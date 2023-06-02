package eu.strasbourg.portlet.form_send;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.portlet.form_send.context.*;
import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalement;
import eu.strasbourg.service.formSendRecordField.service.FormSendRecordFieldSignalementLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.form_send.constants.FormSendConstants.*;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * @author angelique.champougny
 */
@Component(
		immediate=true,
		property= {
				"javax.portlet.version=3.0",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.footer-portlet-javascript=/js/form-send-bo-main.js",
				"com.liferay.portlet.header-portlet-css=/css/form-send-bo-main.css",
				"com.liferay.portlet.single-page-application=false",
				"javax.portlet.init-param.template-path=/META-INF/resources/",
				"javax.portlet.init-param.view-template=/form-send-bo-view-forms.jsp",
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class FormSendBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		try {
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);

			//si on est sur la page des proposition ou de signalement, on renvoi le formInstanceId
			renderRequest.setAttribute(URL_PARAM_FORM_INSTANCE_ID, navigationDC.getSelectedFormInstanceId());

			switch (navigationDC.getSelectedTab()) {
				case RECORDS:
					if (navigationDC.getSelectedCmd().equals(EDIT_FORM_SEND) || navigationDC.getSelectedCmd().equals(SAVE_FORM_SEND)) {
						EditFormSendDisplayContext dc = new EditFormSendDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewFormSendDisplayContext dc = new ViewFormSendDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementFormsSendToolBarDisplayContext managementDC = new ManagementFormsSendToolBarDisplayContext
								(servletRequest,(LiferayPortletRequest) renderRequest,
										(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case SIGNALEMENTS: {
					ViewReportingDisplayContext dc = new ViewReportingDisplayContext(renderRequest, renderResponse, _itemSelector);
					ManagementRportingToolBarDisplayContext managementDC = new ManagementRportingToolBarDisplayContext
							(servletRequest, (LiferayPortletRequest) renderRequest,
									(LiferayPortletResponse) renderResponse, dc);
					renderRequest.setAttribute("dc", dc);
					renderRequest.setAttribute("managementDC", managementDC);
					break;
				}
				case FORMS: {
					ViewFormDisplayContext dc = new ViewFormDisplayContext(renderRequest, renderResponse, _itemSelector);
					ManagementFormsToolBarDisplayContext managementDC = new ManagementFormsToolBarDisplayContext
							(servletRequest, (LiferayPortletRequest) renderRequest,
									(LiferayPortletResponse) renderResponse, dc);
					renderRequest.setAttribute("dc", dc);
					renderRequest.setAttribute("managementDC", managementDC);
					break;
				}
			}

		} catch (PortalException e) {
			e.printStackTrace();
		}

		//si on est sur la page des proposition ou de signalement, on affiche un lien de retour
		String backURL = ParamUtil.getString(renderRequest,"backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton){
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL);
		}

		super.render(renderRequest, renderResponse);
	}

	private Boolean displayResponse(boolean showResponse, long formSendRecordFieldId){
		// récupère tous les signalements qui ont cette réponse
		List<FormSendRecordFieldSignalement> signalements = FormSendRecordFieldSignalementLocalServiceUtil.findByFormSendRecordFieldId(formSendRecordFieldId);

		// pour chaque signalement, modifier leurs status par celui correspondant (4 -> afficher la réponse, 0 -> cacher la réponse)
		for (FormSendRecordFieldSignalement signalement : signalements) {
			signalement.setStatus(showResponse ? WorkflowConstants.STATUS_DENIED : WorkflowConstants.STATUS_APPROVED);
			FormSendRecordFieldSignalementLocalServiceUtil.updateFormSendRecordFieldSignalement(signalement);
		}
		return true;
	}
	@Reference
	private ItemSelector _itemSelector;
}