/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import eu.strasbourg.service.council.exception.NoSuchProcurationException;
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.model.ProcurationTable;
import eu.strasbourg.service.council.model.impl.ProcurationImpl;
import eu.strasbourg.service.council.model.impl.ProcurationModelImpl;
import eu.strasbourg.service.council.service.persistence.ProcurationPersistence;
import eu.strasbourg.service.council.service.persistence.ProcurationUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the procuration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProcurationPersistenceImpl
	extends BasePersistenceImpl<Procuration> implements ProcurationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProcurationUtil</code> to access the procuration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProcurationImpl.class.getName();

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
	 * Returns all the procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
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

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if (!uuid.equals(procuration.getUuid())) {
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

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

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
				sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_First(
			String uuid, OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByUuid_First(uuid, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_First(
		String uuid, OrderByComparator<Procuration> orderByComparator) {

		List<Procuration> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_Last(
			String uuid, OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByUuid_Last(uuid, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_Last(
		String uuid, OrderByComparator<Procuration> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByUuid_PrevAndNext(
			long procurationId, String uuid,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		uuid = Objects.toString(uuid, "");

		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, procuration, uuid, orderByComparator, true);

			array[1] = procuration;

			array[2] = getByUuid_PrevAndNext(
				session, procuration, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration getByUuid_PrevAndNext(
		Session session, Procuration procuration, String uuid,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCURATION_WHERE);

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
			sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(procuration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procuration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Procuration procuration :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		"procuration.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(procuration.uuid IS NULL OR procuration.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUUID_G(String uuid, long groupId)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByUUID_G(uuid, groupId);

		if (procuration == null) {
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

			throw new NoSuchProcurationException(sb.toString());
		}

		return procuration;
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Procuration) {
			Procuration procuration = (Procuration)result;

			if (!Objects.equals(uuid, procuration.getUuid()) ||
				(groupId != procuration.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

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

				List<Procuration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Procuration procuration = list.get(0);

					result = procuration;

					cacheResult(procuration);
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
			return (Procuration)result;
		}
	}

	/**
	 * Removes the procuration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procuration that was removed
	 */
	@Override
	public Procuration removeByUUID_G(String uuid, long groupId)
		throws NoSuchProcurationException {

		Procuration procuration = findByUUID_G(uuid, groupId);

		return remove(procuration);
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		"procuration.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(procuration.uuid IS NULL OR procuration.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"procuration.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
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

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if (!uuid.equals(procuration.getUuid()) ||
						(companyId != procuration.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

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
				sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {

		List<Procuration> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByUuid_C_PrevAndNext(
			long procurationId, String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		uuid = Objects.toString(uuid, "");

		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, procuration, uuid, companyId, orderByComparator, true);

			array[1] = procuration;

			array[2] = getByUuid_C_PrevAndNext(
				session, procuration, uuid, companyId, orderByComparator,
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

	protected Procuration getByUuid_C_PrevAndNext(
		Session session, Procuration procuration, String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROCURATION_WHERE);

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
			sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(procuration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procuration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Procuration procuration :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		"procuration.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(procuration.uuid IS NULL OR procuration.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"procuration.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByCouncilSessionId;
	private FinderPath _finderPathWithoutPaginationFindByCouncilSessionId;
	private FinderPath _finderPathCountByCouncilSessionId;

	/**
	 * Returns all the procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(long councilSessionId) {
		return findByCouncilSessionId(
			councilSessionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end) {

		return findByCouncilSessionId(councilSessionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return findByCouncilSessionId(
			councilSessionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCouncilSessionId;
				finderArgs = new Object[] {councilSessionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCouncilSessionId;
			finderArgs = new Object[] {
				councilSessionId, start, end, orderByComparator
			};
		}

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if (councilSessionId != procuration.getCouncilSessionId()) {
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

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

			sb.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionId_First(
			long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByCouncilSessionId_First(
			councilSessionId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionId_First(
		long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {

		List<Procuration> list = findByCouncilSessionId(
			councilSessionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionId_Last(
			long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByCouncilSessionId_Last(
			councilSessionId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionId_Last(
		long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {

		int count = countByCouncilSessionId(councilSessionId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByCouncilSessionId(
			councilSessionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByCouncilSessionId_PrevAndNext(
			long procurationId, long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByCouncilSessionId_PrevAndNext(
				session, procuration, councilSessionId, orderByComparator,
				true);

			array[1] = procuration;

			array[2] = getByCouncilSessionId_PrevAndNext(
				session, procuration, councilSessionId, orderByComparator,
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

	protected Procuration getByCouncilSessionId_PrevAndNext(
		Session session, Procuration procuration, long councilSessionId,
		OrderByComparator<Procuration> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROCURATION_WHERE);

		sb.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

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
			sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(councilSessionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procuration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procuration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 */
	@Override
	public void removeByCouncilSessionId(long councilSessionId) {
		for (Procuration procuration :
				findByCouncilSessionId(
					councilSessionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionId(long councilSessionId) {
		FinderPath finderPath = _finderPathCountByCouncilSessionId;

		Object[] finderArgs = new Object[] {councilSessionId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

			sb.append(_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_COUNCILSESSIONID_COUNCILSESSIONID_2 =
			"procuration.councilSessionId = ?";

	private FinderPath
		_finderPathWithPaginationFindByCouncilSessionIdAndOfficialVotersId;
	private FinderPath
		_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialVotersId;
	private FinderPath _finderPathCountByCouncilSessionIdAndOfficialVotersId;

	/**
	 * Returns all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		return findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end) {

		return findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialVotersId;
				finderArgs = new Object[] {councilSessionId, officialVotersId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCouncilSessionIdAndOfficialVotersId;
			finderArgs = new Object[] {
				councilSessionId, officialVotersId, start, end,
				orderByComparator
			};
		}

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if ((councilSessionId !=
							procuration.getCouncilSessionId()) ||
						(officialVotersId !=
							procuration.getOfficialVotersId())) {

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

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialVotersId);

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialVotersId_First(
			long councilSessionId, long officialVotersId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration =
			fetchByCouncilSessionIdAndOfficialVotersId_First(
				councilSessionId, officialVotersId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append(", officialVotersId=");
		sb.append(officialVotersId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialVotersId_First(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {

		List<Procuration> list = findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialVotersId_Last(
			long councilSessionId, long officialVotersId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration =
			fetchByCouncilSessionIdAndOfficialVotersId_Last(
				councilSessionId, officialVotersId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append(", officialVotersId=");
		sb.append(officialVotersId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialVotersId_Last(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {

		int count = countByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[] findByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
			long procurationId, long councilSessionId, long officialVotersId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] = getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
				session, procuration, councilSessionId, officialVotersId,
				orderByComparator, true);

			array[1] = procuration;

			array[2] = getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
				session, procuration, councilSessionId, officialVotersId,
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

	protected Procuration getByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
		Session session, Procuration procuration, long councilSessionId,
		long officialVotersId, OrderByComparator<Procuration> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCURATION_WHERE);

		sb.append(
			_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

		sb.append(
			_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

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
			sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(councilSessionId);

		queryPos.add(officialVotersId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procuration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procuration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; and officialVotersId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 */
	@Override
	public void removeByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		for (Procuration procuration :
				findByCouncilSessionIdAndOfficialVotersId(
					councilSessionId, officialVotersId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		FinderPath finderPath =
			_finderPathCountByCouncilSessionIdAndOfficialVotersId;

		Object[] finderArgs = new Object[] {councilSessionId, officialVotersId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialVotersId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_COUNCILSESSIONID_2 =
			"procuration.councilSessionId = ? AND ";

	private static final String
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSID_OFFICIALVOTERSID_2 =
			"procuration.officialVotersId = ?";

	private FinderPath
		_finderPathWithPaginationFindByCouncilSessionIdAndOfficialUnavailableId;
	private FinderPath
		_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialUnavailableId;
	private FinderPath
		_finderPathCountByCouncilSessionIdAndOfficialUnavailableId;

	/**
	 * Returns all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId) {

		return findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId, int start, int end) {

		return findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	@Override
	public List<Procuration> findByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialUnavailableId;
				finderArgs = new Object[] {
					councilSessionId, officialUnavailableId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByCouncilSessionIdAndOfficialUnavailableId;
			finderArgs = new Object[] {
				councilSessionId, officialUnavailableId, start, end,
				orderByComparator
			};
		}

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Procuration procuration : list) {
					if ((councilSessionId !=
							procuration.getCouncilSessionId()) ||
						(officialUnavailableId !=
							procuration.getOfficialUnavailableId())) {

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

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_OFFICIALUNAVAILABLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialUnavailableId);

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialUnavailableId_First(
			long councilSessionId, long officialUnavailableId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration =
			fetchByCouncilSessionIdAndOfficialUnavailableId_First(
				councilSessionId, officialUnavailableId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append(", officialUnavailableId=");
		sb.append(officialUnavailableId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialUnavailableId_First(
		long councilSessionId, long officialUnavailableId,
		OrderByComparator<Procuration> orderByComparator) {

		List<Procuration> list = findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialUnavailableId_Last(
			long councilSessionId, long officialUnavailableId,
			OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration =
			fetchByCouncilSessionIdAndOfficialUnavailableId_Last(
				councilSessionId, officialUnavailableId, orderByComparator);

		if (procuration != null) {
			return procuration;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("councilSessionId=");
		sb.append(councilSessionId);

		sb.append(", officialUnavailableId=");
		sb.append(officialUnavailableId);

		sb.append("}");

		throw new NoSuchProcurationException(sb.toString());
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByCouncilSessionIdAndOfficialUnavailableId_Last(
		long councilSessionId, long officialUnavailableId,
		OrderByComparator<Procuration> orderByComparator) {

		int count = countByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId);

		if (count == 0) {
			return null;
		}

		List<Procuration> list = findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration[]
			findByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
				long procurationId, long councilSessionId,
				long officialUnavailableId,
				OrderByComparator<Procuration> orderByComparator)
		throws NoSuchProcurationException {

		Procuration procuration = findByPrimaryKey(procurationId);

		Session session = null;

		try {
			session = openSession();

			Procuration[] array = new ProcurationImpl[3];

			array[0] =
				getByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
					session, procuration, councilSessionId,
					officialUnavailableId, orderByComparator, true);

			array[1] = procuration;

			array[2] =
				getByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
					session, procuration, councilSessionId,
					officialUnavailableId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Procuration
		getByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
			Session session, Procuration procuration, long councilSessionId,
			long officialUnavailableId,
			OrderByComparator<Procuration> orderByComparator,
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

		sb.append(_SQL_SELECT_PROCURATION_WHERE);

		sb.append(
			_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_COUNCILSESSIONID_2);

		sb.append(
			_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_OFFICIALUNAVAILABLEID_2);

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
			sb.append(ProcurationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(councilSessionId);

		queryPos.add(officialUnavailableId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(procuration)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Procuration> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 */
	@Override
	public void removeByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId) {

		for (Procuration procuration :
				findByCouncilSessionIdAndOfficialUnavailableId(
					councilSessionId, officialUnavailableId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId) {

		FinderPath finderPath =
			_finderPathCountByCouncilSessionIdAndOfficialUnavailableId;

		Object[] finderArgs = new Object[] {
			councilSessionId, officialUnavailableId
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_OFFICIALUNAVAILABLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialUnavailableId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_COUNCILSESSIONID_2 =
			"procuration.councilSessionId = ? AND ";

	private static final String
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALUNAVAILABLEID_OFFICIALUNAVAILABLEID_2 =
			"procuration.officialUnavailableId = ?";

	private FinderPath
		_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds;
	private FinderPath
		_finderPathCountByCouncilSessionIdAndOfficialVotersAndUnavailableIds;

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVotersId,
			long officialUnavailableId)
		throws NoSuchProcurationException {

		Procuration procuration =
			fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);

		if (procuration == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("councilSessionId=");
			sb.append(councilSessionId);

			sb.append(", officialVotersId=");
			sb.append(officialVotersId);

			sb.append(", officialUnavailableId=");
			sb.append(officialUnavailableId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProcurationException(sb.toString());
		}

		return procuration;
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration
		fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVotersId,
			long officialUnavailableId) {

		return fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			councilSessionId, officialVotersId, officialUnavailableId, true);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration
		fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVotersId,
			long officialUnavailableId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				councilSessionId, officialVotersId, officialUnavailableId
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds,
				finderArgs, this);
		}

		if (result instanceof Procuration) {
			Procuration procuration = (Procuration)result;

			if ((councilSessionId != procuration.getCouncilSessionId()) ||
				(officialVotersId != procuration.getOfficialVotersId()) ||
				(officialUnavailableId !=
					procuration.getOfficialUnavailableId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALVOTERSID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALUNAVAILABLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialVotersId);

				queryPos.add(officialUnavailableId);

				List<Procuration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									councilSessionId, officialVotersId,
									officialUnavailableId
								};
							}

							_log.warn(
								"ProcurationPersistenceImpl.fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Procuration procuration = list.get(0);

					result = procuration;

					cacheResult(procuration);
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
			return (Procuration)result;
		}
	}

	/**
	 * Removes the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the procuration that was removed
	 */
	@Override
	public Procuration
			removeByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				long councilSessionId, long officialVotersId,
				long officialUnavailableId)
		throws NoSuchProcurationException {

		Procuration procuration =
			findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);

		return remove(procuration);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the number of matching procurations
	 */
	@Override
	public int countByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
		long councilSessionId, long officialVotersId,
		long officialUnavailableId) {

		FinderPath finderPath =
			_finderPathCountByCouncilSessionIdAndOfficialVotersAndUnavailableIds;

		Object[] finderArgs = new Object[] {
			councilSessionId, officialVotersId, officialUnavailableId
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALVOTERSID_2);

			sb.append(
				_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALUNAVAILABLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialVotersId);

				queryPos.add(officialUnavailableId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_COUNCILSESSIONID_2 =
			"procuration.councilSessionId = ? AND ";

	private static final String
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALVOTERSID_2 =
			"procuration.officialVotersId = ? AND ";

	private static final String
		_FINDER_COLUMN_COUNCILSESSIONIDANDOFFICIALVOTERSANDUNAVAILABLEIDS_OFFICIALUNAVAILABLEID_2 =
			"procuration.officialUnavailableId = ?";

	private FinderPath _finderPathFetchByAbsenceForCouncilSession;
	private FinderPath _finderPathCountByAbsenceForCouncilSession;

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	@Override
	public Procuration findByAbsenceForCouncilSession(
			long councilSessionId, long officialUnavailableId, boolean isAbsent)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);

		if (procuration == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("councilSessionId=");
			sb.append(councilSessionId);

			sb.append(", officialUnavailableId=");
			sb.append(officialUnavailableId);

			sb.append(", isAbsent=");
			sb.append(isAbsent);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProcurationException(sb.toString());
		}

		return procuration;
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent) {

		return fetchByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent, true);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	@Override
	public Procuration fetchByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				councilSessionId, officialUnavailableId, isAbsent
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByAbsenceForCouncilSession, finderArgs, this);
		}

		if (result instanceof Procuration) {
			Procuration procuration = (Procuration)result;

			if ((councilSessionId != procuration.getCouncilSessionId()) ||
				(officialUnavailableId !=
					procuration.getOfficialUnavailableId()) ||
				(isAbsent != procuration.isIsAbsent())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_OFFICIALUNAVAILABLEID_2);

			sb.append(_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_ISABSENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialUnavailableId);

				queryPos.add(isAbsent);

				List<Procuration> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByAbsenceForCouncilSession,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									councilSessionId, officialUnavailableId,
									isAbsent
								};
							}

							_log.warn(
								"ProcurationPersistenceImpl.fetchByAbsenceForCouncilSession(long, long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Procuration procuration = list.get(0);

					result = procuration;

					cacheResult(procuration);
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
			return (Procuration)result;
		}
	}

	/**
	 * Removes the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the procuration that was removed
	 */
	@Override
	public Procuration removeByAbsenceForCouncilSession(
			long councilSessionId, long officialUnavailableId, boolean isAbsent)
		throws NoSuchProcurationException {

		Procuration procuration = findByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);

		return remove(procuration);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the number of matching procurations
	 */
	@Override
	public int countByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent) {

		FinderPath finderPath = _finderPathCountByAbsenceForCouncilSession;

		Object[] finderArgs = new Object[] {
			councilSessionId, officialUnavailableId, isAbsent
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROCURATION_WHERE);

			sb.append(
				_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_COUNCILSESSIONID_2);

			sb.append(
				_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_OFFICIALUNAVAILABLEID_2);

			sb.append(_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_ISABSENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(councilSessionId);

				queryPos.add(officialUnavailableId);

				queryPos.add(isAbsent);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_COUNCILSESSIONID_2 =
			"procuration.councilSessionId = ? AND ";

	private static final String
		_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_OFFICIALUNAVAILABLEID_2 =
			"procuration.officialUnavailableId = ? AND ";

	private static final String
		_FINDER_COLUMN_ABSENCEFORCOUNCILSESSION_ISABSENT_2 =
			"procuration.isAbsent = ?";

	public ProcurationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Procuration.class);

		setModelImplClass(ProcurationImpl.class);
		setModelPKClass(long.class);

		setTable(ProcurationTable.INSTANCE);
	}

	/**
	 * Caches the procuration in the entity cache if it is enabled.
	 *
	 * @param procuration the procuration
	 */
	@Override
	public void cacheResult(Procuration procuration) {
		dummyEntityCache.putResult(
			ProcurationImpl.class, procuration.getPrimaryKey(), procuration);

		dummyFinderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {procuration.getUuid(), procuration.getGroupId()},
			procuration);

		dummyFinderCache.putResult(
			_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds,
			new Object[] {
				procuration.getCouncilSessionId(),
				procuration.getOfficialVotersId(),
				procuration.getOfficialUnavailableId()
			},
			procuration);

		dummyFinderCache.putResult(
			_finderPathFetchByAbsenceForCouncilSession,
			new Object[] {
				procuration.getCouncilSessionId(),
				procuration.getOfficialUnavailableId(), procuration.isIsAbsent()
			},
			procuration);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the procurations in the entity cache if it is enabled.
	 *
	 * @param procurations the procurations
	 */
	@Override
	public void cacheResult(List<Procuration> procurations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (procurations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Procuration procuration : procurations) {
			if (dummyEntityCache.getResult(
					ProcurationImpl.class, procuration.getPrimaryKey()) ==
						null) {

				cacheResult(procuration);
			}
		}
	}

	/**
	 * Clears the cache for all procurations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ProcurationImpl.class);

		dummyFinderCache.clearCache(ProcurationImpl.class);
	}

	/**
	 * Clears the cache for the procuration.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Procuration procuration) {
		dummyEntityCache.removeResult(ProcurationImpl.class, procuration);
	}

	@Override
	public void clearCache(List<Procuration> procurations) {
		for (Procuration procuration : procurations) {
			dummyEntityCache.removeResult(ProcurationImpl.class, procuration);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(ProcurationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ProcurationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProcurationModelImpl procurationModelImpl) {

		Object[] args = new Object[] {
			procurationModelImpl.getUuid(), procurationModelImpl.getGroupId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1));
		dummyFinderCache.putResult(
			_finderPathFetchByUUID_G, args, procurationModelImpl);

		args = new Object[] {
			procurationModelImpl.getCouncilSessionId(),
			procurationModelImpl.getOfficialVotersId(),
			procurationModelImpl.getOfficialUnavailableId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByCouncilSessionIdAndOfficialVotersAndUnavailableIds,
			args, Long.valueOf(1));
		dummyFinderCache.putResult(
			_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds,
			args, procurationModelImpl);

		args = new Object[] {
			procurationModelImpl.getCouncilSessionId(),
			procurationModelImpl.getOfficialUnavailableId(),
			procurationModelImpl.isIsAbsent()
		};

		dummyFinderCache.putResult(
			_finderPathCountByAbsenceForCouncilSession, args, Long.valueOf(1));
		dummyFinderCache.putResult(
			_finderPathFetchByAbsenceForCouncilSession, args,
			procurationModelImpl);
	}

	/**
	 * Creates a new procuration with the primary key. Does not add the procuration to the database.
	 *
	 * @param procurationId the primary key for the new procuration
	 * @return the new procuration
	 */
	@Override
	public Procuration create(long procurationId) {
		Procuration procuration = new ProcurationImpl();

		procuration.setNew(true);
		procuration.setPrimaryKey(procurationId);

		String uuid = PortalUUIDUtil.generate();

		procuration.setUuid(uuid);

		procuration.setCompanyId(CompanyThreadLocal.getCompanyId());

		return procuration;
	}

	/**
	 * Removes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration remove(long procurationId)
		throws NoSuchProcurationException {

		return remove((Serializable)procurationId);
	}

	/**
	 * Removes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration remove(Serializable primaryKey)
		throws NoSuchProcurationException {

		Session session = null;

		try {
			session = openSession();

			Procuration procuration = (Procuration)session.get(
				ProcurationImpl.class, primaryKey);

			if (procuration == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProcurationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(procuration);
		}
		catch (NoSuchProcurationException noSuchEntityException) {
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
	protected Procuration removeImpl(Procuration procuration) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(procuration)) {
				procuration = (Procuration)session.get(
					ProcurationImpl.class, procuration.getPrimaryKeyObj());
			}

			if (procuration != null) {
				session.delete(procuration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (procuration != null) {
			clearCache(procuration);
		}

		return procuration;
	}

	@Override
	public Procuration updateImpl(Procuration procuration) {
		boolean isNew = procuration.isNew();

		if (!(procuration instanceof ProcurationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(procuration.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(procuration);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in procuration proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Procuration implementation " +
					procuration.getClass());
		}

		ProcurationModelImpl procurationModelImpl =
			(ProcurationModelImpl)procuration;

		if (Validator.isNull(procuration.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			procuration.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (procuration.getCreateDate() == null)) {
			if (serviceContext == null) {
				procuration.setCreateDate(date);
			}
			else {
				procuration.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!procurationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				procuration.setModifiedDate(date);
			}
			else {
				procuration.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(procuration);
			}
			else {
				procuration = (Procuration)session.merge(procuration);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ProcurationImpl.class, procurationModelImpl, false, true);

		cacheUniqueFindersCache(procurationModelImpl);

		if (isNew) {
			procuration.setNew(false);
		}

		procuration.resetOriginalValues();

		return procuration;
	}

	/**
	 * Returns the procuration with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the procuration
	 * @return the procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProcurationException {

		Procuration procuration = fetchByPrimaryKey(primaryKey);

		if (procuration == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProcurationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return procuration;
	}

	/**
	 * Returns the procuration with the primary key or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration findByPrimaryKey(long procurationId)
		throws NoSuchProcurationException {

		return findByPrimaryKey((Serializable)procurationId);
	}

	/**
	 * Returns the procuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration, or <code>null</code> if a procuration with the primary key could not be found
	 */
	@Override
	public Procuration fetchByPrimaryKey(long procurationId) {
		return fetchByPrimaryKey((Serializable)procurationId);
	}

	/**
	 * Returns all the procurations.
	 *
	 * @return the procurations
	 */
	@Override
	public List<Procuration> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of procurations
	 */
	@Override
	public List<Procuration> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procurations
	 */
	@Override
	public List<Procuration> findAll(
		int start, int end, OrderByComparator<Procuration> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procurations
	 */
	@Override
	public List<Procuration> findAll(
		int start, int end, OrderByComparator<Procuration> orderByComparator,
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

		List<Procuration> list = null;

		if (useFinderCache) {
			list = (List<Procuration>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROCURATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROCURATION;

				sql = sql.concat(ProcurationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Procuration>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the procurations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Procuration procuration : findAll()) {
			remove(procuration);
		}
	}

	/**
	 * Returns the number of procurations.
	 *
	 * @return the number of procurations
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROCURATION);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
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
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "procurationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROCURATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProcurationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the procuration persistence.
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

		_finderPathWithPaginationFindByCouncilSessionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCouncilSessionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"councilSessionId"}, true);

		_finderPathWithoutPaginationFindByCouncilSessionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCouncilSessionId",
			new String[] {Long.class.getName()},
			new String[] {"councilSessionId"}, true);

		_finderPathCountByCouncilSessionId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCouncilSessionId", new String[] {Long.class.getName()},
			new String[] {"councilSessionId"}, false);

		_finderPathWithPaginationFindByCouncilSessionIdAndOfficialVotersId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCouncilSessionIdAndOfficialVotersId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"councilSessionId", "officialVotersId"}, true);

		_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialVotersId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCouncilSessionIdAndOfficialVotersId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"councilSessionId", "officialVotersId"}, true);

		_finderPathCountByCouncilSessionIdAndOfficialVotersId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCouncilSessionIdAndOfficialVotersId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"councilSessionId", "officialVotersId"}, false);

		_finderPathWithPaginationFindByCouncilSessionIdAndOfficialUnavailableId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByCouncilSessionIdAndOfficialUnavailableId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"councilSessionId", "officialUnavailableId"},
				true);

		_finderPathWithoutPaginationFindByCouncilSessionIdAndOfficialUnavailableId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCouncilSessionIdAndOfficialUnavailableId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"councilSessionId", "officialUnavailableId"},
				true);

		_finderPathCountByCouncilSessionIdAndOfficialUnavailableId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByCouncilSessionIdAndOfficialUnavailableId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"councilSessionId", "officialUnavailableId"},
				false);

		_finderPathFetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"councilSessionId", "officialVotersId",
					"officialUnavailableId"
				},
				true);

		_finderPathCountByCouncilSessionIdAndOfficialVotersAndUnavailableIds =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByCouncilSessionIdAndOfficialVotersAndUnavailableIds",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"councilSessionId", "officialVotersId",
					"officialUnavailableId"
				},
				false);

		_finderPathFetchByAbsenceForCouncilSession = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAbsenceForCouncilSession",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {
				"councilSessionId", "officialUnavailableId", "isAbsent"
			},
			true);

		_finderPathCountByAbsenceForCouncilSession = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByAbsenceForCouncilSession",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {
				"councilSessionId", "officialUnavailableId", "isAbsent"
			},
			false);

		ProcurationUtil.setPersistence(this);
	}

	public void destroy() {
		ProcurationUtil.setPersistence(null);

		dummyEntityCache.removeCache(ProcurationImpl.class.getName());
	}

	private static final String _SQL_SELECT_PROCURATION =
		"SELECT procuration FROM Procuration procuration";

	private static final String _SQL_SELECT_PROCURATION_WHERE =
		"SELECT procuration FROM Procuration procuration WHERE ";

	private static final String _SQL_COUNT_PROCURATION =
		"SELECT COUNT(procuration) FROM Procuration procuration";

	private static final String _SQL_COUNT_PROCURATION_WHERE =
		"SELECT COUNT(procuration) FROM Procuration procuration WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "procuration.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Procuration exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Procuration exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProcurationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

}