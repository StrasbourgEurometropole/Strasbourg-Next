/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence.impl;

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

import eu.strasbourg.service.project.exception.NoSuchInitiativeException;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.InitiativeTable;
import eu.strasbourg.service.project.model.impl.InitiativeImpl;
import eu.strasbourg.service.project.model.impl.InitiativeModelImpl;
import eu.strasbourg.service.project.service.persistence.InitiativePersistence;
import eu.strasbourg.service.project.service.persistence.InitiativeUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the initiative service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class InitiativePersistenceImpl
	extends BasePersistenceImpl<Initiative> implements InitiativePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InitiativeUtil</code> to access the initiative persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InitiativeImpl.class.getName();

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
	 * Returns all the initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
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

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Initiative initiative : list) {
					if (!uuid.equals(initiative.getUuid())) {
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

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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
				sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Initiative>)QueryUtil.list(
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
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByUuid_First(
			String uuid, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByUuid_First(uuid, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUuid_First(
		String uuid, OrderByComparator<Initiative> orderByComparator) {

		List<Initiative> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByUuid_Last(
			String uuid, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByUuid_Last(uuid, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUuid_Last(
		String uuid, OrderByComparator<Initiative> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Initiative> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where uuid = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative[] findByUuid_PrevAndNext(
			long initiativeId, String uuid,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		uuid = Objects.toString(uuid, "");

		Initiative initiative = findByPrimaryKey(initiativeId);

		Session session = null;

		try {
			session = openSession();

			Initiative[] array = new InitiativeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, initiative, uuid, orderByComparator, true);

			array[1] = initiative;

			array[2] = getByUuid_PrevAndNext(
				session, initiative, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Initiative getByUuid_PrevAndNext(
		Session session, Initiative initiative, String uuid,
		OrderByComparator<Initiative> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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
			sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(initiative)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Initiative> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiatives where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Initiative initiative :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching initiatives
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

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
		"initiative.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(initiative.uuid IS NULL OR initiative.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByUUID_G(uuid, groupId);

		if (initiative == null) {
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

			throw new NoSuchInitiativeException(sb.toString());
		}

		return initiative;
	}

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUUID_G(
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

		if (result instanceof Initiative) {
			Initiative initiative = (Initiative)result;

			if (!Objects.equals(uuid, initiative.getUuid()) ||
				(groupId != initiative.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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

				List<Initiative> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Initiative initiative = list.get(0);

					result = initiative;

					cacheResult(initiative);
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
			return (Initiative)result;
		}
	}

	/**
	 * Removes the initiative where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the initiative that was removed
	 */
	@Override
	public Initiative removeByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeException {

		Initiative initiative = findByUUID_G(uuid, groupId);

		return remove(initiative);
	}

	/**
	 * Returns the number of initiatives where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

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
		"initiative.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(initiative.uuid IS NULL OR initiative.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"initiative.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
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

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Initiative initiative : list) {
					if (!uuid.equals(initiative.getUuid()) ||
						(companyId != initiative.getCompanyId())) {

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

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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
				sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
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

				list = (List<Initiative>)QueryUtil.list(
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
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Initiative> orderByComparator) {

		List<Initiative> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Initiative> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Initiative> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative[] findByUuid_C_PrevAndNext(
			long initiativeId, String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		uuid = Objects.toString(uuid, "");

		Initiative initiative = findByPrimaryKey(initiativeId);

		Session session = null;

		try {
			session = openSession();

			Initiative[] array = new InitiativeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, initiative, uuid, companyId, orderByComparator, true);

			array[1] = initiative;

			array[2] = getByUuid_C_PrevAndNext(
				session, initiative, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Initiative getByUuid_C_PrevAndNext(
		Session session, Initiative initiative, String uuid, long companyId,
		OrderByComparator<Initiative> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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
			sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(initiative)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Initiative> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiatives where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Initiative initiative :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching initiatives
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

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
		"initiative.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(initiative.uuid IS NULL OR initiative.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"initiative.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	@Override
	public List<Initiative> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	@Override
	public List<Initiative> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
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

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Initiative initiative : list) {
					if (groupId != initiative.getGroupId()) {
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

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Initiative>)QueryUtil.list(
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
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByGroupId_First(
			long groupId, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByGroupId_First(
			groupId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByGroupId_First(
		long groupId, OrderByComparator<Initiative> orderByComparator) {

		List<Initiative> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByGroupId_Last(
			long groupId, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByGroupId_Last(groupId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByGroupId_Last(
		long groupId, OrderByComparator<Initiative> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Initiative> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where groupId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative[] findByGroupId_PrevAndNext(
			long initiativeId, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = findByPrimaryKey(initiativeId);

		Session session = null;

		try {
			session = openSession();

			Initiative[] array = new InitiativeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, initiative, groupId, orderByComparator, true);

			array[1] = initiative;

			array[2] = getByGroupId_PrevAndNext(
				session, initiative, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Initiative getByGroupId_PrevAndNext(
		Session session, Initiative initiative, long groupId,
		OrderByComparator<Initiative> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVE_WHERE);

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
			sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(initiative)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Initiative> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiatives where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Initiative initiative :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

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
		"initiative.groupId = ?";

	private FinderPath _finderPathWithPaginationFindBypublikId;
	private FinderPath _finderPathWithoutPaginationFindBypublikId;
	private FinderPath _finderPathCountBypublikId;

	/**
	 * Returns all the initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching initiatives
	 */
	@Override
	public List<Initiative> findBypublikId(String publikId) {
		return findBypublikId(
			publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	@Override
	public List<Initiative> findBypublikId(
		String publikId, int start, int end) {

		return findBypublikId(publikId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return findBypublikId(publikId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypublikId;
				finderArgs = new Object[] {publikId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypublikId;
			finderArgs = new Object[] {publikId, start, end, orderByComparator};
		}

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Initiative initiative : list) {
					if (!publikId.equals(initiative.getPublikId())) {
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

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
				}

				list = (List<Initiative>)QueryUtil.list(
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
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findBypublikId_First(
			String publikId, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchBypublikId_First(
			publikId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchBypublikId_First(
		String publikId, OrderByComparator<Initiative> orderByComparator) {

		List<Initiative> list = findBypublikId(
			publikId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findBypublikId_Last(
			String publikId, OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchBypublikId_Last(
			publikId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchBypublikId_Last(
		String publikId, OrderByComparator<Initiative> orderByComparator) {

		int count = countBypublikId(publikId);

		if (count == 0) {
			return null;
		}

		List<Initiative> list = findBypublikId(
			publikId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where publikId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative[] findBypublikId_PrevAndNext(
			long initiativeId, String publikId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		publikId = Objects.toString(publikId, "");

		Initiative initiative = findByPrimaryKey(initiativeId);

		Session session = null;

		try {
			session = openSession();

			Initiative[] array = new InitiativeImpl[3];

			array[0] = getBypublikId_PrevAndNext(
				session, initiative, publikId, orderByComparator, true);

			array[1] = initiative;

			array[2] = getBypublikId_PrevAndNext(
				session, initiative, publikId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Initiative getBypublikId_PrevAndNext(
		Session session, Initiative initiative, String publikId,
		OrderByComparator<Initiative> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVE_WHERE);

		boolean bindPublikId = false;

		if (publikId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
		}
		else {
			bindPublikId = true;

			sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
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
			sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPublikId) {
			queryPos.add(publikId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(initiative)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Initiative> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiatives where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	@Override
	public void removeBypublikId(String publikId) {
		for (Initiative initiative :
				findBypublikId(
					publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching initiatives
	 */
	@Override
	public int countBypublikId(String publikId) {
		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountBypublikId;

		Object[] finderArgs = new Object[] {publikId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
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

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_2 =
		"initiative.publikId = ?";

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_3 =
		"(initiative.publikId IS NULL OR initiative.publikId = '')";

	private FinderPath _finderPathWithPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathWithoutPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathCountByStatusAndGroupId;

	/**
	 * Returns all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	@Override
	public List<Initiative> findByStatusAndGroupId(int status, long groupId) {
		return findByStatusAndGroupId(
			status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	@Override
	public List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return findByStatusAndGroupId(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	@Override
	public List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatusAndGroupId;
				finderArgs = new Object[] {status, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusAndGroupId;
			finderArgs = new Object[] {
				status, groupId, start, end, orderByComparator
			};
		}

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Initiative initiative : list) {
					if ((status != initiative.getStatus()) ||
						(groupId != initiative.getGroupId())) {

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

			sb.append(_SQL_SELECT_INITIATIVE_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(groupId);

				list = (List<Initiative>)QueryUtil.list(
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
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<Initiative> orderByComparator) {

		List<Initiative> list = findByStatusAndGroupId(
			status, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	@Override
	public Initiative findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);

		if (initiative != null) {
			return initiative;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchInitiativeException(sb.toString());
	}

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	@Override
	public Initiative fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<Initiative> orderByComparator) {

		int count = countByStatusAndGroupId(status, groupId);

		if (count == 0) {
			return null;
		}

		List<Initiative> list = findByStatusAndGroupId(
			status, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative[] findByStatusAndGroupId_PrevAndNext(
			long initiativeId, int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws NoSuchInitiativeException {

		Initiative initiative = findByPrimaryKey(initiativeId);

		Session session = null;

		try {
			session = openSession();

			Initiative[] array = new InitiativeImpl[3];

			array[0] = getByStatusAndGroupId_PrevAndNext(
				session, initiative, status, groupId, orderByComparator, true);

			array[1] = initiative;

			array[2] = getByStatusAndGroupId_PrevAndNext(
				session, initiative, status, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Initiative getByStatusAndGroupId_PrevAndNext(
		Session session, Initiative initiative, int status, long groupId,
		OrderByComparator<Initiative> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_INITIATIVE_WHERE);

		sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

		sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

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
			sb.append(InitiativeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(initiative)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Initiative> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiatives where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	@Override
	public void removeByStatusAndGroupId(int status, long groupId) {
		for (Initiative initiative :
				findByStatusAndGroupId(
					status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	@Override
	public int countByStatusAndGroupId(int status, long groupId) {
		FinderPath finderPath = _finderPathCountByStatusAndGroupId;

		Object[] finderArgs = new Object[] {status, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INITIATIVE_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUSANDGROUPID_STATUS_2 =
		"initiative.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2 =
		"initiative.groupId = ?";

	public InitiativePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Initiative.class);

		setModelImplClass(InitiativeImpl.class);
		setModelPKClass(long.class);

		setTable(InitiativeTable.INSTANCE);
	}

	/**
	 * Caches the initiative in the entity cache if it is enabled.
	 *
	 * @param initiative the initiative
	 */
	@Override
	public void cacheResult(Initiative initiative) {
		entityCache.putResult(
			InitiativeImpl.class, initiative.getPrimaryKey(), initiative);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {initiative.getUuid(), initiative.getGroupId()},
			initiative);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the initiatives in the entity cache if it is enabled.
	 *
	 * @param initiatives the initiatives
	 */
	@Override
	public void cacheResult(List<Initiative> initiatives) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (initiatives.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Initiative initiative : initiatives) {
			if (entityCache.getResult(
					InitiativeImpl.class, initiative.getPrimaryKey()) == null) {

				cacheResult(initiative);
			}
		}
	}

	/**
	 * Clears the cache for all initiatives.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InitiativeImpl.class);

		finderCache.clearCache(InitiativeImpl.class);
	}

	/**
	 * Clears the cache for the initiative.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Initiative initiative) {
		entityCache.removeResult(InitiativeImpl.class, initiative);
	}

	@Override
	public void clearCache(List<Initiative> initiatives) {
		for (Initiative initiative : initiatives) {
			entityCache.removeResult(InitiativeImpl.class, initiative);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(InitiativeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InitiativeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		InitiativeModelImpl initiativeModelImpl) {

		Object[] args = new Object[] {
			initiativeModelImpl.getUuid(), initiativeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, initiativeModelImpl);
	}

	/**
	 * Creates a new initiative with the primary key. Does not add the initiative to the database.
	 *
	 * @param initiativeId the primary key for the new initiative
	 * @return the new initiative
	 */
	@Override
	public Initiative create(long initiativeId) {
		Initiative initiative = new InitiativeImpl();

		initiative.setNew(true);
		initiative.setPrimaryKey(initiativeId);

		String uuid = PortalUUIDUtil.generate();

		initiative.setUuid(uuid);

		initiative.setCompanyId(CompanyThreadLocal.getCompanyId());

		return initiative;
	}

	/**
	 * Removes the initiative with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative that was removed
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative remove(long initiativeId)
		throws NoSuchInitiativeException {

		return remove((Serializable)initiativeId);
	}

	/**
	 * Removes the initiative with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the initiative
	 * @return the initiative that was removed
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative remove(Serializable primaryKey)
		throws NoSuchInitiativeException {

		Session session = null;

		try {
			session = openSession();

			Initiative initiative = (Initiative)session.get(
				InitiativeImpl.class, primaryKey);

			if (initiative == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInitiativeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(initiative);
		}
		catch (NoSuchInitiativeException noSuchEntityException) {
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
	protected Initiative removeImpl(Initiative initiative) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(initiative)) {
				initiative = (Initiative)session.get(
					InitiativeImpl.class, initiative.getPrimaryKeyObj());
			}

			if (initiative != null) {
				session.delete(initiative);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (initiative != null) {
			clearCache(initiative);
		}

		return initiative;
	}

	@Override
	public Initiative updateImpl(Initiative initiative) {
		boolean isNew = initiative.isNew();

		if (!(initiative instanceof InitiativeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(initiative.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(initiative);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in initiative proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Initiative implementation " +
					initiative.getClass());
		}

		InitiativeModelImpl initiativeModelImpl =
			(InitiativeModelImpl)initiative;

		if (Validator.isNull(initiative.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			initiative.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (initiative.getCreateDate() == null)) {
			if (serviceContext == null) {
				initiative.setCreateDate(date);
			}
			else {
				initiative.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!initiativeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				initiative.setModifiedDate(date);
			}
			else {
				initiative.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(initiative);
			}
			else {
				initiative = (Initiative)session.merge(initiative);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			InitiativeImpl.class, initiativeModelImpl, false, true);

		cacheUniqueFindersCache(initiativeModelImpl);

		if (isNew) {
			initiative.setNew(false);
		}

		initiative.resetOriginalValues();

		return initiative;
	}

	/**
	 * Returns the initiative with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the initiative
	 * @return the initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInitiativeException {

		Initiative initiative = fetchByPrimaryKey(primaryKey);

		if (initiative == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInitiativeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return initiative;
	}

	/**
	 * Returns the initiative with the primary key or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative findByPrimaryKey(long initiativeId)
		throws NoSuchInitiativeException {

		return findByPrimaryKey((Serializable)initiativeId);
	}

	/**
	 * Returns the initiative with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative, or <code>null</code> if a initiative with the primary key could not be found
	 */
	@Override
	public Initiative fetchByPrimaryKey(long initiativeId) {
		return fetchByPrimaryKey((Serializable)initiativeId);
	}

	/**
	 * Returns all the initiatives.
	 *
	 * @return the initiatives
	 */
	@Override
	public List<Initiative> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of initiatives
	 */
	@Override
	public List<Initiative> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of initiatives
	 */
	@Override
	public List<Initiative> findAll(
		int start, int end, OrderByComparator<Initiative> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of initiatives
	 */
	@Override
	public List<Initiative> findAll(
		int start, int end, OrderByComparator<Initiative> orderByComparator,
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

		List<Initiative> list = null;

		if (useFinderCache) {
			list = (List<Initiative>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INITIATIVE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INITIATIVE;

				sql = sql.concat(InitiativeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Initiative>)QueryUtil.list(
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
	 * Removes all the initiatives from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Initiative initiative : findAll()) {
			remove(initiative);
		}
	}

	/**
	 * Returns the number of initiatives.
	 *
	 * @return the number of initiatives
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INITIATIVE);

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
		return "initiativeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INITIATIVE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InitiativeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the initiative persistence.
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

		_finderPathWithPaginationFindBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypublikId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"publikId"}, true);

		_finderPathWithoutPaginationFindBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			true);

		_finderPathCountBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			false);

		_finderPathWithPaginationFindByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroupId",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"status", "groupId"}, true);

		_finderPathWithoutPaginationFindByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroupId",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, true);

		_finderPathCountByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndGroupId",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, false);

		InitiativeUtil.setPersistence(this);
	}

	public void destroy() {
		InitiativeUtil.setPersistence(null);

		entityCache.removeCache(InitiativeImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INITIATIVE =
		"SELECT initiative FROM Initiative initiative";

	private static final String _SQL_SELECT_INITIATIVE_WHERE =
		"SELECT initiative FROM Initiative initiative WHERE ";

	private static final String _SQL_COUNT_INITIATIVE =
		"SELECT COUNT(initiative) FROM Initiative initiative";

	private static final String _SQL_COUNT_INITIATIVE_WHERE =
		"SELECT COUNT(initiative) FROM Initiative initiative WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "initiative.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Initiative exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Initiative exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InitiativePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}