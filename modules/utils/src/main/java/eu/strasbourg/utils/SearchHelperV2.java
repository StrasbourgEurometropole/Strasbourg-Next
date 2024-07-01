package eu.strasbourg.utils;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.groupby.GroupByRequestFactory;
import com.liferay.portal.search.hits.SearchHits;
import com.liferay.portal.search.query.BooleanQuery;
import com.liferay.portal.search.query.FunctionScoreQuery;
import com.liferay.portal.search.query.MatchQuery;
import com.liferay.portal.search.query.Operator;
import com.liferay.portal.search.query.Queries;
import com.liferay.portal.search.query.Query;
import com.liferay.portal.search.query.RangeTermQuery;
import com.liferay.portal.search.query.TermQuery;
import com.liferay.portal.search.query.WildcardQuery;
import com.liferay.portal.search.query.function.score.RandomScoreFunction;
import com.liferay.portal.search.query.function.score.ScoreFunctions;
import com.liferay.portal.search.searcher.SearchRequest;
import com.liferay.portal.search.searcher.SearchRequestBuilder;
import com.liferay.portal.search.searcher.SearchRequestBuilderFactory;
import com.liferay.portal.search.searcher.SearchResponse;
import com.liferay.portal.search.searcher.Searcher;
import com.liferay.portal.search.sort.FieldSort;
import com.liferay.portal.search.sort.Sort;
import com.liferay.portal.search.sort.SortOrder;
import com.liferay.portal.search.sort.Sorts;
import eu.strasbourg.utils.bean.AssetPrefilter;
import eu.strasbourg.utils.bean.AssetType;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
		immediate = true,
		property = {},
		service = SearchHelperV2.class)
public class SearchHelperV2{

	/**
	 * Retourne les Hits correspondant aux paramètres pour les moteurs de
	 * recherche d'assets V2
	 *
	 * @param searchContext
	 *            Utilisé pour récupérer le companyId
	 * @param assetTypes
	 *            Liste d'AssetType _className, scopeGroupIDs, structureID, assetPrefilterList_ (utilisé dans la query)
	 * @param isDisplayField
	 *            Si la recherche se fait par rapport à des dates (utilisé dans la query)
	 * @param filterField
	 *            Champs au format date sur lequel le filtre se fait (utilisé dans la query)
	 * @param seed
	 *            int random pour le tri aléatoire
	 * @param sortingFieldsAndTypes
	 *            Map contenant les champs et les types des tri
//	 * @param categoriesIdsForGroupBy
//	 *            Catégories du vocabulaire sur lequel on veut le regroupement
	 * @param keywords
	 *            Mots clés de recherche (utilisé dans la query)
	 * @param fromDate
	 *            Date de début, sous le format "yyyyMMdd000000" (utilisé dans la query)
	 * @param toDate
	 *            Date de fin, sous le format "yyyyMMdd000000" (utilisé dans la query)
	 * @param categoriesIds
	 *            Liste de tableaux d'ids de catégories (provenant de la
	 *            recherche utilisateur) - un OU est effectué entre chaque id de
	 *            chaque tableau, et UN entre chaque liste (utilisé dans la query)
	 * @param idSIGPlace
	 * 			  L'id SIG du lieu (utilisé dans la query)
	 * @param classNamesOrStructuresSelected
	 *            Liste des classNames ou Structures sélectionnés par l'utilisateur (utilisé dans la query)
	 * @param locale
	 *            Locale utile pour la recherche de mots clé (utilisé dans la query)
	 * @param start
	 *            Pagination : début
	 * @param end
	 *            Pagination : fin
	 *
	 * @return Les hits renvoyés par le moteur de recherche
	 */
	public SearchHits  getGlobalSearchHitsV2(SearchContext searchContext, List<AssetType> assetTypes, Boolean isDisplayField,
											 String filterField, int seed, Map<String, String> sortingFieldsAndTypes,
											 /*long[] categoriesIdsForGroupBy, */String keywords, LocalDate fromDate,
											 LocalDate toDate, List<Long[]> categoriesIds, String idSIGPlace,
											 List<String> classNamesOrStructuresSelected, Locale locale, int start, int end) {

		// Query
		Query query = getGlobalSearchV2Query(assetTypes, isDisplayField, filterField, /*categoriesIdsForGroupBy,*/
				keywords, fromDate, toDate, categoriesIds, idSIGPlace, classNamesOrStructuresSelected, locale);

		// Recherche
		SearchHits searchHits = search(searchContext, query, sortingFieldsAndTypes, seed, start, end);

		return searchHits;
	}

