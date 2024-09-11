/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.EventParticipation;

import java.io.Serializable;

import java.util.List;

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
	public static EventParticipation addEventParticipation(
		EventParticipation eventParticipation) {

		return getService().addEventParticipation(eventParticipation);
	}

	/**
	 * Cree une nouvelle participation a un evenement
	 */
	public static EventParticipation createEventParticipation() {
		return getService().createEventParticipation();
	}

	/**
	 * Creates a new event participation with the primary key. Does not add the event participation to the database.
	 *
	 * @param eventParticipationId the primary key for the new event participation
	 * @return the new event participation
	 */
	public static EventParticipation createEventParticipation(
		long eventParticipationId) {

		return getService().createEventParticipation(eventParticipationId);
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
	 * Deletes the event participation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventParticipation the event participation
	 * @return the event participation that was removed
	 */
	public static EventParticipation deleteEventParticipation(
		EventParticipation eventParticipation) {

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
	public static EventParticipation deleteEventParticipation(
			long eventParticipationId)
		throws PortalException {

		return getService().deleteEventParticipation(eventParticipationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl</code>.
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

	public static EventParticipation fetchEventParticipation(
		long eventParticipationId) {

		return getService().fetchEventParticipation(eventParticipationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des likes/dislikes d'un evenement
	 */
	public static List<EventParticipation> getByEventId(long eventId) {
		return getService().getByEventId(eventId);
	}

	/**
	 * Retourne la liste des likes/dislikes d'un utilisateur
	 */
	public static List<EventParticipation> getByPublikUser(
		String publikUserId) {

		return getService().getByPublikUser(publikUserId);
	}

	/**
	 * Retourne la participation à l'événement d'un utilisateur et d'un événement donné
	 */
	public static EventParticipation getByPublikUserIdAndEventId(
		String publikUserId, long eventId) {

		return getService().getByPublikUserIdAndEventId(publikUserId, eventId);
	}

	/**
	 * Returns the event participation with the primary key.
	 *
	 * @param eventParticipationId the primary key of the event participation
	 * @return the event participation
	 * @throws PortalException if a event participation with the primary key could not be found
	 */
	public static EventParticipation getEventParticipation(
			long eventParticipationId)
		throws PortalException {

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
	public static List<EventParticipation> getEventParticipations(
		int start, int end) {

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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

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
	public static EventParticipation updateEventParticipation(
		EventParticipation eventParticipation) {

		return getService().updateEventParticipation(eventParticipation);
	}

	public static EventParticipationLocalService getService() {
		return _service;
	}

	public static void setService(EventParticipationLocalService service) {
		_service = service;
	}

	private static volatile EventParticipationLocalService _service;

}