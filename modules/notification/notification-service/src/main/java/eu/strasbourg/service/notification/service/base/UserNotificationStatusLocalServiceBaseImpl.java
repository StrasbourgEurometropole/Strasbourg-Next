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

package eu.strasbourg.service.notification.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
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
import com.liferay.portal.spring.extender.service.ServiceReference;
import eu.strasbourg.service.notification.model.UserNotificationStatus;
import eu.strasbourg.service.notification.service.UserNotificationStatusLocalService;
import eu.strasbourg.service.notification.service.UserNotificationStatusLocalServiceUtil;
import eu.strasbourg.service.notification.service.persistence.NotificationPersistence;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPersistence;
import eu.strasbourg.service.notification.service.persistence.UserNotificationStatusPK;
import eu.strasbourg.service.notification.service.persistence.UserNotificationStatusPersistence;
import eu.strasbourg.service.notification.service.persistence.UserNotificationTypePersistence;

import javax.sql.DataSource;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Provides the base implementation for the user notification status local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.notification.service.impl.UserNotificationStatusLocalServiceImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see eu.strasbourg.service.notification.service.impl.UserNotificationStatusLocalServiceImpl
 * @generated
 */
public abstract class UserNotificationStatusLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements IdentifiableOSGiService, UserNotificationStatusLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>UserNotificationStatusLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>UserNotificationStatusLocalServiceUtil</code>.
	 */

	/**
	 * Adds the user notification status to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationStatus the user notification status
	 * @return the user notification status that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserNotificationStatus addUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		userNotificationStatus.setNew(true);

		return userNotificationStatusPersistence.update(userNotificationStatus);
	}

	/**
	 * Creates a new user notification status with the primary key. Does not add the user notification status to the database.
	 *
	 * @param userNotificationStatusPK the primary key for the new user notification status
	 * @return the new user notification status
	 */
	@Override
	@Transactional(enabled = false)
	public UserNotificationStatus createUserNotificationStatus(
		UserNotificationStatusPK userNotificationStatusPK) {

		return userNotificationStatusPersistence.create(
			userNotificationStatusPK);
	}

	/**
	 * Deletes the user notification status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status that was removed
	 * @throws PortalException if a user notification status with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserNotificationStatus deleteUserNotificationStatus(
			UserNotificationStatusPK userNotificationStatusPK)
		throws PortalException {

		return userNotificationStatusPersistence.remove(
			userNotificationStatusPK);
	}

	/**
	 * Deletes the user notification status from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationStatus the user notification status
	 * @return the user notification status that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public UserNotificationStatus deleteUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		return userNotificationStatusPersistence.remove(userNotificationStatus);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return userNotificationStatusPersistence.dslQuery(dslQuery);
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
			UserNotificationStatus.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return userNotificationStatusPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationStatusModelImpl</code>.
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

		return userNotificationStatusPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationStatusModelImpl</code>.
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

		return userNotificationStatusPersistence.findWithDynamicQuery(
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
		return userNotificationStatusPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return userNotificationStatusPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public UserNotificationStatus fetchUserNotificationStatus(
		UserNotificationStatusPK userNotificationStatusPK) {

		return userNotificationStatusPersistence.fetchByPrimaryKey(
			userNotificationStatusPK);
	}

	/**
	 * Returns the user notification status with the primary key.
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status
	 * @throws PortalException if a user notification status with the primary key could not be found
	 */
	@Override
	public UserNotificationStatus getUserNotificationStatus(
			UserNotificationStatusPK userNotificationStatusPK)
		throws PortalException {

		return userNotificationStatusPersistence.findByPrimaryKey(
			userNotificationStatusPK);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			userNotificationStatusLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserNotificationStatus.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.notificationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			userNotificationStatusLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			UserNotificationStatus.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.notificationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			userNotificationStatusLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(UserNotificationStatus.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"primaryKey.notificationId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userNotificationStatusPersistence.create(
			(UserNotificationStatusPK)primaryKeyObj);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement UserNotificationStatusLocalServiceImpl#deleteUserNotificationStatus(UserNotificationStatus) to avoid orphaned data");
		}

		return userNotificationStatusLocalService.deleteUserNotificationStatus(
			(UserNotificationStatus)persistedModel);
	}

	@Override
	public BasePersistence<UserNotificationStatus> getBasePersistence() {
		return userNotificationStatusPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return userNotificationStatusPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the user notification statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification statuses
	 * @param end the upper bound of the range of user notification statuses (not inclusive)
	 * @return the range of user notification statuses
	 */
	@Override
	public List<UserNotificationStatus> getUserNotificationStatuses(
		int start, int end) {

		return userNotificationStatusPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of user notification statuses.
	 *
	 * @return the number of user notification statuses
	 */
	@Override
	public int getUserNotificationStatusesCount() {
		return userNotificationStatusPersistence.countAll();
	}

	/**
	 * Updates the user notification status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationStatusLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationStatus the user notification status
	 * @return the user notification status that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public UserNotificationStatus updateUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		return userNotificationStatusPersistence.update(userNotificationStatus);
	}

	/**
	 * Returns the notification local service.
	 *
	 * @return the notification local service
	 */
	public eu.strasbourg.service.notification.service.NotificationLocalService
		getNotificationLocalService() {

		return notificationLocalService;
	}

	/**
	 * Sets the notification local service.
	 *
	 * @param notificationLocalService the notification local service
	 */
	public void setNotificationLocalService(
		eu.strasbourg.service.notification.service.NotificationLocalService
			notificationLocalService) {

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
	 * Returns the user notification channel local service.
	 *
	 * @return the user notification channel local service
	 */
	public eu.strasbourg.service.notification.service.
		UserNotificationChannelLocalService
			getUserNotificationChannelLocalService() {

		return userNotificationChannelLocalService;
	}

	/**
	 * Sets the user notification channel local service.
	 *
	 * @param userNotificationChannelLocalService the user notification channel local service
	 */
	public void setUserNotificationChannelLocalService(
		eu.strasbourg.service.notification.service.
			UserNotificationChannelLocalService
				userNotificationChannelLocalService) {

		this.userNotificationChannelLocalService =
			userNotificationChannelLocalService;
	}

	/**
	 * Returns the user notification channel persistence.
	 *
	 * @return the user notification channel persistence
	 */
	public UserNotificationChannelPersistence
		getUserNotificationChannelPersistence() {

		return userNotificationChannelPersistence;
	}

	/**
	 * Sets the user notification channel persistence.
	 *
	 * @param userNotificationChannelPersistence the user notification channel persistence
	 */
	public void setUserNotificationChannelPersistence(
		UserNotificationChannelPersistence userNotificationChannelPersistence) {

		this.userNotificationChannelPersistence =
			userNotificationChannelPersistence;
	}

	/**
	 * Returns the user notification status local service.
	 *
	 * @return the user notification status local service
	 */
	public UserNotificationStatusLocalService
		getUserNotificationStatusLocalService() {

		return userNotificationStatusLocalService;
	}

	/**
	 * Sets the user notification status local service.
	 *
	 * @param userNotificationStatusLocalService the user notification status local service
	 */
	public void setUserNotificationStatusLocalService(
		UserNotificationStatusLocalService userNotificationStatusLocalService) {

		this.userNotificationStatusLocalService =
			userNotificationStatusLocalService;
	}

	/**
	 * Returns the user notification status persistence.
	 *
	 * @return the user notification status persistence
	 */
	public UserNotificationStatusPersistence
		getUserNotificationStatusPersistence() {

		return userNotificationStatusPersistence;
	}

	/**
	 * Sets the user notification status persistence.
	 *
	 * @param userNotificationStatusPersistence the user notification status persistence
	 */
	public void setUserNotificationStatusPersistence(
		UserNotificationStatusPersistence userNotificationStatusPersistence) {

		this.userNotificationStatusPersistence =
			userNotificationStatusPersistence;
	}

	/**
	 * Returns the user notification type local service.
	 *
	 * @return the user notification type local service
	 */
	public
		eu.strasbourg.service.notification.service.
			UserNotificationTypeLocalService
				getUserNotificationTypeLocalService() {

		return userNotificationTypeLocalService;
	}

	/**
	 * Sets the user notification type local service.
	 *
	 * @param userNotificationTypeLocalService the user notification type local service
	 */
	public void setUserNotificationTypeLocalService(
		eu.strasbourg.service.notification.service.
			UserNotificationTypeLocalService userNotificationTypeLocalService) {

		this.userNotificationTypeLocalService =
			userNotificationTypeLocalService;
	}

	/**
	 * Returns the user notification type persistence.
	 *
	 * @return the user notification type persistence
	 */
	public UserNotificationTypePersistence
		getUserNotificationTypePersistence() {

		return userNotificationTypePersistence;
	}

	/**
	 * Sets the user notification type persistence.
	 *
	 * @param userNotificationTypePersistence the user notification type persistence
	 */
	public void setUserNotificationTypePersistence(
		UserNotificationTypePersistence userNotificationTypePersistence) {

		this.userNotificationTypePersistence = userNotificationTypePersistence;
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

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"eu.strasbourg.service.notification.model.UserNotificationStatus",
			userNotificationStatusLocalService);

		_setLocalServiceUtilService(userNotificationStatusLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"eu.strasbourg.service.notification.model.UserNotificationStatus");

		_setLocalServiceUtilService(null);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return UserNotificationStatusLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return UserNotificationStatus.class;
	}

	protected String getModelClassName() {
		return UserNotificationStatus.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				userNotificationStatusPersistence.getDataSource();

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
		UserNotificationStatusLocalService userNotificationStatusLocalService) {

		try {
			Field field =
				UserNotificationStatusLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, userNotificationStatusLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.notification.service.NotificationLocalService.class
	)
	protected
		eu.strasbourg.service.notification.service.NotificationLocalService
			notificationLocalService;

	@BeanReference(type = NotificationPersistence.class)
	protected NotificationPersistence notificationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.notification.service.UserNotificationChannelLocalService.class
	)
	protected eu.strasbourg.service.notification.service.
		UserNotificationChannelLocalService userNotificationChannelLocalService;

	@BeanReference(type = UserNotificationChannelPersistence.class)
	protected UserNotificationChannelPersistence
		userNotificationChannelPersistence;

	@BeanReference(type = UserNotificationStatusLocalService.class)
	protected UserNotificationStatusLocalService
		userNotificationStatusLocalService;

	@BeanReference(type = UserNotificationStatusPersistence.class)
	protected UserNotificationStatusPersistence
		userNotificationStatusPersistence;

	@BeanReference(
		type = eu.strasbourg.service.notification.service.UserNotificationTypeLocalService.class
	)
	protected
		eu.strasbourg.service.notification.service.
			UserNotificationTypeLocalService userNotificationTypeLocalService;

	@BeanReference(type = UserNotificationTypePersistence.class)
	protected UserNotificationTypePersistence userNotificationTypePersistence;

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

	private static final Log _log = LogFactoryUtil.getLog(
		UserNotificationStatusLocalServiceBaseImpl.class);

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}