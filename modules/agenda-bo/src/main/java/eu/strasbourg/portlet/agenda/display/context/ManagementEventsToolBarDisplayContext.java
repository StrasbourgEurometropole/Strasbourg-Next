package eu.strasbourg.portlet.agenda.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;

public class ManagementEventsToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<Event> {

    public ManagementEventsToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                Event.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    @Override
    protected boolean hasUpdatePermission() {
        return !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
                _themeDisplay.getCompanyId(), _themeDisplay.getScopeGroupId(),
                Event.class.getName())
                && _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getCompanyGroupId(),
                StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO, "EDIT_EVENT")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    @Override
    protected boolean hasDeletePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getCompanyGroupId(),
                StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO, "DELETE_EVENT")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "eventsSearchContainer";
    }



    /**
     * creates an add menu button
     */
    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    ThemeDisplay themeDisplay =
                            (ThemeDisplay)httpServletRequest.getAttribute(
                                    WebKeys.THEME_DISPLAY);

                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "tab", "events",
                            "cmd", "editEvent",
                            "mvcPath", "/agenda-bo-edit-event.jsp",
                            "backURL", themeDisplay.getURLCurrent());

                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add"));
                }
        ).build();
    }

    /**
     * Add menu visibility
     */
    @Override
    public Boolean isShowCreationMenu() {
        ThemeDisplay themeDisplay =
                (ThemeDisplay)httpServletRequest.getAttribute(
                        WebKeys.THEME_DISPLAY);

        Group group = themeDisplay.getScopeGroup();
        if(_themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.AGENDA_BO, StrasbourgPortletKeys.AGENDA_BO, "ADD_EVENT") &&
                group.getStagingGroup() == null){
            return true;
        }
        return false;

    }

    private final ThemeDisplay _themeDisplay;
}