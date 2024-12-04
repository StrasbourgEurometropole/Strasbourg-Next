package eu.strasbourg.portlet.form_send.context;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewFormDisplayContext extends ViewBaseDisplayContext<DDMFormInstance> {

    public ViewFormDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, DDMFormInstance.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);

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
    @Override
    public SearchContainer<DDMFormInstance> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/form-send-bo-view-forms.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");
            _searchContainer.setOrderByCol(getOrderByCol());
            _searchContainer.setOrderByType(getOrderByType());
            Hits hits;
            try {
                hits = getHits(this._themeDisplay.getScopeGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<DDMFormInstance> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                DDMFormInstance form = DDMFormInstanceLocalServiceUtil.
                                        fetchDDMFormInstance(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (form!= null)
                                    results.add(form);
                            }
                        }

                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }

    @Override
    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "modified-date":
            default:
                return "modified_sortable";
        }
    }

    protected SearchContainer<DDMFormInstance> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
}
