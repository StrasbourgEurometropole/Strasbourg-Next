/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.activity.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetLinkPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.service.activity.service.ActivityOrganizerLocalService;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePlacePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCourseSchedulePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityOrganizerPersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityPersistence;
import eu.strasbourg.service.activity.service.persistence.AssociationPersistence;
import eu.strasbourg.service.activity.service.persistence.PracticePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the activity organizer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.activity.service.impl.ActivityOrganizerLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.activity.service.impl.ActivityOrganizerLocalServiceImpl
 * @see eu.strasbourg.service.activity.service.ActivityOrganizerLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ActivityOrganizerLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements ActivityOrganizerLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link eu.strasbourg.service.activity.service.ActivityOrganizerLocalServiceUtil} to access the activity organizer local service.
	 */

	/**
	 * Adds the activity organizer to the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ActivityOrganizer addActivityOrganizer(
		ActivityOrganizer activityOrganizer) {
		activityOrganizer.setNew(true);

		return activityOrganizerPersistence.update(activityOrganizer);
	}

	/**
	 * Creates a new activity organizer with the primary key. Does not add the activity organizer to the database.
	 *
	 * @param activityOrganizerId the primary key for the new activity organizer
	 * @return the new activity organizer
	 */
	@Override
	public ActivityOrganizer createActivityOrganizer(long activityOrganizerId) {
		return activityOrganizerPersistence.create(activityOrganizerId);
	}

	/**
	 * Deletes the activity organizer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer that was removed
	 * @throws PortalException if a activity organizer with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ActivityOrganizer deleteActivityOrganizer(long activityOrganizerId)
		throws PortalException {
		return activityOrganizerPersistence.remove(activityOrganizerId);
	}

	/**
	 * Deletes the activity organizer from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ActivityOrganizer deleteActivityOrganizer(
		ActivityOrganizer activityOrganizer) {
		return activityOrganizerPersistence.remove(activityOrganizer);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ActivityOrganizer.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return activityOrganizerPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return activityOrganizerPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return activityOrganizerPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return activityOrganizerPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return activityOrganizerPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public ActivityOrganizer fetchActivityOrganizer(long activityOrganizerId) {
		return activityOrganizerPersistence.fetchByPrimaryKey(activityOrganizerId);
	}

	/**
	 * Returns the activity organizer matching the UUID and group.
	 *
	 * @param uuid the activity organizer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchActivityOrganizerByUuidAndGroupId(
		String uuid, long groupId) {
		return activityOrganizerPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity organizer with the primary key.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer
	 * @throws PortalException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer getActivityOrganizer(long activityOrganizerId)
		throws PortalException {
		return activityOrganizerPersistence.findByPrimaryKey(activityOrganizerId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(activityOrganizerLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ActivityOrganizer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityOrganizerId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(activityOrganizerLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ActivityOrganizer.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"activityOrganizerId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(activityOrganizerLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ActivityOrganizer.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("activityOrganizerId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion = portletDataContext.getDateRangeCriteria(
							"modifiedDate");

					Criterion statusDateCriterion = portletDataContext.getDateRangeCriteria(
							"statusDate");

					if ((modifiedDateCriterion != null) &&
							(statusDateCriterion != null)) {
						Disjunction disjunction = RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty = PropertyFactoryUtil.forName(
							"status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler = StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(ActivityOrganizer.class.getName());

						dynamicQuery.add(workflowStatusProperty.in(
								stagedModelDataHandler.getExportableStatuses()));
					}
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<ActivityOrganizer>() {
				@Override
				public void performAction(ActivityOrganizer activityOrganizer)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						activityOrganizer);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(ActivityOrganizer.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return activityOrganizerLocalService.deleteActivityOrganizer((ActivityOrganizer)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return activityOrganizerPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the activity organizers matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity organizers
	 * @param companyId the primary key of the company
	 * @return the matching activity organizers, or an empty list if no matches were found
	 */
	@Override
	public List<ActivityOrganizer> getActivityOrganizersByUuidAndCompanyId(
		String uuid, long companyId) {
		return activityOrganizerPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of activity organizers matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity organizers
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity organizers, or an empty list if no matches were found
	 */
	@Override
	public List<ActivityOrganizer> getActivityOrganizersByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator) {
		return activityOrganizerPersistence.findByUuid_C(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	 * Returns the activity organizer matching the UUID and group.
	 *
	 * @param uuid the activity organizer's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity organizer
	 * @throws PortalException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer getActivityOrganizerByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return activityOrganizerPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the activity organizers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of activity organizers
	 */
	@Override
	public List<ActivityOrganizer> getActivityOrganizers(int start, int end) {
		return activityOrganizerPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of activity organizers.
	 *
	 * @return the number of activity organizers
	 */
	@Override
	public int getActivityOrganizersCount() {
		return activityOrganizerPersistence.countAll();
	}

	/**
	 * Updates the activity organizer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param activityOrganizer the activity organizer
	 * @return the activity organizer that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ActivityOrganizer updateActivityOrganizer(
		ActivityOrganizer activityOrganizer) {
		return activityOrganizerPersistence.update(activityOrganizer);
	}

	/**
	 * Returns the activity local service.
	 *
	 * @return the activity local service
	 */
	public eu.strasbourg.service.activity.service.ActivityLocalService getActivityLocalService() {
		return activityLocalService;
	}

	/**
	 * Sets the activity local service.
	 *
	 * @param activityLocalService the activity local service
	 */
	public void setActivityLocalService(
		eu.strasbourg.service.activity.service.ActivityLocalService activityLocalService) {
		this.activityLocalService = activityLocalService;
	}

	/**
	 * Returns the activity persistence.
	 *
	 * @return the activity persistence
	 */
	public ActivityPersistence getActivityPersistence() {
		return activityPersistence;
	}

	/**
	 * Sets the activity persistence.
	 *
	 * @param activityPersistence the activity persistence
	 */
	public void setActivityPersistence(ActivityPersistence activityPersistence) {
		this.activityPersistence = activityPersistence;
	}

	/**
	 * Returns the activity course local service.
	 *
	 * @return the activity course local service
	 */
	public eu.strasbourg.service.activity.service.ActivityCourseLocalService getActivityCourseLocalService() {
		return activityCourseLocalService;
	}

	/**
	 * Sets the activity course local service.
	 *
	 * @param activityCourseLocalService the activity course local service
	 */
	public void setActivityCourseLocalService(
		eu.strasbourg.service.activity.service.ActivityCourseLocalService activityCourseLocalService) {
		this.activityCourseLocalService = activityCourseLocalService;
	}

	/**
	 * Returns the activity course persistence.
	 *
	 * @return the activity course persistence
	 */
	public ActivityCoursePersistence getActivityCoursePersistence() {
		return activityCoursePersistence;
	}

	/**
	 * Sets the activity course persistence.
	 *
	 * @param activityCoursePersistence the activity course persistence
	 */
	public void setActivityCoursePersistence(
		ActivityCoursePersistence activityCoursePersistence) {
		this.activityCoursePersistence = activityCoursePersistence;
	}

	/**
	 * Returns the activity course place local service.
	 *
	 * @return the activity course place local service
	 */
	public eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService getActivityCoursePlaceLocalService() {
		return activityCoursePlaceLocalService;
	}

	/**
	 * Sets the activity course place local service.
	 *
	 * @param activityCoursePlaceLocalService the activity course place local service
	 */
	public void setActivityCoursePlaceLocalService(
		eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService activityCoursePlaceLocalService) {
		this.activityCoursePlaceLocalService = activityCoursePlaceLocalService;
	}

	/**
	 * Returns the activity course place persistence.
	 *
	 * @return the activity course place persistence
	 */
	public ActivityCoursePlacePersistence getActivityCoursePlacePersistence() {
		return activityCoursePlacePersistence;
	}

	/**
	 * Sets the activity course place persistence.
	 *
	 * @param activityCoursePlacePersistence the activity course place persistence
	 */
	public void setActivityCoursePlacePersistence(
		ActivityCoursePlacePersistence activityCoursePlacePersistence) {
		this.activityCoursePlacePersistence = activityCoursePlacePersistence;
	}

	/**
	 * Returns the activity course schedule local service.
	 *
	 * @return the activity course schedule local service
	 */
	public eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService getActivityCourseScheduleLocalService() {
		return activityCourseScheduleLocalService;
	}

	/**
	 * Sets the activity course schedule local service.
	 *
	 * @param activityCourseScheduleLocalService the activity course schedule local service
	 */
	public void setActivityCourseScheduleLocalService(
		eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService activityCourseScheduleLocalService) {
		this.activityCourseScheduleLocalService = activityCourseScheduleLocalService;
	}

	/**
	 * Returns the activity course schedule persistence.
	 *
	 * @return the activity course schedule persistence
	 */
	public ActivityCourseSchedulePersistence getActivityCourseSchedulePersistence() {
		return activityCourseSchedulePersistence;
	}

	/**
	 * Sets the activity course schedule persistence.
	 *
	 * @param activityCourseSchedulePersistence the activity course schedule persistence
	 */
	public void setActivityCourseSchedulePersistence(
		ActivityCourseSchedulePersistence activityCourseSchedulePersistence) {
		this.activityCourseSchedulePersistence = activityCourseSchedulePersistence;
	}

	/**
	 * Returns the activity organizer local service.
	 *
	 * @return the activity organizer local service
	 */
	public ActivityOrganizerLocalService getActivityOrganizerLocalService() {
		return activityOrganizerLocalService;
	}

	/**
	 * Sets the activity organizer local service.
	 *
	 * @param activityOrganizerLocalService the activity organizer local service
	 */
	public void setActivityOrganizerLocalService(
		ActivityOrganizerLocalService activityOrganizerLocalService) {
		this.activityOrganizerLocalService = activityOrganizerLocalService;
	}

	/**
	 * Returns the activity organizer persistence.
	 *
	 * @return the activity organizer persistence
	 */
	public ActivityOrganizerPersistence getActivityOrganizerPersistence() {
		return activityOrganizerPersistence;
	}

	/**
	 * Sets the activity organizer persistence.
	 *
	 * @param activityOrganizerPersistence the activity organizer persistence
	 */
	public void setActivityOrganizerPersistence(
		ActivityOrganizerPersistence activityOrganizerPersistence) {
		this.activityOrganizerPersistence = activityOrganizerPersistence;
	}

	/**
	 * Returns the association local service.
	 *
	 * @return the association local service
	 */
	public eu.strasbourg.service.activity.service.AssociationLocalService getAssociationLocalService() {
		return associationLocalService;
	}

	/**
	 * Sets the association local service.
	 *
	 * @param associationLocalService the association local service
	 */
	public void setAssociationLocalService(
		eu.strasbourg.service.activity.service.AssociationLocalService associationLocalService) {
		this.associationLocalService = associationLocalService;
	}

	/**
	 * Returns the association persistence.
	 *
	 * @return the association persistence
	 */
	public AssociationPersistence getAssociationPersistence() {
		return associationPersistence;
	}

	/**
	 * Sets the association persistence.
	 *
	 * @param associationPersistence the association persistence
	 */
	public void setAssociationPersistence(
		AssociationPersistence associationPersistence) {
		this.associationPersistence = associationPersistence;
	}

	/**
	 * Returns the practice local service.
	 *
	 * @return the practice local service
	 */
	public eu.strasbourg.service.activity.service.PracticeLocalService getPracticeLocalService() {
		return practiceLocalService;
	}

	/**
	 * Sets the practice local service.
	 *
	 * @param practiceLocalService the practice local service
	 */
	public void setPracticeLocalService(
		eu.strasbourg.service.activity.service.PracticeLocalService practiceLocalService) {
		this.practiceLocalService = practiceLocalService;
	}

	/**
	 * Returns the practice persistence.
	 *
	 * @return the practice persistence
	 */
	public PracticePersistence getPracticePersistence() {
		return practicePersistence;
	}

	/**
	 * Sets the practice persistence.
	 *
	 * @param practicePersistence the practice persistence
	 */
	public void setPracticePersistence(PracticePersistence practicePersistence) {
		this.practicePersistence = practicePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService getAssetEntryLocalService() {
		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService) {
		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {
		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.kernel.service.AssetLinkLocalService getAssetLinkLocalService() {
		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService) {
		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {
		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService getAssetTagLocalService() {
		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService) {
		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(AssetTagPersistence assetTagPersistence) {
		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("eu.strasbourg.service.activity.model.ActivityOrganizer",
			activityOrganizerLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.activity.model.ActivityOrganizer");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ActivityOrganizerLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ActivityOrganizer.class;
	}

	protected String getModelClassName() {
		return ActivityOrganizer.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = activityOrganizerPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = eu.strasbourg.service.activity.service.ActivityLocalService.class)
	protected eu.strasbourg.service.activity.service.ActivityLocalService activityLocalService;
	@BeanReference(type = ActivityPersistence.class)
	protected ActivityPersistence activityPersistence;
	@BeanReference(type = eu.strasbourg.service.activity.service.ActivityCourseLocalService.class)
	protected eu.strasbourg.service.activity.service.ActivityCourseLocalService activityCourseLocalService;
	@BeanReference(type = ActivityCoursePersistence.class)
	protected ActivityCoursePersistence activityCoursePersistence;
	@BeanReference(type = eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService.class)
	protected eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalService activityCoursePlaceLocalService;
	@BeanReference(type = ActivityCoursePlacePersistence.class)
	protected ActivityCoursePlacePersistence activityCoursePlacePersistence;
	@BeanReference(type = eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService.class)
	protected eu.strasbourg.service.activity.service.ActivityCourseScheduleLocalService activityCourseScheduleLocalService;
	@BeanReference(type = ActivityCourseSchedulePersistence.class)
	protected ActivityCourseSchedulePersistence activityCourseSchedulePersistence;
	@BeanReference(type = ActivityOrganizerLocalService.class)
	protected ActivityOrganizerLocalService activityOrganizerLocalService;
	@BeanReference(type = ActivityOrganizerPersistence.class)
	protected ActivityOrganizerPersistence activityOrganizerPersistence;
	@BeanReference(type = eu.strasbourg.service.activity.service.AssociationLocalService.class)
	protected eu.strasbourg.service.activity.service.AssociationLocalService associationLocalService;
	@BeanReference(type = AssociationPersistence.class)
	protected AssociationPersistence associationPersistence;
	@BeanReference(type = eu.strasbourg.service.activity.service.PracticeLocalService.class)
	protected eu.strasbourg.service.activity.service.PracticeLocalService practiceLocalService;
	@BeanReference(type = PracticePersistence.class)
	protected PracticePersistence practicePersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetEntryLocalService.class)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService assetEntryLocalService;
	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetLinkLocalService.class)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService assetLinkLocalService;
	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;
	@ServiceReference(type = com.liferay.asset.kernel.service.AssetTagLocalService.class)
	protected com.liferay.asset.kernel.service.AssetTagLocalService assetTagLocalService;
	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}