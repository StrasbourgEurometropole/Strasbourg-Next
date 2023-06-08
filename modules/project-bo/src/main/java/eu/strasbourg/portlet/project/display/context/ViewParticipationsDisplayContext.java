package eu.strasbourg.portlet.project.display.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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

import eu.strasbourg.portlet.project.util.ParticipationActionDropdownItemsProvider;
import eu.strasbourg.portlet.project.util.PetitionActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.service.ParticipationLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

public class ViewParticipationsDisplayContext {

	private List <Participation> _participations;
	
	public ViewParticipationsDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector = itemSelector;
	}

	/*public List<Participation> getParticipations() throws PortalException {
		if (this._participations == null) {
			Hits hits = getHits(this._themeDisplay.getScopeGroupId());
			this._participations = createObjectList(hits);
		}
		return this._participations;
	}*/
	/**
	 * Retourne le dropdownItemsProvider de participation
	 *
	 */
	@SuppressWarnings("unused")
	public ParticipationActionDropdownItemsProvider getActionsParticipation(Participation participation) {
		return new ParticipationActionDropdownItemsProvider(participation, _request,
				_response);
	}
	/**
	 * Retourne le searchContainer des participations
	 *
	 */
	public SearchContainer<Participation> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/project-bo-view-participations.jsp")
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
				getHits(this._themeDisplay.getScopeGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<Participation> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								Participation participation = ParticipationLocalServiceUtil
										.fetchParticipation(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (participation != null) {
									results.add(participation);
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
				getSearchContainer().getEnd(), Participation.class.getName(), groupId,
				"", keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
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


	private List<Participation> createObjectList(Hits hits) {
		// Création de la liste d'objet
		List<Participation> results = new ArrayList<>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				Participation participation = ParticipationLocalServiceUtil.fetchParticipation(
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (participation != null) {
					results.add(participation);
				}
			}
		}
		return results;
	}

	/**
	 * Retourne la liste des participations correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<Participation> getAllParticipations() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		return createObjectList(hits);
	}
	
	/**
	 * Retourne la liste des PK de toutes les participations
	 * @return liste de PK (ex: "1,5,7,8")
	 */
	public String getAllParticipationIds() throws PortalException {
		String participationIds = "";
		for (Participation participation : this.getAllParticipations()) {
			if (participationIds.length() > 0) {
				participationIds += ",";
			}
			participationIds += participation.getParticipationId();
		}
		return participationIds;
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
				-1, -1, Participation.class.getName(), groupId,
				"", keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
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
	private Hits _hits;
	protected SearchContainer<Participation> _searchContainer;
	private Map<String, String> _categVocabularies;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;
}
