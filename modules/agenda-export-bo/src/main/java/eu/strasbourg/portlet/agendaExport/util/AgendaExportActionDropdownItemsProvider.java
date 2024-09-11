package eu.strasbourg.portlet.agendaExport.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.service.AgendaExportLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author AZC
 */
public class AgendaExportActionDropdownItemsProvider {

    public AgendaExportActionDropdownItemsProvider(
            AgendaExport agendaExport, RenderRequest request,
            RenderResponse response) {

        _agendaExport = agendaExport;
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
                StrasbourgPortletKeys.AGENDA_EXPORT_BO, StrasbourgPortletKeys.AGENDA_EXPORT_BO, "EDIT_AGENDA_EXPORT")
                && canEditAdminContent(_agendaExport.getAgendaExportId())
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.AGENDA_EXPORT_BO, StrasbourgPortletKeys.AGENDA_EXPORT_BO, "DELETE_AGENDA_EXPORT")
                && canEditAdminContent(_agendaExport.getAgendaExportId())
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    _getExportActionUnsafeConsumer()
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
     * Action of Export link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/agenda-export-bo-edit-agenda-export.jsp")
                            .setCMD("exportAgendaExports")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaExports")
                            .setParameter("eventId", _agendaExport.getAgendaExportId())
                            .setParameter("toExport", "true")
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "eu.agenda.export.export"));
        };
    }

    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/agenda-export-bo-edit-agenda-export.jsp")
                            .setCMD("editAgendaExports")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaExports")
                            .setParameter("agendaExportId", _agendaExport.getAgendaExportId())
                            .setParameter("toExport", "false")
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Copy link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getCopyActionUnsafeConsumer(){

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/agenda-export-bo-copy-agenda-export.jsp")
                            .setCMD("copyAgendaExports")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaExports")
                            .setParameter("agendaExportId", _agendaExport.getAgendaExportId())
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
                            .setActionName("deleteAgendaExport")
                            .setMVCPath("/agenda-export-bo-view-agenda-export.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaExports")
                            .setParameter("agendaExportId", _agendaExport.getAgendaExportId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final AgendaExport _agendaExport;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

    public boolean canEditAdminContent(Long agendaExportId) {

        if(agendaExportId == null) {
            return true;
        }

        boolean createdByAdmin = false;
        try {
            AgendaExport agendaExport = AgendaExportLocalServiceUtil.getAgendaExport(agendaExportId);
            if (agendaExport != null) {
                User user = UserServiceUtil.getUserById(agendaExport.getUserId());
                if (user != null) {
                    createdByAdmin = isAdministrator(user);
                }
            }
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        //Si le user qui a créé l'entité est un admin, on doit vérifier que l'utilisateur courant a les droits de modifier cette entité
        //lui aussi est un admin
        if(createdByAdmin) {
            return _themeDisplay.getPermissionChecker().isOmniadmin();
        }

        return true;
    }

    public boolean isAdministrator(User user){
        boolean isAdministrator = false;
        Role adminRole = RoleLocalServiceUtil.fetchRole(_themeDisplay.getCompanyId(), "Administrator");
        isAdministrator = user.getRoles().contains(adminRole);
        return isAdministrator;
    }

}
