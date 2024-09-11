package eu.strasbourg.portlet.notif.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementServicesToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<ServiceNotif> {

    public ManagementServicesToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                ServiceNotif.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * on ne veut ni filtre ni tri
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return null;
    }
    @Override
    public Boolean isShowSearch() {
        return false;
    }



    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "linksSearchContainer";
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
                            "tab", "services",
                            "cmd", "editService",
                            "mvcPath", "/notif-bo-edit-service.jsp",
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
                StrasbourgPortletKeys.NOTIF_BO, StrasbourgPortletKeys.NOTIF_BO, "ADD_SERVICE") &&
                group.getStagingGroup() == null){
            return true;
        }
        return false;

    }

    @Override
    public Boolean isSelectable() {
        return false;
    }

    private final ThemeDisplay _themeDisplay;
}