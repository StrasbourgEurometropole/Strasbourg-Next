package eu.strasbourg.portlet.agenda.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agenda.util.EventActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewEventsDisplayContext {

	public ViewEventsDisplayContext(RenderRequest request, RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
	}

	/**
	 * Retourne le dropdownItemsProvider de l'event
	 *
	 * @return EventActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public EventActionDropdownItemsProvider getActionsEvent(Event event) {
		return new EventActionDropdownItemsProvider(event, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des events
	 *
	 * @return SearchContainer<Event>
	 */
	public SearchContainer<Event> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/agenda-bo-view-events.jsp")
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
						List<Event> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								Event event = EventLocalServiceUtil
										.fetchEvent(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (event != null) {
									results.add(event);
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
				getSearchContainer().getEnd(), Event.class.getName(), groupId,
				getFilterCategoriesIds(), keywords,
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

	public boolean hasVocabulary(String vocabularyName){
		return getFilterCategoriesIdByVocabulariesName().contains(vocabularyName+"_");
	}

	/**
	 * Retourne la liste des IDs des catégories sur lesquels on doit filtrer
	 *  chaque entrée de liste contient un tableau de String :
	 * [vocabularyName, categoryName, categoryId]
	 */
	public List<String[]> getCategVocabularies() {
		if (_categVocabularies == null) {
			_categVocabularies = new ArrayList<>();
			List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
					.split("__"));
			for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
				if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
					_categVocabularies.add(filterCategoryIdByVocabularyName.split("_"));
				}
			}
		}

		return _categVocabularies;
	}

	/**
	 * Retourne un String des IDs des catégories sur lesquels on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "vocabularyName_categoryName_categoryId__..."
	 */
	public String getFilterCategoriesIdByVocabulariesName() {
		return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
	}

	@SuppressWarnings("unused")
	public String getAllEventIds() throws PortalException {
		StringBuilder eventIds = new StringBuilder();
		for (Event event : this.getAllEvents()) {
			if (eventIds.length() > 0) {
				eventIds.append(",");
			}
			eventIds.append(event.getEventId());
		}
		return eventIds.toString();
	}

	/**
	 * Retourne la liste des événements correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<Event> getAllEvents() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());
		
		// Création de la liste d'objet
		List<Event> results = new ArrayList<Event>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				Event event = EventLocalServiceUtil.fetchEvent(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (event != null) {
					results.add(event);
				}
			}
		}
		return results;
	}

	/**
	 * Retourne tous les Hits de recherche
	 */
	private Hits getAllHits(long groupId) {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");

		return SearchHelper.getBOSearchHits(searchContext,
				-1, -1, Event.class.getName(), groupId,
				getFilterCategoriesIds(), keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
	}

	/**
	 * Retourne la liste des IDs des catégories sur lesquels on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * ",categoryId1,categoryId2,categoryId3,"
	 */
	public String getFilterCategoriesIds() {
		if (Validator.isNotNull(_filterCategoriesIds)) {
			return _filterCategoriesIds;
		}
		List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
				.split("__"));
		_filterCategoriesIds = ",";
		for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
			if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
				_filterCategoriesIds += filterCategoryIdByVocabularyName.split("_")[2] + ",";
			}
		}
		return _filterCategoriesIds;
	}

	/**
	 * Retourne la liste des IDs des catégories d'un vocabulaire, sur lequel on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "categoryId1,categoryId2,categoryId3,"
	 */
	public String getFilterCategoriesIdsByVocabularyName(String vocabularyName) {
		List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
				.split("__"));
		String filterCategoriesIdsByVocabulary = "";
		for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
			if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
				String[] arrayCategoryIdByVocabularyName = filterCategoryIdByVocabularyName.split("_");
				if(arrayCategoryIdByVocabularyName[0].equals(vocabularyName))
					filterCategoriesIdsByVocabulary += arrayCategoryIdByVocabularyName[2] + ",";
			}
		}
		return filterCategoriesIdsByVocabulary;
	}

	private Hits _hits;
	protected SearchContainer<Event> _searchContainer;
	private List<String[]> _categVocabularies;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	protected String _filterCategoriesIds;

}
