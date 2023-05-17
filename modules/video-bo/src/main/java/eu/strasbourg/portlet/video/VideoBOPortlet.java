package eu.strasbourg.portlet.video;

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
import eu.strasbourg.portlet.video.display.context.*;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import static eu.strasbourg.portlet.video.constants.VideoConstants.*;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/video-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/video-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/video-bo-view-videos.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)

public class VideoBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
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
				case VIDEOS:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_VIDEO) || navigationDC.getSelectedCmd().equals(SAVE_VIDEO)) {
						EditVideoDisplayContext dc = new EditVideoDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewVideosDisplayContext dc = new ViewVideosDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementVideosToolBarDisplayContext managementDC=new ManagementVideosToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
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

		String cmd = ParamUtil.getString(renderRequest, "cmd");
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");

		renderResponse.setTitle("Videos");

		// On affiche un bouton retour si on se trouve sur une page d'édition
		String returnURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL);
		}

		// On set le displayContext selon la page sur laquelle on se trouve
		if (cmd.equals("editVideo") || mvcPath.equals("/video-bo-edit-video.jsp")) {
			EditVideoDisplayContext dc = new EditVideoDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("editGallery") || mvcPath.equals("/video-bo-edit-gallery.jsp")) {
			EditGalleryDisplayContext dc = new EditGalleryDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else { // Else, we are on the video list page
			ViewVideosDisplayContext dc = new ViewVideosDisplayContext(
				renderRequest, renderResponse,_itemSelector);
			renderRequest.setAttribute("dc", dc);
		}

		super.render(renderRequest, renderResponse);

	}
	private ItemSelector _itemSelector;
}