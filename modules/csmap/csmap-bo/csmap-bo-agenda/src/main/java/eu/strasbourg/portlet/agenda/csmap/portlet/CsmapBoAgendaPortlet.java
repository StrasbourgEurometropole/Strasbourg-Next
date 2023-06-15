package eu.strasbourg.portlet.agenda.csmap.portlet;

import com.liferay.item.selector.ItemSelector;
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
import eu.strasbourg.portlet.agenda.csmap.display.context.*;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.agenda.csmap.constants.CsmapBoAgendaConstants.*;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author quentin.mayer
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.version=3.0",
			"com.liferay.portlet.instanceable=false",
			"com.liferay.portlet.layout-cacheable=true",
			"javax.portlet.display-name=CsmapBoAgenda",
			"com.liferay.portlet.single-page-application=false",
			"javax.portlet.name=" + StrasbourgPortletKeys.CSMAP_BO_AGENDA,
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/csmap-bo-agenda-edit-principal.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsmapBoAgendaPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		renderResponse.setTitle("CSmapAgendaCategories");
		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case AGENDA_PRINCIPAL: {
					EditCsmapPrincipalAgendaDisplayContext dc = new EditCsmapPrincipalAgendaDisplayContext();
					renderRequest.setAttribute("dc", dc);
					break;
				}
				case AGENDA_THEMATIQUES: {
					if (navigationDC.getSelectedCmd().equals(EDIT_AGENDA_THEMATIQUE) || navigationDC.getSelectedCmd().equals(SAVE_AGENDA_THEMATIQUE)) {
						EditCsmapThematiqueAgendaDisplayContext dc = new EditCsmapThematiqueAgendaDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewCsmapAgendaThematiqueDisplayContext dc = new ViewCsmapAgendaThematiqueDisplayContext(renderRequest, renderResponse, _itemSelector);
						renderRequest.setAttribute("dc", dc);
						ManagementCsmapThematiqueAgendaToolBarDisplayContext managementDC= new ManagementCsmapThematiqueAgendaToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("managementDC", managementDC);

					}
					break;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}


		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL);
		}


		// Admin ou pas
		renderRequest.setAttribute("isAdmin", themeDisplay.getPermissionChecker().isOmniadmin());

		super.render(renderRequest, renderResponse);
	}
	@Reference
	private ItemSelector _itemSelector;
}