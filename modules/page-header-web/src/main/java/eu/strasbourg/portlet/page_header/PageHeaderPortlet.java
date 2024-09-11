package eu.strasbourg.portlet.page_header;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Supplier;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.page_header.configuration.PageHeaderConfiguration;

@Component(
	immediate = true,
	configurationPid = "eu.strasbourg.portlet.page_header.configuration.PageHeaderConfiguration",
	property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.css-class-wrapper=page-header-portlet",
		"com.liferay.portlet.header-portlet-css=/css/page-header-default-style.css",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + StrasbourgPortletKeys.PAGE_HEADER_WEB,
		"javax.portlet.init-param.view-template=/page-header-view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.version=3.0"},
	service = Portlet.class)
public class PageHeaderPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
		Layout layout = themeDisplay.getLayout();
		
		renderRequest.setAttribute("page", layout);

		String title = layout.getTitle(themeDisplay.getLocale());
		String subTitle = layout.getDescription(themeDisplay.getLocale());
		String imageUrl = layout.getExpandoBridge().getAttribute("image").toString();
		String imageCredit = "";

		try {
			PageHeaderConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(PageHeaderConfiguration.class, themeDisplay);

			imageCredit = getNonEmptyValue(configuration.imageCredit(), imageCredit);
			title = getNonEmptyValue(getLocalizationValue(configuration.titleXML(), themeDisplay.getLocale()), title);
			subTitle = getNonEmptyValue(getLocalizationValue(configuration.subTitleXML(), themeDisplay.getLocale()), subTitle);
			imageUrl = getNonEmptyValue(getLocalizationValue(configuration.imageUrlXML(), themeDisplay.getLocale()), imageUrl);

			renderRequest.setAttribute("imageCredit", imageCredit);
			renderRequest.setAttribute("title", title);
			renderRequest.setAttribute("subTitle", subTitle);
			renderRequest.setAttribute("imageUrl", imageUrl);

		} catch (ConfigurationException e) {
			_log.error(e);
		}
		
		// Application display templates stuff
		PortletPreferences preferences = renderRequest.getPreferences();
		String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", StringPool.BLANK));
		long displayStyleGroupId = GetterUtil.getLong(preferences.getValue("displayStyleGroupId", null), 0);
		Map<String, Object> contextObjects = new HashMap<String, Object>();
		contextObjects.put("imageCredit", imageCredit);
		contextObjects.put("title", title);
		contextObjects.put("subTitle", subTitle);
		contextObjects.put("imageUrl", imageUrl);
		contextObjects.put("page", layout);
		List<Layout> entries = new ArrayList<Layout>() ;
		renderRequest.setAttribute("displayStyle", displayStyle);
		renderRequest.setAttribute("displayStyleGroupId", displayStyleGroupId);
		renderRequest.setAttribute("contextObjects", contextObjects);
		renderRequest.setAttribute("entries", entries);
		
		super.render(renderRequest, renderResponse);
	}

	private String getNonEmptyValue(String configValue, String defaultValue) {
		return Validator.isNull(configValue)  ? defaultValue : configValue;
	}

	private String getLocalizationValue(String map, Locale locale) {
		Map<Locale, String> localizationMap = LocalizationUtil.getLocalizationMap(map);
		return localizationMap.get(locale);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}