package eu.strasbourg.portlet.artwork;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.artwork.display.context.EditArtworkDisplayContext;
import eu.strasbourg.portlet.artwork.display.context.EditCollectionDisplayContext;
import eu.strasbourg.portlet.artwork.display.context.ViewArtworksDisplayContext;
import eu.strasbourg.portlet.artwork.display.context.ViewCollectionsDisplayContext;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/artwork-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/artwork-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/artwork-bo-view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ArtworkBOPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		String cmd = ParamUtil.getString(renderRequest, "cmd");
		String tab = ParamUtil.getString(renderRequest, "tab");
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		
		renderResponse.setTitle("Oeuvres");
		
		// Si on est sur la page d'ajout, on affiche une lien de retour
		String returnURL = ParamUtil.getString(renderRequest, "returnURL");
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL.toString());
		}
		
		// On set le displayContext selon la page sur laquelle on est
		if (cmd.equals("editArtwork")|| mvcPath.equals("/artwork-bo-edit-artwork.jsp")) {
			EditArtworkDisplayContext dc = new EditArtworkDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("editCollection")|| mvcPath.equals("/artwork-bo-edit-collection.jsp")) {
			EditCollectionDisplayContext dc = new EditCollectionDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else if (tab.equals("collections")) {
			ViewCollectionsDisplayContext dc = new ViewCollectionsDisplayContext(renderRequest, renderResponse); 
			renderRequest.setAttribute("dc", dc);			
		} else { // Else, we are on the artwork list page
			ViewArtworksDisplayContext dc = new ViewArtworksDisplayContext(renderRequest, renderResponse); 
			renderRequest.setAttribute("dc", dc);
		}
		
		super.render(renderRequest, renderResponse);
	}	
	
}