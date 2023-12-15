/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service.persistence.impl;

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

import eu.strasbourg.service.comment.exception.NoSuchSignalementException;
import eu.strasbourg.service.comment.model.Signalement;
import eu.strasbourg.service.comment.model.SignalementTable;
import eu.strasbourg.service.comment.model.impl.SignalementImpl;
import eu.strasbourg.service.comment.model.impl.SignalementModelImpl;
import eu.strasbourg.service.comment.service.persistence.SignalementPersistence;
import eu.strasbourg.service.comment.service.persistence.SignalementUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the signalement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Romain Vergnais
 * @generated
 */
public class SignalementPersistenceImpl
	extends BasePersistenceImpl<Signalement> implements SignalementPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SignalementUtil</code> to access the signalement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SignalementImpl.class.getName();

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
	 * Returns all the signalements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signalements
	 */
	@Override
	public List<Signalement> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Signalement> orderByComparator,
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

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Signalement signalement : list) {
					if (!uuid.equals(signalement.getUuid())) {
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

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
				sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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

				list = (List<Signalement>)QueryUtil.list(
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
	 * Returns the first signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByUuid_First(
			String uuid, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByUuid_First(uuid, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUuid_First(
		String uuid, OrderByComparator<Signalement> orderByComparator) {

		List<Signalement> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByUuid_Last(
			String uuid, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByUuid_Last(uuid, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUuid_Last(
		String uuid, OrderByComparator<Signalement> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Signalement> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where uuid = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement[] findByUuid_PrevAndNext(
			long signalementId, String uuid,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		uuid = Objects.toString(uuid, "");

		Signalement signalement = findByPrimaryKey(signalementId);

		Session session = null;

		try {
			session = openSession();

			Signalement[] array = new SignalementImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, signalement, uuid, orderByComparator, true);

			array[1] = signalement;

			array[2] = getByUuid_PrevAndNext(
				session, signalement, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Signalement getByUuid_PrevAndNext(
		Session session, Signalement signalement, String uuid,
		OrderByComparator<Signalement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
			sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(signalement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Signalement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signalements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Signalement signalement :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signalements
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

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
		"signalement.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(signalement.uuid IS NULL OR signalement.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignalementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByUUID_G(String uuid, long groupId)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByUUID_G(uuid, groupId);

		if (signalement == null) {
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

			throw new NoSuchSignalementException(sb.toString());
		}

		return signalement;
	}

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUUID_G(
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

		if (result instanceof Signalement) {
			Signalement signalement = (Signalement)result;

			if (!Objects.equals(uuid, signalement.getUuid()) ||
				(groupId != signalement.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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

				List<Signalement> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Signalement signalement = list.get(0);

					result = signalement;

					cacheResult(signalement);
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
			return (Signalement)result;
		}
	}

	/**
	 * Removes the signalement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the signalement that was removed
	 */
	@Override
	public Signalement removeByUUID_G(String uuid, long groupId)
		throws NoSuchSignalementException {

		Signalement signalement = findByUUID_G(uuid, groupId);

		return remove(signalement);
	}

	/**
	 * Returns the number of signalements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching signalements
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

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
		"signalement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(signalement.uuid IS NULL OR signalement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"signalement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching signalements
	 */
	@Override
	public List<Signalement> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signalement> orderByComparator,
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

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Signalement signalement : list) {
					if (!uuid.equals(signalement.getUuid()) ||
						(companyId != signalement.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
				sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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

				list = (List<Signalement>)QueryUtil.list(
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
	 * Returns the first signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Signalement> orderByComparator) {

		List<Signalement> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Signalement> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Signalement> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement[] findByUuid_C_PrevAndNext(
			long signalementId, String uuid, long companyId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		uuid = Objects.toString(uuid, "");

		Signalement signalement = findByPrimaryKey(signalementId);

		Session session = null;

		try {
			session = openSession();

			Signalement[] array = new SignalementImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, signalement, uuid, companyId, orderByComparator, true);

			array[1] = signalement;

			array[2] = getByUuid_C_PrevAndNext(
				session, signalement, uuid, companyId, orderByComparator,
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

	protected Signalement getByUuid_C_PrevAndNext(
		Session session, Signalement signalement, String uuid, long companyId,
		OrderByComparator<Signalement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
			sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(signalement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Signalement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signalements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Signalement signalement :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching signalements
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

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
		"signalement.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(signalement.uuid IS NULL OR signalement.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"signalement.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the signalements where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching signalements
	 */
	@Override
	public List<Signalement> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	@Override
	public List<Signalement> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Signalement> orderByComparator,
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

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Signalement signalement : list) {
					if (groupId != signalement.getGroupId()) {
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

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignalementModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Signalement>)QueryUtil.list(
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
	 * Returns the first signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByGroupId_First(
			long groupId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByGroupId_First(
			groupId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the first signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByGroupId_First(
		long groupId, OrderByComparator<Signalement> orderByComparator) {

		List<Signalement> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByGroupId_Last(
			long groupId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the last signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByGroupId_Last(
		long groupId, OrderByComparator<Signalement> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Signalement> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where groupId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement[] findByGroupId_PrevAndNext(
			long signalementId, long groupId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = findByPrimaryKey(signalementId);

		Session session = null;

		try {
			session = openSession();

			Signalement[] array = new SignalementImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, signalement, groupId, orderByComparator, true);

			array[1] = signalement;

			array[2] = getByGroupId_PrevAndNext(
				session, signalement, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Signalement getByGroupId_PrevAndNext(
		Session session, Signalement signalement, long groupId,
		OrderByComparator<Signalement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
			sb.append(SignalementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signalement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Signalement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signalements where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Signalement signalement :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching signalements
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

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
		"signalement.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPublikId;
	private FinderPath _finderPathWithoutPaginationFindByPublikId;
	private FinderPath _finderPathCountByPublikId;

	/**
	 * Returns all the signalements where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching signalements
	 */
	@Override
	public List<Signalement> findByPublikId(String publikId) {
		return findByPublikId(
			publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	@Override
	public List<Signalement> findByPublikId(
		String publikId, int start, int end) {

		return findByPublikId(publikId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return findByPublikId(publikId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<Signalement> orderByComparator,
		boolean useFinderCache) {

		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPublikId;
				finderArgs = new Object[] {publikId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPublikId;
			finderArgs = new Object[] {publikId, start, end, orderByComparator};
		}

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Signalement signalement : list) {
					if (!publikId.equals(signalement.getPublikId())) {
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

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
				sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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

				list = (List<Signalement>)QueryUtil.list(
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
	 * Returns the first signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByPublikId_First(
			String publikId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByPublikId_First(
			publikId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the first signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByPublikId_First(
		String publikId, OrderByComparator<Signalement> orderByComparator) {

		List<Signalement> list = findByPublikId(
			publikId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByPublikId_Last(
			String publikId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByPublikId_Last(
			publikId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the last signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByPublikId_Last(
		String publikId, OrderByComparator<Signalement> orderByComparator) {

		int count = countByPublikId(publikId);

		if (count == 0) {
			return null;
		}

		List<Signalement> list = findByPublikId(
			publikId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where publikId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement[] findByPublikId_PrevAndNext(
			long signalementId, String publikId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		publikId = Objects.toString(publikId, "");

		Signalement signalement = findByPrimaryKey(signalementId);

		Session session = null;

		try {
			session = openSession();

			Signalement[] array = new SignalementImpl[3];

			array[0] = getByPublikId_PrevAndNext(
				session, signalement, publikId, orderByComparator, true);

			array[1] = signalement;

			array[2] = getByPublikId_PrevAndNext(
				session, signalement, publikId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Signalement getByPublikId_PrevAndNext(
		Session session, Signalement signalement, String publikId,
		OrderByComparator<Signalement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

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
			sb.append(SignalementModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(signalement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Signalement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signalements where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	@Override
	public void removeByPublikId(String publikId) {
		for (Signalement signalement :
				findByPublikId(
					publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching signalements
	 */
	@Override
	public int countByPublikId(String publikId) {
		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountByPublikId;

		Object[] finderArgs = new Object[] {publikId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

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
		"signalement.publikId = ?";

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_3 =
		"(signalement.publikId IS NULL OR signalement.publikId = '')";

	private FinderPath _finderPathWithPaginationFindByCommentId;
	private FinderPath _finderPathWithoutPaginationFindByCommentId;
	private FinderPath _finderPathCountByCommentId;

	/**
	 * Returns all the signalements where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @return the matching signalements
	 */
	@Override
	public List<Signalement> findByCommentId(long commentId) {
		return findByCommentId(
			commentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	@Override
	public List<Signalement> findByCommentId(
		long commentId, int start, int end) {

		return findByCommentId(commentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByCommentId(
		long commentId, int start, int end,
		OrderByComparator<Signalement> orderByComparator) {

		return findByCommentId(commentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	@Override
	public List<Signalement> findByCommentId(
		long commentId, int start, int end,
		OrderByComparator<Signalement> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCommentId;
				finderArgs = new Object[] {commentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCommentId;
			finderArgs = new Object[] {
				commentId, start, end, orderByComparator
			};
		}

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Signalement signalement : list) {
					if (commentId != signalement.getCommentId()) {
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

			sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

			sb.append(_FINDER_COLUMN_COMMENTID_COMMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SignalementModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commentId);

				list = (List<Signalement>)QueryUtil.list(
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
	 * Returns the first signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByCommentId_First(
			long commentId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByCommentId_First(
			commentId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentId=");
		sb.append(commentId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the first signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByCommentId_First(
		long commentId, OrderByComparator<Signalement> orderByComparator) {

		List<Signalement> list = findByCommentId(
			commentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	@Override
	public Signalement findByCommentId_Last(
			long commentId, OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByCommentId_Last(
			commentId, orderByComparator);

		if (signalement != null) {
			return signalement;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("commentId=");
		sb.append(commentId);

		sb.append("}");

		throw new NoSuchSignalementException(sb.toString());
	}

	/**
	 * Returns the last signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	@Override
	public Signalement fetchByCommentId_Last(
		long commentId, OrderByComparator<Signalement> orderByComparator) {

		int count = countByCommentId(commentId);

		if (count == 0) {
			return null;
		}

		List<Signalement> list = findByCommentId(
			commentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where commentId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement[] findByCommentId_PrevAndNext(
			long signalementId, long commentId,
			OrderByComparator<Signalement> orderByComparator)
		throws NoSuchSignalementException {

		Signalement signalement = findByPrimaryKey(signalementId);

		Session session = null;

		try {
			session = openSession();

			Signalement[] array = new SignalementImpl[3];

			array[0] = getByCommentId_PrevAndNext(
				session, signalement, commentId, orderByComparator, true);

			array[1] = signalement;

			array[2] = getByCommentId_PrevAndNext(
				session, signalement, commentId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Signalement getByCommentId_PrevAndNext(
		Session session, Signalement signalement, long commentId,
		OrderByComparator<Signalement> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SIGNALEMENT_WHERE);

		sb.append(_FINDER_COLUMN_COMMENTID_COMMENTID_2);

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
			sb.append(SignalementModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(commentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(signalement)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Signalement> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the signalements where commentId = &#63; from the database.
	 *
	 * @param commentId the comment ID
	 */
	@Override
	public void removeByCommentId(long commentId) {
		for (Signalement signalement :
				findByCommentId(
					commentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @return the number of matching signalements
	 */
	@Override
	public int countByCommentId(long commentId) {
		FinderPath finderPath = _finderPathCountByCommentId;

		Object[] finderArgs = new Object[] {commentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SIGNALEMENT_WHERE);

			sb.append(_FINDER_COLUMN_COMMENTID_COMMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(commentId);

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

	private static final String _FINDER_COLUMN_COMMENTID_COMMENTID_2 =
		"signalement.commentId = ?";

	public SignalementPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Signalement.class);

		setModelImplClass(SignalementImpl.class);
		setModelPKClass(long.class);

		setTable(SignalementTable.INSTANCE);
	}

	/**
	 * Caches the signalement in the entity cache if it is enabled.
	 *
	 * @param signalement the signalement
	 */
	@Override
	public void cacheResult(Signalement signalement) {
		entityCache.putResult(
			SignalementImpl.class, signalement.getPrimaryKey(), signalement);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {signalement.getUuid(), signalement.getGroupId()},
			signalement);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the signalements in the entity cache if it is enabled.
	 *
	 * @param signalements the signalements
	 */
	@Override
	public void cacheResult(List<Signalement> signalements) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (signalements.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Signalement signalement : signalements) {
			if (entityCache.getResult(
					SignalementImpl.class, signalement.getPrimaryKey()) ==
						null) {

				cacheResult(signalement);
			}
		}
	}

	/**
	 * Clears the cache for all signalements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SignalementImpl.class);

		finderCache.clearCache(SignalementImpl.class);
	}

	/**
	 * Clears the cache for the signalement.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Signalement signalement) {
		entityCache.removeResult(SignalementImpl.class, signalement);
	}

	@Override
	public void clearCache(List<Signalement> signalements) {
		for (Signalement signalement : signalements) {
			entityCache.removeResult(SignalementImpl.class, signalement);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SignalementImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SignalementImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SignalementModelImpl signalementModelImpl) {

		Object[] args = new Object[] {
			signalementModelImpl.getUuid(), signalementModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, signalementModelImpl);
	}

	/**
	 * Creates a new signalement with the primary key. Does not add the signalement to the database.
	 *
	 * @param signalementId the primary key for the new signalement
	 * @return the new signalement
	 */
	@Override
	public Signalement create(long signalementId) {
		Signalement signalement = new SignalementImpl();

		signalement.setNew(true);
		signalement.setPrimaryKey(signalementId);

		String uuid = PortalUUIDUtil.generate();

		signalement.setUuid(uuid);

		signalement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return signalement;
	}

	/**
	 * Removes the signalement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement that was removed
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement remove(long signalementId)
		throws NoSuchSignalementException {

		return remove((Serializable)signalementId);
	}

	/**
	 * Removes the signalement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the signalement
	 * @return the signalement that was removed
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement remove(Serializable primaryKey)
		throws NoSuchSignalementException {

		Session session = null;

		try {
			session = openSession();

			Signalement signalement = (Signalement)session.get(
				SignalementImpl.class, primaryKey);

			if (signalement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSignalementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(signalement);
		}
		catch (NoSuchSignalementException noSuchEntityException) {
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
	protected Signalement removeImpl(Signalement signalement) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(signalement)) {
				signalement = (Signalement)session.get(
					SignalementImpl.class, signalement.getPrimaryKeyObj());
			}

			if (signalement != null) {
				session.delete(signalement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (signalement != null) {
			clearCache(signalement);
		}

		return signalement;
	}

	@Override
	public Signalement updateImpl(Signalement signalement) {
		boolean isNew = signalement.isNew();

		if (!(signalement instanceof SignalementModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(signalement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(signalement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in signalement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Signalement implementation " +
					signalement.getClass());
		}

		SignalementModelImpl signalementModelImpl =
			(SignalementModelImpl)signalement;

		if (Validator.isNull(signalement.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			signalement.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (signalement.getCreateDate() == null)) {
			if (serviceContext == null) {
				signalement.setCreateDate(date);
			}
			else {
				signalement.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!signalementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				signalement.setModifiedDate(date);
			}
			else {
				signalement.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(signalement);
			}
			else {
				signalement = (Signalement)session.merge(signalement);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SignalementImpl.class, signalementModelImpl, false, true);

		cacheUniqueFindersCache(signalementModelImpl);

		if (isNew) {
			signalement.setNew(false);
		}

		signalement.resetOriginalValues();

		return signalement;
	}

	/**
	 * Returns the signalement with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the signalement
	 * @return the signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSignalementException {

		Signalement signalement = fetchByPrimaryKey(primaryKey);

		if (signalement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSignalementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return signalement;
	}

	/**
	 * Returns the signalement with the primary key or throws a <code>NoSuchSignalementException</code> if it could not be found.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement findByPrimaryKey(long signalementId)
		throws NoSuchSignalementException {

		return findByPrimaryKey((Serializable)signalementId);
	}

	/**
	 * Returns the signalement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement, or <code>null</code> if a signalement with the primary key could not be found
	 */
	@Override
	public Signalement fetchByPrimaryKey(long signalementId) {
		return fetchByPrimaryKey((Serializable)signalementId);
	}

	/**
	 * Returns all the signalements.
	 *
	 * @return the signalements
	 */
	@Override
	public List<Signalement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of signalements
	 */
	@Override
	public List<Signalement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of signalements
	 */
	@Override
	public List<Signalement> findAll(
		int start, int end, OrderByComparator<Signalement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of signalements
	 */
	@Override
	public List<Signalement> findAll(
		int start, int end, OrderByComparator<Signalement> orderByComparator,
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

		List<Signalement> list = null;

		if (useFinderCache) {
			list = (List<Signalement>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SIGNALEMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SIGNALEMENT;

				sql = sql.concat(SignalementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Signalement>)QueryUtil.list(
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
	 * Removes all the signalements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Signalement signalement : findAll()) {
			remove(signalement);
		}
	}

	/**
	 * Returns the number of signalements.
	 *
	 * @return the number of signalements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SIGNALEMENT);

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
		return "signalementId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SIGNALEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SignalementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the signalement persistence.
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

		_finderPathWithPaginationFindByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublikId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"publikId"}, true);

		_finderPathWithoutPaginationFindByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			true);

		_finderPathCountByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			false);

		_finderPathWithPaginationFindByCommentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCommentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"commentId"}, true);

		_finderPathWithoutPaginationFindByCommentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCommentId",
			new String[] {Long.class.getName()}, new String[] {"commentId"},
			true);

		_finderPathCountByCommentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCommentId",
			new String[] {Long.class.getName()}, new String[] {"commentId"},
			false);

		SignalementUtil.setPersistence(this);
	}

	public void destroy() {
		SignalementUtil.setPersistence(null);

		entityCache.removeCache(SignalementImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SIGNALEMENT =
		"SELECT signalement FROM Signalement signalement";

	private static final String _SQL_SELECT_SIGNALEMENT_WHERE =
		"SELECT signalement FROM Signalement signalement WHERE ";

	private static final String _SQL_COUNT_SIGNALEMENT =
		"SELECT COUNT(signalement) FROM Signalement signalement";

	private static final String _SQL_COUNT_SIGNALEMENT_WHERE =
		"SELECT COUNT(signalement) FROM Signalement signalement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "signalement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Signalement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Signalement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SignalementPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}