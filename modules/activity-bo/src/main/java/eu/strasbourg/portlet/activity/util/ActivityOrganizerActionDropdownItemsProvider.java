package eu.strasbourg.portlet.activity.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AZC
 */
public class ActivityOrganizerActionDropdownItemsProvider {

    public ActivityOrganizerActionDropdownItemsProvider(
            ActivityOrganizer activityOrganizer, RenderRequest request,
            RenderResponse response) {

        _activityOrganizer = activityOrganizer;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all event
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.ACTIVITY_BO, StrasbourgPortletKeys.ACTIVITY_BO, "EDIT_ACTIVITY_ORGANIZER")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasAddPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.ACTIVITY_BO, StrasbourgPortletKeys.ACTIVITY_BO, "ADD_ACTIVITY_ORGANIZER")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.ACTIVITY_BO, StrasbourgPortletKeys.ACTIVITY_BO, "DELETE_ACTIVITY_ORGANIZER")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder

                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasAddPermission,
                                                    _getCopyActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasDeletePermission,
                                                    _getDeleteActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .build();
    }

    /**
     * Action of Copy link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getCopyActionUnsafeConsumer(){

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("editActivityOrganizer")
                            .setMVCPath("/activity-bo-edit-organizer.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "activityOrganizers")
                            .setParameter("activityOrganizerId", _activityOrganizer.getActivityOrganizerId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "duplicate"));
        };
    }

    /**
     * Action of Delete link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteActivityOrganizer")
                            .setMVCPath("/activity-bo-view-organizers.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "activityOrganizers")
                            .setParameter("activityOrganizerId", _activityOrganizer.getActivityOrganizerId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final ActivityOrganizer _activityOrganizer;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
