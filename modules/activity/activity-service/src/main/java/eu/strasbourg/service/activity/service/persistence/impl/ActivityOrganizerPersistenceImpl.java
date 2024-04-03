/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.activity.exception.NoSuchActivityOrganizerException;
import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.service.activity.model.ActivityOrganizerTable;
import eu.strasbourg.service.activity.model.impl.ActivityOrganizerImpl;
import eu.strasbourg.service.activity.model.impl.ActivityOrganizerModelImpl;
import eu.strasbourg.service.activity.service.persistence.ActivityOrganizerPersistence;
import eu.strasbourg.service.activity.service.persistence.ActivityOrganizerUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the activity organizer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityOrganizerPersistenceImpl
	extends BasePersistenceImpl<ActivityOrganizer>
	implements ActivityOrganizerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActivityOrganizerUtil</code> to access the activity organizer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActivityOrganizerImpl.class.getName();

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
	 * Returns all the activity organizers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity organizers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity organizers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity organizers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		List<ActivityOrganizer> list = null;

		if (useFinderCache) {
			list = (List<ActivityOrganizer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityOrganizer activityOrganizer : list) {
					if (!uuid.equals(activityOrganizer.getUuid())) {
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

			sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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
				sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityOrganizer>)QueryUtil.list(
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
	 * Returns the first activity organizer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByUuid_First(
			String uuid, OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByUuid_First(
			uuid, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the first activity organizer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUuid_First(
		String uuid, OrderByComparator<ActivityOrganizer> orderByComparator) {

		List<ActivityOrganizer> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity organizer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByUuid_Last(
			String uuid, OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByUuid_Last(
			uuid, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the last activity organizer in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUuid_Last(
		String uuid, OrderByComparator<ActivityOrganizer> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ActivityOrganizer> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity organizers before and after the current activity organizer in the ordered set where uuid = &#63;.
	 *
	 * @param activityOrganizerId the primary key of the current activity organizer
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity organizer
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer[] findByUuid_PrevAndNext(
			long activityOrganizerId, String uuid,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		uuid = Objects.toString(uuid, "");

		ActivityOrganizer activityOrganizer = findByPrimaryKey(
			activityOrganizerId);

		Session session = null;

		try {
			session = openSession();

			ActivityOrganizer[] array = new ActivityOrganizerImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, activityOrganizer, uuid, orderByComparator, true);

			array[1] = activityOrganizer;

			array[2] = getByUuid_PrevAndNext(
				session, activityOrganizer, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityOrganizer getByUuid_PrevAndNext(
		Session session, ActivityOrganizer activityOrganizer, String uuid,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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
			sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
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
						activityOrganizer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityOrganizer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity organizers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ActivityOrganizer activityOrganizer :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityOrganizer);
		}
	}

	/**
	 * Returns the number of activity organizers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity organizers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYORGANIZER_WHERE);

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
		"activityOrganizer.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(activityOrganizer.uuid IS NULL OR activityOrganizer.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the activity organizer where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityOrganizerException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByUUID_G(String uuid, long groupId)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByUUID_G(uuid, groupId);

		if (activityOrganizer == null) {
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

			throw new NoSuchActivityOrganizerException(sb.toString());
		}

		return activityOrganizer;
	}

	/**
	 * Returns the activity organizer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the activity organizer where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUUID_G(
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

		if (result instanceof ActivityOrganizer) {
			ActivityOrganizer activityOrganizer = (ActivityOrganizer)result;

			if (!Objects.equals(uuid, activityOrganizer.getUuid()) ||
				(groupId != activityOrganizer.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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

				List<ActivityOrganizer> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ActivityOrganizer activityOrganizer = list.get(0);

					result = activityOrganizer;

					cacheResult(activityOrganizer);
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
			return (ActivityOrganizer)result;
		}
	}

	/**
	 * Removes the activity organizer where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity organizer that was removed
	 */
	@Override
	public ActivityOrganizer removeByUUID_G(String uuid, long groupId)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = findByUUID_G(uuid, groupId);

		return remove(activityOrganizer);
	}

	/**
	 * Returns the number of activity organizers where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity organizers
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYORGANIZER_WHERE);

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
		"activityOrganizer.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(activityOrganizer.uuid IS NULL OR activityOrganizer.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"activityOrganizer.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the activity organizers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity organizers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity organizers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity organizers where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		List<ActivityOrganizer> list = null;

		if (useFinderCache) {
			list = (List<ActivityOrganizer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityOrganizer activityOrganizer : list) {
					if (!uuid.equals(activityOrganizer.getUuid()) ||
						(companyId != activityOrganizer.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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
				sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
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

				list = (List<ActivityOrganizer>)QueryUtil.list(
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
	 * Returns the first activity organizer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the first activity organizer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		List<ActivityOrganizer> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity organizer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the last activity organizer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ActivityOrganizer> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity organizers before and after the current activity organizer in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityOrganizerId the primary key of the current activity organizer
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity organizer
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer[] findByUuid_C_PrevAndNext(
			long activityOrganizerId, String uuid, long companyId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		uuid = Objects.toString(uuid, "");

		ActivityOrganizer activityOrganizer = findByPrimaryKey(
			activityOrganizerId);

		Session session = null;

		try {
			session = openSession();

			ActivityOrganizer[] array = new ActivityOrganizerImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, activityOrganizer, uuid, companyId, orderByComparator,
				true);

			array[1] = activityOrganizer;

			array[2] = getByUuid_C_PrevAndNext(
				session, activityOrganizer, uuid, companyId, orderByComparator,
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

	protected ActivityOrganizer getByUuid_C_PrevAndNext(
		Session session, ActivityOrganizer activityOrganizer, String uuid,
		long companyId, OrderByComparator<ActivityOrganizer> orderByComparator,
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

		sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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
			sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
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
						activityOrganizer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityOrganizer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity organizers where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ActivityOrganizer activityOrganizer :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(activityOrganizer);
		}
	}

	/**
	 * Returns the number of activity organizers where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity organizers
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ACTIVITYORGANIZER_WHERE);

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
		"activityOrganizer.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(activityOrganizer.uuid IS NULL OR activityOrganizer.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"activityOrganizer.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the activity organizers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity organizers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity organizers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity organizers where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		List<ActivityOrganizer> list = null;

		if (useFinderCache) {
			list = (List<ActivityOrganizer>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ActivityOrganizer activityOrganizer : list) {
					if (groupId != activityOrganizer.getGroupId()) {
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

			sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ActivityOrganizer>)QueryUtil.list(
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
	 * Returns the first activity organizer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByGroupId_First(
			long groupId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByGroupId_First(
			groupId, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the first activity organizer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByGroupId_First(
		long groupId, OrderByComparator<ActivityOrganizer> orderByComparator) {

		List<ActivityOrganizer> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity organizer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer
	 * @throws NoSuchActivityOrganizerException if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer findByGroupId_Last(
			long groupId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (activityOrganizer != null) {
			return activityOrganizer;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchActivityOrganizerException(sb.toString());
	}

	/**
	 * Returns the last activity organizer in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity organizer, or <code>null</code> if a matching activity organizer could not be found
	 */
	@Override
	public ActivityOrganizer fetchByGroupId_Last(
		long groupId, OrderByComparator<ActivityOrganizer> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ActivityOrganizer> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity organizers before and after the current activity organizer in the ordered set where groupId = &#63;.
	 *
	 * @param activityOrganizerId the primary key of the current activity organizer
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity organizer
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer[] findByGroupId_PrevAndNext(
			long activityOrganizerId, long groupId,
			OrderByComparator<ActivityOrganizer> orderByComparator)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = findByPrimaryKey(
			activityOrganizerId);

		Session session = null;

		try {
			session = openSession();

			ActivityOrganizer[] array = new ActivityOrganizerImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, activityOrganizer, groupId, orderByComparator, true);

			array[1] = activityOrganizer;

			array[2] = getByGroupId_PrevAndNext(
				session, activityOrganizer, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityOrganizer getByGroupId_PrevAndNext(
		Session session, ActivityOrganizer activityOrganizer, long groupId,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		sb.append(_SQL_SELECT_ACTIVITYORGANIZER_WHERE);

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
			sb.append(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
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
						activityOrganizer)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ActivityOrganizer> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity organizers where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ActivityOrganizer activityOrganizer :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(activityOrganizer);
		}
	}

	/**
	 * Returns the number of activity organizers where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity organizers
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACTIVITYORGANIZER_WHERE);

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
		"activityOrganizer.groupId = ?";

	public ActivityOrganizerPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ActivityOrganizer.class);

		setModelImplClass(ActivityOrganizerImpl.class);
		setModelPKClass(long.class);

		setTable(ActivityOrganizerTable.INSTANCE);
	}

	/**
	 * Caches the activity organizer in the entity cache if it is enabled.
	 *
	 * @param activityOrganizer the activity organizer
	 */
	@Override
	public void cacheResult(ActivityOrganizer activityOrganizer) {
		entityCache.putResult(
			ActivityOrganizerImpl.class, activityOrganizer.getPrimaryKey(),
			activityOrganizer);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				activityOrganizer.getUuid(), activityOrganizer.getGroupId()
			},
			activityOrganizer);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the activity organizers in the entity cache if it is enabled.
	 *
	 * @param activityOrganizers the activity organizers
	 */
	@Override
	public void cacheResult(List<ActivityOrganizer> activityOrganizers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (activityOrganizers.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ActivityOrganizer activityOrganizer : activityOrganizers) {
			if (entityCache.getResult(
					ActivityOrganizerImpl.class,
					activityOrganizer.getPrimaryKey()) == null) {

				cacheResult(activityOrganizer);
			}
		}
	}

	/**
	 * Clears the cache for all activity organizers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActivityOrganizerImpl.class);

		finderCache.clearCache(ActivityOrganizerImpl.class);
	}

	/**
	 * Clears the cache for the activity organizer.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityOrganizer activityOrganizer) {
		entityCache.removeResult(
			ActivityOrganizerImpl.class, activityOrganizer);
	}

	@Override
	public void clearCache(List<ActivityOrganizer> activityOrganizers) {
		for (ActivityOrganizer activityOrganizer : activityOrganizers) {
			entityCache.removeResult(
				ActivityOrganizerImpl.class, activityOrganizer);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ActivityOrganizerImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ActivityOrganizerImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ActivityOrganizerModelImpl activityOrganizerModelImpl) {

		Object[] args = new Object[] {
			activityOrganizerModelImpl.getUuid(),
			activityOrganizerModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, activityOrganizerModelImpl);
	}

	/**
	 * Creates a new activity organizer with the primary key. Does not add the activity organizer to the database.
	 *
	 * @param activityOrganizerId the primary key for the new activity organizer
	 * @return the new activity organizer
	 */
	@Override
	public ActivityOrganizer create(long activityOrganizerId) {
		ActivityOrganizer activityOrganizer = new ActivityOrganizerImpl();

		activityOrganizer.setNew(true);
		activityOrganizer.setPrimaryKey(activityOrganizerId);

		String uuid = PortalUUIDUtil.generate();

		activityOrganizer.setUuid(uuid);

		activityOrganizer.setCompanyId(CompanyThreadLocal.getCompanyId());

		return activityOrganizer;
	}

	/**
	 * Removes the activity organizer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer that was removed
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer remove(long activityOrganizerId)
		throws NoSuchActivityOrganizerException {

		return remove((Serializable)activityOrganizerId);
	}

	/**
	 * Removes the activity organizer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity organizer
	 * @return the activity organizer that was removed
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer remove(Serializable primaryKey)
		throws NoSuchActivityOrganizerException {

		Session session = null;

		try {
			session = openSession();

			ActivityOrganizer activityOrganizer =
				(ActivityOrganizer)session.get(
					ActivityOrganizerImpl.class, primaryKey);

			if (activityOrganizer == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityOrganizerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(activityOrganizer);
		}
		catch (NoSuchActivityOrganizerException noSuchEntityException) {
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
	protected ActivityOrganizer removeImpl(
		ActivityOrganizer activityOrganizer) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityOrganizer)) {
				activityOrganizer = (ActivityOrganizer)session.get(
					ActivityOrganizerImpl.class,
					activityOrganizer.getPrimaryKeyObj());
			}

			if (activityOrganizer != null) {
				session.delete(activityOrganizer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (activityOrganizer != null) {
			clearCache(activityOrganizer);
		}

		return activityOrganizer;
	}

	@Override
	public ActivityOrganizer updateImpl(ActivityOrganizer activityOrganizer) {
		boolean isNew = activityOrganizer.isNew();

		if (!(activityOrganizer instanceof ActivityOrganizerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(activityOrganizer.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					activityOrganizer);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in activityOrganizer proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ActivityOrganizer implementation " +
					activityOrganizer.getClass());
		}

		ActivityOrganizerModelImpl activityOrganizerModelImpl =
			(ActivityOrganizerModelImpl)activityOrganizer;

		if (Validator.isNull(activityOrganizer.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			activityOrganizer.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (activityOrganizer.getCreateDate() == null)) {
			if (serviceContext == null) {
				activityOrganizer.setCreateDate(date);
			}
			else {
				activityOrganizer.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!activityOrganizerModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				activityOrganizer.setModifiedDate(date);
			}
			else {
				activityOrganizer.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(activityOrganizer);
			}
			else {
				activityOrganizer = (ActivityOrganizer)session.merge(
					activityOrganizer);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ActivityOrganizerImpl.class, activityOrganizerModelImpl, false,
			true);

		cacheUniqueFindersCache(activityOrganizerModelImpl);

		if (isNew) {
			activityOrganizer.setNew(false);
		}

		activityOrganizer.resetOriginalValues();

		return activityOrganizer;
	}

	/**
	 * Returns the activity organizer with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity organizer
	 * @return the activity organizer
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityOrganizerException {

		ActivityOrganizer activityOrganizer = fetchByPrimaryKey(primaryKey);

		if (activityOrganizer == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityOrganizerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return activityOrganizer;
	}

	/**
	 * Returns the activity organizer with the primary key or throws a <code>NoSuchActivityOrganizerException</code> if it could not be found.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer
	 * @throws NoSuchActivityOrganizerException if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer findByPrimaryKey(long activityOrganizerId)
		throws NoSuchActivityOrganizerException {

		return findByPrimaryKey((Serializable)activityOrganizerId);
	}

	/**
	 * Returns the activity organizer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityOrganizerId the primary key of the activity organizer
	 * @return the activity organizer, or <code>null</code> if a activity organizer with the primary key could not be found
	 */
	@Override
	public ActivityOrganizer fetchByPrimaryKey(long activityOrganizerId) {
		return fetchByPrimaryKey((Serializable)activityOrganizerId);
	}

	/**
	 * Returns all the activity organizers.
	 *
	 * @return the activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activity organizers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @return the range of activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity organizers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findAll(
		int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the activity organizers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityOrganizerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity organizers
	 * @param end the upper bound of the range of activity organizers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity organizers
	 */
	@Override
	public List<ActivityOrganizer> findAll(
		int start, int end,
		OrderByComparator<ActivityOrganizer> orderByComparator,
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

		List<ActivityOrganizer> list = null;

		if (useFinderCache) {
			list = (List<ActivityOrganizer>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACTIVITYORGANIZER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYORGANIZER;

				sql = sql.concat(ActivityOrganizerModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ActivityOrganizer>)QueryUtil.list(
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
	 * Removes all the activity organizers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ActivityOrganizer activityOrganizer : findAll()) {
			remove(activityOrganizer);
		}
	}

	/**
	 * Returns the number of activity organizers.
	 *
	 * @return the number of activity organizers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ACTIVITYORGANIZER);

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
		return "activityOrganizerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTIVITYORGANIZER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActivityOrganizerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the activity organizer persistence.
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

		ActivityOrganizerUtil.setPersistence(this);
	}

	public void destroy() {
		ActivityOrganizerUtil.setPersistence(null);

		entityCache.removeCache(ActivityOrganizerImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACTIVITYORGANIZER =
		"SELECT activityOrganizer FROM ActivityOrganizer activityOrganizer";

	private static final String _SQL_SELECT_ACTIVITYORGANIZER_WHERE =
		"SELECT activityOrganizer FROM ActivityOrganizer activityOrganizer WHERE ";

	private static final String _SQL_COUNT_ACTIVITYORGANIZER =
		"SELECT COUNT(activityOrganizer) FROM ActivityOrganizer activityOrganizer";

	private static final String _SQL_COUNT_ACTIVITYORGANIZER_WHERE =
		"SELECT COUNT(activityOrganizer) FROM ActivityOrganizer activityOrganizer WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "activityOrganizer.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ActivityOrganizer exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ActivityOrganizer exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActivityOrganizerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}