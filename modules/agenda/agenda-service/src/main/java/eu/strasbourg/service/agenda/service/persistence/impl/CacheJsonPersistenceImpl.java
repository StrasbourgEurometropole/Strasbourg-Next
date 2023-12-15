/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.agenda.exception.NoSuchCacheJsonException;
import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.model.CacheJsonTable;
import eu.strasbourg.service.agenda.model.impl.CacheJsonImpl;
import eu.strasbourg.service.agenda.model.impl.CacheJsonModelImpl;
import eu.strasbourg.service.agenda.service.persistence.CacheJsonPersistence;
import eu.strasbourg.service.agenda.service.persistence.CacheJsonUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the cache json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class CacheJsonPersistenceImpl
	extends BasePersistenceImpl<CacheJson> implements CacheJsonPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CacheJsonUtil</code> to access the cache json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CacheJsonImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByeventId;
	private FinderPath _finderPathCountByeventId;

	/**
	 * Returns the cache json where eventId = &#63; or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @return the matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	@Override
	public CacheJson findByeventId(long eventId)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = fetchByeventId(eventId);

		if (cacheJson == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("eventId=");
			sb.append(eventId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCacheJsonException(sb.toString());
		}

		return cacheJson;
	}

	/**
	 * Returns the cache json where eventId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByeventId(long eventId) {
		return fetchByeventId(eventId, true);
	}

	/**
	 * Returns the cache json where eventId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByeventId(long eventId, boolean useFinderCache) {
		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {eventId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByeventId, finderArgs, this);
		}

		if (result instanceof CacheJson) {
			CacheJson cacheJson = (CacheJson)result;

			if (eventId != cacheJson.getEventId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				List<CacheJson> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByeventId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {eventId};
							}

							_log.warn(
								"CacheJsonPersistenceImpl.fetchByeventId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CacheJson cacheJson = list.get(0);

					result = cacheJson;

					cacheResult(cacheJson);
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
			return (CacheJson)result;
		}
	}

	/**
	 * Removes the cache json where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @return the cache json that was removed
	 */
	@Override
	public CacheJson removeByeventId(long eventId)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = findByeventId(eventId);

		return remove(cacheJson);
	}

	/**
	 * Returns the number of cache jsons where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching cache jsons
	 */
	@Override
	public int countByeventId(long eventId) {
		FinderPath finderPath = _finderPathCountByeventId;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 =
		"cacheJson.eventId = ?";

	private FinderPath _finderPathFetchByeventIdAndIsApproved;
	private FinderPath _finderPathCountByeventIdAndIsApproved;

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	@Override
	public CacheJson findByeventIdAndIsApproved(
			long eventId, boolean isApproved)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = fetchByeventIdAndIsApproved(eventId, isApproved);

		if (cacheJson == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("eventId=");
			sb.append(eventId);

			sb.append(", isApproved=");
			sb.append(isApproved);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCacheJsonException(sb.toString());
		}

		return cacheJson;
	}

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByeventIdAndIsApproved(
		long eventId, boolean isApproved) {

		return fetchByeventIdAndIsApproved(eventId, isApproved, true);
	}

	/**
	 * Returns the cache json where eventId = &#63; and isApproved = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByeventIdAndIsApproved(
		long eventId, boolean isApproved, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {eventId, isApproved};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByeventIdAndIsApproved, finderArgs, this);
		}

		if (result instanceof CacheJson) {
			CacheJson cacheJson = (CacheJson)result;

			if ((eventId != cacheJson.getEventId()) ||
				(isApproved != cacheJson.isIsApproved())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_EVENTIDANDISAPPROVED_EVENTID_2);

			sb.append(_FINDER_COLUMN_EVENTIDANDISAPPROVED_ISAPPROVED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				queryPos.add(isApproved);

				List<CacheJson> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByeventIdAndIsApproved, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {eventId, isApproved};
							}

							_log.warn(
								"CacheJsonPersistenceImpl.fetchByeventIdAndIsApproved(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CacheJson cacheJson = list.get(0);

					result = cacheJson;

					cacheResult(cacheJson);
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
			return (CacheJson)result;
		}
	}

	/**
	 * Removes the cache json where eventId = &#63; and isApproved = &#63; from the database.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the cache json that was removed
	 */
	@Override
	public CacheJson removeByeventIdAndIsApproved(
			long eventId, boolean isApproved)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = findByeventIdAndIsApproved(eventId, isApproved);

		return remove(cacheJson);
	}

	/**
	 * Returns the number of cache jsons where eventId = &#63; and isApproved = &#63;.
	 *
	 * @param eventId the event ID
	 * @param isApproved the is approved
	 * @return the number of matching cache jsons
	 */
	@Override
	public int countByeventIdAndIsApproved(long eventId, boolean isApproved) {
		FinderPath finderPath = _finderPathCountByeventIdAndIsApproved;

		Object[] finderArgs = new Object[] {eventId, isApproved};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_EVENTIDANDISAPPROVED_EVENTID_2);

			sb.append(_FINDER_COLUMN_EVENTIDANDISAPPROVED_ISAPPROVED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				queryPos.add(isApproved);

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

	private static final String _FINDER_COLUMN_EVENTIDANDISAPPROVED_EVENTID_2 =
		"cacheJson.eventId = ? AND ";

	private static final String
		_FINDER_COLUMN_EVENTIDANDISAPPROVED_ISAPPROVED_2 =
			"cacheJson.isApproved = ?";

	private FinderPath _finderPathWithPaginationFindByisApproved;
	private FinderPath _finderPathWithoutPaginationFindByisApproved;
	private FinderPath _finderPathCountByisApproved;

	/**
	 * Returns all the cache jsons where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @return the matching cache jsons
	 */
	@Override
	public List<CacheJson> findByisApproved(boolean isApproved) {
		return findByisApproved(
			isApproved, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	@Override
	public List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end) {

		return findByisApproved(isApproved, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	@Override
	public List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return findByisApproved(
			isApproved, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache jsons where isApproved = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param isApproved the is approved
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	@Override
	public List<CacheJson> findByisApproved(
		boolean isApproved, int start, int end,
		OrderByComparator<CacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByisApproved;
				finderArgs = new Object[] {isApproved};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByisApproved;
			finderArgs = new Object[] {
				isApproved, start, end, orderByComparator
			};
		}

		List<CacheJson> list = null;

		if (useFinderCache) {
			list = (List<CacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CacheJson cacheJson : list) {
					if (isApproved != cacheJson.isIsApproved()) {
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

			sb.append(_SQL_SELECT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_ISAPPROVED_ISAPPROVED_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isApproved);

				list = (List<CacheJson>)QueryUtil.list(
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
	 * Returns the first cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	@Override
	public CacheJson findByisApproved_First(
			boolean isApproved, OrderByComparator<CacheJson> orderByComparator)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = fetchByisApproved_First(
			isApproved, orderByComparator);

		if (cacheJson != null) {
			return cacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isApproved=");
		sb.append(isApproved);

		sb.append("}");

		throw new NoSuchCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByisApproved_First(
		boolean isApproved, OrderByComparator<CacheJson> orderByComparator) {

		List<CacheJson> list = findByisApproved(
			isApproved, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	@Override
	public CacheJson findByisApproved_Last(
			boolean isApproved, OrderByComparator<CacheJson> orderByComparator)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = fetchByisApproved_Last(
			isApproved, orderByComparator);

		if (cacheJson != null) {
			return cacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isApproved=");
		sb.append(isApproved);

		sb.append("}");

		throw new NoSuchCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	@Override
	public CacheJson fetchByisApproved_Last(
		boolean isApproved, OrderByComparator<CacheJson> orderByComparator) {

		int count = countByisApproved(isApproved);

		if (count == 0) {
			return null;
		}

		List<CacheJson> list = findByisApproved(
			isApproved, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where isApproved = &#63;.
	 *
	 * @param eventId the primary key of the current cache json
	 * @param isApproved the is approved
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson[] findByisApproved_PrevAndNext(
			long eventId, boolean isApproved,
			OrderByComparator<CacheJson> orderByComparator)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CacheJson[] array = new CacheJsonImpl[3];

			array[0] = getByisApproved_PrevAndNext(
				session, cacheJson, isApproved, orderByComparator, true);

			array[1] = cacheJson;

			array[2] = getByisApproved_PrevAndNext(
				session, cacheJson, isApproved, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CacheJson getByisApproved_PrevAndNext(
		Session session, CacheJson cacheJson, boolean isApproved,
		OrderByComparator<CacheJson> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CACHEJSON_WHERE);

		sb.append(_FINDER_COLUMN_ISAPPROVED_ISAPPROVED_2);

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
			sb.append(CacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isApproved);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(cacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cache jsons where isApproved = &#63; from the database.
	 *
	 * @param isApproved the is approved
	 */
	@Override
	public void removeByisApproved(boolean isApproved) {
		for (CacheJson cacheJson :
				findByisApproved(
					isApproved, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cacheJson);
		}
	}

	/**
	 * Returns the number of cache jsons where isApproved = &#63;.
	 *
	 * @param isApproved the is approved
	 * @return the number of matching cache jsons
	 */
	@Override
	public int countByisApproved(boolean isApproved) {
		FinderPath finderPath = _finderPathCountByisApproved;

		Object[] finderArgs = new Object[] {isApproved};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_ISAPPROVED_ISAPPROVED_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isApproved);

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

	private static final String _FINDER_COLUMN_ISAPPROVED_ISAPPROVED_2 =
		"cacheJson.isApproved = ?";

	public CacheJsonPersistenceImpl() {
		setModelClass(CacheJson.class);

		setModelImplClass(CacheJsonImpl.class);
		setModelPKClass(long.class);

		setTable(CacheJsonTable.INSTANCE);
	}

	/**
	 * Caches the cache json in the entity cache if it is enabled.
	 *
	 * @param cacheJson the cache json
	 */
	@Override
	public void cacheResult(CacheJson cacheJson) {
		entityCache.putResult(
			CacheJsonImpl.class, cacheJson.getPrimaryKey(), cacheJson);

		finderCache.putResult(
			_finderPathFetchByeventId, new Object[] {cacheJson.getEventId()},
			cacheJson);

		finderCache.putResult(
			_finderPathFetchByeventIdAndIsApproved,
			new Object[] {cacheJson.getEventId(), cacheJson.isIsApproved()},
			cacheJson);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cache jsons in the entity cache if it is enabled.
	 *
	 * @param cacheJsons the cache jsons
	 */
	@Override
	public void cacheResult(List<CacheJson> cacheJsons) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cacheJsons.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CacheJson cacheJson : cacheJsons) {
			if (entityCache.getResult(
					CacheJsonImpl.class, cacheJson.getPrimaryKey()) == null) {

				cacheResult(cacheJson);
			}
		}
	}

	/**
	 * Clears the cache for all cache jsons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CacheJsonImpl.class);

		finderCache.clearCache(CacheJsonImpl.class);
	}

	/**
	 * Clears the cache for the cache json.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CacheJson cacheJson) {
		entityCache.removeResult(CacheJsonImpl.class, cacheJson);
	}

	@Override
	public void clearCache(List<CacheJson> cacheJsons) {
		for (CacheJson cacheJson : cacheJsons) {
			entityCache.removeResult(CacheJsonImpl.class, cacheJson);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CacheJsonImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CacheJsonImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CacheJsonModelImpl cacheJsonModelImpl) {

		Object[] args = new Object[] {cacheJsonModelImpl.getEventId()};

		finderCache.putResult(_finderPathCountByeventId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByeventId, args, cacheJsonModelImpl);

		args = new Object[] {
			cacheJsonModelImpl.getEventId(), cacheJsonModelImpl.isIsApproved()
		};

		finderCache.putResult(
			_finderPathCountByeventIdAndIsApproved, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByeventIdAndIsApproved, args, cacheJsonModelImpl);
	}

	/**
	 * Creates a new cache json with the primary key. Does not add the cache json to the database.
	 *
	 * @param eventId the primary key for the new cache json
	 * @return the new cache json
	 */
	@Override
	public CacheJson create(long eventId) {
		CacheJson cacheJson = new CacheJsonImpl();

		cacheJson.setNew(true);
		cacheJson.setPrimaryKey(eventId);

		return cacheJson;
	}

	/**
	 * Removes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson remove(long eventId) throws NoSuchCacheJsonException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson remove(Serializable primaryKey)
		throws NoSuchCacheJsonException {

		Session session = null;

		try {
			session = openSession();

			CacheJson cacheJson = (CacheJson)session.get(
				CacheJsonImpl.class, primaryKey);

			if (cacheJson == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCacheJsonException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cacheJson);
		}
		catch (NoSuchCacheJsonException noSuchEntityException) {
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
	protected CacheJson removeImpl(CacheJson cacheJson) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cacheJson)) {
				cacheJson = (CacheJson)session.get(
					CacheJsonImpl.class, cacheJson.getPrimaryKeyObj());
			}

			if (cacheJson != null) {
				session.delete(cacheJson);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cacheJson != null) {
			clearCache(cacheJson);
		}

		return cacheJson;
	}

	@Override
	public CacheJson updateImpl(CacheJson cacheJson) {
		boolean isNew = cacheJson.isNew();

		if (!(cacheJson instanceof CacheJsonModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cacheJson.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cacheJson);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cacheJson proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CacheJson implementation " +
					cacheJson.getClass());
		}

		CacheJsonModelImpl cacheJsonModelImpl = (CacheJsonModelImpl)cacheJson;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cacheJson);
			}
			else {
				cacheJson = (CacheJson)session.merge(cacheJson);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CacheJsonImpl.class, cacheJsonModelImpl, false, true);

		cacheUniqueFindersCache(cacheJsonModelImpl);

		if (isNew) {
			cacheJson.setNew(false);
		}

		cacheJson.resetOriginalValues();

		return cacheJson;
	}

	/**
	 * Returns the cache json with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cache json
	 * @return the cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCacheJsonException {

		CacheJson cacheJson = fetchByPrimaryKey(primaryKey);

		if (cacheJson == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCacheJsonException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cacheJson;
	}

	/**
	 * Returns the cache json with the primary key or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson findByPrimaryKey(long eventId)
		throws NoSuchCacheJsonException {

		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the cache json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json, or <code>null</code> if a cache json with the primary key could not be found
	 */
	@Override
	public CacheJson fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the cache jsons.
	 *
	 * @return the cache jsons
	 */
	@Override
	public List<CacheJson> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of cache jsons
	 */
	@Override
	public List<CacheJson> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cache jsons
	 */
	@Override
	public List<CacheJson> findAll(
		int start, int end, OrderByComparator<CacheJson> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cache jsons
	 */
	@Override
	public List<CacheJson> findAll(
		int start, int end, OrderByComparator<CacheJson> orderByComparator,
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

		List<CacheJson> list = null;

		if (useFinderCache) {
			list = (List<CacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CACHEJSON);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CACHEJSON;

				sql = sql.concat(CacheJsonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CacheJson>)QueryUtil.list(
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
	 * Removes all the cache jsons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CacheJson cacheJson : findAll()) {
			remove(cacheJson);
		}
	}

	/**
	 * Returns the number of cache jsons.
	 *
	 * @return the number of cache jsons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CACHEJSON);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "eventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CACHEJSON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CacheJsonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cache json persistence.
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

		_finderPathFetchByeventId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByeventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			true);

		_finderPathCountByeventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			false);

		_finderPathFetchByeventIdAndIsApproved = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByeventIdAndIsApproved",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"eventId", "isApproved"}, true);

		_finderPathCountByeventIdAndIsApproved = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByeventIdAndIsApproved",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"eventId", "isApproved"}, false);

		_finderPathWithPaginationFindByisApproved = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisApproved",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isApproved"}, true);

		_finderPathWithoutPaginationFindByisApproved = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisApproved",
			new String[] {Boolean.class.getName()}, new String[] {"isApproved"},
			true);

		_finderPathCountByisApproved = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisApproved",
			new String[] {Boolean.class.getName()}, new String[] {"isApproved"},
			false);

		CacheJsonUtil.setPersistence(this);
	}

	public void destroy() {
		CacheJsonUtil.setPersistence(null);

		entityCache.removeCache(CacheJsonImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CACHEJSON =
		"SELECT cacheJson FROM CacheJson cacheJson";

	private static final String _SQL_SELECT_CACHEJSON_WHERE =
		"SELECT cacheJson FROM CacheJson cacheJson WHERE ";

	private static final String _SQL_COUNT_CACHEJSON =
		"SELECT COUNT(cacheJson) FROM CacheJson cacheJson";

	private static final String _SQL_COUNT_CACHEJSON_WHERE =
		"SELECT COUNT(cacheJson) FROM CacheJson cacheJson WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cacheJson.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CacheJson exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CacheJson exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CacheJsonPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}