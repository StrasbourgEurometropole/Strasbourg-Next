package eu.strasbourg.portlet.oidc;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.oidc.display.context.EditAnonymisationHistoricsDisplayContext;
import eu.strasbourg.portlet.oidc.display.context.EditPublikUserDisplayContext;
import eu.strasbourg.portlet.oidc.display.context.ManagementPublikUsersToolBarDisplayContext;
import eu.strasbourg.portlet.oidc.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.oidc.display.context.ViewAnonymisationHistoricsDisplayContext;
import eu.strasbourg.portlet.oidc.display.context.ViewPublikUsersDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static eu.strasbourg.portlet.oidc.constants.OidcConstants.*;

/**
 * @author cedric.henry
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.OIDC_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/oidc-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/oidc-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/oidc-bo-view-publikusers.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class OIDCBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();



		renderResponse.setTitle("Utilisateurs Publik");

		// Si on est sur la page d'ajout, on affiche un lien de retour
		String returnURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL);
		}
		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case PUBLIK_USERS:
					if (navigationDC.getSelectedCmd().equals(EDIT_PUBLIK_USER)) {
						EditPublikUserDisplayContext dc = new EditPublikUserDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewPublikUsersDisplayContext dc = new ViewPublikUsersDisplayContext(renderRequest, renderResponse);
						ManagementPublikUsersToolBarDisplayContext managementDC = new ManagementPublikUsersToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case ANONYMISATION_HISTORICS:
					if (navigationDC.getSelectedCmd().equals(EDIT_ANONYMISATION_HISTORIC)) {
						EditAnonymisationHistoricsDisplayContext dc = new EditAnonymisationHistoricsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewAnonymisationHistoricsDisplayContext dc = new ViewAnonymisationHistoricsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}


		// Admin ou pas
		renderRequest.setAttribute("isAdmin", themeDisplay.getPermissionChecker().isOmniadmin());

		super.render(renderRequest, renderResponse);
	}

}

