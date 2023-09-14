package eu.strasbourg.portlet.place.display.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.place.util.PriceActionDropdownItemsProvider;
import eu.strasbourg.service.place.model.Price;
import eu.strasbourg.service.place.service.PriceLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class ViewPricesDisplayContext extends ViewBaseDisplayContext<Price> {

	public ViewPricesDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, Price.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de price
	 *
	 */
	@SuppressWarnings("unused")
	public PriceActionDropdownItemsProvider getActionsPrice(Price price) {
		return new PriceActionDropdownItemsProvider(price, _request,
				_response);
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 * Retourne le searchContainer des élus
	 *
	 * @return SearchContainer<price>
	 */
	@Override
	public SearchContainer<Price> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/place-bo-view-prices.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","prices")
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
						_prices = _prices.subList(start, end > total ? total : end);
						return _prices;
					}, _prices.size()
			);
		}

		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}

	private void getHits() throws PortalException {
		if (this._prices == null) {

			// Récupération de la liste des prix
			this._prices= PriceLocalServiceUtil.getPrices(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		}
	}


	private List<Price> _prices;
	protected SearchContainer<Price> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;


}
