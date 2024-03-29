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

package eu.strasbourg.service.gtfs.service.persistence.impl;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.exception.NoSuchStopTimeException;
import eu.strasbourg.service.gtfs.model.StopTime;
import eu.strasbourg.service.gtfs.model.impl.StopTimeImpl;
import eu.strasbourg.service.gtfs.model.impl.StopTimeModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.StopTimePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the stop time service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class StopTimePersistenceImpl
	extends BasePersistenceImpl<StopTime> implements StopTimePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StopTimeUtil</code> to access the stop time persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StopTimeImpl.class.getName();

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
	 * Returns all the stop times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stop times
	 */
	@Override
	public List<StopTime> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StopTime> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<StopTime> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<StopTime> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

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

		List<StopTime> list = null;

		if (useFinderCache) {
			list = (List<StopTime>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StopTime stopTime : list) {
					if (!uuid.equals(stopTime.getUuid())) {
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

			sb.append(_SQL_SELECT_STOPTIME_WHERE);

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
				sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
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

				list = (List<StopTime>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByUuid_First(
			String uuid, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByUuid_First(uuid, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the first stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByUuid_First(
		String uuid, OrderByComparator<StopTime> orderByComparator) {

		List<StopTime> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByUuid_Last(
			String uuid, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByUuid_Last(uuid, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the last stop time in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByUuid_Last(
		String uuid, OrderByComparator<StopTime> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StopTime> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public StopTime[] findByUuid_PrevAndNext(
			long id, String uuid, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		uuid = Objects.toString(uuid, "");

		StopTime stopTime = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StopTime[] array = new StopTimeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, stopTime, uuid, orderByComparator, true);

			array[1] = stopTime;

			array[2] = getByUuid_PrevAndNext(
				session, stopTime, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StopTime getByUuid_PrevAndNext(
		Session session, StopTime stopTime, String uuid,
		OrderByComparator<StopTime> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STOPTIME_WHERE);

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
			sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(stopTime)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StopTime> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop times where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StopTime stopTime :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stopTime);
		}
	}

	/**
	 * Returns the number of stop times where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stop times
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STOPTIME_WHERE);

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
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"stopTime.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(stopTime.uuid IS NULL OR stopTime.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByTripId;
	private FinderPath _finderPathWithoutPaginationFindByTripId;
	private FinderPath _finderPathCountByTripId;

	/**
	 * Returns all the stop times where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the matching stop times
	 */
	@Override
	public List<StopTime> findByTripId(String trip_id) {
		return findByTripId(
			trip_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StopTime> findByTripId(String trip_id, int start, int end) {
		return findByTripId(trip_id, start, end, null);
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
	@Override
	public List<StopTime> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return findByTripId(trip_id, start, end, orderByComparator, true);
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
	@Override
	public List<StopTime> findByTripId(
		String trip_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

		trip_id = Objects.toString(trip_id, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTripId;
				finderArgs = new Object[] {trip_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTripId;
			finderArgs = new Object[] {trip_id, start, end, orderByComparator};
		}

		List<StopTime> list = null;

		if (useFinderCache) {
			list = (List<StopTime>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StopTime stopTime : list) {
					if (!trip_id.equals(stopTime.getTrip_id())) {
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

			sb.append(_SQL_SELECT_STOPTIME_WHERE);

			boolean bindTrip_id = false;

			if (trip_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_3);
			}
			else {
				bindTrip_id = true;

				sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrip_id) {
					queryPos.add(trip_id);
				}

				list = (List<StopTime>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByTripId_First(
			String trip_id, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByTripId_First(trip_id, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trip_id=");
		sb.append(trip_id);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the first stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByTripId_First(
		String trip_id, OrderByComparator<StopTime> orderByComparator) {

		List<StopTime> list = findByTripId(trip_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByTripId_Last(
			String trip_id, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByTripId_Last(trip_id, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("trip_id=");
		sb.append(trip_id);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the last stop time in the ordered set where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByTripId_Last(
		String trip_id, OrderByComparator<StopTime> orderByComparator) {

		int count = countByTripId(trip_id);

		if (count == 0) {
			return null;
		}

		List<StopTime> list = findByTripId(
			trip_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public StopTime[] findByTripId_PrevAndNext(
			long id, String trip_id,
			OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		trip_id = Objects.toString(trip_id, "");

		StopTime stopTime = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StopTime[] array = new StopTimeImpl[3];

			array[0] = getByTripId_PrevAndNext(
				session, stopTime, trip_id, orderByComparator, true);

			array[1] = stopTime;

			array[2] = getByTripId_PrevAndNext(
				session, stopTime, trip_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StopTime getByTripId_PrevAndNext(
		Session session, StopTime stopTime, String trip_id,
		OrderByComparator<StopTime> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STOPTIME_WHERE);

		boolean bindTrip_id = false;

		if (trip_id.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_3);
		}
		else {
			bindTrip_id = true;

			sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_2);
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
			sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTrip_id) {
			queryPos.add(trip_id);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stopTime)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StopTime> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop times where trip_id = &#63; from the database.
	 *
	 * @param trip_id the trip_id
	 */
	@Override
	public void removeByTripId(String trip_id) {
		for (StopTime stopTime :
				findByTripId(
					trip_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stopTime);
		}
	}

	/**
	 * Returns the number of stop times where trip_id = &#63;.
	 *
	 * @param trip_id the trip_id
	 * @return the number of matching stop times
	 */
	@Override
	public int countByTripId(String trip_id) {
		trip_id = Objects.toString(trip_id, "");

		FinderPath finderPath = _finderPathCountByTripId;

		Object[] finderArgs = new Object[] {trip_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STOPTIME_WHERE);

			boolean bindTrip_id = false;

			if (trip_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_3);
			}
			else {
				bindTrip_id = true;

				sb.append(_FINDER_COLUMN_TRIPID_TRIP_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTrip_id) {
					queryPos.add(trip_id);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRIPID_TRIP_ID_2 =
		"stopTime.trip_id = ?";

	private static final String _FINDER_COLUMN_TRIPID_TRIP_ID_3 =
		"(stopTime.trip_id IS NULL OR stopTime.trip_id = '')";

	private FinderPath _finderPathWithPaginationFindByStopId;
	private FinderPath _finderPathWithoutPaginationFindByStopId;
	private FinderPath _finderPathCountByStopId;

	/**
	 * Returns all the stop times where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @return the matching stop times
	 */
	@Override
	public List<StopTime> findByStopId(String stop_id) {
		return findByStopId(
			stop_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StopTime> findByStopId(String stop_id, int start, int end) {
		return findByStopId(stop_id, start, end, null);
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
	@Override
	public List<StopTime> findByStopId(
		String stop_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator) {

		return findByStopId(stop_id, start, end, orderByComparator, true);
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
	@Override
	public List<StopTime> findByStopId(
		String stop_id, int start, int end,
		OrderByComparator<StopTime> orderByComparator, boolean useFinderCache) {

		stop_id = Objects.toString(stop_id, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStopId;
				finderArgs = new Object[] {stop_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStopId;
			finderArgs = new Object[] {stop_id, start, end, orderByComparator};
		}

		List<StopTime> list = null;

		if (useFinderCache) {
			list = (List<StopTime>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StopTime stopTime : list) {
					if (!stop_id.equals(stopTime.getStop_id())) {
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

			sb.append(_SQL_SELECT_STOPTIME_WHERE);

			boolean bindStop_id = false;

			if (stop_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPID_STOP_ID_3);
			}
			else {
				bindStop_id = true;

				sb.append(_FINDER_COLUMN_STOPID_STOP_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStop_id) {
					queryPos.add(stop_id);
				}

				list = (List<StopTime>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByStopId_First(
			String stop_id, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByStopId_First(stop_id, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stop_id=");
		sb.append(stop_id);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the first stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByStopId_First(
		String stop_id, OrderByComparator<StopTime> orderByComparator) {

		List<StopTime> list = findByStopId(stop_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time
	 * @throws NoSuchStopTimeException if a matching stop time could not be found
	 */
	@Override
	public StopTime findByStopId_Last(
			String stop_id, OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByStopId_Last(stop_id, orderByComparator);

		if (stopTime != null) {
			return stopTime;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stop_id=");
		sb.append(stop_id);

		sb.append("}");

		throw new NoSuchStopTimeException(sb.toString());
	}

	/**
	 * Returns the last stop time in the ordered set where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop time, or <code>null</code> if a matching stop time could not be found
	 */
	@Override
	public StopTime fetchByStopId_Last(
		String stop_id, OrderByComparator<StopTime> orderByComparator) {

		int count = countByStopId(stop_id);

		if (count == 0) {
			return null;
		}

		List<StopTime> list = findByStopId(
			stop_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public StopTime[] findByStopId_PrevAndNext(
			long id, String stop_id,
			OrderByComparator<StopTime> orderByComparator)
		throws NoSuchStopTimeException {

		stop_id = Objects.toString(stop_id, "");

		StopTime stopTime = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			StopTime[] array = new StopTimeImpl[3];

			array[0] = getByStopId_PrevAndNext(
				session, stopTime, stop_id, orderByComparator, true);

			array[1] = stopTime;

			array[2] = getByStopId_PrevAndNext(
				session, stopTime, stop_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected StopTime getByStopId_PrevAndNext(
		Session session, StopTime stopTime, String stop_id,
		OrderByComparator<StopTime> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STOPTIME_WHERE);

		boolean bindStop_id = false;

		if (stop_id.isEmpty()) {
			sb.append(_FINDER_COLUMN_STOPID_STOP_ID_3);
		}
		else {
			bindStop_id = true;

			sb.append(_FINDER_COLUMN_STOPID_STOP_ID_2);
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
			sb.append(StopTimeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStop_id) {
			queryPos.add(stop_id);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stopTime)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<StopTime> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stop times where stop_id = &#63; from the database.
	 *
	 * @param stop_id the stop_id
	 */
	@Override
	public void removeByStopId(String stop_id) {
		for (StopTime stopTime :
				findByStopId(
					stop_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stopTime);
		}
	}

	/**
	 * Returns the number of stop times where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @return the number of matching stop times
	 */
	@Override
	public int countByStopId(String stop_id) {
		stop_id = Objects.toString(stop_id, "");

		FinderPath finderPath = _finderPathCountByStopId;

		Object[] finderArgs = new Object[] {stop_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STOPTIME_WHERE);

			boolean bindStop_id = false;

			if (stop_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPID_STOP_ID_3);
			}
			else {
				bindStop_id = true;

				sb.append(_FINDER_COLUMN_STOPID_STOP_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStop_id) {
					queryPos.add(stop_id);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STOPID_STOP_ID_2 =
		"stopTime.stop_id = ?";

	private static final String _FINDER_COLUMN_STOPID_STOP_ID_3 =
		"(stopTime.stop_id IS NULL OR stopTime.stop_id = '')";

	public StopTimePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(StopTime.class);
	}

	/**
	 * Caches the stop time in the entity cache if it is enabled.
	 *
	 * @param stopTime the stop time
	 */
	@Override
	public void cacheResult(StopTime stopTime) {
		entityCache.putResult(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
			stopTime.getPrimaryKey(), stopTime);

		stopTime.resetOriginalValues();
	}

	/**
	 * Caches the stop times in the entity cache if it is enabled.
	 *
	 * @param stopTimes the stop times
	 */
	@Override
	public void cacheResult(List<StopTime> stopTimes) {
		for (StopTime stopTime : stopTimes) {
			if (entityCache.getResult(
					StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
					stopTime.getPrimaryKey()) == null) {

				cacheResult(stopTime);
			}
			else {
				stopTime.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stop times.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StopTimeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stop time.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StopTime stopTime) {
		entityCache.removeResult(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
			stopTime.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StopTime> stopTimes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StopTime stopTime : stopTimes) {
			entityCache.removeResult(
				StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
				stopTime.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
				primaryKey);
		}
	}

	/**
	 * Creates a new stop time with the primary key. Does not add the stop time to the database.
	 *
	 * @param id the primary key for the new stop time
	 * @return the new stop time
	 */
	@Override
	public StopTime create(long id) {
		StopTime stopTime = new StopTimeImpl();

		stopTime.setNew(true);
		stopTime.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		stopTime.setUuid(uuid);

		return stopTime;
	}

	/**
	 * Removes the stop time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time that was removed
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime remove(long id) throws NoSuchStopTimeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the stop time with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stop time
	 * @return the stop time that was removed
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime remove(Serializable primaryKey)
		throws NoSuchStopTimeException {

		Session session = null;

		try {
			session = openSession();

			StopTime stopTime = (StopTime)session.get(
				StopTimeImpl.class, primaryKey);

			if (stopTime == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStopTimeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stopTime);
		}
		catch (NoSuchStopTimeException noSuchEntityException) {
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
	protected StopTime removeImpl(StopTime stopTime) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stopTime)) {
				stopTime = (StopTime)session.get(
					StopTimeImpl.class, stopTime.getPrimaryKeyObj());
			}

			if (stopTime != null) {
				session.delete(stopTime);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stopTime != null) {
			clearCache(stopTime);
		}

		return stopTime;
	}

	@Override
	public StopTime updateImpl(StopTime stopTime) {
		boolean isNew = stopTime.isNew();

		if (!(stopTime instanceof StopTimeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stopTime.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stopTime);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stopTime proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StopTime implementation " +
					stopTime.getClass());
		}

		StopTimeModelImpl stopTimeModelImpl = (StopTimeModelImpl)stopTime;

		if (Validator.isNull(stopTime.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			stopTime.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (stopTime.isNew()) {
				session.save(stopTime);

				stopTime.setNew(false);
			}
			else {
				stopTime = (StopTime)session.merge(stopTime);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StopTimeModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {stopTimeModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {stopTimeModelImpl.getTrip_id()};

			finderCache.removeResult(_finderPathCountByTripId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTripId, args);

			args = new Object[] {stopTimeModelImpl.getStop_id()};

			finderCache.removeResult(_finderPathCountByStopId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStopId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stopTimeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					stopTimeModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {stopTimeModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((stopTimeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTripId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					stopTimeModelImpl.getOriginalTrip_id()
				};

				finderCache.removeResult(_finderPathCountByTripId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTripId, args);

				args = new Object[] {stopTimeModelImpl.getTrip_id()};

				finderCache.removeResult(_finderPathCountByTripId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTripId, args);
			}

			if ((stopTimeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStopId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					stopTimeModelImpl.getOriginalStop_id()
				};

				finderCache.removeResult(_finderPathCountByStopId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStopId, args);

				args = new Object[] {stopTimeModelImpl.getStop_id()};

				finderCache.removeResult(_finderPathCountByStopId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStopId, args);
			}
		}

		entityCache.putResult(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
			stopTime.getPrimaryKey(), stopTime, false);

		stopTime.resetOriginalValues();

		return stopTime;
	}

	/**
	 * Returns the stop time with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop time
	 * @return the stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStopTimeException {

		StopTime stopTime = fetchByPrimaryKey(primaryKey);

		if (stopTime == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStopTimeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stopTime;
	}

	/**
	 * Returns the stop time with the primary key or throws a <code>NoSuchStopTimeException</code> if it could not be found.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time
	 * @throws NoSuchStopTimeException if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime findByPrimaryKey(long id) throws NoSuchStopTimeException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the stop time with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop time
	 * @return the stop time, or <code>null</code> if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StopTime stopTime = (StopTime)serializable;

		if (stopTime == null) {
			Session session = null;

			try {
				session = openSession();

				stopTime = (StopTime)session.get(
					StopTimeImpl.class, primaryKey);

				if (stopTime != null) {
					cacheResult(stopTime);
				}
				else {
					entityCache.putResult(
						StopTimeModelImpl.ENTITY_CACHE_ENABLED,
						StopTimeImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
					primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return stopTime;
	}

	/**
	 * Returns the stop time with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the stop time
	 * @return the stop time, or <code>null</code> if a stop time with the primary key could not be found
	 */
	@Override
	public StopTime fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, StopTime> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StopTime> map = new HashMap<Serializable, StopTime>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StopTime stopTime = fetchByPrimaryKey(primaryKey);

			if (stopTime != null) {
				map.put(primaryKey, stopTime);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StopTime)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_STOPTIME_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			sb.append((long)primaryKey);

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			for (StopTime stopTime : (List<StopTime>)query.list()) {
				map.put(stopTime.getPrimaryKeyObj(), stopTime);

				cacheResult(stopTime);

				uncachedPrimaryKeys.remove(stopTime.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					StopTimeModelImpl.ENTITY_CACHE_ENABLED, StopTimeImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the stop times.
	 *
	 * @return the stop times
	 */
	@Override
	public List<StopTime> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<StopTime> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<StopTime> findAll(
		int start, int end, OrderByComparator<StopTime> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<StopTime> findAll(
		int start, int end, OrderByComparator<StopTime> orderByComparator,
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

		List<StopTime> list = null;

		if (useFinderCache) {
			list = (List<StopTime>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STOPTIME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STOPTIME;

				sql = sql.concat(StopTimeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<StopTime>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the stop times from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StopTime stopTime : findAll()) {
			remove(stopTime);
		}
	}

	/**
	 * Returns the number of stop times.
	 *
	 * @return the number of stop times
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STOPTIME);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return StopTimeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stop time persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			StopTimeModelImpl.UUID_COLUMN_BITMASK |
			StopTimeModelImpl.TRIP_ID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTripId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTripId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTripId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTripId",
			new String[] {String.class.getName()},
			StopTimeModelImpl.TRIP_ID_COLUMN_BITMASK);

		_finderPathCountByTripId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTripId",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByStopId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStopId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStopId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, StopTimeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStopId",
			new String[] {String.class.getName()},
			StopTimeModelImpl.STOP_ID_COLUMN_BITMASK |
			StopTimeModelImpl.TRIP_ID_COLUMN_BITMASK);

		_finderPathCountByStopId = new FinderPath(
			StopTimeModelImpl.ENTITY_CACHE_ENABLED,
			StopTimeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStopId",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StopTimeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STOPTIME =
		"SELECT stopTime FROM StopTime stopTime";

	private static final String _SQL_SELECT_STOPTIME_WHERE_PKS_IN =
		"SELECT stopTime FROM StopTime stopTime WHERE id_ IN (";

	private static final String _SQL_SELECT_STOPTIME_WHERE =
		"SELECT stopTime FROM StopTime stopTime WHERE ";

	private static final String _SQL_COUNT_STOPTIME =
		"SELECT COUNT(stopTime) FROM StopTime stopTime";

	private static final String _SQL_COUNT_STOPTIME_WHERE =
		"SELECT COUNT(stopTime) FROM StopTime stopTime WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stopTime.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No StopTime exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No StopTime exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StopTimePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

}