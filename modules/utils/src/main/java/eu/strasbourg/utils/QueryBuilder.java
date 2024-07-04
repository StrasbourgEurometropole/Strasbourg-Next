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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class QueryBuilder {
    protected Queries queries;

    private BooleanQuery superQuery;
    private BooleanQuery query;
    private BooleanQuery filterQuery;

    public QueryBuilder(Queries queries) {
        this.queries = queries;
        this.superQuery = queries.booleanQuery();
        this.query = queries.booleanQuery();
        this.filterQuery = queries.booleanQuery();
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
        this.filterQuery.addMustQueryClauses(assetTypesQuery);
        return this;
    }

    // Extract the asset type query logic to a separate method
    private BooleanQuery buildAssetTypeQuery(AssetType assetType, String keywords) {
        BooleanQuery assetTypeQuery = queries.booleanQuery();
        // ClassNames
        if (assetType.getClassName().equals("searchJournalArticle") || assetType.getClassName().equals(JournalArticle.class.getName())) {
            // Cas d'un journalArticle
            TermQuery journalArticleClassNameQuery = queries.term(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
            // on vérifie que c'est la dernière version
            TermQuery journalArticleHeadQuery = queries.term("head", true);
            assetTypeQuery.addMustQueryClauses(journalArticleClassNameQuery);
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
        filterQuery.addMustQueryClauses(statusQuery);
        return this;
    }

    public QueryBuilder withoutTags(List<String> tagNames) {
        BooleanQuery tagsQuery = queries.booleanQuery();
        for (String tagId :tagNames){
            TermQuery tagQuery = queries.term(Field.ASSET_TAG_NAMES, tagId);
            tagsQuery.addMustNotQueryClauses(tagQuery);
        }
        filterQuery.addMustQueryClauses(tagsQuery);
        return this;
    }

    public QueryBuilder withVisible(boolean visible) {
        TermQuery statusQuery = queries.term("visible", visible);
        filterQuery.addMustQueryClauses(statusQuery);
        return this;
    }

    public QueryBuilder withDateBeforeToday() {
        // Date de publication
        RangeTermQuery publicationDateQuery = queries.rangeTerm(Field.PUBLISH_DATE + "_sortable", true, true, 0, Timestamp.valueOf(LocalDateTime.now()).toInstant().toEpochMilli());
        filterQuery.addMustQueryClauses(publicationDateQuery);
        return this;
    }

    public BooleanQuery addKeywordField(String field, String keyword, Float boost, Boolean searchExact){
        BooleanQuery keywordQuery = queries.booleanQuery();

        MatchQuery matchQuery = queries.match(field, keyword);
        matchQuery.setBoost(boost);
        matchQuery.setFuzziness(1f);
        matchQuery.setOperator(Operator.OR);
        matchQuery.setAnalyzer("strasbourg_analyzer");

        MatchQuery matchApproxQuery = queries.match(field, keyword);
        matchApproxQuery.setBoost(boost);


        if(searchExact) {
            MatchQuery matchExactQuery = queries.match(field + ".exact", keyword);
            matchExactQuery.setBoost(boost + 2f);
            matchExactQuery.setAnalyzer("standard");
            keywordQuery.addShouldQueryClauses(matchExactQuery);
        }

        MatchPhraseQuery matchPhraseQuery = queries.matchPhrase(field, keyword);
        matchPhraseQuery.setSlop(5);
        matchPhraseQuery.setBoost(boost + 2f);
        matchPhraseQuery.setAnalyzer("strasbourg_analyzer");

        MatchPhrasePrefixQuery matchPhrasePrefixQuery = queries.matchPhrasePrefix(field, keyword);
        matchPhrasePrefixQuery.setSlop(5);
        matchPhrasePrefixQuery.setBoost(boost + 2f);
        matchPhrasePrefixQuery.setAnalyzer("strasbourg_analyzer");


        keywordQuery.addShouldQueryClauses(matchPhraseQuery, matchPhrasePrefixQuery, matchQuery, matchApproxQuery);

        return keywordQuery;

    }

    public QueryBuilder withKeywords(String keywords, Locale locale) {
        // Mots-clés
        if (Validator.isNotNull(keywords)) {
            Map<String, Float> fieldBoost = new HashMap<String, Float>() {{
                put(Field.TITLE + "_" + locale.toString(), 30f);
                put(Field.CONTENT + "_" + locale.toString(), 1f);
                put(Field.DESCRIPTION + "_" + locale.toString(), 1f);
                put(Field.ASSET_CATEGORY_TITLES + "_" + locale.toString(), 15f);
                put(Field.ASSET_TAG_NAMES  + "_" + locale.toString(), 15f);
            }};

            BooleanQuery shouldQuery = queries.booleanQuery();
            for(Map.Entry<String, Float> entry : fieldBoost.entrySet()) {
                BooleanQuery booleanQuery = addKeywordField(entry.getKey(), keywords, entry.getValue(), entry.getValue() > 20f);
                shouldQuery.addShouldQueryClauses(booleanQuery);
            }

            query.addMustQueryClauses(shouldQuery);
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
                filterQuery.addMustQueryClauses(datesQuery);
            } else {
                long fromDateEpoch = fromDate.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000;
                long toDateEpoch = toDate.plusDays(1).atStartOfDay().toEpochSecond(ZoneOffset.UTC) * 1000;

                RangeTermQuery datesQuery = queries.rangeTerm(filterField, true, true, fromDateEpoch, toDateEpoch);
                filterQuery.addMustQueryClauses(datesQuery);
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
            filterQuery.addMustQueryClauses(vocabularyQuery);
        }
        return this;
    }

    public QueryBuilder withPlace(String placeSigId) {
        if (Validator.isNotNull(placeSigId)) {
            MatchQuery placeQuery = queries.match("idSIGPlace", placeSigId);
            this.filterQuery.addMustQueryClauses(placeQuery);
        }
        return this;
    }

    public QueryBuilder withTags(List<String> tagNames) {
        BooleanQuery tagsQuery = queries.booleanQuery();
        for (String tagId :tagNames){
            TermQuery tagQuery = queries.term(Field.ASSET_TAG_NAMES, tagId);
            tagsQuery.addShouldQueryClauses(tagQuery);
        }
        filterQuery.addMustQueryClauses(tagsQuery);
        return this;
    }

    public Query build() {
        this.superQuery.addMustQueryClauses(this.query);
        this.superQuery.addFilterQueryClauses(this.filterQuery);

        return this.superQuery;
    }

    public String getJSON() {
        return this.superQuery.toString();
    }
}