	public SearchHits search(SearchContext searchContext, Query query, Map<String, String> sortingFieldsAndTypes,int seed,  int start, int end) {
		SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();

		// Pagination
		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(
				sc -> {
					sc.setCompanyId(searchContext.getCompanyId());
				}
		);

		searchRequestBuilder.from(start);
		searchRequestBuilder.size(end - start);
		// Pour debugger les scores
		searchRequestBuilder.explain(true);

		// Tri
		if (Validator.isNotNull(seed) && seed > 0) {
			// Tri aléatoire
			RandomScoreFunction randomScoreFunction = scoreFunctions.random();
			randomScoreFunction.setSeed(seed);
			randomScoreFunction.setField("entryClassPK");
			FunctionScoreQuery functionScoreQuery = queries.functionScore(query);
			functionScoreQuery.addFilterQueryScoreFunctionHolder(query, randomScoreFunction);
			query = functionScoreQuery;
		}
		else {
			// Tri
			if (sortingFieldsAndTypes.size() > 0) {
				Sort[] sortArray = new Sort[sortingFieldsAndTypes.size()];
				int i = 0;
				Iterator iterator = sortingFieldsAndTypes.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry entry = (Map.Entry) iterator.next();
					FieldSort fieldSort = sorts.field((String)entry.getKey(), SortOrder.valueOf(String.valueOf(entry.getValue()).toUpperCase()));
					sortArray[i] = fieldSort;
					i++;
				}
				searchRequestBuilder = searchRequestBuilder.sorts(sortArray);
			}
		}



		SearchRequest searchRequest = searchRequestBuilder.query(query).build();
		SearchResponse searchResponse = searcher.search(searchRequest);

