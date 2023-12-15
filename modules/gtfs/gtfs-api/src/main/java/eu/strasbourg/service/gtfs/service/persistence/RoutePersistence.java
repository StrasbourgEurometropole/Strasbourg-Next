/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.gtfs.exception.NoSuchRouteException;
import eu.strasbourg.service.gtfs.model.Route;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see RouteUtil
 * @generated
 */
@ProviderType
public interface RoutePersistence extends BasePersistence<Route> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RouteUtil} to access the route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the routes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching routes
	 */
	public java.util.List<Route> findByUuid(String uuid);

	/**
	 * Returns a range of all the routes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @return the range of matching routes
	 */
	public java.util.List<Route> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the routes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching routes
	 */
	public java.util.List<Route> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator);

	/**
	 * Returns an ordered range of all the routes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching routes
	 */
	public java.util.List<Route> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	public Route findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Route>
				orderByComparator)
		throws NoSuchRouteException;

	/**
	 * Returns the first route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching route, or <code>null</code> if a matching route could not be found
	 */
	public Route fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator);

	/**
	 * Returns the last route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	public Route findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Route>
				orderByComparator)
		throws NoSuchRouteException;

	/**
	 * Returns the last route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching route, or <code>null</code> if a matching route could not be found
	 */
	public Route fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator);

	/**
	 * Returns the routes before and after the current route in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current route
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	public Route[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Route>
				orderByComparator)
		throws NoSuchRouteException;

	/**
	 * Removes all the routes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of routes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching routes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the route where route_id = &#63; or throws a <code>NoSuchRouteException</code> if it could not be found.
	 *
	 * @param route_id the route_id
	 * @return the matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	public Route findByRouteId(String route_id) throws NoSuchRouteException;

	/**
	 * Returns the route where route_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param route_id the route_id
	 * @return the matching route, or <code>null</code> if a matching route could not be found
	 */
	public Route fetchByRouteId(String route_id);

	/**
	 * Returns the route where route_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param route_id the route_id
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching route, or <code>null</code> if a matching route could not be found
	 */
	public Route fetchByRouteId(String route_id, boolean useFinderCache);

	/**
	 * Removes the route where route_id = &#63; from the database.
	 *
	 * @param route_id the route_id
	 * @return the route that was removed
	 */
	public Route removeByRouteId(String route_id) throws NoSuchRouteException;

	/**
	 * Returns the number of routes where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the number of matching routes
	 */
	public int countByRouteId(String route_id);

	/**
	 * Caches the route in the entity cache if it is enabled.
	 *
	 * @param route the route
	 */
	public void cacheResult(Route route);

	/**
	 * Caches the routes in the entity cache if it is enabled.
	 *
	 * @param routes the routes
	 */
	public void cacheResult(java.util.List<Route> routes);

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param id the primary key for the new route
	 * @return the new route
	 */
	public Route create(long id);

	/**
	 * Removes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the route
	 * @return the route that was removed
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	public Route remove(long id) throws NoSuchRouteException;

	public Route updateImpl(Route route);

	/**
	 * Returns the route with the primary key or throws a <code>NoSuchRouteException</code> if it could not be found.
	 *
	 * @param id the primary key of the route
	 * @return the route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	public Route findByPrimaryKey(long id) throws NoSuchRouteException;

	/**
	 * Returns the route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the route
	 * @return the route, or <code>null</code> if a route with the primary key could not be found
	 */
	public Route fetchByPrimaryKey(long id);

	/**
	 * Returns all the routes.
	 *
	 * @return the routes
	 */
	public java.util.List<Route> findAll();

	/**
	 * Returns a range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @return the range of routes
	 */
	public java.util.List<Route> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of routes
	 */
	public java.util.List<Route> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator);

	/**
	 * Returns an ordered range of all the routes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RouteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of routes
	 * @param end the upper bound of the range of routes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of routes
	 */
	public java.util.List<Route> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Route>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the routes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of routes.
	 *
	 * @return the number of routes
	 */
	public int countAll();

}