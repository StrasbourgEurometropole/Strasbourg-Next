package eu.strasbourg.portlet.familyKiosk.configuration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Map;

@Component(
	configurationPid = "eu.strasbourg.portlet.familyKiosk.configuration.FamilyKioskConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.FAMILY_KIOSK_WEB },
	service = ConfigurationAction.class)
public class FamilyKioskConfigurationAction
	extends DefaultConfigurationAction {

	/**
	 * Action : Sauvegarde de la configuration si on a validé le formulaire ou
	 * envoi de la JSP des sélecteurs si on a changé la liste déroulante des
	 * types d'entité
	 */
	@Override
	public void processAction(PortletConfig portletConfig,
		ActionRequest request, ActionResponse response) throws Exception {


		String cmd = ParamUtil.getString(request, "cmd");

		if (cmd.equals("update")) {

			// Texte d'introduction
			Map<Locale, String> introMap = LocalizationUtil
					.getLocalizationMap(request, "introMap");
			LocalizedValuesMap mapIntro = new LocalizedValuesMap();
			for (Map.Entry<Locale, String> e : introMap.entrySet()) {
				mapIntro.put(e.getKey(), e.getValue());
			}
			String introXML = LocalizationUtil.getXml(mapIntro, "intro");
			setPreference(request, "introXML", introXML);

			// URL site espace famille
			String familyKioskURL = ParamUtil.getString(request, "familyKioskURL");
			setPreference(request, "familyKioskURL", familyKioskURL);
		}
		super.processAction(portletConfig, request, response);
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
			FamilyKioskConfiguration configuration = themeDisplay
				.getPortletDisplay().getPortletInstanceConfiguration(
						FamilyKioskConfiguration.class);

			request.setAttribute("intro", configuration.introXML());
			request.setAttribute("familyKioskURL", configuration.familyKioskURL());
			
		} catch (ConfigurationException e) {
			_log.error(e);
		}
		super.include(portletConfig, request, response);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
