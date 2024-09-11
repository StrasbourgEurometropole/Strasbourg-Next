package eu.strasbourg.portlet.notification.display.context;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import eu.strasbourg.portlet.notification.util.NotificationsActionDropdownItemsProvider;
import eu.strasbourg.service.notification.model.Notification;
import eu.strasbourg.service.notification.service.NotificationLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

public class ViewNotificationsDisplayContext extends ViewBaseDisplayContext<Notification> {
	
	public ViewNotificationsDisplayContext(RenderRequest request,RenderResponse response) {
		super(request, response, Notification.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
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
	@Override
	public SearchContainer<Notification> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/notification-bo-view-notifications.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
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
						_notifications = _notifications.subList(start, end > total ? total : end);
						return _notifications;
					}, _notifications.size()
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
		if (this._notifications == null) {
			this._notifications = NotificationLocalServiceUtil.getNotifications(-1, -1).stream()
					.filter(n -> !n.isSingleUser())
					.collect(Collectors.toList());
		}
	}


	/**
	 * Renvoie la colonne sur laquelle on fait le tri
	 */
	@Override
	public String getOrderByCol() {
		return ParamUtil.getString(this._request, "orderByCol",
			"publication-date");
	}

	/**
	 * Renvoie le nom de la colonne sur laquelle on fait le tri pour
	 * ElasticSearch
	 */
	@Override
	public String getOrderByColSearchField() {
		switch (this.getOrderByCol()) {
		case "title":
		case "alias":
			return "localized_title_fr_FR_sortable";
		case "publication-date":
			return "publishDate_sortable";
		case "status":
			return "status_sortable";
		default:
			return "publishDate_sortable";
		}
	}

	protected SearchContainer<Notification> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private List<Notification> _notifications;

}
