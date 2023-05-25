package eu.strasbourg.portlet.form_send.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.form_send.util.FormActionDropdownItemsProvider;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewFormDisplayContext{

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());



    public ViewFormDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector=itemSelector;

    }


    private List<DDMFormInstance> populateForms(Hits hits) {
        List<DDMFormInstance> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                DDMFormInstance form = DDMFormInstanceLocalServiceUtil.fetchFormInstance(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (form != null) {
                    results.add(form);
                }
            }
        }
        return results;
    }
    /**
     * Retourne le searchContainer
     *
     */
    public SearchContainer<DDMFormInstance> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/form-send-bo-view-forms.jsp")
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
                        List<DDMFormInstance> results = new ArrayList<>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                DDMFormInstance form = DDMFormInstanceLocalServiceUtil.
                                        fetchDDMFormInstance(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (form!= null)
                                    results.add(form);
                            }
                        }

                        return results;
                    }, _hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }
    /**
     * Retourne le dropdownItemsProvider de Form
     *
     * @return officialActionDropdownItemsProvider
     */
    @SuppressWarnings("unused")
    public FormActionDropdownItemsProvider getActionsForm(DDMFormInstance ddmForm) {
        return new FormActionDropdownItemsProvider(ddmForm, _request,
                _response);
    }

    private void getHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");
        _hits = SearchHelper.getBOSearchHits(searchContext,
                getSearchContainer().getStart(),
                getSearchContainer().getEnd(), DDMFormInstance.class.getName(), groupId,
                "", keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "title":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
            default:
                return "modified_sortable";
        }
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
        categoryTreeNodeItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                new AssetCategoryTreeNodeItemSelectorReturnType());

        return String.valueOf(
                _itemSelector.getItemSelectorURL(
                        requestBackedPortletURLFactory,
                        _response.getNamespace() + "selectAssetCategory",
                        categoryTreeNodeItemSelectorCriterion));
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
    private Hits _hits;
    protected SearchContainer<DDMFormInstance> _searchContainer;
    private Map<String, String> _categVocabularies;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;

    private List<DDMFormInstance> _forms;
}
