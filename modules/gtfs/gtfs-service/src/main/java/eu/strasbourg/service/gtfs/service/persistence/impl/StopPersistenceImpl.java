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

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.exception.NoSuchStopException;
import eu.strasbourg.service.gtfs.model.Stop;
import eu.strasbourg.service.gtfs.model.impl.StopImpl;
import eu.strasbourg.service.gtfs.model.impl.StopModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.StopPersistence;

import java.io.Serializable;

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
 * The persistence implementation for the stop service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public class StopPersistenceImpl
	extends BasePersistenceImpl<Stop> implements StopPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StopUtil</code> to access the stop persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StopImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByStopId;
	private FinderPath _finderPathCountByStopId;

	/**
	 * Returns the stop where stop_id = &#63; or throws a <code>NoSuchStopException</code> if it could not be found.
	 *
	 * @param stop_id the stop_id
	 * @return the matching stop
	 * @throws NoSuchStopException if a matching stop could not be found
	 */
	@Override
	public Stop findByStopId(String stop_id) throws NoSuchStopException {
		Stop stop = fetchByStopId(stop_id);

		if (stop == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("stop_id=");
			msg.append(stop_id);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStopException(msg.toString());
		}

		return stop;
	}

	/**
	 * Returns the stop where stop_id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stop_id the stop_id
	 * @return the matching stop, or <code>null</code> if a matching stop could not be found
	 */
	@Override
	public Stop fetchByStopId(String stop_id) {
		return fetchByStopId(stop_id, true);
	}

	/**
	 * Returns the stop where stop_id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stop_id the stop_id
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching stop, or <code>null</code> if a matching stop could not be found
	 */
	@Override
	public Stop fetchByStopId(String stop_id, boolean retrieveFromCache) {
		stop_id = Objects.toString(stop_id, "");

		Object[] finderArgs = new Object[] {stop_id};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByStopId, finderArgs, this);
		}

		if (result instanceof Stop) {
			Stop stop = (Stop)result;

			if (!Objects.equals(stop_id, stop.getStop_id())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_STOP_WHERE);

			boolean bindStop_id = false;

			if (stop_id.isEmpty()) {
				query.append(_FINDER_COLUMN_STOPID_STOP_ID_3);
			}
			else {
				bindStop_id = true;

				query.append(_FINDER_COLUMN_STOPID_STOP_ID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStop_id) {
					qPos.add(stop_id);
				}

				List<Stop> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByStopId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"StopPersistenceImpl.fetchByStopId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Stop stop = list.get(0);

					result = stop;

					cacheResult(stop);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByStopId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Stop)result;
		}
	}

	/**
	 * Removes the stop where stop_id = &#63; from the database.
	 *
	 * @param stop_id the stop_id
	 * @return the stop that was removed
	 */
	@Override
	public Stop removeByStopId(String stop_id) throws NoSuchStopException {
		Stop stop = findByStopId(stop_id);

		return remove(stop);
	}

	/**
	 * Returns the number of stops where stop_id = &#63;.
	 *
	 * @param stop_id the stop_id
	 * @return the number of matching stops
	 */
	@Override
	public int countByStopId(String stop_id) {
		stop_id = Objects.toString(stop_id, "");

		FinderPath finderPath = _finderPathCountByStopId;

		Object[] finderArgs = new Object[] {stop_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOP_WHERE);

			boolean bindStop_id = false;

			if (stop_id.isEmpty()) {
				query.append(_FINDER_COLUMN_STOPID_STOP_ID_3);
			}
			else {
				bindStop_id = true;

				query.append(_FINDER_COLUMN_STOPID_STOP_ID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStop_id) {
					qPos.add(stop_id);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STOPID_STOP_ID_2 =
		"stop.stop_id = ?";

	private static final String _FINDER_COLUMN_STOPID_STOP_ID_3 =
		"(stop.stop_id IS NULL OR stop.stop_id = '')";

	private FinderPath _finderPathWithPaginationFindByStopCode;
	private FinderPath _finderPathWithoutPaginationFindByStopCode;
	private FinderPath _finderPathCountByStopCode;

	/**
	 * Returns all the stops where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @return the matching stops
	 */
	@Override
	public List<Stop> findByStopCode(String stop_code) {
		return findByStopCode(
			stop_code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stops where stop_code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stop_code the stop_code
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @return the range of matching stops
	 */
	@Override
	public List<Stop> findByStopCode(String stop_code, int start, int end) {
		return findByStopCode(stop_code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the stops where stop_code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stop_code the stop_code
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stops
	 */
	@Override
	public List<Stop> findByStopCode(
		String stop_code, int start, int end,
		OrderByComparator<Stop> orderByComparator) {

		return findByStopCode(stop_code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stops where stop_code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param stop_code the stop_code
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching stops
	 */
	@Override
	public List<Stop> findByStopCode(
		String stop_code, int start, int end,
		OrderByComparator<Stop> orderByComparator, boolean retrieveFromCache) {

		stop_code = Objects.toString(stop_code, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByStopCode;
			finderArgs = new Object[] {stop_code};
		}
		else {
			finderPath = _finderPathWithPaginationFindByStopCode;
			finderArgs = new Object[] {
				stop_code, start, end, orderByComparator
			};
		}

		List<Stop> list = null;

		if (retrieveFromCache) {
			list = (List<Stop>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stop stop : list) {
					if (!stop_code.equals(stop.getStop_code())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STOP_WHERE);

			boolean bindStop_code = false;

			if (stop_code.isEmpty()) {
				query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_3);
			}
			else {
				bindStop_code = true;

				query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(StopModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStop_code) {
					qPos.add(stop_code);
				}

				if (!pagination) {
					list = (List<Stop>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Stop>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stop in the ordered set where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop
	 * @throws NoSuchStopException if a matching stop could not be found
	 */
	@Override
	public Stop findByStopCode_First(
			String stop_code, OrderByComparator<Stop> orderByComparator)
		throws NoSuchStopException {

		Stop stop = fetchByStopCode_First(stop_code, orderByComparator);

		if (stop != null) {
			return stop;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stop_code=");
		msg.append(stop_code);

		msg.append("}");

		throw new NoSuchStopException(msg.toString());
	}

	/**
	 * Returns the first stop in the ordered set where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stop, or <code>null</code> if a matching stop could not be found
	 */
	@Override
	public Stop fetchByStopCode_First(
		String stop_code, OrderByComparator<Stop> orderByComparator) {

		List<Stop> list = findByStopCode(stop_code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stop in the ordered set where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop
	 * @throws NoSuchStopException if a matching stop could not be found
	 */
	@Override
	public Stop findByStopCode_Last(
			String stop_code, OrderByComparator<Stop> orderByComparator)
		throws NoSuchStopException {

		Stop stop = fetchByStopCode_Last(stop_code, orderByComparator);

		if (stop != null) {
			return stop;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("stop_code=");
		msg.append(stop_code);

		msg.append("}");

		throw new NoSuchStopException(msg.toString());
	}

	/**
	 * Returns the last stop in the ordered set where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stop, or <code>null</code> if a matching stop could not be found
	 */
	@Override
	public Stop fetchByStopCode_Last(
		String stop_code, OrderByComparator<Stop> orderByComparator) {

		int count = countByStopCode(stop_code);

		if (count == 0) {
			return null;
		}

		List<Stop> list = findByStopCode(
			stop_code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the stops before and after the current stop in the ordered set where stop_code = &#63;.
	 *
	 * @param stop_id the primary key of the current stop
	 * @param stop_code the stop_code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stop
	 * @throws NoSuchStopException if a stop with the primary key could not be found
	 */
	@Override
	public Stop[] findByStopCode_PrevAndNext(
			String stop_id, String stop_code,
			OrderByComparator<Stop> orderByComparator)
		throws NoSuchStopException {

		stop_code = Objects.toString(stop_code, "");

		Stop stop = findByPrimaryKey(stop_id);

		Session session = null;

		try {
			session = openSession();

			Stop[] array = new StopImpl[3];

			array[0] = getByStopCode_PrevAndNext(
				session, stop, stop_code, orderByComparator, true);

			array[1] = stop;

			array[2] = getByStopCode_PrevAndNext(
				session, stop, stop_code, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stop getByStopCode_PrevAndNext(
		Session session, Stop stop, String stop_code,
		OrderByComparator<Stop> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOP_WHERE);

		boolean bindStop_code = false;

		if (stop_code.isEmpty()) {
			query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_3);
		}
		else {
			bindStop_code = true;

			query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StopModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStop_code) {
			qPos.add(stop_code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stop)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Stop> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stops where stop_code = &#63; from the database.
	 *
	 * @param stop_code the stop_code
	 */
	@Override
	public void removeByStopCode(String stop_code) {
		for (Stop stop :
				findByStopCode(
					stop_code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stop);
		}
	}

	/**
	 * Returns the number of stops where stop_code = &#63;.
	 *
	 * @param stop_code the stop_code
	 * @return the number of matching stops
	 */
	@Override
	public int countByStopCode(String stop_code) {
		stop_code = Objects.toString(stop_code, "");

		FinderPath finderPath = _finderPathCountByStopCode;

		Object[] finderArgs = new Object[] {stop_code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOP_WHERE);

			boolean bindStop_code = false;

			if (stop_code.isEmpty()) {
				query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_3);
			}
			else {
				bindStop_code = true;

				query.append(_FINDER_COLUMN_STOPCODE_STOP_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStop_code) {
					qPos.add(stop_code);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STOPCODE_STOP_CODE_2 =
		"stop.stop_code = ?";

	private static final String _FINDER_COLUMN_STOPCODE_STOP_CODE_3 =
		"(stop.stop_code IS NULL OR stop.stop_code = '')";

	public StopPersistenceImpl() {
		setModelClass(Stop.class);
	}

	/**
	 * Caches the stop in the entity cache if it is enabled.
	 *
	 * @param stop the stop
	 */
	@Override
	public void cacheResult(Stop stop) {
		entityCache.putResult(
			StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
			stop.getPrimaryKey(), stop);

		finderCache.putResult(
			_finderPathFetchByStopId, new Object[] {stop.getStop_id()}, stop);

		stop.resetOriginalValues();
	}

	/**
	 * Caches the stops in the entity cache if it is enabled.
	 *
	 * @param stops the stops
	 */
	@Override
	public void cacheResult(List<Stop> stops) {
		for (Stop stop : stops) {
			if (entityCache.getResult(
					StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
					stop.getPrimaryKey()) == null) {

				cacheResult(stop);
			}
			else {
				stop.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stops.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StopImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stop.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Stop stop) {
		entityCache.removeResult(
			StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
			stop.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StopModelImpl)stop, true);
	}

	@Override
	public void clearCache(List<Stop> stops) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Stop stop : stops) {
			entityCache.removeResult(
				StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
				stop.getPrimaryKey());

			clearUniqueFindersCache((StopModelImpl)stop, true);
		}
	}

	protected void cacheUniqueFindersCache(StopModelImpl stopModelImpl) {
		Object[] args = new Object[] {stopModelImpl.getStop_id()};

		finderCache.putResult(
			_finderPathCountByStopId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByStopId, args, stopModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StopModelImpl stopModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {stopModelImpl.getStop_id()};

			finderCache.removeResult(_finderPathCountByStopId, args);
			finderCache.removeResult(_finderPathFetchByStopId, args);
		}

		if ((stopModelImpl.getColumnBitmask() &
			 _finderPathFetchByStopId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {stopModelImpl.getOriginalStop_id()};

			finderCache.removeResult(_finderPathCountByStopId, args);
			finderCache.removeResult(_finderPathFetchByStopId, args);
		}
	}

	/**
	 * Creates a new stop with the primary key. Does not add the stop to the database.
	 *
	 * @param stop_id the primary key for the new stop
	 * @return the new stop
	 */
	@Override
	public Stop create(String stop_id) {
		Stop stop = new StopImpl();

		stop.setNew(true);
		stop.setPrimaryKey(stop_id);

		return stop;
	}

	/**
	 * Removes the stop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stop_id the primary key of the stop
	 * @return the stop that was removed
	 * @throws NoSuchStopException if a stop with the primary key could not be found
	 */
	@Override
	public Stop remove(String stop_id) throws NoSuchStopException {
		return remove((Serializable)stop_id);
	}

	/**
	 * Removes the stop with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stop
	 * @return the stop that was removed
	 * @throws NoSuchStopException if a stop with the primary key could not be found
	 */
	@Override
	public Stop remove(Serializable primaryKey) throws NoSuchStopException {
		Session session = null;

		try {
			session = openSession();

			Stop stop = (Stop)session.get(StopImpl.class, primaryKey);

			if (stop == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStopException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stop);
		}
		catch (NoSuchStopException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Stop removeImpl(Stop stop) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stop)) {
				stop = (Stop)session.get(
					StopImpl.class, stop.getPrimaryKeyObj());
			}

			if (stop != null) {
				session.delete(stop);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (stop != null) {
			clearCache(stop);
		}

		return stop;
	}

	@Override
	public Stop updateImpl(Stop stop) {
		boolean isNew = stop.isNew();

		if (!(stop instanceof StopModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stop.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stop);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stop proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Stop implementation " +
					stop.getClass());
		}

		StopModelImpl stopModelImpl = (StopModelImpl)stop;

		Session session = null;

		try {
			session = openSession();

			if (stop.isNew()) {
				session.save(stop);

				stop.setNew(false);
			}
			else {
				stop = (Stop)session.merge(stop);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StopModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {stopModelImpl.getStop_code()};

			finderCache.removeResult(_finderPathCountByStopCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStopCode, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stopModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStopCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					stopModelImpl.getOriginalStop_code()
				};

				finderCache.removeResult(_finderPathCountByStopCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStopCode, args);

				args = new Object[] {stopModelImpl.getStop_code()};

				finderCache.removeResult(_finderPathCountByStopCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStopCode, args);
			}
		}

		entityCache.putResult(
			StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
			stop.getPrimaryKey(), stop, false);

		clearUniqueFindersCache(stopModelImpl, false);
		cacheUniqueFindersCache(stopModelImpl);

		stop.resetOriginalValues();

		return stop;
	}

	/**
	 * Returns the stop with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop
	 * @return the stop
	 * @throws NoSuchStopException if a stop with the primary key could not be found
	 */
	@Override
	public Stop findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStopException {

		Stop stop = fetchByPrimaryKey(primaryKey);

		if (stop == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStopException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stop;
	}

	/**
	 * Returns the stop with the primary key or throws a <code>NoSuchStopException</code> if it could not be found.
	 *
	 * @param stop_id the primary key of the stop
	 * @return the stop
	 * @throws NoSuchStopException if a stop with the primary key could not be found
	 */
	@Override
	public Stop findByPrimaryKey(String stop_id) throws NoSuchStopException {
		return findByPrimaryKey((Serializable)stop_id);
	}

	/**
	 * Returns the stop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stop
	 * @return the stop, or <code>null</code> if a stop with the primary key could not be found
	 */
	@Override
	public Stop fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Stop stop = (Stop)serializable;

		if (stop == null) {
			Session session = null;

			try {
				session = openSession();

				stop = (Stop)session.get(StopImpl.class, primaryKey);

				if (stop != null) {
					cacheResult(stop);
				}
				else {
					entityCache.putResult(
						StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return stop;
	}

	/**
	 * Returns the stop with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stop_id the primary key of the stop
	 * @return the stop, or <code>null</code> if a stop with the primary key could not be found
	 */
	@Override
	public Stop fetchByPrimaryKey(String stop_id) {
		return fetchByPrimaryKey((Serializable)stop_id);
	}

	@Override
	public Map<Serializable, Stop> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Stop> map = new HashMap<Serializable, Stop>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Stop stop = fetchByPrimaryKey(primaryKey);

			if (stop != null) {
				map.put(primaryKey, stop);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Stop)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_STOP_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			query.append("?");

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			QueryPos qPos = QueryPos.getInstance(q);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				qPos.add((String)primaryKey);
			}

			for (Stop stop : (List<Stop>)q.list()) {
				map.put(stop.getPrimaryKeyObj(), stop);

				cacheResult(stop);

				uncachedPrimaryKeys.remove(stop.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					StopModelImpl.ENTITY_CACHE_ENABLED, StopImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the stops.
	 *
	 * @return the stops
	 */
	@Override
	public List<Stop> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the stops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @return the range of stops
	 */
	@Override
	public List<Stop> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the stops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stops
	 */
	@Override
	public List<Stop> findAll(
		int start, int end, OrderByComparator<Stop> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the stops.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>StopModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of stops
	 * @param end the upper bound of the range of stops (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of stops
	 */
	@Override
	public List<Stop> findAll(
		int start, int end, OrderByComparator<Stop> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Stop> list = null;

		if (retrieveFromCache) {
			list = (List<Stop>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STOP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STOP;

				if (pagination) {
					sql = sql.concat(StopModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Stop>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Stop>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the stops from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Stop stop : findAll()) {
			remove(stop);
		}
	}

	/**
	 * Returns the number of stops.
	 *
	 * @return the number of stops
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STOP);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StopModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stop persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, StopImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, StopImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByStopId = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, StopImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByStopId",
			new String[] {String.class.getName()},
			StopModelImpl.STOP_ID_COLUMN_BITMASK);

		_finderPathCountByStopId = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStopId",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByStopCode = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, StopImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStopCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStopCode = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, StopImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStopCode",
			new String[] {String.class.getName()},
			StopModelImpl.STOP_CODE_COLUMN_BITMASK);

		_finderPathCountByStopCode = new FinderPath(
			StopModelImpl.ENTITY_CACHE_ENABLED,
			StopModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStopCode",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(StopImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STOP = "SELECT stop FROM Stop stop";

	private static final String _SQL_SELECT_STOP_WHERE_PKS_IN =
		"SELECT stop FROM Stop stop WHERE stop_id IN (";

	private static final String _SQL_SELECT_STOP_WHERE =
		"SELECT stop FROM Stop stop WHERE ";

	private static final String _SQL_COUNT_STOP =
		"SELECT COUNT(stop) FROM Stop stop";

	private static final String _SQL_COUNT_STOP_WHERE =
		"SELECT COUNT(stop) FROM Stop stop WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stop.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Stop exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Stop exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StopPersistenceImpl.class);

}