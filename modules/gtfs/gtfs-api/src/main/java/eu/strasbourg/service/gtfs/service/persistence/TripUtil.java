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

package eu.strasbourg.service.gtfs.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.Trip;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the trip service. This utility wraps <code>eu.strasbourg.service.gtfs.service.persistence.impl.TripPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see TripPersistence
 * @generated
 */
@ProviderType
public class TripUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Trip trip) {
		getPersistence().clearCache(trip);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Trip> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Trip> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Trip> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Trip> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Trip update(Trip trip) {
		return getPersistence().update(trip);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Trip update(Trip trip, ServiceContext serviceContext) {
		return getPersistence().update(trip, serviceContext);
	}

	/**
	 * Returns all the trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trips
	 */
	public static List<Trip> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public static List<Trip> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Trip> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByUuid_First(
			String uuid, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByUuid_First(
		String uuid, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByUuid_Last(
			String uuid, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByUuid_Last(
		String uuid, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the trips before and after the current trip in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the trips where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trips
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the trips where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the matching trips
	 */
	public static List<Trip> findByRouteId(String route_id) {
		return getPersistence().findByRouteId(route_id);
	}

	/**
	 * Returns a range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public static List<Trip> findByRouteId(
		String route_id, int start, int end) {

		return getPersistence().findByRouteId(route_id, start, end);
	}

	/**
	 * Returns an ordered range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByRouteId(
		String route_id, int start, int end,
		OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findByRouteId(
			route_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByRouteId(
		String route_id, int start, int end,
		OrderByComparator<Trip> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByRouteId(
			route_id, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByRouteId_First(
			String route_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByRouteId_First(
			route_id, orderByComparator);
	}

	/**
	 * Returns the first trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByRouteId_First(
		String route_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByRouteId_First(
			route_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByRouteId_Last(
			String route_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByRouteId_Last(route_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByRouteId_Last(
		String route_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByRouteId_Last(
			route_id, orderByComparator);
	}

	/**
	 * Returns the trips before and after the current trip in the ordered set where route_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip[] findByRouteId_PrevAndNext(
			long id, String route_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByRouteId_PrevAndNext(
			id, route_id, orderByComparator);
	}

	/**
	 * Removes all the trips where route_id = &#63; from the database.
	 *
	 * @param route_id the route_id
	 */
	public static void removeByRouteId(String route_id) {
		getPersistence().removeByRouteId(route_id);
	}

	/**
	 * Returns the number of trips where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the number of matching trips
	 */
	public static int countByRouteId(String route_id) {
		return getPersistence().countByRouteId(route_id);
	}

	/**
	 * Returns all the trips where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the matching trips
	 */
	public static List<Trip> findByServiceId(String service_id) {
		return getPersistence().findByServiceId(service_id);
	}

	/**
	 * Returns a range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public static List<Trip> findByServiceId(
		String service_id, int start, int end) {

		return getPersistence().findByServiceId(service_id, start, end);
	}

	/**
	 * Returns an ordered range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByServiceId(
		String service_id, int start, int end,
		OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findByServiceId(
			service_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByServiceId(
		String service_id, int start, int end,
		OrderByComparator<Trip> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByServiceId(
			service_id, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByServiceId_First(
			String service_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByServiceId_First(
			service_id, orderByComparator);
	}

	/**
	 * Returns the first trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByServiceId_First(
		String service_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByServiceId_First(
			service_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByServiceId_Last(
			String service_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByServiceId_Last(
			service_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByServiceId_Last(
		String service_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByServiceId_Last(
			service_id, orderByComparator);
	}

	/**
	 * Returns the trips before and after the current trip in the ordered set where service_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip[] findByServiceId_PrevAndNext(
			long id, String service_id,
			OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByServiceId_PrevAndNext(
			id, service_id, orderByComparator);
	}

	/**
	 * Removes all the trips where service_id = &#63; from the database.
	 *
	 * @param service_id the service_id
	 */
	public static void removeByServiceId(String service_id) {
		getPersistence().removeByServiceId(service_id);
	}

	/**
	 * Returns the number of trips where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the number of matching trips
	 */
	public static int countByServiceId(String service_id) {
		return getPersistence().countByServiceId(service_id);
	}

	/**
	 * Returns all the trips where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the matching trips
	 */
	public static List<Trip> findByTripId(String trip_id) {
		return getPersistence().findByTripId(trip_id);
	}

	/**
	 * Returns a range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public static List<Trip> findByTripId(String trip_id, int start, int end) {
		return getPersistence().findByTripId(trip_id, start, end);
	}

	/**
	 * Returns an ordered range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findByTripId(
			trip_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching trips
	 */
	public static List<Trip> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<Trip> orderByComparator, boolean retrieveFromCache) {

		return getPersistence().findByTripId(
			trip_id, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByTripId_First(
			String trip_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByTripId_First(trip_id, orderByComparator);
	}

	/**
	 * Returns the first trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByTripId_First(
		String trip_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByTripId_First(trip_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public static Trip findByTripId_Last(
			String trip_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByTripId_Last(trip_id, orderByComparator);
	}

	/**
	 * Returns the last trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public static Trip fetchByTripId_Last(
		String trip_id, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().fetchByTripId_Last(trip_id, orderByComparator);
	}

	/**
	 * Returns the trips before and after the current trip in the ordered set where trip_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip[] findByTripId_PrevAndNext(
			long id, String trip_id, OrderByComparator<Trip> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByTripId_PrevAndNext(
			id, trip_id, orderByComparator);
	}

	/**
	 * Removes all the trips where trip_id = &#63; from the database.
	 *
	 * @param trip_id the trip_id
	 */
	public static void removeByTripId(String trip_id) {
		getPersistence().removeByTripId(trip_id);
	}

	/**
	 * Returns the number of trips where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the number of matching trips
	 */
	public static int countByTripId(String trip_id) {
		return getPersistence().countByTripId(trip_id);
	}

	/**
	 * Caches the trip in the entity cache if it is enabled.
	 *
	 * @param trip the trip
	 */
	public static void cacheResult(Trip trip) {
		getPersistence().cacheResult(trip);
	}

	/**
	 * Caches the trips in the entity cache if it is enabled.
	 *
	 * @param trips the trips
	 */
	public static void cacheResult(List<Trip> trips) {
		getPersistence().cacheResult(trips);
	}

	/**
	 * Creates a new trip with the primary key. Does not add the trip to the database.
	 *
	 * @param id the primary key for the new trip
	 * @return the new trip
	 */
	public static Trip create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the trip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trip
	 * @return the trip that was removed
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip remove(long id)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().remove(id);
	}

	public static Trip updateImpl(Trip trip) {
		return getPersistence().updateImpl(trip);
	}

	/**
	 * Returns the trip with the primary key or throws a <code>NoSuchTripException</code> if it could not be found.
	 *
	 * @param id the primary key of the trip
	 * @return the trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public static Trip findByPrimaryKey(long id)
		throws eu.strasbourg.service.gtfs.exception.NoSuchTripException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the trip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trip
	 * @return the trip, or <code>null</code> if a trip with the primary key could not be found
	 */
	public static Trip fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the trips.
	 *
	 * @return the trips
	 */
	public static List<Trip> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of trips
	 */
	public static List<Trip> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trips
	 */
	public static List<Trip> findAll(
		int start, int end, OrderByComparator<Trip> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TripModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of trips
	 */
	public static List<Trip> findAll(
		int start, int end, OrderByComparator<Trip> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the trips from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of trips.
	 *
	 * @return the number of trips
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static TripPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TripPersistence, TripPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TripPersistence.class);

		ServiceTracker<TripPersistence, TripPersistence> serviceTracker =
			new ServiceTracker<TripPersistence, TripPersistence>(
				bundle.getBundleContext(), TripPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}