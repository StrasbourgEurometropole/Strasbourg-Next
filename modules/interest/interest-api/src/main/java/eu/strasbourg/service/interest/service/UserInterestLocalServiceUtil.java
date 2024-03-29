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

package eu.strasbourg.service.interest.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserInterest. This utility wraps
 * <code>eu.strasbourg.service.interest.service.impl.UserInterestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see UserInterestLocalService
 * @generated
 */
public class UserInterestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.interest.service.impl.UserInterestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the user interest to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserInterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userInterest the user interest
	 * @return the user interest that was added
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
		addUserInterest(
			eu.strasbourg.service.interest.model.UserInterest userInterest) {

		return getService().addUserInterest(userInterest);
	}

	/**
	 * Creates a new user interest with the primary key. Does not add the user interest to the database.
	 *
	 * @param userInterestPK the primary key for the new user interest
	 * @return the new user interest
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
		createUserInterest(
			eu.strasbourg.service.interest.service.persistence.UserInterestPK
				userInterestPK) {

		return getService().createUserInterest(userInterestPK);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user interest from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserInterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userInterest the user interest
	 * @return the user interest that was removed
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
		deleteUserInterest(
			eu.strasbourg.service.interest.model.UserInterest userInterest) {

		return getService().deleteUserInterest(userInterest);
	}

	/**
	 * Deletes the user interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserInterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userInterestPK the primary key of the user interest
	 * @return the user interest that was removed
	 * @throws PortalException if a user interest with the primary key could not be found
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
			deleteUserInterest(
				eu.strasbourg.service.interest.service.persistence.
					UserInterestPK userInterestPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteUserInterest(userInterestPK);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.UserInterestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.UserInterestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.interest.model.UserInterest
		fetchUserInterest(
			eu.strasbourg.service.interest.service.persistence.UserInterestPK
				userInterestPK) {

		return getService().fetchUserInterest(userInterestPK);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<eu.strasbourg.service.interest.model.UserInterest> getByInterestId(
			long interestId) {

		return getService().getByInterestId(interestId);
	}

	public static java.util.List
		<eu.strasbourg.service.interest.model.UserInterest> getByPublikUserId(
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user interest with the primary key.
	 *
	 * @param userInterestPK the primary key of the user interest
	 * @return the user interest
	 * @throws PortalException if a user interest with the primary key could not be found
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
			getUserInterest(
				eu.strasbourg.service.interest.service.persistence.
					UserInterestPK userInterestPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getUserInterest(userInterestPK);
	}

	/**
	 * Returns a range of all the user interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.UserInterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user interests
	 * @param end the upper bound of the range of user interests (not inclusive)
	 * @return the range of user interests
	 */
	public static java.util.List
		<eu.strasbourg.service.interest.model.UserInterest> getUserInterests(
			int start, int end) {

		return getService().getUserInterests(start, end);
	}

	/**
	 * Returns the number of user interests.
	 *
	 * @return the number of user interests
	 */
	public static int getUserInterestsCount() {
		return getService().getUserInterestsCount();
	}

	/**
	 * Updates the user interest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserInterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userInterest the user interest
	 * @return the user interest that was updated
	 */
	public static eu.strasbourg.service.interest.model.UserInterest
		updateUserInterest(
			eu.strasbourg.service.interest.model.UserInterest userInterest) {

		return getService().updateUserInterest(userInterest);
	}

	public static UserInterestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<UserInterestLocalService, UserInterestLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(UserInterestLocalService.class);

		ServiceTracker<UserInterestLocalService, UserInterestLocalService>
			serviceTracker =
				new ServiceTracker
					<UserInterestLocalService, UserInterestLocalService>(
						bundle.getBundleContext(),
						UserInterestLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}