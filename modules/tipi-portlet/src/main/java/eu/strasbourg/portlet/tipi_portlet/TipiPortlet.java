package eu.strasbourg.portlet.tipi_portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author 01i454
 */
@Component(immediate = true,
		configurationPid = "eu.strasbourg.portlet.tipi_portlet.configuration.TipiPortletConfiguration",
		property = {
		"com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Tipi Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.version=3.0",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/tipi-configuration.jsp",
		"com.liferay.portlet.footer-portlet-javascript=/js/main.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.name=" + StrasbourgPortletKeys.TIPI_PORTLET_WEB,
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class TipiPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		// On récupère les préférences afin de les renvoyer existantes à la JSP
		PortletPreferences prefs = request.getPreferences();

		// Type de formulaire
		String form = prefs.getValue("form", "");
		request.setAttribute("form", form);
		
		// Complément d'infos
		String complement = prefs.getValue("complement", "");
		request.setAttribute("complement", complement);

		String appCode = "";
		String clientNumber = "";
		String formTitle = "";
		if (form != null && form.length() > 0) {
			if (form.equals("childhood")) {
				appCode = "PF";
				clientNumber = "000696";
				formTitle = "Facturation petite enfance";
			} else if (form.equals("schoolRestaurantAfterSchool")) {
				appCode = "SP";
				clientNumber = "000696";
				formTitle = "Facturation Enfance (Cantine, ALM et APM)";
			} else if (form.equals("water")) {
				appCode = "EA";
				clientNumber = "007964";
				formTitle = "Facturation eau et assainissement";
			} else if (form.equals("rs")) {
				appCode = "RZ";
				clientNumber = "002902";
				formTitle = "Facturation D&eacute;chet Redevance Sp&eacute;ciale";
			} else if (form.equals("reom")) {
				appCode = "RC";
				clientNumber = "021529";
				formTitle = "Facturation D&eacute;chet REOM";
		} else {
			formTitle = "Facturation inconnue";

			}
			
	}
		request.setAttribute("appCode", appCode);
		request.setAttribute("clientNumber", clientNumber);
		request.setAttribute("formTitle", formTitle);

		// On récupère l'URL de paiement dans config.properties
		String billingURL = "";
		String callbackURL = "";
		billingURL =  StrasbourgPropsUtil.getTipiURL();
		callbackURL = StrasbourgPropsUtil.getTipiCallbackURL();
				//callbackURL = "http://ldkimmwffo.localtunnel.me/web/tipi/accueil";
		request.setAttribute("billingURL", billingURL);
		request.setAttribute("callbackURL", callbackURL);

		super.render(request, response);
	}
}