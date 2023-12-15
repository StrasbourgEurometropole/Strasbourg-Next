package eu.strasbourg.portlet.userdisplay;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.userdisplay.configuration.UserDisplayConfiguration;
import eu.strasbourg.portlet.userdisplay.configuration.UserDisplayConfigurationDisplayContext;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author romain.vergnais
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg", "com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.instanceable=false", "javax.portlet.display-name=Personnalisation utilisateur",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/user-display-view.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.USER_DISPLAY, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UserDisplayPortlet extends MVCPortlet {

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

	@Override
	public void render(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			UserDisplayConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(UserDisplayConfiguration.class, themeDisplay);
			UserDisplayConfigurationDisplayContext dc  =
					new UserDisplayConfigurationDisplayContext(themeDisplay, configuration);

			request.setAttribute("dc", dc);
		} catch (Exception e) {
			_log.error(e);
		}
		super.render(request, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String resourceID = resourceRequest.getResourceID();
            HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
            String portletId = ParamUtil.getString(resourceRequest, "portletId");

			if (resourceID.equals("hidePortlet")) {
                PortletHelper.hidePortlet(portletId);
			} else if (resourceID.equals("showPortlet")) {
                PortletHelper.showPortlet(portletId);
            }
		} catch (Exception e) {
			_log.error(e);
		}

		super.serveResource(resourceRequest, resourceResponse);
	}

}