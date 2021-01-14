package eu.strasbourg.portlet.search_request;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.GroupBy;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.groupby.GroupByRequest;
import com.liferay.portal.search.hits.SearchHit;
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
import eu.strasbourg.portlet.search_request.constants.SearchRequestPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author angelique.champougny
 */
@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=Strasbourg",
				"com.liferay.portlet.instanceable=false",
				"com.liferay.portlet.css-class-wrapper=search-request-portlet",
				"com.liferay.portlet.single-page-application=false",
				"javax.portlet.version=3.0",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/search-request-view.jsp",
				"javax.portlet.init-param.check-auth-token=false",
				"javax.portlet.name=" + SearchRequestPortletKeys.SEARCHREQUEST,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class SearchRequestPortlet extends MVCPortlet {

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(actionRequest);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		// START : user query simulation
		JSONArray assetTypes = null;
		try {
			assetTypes = JSONFactoryUtil.createJSONArray(
				"[" +
					"{" +
						"\"classname\":\"searchJournalArticle\"," +
						"\"scopeIds\":[20160,976405]," +
						"\"structureId\":0," +
						"\"prefilters\":[]" +
					"}," +
					"{" +
						"\"classname\":\"searchDocument\"," +
						"\"scopeIds\":[20160,976405]," +
						"\"structureId\":0," +
						"\"prefilters\":[]" +
					"}," +
				"]");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		// Used by functionQuery to process a random score and have a random sort
		int seed= 64684153;
		List<String> classNamesSelected = new ArrayList<>();
		classNamesSelected.add("searchJournalArticle");
		classNamesSelected.add("searchDocument");
		int start = 0;
		int end = 14;
		Map<String, String> sortingFieldsAndTypes = new HashMap();
		// END : user query simulation

		// Generate query
		Query query = getGlobalSearchV2Query(assetTypes, false, "",
				seed, "test", LocalDate.of(2011,10,13), LocalDate.now(), new ArrayList<>(),
				"", classNamesSelected, Locale.FRANCE);

		SearchRequestBuilder searchRequestBuilder = searchRequestBuilderFactory.builder();

		// Order
		if(Validator.isNull(seed) || seed == 0) {
			Sort[] sortArray = new Sort[sortingFieldsAndTypes.size()];
			Iterator iterator = sortingFieldsAndTypes.entrySet().iterator();
			int i = 0;
			while (iterator.hasNext()) {
				Map.Entry entry = (Map.Entry) iterator.next();
				FieldSort fieldSort = sorts.field((String)entry.getKey(), SortOrder.valueOf(String.valueOf(entry.getValue()).toUpperCase()));
				sortArray[i] = fieldSort;
				i++;
			}
			searchRequestBuilder = searchRequestBuilder.sorts(sortArray);
		}

		// Pagination
		searchRequestBuilder.emptySearchEnabled(true);
		searchRequestBuilder.withSearchContext(
				sc -> {
					sc.setCompanyId(searchContext.getCompanyId());
					sc.setStart(start);
					sc.setEnd(end);

					// TODO Correct : Try this kind of Group By but doesn't affect results
					GroupBy groupBy = new GroupBy(Field.CLASS_TYPE_ID);
					sc.setGroupBy(groupBy);
				}
		);

		groupByRequest.setField(Field.CLASS_TYPE_ID);
		searchRequestBuilder.groupByRequests(groupByRequest);

		searchRequestBuilder.from(start);
		searchRequestBuilder.size(end - start);

		SearchRequest searchRequest = searchRequestBuilder.query(query).build();

		SearchResponse searchResponse = searcher.search(searchRequest);

		// Recherche
		SearchHits searchHits = searchResponse.getSearchHits();
		_log.info("Search front-end : " + searchHits.getSearchTime() * 1000 + "ms");

		if (searchHits != null) {
			for (SearchHit searchHit : searchHits.getSearchHits()) {
				Document document = searchHit.getDocument();
				_log.info(document.getString(
						"localized_title_fr_FR_sortable") + " : " + searchHit.getScore() +
						", className : " + document.getString("entryClassName"));

			}
		}

		super.processAction(actionRequest, actionResponse);
	}

	/**
	 * Generate the request for searchAssetV2
	 */
	private Query getGlobalSearchV2Query(JSONArray assetTypes,
										 Boolean isDisplayField, String filterField,
										 int seed, String keywords, LocalDate fromDate,
										 LocalDate toDate, List<Long[]> categoriesIds,
										 String placeSigId, List<String> filterClassNames, Locale locale) {
		// Construct base request
		BooleanQuery superQuery = queries.booleanQuery();
		BooleanQuery query = queries.booleanQuery();

		// Cast json asset types to query elements
		BooleanQuery assetTypesQuery = queries.booleanQuery();
		if(filterClassNames.size() > 0) {
			for (Object assetTypeObject : assetTypes) {
				JSONObject assetType = (JSONObject) assetTypeObject;
				if (Validator.isNotNull(assetType)) {
					if (Validator.isNotNull(assetType.getString("classname"))) {
						// Check if classname is asked by user
						if (filterClassNames.contains(assetType.getString("classname"))) {
							BooleanQuery assetTypeQuery = queries.booleanQuery();
							// ClassNames
							if (assetType.getString("classname").equals("searchJournalArticle")) {
								// JournalArticle use case
								TermQuery journalArticleClassNameQuery = queries.term(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
								// Check if it is the last version
								TermQuery journalArticleHeadQuery = queries.term("head", true);
								assetTypeQuery.addMustQueryClauses(journalArticleClassNameQuery, journalArticleHeadQuery);
								// Add web content structure
								if (Validator.isNotNull(assetType.getLong("structureId"))) {
									TermQuery structureQuery = queries.term(Field.CLASS_TYPE_ID, assetType.getString("structureId"));
									assetTypeQuery.addMustQueryClauses(structureQuery);
								}

							} else {
								if (assetType.getString("classname").equals("searchDocument")) {
									// DLFileEntry use case
									TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
									assetTypeQuery.addMustQueryClauses(classNameQuery);
								} else {
									TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, assetType.getString("classname"));
									assetTypeQuery.addMustQueryClauses(classNameQuery);
								}
							}

							// Groups
							if (assetType.getJSONArray("scopeIds").length() > 0) {
								BooleanQuery groupsQuery = queries.booleanQuery();
								for (Object groupObject : assetType.getJSONArray("scopeIds")) {
									Long groupId = Long.parseLong(groupObject.toString());
									TermQuery groupQuery = queries.term(Field.GROUP_ID, groupId);
									groupsQuery.addShouldQueryClauses(groupQuery);
								}
								assetTypeQuery.addMustQueryClauses(groupsQuery);
							}

							// Prefilters
							if (assetType.getJSONArray("prefilters").length() > 0) {
								BooleanQuery prefiltersQuery = queries.booleanQuery();
								for (Object prefilterObject : assetType.getJSONArray("prefilters")) {
									JSONObject prefilter = (JSONObject) prefilterObject;
									if (prefilter.getString("type").equals("tags")) {
										BooleanQuery tagsQuery = queries.booleanQuery();
										for (Object tagObject : prefilter.getJSONArray("selection")) {
											Long tagId = (Long) tagObject;
											TermQuery tagQuery = queries.term(Field.ASSET_TAG_IDS, String.valueOf(tagId));
											if (prefilter.getString("operator").equals("all")) {
												tagsQuery.addMustQueryClauses(tagQuery);
											} else {
												tagsQuery.addShouldQueryClauses(tagQuery);
											}
										}
										// CONTAINS operator
										if (prefilter.getBoolean("contains")) {
											prefiltersQuery.addMustQueryClauses(tagsQuery);
										} else {
											prefiltersQuery.addMustNotQueryClauses(tagsQuery);
										}
									} else {
										BooleanQuery categoriesQuery = queries.booleanQuery();
										for (Object categoryObject : prefilter.getJSONArray("selection")) {
											Long categoryId = (Long) categoryObject;
											TermQuery categoryQuery = queries.term(Field.ASSET_CATEGORY_IDS, String.valueOf(categoryId));
											if (prefilter.getString("operator").equals("all")) {
												categoriesQuery.addMustQueryClauses(categoryQuery);
											} else {
												categoriesQuery.addShouldQueryClauses(categoryQuery);
											}
										}
										// CONTAINS operator
										if (prefilter.getBoolean("contains")) {
											prefiltersQuery.addMustQueryClauses(categoriesQuery);
										} else {
											prefiltersQuery.addMustNotQueryClauses(categoriesQuery);
										}
									}
								}
								assetTypeQuery.addMustQueryClauses(prefiltersQuery);
							}
							assetTypesQuery.addShouldQueryClauses(assetTypeQuery);
						}
					}
				}
			}
		}else{
			BooleanQuery assetTypeQuery = queries.booleanQuery();
			TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, "");
			assetTypeQuery.addMustQueryClauses(classNameQuery);
			assetTypesQuery.addShouldQueryClauses(assetTypeQuery);
		}
		query.addMustQueryClauses(assetTypesQuery);

		// Status and visibility
		TermQuery statusQuery = queries.term(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		TermQuery visibilityQuery = queries.term("visible", true);
		query.addMustQueryClauses(statusQuery, visibilityQuery);

		// Publication date
		RangeTermQuery publicationDateQuery = queries.rangeTerm(Field.PUBLISH_DATE + "_sortable", true, true, 0, Timestamp.valueOf(LocalDateTime.now()).toInstant().toEpochMilli());
		query.addMustQueryClauses(publicationDateQuery);

		// Keywords
		if (Validator.isNotNull(keywords)) {
			BooleanQuery keywordQuery = queries.booleanQuery();

			// Fuzzy on title
			MatchQuery titleQuery = queries.match(Field.TITLE + '_' + locale, keywords);
			titleQuery.setOperator(Operator.OR);
			titleQuery.setAnalyzer("strasbourg_analyzer");
			titleQuery.setPrefixLength(0);
			titleQuery.setMaxExpansions(50);
			titleQuery.setFuzzyTranspositions(true);
			titleQuery.setLenient(false);
			titleQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//					"auto_generate_synonyms_phrase_query" : true,
			keywordQuery.addShouldQueryClauses(titleQuery);

			// Titre sans analyzer
			MatchQuery titleQueryWithoutAnalyzer = queries.match(Field.TITLE + "_" + locale, keywords);
			titleQueryWithoutAnalyzer.setOperator(Operator.OR);
			titleQueryWithoutAnalyzer.setFuzziness(2f);
			titleQueryWithoutAnalyzer.setPrefixLength(0);
			titleQueryWithoutAnalyzer.setMaxExpansions(50);
			titleQueryWithoutAnalyzer.setFuzzyTranspositions(true);
			titleQueryWithoutAnalyzer.setLenient(false);
			titleQueryWithoutAnalyzer.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);

			// TODO Correct : this boost setter is not used by the request
			titleQueryWithoutAnalyzer.setBoost(3.0f);
			keywordQuery.addShouldQueryClauses(titleQueryWithoutAnalyzer);

			// Wildcard on title
			WildcardQuery titleWildcardQuery = queries.wildcard(Field.TITLE + "_" + locale,
					"*" + keywords + "*");
			// Boost pas pris en compte
			titleWildcardQuery.setBoost(30.0f);
			keywordQuery.addShouldQueryClauses(titleWildcardQuery);

			// Description
			MatchQuery descriptionQuery = queries.match(Field.DESCRIPTION + "_" + locale, keywords);
			descriptionQuery.setOperator(Operator.OR);
			descriptionQuery.setPrefixLength(0);
			descriptionQuery.setMaxExpansions(50);
			descriptionQuery.setFuzzyTranspositions(true);
			descriptionQuery.setLenient(false);
			descriptionQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
			keywordQuery.addShouldQueryClauses(descriptionQuery);

			// For files, we search only on title field without taking care of locales cause it's indexed that way
			MatchQuery fileTitleQuery = queries.match(Field.TITLE, keywords);
			fileTitleQuery.setOperator(Operator.OR);
			fileTitleQuery.setPrefixLength(0);
			fileTitleQuery.setMaxExpansions(50);
			fileTitleQuery.setFuzzyTranspositions(true);
			fileTitleQuery.setLenient(false);
			fileTitleQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);

			TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());

			BooleanQuery fileQuery = queries.booleanQuery();
			fileQuery.addMustQueryClauses(fileTitleQuery, classNameQuery);
			keywordQuery.addShouldQueryClauses(fileQuery);

			// Fuzzy on content for webcontent behavior
			MatchQuery contentQuery = queries.match(Field.CONTENT + "_" + locale, keywords);
			contentQuery.setOperator(Operator.OR);
			contentQuery.setPrefixLength(0);
			contentQuery.setMaxExpansions(50);
			contentQuery.setFuzzyTranspositions(true);
			contentQuery.setLenient(false);
			contentQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
			keywordQuery.addShouldQueryClauses(contentQuery);

			// Fuzzy on category
			MatchQuery categoryKeywordQuery = queries.match(Field.ASSET_CATEGORY_TITLES, keywords);
			categoryKeywordQuery.setOperator(Operator.OR);
			categoryKeywordQuery.setPrefixLength(0);
			categoryKeywordQuery.setMaxExpansions(50);
			categoryKeywordQuery.setFuzzyTranspositions(true);
			categoryKeywordQuery.setLenient(false);
			categoryKeywordQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
			keywordQuery.addShouldQueryClauses(categoryKeywordQuery);

			// Fuzzy on tags
			MatchQuery tagKeywordQuery = queries.match(Field.ASSET_TAG_NAMES, keywords);
			tagKeywordQuery.setOperator(Operator.OR);
			tagKeywordQuery.setPrefixLength(0);
			tagKeywordQuery.setMaxExpansions(50);
			tagKeywordQuery.setFuzzyTranspositions(true);
			tagKeywordQuery.setLenient(false);
			tagKeywordQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
			keywordQuery.addShouldQueryClauses(tagKeywordQuery);

			query.addMustQueryClauses(keywordQuery);
		} else {
			// If there is no keyword, we stil want located results exept for files (no location on title for them)
			BooleanQuery anyKeywordQuery = queries.booleanQuery();
			TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
			anyKeywordQuery.addShouldQueryClauses(classNameQuery);

			WildcardQuery anyKeywordWildcardQuery = queries.wildcard("title_" + locale, "*");
			anyKeywordQuery.addShouldQueryClauses(anyKeywordWildcardQuery);

			query.addMustQueryClauses(anyKeywordQuery);
		}

		// Catégories
		// On fait un "ou" entre les catégories d'un même vocabulaire et un
		// "et" entre les différents vocabulaires
		for (Long[] categoriesIdsGroupByVocabulary : categoriesIds) {
			BooleanQuery vocabularyQuery = queries.booleanQuery();
			for (long categoryId : categoriesIdsGroupByVocabulary) {
				TermQuery categoryQuery = queries.term(Field.ASSET_CATEGORY_IDS, String.valueOf(categoryId));
				vocabularyQuery.addShouldQueryClauses(categoryQuery);
			}
			query.addMustQueryClauses(vocabularyQuery);
		}

		// Dates
		if (isDisplayField) {
			if (filterField.equals("dates_Number_sortable")) {
				String fromDateString = String.format("%04d", fromDate.getYear())
						+ String.format("%02d", fromDate.getMonth().getValue())
						+ String.format("%02d", fromDate.getDayOfMonth()) + "000000";
				String toDateString = String.format("%04d", toDate.getYear())
						+ String.format("%02d", toDate.getMonth().getValue())
						+ String.format("%02d", toDate.getDayOfMonth()) + "000000";

				RangeTermQuery datesQuery = queries.dateRangeTerm("dates", true, true, fromDateString, toDateString);
				query.addMustQueryClauses(datesQuery);
			} else {
				long fromDateEpoch = fromDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000;
				long toDateEpoch = toDate.plusDays(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000;

				RangeTermQuery datesQuery = queries.rangeTerm(filterField, true, true, fromDateEpoch, toDateEpoch);
				query.addMustQueryClauses(datesQuery);
			}

		}

		// If SIG is complete (for Strasbourg places) put it on the request
		if(Validator.isNotNull(placeSigId)) {
			TermQuery placeQuery = queries.term("idSIGPlace", placeSigId);
			query.addMustQueryClauses(placeQuery);
		}

		// Random sort
		if(Validator.isNotNull(seed) && seed > 0) {
			RandomScoreFunction randomScoreFunction = scoreFunctions.random();
			randomScoreFunction.setSeed(seed);
			randomScoreFunction.setField("entryClassPK");

			// TODO Correct : function score for the random sort can't be called because of unsatisfied reference
			//FunctionScoreQuery functionScoreQuery = queries.functionScore(query);

			functionScoreQuery.addFilterQueryScoreFunctionHolder(query, randomScoreFunction);
		}

		superQuery.addShouldQueryClauses(query);

		return superQuery;
	}

	@Reference
	protected Sorts sorts;

	@Reference
	protected ScoreFunctions scoreFunctions;

	/*
	 * @notes GogoShell result using scr:info on this component :
	 *   functionScoreQuery: com.liferay.portal.search.query.FunctionScoreQuery UNSATISFIED 1..1 static target=(*) scope=bundle
	 * */
	@Reference
	protected FunctionScoreQuery functionScoreQuery;

	/*
	* @notes GogoShell result using scr:info on this component :
	*   groupByRequest: com.liferay.portal.search.groupby.GroupByRequest UNSATISFIED 1..1 static target=(*) scope=bundle
    * */
	@Reference
	protected GroupByRequest groupByRequest;

	@Reference
	protected Queries queries;

	@Reference
	protected Searcher searcher;

	@Reference
	protected SearchRequestBuilderFactory searchRequestBuilderFactory;

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}