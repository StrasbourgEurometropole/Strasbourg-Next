package eu.strasbourg.service.comment.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import eu.strasbourg.service.comment.model.Signalement;
import eu.strasbourg.service.comment.service.SignalementLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.List;
import java.util.Locale;

/**
 * @author alexandre.quere
 */
@Component(immediate = true, service = Indexer.class)
public class SignalementIndexer extends BaseIndexer<Signalement> {
    private static final String CLASS_NAME = Signalement.class.getName();
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    public SignalementIndexer() {
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    protected void doDelete(Signalement signalement) throws Exception {
        deleteDocument(signalement.getCompanyId(), signalement.getSignalementId());
    }

    @Override
    protected Summary doGetSummary(Document document, Locale locale,
                                   String snippet, PortletRequest portletRequest,
                                   PortletResponse portletResponse) {
        return createSummary(document, Field.USER_NAME, Field.URL);
    }

    @Override
    protected void doReindex(String className, long classPK) throws Exception {
        Signalement entry = SignalementLocalServiceUtil.getSignalement(classPK);
        doReindex(entry);
    }

    @Override
    protected void doReindex(String[] ids) throws Exception {
        long companyId = GetterUtil.getLong(ids[0]);
        reindexEntries(companyId);
    }

    @Override
    protected void doReindex(Signalement signalement) throws Exception {
        Document document = getDocument(signalement);

        IndexWriterHelperUtil.updateDocument(signalement.getCompanyId(), document);

    }

    protected void reindexEntries(long companyId) throws PortalException {
        final IndexableActionableDynamicQuery indexableActionableDynamicQuery = SignalementLocalServiceUtil
                .getIndexableActionableDynamicQuery();
        indexableActionableDynamicQuery.setAddCriteriaMethod(dynamicQuery -> {});
        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod(
                (ActionableDynamicQuery.PerformActionMethod<Signalement>) signalement -> {
                    try {
                        Document document = getDocument(signalement);
                        indexableActionableDynamicQuery.addDocuments(document);
                    } catch (PortalException pe) {
                        _log.error("Unable to index signalement signalement "
                                + signalement.getSignalementId());
                    }
                });

        indexableActionableDynamicQuery.performActions();
    }

    @Override
    protected Document doGetDocument(Signalement signalement) {
        Document document = getBaseModelDocument(CLASS_NAME, signalement);
        long[] assetCategorIds = AssetVocabularyHelper
                .getFullHierarchyCategoriesIds(signalement.getCategoriesByAssetEntry());
        List<AssetCategory> assetCategories = AssetVocabularyHelper
                .getFullHierarchyCategories(signalement.getCategoriesByAssetEntry());
        document.addKeyword(Field.ASSET_CATEGORY_IDS,assetCategorIds);
        //addSearchAssetCategoryTitles(document,Field.ASSET_CATEGORY_TITLES,assetCategories);
        document.addTextSortable("reportType",signalement.getCategorieName());
        document.addTextSortable(Field.USER_NAME,signalement.getUserName());
        document.addNumber(Field.STATUS, signalement.getStatus());
        return document;
    }
}
