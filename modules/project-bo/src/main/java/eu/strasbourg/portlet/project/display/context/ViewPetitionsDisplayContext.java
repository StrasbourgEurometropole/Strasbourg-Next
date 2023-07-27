package eu.strasbourg.portlet.project.display.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.project.util.PetitionActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.service.PetitionLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author alexandre.quere
 */
public class ViewPetitionsDisplayContext {

    public ViewPetitionsDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector = itemSelector;
    }
    /**
     * Retourne le dropdownItemsProvider de petition
     *
     */
    @SuppressWarnings("unused")
    public PetitionActionDropdownItemsProvider getActionsPetition(Petition petition) {
        return new PetitionActionDropdownItemsProvider(petition, _request,
                _response);
    }
    /**
     * Retourne le searchContainer des petitions
     *
     */
    public SearchContainer<Petition> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/project-bo-view-petitions.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","petitions")
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
                        List<Petition> results = new ArrayList<>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                Petition petition = PetitionLocalServiceUtil.fetchPetition(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (petition != null) {
                                    results.add(petition);
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
                getSearchContainer().getEnd(), Petition.class.getName(), groupId,
                "", keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }
    /**
     * Renvoie le nom du champ sur laquelle on fait le tri pour ElasticSearch
	 *
	 */
    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "title":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
            default:
                return "modified_sortable";
        }
    }
    /**
     * Renvoie la colonne sur laquelle on fait le tri
     *
     * @return String
     */
    public String getOrderByCol() {
        return ParamUtil.getString(_request, "orderByCol", "modified-date");
    }

    /**
     * Retourne le type de tri (desc ou asc)
     *
     * @return String
     */
    public String getOrderByType() {
        return ParamUtil.getString(_request, "orderByType", "desc");
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
        return getCategVocabularies().containsKey(vocabularyName);
    }

    public Map<String, String> getCategVocabularies() {
        if (_categVocabularies == null) {
            _categVocabularies = new HashMap<>();
            _categVocabularies.put("vocabulary1", ParamUtil.getString(
                    _httpServletRequest, "vocabulary1", ""));
        }

        return _categVocabularies;
    }

    @SuppressWarnings("unused")
    public String getSelectCategoriesByVocabularyIdURL(long vocabularyId) {
        RequestBackedPortletURLFactory requestBackedPortletURLFactory =
                RequestBackedPortletURLFactoryUtil.create(_request);
        AssetCategoryTreeNodeItemSelectorCriterion categoryTreeNodeItemSelectorCriterion =
                new AssetCategoryTreeNodeItemSelectorCriterion();
//		categoryTreeNodeItemSelectorCriterion.setClassNameId(
//				PortalUtil.getClassNameId(JournalArticle.class));
        categoryTreeNodeItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new AssetCategoryTreeNodeItemSelectorReturnType());

        return String.valueOf(
                _itemSelector.getItemSelectorURL(
                        requestBackedPortletURLFactory,
                        _response.getNamespace() + "selectAssetCategory",
                        categoryTreeNodeItemSelectorCriterion));
    }

    private List<Petition> createObjectList(Hits hits) {
        // Création de la liste d'objet
        List<Petition> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Petition petition = PetitionLocalServiceUtil.fetchPetition(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (petition != null) {
                    results.add(petition);
                }
            }
        }
        return results;
    }


    /**
     * Retourne la liste des pétitions correspondante à la recherche lancée en ignorant la pagination
     */
    private List<Petition> getAllPetitions() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        // Création de la liste d'objet
        return createObjectList(hits);
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
                -1, -1, Petition.class.getName(), groupId,
                "", keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    /**
     * Retourne la liste des PK de toutes les pétitions
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllPetitionIds() throws PortalException {
        StringBuilder petitionIds = new StringBuilder();
        for (Petition petition : this.getAllPetitions()) {
            if (petitionIds.length() > 0) {
                petitionIds.append(",");
            }
            petitionIds.append(petition.getPetitionId());
        }
        return petitionIds.toString();
    }

    private Hits _hits;
    protected SearchContainer<Petition> _searchContainer;
    private Map<String, String> _categVocabularies;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;
}
