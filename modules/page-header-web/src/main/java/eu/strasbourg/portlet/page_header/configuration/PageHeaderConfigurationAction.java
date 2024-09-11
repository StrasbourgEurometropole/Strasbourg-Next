package eu.strasbourg.portlet.page_header.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.settings.LocalizedValuesMap;
import com.liferay.portal.kernel.util.LocalizationUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

@Component(
	configurationPid = "eu.strasbourg.portlet.page_header.configuration.PageHeaderConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	immediate = true,
	property = {
		"javax.portlet.name=eu_strasbourg_portlet_page_header_PageHeaderPortlet" },
	service = ConfigurationAction.class)
public class PageHeaderConfigurationAction extends DefaultConfigurationAction {

	@Override
	public String getJspPath(HttpServletRequest request) {
		return "/page-header-configuration.jsp";
	}

	@Override
	public void processAction(PortletConfig portletConfig,
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String imageCredit = ParamUtil.getString(actionRequest, "imageCredit");
		setPreference(actionRequest, "imageCredit", imageCredit);

		Map<Locale, String> titleMap = LocalizationUtil
				.getLocalizationMap(actionRequest, "titleMap");
		LocalizedValuesMap mapTitle = new LocalizedValuesMap();
		for (Map.Entry<Locale, String> e : titleMap.entrySet()) {
			mapTitle.put(e.getKey(), e.getValue());
		}
		String titleXML = LocalizationUtil.getXml(mapTitle, "title");
		setPreference(actionRequest, "titleXML", titleXML);

		Map<Locale, String> subTitleMap = LocalizationUtil
				.getLocalizationMap(actionRequest, "subTitleMap");
		LocalizedValuesMap mapSubTitle = new LocalizedValuesMap();
		for (Map.Entry<Locale, String> e : subTitleMap.entrySet()) {
			mapSubTitle.put(e.getKey(), e.getValue());
		}
		String subTitleXML = LocalizationUtil.getXml(mapSubTitle, "subTitle");
		setPreference(actionRequest, "subTitleXML", subTitleXML);

		Map<Locale, String> imageUrlMap = LocalizationUtil
				.getLocalizationMap(actionRequest, "imageUrlMap");
		LocalizedValuesMap mapImageUrl = new LocalizedValuesMap();
		for (Map.Entry<Locale, String> e : imageUrlMap.entrySet()) {
			mapImageUrl.put(e.getKey(), e.getValue());
		}
		String imageUrlXML = LocalizationUtil.getXml(mapImageUrl, "imageUrl");
		setPreference(actionRequest, "imageUrlXML", imageUrlXML);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
			String portletResource = ParamUtil.getString(request,
			    "portletResource");
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);

			PageHeaderConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(PageHeaderConfiguration.class, themeDisplay);

			request.setAttribute("imageCredit", ParamUtil.getString(
				request, "imageCredit", configuration.imageCredit()));

			request.setAttribute("title", configuration.titleXML());

			request.setAttribute("subTitle", configuration.subTitleXML());

			request.setAttribute("imageUrl", configuration.imageUrlXML());

			// Tout ce qui est Application Display Template
			String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", StringPool.BLANK));
			long displayStyleGroupId = GetterUtil.getLong(preferences.getValue("displayStyleGroupId", null), 0);
			String refreshURL = PortalUtil.getCurrentURL(request);
			request.setAttribute("displayStyle", displayStyle);
			request.setAttribute("displayStyleGroupId", displayStyleGroupId);
			request.setAttribute("refreshURL", refreshURL);
			
			super.include(portletConfig, request, response);
		} catch (ConfigurationException e) {
			_log.error(e);
		}
	}
	
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
