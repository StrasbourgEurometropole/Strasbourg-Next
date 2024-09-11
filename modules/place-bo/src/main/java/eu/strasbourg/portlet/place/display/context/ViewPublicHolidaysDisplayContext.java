package eu.strasbourg.portlet.place.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.place.util.PublicHolidayActionDropdownItemsProvider;
import eu.strasbourg.service.place.model.PublicHoliday;
import eu.strasbourg.service.place.service.PublicHolidayLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class ViewPublicHolidaysDisplayContext extends ViewBaseDisplayContext<PublicHoliday> {

	public ViewPublicHolidaysDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, PublicHoliday.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}
	/**
	 * Retourne le dropdownItemsProvider de place
	 *
	 */
	@SuppressWarnings("unused")
	public PublicHolidayActionDropdownItemsProvider getActionsPublicHoliday(PublicHoliday publicHoliday) {
		return new PublicHolidayActionDropdownItemsProvider(publicHoliday, _request,
				_response);
	}

	@Override
	public SearchContainer<PublicHoliday> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/place-bo-view-public-holidays.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","publicHolidays")
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
						_publicHolidays= _publicHolidays.subList(start, end > total ? total : end);
						return _publicHolidays;
					}, _publicHolidays.size()
			);
		}
		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}

	private void getHits() throws PortalException {
		if (this._publicHolidays == null) {

			// Récupération de la liste des prix
			this._publicHolidays = PublicHolidayLocalServiceUtil
					.getPublicHolidays(QueryUtil.ALL_POS,
							QueryUtil.ALL_POS);
		}
	}


	private List<PublicHoliday> _publicHolidays;
	protected SearchContainer<PublicHoliday> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}
