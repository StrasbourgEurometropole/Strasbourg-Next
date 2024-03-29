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

package eu.strasbourg.service.gtfs.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StopTime. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.StopTimeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see StopTimeLocalService
 * @generated
 */
public class StopTimeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.StopTimeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the stop time to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was added
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime addStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return getService().addStopTime(stopTime);
	}

	/**
	 * Creates a new stop time with the primary key. Does not add the stop time to the database.
	 *
	 * @param id the primary key for the new stop time
	 * @return the new stop time
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime createStopTime(
		long id) {

		return getService().createStopTime(id);
	}

	/**
	 * Crée un StopTime vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime createStopTime(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createStopTime(sc);
	}

	/**
	 * Crée un temps d'arret à partir d'une entrée GTFS
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime
			createStopTimeFromGTFS(
				eu.strasbourg.utils.models.StopTimesGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createStopTimeFromGTFS(entry);
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
	 * Deletes the stop time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time that was removed
	 * @throws PortalException if a stop time with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime deleteStopTime(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStopTime(id);
	}

	/**
	 * Deletes the stop time from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was removed
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime deleteStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return getService().deleteStopTime(stopTime);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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

	public static eu.strasbourg.service.gtfs.model.StopTime fetchStopTime(
		long id) {

		return getService().fetchStopTime(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the stop time with the primary key.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time
	 * @throws PortalException if a stop time with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime getStopTime(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStopTime(id);
	}

	/**
	 * Returns a range of all the stop times.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of stop times
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.StopTime>
		getStopTimes(int start, int end) {

		return getService().getStopTimes(start, end);
	}

	/**
	 * Returns the number of stop times.
	 *
	 * @return the number of stop times
	 */
	public static int getStopTimesCount() {
		return getService().getStopTimesCount();
	}

	/**
	 * Import des temps d'arret de calendrier sous le format de données GTFS
	 */
	public static void importFromGTFS(
			java.util.Map
				<String,
				 java.util.List<eu.strasbourg.utils.models.StopTimesGTFS>> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime toutes le StopTime
	 */
	public static void removeAllStopTimes()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeAllStopTimes();
	}

	/**
	 * Supprime un StopTime
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime removeStopTime(
			long stopTimeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeStopTime(stopTimeId);
	}

	/**
	 * Updates the stop time in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StopTimeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stopTime the stop time
	 * @return the stop time that was updated
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime updateStopTime(
		eu.strasbourg.service.gtfs.model.StopTime stopTime) {

		return getService().updateStopTime(stopTime);
	}

	/**
	 * Met à jour un StopTime et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static eu.strasbourg.service.gtfs.model.StopTime updateStopTime(
			eu.strasbourg.service.gtfs.model.StopTime stopTime,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStopTime(stopTime, sc);
	}

	public static StopTimeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StopTimeLocalService, StopTimeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StopTimeLocalService.class);

		ServiceTracker<StopTimeLocalService, StopTimeLocalService>
			serviceTracker =
				new ServiceTracker<StopTimeLocalService, StopTimeLocalService>(
					bundle.getBundleContext(), StopTimeLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}