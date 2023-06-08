package eu.strasbourg.portlet.project.display.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.project.util.BudgetPhaseActionDropdownItemsProvider;
import eu.strasbourg.portlet.project.util.InitiativeActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewBudgetPhasesDisplayContext  {

	private List <BudgetPhase> _budgetPhases;
	
	public ViewBudgetPhasesDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector = itemSelector;
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
	 * Retourne le searchContainer des events
	 *
	 * @return SearchContainer<Event>
	 */
	public SearchContainer<BudgetPhase> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/project-bo-edit-budget-phase.jsp")
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
				getHits(_themeDisplay.getCompanyGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<BudgetPhase> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								BudgetPhase budgetPhase = BudgetPhaseLocalServiceUtil
										.fetchBudgetPhase(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (budgetPhase != null) {
									results.add(budgetPhase);
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
				getSearchContainer().getEnd(), BudgetPhase.class.getName(), groupId,
				"", keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
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
	 * Retourne tous les Hits de recherche
	 */
	private Hits getAllHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");

		return SearchHelper.getBOSearchHits(searchContext,
				-1, -1, BudgetPhase.class.getName(), groupId,
				"", keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
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
	public String getOrderByColSearchField() {
		switch (getOrderByCol()) {
			case "title":
			case "alias":
				return "localized_title_fr_FR_sortable";
			case "publication-date":
				return "publishDate_sortable";
			case "status":
				return "status_sortable";
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
	 * Retourne les mots clés de recherche saisis
	 */
	@SuppressWarnings("unused")
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}

	public boolean hasVocabulary(String vocabularyName){
		return getCategVocabularies().containsKey(vocabularyName);
	}

	public Map<String, String> getCategVocabularies() {
		if (_categVocabularies == null) {
			_categVocabularies = new HashMap<>();
			_categVocabularies.put("vocabulary1", ParamUtil.getString(
					_httpServletRequest, "vocabulary1", ""));
		}

		return _categVocabularies;
	}
	@SuppressWarnings("unused")
	public String getSelectCategoriesByVocabularyIdURL(long vocabularyId) {
		RequestBackedPortletURLFactory requestBackedPortletURLFactory =
				RequestBackedPortletURLFactoryUtil.create(_request);
		AssetCategoryTreeNodeItemSelectorCriterion categoryTreeNodeItemSelectorCriterion =
				new AssetCategoryTreeNodeItemSelectorCriterion();
		categoryTreeNodeItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				new AssetCategoryTreeNodeItemSelectorReturnType());

		return String.valueOf(
				_itemSelector.getItemSelectorURL(
						requestBackedPortletURLFactory,
						_response.getNamespace() + "selectAssetCategory",
						categoryTreeNodeItemSelectorCriterion));
	}
	private Hits _hits;
	protected SearchContainer<BudgetPhase> _searchContainer;
	private Map<String, String> _categVocabularies;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;

	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;
	
}
