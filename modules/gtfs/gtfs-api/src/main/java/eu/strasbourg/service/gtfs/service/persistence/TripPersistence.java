/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.gtfs.exception.NoSuchTripException;
import eu.strasbourg.service.gtfs.model.Trip;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see TripUtil
 * @generated
 */
@ProviderType
public interface TripPersistence extends BasePersistence<Trip> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TripUtil} to access the trip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByUuid(String uuid);

	/**
	 * Returns a range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trips
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the trips where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByRouteId(String route_id);

	/**
	 * Returns a range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByRouteId(
		String route_id, int start, int end);

	/**
	 * Returns an ordered range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByRouteId(
		String route_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where route_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param route_id the route_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByRouteId(
		String route_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByRouteId_First(
			String route_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByRouteId_First(
		String route_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByRouteId_Last(
			String route_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByRouteId_Last(
		String route_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where route_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param route_id the route_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByRouteId_PrevAndNext(
			long id, String route_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where route_id = &#63; from the database.
	 *
	 * @param route_id the route_id
	 */
	public void removeByRouteId(String route_id);

	/**
	 * Returns the number of trips where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the number of matching trips
	 */
	public int countByRouteId(String route_id);

	/**
	 * Returns all the trips where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByServiceId(String service_id);

	/**
	 * Returns a range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByServiceId(
		String service_id, int start, int end);

	/**
	 * Returns an ordered range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByServiceId(
		String service_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByServiceId(
		String service_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByServiceId_First(
			String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByServiceId_First(
		String service_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByServiceId_Last(
			String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByServiceId_Last(
		String service_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where service_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByServiceId_PrevAndNext(
			long id, String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where service_id = &#63; from the database.
	 *
	 * @param service_id the service_id
	 */
	public void removeByServiceId(String service_id);

	/**
	 * Returns the number of trips where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the number of matching trips
	 */
	public int countByServiceId(String service_id);

	/**
	 * Returns all the trips where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByTripId(String trip_id);

	/**
	 * Returns a range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByTripId(
		String trip_id, int start, int end);

	/**
	 * Returns an ordered range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByTripId(
		String trip_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where trip_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param trip_id the trip_id
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByTripId(
		String trip_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByTripId_First(
			String trip_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByTripId_First(
		String trip_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByTripId_Last(
			String trip_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByTripId_Last(
		String trip_id,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where trip_id = &#63;.
	 *
	 * @param id the primary key of the current trip
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByTripId_PrevAndNext(
			long id, String trip_id,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where trip_id = &#63; from the database.
	 *
	 * @param trip_id the trip_id
	 */
	public void removeByTripId(String trip_id);

	/**
	 * Returns the number of trips where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the number of matching trips
	 */
	public int countByTripId(String trip_id);

	/**
	 * Caches the trip in the entity cache if it is enabled.
	 *
	 * @param trip the trip
	 */
	public void cacheResult(Trip trip);

	/**
	 * Caches the trips in the entity cache if it is enabled.
	 *
	 * @param trips the trips
	 */
	public void cacheResult(java.util.List<Trip> trips);

	/**
	 * Creates a new trip with the primary key. Does not add the trip to the database.
	 *
	 * @param id the primary key for the new trip
	 * @return the new trip
	 */
	public Trip create(long id);

	/**
	 * Removes the trip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the trip
	 * @return the trip that was removed
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip remove(long id) throws NoSuchTripException;

	public Trip updateImpl(Trip trip);

	/**
	 * Returns the trip with the primary key or throws a <code>NoSuchTripException</code> if it could not be found.
	 *
	 * @param id the primary key of the trip
	 * @return the trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip findByPrimaryKey(long id) throws NoSuchTripException;

	/**
	 * Returns the trip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the trip
	 * @return the trip, or <code>null</code> if a trip with the primary key could not be found
	 */
	public Trip fetchByPrimaryKey(long id);

	/**
	 * Returns all the trips.
	 *
	 * @return the trips
	 */
	public java.util.List<Trip> findAll();

	/**
	 * Returns a range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of trips
	 */
	public java.util.List<Trip> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trips
	 */
	public java.util.List<Trip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trips
	 */
	public java.util.List<Trip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trips from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trips.
	 *
	 * @return the number of trips
	 */
	public int countAll();

}