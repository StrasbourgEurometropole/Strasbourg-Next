package eu.strasbourg.portlet.gtfs;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.gtfs.display.context.*;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static eu.strasbourg.portlet.gtfs.constants.GtfsConstants.*;

/**
 * @author cedric.henry
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.GTFS_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/gtfs-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/gtfs-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/gtfs-bo-view-arrets.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GTFSBOPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		
		// Recuperation des données de la requete de page
		String cmd = ParamUtil.getString(renderRequest, "cmd");

		String title = PortalUtil.getPortletTitle(renderRequest);
		
		// Si on est sur la page d'ajout, on affiche un lien de retour
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL.toString());
		}

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case IMPORT_HISTORICS:
					if (navigationDC.getSelectedCmd().equals(EDIT_IMPORT_HISTORIC)) {
						EditImportHistoricDisplayContext  dc = new EditImportHistoricDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewImportHistoricsDisplayContext dc = new ViewImportHistoricsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				case ARRETS:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_ARRET) || navigationDC.getSelectedCmd().equals(SAVE_ARRET)) {
						EditArretDisplayContext dc = new EditArretDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewArretsDisplayContext dc = new ViewArretsDisplayContext(renderRequest, renderResponse);
						ManagementArretsToolBarDisplayContext managementDC = new ManagementArretsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		// Admin ou pas
		renderRequest.setAttribute("isAdmin", themeDisplay.getPermissionChecker().isOmniadmin());
		
		super.render(renderRequest, renderResponse);
		
		title = LanguageUtil.get(PortalUtil.getHttpServletRequest(renderRequest), title);
		renderResponse.setTitle(title);
	}
}