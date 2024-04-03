package eu.strasbourg.portlet.place_schedule.configuration;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
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
	configurationPid = "eu.strasbourg.portlet.place_schedule.configuration.PlaceScheduleConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_SCHEDULE_WEB },
	service = ConfigurationAction.class)
public class PlaceScheduleConfigurationAction
	extends DefaultConfigurationAction {

	/**
	 * Action : Sauvegarde de la configuration si on a validé le formulaire ou
	 * envoi de la JSP des sélecteurs si on a changé la liste déroulante des
	 * types d'entité
	 */
	@Override
	public void processAction(PortletConfig portletConfig,
		ActionRequest request, ActionResponse response) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
			.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();

		String cmd = ParamUtil.getString(request, "cmd");

		if (cmd.equals("update")) {
			// Catégorie
			String categoryId = ParamUtil.getString(request, "categoryId");
			setPreference(request, "categoryId", categoryId);

			// Text
			Map<Locale, String> textMap = LocalizationUtil
				.getLocalizationMap(request, "textMap");
			LocalizedValuesMap map = new LocalizedValuesMap();
			for (Map.Entry<Locale, String> e : textMap.entrySet()) {
				map.put(e.getKey(), e.getValue());
			}
			String textXML = LocalizationUtil.getXml(map, "TextSchedule");
			setPreference(request, "textScheduleXML", textXML);

			// Page détail
			String linksUuids = ParamUtil.getString(request, "linksUuids");
			setPreference(request, "linksUuids", linksUuids);

			// Mode d'affichage
			String template = ParamUtil.getString(request, "template");
			setPreference(request, "template", template);

			// Masquage de l'affluence
			boolean hideAffluence = ParamUtil.getBoolean(request, "hideAffluence");
			setPreference(request, "hideAffluence", String.valueOf(hideAffluence));
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

			// Vocabulaire type de lieux
			AssetVocabulary placeTypeVocabulary = AssetVocabularyHelper
				.getVocabulary(VocabularyNames.PLACE_TYPE,
					themeDisplay.getCompanyGroupId());
			request.setAttribute("categories",
				placeTypeVocabulary.getCategories());

			PlaceScheduleConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(PlaceScheduleConfiguration.class, themeDisplay);
			// Catégorie
			request.setAttribute("categoryId", configuration.categoryId() > 0
				? configuration.categoryId() : "");



			// Text
			request.setAttribute("textSchedule",
				configuration.textScheduleXML());

			// Page détail
			request.setAttribute("linksUuids", configuration.linksUuids());

			// Mode d'affichage
			request.setAttribute("template", configuration.template());

			// Masquage de l'affluence
			boolean hideAffluence = ParamUtil.getBoolean(request,
					"hideAffluence", configuration.hideAffluence());
			request.setAttribute("hideAffluence", hideAffluence);
			

		} catch (ConfigurationException e) {
			_log.error(e);
		}
		super.include(portletConfig, request, response);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
