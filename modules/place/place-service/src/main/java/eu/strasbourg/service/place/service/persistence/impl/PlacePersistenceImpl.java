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

package eu.strasbourg.service.place.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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

import eu.strasbourg.service.place.exception.NoSuchPlaceException;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.PlaceTable;
import eu.strasbourg.service.place.model.impl.PlaceImpl;
import eu.strasbourg.service.place.model.impl.PlaceModelImpl;
import eu.strasbourg.service.place.service.persistence.PlacePersistence;
import eu.strasbourg.service.place.service.persistence.PlaceUtil;

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
 * The persistence implementation for the place service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PlacePersistenceImpl
	extends BasePersistenceImpl<Place> implements PlacePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PlaceUtil</code> to access the place persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PlaceImpl.class.getName();

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
	 * Returns all the places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching places
	 */
	@Override
	public List<Place> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of matching places
	 */
	@Override
	public List<Place> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Place> orderByComparator, boolean useFinderCache) {

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

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Place place : list) {
					if (!uuid.equals(place.getUuid())) {
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

			sb.append(_SQL_SELECT_PLACE_WHERE);

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
				sb.append(PlaceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Place>)QueryUtil.list(
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
	 * Returns the first place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByUuid_First(
			String uuid, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByUuid_First(uuid, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the first place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUuid_First(
		String uuid, OrderByComparator<Place> orderByComparator) {

		List<Place> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByUuid_Last(
			String uuid, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByUuid_Last(uuid, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the last place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUuid_Last(
		String uuid, OrderByComparator<Place> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Place> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the places before and after the current place in the ordered set where uuid = &#63;.
	 *
	 * @param placeId the primary key of the current place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place[] findByUuid_PrevAndNext(
			long placeId, String uuid,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		uuid = Objects.toString(uuid, "");

		Place place = findByPrimaryKey(placeId);

		Session session = null;

		try {
			session = openSession();

			Place[] array = new PlaceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, place, uuid, orderByComparator, true);

			array[1] = place;

			array[2] = getByUuid_PrevAndNext(
				session, place, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Place getByUuid_PrevAndNext(
		Session session, Place place, String uuid,
		OrderByComparator<Place> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACE_WHERE);

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
			sb.append(PlaceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(place)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Place> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Place place :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(place);
		}
	}

	/**
	 * Returns the number of places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching places
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "place.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(place.uuid IS NULL OR place.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the place where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPlaceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByUUID_G(String uuid, long groupId)
		throws NoSuchPlaceException {

		Place place = fetchByUUID_G(uuid, groupId);

		if (place == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPlaceException(sb.toString());
		}

		return place;
	}

	/**
	 * Returns the place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Place) {
			Place place = (Place)result;

			if (!Objects.equals(uuid, place.getUuid()) ||
				(groupId != place.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PLACE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Place> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Place place = list.get(0);

					result = place;

					cacheResult(place);
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
			return (Place)result;
		}
	}

	/**
	 * Removes the place where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the place that was removed
	 */
	@Override
	public Place removeByUUID_G(String uuid, long groupId)
		throws NoSuchPlaceException {

		Place place = findByUUID_G(uuid, groupId);

		return remove(place);
	}

	/**
	 * Returns the number of places where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching places
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"place.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(place.uuid IS NULL OR place.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"place.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching places
	 */
	@Override
	public List<Place> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of matching places
	 */
	@Override
	public List<Place> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Place> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Place place : list) {
					if (!uuid.equals(place.getUuid()) ||
						(companyId != place.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PLACE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlaceModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<Place>)QueryUtil.list(
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
	 * Returns the first place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the first place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Place> orderByComparator) {

		List<Place> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the last place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Place> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Place> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the places before and after the current place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param placeId the primary key of the current place
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place[] findByUuid_C_PrevAndNext(
			long placeId, String uuid, long companyId,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		uuid = Objects.toString(uuid, "");

		Place place = findByPrimaryKey(placeId);

		Session session = null;

		try {
			session = openSession();

			Place[] array = new PlaceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, place, uuid, companyId, orderByComparator, true);

			array[1] = place;

			array[2] = getByUuid_C_PrevAndNext(
				session, place, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Place getByUuid_C_PrevAndNext(
		Session session, Place place, String uuid, long companyId,
		OrderByComparator<Place> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PLACE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(PlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(place)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Place> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the places where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Place place :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(place);
		}
	}

	/**
	 * Returns the number of places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching places
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"place.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(place.uuid IS NULL OR place.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"place.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching places
	 */
	@Override
	public List<Place> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of matching places
	 */
	@Override
	public List<Place> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Place> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Place place : list) {
					if (groupId != place.getGroupId()) {
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

			sb.append(_SQL_SELECT_PLACE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Place>)QueryUtil.list(
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
	 * Returns the first place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByGroupId_First(
			long groupId, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByGroupId_First(groupId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the first place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByGroupId_First(
		long groupId, OrderByComparator<Place> orderByComparator) {

		List<Place> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByGroupId_Last(
			long groupId, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByGroupId_Last(groupId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the last place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByGroupId_Last(
		long groupId, OrderByComparator<Place> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Place> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the places before and after the current place in the ordered set where groupId = &#63;.
	 *
	 * @param placeId the primary key of the current place
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place[] findByGroupId_PrevAndNext(
			long placeId, long groupId,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = findByPrimaryKey(placeId);

		Session session = null;

		try {
			session = openSession();

			Place[] array = new PlaceImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, place, groupId, orderByComparator, true);

			array[1] = place;

			array[2] = getByGroupId_PrevAndNext(
				session, place, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Place getByGroupId_PrevAndNext(
		Session session, Place place, long groupId,
		OrderByComparator<Place> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			sb.append(PlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(place)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Place> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the places where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Place place :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(place);
		}
	}

	/**
	 * Returns the number of places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching places
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"place.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPriceId;
	private FinderPath _finderPathWithoutPaginationFindByPriceId;
	private FinderPath _finderPathCountByPriceId;

	/**
	 * Returns all the places where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @return the matching places
	 */
	@Override
	public List<Place> findByPriceId(long priceId) {
		return findByPriceId(
			priceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places where priceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param priceId the price ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of matching places
	 */
	@Override
	public List<Place> findByPriceId(long priceId, int start, int end) {
		return findByPriceId(priceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the places where priceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param priceId the price ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByPriceId(
		long priceId, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return findByPriceId(priceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places where priceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param priceId the price ID
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByPriceId(
		long priceId, int start, int end,
		OrderByComparator<Place> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPriceId;
				finderArgs = new Object[] {priceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPriceId;
			finderArgs = new Object[] {priceId, start, end, orderByComparator};
		}

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Place place : list) {
					if (priceId != place.getPriceId()) {
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

			sb.append(_SQL_SELECT_PLACE_WHERE);

			sb.append(_FINDER_COLUMN_PRICEID_PRICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(priceId);

				list = (List<Place>)QueryUtil.list(
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
	 * Returns the first place in the ordered set where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByPriceId_First(
			long priceId, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByPriceId_First(priceId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("priceId=");
		sb.append(priceId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the first place in the ordered set where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByPriceId_First(
		long priceId, OrderByComparator<Place> orderByComparator) {

		List<Place> list = findByPriceId(priceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place in the ordered set where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByPriceId_Last(
			long priceId, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByPriceId_Last(priceId, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("priceId=");
		sb.append(priceId);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the last place in the ordered set where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByPriceId_Last(
		long priceId, OrderByComparator<Place> orderByComparator) {

		int count = countByPriceId(priceId);

		if (count == 0) {
			return null;
		}

		List<Place> list = findByPriceId(
			priceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the places before and after the current place in the ordered set where priceId = &#63;.
	 *
	 * @param placeId the primary key of the current place
	 * @param priceId the price ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place[] findByPriceId_PrevAndNext(
			long placeId, long priceId,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = findByPrimaryKey(placeId);

		Session session = null;

		try {
			session = openSession();

			Place[] array = new PlaceImpl[3];

			array[0] = getByPriceId_PrevAndNext(
				session, place, priceId, orderByComparator, true);

			array[1] = place;

			array[2] = getByPriceId_PrevAndNext(
				session, place, priceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Place getByPriceId_PrevAndNext(
		Session session, Place place, long priceId,
		OrderByComparator<Place> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACE_WHERE);

		sb.append(_FINDER_COLUMN_PRICEID_PRICEID_2);

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
			sb.append(PlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(priceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(place)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Place> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the places where priceId = &#63; from the database.
	 *
	 * @param priceId the price ID
	 */
	@Override
	public void removeByPriceId(long priceId) {
		for (Place place :
				findByPriceId(
					priceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(place);
		}
	}

	/**
	 * Returns the number of places where priceId = &#63;.
	 *
	 * @param priceId the price ID
	 * @return the number of matching places
	 */
	@Override
	public int countByPriceId(long priceId) {
		FinderPath finderPath = _finderPathCountByPriceId;

		Object[] finderArgs = new Object[] {priceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			sb.append(_FINDER_COLUMN_PRICEID_PRICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(priceId);

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

	private static final String _FINDER_COLUMN_PRICEID_PRICEID_2 =
		"place.priceId = ?";

	private FinderPath _finderPathFetchBySIGId;
	private FinderPath _finderPathCountBySIGId;

	/**
	 * Returns the place where SIGid = &#63; or throws a <code>NoSuchPlaceException</code> if it could not be found.
	 *
	 * @param SIGid the si gid
	 * @return the matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findBySIGId(String SIGid) throws NoSuchPlaceException {
		Place place = fetchBySIGId(SIGid);

		if (place == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("SIGid=");
			sb.append(SIGid);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPlaceException(sb.toString());
		}

		return place;
	}

	/**
	 * Returns the place where SIGid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param SIGid the si gid
	 * @return the matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchBySIGId(String SIGid) {
		return fetchBySIGId(SIGid, true);
	}

	/**
	 * Returns the place where SIGid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param SIGid the si gid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchBySIGId(String SIGid, boolean useFinderCache) {
		SIGid = Objects.toString(SIGid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {SIGid};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySIGId, finderArgs, this);
		}

		if (result instanceof Place) {
			Place place = (Place)result;

			if (!Objects.equals(SIGid, place.getSIGid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PLACE_WHERE);

			boolean bindSIGid = false;

			if (SIGid.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_SIGID_3);
			}
			else {
				bindSIGid = true;

				sb.append(_FINDER_COLUMN_SIGID_SIGID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSIGid) {
					queryPos.add(SIGid);
				}

				List<Place> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySIGId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {SIGid};
							}

							_log.warn(
								"PlacePersistenceImpl.fetchBySIGId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Place place = list.get(0);

					result = place;

					cacheResult(place);
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
			return (Place)result;
		}
	}

	/**
	 * Removes the place where SIGid = &#63; from the database.
	 *
	 * @param SIGid the si gid
	 * @return the place that was removed
	 */
	@Override
	public Place removeBySIGId(String SIGid) throws NoSuchPlaceException {
		Place place = findBySIGId(SIGid);

		return remove(place);
	}

	/**
	 * Returns the number of places where SIGid = &#63;.
	 *
	 * @param SIGid the si gid
	 * @return the number of matching places
	 */
	@Override
	public int countBySIGId(String SIGid) {
		SIGid = Objects.toString(SIGid, "");

		FinderPath finderPath = _finderPathCountBySIGId;

		Object[] finderArgs = new Object[] {SIGid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			boolean bindSIGid = false;

			if (SIGid.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_SIGID_3);
			}
			else {
				bindSIGid = true;

				sb.append(_FINDER_COLUMN_SIGID_SIGID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSIGid) {
					queryPos.add(SIGid);
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

	private static final String _FINDER_COLUMN_SIGID_SIGID_2 =
		"place.SIGid = ?";

	private static final String _FINDER_COLUMN_SIGID_SIGID_3 =
		"(place.SIGid IS NULL OR place.SIGid = '')";

	private FinderPath _finderPathWithPaginationFindByname;
	private FinderPath _finderPathWithPaginationCountByname;

	/**
	 * Returns all the places where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching places
	 */
	@Override
	public List<Place> findByname(String name) {
		return findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of matching places
	 */
	@Override
	public List<Place> findByname(String name, int start, int end) {
		return findByname(name, start, end, null);
	}

	/**
	 * Returns an ordered range of all the places where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByname(
		String name, int start, int end,
		OrderByComparator<Place> orderByComparator) {

		return findByname(name, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places where name LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching places
	 */
	@Override
	public List<Place> findByname(
		String name, int start, int end,
		OrderByComparator<Place> orderByComparator, boolean useFinderCache) {

		name = Objects.toString(name, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByname;
		finderArgs = new Object[] {name, start, end, orderByComparator};

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Place place : list) {
					if (!StringUtil.wildcardMatches(
							place.getName(), name, '_', '%', '\\', true)) {

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

			sb.append(_SQL_SELECT_PLACE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				list = (List<Place>)QueryUtil.list(
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
	 * Returns the first place in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByname_First(
			String name, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByname_First(name, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the first place in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByname_First(
		String name, OrderByComparator<Place> orderByComparator) {

		List<Place> list = findByname(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last place in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place
	 * @throws NoSuchPlaceException if a matching place could not be found
	 */
	@Override
	public Place findByname_Last(
			String name, OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		Place place = fetchByname_Last(name, orderByComparator);

		if (place != null) {
			return place;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("nameLIKE");
		sb.append(name);

		sb.append("}");

		throw new NoSuchPlaceException(sb.toString());
	}

	/**
	 * Returns the last place in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching place, or <code>null</code> if a matching place could not be found
	 */
	@Override
	public Place fetchByname_Last(
		String name, OrderByComparator<Place> orderByComparator) {

		int count = countByname(name);

		if (count == 0) {
			return null;
		}

		List<Place> list = findByname(
			name, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the places before and after the current place in the ordered set where name LIKE &#63;.
	 *
	 * @param placeId the primary key of the current place
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place[] findByname_PrevAndNext(
			long placeId, String name,
			OrderByComparator<Place> orderByComparator)
		throws NoSuchPlaceException {

		name = Objects.toString(name, "");

		Place place = findByPrimaryKey(placeId);

		Session session = null;

		try {
			session = openSession();

			Place[] array = new PlaceImpl[3];

			array[0] = getByname_PrevAndNext(
				session, place, name, orderByComparator, true);

			array[1] = place;

			array[2] = getByname_PrevAndNext(
				session, place, name, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Place getByname_PrevAndNext(
		Session session, Place place, String name,
		OrderByComparator<Place> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACE_WHERE);

		boolean bindName = false;

		if (name.isEmpty()) {
			sb.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			sb.append(_FINDER_COLUMN_NAME_NAME_2);
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
			sb.append(PlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindName) {
			queryPos.add(name);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(place)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Place> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the places where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 */
	@Override
	public void removeByname(String name) {
		for (Place place :
				findByname(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(place);
		}
	}

	/**
	 * Returns the number of places where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching places
	 */
	@Override
	public int countByname(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathWithPaginationCountByname;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACE_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"place.name LIKE ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(place.name IS NULL OR place.name LIKE '')";

	public PlacePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("alias", "alias_");
		dbColumnNames.put("access", "access_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Place.class);

		setModelImplClass(PlaceImpl.class);
		setModelPKClass(long.class);

		setTable(PlaceTable.INSTANCE);
	}

	/**
	 * Caches the place in the entity cache if it is enabled.
	 *
	 * @param place the place
	 */
	@Override
	public void cacheResult(Place place) {
		entityCache.putResult(PlaceImpl.class, place.getPrimaryKey(), place);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {place.getUuid(), place.getGroupId()}, place);

		finderCache.putResult(
			_finderPathFetchBySIGId, new Object[] {place.getSIGid()}, place);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the places in the entity cache if it is enabled.
	 *
	 * @param places the places
	 */
	@Override
	public void cacheResult(List<Place> places) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (places.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Place place : places) {
			if (entityCache.getResult(PlaceImpl.class, place.getPrimaryKey()) ==
					null) {

				cacheResult(place);
			}
		}
	}

	/**
	 * Clears the cache for all places.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PlaceImpl.class);

		finderCache.clearCache(PlaceImpl.class);
	}

	/**
	 * Clears the cache for the place.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Place place) {
		entityCache.removeResult(PlaceImpl.class, place);
	}

	@Override
	public void clearCache(List<Place> places) {
		for (Place place : places) {
			entityCache.removeResult(PlaceImpl.class, place);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PlaceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PlaceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(PlaceModelImpl placeModelImpl) {
		Object[] args = new Object[] {
			placeModelImpl.getUuid(), placeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, placeModelImpl);

		args = new Object[] {placeModelImpl.getSIGid()};

		finderCache.putResult(_finderPathCountBySIGId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchBySIGId, args, placeModelImpl);
	}

	/**
	 * Creates a new place with the primary key. Does not add the place to the database.
	 *
	 * @param placeId the primary key for the new place
	 * @return the new place
	 */
	@Override
	public Place create(long placeId) {
		Place place = new PlaceImpl();

		place.setNew(true);
		place.setPrimaryKey(placeId);

		String uuid = _portalUUID.generate();

		place.setUuid(uuid);

		place.setCompanyId(CompanyThreadLocal.getCompanyId());

		return place;
	}

	/**
	 * Removes the place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param placeId the primary key of the place
	 * @return the place that was removed
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place remove(long placeId) throws NoSuchPlaceException {
		return remove((Serializable)placeId);
	}

	/**
	 * Removes the place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the place
	 * @return the place that was removed
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place remove(Serializable primaryKey) throws NoSuchPlaceException {
		Session session = null;

		try {
			session = openSession();

			Place place = (Place)session.get(PlaceImpl.class, primaryKey);

			if (place == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPlaceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(place);
		}
		catch (NoSuchPlaceException noSuchEntityException) {
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
	protected Place removeImpl(Place place) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(place)) {
				place = (Place)session.get(
					PlaceImpl.class, place.getPrimaryKeyObj());
			}

			if (place != null) {
				session.delete(place);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (place != null) {
			clearCache(place);
		}

		return place;
	}

	@Override
	public Place updateImpl(Place place) {
		boolean isNew = place.isNew();

		if (!(place instanceof PlaceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(place.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(place);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in place proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Place implementation " +
					place.getClass());
		}

		PlaceModelImpl placeModelImpl = (PlaceModelImpl)place;

		if (Validator.isNull(place.getUuid())) {
			String uuid = _portalUUID.generate();

			place.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (place.getCreateDate() == null)) {
			if (serviceContext == null) {
				place.setCreateDate(date);
			}
			else {
				place.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!placeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				place.setModifiedDate(date);
			}
			else {
				place.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(place);
			}
			else {
				place = (Place)session.merge(place);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(PlaceImpl.class, placeModelImpl, false, true);

		cacheUniqueFindersCache(placeModelImpl);

		if (isNew) {
			place.setNew(false);
		}

		place.resetOriginalValues();

		return place;
	}

	/**
	 * Returns the place with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the place
	 * @return the place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPlaceException {

		Place place = fetchByPrimaryKey(primaryKey);

		if (place == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPlaceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return place;
	}

	/**
	 * Returns the place with the primary key or throws a <code>NoSuchPlaceException</code> if it could not be found.
	 *
	 * @param placeId the primary key of the place
	 * @return the place
	 * @throws NoSuchPlaceException if a place with the primary key could not be found
	 */
	@Override
	public Place findByPrimaryKey(long placeId) throws NoSuchPlaceException {
		return findByPrimaryKey((Serializable)placeId);
	}

	/**
	 * Returns the place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param placeId the primary key of the place
	 * @return the place, or <code>null</code> if a place with the primary key could not be found
	 */
	@Override
	public Place fetchByPrimaryKey(long placeId) {
		return fetchByPrimaryKey((Serializable)placeId);
	}

	/**
	 * Returns all the places.
	 *
	 * @return the places
	 */
	@Override
	public List<Place> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @return the range of places
	 */
	@Override
	public List<Place> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of places
	 */
	@Override
	public List<Place> findAll(
		int start, int end, OrderByComparator<Place> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of places
	 * @param end the upper bound of the range of places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of places
	 */
	@Override
	public List<Place> findAll(
		int start, int end, OrderByComparator<Place> orderByComparator,
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

		List<Place> list = null;

		if (useFinderCache) {
			list = (List<Place>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLACE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLACE;

				sql = sql.concat(PlaceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Place>)QueryUtil.list(
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
	 * Removes all the places from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Place place : findAll()) {
			remove(place);
		}
	}

	/**
	 * Returns the number of places.
	 *
	 * @return the number of places
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PLACE);

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
		return "placeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PLACE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PlaceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the place persistence.
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByPriceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPriceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"priceId"}, true);

		_finderPathWithoutPaginationFindByPriceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPriceId",
			new String[] {Long.class.getName()}, new String[] {"priceId"},
			true);

		_finderPathCountByPriceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPriceId",
			new String[] {Long.class.getName()}, new String[] {"priceId"},
			false);

		_finderPathFetchBySIGId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySIGId",
			new String[] {String.class.getName()}, new String[] {"SIGid"},
			true);

		_finderPathCountBySIGId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySIGId",
			new String[] {String.class.getName()}, new String[] {"SIGid"},
			false);

		_finderPathWithPaginationFindByname = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByname",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"name"}, true);

		_finderPathWithPaginationCountByname = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByname",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setPlaceUtilPersistence(this);
	}

	public void destroy() {
		_setPlaceUtilPersistence(null);

		entityCache.removeCache(PlaceImpl.class.getName());
	}

	private void _setPlaceUtilPersistence(PlacePersistence placePersistence) {
		try {
			Field field = PlaceUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, placePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PLACE =
		"SELECT place FROM Place place";

	private static final String _SQL_SELECT_PLACE_WHERE =
		"SELECT place FROM Place place WHERE ";

	private static final String _SQL_COUNT_PLACE =
		"SELECT COUNT(place) FROM Place place";

	private static final String _SQL_COUNT_PLACE_WHERE =
		"SELECT COUNT(place) FROM Place place WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "place.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Place exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Place exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PlacePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "alias", "access"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}