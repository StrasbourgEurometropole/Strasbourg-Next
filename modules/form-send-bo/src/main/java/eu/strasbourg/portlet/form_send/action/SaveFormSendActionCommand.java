package eu.strasbourg.portlet.form_send.action;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormFieldValue;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordField;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalService;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component(
        immediate = true,
        property = {
        "javax.portlet.name=" + StrasbourgPortletKeys.FORM_SEND_BO,
        "mvc.command.name=saveFormSend"
        },
        service = MVCActionCommand.class
        )
public class SaveFormSendActionCommand implements MVCActionCommand{

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private FormSendRecordFieldLocalService _formSendRecordFieldLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
                .getAttribute(WebKeys.THEME_DISPLAY);

        try {
            long recordId = ParamUtil.getLong(actionRequest,"recordId");
            if (Validator.isNotNull(recordId)) {
                // récupération du formulaire envoyé
                DDMFormInstanceRecord record = DDMFormInstanceRecordLocalServiceUtil.fetchFormInstanceRecord(recordId);
                if(Validator.isNotNull(record)){
                    // récupère les infos du contenu du formulaire envoyé
                    // Contient les valeurs et le type du champ, avec l'identifiant du champ comme cle de la Map
                    Map<String, List<DDMFormFieldValue>> formfieldvaluesMap = record.getDDMFormValues().getDDMFormFieldValuesMap(false);
                    for (String formFieldKey : formfieldvaluesMap.keySet()) {
                        // récupère les infos du champs
                        List<DDMFormFieldValue> formFieldValuesList = formfieldvaluesMap.get(formFieldKey);
                        // récupère le formSendRecordField
                        List<FormSendRecordField> formSendRecordFieldList = FormSendRecordFieldLocalServiceUtil.getByContentAndInstanceId(record.getStorageId(), formFieldValuesList.get(0).getInstanceId());
                        if(formSendRecordFieldList.size() > 0){
                            FormSendRecordField formSendRecordField = formSendRecordFieldList.get(0);
                            if (Validator.isNotNull(formSendRecordField)){
                                // récupère la réponse si elle existe
                                String reponse = ParamUtil.getString(actionRequest,"rep-ville_" + formSendRecordField.getFormSendRecordFieldId());
                                // vérifie que la réponse est nouvelle
                                if(!reponse.equals(formSendRecordField.getResponse())){
                                    formSendRecordField.setModifiedDate(new Date());
                                    formSendRecordField.setResponseUserId(themeDisplay.getUserId());
                                    formSendRecordField.setResponse(reponse);

                                    _formSendRecordFieldLocalService.updateFormSendRecordField(formSendRecordField);
                                }
                            }
                        }
                    }
                }
            }

            actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "backURL"));

        } catch (IOException e) {
            _log.error(e);
        } catch (PortalException e) {
            _log.error(e);
            String portletName = (String) actionRequest
                    .getAttribute(WebKeys.PORTLET_ID);
            PortletURL backURL = PortletURLFactoryUtil.create(actionRequest,
                    portletName, themeDisplay.getPlid(),
                    PortletRequest.RENDER_PHASE);
            actionResponse.setRenderParameter("backURL", backURL.toString());
            actionResponse.setRenderParameter("mvcPath",
                    "/form-send-bo-edit-form-send.jsp");
            actionResponse.setRenderParameter("cmd", "saveFormSend");
            return false;
        }
        return true;
    }

    @Reference(unbind = "-")
    protected void setFormSendRecordFieldLocalService(FormSendRecordFieldLocalService formSendRecordFieldLocalService){
        _formSendRecordFieldLocalService = formSendRecordFieldLocalService;
    }
}
