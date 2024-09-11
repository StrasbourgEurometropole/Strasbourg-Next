package eu.strasbourg.service.activity.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.service.persistence.PortletUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.IndexHelper;
import eu.strasbourg.utils.PortletHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.*;

@Component(immediate = true, service = Indexer.class)
public class ActivityIndexer extends BaseIndexer<Activity> {

    public static final String CLASS_NAME = Activity.class.getName();

    public ActivityIndexer() {
        setFilterSearch(true);
        setPermissionAware(false);
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    protected void doDelete(Activity activity) throws Exception {
        deleteDocument(activity.getCompanyId(), activity.getActivityId());
    }

    /**
     * Fonction appelée lors de l'indexation de l'entité, c'est ici qu'on choisi
     * les champs à indexer
     */
    @Override
    protected Document doGetDocument(Activity activity) throws Exception {
        // Obtient le document du modèle de base pour le nom de classe et l'activité donnés
        Document document = getBaseModelDocument(CLASS_NAME, activity);

        // Indexe l'ensemble de la hiérarchie des catégories (parents et enfants) associées à l'activité
        List<AssetCategory> allCategories = new ArrayList<>(activity.getCategories());
        long[] assetCategoryIds = AssetVocabularyHelper.getFullHierarchyCategoriesIds(allCategories);
        List<String> assetVocabularyCategoryIds = new ArrayList<>();

        // Parcours chaque catégorie d'actif dans la hiérarchie
        for (AssetCategory assetCategory : allCategories) {
            assetCategoryIds = ArrayUtil.append(assetCategoryIds, assetCategory.getCategoryId());
            assetVocabularyCategoryIds.add(getVocabularyCategoryId(assetCategory));
        }

        // Obtient les catégories des cours associés à l'activité
        for (ActivityCourse activityCourse : activity.getActivityCourses()) {
            List<AssetCategory> coursesCategories = AssetVocabularyHelper.getFullHierarchyCategories(activityCourse.getCategories());
            allCategories.addAll(coursesCategories);

            // Ajoute les catégories de cours à assetCategoryIds
            for (AssetCategory assetCategory : coursesCategories) {
                assetCategoryIds = ArrayUtil.append(assetCategoryIds, assetCategory.getCategoryId());
                assetVocabularyCategoryIds.add(getVocabularyCategoryId(assetCategory));
            }
        }

        // Assure qu'il n'y a pas d'identifiants de catégorie en double
        assetCategoryIds = ArrayUtil.unique(assetCategoryIds);

        // Supprime les entrées en double dans la liste de chaînes
        assetVocabularyCategoryIds = new ArrayList<>(new HashSet<>(assetVocabularyCategoryIds));

        // Ajoute des mots-clés et des champs indexés au document
        addKeywordsAndIndexedFields(document, assetVocabularyCategoryIds, assetCategoryIds, allCategories);

        // Ajoute des champs de texte localisés au document
        addLocalizedTextFields(document, activity);

        // Ajoute le contenu de superposition et l'étiquette de type au document
        addOverlayAndTypeLabel(document, activity);

        // Ajoute l'ID de l'entité image au document
        document.addNumber("imageEntityId", activity.getImageId());

// Retourne le document final
        return document;
    }


    // Méthode utilitaire pour obtenir l'ID de vocabulaire et de catégorie sous forme de chaîne
    private String getVocabularyCategoryId(AssetCategory assetCategory) {
        return assetCategory.getVocabularyId() + StringPool.DASH + assetCategory.getCategoryId();
    }

    // Méthode utilitaire pour ajouter des mots-clés et des champs indexés au document
    private void addKeywordsAndIndexedFields(Document document, List<String> vocabularyCategoryIds, long[] categoryIds, List<AssetCategory> categories) {
        document.addKeyword("assetVocabularyCategoryIds", vocabularyCategoryIds.toArray(new String[vocabularyCategoryIds.size()]));
        document.addKeyword(Field.ASSET_CATEGORY_IDS, categoryIds);
        IndexHelper.addAssetCategoryTitles(document, Field.ASSET_CATEGORY_TITLES, categories);
    }

    // Méthode utilitaire pour ajouter des champs de texte localisés au document
    private void addLocalizedTextFields(Document document, Activity activity) {
        document.addLocalizedText(Field.TITLE, activity.getTitleMap());
        document.addLocalizedText(Field.DESCRIPTION, activity.getDescriptionMap());
        document.addNumber(Field.STATUS, activity.getStatus());

        // Supprime les balises HTML de la description et limite sa longueur
        Map<Locale, String> descriptionWithoutHTML = new HashMap<>(activity.getDescriptionMap());
        descriptionWithoutHTML.replaceAll((k, v) -> truncateString(HtmlUtil.stripHtml(v), 150));
        document.addLocalizedText("descriptionWithoutHTML", descriptionWithoutHTML);
    }

    // Méthode utilitaire pour ajouter le contenu de superposition et l'étiquette de type au document
    private void addOverlayAndTypeLabel(Document document, Activity activity) {
        document.addLocalizedText("activityOverlayContent", getOverlayContent(activity));

        Map<Locale, String> typeLabelMap = new HashMap<>();
        for (Locale locale : LanguageUtil.getAvailableLocales()) {
            typeLabelMap.put(locale, activity.getTypesLabel(locale));
        }
        document.addLocalizedText("typeLabel", typeLabelMap);
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
        Summary summary = createSummary(document, Field.TITLE, Field.URL);
        return summary;
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        Activity entry = ActivityLocalServiceUtil.getActivity(classPK);
        doReindex(entry);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    @Override
    protected void doReindex(Activity activity) throws Exception {
        Document document = getDocument(activity);

        IndexWriterHelperUtil.updateDocument(activity.getCompanyId(), document);

    }

    protected void reindexEntries(long companyId) throws PortalException {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = ActivityLocalServiceUtil.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
            @Override
            public void addCriteria(DynamicQuery dynamicQuery) {

            }
        });
        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Activity>() {

            @Override
            public void performAction(Activity entry) {
                try {
                    Document document = getDocument(entry);

                    indexableActionableDynamicQuery.addDocuments(document);
                } catch (PortalException pe) {
                    _log.error("Unable to index activity entry " + entry.getActivityId());
                }
            }

        });

        indexableActionableDynamicQuery.performActions();
    }

    private Map<Locale, String> getOverlayContent(Activity activity) {
        Map<Locale, String> mapOverlay = new HashMap<>();

        for (Locale locale : LanguageUtil.getAvailableLocales()) {
            JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
            for (ActivityCourse activityCourse : activity.getActivityCourses()) {
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("activityCourseId", activityCourse.getActivityCourseId());
                json.put("name", activityCourse.getName(locale));
                json.put("typesLabels", activityCourse.getTypesLabels(locale));
                json.put("publicsLabel", activityCourse.getPublicsLabel(locale));
                json.put("duration", activityCourse.getDuration());
                json.put("placeNames", String.join(", ", activityCourse.getPlaceNames(locale)));
                json.put("description", HtmlUtil.stripHtml(activityCourse.getPresentation(locale)));
                jsonArray.put(json);
            }
            mapOverlay.put(locale, jsonArray.toJSONString());
        }

        return mapOverlay;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    private static String truncateString(String input, int characterLimit) {
        if (input.length() > characterLimit) {
            return input.substring(0, characterLimit) + "...";
        } else {
            return input;
        }
    }
}
