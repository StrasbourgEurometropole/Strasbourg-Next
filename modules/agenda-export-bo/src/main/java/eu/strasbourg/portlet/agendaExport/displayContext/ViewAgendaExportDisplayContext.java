package eu.strasbourg.portlet.agendaExport.displayContext;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agendaExport.util.AgendaExportActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewAgendaExportDisplayContext extends ViewBaseDisplayContext<AgendaExport> {

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    private List<AgendaExport> _agendaExports;

    public ViewAgendaExportDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, AgendaExport.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     * @return XXXActionDropdownItemsProvider
     */
    @SuppressWarnings("unused")
    public AgendaExportActionDropdownItemsProvider getActionAgendaExport(AgendaExport agendaExport) {
        return new AgendaExportActionDropdownItemsProvider(agendaExport, this._request,
                this._response);
    }

    /**
     * Retourne le searchContainer des events
     *
     * @return SearchContainer<Event>
     */
    @Override
    public SearchContainer<AgendaExport> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/agenda-export-bo-view-agenda-export.jsp")
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
            Hits hits;
            try {
                hits = getHits(_themeDisplay.getCompanyGroupId());
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        List<AgendaExport> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                AgendaExport agendaExport = AgendaExportLocalServiceUtil
                                        .fetchAgendaExport(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (agendaExport != null) {
                                    results.add(agendaExport);
                                }
                            }
                        }

                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_response));

        return _searchContainer;
    }

    protected SearchContainer<AgendaExport> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
}
