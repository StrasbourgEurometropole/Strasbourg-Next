package eu.strasbourg.portlet.felec.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
	immediate = true,
	property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/felec-view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class FelecWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("dc", new FelecWebDisplayContext(renderRequest, renderResponse));
		super.render(renderRequest, renderResponse);
	}
	@Override
	public void processAction(ActionRequest actionRequest,
		ActionResponse actionResponse) throws IOException, PortletException {
		String name = ParamUtil.getString(actionRequest, "name");
		String firstName = ParamUtil.getString(actionRequest, "firstname");
		Date birthDate = ParamUtil.getDate(actionRequest, "birthdate",
			new SimpleDateFormat("yyyy-MM-dd"));
		String birthPlace = ParamUtil.getString(actionRequest, "birthplace");

		if (Validator.isNull(name)) {
			SessionErrors.add(actionRequest, "name-required");
		}

		if (Validator.isNull(firstName)) {
			SessionErrors.add(actionRequest, "first-name-required");
		}

		if (Validator.isNull(birthPlace)) {
			SessionErrors.add(actionRequest, "birthplace-required");
		}

		String birthdate = ParamUtil.getString(actionRequest, "birthdate");
		if (Validator.isNull(birthdate)) {
			SessionErrors.add(actionRequest, "birthdate-required");
		}
		else {
			if (!birthdate.matches("^[1-2][0-9]{3}-[0-1]?[0-9]-[0-3]?[0-9]$")) {
				SessionErrors.add(actionRequest, "date-not-valid");
			}
		}

		if (birthPlace.contains("<")) {
			SessionErrors.add(actionRequest, "invalid-character-in-birthplace");
		}

		if (name.contains("<")) {
			SessionErrors.add(actionRequest, "invalid-character-in-name");
		}

		if (firstName.contains("<")) {
			SessionErrors.add(actionRequest, "invalid-character-in-first-name");
		}


		if (SessionErrors.isEmpty(actionRequest)) {
			FelecResponse felecResponse = FelecWebServiceClient
				.getResponse(name, firstName, birthDate, birthPlace);
			actionRequest.setAttribute("felecResponse", felecResponse);
		}
		actionRequest.setAttribute("name", HtmlUtil.escape(name));
		actionRequest.setAttribute("firstname", HtmlUtil.escape(firstName));
		actionRequest.setAttribute("birthdate",
			ParamUtil.getString(actionRequest, "birthdate"));
		actionRequest.setAttribute("birthplace", HtmlUtil.escape(birthPlace));
		super.processAction(actionRequest, actionResponse);
	}
}