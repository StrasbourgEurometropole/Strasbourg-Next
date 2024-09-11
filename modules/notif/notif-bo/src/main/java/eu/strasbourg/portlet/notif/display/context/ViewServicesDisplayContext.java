package eu.strasbourg.portlet.notif.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.notif.util.ServicesActionDropdownItemsProvider;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.notif.service.ServiceNotifLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class ViewServicesDisplayContext extends ViewBaseDisplayContext<ServiceNotif> {


	public ViewServicesDisplayContext(RenderRequest request,
									  RenderResponse response) {
		super(request, response, ServiceNotif.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de Notification
	 *
	 */
	@SuppressWarnings("unused")
	public ServicesActionDropdownItemsProvider getActionsService(ServiceNotif serviceNotif) {
		return new ServicesActionDropdownItemsProvider(serviceNotif, _request,
				_response);
	}
	/**
	 * Retourne le searchContainer des notifications
	 *
	 */
	@Override
	public SearchContainer<ServiceNotif> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/notif-bo-view-services.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
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
						_services = _services.subList(start, end > total ? total : end);
						return _services;
					}, _services.size()
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
		if (this._services == null) {
			this._services = ServiceNotifLocalServiceUtil.getServiceNotifs(
					QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
		}
	}


	/**
	 * Renvoie la colonne sur laquelle on fait le tri
	 */
	@Override
	public String getOrderByCol() {
		return null;
	}

	protected SearchContainer<ServiceNotif> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;

	private List<ServiceNotif> _services;
}
