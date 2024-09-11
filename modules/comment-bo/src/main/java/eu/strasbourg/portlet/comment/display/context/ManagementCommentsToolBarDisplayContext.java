package eu.strasbourg.portlet.comment.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;

public class ManagementCommentsToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<Comment> {

    public ManagementCommentsToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                Comment.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    @Override
    protected boolean hasUpdatePermission() {
        return !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
                _themeDisplay.getCompanyId(), _themeDisplay.getScopeGroupId(),
                Comment.class.getName())
                && _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COMMENT_BO, StrasbourgPortletKeys.COMMENT_BO, "EDIT_COMMENT")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    @Override
    protected boolean hasDeletePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COMMENT_BO, StrasbourgPortletKeys.COMMENT_BO, "DELETE_COMMENT")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "commentsSearchContainer";
    }

    /**
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "entityName","entityType","modified-date","userName", "reportings","title" , "status" };
    }

    private final ThemeDisplay _themeDisplay;

}