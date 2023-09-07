package eu.strasbourg.portlet.activity.display.context;

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

import eu.strasbourg.portlet.activity.util.ActivityActionDropdownItemsProvider;
import eu.strasbourg.portlet.activity.util.ActivityCourseActionDropdownItemsProvider;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.service.activity.service.ActivityLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

public class ViewActivityCoursesDisplayContext {
	public ViewActivityCoursesDisplayContext(RenderRequest request,
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
	 * @return activityCourseActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public ActivityCourseActionDropdownItemsProvider getActionsActivityCourse(ActivityCourse activityCourse) {
		return new ActivityCourseActionDropdownItemsProvider(activityCourse, _request,
				_response);
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 * Retourne le searchContainer
	 *
	 */
	public SearchContainer<ActivityCourse> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/activity-bo-view-courses.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","activityCourses")
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
						List<ActivityCourse> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								ActivityCourse activityCourse = ActivityCourseLocalServiceUtil.fetchActivityCourse(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (activityCourse!= null) {
									results.add(activityCourse);
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
				getSearchContainer().getEnd(), ActivityCourse.class.getName(), groupId,
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

	public boolean hasVocabulary(String vocabularyName){
		return getFilterCategoriesIdByVocabulariesName().contains(vocabularyName+"_");
	}

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

	private Hits _hits;
	protected SearchContainer<ActivityCourse> _searchContainer;
	private List<String[]> _categVocabularies;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	protected String _filterCategoriesIds;

}
