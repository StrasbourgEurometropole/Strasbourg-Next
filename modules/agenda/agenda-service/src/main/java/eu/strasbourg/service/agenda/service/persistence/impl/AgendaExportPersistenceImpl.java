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

import eu.strasbourg.service.agenda.exception.NoSuchAgendaExportException;
import eu.strasbourg.service.agenda.model.AgendaExport;
import eu.strasbourg.service.agenda.model.impl.AgendaExportImpl;
import eu.strasbourg.service.agenda.model.impl.AgendaExportModelImpl;
import eu.strasbourg.service.agenda.service.persistence.AgendaExportPersistence;

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
 * The persistence implementation for the agenda export service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class AgendaExportPersistenceImpl
	extends BasePersistenceImpl<AgendaExport>
	implements AgendaExportPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgendaExportUtil</code> to access the agenda export persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgendaExportImpl.class.getName();

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
	 * Returns all the agenda exports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
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

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExport agendaExport : list) {
					if (!uuid.equals(agendaExport.getUuid())) {
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

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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
				sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
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

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Returns the first agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByUuid_First(
			String uuid, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByUuid_First(uuid, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUuid_First(
		String uuid, OrderByComparator<AgendaExport> orderByComparator) {

		List<AgendaExport> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByUuid_Last(
			String uuid, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByUuid_Last(uuid, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUuid_Last(
		String uuid, OrderByComparator<AgendaExport> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AgendaExport> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where uuid = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport[] findByUuid_PrevAndNext(
			long agendaExportId, String uuid,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		uuid = Objects.toString(uuid, "");

		AgendaExport agendaExport = findByPrimaryKey(agendaExportId);

		Session session = null;

		try {
			session = openSession();

			AgendaExport[] array = new AgendaExportImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, agendaExport, uuid, orderByComparator, true);

			array[1] = agendaExport;

			array[2] = getByUuid_PrevAndNext(
				session, agendaExport, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgendaExport getByUuid_PrevAndNext(
		Session session, AgendaExport agendaExport, String uuid,
		OrderByComparator<AgendaExport> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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
			sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(agendaExport)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExport> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda exports where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AgendaExport agendaExport :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

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
		"agendaExport.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(agendaExport.uuid IS NULL OR agendaExport.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAgendaExportException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByUUID_G(String uuid, long groupId)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByUUID_G(uuid, groupId);

		if (agendaExport == null) {
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

			throw new NoSuchAgendaExportException(sb.toString());
		}

		return agendaExport;
	}

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the agenda export where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUUID_G(
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

		if (result instanceof AgendaExport) {
			AgendaExport agendaExport = (AgendaExport)result;

			if (!Objects.equals(uuid, agendaExport.getUuid()) ||
				(groupId != agendaExport.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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

				List<AgendaExport> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AgendaExport agendaExport = list.get(0);

					result = agendaExport;

					cacheResult(agendaExport);
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
			return (AgendaExport)result;
		}
	}

	/**
	 * Removes the agenda export where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the agenda export that was removed
	 */
	@Override
	public AgendaExport removeByUUID_G(String uuid, long groupId)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = findByUUID_G(uuid, groupId);

		return remove(agendaExport);
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

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
		"agendaExport.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(agendaExport.uuid IS NULL OR agendaExport.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"agendaExport.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
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

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExport agendaExport : list) {
					if (!uuid.equals(agendaExport.getUuid()) ||
						(companyId != agendaExport.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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
				sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
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

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Returns the first agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the first agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AgendaExport> orderByComparator) {

		List<AgendaExport> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the last agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AgendaExport> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AgendaExport> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport[] findByUuid_C_PrevAndNext(
			long agendaExportId, String uuid, long companyId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		uuid = Objects.toString(uuid, "");

		AgendaExport agendaExport = findByPrimaryKey(agendaExportId);

		Session session = null;

		try {
			session = openSession();

			AgendaExport[] array = new AgendaExportImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, agendaExport, uuid, companyId, orderByComparator,
				true);

			array[1] = agendaExport;

			array[2] = getByUuid_C_PrevAndNext(
				session, agendaExport, uuid, companyId, orderByComparator,
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

	protected AgendaExport getByUuid_C_PrevAndNext(
		Session session, AgendaExport agendaExport, String uuid, long companyId,
		OrderByComparator<AgendaExport> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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
			sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(agendaExport)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExport> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda exports where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AgendaExport agendaExport :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

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
		"agendaExport.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(agendaExport.uuid IS NULL OR agendaExport.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"agendaExport.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the agenda exports where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByStatus(
		int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByStatus(
		int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExport agendaExport : list) {
					if (status != agendaExport.getStatus()) {
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

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Returns the first agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByStatus_First(
			int status, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByStatus_First(
			status, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the first agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByStatus_First(
		int status, OrderByComparator<AgendaExport> orderByComparator) {

		List<AgendaExport> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByStatus_Last(
			int status, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByStatus_Last(
			status, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the last agenda export in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByStatus_Last(
		int status, OrderByComparator<AgendaExport> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<AgendaExport> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where status = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport[] findByStatus_PrevAndNext(
			long agendaExportId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = findByPrimaryKey(agendaExportId);

		Session session = null;

		try {
			session = openSession();

			AgendaExport[] array = new AgendaExportImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, agendaExport, status, orderByComparator, true);

			array[1] = agendaExport;

			array[2] = getByStatus_PrevAndNext(
				session, agendaExport, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgendaExport getByStatus_PrevAndNext(
		Session session, AgendaExport agendaExport, int status,
		OrderByComparator<AgendaExport> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(agendaExport)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExport> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda exports where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (AgendaExport agendaExport :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"agendaExport.status = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the agenda exports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
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

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExport agendaExport : list) {
					if (groupId != agendaExport.getGroupId()) {
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

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Returns the first agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByGroupId_First(
			long groupId, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByGroupId_First(
			groupId, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByGroupId_First(
		long groupId, OrderByComparator<AgendaExport> orderByComparator) {

		List<AgendaExport> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByGroupId_Last(
			long groupId, OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByGroupId_Last(
		long groupId, OrderByComparator<AgendaExport> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<AgendaExport> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where groupId = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport[] findByGroupId_PrevAndNext(
			long agendaExportId, long groupId,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = findByPrimaryKey(agendaExportId);

		Session session = null;

		try {
			session = openSession();

			AgendaExport[] array = new AgendaExportImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, agendaExport, groupId, orderByComparator, true);

			array[1] = agendaExport;

			array[2] = getByGroupId_PrevAndNext(
				session, agendaExport, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgendaExport getByGroupId_PrevAndNext(
		Session session, AgendaExport agendaExport, long groupId,
		OrderByComparator<AgendaExport> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

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
			sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(agendaExport)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExport> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda exports where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (AgendaExport agendaExport :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

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
		"agendaExport.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndStatus;
	private FinderPath _finderPathCountByGroupIdAndStatus;

	/**
	 * Returns all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupIdAndStatus(long groupId, int status) {
		return findByGroupIdAndStatus(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end) {

		return findByGroupIdAndStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator) {

		return findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda exports
	 */
	@Override
	public List<AgendaExport> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<AgendaExport> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupIdAndStatus;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndStatus;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExport agendaExport : list) {
					if ((groupId != agendaExport.getGroupId()) ||
						(status != agendaExport.getStatus())) {

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

			sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Returns the first agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByGroupIdAndStatus_First(
			long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByGroupIdAndStatus_First(
			groupId, status, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the first agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByGroupIdAndStatus_First(
		long groupId, int status,
		OrderByComparator<AgendaExport> orderByComparator) {

		List<AgendaExport> list = findByGroupIdAndStatus(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export
	 * @throws NoSuchAgendaExportException if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport findByGroupIdAndStatus_Last(
			long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);

		if (agendaExport != null) {
			return agendaExport;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchAgendaExportException(sb.toString());
	}

	/**
	 * Returns the last agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export, or <code>null</code> if a matching agenda export could not be found
	 */
	@Override
	public AgendaExport fetchByGroupIdAndStatus_Last(
		long groupId, int status,
		OrderByComparator<AgendaExport> orderByComparator) {

		int count = countByGroupIdAndStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<AgendaExport> list = findByGroupIdAndStatus(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda exports before and after the current agenda export in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param agendaExportId the primary key of the current agenda export
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport[] findByGroupIdAndStatus_PrevAndNext(
			long agendaExportId, long groupId, int status,
			OrderByComparator<AgendaExport> orderByComparator)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = findByPrimaryKey(agendaExportId);

		Session session = null;

		try {
			session = openSession();

			AgendaExport[] array = new AgendaExportImpl[3];

			array[0] = getByGroupIdAndStatus_PrevAndNext(
				session, agendaExport, groupId, status, orderByComparator,
				true);

			array[1] = agendaExport;

			array[2] = getByGroupIdAndStatus_PrevAndNext(
				session, agendaExport, groupId, status, orderByComparator,
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

	protected AgendaExport getByGroupIdAndStatus_PrevAndNext(
		Session session, AgendaExport agendaExport, long groupId, int status,
		OrderByComparator<AgendaExport> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_STATUS_2);

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
			sb.append(AgendaExportModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(agendaExport)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExport> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda exports where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByGroupIdAndStatus(long groupId, int status) {
		for (AgendaExport agendaExport :
				findByGroupIdAndStatus(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching agenda exports
	 */
	@Override
	public int countByGroupIdAndStatus(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByGroupIdAndStatus;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AGENDAEXPORT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_GROUPIDANDSTATUS_GROUPID_2 =
		"agendaExport.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDSTATUS_STATUS_2 =
		"agendaExport.status = ?";

	public AgendaExportPersistenceImpl() {
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

		setModelClass(AgendaExport.class);
	}

	/**
	 * Caches the agenda export in the entity cache if it is enabled.
	 *
	 * @param agendaExport the agenda export
	 */
	@Override
	public void cacheResult(AgendaExport agendaExport) {
		entityCache.putResult(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED, AgendaExportImpl.class,
			agendaExport.getPrimaryKey(), agendaExport);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {agendaExport.getUuid(), agendaExport.getGroupId()},
			agendaExport);

		agendaExport.resetOriginalValues();
	}

	/**
	 * Caches the agenda exports in the entity cache if it is enabled.
	 *
	 * @param agendaExports the agenda exports
	 */
	@Override
	public void cacheResult(List<AgendaExport> agendaExports) {
		for (AgendaExport agendaExport : agendaExports) {
			if (entityCache.getResult(
					AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
					AgendaExportImpl.class, agendaExport.getPrimaryKey()) ==
						null) {

				cacheResult(agendaExport);
			}
			else {
				agendaExport.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all agenda exports.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgendaExportImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the agenda export.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgendaExport agendaExport) {
		entityCache.removeResult(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED, AgendaExportImpl.class,
			agendaExport.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((AgendaExportModelImpl)agendaExport, true);
	}

	@Override
	public void clearCache(List<AgendaExport> agendaExports) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AgendaExport agendaExport : agendaExports) {
			entityCache.removeResult(
				AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
				AgendaExportImpl.class, agendaExport.getPrimaryKey());

			clearUniqueFindersCache((AgendaExportModelImpl)agendaExport, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
				AgendaExportImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AgendaExportModelImpl agendaExportModelImpl) {

		Object[] args = new Object[] {
			agendaExportModelImpl.getUuid(), agendaExportModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, agendaExportModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		AgendaExportModelImpl agendaExportModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				agendaExportModelImpl.getUuid(),
				agendaExportModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((agendaExportModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				agendaExportModelImpl.getOriginalUuid(),
				agendaExportModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new agenda export with the primary key. Does not add the agenda export to the database.
	 *
	 * @param agendaExportId the primary key for the new agenda export
	 * @return the new agenda export
	 */
	@Override
	public AgendaExport create(long agendaExportId) {
		AgendaExport agendaExport = new AgendaExportImpl();

		agendaExport.setNew(true);
		agendaExport.setPrimaryKey(agendaExportId);

		String uuid = PortalUUIDUtil.generate();

		agendaExport.setUuid(uuid);

		agendaExport.setCompanyId(CompanyThreadLocal.getCompanyId());

		return agendaExport;
	}

	/**
	 * Removes the agenda export with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export that was removed
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport remove(long agendaExportId)
		throws NoSuchAgendaExportException {

		return remove((Serializable)agendaExportId);
	}

	/**
	 * Removes the agenda export with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agenda export
	 * @return the agenda export that was removed
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport remove(Serializable primaryKey)
		throws NoSuchAgendaExportException {

		Session session = null;

		try {
			session = openSession();

			AgendaExport agendaExport = (AgendaExport)session.get(
				AgendaExportImpl.class, primaryKey);

			if (agendaExport == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgendaExportException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agendaExport);
		}
		catch (NoSuchAgendaExportException noSuchEntityException) {
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
	protected AgendaExport removeImpl(AgendaExport agendaExport) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agendaExport)) {
				agendaExport = (AgendaExport)session.get(
					AgendaExportImpl.class, agendaExport.getPrimaryKeyObj());
			}

			if (agendaExport != null) {
				session.delete(agendaExport);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agendaExport != null) {
			clearCache(agendaExport);
		}

		return agendaExport;
	}

	@Override
	public AgendaExport updateImpl(AgendaExport agendaExport) {
		boolean isNew = agendaExport.isNew();

		if (!(agendaExport instanceof AgendaExportModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agendaExport.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agendaExport);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agendaExport proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgendaExport implementation " +
					agendaExport.getClass());
		}

		AgendaExportModelImpl agendaExportModelImpl =
			(AgendaExportModelImpl)agendaExport;

		if (Validator.isNull(agendaExport.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			agendaExport.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (agendaExport.getCreateDate() == null)) {
			if (serviceContext == null) {
				agendaExport.setCreateDate(now);
			}
			else {
				agendaExport.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!agendaExportModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				agendaExport.setModifiedDate(now);
			}
			else {
				agendaExport.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (agendaExport.isNew()) {
				session.save(agendaExport);

				agendaExport.setNew(false);
			}
			else {
				agendaExport = (AgendaExport)session.merge(agendaExport);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!AgendaExportModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {agendaExportModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				agendaExportModelImpl.getUuid(),
				agendaExportModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {agendaExportModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			args = new Object[] {agendaExportModelImpl.getGroupId()};

			finderCache.removeResult(_finderPathCountByGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupId, args);

			args = new Object[] {
				agendaExportModelImpl.getGroupId(),
				agendaExportModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByGroupIdAndStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupIdAndStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((agendaExportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					agendaExportModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {agendaExportModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((agendaExportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					agendaExportModelImpl.getOriginalUuid(),
					agendaExportModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					agendaExportModelImpl.getUuid(),
					agendaExportModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((agendaExportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					agendaExportModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {agendaExportModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}

			if ((agendaExportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					agendaExportModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);

				args = new Object[] {agendaExportModelImpl.getGroupId()};

				finderCache.removeResult(_finderPathCountByGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupId, args);
			}

			if ((agendaExportModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupIdAndStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					agendaExportModelImpl.getOriginalGroupId(),
					agendaExportModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(
					_finderPathCountByGroupIdAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupIdAndStatus, args);

				args = new Object[] {
					agendaExportModelImpl.getGroupId(),
					agendaExportModelImpl.getStatus()
				};

				finderCache.removeResult(
					_finderPathCountByGroupIdAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupIdAndStatus, args);
			}
		}

		entityCache.putResult(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED, AgendaExportImpl.class,
			agendaExport.getPrimaryKey(), agendaExport, false);

		clearUniqueFindersCache(agendaExportModelImpl, false);
		cacheUniqueFindersCache(agendaExportModelImpl);

		agendaExport.resetOriginalValues();

		return agendaExport;
	}

	/**
	 * Returns the agenda export with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agenda export
	 * @return the agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgendaExportException {

		AgendaExport agendaExport = fetchByPrimaryKey(primaryKey);

		if (agendaExport == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgendaExportException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agendaExport;
	}

	/**
	 * Returns the agenda export with the primary key or throws a <code>NoSuchAgendaExportException</code> if it could not be found.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export
	 * @throws NoSuchAgendaExportException if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport findByPrimaryKey(long agendaExportId)
		throws NoSuchAgendaExportException {

		return findByPrimaryKey((Serializable)agendaExportId);
	}

	/**
	 * Returns the agenda export with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agenda export
	 * @return the agenda export, or <code>null</code> if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED, AgendaExportImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AgendaExport agendaExport = (AgendaExport)serializable;

		if (agendaExport == null) {
			Session session = null;

			try {
				session = openSession();

				agendaExport = (AgendaExport)session.get(
					AgendaExportImpl.class, primaryKey);

				if (agendaExport != null) {
					cacheResult(agendaExport);
				}
				else {
					entityCache.putResult(
						AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
						AgendaExportImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
					AgendaExportImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return agendaExport;
	}

	/**
	 * Returns the agenda export with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agendaExportId the primary key of the agenda export
	 * @return the agenda export, or <code>null</code> if a agenda export with the primary key could not be found
	 */
	@Override
	public AgendaExport fetchByPrimaryKey(long agendaExportId) {
		return fetchByPrimaryKey((Serializable)agendaExportId);
	}

	@Override
	public Map<Serializable, AgendaExport> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AgendaExport> map =
			new HashMap<Serializable, AgendaExport>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AgendaExport agendaExport = fetchByPrimaryKey(primaryKey);

			if (agendaExport != null) {
				map.put(primaryKey, agendaExport);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
				AgendaExportImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AgendaExport)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_AGENDAEXPORT_WHERE_PKS_IN);

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

			for (AgendaExport agendaExport : (List<AgendaExport>)query.list()) {
				map.put(agendaExport.getPrimaryKeyObj(), agendaExport);

				cacheResult(agendaExport);

				uncachedPrimaryKeys.remove(agendaExport.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
					AgendaExportImpl.class, primaryKey, nullModel);
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
	 * Returns all the agenda exports.
	 *
	 * @return the agenda exports
	 */
	@Override
	public List<AgendaExport> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @return the range of agenda exports
	 */
	@Override
	public List<AgendaExport> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agenda exports
	 */
	@Override
	public List<AgendaExport> findAll(
		int start, int end, OrderByComparator<AgendaExport> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda exports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda exports
	 * @param end the upper bound of the range of agenda exports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agenda exports
	 */
	@Override
	public List<AgendaExport> findAll(
		int start, int end, OrderByComparator<AgendaExport> orderByComparator,
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

		List<AgendaExport> list = null;

		if (useFinderCache) {
			list = (List<AgendaExport>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENDAEXPORT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENDAEXPORT;

				sql = sql.concat(AgendaExportModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgendaExport>)QueryUtil.list(
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
	 * Removes all the agenda exports from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgendaExport agendaExport : findAll()) {
			remove(agendaExport);
		}
	}

	/**
	 * Returns the number of agenda exports.
	 *
	 * @return the number of agenda exports
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AGENDAEXPORT);

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
		return AgendaExportModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agenda export persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			AgendaExportModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			AgendaExportModelImpl.UUID_COLUMN_BITMASK |
			AgendaExportModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			AgendaExportModelImpl.UUID_COLUMN_BITMASK |
			AgendaExportModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			AgendaExportModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()},
			AgendaExportModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByGroupId = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupIdAndStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupIdAndStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, AgendaExportImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			AgendaExportModelImpl.GROUPID_COLUMN_BITMASK |
			AgendaExportModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByGroupIdAndStatus = new FinderPath(
			AgendaExportModelImpl.ENTITY_CACHE_ENABLED,
			AgendaExportModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(AgendaExportImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AGENDAEXPORT =
		"SELECT agendaExport FROM AgendaExport agendaExport";

	private static final String _SQL_SELECT_AGENDAEXPORT_WHERE_PKS_IN =
		"SELECT agendaExport FROM AgendaExport agendaExport WHERE agendaExportId IN (";

	private static final String _SQL_SELECT_AGENDAEXPORT_WHERE =
		"SELECT agendaExport FROM AgendaExport agendaExport WHERE ";

	private static final String _SQL_COUNT_AGENDAEXPORT =
		"SELECT COUNT(agendaExport) FROM AgendaExport agendaExport";

	private static final String _SQL_COUNT_AGENDAEXPORT_WHERE =
		"SELECT COUNT(agendaExport) FROM AgendaExport agendaExport WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agendaExport.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgendaExport exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgendaExport exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgendaExportPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}