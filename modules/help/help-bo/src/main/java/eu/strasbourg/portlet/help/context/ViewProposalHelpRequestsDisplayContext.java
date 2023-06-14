package eu.strasbourg.portlet.help.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ViewProposalHelpRequestsDisplayContext{


    public ViewProposalHelpRequestsDisplayContext(RenderRequest request, RenderResponse response
       , ItemSelector itemSelector) {
            _request = request;
            _response = response;
            _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
            _httpServletRequest = PortalUtil.getHttpServletRequest(request);
            _itemSelector = itemSelector;
        }


    public HelpProposal getHelpProposal() throws PortalException {
        long helpProposalId = ParamUtil.getLong(_request, "helpProposalId");
        if (_helpProposal == null && helpProposalId > 0) {
            _helpProposal = HelpProposalLocalServiceUtil.getHelpProposal(helpProposalId);
        }
        return _helpProposal;
    }

    public List<HelpRequest> getHelpRequests() throws PortalException {
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
        return this._helpRequests;
    }

    public String getCurrentUrl() {
        return PortalUtil.getCurrentURL(this._request);
    }

    /**
     * Wrapper autour du permission checker pour les permissions de module
     */
    public boolean hasPermission(String actionId) throws PortalException {
        return _themeDisplay.getPermissionChecker().hasPermission(
                this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO,
                actionId);
    }
    private Hits _hits;
    protected SearchContainer<HelpProposal> _searchContainer;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;

    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;

    private Map<String, String> _categVocabularies;
    private HelpProposal _helpProposal;
    private List <HelpRequest> _helpRequests;

}