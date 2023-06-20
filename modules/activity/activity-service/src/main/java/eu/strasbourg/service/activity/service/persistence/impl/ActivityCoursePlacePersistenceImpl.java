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

package eu.strasbourg.service.activity.service.persistence.impl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.exception.NoSuchActivityCoursePlaceException;
import eu.strasbourg.service.activity.model.ActivityCoursePlace;
import eu.strasbourg.service.activity.model.ActivityCoursePlaceTable;
import eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl;
import eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePlacePersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePlaceUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the activity course place service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCoursePlacePersistenceImpl
	extends BasePersistenceImpl<ActivityCoursePlace>
	implements ActivityCoursePlacePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActivityCoursePlaceUtil</code> to access the activity course place persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActivityCoursePlaceImpl.class.getName();

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
	 * Returns all the activity course places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
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

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCoursePlace activityCoursePlace : list) {
					if (!uuid.equals(activityCoursePlace.getUuid())) {
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

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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
				sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Returns the first activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByUuid_First(
			String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByUuid_First(
			uuid, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUuid_First(
		String uuid, OrderByComparator<ActivityCoursePlace> orderByComparator) {

		List<ActivityCoursePlace> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByUuid_Last(
			String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByUuid_Last(
			uuid, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUuid_Last(
		String uuid, OrderByComparator<ActivityCoursePlace> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ActivityCoursePlace> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace[] findByUuid_PrevAndNext(
			long activityCoursePlaceId, String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		uuid = Objects.toString(uuid, "");

		ActivityCoursePlace activityCoursePlace = findByPrimaryKey(
			activityCoursePlaceId);

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace[] array = new ActivityCoursePlaceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, activityCoursePlace, uuid, orderByComparator, true);

			array[1] = activityCoursePlace;

			array[2] = getByUuid_PrevAndNext(
				session, activityCoursePlace, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCoursePlace getByUuid_PrevAndNext(
		Session session, ActivityCoursePlace activityCoursePlace, String uuid,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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
			sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
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
						activityCoursePlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCoursePlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity course places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ActivityCoursePlace activityCoursePlace :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity course places
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

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
		"activityCoursePlace.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(activityCoursePlace.uuid IS NULL OR activityCoursePlace.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityCoursePlaceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByUUID_G(String uuid, long groupId)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByUUID_G(uuid, groupId);

		if (activityCoursePlace == null) {
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

			throw new NoSuchActivityCoursePlaceException(sb.toString());
		}

		return activityCoursePlace;
	}

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUUID_G(
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

		if (result instanceof ActivityCoursePlace) {
			ActivityCoursePlace activityCoursePlace =
				(ActivityCoursePlace)result;

			if (!Objects.equals(uuid, activityCoursePlace.getUuid()) ||
				(groupId != activityCoursePlace.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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

				List<ActivityCoursePlace> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ActivityCoursePlace activityCoursePlace = list.get(0);

					result = activityCoursePlace;

					cacheResult(activityCoursePlace);
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
			return (ActivityCoursePlace)result;
		}
	}

	/**
	 * Removes the activity course place where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity course place that was removed
	 */
	@Override
	public ActivityCoursePlace removeByUUID_G(String uuid, long groupId)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = findByUUID_G(uuid, groupId);

		return remove(activityCoursePlace);
	}

	/**
	 * Returns the number of activity course places where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity course places
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

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
		"activityCoursePlace.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(activityCoursePlace.uuid IS NULL OR activityCoursePlace.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"activityCoursePlace.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

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

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCoursePlace activityCoursePlace : list) {
					if (!uuid.equals(activityCoursePlace.getUuid()) ||
						(companyId != activityCoursePlace.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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
				sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Returns the first activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		List<ActivityCoursePlace> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ActivityCoursePlace> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace[] findByUuid_C_PrevAndNext(
			long activityCoursePlaceId, String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		uuid = Objects.toString(uuid, "");

		ActivityCoursePlace activityCoursePlace = findByPrimaryKey(
			activityCoursePlaceId);

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace[] array = new ActivityCoursePlaceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, activityCoursePlace, uuid, companyId,
				orderByComparator, true);

			array[1] = activityCoursePlace;

			array[2] = getByUuid_C_PrevAndNext(
				session, activityCoursePlace, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCoursePlace getByUuid_C_PrevAndNext(
		Session session, ActivityCoursePlace activityCoursePlace, String uuid,
		long companyId,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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
			sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						activityCoursePlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCoursePlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity course places where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ActivityCoursePlace activityCoursePlace :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity course places
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

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
		"activityCoursePlace.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(activityCoursePlace.uuid IS NULL OR activityCoursePlace.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"activityCoursePlace.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the activity course places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

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

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCoursePlace activityCoursePlace : list) {
					if (groupId != activityCoursePlace.getGroupId()) {
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

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Returns the first activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByGroupId_First(
			long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByGroupId_First(
			groupId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the first activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByGroupId_First(
		long groupId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		List<ActivityCoursePlace> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByGroupId_Last(
			long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the last activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByGroupId_Last(
		long groupId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ActivityCoursePlace> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace[] findByGroupId_PrevAndNext(
			long activityCoursePlaceId, long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = findByPrimaryKey(
			activityCoursePlaceId);

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace[] array = new ActivityCoursePlaceImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, activityCoursePlace, groupId, orderByComparator, true);

			array[1] = activityCoursePlace;

			array[2] = getByGroupId_PrevAndNext(
				session, activityCoursePlace, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCoursePlace getByGroupId_PrevAndNext(
		Session session, ActivityCoursePlace activityCoursePlace, long groupId,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

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
			sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						activityCoursePlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCoursePlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity course places where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ActivityCoursePlace activityCoursePlace :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity course places
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

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
		"activityCoursePlace.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByActivityCourse;
	private FinderPath _finderPathWithoutPaginationFindByActivityCourse;
	private FinderPath _finderPathCountByActivityCourse;

	/**
	 * Returns all the activity course places where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @return the matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId) {

		return findByActivityCourse(
			activityCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end) {

		return findByActivityCourse(activityCourseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findByActivityCourse(
			activityCourseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActivityCourse;
				finderArgs = new Object[] {activityCourseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActivityCourse;
			finderArgs = new Object[] {
				activityCourseId, start, end, orderByComparator
			};
		}

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCoursePlace activityCoursePlace : list) {
					if (activityCourseId !=
							activityCoursePlace.getActivityCourseId()) {

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

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITYCOURSE_ACTIVITYCOURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityCourseId);

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Returns the first activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByActivityCourse_First(
			long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByActivityCourse_First(
			activityCourseId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityCourseId=");
		sb.append(activityCourseId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the first activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByActivityCourse_First(
		long activityCourseId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		List<ActivityCoursePlace> list = findByActivityCourse(
			activityCourseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findByActivityCourse_Last(
			long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByActivityCourse_Last(
			activityCourseId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityCourseId=");
		sb.append(activityCourseId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the last activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByActivityCourse_Last(
		long activityCourseId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		int count = countByActivityCourse(activityCourseId);

		if (count == 0) {
			return null;
		}

		List<ActivityCoursePlace> list = findByActivityCourse(
			activityCourseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace[] findByActivityCourse_PrevAndNext(
			long activityCoursePlaceId, long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = findByPrimaryKey(
			activityCoursePlaceId);

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace[] array = new ActivityCoursePlaceImpl[3];

			array[0] = getByActivityCourse_PrevAndNext(
				session, activityCoursePlace, activityCourseId,
				orderByComparator, true);

			array[1] = activityCoursePlace;

			array[2] = getByActivityCourse_PrevAndNext(
				session, activityCoursePlace, activityCourseId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCoursePlace getByActivityCourse_PrevAndNext(
		Session session, ActivityCoursePlace activityCoursePlace,
		long activityCourseId,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVITYCOURSE_ACTIVITYCOURSEID_2);

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
			sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(activityCourseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						activityCoursePlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCoursePlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity course places where activityCourseId = &#63; from the database.
	 *
	 * @param activityCourseId the activity course ID
	 */
	@Override
	public void removeByActivityCourse(long activityCourseId) {
		for (ActivityCoursePlace activityCoursePlace :
				findByActivityCourse(
					activityCourseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @return the number of matching activity course places
	 */
	@Override
	public int countByActivityCourse(long activityCourseId) {
		FinderPath finderPath = _finderPathCountByActivityCourse;

		Object[] finderArgs = new Object[] {activityCourseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITYCOURSE_ACTIVITYCOURSEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityCourseId);

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

	private static final String
		_FINDER_COLUMN_ACTIVITYCOURSE_ACTIVITYCOURSEID_2 =
			"activityCoursePlace.activityCourseId = ?";

	private FinderPath _finderPathWithPaginationFindBySigId;
	private FinderPath _finderPathWithoutPaginationFindBySigId;
	private FinderPath _finderPathCountBySigId;

	/**
	 * Returns all the activity course places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findBySigId(String placeSIGId) {
		return findBySigId(
			placeSIGId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end) {

		return findBySigId(placeSIGId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findBySigId(placeSIGId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		placeSIGId = Objects.toString(placeSIGId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySigId;
				finderArgs = new Object[] {placeSIGId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySigId;
			finderArgs = new Object[] {
				placeSIGId, start, end, orderByComparator
			};
		}

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCoursePlace activityCoursePlace : list) {
					if (!placeSIGId.equals(
							activityCoursePlace.getPlaceSIGId())) {

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

			sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

			boolean bindPlaceSIGId = false;

			if (placeSIGId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
			}
			else {
				bindPlaceSIGId = true;

				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlaceSIGId) {
					queryPos.add(placeSIGId);
				}

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Returns the first activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findBySigId_First(
			String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchBySigId_First(
			placeSIGId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeSIGId=");
		sb.append(placeSIGId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the first activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchBySigId_First(
		String placeSIGId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		List<ActivityCoursePlace> list = findBySigId(
			placeSIGId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace findBySigId_Last(
			String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchBySigId_Last(
			placeSIGId, orderByComparator);

		if (activityCoursePlace != null) {
			return activityCoursePlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeSIGId=");
		sb.append(placeSIGId);

		sb.append("}");

		throw new NoSuchActivityCoursePlaceException(sb.toString());
	}

	/**
	 * Returns the last activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	@Override
	public ActivityCoursePlace fetchBySigId_Last(
		String placeSIGId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		int count = countBySigId(placeSIGId);

		if (count == 0) {
			return null;
		}

		List<ActivityCoursePlace> list = findBySigId(
			placeSIGId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace[] findBySigId_PrevAndNext(
			long activityCoursePlaceId, String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws NoSuchActivityCoursePlaceException {

		placeSIGId = Objects.toString(placeSIGId, "");

		ActivityCoursePlace activityCoursePlace = findByPrimaryKey(
			activityCoursePlaceId);

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace[] array = new ActivityCoursePlaceImpl[3];

			array[0] = getBySigId_PrevAndNext(
				session, activityCoursePlace, placeSIGId, orderByComparator,
				true);

			array[1] = activityCoursePlace;

			array[2] = getBySigId_PrevAndNext(
				session, activityCoursePlace, placeSIGId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCoursePlace getBySigId_PrevAndNext(
		Session session, ActivityCoursePlace activityCoursePlace,
		String placeSIGId,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE);

		boolean bindPlaceSIGId = false;

		if (placeSIGId.isEmpty()) {
			sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
		}
		else {
			bindPlaceSIGId = true;

			sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
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
			sb.append(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPlaceSIGId) {
			queryPos.add(placeSIGId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						activityCoursePlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCoursePlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity course places where placeSIGId = &#63; from the database.
	 *
	 * @param placeSIGId the place sig ID
	 */
	@Override
	public void removeBySigId(String placeSIGId) {
		for (ActivityCoursePlace activityCoursePlace :
				findBySigId(
					placeSIGId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the number of matching activity course places
	 */
	@Override
	public int countBySigId(String placeSIGId) {
		placeSIGId = Objects.toString(placeSIGId, "");

		FinderPath finderPath = _finderPathCountBySigId;

		Object[] finderArgs = new Object[] {placeSIGId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE);

			boolean bindPlaceSIGId = false;

			if (placeSIGId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
			}
			else {
				bindPlaceSIGId = true;

				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlaceSIGId) {
					queryPos.add(placeSIGId);
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

	private static final String _FINDER_COLUMN_SIGID_PLACESIGID_2 =
		"activityCoursePlace.placeSIGId = ?";

	private static final String _FINDER_COLUMN_SIGID_PLACESIGID_3 =
		"(activityCoursePlace.placeSIGId IS NULL OR activityCoursePlace.placeSIGId = '')";

	public ActivityCoursePlacePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ActivityCoursePlace.class);

		setModelImplClass(ActivityCoursePlaceImpl.class);
		setModelPKClass(long.class);

		setTable(ActivityCoursePlaceTable.INSTANCE);
	}

	/**
	 * Caches the activity course place in the entity cache if it is enabled.
	 *
	 * @param activityCoursePlace the activity course place
	 */
	@Override
	public void cacheResult(ActivityCoursePlace activityCoursePlace) {
		entityCache.putResult(
			ActivityCoursePlaceImpl.class, activityCoursePlace.getPrimaryKey(),
			activityCoursePlace);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				activityCoursePlace.getUuid(), activityCoursePlace.getGroupId()
			},
			activityCoursePlace);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the activity course places in the entity cache if it is enabled.
	 *
	 * @param activityCoursePlaces the activity course places
	 */
	@Override
	public void cacheResult(List<ActivityCoursePlace> activityCoursePlaces) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (activityCoursePlaces.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ActivityCoursePlace activityCoursePlace : activityCoursePlaces) {
			if (entityCache.getResult(
					ActivityCoursePlaceImpl.class,
					activityCoursePlace.getPrimaryKey()) == null) {

				cacheResult(activityCoursePlace);
			}
		}
	}

	/**
	 * Clears the cache for all activity course places.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityCoursePlaceImpl.class);

		finderCache.clearCache(ActivityCoursePlaceImpl.class);
	}

	/**
	 * Clears the cache for the activity course place.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityCoursePlace activityCoursePlace) {
		entityCache.removeResult(
			ActivityCoursePlaceImpl.class, activityCoursePlace);
	}

	@Override
	public void clearCache(List<ActivityCoursePlace> activityCoursePlaces) {
		for (ActivityCoursePlace activityCoursePlace : activityCoursePlaces) {
			entityCache.removeResult(
				ActivityCoursePlaceImpl.class, activityCoursePlace);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ActivityCoursePlaceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ActivityCoursePlaceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ActivityCoursePlaceModelImpl activityCoursePlaceModelImpl) {

		Object[] args = new Object[] {
			activityCoursePlaceModelImpl.getUuid(),
			activityCoursePlaceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, activityCoursePlaceModelImpl);
	}

	/**
	 * Creates a new activity course place with the primary key. Does not add the activity course place to the database.
	 *
	 * @param activityCoursePlaceId the primary key for the new activity course place
	 * @return the new activity course place
	 */
	@Override
	public ActivityCoursePlace create(long activityCoursePlaceId) {
		ActivityCoursePlace activityCoursePlace = new ActivityCoursePlaceImpl();

		activityCoursePlace.setNew(true);
		activityCoursePlace.setPrimaryKey(activityCoursePlaceId);

		String uuid = _portalUUID.generate();

		activityCoursePlace.setUuid(uuid);

		activityCoursePlace.setCompanyId(CompanyThreadLocal.getCompanyId());

		return activityCoursePlace;
	}

	/**
	 * Removes the activity course place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place that was removed
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace remove(long activityCoursePlaceId)
		throws NoSuchActivityCoursePlaceException {

		return remove((Serializable)activityCoursePlaceId);
	}

	/**
	 * Removes the activity course place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity course place
	 * @return the activity course place that was removed
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace remove(Serializable primaryKey)
		throws NoSuchActivityCoursePlaceException {

		Session session = null;

		try {
			session = openSession();

			ActivityCoursePlace activityCoursePlace =
				(ActivityCoursePlace)session.get(
					ActivityCoursePlaceImpl.class, primaryKey);

			if (activityCoursePlace == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityCoursePlaceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(activityCoursePlace);
		}
		catch (NoSuchActivityCoursePlaceException noSuchEntityException) {
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
	protected ActivityCoursePlace removeImpl(
		ActivityCoursePlace activityCoursePlace) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityCoursePlace)) {
				activityCoursePlace = (ActivityCoursePlace)session.get(
					ActivityCoursePlaceImpl.class,
					activityCoursePlace.getPrimaryKeyObj());
			}

			if (activityCoursePlace != null) {
				session.delete(activityCoursePlace);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (activityCoursePlace != null) {
			clearCache(activityCoursePlace);
		}

		return activityCoursePlace;
	}

	@Override
	public ActivityCoursePlace updateImpl(
		ActivityCoursePlace activityCoursePlace) {

		boolean isNew = activityCoursePlace.isNew();

		if (!(activityCoursePlace instanceof ActivityCoursePlaceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activityCoursePlace.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					activityCoursePlace);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activityCoursePlace proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ActivityCoursePlace implementation " +
					activityCoursePlace.getClass());
		}

		ActivityCoursePlaceModelImpl activityCoursePlaceModelImpl =
			(ActivityCoursePlaceModelImpl)activityCoursePlace;

		if (Validator.isNull(activityCoursePlace.getUuid())) {
			String uuid = _portalUUID.generate();

			activityCoursePlace.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (activityCoursePlace.getCreateDate() == null)) {
			if (serviceContext == null) {
				activityCoursePlace.setCreateDate(date);
			}
			else {
				activityCoursePlace.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!activityCoursePlaceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				activityCoursePlace.setModifiedDate(date);
			}
			else {
				activityCoursePlace.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(activityCoursePlace);
			}
			else {
				activityCoursePlace = (ActivityCoursePlace)session.merge(
					activityCoursePlace);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ActivityCoursePlaceImpl.class, activityCoursePlaceModelImpl, false,
			true);

		cacheUniqueFindersCache(activityCoursePlaceModelImpl);

		if (isNew) {
			activityCoursePlace.setNew(false);
		}

		activityCoursePlace.resetOriginalValues();

		return activityCoursePlace;
	}

	/**
	 * Returns the activity course place with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity course place
	 * @return the activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityCoursePlaceException {

		ActivityCoursePlace activityCoursePlace = fetchByPrimaryKey(primaryKey);

		if (activityCoursePlace == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityCoursePlaceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return activityCoursePlace;
	}

	/**
	 * Returns the activity course place with the primary key or throws a <code>NoSuchActivityCoursePlaceException</code> if it could not be found.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace findByPrimaryKey(long activityCoursePlaceId)
		throws NoSuchActivityCoursePlaceException {

		return findByPrimaryKey((Serializable)activityCoursePlaceId);
	}

	/**
	 * Returns the activity course place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place, or <code>null</code> if a activity course place with the primary key could not be found
	 */
	@Override
	public ActivityCoursePlace fetchByPrimaryKey(long activityCoursePlaceId) {
		return fetchByPrimaryKey((Serializable)activityCoursePlaceId);
	}

	/**
	 * Returns all the activity course places.
	 *
	 * @return the activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findAll(
		int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity course places
	 */
	@Override
	public List<ActivityCoursePlace> findAll(
		int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
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

		List<ActivityCoursePlace> list = null;

		if (useFinderCache) {
			list = (List<ActivityCoursePlace>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTIVITYCOURSEPLACE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYCOURSEPLACE;

				sql = sql.concat(ActivityCoursePlaceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ActivityCoursePlace>)QueryUtil.list(
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
	 * Removes all the activity course places from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ActivityCoursePlace activityCoursePlace : findAll()) {
			remove(activityCoursePlace);
		}
	}

	/**
	 * Returns the number of activity course places.
	 *
	 * @return the number of activity course places
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ACTIVITYCOURSEPLACE);

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
		return "activityCoursePlaceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTIVITYCOURSEPLACE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActivityCoursePlaceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity course place persistence.
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

		_finderPathWithPaginationFindByActivityCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByActivityCourse",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"activityCourseId"}, true);

		_finderPathWithoutPaginationFindByActivityCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByActivityCourse",
			new String[] {Long.class.getName()},
			new String[] {"activityCourseId"}, true);

		_finderPathCountByActivityCourse = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivityCourse",
			new String[] {Long.class.getName()},
			new String[] {"activityCourseId"}, false);

		_finderPathWithPaginationFindBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySigId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"placeSIGId"}, true);

		_finderPathWithoutPaginationFindBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySigId",
			new String[] {String.class.getName()}, new String[] {"placeSIGId"},
			true);

		_finderPathCountBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigId",
			new String[] {String.class.getName()}, new String[] {"placeSIGId"},
			false);

		_setActivityCoursePlaceUtilPersistence(this);
	}

	public void destroy() {
		_setActivityCoursePlaceUtilPersistence(null);

		entityCache.removeCache(ActivityCoursePlaceImpl.class.getName());
	}

	private void _setActivityCoursePlaceUtilPersistence(
		ActivityCoursePlacePersistence activityCoursePlacePersistence) {

		try {
			Field field = ActivityCoursePlaceUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, activityCoursePlacePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACTIVITYCOURSEPLACE =
		"SELECT activityCoursePlace FROM ActivityCoursePlace activityCoursePlace";

	private static final String _SQL_SELECT_ACTIVITYCOURSEPLACE_WHERE =
		"SELECT activityCoursePlace FROM ActivityCoursePlace activityCoursePlace WHERE ";

	private static final String _SQL_COUNT_ACTIVITYCOURSEPLACE =
		"SELECT COUNT(activityCoursePlace) FROM ActivityCoursePlace activityCoursePlace";

	private static final String _SQL_COUNT_ACTIVITYCOURSEPLACE_WHERE =
		"SELECT COUNT(activityCoursePlace) FROM ActivityCoursePlace activityCoursePlace WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "activityCoursePlace.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ActivityCoursePlace exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ActivityCoursePlace exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityCoursePlacePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}