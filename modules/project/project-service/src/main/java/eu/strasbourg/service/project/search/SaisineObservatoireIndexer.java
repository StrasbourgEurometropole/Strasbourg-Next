package eu.strasbourg.service.project.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.DateHelper;
import eu.strasbourg.utils.IndexHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.*;

/**
 * @author joshua.chacha
 */
@Component(immediate = true, service = Indexer.class)
public class SaisineObservatoireIndexer extends BaseIndexer<SaisineObservatoire> {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    public static final String CLASS_NAME = SaisineObservatoire.class.getName();

    public SaisineObservatoireIndexer() {
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    protected void doDelete(SaisineObservatoire saisineObservatoire) throws Exception {
        deleteDocument(saisineObservatoire.getCompanyId(), saisineObservatoire.getSaisineObservatoireId());
    }

    @Override
    protected Document doGetDocument(SaisineObservatoire saisineObservatoire) throws Exception {
        Document document = getBaseModelDocument(CLASS_NAME, saisineObservatoire);

        // On indexe toute la hiérarchie de catégories (parents et enfants des
        // catégories de l'entité)
        long[] assetCategoryIds = AssetVocabularyHelper
                .getFullHierarchyCategoriesIds(saisineObservatoire.getCategories());
        List<AssetCategory> assetCategories = AssetVocabularyHelper
                .getFullHierarchyCategories(saisineObservatoire.getCategories());
        document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);
        IndexHelper.addAssetCategoryTitles(document, Field.ASSET_CATEGORY_TITLES,
                assetCategories);

        Map<Locale, String> titleFieldMap = new HashMap<>();
        titleFieldMap.put(Locale.FRANCE, saisineObservatoire.getTitle());
        titleFieldMap.put(Locale.GERMANY, saisineObservatoire.getTitle());
        titleFieldMap.put(Locale.ENGLISH, saisineObservatoire.getTitle());

        Map<Locale, String> descriptionFieldMap = new HashMap<>();
        descriptionFieldMap.put(Locale.FRANCE, saisineObservatoire.getDescription());

        document.addLocalizedText(Field.TITLE, titleFieldMap);
        document.addLocalizedText(Field.DESCRIPTION, descriptionFieldMap);
        document.addNumber(Field.STATUS, saisineObservatoire.getStatus());
        return document;
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest, PortletResponse portletResponse) throws Exception {
        return createSummary(document, Field.TITLE, Field.URL);
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil.getSaisineObservatoire(classPK);
        doReindex(saisineObservatoire);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    @Override
    protected void doReindex(SaisineObservatoire saisineObservatoire) throws Exception {
        Document document = getDocument(saisineObservatoire);
        IndexWriterHelperUtil.updateDocument(saisineObservatoire.getCompanyId(), document);
    }

    protected void reindexEntries(long companyId) throws PortalException {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = SaisineObservatoireLocalServiceUtil.getIndexableActionableDynamicQuery();
        indexableActionableDynamicQuery.setAddCriteriaMethod(dynamicQuery -> {
        });
        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod((ActionableDynamicQuery
                .PerformActionMethod<SaisineObservatoire>) saisineObservatoire -> {
            Document document = getDocument(saisineObservatoire);
            indexableActionableDynamicQuery.addDocuments(document);
        });
        indexableActionableDynamicQuery.performActions();
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }
}
