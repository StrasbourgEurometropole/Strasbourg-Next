package eu.strasbourg.portlet.interest.display.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import eu.strasbourg.portlet.interest.util.InterestActionDropdownItemsProvider;
import eu.strasbourg.service.interest.model.Interest;
import eu.strasbourg.service.interest.service.InterestLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

public class ViewInterestsDisplayContext  {

	public ViewInterestsDisplayContext(RenderRequest request,
		RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
	}

	/**
	 * Retourne le dropdownItemsProvider de l'interest
	 *
	 */
	@SuppressWarnings("unused")
	public InterestActionDropdownItemsProvider getActionsInterest(Interest interest) {
		return new InterestActionDropdownItemsProvider(interest, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer
	 *
	 */
	public SearchContainer<Interest> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/interest-bo-view-interests.jsp")
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
						List<Interest> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								Interest interest = InterestLocalServiceUtil
										.fetchInterest(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (interest != null) {
									results.add(interest);
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
				getSearchContainer().getEnd(), Interest.class.getName(), groupId,
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
	 * Retourne les mots clés de recherche saisis
	 */
	@SuppressWarnings("unused")
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}
	public String getFilterCategoriesIdByVocabulariesName() {
		return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
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
	protected SearchContainer<Interest> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	protected List<Long[]> _filterCategoriesIds;

}
