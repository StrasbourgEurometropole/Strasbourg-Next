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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.place.model.PublicHoliday;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementPublicHolidayToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<PublicHoliday> {

    public ManagementPublicHolidayToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                PublicHoliday.class, searchContainer);


        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * on ne veut pas d'options de sélection
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return null;
    }

    /**
     * on ne veut ni filtre ni tri
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return null;
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
                            "tab", "publicHolidays",
                            "cmd", "editPublicHoliday",
                            "mvcPath", "/place-bo-edit-public-holiday.jsp",
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

    // Masquer la zone de recherche
    @Override
    public Boolean isShowSearch() {
        return false;
    }

    // Masquer la case à cocher "Select All"
    @Override
    public Boolean isSelectable() {
        return false;
    }

    private final ThemeDisplay _themeDisplay;


}