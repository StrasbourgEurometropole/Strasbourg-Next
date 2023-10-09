package eu.strasbourg.portlet.help.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.util.ProposalHelpRequestActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;

public class ViewProposalHelpRequestsDisplayContext extends ViewBaseDisplayContext<HelpRequest> {


    public ViewProposalHelpRequestsDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, HelpRequest.class);
            _request = request;
            _response = response;
            _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        }

    /**
     * Retourne le dropdownItemsProvider
     *
     */
    @SuppressWarnings("unused")
    public ProposalHelpRequestActionDropdownItemsProvider getActionsProposalHelpRequest(HelpRequest helpRequest) {
        return new ProposalHelpRequestActionDropdownItemsProvider(helpRequest, _request,
                _response);
    }

    public HelpProposal getHelpProposal() throws PortalException {
        long helpProposalId = ParamUtil.getLong(_request, "helpProposalId");
        if (_helpProposal == null && helpProposalId > 0) {
            _helpProposal = HelpProposalLocalServiceUtil.getHelpProposal(helpProposalId);
        }
        return _helpProposal;
    }

    /**
     * Retourne le searchContainer des help proposals
     *
     */
    @Override
    public SearchContainer<HelpRequest> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/help-bo-view-help-requests.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","viewProposalHelpRequests")
                    .setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            try {
                getHits();
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(
                    () -> {
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
        if (this._helpRequests == null) {
            List unsortedRequests = HelpRequestLocalServiceUtil.getByHelpProposalId(getHelpProposal().getHelpProposalId());

            Comparator<HelpRequest> byDate = new Comparator<HelpRequest>() {
                @Override
                public int compare(HelpRequest c1, HelpRequest c2) {
                    return Long.valueOf(c1.getCreateDate().getTime()).compareTo(c2.getCreateDate().getTime());
                }
            };
            this._helpRequests = ListUtil.sort(unsortedRequests, byDate.reversed());

        }
    }

    @SuppressWarnings("unused")
    public String getCurrentUrl() {
        return PortalUtil.getCurrentURL(this._request);
    }

    protected SearchContainer<HelpRequest> _searchContainer;

    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private HelpProposal _helpProposal;
    private List <HelpRequest> _helpRequests;
}