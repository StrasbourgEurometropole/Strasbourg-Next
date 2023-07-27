package eu.strasbourg.portlet.notif.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.notif.constants.NotifConstants;
import eu.strasbourg.portlet.notif.util.NotificationsActionDropdownItemsProvider;
import eu.strasbourg.service.notif.model.NatureNotif;
import eu.strasbourg.service.notif.model.Notification;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.notif.service.NatureNotifLocalServiceUtil;
import eu.strasbourg.service.notif.service.NotificationLocalServiceUtil;
import eu.strasbourg.service.notif.service.ServiceNotifLocalServiceUtil;
import eu.strasbourg.utils.constants.RoleNames;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ViewNotificationsDisplayContext {


	public ViewNotificationsDisplayContext(RenderRequest request,
										   RenderResponse response,
										   String filter,
										   ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector = itemSelector;
		this.filter = filter;
	}
	/**
	 * Retourne le dropdownItemsProvider de Notification
	 *
	 */
	@SuppressWarnings("unused")
	public NotificationsActionDropdownItemsProvider getActionsNotification(Notification notification) {
		return new NotificationsActionDropdownItemsProvider(notification, _request,
				_response);
	}
	/**
	 * Retourne le searchContainer des notifications
	 *
	 */
	public SearchContainer<Notification> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/notif-bo-view-notifications.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab", "notifications")
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			_searchContainer.setOrderByColParam("orderByCol");
			_searchContainer.setOrderByTypeParam("orderByType");
			_searchContainer.setOrderByCol(getOrderByCol());
			_searchContainer.setOrderByType(getOrderByType());
			try {
				getHits();
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						int start = this._searchContainer.getStart();
						int end = this._searchContainer.getEnd();
						int total = this._searchContainer.getTotal();
						notifications = notifications.subList(start, end > total ? total : end);
						return notifications;
					}, notifications.size()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}

	/**
	 * Retourne les Hits de recherche pour un delta
	 */
	private void getHits() throws PortalException {
		if (this.notifications == null) {
			if (isAdminNotification())
				this.notifications = NotificationLocalServiceUtil.getNotifications(
						QueryUtil.ALL_POS,
						QueryUtil.ALL_POS);
			else {
				if (getServicesId().length > 0) {
					this.notifications = NotificationLocalServiceUtil.getByServiceIds(getServicesId());
				}
			}
		}
	}
	public String getOrderByType() {
		return ParamUtil.getString(_request, "orderByType", "desc");
	}


	/**
	 * Renvoie la colonne sur laquelle on fait le tri
	 */
	public String getOrderByCol() {
		return null;
	}

	/*@SuppressWarnings("unused")
	public List<Notification> getNotifications() throws PortalException {

		int countResults = 0;

		if (this.notifications == null) {
			if(isAdminNotification())
				this.notifications = NotificationLocalServiceUtil.getNotifications(
						this.getSearchContainer().getStart(),
						this.getSearchContainer().getEnd());
			else{
				if(getServicesId().length > 0) {
					this.notifications = NotificationLocalServiceUtil.getByServiceIds(getServicesId());
				}
			}

			countResults = ServiceNotifLocalServiceUtil.getServiceNotifs(-1, -1).size();
		}
		this.getSearchContainer().setTotal(countResults);
		return this.notifications;
	}*/

	@SuppressWarnings("unused")
	public List<Notification> getInProgressNotifications() {
		return NotificationLocalServiceUtil.getInProgressNotifications();
	}

	@SuppressWarnings("unused")
	public List<Notification> getToComeNotifications() {
		return NotificationLocalServiceUtil.getToComeNotifications();
	}

	@SuppressWarnings("unused")
	public List<Notification> getPastNotifications() {
		return NotificationLocalServiceUtil.getPastNotifications();
	}

	public long[] getServicesId() throws PortalException{
		if(Validator.isNull(this.serviceIds)) {
			long[] organisationIds = _themeDisplay.getUser().getOrganizationIds();
			if (organisationIds.length > 0) {
				List<ServiceNotif> services = ServiceNotifLocalServiceUtil.getByOrganisationIds(organisationIds);
				this.serviceIds = services.stream().mapToLong(ServiceNotif::getServiceId).toArray();
			}
		}
		return this.serviceIds;
	}

	@SuppressWarnings("unused")
	public boolean hasMultipleServices() throws PortalException{
		return getServicesId().length > 1;
	}

	@SuppressWarnings("unused")
	public String getService(long serviceId){
		ServiceNotif service = ServiceNotifLocalServiceUtil.fetchServiceNotif(serviceId);
		if(Validator.isNotNull(service))
			return service.getName();
		return "";
	}

	@SuppressWarnings("unused")
	public String getNature(long natureId){
		NatureNotif nature = NatureNotifLocalServiceUtil.fetchNatureNotif(natureId);
		if(Validator.isNotNull(nature))
			return nature.getName();
		return "";
	}

	@SuppressWarnings("unused")
	public boolean canUpdateOrDeleteNotification(long createUserId){
		if(isContribOnly()) {
			return this._themeDisplay.getUserId() == createUserId;
		}
		return true;
	}

	public boolean isAdminNotification(){
		try {

			Role siteAdministrator = RoleLocalServiceUtil.getRole(this._themeDisplay.getCompanyId(), RoleNames.ADMINISTRATEUR_NOTIFICATION);
			if(_themeDisplay.getPermissionChecker().isOmniadmin()
				|| UserGroupRoleLocalServiceUtil.hasUserGroupRole(_themeDisplay.getUserId(),_themeDisplay.getScopeGroupId(), siteAdministrator.getRoleId()))
				return true;
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return false;
	}


	public boolean isRespNotification(){
		try {
			Role  responsableNotification = RoleLocalServiceUtil.getRole(this._themeDisplay.getCompanyId(), RoleNames.RESPONSABLE_NOTIFICATION);
			return UserGroupRoleLocalServiceUtil.hasUserGroupRole(_themeDisplay.getUserId(),_themeDisplay.getScopeGroupId(), responsableNotification.getRoleId());
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return false;
	}


	public boolean isContribOnly(){
		try {
			if(isAdminNotification() ||isRespNotification())
				return false;

			Role contributorNotification = RoleLocalServiceUtil.getRole(this._themeDisplay.getCompanyId(), RoleNames.CONTRIBUTEUR_NOTIFICATION);
			return UserGroupRoleLocalServiceUtil.hasUserGroupRole(_themeDisplay.getUserId(),_themeDisplay.getScopeGroupId(), contributorNotification.getRoleId());
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return false;
	}
	/**
	 * Retourne les mots clés de recherche saisis
	 */
	@SuppressWarnings("unused")
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}
	@SuppressWarnings("unused")
	public String getFilter() {
		return filter;
	}

	@SuppressWarnings("unused")
	public String getALL() {
		return NotifConstants.ALL;
	}

	@SuppressWarnings("unused")
	public String getIN_PROGRESS() {
		return NotifConstants.IN_PROGRESS;
	}

	@SuppressWarnings("unused")
	public String getTO_COME() {
		return NotifConstants.TO_COME;
	}

	@SuppressWarnings("unused")
	public String getPAST() {
		return NotifConstants.PAST;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass());
	protected SearchContainer<Notification> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;
	private List<Notification> notifications;
	private String filter;
	private long[] serviceIds;
}
