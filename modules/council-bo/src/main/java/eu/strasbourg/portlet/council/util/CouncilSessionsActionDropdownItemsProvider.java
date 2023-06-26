package eu.strasbourg.portlet.council.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class CouncilSessionsActionDropdownItemsProvider {

    public CouncilSessionsActionDropdownItemsProvider(
            CouncilSession councilSession, RenderRequest request,
            RenderResponse response) {

        _councilSession = councilSession;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

            _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    /**
     * The list of dropdown items to display for all council session
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COUNCIL_BO, StrasbourgPortletKeys.COUNCIL_BO, "EDIT_COUNCIL_SESSION")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.COUNCIL_BO, StrasbourgPortletKeys.COUNCIL_BO, "DELETE_COUNCIL_SESSION")
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
                                                    () -> hasUpdatePermission,
                                                    _getManageProcurationsActionUnsafeConsumer()
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
                                                    _getExportCouncilSessionActionUnsafeConsumer()
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
                                                    () -> hasDeletePermission,
                                                    _getDeleteActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }
                ).build();
    }

    /**
     * Action of Edit councilsession
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/council-bo-edit-council-session.jsp")
                            .setCMD("editCouncilSession")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "councilSessions")
                            .setParameter("councilSessionId", _councilSession.getCouncilSessionId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }
    /**
     * Action of Manage procurations
     */
    private UnsafeConsumer<DropdownItem, Exception> _getManageProcurationsActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/council-bo-manage-procurations.jsp")
                            .setCMD("manageProcurations")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "councilSessions")
                            .setParameter("councilSessionId", _councilSession.getCouncilSessionId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "manage-procurations"));
        };
    }
    /**
     * Action of Export link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportCouncilSessionActionUnsafeConsumer() {

        return dropdownItem -> {
            ResourceURL resourceURL =
                    _response.createResourceURL();
            resourceURL.setResourceID("exportCouncilSessionResults");
            resourceURL.setParameter("councilSessionId", String.valueOf(_councilSession.getCouncilSessionId()));
            dropdownItem.setHref(resourceURL.toString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "export-results"));

        };

    }
    /**
     * Action of Export link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getExportActionUnsafeConsumer() {

        return dropdownItem -> {
            ResourceURL resourceURL =
                    _response.createResourceURL();
            resourceURL.setResourceID("exportProcurationsHistoric");
            resourceURL.setParameter("councilSessionId", String.valueOf(_councilSession.getCouncilSessionId()));
            dropdownItem.setHref(resourceURL.toString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "export-procurations"));
        };
    }

    /**
     * Action of Delete councilSession
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createActionURL(_response)
                            .setActionName("deleteCouncilSession")
                            .setMVCPath("/council-bo-view-council-sessions.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "councilSessions")
                            .setParameter("councilSessionId", _councilSession.getCouncilSessionId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final CouncilSession _councilSession;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}