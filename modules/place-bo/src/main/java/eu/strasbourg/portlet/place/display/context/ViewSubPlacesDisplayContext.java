package eu.strasbourg.portlet.place.display.context;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;

import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.place.util.PublicHolidayActionDropdownItemsProvider;
import eu.strasbourg.service.place.model.PublicHoliday;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.PublicHolidayLocalServiceUtil;
import eu.strasbourg.service.place.service.SubPlaceLocalServiceUtil;

public class ViewSubPlacesDisplayContext {

	public ViewSubPlacesDisplayContext(RenderRequest request,
			RenderResponse response, ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector=itemSelector;
	}

	/**
	 * Retourne le dropdownItemsProvider de subPlace
	 *
	 */
	@SuppressWarnings("unused")
	public PublicHolidayActionDropdownItemsProvider getActionsPublicHoliday(PublicHoliday publicHoliday) {
		return new PublicHolidayActionDropdownItemsProvider(publicHoliday, _request,
				_response);
	}

	public SearchContainer<SubPlace> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/place-bo-view-subplaces.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","subPlaces")
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			_searchContainer.setOrderByColParam("orderByCol");
			_searchContainer.setOrderByTypeParam("orderByType");
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
						_subPlaces= _subPlaces.subList(start, end > total ? total : end);
						return _subPlaces;
					}, _subPlaces.size()
			);
		}
		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}

	private void getHits() throws PortalException {
		if (this._subPlaces == null) {

			// Récupération de la liste des prix
			this._subPlaces = SubPlaceLocalServiceUtil.getSubPlaces(
					QueryUtil.ALL_POS,
					QueryUtil.ALL_POS);
		}
	}


	private final RenderRequest _request;
	private final RenderResponse _response;

	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;


	private SearchContainer<SubPlace> _searchContainer;
	private List<SubPlace> _subPlaces;

}
