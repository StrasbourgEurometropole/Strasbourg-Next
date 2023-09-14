package eu.strasbourg.portlet.project.display.context;

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
import eu.strasbourg.portlet.project.util.BudgetPhaseActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewBudgetPhasesDisplayContext  extends ViewBaseDisplayContext<BudgetPhase> {
	
	public ViewBudgetPhasesDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response, BudgetPhase.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de l'initiative
	 *
	 */
	@SuppressWarnings("unused")
	public BudgetPhaseActionDropdownItemsProvider getActionsBudgetPhase(BudgetPhase budgetPhase) {
		return new BudgetPhaseActionDropdownItemsProvider(budgetPhase, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des BudgetPhases
	 *
	 */
	@Override
	public SearchContainer<BudgetPhase> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/project-bo-view-budgets-phases.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab", "budgets-phases")
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
				hits = getHits(_themeDisplay.getScopeGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<BudgetPhase> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								BudgetPhase budgetPhase = BudgetPhaseLocalServiceUtil
										.fetchBudgetPhase(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (budgetPhase != null) {
									results.add(budgetPhase);
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

	/**
	 * Retourne la liste des phases correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<BudgetPhase> getAllBudgetPhases() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());
		
		// Création de la liste d'objet
		List<BudgetPhase> results = new ArrayList<BudgetPhase>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				BudgetPhase budgetPhase = BudgetPhaseLocalServiceUtil.fetchBudgetPhase(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (budgetPhase != null) {
					results.add(budgetPhase);
				}
			}
		}
		return results;
	}

	/**
	 * Retourne la liste des PK de toutes les phases
	 * @return liste de PK (ex: "1,5,7,8")
	 */
	public String getAllBudgetPhaseIds() throws PortalException {
		String budgetPhaseIds = "";
		for (BudgetPhase budgetPhase : this.getAllBudgetPhases()) {
			if (budgetPhaseIds.length() > 0) {
				budgetPhaseIds += ",";
			}
			budgetPhaseIds += budgetPhase.getBudgetPhaseId();
		}
		return budgetPhaseIds;
	}

	/**
	 * Renvoie le nom du champ sur laquelle on fait le tri pour
	 * ElasticSearch
	 *
	 * @return String
	 */
	@Override
	public String getOrderByColSearchField() {
		switch (getOrderByCol()) {

			case "name":
				return "title";
			case "is-active":
				return "isActive";
			case "modified-date":
			default:
				return "modified_sortable";
		}
	}

	protected SearchContainer<BudgetPhase> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;

	protected ThemeDisplay _themeDisplay;

}
