package eu.strasbourg.portlet.gtfs.display.context;

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
import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.service.ImportHistoricLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewImportHistoricsDisplayContext extends ViewBaseDisplayContext<ImportHistoric> {

	public ViewImportHistoricsDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response, ImportHistoric.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}
	
	/**
	 * Retourne la liste des entrees d'historique correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<ImportHistoric> getAllImportHistorics() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		List<ImportHistoric> results = new ArrayList<>();
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

	@Override
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
	 * Retourne la liste des PK de toutes les entrees d'historique
	 * @return liste de PK (ex: "1,5,7,8")
	 */
	/*public String getAllImportHistoricIds() throws PortalException {
		String importHistoricIds = "";
		for (ImportHistoric importHistoric : this.getAllImportHistorics()) {
			if (importHistoricIds.length() > 0) {
				importHistoricIds += ",";
			}
			importHistoricIds += importHistoric.getImportHistoricId();
		}
		return importHistoricIds;
	}*/

	/**
	 * Retourne le searchContainer
	 *
	 */
	@Override
	public SearchContainer<ImportHistoric> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/gtfs-bo-view-import-historics.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab", "import-historics")
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
						List<ImportHistoric> results = new ArrayList<>();
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
					}, hits.getLength()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}

	protected SearchContainer<ImportHistoric> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}
