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

import eu.strasbourg.service.gtfs.model.Direction;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Direction. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.DirectionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see DirectionLocalService
 * @generated
 */
public class DirectionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.DirectionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the direction to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DirectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param direction the direction
	 * @return the direction that was added
	 */
	public static Direction addDirection(Direction direction) {
		return getService().addDirection(direction);
	}

	/**
	 * Creates a new direction with the primary key. Does not add the direction to the database.
	 *
	 * @param directionId the primary key for the new direction
	 * @return the new direction
	 */
	public static Direction createDirection(long directionId) {
		return getService().createDirection(directionId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public static Direction createDirection(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createDirection(sc);
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
	 * Deletes the direction from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DirectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param direction the direction
	 * @return the direction that was removed
	 */
	public static Direction deleteDirection(Direction direction) {
		return getService().deleteDirection(direction);
	}

	/**
	 * Deletes the direction with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DirectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param directionId the primary key of the direction
	 * @return the direction that was removed
	 * @throws PortalException if a direction with the primary key could not be found
	 */
	public static Direction deleteDirection(long directionId)
		throws PortalException {

		return getService().deleteDirection(directionId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.DirectionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.DirectionModelImpl</code>.
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

	public static Direction fetchDirection(long directionId) {
		return getService().fetchDirection(directionId);
	}

	/**
	 * Returns the direction matching the UUID and group.
	 *
	 * @param uuid the direction's UUID
	 * @param groupId the primary key of the group
	 * @return the matching direction, or <code>null</code> if a matching direction could not be found
	 */
	public static Direction fetchDirectionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchDirectionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste de toutes les directions
	 */
	public static List<Direction> getAll() {
		return getService().getAll();
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	public static List<Direction> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne toutes direction d'une ligne
	 */
	public static List<Direction> getByRouteId(String routeId) {
		return getService().getByRouteId(routeId);
	}

	/**
	 * Retourne toutes direction d'un arret
	 */
	public static List<Direction> getByStopId(String stopId) {
		return getService().getByStopId(stopId);
	}

	/**
	 * Retourne une direction via son tripId
	 */
	public static Direction getByTripId(String tripId) {
		return getService().getByTripId(tripId);
	}

	/**
	 * Returns the direction with the primary key.
	 *
	 * @param directionId the primary key of the direction
	 * @return the direction
	 * @throws PortalException if a direction with the primary key could not be found
	 */
	public static Direction getDirection(long directionId)
		throws PortalException {

		return getService().getDirection(directionId);
	}

	/**
	 * Returns the direction matching the UUID and group.
	 *
	 * @param uuid the direction's UUID
	 * @param groupId the primary key of the group
	 * @return the matching direction
	 * @throws PortalException if a matching direction could not be found
	 */
	public static Direction getDirectionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getDirectionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the directions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.DirectionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of directions
	 * @param end the upper bound of the range of directions (not inclusive)
	 * @return the range of directions
	 */
	public static List<Direction> getDirections(int start, int end) {
		return getService().getDirections(start, end);
	}

	/**
	 * Returns all the directions matching the UUID and company.
	 *
	 * @param uuid the UUID of the directions
	 * @param companyId the primary key of the company
	 * @return the matching directions, or an empty list if no matches were found
	 */
	public static List<Direction> getDirectionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getDirectionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of directions matching the UUID and company.
	 *
	 * @param uuid the UUID of the directions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of directions
	 * @param end the upper bound of the range of directions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching directions, or an empty list if no matches were found
	 */
	public static List<Direction> getDirectionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Direction> orderByComparator) {

		return getService().getDirectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of directions.
	 *
	 * @return the number of directions
	 */
	public static int getDirectionsCount() {
		return getService().getDirectionsCount();
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
	 * Supprime les entree correspondants au routeId donnee
	 */
	public static List<Direction> removeByRouteId(String routeId)
		throws PortalException {

		return getService().removeByRouteId(routeId);
	}

	/**
	 * Supprime les entree correspondants au stopId donnee
	 */
	public static List<Direction> removeByStopId(String stopId)
		throws PortalException {

		return getService().removeByStopId(stopId);
	}

	/**
	 * Supprime l'entree
	 */
	public static Direction removeDirection(long directionId)
		throws PortalException {

		return getService().removeDirection(directionId);
	}

	/**
	 * Supprime les entrees
	 */
	public static void removeDirections(List<Direction> directions)
		throws PortalException {

		getService().removeDirections(directions);
	}

	/**
	 * Updates the direction in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect DirectionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param direction the direction
	 * @return the direction that was updated
	 */
	public static Direction updateDirection(Direction direction) {
		return getService().updateDirection(direction);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws PortalException
	 * @throws IOException
	 */
	public static Direction updateDirection(
			Direction direction,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateDirection(direction, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public static void updateDirections(
			List<Direction> directions,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().updateDirections(directions, sc);
	}

	public static DirectionLocalService getService() {
		return _service;
	}

	public static void setService(DirectionLocalService service) {
		_service = service;
	}

	private static volatile DirectionLocalService _service;

}