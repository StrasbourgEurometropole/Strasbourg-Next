package eu.strasbourg.portlet.help;

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
import eu.strasbourg.portlet.help.constants.HelpBOConstants;
import eu.strasbourg.portlet.help.context.*;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.help.constants.HelpBOConstants.*;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author angelique.champougny
 */
@Component(
	immediate = true,
		property = {
			"javax.portlet.version=3.0",
				"javax.portlet.name=" + StrasbourgPortletKeys.HELP_BO,
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.footer-portlet-javascript=/js/help-bo-main.js",
			"com.liferay.portlet.header-portlet-css=/css/help-bo-main.css",
			"com.liferay.portlet.single-page-application=false",
				"javax.portlet.init-param.template-path=/META-INF/resources/",
				"javax.portlet.init-param.view-template=/help-bo-view-help-proposals.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
	service = Portlet.class
)
public class HelpBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
					   RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();


		String title = HelpBOConstants.HEADER_TITLE;

		// Si on est sur la page d'ajout, on affiche un lien de retour
		String backUrl = ParamUtil.getString(renderRequest, HelpBOConstants.PARAM_RETURN_URL);
		boolean showBackButton = Validator.isNotNull(backUrl);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backUrl);
			renderRequest.setAttribute(HelpBOConstants.PARAM_RETURN_URL, backUrl);
		}


		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case HELP_PROPOSALS:
					if (navigationDC.getSelectedCmd().equals(EDIT_HELP_PROPOSAL)) {
						EditHelpProposalDisplayContext dc = new EditHelpProposalDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else if (navigationDC.getSelectedCmd().equals(PROPOSAL_HELP_REQUESTS) ) {
						ViewProposalHelpRequestsDisplayContext dc = new ViewProposalHelpRequestsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);

					}/*else if(navigationDC.getSelectedCmd().equals(READ_HELP_PROPOSAL)){

					}*/
					else {
						ViewHelpProposalsDisplayContext dc = new ViewHelpProposalsDisplayContext(renderRequest, renderResponse);
						ManagementHelpProposalsToolBarDisplayContext managementDC = new ManagementHelpProposalsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case HELP_REQUESTS:
					if (navigationDC.getSelectedCmd().equals(EDIT_HELP_REQUEST)) {
						EditHelpRequestDisplayContext dc = new EditHelpRequestDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewHelpRequestsDisplayContext dc = new ViewHelpRequestsDisplayContext(renderRequest, renderResponse);
						ManagementHelpRequestsToolBarDisplayContext managementDC = new ManagementHelpRequestsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;

				case HELP_SEEKERS:
					/*if(navigationDC.getSelectedCmd().equals(EDIT_HELP_PROPOSAL)){
						ViewSeekerHelpRequestsDisplayContext dc = new ViewSeekerHelpRequestsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					else*/ if(navigationDC.getSelectedCmd().equals(SEEKER_HELP_REQUESTS)) {
						ViewSeekerHelpRequestsDisplayContext dc = new ViewSeekerHelpRequestsDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					else {
						ViewHelpSeekersDisplayContext dc = new ViewHelpSeekersDisplayContext(renderRequest, renderResponse);
						ManagementHelpSeekersToolBarDisplayContext managementDC = new ManagementHelpSeekersToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
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