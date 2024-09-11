/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.notification.model.UserNotificationStatus;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserNotificationStatus. This utility wraps
 * <code>eu.strasbourg.service.notification.service.impl.UserNotificationStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see UserNotificationStatusLocalService
 * @generated
 */
public class UserNotificationStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.notification.service.impl.UserNotificationStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static UserNotificationStatus addUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		return getService().addUserNotificationStatus(userNotificationStatus);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user notification status with the primary key. Does not add the user notification status to the database.
	 *
	 * @param userNotificationStatusPK the primary key for the new user notification status
	 * @return the new user notification status
	 */
	public static UserNotificationStatus createUserNotificationStatus(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationStatusPK userNotificationStatusPK) {

		return getService().createUserNotificationStatus(
			userNotificationStatusPK);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static UserNotificationStatus deleteUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		return getService().deleteUserNotificationStatus(
			userNotificationStatus);
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
	public static UserNotificationStatus deleteUserNotificationStatus(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK)
		throws PortalException {

		return getService().deleteUserNotificationStatus(
			userNotificationStatusPK);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static UserNotificationStatus fetchUserNotificationStatus(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationStatusPK userNotificationStatusPK) {

		return getService().fetchUserNotificationStatus(
			userNotificationStatusPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des statuts de notification pour une notification
	 */
	public static List<UserNotificationStatus> getByNotificationId(
		long notificationId) {

		return getService().getByNotificationId(notificationId);
	}

	/**
	 * Retourne la liste des statuts de notification pour un utilisateur
	 */
	public static List<UserNotificationStatus> getByPublikUserId(
		String publikUserId) {

		return getService().getByPublikUserId(publikUserId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne la liste des statuts de notification pour un utilisateur
	 */
	public static long getUnreadNotificationCount(String publikUserId) {
		return getService().getUnreadNotificationCount(publikUserId);
	}

	/**
	 * Returns the user notification status with the primary key.
	 *
	 * @param userNotificationStatusPK the primary key of the user notification status
	 * @return the user notification status
	 * @throws PortalException if a user notification status with the primary key could not be found
	 */
	public static UserNotificationStatus getUserNotificationStatus(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationStatusPK userNotificationStatusPK)
		throws PortalException {

		return getService().getUserNotificationStatus(userNotificationStatusPK);
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
	public static List<UserNotificationStatus> getUserNotificationStatuses(
		int start, int end) {

		return getService().getUserNotificationStatuses(start, end);
	}

	/**
	 * Returns the number of user notification statuses.
	 *
	 * @return the number of user notification statuses
	 */
	public static int getUserNotificationStatusesCount() {
		return getService().getUserNotificationStatusesCount();
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
	public static UserNotificationStatus updateUserNotificationStatus(
		UserNotificationStatus userNotificationStatus) {

		return getService().updateUserNotificationStatus(
			userNotificationStatus);
	}

	public static UserNotificationStatusLocalService getService() {
		return _service;
	}

	public static void setService(UserNotificationStatusLocalService service) {
		_service = service;
	}

	private static volatile UserNotificationStatusLocalService _service;

}