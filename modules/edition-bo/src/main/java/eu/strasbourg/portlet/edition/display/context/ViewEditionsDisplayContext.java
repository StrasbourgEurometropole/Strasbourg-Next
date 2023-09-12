package eu.strasbourg.portlet.edition.display.context;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.edition.util.EditionActionDropdownItemsProvider;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.service.EditionLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ViewEditionsDisplayContext {

	public ViewEditionsDisplayContext(RenderRequest request,
		RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
	}


	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
			this._themeDisplay.getScopeGroupId(),
			StrasbourgPortletKeys.EDITION_BO, StrasbourgPortletKeys.EDITION_BO,
			actionId);
	}
	/**
	 * Retourne le dropdownItemsProvider de l'edition
	 *
	 * @return EditionActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public EditionActionDropdownItemsProvider getActionsEdition(Edition edition) {
		return new EditionActionDropdownItemsProvider(edition, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des editions
	 *
	 * @return SearchContainer<Edition>
	 */
	public SearchContainer<Edition> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/edition-bo-view-editions.jsp")
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
						List<Edition> results = new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								Edition edition = EditionLocalServiceUtil
										.fetchEdition(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (edition != null) {
									results.add(edition);
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
				getSearchContainer().getEnd(), Edition.class.getName(), groupId,
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

	/**
	 * Retourne un String des IDs des catégories sur lesquels on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "vocabularyName_categoryName_categoryId__..."
	 */
	public String getFilterCategoriesIdByVocabulariesName() {
		return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
	}

	@SuppressWarnings("unused")
	public String getAllEditionIds() throws PortalException {
		StringBuilder editionIds = new StringBuilder();
		for (Edition edition : this.getAllEditions()) {
			if (editionIds.length() > 0) {
				editionIds.append(",");
			}
			editionIds.append(edition.getEditionId());
		}
		return editionIds.toString();
	}

	/**
	 * Retourne la liste des éditions correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<Edition> getAllEditions() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		List<Edition> results = new ArrayList<Edition>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				Edition edition = EditionLocalServiceUtil.fetchEdition(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (edition != null) {
					results.add(edition);
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
				-1, -1, Edition.class.getName(), groupId,
				getFilterCategoriesIds(), keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
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
	protected SearchContainer<Edition> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;
	private List<Edition> _editions;
	protected List<Long[]> _filterCategoriesIds;
}
