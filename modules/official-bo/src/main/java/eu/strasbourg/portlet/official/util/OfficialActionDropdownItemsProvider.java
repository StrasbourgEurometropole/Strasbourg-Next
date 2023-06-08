package eu.strasbourg.portlet.official.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OfficialActionDropdownItemsProvider {
    public OfficialActionDropdownItemsProvider(Official official, RenderRequest request, RenderResponse _response) {
        this._official = official;
        this._httpServletRequest = PortalUtil.getHttpServletRequest(request);
        ;
        this._response = _response;
        _themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * The list of dropdown items to display for all official
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.OFFICIAL_BO, StrasbourgPortletKeys.OFFICIAL_BO, "EDIT_OFFICIAL") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.OFFICIAL_BO, StrasbourgPortletKeys.OFFICIAL_BO, "DELETE_OFFICIAL") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder.addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasUpdatePermission, _getEditActionUnsafeConsumer()).build());
        }).addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasDeletePermission, _getDeleteActionUnsafeConsumer()).build());
        }).build();

    }

    /**
     * Action of Edit official
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createRenderURL(_response).setMVCPath("/official-bo-edit-official.jsp").setCMD("editOfficial").setBackURL(_themeDisplay.getURLCurrent()).setParameter("tab", "officials").setParameter("officialId", _official.getOfficialId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete official
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createActionURL(_response).setActionName("deleteOfficial").setMVCPath("/official-bo-view-officials.jsp").setBackURL(_themeDisplay.getURLCurrent()).setParameter("tab", "officials").setParameter("officialId", _official.getOfficialId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }


    private final Official _official;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;
}





