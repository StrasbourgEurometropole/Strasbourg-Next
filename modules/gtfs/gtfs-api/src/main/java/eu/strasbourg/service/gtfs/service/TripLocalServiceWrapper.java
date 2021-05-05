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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TripLocalService}.
 *
 * @author Cedric Henry
 * @see TripLocalService
 * @generated
 */
@ProviderType
public class TripLocalServiceWrapper
	implements TripLocalService, ServiceWrapper<TripLocalService> {

	public TripLocalServiceWrapper(TripLocalService tripLocalService) {
		_tripLocalService = tripLocalService;
	}

	/**
	 * Adds the trip to the database. Also notifies the appropriate model listeners.
	 *
	 * @param trip the trip
	 * @return the trip that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip addTrip(
		eu.strasbourg.service.gtfs.model.Trip trip) {

		return _tripLocalService.addTrip(trip);
	}

	/**
	 * Creates a new trip with the primary key. Does not add the trip to the database.
	 *
	 * @param trip_id the primary key for the new trip
	 * @return the new trip
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip createTrip(String trip_id) {
		return _tripLocalService.createTrip(trip_id);
	}

	/**
	 * Crée un voyage à partir d'une entrée GTFS
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip createTripFromGTFS(
			eu.strasbourg.utils.models.TripsGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.createTripFromGTFS(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trip_id the primary key of the trip
	 * @return the trip that was removed
	 * @throws PortalException if a trip with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip deleteTrip(String trip_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.deleteTrip(trip_id);
	}

	/**
	 * Deletes the trip from the database. Also notifies the appropriate model listeners.
	 *
	 * @param trip the trip
	 * @return the trip that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip deleteTrip(
		eu.strasbourg.service.gtfs.model.Trip trip) {

		return _tripLocalService.deleteTrip(trip);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tripLocalService.dynamicQuery();
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

		return _tripLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _tripLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _tripLocalService.dynamicQuery(
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

		return _tripLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tripLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Trip fetchTrip(String trip_id) {
		return _tripLocalService.fetchTrip(trip_id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tripLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trip with the primary key.
	 *
	 * @param trip_id the primary key of the trip
	 * @return the trip
	 * @throws PortalException if a trip with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip getTrip(String trip_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.getTrip(trip_id);
	}

	/**
	 * Rechercher les voyages disponibles aujourd'hui pour id d'arret donne
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Trip>
		getTripAvailableForStop(String stopId) {

		return _tripLocalService.getTripAvailableForStop(stopId);
	}

	/**
	 * Returns a range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of trips
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Trip> getTrips(
		int start, int end) {

		return _tripLocalService.getTrips(start, end);
	}

	/**
	 * Returns the number of trips.
	 *
	 * @return the number of trips
	 */
	@Override
	public int getTripsCount() {
		return _tripLocalService.getTripsCount();
	}

	/**
	 * Import des voyage sous le format de données GTFS
	 */
	@Override
	public void importFromGTFS(
			java.util.Map<String, eu.strasbourg.utils.models.TripsGTFS> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		_tripLocalService.importFromGTFS(data);
	}

	/**
	 * Supprime toutes les Trips
	 */
	@Override
	public void removeAllTrips()
		throws com.liferay.portal.kernel.exception.PortalException {

		_tripLocalService.removeAllTrips();
	}

	/**
	 * Supprime une agence
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip removeTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.removeTrip(tripId);
	}

	/**
	 * Updates the trip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param trip the trip
	 * @return the trip that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip updateTrip(
		eu.strasbourg.service.gtfs.model.Trip trip) {

		return _tripLocalService.updateTrip(trip);
	}

	/**
	 * Met à jour un Trip et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Trip updateTrip(
			eu.strasbourg.service.gtfs.model.Trip trip,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.updateTrip(trip, sc);
	}

	@Override
	public TripLocalService getWrappedService() {
		return _tripLocalService;
	}

	@Override
	public void setWrappedService(TripLocalService tripLocalService) {
		_tripLocalService = tripLocalService;
	}

	private TripLocalService _tripLocalService;

}