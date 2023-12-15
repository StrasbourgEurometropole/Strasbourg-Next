/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.exception.NoSuchRouteException;
import eu.strasbourg.service.gtfs.model.Route;
import eu.strasbourg.service.gtfs.model.RouteTable;
import eu.strasbourg.service.gtfs.model.impl.RouteImpl;
import eu.strasbourg.service.gtfs.model.impl.RouteModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.RoutePersistence;
import eu.strasbourg.service.gtfs.service.persistence.RouteUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the route service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class RoutePersistenceImpl
	extends BasePersistenceImpl<Route> implements RoutePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RouteUtil</code> to access the route persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RouteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the routes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching routes
	 */
	@Override
	public List<Route> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Route> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<Route> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Route> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Route> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Route> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Route> list = null;

		if (useFinderCache) {
			list = (List<Route>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Route route : list) {
					if (!uuid.equals(route.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ROUTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RouteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Route>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	@Override
	public Route findByUuid_First(
			String uuid, OrderByComparator<Route> orderByComparator)
		throws NoSuchRouteException {

		Route route = fetchByUuid_First(uuid, orderByComparator);

		if (route != null) {
			return route;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRouteException(sb.toString());
	}

	/**
	 * Returns the first route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching route, or <code>null</code> if a matching route could not be found
	 */
	@Override
	public Route fetchByUuid_First(
		String uuid, OrderByComparator<Route> orderByComparator) {

		List<Route> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	@Override
	public Route findByUuid_Last(
			String uuid, OrderByComparator<Route> orderByComparator)
		throws NoSuchRouteException {

		Route route = fetchByUuid_Last(uuid, orderByComparator);

		if (route != null) {
			return route;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRouteException(sb.toString());
	}

	/**
	 * Returns the last route in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching route, or <code>null</code> if a matching route could not be found
	 */
	@Override
	public Route fetchByUuid_Last(
		String uuid, OrderByComparator<Route> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Route> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the routes before and after the current route in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current route
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	@Override
	public Route[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<Route> orderByComparator)
		throws NoSuchRouteException {

		uuid = Objects.toString(uuid, "");

		Route route = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Route[] array = new RouteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, route, uuid, orderByComparator, true);

			array[1] = route;

			array[2] = getByUuid_PrevAndNext(
				session, route, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Route getByUuid_PrevAndNext(
		Session session, Route route, String uuid,
		OrderByComparator<Route> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ROUTE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(RouteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(route)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Route> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the routes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Route route :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(route);
		}
	}

	/**
	 * Returns the number of routes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching routes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROUTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "route.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(route.uuid IS NULL OR route.uuid = '')";

	private FinderPath _finderPathFetchByRouteId;
	private FinderPath _finderPathCountByRouteId;

	/**
	 * Returns the route where route_id = &#63; or throws a <code>NoSuchRouteException</code> if it could not be found.
	 *
	 * @param route_id the route_id
	 * @return the matching route
	 * @throws NoSuchRouteException if a matching route could not be found
	 */
	@Override
	public Route findByRouteId(String route_id) throws NoSuchRouteException {
		Route route = fetchByRouteId(route_id);

		if (route == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("route_id=");
			sb.append(route_id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchRouteException(sb.toString());
		}

		return route;
	}

	/**
	 * Returns the route where route_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param route_id the route_id
	 * @return the matching route, or <code>null</code> if a matching route could not be found
	 */
	@Override
	public Route fetchByRouteId(String route_id) {
		return fetchByRouteId(route_id, true);
	}

	/**
	 * Returns the route where route_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param route_id the route_id
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching route, or <code>null</code> if a matching route could not be found
	 */
	@Override
	public Route fetchByRouteId(String route_id, boolean useFinderCache) {
		route_id = Objects.toString(route_id, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {route_id};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRouteId, finderArgs, this);
		}

		if (result instanceof Route) {
			Route route = (Route)result;

			if (!Objects.equals(route_id, route.getRoute_id())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ROUTE_WHERE);

			boolean bindRoute_id = false;

			if (route_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROUTEID_ROUTE_ID_3);
			}
			else {
				bindRoute_id = true;

				sb.append(_FINDER_COLUMN_ROUTEID_ROUTE_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoute_id) {
					queryPos.add(route_id);
				}

				List<Route> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRouteId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {route_id};
							}

							_log.warn(
								"RoutePersistenceImpl.fetchByRouteId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Route route = list.get(0);

					result = route;

					cacheResult(route);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Route)result;
		}
	}

	/**
	 * Removes the route where route_id = &#63; from the database.
	 *
	 * @param route_id the route_id
	 * @return the route that was removed
	 */
	@Override
	public Route removeByRouteId(String route_id) throws NoSuchRouteException {
		Route route = findByRouteId(route_id);

		return remove(route);
	}

	/**
	 * Returns the number of routes where route_id = &#63;.
	 *
	 * @param route_id the route_id
	 * @return the number of matching routes
	 */
	@Override
	public int countByRouteId(String route_id) {
		route_id = Objects.toString(route_id, "");

		FinderPath finderPath = _finderPathCountByRouteId;

		Object[] finderArgs = new Object[] {route_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROUTE_WHERE);

			boolean bindRoute_id = false;

			if (route_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROUTEID_ROUTE_ID_3);
			}
			else {
				bindRoute_id = true;

				sb.append(_FINDER_COLUMN_ROUTEID_ROUTE_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRoute_id) {
					queryPos.add(route_id);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ROUTEID_ROUTE_ID_2 =
		"route.route_id = ?";

	private static final String _FINDER_COLUMN_ROUTEID_ROUTE_ID_3 =
		"(route.route_id IS NULL OR route.route_id = '')";

	public RoutePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Route.class);

		setModelImplClass(RouteImpl.class);
		setModelPKClass(long.class);

		setTable(RouteTable.INSTANCE);
	}

	/**
	 * Caches the route in the entity cache if it is enabled.
	 *
	 * @param route the route
	 */
	@Override
	public void cacheResult(Route route) {
		entityCache.putResult(RouteImpl.class, route.getPrimaryKey(), route);

		finderCache.putResult(
			_finderPathFetchByRouteId, new Object[] {route.getRoute_id()},
			route);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the routes in the entity cache if it is enabled.
	 *
	 * @param routes the routes
	 */
	@Override
	public void cacheResult(List<Route> routes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (routes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Route route : routes) {
			if (entityCache.getResult(RouteImpl.class, route.getPrimaryKey()) ==
					null) {

				cacheResult(route);
			}
		}
	}

	/**
	 * Clears the cache for all routes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RouteImpl.class);

		finderCache.clearCache(RouteImpl.class);
	}

	/**
	 * Clears the cache for the route.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Route route) {
		entityCache.removeResult(RouteImpl.class, route);
	}

	@Override
	public void clearCache(List<Route> routes) {
		for (Route route : routes) {
			entityCache.removeResult(RouteImpl.class, route);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RouteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RouteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(RouteModelImpl routeModelImpl) {
		Object[] args = new Object[] {routeModelImpl.getRoute_id()};

		finderCache.putResult(_finderPathCountByRouteId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByRouteId, args, routeModelImpl);
	}

	/**
	 * Creates a new route with the primary key. Does not add the route to the database.
	 *
	 * @param id the primary key for the new route
	 * @return the new route
	 */
	@Override
	public Route create(long id) {
		Route route = new RouteImpl();

		route.setNew(true);
		route.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		route.setUuid(uuid);

		return route;
	}

	/**
	 * Removes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the route
	 * @return the route that was removed
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	@Override
	public Route remove(long id) throws NoSuchRouteException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the route with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the route
	 * @return the route that was removed
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	@Override
	public Route remove(Serializable primaryKey) throws NoSuchRouteException {
		Session session = null;

		try {
			session = openSession();

			Route route = (Route)session.get(RouteImpl.class, primaryKey);

			if (route == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRouteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(route);
		}
		catch (NoSuchRouteException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Route removeImpl(Route route) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(route)) {
				route = (Route)session.get(
					RouteImpl.class, route.getPrimaryKeyObj());
			}

			if (route != null) {
				session.delete(route);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (route != null) {
			clearCache(route);
		}

		return route;
	}

	@Override
	public Route updateImpl(Route route) {
		boolean isNew = route.isNew();

		if (!(route instanceof RouteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(route.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(route);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in route proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Route implementation " +
					route.getClass());
		}

		RouteModelImpl routeModelImpl = (RouteModelImpl)route;

		if (Validator.isNull(route.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			route.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(route);
			}
			else {
				route = (Route)session.merge(route);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(RouteImpl.class, routeModelImpl, false, true);

		cacheUniqueFindersCache(routeModelImpl);

		if (isNew) {
			route.setNew(false);
		}

		route.resetOriginalValues();

		return route;
	}

	/**
	 * Returns the route with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the route
	 * @return the route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	@Override
	public Route findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRouteException {

		Route route = fetchByPrimaryKey(primaryKey);

		if (route == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRouteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return route;
	}

	/**
	 * Returns the route with the primary key or throws a <code>NoSuchRouteException</code> if it could not be found.
	 *
	 * @param id the primary key of the route
	 * @return the route
	 * @throws NoSuchRouteException if a route with the primary key could not be found
	 */
	@Override
	public Route findByPrimaryKey(long id) throws NoSuchRouteException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the route with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the route
	 * @return the route, or <code>null</code> if a route with the primary key could not be found
	 */
	@Override
	public Route fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the routes.
	 *
	 * @return the routes
	 */
	@Override
	public List<Route> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Route> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Route> findAll(
		int start, int end, OrderByComparator<Route> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Route> findAll(
		int start, int end, OrderByComparator<Route> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Route> list = null;

		if (useFinderCache) {
			list = (List<Route>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROUTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROUTE;

				sql = sql.concat(RouteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Route>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the routes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Route route : findAll()) {
			remove(route);
		}
	}

	/**
	 * Returns the number of routes.
	 *
	 * @return the number of routes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ROUTE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROUTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RouteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the route persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByRouteId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRouteId",
			new String[] {String.class.getName()}, new String[] {"route_id"},
			true);

		_finderPathCountByRouteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRouteId",
			new String[] {String.class.getName()}, new String[] {"route_id"},
			false);

		RouteUtil.setPersistence(this);
	}

	public void destroy() {
		RouteUtil.setPersistence(null);

		entityCache.removeCache(RouteImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ROUTE =
		"SELECT route FROM Route route";

	private static final String _SQL_SELECT_ROUTE_WHERE =
		"SELECT route FROM Route route WHERE ";

	private static final String _SQL_COUNT_ROUTE =
		"SELECT COUNT(route) FROM Route route";

	private static final String _SQL_COUNT_ROUTE_WHERE =
		"SELECT COUNT(route) FROM Route route WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "route.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Route exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Route exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RoutePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}