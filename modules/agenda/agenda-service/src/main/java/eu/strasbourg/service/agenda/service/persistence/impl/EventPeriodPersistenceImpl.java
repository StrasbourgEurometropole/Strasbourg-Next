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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.agenda.exception.NoSuchEventPeriodException;
import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.model.EventPeriodTable;
import eu.strasbourg.service.agenda.model.impl.EventPeriodImpl;
import eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl;
import eu.strasbourg.service.agenda.service.persistence.EventPeriodPersistence;
import eu.strasbourg.service.agenda.service.persistence.EventPeriodUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the event period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class EventPeriodPersistenceImpl
	extends BasePersistenceImpl<EventPeriod> implements EventPeriodPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>EventPeriodUtil</code> to access the event period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		EventPeriodImpl.class.getName();

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
	 * Returns all the event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event periods
	 */
	@Override
	public List<EventPeriod> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
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

		List<EventPeriod> list = null;

		if (useFinderCache) {
			list = (List<EventPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventPeriod eventPeriod : list) {
					if (!uuid.equals(eventPeriod.getUuid())) {
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

			sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

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
				sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
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

				list = (List<EventPeriod>)QueryUtil.list(
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
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByUuid_First(
			String uuid, OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByUuid_First(uuid, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByUuid_First(
		String uuid, OrderByComparator<EventPeriod> orderByComparator) {

		List<EventPeriod> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByUuid_Last(
			String uuid, OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByUuid_Last(uuid, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByUuid_Last(
		String uuid, OrderByComparator<EventPeriod> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<EventPeriod> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where uuid = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod[] findByUuid_PrevAndNext(
			long eventPeriodId, String uuid,
			OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		uuid = Objects.toString(uuid, "");

		EventPeriod eventPeriod = findByPrimaryKey(eventPeriodId);

		Session session = null;

		try {
			session = openSession();

			EventPeriod[] array = new EventPeriodImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, eventPeriod, uuid, orderByComparator, true);

			array[1] = eventPeriod;

			array[2] = getByUuid_PrevAndNext(
				session, eventPeriod, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventPeriod getByUuid_PrevAndNext(
		Session session, EventPeriod eventPeriod, String uuid,
		OrderByComparator<EventPeriod> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

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
			sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(eventPeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventPeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event periods where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (EventPeriod eventPeriod :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventPeriod);
		}
	}

	/**
	 * Returns the number of event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event periods
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTPERIOD_WHERE);

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
		"eventPeriod.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(eventPeriod.uuid IS NULL OR eventPeriod.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByEventId;
	private FinderPath _finderPathWithoutPaginationFindByEventId;
	private FinderPath _finderPathCountByEventId;

	/**
	 * Returns all the event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event periods
	 */
	@Override
	public List<EventPeriod> findByEventId(long eventId) {
		return findByEventId(
			eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByEventId(long eventId, int start, int end) {
		return findByEventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return findByEventId(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEventId;
				finderArgs = new Object[] {eventId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEventId;
			finderArgs = new Object[] {eventId, start, end, orderByComparator};
		}

		List<EventPeriod> list = null;

		if (useFinderCache) {
			list = (List<EventPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventPeriod eventPeriod : list) {
					if (eventId != eventPeriod.getEventId()) {
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

			sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				list = (List<EventPeriod>)QueryUtil.list(
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
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByEventId_First(
			long eventId, OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByEventId_First(
			eventId, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByEventId_First(
		long eventId, OrderByComparator<EventPeriod> orderByComparator) {

		List<EventPeriod> list = findByEventId(
			eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByEventId_Last(
			long eventId, OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByEventId_Last(
			eventId, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByEventId_Last(
		long eventId, OrderByComparator<EventPeriod> orderByComparator) {

		int count = countByEventId(eventId);

		if (count == 0) {
			return null;
		}

		List<EventPeriod> list = findByEventId(
			eventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod[] findByEventId_PrevAndNext(
			long eventPeriodId, long eventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = findByPrimaryKey(eventPeriodId);

		Session session = null;

		try {
			session = openSession();

			EventPeriod[] array = new EventPeriodImpl[3];

			array[0] = getByEventId_PrevAndNext(
				session, eventPeriod, eventId, orderByComparator, true);

			array[1] = eventPeriod;

			array[2] = getByEventId_PrevAndNext(
				session, eventPeriod, eventId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected EventPeriod getByEventId_PrevAndNext(
		Session session, EventPeriod eventPeriod, long eventId,
		OrderByComparator<EventPeriod> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

		sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

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
			sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(eventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventPeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventPeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event periods where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByEventId(long eventId) {
		for (EventPeriod eventPeriod :
				findByEventId(
					eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(eventPeriod);
		}
	}

	/**
	 * Returns the number of event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event periods
	 */
	@Override
	public int countByEventId(long eventId) {
		FinderPath finderPath = _finderPathCountByEventId;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTPERIOD_WHERE);

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
		"eventPeriod.eventId = ?";

	private FinderPath _finderPathWithPaginationFindByCampaignEventId;
	private FinderPath _finderPathWithoutPaginationFindByCampaignEventId;
	private FinderPath _finderPathCountByCampaignEventId;

	/**
	 * Returns all the event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the matching event periods
	 */
	@Override
	public List<EventPeriod> findByCampaignEventId(long campaignEventId) {
		return findByCampaignEventId(
			campaignEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end) {

		return findByCampaignEventId(campaignEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator) {

		return findByCampaignEventId(
			campaignEventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching event periods
	 */
	@Override
	public List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<EventPeriod> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCampaignEventId;
				finderArgs = new Object[] {campaignEventId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCampaignEventId;
			finderArgs = new Object[] {
				campaignEventId, start, end, orderByComparator
			};
		}

		List<EventPeriod> list = null;

		if (useFinderCache) {
			list = (List<EventPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (EventPeriod eventPeriod : list) {
					if (campaignEventId != eventPeriod.getCampaignEventId()) {
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

			sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_CAMPAIGNEVENTID_CAMPAIGNEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(campaignEventId);

				list = (List<EventPeriod>)QueryUtil.list(
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
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByCampaignEventId_First(
			long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByCampaignEventId_First(
			campaignEventId, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignEventId=");
		sb.append(campaignEventId);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByCampaignEventId_First(
		long campaignEventId,
		OrderByComparator<EventPeriod> orderByComparator) {

		List<EventPeriod> list = findByCampaignEventId(
			campaignEventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	@Override
	public EventPeriod findByCampaignEventId_Last(
			long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByCampaignEventId_Last(
			campaignEventId, orderByComparator);

		if (eventPeriod != null) {
			return eventPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignEventId=");
		sb.append(campaignEventId);

		sb.append("}");

		throw new NoSuchEventPeriodException(sb.toString());
	}

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	@Override
	public EventPeriod fetchByCampaignEventId_Last(
		long campaignEventId,
		OrderByComparator<EventPeriod> orderByComparator) {

		int count = countByCampaignEventId(campaignEventId);

		if (count == 0) {
			return null;
		}

		List<EventPeriod> list = findByCampaignEventId(
			campaignEventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the event periods before and after the current event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod[] findByCampaignEventId_PrevAndNext(
			long eventPeriodId, long campaignEventId,
			OrderByComparator<EventPeriod> orderByComparator)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = findByPrimaryKey(eventPeriodId);

		Session session = null;

		try {
			session = openSession();

			EventPeriod[] array = new EventPeriodImpl[3];

			array[0] = getByCampaignEventId_PrevAndNext(
				session, eventPeriod, campaignEventId, orderByComparator, true);

			array[1] = eventPeriod;

			array[2] = getByCampaignEventId_PrevAndNext(
				session, eventPeriod, campaignEventId, orderByComparator,
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

	protected EventPeriod getByCampaignEventId_PrevAndNext(
		Session session, EventPeriod eventPeriod, long campaignEventId,
		OrderByComparator<EventPeriod> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EVENTPERIOD_WHERE);

		sb.append(_FINDER_COLUMN_CAMPAIGNEVENTID_CAMPAIGNEVENTID_2);

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
			sb.append(EventPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(campaignEventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(eventPeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<EventPeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the event periods where campaignEventId = &#63; from the database.
	 *
	 * @param campaignEventId the campaign event ID
	 */
	@Override
	public void removeByCampaignEventId(long campaignEventId) {
		for (EventPeriod eventPeriod :
				findByCampaignEventId(
					campaignEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(eventPeriod);
		}
	}

	/**
	 * Returns the number of event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the number of matching event periods
	 */
	@Override
	public int countByCampaignEventId(long campaignEventId) {
		FinderPath finderPath = _finderPathCountByCampaignEventId;

		Object[] finderArgs = new Object[] {campaignEventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EVENTPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_CAMPAIGNEVENTID_CAMPAIGNEVENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(campaignEventId);

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
		_FINDER_COLUMN_CAMPAIGNEVENTID_CAMPAIGNEVENTID_2 =
			"eventPeriod.campaignEventId = ?";

	public EventPeriodPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(EventPeriod.class);

		setModelImplClass(EventPeriodImpl.class);
		setModelPKClass(long.class);

		setTable(EventPeriodTable.INSTANCE);
	}

	/**
	 * Caches the event period in the entity cache if it is enabled.
	 *
	 * @param eventPeriod the event period
	 */
	@Override
	public void cacheResult(EventPeriod eventPeriod) {
		entityCache.putResult(
			EventPeriodImpl.class, eventPeriod.getPrimaryKey(), eventPeriod);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the event periods in the entity cache if it is enabled.
	 *
	 * @param eventPeriods the event periods
	 */
	@Override
	public void cacheResult(List<EventPeriod> eventPeriods) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (eventPeriods.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (EventPeriod eventPeriod : eventPeriods) {
			if (entityCache.getResult(
					EventPeriodImpl.class, eventPeriod.getPrimaryKey()) ==
						null) {

				cacheResult(eventPeriod);
			}
		}
	}

	/**
	 * Clears the cache for all event periods.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventPeriodImpl.class);

		finderCache.clearCache(EventPeriodImpl.class);
	}

	/**
	 * Clears the cache for the event period.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EventPeriod eventPeriod) {
		entityCache.removeResult(EventPeriodImpl.class, eventPeriod);
	}

	@Override
	public void clearCache(List<EventPeriod> eventPeriods) {
		for (EventPeriod eventPeriod : eventPeriods) {
			entityCache.removeResult(EventPeriodImpl.class, eventPeriod);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(EventPeriodImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(EventPeriodImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new event period with the primary key. Does not add the event period to the database.
	 *
	 * @param eventPeriodId the primary key for the new event period
	 * @return the new event period
	 */
	@Override
	public EventPeriod create(long eventPeriodId) {
		EventPeriod eventPeriod = new EventPeriodImpl();

		eventPeriod.setNew(true);
		eventPeriod.setPrimaryKey(eventPeriodId);

		String uuid = PortalUUIDUtil.generate();

		eventPeriod.setUuid(uuid);

		return eventPeriod;
	}

	/**
	 * Removes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period that was removed
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod remove(long eventPeriodId)
		throws NoSuchEventPeriodException {

		return remove((Serializable)eventPeriodId);
	}

	/**
	 * Removes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the event period
	 * @return the event period that was removed
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod remove(Serializable primaryKey)
		throws NoSuchEventPeriodException {

		Session session = null;

		try {
			session = openSession();

			EventPeriod eventPeriod = (EventPeriod)session.get(
				EventPeriodImpl.class, primaryKey);

			if (eventPeriod == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventPeriodException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eventPeriod);
		}
		catch (NoSuchEventPeriodException noSuchEntityException) {
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
	protected EventPeriod removeImpl(EventPeriod eventPeriod) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eventPeriod)) {
				eventPeriod = (EventPeriod)session.get(
					EventPeriodImpl.class, eventPeriod.getPrimaryKeyObj());
			}

			if (eventPeriod != null) {
				session.delete(eventPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eventPeriod != null) {
			clearCache(eventPeriod);
		}

		return eventPeriod;
	}

	@Override
	public EventPeriod updateImpl(EventPeriod eventPeriod) {
		boolean isNew = eventPeriod.isNew();

		if (!(eventPeriod instanceof EventPeriodModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(eventPeriod.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(eventPeriod);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in eventPeriod proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom EventPeriod implementation " +
					eventPeriod.getClass());
		}

		EventPeriodModelImpl eventPeriodModelImpl =
			(EventPeriodModelImpl)eventPeriod;

		if (Validator.isNull(eventPeriod.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			eventPeriod.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eventPeriod);
			}
			else {
				eventPeriod = (EventPeriod)session.merge(eventPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			EventPeriodImpl.class, eventPeriodModelImpl, false, true);

		if (isNew) {
			eventPeriod.setNew(false);
		}

		eventPeriod.resetOriginalValues();

		return eventPeriod;
	}

	/**
	 * Returns the event period with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the event period
	 * @return the event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventPeriodException {

		EventPeriod eventPeriod = fetchByPrimaryKey(primaryKey);

		if (eventPeriod == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventPeriodException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eventPeriod;
	}

	/**
	 * Returns the event period with the primary key or throws a <code>NoSuchEventPeriodException</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod findByPrimaryKey(long eventPeriodId)
		throws NoSuchEventPeriodException {

		return findByPrimaryKey((Serializable)eventPeriodId);
	}

	/**
	 * Returns the event period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period, or <code>null</code> if a event period with the primary key could not be found
	 */
	@Override
	public EventPeriod fetchByPrimaryKey(long eventPeriodId) {
		return fetchByPrimaryKey((Serializable)eventPeriodId);
	}

	/**
	 * Returns all the event periods.
	 *
	 * @return the event periods
	 */
	@Override
	public List<EventPeriod> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of event periods
	 */
	@Override
	public List<EventPeriod> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event periods
	 */
	@Override
	public List<EventPeriod> findAll(
		int start, int end, OrderByComparator<EventPeriod> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of event periods
	 */
	@Override
	public List<EventPeriod> findAll(
		int start, int end, OrderByComparator<EventPeriod> orderByComparator,
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

		List<EventPeriod> list = null;

		if (useFinderCache) {
			list = (List<EventPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EVENTPERIOD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTPERIOD;

				sql = sql.concat(EventPeriodModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<EventPeriod>)QueryUtil.list(
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
	 * Removes all the event periods from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EventPeriod eventPeriod : findAll()) {
			remove(eventPeriod);
		}
	}

	/**
	 * Returns the number of event periods.
	 *
	 * @return the number of event periods
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EVENTPERIOD);

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
		return "eventPeriodId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EVENTPERIOD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EventPeriodModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the event period persistence.
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

		_finderPathWithPaginationFindByEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eventId"}, true);

		_finderPathWithoutPaginationFindByEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			true);

		_finderPathCountByEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			false);

		_finderPathWithPaginationFindByCampaignEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignEventId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"campaignEventId"}, true);

		_finderPathWithoutPaginationFindByCampaignEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignEventId",
			new String[] {Long.class.getName()},
			new String[] {"campaignEventId"}, true);

		_finderPathCountByCampaignEventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignEventId",
			new String[] {Long.class.getName()},
			new String[] {"campaignEventId"}, false);

		EventPeriodUtil.setPersistence(this);
	}

	public void destroy() {
		EventPeriodUtil.setPersistence(null);

		entityCache.removeCache(EventPeriodImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EVENTPERIOD =
		"SELECT eventPeriod FROM EventPeriod eventPeriod";

	private static final String _SQL_SELECT_EVENTPERIOD_WHERE =
		"SELECT eventPeriod FROM EventPeriod eventPeriod WHERE ";

	private static final String _SQL_COUNT_EVENTPERIOD =
		"SELECT COUNT(eventPeriod) FROM EventPeriod eventPeriod";

	private static final String _SQL_COUNT_EVENTPERIOD_WHERE =
		"SELECT COUNT(eventPeriod) FROM EventPeriod eventPeriod WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eventPeriod.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No EventPeriod exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No EventPeriod exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		EventPeriodPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}