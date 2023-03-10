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
import eu.strasbourg.service.gtfs.exception.NoSuchCalendarDateException;
import eu.strasbourg.service.gtfs.model.CalendarDate;
import eu.strasbourg.service.gtfs.model.CalendarDateTable;
import eu.strasbourg.service.gtfs.model.impl.CalendarDateImpl;
import eu.strasbourg.service.gtfs.model.impl.CalendarDateModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.CalendarDatePersistence;
import eu.strasbourg.service.gtfs.service.persistence.CalendarDateUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the calendar date service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class CalendarDatePersistenceImpl
	extends BasePersistenceImpl<CalendarDate>
	implements CalendarDatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CalendarDateUtil</code> to access the calendar date persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CalendarDateImpl.class.getName();

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
	 * Returns all the calendar dates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator,
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

		List<CalendarDate> list = null;

		if (useFinderCache) {
			list = (List<CalendarDate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CalendarDate calendarDate : list) {
					if (!uuid.equals(calendarDate.getUuid())) {
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

			sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

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
				sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
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

				list = (List<CalendarDate>)QueryUtil.list(
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
	 * Returns the first calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByUuid_First(
			String uuid, OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByUuid_First(uuid, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the first calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByUuid_First(
		String uuid, OrderByComparator<CalendarDate> orderByComparator) {

		List<CalendarDate> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByUuid_Last(
			String uuid, OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByUuid_Last(uuid, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the last calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByUuid_Last(
		String uuid, OrderByComparator<CalendarDate> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CalendarDate> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		uuid = Objects.toString(uuid, "");

		CalendarDate calendarDate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CalendarDate[] array = new CalendarDateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, calendarDate, uuid, orderByComparator, true);

			array[1] = calendarDate;

			array[2] = getByUuid_PrevAndNext(
				session, calendarDate, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarDate getByUuid_PrevAndNext(
		Session session, CalendarDate calendarDate, String uuid,
		OrderByComparator<CalendarDate> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

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
			sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(calendarDate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CalendarDate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar dates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CalendarDate calendarDate :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(calendarDate);
		}
	}

	/**
	 * Returns the number of calendar dates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching calendar dates
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CALENDARDATE_WHERE);

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
		"calendarDate.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(calendarDate.uuid IS NULL OR calendarDate.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByServiceId;
	private FinderPath _finderPathWithoutPaginationFindByServiceId;
	private FinderPath _finderPathCountByServiceId;

	/**
	 * Returns all the calendar dates where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByServiceId(String service_id) {
		return findByServiceId(
			service_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByServiceId(
		String service_id, int start, int end) {

		return findByServiceId(service_id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByServiceId(
		String service_id, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator) {

		return findByServiceId(service_id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByServiceId(
		String service_id, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator,
		boolean useFinderCache) {

		service_id = Objects.toString(service_id, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServiceId;
				finderArgs = new Object[] {service_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServiceId;
			finderArgs = new Object[] {
				service_id, start, end, orderByComparator
			};
		}

		List<CalendarDate> list = null;

		if (useFinderCache) {
			list = (List<CalendarDate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CalendarDate calendarDate : list) {
					if (!service_id.equals(calendarDate.getService_id())) {
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

			sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

			boolean bindService_id = false;

			if (service_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_3);
			}
			else {
				bindService_id = true;

				sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindService_id) {
					queryPos.add(service_id);
				}

				list = (List<CalendarDate>)QueryUtil.list(
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
	 * Returns the first calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByServiceId_First(
			String service_id,
			OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByServiceId_First(
			service_id, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("service_id=");
		sb.append(service_id);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the first calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByServiceId_First(
		String service_id, OrderByComparator<CalendarDate> orderByComparator) {

		List<CalendarDate> list = findByServiceId(
			service_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByServiceId_Last(
			String service_id,
			OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByServiceId_Last(
			service_id, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("service_id=");
		sb.append(service_id);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the last calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByServiceId_Last(
		String service_id, OrderByComparator<CalendarDate> orderByComparator) {

		int count = countByServiceId(service_id);

		if (count == 0) {
			return null;
		}

		List<CalendarDate> list = findByServiceId(
			service_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate[] findByServiceId_PrevAndNext(
			long id, String service_id,
			OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		service_id = Objects.toString(service_id, "");

		CalendarDate calendarDate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CalendarDate[] array = new CalendarDateImpl[3];

			array[0] = getByServiceId_PrevAndNext(
				session, calendarDate, service_id, orderByComparator, true);

			array[1] = calendarDate;

			array[2] = getByServiceId_PrevAndNext(
				session, calendarDate, service_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarDate getByServiceId_PrevAndNext(
		Session session, CalendarDate calendarDate, String service_id,
		OrderByComparator<CalendarDate> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

		boolean bindService_id = false;

		if (service_id.isEmpty()) {
			sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_3);
		}
		else {
			bindService_id = true;

			sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_2);
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
			sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindService_id) {
			queryPos.add(service_id);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(calendarDate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CalendarDate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar dates where service_id = &#63; from the database.
	 *
	 * @param service_id the service_id
	 */
	@Override
	public void removeByServiceId(String service_id) {
		for (CalendarDate calendarDate :
				findByServiceId(
					service_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(calendarDate);
		}
	}

	/**
	 * Returns the number of calendar dates where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the number of matching calendar dates
	 */
	@Override
	public int countByServiceId(String service_id) {
		service_id = Objects.toString(service_id, "");

		FinderPath finderPath = _finderPathCountByServiceId;

		Object[] finderArgs = new Object[] {service_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CALENDARDATE_WHERE);

			boolean bindService_id = false;

			if (service_id.isEmpty()) {
				sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_3);
			}
			else {
				bindService_id = true;

				sb.append(_FINDER_COLUMN_SERVICEID_SERVICE_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindService_id) {
					queryPos.add(service_id);
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

	private static final String _FINDER_COLUMN_SERVICEID_SERVICE_ID_2 =
		"calendarDate.service_id = ?";

	private static final String _FINDER_COLUMN_SERVICEID_SERVICE_ID_3 =
		"(calendarDate.service_id IS NULL OR calendarDate.service_id = '')";

	private FinderPath _finderPathWithPaginationFindByDate;
	private FinderPath _finderPathWithoutPaginationFindByDate;
	private FinderPath _finderPathCountByDate;

	/**
	 * Returns all the calendar dates where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByDate(Date date) {
		return findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByDate(Date date, int start, int end) {
		return findByDate(date, start, end, null);
	}

	/**
	 * Returns an ordered range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByDate(
		Date date, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator) {

		return findByDate(date, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	@Override
	public List<CalendarDate> findByDate(
		Date date, int start, int end,
		OrderByComparator<CalendarDate> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDate;
				finderArgs = new Object[] {_getTime(date)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDate;
			finderArgs = new Object[] {
				_getTime(date), start, end, orderByComparator
			};
		}

		List<CalendarDate> list = null;

		if (useFinderCache) {
			list = (List<CalendarDate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CalendarDate calendarDate : list) {
					if (!Objects.equals(date, calendarDate.getDate())) {
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

			sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				list = (List<CalendarDate>)QueryUtil.list(
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
	 * Returns the first calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByDate_First(
			Date date, OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByDate_First(date, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the first calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByDate_First(
		Date date, OrderByComparator<CalendarDate> orderByComparator) {

		List<CalendarDate> list = findByDate(date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate findByDate_Last(
			Date date, OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByDate_Last(date, orderByComparator);

		if (calendarDate != null) {
			return calendarDate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchCalendarDateException(sb.toString());
	}

	/**
	 * Returns the last calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	@Override
	public CalendarDate fetchByDate_Last(
		Date date, OrderByComparator<CalendarDate> orderByComparator) {

		int count = countByDate(date);

		if (count == 0) {
			return null;
		}

		List<CalendarDate> list = findByDate(
			date, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where date = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate[] findByDate_PrevAndNext(
			long id, Date date,
			OrderByComparator<CalendarDate> orderByComparator)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CalendarDate[] array = new CalendarDateImpl[3];

			array[0] = getByDate_PrevAndNext(
				session, calendarDate, date, orderByComparator, true);

			array[1] = calendarDate;

			array[2] = getByDate_PrevAndNext(
				session, calendarDate, date, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarDate getByDate_PrevAndNext(
		Session session, CalendarDate calendarDate, Date date,
		OrderByComparator<CalendarDate> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CALENDARDATE_WHERE);

		boolean bindDate = false;

		if (date == null) {
			sb.append(_FINDER_COLUMN_DATE_DATE_1);
		}
		else {
			bindDate = true;

			sb.append(_FINDER_COLUMN_DATE_DATE_2);
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
			sb.append(CalendarDateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDate) {
			queryPos.add(new Timestamp(date.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(calendarDate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CalendarDate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar dates where date = &#63; from the database.
	 *
	 * @param date the date
	 */
	@Override
	public void removeByDate(Date date) {
		for (CalendarDate calendarDate :
				findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(calendarDate);
		}
	}

	/**
	 * Returns the number of calendar dates where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching calendar dates
	 */
	@Override
	public int countByDate(Date date) {
		FinderPath finderPath = _finderPathCountByDate;

		Object[] finderArgs = new Object[] {_getTime(date)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CALENDARDATE_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
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

	private static final String _FINDER_COLUMN_DATE_DATE_1 =
		"calendarDate.date IS NULL";

	private static final String _FINDER_COLUMN_DATE_DATE_2 =
		"calendarDate.date = ?";

	public CalendarDatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");
		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CalendarDate.class);

		setModelImplClass(CalendarDateImpl.class);
		setModelPKClass(long.class);

		setTable(CalendarDateTable.INSTANCE);
	}

	/**
	 * Caches the calendar date in the entity cache if it is enabled.
	 *
	 * @param calendarDate the calendar date
	 */
	@Override
	public void cacheResult(CalendarDate calendarDate) {
		entityCache.putResult(
			CalendarDateImpl.class, calendarDate.getPrimaryKey(), calendarDate);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the calendar dates in the entity cache if it is enabled.
	 *
	 * @param calendarDates the calendar dates
	 */
	@Override
	public void cacheResult(List<CalendarDate> calendarDates) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (calendarDates.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CalendarDate calendarDate : calendarDates) {
			if (entityCache.getResult(
					CalendarDateImpl.class, calendarDate.getPrimaryKey()) ==
						null) {

				cacheResult(calendarDate);
			}
		}
	}

	/**
	 * Clears the cache for all calendar dates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CalendarDateImpl.class);

		finderCache.clearCache(CalendarDateImpl.class);
	}

	/**
	 * Clears the cache for the calendar date.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CalendarDate calendarDate) {
		entityCache.removeResult(CalendarDateImpl.class, calendarDate);
	}

	@Override
	public void clearCache(List<CalendarDate> calendarDates) {
		for (CalendarDate calendarDate : calendarDates) {
			entityCache.removeResult(CalendarDateImpl.class, calendarDate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CalendarDateImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CalendarDateImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new calendar date with the primary key. Does not add the calendar date to the database.
	 *
	 * @param id the primary key for the new calendar date
	 * @return the new calendar date
	 */
	@Override
	public CalendarDate create(long id) {
		CalendarDate calendarDate = new CalendarDateImpl();

		calendarDate.setNew(true);
		calendarDate.setPrimaryKey(id);

		String uuid = _portalUUID.generate();

		calendarDate.setUuid(uuid);

		return calendarDate;
	}

	/**
	 * Removes the calendar date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date that was removed
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate remove(long id) throws NoSuchCalendarDateException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the calendar date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the calendar date
	 * @return the calendar date that was removed
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate remove(Serializable primaryKey)
		throws NoSuchCalendarDateException {

		Session session = null;

		try {
			session = openSession();

			CalendarDate calendarDate = (CalendarDate)session.get(
				CalendarDateImpl.class, primaryKey);

			if (calendarDate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCalendarDateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(calendarDate);
		}
		catch (NoSuchCalendarDateException noSuchEntityException) {
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
	protected CalendarDate removeImpl(CalendarDate calendarDate) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(calendarDate)) {
				calendarDate = (CalendarDate)session.get(
					CalendarDateImpl.class, calendarDate.getPrimaryKeyObj());
			}

			if (calendarDate != null) {
				session.delete(calendarDate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (calendarDate != null) {
			clearCache(calendarDate);
		}

		return calendarDate;
	}

	@Override
	public CalendarDate updateImpl(CalendarDate calendarDate) {
		boolean isNew = calendarDate.isNew();

		if (!(calendarDate instanceof CalendarDateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(calendarDate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					calendarDate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in calendarDate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CalendarDate implementation " +
					calendarDate.getClass());
		}

		CalendarDateModelImpl calendarDateModelImpl =
			(CalendarDateModelImpl)calendarDate;

		if (Validator.isNull(calendarDate.getUuid())) {
			String uuid = _portalUUID.generate();

			calendarDate.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(calendarDate);
			}
			else {
				calendarDate = (CalendarDate)session.merge(calendarDate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CalendarDateImpl.class, calendarDateModelImpl, false, true);

		if (isNew) {
			calendarDate.setNew(false);
		}

		calendarDate.resetOriginalValues();

		return calendarDate;
	}

	/**
	 * Returns the calendar date with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the calendar date
	 * @return the calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCalendarDateException {

		CalendarDate calendarDate = fetchByPrimaryKey(primaryKey);

		if (calendarDate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCalendarDateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return calendarDate;
	}

	/**
	 * Returns the calendar date with the primary key or throws a <code>NoSuchCalendarDateException</code> if it could not be found.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate findByPrimaryKey(long id)
		throws NoSuchCalendarDateException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the calendar date with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date, or <code>null</code> if a calendar date with the primary key could not be found
	 */
	@Override
	public CalendarDate fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the calendar dates.
	 *
	 * @return the calendar dates
	 */
	@Override
	public List<CalendarDate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of calendar dates
	 */
	@Override
	public List<CalendarDate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of calendar dates
	 */
	@Override
	public List<CalendarDate> findAll(
		int start, int end, OrderByComparator<CalendarDate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of calendar dates
	 */
	@Override
	public List<CalendarDate> findAll(
		int start, int end, OrderByComparator<CalendarDate> orderByComparator,
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

		List<CalendarDate> list = null;

		if (useFinderCache) {
			list = (List<CalendarDate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CALENDARDATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CALENDARDATE;

				sql = sql.concat(CalendarDateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CalendarDate>)QueryUtil.list(
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
	 * Removes all the calendar dates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CalendarDate calendarDate : findAll()) {
			remove(calendarDate);
		}
	}

	/**
	 * Returns the number of calendar dates.
	 *
	 * @return the number of calendar dates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CALENDARDATE);

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
		return _SQL_SELECT_CALENDARDATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CalendarDateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the calendar date persistence.
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

		_finderPathWithPaginationFindByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"service_id"}, true);

		_finderPathWithoutPaginationFindByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceId",
			new String[] {String.class.getName()}, new String[] {"service_id"},
			true);

		_finderPathCountByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServiceId",
			new String[] {String.class.getName()}, new String[] {"service_id"},
			false);

		_finderPathWithPaginationFindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"date_"}, true);

		_finderPathWithoutPaginationFindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] {Date.class.getName()}, new String[] {"date_"}, true);

		_finderPathCountByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] {Date.class.getName()}, new String[] {"date_"}, false);

		_setCalendarDateUtilPersistence(this);
	}

	public void destroy() {
		_setCalendarDateUtilPersistence(null);

		entityCache.removeCache(CalendarDateImpl.class.getName());
	}

	private void _setCalendarDateUtilPersistence(
		CalendarDatePersistence calendarDatePersistence) {

		try {
			Field field = CalendarDateUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, calendarDatePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CALENDARDATE =
		"SELECT calendarDate FROM CalendarDate calendarDate";

	private static final String _SQL_SELECT_CALENDARDATE_WHERE =
		"SELECT calendarDate FROM CalendarDate calendarDate WHERE ";

	private static final String _SQL_COUNT_CALENDARDATE =
		"SELECT COUNT(calendarDate) FROM CalendarDate calendarDate";

	private static final String _SQL_COUNT_CALENDARDATE_WHERE =
		"SELECT COUNT(calendarDate) FROM CalendarDate calendarDate WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "calendarDate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CalendarDate exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CalendarDate exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CalendarDatePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "date"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}