		// Recherche
		SearchHits searchHits = searchResponse.getSearchHits();
		_log.debug("Recherche front-end : " + searchHits.getSearchTime() * 1000 + "ms");
		return searchHits;
	}

	/**
	 * Retourne la requête à exécuter correspondant aux paramètres pour le searchAssetV2
	 */
	private Query getGlobalSearchV2Query(List<AssetType> assetTypes,
										 Boolean isDisplayField, String filterField, /*long[] categoriesIdsForGroupBy,*/
										 String keywords, LocalDate fromDate, LocalDate toDate, List<Long[]> categoriesIds,
										 String placeSigId, List<String> classNamesOrStructuresSelected, Locale locale) {


		// Construction de la requète

		QueryBuilder queryBuilder = new QueryBuilder(queries);

		queryBuilder = queryBuilder
				.withAssetTypes(assetTypes, classNamesOrStructuresSelected, keywords)
				.withStatus(WorkflowConstants.STATUS_APPROVED)
				.withVisible(true)
				.withDateBeforeToday();

		if(isDisplayField) {
			queryBuilder = queryBuilder.withDate(filterField, fromDate, toDate);
		}


		Query query = queryBuilder
				.withKeywords(keywords, locale)
                .withCategories(categoriesIds)
                .withPlace(placeSigId)
				.build();

		return query;
	}

	/**
	 * Implémentation de Requete les événements pour interest viewer
	 */
	private Query getInterestEventsSearchQuery(String className,List <Long> tagIds,List<Long[]> categoriesIds
										 , LocalDate fromDate, LocalDate toDate) {
		// Construction de la requète
		BooleanQuery query = queries.booleanQuery();

		// ClassName exact
		if(Validator.isNotNull(className))
		{
			TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, className);
			query.addMustQueryClauses(classNameQuery);
		}

		// Catégories
		// On fait un "ou" entre les catégories d'un même vocabulaire et un
		// "et" entre les différents vocabulaires
		if(categoriesIds!=null) {
			for (Long[] categoriesIdsGroupByVocabulary : categoriesIds) {
				BooleanQuery vocabularyQuery = queries.booleanQuery();
				for (long categoryId : categoriesIdsGroupByVocabulary) {
					TermQuery categoryQuery = queries.term(Field.ASSET_CATEGORY_IDS, String.valueOf(categoryId));
					vocabularyQuery.addShouldQueryClauses(categoryQuery);
				}
				query.addMustQueryClauses(vocabularyQuery);
			}
		}
		//tags
		if(tagIds!=null){
			BooleanQuery tagsQuery = queries.booleanQuery();
			for (Long tagId :tagIds){
				TermQuery tagQuery = queries.term(Field.ASSET_TAG_IDS, String.valueOf(tagId));
				tagsQuery.addShouldQueryClauses(tagQuery);
			}
			query.addMustQueryClauses(tagsQuery);
		}

		// formater la date début et la date fin en format dates ElasticSearch
		String fromDateString = String.format("%04d", fromDate.getYear())
				+ String.format("%02d", fromDate.getMonth().getValue())
				+ String.format("%02d", fromDate.getDayOfMonth()) + "000000";
		String toDateString = String.format("%04d", toDate.getYear())
				+ String.format("%02d", toDate.getMonth().getValue())
				+ String.format("%02d", toDate.getDayOfMonth()) + "000000";
		RangeTermQuery datesQuery = queries.dateRangeTerm("dates", true, true, fromDateString, toDateString);
				query.addMustQueryClauses(datesQuery);
				// chercher les events ayant le status approuvé  et visible
		TermQuery statusQuery = queries.term(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		TermQuery visibilityQuery = queries.term("visible", true);
		query.addMustQueryClauses(statusQuery, visibilityQuery);
		return query;
	}

	/**
	 * Chercher les événements pour interest viewer
	 * à pour but de chercher les x prochine événements à partir d'ayjourd'hui en fct de centre d'intéret d'un utilisateur
	 */
	public SearchHits getInterestEventsSearchHits(SearchContext searchContext, String className, List<Long> tagIds
			, List<Long[]> categoriesIds, int start, int end) {

		// Query
		LocalDate fromDate = LocalDate.now();
		// on recherche sur 1 mois arbitrairement car on sait qu'on ne va chercher qu'une dizaine d'événement
		Query query = getInterestEventsSearchQuery(className,tagIds,categoriesIds,fromDate,fromDate.plusMonths(1));

		SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();

		// Pagination
		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(
				sc -> {
					sc.setCompanyId(searchContext.getCompanyId());

				}
		);
		searchRequestBuilder.from(start);
		searchRequestBuilder.size(end - start);

		// Tri qui a pour but de faire venir en premier les événements qui n'ont lieu qu'aujourd'hui

		//Tri par ordre croissant par la date d'événement
		// Comme on a fait un range à partir de la date d'aujourd'hui, on commence donc par les events
		// qui se produisent aujourd'hui
		FieldSort dateSort = sorts.field("dates_Number_sortable", SortOrder.ASC);

		// faire apparaitre en premier les évenements qui finissent aujourd'hui
		FieldSort endDateSort = sorts.field("endDate_Number_sortable", SortOrder.ASC);

		// Trie par start date ordre décroissant à pour récuperer les events qui se commence aujourd'hui
		FieldSort starDateSort = sorts.field("startDate_Number_sortable", SortOrder.DESC);
		searchRequestBuilder = searchRequestBuilder.sorts(dateSort,endDateSort,starDateSort);

		SearchRequest searchRequest = searchRequestBuilder.query(query).build();
		SearchResponse searchResponse = searcher.search(searchRequest);
		SearchHits searchHits = searchResponse.getSearchHits();
		_log.info("Recherche front-end : " + searchHits.getSearchTime() * 1000 + "ms");
		return searchHits;
	}


	private static final Log _log = LogFactoryUtil.getLog(SearchHelperV2.class.getName());

	@Reference
	GroupByRequestFactory groupByRequestFactory;

	@Reference
	protected Sorts sorts;

	@Reference
	protected ScoreFunctions scoreFunctions;

	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;
}
