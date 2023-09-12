package eu.strasbourg.portlet.help.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.util.SeekerHelpRequestActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ViewSeekerHelpRequestsDisplayContext {

    public ViewSeekerHelpRequestsDisplayContext(RenderRequest request, RenderResponse response) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
    }

    @SuppressWarnings("unused")
        public SeekerHelpRequestActionDropdownItemsProvider getActionsSeekerHelpRequest(HelpRequest helpRequest) {
        return new SeekerHelpRequestActionDropdownItemsProvider(helpRequest, _request,
                _response);
    }

    public PublikUser getHelpSeeker() {
        if (_helpSeeker == null) {
            this.getSearchContainer();
        }
        return _helpSeeker;
    }

    /**
     * Retourne le searchContainer des help seekers
     *
     */
    public SearchContainer<HelpRequest> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/help-bo-view-seeker-help-requests.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setTabs1("helpSeekers")
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","viewProposalHelpRequests")
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
                getHits();
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
                        // Création de la liste d'objet
                        int start = this._searchContainer.getStart();
                        int end = this._searchContainer.getEnd();
                        int total = this._searchContainer.getTotal();
                        _helpRequests = _helpRequests.subList(start, end > total ? total : end);
                        return _helpRequests;
                    }, _helpRequests.size()
            );
        }
        _searchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_response));

        return _searchContainer;
    }

    /**
     * Retourne les Hits de recherche pour un delta
     */
    private void getHits() throws PortalException {
        if (_helpRequests == null) {
            String helpSeekerId = ParamUtil.getString(_request, "helpSeekerId");
            _helpSeeker = PublikUserLocalServiceUtil.getByPublikUserId(helpSeekerId);
            if (helpSeekerId.equals("")) {
                _helpRequests = new ArrayList<>();
            } else {
                List<HelpRequest> unsortedHelpRequests = HelpRequestLocalServiceUtil.getByPublikId(helpSeekerId);
                // Tri par requete la plus recente
                Comparator<HelpRequest> byDate = (c1, c2) -> Long.valueOf(c1.getCreateDate().getTime()).compareTo(c2.getCreateDate().getTime());
                this._helpRequests = ListUtil.sort(unsortedHelpRequests, byDate.reversed());
            }


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

    public String getCurrentUrl() {
        return PortalUtil.getCurrentURL(this._request);
    }


    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    private List<HelpRequest> _helpRequests;
    private PublikUser _helpSeeker;
    protected SearchContainer<HelpRequest> _searchContainer;

    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;

}
