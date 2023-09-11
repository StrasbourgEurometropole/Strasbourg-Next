package eu.strasbourg.portlet.council.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.council.constants.CouncilConstants;
import eu.strasbourg.portlet.council.util.DeliberationsActionDropdownItemsProvider;
import eu.strasbourg.service.council.constants.StageDeliberation;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.service.DeliberationLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewDeliberationsDisplayContext {

    private List<Deliberation> deliberations;
    private String sessionCategoryToAdd;

    public ViewDeliberationsDisplayContext(RenderRequest request, RenderResponse response, String categoryToAdd) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        this.sessionCategoryToAdd=categoryToAdd;
        // Hack : forçage du delta du SearchContainer
        // TODO : Changer le ViewListBaseDisplayContext pour mettre en place la prise en compte du delta par default
        this.getSearchContainer().setDelta(100);

    }

    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     */
    @SuppressWarnings("unused")
    public DeliberationsActionDropdownItemsProvider getActionsDeliberations(Deliberation deliberation) {
        return new DeliberationsActionDropdownItemsProvider(deliberation, this._request,
                this._response);
    }

    /**
     * Retourne la liste des délibérations correspondant à la recherche lancée en ignorant la pagination
     */
    private List<Deliberation> getAllDeliberations() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        List<Deliberation> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Deliberation deliberation = DeliberationLocalServiceUtil
                        .fetchDeliberation(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (deliberation != null) {
                    results.add(deliberation);
                }
            }
        }
        return results;
    }
    /**
     * Retourne tous les Hits de recherche
     */
    private Hits getAllHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil
                .getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory
                .getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");

        return SearchHelper.getBOSearchHits(searchContext,
                -1, -1,Deliberation.class.getName(), groupId,
                getFilterCategoriesIds(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    /**
     * Retourne la liste des PK de toutes les délibérations
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllDeliberationIds() throws PortalException {
        StringBuilder deliberationsIds = new StringBuilder();
        for (Deliberation deliberation : this.getAllDeliberations()) {
            if (deliberationsIds.length() > 0) {
                deliberationsIds.append(",");
            }
            deliberationsIds.append(deliberation.getDeliberationId());
        }
        return deliberationsIds.toString();
    }
    /**
     * Retourne le searchContainer des Deliberations
     *
     */
    public SearchContainer<Deliberation> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-deliberations.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","deliberations")
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");
            _searchContainer.setOrderByCol(getOrderByCol());
            _searchContainer.setOrderByType(getOrderByType());
            try {
                getHits(this._themeDisplay.getScopeGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<Deliberation> results = new ArrayList<Deliberation>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                Deliberation deliberation = DeliberationLocalServiceUtil.fetchDeliberation(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (deliberation != null) {
                                    results.add(deliberation);
                                }
                            }
                        }
                        return results;
                    }, _hits.getLength()
            );
        }
        _searchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_response));

        return _searchContainer;
    }
    public String getOrderByColSearchField() {
        switch (this.getOrderByCol()) {
            case "title":
            case "alias":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
                return "modified_sortable";
            case "publication-date":
                return "publishDate_sortable";
            case "status":
                return "status_sortable";
            case "order":
                return "order_sortable";
            default:
                return "modified_sortable";
        }
    }

    public String getOrderByCol() {
        return ParamUtil.getString(this._request, "orderByCol",
                "order");
    }

    public String getOrderByType() {
        return ParamUtil.getString(this._request, "orderByType", "asc");
    }


    /**
     * Retourne les Hits de recherche pour un delta
     */
    private void getHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil
                .getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory
                .getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");
        _hits = SearchHelper.getBOSearchHits(searchContext,
                getSearchContainer().getStart(),
                getSearchContainer().getEnd(), Deliberation.class.getName(), groupId,
                getFilterCategoriesIds(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }


        @SuppressWarnings("unused")
    public String getStageDeliberationName(long id) {
        return StageDeliberation.get(id).getName();
    }

    /**
     * Class CSS de la couleur du Statut
     */
    @SuppressWarnings("unused")
    public String getCSSClass(Deliberation deliberation) {
        String cssClass="";
        if(deliberation.isAdopte()) {
            cssClass="green";
        } else if (deliberation.isRejete()) {
            cssClass="red";
        } else if (deliberation.isAffichageEnCours() || deliberation.isVoteOuvert()) {
            cssClass="focus-stage";
        }

        return cssClass;
    }

    /**
     * Récupère et ajoute à la liste la categorie correspondant à aucun conseil sélectionné
     */
    private void addCategorieAucunConseilSelectionne(ThemeDisplay themeDisplay, List<AssetCategory> authorizedRootCategories) {

        long groupId = themeDisplay.getScopeGroupId();
        AssetCategory categoryAucunConseil = AssetVocabularyHelper.getCategory(CouncilConstants.NO_COUNCIL_CATEGORY_NAME, groupId);
        authorizedRootCategories.add(categoryAucunConseil);
    }
    /**
     * Retourne les mots clés de recherche saisis
     */
    @SuppressWarnings("unused")
    public String getKeywords() {
        if (Validator.isNull(_keywords)) {
            _keywords = ParamUtil.getString(_request, "keywords");
        }
        return _keywords;
    }
    public boolean hasVocabulary(String vocabularyName){
        return getFilterCategoriesIdByVocabulariesName().contains(vocabularyName+"_");
    }

    /**
     * Retourne la liste des IDs des catégories sur lesquels on doit filtrer
     *  chaque entrée de liste contient un tableau de String :
     * [vocabularyName, categoryName, categoryId]
     */
    public List<String[]> getCategVocabularies() {
        if (_categVocabularies == null) {
            _categVocabularies = new ArrayList<>();
            List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
                    .split("__"));
            for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
                if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
                    _categVocabularies.add(filterCategoryIdByVocabularyName.split("_"));
                }
            }
        }

        return _categVocabularies;
    }

    /**
     * Retourne un String des IDs des catégories sur lesquels on doit filtrer
     *  sous forme de string qui se présente comme suit :
     * "vocabularyName_categoryName_categoryId__..."
     */
    public String getFilterCategoriesIdByVocabulariesName() {
        return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
    }

    /**
     * Renvoie la liste des catégories sur lesquelles on souhaite filtrer les
     * entries. L'opérateur entre chaque id de catégorie d'un array est un "OU", celui entre chaque liste d'array est un "ET"
     */
    private List<Long[]> getFilterCategoriesIds() {
        if (_filterCategoriesIds == null) {
            List<Long[]> filterCategoriesIds = new ArrayList<Long[]>();

            // récupère les catégories triées par nom de vocabulaire
            List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
                    .split("__")).stream().sorted().collect(Collectors.toList());
            if(!filterCategoriesIdByVocabulariesName.isEmpty()) {
                String oldVocabularyName = "";
                String categoriesIds = "";
                for (String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName) {
                    if (Validator.isNotNull(filterCategoryIdByVocabularyName)) {
                        String vocabularyName = filterCategoryIdByVocabularyName.split("_")[0];
                        String categoryId = filterCategoryIdByVocabularyName.split("_")[2];
                        if (oldVocabularyName.equals("") || oldVocabularyName.equals(vocabularyName)) {
                            if (Validator.isNotNull(categoriesIds)) {
                                categoriesIds += ",";
                            }
                            categoriesIds += categoryId;
                            oldVocabularyName = vocabularyName;
                        } else {
                            Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
                            filterCategoriesIds.add(categoriesIdsOr);
                            oldVocabularyName = vocabularyName;
                            categoriesIds = categoryId;
                        }
                    }
                }
                Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
                filterCategoriesIds.add(categoriesIdsOr);
            }
            this._filterCategoriesIds = filterCategoriesIds;
        }
        return this._filterCategoriesIds;
    }

    /**
     * Retourne la liste des IDs des catégories d'un vocabulaire, sur lequel on doit filtrer
     *  sous forme de string qui se présente comme suit :
     * "categoryId1,categoryId2,categoryId3,"
     */
    public String getFilterCategoriesIdsByVocabularyName(String vocabularyName) {
        List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
                .split("__"));
        String filterCategoriesIdsByVocabulary = "";
        for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
            if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
                String[] arrayCategoryIdByVocabularyName = filterCategoryIdByVocabularyName.split("_");
                if(arrayCategoryIdByVocabularyName[0].equals(vocabularyName))
                    filterCategoriesIdsByVocabulary += arrayCategoryIdByVocabularyName[2] + ",";
            }
        }
        return filterCategoriesIdsByVocabulary;
    }


    private final Log _log = LogFactoryUtil.getLog(this.getClass());
    private Hits _hits;
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    protected SearchContainer<Deliberation> _searchContainer;

    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;
    private String _keywords;
    private List<String[]> _categVocabularies;
    protected List<Long[]> _filterCategoriesIds;
}
