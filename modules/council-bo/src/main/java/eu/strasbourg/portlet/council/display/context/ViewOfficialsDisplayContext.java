package eu.strasbourg.portlet.council.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.council.util.OfficialsActionDropdownItemsProvider;
import eu.strasbourg.portlet.council.util.TypesActionDropdownItemsProvider;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.OfficialLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewOfficialsDisplayContext {



    public ViewOfficialsDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector = itemSelector;
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
                "", keywords,
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
                "", keywords,
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
     * Retourne la liste des IDs des catégories sur lesquels on doit filtrer les
     * éditions Liste sous forme de string qui se présente comme suit :
     * ",categoryId1,categoryId2,categoryId3," Si le paramètre
     * "vocabularyToRemove" est présent, on enlève les catégories appartenant à
     * ce vocabulaire de la liste Si le paramètre "categoryToAdd" est présent,
     * on ajoute ladite catégorie à la liste
     *
     */
   /* public String getFilterCategoriesIds() throws PortalException {
        if (Validator.isNotNull(_filterCategoriesIds)) {
            return _filterCategoriesIds;
        }
        _filterCategoriesIds = ParamUtil.getString(_request,
                "filterCategoriesIds");
        if (_filterCategoriesIds.length() == 0) {
            _filterCategoriesIds = ",";
        }
        Long vocabularyToRemove = ParamUtil.getLong(_request,
                "vocabularyToRemove");
        if (vocabularyToRemove > 0) {
            AssetVocabulary vocabulary = AssetVocabularyLocalServiceUtil
                    .getVocabulary(vocabularyToRemove);
            List<AssetCategory> categories = vocabulary.getCategories();
            for (AssetCategory category : categories) {
                if (_filterCategoriesIds
                        .contains(String.valueOf(category.getCategoryId()))) {
                    _filterCategoriesIds = _filterCategoriesIds
                            .replace("," + category.getCategoryId(), "");
                }
            }
            _filterCategoriesIds = _filterCategoriesIds
                    .replace(vocabularyToRemove + ",", "");
        }

        AssetCategory catInactive = AssetVocabularyHelper.getCategory(CATEGORY_INACTIVE, this._themeDisplay.getScopeGroupId());
        AssetCategory catActive = AssetVocabularyHelper.getCategory(CATEGORY_ACTIVE, this._themeDisplay.getScopeGroupId());
        String categoryToAdd ="";
        // Si FilterCategorie contient déjà l'une des catégories d'activité, on cherche categoryToAdd normalement
        // (Ca empêche de flood filterCategorie avec l'id de "Actif)
        if((catActive != null && _filterCategoriesIds.contains(String.valueOf(catActive.getCategoryId())))
            ||
            (catInactive != null &&    _filterCategoriesIds.contains(String.valueOf(catInactive.getCategoryId()))) ) {
            categoryToAdd = ParamUtil.getString(this._request, "categoryToAdd");
        } else {
            categoryToAdd = ParamUtil.getString(
                    this._request, "categoryToAdd", catActive != null ? Long.toString(catActive.getCategoryId()) : "");
        }

        if (Validator.isNotNull(categoryToAdd)) {
            _filterCategoriesIds += categoryToAdd + ",";
        }
        return _filterCategoriesIds;
    }

    public List<ManagementBarFilterItem> getManagementBarFilterItems(
            AssetVocabulary vocabulary) throws PortalException {
        List<ManagementBarFilterItem> managementBarFilterItems = new ArrayList<>();

        String tab = ParamUtil.getString(this._request, "tab");
        String orderByCol = this.getOrderByCol();
        String orderByType = this.getOrderByType();
        String filterCategoriesIds = this.getFilterCategoriesIds();
        String keywords = this.getKeywords();
        ThemeDisplay themeDisplay = (ThemeDisplay) this._request
                .getAttribute(WebKeys.THEME_DISPLAY);
        String portletName = (String) this._request
                .getAttribute(WebKeys.PORTLET_ID);
        PortletURL filterURL = PortletURLFactoryUtil.create(this._request,
                portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        int delta = this.getSearchContainer().getDelta();
        long vocabularyToRemove = vocabulary.getVocabularyId();
        filterURL.setParameter("tab", tab);
        filterURL.setParameter("orderByCol", orderByCol);
        filterURL.setParameter("orderByType", orderByType);
        filterURL.setParameter("filterCategoriesIds", filterCategoriesIds);
        filterURL.setParameter("keywords", keywords);
        filterURL.setParameter("delta", String.valueOf(delta));
        filterURL.setParameter("vocabularyToRemove",
                String.valueOf(vocabularyToRemove));

        ManagementBarFilterItem allItemsFilter = new ManagementBarFilterItem(
                false, vocabulary.getName() + " : "
                + LanguageUtil.get(Locale.FRENCH, "any"),
                filterURL.toString());
        managementBarFilterItems.add(allItemsFilter);

        List<AssetCategory> rootCategories = vocabulary.getCategories().stream()
                .filter(c -> c.isRootCategory()).collect(Collectors.toList());

        AssetVocabulary conseilVocab = AssetVocabularyHelper.getVocabulary(VocabularyNames.COUNCIL_SESSION, themeDisplay.getScopeGroupId());
        if(conseilVocab != null && conseilVocab.getVocabularyId() == vocabulary.getVocabularyId()) {
            List<AssetCategory> authorizedRootCategories = new ArrayList<>();
            for (AssetCategory typeCouncilCat : UserRoleType.typeCategoriesForUser(themeDisplay)) {
                if(rootCategories.contains(typeCouncilCat)) {
                    authorizedRootCategories.add(typeCouncilCat);
                }
            }
            for (AssetCategory category : authorizedRootCategories) {
                populateManagementBar(managementBarFilterItems, category,
                        filterURL);
            }
        } else {
            for (AssetCategory category : rootCategories) {
                populateManagementBar(managementBarFilterItems, category,
                        filterURL);
            }
        }

        return managementBarFilterItems;
    }

    @Override
    protected List<ManagementBarFilterItem> populateManagementBar(
            List<ManagementBarFilterItem> managementBarFilterItems,
            AssetCategory category, PortletURL filterURL) throws PortalException {

        ManagementBarFilterItem managementBarFilterItem = getCategoryBarFilterItem(
                category, filterURL);
        managementBarFilterItems.add(managementBarFilterItem);

        // On a supprimé la recherche des enfants de catégories pour ne garder que les premières catégories parentes
        // Ainsi on a que les catégories de Type de conseil pour le filtre par Conseil

        return managementBarFilterItems;
    }*/
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

    private Hits _hits;
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;

    protected SearchContainer<Official> _searchContainer;

    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;
    private List<Official> officials;

    public static final String CATEGORY_ACTIVE = "Actif";
    public static final String CATEGORY_INACTIVE = "Inactif";
    private String _keywords;
}
