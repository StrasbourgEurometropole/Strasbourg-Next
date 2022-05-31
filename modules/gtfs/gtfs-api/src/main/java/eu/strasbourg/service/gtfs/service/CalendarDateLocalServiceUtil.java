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
 * Provides the local service utility for CalendarDate. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.CalendarDateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see CalendarDateLocalService
 * @generated
 */
public class CalendarDateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.CalendarDateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the calendar date to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarDateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendarDate the calendar date
	 * @return the calendar date that was added
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate addCalendarDate(
		eu.strasbourg.service.gtfs.model.CalendarDate calendarDate) {

		return getService().addCalendarDate(calendarDate);
	}

	/**
	 * Creates a new calendar date with the primary key. Does not add the calendar date to the database.
	 *
	 * @param id the primary key for the new calendar date
	 * @return the new calendar date
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
		createCalendarDate(long id) {

		return getService().createCalendarDate(id);
	}

	/**
	 * Crée un CalendarDate vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
			createCalendarDate(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createCalendarDate(sc);
	}

	/**
	 * Crée un Calendar à partir d'une entrée GTFS
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
			createCalendarDateFromGTFS(
				eu.strasbourg.utils.models.CalendarDatesGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createCalendarDateFromGTFS(entry);
	}

	/**
	 * Deletes the calendar date from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarDateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendarDate the calendar date
	 * @return the calendar date that was removed
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
		deleteCalendarDate(
			eu.strasbourg.service.gtfs.model.CalendarDate calendarDate) {

		return getService().deleteCalendarDate(calendarDate);
	}

	/**
	 * Deletes the calendar date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarDateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date that was removed
	 * @throws PortalException if a calendar date with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
			deleteCalendarDate(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCalendarDate(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarDateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarDateModelImpl</code>.
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

	public static eu.strasbourg.service.gtfs.model.CalendarDate
		fetchCalendarDate(long id) {

		return getService().fetchCalendarDate(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the calendar date with the primary key.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date
	 * @throws PortalException if a calendar date with the primary key could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate getCalendarDate(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCalendarDate(id);
	}

	/**
	 * Returns a range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of calendar dates
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.CalendarDate>
		getCalendarDates(int start, int end) {

		return getService().getCalendarDates(start, end);
	}

	/**
	 * Returns the number of calendar dates.
	 *
	 * @return the number of calendar dates
	 */
	public static int getCalendarDatesCount() {
		return getService().getCalendarDatesCount();
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
	 * Import des dates de calendrier sous le format de données GTFS
	 */
	public static void importFromGTFS(
			java.util.Map
				<String,
				 java.util.List<eu.strasbourg.utils.models.CalendarDatesGTFS>>
					data)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime toutes les dates de calendrier
	 */
	public static void removeAllCalendarDates()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeAllCalendarDates();
	}

	/**
	 * Supprime un CalendarDate
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
			removeCalendarDate(long calendarDateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeCalendarDate(calendarDateId);
	}

	/**
	 * Updates the calendar date in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarDateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendarDate the calendar date
	 * @return the calendar date that was updated
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
		updateCalendarDate(
			eu.strasbourg.service.gtfs.model.CalendarDate calendarDate) {

		return getService().updateCalendarDate(calendarDate);
	}

	/**
	 * Met à jour un CalendarDate et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static eu.strasbourg.service.gtfs.model.CalendarDate
			updateCalendarDate(
				eu.strasbourg.service.gtfs.model.CalendarDate calendarDate,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCalendarDate(calendarDate, sc);
	}

	public static CalendarDateLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CalendarDateLocalService, CalendarDateLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CalendarDateLocalService.class);

		ServiceTracker<CalendarDateLocalService, CalendarDateLocalService>
			serviceTracker =
				new ServiceTracker
					<CalendarDateLocalService, CalendarDateLocalService>(
						bundle.getBundleContext(),
						CalendarDateLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}