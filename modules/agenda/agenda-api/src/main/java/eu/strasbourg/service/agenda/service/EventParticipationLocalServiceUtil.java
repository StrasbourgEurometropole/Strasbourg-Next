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
 * Provides the local service utility for EventParticipation. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.EventParticipationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see EventParticipationLocalService
 * @generated
 */
public class EventParticipationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventParticipationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the event participation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventParticipation the event participation
	 * @return the event participation that was added
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		addEventParticipation(
			eu.strasbourg.service.agenda.model.EventParticipation
				eventParticipation) {

		return getService().addEventParticipation(eventParticipation);
	}

	/**
	 * Cree une nouvelle participation a un evenement
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		createEventParticipation() {

		return getService().createEventParticipation();
	}

	/**
	 * Creates a new event participation with the primary key. Does not add the event participation to the database.
	 *
	 * @param eventParticipationId the primary key for the new event participation
	 * @return the new event participation
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		createEventParticipation(long eventParticipationId) {

		return getService().createEventParticipation(eventParticipationId);
	}

	/**
	 * Deletes the event participation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventParticipation the event participation
	 * @return the event participation that was removed
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		deleteEventParticipation(
			eu.strasbourg.service.agenda.model.EventParticipation
				eventParticipation) {

		return getService().deleteEventParticipation(eventParticipation);
	}

	/**
	 * Deletes the event participation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventParticipationId the primary key of the event participation
	 * @return the event participation that was removed
	 * @throws PortalException if a event participation with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
			deleteEventParticipation(long eventParticipationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEventParticipation(eventParticipationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl</code>.
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

	public static eu.strasbourg.service.agenda.model.EventParticipation
		fetchEventParticipation(long eventParticipationId) {

		return getService().fetchEventParticipation(eventParticipationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des likes/dislikes d'un evenement
	 */
	public static java.util.List
		<eu.strasbourg.service.agenda.model.EventParticipation> getByEventId(
			long eventId) {

		return getService().getByEventId(eventId);
	}

	/**
	 * Retourne la liste des likes/dislikes d'un utilisateur
	 */
	public static java.util.List
		<eu.strasbourg.service.agenda.model.EventParticipation> getByPublikUser(
			String publikUserId) {

		return getService().getByPublikUser(publikUserId);
	}

	/**
	 * Retourne la participation à l'événement d'un utilisateur et d'un événement donné
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		getByPublikUserIdAndEventId(String publikUserId, long eventId) {

		return getService().getByPublikUserIdAndEventId(publikUserId, eventId);
	}

	/**
	 * Returns the event participation with the primary key.
	 *
	 * @param eventParticipationId the primary key of the event participation
	 * @return the event participation
	 * @throws PortalException if a event participation with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
			getEventParticipation(long eventParticipationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEventParticipation(eventParticipationId);
	}

	/**
	 * Returns a range of all the event participations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event participations
	 * @param end the upper bound of the range of event participations (not inclusive)
	 * @return the range of event participations
	 */
	public static java.util.List
		<eu.strasbourg.service.agenda.model.EventParticipation>
			getEventParticipations(int start, int end) {

		return getService().getEventParticipations(start, end);
	}

	/**
	 * Returns the number of event participations.
	 *
	 * @return the number of event participations
	 */
	public static int getEventParticipationsCount() {
		return getService().getEventParticipationsCount();
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
	 * Updates the event participation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventParticipation the event participation
	 * @return the event participation that was updated
	 */
	public static eu.strasbourg.service.agenda.model.EventParticipation
		updateEventParticipation(
			eu.strasbourg.service.agenda.model.EventParticipation
				eventParticipation) {

		return getService().updateEventParticipation(eventParticipation);
	}

	public static EventParticipationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EventParticipationLocalService, EventParticipationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EventParticipationLocalService.class);

		ServiceTracker
			<EventParticipationLocalService, EventParticipationLocalService>
				serviceTracker =
					new ServiceTracker
						<EventParticipationLocalService,
						 EventParticipationLocalService>(
							 bundle.getBundleContext(),
							 EventParticipationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}