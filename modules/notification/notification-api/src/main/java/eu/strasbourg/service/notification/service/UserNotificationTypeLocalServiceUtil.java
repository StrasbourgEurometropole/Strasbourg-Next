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

import eu.strasbourg.service.notification.model.UserNotificationType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserNotificationType. This utility wraps
 * <code>eu.strasbourg.service.notification.service.impl.UserNotificationTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see UserNotificationTypeLocalService
 * @generated
 */
public class UserNotificationTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.notification.service.impl.UserNotificationTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user notification type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was added
	 */
	public static UserNotificationType addUserNotificationType(
		UserNotificationType userNotificationType) {

		return getService().addUserNotificationType(userNotificationType);
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
	 * Creates a new user notification type with the primary key. Does not add the user notification type to the database.
	 *
	 * @param userNotificationTypePK the primary key for the new user notification type
	 * @return the new user notification type
	 */
	public static UserNotificationType createUserNotificationType(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationTypePK userNotificationTypePK) {

		return getService().createUserNotificationType(userNotificationTypePK);
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
	 * Deletes the user notification type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was removed
	 */
	public static UserNotificationType deleteUserNotificationType(
		UserNotificationType userNotificationType) {

		return getService().deleteUserNotificationType(userNotificationType);
	}

	/**
	 * Deletes the user notification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type that was removed
	 * @throws PortalException if a user notification type with the primary key could not be found
	 */
	public static UserNotificationType deleteUserNotificationType(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationTypePK userNotificationTypePK)
		throws PortalException {

		return getService().deleteUserNotificationType(userNotificationTypePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
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

	public static UserNotificationType fetchUserNotificationType(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationTypePK userNotificationTypePK) {

		return getService().fetchUserNotificationType(userNotificationTypePK);
	}

	/**
	 * Retourne la liste des statuts de notification pour un utilisateur
	 */
	public static List<UserNotificationType> getByPublikUserId(
		String publikUserId) {

		return getService().getByPublikUserId(publikUserId);
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
	 * Returns the user notification type with the primary key.
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type
	 * @throws PortalException if a user notification type with the primary key could not be found
	 */
	public static UserNotificationType getUserNotificationType(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationTypePK userNotificationTypePK)
		throws PortalException {

		return getService().getUserNotificationType(userNotificationTypePK);
	}

	/**
	 * Returns a range of all the user notification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @return the range of user notification types
	 */
	public static List<UserNotificationType> getUserNotificationTypes(
		int start, int end) {

		return getService().getUserNotificationTypes(start, end);
	}

	/**
	 * Retourne la liste des types de notifications auxquels l'utilisateur est
	 * abonné
	 */
	public static List<com.liferay.asset.kernel.model.AssetCategory>
		getUserNotificationTypes(String publikUserId) {

		return getService().getUserNotificationTypes(publikUserId);
	}

	/**
	 * Returns the number of user notification types.
	 *
	 * @return the number of user notification types
	 */
	public static int getUserNotificationTypesCount() {
		return getService().getUserNotificationTypesCount();
	}

	/**
	 * Retourne la liste des utilisateurs abonnés à un type de notification
	 */
	public static List<eu.strasbourg.service.oidc.model.PublikUser>
		getUsersSubscribedToType(long typeId) {

		return getService().getUsersSubscribedToType(typeId);
	}

	/**
	 * Retourne true si l'utilisateur est abonné au type passé en paramètre
	 */
	public static boolean isUserSubscribedToType(
		String publikUserId, long typeId) {

		return getService().isUserSubscribedToType(publikUserId, typeId);
	}

	/**
	 * Remplace les abonnement existant de l'utilisateur par des nouveaux
	 */
	public static void replaceUserSubscriptions(
		String publikUserId,
		List<com.liferay.asset.kernel.model.AssetCategory> types) {

		getService().replaceUserSubscriptions(publikUserId, types);
	}

	/**
	 * Updates the user notification type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was updated
	 */
	public static UserNotificationType updateUserNotificationType(
		UserNotificationType userNotificationType) {

		return getService().updateUserNotificationType(userNotificationType);
	}

	public static UserNotificationTypeLocalService getService() {
		return _service;
	}

	public static void setService(UserNotificationTypeLocalService service) {
		_service = service;
	}

	private static volatile UserNotificationTypeLocalService _service;

}