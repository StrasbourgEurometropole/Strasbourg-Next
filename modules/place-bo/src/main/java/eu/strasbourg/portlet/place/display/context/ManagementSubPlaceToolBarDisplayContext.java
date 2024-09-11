package eu.strasbourg.portlet.place.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
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
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementSubPlaceToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<SubPlace> {

    public ManagementSubPlaceToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                SubPlace.class, searchContainer);


        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    @Override
    protected boolean hasUpdatePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getCompanyGroupId(),
                StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO, "EDIT_PLACE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    @Override
    protected boolean hasDeletePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getCompanyGroupId(),
                StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO, "DELETE_PLACE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    /**
     * on ne veut ni filtre ni tri
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return null;
    }

    // Masquer la zone de recherche
    @Override
    public Boolean isShowSearch() {
        return false;
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
                            "tab", "subPlaces",
                            "cmd", "editSubPlace",
                            "mvcPath", "/place-bo-edit-subplace.jsp",
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
        if(group.getStagingGroup() == null){
            return true;
        }
        return false;

    }
    @Override
    public String getSearchContainerId() {
        return "subPlacesSearchContainer";
    }

    private final ThemeDisplay _themeDisplay;
}