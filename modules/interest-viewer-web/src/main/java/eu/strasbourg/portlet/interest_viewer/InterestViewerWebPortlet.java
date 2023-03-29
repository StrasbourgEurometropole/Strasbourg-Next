package eu.strasbourg.portlet.interest_viewer;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.interest_viewer.configuration.InterestViewerConfiguration;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=false", "com.liferay.portlet.required-namespaced-parameters=false",
		"javax.portlet.display-name=Mes actus et mon agenda", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/interest-viewer-view.jsp",
		"javax.portlet.init-param.config-template=/configuration/interest-viewer-configuration.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.INTEREST_VIEWER_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class InterestViewerWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			InterestViewerConfiguration configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(InterestViewerConfiguration.class);

			// récupère le type d'affichage
			String template = configuration.template();
			if (Validator.isNull(template)) {
				template = "liste";
			}
			

			InterestViewerDisplayContext dc = new InterestViewerDisplayContext(themeDisplay, request);

			request.setAttribute("dc", dc);
			
			// titre personnalisable en mode widget
			request.setAttribute("title", PortletHelper.getPortletTitle("actu-agenda", request));

			include("/templates/" + template + ".jsp", request, response);
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}