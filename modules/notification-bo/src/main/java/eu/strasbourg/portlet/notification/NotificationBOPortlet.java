package eu.strasbourg.portlet.notification;

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
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.portlet.notification.display.context.ManagementNotificationsToolBarDisplayContext;
import eu.strasbourg.portlet.notification.display.context.NavigationBarDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import static eu.strasbourg.portlet.notification.constants.NotificationConstants.*;
import eu.strasbourg.portlet.notification.display.context.EditNotificationDisplayContext;
import eu.strasbourg.portlet.notification.display.context.ViewNotificationsDisplayContext;
import org.osgi.service.component.annotations.Reference;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.NOTIFICATION_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.header-portlet-css=/css/notification-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/notification-bo-view-notifications.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class NotificationBOPortlet extends MVCPortlet {

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

				case NOTIFICATIONS: {
					if (navigationDC.getSelectedCmd().equals(EDIT_NOTIFICATION) || navigationDC.getSelectedCmd().equals(SAVE_NOTIFICATION)) {
						EditNotificationDisplayContext dc = new EditNotificationDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse);
						ManagementNotificationsToolBarDisplayContext managementDC = new ManagementNotificationsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
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
			portletDisplay.setURLBack(backURL.toString());
		}

		super.render(renderRequest, renderResponse);
	}
}