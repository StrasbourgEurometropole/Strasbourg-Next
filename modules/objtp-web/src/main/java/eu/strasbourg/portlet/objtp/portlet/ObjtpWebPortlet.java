package eu.strasbourg.portlet.objtp.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.objtp.configuration.ObjtpConfiguration;
import eu.strasbourg.portlet.objtp.portlet.context.ObjtpDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

/**
 * @author Jérémy Zwickert
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Objets trouves",
		"javax.portlet.init-param.add-process-action-success-action=false", "javax.portlet.init-param.template-path=/",
		"javax.portlet.name=" + StrasbourgPortletKeys.OBJTP_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ObjtpWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
			// Get the theme display object from render request
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// Get the portlet instance configuration for ObjtpConfiguration class
			ObjtpConfiguration configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(ObjtpConfiguration.class);

			// Get and validate the title, URL for declaring lost, URL for guide how to, and category codes
			String title = validateString(configuration.title());
			String urlDeclareLost = validateString(configuration.urlDeclareLost());
			String urlGuideHowTo = validateString(configuration.urlGuideHowTo());
			String categoryCodes = validateString(configuration.categoryCodes());

			// Create an ObjtpDisplayContext object with necessary parameters
			ObjtpDisplayContext dc = new ObjtpDisplayContext(renderRequest, renderResponse, categoryCodes);

			// Set the display context and title as attributes in the render request
			renderRequest.setAttribute("dc", dc);
			renderRequest.setAttribute("title", title);
			renderRequest.setAttribute("urlDeclareLost", urlDeclareLost);
			renderRequest.setAttribute("urlGuideHowTo", urlGuideHowTo);

			// Include the JSP file for rendering
			include("/objtp-view.jsp", renderRequest, renderResponse);

		} catch (Exception e) {
			// Log any exceptions that occur
			_log.error(e);
		}
	}

	// Helper method to validate and handle null strings
	private String validateString(String input) {
		return Validator.isNull(input) ? "" : input;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}