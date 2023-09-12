package eu.strasbourg.portlet.activity.display.context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import eu.strasbourg.portlet.activity.util.ActivityOrganizerActionDropdownItemsProvider;
import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.service.activity.service.ActivityOrganizerLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

public class ViewActivityOrganizersDisplayContext {


	public ViewActivityOrganizersDisplayContext(RenderRequest request,
												RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
	}

	/**
	 * Retourne le dropdownItemsProvider de activityCourse
	 *
	 */
	@SuppressWarnings("unused")
	public ActivityOrganizerActionDropdownItemsProvider getActionsActivityOrganizer(ActivityOrganizer activityOrganizer) {
		return new ActivityOrganizerActionDropdownItemsProvider(activityOrganizer, _request,
				_response);
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 * Retourne le searchContainer
	 *
	 */
	public SearchContainer<ActivityOrganizer> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/activity-bo-view-organizers.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","activityOrganizers")
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
						List<ActivityOrganizer> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								ActivityOrganizer activityOrganizer = ActivityOrganizerLocalServiceUtil.fetchActivityOrganizer(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (activityOrganizer!= null) {
									results.add(activityOrganizer);
								}
							}
						}

						return results;
					}, _hits.getLength()
			);
		}
		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}
	/**
	 * Retourne les Hits de recherche pour un delta
	 */
	private void getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		_hits = SearchHelper.getBOSearchHits(searchContext,
				getSearchContainer().getStart(),
				getSearchContainer().getEnd(), ActivityOrganizer.class.getName(), groupId,
				getFilterCategoriesIds(), keywords,
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
	 * Retourne un String des IDs des catégories sur lesquels on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "vocabularyName_categoryName_categoryId__..."
	 */
	public String getFilterCategoriesIdByVocabulariesName() {
		return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
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

	/**
	 * Renvoie la liste des catégories sur lesquelles on souhaite filtrer les
	 * entries. L'opérateur entre chaque id de catégorie d'un array est un "OU", celui entre chaque liste d'array est un "ET"
	 */
	private List<Long[]> getFilterCategoriesIds() {
		if (_filterCategoriesIds == null) {
			List<Long[]> filterCategoriesIds = new ArrayList<Long[]>();

			// récupère les catégories triées par nom de vocabulaire
			List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
					.split("__")).stream().sorted().collect(Collectors.toList());
			if(!filterCategoriesIdByVocabulariesName.isEmpty()) {
				String oldVocabularyName = "";
				String categoriesIds = "";
				for (String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName) {
					if (Validator.isNotNull(filterCategoryIdByVocabularyName)) {
						String vocabularyName = filterCategoryIdByVocabularyName.split("_")[0];
						String categoryId = filterCategoryIdByVocabularyName.split("_")[2];
						if (oldVocabularyName.equals("") || oldVocabularyName.equals(vocabularyName)) {
							if (Validator.isNotNull(categoriesIds)) {
								categoriesIds += ",";
							}
							categoriesIds += categoryId;
							oldVocabularyName = vocabularyName;
						} else {
							Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
							filterCategoriesIds.add(categoriesIdsOr);
							oldVocabularyName = vocabularyName;
							categoriesIds = categoryId;
						}
					}
				}
				Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
				filterCategoriesIds.add(categoriesIdsOr);
			}
			this._filterCategoriesIds = filterCategoriesIds;
		}
		return this._filterCategoriesIds;
	}

	private Hits _hits;
	protected SearchContainer<ActivityOrganizer> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	protected List<Long[]> _filterCategoriesIds;


}
