package eu.strasbourg.portlet.oidc.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.oidc.util.PublikUserActionDropdownItemsProvider;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

public class ViewPublikUsersDisplayContext extends ViewBaseDisplayContext<PublikUser> {
	
	private List <PublikUser> _publikUsers;

	public ViewPublikUsersDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response, PublikUser.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Renvoie le nom de la colonne sur laquelle on fait le tri pour PublikUser
	 *
	 */
	@Override
	public String getOrderByColSearchField() {
		switch (this.getOrderByCol()) {
			case "first-name":
				return "firstName";
			case "email":
				return "email";
			case "banish-date":
				return "banishDate";
			default:
				return "lastName";
		}
	}

	/**
	 * Retourne le dropdownItemsProvider de l'publik user
	 *
	 */
	@SuppressWarnings("unused")
	public PublikUserActionDropdownItemsProvider getActionsPublikUser(PublikUser publikUser) {
		return new PublikUserActionDropdownItemsProvider(publikUser, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer
	 *
	 */
	@Override
	public SearchContainer<PublikUser> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/oidc-bo-view-publikusers.jsp")
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

						return _publikUsers;

					},PublikUserLocalServiceUtil.getPublikUsers(
							this.getKeywords(),
							this.getOrderByColSearchField(),
							"desc".equals(this.getOrderByType())).size()

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

		List results = PublikUserLocalServiceUtil.getPublikUsers(
				this.getSearchContainer().getStart(),
				this.getSearchContainer().getEnd(),
				this.getKeywords(),
				this.getOrderByColSearchField(),
				"desc".equals(this.getOrderByType()));

		this._publikUsers=results;
	}

	protected SearchContainer<PublikUser> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;

}
