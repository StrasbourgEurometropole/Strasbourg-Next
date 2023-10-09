package eu.strasbourg.portlet.project.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementSaisineObservatoireToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<Project> {

    public ManagementSaisineObservatoireToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                Project.class, searchContainer);

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * The list of dropdown items to display when a result is checked
     * or the master checkbox in the Management Toolbar is checked
     * Content : publish, unpublish and delete
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return DropdownItemListBuilder
                .addGroup(
                        () -> hasUpdatePermission(),
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder.add(
                                            dropdownItem -> {
                                                dropdownItem.put("href", "javascript:unpublishSelection();");
                                                dropdownItem.setIcon("times");
                                                dropdownItem.setLabel(
                                                        LanguageUtil.get(httpServletRequest, "unpublish"));
                                                dropdownItem.setQuickAction(true);
                                            }
                                    ).build());
                            dropdownGroupItem.setSeparator(true);
                        }
                )
                .addGroup(
                        () -> hasDeletePermission(),
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder.add(
                                            dropdownItem -> {
                                                dropdownItem.put("href", "javascript:deleteSelection();");
                                                dropdownItem.setIcon("trash");
                                                dropdownItem.setLabel(
                                                        LanguageUtil.get(httpServletRequest, "delete"));
                                                dropdownItem.setQuickAction(true);
                                            }
                                    ).build());
                            dropdownGroupItem.setSeparator(true);
                        }
                )
                .build();
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "saisinesObservatoireSearchContainer";
    }

    /**
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] {"modified-date", "title"};
    }



    @Override
    protected boolean hasUpdatePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO, "EDIT_SAISINE_OBSERVATOIRE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
    }

    @Override
    protected boolean hasDeletePermission() {
        return _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO, "DELETE_SAISINE_OBSERVATOIRE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
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
                            "tab", "saisines-observatoire",
                            "cmd", "editSaisineObservatoire",
                            "mvcPath", "/project-bo-edit-saisine-observatoire.jsp",
                            "backURL", themeDisplay.getURLCurrent());

                    dropdownItem.setLabel("Ajouter une saisine");
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
                StrasbourgPortletKeys.PROJECT_BO, StrasbourgPortletKeys.PROJECT_BO, "ADD_SAISINE_OBSERVATOIRE") &&
                group.getStagingGroup() == null){
            return true;
        }
        return false;

    }

    private final ThemeDisplay _themeDisplay;
}