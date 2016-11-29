package eu.strasbourg.portlet.search_asset.display.context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.portlet.search_asset.configuration.SearchAssetConfiguration;

public class SearchAssetDisplayContext {

	public SearchAssetDisplayContext(RenderRequest request,
		RenderResponse response) throws PortalException {

		this._request = request;
		this._response = response;
		this._themeDisplay = (ThemeDisplay) _request
			.getAttribute(WebKeys.THEME_DISPLAY);
		this._configuration = this._themeDisplay.getPortletDisplay()
			.getPortletInstanceConfiguration(SearchAssetConfiguration.class);
		this.initSearchContainer();
		this.initEntries();
	}

	private void initSearchContainer() {
		PortletURL iteratorURL = this._response.createRenderURL();
		iteratorURL.setParameter("orderByCol", this.getOrderByCol());
		iteratorURL.setParameter("orderByType", this.getOrderByType());
		int i = 0;
		for (long categoryId : getFilterCategoriesIds()) {
			iteratorURL.setParameter("vocabulary_" + i,
				String.valueOf(categoryId));
			i++;
		}
		iteratorURL.setParameter("vocabulariesCount", String.valueOf(i));
		i = 0;
		for (String className : getFilterClassNames()) {
			iteratorURL.setParameter("className_" + i, className);
			i++;
		}
		iteratorURL.setParameter("classNamesCount", String.valueOf(i));
		iteratorURL.setParameter("keywords", this.getKeywords());

		if (this._searchContainer == null) {
			this._searchContainer = new SearchContainer<AssetEntry>(
				this._request, iteratorURL, null, "no-entries-were-found");

			this._searchContainer.setOrderByColParam("orderByCol");
			this._searchContainer.setOrderByTypeParam("orderByType");
			this._searchContainer
				.setDelta((int) (this._configuration.delta() > 0
					? this._configuration.delta() : 12));
		}
	}

	private void initEntries() throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
			.getHttpServletRequest(_request);

		SearchContext searchContext = SearchContextFactory
			.getInstance(servletRequest);

		// Pagination
		searchContext.setStart(getSearchContainer().getStart());
		searchContext.setEnd(getSearchContainer().getEnd());

		// Construction de la requète
		BooleanQuery query = new BooleanQueryImpl();

		// ClassNames
		BooleanQuery classNameQuery = new BooleanQueryImpl();
		for (String className : this.getFilterClassNames()) {
			if (Validator.isNotNull(className)) {
				// TermQuery termQuery = new TermQueryImpl(new
				// QueryTermImpl(Field.EN, value))
				classNameQuery.addTerm(Field.ENTRY_CLASS_NAME, className, false,
					BooleanClauseOccur.SHOULD);
			}
		}
		query.add(classNameQuery, BooleanClauseOccur.MUST);

		// Group
		if (this._configuration.globalScope()) {
			// Si la configuration demande que le groupe global soit inclu
			// On crée une query faisant un "ou" entre le groupe courant et le
			// groupe global
			BooleanQuery groupQuery = new BooleanQueryImpl();
			BooleanQuery scopeGroupQuery = new BooleanQueryImpl();
			BooleanQuery globalGroupQuery = new BooleanQueryImpl();
			scopeGroupQuery.addRequiredTerm(Field.GROUP_ID,
				this._themeDisplay.getScopeGroupId());
			globalGroupQuery.addRequiredTerm(Field.GROUP_ID,
				this._themeDisplay.getCompanyGroupId());
			groupQuery.add(scopeGroupQuery, BooleanClauseOccur.SHOULD);
			groupQuery.add(globalGroupQuery, BooleanClauseOccur.SHOULD);
			query.add(groupQuery, BooleanClauseOccur.MUST);
		} else {
			// Sinon on se contente d'ajouter le groupe courant à la requête
			query.addRequiredTerm(Field.GROUP_ID,
				this._themeDisplay.getScopeGroupId());
		}

