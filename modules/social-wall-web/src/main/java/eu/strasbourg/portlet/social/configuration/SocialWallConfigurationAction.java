package eu.strasbourg.portlet.social.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.cache.PortalCacheHelperUtil;
import com.liferay.portal.kernel.cache.PortalCacheManagerNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	configurationPid = "eu.strasbourg.portlet.social.configuration.SocialWallConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.SOCIAL_WALL_WEB },
	service = ConfigurationAction.class)
public class SocialWallConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String twitterAccount = ParamUtil.getString(actionRequest, "twitterAccount");
		setPreference(actionRequest, "twitterAccount", twitterAccount);

		String instagramCreateDate = ParamUtil.getString(actionRequest, "instagramCreateDate");
		setPreference(actionRequest, "instagramCreateDate", instagramCreateDate);

		String instagramToken = ParamUtil.getString(actionRequest, "instagramToken");
		setPreference(actionRequest, "instagramToken", instagramToken);

		String dailymotionAccountId = ParamUtil.getString(actionRequest, "dailymotionAccountId");
		setPreference(actionRequest, "dailymotionAccountId", dailymotionAccountId);

		String facebookToken = ParamUtil.getString(actionRequest, "facebookToken");
		setPreference(actionRequest, "facebookToken", facebookToken);

		String postCount = ParamUtil.getString(actionRequest, "postCount");
		setPreference(actionRequest, "postCount", postCount);
		
		String template = ParamUtil.getString(actionRequest,  "template");
		setPreference(actionRequest, "template", template);

		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
				"twitter_cache").remove(twitterAccount);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
						"twitter_cache").remove(twitterAccount + "_last_update");
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
				"dailymotion_cache").remove(dailymotionAccountId);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
						"dailymotion_cache").remove(dailymotionAccountId + "_last_update");
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
				"instagram_cache").remove(instagramToken);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
						"instagram_cache").remove(instagramToken + "_last_update");
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
				"facebook_cache").remove(facebookToken);

		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
						"facebook_cache").remove(facebookToken + "_last_update");
		

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

			SocialWallConfiguration configuration = themeDisplay
				.getPortletDisplay()
				.getPortletInstanceConfiguration(SocialWallConfiguration.class);

			request.setAttribute("twitterAccount", configuration.twitterAccount());
			request.setAttribute("instagramToken", configuration.instagramToken());
			request.setAttribute("instagramCreateDate", configuration.instagramCreateDate());
			request.setAttribute("dailymotionAccountId", configuration.dailymotionAccountId());
			request.setAttribute("facebookToken", configuration.facebookToken());
			request.setAttribute("postCount", configuration.postCount());
			request.setAttribute("template", configuration.template());

			super.include(portletConfig, request, response);
		} catch (ConfigurationException e) {
			_log.error(e);
		}
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
