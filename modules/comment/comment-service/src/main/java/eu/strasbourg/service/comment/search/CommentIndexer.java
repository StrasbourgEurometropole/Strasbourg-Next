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
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.IndexHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class CommentIndexer extends BaseIndexer<Comment> {

	public static final String CLASS_NAME = Comment.class.getName();
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

	public CommentIndexer() {
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(Comment comment) throws Exception {
		deleteDocument(comment.getCompanyId(), comment.getCommentId());
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
		String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) {
		return createSummary(document, Field.USER_NAME, Field.URL);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Comment entry = CommentLocalServiceUtil.getComment(classPK);
		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}
	
	@Override
	protected void doReindex(Comment comment) throws Exception {
		Document document = getDocument(comment);

		IndexWriterHelperUtil.updateDocument(comment.getCompanyId(), document);

	}
	
	protected void reindexEntries(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = CommentLocalServiceUtil
			.getIndexableActionableDynamicQuery();
		indexableActionableDynamicQuery.setAddCriteriaMethod(dynamicQuery -> {});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
				(ActionableDynamicQuery.PerformActionMethod<Comment>) comment -> {
					try {
						Document document = getDocument(comment);
						indexableActionableDynamicQuery.addDocuments(document);
					} catch (PortalException pe) {
						_log.error("Unable to index comment comment "
							+ comment.getCommentId());
					}
				});

		indexableActionableDynamicQuery.performActions();
	}

	@Override
	protected Document doGetDocument(Comment comment) {
		Document document = getBaseModelDocument(CLASS_NAME, comment);
		// TODO Remettre les catégories quand le problème de l'indexation des commentaires sera résolu
//		long[] assetCategorIds = AssetVocabularyHelper.getFullHierarchyCategoriesIds(comment.getCategories());
//		List<AssetCategory> assetCategories = AssetVocabularyHelper.getFullHierarchyCategories(comment.getCategories());
//		document.addKeyword(Field.ASSET_CATEGORY_IDS,assetCategorIds);
//		IndexHelper.addAssetCategoryTitles(document,Field.ASSET_CATEGORY_TITLES,assetCategories);
		document.addNumber(Field.STATUS, comment.getStatus());
		document.addNumber("reportings", comment.getCountSignalements());
		document.addTextSortable("entityType",comment.getTypeAssetEntry());
		document.addTextSortable("entityName",comment.getAssetEntryTitle());
		document.addTextSortable(Field.TITLE, comment.getUserName());
		document.addLocalizedText(Field.DESCRIPTION, comment.getTextMap());
		return document;
	}
}
