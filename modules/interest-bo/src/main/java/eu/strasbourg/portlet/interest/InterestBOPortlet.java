package eu.strasbourg.portlet.interest;

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
import eu.strasbourg.portlet.interest.display.context.EditInterestDisplayContext;
import eu.strasbourg.portlet.interest.display.context.ManagementInterestsToolBarDisplayContext;
import eu.strasbourg.portlet.interest.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.interest.display.context.ViewInterestsDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static eu.strasbourg.portlet.interest.constants.InterestConstants.*;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.INTEREST_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/interest-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/interest-bo-view-interests.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class InterestBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();


		String tab = ParamUtil.getString(renderRequest, "tab");
		
		renderResponse.setTitle("interests");

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
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

				case INTERESTS:
					if (navigationDC.getSelectedCmd().equals(EDIT_INTEREST) || navigationDC.getSelectedCmd().equals(SAVE_INTEREST)) {
						EditInterestDisplayContext dc = new EditInterestDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewInterestsDisplayContext dc = new ViewInterestsDisplayContext(renderRequest, renderResponse);
						ManagementInterestsToolBarDisplayContext managementDC = new ManagementInterestsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		super.render(renderRequest, renderResponse);
	}
}