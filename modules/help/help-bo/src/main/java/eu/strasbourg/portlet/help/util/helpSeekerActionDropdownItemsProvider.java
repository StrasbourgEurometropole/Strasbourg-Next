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
import eu.strasbourg.portlet.help.context.ViewHelpSeekersDisplayContext;
import eu.strasbourg.service.interest.model.Interest;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author BMA
 */
public class helpSeekerActionDropdownItemsProvider {

    public helpSeekerActionDropdownItemsProvider(
            HelpSeeker helpSeeker, RenderRequest request,
            RenderResponse response) {

        _helpSeeker = helpSeeker;
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
                StrasbourgPortletKeys.INTEREST_BO, StrasbourgPortletKeys.INTEREST_BO, "EDIT_INTEREST")
                && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(),
                StrasbourgPortletKeys.INTEREST_BO, StrasbourgPortletKeys.INTEREST_BO, "DELETE_INTEREST")
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
                .build();
    }

    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(
                    PortletURLBuilder.createRenderURL(_response)
                            .setMVCPath("/interest-bo-edit-interest.jsp")
                            .setCMD("editInterest")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "interests")
                            .setParameter("interestId", _interest.getInterestId())
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
                            .setActionName("deleteInterest")
                            .setMVCPath("/interest-bo-view-interests.jsp")
                            .setBackURL(_themeDisplay.getURLCurrent())
                            .setParameter("tab", "interests")
                            .setParameter("interestId", _helpSeeker.get())
                            .buildString()
            );
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }

    private final ViewHelpSeekersDisplayContext.HelpSeeker _helpSeeker;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;

}
