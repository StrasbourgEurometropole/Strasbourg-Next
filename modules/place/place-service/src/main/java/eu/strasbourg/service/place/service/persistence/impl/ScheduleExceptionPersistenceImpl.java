/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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

import eu.strasbourg.service.place.exception.NoSuchScheduleExceptionException;
import eu.strasbourg.service.place.model.ScheduleException;
import eu.strasbourg.service.place.model.ScheduleExceptionTable;
import eu.strasbourg.service.place.model.impl.ScheduleExceptionImpl;
import eu.strasbourg.service.place.model.impl.ScheduleExceptionModelImpl;
import eu.strasbourg.service.place.service.persistence.ScheduleExceptionPersistence;
import eu.strasbourg.service.place.service.persistence.ScheduleExceptionUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the schedule exception service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class ScheduleExceptionPersistenceImpl
	extends BasePersistenceImpl<ScheduleException>
	implements ScheduleExceptionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ScheduleExceptionUtil</code> to access the schedule exception persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ScheduleExceptionImpl.class.getName();

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
	 * Returns all the schedule exceptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedule exceptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator,
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

		List<ScheduleException> list = null;

		if (useFinderCache) {
			list = (List<ScheduleException>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduleException scheduleException : list) {
					if (!uuid.equals(scheduleException.getUuid())) {
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

			sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

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
				sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
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

				list = (List<ScheduleException>)QueryUtil.list(
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
	 * Returns the first schedule exception in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findByUuid_First(
			String uuid, OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchByUuid_First(
			uuid, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the first schedule exception in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchByUuid_First(
		String uuid, OrderByComparator<ScheduleException> orderByComparator) {

		List<ScheduleException> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedule exception in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findByUuid_Last(
			String uuid, OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchByUuid_Last(
			uuid, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the last schedule exception in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchByUuid_Last(
		String uuid, OrderByComparator<ScheduleException> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ScheduleException> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedule exceptions before and after the current schedule exception in the ordered set where uuid = &#63;.
	 *
	 * @param exceptionId the primary key of the current schedule exception
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedule exception
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException[] findByUuid_PrevAndNext(
			long exceptionId, String uuid,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		uuid = Objects.toString(uuid, "");

		ScheduleException scheduleException = findByPrimaryKey(exceptionId);

		Session session = null;

		try {
			session = openSession();

			ScheduleException[] array = new ScheduleExceptionImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, scheduleException, uuid, orderByComparator, true);

			array[1] = scheduleException;

			array[2] = getByUuid_PrevAndNext(
				session, scheduleException, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScheduleException getByUuid_PrevAndNext(
		Session session, ScheduleException scheduleException, String uuid,
		OrderByComparator<ScheduleException> orderByComparator,
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

		sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

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
			sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
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
						scheduleException)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduleException> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedule exceptions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ScheduleException scheduleException :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(scheduleException);
		}
	}

	/**
	 * Returns the number of schedule exceptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching schedule exceptions
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEEXCEPTION_WHERE);

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
		"scheduleException.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(scheduleException.uuid IS NULL OR scheduleException.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByPlaceId;
	private FinderPath _finderPathWithoutPaginationFindByPlaceId;
	private FinderPath _finderPathCountByPlaceId;

	/**
	 * Returns all the schedule exceptions where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByPlaceId(long placeId) {
		return findByPlaceId(
			placeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedule exceptions where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByPlaceId(
		long placeId, int start, int end) {

		return findByPlaceId(placeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByPlaceId(
		long placeId, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator) {

		return findByPlaceId(placeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findByPlaceId(
		long placeId, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPlaceId;
				finderArgs = new Object[] {placeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPlaceId;
			finderArgs = new Object[] {placeId, start, end, orderByComparator};
		}

		List<ScheduleException> list = null;

		if (useFinderCache) {
			list = (List<ScheduleException>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduleException scheduleException : list) {
					if (placeId != scheduleException.getPlaceId()) {
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

			sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

			sb.append(_FINDER_COLUMN_PLACEID_PLACEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(placeId);

				list = (List<ScheduleException>)QueryUtil.list(
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
	 * Returns the first schedule exception in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findByPlaceId_First(
			long placeId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchByPlaceId_First(
			placeId, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeId=");
		sb.append(placeId);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the first schedule exception in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchByPlaceId_First(
		long placeId, OrderByComparator<ScheduleException> orderByComparator) {

		List<ScheduleException> list = findByPlaceId(
			placeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedule exception in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findByPlaceId_Last(
			long placeId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchByPlaceId_Last(
			placeId, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeId=");
		sb.append(placeId);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the last schedule exception in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchByPlaceId_Last(
		long placeId, OrderByComparator<ScheduleException> orderByComparator) {

		int count = countByPlaceId(placeId);

		if (count == 0) {
			return null;
		}

		List<ScheduleException> list = findByPlaceId(
			placeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedule exceptions before and after the current schedule exception in the ordered set where placeId = &#63;.
	 *
	 * @param exceptionId the primary key of the current schedule exception
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedule exception
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException[] findByPlaceId_PrevAndNext(
			long exceptionId, long placeId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = findByPrimaryKey(exceptionId);

		Session session = null;

		try {
			session = openSession();

			ScheduleException[] array = new ScheduleExceptionImpl[3];

			array[0] = getByPlaceId_PrevAndNext(
				session, scheduleException, placeId, orderByComparator, true);

			array[1] = scheduleException;

			array[2] = getByPlaceId_PrevAndNext(
				session, scheduleException, placeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ScheduleException getByPlaceId_PrevAndNext(
		Session session, ScheduleException scheduleException, long placeId,
		OrderByComparator<ScheduleException> orderByComparator,
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

		sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

		sb.append(_FINDER_COLUMN_PLACEID_PLACEID_2);

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
			sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(placeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						scheduleException)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduleException> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedule exceptions where placeId = &#63; from the database.
	 *
	 * @param placeId the place ID
	 */
	@Override
	public void removeByPlaceId(long placeId) {
		for (ScheduleException scheduleException :
				findByPlaceId(
					placeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(scheduleException);
		}
	}

	/**
	 * Returns the number of schedule exceptions where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the number of matching schedule exceptions
	 */
	@Override
	public int countByPlaceId(long placeId) {
		FinderPath finderPath = _finderPathCountByPlaceId;

		Object[] finderArgs = new Object[] {placeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEEXCEPTION_WHERE);

			sb.append(_FINDER_COLUMN_PLACEID_PLACEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(placeId);

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

	private static final String _FINDER_COLUMN_PLACEID_PLACEID_2 =
		"scheduleException.placeId = ?";

	private FinderPath _finderPathWithPaginationFindBySubPlaceId;
	private FinderPath _finderPathWithoutPaginationFindBySubPlaceId;
	private FinderPath _finderPathCountBySubPlaceId;

	/**
	 * Returns all the schedule exceptions where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findBySubPlaceId(long subPlaceId) {
		return findBySubPlaceId(
			subPlaceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedule exceptions where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findBySubPlaceId(
		long subPlaceId, int start, int end) {

		return findBySubPlaceId(subPlaceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findBySubPlaceId(
		long subPlaceId, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator) {

		return findBySubPlaceId(
			subPlaceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching schedule exceptions
	 */
	@Override
	public List<ScheduleException> findBySubPlaceId(
		long subPlaceId, int start, int end,
		OrderByComparator<ScheduleException> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySubPlaceId;
				finderArgs = new Object[] {subPlaceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySubPlaceId;
			finderArgs = new Object[] {
				subPlaceId, start, end, orderByComparator
			};
		}

		List<ScheduleException> list = null;

		if (useFinderCache) {
			list = (List<ScheduleException>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ScheduleException scheduleException : list) {
					if (subPlaceId != scheduleException.getSubPlaceId()) {
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

			sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

			sb.append(_FINDER_COLUMN_SUBPLACEID_SUBPLACEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subPlaceId);

				list = (List<ScheduleException>)QueryUtil.list(
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
	 * Returns the first schedule exception in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findBySubPlaceId_First(
			long subPlaceId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchBySubPlaceId_First(
			subPlaceId, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subPlaceId=");
		sb.append(subPlaceId);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the first schedule exception in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchBySubPlaceId_First(
		long subPlaceId,
		OrderByComparator<ScheduleException> orderByComparator) {

		List<ScheduleException> list = findBySubPlaceId(
			subPlaceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last schedule exception in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception
	 * @throws NoSuchScheduleExceptionException if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException findBySubPlaceId_Last(
			long subPlaceId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchBySubPlaceId_Last(
			subPlaceId, orderByComparator);

		if (scheduleException != null) {
			return scheduleException;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subPlaceId=");
		sb.append(subPlaceId);

		sb.append("}");

		throw new NoSuchScheduleExceptionException(sb.toString());
	}

	/**
	 * Returns the last schedule exception in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching schedule exception, or <code>null</code> if a matching schedule exception could not be found
	 */
	@Override
	public ScheduleException fetchBySubPlaceId_Last(
		long subPlaceId,
		OrderByComparator<ScheduleException> orderByComparator) {

		int count = countBySubPlaceId(subPlaceId);

		if (count == 0) {
			return null;
		}

		List<ScheduleException> list = findBySubPlaceId(
			subPlaceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the schedule exceptions before and after the current schedule exception in the ordered set where subPlaceId = &#63;.
	 *
	 * @param exceptionId the primary key of the current schedule exception
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next schedule exception
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException[] findBySubPlaceId_PrevAndNext(
			long exceptionId, long subPlaceId,
			OrderByComparator<ScheduleException> orderByComparator)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = findByPrimaryKey(exceptionId);

		Session session = null;

		try {
			session = openSession();

			ScheduleException[] array = new ScheduleExceptionImpl[3];

			array[0] = getBySubPlaceId_PrevAndNext(
				session, scheduleException, subPlaceId, orderByComparator,
				true);

			array[1] = scheduleException;

			array[2] = getBySubPlaceId_PrevAndNext(
				session, scheduleException, subPlaceId, orderByComparator,
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

	protected ScheduleException getBySubPlaceId_PrevAndNext(
		Session session, ScheduleException scheduleException, long subPlaceId,
		OrderByComparator<ScheduleException> orderByComparator,
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

		sb.append(_SQL_SELECT_SCHEDULEEXCEPTION_WHERE);

		sb.append(_FINDER_COLUMN_SUBPLACEID_SUBPLACEID_2);

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
			sb.append(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subPlaceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						scheduleException)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ScheduleException> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the schedule exceptions where subPlaceId = &#63; from the database.
	 *
	 * @param subPlaceId the sub place ID
	 */
	@Override
	public void removeBySubPlaceId(long subPlaceId) {
		for (ScheduleException scheduleException :
				findBySubPlaceId(
					subPlaceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(scheduleException);
		}
	}

	/**
	 * Returns the number of schedule exceptions where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the number of matching schedule exceptions
	 */
	@Override
	public int countBySubPlaceId(long subPlaceId) {
		FinderPath finderPath = _finderPathCountBySubPlaceId;

		Object[] finderArgs = new Object[] {subPlaceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SCHEDULEEXCEPTION_WHERE);

			sb.append(_FINDER_COLUMN_SUBPLACEID_SUBPLACEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subPlaceId);

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

	private static final String _FINDER_COLUMN_SUBPLACEID_SUBPLACEID_2 =
		"scheduleException.subPlaceId = ?";

	public ScheduleExceptionPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ScheduleException.class);

		setModelImplClass(ScheduleExceptionImpl.class);
		setModelPKClass(long.class);

		setTable(ScheduleExceptionTable.INSTANCE);
	}

	/**
	 * Caches the schedule exception in the entity cache if it is enabled.
	 *
	 * @param scheduleException the schedule exception
	 */
	@Override
	public void cacheResult(ScheduleException scheduleException) {
		entityCache.putResult(
			ScheduleExceptionImpl.class, scheduleException.getPrimaryKey(),
			scheduleException);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the schedule exceptions in the entity cache if it is enabled.
	 *
	 * @param scheduleExceptions the schedule exceptions
	 */
	@Override
	public void cacheResult(List<ScheduleException> scheduleExceptions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (scheduleExceptions.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ScheduleException scheduleException : scheduleExceptions) {
			if (entityCache.getResult(
					ScheduleExceptionImpl.class,
					scheduleException.getPrimaryKey()) == null) {

				cacheResult(scheduleException);
			}
		}
	}

	/**
	 * Clears the cache for all schedule exceptions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ScheduleExceptionImpl.class);

		finderCache.clearCache(ScheduleExceptionImpl.class);
	}

	/**
	 * Clears the cache for the schedule exception.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ScheduleException scheduleException) {
		entityCache.removeResult(
			ScheduleExceptionImpl.class, scheduleException);
	}

	@Override
	public void clearCache(List<ScheduleException> scheduleExceptions) {
		for (ScheduleException scheduleException : scheduleExceptions) {
			entityCache.removeResult(
				ScheduleExceptionImpl.class, scheduleException);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ScheduleExceptionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ScheduleExceptionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new schedule exception with the primary key. Does not add the schedule exception to the database.
	 *
	 * @param exceptionId the primary key for the new schedule exception
	 * @return the new schedule exception
	 */
	@Override
	public ScheduleException create(long exceptionId) {
		ScheduleException scheduleException = new ScheduleExceptionImpl();

		scheduleException.setNew(true);
		scheduleException.setPrimaryKey(exceptionId);

		String uuid = PortalUUIDUtil.generate();

		scheduleException.setUuid(uuid);

		return scheduleException;
	}

	/**
	 * Removes the schedule exception with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception that was removed
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException remove(long exceptionId)
		throws NoSuchScheduleExceptionException {

		return remove((Serializable)exceptionId);
	}

	/**
	 * Removes the schedule exception with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the schedule exception
	 * @return the schedule exception that was removed
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException remove(Serializable primaryKey)
		throws NoSuchScheduleExceptionException {

		Session session = null;

		try {
			session = openSession();

			ScheduleException scheduleException =
				(ScheduleException)session.get(
					ScheduleExceptionImpl.class, primaryKey);

			if (scheduleException == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchScheduleExceptionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(scheduleException);
		}
		catch (NoSuchScheduleExceptionException noSuchEntityException) {
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
	protected ScheduleException removeImpl(
		ScheduleException scheduleException) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(scheduleException)) {
				scheduleException = (ScheduleException)session.get(
					ScheduleExceptionImpl.class,
					scheduleException.getPrimaryKeyObj());
			}

			if (scheduleException != null) {
				session.delete(scheduleException);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (scheduleException != null) {
			clearCache(scheduleException);
		}

		return scheduleException;
	}

	@Override
	public ScheduleException updateImpl(ScheduleException scheduleException) {
		boolean isNew = scheduleException.isNew();

		if (!(scheduleException instanceof ScheduleExceptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(scheduleException.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					scheduleException);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in scheduleException proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ScheduleException implementation " +
					scheduleException.getClass());
		}

		ScheduleExceptionModelImpl scheduleExceptionModelImpl =
			(ScheduleExceptionModelImpl)scheduleException;

		if (Validator.isNull(scheduleException.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			scheduleException.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(scheduleException);
			}
			else {
				scheduleException = (ScheduleException)session.merge(
					scheduleException);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ScheduleExceptionImpl.class, scheduleExceptionModelImpl, false,
			true);

		if (isNew) {
			scheduleException.setNew(false);
		}

		scheduleException.resetOriginalValues();

		return scheduleException;
	}

	/**
	 * Returns the schedule exception with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the schedule exception
	 * @return the schedule exception
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException findByPrimaryKey(Serializable primaryKey)
		throws NoSuchScheduleExceptionException {

		ScheduleException scheduleException = fetchByPrimaryKey(primaryKey);

		if (scheduleException == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchScheduleExceptionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return scheduleException;
	}

	/**
	 * Returns the schedule exception with the primary key or throws a <code>NoSuchScheduleExceptionException</code> if it could not be found.
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception
	 * @throws NoSuchScheduleExceptionException if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException findByPrimaryKey(long exceptionId)
		throws NoSuchScheduleExceptionException {

		return findByPrimaryKey((Serializable)exceptionId);
	}

	/**
	 * Returns the schedule exception with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param exceptionId the primary key of the schedule exception
	 * @return the schedule exception, or <code>null</code> if a schedule exception with the primary key could not be found
	 */
	@Override
	public ScheduleException fetchByPrimaryKey(long exceptionId) {
		return fetchByPrimaryKey((Serializable)exceptionId);
	}

	/**
	 * Returns all the schedule exceptions.
	 *
	 * @return the schedule exceptions
	 */
	@Override
	public List<ScheduleException> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the schedule exceptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @return the range of schedule exceptions
	 */
	@Override
	public List<ScheduleException> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of schedule exceptions
	 */
	@Override
	public List<ScheduleException> findAll(
		int start, int end,
		OrderByComparator<ScheduleException> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the schedule exceptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ScheduleExceptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of schedule exceptions
	 * @param end the upper bound of the range of schedule exceptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of schedule exceptions
	 */
	@Override
	public List<ScheduleException> findAll(
		int start, int end,
		OrderByComparator<ScheduleException> orderByComparator,
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

		List<ScheduleException> list = null;

		if (useFinderCache) {
			list = (List<ScheduleException>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SCHEDULEEXCEPTION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SCHEDULEEXCEPTION;

				sql = sql.concat(ScheduleExceptionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ScheduleException>)QueryUtil.list(
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
	 * Removes all the schedule exceptions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ScheduleException scheduleException : findAll()) {
			remove(scheduleException);
		}
	}

	/**
	 * Returns the number of schedule exceptions.
	 *
	 * @return the number of schedule exceptions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SCHEDULEEXCEPTION);

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
		return "exceptionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SCHEDULEEXCEPTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ScheduleExceptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the schedule exception persistence.
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

		_finderPathWithPaginationFindByPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPlaceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"placeId"}, true);

		_finderPathWithoutPaginationFindByPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPlaceId",
			new String[] {Long.class.getName()}, new String[] {"placeId"},
			true);

		_finderPathCountByPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPlaceId",
			new String[] {Long.class.getName()}, new String[] {"placeId"},
			false);

		_finderPathWithPaginationFindBySubPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubPlaceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subPlaceId"}, true);

		_finderPathWithoutPaginationFindBySubPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubPlaceId",
			new String[] {Long.class.getName()}, new String[] {"subPlaceId"},
			true);

		_finderPathCountBySubPlaceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubPlaceId",
			new String[] {Long.class.getName()}, new String[] {"subPlaceId"},
			false);

		ScheduleExceptionUtil.setPersistence(this);
	}

	public void destroy() {
		ScheduleExceptionUtil.setPersistence(null);

		entityCache.removeCache(ScheduleExceptionImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SCHEDULEEXCEPTION =
		"SELECT scheduleException FROM ScheduleException scheduleException";

	private static final String _SQL_SELECT_SCHEDULEEXCEPTION_WHERE =
		"SELECT scheduleException FROM ScheduleException scheduleException WHERE ";

	private static final String _SQL_COUNT_SCHEDULEEXCEPTION =
		"SELECT COUNT(scheduleException) FROM ScheduleException scheduleException";

	private static final String _SQL_COUNT_SCHEDULEEXCEPTION_WHERE =
		"SELECT COUNT(scheduleException) FROM ScheduleException scheduleException WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "scheduleException.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ScheduleException exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ScheduleException exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ScheduleExceptionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}