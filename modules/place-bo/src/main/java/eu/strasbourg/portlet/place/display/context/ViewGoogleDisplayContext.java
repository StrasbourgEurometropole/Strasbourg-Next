package eu.strasbourg.portlet.place.display.context;

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
import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;
import eu.strasbourg.service.place.service.GoogleMyBusinessHistoricLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewGoogleDisplayContext extends ViewBaseDisplayContext<GoogleMyBusinessHistoric> {



    public ViewGoogleDisplayContext(RenderRequest request,
                                    RenderResponse response) {
        super(request, response, GoogleMyBusinessHistoric.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
    }

    @Override
    public SearchContainer<GoogleMyBusinessHistoric> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/place-bo-view-google.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","google")
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");
            Hits hits;
            try {
                hits = getHits(this._themeDisplay.getCompanyGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<GoogleMyBusinessHistoric> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                GoogleMyBusinessHistoric googleMyBusinessHistoric = GoogleMyBusinessHistoricLocalServiceUtil.fetchGoogleMyBusinessHistoric(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (googleMyBusinessHistoric != null) {
                                    results.add(googleMyBusinessHistoric);
                                }
                            }
                        }
                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }

    public String getOrderByColSearchField() {

        return "modified_sortable";
    }

    /**
     * @return True si on peut faire la synchronisation
     */
    @SuppressWarnings("unused")
    public boolean canSynchronise() {
        return Boolean.parseBoolean(StrasbourgPropsUtil.getGMBActivated());
    }

    protected SearchContainer<GoogleMyBusinessHistoric> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;

    protected ThemeDisplay _themeDisplay;
}

