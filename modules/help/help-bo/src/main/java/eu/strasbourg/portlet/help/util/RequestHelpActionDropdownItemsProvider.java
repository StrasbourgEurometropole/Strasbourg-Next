package eu.strasbourg.portlet.help.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class RequestHelpActionDropdownItemsProvider {

    public RequestHelpActionDropdownItemsProvider(
            HelpRequest helpRequest, RenderRequest request,
            RenderResponse response) {

        _helpRequest = helpRequest;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    public List<DropdownItem> getActionDropdownItems(String imageCount) {

        boolean hasUpdateHelpRequestPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_HELP_REQUEST")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_HELP")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasChangeActivityPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_PUBLIKUSER")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasUpdateHelpRequestPermission,
                                                    _getEditHelpRequestActionUnsafeConsumer()
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
                                                    () -> hasUpdateHelpRequestPermission,
                                                    _getChangeStatusHelpRequestActionUnsafeConsumer()
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
                                                    () -> hasUpdateHelpRequestPermission,
                                                    _getDeleteActionUnsafeConsumer(imageCount)
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
                                                    () -> hasChangeActivityPermission,
                                                    _getViewActionUnsafeConsumer()
                                            )
                                            .build()
                            );
                        }

                )
                .build();
    }

    /**
     * Action of Edit help proposal
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-edit-help-proposal.jsp\"")
                            .setCMD("editHelpProposal")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpRequests")
                            .setParameter("helpProposalId", _helpRequest.getHelpProposalId())
                            .buildString()

            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-help-proposal"));
        };
    }

    /**
     * Action of view help proposal
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditHelpRequestActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-edit-help-request.jsp")
                            .setCMD("editHelpRequest")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpRequests")
                            .setParameter("helpRequestId", _helpRequest.getHelpRequestId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-help-request"));
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer(String imagesCount) {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setActionName("deleteStudentCardImages")
                            .setMVCPath("/help-bo-view-help-requests.jsp")
                            .setCMD("deleteStudentCardImages")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpRequests")
                            .setParameter("studentPublikId", _helpRequest.getPublikId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, imagesCount));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getChangeStatusHelpRequestActionUnsafeConsumer() {

        return dropdownItem -> {
            if(!_helpRequest.getModerationStatusTitle(_themeDisplay.getLocale()).equals("Conforme")) {
                dropdownItem.setHref(



                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeStatusHelpRequest")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeStatusHelpRequest")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpRequests")
                                .setParameter("requestModerationStatus", "Conforme")
                                .setParameter("helpRequestId", _helpRequest.getHelpRequestId())
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "set-request-valid"));
            }else if(!_helpRequest.getModerationStatusTitle(_themeDisplay.getLocale()).equals("Alerte")){
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeStatusHelpRequest")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeStatusHelpRequest")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpRequests")
                                .setParameter("requestModerationStatus", "Alerte")
                                .setParameter("helpRequestId", _helpRequest.getHelpRequestId())
                                .buildString()

                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "set-request-valid"));
            }
            else if(!_helpRequest.getModerationStatusTitle(_themeDisplay.getLocale()).equals("Non-conforme")){
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeStatusHelpRequest")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeStatusHelpRequest")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpRequests")
                                .setParameter("requestModerationStatus", "Non-conforme")
                                .setParameter("helpRequestId", _helpRequest.getHelpRequestId())
                                .buildString()

                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "set-request-not-valid"));
            }
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getViewActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setActionName("deleteStudentCardImages")
                            .setMVCPath("/help-bo-view-help-requests.jsp")
                            .setCMD("deleteStudentCardImages")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpRequests")
                            .setParameter("studentPublikId", _helpRequest.getPublikId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-user-profil"));
        };
    }
    private final HelpRequest _helpRequest;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
