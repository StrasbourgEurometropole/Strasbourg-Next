package eu.strasbourg.portlet.help.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ViewSeekerHelpRequestsDisplayContext {



    public ViewSeekerHelpRequestsDisplayContext(RenderRequest request, RenderResponse response,ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector = itemSelector;
    }

    public PublikUser getHelpSeeker() {
        if (_helpSeeker == null) {
            this.getHelpRequests();
        }
        return _helpSeeker;
    }

    public List<HelpRequest> getHelpRequests() {
        if (_helpRequests == null) {
            String helpSeekerId = ParamUtil.getString(_request, "helpSeekerId");
            _helpSeeker = PublikUserLocalServiceUtil.getByPublikUserId(helpSeekerId);
            if (helpSeekerId.equals("")) {
                _helpRequests = new ArrayList<>();
            }
            else {
                List<HelpRequest> unsortedHelpRequests = HelpRequestLocalServiceUtil.getByPublikId(helpSeekerId);
                // Tri par requete la plus recente
                Comparator<HelpRequest> byDate = (c1, c2) -> Long.valueOf(c1.getCreateDate().getTime()).compareTo(c2.getCreateDate().getTime());
                this._helpRequests = ListUtil.sort(unsortedHelpRequests, byDate.reversed());
            }
        }
        return _helpRequests;
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

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    private List<HelpRequest> _helpRequests;
    private PublikUser _helpSeeker;
    private Hits _hits;
    protected SearchContainer<HelpProposal> _searchContainer;
    private String _keywords;
    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;

    private Map<String, String> _categVocabularies;
}
