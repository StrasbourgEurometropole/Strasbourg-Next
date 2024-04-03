package eu.strasbourg.portlet.form_send.util;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemListBuilder;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FormSendSignalementActionDropdownItemsProvider {
    public FormSendSignalementActionDropdownItemsProvider(FormSendRecordFieldSignalement formSignalement, RenderRequest request, RenderResponse _response) {
        this._formSendRecordFieldSignalement = formSignalement;
        this._httpServletRequest = PortalUtil.getHttpServletRequest(request);
        ;
        this._response = _response;
        _themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * The list of dropdown items to display for all formSend
     */
    public List<DropdownItem> getActionDropdownItems() {

        boolean hasUpdatePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.FORM_SEND_BO, StrasbourgPortletKeys.FORM_SEND_BO, "EDIT_FORM_SEND") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        boolean hasDeletePermission = _themeDisplay.getPermissionChecker().hasPermission(this._themeDisplay.getScopeGroupId(), StrasbourgPortletKeys.FORM_SEND_BO, StrasbourgPortletKeys.FORM_SEND_BO, "DELETE_FORM_SEND") && Validator.isNull(_themeDisplay.getScopeGroup().getStagingGroup());

        return DropdownItemListBuilder.addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasUpdatePermission, _getEditActionUnsafeConsumer()).build());
        }).addGroup(dropdownGroupItem -> {
            dropdownGroupItem.setDropdownItems(DropdownItemListBuilder.add(() -> hasDeletePermission, _getDeleteActionUnsafeConsumer()).build());
        }).build();

    }

    /**
     * Action of Edit FormSend
     */
    private UnsafeConsumer<DropdownItem, Exception> _getEditActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createRenderURL(_response).setMVCPath("/form-send-bo-edit-form-send.jsp")
                    .setCMD("editFormSend").setBackURL(_themeDisplay.getURLCurrent())
                    .setParameter("tab", "forms").setParameter("signalementId", _formSendRecordFieldSignalement.getSignalementId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "edit"));
        };
    }

    /**
     * Action of Delete FormSend
     */
    private UnsafeConsumer<DropdownItem, Exception> _getDeleteActionUnsafeConsumer() {

        return dropdownItem -> {
            dropdownItem.setHref(PortletURLBuilder.createActionURL(_response).setActionName("deleteFormSend").setMVCPath("/form-send-bo-view-forms.jsp")
                    .setBackURL(_themeDisplay.getURLCurrent()).setParameter("tab", "forms").setParameter("signalementId", _formSendRecordFieldSignalement.getSignalementId()).buildString());
            dropdownItem.setLabel(LanguageUtil.get(_httpServletRequest, "delete"));
        };
    }


    private final FormSendRecordFieldSignalement _formSendRecordFieldSignalement;
    private final HttpServletRequest _httpServletRequest;
    private final RenderResponse _response;
    private final ThemeDisplay _themeDisplay;
}





