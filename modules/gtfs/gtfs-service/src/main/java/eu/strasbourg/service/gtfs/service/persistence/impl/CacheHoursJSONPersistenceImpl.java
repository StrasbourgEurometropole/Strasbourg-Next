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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.exception.NoSuchCacheHoursJSONException;
import eu.strasbourg.service.gtfs.model.CacheHoursJSON;
import eu.strasbourg.service.gtfs.model.CacheHoursJSONTable;
import eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONImpl;
import eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPersistence;
import eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the cache hours json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class CacheHoursJSONPersistenceImpl
	extends BasePersistenceImpl<CacheHoursJSON>
	implements CacheHoursJSONPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CacheHoursJSONUtil</code> to access the cache hours json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CacheHoursJSONImpl.class.getName();

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
	 * Returns all the cache hours jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache hours jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator,
		boolean useFinderCache) {

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

		List<CacheHoursJSON> list = null;

		if (useFinderCache) {
			list = (List<CacheHoursJSON>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CacheHoursJSON cacheHoursJSON : list) {
					if (!uuid.equals(cacheHoursJSON.getUuid())) {
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

			sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

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
				sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
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

				list = (List<CacheHoursJSON>)QueryUtil.list(
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
	 * Returns the first cache hours json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByUuid_First(
			String uuid, OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByUuid_First(
			uuid, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the first cache hours json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByUuid_First(
		String uuid, OrderByComparator<CacheHoursJSON> orderByComparator) {

		List<CacheHoursJSON> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cache hours json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByUuid_Last(
			String uuid, OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByUuid_Last(
			uuid, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the last cache hours json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByUuid_Last(
		String uuid, OrderByComparator<CacheHoursJSON> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CacheHoursJSON> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cache hours jsons before and after the current cache hours json in the ordered set where uuid = &#63;.
	 *
	 * @param cacheHoursJSONPK the primary key of the current cache hours json
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache hours json
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON[] findByUuid_PrevAndNext(
			CacheHoursJSONPK cacheHoursJSONPK, String uuid,
			OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		uuid = Objects.toString(uuid, "");

		CacheHoursJSON cacheHoursJSON = findByPrimaryKey(cacheHoursJSONPK);

		Session session = null;

		try {
			session = openSession();

			CacheHoursJSON[] array = new CacheHoursJSONImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, cacheHoursJSON, uuid, orderByComparator, true);

			array[1] = cacheHoursJSON;

			array[2] = getByUuid_PrevAndNext(
				session, cacheHoursJSON, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CacheHoursJSON getByUuid_PrevAndNext(
		Session session, CacheHoursJSON cacheHoursJSON, String uuid,
		OrderByComparator<CacheHoursJSON> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

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
			sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						cacheHoursJSON)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CacheHoursJSON> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cache hours jsons where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CacheHoursJSON cacheHoursJSON :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cacheHoursJSON);
		}
	}

	/**
	 * Returns the number of cache hours jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cache hours jsons
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CACHEHOURSJSON_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"cacheHoursJSON.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(cacheHoursJSON.uuid IS NULL OR cacheHoursJSON.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByStopCode;
	private FinderPath _finderPathWithoutPaginationFindByStopCode;
	private FinderPath _finderPathCountByStopCode;

	/**
	 * Returns all the cache hours jsons where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @return the matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByStopCode(String stopCode) {
		return findByStopCode(
			stopCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache hours jsons where stopCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param stopCode the stop code
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByStopCode(
		String stopCode, int start, int end) {

		return findByStopCode(stopCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where stopCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param stopCode the stop code
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByStopCode(
		String stopCode, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator) {

		return findByStopCode(stopCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where stopCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param stopCode the stop code
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByStopCode(
		String stopCode, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator,
		boolean useFinderCache) {

		stopCode = Objects.toString(stopCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStopCode;
				finderArgs = new Object[] {stopCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStopCode;
			finderArgs = new Object[] {stopCode, start, end, orderByComparator};
		}

		List<CacheHoursJSON> list = null;

		if (useFinderCache) {
			list = (List<CacheHoursJSON>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CacheHoursJSON cacheHoursJSON : list) {
					if (!stopCode.equals(cacheHoursJSON.getStopCode())) {
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

			sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

			boolean bindStopCode = false;

			if (stopCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_3);
			}
			else {
				bindStopCode = true;

				sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStopCode) {
					queryPos.add(stopCode);
				}

				list = (List<CacheHoursJSON>)QueryUtil.list(
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
	 * Returns the first cache hours json in the ordered set where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByStopCode_First(
			String stopCode,
			OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByStopCode_First(
			stopCode, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stopCode=");
		sb.append(stopCode);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the first cache hours json in the ordered set where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByStopCode_First(
		String stopCode, OrderByComparator<CacheHoursJSON> orderByComparator) {

		List<CacheHoursJSON> list = findByStopCode(
			stopCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cache hours json in the ordered set where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByStopCode_Last(
			String stopCode,
			OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByStopCode_Last(
			stopCode, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("stopCode=");
		sb.append(stopCode);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the last cache hours json in the ordered set where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByStopCode_Last(
		String stopCode, OrderByComparator<CacheHoursJSON> orderByComparator) {

		int count = countByStopCode(stopCode);

		if (count == 0) {
			return null;
		}

		List<CacheHoursJSON> list = findByStopCode(
			stopCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cache hours jsons before and after the current cache hours json in the ordered set where stopCode = &#63;.
	 *
	 * @param cacheHoursJSONPK the primary key of the current cache hours json
	 * @param stopCode the stop code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache hours json
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON[] findByStopCode_PrevAndNext(
			CacheHoursJSONPK cacheHoursJSONPK, String stopCode,
			OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		stopCode = Objects.toString(stopCode, "");

		CacheHoursJSON cacheHoursJSON = findByPrimaryKey(cacheHoursJSONPK);

		Session session = null;

		try {
			session = openSession();

			CacheHoursJSON[] array = new CacheHoursJSONImpl[3];

			array[0] = getByStopCode_PrevAndNext(
				session, cacheHoursJSON, stopCode, orderByComparator, true);

			array[1] = cacheHoursJSON;

			array[2] = getByStopCode_PrevAndNext(
				session, cacheHoursJSON, stopCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CacheHoursJSON getByStopCode_PrevAndNext(
		Session session, CacheHoursJSON cacheHoursJSON, String stopCode,
		OrderByComparator<CacheHoursJSON> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

		boolean bindStopCode = false;

		if (stopCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_3);
		}
		else {
			bindStopCode = true;

			sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_2);
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
			sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStopCode) {
			queryPos.add(stopCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cacheHoursJSON)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CacheHoursJSON> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cache hours jsons where stopCode = &#63; from the database.
	 *
	 * @param stopCode the stop code
	 */
	@Override
	public void removeByStopCode(String stopCode) {
		for (CacheHoursJSON cacheHoursJSON :
				findByStopCode(
					stopCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cacheHoursJSON);
		}
	}

	/**
	 * Returns the number of cache hours jsons where stopCode = &#63;.
	 *
	 * @param stopCode the stop code
	 * @return the number of matching cache hours jsons
	 */
	@Override
	public int countByStopCode(String stopCode) {
		stopCode = Objects.toString(stopCode, "");

		FinderPath finderPath = _finderPathCountByStopCode;

		Object[] finderArgs = new Object[] {stopCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CACHEHOURSJSON_WHERE);

			boolean bindStopCode = false;

			if (stopCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_3);
			}
			else {
				bindStopCode = true;

				sb.append(_FINDER_COLUMN_STOPCODE_STOPCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStopCode) {
					queryPos.add(stopCode);
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

	private static final String _FINDER_COLUMN_STOPCODE_STOPCODE_2 =
		"cacheHoursJSON.id.stopCode = ?";

	private static final String _FINDER_COLUMN_STOPCODE_STOPCODE_3 =
		"(cacheHoursJSON.id.stopCode IS NULL OR cacheHoursJSON.id.stopCode = '')";

	private FinderPath _finderPathWithPaginationFindByType;
	private FinderPath _finderPathWithoutPaginationFindByType;
	private FinderPath _finderPathCountByType;

	/**
	 * Returns all the cache hours jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByType(int type) {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache hours jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByType(int type, int start, int end) {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByType(
		int type, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator) {

		return findByType(type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findByType(
		int type, int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByType;
				finderArgs = new Object[] {type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByType;
			finderArgs = new Object[] {type, start, end, orderByComparator};
		}

		List<CacheHoursJSON> list = null;

		if (useFinderCache) {
			list = (List<CacheHoursJSON>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CacheHoursJSON cacheHoursJSON : list) {
					if (type != cacheHoursJSON.getType()) {
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

			sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

				list = (List<CacheHoursJSON>)QueryUtil.list(
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
	 * Returns the first cache hours json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByType_First(
			int type, OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByType_First(
			type, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the first cache hours json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByType_First(
		int type, OrderByComparator<CacheHoursJSON> orderByComparator) {

		List<CacheHoursJSON> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cache hours json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByType_Last(
			int type, OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByType_Last(
			type, orderByComparator);

		if (cacheHoursJSON != null) {
			return cacheHoursJSON;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchCacheHoursJSONException(sb.toString());
	}

	/**
	 * Returns the last cache hours json in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByType_Last(
		int type, OrderByComparator<CacheHoursJSON> orderByComparator) {

		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<CacheHoursJSON> list = findByType(
			type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cache hours jsons before and after the current cache hours json in the ordered set where type = &#63;.
	 *
	 * @param cacheHoursJSONPK the primary key of the current cache hours json
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache hours json
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON[] findByType_PrevAndNext(
			CacheHoursJSONPK cacheHoursJSONPK, int type,
			OrderByComparator<CacheHoursJSON> orderByComparator)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = findByPrimaryKey(cacheHoursJSONPK);

		Session session = null;

		try {
			session = openSession();

			CacheHoursJSON[] array = new CacheHoursJSONImpl[3];

			array[0] = getByType_PrevAndNext(
				session, cacheHoursJSON, type, orderByComparator, true);

			array[1] = cacheHoursJSON;

			array[2] = getByType_PrevAndNext(
				session, cacheHoursJSON, type, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CacheHoursJSON getByType_PrevAndNext(
		Session session, CacheHoursJSON cacheHoursJSON, int type,
		OrderByComparator<CacheHoursJSON> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

		sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

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
			sb.append(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						cacheHoursJSON)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CacheHoursJSON> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cache hours jsons where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	@Override
	public void removeByType(int type) {
		for (CacheHoursJSON cacheHoursJSON :
				findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(cacheHoursJSON);
		}
	}

	/**
	 * Returns the number of cache hours jsons where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching cache hours jsons
	 */
	@Override
	public int countByType(int type) {
		FinderPath finderPath = _finderPathCountByType;

		Object[] finderArgs = new Object[] {type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CACHEHOURSJSON_WHERE);

			sb.append(_FINDER_COLUMN_TYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(type);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_2 =
		"cacheHoursJSON.id.type = ?";

	private FinderPath _finderPathFetchByStopCodeAndType;
	private FinderPath _finderPathCountByStopCodeAndType;

	/**
	 * Returns the cache hours json where stopCode = &#63; and type = &#63; or throws a <code>NoSuchCacheHoursJSONException</code> if it could not be found.
	 *
	 * @param stopCode the stop code
	 * @param type the type
	 * @return the matching cache hours json
	 * @throws NoSuchCacheHoursJSONException if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON findByStopCodeAndType(String stopCode, int type)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByStopCodeAndType(stopCode, type);

		if (cacheHoursJSON == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("stopCode=");
			sb.append(stopCode);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCacheHoursJSONException(sb.toString());
		}

		return cacheHoursJSON;
	}

	/**
	 * Returns the cache hours json where stopCode = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stopCode the stop code
	 * @param type the type
	 * @return the matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByStopCodeAndType(String stopCode, int type) {
		return fetchByStopCodeAndType(stopCode, type, true);
	}

	/**
	 * Returns the cache hours json where stopCode = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stopCode the stop code
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching cache hours json, or <code>null</code> if a matching cache hours json could not be found
	 */
	@Override
	public CacheHoursJSON fetchByStopCodeAndType(
		String stopCode, int type, boolean useFinderCache) {

		stopCode = Objects.toString(stopCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {stopCode, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByStopCodeAndType, finderArgs, this);
		}

		if (result instanceof CacheHoursJSON) {
			CacheHoursJSON cacheHoursJSON = (CacheHoursJSON)result;

			if (!Objects.equals(stopCode, cacheHoursJSON.getStopCode()) ||
				(type != cacheHoursJSON.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CACHEHOURSJSON_WHERE);

			boolean bindStopCode = false;

			if (stopCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_3);
			}
			else {
				bindStopCode = true;

				sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_2);
			}

			sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStopCode) {
					queryPos.add(stopCode);
				}

				queryPos.add(type);

				List<CacheHoursJSON> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByStopCodeAndType, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {stopCode, type};
							}

							_log.warn(
								"CacheHoursJSONPersistenceImpl.fetchByStopCodeAndType(String, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CacheHoursJSON cacheHoursJSON = list.get(0);

					result = cacheHoursJSON;

					cacheResult(cacheHoursJSON);
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
			return (CacheHoursJSON)result;
		}
	}

	/**
	 * Removes the cache hours json where stopCode = &#63; and type = &#63; from the database.
	 *
	 * @param stopCode the stop code
	 * @param type the type
	 * @return the cache hours json that was removed
	 */
	@Override
	public CacheHoursJSON removeByStopCodeAndType(String stopCode, int type)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = findByStopCodeAndType(stopCode, type);

		return remove(cacheHoursJSON);
	}

	/**
	 * Returns the number of cache hours jsons where stopCode = &#63; and type = &#63;.
	 *
	 * @param stopCode the stop code
	 * @param type the type
	 * @return the number of matching cache hours jsons
	 */
	@Override
	public int countByStopCodeAndType(String stopCode, int type) {
		stopCode = Objects.toString(stopCode, "");

		FinderPath finderPath = _finderPathCountByStopCodeAndType;

		Object[] finderArgs = new Object[] {stopCode, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CACHEHOURSJSON_WHERE);

			boolean bindStopCode = false;

			if (stopCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_3);
			}
			else {
				bindStopCode = true;

				sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_2);
			}

			sb.append(_FINDER_COLUMN_STOPCODEANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStopCode) {
					queryPos.add(stopCode);
				}

				queryPos.add(type);

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

	private static final String _FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_2 =
		"cacheHoursJSON.id.stopCode = ? AND ";

	private static final String _FINDER_COLUMN_STOPCODEANDTYPE_STOPCODE_3 =
		"(cacheHoursJSON.id.stopCode IS NULL OR cacheHoursJSON.id.stopCode = '') AND ";

	private static final String _FINDER_COLUMN_STOPCODEANDTYPE_TYPE_2 =
		"cacheHoursJSON.id.type = ?";

	public CacheHoursJSONPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CacheHoursJSON.class);

		setModelImplClass(CacheHoursJSONImpl.class);
		setModelPKClass(CacheHoursJSONPK.class);

		setTable(CacheHoursJSONTable.INSTANCE);
	}

	/**
	 * Caches the cache hours json in the entity cache if it is enabled.
	 *
	 * @param cacheHoursJSON the cache hours json
	 */
	@Override
	public void cacheResult(CacheHoursJSON cacheHoursJSON) {
		entityCache.putResult(
			CacheHoursJSONImpl.class, cacheHoursJSON.getPrimaryKey(),
			cacheHoursJSON);

		finderCache.putResult(
			_finderPathFetchByStopCodeAndType,
			new Object[] {
				cacheHoursJSON.getStopCode(), cacheHoursJSON.getType()
			},
			cacheHoursJSON);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the cache hours jsons in the entity cache if it is enabled.
	 *
	 * @param cacheHoursJSONs the cache hours jsons
	 */
	@Override
	public void cacheResult(List<CacheHoursJSON> cacheHoursJSONs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (cacheHoursJSONs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CacheHoursJSON cacheHoursJSON : cacheHoursJSONs) {
			if (entityCache.getResult(
					CacheHoursJSONImpl.class, cacheHoursJSON.getPrimaryKey()) ==
						null) {

				cacheResult(cacheHoursJSON);
			}
		}
	}

	/**
	 * Clears the cache for all cache hours jsons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CacheHoursJSONImpl.class);

		finderCache.clearCache(CacheHoursJSONImpl.class);
	}

	/**
	 * Clears the cache for the cache hours json.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CacheHoursJSON cacheHoursJSON) {
		entityCache.removeResult(CacheHoursJSONImpl.class, cacheHoursJSON);
	}

	@Override
	public void clearCache(List<CacheHoursJSON> cacheHoursJSONs) {
		for (CacheHoursJSON cacheHoursJSON : cacheHoursJSONs) {
			entityCache.removeResult(CacheHoursJSONImpl.class, cacheHoursJSON);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CacheHoursJSONImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CacheHoursJSONImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CacheHoursJSONModelImpl cacheHoursJSONModelImpl) {

		Object[] args = new Object[] {
			cacheHoursJSONModelImpl.getStopCode(),
			cacheHoursJSONModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByStopCodeAndType, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByStopCodeAndType, args, cacheHoursJSONModelImpl);
	}

	/**
	 * Creates a new cache hours json with the primary key. Does not add the cache hours json to the database.
	 *
	 * @param cacheHoursJSONPK the primary key for the new cache hours json
	 * @return the new cache hours json
	 */
	@Override
	public CacheHoursJSON create(CacheHoursJSONPK cacheHoursJSONPK) {
		CacheHoursJSON cacheHoursJSON = new CacheHoursJSONImpl();

		cacheHoursJSON.setNew(true);
		cacheHoursJSON.setPrimaryKey(cacheHoursJSONPK);

		String uuid = _portalUUID.generate();

		cacheHoursJSON.setUuid(uuid);

		return cacheHoursJSON;
	}

	/**
	 * Removes the cache hours json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json that was removed
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON remove(CacheHoursJSONPK cacheHoursJSONPK)
		throws NoSuchCacheHoursJSONException {

		return remove((Serializable)cacheHoursJSONPK);
	}

	/**
	 * Removes the cache hours json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cache hours json
	 * @return the cache hours json that was removed
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON remove(Serializable primaryKey)
		throws NoSuchCacheHoursJSONException {

		Session session = null;

		try {
			session = openSession();

			CacheHoursJSON cacheHoursJSON = (CacheHoursJSON)session.get(
				CacheHoursJSONImpl.class, primaryKey);

			if (cacheHoursJSON == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCacheHoursJSONException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cacheHoursJSON);
		}
		catch (NoSuchCacheHoursJSONException noSuchEntityException) {
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
	protected CacheHoursJSON removeImpl(CacheHoursJSON cacheHoursJSON) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cacheHoursJSON)) {
				cacheHoursJSON = (CacheHoursJSON)session.get(
					CacheHoursJSONImpl.class,
					cacheHoursJSON.getPrimaryKeyObj());
			}

			if (cacheHoursJSON != null) {
				session.delete(cacheHoursJSON);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (cacheHoursJSON != null) {
			clearCache(cacheHoursJSON);
		}

		return cacheHoursJSON;
	}

	@Override
	public CacheHoursJSON updateImpl(CacheHoursJSON cacheHoursJSON) {
		boolean isNew = cacheHoursJSON.isNew();

		if (!(cacheHoursJSON instanceof CacheHoursJSONModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cacheHoursJSON.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					cacheHoursJSON);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cacheHoursJSON proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CacheHoursJSON implementation " +
					cacheHoursJSON.getClass());
		}

		CacheHoursJSONModelImpl cacheHoursJSONModelImpl =
			(CacheHoursJSONModelImpl)cacheHoursJSON;

		if (Validator.isNull(cacheHoursJSON.getUuid())) {
			String uuid = _portalUUID.generate();

			cacheHoursJSON.setUuid(uuid);
		}

		if (!cacheHoursJSONModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				cacheHoursJSON.setModifiedDate(date);
			}
			else {
				cacheHoursJSON.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(cacheHoursJSON);
			}
			else {
				cacheHoursJSON = (CacheHoursJSON)session.merge(cacheHoursJSON);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CacheHoursJSONImpl.class, cacheHoursJSONModelImpl, false, true);

		cacheUniqueFindersCache(cacheHoursJSONModelImpl);

		if (isNew) {
			cacheHoursJSON.setNew(false);
		}

		cacheHoursJSON.resetOriginalValues();

		return cacheHoursJSON;
	}

	/**
	 * Returns the cache hours json with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cache hours json
	 * @return the cache hours json
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCacheHoursJSONException {

		CacheHoursJSON cacheHoursJSON = fetchByPrimaryKey(primaryKey);

		if (cacheHoursJSON == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCacheHoursJSONException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cacheHoursJSON;
	}

	/**
	 * Returns the cache hours json with the primary key or throws a <code>NoSuchCacheHoursJSONException</code> if it could not be found.
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json
	 * @throws NoSuchCacheHoursJSONException if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON findByPrimaryKey(CacheHoursJSONPK cacheHoursJSONPK)
		throws NoSuchCacheHoursJSONException {

		return findByPrimaryKey((Serializable)cacheHoursJSONPK);
	}

	/**
	 * Returns the cache hours json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json, or <code>null</code> if a cache hours json with the primary key could not be found
	 */
	@Override
	public CacheHoursJSON fetchByPrimaryKey(CacheHoursJSONPK cacheHoursJSONPK) {
		return fetchByPrimaryKey((Serializable)cacheHoursJSONPK);
	}

	/**
	 * Returns all the cache hours jsons.
	 *
	 * @return the cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache hours jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findAll(
		int start, int end,
		OrderByComparator<CacheHoursJSON> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache hours jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cache hours jsons
	 */
	@Override
	public List<CacheHoursJSON> findAll(
		int start, int end, OrderByComparator<CacheHoursJSON> orderByComparator,
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

		List<CacheHoursJSON> list = null;

		if (useFinderCache) {
			list = (List<CacheHoursJSON>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CACHEHOURSJSON);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CACHEHOURSJSON;

				sql = sql.concat(CacheHoursJSONModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CacheHoursJSON>)QueryUtil.list(
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
	 * Removes all the cache hours jsons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CacheHoursJSON cacheHoursJSON : findAll()) {
			remove(cacheHoursJSON);
		}
	}

	/**
	 * Returns the number of cache hours jsons.
	 *
	 * @return the number of cache hours jsons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CACHEHOURSJSON);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "cacheHoursJSONPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CACHEHOURSJSON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CacheHoursJSONModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cache hours json persistence.
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

		_finderPathWithPaginationFindByStopCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStopCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"stopCode"}, true);

		_finderPathWithoutPaginationFindByStopCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStopCode",
			new String[] {String.class.getName()}, new String[] {"stopCode"},
			true);

		_finderPathCountByStopCode = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStopCode",
			new String[] {String.class.getName()}, new String[] {"stopCode"},
			false);

		_finderPathWithPaginationFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"type_"}, true);

		_finderPathWithoutPaginationFindByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] {Integer.class.getName()}, new String[] {"type_"},
			true);

		_finderPathCountByType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] {Integer.class.getName()}, new String[] {"type_"},
			false);

		_finderPathFetchByStopCodeAndType = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByStopCodeAndType",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"stopCode", "type_"}, true);

		_finderPathCountByStopCodeAndType = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStopCodeAndType",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"stopCode", "type_"}, false);

		_setCacheHoursJSONUtilPersistence(this);
	}

	public void destroy() {
		_setCacheHoursJSONUtilPersistence(null);

		entityCache.removeCache(CacheHoursJSONImpl.class.getName());
	}

	private void _setCacheHoursJSONUtilPersistence(
		CacheHoursJSONPersistence cacheHoursJSONPersistence) {

		try {
			Field field = CacheHoursJSONUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, cacheHoursJSONPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CACHEHOURSJSON =
		"SELECT cacheHoursJSON FROM CacheHoursJSON cacheHoursJSON";

	private static final String _SQL_SELECT_CACHEHOURSJSON_WHERE =
		"SELECT cacheHoursJSON FROM CacheHoursJSON cacheHoursJSON WHERE ";

	private static final String _SQL_COUNT_CACHEHOURSJSON =
		"SELECT COUNT(cacheHoursJSON) FROM CacheHoursJSON cacheHoursJSON";

	private static final String _SQL_COUNT_CACHEHOURSJSON_WHERE =
		"SELECT COUNT(cacheHoursJSON) FROM CacheHoursJSON cacheHoursJSON WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cacheHoursJSON.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CacheHoursJSON exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CacheHoursJSON exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CacheHoursJSONPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"stopCode", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}