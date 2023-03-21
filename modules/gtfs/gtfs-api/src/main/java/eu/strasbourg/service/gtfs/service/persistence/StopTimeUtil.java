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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.StopTime;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the stop time service. This utility wraps <code>eu.strasbourg.service.gtfs.service.persistence.impl.StopTimePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see StopTimePersistence
 * @generated
 */
public class StopTimeUtil {

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
	public static void clearCache(StopTime stopTime) {
		getPersistence().clearCache(stopTime);
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
	public static Map<Serializable, StopTime> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<StopTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<StopTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<StopTime> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static StopTime update(StopTime stopTime) {
		return getPersistence().update(stopTime);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static StopTime update(
		StopTime stopTime, ServiceContext serviceContext) {

		return getPersistence().update(stopTime, serviceContext);
	}

	/**
	 * Returns all the stop times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stop times
	 */
	public static List<StopTime> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the stop times where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of matching stop times
	 */
	public static List<StopTime> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the stop times where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stop times where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByUuid_First(
			String uuid, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByUuid_First(
		String uuid, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByUuid_Last(
			String uuid, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByUuid_Last(
		String uuid, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the stop times before and after the current stop time in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current stop time
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	public static StopTime[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the stop times where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of stop times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stop times
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the stop times where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the matching stop times
	 */
	public static List<StopTime> findByTripId(String trip_id) {
		return getPersistence().findByTripId(trip_id);
	}

	/**
	 * Returns a range of all the stop times where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of matching stop times
	 */
	public static List<StopTime> findByTripId(
		String trip_id, int start, int end) {

		return getPersistence().findByTripId(trip_id, start, end);
	}

	/**
	 * Returns an ordered range of all the stop times where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().findByTripId(
			trip_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stop times where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTripId(
			trip_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByTripId_First(
			String trip_id, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByTripId_First(trip_id, orderByComparator);
	}

	/**
	 * Returns the first stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByTripId_First(
		String trip_id, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByTripId_First(trip_id, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByTripId_Last(
			String trip_id, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByTripId_Last(trip_id, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByTripId_Last(
		String trip_id, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByTripId_Last(trip_id, orderByComparator);
	}

	/**
	 * Returns the stop times before and after the current stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param id the primary key of the current stop time
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	public static StopTime[] findByTripId_PrevAndNext(
			long id, String trip_id,
			OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByTripId_PrevAndNext(
			id, trip_id, orderByComparator);
	}

	/**
	 * Removes all the stop times where trip_id = &#63; from the database.
	 *
	 * @param trip_id the trip_id
	 */
	public static void removeByTripId(String trip_id) {
		getPersistence().removeByTripId(trip_id);
	}

	/**
	 * Returns the number of stop times where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the number of matching stop times
	 */
	public static int countByTripId(String trip_id) {
		return getPersistence().countByTripId(trip_id);
	}

	/**
	 * Returns all the stop times where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @return the matching stop times
	 */
	public static List<StopTime> findByStopId(String stop_id) {
		return getPersistence().findByStopId(stop_id);
	}

	/**
	 * Returns a range of all the stop times where stop_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param stop_id the stop_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of matching stop times
	 */
	public static List<StopTime> findByStopId(
		String stop_id, int start, int end) {

		return getPersistence().findByStopId(stop_id, start, end);
	}

	/**
	 * Returns an ordered range of all the stop times where stop_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param stop_id the stop_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByStopId(
		String stop_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().findByStopId(
			stop_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stop times where stop_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param stop_id the stop_id
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stop times
	 */
	public static List<StopTime> findByStopId(
		String stop_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStopId(
			stop_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByStopId_First(
			String stop_id, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByStopId_First(stop_id, orderByComparator);
	}

	/**
	 * Returns the first stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByStopId_First(
		String stop_id, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByStopId_First(stop_id, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	public static StopTime findByStopId_Last(
			String stop_id, OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByStopId_Last(stop_id, orderByComparator);
	}

	/**
	 * Returns the last stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	public static StopTime fetchByStopId_Last(
		String stop_id, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().fetchByStopId_Last(stop_id, orderByComparator);
	}

	/**
	 * Returns the stop times before and after the current stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param id the primary key of the current stop time
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	public static StopTime[] findByStopId_PrevAndNext(
			long id, String stop_id,
			OrderByComparator<StopTime> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByStopId_PrevAndNext(
			id, stop_id, orderByComparator);
	}

	/**
	 * Removes all the stop times where stop_id = &#63; from the database.
	 *
	 * @param stop_id the stop_id
	 */
	public static void removeByStopId(String stop_id) {
		getPersistence().removeByStopId(stop_id);
	}

	/**
	 * Returns the number of stop times where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @return the number of matching stop times
	 */
	public static int countByStopId(String stop_id) {
		return getPersistence().countByStopId(stop_id);
	}

	/**
	 * Caches the stop time in the entity cache if it is enabled.
	 *
	 * @param stopTime the stop time
	 */
	public static void cacheResult(StopTime stopTime) {
		getPersistence().cacheResult(stopTime);
	}

	/**
	 * Caches the stop times in the entity cache if it is enabled.
	 *
	 * @param stopTimes the stop times
	 */
	public static void cacheResult(List<StopTime> stopTimes) {
		getPersistence().cacheResult(stopTimes);
	}

	/**
	 * Creates a new stop time with the primary key. Does not add the stop time to the database.
	 *
	 * @param id the primary key for the new stop time
	 * @return the new stop time
	 */
	public static StopTime create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the stop time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time that was removed
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	public static StopTime remove(long id)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().remove(id);
	}

	public static StopTime updateImpl(StopTime stopTime) {
		return getPersistence().updateImpl(stopTime);
	}

	/**
	 * Returns the stop time with the primary key or throws a <code>NoSuchStopTimeException</code> if it could not be found.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	public static StopTime findByPrimaryKey(long id)
		throws eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the stop time with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time, or <code>null</code> if a stop time with the primary key could not be found
	 */
	public static StopTime fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the stop times.
	 *
	 * @return the stop times
	 */
	public static List<StopTime> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stop times.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @return the range of stop times
	 */
	public static List<StopTime> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stop times.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stop times
	 */
	public static List<StopTime> findAll(
		int start, int end, OrderByComparator<StopTime> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stop times.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StopTimeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stop times
	 * @param end the upper bound of the range of stop times (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stop times
	 */
	public static List<StopTime> findAll(
		int start, int end, OrderByComparator<StopTime> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stop times from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stop times.
	 *
	 * @return the number of stop times
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StopTimePersistence getPersistence() {
		return _persistence;
	}

	private static volatile StopTimePersistence _persistence;

}