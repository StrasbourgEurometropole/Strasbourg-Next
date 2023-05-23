package eu.strasbourg.portlet.official;

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
import eu.strasbourg.portlet.official.display.context.ManagementLOfficialsToolBarDisplayContext;
import eu.strasbourg.portlet.official.display.context.NavigationBarDisplayContext;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import static eu.strasbourg.portlet.official.constants.OfficialConstants.*;

import eu.strasbourg.portlet.official.display.context.EditOfficialDisplayContext;
import eu.strasbourg.portlet.official.display.context.ViewOfficialsDisplayContext;
import org.osgi.service.component.annotations.Reference;


@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/official-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/official-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/official-bo-view-officials.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class OfficialBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case OFFICIALS:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_OFFICIAL) || navigationDC.getSelectedCmd().equals(SAVE_OFFICIAL)) {
						EditOfficialDisplayContext dc = new EditOfficialDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewOfficialsDisplayContext dc = new ViewOfficialsDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementLOfficialsToolBarDisplayContext managementDC = new ManagementLOfficialsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}


		renderResponse.setTitle("Officials");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
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