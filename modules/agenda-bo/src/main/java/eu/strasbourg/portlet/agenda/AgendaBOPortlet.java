package eu.strasbourg.portlet.agenda;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agenda.display.context.EditCampaignDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.EditEventDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.EditManifestationDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewCampaignsDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewEventsDisplayContext;
import eu.strasbourg.portlet.agenda.display.context.ViewManifestationsDisplayContext;
import eu.strasbourg.service.agenda.model.ImportReport;
import eu.strasbourg.service.agenda.service.ImportReportLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/vendors/daterangepicker.css",
		"com.liferay.portlet.header-portlet-css=/css/agenda-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/agenda-bo-view-events.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class AgendaBOPortlet extends MVCPortlet {
	public static final String EVENTS = "events";
	public static final String MANIFS = "manifestations";
	public static final String IMPORT = "import";
	public static final String CAMPAIGNS = "campaigns";
	public static final String EDIT_EVENT = "editEvent";
	public static final String EDIT_MANIF = "editManifestation";
	public static final String EDIT_CAMPAIGN = "editCampaign";
	public static final String URL_PARAM_CMD = "cmd";

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);

		NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
		renderRequest.setAttribute("navigationDC", navigationDC);
		String selectedCmd = Optional
				.ofNullable(ParamUtil.getString(renderRequest, URL_PARAM_CMD))
				.filter(Validator::isNotNull)
				.orElse(null);
		switch (navigationDC.getSelectedTab()) {
			case MANIFS:
				if(Validator.isNotNull(selectedCmd) && selectedCmd.equals(EDIT_MANIF)){
					EditManifestationDisplayContext dc = new EditManifestationDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				} else {
					ViewManifestationsDisplayContext dc = new ViewManifestationsDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				}
				break;

			case CAMPAIGNS:
				if(Validator.isNotNull(selectedCmd) && selectedCmd.equals(EDIT_CAMPAIGN)){
					EditCampaignDisplayContext dc = new EditCampaignDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				} else {
					ViewCampaignsDisplayContext dc = new ViewCampaignsDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				}
				break;

			case EVENTS:
			case IMPORT:
			default:
				if(Validator.isNotNull(selectedCmd) && selectedCmd.equals(EDIT_EVENT)){
					EditEventDisplayContext dc = new EditEventDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				} else {
					ViewEventsDisplayContext dc = new ViewEventsDisplayContext(renderRequest, renderResponse);
					renderRequest.setAttribute("dc", dc);
				}
				break;
		}
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		renderResponse.setTitle("Events");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL.toString());
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