package eu.strasbourg.portlet.edition.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EditionActionDropdownItemsProvider {
    public EditionActionDropdownItemsProvider(Edition edition, RenderRequest request, RenderResponse _response) {
        this._edition = edition;
        this._httpServletRequest = PortalUtil.getHttpServletRequest(request);
        ;
        this._response = _response;
        _themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * The list of dropdown items to display for all edition
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.EDITION_BO, StrasbourgPortletKeys.EDITION_BO, "EDIT_EDITION") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.EDITION_BO, StrasbourgPortletKeys.EDITION_BO, "DELETE_EDITION") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder.addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasUpdatePermission, _getEditActionUnsafeConsumer()).build());
        }).addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasDeletePermission, _getDeleteActionUnsafeConsumer()).build());
        }).build();

    }

    /**
     * Action of Edit link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createRenderURL(_response).setMVCPath("/edition-bo-edit-edition.jsp").setCMD("editEdition").setBackURL(_themeDisplay.getURLCurrent()).setParameter("tab", "editions").setParameter("editionId", _edition.getEditionId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete link
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createActionURL(_response).setActionName("deleteEdition").setMVCPath("/edition-bo-view-editions.jsp").setBackURL(_themeDisplay.getURLCurrent()).setParameter("tab", "editions").setParameter("editionId", _edition.getEditionId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }


    private final Edition _edition;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;
}





