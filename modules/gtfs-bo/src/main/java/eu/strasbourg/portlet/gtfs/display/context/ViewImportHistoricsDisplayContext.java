package eu.strasbourg.portlet.gtfs.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.service.ImportHistoricLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

public class ViewImportHistoricsDisplayContext  {

	private List <ImportHistoric> _importHistorics;
	
	public ViewImportHistoricsDisplayContext(RenderRequest request, RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
	}
	
	/**
	 * Retourne la liste des entrees d'historique correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<ImportHistoric> getAllImportHistorics() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		List<ImportHistoric> results = new ArrayList<ImportHistoric>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				ImportHistoric importHistoric = ImportHistoricLocalServiceUtil
						.fetchImportHistoric(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (importHistoric != null) {
					results.add(importHistoric);
				}
			}
		}
		return results;
	}
	private Hits getAllHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");

		return SearchHelper.getBOSearchHits(searchContext,
				-1, -1, Arret.class.getName(), groupId,
				new ArrayList<>(), keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
	}
	public String getOrderByColSearchField() {
		switch (getOrderByCol()) {
			case "title":
				return "localized_title_fr_FR_sortable";
			case "modified-date":
			default:
				return "modified_sortable";
		}
	}

	/**
	 * Renvoie la colonne sur laquelle on fait le tri
	 *
	 * @return String
	 */
	public String getOrderByCol() {
		return ParamUtil.getString(_request, "orderByCol", "modified-date");
	}

	/**
	 * Retourne le type de tri (desc ou asc)
	 *
	 * @return String
	 */
	public String getOrderByType() {
		return ParamUtil.getString(_request, "orderByType", "desc");
	}
	/**
	 * Retourne la liste des PK de toutes les entrees d'historique
	 * @return liste de PK (ex: "1,5,7,8")
	 */
	public String getAllImportHistoricIds() throws PortalException {
		String importHistoricIds = "";
		for (ImportHistoric importHistoric : this.getAllImportHistorics()) {
			if (importHistoricIds.length() > 0) {
				importHistoricIds += ",";
			}
			importHistoricIds += importHistoric.getImportHistoricId();
		}
		return importHistoricIds;
	}
	/**
	 * Retourne les mots clés de recherche saisis
	 */
	/**
	 * Retourne le searchContainer
	 *
	 */
	public SearchContainer<ImportHistoric> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/gtfs-bo-view-import-historics.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab", "importHistorics")
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
				getHits(_themeDisplay.getCompanyGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<ImportHistoric> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								ImportHistoric importHistoric = ImportHistoricLocalServiceUtil
										.fetchImportHistoric(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (importHistoric != null) {
									results.add(importHistoric);
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

	/**
	 * Retourne les Hits de recherche pour un delta
	 */
	private void getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		_hits = SearchHelper.getBOSearchHits(searchContext,
				getSearchContainer().getStart(),
				getSearchContainer().getEnd(), Arret.class.getName(), groupId,
				new ArrayList<>(), keywords,
				getOrderByColSearchField(),
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
	protected SearchContainer<ImportHistoric> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
}
