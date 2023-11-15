package eu.strasbourg.portlet.place.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.place.util.SubPlaceActionDropdownItemsProvider;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.SubPlaceLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class ViewSubPlacesDisplayContext extends ViewBaseDisplayContext<SubPlace> {

	public ViewSubPlacesDisplayContext(RenderRequest request,
			RenderResponse response) {
		super(request, response, SubPlace.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de subPlace
	 *
	 */
	@SuppressWarnings("unused")
	public SubPlaceActionDropdownItemsProvider getActionsSubPlace(SubPlace subPlace) {
		return new SubPlaceActionDropdownItemsProvider(subPlace, _request,
				_response);
	}

	@Override
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

	private SearchContainer<SubPlace> _searchContainer;
	private List<SubPlace> _subPlaces;
}
