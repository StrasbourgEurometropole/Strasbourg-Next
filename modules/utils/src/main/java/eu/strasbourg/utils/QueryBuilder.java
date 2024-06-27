package eu.strasbourg.utils;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.query.*;
import com.liferay.portal.search.query.function.score.RandomScoreFunction;
import com.liferay.portal.search.query.function.score.ScoreFunctions;
import eu.strasbourg.utils.bean.AssetPrefilter;
import eu.strasbourg.utils.bean.AssetType;
import org.osgi.service.component.annotations.Reference;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Locale;

public class QueryBuilder {
    protected Queries queries;

    private BooleanQuery superQuery;
    private BooleanQuery query;

    public QueryBuilder(Queries queries) {
        this.queries = queries;
        this.superQuery = queries.booleanQuery();
        this.query = queries.booleanQuery();
    }

    public QueryBuilder withAssetTypes(List<AssetType> assetTypes, List<String> classNamesOrStructuresSelected, String keywords) {
        BooleanQuery assetTypesQuery = queries.booleanQuery();
        if (classNamesOrStructuresSelected.size() > 0) {
            for (AssetType assetType : assetTypes) {
                if (Validator.isNull(assetType) || Validator.isNull(assetType.getClassName()) || (!classNamesOrStructuresSelected.contains(assetType.getClassName()) && !classNamesOrStructuresSelected.contains("" + assetType.getStructureID()))) {
                    continue;
                }
                BooleanQuery assetTypeQuery = buildAssetTypeQuery(assetType, keywords);
                assetTypesQuery.addShouldQueryClauses(assetTypeQuery);

            }
        } else {
            BooleanQuery assetTypeQuery = queries.booleanQuery();
            TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, "");
            assetTypeQuery.addMustQueryClauses(classNameQuery);
            assetTypesQuery.addShouldQueryClauses(assetTypeQuery);
        }
        this.query.addMustQueryClauses(assetTypesQuery);
        return this;
    }

    // Extract the asset type query logic to a separate method
    private BooleanQuery buildAssetTypeQuery(AssetType assetType, String keywords) {
        BooleanQuery assetTypeQuery = queries.booleanQuery();
        // ClassNames
        if (assetType.getClassName().equals("searchJournalArticle")) {
            // Cas d'un journalArticle
            TermQuery journalArticleClassNameQuery = queries.term(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
            // on vérifie que c'est la dernière version
            TermQuery journalArticleHeadQuery = queries.term("head", true);
            assetTypeQuery.addMustQueryClauses(journalArticleClassNameQuery, journalArticleHeadQuery);
            // ajout de la structure du contenu web
            if (Validator.isNotNull(assetType.getStructureID())) {
                TermQuery structureQuery = queries.term(Field.CLASS_TYPE_ID, assetType.getStructureID());
                assetTypeQuery.addMustQueryClauses(structureQuery);
            }

        } else {
            if (assetType.getClassName().equals("searchDocument")) {
                // Cas d'un fichier
                TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
                assetTypeQuery.addMustQueryClauses(classNameQuery);
            } else {
                if (assetType.getClassName().equals("searchDemarche")) {
                    // Cas d'une procédures/démarches
                    BooleanQuery procedureQuery = queries.booleanQuery();
                    TermQuery typeQuery = queries.term("type", "procedure");
                    TermQuery titleQuery = queries.term("title", keywords);
                    procedureQuery.addShouldQueryClauses(typeQuery, titleQuery);
                    // On rajoute la condition à la requête principale
                    superQuery.addShouldQueryClauses(procedureQuery);
                } else {
                    // Cas général
                    TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, assetType.getClassName());
                    assetTypeQuery.addMustQueryClauses(classNameQuery);
                }
            }
        }

        // Groups
        if (assetType.getScopeGroupIDs().size() > 0) {
            BooleanQuery groupsQuery = queries.booleanQuery();
            for (Long groupId : assetType.getScopeGroupIDs()) {
                TermQuery groupQuery = queries.term(Field.GROUP_ID, groupId);
                groupsQuery.addShouldQueryClauses(groupQuery);
            }
            assetTypeQuery.addMustQueryClauses(groupsQuery);
        }

        // Préfiltres
        if (assetType.getAssetPrefilterList().size() > 0) {
            BooleanQuery prefiltersQuery = queries.booleanQuery();
            for (AssetPrefilter prefilter : assetType.getAssetPrefilterList()) {
                if (prefilter.getType().equals("tags")) {
                    BooleanQuery tagsQuery = queries.booleanQuery();
                    for (Long tagId : prefilter.getCategoryOrTagIdList()) {
                        TermQuery tagQuery = queries.term(Field.ASSET_TAG_IDS, String.valueOf(tagId));
                        if (prefilter.getOperator().equals("all")) {
                            tagsQuery.addMustQueryClauses(tagQuery);
                        } else {
                            tagsQuery.addShouldQueryClauses(tagQuery);
                        }
                    }
                    // si true alors contient
                    if (prefilter.isIncludeOrExclude()) {
                        prefiltersQuery.addMustQueryClauses(tagsQuery);
                    } else {
                        prefiltersQuery.addMustNotQueryClauses(tagsQuery);
                    }
                } else {
                    BooleanQuery categoriesQuery = queries.booleanQuery();
                    for (Long categoryId : prefilter.getCategoryOrTagIdList()) {
                        TermQuery categoryQuery = queries.term(Field.ASSET_CATEGORY_IDS, String.valueOf(categoryId));
                        if (prefilter.getOperator().equals("all")) {
                            categoriesQuery.addMustQueryClauses(categoryQuery);
                        } else {
                            categoriesQuery.addShouldQueryClauses(categoryQuery);
                        }
                    }
                    // si true alors contient
                    if (prefilter.isIncludeOrExclude()) {
                        prefiltersQuery.addMustQueryClauses(categoriesQuery);
                    } else {
                        prefiltersQuery.addMustNotQueryClauses(categoriesQuery);
                    }
                }
            }
            assetTypeQuery.addMustQueryClauses(prefiltersQuery);
        }
        return assetTypeQuery;
    }

    public QueryBuilder withStatus(int status) {
        // Statut et visibilité
        TermQuery statusQuery = queries.term(Field.STATUS, status);
        query.addMustQueryClauses(statusQuery);
        return this;
    }

    public QueryBuilder withVisible(boolean visible) {
        TermQuery statusQuery = queries.term("visible", visible);
        query.addMustQueryClauses(statusQuery);
        return this;
    }

    public QueryBuilder withDateBeforeToday() {
        // Date de publication
        RangeTermQuery publicationDateQuery = queries.rangeTerm(Field.PUBLISH_DATE + "_sortable", true, true, 0, Timestamp.valueOf(LocalDateTime.now()).toInstant().toEpochMilli());
        query.addMustQueryClauses(publicationDateQuery);
        return this;
    }

    public QueryBuilder withKeywords(String keywords, Locale locale) {
        // Mots-clés
        if (Validator.isNotNull(keywords)) {
            BooleanQuery keywordQuery = queries.booleanQuery();

            // Fuzzy sur titre
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
//					"auto_generate_synonyms_phrase_query" : true,
            titleQueryWithoutAnalyzer.setBoost(3.0f);
            FunctionScoreQuery functionScoreQueryTitleQueryWithoutAnalyzer =
                    queries.functionScore(titleQueryWithoutAnalyzer);
            functionScoreQueryTitleQueryWithoutAnalyzer.setBoost(3.0f);
            keywordQuery.addShouldQueryClauses(functionScoreQueryTitleQueryWithoutAnalyzer);
            keywordQuery.addShouldQueryClauses(titleQueryWithoutAnalyzer);

            // Wildcard sur titre
            WildcardQuery titleWildcardQuery = queries.wildcard(Field.TITLE + "_" + locale,
                    "*" + keywords + "*");
            titleWildcardQuery.setBoost(30.0f);
            FunctionScoreQuery functionScoreQueryTitleWildcard =
                    queries.functionScore(titleWildcardQuery);
            functionScoreQueryTitleWildcard.setBoost(30.0f);
            keywordQuery.addShouldQueryClauses(functionScoreQueryTitleWildcard);
            keywordQuery.addShouldQueryClauses(titleWildcardQuery);

            // Description
            MatchQuery descriptionQuery = queries.match(Field.DESCRIPTION + "_" + locale, keywords);
            descriptionQuery.setOperator(Operator.OR);
            descriptionQuery.setPrefixLength(0);
            descriptionQuery.setMaxExpansions(50);
            descriptionQuery.setFuzzyTranspositions(true);
            descriptionQuery.setLenient(false);
            descriptionQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//					"auto_generate_synonyms_phrase_query" : true,
            keywordQuery.addShouldQueryClauses(descriptionQuery);

            // Pour les fichiers on recherche dans le champ "title" sans la
            // locale car il est indexé uniquement comme cela
            MatchQuery fileTitleQuery = queries.match(Field.TITLE, keywords);
            fileTitleQuery.setOperator(Operator.OR);
            // fileTitleQuery.setFuzziness(10f);
            fileTitleQuery.setPrefixLength(0);
            fileTitleQuery.setMaxExpansions(50);
            fileTitleQuery.setFuzzyTranspositions(true);
            fileTitleQuery.setLenient(false);
            fileTitleQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//			"auto_generate_synonyms_phrase_query" : true,

            TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());

            BooleanQuery fileQuery = queries.booleanQuery();
            fileQuery.addMustQueryClauses(fileTitleQuery, classNameQuery);
            keywordQuery.addShouldQueryClauses(fileQuery);

            // Fuzzy sur content (tous les champs indexables des structures
            // de CW et de D&M sont dans ce champ)
            MatchQuery contentQuery = queries.match(Field.CONTENT + "_" + locale, keywords);
            contentQuery.setOperator(Operator.OR);
            // contentQuery.setFuzziness(1f);
            contentQuery.setPrefixLength(0);
            contentQuery.setMaxExpansions(50);
            contentQuery.setFuzzyTranspositions(true);
            contentQuery.setLenient(false);
            contentQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//			"auto_generate_synonyms_phrase_query" : true,
            keywordQuery.addShouldQueryClauses(contentQuery);

            // Fuzzy sur catégorie
            MatchQuery categoryKeywordQuery = queries.match(Field.ASSET_CATEGORY_TITLES + '_' + locale, keywords);
            categoryKeywordQuery.setOperator(Operator.OR);
            // categoryKeywordQuery.setFuzziness(10f);
            categoryKeywordQuery.setPrefixLength(0);
            categoryKeywordQuery.setMaxExpansions(50);
            categoryKeywordQuery.setFuzzyTranspositions(true);
            categoryKeywordQuery.setLenient(false);
            categoryKeywordQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//			"auto_generate_synonyms_phrase_query" : true,
            keywordQuery.addShouldQueryClauses(categoryKeywordQuery);

            // Fuzzy sur tags
            MatchQuery tagKeywordQuery = queries.match(Field.ASSET_TAG_NAMES, keywords);
            tagKeywordQuery.setOperator(Operator.OR);
            // tagKeywordQuery.setFuzziness(10f);
            tagKeywordQuery.setPrefixLength(0);
            tagKeywordQuery.setMaxExpansions(50);
            tagKeywordQuery.setFuzzyTranspositions(true);
            tagKeywordQuery.setLenient(false);
            tagKeywordQuery.setZeroTermsQuery(com.liferay.portal.search.query.MatchQuery.ZeroTermsQuery.NONE);
//			"auto_generate_synonyms_phrase_query" : true,
            keywordQuery.addShouldQueryClauses(tagKeywordQuery);

            query.addMustQueryClauses(keywordQuery);
        } else {
            // Si on n'a pas de keyword : on ne veut que les entités de la
            // langue en cours tout de même
            // Pour cela on vérifie que le champ "title_{locale}" n'est pas
            // vide On ne fait pas cela pour les fichiers car ils n'ont pas
            // de champ titre traduit
            BooleanQuery anyKeywordQuery = queries.booleanQuery();
            TermQuery classNameQuery = queries.term(Field.ENTRY_CLASS_NAME, DLFileEntry.class.getName());
            anyKeywordQuery.addShouldQueryClauses(classNameQuery);


            WildcardQuery anyKeywordWildcardQuery = queries.wildcard("title_" + locale, "*");
            anyKeywordQuery.addShouldQueryClauses(anyKeywordWildcardQuery);

            query.addMustQueryClauses(anyKeywordQuery);
        }
        return this;
    }

    public QueryBuilder withDate(String filterField, LocalDate fromDate, LocalDate toDate) {
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

        return this;

    }

    public QueryBuilder withCategories(List<Long[]> categoriesIds) {
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
        return this;
    }

    public QueryBuilder withPlace(String placeSigId) {
        if (Validator.isNotNull(placeSigId)) {
            MatchQuery placeQuery = queries.match("idSIGPlace", placeSigId);
            this.query.addMustQueryClauses(placeQuery);
        }
        return this;
    }

    public Query build() {
        this.superQuery.addShouldQueryClauses(this.query);
        return this.superQuery;
    }

    public String getJSON() {
        return this.superQuery.toString();
    }
}
