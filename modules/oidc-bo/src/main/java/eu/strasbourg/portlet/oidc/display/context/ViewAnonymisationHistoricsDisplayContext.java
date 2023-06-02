package eu.strasbourg.portlet.oidc.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.service.oidc.model.AnonymisationHistoric;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.AnonymisationHistoricLocalServiceUtil;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewAnonymisationHistoricsDisplayContext{

	private List<AnonymisationHistoric> _anonymisationHistorics;

	public ViewAnonymisationHistoricsDisplayContext(RenderRequest request,
                                                    RenderResponse response, ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector = itemSelector;
	}

	/**
	 * @return True si on peut faire l'anonymisation
	 */
	public boolean canAnonymise() {
		return Boolean.parseBoolean(StrasbourgPropsUtil.getAnonymisationActivated());
	}
	public SearchContainer<AnonymisationHistoric> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/oidc-bo-view-anonymisation-historics.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			try {
				getHits(this._themeDisplay.getCompanyGroupId());

			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<AnonymisationHistoric> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								AnonymisationHistoric anonymisationHistoric = AnonymisationHistoricLocalServiceUtil
										.fetchAnonymisationHistoric(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (anonymisationHistoric != null) {
									results.add(anonymisationHistoric);
								}
							}
						}

						return results;
					}, _hits.getLength()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}
	public String getOrderByCol() {
		return ParamUtil.getString(_request, "orderByCol", "banish-date");
	}
	public String getOrderByType() {
		return ParamUtil.getString(_request, "orderByType", "desc");
	}

	private void getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		_hits = SearchHelper.getBOSearchHits(searchContext,
				getSearchContainer().getStart(),
				getSearchContainer().getEnd(), AnonymisationHistoric.class.getName(), groupId,
				"", keywords,
				null,
				"desc".equals(getOrderByType()));
	}
	@SuppressWarnings("unused")
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}
	private Hits _hits;
	protected SearchContainer<AnonymisationHistoric> _searchContainer;
	private Map<String, String> _categVocabularies;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;

}
