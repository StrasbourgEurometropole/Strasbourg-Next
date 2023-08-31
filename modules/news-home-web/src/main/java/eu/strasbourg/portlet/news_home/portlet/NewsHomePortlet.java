package eu.strasbourg.portlet.news_home.portlet;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.news_home.constants.NewsHomePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import eu.strasbourg.portlet.news_home.context.NewsHomeDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author thomas.tse
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.header-portlet-css=/css/news-home.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Accueil Actualité",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.init-param.config-template=/configuration/news-home-configuration.jsp",
		"javax.portlet.name=" + StrasbourgPortletKeys.NEWSHOME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsHomePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		NewsHomeDisplayContext dc = new NewsHomeDisplayContext(request, response);

		request.setAttribute("dc", dc);

		super.render(request, response);

	}
}