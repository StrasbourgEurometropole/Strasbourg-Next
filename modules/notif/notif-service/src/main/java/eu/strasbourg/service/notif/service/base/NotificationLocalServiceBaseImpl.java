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

package eu.strasbourg.service.notif.service.base;

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
import com.liferay.petra.sql.dsl.query.DSLQuery;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notif.model.Notification;
import eu.strasbourg.service.notif.service.NotificationLocalService;
import eu.strasbourg.service.notif.service.NotificationLocalServiceUtil;
import eu.strasbourg.service.notif.service.persistence.MessagePersistence;
import eu.strasbourg.service.notif.service.persistence.NatureNotifPersistence;
import eu.strasbourg.service.notif.service.persistence.NotificationPersistence;
import eu.strasbourg.service.notif.service.persistence.ServiceNotifPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the notification local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.notif.service.impl.NotificationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.notif.service.impl.NotificationLocalServiceImpl
 * @generated
 */
public abstract class NotificationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, NotificationLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>NotificationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>NotificationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the notification to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notification the notification
	 * @return the notification that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notification addNotification(Notification notification) {
		notification.setNew(true);

		return notificationPersistence.update(notification);
	}

	/**
	 * Creates a new notification with the primary key. Does not add the notification to the database.
	 *
	 * @param notificationId the primary key for the new notification
	 * @return the new notification
	 */
	@Override
	@Transactional(enabled = false)
	public Notification createNotification(long notificationId) {
		return notificationPersistence.create(notificationId);
	}

	/**
	 * Deletes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification that was removed
	 * @throws PortalException if a notification with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Notification deleteNotification(long notificationId)
		throws PortalException {

		return notificationPersistence.remove(notificationId);
	}

	/**
	 * Deletes the notification from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notification the notification
	 * @return the notification that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Notification deleteNotification(Notification notification) {
		return notificationPersistence.remove(notification);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return notificationPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Notification.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return notificationPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return notificationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return notificationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return notificationPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return notificationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Notification fetchNotification(long notificationId) {
		return notificationPersistence.fetchByPrimaryKey(notificationId);
	}

	/**
	 * Returns the notification matching the UUID and group.
	 *
	 * @param uuid the notification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchNotificationByUuidAndGroupId(
		String uuid, long groupId) {

		return notificationPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the notification with the primary key.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification
	 * @throws PortalException if a notification with the primary key could not be found
	 */
	@Override
	public Notification getNotification(long notificationId)
		throws PortalException {

		return notificationPersistence.findByPrimaryKey(notificationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(notificationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Notification.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("notificationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			notificationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Notification.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"notificationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(notificationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Notification.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("notificationId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									Notification.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Notification>() {

				@Override
				public void performAction(Notification notification)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, notification);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Notification.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return notificationPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement NotificationLocalServiceImpl#deleteNotification(Notification) to avoid orphaned data");
		}

		return notificationLocalService.deleteNotification(
			(Notification)persistedModel);
	}

	@Override
	public BasePersistence<Notification> getBasePersistence() {
		return notificationPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return notificationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the notifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the notifications
	 * @param companyId the primary key of the company
	 * @return the matching notifications, or an empty list if no matches were found
	 */
	@Override
	public List<Notification> getNotificationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return notificationPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of notifications matching the UUID and company.
	 *
	 * @param uuid the UUID of the notifications
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching notifications, or an empty list if no matches were found
	 */
	@Override
	public List<Notification> getNotificationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return notificationPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the notification matching the UUID and group.
	 *
	 * @param uuid the notification's UUID
	 * @param groupId the primary key of the group
	 * @return the matching notification
	 * @throws PortalException if a matching notification could not be found
	 */
	@Override
	public Notification getNotificationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return notificationPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notif.model.impl.NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of notifications
	 */
	@Override
	public List<Notification> getNotifications(int start, int end) {
		return notificationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of notifications.
	 *
	 * @return the number of notifications
	 */
	@Override
	public int getNotificationsCount() {
		return notificationPersistence.countAll();
	}

	/**
	 * Updates the notification in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect NotificationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param notification the notification
	 * @return the notification that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Notification updateNotification(Notification notification) {
		return notificationPersistence.update(notification);
	}

	/**
	 * Returns the message local service.
	 *
	 * @return the message local service
	 */
	public eu.strasbourg.service.notif.service.MessageLocalService
		getMessageLocalService() {

		return messageLocalService;
	}

	/**
	 * Sets the message local service.
	 *
	 * @param messageLocalService the message local service
	 */
	public void setMessageLocalService(
		eu.strasbourg.service.notif.service.MessageLocalService
			messageLocalService) {

		this.messageLocalService = messageLocalService;
	}

	/**
	 * Returns the message persistence.
	 *
	 * @return the message persistence
	 */
	public MessagePersistence getMessagePersistence() {
		return messagePersistence;
	}

	/**
	 * Sets the message persistence.
	 *
	 * @param messagePersistence the message persistence
	 */
	public void setMessagePersistence(MessagePersistence messagePersistence) {
		this.messagePersistence = messagePersistence;
	}

	/**
	 * Returns the nature notif local service.
	 *
	 * @return the nature notif local service
	 */
	public eu.strasbourg.service.notif.service.NatureNotifLocalService
		getNatureNotifLocalService() {

		return natureNotifLocalService;
	}

	/**
	 * Sets the nature notif local service.
	 *
	 * @param natureNotifLocalService the nature notif local service
	 */
	public void setNatureNotifLocalService(
		eu.strasbourg.service.notif.service.NatureNotifLocalService
			natureNotifLocalService) {

		this.natureNotifLocalService = natureNotifLocalService;
	}

	/**
	 * Returns the nature notif persistence.
	 *
	 * @return the nature notif persistence
	 */
	public NatureNotifPersistence getNatureNotifPersistence() {
		return natureNotifPersistence;
	}

	/**
	 * Sets the nature notif persistence.
	 *
	 * @param natureNotifPersistence the nature notif persistence
	 */
	public void setNatureNotifPersistence(
		NatureNotifPersistence natureNotifPersistence) {

		this.natureNotifPersistence = natureNotifPersistence;
	}

	/**
	 * Returns the notification local service.
	 *
	 * @return the notification local service
	 */
	public NotificationLocalService getNotificationLocalService() {
		return notificationLocalService;
	}

	/**
	 * Sets the notification local service.
	 *
	 * @param notificationLocalService the notification local service
	 */
	public void setNotificationLocalService(
		NotificationLocalService notificationLocalService) {

		this.notificationLocalService = notificationLocalService;
	}

	/**
	 * Returns the notification persistence.
	 *
	 * @return the notification persistence
	 */
	public NotificationPersistence getNotificationPersistence() {
		return notificationPersistence;
	}

	/**
	 * Sets the notification persistence.
	 *
	 * @param notificationPersistence the notification persistence
	 */
	public void setNotificationPersistence(
		NotificationPersistence notificationPersistence) {

		this.notificationPersistence = notificationPersistence;
	}

	/**
	 * Returns the service notif local service.
	 *
	 * @return the service notif local service
	 */
	public eu.strasbourg.service.notif.service.ServiceNotifLocalService
		getServiceNotifLocalService() {

		return serviceNotifLocalService;
	}

	/**
	 * Sets the service notif local service.
	 *
	 * @param serviceNotifLocalService the service notif local service
	 */
	public void setServiceNotifLocalService(
		eu.strasbourg.service.notif.service.ServiceNotifLocalService
			serviceNotifLocalService) {

		this.serviceNotifLocalService = serviceNotifLocalService;
	}

	/**
	 * Returns the service notif persistence.
	 *
	 * @return the service notif persistence
	 */
	public ServiceNotifPersistence getServiceNotifPersistence() {
		return serviceNotifPersistence;
	}

	/**
	 * Sets the service notif persistence.
	 *
	 * @param serviceNotifPersistence the service notif persistence
	 */
	public void setServiceNotifPersistence(
		ServiceNotifPersistence serviceNotifPersistence) {

		this.serviceNotifPersistence = serviceNotifPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

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
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

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
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

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
	public com.liferay.asset.kernel.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService
			assetLinkLocalService) {

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
	public com.liferay.asset.kernel.service.AssetTagLocalService
		getAssetTagLocalService() {

		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService
			assetTagLocalService) {

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
	public void setAssetTagPersistence(
		AssetTagPersistence assetTagPersistence) {

		this.assetTagPersistence = assetTagPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"eu.strasbourg.service.notif.model.Notification",
			notificationLocalService);

		_setLocalServiceUtilService(notificationLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.notif.model.Notification");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return NotificationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Notification.class;
	}

	protected String getModelClassName() {
		return Notification.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = notificationPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		NotificationLocalService notificationLocalService) {

		try {
			Field field = NotificationLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, notificationLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.notif.service.MessageLocalService.class
	)
	protected eu.strasbourg.service.notif.service.MessageLocalService
		messageLocalService;

	@BeanReference(type = MessagePersistence.class)
	protected MessagePersistence messagePersistence;

	@BeanReference(
		type = eu.strasbourg.service.notif.service.NatureNotifLocalService.class
	)
	protected eu.strasbourg.service.notif.service.NatureNotifLocalService
		natureNotifLocalService;

	@BeanReference(type = NatureNotifPersistence.class)
	protected NatureNotifPersistence natureNotifPersistence;

	@BeanReference(type = NotificationLocalService.class)
	protected NotificationLocalService notificationLocalService;

	@BeanReference(type = NotificationPersistence.class)
	protected NotificationPersistence notificationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.notif.service.ServiceNotifLocalService.class
	)
	protected eu.strasbourg.service.notif.service.ServiceNotifLocalService
		serviceNotifLocalService;

	@BeanReference(type = ServiceNotifPersistence.class)
	protected ServiceNotifPersistence serviceNotifPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		NotificationLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}