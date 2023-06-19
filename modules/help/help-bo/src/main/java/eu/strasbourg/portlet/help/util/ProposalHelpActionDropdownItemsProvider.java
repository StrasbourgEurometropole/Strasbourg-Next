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
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class ProposalHelpActionDropdownItemsProvider {

    public ProposalHelpActionDropdownItemsProvider(
            HelpProposal helpProposal, RenderRequest request,
            RenderResponse response) {

        _helpProposal = helpProposal;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_HELP")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasViewPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "VIEW")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasChangeActivityPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "CHANGE_ACTIVITY_HELP")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "DELETE_HELP")
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
                                                    () -> hasViewPermission,
                                                    _getViewActionUnsafeConsumer()
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
                                                    _getChangeActivityActionUnsafeConsumer()
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
                                                    _getReadActionUnsafeConsumer()
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
                                                    _getChangeStatusActionUnsafeConsumer()
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
                                                    _getDeletectionUnsafeConsumer()
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
    private UnsafeConsumer<DropdownItem, Exception> _getViewActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-view-proposal-help-requests.jsp")
                            .setCMD("viewProposalHelpRequests")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-help-requests"));
        };
    }
    /**
     * Action of Edit help proposal
     */
    private UnsafeConsumer<DropdownItem, Exception> _getReadActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setActionName("readHelpProposal")
                            .setMVCPath("/help-bo-view-proposal-help-requests.jsp")
                            .setCMD("readHelpProposal")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "setRead"));
        };
    }
    /**
     * Action of view help proposal
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-edit-help-proposal.jsp")
                            .setCMD("editHelpProposal")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    private UnsafeConsumer<DropdownItem, Exception> _getChangeActivityActionUnsafeConsumer() {

        return dropdownItem -> {
            if(_helpProposal.getActivityStatusTitle(_themeDisplay.getLocale()).equals("Active")) {
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeActivityHelpProposal")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeActivityHelpProposal")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpProposals")
                                .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "deactivate-help-proposal"));
            }else if(_helpProposal.getActivityStatusTitle(_themeDisplay.getLocale()).equals("Inactive")){
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeActivityHelpProposal")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeActivityHelpProposal")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpProposals")
                                .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                                .buildString()

                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "reactivate-help-proposal"));
            }
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getChangeStatusActionUnsafeConsumer() {
        return dropdownItem -> {
            if(_helpProposal.getStatus()==0 ){
                dropdownItem.setHref(
                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeStatusHelpProposal")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeStatusHelpProposal")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpProposals")
                                .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                                .setParameter("status",2)
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "unpublish-help-proposal"));

            }else if(_helpProposal.getStatus()==2 ){
                dropdownItem.setHref(

                        PortletURLBuilder.createActionURL(_response)
                                .setActionName("changeStatusHelpProposal")
                                .setMVCPath("/help-bo-view-help-requests.jsp")
                                .setCMD("changeStatusHelpProposal")
                                .setBackURL(_themeDisplay.getURLCurrent())
                                .setParameter("tab", "helpProposals")
                                .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                                .setParameter("status",0)
                                .buildString()
                );
                dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "publish-help-proposal"));
            }
        };
    }
    private UnsafeConsumer<DropdownItem, Exception> _getDeletectionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setActionName("deleteHelpProposal")
                            .setMVCPath("/help-bo-view-help-proposals.jsp")
                            .setCMD("deleteHelpProposal")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpProposalId", _helpProposal.getHelpProposalId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }
    private final HelpProposal _helpProposal;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
