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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.exception.NoSuchInitiativeHelpException;
import eu.strasbourg.service.project.model.InitiativeHelp;
import eu.strasbourg.service.project.model.InitiativeHelpTable;
import eu.strasbourg.service.project.model.impl.InitiativeHelpImpl;
import eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl;
import eu.strasbourg.service.project.service.persistence.InitiativeHelpPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativeHelpUtil;

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
 * The persistence implementation for the initiative help service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class InitiativeHelpPersistenceImpl
	extends BasePersistenceImpl<InitiativeHelp>
	implements InitiativeHelpPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InitiativeHelpUtil</code> to access the initiative help persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InitiativeHelpImpl.class.getName();

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
	 * Returns all the initiative helps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
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

		List<InitiativeHelp> list = null;

		if (useFinderCache) {
			list = (List<InitiativeHelp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InitiativeHelp initiativeHelp : list) {
					if (!uuid.equals(initiativeHelp.getUuid())) {
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

			sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

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
				sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
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

				list = (List<InitiativeHelp>)QueryUtil.list(
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
	 * Returns the first initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByUuid_First(
			String uuid, OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByUuid_First(
			uuid, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the first initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByUuid_First(
		String uuid, OrderByComparator<InitiativeHelp> orderByComparator) {

		List<InitiativeHelp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByUuid_Last(
			String uuid, OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByUuid_Last(
			uuid, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the last initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByUuid_Last(
		String uuid, OrderByComparator<InitiativeHelp> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<InitiativeHelp> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp[] findByUuid_PrevAndNext(
			long initiativeHelpId, String uuid,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		uuid = Objects.toString(uuid, "");

		InitiativeHelp initiativeHelp = findByPrimaryKey(initiativeHelpId);

		Session session = null;

		try {
			session = openSession();

			InitiativeHelp[] array = new InitiativeHelpImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, initiativeHelp, uuid, orderByComparator, true);

			array[1] = initiativeHelp;

			array[2] = getByUuid_PrevAndNext(
				session, initiativeHelp, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected InitiativeHelp getByUuid_PrevAndNext(
		Session session, InitiativeHelp initiativeHelp, String uuid,
		OrderByComparator<InitiativeHelp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

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
			sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
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
						initiativeHelp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InitiativeHelp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiative helps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (InitiativeHelp initiativeHelp :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiativeHelp);
		}
	}

	/**
	 * Returns the number of initiative helps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching initiative helps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVEHELP_WHERE);

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
		"initiativeHelp.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(initiativeHelp.uuid IS NULL OR initiativeHelp.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByUUID_G(uuid, groupId);

		if (initiativeHelp == null) {
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

			throw new NoSuchInitiativeHelpException(sb.toString());
		}

		return initiativeHelp;
	}

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByUUID_G(
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

		if (result instanceof InitiativeHelp) {
			InitiativeHelp initiativeHelp = (InitiativeHelp)result;

			if (!Objects.equals(uuid, initiativeHelp.getUuid()) ||
				(groupId != initiativeHelp.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

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

				List<InitiativeHelp> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					InitiativeHelp initiativeHelp = list.get(0);

					result = initiativeHelp;

					cacheResult(initiativeHelp);
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
			return (InitiativeHelp)result;
		}
	}

	/**
	 * Removes the initiative help where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the initiative help that was removed
	 */
	@Override
	public InitiativeHelp removeByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = findByUUID_G(uuid, groupId);

		return remove(initiativeHelp);
	}

	/**
	 * Returns the number of initiative helps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching initiative helps
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INITIATIVEHELP_WHERE);

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
		"initiativeHelp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(initiativeHelp.uuid IS NULL OR initiativeHelp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"initiativeHelp.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPublikUserId;
	private FinderPath _finderPathWithoutPaginationFindByPublikUserId;
	private FinderPath _finderPathCountByPublikUserId;

	/**
	 * Returns all the initiative helps where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByPublikUserId(String publikUserId) {
		return findByPublikUserId(
			publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end) {

		return findByPublikUserId(publikUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return findByPublikUserId(
			publikUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		publikUserId = Objects.toString(publikUserId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPublikUserId;
				finderArgs = new Object[] {publikUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPublikUserId;
			finderArgs = new Object[] {
				publikUserId, start, end, orderByComparator
			};
		}

		List<InitiativeHelp> list = null;

		if (useFinderCache) {
			list = (List<InitiativeHelp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InitiativeHelp initiativeHelp : list) {
					if (!publikUserId.equals(
							initiativeHelp.getPublikUserId())) {

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

			sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				list = (List<InitiativeHelp>)QueryUtil.list(
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
	 * Returns the first initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByPublikUserId_First(
			String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByPublikUserId_First(
			publikUserId, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the first initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByPublikUserId_First(
		String publikUserId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		List<InitiativeHelp> list = findByPublikUserId(
			publikUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByPublikUserId_Last(
			String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByPublikUserId_Last(
			publikUserId, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the last initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByPublikUserId_Last(
		String publikUserId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		int count = countByPublikUserId(publikUserId);

		if (count == 0) {
			return null;
		}

		List<InitiativeHelp> list = findByPublikUserId(
			publikUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp[] findByPublikUserId_PrevAndNext(
			long initiativeHelpId, String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		publikUserId = Objects.toString(publikUserId, "");

		InitiativeHelp initiativeHelp = findByPrimaryKey(initiativeHelpId);

		Session session = null;

		try {
			session = openSession();

			InitiativeHelp[] array = new InitiativeHelpImpl[3];

			array[0] = getByPublikUserId_PrevAndNext(
				session, initiativeHelp, publikUserId, orderByComparator, true);

			array[1] = initiativeHelp;

			array[2] = getByPublikUserId_PrevAndNext(
				session, initiativeHelp, publikUserId, orderByComparator,
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

	protected InitiativeHelp getByPublikUserId_PrevAndNext(
		Session session, InitiativeHelp initiativeHelp, String publikUserId,
		OrderByComparator<InitiativeHelp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

		boolean bindPublikUserId = false;

		if (publikUserId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3);
		}
		else {
			bindPublikUserId = true;

			sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_2);
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
			sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPublikUserId) {
			queryPos.add(publikUserId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						initiativeHelp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InitiativeHelp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiative helps where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	@Override
	public void removeByPublikUserId(String publikUserId) {
		for (InitiativeHelp initiativeHelp :
				findByPublikUserId(
					publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiativeHelp);
		}
	}

	/**
	 * Returns the number of initiative helps where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching initiative helps
	 */
	@Override
	public int countByPublikUserId(String publikUserId) {
		publikUserId = Objects.toString(publikUserId, "");

		FinderPath finderPath = _finderPathCountByPublikUserId;

		Object[] finderArgs = new Object[] {publikUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVEHELP_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(_FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
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

	private static final String _FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_2 =
		"initiativeHelp.publikUserId = ?";

	private static final String _FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3 =
		"(initiativeHelp.publikUserId IS NULL OR initiativeHelp.publikUserId = '')";

	private FinderPath _finderPathWithPaginationFindByinitiativeId;
	private FinderPath _finderPathWithoutPaginationFindByinitiativeId;
	private FinderPath _finderPathCountByinitiativeId;

	/**
	 * Returns all the initiative helps where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByinitiativeId(long initiativeId) {
		return findByinitiativeId(
			initiativeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end) {

		return findByinitiativeId(initiativeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return findByinitiativeId(
			initiativeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	@Override
	public List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByinitiativeId;
				finderArgs = new Object[] {initiativeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByinitiativeId;
			finderArgs = new Object[] {
				initiativeId, start, end, orderByComparator
			};
		}

		List<InitiativeHelp> list = null;

		if (useFinderCache) {
			list = (List<InitiativeHelp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (InitiativeHelp initiativeHelp : list) {
					if (initiativeId != initiativeHelp.getInitiativeId()) {
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

			sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

			sb.append(_FINDER_COLUMN_INITIATIVEID_INITIATIVEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(initiativeId);

				list = (List<InitiativeHelp>)QueryUtil.list(
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
	 * Returns the first initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByinitiativeId_First(
			long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByinitiativeId_First(
			initiativeId, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("initiativeId=");
		sb.append(initiativeId);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the first initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByinitiativeId_First(
		long initiativeId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		List<InitiativeHelp> list = findByinitiativeId(
			initiativeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByinitiativeId_Last(
			long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByinitiativeId_Last(
			initiativeId, orderByComparator);

		if (initiativeHelp != null) {
			return initiativeHelp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("initiativeId=");
		sb.append(initiativeId);

		sb.append("}");

		throw new NoSuchInitiativeHelpException(sb.toString());
	}

	/**
	 * Returns the last initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByinitiativeId_Last(
		long initiativeId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		int count = countByinitiativeId(initiativeId);

		if (count == 0) {
			return null;
		}

		List<InitiativeHelp> list = findByinitiativeId(
			initiativeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp[] findByinitiativeId_PrevAndNext(
			long initiativeHelpId, long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = findByPrimaryKey(initiativeHelpId);

		Session session = null;

		try {
			session = openSession();

			InitiativeHelp[] array = new InitiativeHelpImpl[3];

			array[0] = getByinitiativeId_PrevAndNext(
				session, initiativeHelp, initiativeId, orderByComparator, true);

			array[1] = initiativeHelp;

			array[2] = getByinitiativeId_PrevAndNext(
				session, initiativeHelp, initiativeId, orderByComparator,
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

	protected InitiativeHelp getByinitiativeId_PrevAndNext(
		Session session, InitiativeHelp initiativeHelp, long initiativeId,
		OrderByComparator<InitiativeHelp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

		sb.append(_FINDER_COLUMN_INITIATIVEID_INITIATIVEID_2);

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
			sb.append(InitiativeHelpModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(initiativeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						initiativeHelp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<InitiativeHelp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the initiative helps where initiativeId = &#63; from the database.
	 *
	 * @param initiativeId the initiative ID
	 */
	@Override
	public void removeByinitiativeId(long initiativeId) {
		for (InitiativeHelp initiativeHelp :
				findByinitiativeId(
					initiativeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(initiativeHelp);
		}
	}

	/**
	 * Returns the number of initiative helps where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the number of matching initiative helps
	 */
	@Override
	public int countByinitiativeId(long initiativeId) {
		FinderPath finderPath = _finderPathCountByinitiativeId;

		Object[] finderArgs = new Object[] {initiativeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INITIATIVEHELP_WHERE);

			sb.append(_FINDER_COLUMN_INITIATIVEID_INITIATIVEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(initiativeId);

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

	private static final String _FINDER_COLUMN_INITIATIVEID_INITIATIVEID_2 =
		"initiativeHelp.initiativeId = ?";

	private FinderPath _finderPathFetchByPublikUserIdAndInitiativeId;
	private FinderPath _finderPathCountByPublikUserIdAndInitiativeId;

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp findByPublikUserIdAndInitiativeId(
			String publikUserId, long initiativeId)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);

		if (initiativeHelp == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("publikUserId=");
			sb.append(publikUserId);

			sb.append(", initiativeId=");
			sb.append(initiativeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchInitiativeHelpException(sb.toString());
		}

		return initiativeHelp;
	}

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId) {

		return fetchByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId, true);
	}

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Override
	public InitiativeHelp fetchByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId, boolean useFinderCache) {

		publikUserId = Objects.toString(publikUserId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {publikUserId, initiativeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPublikUserIdAndInitiativeId, finderArgs,
				this);
		}

		if (result instanceof InitiativeHelp) {
			InitiativeHelp initiativeHelp = (InitiativeHelp)result;

			if (!Objects.equals(
					publikUserId, initiativeHelp.getPublikUserId()) ||
				(initiativeId != initiativeHelp.getInitiativeId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_INITIATIVEHELP_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(
					_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_2);
			}

			sb.append(
				_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_INITIATIVEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				queryPos.add(initiativeId);

				List<InitiativeHelp> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPublikUserIdAndInitiativeId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									publikUserId, initiativeId
								};
							}

							_log.warn(
								"InitiativeHelpPersistenceImpl.fetchByPublikUserIdAndInitiativeId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					InitiativeHelp initiativeHelp = list.get(0);

					result = initiativeHelp;

					cacheResult(initiativeHelp);
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
			return (InitiativeHelp)result;
		}
	}

	/**
	 * Removes the initiative help where publikUserId = &#63; and initiativeId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the initiative help that was removed
	 */
	@Override
	public InitiativeHelp removeByPublikUserIdAndInitiativeId(
			String publikUserId, long initiativeId)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = findByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);

		return remove(initiativeHelp);
	}

	/**
	 * Returns the number of initiative helps where publikUserId = &#63; and initiativeId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the number of matching initiative helps
	 */
	@Override
	public int countByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId) {

		publikUserId = Objects.toString(publikUserId, "");

		FinderPath finderPath = _finderPathCountByPublikUserIdAndInitiativeId;

		Object[] finderArgs = new Object[] {publikUserId, initiativeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_INITIATIVEHELP_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(
					_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_2);
			}

			sb.append(
				_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_INITIATIVEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				queryPos.add(initiativeId);

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
		_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_2 =
			"initiativeHelp.publikUserId = ? AND ";

	private static final String
		_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_PUBLIKUSERID_3 =
			"(initiativeHelp.publikUserId IS NULL OR initiativeHelp.publikUserId = '') AND ";

	private static final String
		_FINDER_COLUMN_PUBLIKUSERIDANDINITIATIVEID_INITIATIVEID_2 =
			"initiativeHelp.initiativeId = ?";

	public InitiativeHelpPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(InitiativeHelp.class);

		setModelImplClass(InitiativeHelpImpl.class);
		setModelPKClass(long.class);

		setTable(InitiativeHelpTable.INSTANCE);
	}

	/**
	 * Caches the initiative help in the entity cache if it is enabled.
	 *
	 * @param initiativeHelp the initiative help
	 */
	@Override
	public void cacheResult(InitiativeHelp initiativeHelp) {
		entityCache.putResult(
			InitiativeHelpImpl.class, initiativeHelp.getPrimaryKey(),
			initiativeHelp);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				initiativeHelp.getUuid(), initiativeHelp.getGroupId()
			},
			initiativeHelp);

		finderCache.putResult(
			_finderPathFetchByPublikUserIdAndInitiativeId,
			new Object[] {
				initiativeHelp.getPublikUserId(),
				initiativeHelp.getInitiativeId()
			},
			initiativeHelp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the initiative helps in the entity cache if it is enabled.
	 *
	 * @param initiativeHelps the initiative helps
	 */
	@Override
	public void cacheResult(List<InitiativeHelp> initiativeHelps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (initiativeHelps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (InitiativeHelp initiativeHelp : initiativeHelps) {
			if (entityCache.getResult(
					InitiativeHelpImpl.class, initiativeHelp.getPrimaryKey()) ==
						null) {

				cacheResult(initiativeHelp);
			}
		}
	}

	/**
	 * Clears the cache for all initiative helps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InitiativeHelpImpl.class);

		finderCache.clearCache(InitiativeHelpImpl.class);
	}

	/**
	 * Clears the cache for the initiative help.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InitiativeHelp initiativeHelp) {
		entityCache.removeResult(InitiativeHelpImpl.class, initiativeHelp);
	}

	@Override
	public void clearCache(List<InitiativeHelp> initiativeHelps) {
		for (InitiativeHelp initiativeHelp : initiativeHelps) {
			entityCache.removeResult(InitiativeHelpImpl.class, initiativeHelp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(InitiativeHelpImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InitiativeHelpImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		InitiativeHelpModelImpl initiativeHelpModelImpl) {

		Object[] args = new Object[] {
			initiativeHelpModelImpl.getUuid(),
			initiativeHelpModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, initiativeHelpModelImpl);

		args = new Object[] {
			initiativeHelpModelImpl.getPublikUserId(),
			initiativeHelpModelImpl.getInitiativeId()
		};

		finderCache.putResult(
			_finderPathCountByPublikUserIdAndInitiativeId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPublikUserIdAndInitiativeId, args,
			initiativeHelpModelImpl);
	}

	/**
	 * Creates a new initiative help with the primary key. Does not add the initiative help to the database.
	 *
	 * @param initiativeHelpId the primary key for the new initiative help
	 * @return the new initiative help
	 */
	@Override
	public InitiativeHelp create(long initiativeHelpId) {
		InitiativeHelp initiativeHelp = new InitiativeHelpImpl();

		initiativeHelp.setNew(true);
		initiativeHelp.setPrimaryKey(initiativeHelpId);

		String uuid = PortalUUIDUtil.generate();

		initiativeHelp.setUuid(uuid);

		return initiativeHelp;
	}

	/**
	 * Removes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp remove(long initiativeHelpId)
		throws NoSuchInitiativeHelpException {

		return remove((Serializable)initiativeHelpId);
	}

	/**
	 * Removes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp remove(Serializable primaryKey)
		throws NoSuchInitiativeHelpException {

		Session session = null;

		try {
			session = openSession();

			InitiativeHelp initiativeHelp = (InitiativeHelp)session.get(
				InitiativeHelpImpl.class, primaryKey);

			if (initiativeHelp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInitiativeHelpException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(initiativeHelp);
		}
		catch (NoSuchInitiativeHelpException noSuchEntityException) {
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
	protected InitiativeHelp removeImpl(InitiativeHelp initiativeHelp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(initiativeHelp)) {
				initiativeHelp = (InitiativeHelp)session.get(
					InitiativeHelpImpl.class,
					initiativeHelp.getPrimaryKeyObj());
			}

			if (initiativeHelp != null) {
				session.delete(initiativeHelp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (initiativeHelp != null) {
			clearCache(initiativeHelp);
		}

		return initiativeHelp;
	}

	@Override
	public InitiativeHelp updateImpl(InitiativeHelp initiativeHelp) {
		boolean isNew = initiativeHelp.isNew();

		if (!(initiativeHelp instanceof InitiativeHelpModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(initiativeHelp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					initiativeHelp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in initiativeHelp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom InitiativeHelp implementation " +
					initiativeHelp.getClass());
		}

		InitiativeHelpModelImpl initiativeHelpModelImpl =
			(InitiativeHelpModelImpl)initiativeHelp;

		if (Validator.isNull(initiativeHelp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			initiativeHelp.setUuid(uuid);
		}

		if (isNew && (initiativeHelp.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				initiativeHelp.setCreateDate(date);
			}
			else {
				initiativeHelp.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(initiativeHelp);
			}
			else {
				initiativeHelp = (InitiativeHelp)session.merge(initiativeHelp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			InitiativeHelpImpl.class, initiativeHelpModelImpl, false, true);

		cacheUniqueFindersCache(initiativeHelpModelImpl);

		if (isNew) {
			initiativeHelp.setNew(false);
		}

		initiativeHelp.resetOriginalValues();

		return initiativeHelp;
	}

	/**
	 * Returns the initiative help with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the initiative help
	 * @return the initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInitiativeHelpException {

		InitiativeHelp initiativeHelp = fetchByPrimaryKey(primaryKey);

		if (initiativeHelp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInitiativeHelpException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return initiativeHelp;
	}

	/**
	 * Returns the initiative help with the primary key or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp findByPrimaryKey(long initiativeHelpId)
		throws NoSuchInitiativeHelpException {

		return findByPrimaryKey((Serializable)initiativeHelpId);
	}

	/**
	 * Returns the initiative help with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help, or <code>null</code> if a initiative help with the primary key could not be found
	 */
	@Override
	public InitiativeHelp fetchByPrimaryKey(long initiativeHelpId) {
		return fetchByPrimaryKey((Serializable)initiativeHelpId);
	}

	/**
	 * Returns all the initiative helps.
	 *
	 * @return the initiative helps
	 */
	@Override
	public List<InitiativeHelp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of initiative helps
	 */
	@Override
	public List<InitiativeHelp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of initiative helps
	 */
	@Override
	public List<InitiativeHelp> findAll(
		int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of initiative helps
	 */
	@Override
	public List<InitiativeHelp> findAll(
		int start, int end, OrderByComparator<InitiativeHelp> orderByComparator,
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

		List<InitiativeHelp> list = null;

		if (useFinderCache) {
			list = (List<InitiativeHelp>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INITIATIVEHELP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INITIATIVEHELP;

				sql = sql.concat(InitiativeHelpModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<InitiativeHelp>)QueryUtil.list(
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
	 * Removes all the initiative helps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (InitiativeHelp initiativeHelp : findAll()) {
			remove(initiativeHelp);
		}
	}

	/**
	 * Returns the number of initiative helps.
	 *
	 * @return the number of initiative helps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INITIATIVEHELP);

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
		return "initiativeHelpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INITIATIVEHELP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InitiativeHelpModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the initiative help persistence.
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

		_finderPathWithPaginationFindByPublikUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublikUserId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"publikUserId"}, true);

		_finderPathWithoutPaginationFindByPublikUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublikUserId",
			new String[] {String.class.getName()},
			new String[] {"publikUserId"}, true);

		_finderPathCountByPublikUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublikUserId",
			new String[] {String.class.getName()},
			new String[] {"publikUserId"}, false);

		_finderPathWithPaginationFindByinitiativeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByinitiativeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"initiativeId"}, true);

		_finderPathWithoutPaginationFindByinitiativeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByinitiativeId",
			new String[] {Long.class.getName()}, new String[] {"initiativeId"},
			true);

		_finderPathCountByinitiativeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByinitiativeId",
			new String[] {Long.class.getName()}, new String[] {"initiativeId"},
			false);

		_finderPathFetchByPublikUserIdAndInitiativeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPublikUserIdAndInitiativeId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"publikUserId", "initiativeId"}, true);

		_finderPathCountByPublikUserIdAndInitiativeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublikUserIdAndInitiativeId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"publikUserId", "initiativeId"}, false);

		InitiativeHelpUtil.setPersistence(this);
	}

	public void destroy() {
		InitiativeHelpUtil.setPersistence(null);

		entityCache.removeCache(InitiativeHelpImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INITIATIVEHELP =
		"SELECT initiativeHelp FROM InitiativeHelp initiativeHelp";

	private static final String _SQL_SELECT_INITIATIVEHELP_WHERE =
		"SELECT initiativeHelp FROM InitiativeHelp initiativeHelp WHERE ";

	private static final String _SQL_COUNT_INITIATIVEHELP =
		"SELECT COUNT(initiativeHelp) FROM InitiativeHelp initiativeHelp";

	private static final String _SQL_COUNT_INITIATIVEHELP_WHERE =
		"SELECT COUNT(initiativeHelp) FROM InitiativeHelp initiativeHelp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "initiativeHelp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No InitiativeHelp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No InitiativeHelp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InitiativeHelpPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}