/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link DirectionLocalService}.
 *
 * @author Cedric Henry
 * @see DirectionLocalService
 * @generated
 */
public class DirectionLocalServiceWrapper
	implements DirectionLocalService, ServiceWrapper<DirectionLocalService> {

	public DirectionLocalServiceWrapper() {
		this(null);
	}

	public DirectionLocalServiceWrapper(
		DirectionLocalService directionLocalService) {

		_directionLocalService = directionLocalService;
	}

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
	@Override
	public eu.strasbourg.service.gtfs.model.Direction addDirection(
		eu.strasbourg.service.gtfs.model.Direction direction) {

		return _directionLocalService.addDirection(direction);
	}

	/**
	 * Creates a new direction with the primary key. Does not add the direction to the database.
	 *
	 * @param directionId the primary key for the new direction
	 * @return the new direction
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction createDirection(
		long directionId) {

		return _directionLocalService.createDirection(directionId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction createDirection(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.createDirection(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.gtfs.model.Direction deleteDirection(
		eu.strasbourg.service.gtfs.model.Direction direction) {

		return _directionLocalService.deleteDirection(direction);
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
	@Override
	public eu.strasbourg.service.gtfs.model.Direction deleteDirection(
			long directionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.deleteDirection(directionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _directionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _directionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _directionLocalService.dynamicQuery();
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

		return _directionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _directionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _directionLocalService.dynamicQuery(
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

		return _directionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _directionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Direction fetchDirection(
		long directionId) {

		return _directionLocalService.fetchDirection(directionId);
	}

	/**
	 * Returns the direction matching the UUID and group.
	 *
	 * @param uuid the direction's UUID
	 * @param groupId the primary key of the group
	 * @return the matching direction, or <code>null</code> if a matching direction could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction
		fetchDirectionByUuidAndGroupId(String uuid, long groupId) {

		return _directionLocalService.fetchDirectionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _directionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste de toutes les directions
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction> getAll() {
		return _directionLocalService.getAll();
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getByGroupId(long groupId) {

		return _directionLocalService.getByGroupId(groupId);
	}

	/**
	 * Retourne toutes direction d'une ligne
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getByRouteId(String routeId) {

		return _directionLocalService.getByRouteId(routeId);
	}

	/**
	 * Retourne toutes direction d'un arret
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getByStopId(String stopId) {

		return _directionLocalService.getByStopId(stopId);
	}

	/**
	 * Retourne une direction via son tripId
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction getByTripId(
		String tripId) {

		return _directionLocalService.getByTripId(tripId);
	}

	/**
	 * Returns the direction with the primary key.
	 *
	 * @param directionId the primary key of the direction
	 * @return the direction
	 * @throws PortalException if a direction with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction getDirection(
			long directionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.getDirection(directionId);
	}

	/**
	 * Returns the direction matching the UUID and group.
	 *
	 * @param uuid the direction's UUID
	 * @param groupId the primary key of the group
	 * @return the matching direction
	 * @throws PortalException if a matching direction could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction
			getDirectionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.getDirectionByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirections(int start, int end) {

		return _directionLocalService.getDirections(start, end);
	}

	/**
	 * Returns all the directions matching the UUID and company.
	 *
	 * @param uuid the UUID of the directions
	 * @param companyId the primary key of the company
	 * @return the matching directions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirectionsByUuidAndCompanyId(String uuid, long companyId) {

		return _directionLocalService.getDirectionsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
		getDirectionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.gtfs.model.Direction>
					orderByComparator) {

		return _directionLocalService.getDirectionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of directions.
	 *
	 * @return the number of directions
	 */
	@Override
	public int getDirectionsCount() {
		return _directionLocalService.getDirectionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _directionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _directionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime les entree correspondants au routeId donnee
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
			removeByRouteId(String routeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.removeByRouteId(routeId);
	}

	/**
	 * Supprime les entree correspondants au stopId donnee
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Direction>
			removeByStopId(String stopId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.removeByStopId(stopId);
	}

	/**
	 * Supprime l'entree
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction removeDirection(
			long directionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.removeDirection(directionId);
	}

	/**
	 * Supprime les entrees
	 */
	@Override
	public void removeDirections(
			java.util.List<eu.strasbourg.service.gtfs.model.Direction>
				directions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_directionLocalService.removeDirections(directions);
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
	@Override
	public eu.strasbourg.service.gtfs.model.Direction updateDirection(
		eu.strasbourg.service.gtfs.model.Direction direction) {

		return _directionLocalService.updateDirection(direction);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws PortalException
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Direction updateDirection(
			eu.strasbourg.service.gtfs.model.Direction direction,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _directionLocalService.updateDirection(direction, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	@Override
	public void updateDirections(
			java.util.List<eu.strasbourg.service.gtfs.model.Direction>
				directions,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		_directionLocalService.updateDirections(directions, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _directionLocalService.getBasePersistence();
	}

	@Override
	public DirectionLocalService getWrappedService() {
		return _directionLocalService;
	}

	@Override
	public void setWrappedService(DirectionLocalService directionLocalService) {
		_directionLocalService = directionLocalService;
	}

	private DirectionLocalService _directionLocalService;

}