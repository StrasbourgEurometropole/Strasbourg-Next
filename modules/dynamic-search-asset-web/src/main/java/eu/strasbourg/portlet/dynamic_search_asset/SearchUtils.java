package eu.strasbourg.portlet.dynamic_search_asset;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.search.document.Document;
import com.liferay.portal.search.hits.SearchHit;
import com.liferay.portal.search.hits.SearchHits;
import eu.strasbourg.portlet.dynamic_search_asset.configuration.DynamicSearchAssetConfiguration;
import eu.strasbourg.portlet.dynamic_search_asset.constants.Constants;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.service.search.log.model.SearchLog;
import eu.strasbourg.service.search.log.service.SearchLogLocalServiceUtil;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.LayoutHelper;
import eu.strasbourg.utils.PortalHelper;
import eu.strasbourg.utils.bean.AssetType;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

public class SearchUtils {
    /**
     * Récupération de l'URL de base du site pour le lien vers les pages des entités
     */
    public static String getHomeURL(ThemeDisplay themeDisplay) {
        return PortalHelper.getHomeURL(themeDisplay) +"/";
    }

    public static void logSearchChoice(ResourceRequest request) {
        // On logue le choix de l'utilsateur
        long searchLogId = ParamUtil.getLong(request, "searchLogId");
        SearchLog searchLog = SearchLogLocalServiceUtil.fetchSearchLog(searchLogId);
        if (searchLog != null) {
            long userTargetClassId = ParamUtil.getLong(request, "classNameId");
            long userTargetClassPK = ParamUtil.getLong(request, "classPK");
            String userTargetTitle = ParamUtil.getString(request, "title");
            searchLog.setUserTargetClassId(userTargetClassId);
            searchLog.setUserTargetClassPK(userTargetClassPK);
            searchLog.setUserTargetTitle(userTargetTitle);
            SearchLogLocalServiceUtil.updateSearchLog(searchLog);
        }
    }

    public static void logSearch(ResourceRequest request, List<AssetEntry> assetEntries, String keywords, long totalResult, long searchTime, JSONArray jsonResponse) throws PortalException {
        // Gestion du log
        JSONObject jsonSearchLog = JSONFactoryUtil.createJSONObject();
        ServiceContext sc = ServiceContextFactory.getInstance(request);
        AssetEntry result1 = assetEntries.size() > 0 ? assetEntries.get(0) : null;
        AssetEntry result2 = assetEntries.size() > 1 ? assetEntries.get(1) : null;
        AssetEntry result3 = assetEntries.size() > 2 ? assetEntries.get(2) : null;
        SearchLog searchLog = SearchLogLocalServiceUtil.addSearchLog(sc, keywords,
                totalResult, result1, result2, result3, null, searchTime);
        jsonSearchLog.put("searchLogId", searchLog.getSearchLogId());
        jsonResponse.put(jsonSearchLog);
    }





    public static List<AssetEntry> getAssetEntriesFromSearchHits(SearchHits searchHits, ThemeDisplay themeDisplay, long groupId) throws PortalException {
        List<AssetEntry> results = new ArrayList<>();

        // Get active budget phase and its category
        BudgetPhase activePhase = BudgetPhaseLocalServiceUtil.getActivePhase(groupId);
        AssetCategory activePhaseCategory = activePhase != null ? activePhase.getPhaseCategory() : null;

        if (searchHits != null) {
            // Iterate through each document in search results
            for (SearchHit hit : searchHits.getSearchHits()) {
                Document document = hit.getDocument();
                AssetEntry entry = fetchAssetEntryFromHit(document);
                if (entry != null && isValidEntry(entry, document, activePhaseCategory, themeDisplay)) {
                    results.add(entry);
                }
            }
        }

        return results;
    }

    private static AssetEntry fetchAssetEntryFromHit(Document document) {
        return AssetEntryLocalServiceUtil.fetchEntry(
                document.getString(Field.ENTRY_CLASS_NAME),
                document.getLong(Field.ENTRY_CLASS_PK)
        );
    }

    private static boolean isValidEntry(AssetEntry entry, Document document, AssetCategory activePhaseCategory, ThemeDisplay themeDisplay) throws PortalException {
        if (isBudgetParticipatifEntry(document) && !isInActivePhase(entry, activePhaseCategory)) {
            return false;
        }

        return true;
    }

    private static boolean isBudgetParticipatifEntry(Document document) {
        return "eu.strasbourg.service.project.model.BudgetParticipatif".equals(document.getString(Field.ENTRY_CLASS_NAME));
    }

    private static boolean isInActivePhase(AssetEntry entry, AssetCategory activePhaseCategory) {
        return activePhaseCategory != null && AssetVocabularyHelper.hasAssetCategoryAssetEntry(entry.getEntryId(), activePhaseCategory.getCategoryId());
    }

    private static boolean isJournalArticleEntry(Document document) {
        return JournalArticle.class.getName().equals(document.getString(Field.ENTRY_CLASS_NAME));
    }

    private static boolean hasValidLayout(AssetEntry entry, ThemeDisplay themeDisplay) throws PortalException {
        try {
            JournalArticle journalArticle = JournalArticleServiceUtil.getLatestArticle(entry.getClassPK());
            String url = LayoutHelper.getJournalArticleLayoutURL(journalArticle.getGroupId(), journalArticle.getArticleId(), themeDisplay);
            return Validator.isNotNull(url);
        } catch (PortalException e) {
            return false;
        }
    }

    /**
     * Applique un comportement de filtrage suplémentaire selon le template
     * de formulaire configuré
     */
    public static void applyTemplateBehaviors(DynamicSearchAssetConfiguration configuration, List<AssetEntry> assetEntries) {

        String searchForm = configuration.searchForm();

        // Comportement(s) : Plateforme-Citoyenne
        if (eu.strasbourg.portlet.dynamic_search_asset.constants.Constants.SEARCH_FORM_PLACIT.equals(searchForm)) {// Parcours des résultats
            for (Iterator<AssetEntry> results = assetEntries.iterator(); results.hasNext(); ) {
                AssetEntry assetEntry = results.next();

                String assetClassName = assetEntry.getClassName();

                // Retirer les événements n'appartenant pas à Placit via le tag dédié
                if (assetClassName.equals(Event.class.getName())) {
                    List<String> assetTags = Arrays.asList(assetEntry.getTagNames());

                    if (!assetTags.contains(eu.strasbourg.portlet.dynamic_search_asset.constants.Constants.PLACIT_TAG)) {
                        results.remove();
                    }
                }

                // Retirer les vidéos n'appartenant pas à Placit via le tag dédié
                if (assetClassName.equals(Video.class.getName())) {
                    List<String> assetTags = Arrays.asList(assetEntry.getTagNames());

                    if (!assetTags.contains(Constants.PLACIT_TAG)) {
                        results.remove();
                    }
                }

            }
        }
    }

}