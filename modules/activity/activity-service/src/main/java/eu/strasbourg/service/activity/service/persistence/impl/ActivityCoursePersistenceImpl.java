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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.exception.NoSuchActivityCourseException;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.model.impl.ActivityCourseImpl;
import eu.strasbourg.service.activity.model.impl.ActivityCourseModelImpl;
import eu.strasbourg.service.activity.service.persistence.ActivityCoursePersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the activity course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCoursePersistenceImpl
	extends BasePersistenceImpl<ActivityCourse>
	implements ActivityCoursePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActivityCourseUtil</code> to access the activity course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActivityCourseImpl.class.getName();

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
	 * Returns all the activity courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
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

		List<ActivityCourse> list = null;

		if (useFinderCache) {
			list = (List<ActivityCourse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCourse activityCourse : list) {
					if (!uuid.equals(activityCourse.getUuid())) {
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

			sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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
				sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityCourse>)QueryUtil.list(
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
	 * Returns the first activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByUuid_First(
			String uuid, OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByUuid_First(
			uuid, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUuid_First(
		String uuid, OrderByComparator<ActivityCourse> orderByComparator) {

		List<ActivityCourse> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByUuid_Last(
			String uuid, OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByUuid_Last(
			uuid, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUuid_Last(
		String uuid, OrderByComparator<ActivityCourse> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ActivityCourse> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where uuid = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse[] findByUuid_PrevAndNext(
			long activityCourseId, String uuid,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		uuid = Objects.toString(uuid, "");

		ActivityCourse activityCourse = findByPrimaryKey(activityCourseId);

		Session session = null;

		try {
			session = openSession();

			ActivityCourse[] array = new ActivityCourseImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, activityCourse, uuid, orderByComparator, true);

			array[1] = activityCourse;

			array[2] = getByUuid_PrevAndNext(
				session, activityCourse, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCourse getByUuid_PrevAndNext(
		Session session, ActivityCourse activityCourse, String uuid,
		OrderByComparator<ActivityCourse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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
			sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
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
						activityCourse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCourse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity courses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ActivityCourse activityCourse :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCourse);
		}
	}

	/**
	 * Returns the number of activity courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity courses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSE_WHERE);

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
		"activityCourse.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(activityCourse.uuid IS NULL OR activityCourse.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityCourseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByUUID_G(String uuid, long groupId)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByUUID_G(uuid, groupId);

		if (activityCourse == null) {
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

			throw new NoSuchActivityCourseException(sb.toString());
		}

		return activityCourse;
	}

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUUID_G(
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

		if (result instanceof ActivityCourse) {
			ActivityCourse activityCourse = (ActivityCourse)result;

			if (!Objects.equals(uuid, activityCourse.getUuid()) ||
				(groupId != activityCourse.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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

				List<ActivityCourse> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ActivityCourse activityCourse = list.get(0);

					result = activityCourse;

					cacheResult(activityCourse);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

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
			return (ActivityCourse)result;
		}
	}

	/**
	 * Removes the activity course where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity course that was removed
	 */
	@Override
	public ActivityCourse removeByUUID_G(String uuid, long groupId)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = findByUUID_G(uuid, groupId);

		return remove(activityCourse);
	}

	/**
	 * Returns the number of activity courses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity courses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYCOURSE_WHERE);

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
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"activityCourse.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(activityCourse.uuid IS NULL OR activityCourse.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"activityCourse.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
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

		List<ActivityCourse> list = null;

		if (useFinderCache) {
			list = (List<ActivityCourse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCourse activityCourse : list) {
					if (!uuid.equals(activityCourse.getUuid()) ||
						(companyId != activityCourse.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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
				sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityCourse>)QueryUtil.list(
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
	 * Returns the first activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityCourse> orderByComparator) {

		List<ActivityCourse> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityCourse> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ActivityCourse> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse[] findByUuid_C_PrevAndNext(
			long activityCourseId, String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		uuid = Objects.toString(uuid, "");

		ActivityCourse activityCourse = findByPrimaryKey(activityCourseId);

		Session session = null;

		try {
			session = openSession();

			ActivityCourse[] array = new ActivityCourseImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, activityCourse, uuid, companyId, orderByComparator,
				true);

			array[1] = activityCourse;

			array[2] = getByUuid_C_PrevAndNext(
				session, activityCourse, uuid, companyId, orderByComparator,
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

	protected ActivityCourse getByUuid_C_PrevAndNext(
		Session session, ActivityCourse activityCourse, String uuid,
		long companyId, OrderByComparator<ActivityCourse> orderByComparator,
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

		sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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
			sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
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
						activityCourse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCourse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity courses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ActivityCourse activityCourse :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(activityCourse);
		}
	}

	/**
	 * Returns the number of activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity courses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYCOURSE_WHERE);

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
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"activityCourse.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(activityCourse.uuid IS NULL OR activityCourse.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"activityCourse.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByActivity;
	private FinderPath _finderPathWithoutPaginationFindByActivity;
	private FinderPath _finderPathCountByActivity;

	/**
	 * Returns all the activity courses where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByActivity(long activityId) {
		return findByActivity(
			activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByActivity(
		long activityId, int start, int end) {

		return findByActivity(activityId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return findByActivity(activityId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByActivity;
				finderArgs = new Object[] {activityId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByActivity;
			finderArgs = new Object[] {
				activityId, start, end, orderByComparator
			};
		}

		List<ActivityCourse> list = null;

		if (useFinderCache) {
			list = (List<ActivityCourse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCourse activityCourse : list) {
					if (activityId != activityCourse.getActivityId()) {
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

			sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITY_ACTIVITYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityId);

				list = (List<ActivityCourse>)QueryUtil.list(
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
	 * Returns the first activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByActivity_First(
			long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByActivity_First(
			activityId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityId=");
		sb.append(activityId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the first activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByActivity_First(
		long activityId, OrderByComparator<ActivityCourse> orderByComparator) {

		List<ActivityCourse> list = findByActivity(
			activityId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByActivity_Last(
			long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByActivity_Last(
			activityId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("activityId=");
		sb.append(activityId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the last activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByActivity_Last(
		long activityId, OrderByComparator<ActivityCourse> orderByComparator) {

		int count = countByActivity(activityId);

		if (count == 0) {
			return null;
		}

		List<ActivityCourse> list = findByActivity(
			activityId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse[] findByActivity_PrevAndNext(
			long activityCourseId, long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = findByPrimaryKey(activityCourseId);

		Session session = null;

		try {
			session = openSession();

			ActivityCourse[] array = new ActivityCourseImpl[3];

			array[0] = getByActivity_PrevAndNext(
				session, activityCourse, activityId, orderByComparator, true);

			array[1] = activityCourse;

			array[2] = getByActivity_PrevAndNext(
				session, activityCourse, activityId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCourse getByActivity_PrevAndNext(
		Session session, ActivityCourse activityCourse, long activityId,
		OrderByComparator<ActivityCourse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

		sb.append(_FINDER_COLUMN_ACTIVITY_ACTIVITYID_2);

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
			sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(activityId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						activityCourse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCourse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity courses where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	@Override
	public void removeByActivity(long activityId) {
		for (ActivityCourse activityCourse :
				findByActivity(
					activityId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCourse);
		}
	}

	/**
	 * Returns the number of activity courses where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activity courses
	 */
	@Override
	public int countByActivity(long activityId) {
		FinderPath finderPath = _finderPathCountByActivity;

		Object[] finderArgs = new Object[] {activityId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSE_WHERE);

			sb.append(_FINDER_COLUMN_ACTIVITY_ACTIVITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(activityId);

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

	private static final String _FINDER_COLUMN_ACTIVITY_ACTIVITYID_2 =
		"activityCourse.activityId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the activity courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	@Override
	public List<ActivityCourse> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
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

		List<ActivityCourse> list = null;

		if (useFinderCache) {
			list = (List<ActivityCourse>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityCourse activityCourse : list) {
					if (groupId != activityCourse.getGroupId()) {
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

			sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ActivityCourse>)QueryUtil.list(
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
	 * Returns the first activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByGroupId_First(
			long groupId, OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByGroupId_First(
			groupId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the first activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByGroupId_First(
		long groupId, OrderByComparator<ActivityCourse> orderByComparator) {

		List<ActivityCourse> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse findByGroupId_Last(
			long groupId, OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (activityCourse != null) {
			return activityCourse;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityCourseException(sb.toString());
	}

	/**
	 * Returns the last activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	@Override
	public ActivityCourse fetchByGroupId_Last(
		long groupId, OrderByComparator<ActivityCourse> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ActivityCourse> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where groupId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse[] findByGroupId_PrevAndNext(
			long activityCourseId, long groupId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = findByPrimaryKey(activityCourseId);

		Session session = null;

		try {
			session = openSession();

			ActivityCourse[] array = new ActivityCourseImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, activityCourse, groupId, orderByComparator, true);

			array[1] = activityCourse;

			array[2] = getByGroupId_PrevAndNext(
				session, activityCourse, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityCourse getByGroupId_PrevAndNext(
		Session session, ActivityCourse activityCourse, long groupId,
		OrderByComparator<ActivityCourse> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE);

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
			sb.append(ActivityCourseModelImpl.ORDER_BY_JPQL);
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
						activityCourse)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityCourse> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity courses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ActivityCourse activityCourse :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityCourse);
		}
	}

	/**
	 * Returns the number of activity courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity courses
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYCOURSE_WHERE);

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
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"activityCourse.groupId = ?";

	public ActivityCoursePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

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

		setModelClass(ActivityCourse.class);
	}

	/**
	 * Caches the activity course in the entity cache if it is enabled.
	 *
	 * @param activityCourse the activity course
	 */
	@Override
	public void cacheResult(ActivityCourse activityCourse) {
		entityCache.putResult(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseImpl.class, activityCourse.getPrimaryKey(),
			activityCourse);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				activityCourse.getUuid(), activityCourse.getGroupId()
			},
			activityCourse);

		activityCourse.resetOriginalValues();
	}

	/**
	 * Caches the activity courses in the entity cache if it is enabled.
	 *
	 * @param activityCourses the activity courses
	 */
	@Override
	public void cacheResult(List<ActivityCourse> activityCourses) {
		for (ActivityCourse activityCourse : activityCourses) {
			if (entityCache.getResult(
					ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
					ActivityCourseImpl.class, activityCourse.getPrimaryKey()) ==
						null) {

				cacheResult(activityCourse);
			}
			else {
				activityCourse.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activity courses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityCourseImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity course.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityCourse activityCourse) {
		entityCache.removeResult(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseImpl.class, activityCourse.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ActivityCourseModelImpl)activityCourse, true);
	}

	@Override
	public void clearCache(List<ActivityCourse> activityCourses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActivityCourse activityCourse : activityCourses) {
			entityCache.removeResult(
				ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
				ActivityCourseImpl.class, activityCourse.getPrimaryKey());

			clearUniqueFindersCache(
				(ActivityCourseModelImpl)activityCourse, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
				ActivityCourseImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ActivityCourseModelImpl activityCourseModelImpl) {

		Object[] args = new Object[] {
			activityCourseModelImpl.getUuid(),
			activityCourseModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, activityCourseModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ActivityCourseModelImpl activityCourseModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				activityCourseModelImpl.getUuid(),
				activityCourseModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((activityCourseModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				activityCourseModelImpl.getOriginalUuid(),
				activityCourseModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new activity course with the primary key. Does not add the activity course to the database.
	 *
	 * @param activityCourseId the primary key for the new activity course
	 * @return the new activity course
	 */
	@Override
	public ActivityCourse create(long activityCourseId) {
		ActivityCourse activityCourse = new ActivityCourseImpl();

		activityCourse.setNew(true);
		activityCourse.setPrimaryKey(activityCourseId);

		String uuid = PortalUUIDUtil.generate();

		activityCourse.setUuid(uuid);

		activityCourse.setCompanyId(CompanyThreadLocal.getCompanyId());

		return activityCourse;
	}

	/**
	 * Removes the activity course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course that was removed
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse remove(long activityCourseId)
		throws NoSuchActivityCourseException {

		return remove((Serializable)activityCourseId);
	}

	/**
	 * Removes the activity course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity course
	 * @return the activity course that was removed
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse remove(Serializable primaryKey)
		throws NoSuchActivityCourseException {

		Session session = null;

		try {
			session = openSession();

			ActivityCourse activityCourse = (ActivityCourse)session.get(
				ActivityCourseImpl.class, primaryKey);

			if (activityCourse == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityCourseException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(activityCourse);
		}
		catch (NoSuchActivityCourseException noSuchEntityException) {
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
	protected ActivityCourse removeImpl(ActivityCourse activityCourse) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityCourse)) {
				activityCourse = (ActivityCourse)session.get(
					ActivityCourseImpl.class,
					activityCourse.getPrimaryKeyObj());
			}

			if (activityCourse != null) {
				session.delete(activityCourse);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (activityCourse != null) {
			clearCache(activityCourse);
		}

		return activityCourse;
	}

	@Override
	public ActivityCourse updateImpl(ActivityCourse activityCourse) {
		boolean isNew = activityCourse.isNew();

		if (!(activityCourse instanceof ActivityCourseModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activityCourse.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					activityCourse);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activityCourse proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ActivityCourse implementation " +
					activityCourse.getClass());
		}

		ActivityCourseModelImpl activityCourseModelImpl =
			(ActivityCourseModelImpl)activityCourse;

		if (Validator.isNull(activityCourse.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			activityCourse.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (activityCourse.getCreateDate() == null)) {
			if (serviceContext == null) {
				activityCourse.setCreateDate(now);
			}
			else {
				activityCourse.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!activityCourseModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				activityCourse.setModifiedDate(now);
			}
			else {
				activityCourse.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (activityCourse.isNew()) {
				session.save(activityCourse);

				activityCourse.setNew(false);
			}
			else {
				activityCourse = (ActivityCourse)session.merge(activityCourse);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!ActivityCourseModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {activityCourseModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				activityCourseModelImpl.getUuid(),
				activityCourseModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {activityCourseModelImpl.getActivityId()};

			finderCache.removeResult(_finderPathCountByActivity, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByActivity, args);

			args = new Object[] {activityCourseModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((activityCourseModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					activityCourseModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {activityCourseModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((activityCourseModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					activityCourseModelImpl.getOriginalUuid(),
					activityCourseModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					activityCourseModelImpl.getUuid(),
					activityCourseModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((activityCourseModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByActivity.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					activityCourseModelImpl.getOriginalActivityId()
				};

				finderCache.removeResult(_finderPathCountByActivity, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActivity, args);

				args = new Object[] {activityCourseModelImpl.getActivityId()};

				finderCache.removeResult(_finderPathCountByActivity, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByActivity, args);
			}

			if ((activityCourseModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					activityCourseModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {activityCourseModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}
		}

		entityCache.putResult(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseImpl.class, activityCourse.getPrimaryKey(),
			activityCourse, false);

		clearUniqueFindersCache(activityCourseModelImpl, false);
		cacheUniqueFindersCache(activityCourseModelImpl);

		activityCourse.resetOriginalValues();

		return activityCourse;
	}

	/**
	 * Returns the activity course with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity course
	 * @return the activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityCourseException {

		ActivityCourse activityCourse = fetchByPrimaryKey(primaryKey);

		if (activityCourse == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityCourseException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return activityCourse;
	}

	/**
	 * Returns the activity course with the primary key or throws a <code>NoSuchActivityCourseException</code> if it could not be found.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse findByPrimaryKey(long activityCourseId)
		throws NoSuchActivityCourseException {

		return findByPrimaryKey((Serializable)activityCourseId);
	}

	/**
	 * Returns the activity course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity course
	 * @return the activity course, or <code>null</code> if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ActivityCourse activityCourse = (ActivityCourse)serializable;

		if (activityCourse == null) {
			Session session = null;

			try {
				session = openSession();

				activityCourse = (ActivityCourse)session.get(
					ActivityCourseImpl.class, primaryKey);

				if (activityCourse != null) {
					cacheResult(activityCourse);
				}
				else {
					entityCache.putResult(
						ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
						ActivityCourseImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
					ActivityCourseImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return activityCourse;
	}

	/**
	 * Returns the activity course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course, or <code>null</code> if a activity course with the primary key could not be found
	 */
	@Override
	public ActivityCourse fetchByPrimaryKey(long activityCourseId) {
		return fetchByPrimaryKey((Serializable)activityCourseId);
	}

	@Override
	public Map<Serializable, ActivityCourse> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ActivityCourse> map =
			new HashMap<Serializable, ActivityCourse>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ActivityCourse activityCourse = fetchByPrimaryKey(primaryKey);

			if (activityCourse != null) {
				map.put(primaryKey, activityCourse);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
				ActivityCourseImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ActivityCourse)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_ACTIVITYCOURSE_WHERE_PKS_IN);

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

			for (ActivityCourse activityCourse :
					(List<ActivityCourse>)query.list()) {

				map.put(activityCourse.getPrimaryKeyObj(), activityCourse);

				cacheResult(activityCourse);

				uncachedPrimaryKeys.remove(activityCourse.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
					ActivityCourseImpl.class, primaryKey, nullModel);
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
	 * Returns all the activity courses.
	 *
	 * @return the activity courses
	 */
	@Override
	public List<ActivityCourse> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of activity courses
	 */
	@Override
	public List<ActivityCourse> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity courses
	 */
	@Override
	public List<ActivityCourse> findAll(
		int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity courses
	 */
	@Override
	public List<ActivityCourse> findAll(
		int start, int end, OrderByComparator<ActivityCourse> orderByComparator,
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

		List<ActivityCourse> list = null;

		if (useFinderCache) {
			list = (List<ActivityCourse>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTIVITYCOURSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYCOURSE;

				sql = sql.concat(ActivityCourseModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ActivityCourse>)QueryUtil.list(
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
	 * Removes all the activity courses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ActivityCourse activityCourse : findAll()) {
			remove(activityCourse);
		}
	}

	/**
	 * Returns the number of activity courses.
	 *
	 * @return the number of activity courses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACTIVITYCOURSE);

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
		return ActivityCourseModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity course persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			ActivityCourseModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ActivityCourseModelImpl.UUID_COLUMN_BITMASK |
			ActivityCourseModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ActivityCourseModelImpl.UUID_COLUMN_BITMASK |
			ActivityCourseModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByActivity = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByActivity",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByActivity = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByActivity", new String[] {Long.class.getName()},
			ActivityCourseModelImpl.ACTIVITYID_COLUMN_BITMASK);

		_finderPathCountByActivity = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByActivity",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED,
			ActivityCourseImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupId", new String[] {Long.class.getName()},
			ActivityCourseModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			ActivityCourseModelImpl.ENTITY_CACHE_ENABLED,
			ActivityCourseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(ActivityCourseImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACTIVITYCOURSE =
		"SELECT activityCourse FROM ActivityCourse activityCourse";

	private static final String _SQL_SELECT_ACTIVITYCOURSE_WHERE_PKS_IN =
		"SELECT activityCourse FROM ActivityCourse activityCourse WHERE activityCourseId IN (";

	private static final String _SQL_SELECT_ACTIVITYCOURSE_WHERE =
		"SELECT activityCourse FROM ActivityCourse activityCourse WHERE ";

	private static final String _SQL_COUNT_ACTIVITYCOURSE =
		"SELECT COUNT(activityCourse) FROM ActivityCourse activityCourse";

	private static final String _SQL_COUNT_ACTIVITYCOURSE_WHERE =
		"SELECT COUNT(activityCourse) FROM ActivityCourse activityCourse WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "activityCourse.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ActivityCourse exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ActivityCourse exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityCoursePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}