package eu.strasbourg.portlet.help.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import com.liferay.portal.kernel.util.Validator;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class SeekerHelpRequestActionDropdownItemsProvider {

    public SeekerHelpRequestActionDropdownItemsProvider(
            HelpRequest helpRequest, RenderRequest request,
            RenderResponse response) {

        _helpRequest = helpRequest;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdateRequestPermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_HELP_REQUEST")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());


         boolean hasUpdatePermission= _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                 StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "EDIT_HELP")
                 && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
                                                    () -> hasUpdateRequestPermission,
                                                    _getUpdateRequestActionUnsafeConsumer()
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
                .build();
    }

    /**
     * Action of Edit help seekerRequest
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-edit-help-proposal.jsp")
                            .setCMD("editHelpProposal")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpProposalId", _helpRequest.getHelpProposal().getHelpProposalId())
                            .buildString()
            );

            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-help-proposal"));
        };
    }

    /**
     * Action of view help seekerRequest
     */
    private UnsafeConsumer<DropdownItem, Exception> _getUpdateRequestActionUnsafeConsumer() {

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

    private final HelpRequest _helpRequest;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
