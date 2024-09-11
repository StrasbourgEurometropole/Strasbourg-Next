package eu.strasbourg.portlet.objtp.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.service.objtp.service.ObjectCategoryLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
		configurationPid = "eu.strasbourg.portlet.objtp.configuration.ObjtpConfiguration",
		configurationPolicy = ConfigurationPolicy.OPTIONAL,
		immediate = true,	
		property = {
				"javax.portlet.name=" + StrasbourgPortletKeys.OBJTP_WEB },
		service = ConfigurationAction.class)
public class ObjtpConfigurationAction extends DefaultConfigurationAction{

	/**
	 * Action: Sauvegarde de la configuration si on a validé le formulaire ou
	 * envoi de la JSP des sélecteurs si on a changé la liste déroulante des
	 * types d'entité
	 */
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest request, ActionResponse response) throws Exception {

		String cmd = ParamUtil.getString(request, "cmd");

		if ("update".equals(cmd)) {
			// Update preferences only if the command is "update."

			// Retrieve and set the preferences for title, URL for declaring lost, and URL for the guide
			setPreference(request, "title", ParamUtil.getString(request, "title"));
			setPreference(request, "urlDeclareLost", ParamUtil.getString(request, "urlDeclareLost"));
			setPreference(request, "urlGuideHowTo", ParamUtil.getString(request, "urlGuideHowTo"));

			// Process category codes
			String categoryCodes = getCategoryCodes(request);
			setPreference(request, "categoryCodes", categoryCodes);
		}

		super.processAction(portletConfig, request, response);
	}

	// Helper method to process and concatenate category codes using Java 8 Stream API
	private String getCategoryCodes(ActionRequest request) {
		long categoriesCount = ParamUtil.getLong(request, "categoriesCount");

		String categoryCodes = LongStream.range(0, categoriesCount)
				.mapToObj(i -> ParamUtil.getString(request, "categoryCode_" + i))
				.filter(code -> !Validator.isNull(code) && !code.equals("false"))
				.collect(Collectors.joining(","));

		return categoryCodes;
	}



	/**
	 * Envoie à la JSP de configuration des informations nécessaires
	 */
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

			// Pages sélectionnées
			ObjtpConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(ObjtpConfiguration.class, themeDisplay);
			
			// Titre
			request.setAttribute("title", configuration.title());

			// URL pour déclarer un objet perdu
			request.setAttribute("urlDeclareLost", configuration.urlDeclareLost());

			// URL pour le guide d'utilisation
			request.setAttribute("urlGuideHowTo", configuration.urlGuideHowTo());
			
			// Codes de catégorie d'objets trouvés
			request.setAttribute("categoryCodes", configuration.categoryCodes());

			request.setAttribute("allCategories", ObjectCategoryLocalServiceUtil.getObjectCategories(-1, -1));
			
			
		} catch (ConfigurationException e) {
			_log.error(e);
		}
		super.include(portletConfig, request, response);
	}
	

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/configuration/objtp-configuration.jsp";
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}

