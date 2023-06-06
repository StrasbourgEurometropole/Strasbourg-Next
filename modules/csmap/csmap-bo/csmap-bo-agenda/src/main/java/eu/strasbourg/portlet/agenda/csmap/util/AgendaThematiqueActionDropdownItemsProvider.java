package eu.strasbourg.portlet.agenda.csmap.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.csmap.model.Agenda;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class AgendaThematiqueActionDropdownItemsProvider {

    public AgendaThematiqueActionDropdownItemsProvider(
            Agenda agenda, RenderRequest request,
            RenderResponse response) {

        _agenda = agenda;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all arret
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.CSMAP_BO_AGENDA, StrasbourgPortletKeys.CSMAP_BO_AGENDA, "EDIT_AGENDA")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());
        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.CSMAP_BO_AGENDA, StrasbourgPortletKeys.CSMAP_BO_AGENDA, "DELETE_AGENDA")
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
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasUpdatePermission,
                                                    _getStatutActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                )
                .build();
    }


    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/csmap-bo-agenda-edit-thematique.jsp")
                            .setCMD("editAgendaThematique")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaThematique")
                            .setParameter("agendaId", _agenda.getAgendaId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }
    /**
     * Action of Delete link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteAgendaThematique")
                            .setMVCPath("/csmap-bo-agenda-view-thematiques.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "agendaThematique")
                            .setParameter("agendaId", _agenda.getAgendaId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getStatutActionUnsafeConsumer() {

        return dropdownItem -> {
            if(_agenda.getIsActive()) {
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("deactivateAgendaThematique")
                                .setMVCPath("/csmap-bo-agenda-view-thematiques.jsp")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "agendaThematique")
                                .setParameter("agendaId", _agenda.getAgendaId())
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "deactivate"));
            }else{
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("activateAgendaThematique")
                                .setMVCPath("/csmap-bo-agenda-view-thematiques.jsp")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "agendaThematique")
                                .setParameter("agendaId", _agenda.getAgendaId())
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "activate"));
            }
        };
    }

    private final Agenda _agenda;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
