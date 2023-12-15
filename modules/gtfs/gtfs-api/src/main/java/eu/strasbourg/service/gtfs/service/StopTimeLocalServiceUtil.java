/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.StopTime;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

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
	public static StopTime addStopTime(StopTime stopTime) {
		return getService().addStopTime(stopTime);
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
	 * Creates a new stop time with the primary key. Does not add the stop time to the database.
	 *
	 * @param id the primary key for the new stop time
	 * @return the new stop time
	 */
	public static StopTime createStopTime(long id) {
		return getService().createStopTime(id);
	}

	/**
	 * Crée un StopTime vide avec une PK, non ajouté à la base de donnée
	 */
	public static StopTime createStopTime(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createStopTime(sc);
	}

	/**
	 * Crée un temps d'arret à partir d'une entrée GTFS
	 */
	public static StopTime createStopTimeFromGTFS(
			eu.strasbourg.utils.models.StopTimesGTFS entry)
		throws PortalException {

		return getService().createStopTimeFromGTFS(entry);
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
	public static StopTime deleteStopTime(long id) throws PortalException {
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
	public static StopTime deleteStopTime(StopTime stopTime) {
		return getService().deleteStopTime(stopTime);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl</code>.
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

	public static StopTime fetchStopTime(long id) {
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stop time with the primary key.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time
	 * @throws PortalException if a stop time with the primary key could not be found
	 */
	public static StopTime getStopTime(long id) throws PortalException {
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
	public static List<StopTime> getStopTimes(int start, int end) {
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
			Map<String, List<eu.strasbourg.utils.models.StopTimesGTFS>> data)
		throws PortalException {

		getService().importFromGTFS(data);
	}

	/**
	 * Supprime toutes le StopTime
	 */
	public static void removeAllStopTimes() throws PortalException {
		getService().removeAllStopTimes();
	}

	/**
	 * Supprime un StopTime
	 */
	public static StopTime removeStopTime(long stopTimeId)
		throws PortalException {

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
	public static StopTime updateStopTime(StopTime stopTime) {
		return getService().updateStopTime(stopTime);
	}

	/**
	 * Met à jour un StopTime et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static StopTime updateStopTime(
			StopTime stopTime,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateStopTime(stopTime, sc);
	}

	public static StopTimeLocalService getService() {
		return _service;
	}

	public static void setService(StopTimeLocalService service) {
		_service = service;
	}

	private static volatile StopTimeLocalService _service;

}