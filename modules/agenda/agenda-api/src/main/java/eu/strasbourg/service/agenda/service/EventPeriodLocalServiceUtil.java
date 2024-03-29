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

package eu.strasbourg.service.agenda.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for EventPeriod. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.EventPeriodLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see EventPeriodLocalService
 * @generated
 */
public class EventPeriodLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventPeriodLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the event period to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was added
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod addEventPeriod(
		eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return getService().addEventPeriod(eventPeriod);
	}

	/**
	 * Vérifie qu'une liste de période ne contient pas de périodes qui se
	 * chevauchent
	 */
	public static boolean checkForOverlappingPeriods(
		java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
			periods) {

		return getService().checkForOverlappingPeriods(periods);
	}

	/**
	 * Crée une édition vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod
			createEventPeriod()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createEventPeriod();
	}

	/**
	 * Creates a new event period with the primary key. Does not add the event period to the database.
	 *
	 * @param eventPeriodId the primary key for the new event period
	 * @return the new event period
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod
		createEventPeriod(long eventPeriodId) {

		return getService().createEventPeriod(eventPeriodId);
	}

	/**
	 * Deletes the event period from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was removed
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod
		deleteEventPeriod(
			eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return getService().deleteEventPeriod(eventPeriod);
	}

	/**
	 * Deletes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period that was removed
	 * @throws PortalException if a event period with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod
			deleteEventPeriod(long eventPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEventPeriod(eventPeriodId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
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

	public static eu.strasbourg.service.agenda.model.EventPeriod
		fetchEventPeriod(long eventPeriodId) {

		return getService().fetchEventPeriod(eventPeriodId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne les périodes d'un événement de campagne
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getByCampaignEventId(long campaignEventId) {

		return getService().getByCampaignEventId(campaignEventId);
	}

	/**
	 * Retourne les périodes d'un événement
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getByEventId(long eventId) {

		return getService().getByEventId(eventId);
	}

	/**
	 * Returns the event period with the primary key.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period
	 * @throws PortalException if a event period with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod getEventPeriod(
			long eventPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEventPeriod(eventPeriodId);
	}

	/**
	 * Returns a range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of event periods
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getEventPeriods(int start, int end) {

		return getService().getEventPeriods(start, end);
	}

	/**
	 * Returns the number of event periods.
	 *
	 * @return the number of event periods
	 */
	public static int getEventPeriodsCount() {
		return getService().getEventPeriodsCount();
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
	 * Updates the event period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was updated
	 */
	public static eu.strasbourg.service.agenda.model.EventPeriod
		updateEventPeriod(
			eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return getService().updateEventPeriod(eventPeriod);
	}

	public static EventPeriodLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventPeriodLocalService, EventPeriodLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventPeriodLocalService.class);

		ServiceTracker<EventPeriodLocalService, EventPeriodLocalService>
			serviceTracker =
				new ServiceTracker
					<EventPeriodLocalService, EventPeriodLocalService>(
						bundle.getBundleContext(),
						EventPeriodLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}