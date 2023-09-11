package eu.strasbourg.portlet.council.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
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
import eu.strasbourg.portlet.council.util.OfficialsActionDropdownItemsProvider;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewOfficialsDisplayContext {



    public ViewOfficialsDisplayContext(RenderRequest request, RenderResponse response) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
    }
    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     */
    @SuppressWarnings("unused")
    public OfficialsActionDropdownItemsProvider getActionsOfficials(Official official) {
        return new OfficialsActionDropdownItemsProvider(official, this._request,
                this._response);
    }
    /**
     * Retourne la liste des élus correspondant à la recherche lancée en ignorant la pagination
     */
    private List<Official> getAllOfficials() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        List<Official> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Official official = OfficialLocalServiceUtil.fetchOfficial(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (official != null)
                    results.add(official);
            }
        }
        return results;
    }
    public SearchContainer<Official> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-officials.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","officials")
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
                        List<Official> results = new ArrayList<Official>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                Official official = OfficialLocalServiceUtil.fetchOfficial(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (official != null)
                                    results.add(official);
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
                -1, -1, Official.class.getName(), groupId,
                getFilterCategoriesIds(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
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
                getSearchContainer().getEnd(), Official.class.getName(), groupId,
                getFilterCategoriesIds(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    public String getOrderByCol() {
        return ParamUtil.getString(this._request, "orderByCol", "full-name");
    }


    public String getOrderByType() {
        return ParamUtil.getString(this._request, "orderByType", "asc");
    }

    /**
     * Surcharge le mappage des champs sur lesquelles trier
     */

    public String getOrderByColSearchField() {
        switch (this.getOrderByCol()) {
            case "full-name":
                return "localized_title_fr_FR_sortable";
            default:
                return "modified_sortable";
        }
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


    private Hits _hits;
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;

    protected SearchContainer<Official> _searchContainer;

    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;
    private List<Official> officials;
    private List<String[]> _categVocabularies;
    public static final String CATEGORY_ACTIVE = "Actif";
    public static final String CATEGORY_INACTIVE = "Inactif";
    private String _keywords;
    protected List<Long[]> _filterCategoriesIds;
}
