/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.ScheduleException;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ScheduleException. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.ScheduleExceptionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleExceptionLocalService
 * @generated
 */
public class ScheduleExceptionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.ScheduleExceptionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the schedule exception to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was added
	 */
	public static ScheduleException addScheduleException(
		ScheduleException scheduleException) {

		return getService().addScheduleException(scheduleException);
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
	 * Creates a new schedule exception with the primary key. Does not add the schedule exception to the database.
	 *
	 * @param exceptionId the primary key for the new schedule exception
	 * @return the new schedule exception
	 */
	public static ScheduleException createScheduleException(long exceptionId) {
		return getService().createScheduleException(exceptionId);
	}

	/**
	 * Crée une exception vide avec une PK, non ajouté à la base de donnée
	 */
	public static ScheduleException createScheduleException(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createScheduleException(sc);
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
	 * Deletes the schedule exception with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception that was removed
	 * @throws PortalException if a schedule exception with the primary key could not be found
	 */
	public static ScheduleException deleteScheduleException(long exceptionId)
		throws PortalException {

		return getService().deleteScheduleException(exceptionId);
	}

	/**
	 * Deletes the schedule exception from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was removed
	 */
	public static ScheduleException deleteScheduleException(
		ScheduleException scheduleException) {

		return getService().deleteScheduleException(scheduleException);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
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

	public static ScheduleException fetchScheduleException(long exceptionId) {
		return getService().fetchScheduleException(exceptionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne les ScheduleException rattachés à un lieu
	 */
	public static List<ScheduleException> getByPlaceId(long placeId) {
		return getService().getByPlaceId(placeId);
	}

	/**
	 * Retourne les ScheduleException rattachés à un sous-lieu
	 */
	public static List<ScheduleException> getBySubPlaceId(long subPlaceId) {
		return getService().getBySubPlaceId(subPlaceId);
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
	 * Returns the schedule exception with the primary key.
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception
	 * @throws PortalException if a schedule exception with the primary key could not be found
	 */
	public static ScheduleException getScheduleException(long exceptionId)
		throws PortalException {

		return getService().getScheduleException(exceptionId);
	}

	/**
	 * Returns a range of all the schedule exceptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of schedule exceptions
	 */
	public static List<ScheduleException> getScheduleExceptions(
		int start, int end) {

		return getService().getScheduleExceptions(start, end);
	}

	/**
	 * Returns the number of schedule exceptions.
	 *
	 * @return the number of schedule exceptions
	 */
	public static int getScheduleExceptionsCount() {
		return getService().getScheduleExceptionsCount();
	}

	/**
	 * Updates the schedule exception in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ScheduleExceptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param scheduleException the schedule exception
	 * @return the schedule exception that was updated
	 */
	public static ScheduleException updateScheduleException(
		ScheduleException scheduleException) {

		return getService().updateScheduleException(scheduleException);
	}

	public static ScheduleExceptionLocalService getService() {
		return _service;
	}

	public static void setService(ScheduleExceptionLocalService service) {
		_service = service;
	}

	private static volatile ScheduleExceptionLocalService _service;

}