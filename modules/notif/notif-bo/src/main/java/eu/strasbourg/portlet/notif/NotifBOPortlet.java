package eu.strasbourg.portlet.notif;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.notif.constants.NotifConstants;
import eu.strasbourg.portlet.notif.display.context.*;
import eu.strasbourg.service.notif.model.Message;
import eu.strasbourg.service.notif.model.NatureNotif;
import eu.strasbourg.service.notif.model.Notification;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.notif.service.MessageLocalService;
import eu.strasbourg.service.notif.service.NatureNotifLocalService;
import eu.strasbourg.service.notif.service.NotificationLocalService;
import eu.strasbourg.service.notif.service.ServiceNotifLocalService;
import eu.strasbourg.utils.constants.RoleNames;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static eu.strasbourg.portlet.notif.constants.NotifConstants.*;
/**
 * @author angelique.champougny
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-css=/css/notif-bo-main.css",
		"com.liferay.portlet.footer-portlet-javascript=/js/notif-bo-main.js",
		"com.liferay.portlet.layout-cacheable=true",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/notification-bo-view-services.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NotifBOPortlet extends MVCPortlet {
	private ThemeDisplay themeDisplay;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		this.themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();



		// Verification des requetes issues d'un champ repetable
		Boolean fromAjaxNature = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxNature"));
		Boolean fromAjaxMessage = GetterUtil.getBoolean(renderRequest.getAttribute("fromAjaxMessage"));

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case NOTIFICATIONS: {
					switch (navigationDC.getSelectedCmd().equals(EDIT_NOTIFICATION)) {
						long notificationId = ParamUtil.getLong(renderRequest, "notificationId");
						Notification notification = null;
						if (notificationId > 0) {
							notification = _notificationLocalService.fetchNotification(notificationId);
						}
						List<ServiceNotif> services = new ArrayList<>();
						try {
							long[] organisationIds = themeDisplay.getUser().getOrganizationIds();
							if(Validator.isNotNull(organisationIds) && organisationIds.length > 0)
								services = _serviceNotifLocalService.getByOrganisationIds(organisationIds);
						} catch (PortalException e) {
							e.printStackTrace();
						}
						List<NatureNotif> natures = _natureNotifLocalService.getNatureNotifs(-1, -1);
						List<Message> messages = _messageLocalService.getMessages(-1, -1);

						EditNotificationDisplayContext dc = new EditNotificationDisplayContext(renderRequest, notification, services,
								natures, messages);
						renderRequest.setAttribute("dc", dc);
					} else {

						ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse,_itemSelector);
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}


		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String returnURL = ParamUtil.getString(renderRequest, "returnURL");
		HttpServletRequest originalRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpSession session = originalRequest.getSession();
		boolean showBackButton = Validator.isNotNull(returnURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(returnURL);
		}
		// If we are on the Session, we add the corresponding
		// display context
	/*	if (cmd.equals("editService") || mvcPath.equals("/notif-bo-edit-service.jsp") || fromAjaxNature || fromAjaxMessage) {
			long serviceId = ParamUtil.getLong(renderRequest, "serviceId");
			ServiceNotif service = null;
			List<NatureNotif> natures = new ArrayList<>();
			List<Message> messages = new ArrayList<>();
			if (serviceId > 0) {
				service = _serviceNotifLocalService.fetchServiceNotif(serviceId);
				natures = _natureNotifLocalService.getByServiceId(service.getServiceId());
				messages = _messageLocalService.getByServiceId(service.getServiceId());
			}

			EditServiceDisplayContext dc = new EditServiceDisplayContext(renderRequest, service, natures, messages);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("editNotification") || mvcPath.equals("/notif-bo-edit-notification.jsp")) {
			long notificationId = ParamUtil.getLong(renderRequest, "notificationId");
			Notification notification = null;
			if (notificationId > 0) {
				notification = _notificationLocalService.fetchNotification(notificationId);
			}
			List<ServiceNotif> services = new ArrayList<>();
			try {
				long[] organisationIds = themeDisplay.getUser().getOrganizationIds();
				if(Validator.isNotNull(organisationIds) && organisationIds.length > 0)
					services = _serviceNotifLocalService.getByOrganisationIds(organisationIds);
			} catch (PortalException e) {
				e.printStackTrace();
			}
			List<NatureNotif> natures = _natureNotifLocalService.getNatureNotifs(-1, -1);
			List<Message> messages = _messageLocalService.getMessages(-1, -1);

			EditNotificationDisplayContext dc = new EditNotificationDisplayContext(renderRequest, notification, services,
					natures, messages);
			renderRequest.setAttribute("dc", dc);

		} else if (cmd.equals("notificationsByInProgress")) {
			ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse, NotifConstants.IN_PROGRESS);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("notificationsByToCome")) {
			ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse, NotifConstants.TO_COME);
			renderRequest.setAttribute("dc", dc);
		} else if (cmd.equals("notificationsByPast")) {
			ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse, NotifConstants.PAST);
			renderRequest.setAttribute("dc", dc);
		} else if (tab.equals("notifications") || !this.isAdminNotification()) {
			ViewNotificationsDisplayContext dc = new ViewNotificationsDisplayContext(renderRequest, renderResponse, NotifConstants.ALL);
			renderRequest.setAttribute("dc", dc);
		} else {
			ViewServicesDisplayContext dc = new ViewServicesDisplayContext(
					renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		}*/

		// Admin Notif ou pas
		renderRequest.setAttribute("isAdminNotification", this.isAdminNotification());

		super.render(renderRequest, renderResponse);
	}

	public boolean isAdminNotification(){
		try {
			Role siteAdministrator = _roleLocalService.getRole(this.themeDisplay.getCompanyId(), RoleNames.ADMINISTRATEUR_NOTIFICATION);
			if(themeDisplay.getPermissionChecker().isOmniadmin()
					|| _userGroupRoleLocalService.hasUserGroupRole(themeDisplay.getUserId(),themeDisplay.getScopeGroupId(), siteAdministrator.getRoleId()))
				return true;
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return false;
	}

	private NotificationLocalService _notificationLocalService;

	@Reference(unbind = "-")
	protected void setNotificationLocalService(NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}

	private ServiceNotifLocalService _serviceNotifLocalService;

	@Reference(unbind = "-")
	protected void setServiceNotifLocalService(ServiceNotifLocalService serviceNotifLocalService) {
		_serviceNotifLocalService = serviceNotifLocalService;
	}

	private NatureNotifLocalService _natureNotifLocalService;

	@Reference(unbind = "-")
	protected void setNatureNotifLocalService(NatureNotifLocalService natureNotifLocalService) {
		_natureNotifLocalService = natureNotifLocalService;
	}

	private MessageLocalService _messageLocalService;

	@Reference(unbind = "-")
	protected void setMessageLocalService(MessageLocalService messageLocalService) {
		_messageLocalService = messageLocalService;
	}

	private RoleLocalService _roleLocalService;

	@Reference(unbind = "-")
	protected void setRoleLocalService(RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}

	private UserGroupRoleLocalService _userGroupRoleLocalService;

	@Reference(unbind = "-")
	protected void setUserGroupRoleLocalService(UserGroupRoleLocalService userGroupRoleLocalService) {
		_userGroupRoleLocalService = userGroupRoleLocalService;
	}
	@Reference
	private ItemSelector _itemSelector;
}