package eu.strasbourg.portlet.agenda;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.agenda.display.context.EditCampaignDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.EditEventDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.EditManifestationDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewCampaignsDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewEventsDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewManifestationsDisplayContext;
import eu.strasbourg.service.agenda.model.ImportReport;
import eu.strasbourg.service.agenda.service.ImportReportLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/vendors/daterangepicker.css",
		"com.liferay.portlet.header-portlet-css=/css/agenda-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/agenda-bo-view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class AgendaBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		String cmd = ParamUtil.getString(renderRequest, "cmd");
		String tab = ParamUtil.getString(renderRequest, "tab");
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		
		renderResponse.setTitle("Events");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String returnURL = ParamUtil.getString(renderRequest, "returnURL");
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL.toString());
		}

		// If we are on the Event event page, we add the corresponding
		// display context
		if (cmd.equals("editEvent") || mvcPath.equals("/agenda-bo-edit-event.jsp")) {
			EditEventDisplayContext dc = new EditEventDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("editManifestation")) {
			EditManifestationDisplayContext dc = new EditManifestationDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("editCampaign") || mvcPath.equals("/agenda-bo-edit-campaign.jsp")) {
			EditCampaignDisplayContext dc = new EditCampaignDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (tab.equals("manifestations")) {
			ViewManifestationsDisplayContext dc = new ViewManifestationsDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (tab.equals("campaigns")) {
			ViewCampaignsDisplayContext dc = new ViewCampaignsDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else { // Else, we are on the event list page
			ViewEventsDisplayContext dc = new ViewEventsDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		}

		// Le dossier d'import des événements
		renderRequest.setAttribute("importPath",
			StrasbourgPropsUtil.getAgendaImportDirectory());

		// La liste des rapports d'import des événements
		List<ImportReport> reports = ImportReportLocalServiceUtil
			.getImportReports(-1, -1).stream()
			.sorted((r1, r2) -> r2.getStartDate().compareTo(r1.getStartDate()))
			.collect(Collectors.toList());
		renderRequest.setAttribute("reports", reports);

		// Admin ou pas
		renderRequest.setAttribute("isAdmin",
			themeDisplay.getPermissionChecker().isOmniadmin());

		super.render(renderRequest, renderResponse);
	}
}