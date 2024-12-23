package eu.strasbourg.service.activity.search;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.IndexHelper;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.List;
import java.util.Locale;

@Component(immediate = true, service = Indexer.class)
public class ActivityCourseIndexer extends BaseIndexer<ActivityCourse> {

	public static final String CLASS_NAME = ActivityCourse.class.getName();

	public ActivityCourseIndexer() {
		setDefaultSelectedFieldNames(
				Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
				Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
				Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	protected void doDelete(ActivityCourse activityCourse) throws Exception {
		deleteDocument(activityCourse.getCompanyId(), activityCourse.getActivityCourseId());
	}

	/**
	 * Fonction appelée lors de l'indexation de l'entité, c'est ici qu'on choisi
	 * les champs à indexer
	 */
	@Override
	protected Document doGetDocument(ActivityCourse activityCourse) throws Exception {
		Document document = getBaseModelDocument(CLASS_NAME, activityCourse);

		// On indexe toute la hiérarchie de catégories (parents et enfants des
		// catégories de l'entité)
		long[] assetCategoryIds = AssetVocabularyHelper
			.getFullHierarchyCategoriesIds(activityCourse.getCategories());
		List<AssetCategory> assetCategories = AssetVocabularyHelper
			.getFullHierarchyCategories(activityCourse.getCategories());
		document.addKeyword(Field.ASSET_CATEGORY_IDS, assetCategoryIds);

		IndexHelper.addAssetCategoryTitles(document, Field.ASSET_CATEGORY_TITLES,
			assetCategories);

		document.addLocalizedText(Field.TITLE, activityCourse.getNameMap());
		document.addNumber(Field.STATUS, activityCourse.getStatus());
		// little hack to allow guest user to see the activityCourse
		Company company  = CompanyLocalServiceUtil.fetchCompany(activityCourse.getCompanyId());
		document.addKeyword("sharedToUserId", List.of(company.getGuestUser().getUserId()).toArray(new Long[1]));
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
		String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) throws Exception {
		Summary summary = createSummary(document, Field.TITLE, Field.URL);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		ActivityCourse entry = ActivityCourseLocalServiceUtil.getActivityCourse(classPK);
		doReindex(entry);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	@Override
	protected void doReindex(ActivityCourse activityCourse) throws Exception {
		Document document = getDocument(activityCourse);

		IndexWriterHelperUtil.updateDocument(activityCourse.getCompanyId(), document);

	}

	protected void reindexEntries(long companyId) throws PortalException {
		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = ActivityCourseLocalServiceUtil
			.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {

				}
			});
		indexableActionableDynamicQuery.setCompanyId(companyId);
		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ActivityCourse>() {

				@Override
				public void performAction(ActivityCourse entry) {
					try {
						Document document = getDocument(entry);

						indexableActionableDynamicQuery.addDocuments(document);
					} catch (PortalException pe) {
						_log.error("Unable to index activityCourse entry "
							+ entry.getActivityCourseId());
					}
				}

			});

		indexableActionableDynamicQuery.performActions();
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
