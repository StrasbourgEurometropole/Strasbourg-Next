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

import eu.strasbourg.service.agenda.exception.NoSuchCsmapCacheJsonException;
import eu.strasbourg.service.agenda.model.CsmapCacheJson;
import eu.strasbourg.service.agenda.model.CsmapCacheJsonTable;
import eu.strasbourg.service.agenda.model.impl.CsmapCacheJsonImpl;
import eu.strasbourg.service.agenda.model.impl.CsmapCacheJsonModelImpl;
import eu.strasbourg.service.agenda.service.persistence.CsmapCacheJsonPersistence;
import eu.strasbourg.service.agenda.service.persistence.CsmapCacheJsonUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the csmap cache json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class CsmapCacheJsonPersistenceImpl
	extends BasePersistenceImpl<CsmapCacheJson>
	implements CsmapCacheJsonPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsmapCacheJsonUtil</code> to access the csmap cache json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsmapCacheJsonImpl.class.getName();

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
	 * Returns all the csmap cache jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator,
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

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if (!uuid.equals(csmapCacheJson.getUuid())) {
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

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

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
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
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

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByUuid_First(
			String uuid, OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByUuid_First(
			uuid, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByUuid_First(
		String uuid, OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByUuid_Last(
			String uuid, OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByUuid_Last(
			uuid, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByUuid_Last(
		String uuid, OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where uuid = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		uuid = Objects.toString(uuid, "");

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, csmapCacheJson, uuid, orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByUuid_PrevAndNext(
				session, csmapCacheJson, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsmapCacheJson getByUuid_PrevAndNext(
		Session session, CsmapCacheJson csmapCacheJson, String uuid,
		OrderByComparator<CsmapCacheJson> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
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
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CsmapCacheJson csmapCacheJson :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

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
		"csmapCacheJson.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(csmapCacheJson.uuid IS NULL OR csmapCacheJson.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByeventId;
	private FinderPath _finderPathWithoutPaginationFindByeventId;
	private FinderPath _finderPathCountByeventId;

	/**
	 * Returns all the csmap cache jsons where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByeventId(long eventId) {
		return findByeventId(
			eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByeventId(
		long eventId, int start, int end) {

		return findByeventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByeventId(
		long eventId, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByeventId(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByeventId(
		long eventId, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByeventId;
				finderArgs = new Object[] {eventId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByeventId;
			finderArgs = new Object[] {eventId, start, end, orderByComparator};
		}

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if (eventId != csmapCacheJson.getEventId()) {
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

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			sb.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(eventId);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByeventId_First(
			long eventId, OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByeventId_First(
			eventId, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByeventId_First(
		long eventId, OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByeventId(
			eventId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByeventId_Last(
			long eventId, OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByeventId_Last(
			eventId, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("eventId=");
		sb.append(eventId);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByeventId_Last(
		long eventId, OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByeventId(eventId);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByeventId(
			eventId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the csmap cache jsons where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByeventId(long eventId) {
		for (CsmapCacheJson csmapCacheJson :
				findByeventId(
					eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByeventId(long eventId) {
		FinderPath finderPath = _finderPathCountByeventId;

		Object[] finderArgs = new Object[] {eventId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

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
		"csmapCacheJson.eventId = ?";

	private FinderPath _finderPathWithPaginationFindByCreatedDateAndIsActive;
	private FinderPath _finderPathWithPaginationCountByCreatedDateAndIsActive;

	/**
	 * Returns all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActive(
		Date createEvent, boolean isActive) {

		return findByCreatedDateAndIsActive(
			createEvent, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActive(
		Date createEvent, boolean isActive, int start, int end) {

		return findByCreatedDateAndIsActive(
			createEvent, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActive(
		Date createEvent, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByCreatedDateAndIsActive(
			createEvent, isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActive(
		Date createEvent, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByCreatedDateAndIsActive;
		finderArgs = new Object[] {
			_getTime(createEvent), isActive, start, end, orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((createEvent.getTime() > csmapCacheJson.getCreateEvent(
						).getTime()) ||
						(isActive != csmapCacheJson.isIsActive())) {

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

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_2);
			}

			sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				queryPos.add(isActive);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndIsActive_First(
			Date createEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByCreatedDateAndIsActive_First(
			createEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent>=");
		sb.append(createEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndIsActive_First(
		Date createEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByCreatedDateAndIsActive(
			createEvent, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndIsActive_Last(
			Date createEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByCreatedDateAndIsActive_Last(
			createEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent>=");
		sb.append(createEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndIsActive_Last(
		Date createEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByCreatedDateAndIsActive(createEvent, isActive);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByCreatedDateAndIsActive(
			createEvent, isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[] findByCreatedDateAndIsActive_PrevAndNext(
			long eventId, Date createEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByCreatedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, createEvent, isActive,
				orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByCreatedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, createEvent, isActive,
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

	protected CsmapCacheJson getByCreatedDateAndIsActive_PrevAndNext(
		Session session, CsmapCacheJson csmapCacheJson, Date createEvent,
		boolean isActive, OrderByComparator<CsmapCacheJson> orderByComparator,
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

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindCreateEvent = false;

		if (createEvent == null) {
			sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_1);
		}
		else {
			bindCreateEvent = true;

			sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_2);
		}

		sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_ISACTIVE_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCreateEvent) {
			queryPos.add(new Timestamp(createEvent.getTime()));
		}

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 */
	@Override
	public void removeByCreatedDateAndIsActive(
		Date createEvent, boolean isActive) {

		for (CsmapCacheJson csmapCacheJson :
				findByCreatedDateAndIsActive(
					createEvent, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where createEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByCreatedDateAndIsActive(
		Date createEvent, boolean isActive) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByCreatedDateAndIsActive;

		Object[] finderArgs = new Object[] {_getTime(createEvent), isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_2);
			}

			sb.append(_FINDER_COLUMN_CREATEDDATEANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				queryPos.add(isActive);

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
		_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_1 =
			"csmapCacheJson.createEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDISACTIVE_CREATEEVENT_2 =
			"csmapCacheJson.createEvent >= ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDISACTIVE_ISACTIVE_2 =
			"csmapCacheJson.isActive = ?";

	private FinderPath
		_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActive;
	private FinderPath
		_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActive;

	/**
	 * Returns all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive) {

		return findByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive, int start,
		int end) {

		return findByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive, int start,
		int end, OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive, int start,
		int end, OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath =
			_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActive;
		finderArgs = new Object[] {
			_getTime(createEvent), _getTime(modifiedEvent), isActive, start,
			end, orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((createEvent.getTime() <= csmapCacheJson.getCreateEvent(
						).getTime()) ||
						(modifiedEvent.getTime() >
							csmapCacheJson.getModifiedEvent(
							).getTime()) ||
						(isActive != csmapCacheJson.isIsActive())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_2);
			}

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndModifiedDateAndIsActive_First(
			Date createEvent, Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndModifiedDateAndIsActive_First(
				createEvent, modifiedEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent<");
		sb.append(createEvent);

		sb.append(", modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndModifiedDateAndIsActive_First(
		Date createEvent, Date modifiedEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndModifiedDateAndIsActive_Last(
			Date createEvent, Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndModifiedDateAndIsActive_Last(
				createEvent, modifiedEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent<");
		sb.append(createEvent);

		sb.append(", modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndModifiedDateAndIsActive_Last(
		Date createEvent, Date modifiedEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByCreatedDateAndModifiedDateAndIsActive(
			createEvent, modifiedEvent, isActive, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[]
			findByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
				long eventId, Date createEvent, Date modifiedEvent,
				boolean isActive,
				OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, createEvent, modifiedEvent, isActive,
				orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, createEvent, modifiedEvent, isActive,
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

	protected CsmapCacheJson
		getByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
			Session session, CsmapCacheJson csmapCacheJson, Date createEvent,
			Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindCreateEvent = false;

		if (createEvent == null) {
			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_1);
		}
		else {
			bindCreateEvent = true;

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_2);
		}

		boolean bindModifiedEvent = false;

		if (modifiedEvent == null) {
			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
		}
		else {
			bindModifiedEvent = true;

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
		}

		sb.append(
			_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_ISACTIVE_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCreateEvent) {
			queryPos.add(new Timestamp(createEvent.getTime()));
		}

		if (bindModifiedEvent) {
			queryPos.add(new Timestamp(modifiedEvent.getTime()));
		}

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 */
	@Override
	public void removeByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive) {

		for (CsmapCacheJson csmapCacheJson :
				findByCreatedDateAndModifiedDateAndIsActive(
					createEvent, modifiedEvent, isActive, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByCreatedDateAndModifiedDateAndIsActive(
		Date createEvent, Date modifiedEvent, boolean isActive) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActive;

		Object[] finderArgs = new Object[] {
			_getTime(createEvent), _getTime(modifiedEvent), isActive
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_2);
			}

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

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
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_1 =
			"csmapCacheJson.createEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_CREATEEVENT_2 =
			"csmapCacheJson.createEvent < ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1 =
			"csmapCacheJson.modifiedEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2 =
			"csmapCacheJson.modifiedEvent >= ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVE_ISACTIVE_2 =
			"csmapCacheJson.isActive = ?";

	private FinderPath
		_finderPathWithPaginationFindByCreatedDateAndIsActiveAndWithSchedules;
	private FinderPath
		_finderPathWithPaginationCountByCreatedDateAndIsActiveAndWithSchedules;

	/**
	 * Returns all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules) {

		return findByCreatedDateAndIsActiveAndWithSchedules(
			createEvent, isActive, hasSchedules, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules, int start,
		int end) {

		return findByCreatedDateAndIsActiveAndWithSchedules(
			createEvent, isActive, hasSchedules, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules, int start,
		int end, OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByCreatedDateAndIsActiveAndWithSchedules(
			createEvent, isActive, hasSchedules, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules, int start,
		int end, OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath =
			_finderPathWithPaginationFindByCreatedDateAndIsActiveAndWithSchedules;
		finderArgs = new Object[] {
			_getTime(createEvent), isActive, hasSchedules, start, end,
			orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((createEvent.getTime() > csmapCacheJson.getCreateEvent(
						).getTime()) ||
						(isActive != csmapCacheJson.isIsActive()) ||
						(hasSchedules != csmapCacheJson.isHasSchedules())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				queryPos.add(isActive);

				queryPos.add(hasSchedules);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndIsActiveAndWithSchedules_First(
			Date createEvent, boolean isActive, boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndIsActiveAndWithSchedules_First(
				createEvent, isActive, hasSchedules, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent>=");
		sb.append(createEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append(", hasSchedules=");
		sb.append(hasSchedules);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndIsActiveAndWithSchedules_First(
		Date createEvent, boolean isActive, boolean hasSchedules,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list =
			findByCreatedDateAndIsActiveAndWithSchedules(
				createEvent, isActive, hasSchedules, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByCreatedDateAndIsActiveAndWithSchedules_Last(
			Date createEvent, boolean isActive, boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndIsActiveAndWithSchedules_Last(
				createEvent, isActive, hasSchedules, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent>=");
		sb.append(createEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append(", hasSchedules=");
		sb.append(hasSchedules);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByCreatedDateAndIsActiveAndWithSchedules_Last(
		Date createEvent, boolean isActive, boolean hasSchedules,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByCreatedDateAndIsActiveAndWithSchedules(
			createEvent, isActive, hasSchedules);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list =
			findByCreatedDateAndIsActiveAndWithSchedules(
				createEvent, isActive, hasSchedules, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[]
			findByCreatedDateAndIsActiveAndWithSchedules_PrevAndNext(
				long eventId, Date createEvent, boolean isActive,
				boolean hasSchedules,
				OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByCreatedDateAndIsActiveAndWithSchedules_PrevAndNext(
				session, csmapCacheJson, createEvent, isActive, hasSchedules,
				orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByCreatedDateAndIsActiveAndWithSchedules_PrevAndNext(
				session, csmapCacheJson, createEvent, isActive, hasSchedules,
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

	protected CsmapCacheJson
		getByCreatedDateAndIsActiveAndWithSchedules_PrevAndNext(
			Session session, CsmapCacheJson csmapCacheJson, Date createEvent,
			boolean isActive, boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindCreateEvent = false;

		if (createEvent == null) {
			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
		}
		else {
			bindCreateEvent = true;

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
		}

		sb.append(
			_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

		sb.append(
			_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCreateEvent) {
			queryPos.add(new Timestamp(createEvent.getTime()));
		}

		queryPos.add(isActive);

		queryPos.add(hasSchedules);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63; from the database.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 */
	@Override
	public void removeByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules) {

		for (CsmapCacheJson csmapCacheJson :
				findByCreatedDateAndIsActiveAndWithSchedules(
					createEvent, isActive, hasSchedules, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where createEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByCreatedDateAndIsActiveAndWithSchedules(
		Date createEvent, boolean isActive, boolean hasSchedules) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByCreatedDateAndIsActiveAndWithSchedules;

		Object[] finderArgs = new Object[] {
			_getTime(createEvent), isActive, hasSchedules
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				queryPos.add(isActive);

				queryPos.add(hasSchedules);

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
		_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1 =
			"csmapCacheJson.createEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2 =
			"csmapCacheJson.createEvent >= ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2 =
			"csmapCacheJson.isActive = ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2 =
			"csmapCacheJson.hasSchedules = ?";

	private FinderPath
		_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules;
	private FinderPath
		_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules;

	/**
	 * Returns all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson>
		findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules) {

		return findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			createEvent, modifiedEvent, isActive, hasSchedules,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson>
		findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules, int start, int end) {

		return findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			createEvent, modifiedEvent, isActive, hasSchedules, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson>
		findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules, int start, int end,
			OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			createEvent, modifiedEvent, isActive, hasSchedules, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson>
		findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules, int start, int end,
			OrderByComparator<CsmapCacheJson> orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath =
			_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules;
		finderArgs = new Object[] {
			_getTime(createEvent), _getTime(modifiedEvent), isActive,
			hasSchedules, start, end, orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((createEvent.getTime() <= csmapCacheJson.getCreateEvent(
						).getTime()) ||
						(modifiedEvent.getTime() >
							csmapCacheJson.getModifiedEvent(
							).getTime()) ||
						(isActive != csmapCacheJson.isIsActive()) ||
						(hasSchedules != csmapCacheJson.isHasSchedules())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
			}

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

				queryPos.add(hasSchedules);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson
			findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_First(
				Date createEvent, Date modifiedEvent, boolean isActive,
				boolean hasSchedules,
				OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_First(
				createEvent, modifiedEvent, isActive, hasSchedules,
				orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent<");
		sb.append(createEvent);

		sb.append(", modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append(", hasSchedules=");
		sb.append(hasSchedules);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson
		fetchByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_First(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list =
			findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
				createEvent, modifiedEvent, isActive, hasSchedules, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson
			findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_Last(
				Date createEvent, Date modifiedEvent, boolean isActive,
				boolean hasSchedules,
				OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson =
			fetchByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_Last(
				createEvent, modifiedEvent, isActive, hasSchedules,
				orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("createEvent<");
		sb.append(createEvent);

		sb.append(", modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append(", hasSchedules=");
		sb.append(hasSchedules);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson
		fetchByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_Last(
			Date createEvent, Date modifiedEvent, boolean isActive,
			boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count =
			countByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
				createEvent, modifiedEvent, isActive, hasSchedules);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list =
			findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
				createEvent, modifiedEvent, isActive, hasSchedules, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[]
			findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_PrevAndNext(
				long eventId, Date createEvent, Date modifiedEvent,
				boolean isActive, boolean hasSchedules,
				OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] =
				getByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_PrevAndNext(
					session, csmapCacheJson, createEvent, modifiedEvent,
					isActive, hasSchedules, orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] =
				getByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_PrevAndNext(
					session, csmapCacheJson, createEvent, modifiedEvent,
					isActive, hasSchedules, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsmapCacheJson
		getByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules_PrevAndNext(
			Session session, CsmapCacheJson csmapCacheJson, Date createEvent,
			Date modifiedEvent, boolean isActive, boolean hasSchedules,
			OrderByComparator<CsmapCacheJson> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindCreateEvent = false;

		if (createEvent == null) {
			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
		}
		else {
			bindCreateEvent = true;

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
		}

		boolean bindModifiedEvent = false;

		if (modifiedEvent == null) {
			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_1);
		}
		else {
			bindModifiedEvent = true;

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_2);
		}

		sb.append(
			_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

		sb.append(
			_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCreateEvent) {
			queryPos.add(new Timestamp(createEvent.getTime()));
		}

		if (bindModifiedEvent) {
			queryPos.add(new Timestamp(modifiedEvent.getTime()));
		}

		queryPos.add(isActive);

		queryPos.add(hasSchedules);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63; from the database.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 */
	@Override
	public void removeByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
		Date createEvent, Date modifiedEvent, boolean isActive,
		boolean hasSchedules) {

		for (CsmapCacheJson csmapCacheJson :
				findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
					createEvent, modifiedEvent, isActive, hasSchedules,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where createEvent &lt; &#63; and modifiedEvent &ge; &#63; and isActive = &#63; and hasSchedules = &#63;.
	 *
	 * @param createEvent the create event
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param hasSchedules the has schedules
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules(
		Date createEvent, Date modifiedEvent, boolean isActive,
		boolean hasSchedules) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules;

		Object[] finderArgs = new Object[] {
			_getTime(createEvent), _getTime(modifiedEvent), isActive,
			hasSchedules
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindCreateEvent = false;

			if (createEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1);
			}
			else {
				bindCreateEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2);
			}

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_2);
			}

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2);

			sb.append(
				_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCreateEvent) {
					queryPos.add(new Timestamp(createEvent.getTime()));
				}

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

				queryPos.add(hasSchedules);

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
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_1 =
			"csmapCacheJson.createEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_CREATEEVENT_2 =
			"csmapCacheJson.createEvent < ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_1 =
			"csmapCacheJson.modifiedEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_MODIFIEDEVENT_2 =
			"csmapCacheJson.modifiedEvent >= ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_ISACTIVE_2 =
			"csmapCacheJson.isActive = ? AND ";

	private static final String
		_FINDER_COLUMN_CREATEDDATEANDMODIFIEDDATEANDISACTIVEANDWITHSCHEDULES_HASSCHEDULES_2 =
			"csmapCacheJson.hasSchedules = ?";

	private FinderPath _finderPathWithPaginationFindByModifiedDateAndIsActive;
	private FinderPath _finderPathWithPaginationCountByModifiedDateAndIsActive;

	/**
	 * Returns all the csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive) {

		return findByModifiedDateAndIsActive(
			modifiedEvent, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive, int start, int end) {

		return findByModifiedDateAndIsActive(
			modifiedEvent, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByModifiedDateAndIsActive(
			modifiedEvent, isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByModifiedDateAndIsActive;
		finderArgs = new Object[] {
			_getTime(modifiedEvent), isActive, start, end, orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((modifiedEvent.getTime() >
							csmapCacheJson.getModifiedEvent(
							).getTime()) ||
						(isActive != csmapCacheJson.isIsActive())) {

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

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
			}

			sb.append(_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByModifiedDateAndIsActive_First(
			Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByModifiedDateAndIsActive_First(
			modifiedEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByModifiedDateAndIsActive_First(
		Date modifiedEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByModifiedDateAndIsActive(
			modifiedEvent, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByModifiedDateAndIsActive_Last(
			Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByModifiedDateAndIsActive_Last(
			modifiedEvent, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("modifiedEvent>=");
		sb.append(modifiedEvent);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByModifiedDateAndIsActive_Last(
		Date modifiedEvent, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByModifiedDateAndIsActive(modifiedEvent, isActive);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByModifiedDateAndIsActive(
			modifiedEvent, isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[] findByModifiedDateAndIsActive_PrevAndNext(
			long eventId, Date modifiedEvent, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByModifiedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, modifiedEvent, isActive,
				orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByModifiedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, modifiedEvent, isActive,
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

	protected CsmapCacheJson getByModifiedDateAndIsActive_PrevAndNext(
		Session session, CsmapCacheJson csmapCacheJson, Date modifiedEvent,
		boolean isActive, OrderByComparator<CsmapCacheJson> orderByComparator,
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

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindModifiedEvent = false;

		if (modifiedEvent == null) {
			sb.append(_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
		}
		else {
			bindModifiedEvent = true;

			sb.append(_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
		}

		sb.append(_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_ISACTIVE_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindModifiedEvent) {
			queryPos.add(new Timestamp(modifiedEvent.getTime()));
		}

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 */
	@Override
	public void removeByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive) {

		for (CsmapCacheJson csmapCacheJson :
				findByModifiedDateAndIsActive(
					modifiedEvent, isActive, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where modifiedEvent &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedEvent the modified event
	 * @param isActive the is active
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByModifiedDateAndIsActive(
		Date modifiedEvent, boolean isActive) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByModifiedDateAndIsActive;

		Object[] finderArgs = new Object[] {_getTime(modifiedEvent), isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindModifiedEvent = false;

			if (modifiedEvent == null) {
				sb.append(
					_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1);
			}
			else {
				bindModifiedEvent = true;

				sb.append(
					_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2);
			}

			sb.append(_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindModifiedEvent) {
					queryPos.add(new Timestamp(modifiedEvent.getTime()));
				}

				queryPos.add(isActive);

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
		_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_1 =
			"csmapCacheJson.modifiedEvent IS NULL AND ";

	private static final String
		_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_MODIFIEDEVENT_2 =
			"csmapCacheJson.modifiedEvent >= ? AND ";

	private static final String
		_FINDER_COLUMN_MODIFIEDDATEANDISACTIVE_ISACTIVE_2 =
			"csmapCacheJson.isActive = ?";

	private FinderPath
		_finderPathWithPaginationFindByRegeneratedDateAndIsActive;
	private FinderPath
		_finderPathWithPaginationCountByRegeneratedDateAndIsActive;

	/**
	 * Returns all the csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @return the matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive) {

		return findByRegeneratedDateAndIsActive(
			regeneratedDate, isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive, int start, int end) {

		return findByRegeneratedDateAndIsActive(
			regeneratedDate, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findByRegeneratedDateAndIsActive(
			regeneratedDate, isActive, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive, int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRegeneratedDateAndIsActive;
		finderArgs = new Object[] {
			_getTime(regeneratedDate), isActive, start, end, orderByComparator
		};

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CsmapCacheJson csmapCacheJson : list) {
					if ((regeneratedDate.getTime() <
							csmapCacheJson.getRegeneratedDate(
							).getTime()) ||
						(isActive != csmapCacheJson.isIsActive())) {

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

			sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

			boolean bindRegeneratedDate = false;

			if (regeneratedDate == null) {
				sb.append(
					_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_1);
			}
			else {
				bindRegeneratedDate = true;

				sb.append(
					_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_2);
			}

			sb.append(_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegeneratedDate) {
					queryPos.add(new Timestamp(regeneratedDate.getTime()));
				}

				queryPos.add(isActive);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Returns the first csmap cache json in the ordered set where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByRegeneratedDateAndIsActive_First(
			Date regeneratedDate, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByRegeneratedDateAndIsActive_First(
			regeneratedDate, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("regeneratedDate<=");
		sb.append(regeneratedDate);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the first csmap cache json in the ordered set where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByRegeneratedDateAndIsActive_First(
		Date regeneratedDate, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		List<CsmapCacheJson> list = findByRegeneratedDateAndIsActive(
			regeneratedDate, isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last csmap cache json in the ordered set where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson findByRegeneratedDateAndIsActive_Last(
			Date regeneratedDate, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByRegeneratedDateAndIsActive_Last(
			regeneratedDate, isActive, orderByComparator);

		if (csmapCacheJson != null) {
			return csmapCacheJson;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("regeneratedDate<=");
		sb.append(regeneratedDate);

		sb.append(", isActive=");
		sb.append(isActive);

		sb.append("}");

		throw new NoSuchCsmapCacheJsonException(sb.toString());
	}

	/**
	 * Returns the last csmap cache json in the ordered set where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching csmap cache json, or <code>null</code> if a matching csmap cache json could not be found
	 */
	@Override
	public CsmapCacheJson fetchByRegeneratedDateAndIsActive_Last(
		Date regeneratedDate, boolean isActive,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		int count = countByRegeneratedDateAndIsActive(
			regeneratedDate, isActive);

		if (count == 0) {
			return null;
		}

		List<CsmapCacheJson> list = findByRegeneratedDateAndIsActive(
			regeneratedDate, isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the csmap cache jsons before and after the current csmap cache json in the ordered set where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param eventId the primary key of the current csmap cache json
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson[] findByRegeneratedDateAndIsActive_PrevAndNext(
			long eventId, Date regeneratedDate, boolean isActive,
			OrderByComparator<CsmapCacheJson> orderByComparator)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson[] array = new CsmapCacheJsonImpl[3];

			array[0] = getByRegeneratedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, regeneratedDate, isActive,
				orderByComparator, true);

			array[1] = csmapCacheJson;

			array[2] = getByRegeneratedDateAndIsActive_PrevAndNext(
				session, csmapCacheJson, regeneratedDate, isActive,
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

	protected CsmapCacheJson getByRegeneratedDateAndIsActive_PrevAndNext(
		Session session, CsmapCacheJson csmapCacheJson, Date regeneratedDate,
		boolean isActive, OrderByComparator<CsmapCacheJson> orderByComparator,
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

		sb.append(_SQL_SELECT_CSMAPCACHEJSON_WHERE);

		boolean bindRegeneratedDate = false;

		if (regeneratedDate == null) {
			sb.append(
				_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_1);
		}
		else {
			bindRegeneratedDate = true;

			sb.append(
				_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_2);
		}

		sb.append(_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_ISACTIVE_2);

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
			sb.append(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRegeneratedDate) {
			queryPos.add(new Timestamp(regeneratedDate.getTime()));
		}

		queryPos.add(isActive);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csmapCacheJson)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CsmapCacheJson> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63; from the database.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 */
	@Override
	public void removeByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive) {

		for (CsmapCacheJson csmapCacheJson :
				findByRegeneratedDateAndIsActive(
					regeneratedDate, isActive, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons where regeneratedDate &le; &#63; and isActive = &#63;.
	 *
	 * @param regeneratedDate the regenerated date
	 * @param isActive the is active
	 * @return the number of matching csmap cache jsons
	 */
	@Override
	public int countByRegeneratedDateAndIsActive(
		Date regeneratedDate, boolean isActive) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByRegeneratedDateAndIsActive;

		Object[] finderArgs = new Object[] {
			_getTime(regeneratedDate), isActive
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CSMAPCACHEJSON_WHERE);

			boolean bindRegeneratedDate = false;

			if (regeneratedDate == null) {
				sb.append(
					_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_1);
			}
			else {
				bindRegeneratedDate = true;

				sb.append(
					_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_2);
			}

			sb.append(_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRegeneratedDate) {
					queryPos.add(new Timestamp(regeneratedDate.getTime()));
				}

				queryPos.add(isActive);

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
		_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_1 =
			"csmapCacheJson.regeneratedDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_REGENERATEDDATE_2 =
			"csmapCacheJson.regeneratedDate <= ? AND ";

	private static final String
		_FINDER_COLUMN_REGENERATEDDATEANDISACTIVE_ISACTIVE_2 =
			"csmapCacheJson.isActive = ?";

	public CsmapCacheJsonPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CsmapCacheJson.class);

		setModelImplClass(CsmapCacheJsonImpl.class);
		setModelPKClass(long.class);

		setTable(CsmapCacheJsonTable.INSTANCE);
	}

	/**
	 * Caches the csmap cache json in the entity cache if it is enabled.
	 *
	 * @param csmapCacheJson the csmap cache json
	 */
	@Override
	public void cacheResult(CsmapCacheJson csmapCacheJson) {
		entityCache.putResult(
			CsmapCacheJsonImpl.class, csmapCacheJson.getPrimaryKey(),
			csmapCacheJson);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the csmap cache jsons in the entity cache if it is enabled.
	 *
	 * @param csmapCacheJsons the csmap cache jsons
	 */
	@Override
	public void cacheResult(List<CsmapCacheJson> csmapCacheJsons) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (csmapCacheJsons.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CsmapCacheJson csmapCacheJson : csmapCacheJsons) {
			if (entityCache.getResult(
					CsmapCacheJsonImpl.class, csmapCacheJson.getPrimaryKey()) ==
						null) {

				cacheResult(csmapCacheJson);
			}
		}
	}

	/**
	 * Clears the cache for all csmap cache jsons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsmapCacheJsonImpl.class);

		finderCache.clearCache(CsmapCacheJsonImpl.class);
	}

	/**
	 * Clears the cache for the csmap cache json.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsmapCacheJson csmapCacheJson) {
		entityCache.removeResult(CsmapCacheJsonImpl.class, csmapCacheJson);
	}

	@Override
	public void clearCache(List<CsmapCacheJson> csmapCacheJsons) {
		for (CsmapCacheJson csmapCacheJson : csmapCacheJsons) {
			entityCache.removeResult(CsmapCacheJsonImpl.class, csmapCacheJson);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CsmapCacheJsonImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CsmapCacheJsonImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new csmap cache json with the primary key. Does not add the csmap cache json to the database.
	 *
	 * @param eventId the primary key for the new csmap cache json
	 * @return the new csmap cache json
	 */
	@Override
	public CsmapCacheJson create(long eventId) {
		CsmapCacheJson csmapCacheJson = new CsmapCacheJsonImpl();

		csmapCacheJson.setNew(true);
		csmapCacheJson.setPrimaryKey(eventId);

		String uuid = PortalUUIDUtil.generate();

		csmapCacheJson.setUuid(uuid);

		return csmapCacheJson;
	}

	/**
	 * Removes the csmap cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the csmap cache json
	 * @return the csmap cache json that was removed
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson remove(long eventId)
		throws NoSuchCsmapCacheJsonException {

		return remove((Serializable)eventId);
	}

	/**
	 * Removes the csmap cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the csmap cache json
	 * @return the csmap cache json that was removed
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson remove(Serializable primaryKey)
		throws NoSuchCsmapCacheJsonException {

		Session session = null;

		try {
			session = openSession();

			CsmapCacheJson csmapCacheJson = (CsmapCacheJson)session.get(
				CsmapCacheJsonImpl.class, primaryKey);

			if (csmapCacheJson == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsmapCacheJsonException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csmapCacheJson);
		}
		catch (NoSuchCsmapCacheJsonException noSuchEntityException) {
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
	protected CsmapCacheJson removeImpl(CsmapCacheJson csmapCacheJson) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csmapCacheJson)) {
				csmapCacheJson = (CsmapCacheJson)session.get(
					CsmapCacheJsonImpl.class,
					csmapCacheJson.getPrimaryKeyObj());
			}

			if (csmapCacheJson != null) {
				session.delete(csmapCacheJson);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (csmapCacheJson != null) {
			clearCache(csmapCacheJson);
		}

		return csmapCacheJson;
	}

	@Override
	public CsmapCacheJson updateImpl(CsmapCacheJson csmapCacheJson) {
		boolean isNew = csmapCacheJson.isNew();

		if (!(csmapCacheJson instanceof CsmapCacheJsonModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csmapCacheJson.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csmapCacheJson);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csmapCacheJson proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsmapCacheJson implementation " +
					csmapCacheJson.getClass());
		}

		CsmapCacheJsonModelImpl csmapCacheJsonModelImpl =
			(CsmapCacheJsonModelImpl)csmapCacheJson;

		if (Validator.isNull(csmapCacheJson.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			csmapCacheJson.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(csmapCacheJson);
			}
			else {
				csmapCacheJson = (CsmapCacheJson)session.merge(csmapCacheJson);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CsmapCacheJsonImpl.class, csmapCacheJsonModelImpl, false, true);

		if (isNew) {
			csmapCacheJson.setNew(false);
		}

		csmapCacheJson.resetOriginalValues();

		return csmapCacheJson;
	}

	/**
	 * Returns the csmap cache json with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the csmap cache json
	 * @return the csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsmapCacheJsonException {

		CsmapCacheJson csmapCacheJson = fetchByPrimaryKey(primaryKey);

		if (csmapCacheJson == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsmapCacheJsonException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csmapCacheJson;
	}

	/**
	 * Returns the csmap cache json with the primary key or throws a <code>NoSuchCsmapCacheJsonException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the csmap cache json
	 * @return the csmap cache json
	 * @throws NoSuchCsmapCacheJsonException if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson findByPrimaryKey(long eventId)
		throws NoSuchCsmapCacheJsonException {

		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the csmap cache json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the csmap cache json
	 * @return the csmap cache json, or <code>null</code> if a csmap cache json with the primary key could not be found
	 */
	@Override
	public CsmapCacheJson fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the csmap cache jsons.
	 *
	 * @return the csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the csmap cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @return the range of csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findAll(
		int start, int end,
		OrderByComparator<CsmapCacheJson> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the csmap cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CsmapCacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csmap cache jsons
	 * @param end the upper bound of the range of csmap cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of csmap cache jsons
	 */
	@Override
	public List<CsmapCacheJson> findAll(
		int start, int end, OrderByComparator<CsmapCacheJson> orderByComparator,
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

		List<CsmapCacheJson> list = null;

		if (useFinderCache) {
			list = (List<CsmapCacheJson>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CSMAPCACHEJSON);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CSMAPCACHEJSON;

				sql = sql.concat(CsmapCacheJsonModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CsmapCacheJson>)QueryUtil.list(
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
	 * Removes all the csmap cache jsons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsmapCacheJson csmapCacheJson : findAll()) {
			remove(csmapCacheJson);
		}
	}

	/**
	 * Returns the number of csmap cache jsons.
	 *
	 * @return the number of csmap cache jsons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CSMAPCACHEJSON);

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
		return "eventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSMAPCACHEJSON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsmapCacheJsonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the csmap cache json persistence.
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

		_finderPathWithPaginationFindByeventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByeventId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"eventId"}, true);

		_finderPathWithoutPaginationFindByeventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByeventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			true);

		_finderPathCountByeventId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventId",
			new String[] {Long.class.getName()}, new String[] {"eventId"},
			false);

		_finderPathWithPaginationFindByCreatedDateAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreatedDateAndIsActive",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"createEvent", "isActive"}, true);

		_finderPathWithPaginationCountByCreatedDateAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByCreatedDateAndIsActive",
			new String[] {Date.class.getName(), Boolean.class.getName()},
			new String[] {"createEvent", "isActive"}, false);

		_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCreatedDateAndModifiedDateAndIsActive",
				new String[] {
					Date.class.getName(), Date.class.getName(),
					Boolean.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"createEvent", "modifiedEvent", "isActive"},
				true);

		_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByCreatedDateAndModifiedDateAndIsActive",
				new String[] {
					Date.class.getName(), Date.class.getName(),
					Boolean.class.getName()
				},
				new String[] {"createEvent", "modifiedEvent", "isActive"},
				false);

		_finderPathWithPaginationFindByCreatedDateAndIsActiveAndWithSchedules =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCreatedDateAndIsActiveAndWithSchedules",
				new String[] {
					Date.class.getName(), Boolean.class.getName(),
					Boolean.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"createEvent", "isActive", "hasSchedules"}, true);

		_finderPathWithPaginationCountByCreatedDateAndIsActiveAndWithSchedules =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByCreatedDateAndIsActiveAndWithSchedules",
				new String[] {
					Date.class.getName(), Boolean.class.getName(),
					Boolean.class.getName()
				},
				new String[] {"createEvent", "isActive", "hasSchedules"},
				false);

		_finderPathWithPaginationFindByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules",
				new String[] {
					Date.class.getName(), Date.class.getName(),
					Boolean.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {
					"createEvent", "modifiedEvent", "isActive", "hasSchedules"
				},
				true);

		_finderPathWithPaginationCountByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByCreatedDateAndModifiedDateAndIsActiveAndWithSchedules",
				new String[] {
					Date.class.getName(), Date.class.getName(),
					Boolean.class.getName(), Boolean.class.getName()
				},
				new String[] {
					"createEvent", "modifiedEvent", "isActive", "hasSchedules"
				},
				false);

		_finderPathWithPaginationFindByModifiedDateAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByModifiedDateAndIsActive",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"modifiedEvent", "isActive"}, true);

		_finderPathWithPaginationCountByModifiedDateAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByModifiedDateAndIsActive",
				new String[] {Date.class.getName(), Boolean.class.getName()},
				new String[] {"modifiedEvent", "isActive"}, false);

		_finderPathWithPaginationFindByRegeneratedDateAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRegeneratedDateAndIsActive",
				new String[] {
					Date.class.getName(), Boolean.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"regeneratedDate", "isActive"}, true);

		_finderPathWithPaginationCountByRegeneratedDateAndIsActive =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByRegeneratedDateAndIsActive",
				new String[] {Date.class.getName(), Boolean.class.getName()},
				new String[] {"regeneratedDate", "isActive"}, false);

		CsmapCacheJsonUtil.setPersistence(this);
	}

	public void destroy() {
		CsmapCacheJsonUtil.setPersistence(null);

		entityCache.removeCache(CsmapCacheJsonImpl.class.getName());
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

	private static final String _SQL_SELECT_CSMAPCACHEJSON =
		"SELECT csmapCacheJson FROM CsmapCacheJson csmapCacheJson";

	private static final String _SQL_SELECT_CSMAPCACHEJSON_WHERE =
		"SELECT csmapCacheJson FROM CsmapCacheJson csmapCacheJson WHERE ";

	private static final String _SQL_COUNT_CSMAPCACHEJSON =
		"SELECT COUNT(csmapCacheJson) FROM CsmapCacheJson csmapCacheJson";

	private static final String _SQL_COUNT_CSMAPCACHEJSON_WHERE =
		"SELECT COUNT(csmapCacheJson) FROM CsmapCacheJson csmapCacheJson WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csmapCacheJson.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsmapCacheJson exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsmapCacheJson exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsmapCacheJsonPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}