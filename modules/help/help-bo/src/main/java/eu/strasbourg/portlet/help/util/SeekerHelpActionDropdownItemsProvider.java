package eu.strasbourg.portlet.help.util;

import com.liferay.alloy.util.JSONUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.context.ViewHelpSeekersDisplayContext;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class SeekerHelpActionDropdownItemsProvider {

    public SeekerHelpActionDropdownItemsProvider(
            ViewHelpSeekersDisplayContext.HelpSeeker helpSeeker, RenderRequest request,
            RenderResponse response) {

        _helpSeeker = helpSeeker;
        _response = response;

        _themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY);

        _httpServletRequest = PortalUtil.getHttpServletRequest(
                request);
    }

    public List<DropdownItem> getActionDropdownItems(String countImage) {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.HELP_BO, StrasbourgPortletKeys.HELP_BO, "'EDIT_HELP_REQUEST'")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());;


        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    DropdownItemListBuilder
                                            .add(
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
                                                   // () -> hasUpdatePermission,
                                                    _getDeleteActionUnsafeConsumer(countImage)
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
                            .setMVCPath("/help-bo-view-seeker-help-requests.jsp")
                            .setCMD("viewSeekerHelpRequests")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpSeekers")
                            .setParameter("helpSeekerId", _helpSeeker.getPublikUser().getPublikId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "view-help-requests"));
        };
    }

    /**
     * Action of view help proposal
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer(String countImage) {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/help-bo-view-seeker-help-requests.jsp")
                            .setCMD("deleteStudentCardImages")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "helpProposals")
                            .setParameter("helpSeekerId", _helpSeeker.getPublikUser().getPublikId())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, countImage));
        };
    }


    private final ViewHelpSeekersDisplayContext.HelpSeeker _helpSeeker;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
