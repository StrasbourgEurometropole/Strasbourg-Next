package eu.strasbourg.portlet.notif.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class ServicesActionDropdownItemsProvider {

    public ServicesActionDropdownItemsProvider(
            ServiceNotif serviceNotif, RenderRequest request,
            RenderResponse response) {

        _serviceNotif = serviceNotif;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all notifications
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.NOTIF_BO, StrasbourgPortletKeys.NOTIF_BO, "EDIT_SERVICE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.NOTIF_BO, StrasbourgPortletKeys.NOTIF_BO, "DELETE_SERVICE")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasUpdatePermission,
                                                    _getEditActionUnsafeConsumer()
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
                ).build();
    }

    /**
     * Action of Edit Notifservice
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/notif-bo-edit-service.jsp")
                            .setCMD("editService")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "services")
                            .setParameter("serviceId", _serviceNotif.getServiceId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete Notifservice
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteService")
                            .setMVCPath("/notif-bo-view-services.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "services")
                            .setParameter("serviceId", _serviceNotif.getServiceId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final ServiceNotif _serviceNotif;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}