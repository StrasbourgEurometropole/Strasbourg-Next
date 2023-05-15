package eu.strasbourg.portlet.edition;

import java.io.IOException;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.portlet.edition.display.context.*;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.edition.constants.EditionConstants.*;


@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/edition-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/edition-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/edition-bo-view-editions.jsp",

		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class EditionBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws  IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case GALERIES:
					if (navigationDC.getSelectedCmd().equals(EDIT_GALERIE) || navigationDC.getSelectedCmd().equals(SAVE_GALERIE)) {
						EditGalleryDisplayContext dc = new EditGalleryDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewGalleriesDisplayContext dc = new ViewGalleriesDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementGalleriesToolBarDisplayContext managementDC=new ManagementGalleriesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case EDITIONS:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_EDITION) || navigationDC.getSelectedCmd().equals(SAVE_EDITION)) {
						EditEditionDisplayContext dc = new EditEditionDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewEditionsDisplayContext dc = new ViewEditionsDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementEditionsToolBarDisplayContext managementDC=new ManagementEditionsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				}
			}catch (PortalException e) {
			e.printStackTrace();
		}

		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		renderResponse.setTitle("Editions");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String returnURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL.toString());
		}
		super.render(renderRequest, renderResponse);
	}
	@Reference
	private ItemSelector _itemSelector;

}