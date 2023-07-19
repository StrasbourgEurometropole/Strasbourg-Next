package eu.strasbourg.service.social.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.cache.PortalCacheHelperUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PortletPreferences;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.social.SocialService;
import eu.strasbourg.utils.JSONHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Change le token instagram des portlet SocialWall qui doivent l'être
 */
@Component(service = SchedulerJobConfiguration.class)
public class AccessTokenRefresh
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 4h45"
		return TriggerConfiguration.createTriggerConfiguration("0 45 4 * * ?");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start refresh token");
			LocalDate today = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			// récupère les préférences des portlets socialWall présent
			List<PortletPreferences> preferences = PortletPreferencesLocalServiceUtil.getPortletPreferences();
			preferences = preferences.stream().filter(p -> p.getPortletId().contains("SocialWallPortlet")).collect(Collectors.toList());
			for (PortletPreferences preference : preferences) {
				javax.portlet.PortletPreferences portletPreferences = PortletPreferencesLocalServiceUtil
						.getPreferences(preference.getCompanyId(), preference.getOwnerId(), preference.getOwnerType(),
								preference.getPlid(), preference.getPortletId());
				String instagramCreateDate = portletPreferences.getValue("instagramCreateDate", "");
				String instagramToken = portletPreferences.getValue("instagramToken", "");

				// Vérifie si le token est toujours valide
				if (Validator.isNotNull(instagramCreateDate)) {
					LocalDate createDate = LocalDate.parse(instagramCreateDate, formatter);
					if (today.isEqual(createDate.plusDays(2))) {
						// on récupère un autre token
						Object[] stringData = {instagramToken};
						String apiURL = "https://graph.instagram.com/refresh_access_token?grant_type=ig_refresh_token&access_token=%s";
						apiURL = String.format(apiURL, stringData);
						try {
							JSONObject json = JSONHelper.readJsonFromURL(apiURL);
							String newInstagramToken = json.getString("access_token");

							// met à jour la configuration
							portletPreferences.setValue("instagramToken", newInstagramToken);
							portletPreferences.setValue("instagramCreateDate", today.format(formatter));
							portletPreferences.store();

							PortalCacheHelperUtil.getPortalCache(null, "instagram_cache").remove(instagramToken);
							PortalCacheHelperUtil.getPortalCache(null, "instagram_cache")
									.remove(instagramToken + "_last_update");
						} catch (Exception e) {
							log.error(e);
						}
					}
				}
			}
			log.info("Finish refresh token");
		};
	}

	@Reference(unbind = "-")
	protected void setSocialService(SocialService socialService) {
		_socialService = socialService;
	}
	private SocialService _socialService;
	private Log log = LogFactoryUtil.getLog(this.getClass());

}
