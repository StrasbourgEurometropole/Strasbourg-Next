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

import eu.strasbourg.service.agenda.exception.NoSuchCampaignEventException;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.model.CampaignEventTable;
import eu.strasbourg.service.agenda.model.impl.CampaignEventImpl;
import eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventPersistence;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventUtil;

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
 * The persistence implementation for the campaign event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class CampaignEventPersistenceImpl
	extends BasePersistenceImpl<CampaignEvent>
	implements CampaignEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CampaignEventUtil</code> to access the campaign event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CampaignEventImpl.class.getName();

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
	 * Returns all the campaign events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator,
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

		List<CampaignEvent> list = null;

		if (useFinderCache) {
			list = (List<CampaignEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignEvent campaignEvent : list) {
					if (!uuid.equals(campaignEvent.getUuid())) {
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

			sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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
				sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
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

				list = (List<CampaignEvent>)QueryUtil.list(
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
	 * Returns the first campaign event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByUuid_First(
			String uuid, OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByUuid_First(
			uuid, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the first campaign event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUuid_First(
		String uuid, OrderByComparator<CampaignEvent> orderByComparator) {

		List<CampaignEvent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByUuid_Last(
			String uuid, OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByUuid_Last(uuid, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the last campaign event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUuid_Last(
		String uuid, OrderByComparator<CampaignEvent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CampaignEvent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign events before and after the current campaign event in the ordered set where uuid = &#63;.
	 *
	 * @param campaignEventId the primary key of the current campaign event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent[] findByUuid_PrevAndNext(
			long campaignEventId, String uuid,
			OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		uuid = Objects.toString(uuid, "");

		CampaignEvent campaignEvent = findByPrimaryKey(campaignEventId);

		Session session = null;

		try {
			session = openSession();

			CampaignEvent[] array = new CampaignEventImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, campaignEvent, uuid, orderByComparator, true);

			array[1] = campaignEvent;

			array[2] = getByUuid_PrevAndNext(
				session, campaignEvent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignEvent getByUuid_PrevAndNext(
		Session session, CampaignEvent campaignEvent, String uuid,
		OrderByComparator<CampaignEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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
			sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
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
						campaignEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CampaignEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CampaignEvent campaignEvent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaign events
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

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
		"campaignEvent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(campaignEvent.uuid IS NULL OR campaignEvent.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the campaign event where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchCampaignEventException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByUUID_G(String uuid, long groupId)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByUUID_G(uuid, groupId);

		if (campaignEvent == null) {
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

			throw new NoSuchCampaignEventException(sb.toString());
		}

		return campaignEvent;
	}

	/**
	 * Returns the campaign event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the campaign event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUUID_G(
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

		if (result instanceof CampaignEvent) {
			CampaignEvent campaignEvent = (CampaignEvent)result;

			if (!Objects.equals(uuid, campaignEvent.getUuid()) ||
				(groupId != campaignEvent.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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

				List<CampaignEvent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CampaignEvent campaignEvent = list.get(0);

					result = campaignEvent;

					cacheResult(campaignEvent);
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
			return (CampaignEvent)result;
		}
	}

	/**
	 * Removes the campaign event where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the campaign event that was removed
	 */
	@Override
	public CampaignEvent removeByUUID_G(String uuid, long groupId)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = findByUUID_G(uuid, groupId);

		return remove(campaignEvent);
	}

	/**
	 * Returns the number of campaign events where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching campaign events
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

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
		"campaignEvent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(campaignEvent.uuid IS NULL OR campaignEvent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"campaignEvent.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the campaign events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign events where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator,
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

		List<CampaignEvent> list = null;

		if (useFinderCache) {
			list = (List<CampaignEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignEvent campaignEvent : list) {
					if (!uuid.equals(campaignEvent.getUuid()) ||
						(companyId != campaignEvent.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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
				sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
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

				list = (List<CampaignEvent>)QueryUtil.list(
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
	 * Returns the first campaign event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the first campaign event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CampaignEvent> orderByComparator) {

		List<CampaignEvent> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the last campaign event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CampaignEvent> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CampaignEvent> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign events before and after the current campaign event in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param campaignEventId the primary key of the current campaign event
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent[] findByUuid_C_PrevAndNext(
			long campaignEventId, String uuid, long companyId,
			OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		uuid = Objects.toString(uuid, "");

		CampaignEvent campaignEvent = findByPrimaryKey(campaignEventId);

		Session session = null;

		try {
			session = openSession();

			CampaignEvent[] array = new CampaignEventImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, campaignEvent, uuid, companyId, orderByComparator,
				true);

			array[1] = campaignEvent;

			array[2] = getByUuid_C_PrevAndNext(
				session, campaignEvent, uuid, companyId, orderByComparator,
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

	protected CampaignEvent getByUuid_C_PrevAndNext(
		Session session, CampaignEvent campaignEvent, String uuid,
		long companyId, OrderByComparator<CampaignEvent> orderByComparator,
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

		sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

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
			sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
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
						campaignEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CampaignEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign events where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CampaignEvent campaignEvent :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching campaign events
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

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
		"campaignEvent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(campaignEvent.uuid IS NULL OR campaignEvent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"campaignEvent.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCampaignId;
	private FinderPath _finderPathWithoutPaginationFindByCampaignId;
	private FinderPath _finderPathCountByCampaignId;

	/**
	 * Returns all the campaign events where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByCampaignId(Long campaignId) {
		return findByCampaignId(
			campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByCampaignId(
		Long campaignId, int start, int end) {

		return findByCampaignId(campaignId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByCampaignId(
		Long campaignId, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator) {

		return findByCampaignId(
			campaignId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign events where campaignId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param campaignId the campaign ID
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign events
	 */
	@Override
	public List<CampaignEvent> findByCampaignId(
		Long campaignId, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCampaignId;
				finderArgs = new Object[] {campaignId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCampaignId;
			finderArgs = new Object[] {
				campaignId, start, end, orderByComparator
			};
		}

		List<CampaignEvent> list = null;

		if (useFinderCache) {
			list = (List<CampaignEvent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignEvent campaignEvent : list) {
					if (!Objects.equals(
							campaignId, campaignEvent.getCampaignId())) {

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

			sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

			sb.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(campaignId.longValue());

				list = (List<CampaignEvent>)QueryUtil.list(
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
	 * Returns the first campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByCampaignId_First(
			Long campaignId, OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByCampaignId_First(
			campaignId, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignId=");
		sb.append(campaignId);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the first campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByCampaignId_First(
		Long campaignId, OrderByComparator<CampaignEvent> orderByComparator) {

		List<CampaignEvent> list = findByCampaignId(
			campaignId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event
	 * @throws NoSuchCampaignEventException if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent findByCampaignId_Last(
			Long campaignId, OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByCampaignId_Last(
			campaignId, orderByComparator);

		if (campaignEvent != null) {
			return campaignEvent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignId=");
		sb.append(campaignId);

		sb.append("}");

		throw new NoSuchCampaignEventException(sb.toString());
	}

	/**
	 * Returns the last campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	@Override
	public CampaignEvent fetchByCampaignId_Last(
		Long campaignId, OrderByComparator<CampaignEvent> orderByComparator) {

		int count = countByCampaignId(campaignId);

		if (count == 0) {
			return null;
		}

		List<CampaignEvent> list = findByCampaignId(
			campaignId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign events before and after the current campaign event in the ordered set where campaignId = &#63;.
	 *
	 * @param campaignEventId the primary key of the current campaign event
	 * @param campaignId the campaign ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent[] findByCampaignId_PrevAndNext(
			long campaignEventId, Long campaignId,
			OrderByComparator<CampaignEvent> orderByComparator)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = findByPrimaryKey(campaignEventId);

		Session session = null;

		try {
			session = openSession();

			CampaignEvent[] array = new CampaignEventImpl[3];

			array[0] = getByCampaignId_PrevAndNext(
				session, campaignEvent, campaignId, orderByComparator, true);

			array[1] = campaignEvent;

			array[2] = getByCampaignId_PrevAndNext(
				session, campaignEvent, campaignId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignEvent getByCampaignId_PrevAndNext(
		Session session, CampaignEvent campaignEvent, Long campaignId,
		OrderByComparator<CampaignEvent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CAMPAIGNEVENT_WHERE);

		sb.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

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
			sb.append(CampaignEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(campaignId.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						campaignEvent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CampaignEvent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign events where campaignId = &#63; from the database.
	 *
	 * @param campaignId the campaign ID
	 */
	@Override
	public void removeByCampaignId(Long campaignId) {
		for (CampaignEvent campaignEvent :
				findByCampaignId(
					campaignId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events where campaignId = &#63;.
	 *
	 * @param campaignId the campaign ID
	 * @return the number of matching campaign events
	 */
	@Override
	public int countByCampaignId(Long campaignId) {
		FinderPath finderPath = _finderPathCountByCampaignId;

		Object[] finderArgs = new Object[] {campaignId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAMPAIGNEVENT_WHERE);

			sb.append(_FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(campaignId.longValue());

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

	private static final String _FINDER_COLUMN_CAMPAIGNID_CAMPAIGNID_2 =
		"campaignEvent.campaignId = ?";

	public CampaignEventPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CampaignEvent.class);

		setModelImplClass(CampaignEventImpl.class);
		setModelPKClass(long.class);

		setTable(CampaignEventTable.INSTANCE);
	}

	/**
	 * Caches the campaign event in the entity cache if it is enabled.
	 *
	 * @param campaignEvent the campaign event
	 */
	@Override
	public void cacheResult(CampaignEvent campaignEvent) {
		entityCache.putResult(
			CampaignEventImpl.class, campaignEvent.getPrimaryKey(),
			campaignEvent);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {campaignEvent.getUuid(), campaignEvent.getGroupId()},
			campaignEvent);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the campaign events in the entity cache if it is enabled.
	 *
	 * @param campaignEvents the campaign events
	 */
	@Override
	public void cacheResult(List<CampaignEvent> campaignEvents) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (campaignEvents.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CampaignEvent campaignEvent : campaignEvents) {
			if (entityCache.getResult(
					CampaignEventImpl.class, campaignEvent.getPrimaryKey()) ==
						null) {

				cacheResult(campaignEvent);
			}
		}
	}

	/**
	 * Clears the cache for all campaign events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CampaignEventImpl.class);

		finderCache.clearCache(CampaignEventImpl.class);
	}

	/**
	 * Clears the cache for the campaign event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignEvent campaignEvent) {
		entityCache.removeResult(CampaignEventImpl.class, campaignEvent);
	}

	@Override
	public void clearCache(List<CampaignEvent> campaignEvents) {
		for (CampaignEvent campaignEvent : campaignEvents) {
			entityCache.removeResult(CampaignEventImpl.class, campaignEvent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CampaignEventImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CampaignEventImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CampaignEventModelImpl campaignEventModelImpl) {

		Object[] args = new Object[] {
			campaignEventModelImpl.getUuid(),
			campaignEventModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, campaignEventModelImpl);
	}

	/**
	 * Creates a new campaign event with the primary key. Does not add the campaign event to the database.
	 *
	 * @param campaignEventId the primary key for the new campaign event
	 * @return the new campaign event
	 */
	@Override
	public CampaignEvent create(long campaignEventId) {
		CampaignEvent campaignEvent = new CampaignEventImpl();

		campaignEvent.setNew(true);
		campaignEvent.setPrimaryKey(campaignEventId);

		String uuid = _portalUUID.generate();

		campaignEvent.setUuid(uuid);

		campaignEvent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return campaignEvent;
	}

	/**
	 * Removes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event that was removed
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent remove(long campaignEventId)
		throws NoSuchCampaignEventException {

		return remove((Serializable)campaignEventId);
	}

	/**
	 * Removes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign event
	 * @return the campaign event that was removed
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent remove(Serializable primaryKey)
		throws NoSuchCampaignEventException {

		Session session = null;

		try {
			session = openSession();

			CampaignEvent campaignEvent = (CampaignEvent)session.get(
				CampaignEventImpl.class, primaryKey);

			if (campaignEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(campaignEvent);
		}
		catch (NoSuchCampaignEventException noSuchEntityException) {
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
	protected CampaignEvent removeImpl(CampaignEvent campaignEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignEvent)) {
				campaignEvent = (CampaignEvent)session.get(
					CampaignEventImpl.class, campaignEvent.getPrimaryKeyObj());
			}

			if (campaignEvent != null) {
				session.delete(campaignEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (campaignEvent != null) {
			clearCache(campaignEvent);
		}

		return campaignEvent;
	}

	@Override
	public CampaignEvent updateImpl(CampaignEvent campaignEvent) {
		boolean isNew = campaignEvent.isNew();

		if (!(campaignEvent instanceof CampaignEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(campaignEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					campaignEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in campaignEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CampaignEvent implementation " +
					campaignEvent.getClass());
		}

		CampaignEventModelImpl campaignEventModelImpl =
			(CampaignEventModelImpl)campaignEvent;

		if (Validator.isNull(campaignEvent.getUuid())) {
			String uuid = _portalUUID.generate();

			campaignEvent.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (campaignEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				campaignEvent.setCreateDate(date);
			}
			else {
				campaignEvent.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!campaignEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				campaignEvent.setModifiedDate(date);
			}
			else {
				campaignEvent.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(campaignEvent);
			}
			else {
				campaignEvent = (CampaignEvent)session.merge(campaignEvent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CampaignEventImpl.class, campaignEventModelImpl, false, true);

		cacheUniqueFindersCache(campaignEventModelImpl);

		if (isNew) {
			campaignEvent.setNew(false);
		}

		campaignEvent.resetOriginalValues();

		return campaignEvent;
	}

	/**
	 * Returns the campaign event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign event
	 * @return the campaign event
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignEventException {

		CampaignEvent campaignEvent = fetchByPrimaryKey(primaryKey);

		if (campaignEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return campaignEvent;
	}

	/**
	 * Returns the campaign event with the primary key or throws a <code>NoSuchCampaignEventException</code> if it could not be found.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event
	 * @throws NoSuchCampaignEventException if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent findByPrimaryKey(long campaignEventId)
		throws NoSuchCampaignEventException {

		return findByPrimaryKey((Serializable)campaignEventId);
	}

	/**
	 * Returns the campaign event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event, or <code>null</code> if a campaign event with the primary key could not be found
	 */
	@Override
	public CampaignEvent fetchByPrimaryKey(long campaignEventId) {
		return fetchByPrimaryKey((Serializable)campaignEventId);
	}

	/**
	 * Returns all the campaign events.
	 *
	 * @return the campaign events
	 */
	@Override
	public List<CampaignEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of campaign events
	 */
	@Override
	public List<CampaignEvent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign events
	 */
	@Override
	public List<CampaignEvent> findAll(
		int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of campaign events
	 */
	@Override
	public List<CampaignEvent> findAll(
		int start, int end, OrderByComparator<CampaignEvent> orderByComparator,
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

		List<CampaignEvent> list = null;

		if (useFinderCache) {
			list = (List<CampaignEvent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CAMPAIGNEVENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNEVENT;

				sql = sql.concat(CampaignEventModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CampaignEvent>)QueryUtil.list(
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
	 * Removes all the campaign events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CampaignEvent campaignEvent : findAll()) {
			remove(campaignEvent);
		}
	}

	/**
	 * Returns the number of campaign events.
	 *
	 * @return the number of campaign events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CAMPAIGNEVENT);

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
		return "campaignEventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CAMPAIGNEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CampaignEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the campaign event persistence.
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

		_finderPathWithPaginationFindByCampaignId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCampaignId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"campaignId"}, true);

		_finderPathWithoutPaginationFindByCampaignId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCampaignId",
			new String[] {Long.class.getName()}, new String[] {"campaignId"},
			true);

		_finderPathCountByCampaignId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCampaignId",
			new String[] {Long.class.getName()}, new String[] {"campaignId"},
			false);

		_setCampaignEventUtilPersistence(this);
	}

	public void destroy() {
		_setCampaignEventUtilPersistence(null);

		entityCache.removeCache(CampaignEventImpl.class.getName());
	}

	private void _setCampaignEventUtilPersistence(
		CampaignEventPersistence campaignEventPersistence) {

		try {
			Field field = CampaignEventUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, campaignEventPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CAMPAIGNEVENT =
		"SELECT campaignEvent FROM CampaignEvent campaignEvent";

	private static final String _SQL_SELECT_CAMPAIGNEVENT_WHERE =
		"SELECT campaignEvent FROM CampaignEvent campaignEvent WHERE ";

	private static final String _SQL_COUNT_CAMPAIGNEVENT =
		"SELECT COUNT(campaignEvent) FROM CampaignEvent campaignEvent";

	private static final String _SQL_COUNT_CAMPAIGNEVENT_WHERE =
		"SELECT COUNT(campaignEvent) FROM CampaignEvent campaignEvent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CampaignEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CampaignEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CampaignEventPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}