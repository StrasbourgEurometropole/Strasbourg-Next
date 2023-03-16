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

import eu.strasbourg.service.agenda.exception.NoSuchCampaignEventStatusException;
import eu.strasbourg.service.agenda.model.CampaignEventStatus;
import eu.strasbourg.service.agenda.model.CampaignEventStatusTable;
import eu.strasbourg.service.agenda.model.impl.CampaignEventStatusImpl;
import eu.strasbourg.service.agenda.model.impl.CampaignEventStatusModelImpl;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventStatusPersistence;
import eu.strasbourg.service.agenda.service.persistence.CampaignEventStatusUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the campaign event status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class CampaignEventStatusPersistenceImpl
	extends BasePersistenceImpl<CampaignEventStatus>
	implements CampaignEventStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CampaignEventStatusUtil</code> to access the campaign event status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CampaignEventStatusImpl.class.getName();

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
	 * Returns all the campaign event statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator,
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

		List<CampaignEventStatus> list = null;

		if (useFinderCache) {
			list = (List<CampaignEventStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignEventStatus campaignEventStatus : list) {
					if (!uuid.equals(campaignEventStatus.getUuid())) {
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

			sb.append(_SQL_SELECT_CAMPAIGNEVENTSTATUS_WHERE);

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
				sb.append(CampaignEventStatusModelImpl.ORDER_BY_JPQL);
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

				list = (List<CampaignEventStatus>)QueryUtil.list(
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
	 * Returns the first campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus findByUuid_First(
			String uuid,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = fetchByUuid_First(
			uuid, orderByComparator);

		if (campaignEventStatus != null) {
			return campaignEventStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCampaignEventStatusException(sb.toString());
	}

	/**
	 * Returns the first campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus fetchByUuid_First(
		String uuid, OrderByComparator<CampaignEventStatus> orderByComparator) {

		List<CampaignEventStatus> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus findByUuid_Last(
			String uuid,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = fetchByUuid_Last(
			uuid, orderByComparator);

		if (campaignEventStatus != null) {
			return campaignEventStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCampaignEventStatusException(sb.toString());
	}

	/**
	 * Returns the last campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus fetchByUuid_Last(
		String uuid, OrderByComparator<CampaignEventStatus> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CampaignEventStatus> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign event statuses before and after the current campaign event status in the ordered set where uuid = &#63;.
	 *
	 * @param statusId the primary key of the current campaign event status
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus[] findByUuid_PrevAndNext(
			long statusId, String uuid,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		uuid = Objects.toString(uuid, "");

		CampaignEventStatus campaignEventStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			CampaignEventStatus[] array = new CampaignEventStatusImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, campaignEventStatus, uuid, orderByComparator, true);

			array[1] = campaignEventStatus;

			array[2] = getByUuid_PrevAndNext(
				session, campaignEventStatus, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CampaignEventStatus getByUuid_PrevAndNext(
		Session session, CampaignEventStatus campaignEventStatus, String uuid,
		OrderByComparator<CampaignEventStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_CAMPAIGNEVENTSTATUS_WHERE);

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
			sb.append(CampaignEventStatusModelImpl.ORDER_BY_JPQL);
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
						campaignEventStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CampaignEventStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign event statuses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CampaignEventStatus campaignEventStatus :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(campaignEventStatus);
		}
	}

	/**
	 * Returns the number of campaign event statuses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching campaign event statuses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAMPAIGNEVENTSTATUS_WHERE);

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
		"campaignEventStatus.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(campaignEventStatus.uuid IS NULL OR campaignEventStatus.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByCampaignEventId;
	private FinderPath _finderPathWithoutPaginationFindByCampaignEventId;
	private FinderPath _finderPathCountByCampaignEventId;

	/**
	 * Returns all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId) {

		return findByCampaignEventId(
			campaignEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end) {

		return findByCampaignEventId(campaignEventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator) {

		return findByCampaignEventId(
			campaignEventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findByCampaignEventId(
		long campaignEventId, int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator,
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

		List<CampaignEventStatus> list = null;

		if (useFinderCache) {
			list = (List<CampaignEventStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CampaignEventStatus campaignEventStatus : list) {
					if (campaignEventId !=
							campaignEventStatus.getCampaignEventId()) {

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

			sb.append(_SQL_SELECT_CAMPAIGNEVENTSTATUS_WHERE);

			sb.append(_FINDER_COLUMN_CAMPAIGNEVENTID_CAMPAIGNEVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CampaignEventStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(campaignEventId);

				list = (List<CampaignEventStatus>)QueryUtil.list(
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
	 * Returns the first campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus findByCampaignEventId_First(
			long campaignEventId,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = fetchByCampaignEventId_First(
			campaignEventId, orderByComparator);

		if (campaignEventStatus != null) {
			return campaignEventStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignEventId=");
		sb.append(campaignEventId);

		sb.append("}");

		throw new NoSuchCampaignEventStatusException(sb.toString());
	}

	/**
	 * Returns the first campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus fetchByCampaignEventId_First(
		long campaignEventId,
		OrderByComparator<CampaignEventStatus> orderByComparator) {

		List<CampaignEventStatus> list = findByCampaignEventId(
			campaignEventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status
	 * @throws NoSuchCampaignEventStatusException if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus findByCampaignEventId_Last(
			long campaignEventId,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = fetchByCampaignEventId_Last(
			campaignEventId, orderByComparator);

		if (campaignEventStatus != null) {
			return campaignEventStatus;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("campaignEventId=");
		sb.append(campaignEventId);

		sb.append("}");

		throw new NoSuchCampaignEventStatusException(sb.toString());
	}

	/**
	 * Returns the last campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching campaign event status, or <code>null</code> if a matching campaign event status could not be found
	 */
	@Override
	public CampaignEventStatus fetchByCampaignEventId_Last(
		long campaignEventId,
		OrderByComparator<CampaignEventStatus> orderByComparator) {

		int count = countByCampaignEventId(campaignEventId);

		if (count == 0) {
			return null;
		}

		List<CampaignEventStatus> list = findByCampaignEventId(
			campaignEventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the campaign event statuses before and after the current campaign event status in the ordered set where campaignEventId = &#63;.
	 *
	 * @param statusId the primary key of the current campaign event status
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus[] findByCampaignEventId_PrevAndNext(
			long statusId, long campaignEventId,
			OrderByComparator<CampaignEventStatus> orderByComparator)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = findByPrimaryKey(statusId);

		Session session = null;

		try {
			session = openSession();

			CampaignEventStatus[] array = new CampaignEventStatusImpl[3];

			array[0] = getByCampaignEventId_PrevAndNext(
				session, campaignEventStatus, campaignEventId,
				orderByComparator, true);

			array[1] = campaignEventStatus;

			array[2] = getByCampaignEventId_PrevAndNext(
				session, campaignEventStatus, campaignEventId,
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

	protected CampaignEventStatus getByCampaignEventId_PrevAndNext(
		Session session, CampaignEventStatus campaignEventStatus,
		long campaignEventId,
		OrderByComparator<CampaignEventStatus> orderByComparator,
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

		sb.append(_SQL_SELECT_CAMPAIGNEVENTSTATUS_WHERE);

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
			sb.append(CampaignEventStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(campaignEventId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						campaignEventStatus)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CampaignEventStatus> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the campaign event statuses where campaignEventId = &#63; from the database.
	 *
	 * @param campaignEventId the campaign event ID
	 */
	@Override
	public void removeByCampaignEventId(long campaignEventId) {
		for (CampaignEventStatus campaignEventStatus :
				findByCampaignEventId(
					campaignEventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(campaignEventStatus);
		}
	}

	/**
	 * Returns the number of campaign event statuses where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the number of matching campaign event statuses
	 */
	@Override
	public int countByCampaignEventId(long campaignEventId) {
		FinderPath finderPath = _finderPathCountByCampaignEventId;

		Object[] finderArgs = new Object[] {campaignEventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAMPAIGNEVENTSTATUS_WHERE);

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
			"campaignEventStatus.campaignEventId = ?";

	public CampaignEventStatusPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");
		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CampaignEventStatus.class);

		setModelImplClass(CampaignEventStatusImpl.class);
		setModelPKClass(long.class);

		setTable(CampaignEventStatusTable.INSTANCE);
	}

	/**
	 * Caches the campaign event status in the entity cache if it is enabled.
	 *
	 * @param campaignEventStatus the campaign event status
	 */
	@Override
	public void cacheResult(CampaignEventStatus campaignEventStatus) {
		entityCache.putResult(
			CampaignEventStatusImpl.class, campaignEventStatus.getPrimaryKey(),
			campaignEventStatus);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the campaign event statuses in the entity cache if it is enabled.
	 *
	 * @param campaignEventStatuses the campaign event statuses
	 */
	@Override
	public void cacheResult(List<CampaignEventStatus> campaignEventStatuses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (campaignEventStatuses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CampaignEventStatus campaignEventStatus : campaignEventStatuses) {
			if (entityCache.getResult(
					CampaignEventStatusImpl.class,
					campaignEventStatus.getPrimaryKey()) == null) {

				cacheResult(campaignEventStatus);
			}
		}
	}

	/**
	 * Clears the cache for all campaign event statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CampaignEventStatusImpl.class);

		finderCache.clearCache(CampaignEventStatusImpl.class);
	}

	/**
	 * Clears the cache for the campaign event status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CampaignEventStatus campaignEventStatus) {
		entityCache.removeResult(
			CampaignEventStatusImpl.class, campaignEventStatus);
	}

	@Override
	public void clearCache(List<CampaignEventStatus> campaignEventStatuses) {
		for (CampaignEventStatus campaignEventStatus : campaignEventStatuses) {
			entityCache.removeResult(
				CampaignEventStatusImpl.class, campaignEventStatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CampaignEventStatusImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CampaignEventStatusImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new campaign event status with the primary key. Does not add the campaign event status to the database.
	 *
	 * @param statusId the primary key for the new campaign event status
	 * @return the new campaign event status
	 */
	@Override
	public CampaignEventStatus create(long statusId) {
		CampaignEventStatus campaignEventStatus = new CampaignEventStatusImpl();

		campaignEventStatus.setNew(true);
		campaignEventStatus.setPrimaryKey(statusId);

		String uuid = _portalUUID.generate();

		campaignEventStatus.setUuid(uuid);

		return campaignEventStatus;
	}

	/**
	 * Removes the campaign event status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status that was removed
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus remove(long statusId)
		throws NoSuchCampaignEventStatusException {

		return remove((Serializable)statusId);
	}

	/**
	 * Removes the campaign event status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the campaign event status
	 * @return the campaign event status that was removed
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus remove(Serializable primaryKey)
		throws NoSuchCampaignEventStatusException {

		Session session = null;

		try {
			session = openSession();

			CampaignEventStatus campaignEventStatus =
				(CampaignEventStatus)session.get(
					CampaignEventStatusImpl.class, primaryKey);

			if (campaignEventStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCampaignEventStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(campaignEventStatus);
		}
		catch (NoSuchCampaignEventStatusException noSuchEntityException) {
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
	protected CampaignEventStatus removeImpl(
		CampaignEventStatus campaignEventStatus) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(campaignEventStatus)) {
				campaignEventStatus = (CampaignEventStatus)session.get(
					CampaignEventStatusImpl.class,
					campaignEventStatus.getPrimaryKeyObj());
			}

			if (campaignEventStatus != null) {
				session.delete(campaignEventStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (campaignEventStatus != null) {
			clearCache(campaignEventStatus);
		}

		return campaignEventStatus;
	}

	@Override
	public CampaignEventStatus updateImpl(
		CampaignEventStatus campaignEventStatus) {

		boolean isNew = campaignEventStatus.isNew();

		if (!(campaignEventStatus instanceof CampaignEventStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(campaignEventStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					campaignEventStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in campaignEventStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CampaignEventStatus implementation " +
					campaignEventStatus.getClass());
		}

		CampaignEventStatusModelImpl campaignEventStatusModelImpl =
			(CampaignEventStatusModelImpl)campaignEventStatus;

		if (Validator.isNull(campaignEventStatus.getUuid())) {
			String uuid = _portalUUID.generate();

			campaignEventStatus.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(campaignEventStatus);
			}
			else {
				campaignEventStatus = (CampaignEventStatus)session.merge(
					campaignEventStatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CampaignEventStatusImpl.class, campaignEventStatusModelImpl, false,
			true);

		if (isNew) {
			campaignEventStatus.setNew(false);
		}

		campaignEventStatus.resetOriginalValues();

		return campaignEventStatus;
	}

	/**
	 * Returns the campaign event status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the campaign event status
	 * @return the campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCampaignEventStatusException {

		CampaignEventStatus campaignEventStatus = fetchByPrimaryKey(primaryKey);

		if (campaignEventStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCampaignEventStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return campaignEventStatus;
	}

	/**
	 * Returns the campaign event status with the primary key or throws a <code>NoSuchCampaignEventStatusException</code> if it could not be found.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status
	 * @throws NoSuchCampaignEventStatusException if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus findByPrimaryKey(long statusId)
		throws NoSuchCampaignEventStatusException {

		return findByPrimaryKey((Serializable)statusId);
	}

	/**
	 * Returns the campaign event status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param statusId the primary key of the campaign event status
	 * @return the campaign event status, or <code>null</code> if a campaign event status with the primary key could not be found
	 */
	@Override
	public CampaignEventStatus fetchByPrimaryKey(long statusId) {
		return fetchByPrimaryKey((Serializable)statusId);
	}

	/**
	 * Returns all the campaign event statuses.
	 *
	 * @return the campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @return the range of campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findAll(
		int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the campaign event statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CampaignEventStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign event statuses
	 * @param end the upper bound of the range of campaign event statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of campaign event statuses
	 */
	@Override
	public List<CampaignEventStatus> findAll(
		int start, int end,
		OrderByComparator<CampaignEventStatus> orderByComparator,
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

		List<CampaignEventStatus> list = null;

		if (useFinderCache) {
			list = (List<CampaignEventStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CAMPAIGNEVENTSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CAMPAIGNEVENTSTATUS;

				sql = sql.concat(CampaignEventStatusModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CampaignEventStatus>)QueryUtil.list(
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
	 * Removes all the campaign event statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CampaignEventStatus campaignEventStatus : findAll()) {
			remove(campaignEventStatus);
		}
	}

	/**
	 * Returns the number of campaign event statuses.
	 *
	 * @return the number of campaign event statuses
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
					_SQL_COUNT_CAMPAIGNEVENTSTATUS);

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
		return "statusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CAMPAIGNEVENTSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CampaignEventStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the campaign event status persistence.
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

		_setCampaignEventStatusUtilPersistence(this);
	}

	public void destroy() {
		_setCampaignEventStatusUtilPersistence(null);

		entityCache.removeCache(CampaignEventStatusImpl.class.getName());
	}

	private void _setCampaignEventStatusUtilPersistence(
		CampaignEventStatusPersistence campaignEventStatusPersistence) {

		try {
			Field field = CampaignEventStatusUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, campaignEventStatusPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CAMPAIGNEVENTSTATUS =
		"SELECT campaignEventStatus FROM CampaignEventStatus campaignEventStatus";

	private static final String _SQL_SELECT_CAMPAIGNEVENTSTATUS_WHERE =
		"SELECT campaignEventStatus FROM CampaignEventStatus campaignEventStatus WHERE ";

	private static final String _SQL_COUNT_CAMPAIGNEVENTSTATUS =
		"SELECT COUNT(campaignEventStatus) FROM CampaignEventStatus campaignEventStatus";

	private static final String _SQL_COUNT_CAMPAIGNEVENTSTATUS_WHERE =
		"SELECT COUNT(campaignEventStatus) FROM CampaignEventStatus campaignEventStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "campaignEventStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CampaignEventStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CampaignEventStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CampaignEventStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment", "date"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}