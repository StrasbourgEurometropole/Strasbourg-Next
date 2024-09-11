package eu.strasbourg.portlet.agenda.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agenda.util.ManifActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.ManifestationLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewManifestationsDisplayContext extends ViewBaseDisplayContext<Manifestation> {
	public ViewManifestationsDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, Manifestation.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de l’entité
	 *
	 * @return ManifActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public ManifActionDropdownItemsProvider getActionsManif(Manifestation manif) {
		return new ManifActionDropdownItemsProvider(manif, this._request,
				this._response);
	}
	/**
	 * Retourne le searchContainer des events
	 *
	 * @return SearchContainer<Manifestation>
	 */
	@Override
	public SearchContainer<Manifestation> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/agenda-bo-view-manifestations.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","manifestations")
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
			Hits hits;
			try {
				hits = getHits(_themeDisplay.getCompanyGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<Manifestation> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								Manifestation manif = ManifestationLocalServiceUtil.fetchManifestation(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (manif!= null)
									results.add(manif);
							}
						}

						return results;
					}, hits.getLength()
			);
		}
		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}

	protected SearchContainer<Manifestation> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;

}
