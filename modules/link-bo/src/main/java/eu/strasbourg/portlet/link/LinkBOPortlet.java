package eu.strasbourg.portlet.link;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.portlet.link.display.context.ManagementLinksToolBarDisplayContext;
import eu.strasbourg.portlet.link.display.context.NavigationBarDisplayContext;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import static eu.strasbourg.portlet.link.constants.LinkConstants.*;
import eu.strasbourg.portlet.link.display.context.EditLinkDisplayContext;
import eu.strasbourg.portlet.link.display.context.ViewLinksDisplayContext;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/link-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/link-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/link-bo-view-links.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LinkBOPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case LINKS:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_LINK) || navigationDC.getSelectedCmd().equals(SAVE_LINK)) {
						EditLinkDisplayContext dc = new EditLinkDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewLinksDisplayContext dc = new ViewLinksDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementLinksToolBarDisplayContext managementDC = new ManagementLinksToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		renderResponse.setTitle("Liens");

		// Si on est sur la page d'ajout, on affiche une lien de retour
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL.toString());
		}



		super.render(renderRequest, renderResponse);
	}
	@Reference
	private ItemSelector _itemSelector;
}

