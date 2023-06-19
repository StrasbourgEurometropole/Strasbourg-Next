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

import eu.strasbourg.service.place.exception.NoSuchSlotException;
import eu.strasbourg.service.place.model.Slot;
import eu.strasbourg.service.place.model.SlotTable;
import eu.strasbourg.service.place.model.impl.SlotImpl;
import eu.strasbourg.service.place.model.impl.SlotModelImpl;
import eu.strasbourg.service.place.service.persistence.SlotPersistence;
import eu.strasbourg.service.place.service.persistence.SlotUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the slot service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class SlotPersistenceImpl
	extends BasePersistenceImpl<Slot> implements SlotPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SlotUtil</code> to access the slot persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SlotImpl.class.getName();

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
	 * Returns all the slots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching slots
	 */
	@Override
	public List<Slot> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	@Override
	public List<Slot> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Slot> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Slot> orderByComparator, boolean useFinderCache) {

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

		List<Slot> list = null;

		if (useFinderCache) {
			list = (List<Slot>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Slot slot : list) {
					if (!uuid.equals(slot.getUuid())) {
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

			sb.append(_SQL_SELECT_SLOT_WHERE);

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
				sb.append(SlotModelImpl.ORDER_BY_JPQL);
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

				list = (List<Slot>)QueryUtil.list(
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
	 * Returns the first slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findByUuid_First(
			String uuid, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchByUuid_First(uuid, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the first slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchByUuid_First(
		String uuid, OrderByComparator<Slot> orderByComparator) {

		List<Slot> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findByUuid_Last(
			String uuid, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchByUuid_Last(uuid, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the last slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchByUuid_Last(
		String uuid, OrderByComparator<Slot> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Slot> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the slots before and after the current slot in the ordered set where uuid = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot[] findByUuid_PrevAndNext(
			long slotId, String uuid, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		uuid = Objects.toString(uuid, "");

		Slot slot = findByPrimaryKey(slotId);

		Session session = null;

		try {
			session = openSession();

			Slot[] array = new SlotImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, slot, uuid, orderByComparator, true);

			array[1] = slot;

			array[2] = getByUuid_PrevAndNext(
				session, slot, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Slot getByUuid_PrevAndNext(
		Session session, Slot slot, String uuid,
		OrderByComparator<Slot> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SLOT_WHERE);

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
			sb.append(SlotModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(slot)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Slot> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the slots where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Slot slot :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(slot);
		}
	}

	/**
	 * Returns the number of slots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching slots
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SLOT_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "slot.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(slot.uuid IS NULL OR slot.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByPeriodId;
	private FinderPath _finderPathWithoutPaginationFindByPeriodId;
	private FinderPath _finderPathCountByPeriodId;

	/**
	 * Returns all the slots where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @return the matching slots
	 */
	@Override
	public List<Slot> findByPeriodId(long periodId) {
		return findByPeriodId(
			periodId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	@Override
	public List<Slot> findByPeriodId(long periodId, int start, int end) {
		return findByPeriodId(periodId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findByPeriodId(
		long periodId, int start, int end,
		OrderByComparator<Slot> orderByComparator) {

		return findByPeriodId(periodId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findByPeriodId(
		long periodId, int start, int end,
		OrderByComparator<Slot> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPeriodId;
				finderArgs = new Object[] {periodId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPeriodId;
			finderArgs = new Object[] {periodId, start, end, orderByComparator};
		}

		List<Slot> list = null;

		if (useFinderCache) {
			list = (List<Slot>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Slot slot : list) {
					if (periodId != slot.getPeriodId()) {
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

			sb.append(_SQL_SELECT_SLOT_WHERE);

			sb.append(_FINDER_COLUMN_PERIODID_PERIODID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SlotModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(periodId);

				list = (List<Slot>)QueryUtil.list(
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
	 * Returns the first slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findByPeriodId_First(
			long periodId, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchByPeriodId_First(periodId, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("periodId=");
		sb.append(periodId);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the first slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchByPeriodId_First(
		long periodId, OrderByComparator<Slot> orderByComparator) {

		List<Slot> list = findByPeriodId(periodId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findByPeriodId_Last(
			long periodId, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchByPeriodId_Last(periodId, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("periodId=");
		sb.append(periodId);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the last slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchByPeriodId_Last(
		long periodId, OrderByComparator<Slot> orderByComparator) {

		int count = countByPeriodId(periodId);

		if (count == 0) {
			return null;
		}

		List<Slot> list = findByPeriodId(
			periodId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the slots before and after the current slot in the ordered set where periodId = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot[] findByPeriodId_PrevAndNext(
			long slotId, long periodId,
			OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = findByPrimaryKey(slotId);

		Session session = null;

		try {
			session = openSession();

			Slot[] array = new SlotImpl[3];

			array[0] = getByPeriodId_PrevAndNext(
				session, slot, periodId, orderByComparator, true);

			array[1] = slot;

			array[2] = getByPeriodId_PrevAndNext(
				session, slot, periodId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Slot getByPeriodId_PrevAndNext(
		Session session, Slot slot, long periodId,
		OrderByComparator<Slot> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SLOT_WHERE);

		sb.append(_FINDER_COLUMN_PERIODID_PERIODID_2);

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
			sb.append(SlotModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(periodId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(slot)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Slot> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the slots where periodId = &#63; from the database.
	 *
	 * @param periodId the period ID
	 */
	@Override
	public void removeByPeriodId(long periodId) {
		for (Slot slot :
				findByPeriodId(
					periodId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(slot);
		}
	}

	/**
	 * Returns the number of slots where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @return the number of matching slots
	 */
	@Override
	public int countByPeriodId(long periodId) {
		FinderPath finderPath = _finderPathCountByPeriodId;

		Object[] finderArgs = new Object[] {periodId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SLOT_WHERE);

			sb.append(_FINDER_COLUMN_PERIODID_PERIODID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(periodId);

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

	private static final String _FINDER_COLUMN_PERIODID_PERIODID_2 =
		"slot.periodId = ?";

	private FinderPath _finderPathWithPaginationFindBySubPlaceId;
	private FinderPath _finderPathWithoutPaginationFindBySubPlaceId;
	private FinderPath _finderPathCountBySubPlaceId;

	/**
	 * Returns all the slots where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the matching slots
	 */
	@Override
	public List<Slot> findBySubPlaceId(long subPlaceId) {
		return findBySubPlaceId(
			subPlaceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	@Override
	public List<Slot> findBySubPlaceId(long subPlaceId, int start, int end) {
		return findBySubPlaceId(subPlaceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findBySubPlaceId(
		long subPlaceId, int start, int end,
		OrderByComparator<Slot> orderByComparator) {

		return findBySubPlaceId(
			subPlaceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	@Override
	public List<Slot> findBySubPlaceId(
		long subPlaceId, int start, int end,
		OrderByComparator<Slot> orderByComparator, boolean useFinderCache) {

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

		List<Slot> list = null;

		if (useFinderCache) {
			list = (List<Slot>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Slot slot : list) {
					if (subPlaceId != slot.getSubPlaceId()) {
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

			sb.append(_SQL_SELECT_SLOT_WHERE);

			sb.append(_FINDER_COLUMN_SUBPLACEID_SUBPLACEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SlotModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subPlaceId);

				list = (List<Slot>)QueryUtil.list(
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
	 * Returns the first slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findBySubPlaceId_First(
			long subPlaceId, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchBySubPlaceId_First(subPlaceId, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subPlaceId=");
		sb.append(subPlaceId);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the first slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchBySubPlaceId_First(
		long subPlaceId, OrderByComparator<Slot> orderByComparator) {

		List<Slot> list = findBySubPlaceId(subPlaceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	@Override
	public Slot findBySubPlaceId_Last(
			long subPlaceId, OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = fetchBySubPlaceId_Last(subPlaceId, orderByComparator);

		if (slot != null) {
			return slot;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subPlaceId=");
		sb.append(subPlaceId);

		sb.append("}");

		throw new NoSuchSlotException(sb.toString());
	}

	/**
	 * Returns the last slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	@Override
	public Slot fetchBySubPlaceId_Last(
		long subPlaceId, OrderByComparator<Slot> orderByComparator) {

		int count = countBySubPlaceId(subPlaceId);

		if (count == 0) {
			return null;
		}

		List<Slot> list = findBySubPlaceId(
			subPlaceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the slots before and after the current slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot[] findBySubPlaceId_PrevAndNext(
			long slotId, long subPlaceId,
			OrderByComparator<Slot> orderByComparator)
		throws NoSuchSlotException {

		Slot slot = findByPrimaryKey(slotId);

		Session session = null;

		try {
			session = openSession();

			Slot[] array = new SlotImpl[3];

			array[0] = getBySubPlaceId_PrevAndNext(
				session, slot, subPlaceId, orderByComparator, true);

			array[1] = slot;

			array[2] = getBySubPlaceId_PrevAndNext(
				session, slot, subPlaceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Slot getBySubPlaceId_PrevAndNext(
		Session session, Slot slot, long subPlaceId,
		OrderByComparator<Slot> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SLOT_WHERE);

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
			sb.append(SlotModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subPlaceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(slot)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Slot> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the slots where subPlaceId = &#63; from the database.
	 *
	 * @param subPlaceId the sub place ID
	 */
	@Override
	public void removeBySubPlaceId(long subPlaceId) {
		for (Slot slot :
				findBySubPlaceId(
					subPlaceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(slot);
		}
	}

	/**
	 * Returns the number of slots where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the number of matching slots
	 */
	@Override
	public int countBySubPlaceId(long subPlaceId) {
		FinderPath finderPath = _finderPathCountBySubPlaceId;

		Object[] finderArgs = new Object[] {subPlaceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SLOT_WHERE);

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
		"slot.subPlaceId = ?";

	public SlotPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Slot.class);

		setModelImplClass(SlotImpl.class);
		setModelPKClass(long.class);

		setTable(SlotTable.INSTANCE);
	}

	/**
	 * Caches the slot in the entity cache if it is enabled.
	 *
	 * @param slot the slot
	 */
	@Override
	public void cacheResult(Slot slot) {
		entityCache.putResult(SlotImpl.class, slot.getPrimaryKey(), slot);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the slots in the entity cache if it is enabled.
	 *
	 * @param slots the slots
	 */
	@Override
	public void cacheResult(List<Slot> slots) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (slots.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Slot slot : slots) {
			if (entityCache.getResult(SlotImpl.class, slot.getPrimaryKey()) ==
					null) {

				cacheResult(slot);
			}
		}
	}

	/**
	 * Clears the cache for all slots.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SlotImpl.class);

		finderCache.clearCache(SlotImpl.class);
	}

	/**
	 * Clears the cache for the slot.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Slot slot) {
		entityCache.removeResult(SlotImpl.class, slot);
	}

	@Override
	public void clearCache(List<Slot> slots) {
		for (Slot slot : slots) {
			entityCache.removeResult(SlotImpl.class, slot);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SlotImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SlotImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new slot with the primary key. Does not add the slot to the database.
	 *
	 * @param slotId the primary key for the new slot
	 * @return the new slot
	 */
	@Override
	public Slot create(long slotId) {
		Slot slot = new SlotImpl();

		slot.setNew(true);
		slot.setPrimaryKey(slotId);

		String uuid = _portalUUID.generate();

		slot.setUuid(uuid);

		return slot;
	}

	/**
	 * Removes the slot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot that was removed
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot remove(long slotId) throws NoSuchSlotException {
		return remove((Serializable)slotId);
	}

	/**
	 * Removes the slot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the slot
	 * @return the slot that was removed
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot remove(Serializable primaryKey) throws NoSuchSlotException {
		Session session = null;

		try {
			session = openSession();

			Slot slot = (Slot)session.get(SlotImpl.class, primaryKey);

			if (slot == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSlotException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(slot);
		}
		catch (NoSuchSlotException noSuchEntityException) {
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
	protected Slot removeImpl(Slot slot) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(slot)) {
				slot = (Slot)session.get(
					SlotImpl.class, slot.getPrimaryKeyObj());
			}

			if (slot != null) {
				session.delete(slot);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (slot != null) {
			clearCache(slot);
		}

		return slot;
	}

	@Override
	public Slot updateImpl(Slot slot) {
		boolean isNew = slot.isNew();

		if (!(slot instanceof SlotModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(slot.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(slot);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in slot proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Slot implementation " +
					slot.getClass());
		}

		SlotModelImpl slotModelImpl = (SlotModelImpl)slot;

		if (Validator.isNull(slot.getUuid())) {
			String uuid = _portalUUID.generate();

			slot.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(slot);
			}
			else {
				slot = (Slot)session.merge(slot);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(SlotImpl.class, slotModelImpl, false, true);

		if (isNew) {
			slot.setNew(false);
		}

		slot.resetOriginalValues();

		return slot;
	}

	/**
	 * Returns the slot with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the slot
	 * @return the slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSlotException {

		Slot slot = fetchByPrimaryKey(primaryKey);

		if (slot == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSlotException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return slot;
	}

	/**
	 * Returns the slot with the primary key or throws a <code>NoSuchSlotException</code> if it could not be found.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	@Override
	public Slot findByPrimaryKey(long slotId) throws NoSuchSlotException {
		return findByPrimaryKey((Serializable)slotId);
	}

	/**
	 * Returns the slot with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot, or <code>null</code> if a slot with the primary key could not be found
	 */
	@Override
	public Slot fetchByPrimaryKey(long slotId) {
		return fetchByPrimaryKey((Serializable)slotId);
	}

	/**
	 * Returns all the slots.
	 *
	 * @return the slots
	 */
	@Override
	public List<Slot> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of slots
	 */
	@Override
	public List<Slot> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of slots
	 */
	@Override
	public List<Slot> findAll(
		int start, int end, OrderByComparator<Slot> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of slots
	 */
	@Override
	public List<Slot> findAll(
		int start, int end, OrderByComparator<Slot> orderByComparator,
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

		List<Slot> list = null;

		if (useFinderCache) {
			list = (List<Slot>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SLOT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SLOT;

				sql = sql.concat(SlotModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Slot>)QueryUtil.list(
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
	 * Removes all the slots from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Slot slot : findAll()) {
			remove(slot);
		}
	}

	/**
	 * Returns the number of slots.
	 *
	 * @return the number of slots
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SLOT);

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
		return "slotId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SLOT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SlotModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the slot persistence.
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

		_finderPathWithPaginationFindByPeriodId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPeriodId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"periodId"}, true);

		_finderPathWithoutPaginationFindByPeriodId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPeriodId",
			new String[] {Long.class.getName()}, new String[] {"periodId"},
			true);

		_finderPathCountByPeriodId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPeriodId",
			new String[] {Long.class.getName()}, new String[] {"periodId"},
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

		_setSlotUtilPersistence(this);
	}

	public void destroy() {
		_setSlotUtilPersistence(null);

		entityCache.removeCache(SlotImpl.class.getName());
	}

	private void _setSlotUtilPersistence(SlotPersistence slotPersistence) {
		try {
			Field field = SlotUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, slotPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SLOT = "SELECT slot FROM Slot slot";

	private static final String _SQL_SELECT_SLOT_WHERE =
		"SELECT slot FROM Slot slot WHERE ";

	private static final String _SQL_COUNT_SLOT =
		"SELECT COUNT(slot) FROM Slot slot";

	private static final String _SQL_COUNT_SLOT_WHERE =
		"SELECT COUNT(slot) FROM Slot slot WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "slot.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Slot exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Slot exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SlotPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}