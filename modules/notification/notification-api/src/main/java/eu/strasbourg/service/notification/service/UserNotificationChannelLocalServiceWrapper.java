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

package eu.strasbourg.service.notification.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserNotificationChannelLocalService}.
 *
 * @author BenjaminBini
 * @see UserNotificationChannelLocalService
 * @generated
 */
public class UserNotificationChannelLocalServiceWrapper
	implements ServiceWrapper<UserNotificationChannelLocalService>,
			   UserNotificationChannelLocalService {

	public UserNotificationChannelLocalServiceWrapper(
		UserNotificationChannelLocalService
			userNotificationChannelLocalService) {

		_userNotificationChannelLocalService =
			userNotificationChannelLocalService;
	}

	/**
	 * Adds the user notification channel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationChannel the user notification channel
	 * @return the user notification channel that was added
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
		addUserNotificationChannel(
			eu.strasbourg.service.notification.model.UserNotificationChannel
				userNotificationChannel) {

		return _userNotificationChannelLocalService.addUserNotificationChannel(
			userNotificationChannel);
	}

	/**
	 * Creates a new user notification channel with the primary key. Does not add the user notification channel to the database.
	 *
	 * @param userNotificationChannelPK the primary key for the new user notification channel
	 * @return the new user notification channel
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
		createUserNotificationChannel(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationChannelPK userNotificationChannelPK) {

		return _userNotificationChannelLocalService.
			createUserNotificationChannel(userNotificationChannelPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationChannelLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user notification channel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationChannel the user notification channel
	 * @return the user notification channel that was removed
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
		deleteUserNotificationChannel(
			eu.strasbourg.service.notification.model.UserNotificationChannel
				userNotificationChannel) {

		return _userNotificationChannelLocalService.
			deleteUserNotificationChannel(userNotificationChannel);
	}

	/**
	 * Deletes the user notification channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel that was removed
	 * @throws PortalException if a user notification channel with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
			deleteUserNotificationChannel(
				eu.strasbourg.service.notification.service.persistence.
					UserNotificationChannelPK userNotificationChannelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationChannelLocalService.
			deleteUserNotificationChannel(userNotificationChannelPK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userNotificationChannelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userNotificationChannelLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userNotificationChannelLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userNotificationChannelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userNotificationChannelLocalService.dynamicQueryCount(
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userNotificationChannelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
		fetchUserNotificationChannel(
			eu.strasbourg.service.notification.service.persistence.
				UserNotificationChannelPK userNotificationChannelPK) {

		return _userNotificationChannelLocalService.
			fetchUserNotificationChannel(userNotificationChannelPK);
	}

	/**
	 * Retourne la liste des statuts de notification pour un utilisateur
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.notification.model.UserNotificationChannel>
			getByPublikUserId(String publikUserId) {

		return _userNotificationChannelLocalService.getByPublikUserId(
			publikUserId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userNotificationChannelLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationChannelLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the user notification channel with the primary key.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel
	 * @throws PortalException if a user notification channel with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
			getUserNotificationChannel(
				eu.strasbourg.service.notification.service.persistence.
					UserNotificationChannelPK userNotificationChannelPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userNotificationChannelLocalService.getUserNotificationChannel(
			userNotificationChannelPK);
	}

	/**
	 * Returns a range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of user notification channels
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.notification.model.UserNotificationChannel>
			getUserNotificationChannels(int start, int end) {

		return _userNotificationChannelLocalService.getUserNotificationChannels(
			start, end);
	}

	/**
	 * Retourne la liste des types de notifications auxquels l'utilisateur est
	 * abonné
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.notification.model.NotificationChannel>
			getUserNotificationChannels(String publikUserId) {

		return _userNotificationChannelLocalService.getUserNotificationChannels(
			publikUserId);
	}

	/**
	 * Returns the number of user notification channels.
	 *
	 * @return the number of user notification channels
	 */
	@Override
	public int getUserNotificationChannelsCount() {
		return _userNotificationChannelLocalService.
			getUserNotificationChannelsCount();
	}

	/**
	 * Remplace les abonnement existant de l'utilisateur par des nouveaux
	 */
	@Override
	public void replaceUserChannels(
		String publikUserId,
		java.util.List
			<eu.strasbourg.service.notification.model.NotificationChannel>
				channels) {

		_userNotificationChannelLocalService.replaceUserChannels(
			publikUserId, channels);
	}

	/**
	 * Updates the user notification channel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationChannelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationChannel the user notification channel
	 * @return the user notification channel that was updated
	 */
	@Override
	public eu.strasbourg.service.notification.model.UserNotificationChannel
		updateUserNotificationChannel(
			eu.strasbourg.service.notification.model.UserNotificationChannel
				userNotificationChannel) {

		return _userNotificationChannelLocalService.
			updateUserNotificationChannel(userNotificationChannel);
	}

	@Override
	public UserNotificationChannelLocalService getWrappedService() {
		return _userNotificationChannelLocalService;
	}

	@Override
	public void setWrappedService(
		UserNotificationChannelLocalService
			userNotificationChannelLocalService) {

		_userNotificationChannelLocalService =
			userNotificationChannelLocalService;
	}

	private UserNotificationChannelLocalService
		_userNotificationChannelLocalService;

}