		// Status
		query.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);

		// Mots-clés
		String keywords = ParamUtil.getString(this._request, "keywords");
		if (Validator.isNotNull(keywords)) {
			query.addTerms(new String[] { Field.TITLE, Field.DESCRIPTION },
				keywords.toLowerCase(), true);
		}

		// Catégories
		for (long categoryId : this.getFilterCategoriesIds()) {
			BooleanQuery categoryQuery = new BooleanQueryImpl();
			categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS,
				String.valueOf(categoryId));
			query.add(categoryQuery, BooleanClauseOccur.MUST);
		}

		// Préfiltre catégories
		// On fait un "ou" entre les catégories d'un même vocabulaire et un
		// "et" entre les différents vocabulaires
		for (String categoriesIdsGroupByVocabulary : this._configuration
			.prefilterCategoriesIds().split(";")) {
			BooleanQuery vocabularyQuery = new BooleanQueryImpl();
			for (String categoryId : categoriesIdsGroupByVocabulary
				.split(",")) {
				if (Validator.isNotNull(categoryId)) {
					BooleanQuery categoryQuery = new BooleanQueryImpl();
					categoryQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS,
						String.valueOf(categoryId));
					vocabularyQuery.add(categoryQuery,
						BooleanClauseOccur.SHOULD);
				}
			}
			query.add(vocabularyQuery, BooleanClauseOccur.MUST);
		}

		// Recherche
		Hits hits = IndexSearcherHelperUtil.search(searchContext, query);
		List<AssetEntry> results = new ArrayList<AssetEntry>();
		if (hits != null) {
			/*
			 * for (float s : hits.getScores()) { System.out.println(s); }
			 * System.out.println();
			 */
			for (Document document : hits.getDocs()) {
				AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(
					GetterUtil.getString(document.get(Field.ENTRY_CLASS_NAME)),
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (entry != null) {
					results.add(entry);
				}
			}
			long count = IndexSearcherHelperUtil.searchCount(searchContext,
				query);
			this.getSearchContainer().setTotal((int) count);
		}

		this._entries = results;
	}

	/**
	 * Renvoie la liste des catégories sur lesquelles on souhaite filtrer les
	 * entries
	 */
	private long[] getFilterCategoriesIds() {
		if (_filterCategoriesIds == null) {
			long vocabulariesCount = ParamUtil.getLong(this._request,
				"vocabulariesCount");
			List<Long> categoriesIds = new ArrayList<Long>();
			for (long i = 0; i < vocabulariesCount; i++) {
				long[] categoriesIdsForVoc = ParamUtil
					.getLongValues(this._request, "vocabulary_" + i);
				for (long categoryIdForVoc : categoriesIdsForVoc) {
					if (categoryIdForVoc > 0) {
						categoriesIds.add(categoryIdForVoc);
					}
				}
			}
			this._filterCategoriesIds = categoriesIds.stream().mapToLong(l -> l)
				.toArray();
		}
		return this._filterCategoriesIds;
	}

	public String getFilterCategoriesIdsString() {
		return StringUtil.merge(getFilterCategoriesIds());
	}

	/**
	 * Renvoie la liste des types d'entités sur lesquels on souhaite rechercher
	 * les entries
	 */
	private String[] getFilterClassNames() {
		if (_filterClassNames == null) {
			long classNamesCount = ParamUtil.getLong(this._request,
				"classNamesCount");
			List<String> classNames = new ArrayList<String>();
			for (long i = 0; i < classNamesCount; i++) {
				String className = ParamUtil.getString(this._request,
					"className_" + i);
				if (Validator.isNotNull(className)
					&& !"false".equals(className)) {
					classNames.add(className);
				}
			}
			this._filterClassNames = classNames.toArray(new String[0]);
		}
		// Si la liste est vide, on renvoie la liste complète paramétrée via la
		// configuration (on ne recherche pas sur rien !)
		if (this._filterClassNames.length == 0) {
			this._filterClassNames = this._configuration.assetClassNames()
				.split(",");
		}
		return this._filterClassNames;
	}

	/**
	 * Retourne la liste des types d'entités sur lesquels on souhaite rechercher
	 * les entries, sous forme de String
	 */
	public String getFilterClassNamesString() {
		return StringUtil.merge(getFilterClassNames());
	}

	/**
	 * On récupère les préférences de catégories et on les envoie à la JSP C'est
	 * une liste d'AssetVocabulary, qui correspond aux vocabulaires pour
	 * lesquels on souhaite afficher une liste déroulante dans le moteur de
	 * recherche
	 */
	public List<AssetVocabulary> getVocabularies() throws PortalException {
		if (this._vocabularies == null) {
			this._vocabularies = new ArrayList<AssetVocabulary>();

			String vocabularyIdsString = this._configuration.vocabulariesIds();
			if (Validator.isNotNull(vocabularyIdsString)) {
				long[] vocabularyIds = Arrays
					.stream(vocabularyIdsString.split(","))
					.mapToLong(Long::parseLong).toArray();
				for (long vocabularyId : vocabularyIds) {
					this._vocabularies.add(AssetVocabularyLocalServiceUtil
						.getAssetVocabulary(vocabularyId));
				}
			}
		}
		return this._vocabularies;
	}

	/**
	 * Retourne la liste des types de contrôles pour les vocabulaires
	 */
	public String[] getVocabulariesControlTypes() {
		String vocabulariesControlTypesString = this._configuration
			.vocabulariesControlTypes();
		if (vocabulariesControlTypesString != null) {
			return vocabulariesControlTypesString.split(",");
		} else {
			return null;
		}
	}

	/**
	 * Retourne les mots-clés de recherche
	 */
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}

	/**
	 * Retourne le searchContainer des entités
	 */
	public SearchContainer<AssetEntry> getSearchContainer() {
		return this._searchContainer;
	}

	/**
	 * Retourne les résultats de la recherche
	 */
	public List<AssetEntry> getEntries() throws PortalException {
		return this._entries;
	}

	/**
	 * Renvoie des données nécessaires au search container
	 */
	public String getOrderByColSearchField() {
		switch (this.getOrderByCol()) {
		case "title":
			return "localized_title_fr_FR_sortable";
		case "modified-date":
			return "modified_sortable";
		case "publication-date":
			return "publishDate_sortable";
		case "status":
			return "status_sortable";
		default:
			return "publishDate_sortable";
		}
	}

	public String getOrderByCol() {
		return ParamUtil.getString(this._request, "orderByCol",
			"modified-date");
	}

	public String getOrderByType() {
		return ParamUtil.getString(this._request, "orderByType", "desc");
	}

	public String[] getOrderColumns() {
		return new String[] { "title", "modified-date", "publication-date",
			"status" };
	}

	/**
	 * Retourne une map avec comme clés les classNames des entités retournées et
	 * comme valeurs les ids des ADT
	 */
	public Map<String, String> getTemplatesMap()
		throws NumberFormatException, PortalException {
		if (this._templatesMap == null) {
			Map<String, String> templatesMap = new HashMap<String, String>();
			String templatesKeys = this._configuration.templatesKeys();
			int i = 0;
			for (String templateKey : templatesKeys.split(",")) {
				if (Validator.isNotNull(templateKey)) {
					String className = this._configuration.assetClassNames()
						.split(",")[i];
					templatesMap.put(className, "ddmTemplate_" + templateKey);
				}
				i++;
			}
			this._templatesMap = templatesMap;
		}
		return this._templatesMap;
	}

	/**
	 * Retourne la liste des class names sur lesquelles on recherche
	 */
	public List<String> getClassNames() {
		return Arrays.asList(_configuration.assetClassNames().split(","));
	}

	private final RenderRequest _request;
	private final RenderResponse _response;
	private final ThemeDisplay _themeDisplay;
	private SearchAssetConfiguration _configuration;

	private SearchContainer<AssetEntry> _searchContainer;
	private List<AssetEntry> _entries;
	private List<AssetVocabulary> _vocabularies;
	private String _keywords;
	private long[] _filterCategoriesIds;
	private String[] _filterClassNames;
	private Map<String, String> _templatesMap;

}
