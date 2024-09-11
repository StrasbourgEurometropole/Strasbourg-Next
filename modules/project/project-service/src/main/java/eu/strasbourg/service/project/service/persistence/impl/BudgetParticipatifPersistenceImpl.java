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

import eu.strasbourg.service.project.exception.NoSuchBudgetParticipatifException;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetParticipatifTable;
import eu.strasbourg.service.project.model.impl.BudgetParticipatifImpl;
import eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifPersistence;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the budget participatif service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class BudgetParticipatifPersistenceImpl
	extends BasePersistenceImpl<BudgetParticipatif>
	implements BudgetParticipatifPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BudgetParticipatifUtil</code> to access the budget participatif persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BudgetParticipatifImpl.class.getName();

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
	 * Returns all the budget participatifs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (!uuid.equals(budgetParticipatif.getUuid())) {
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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByUuid_First(
			String uuid,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByUuid_First(
			uuid, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUuid_First(
		String uuid, OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByUuid_Last(
			String uuid,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByUuid_Last(
			uuid, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUuid_Last(
		String uuid, OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where uuid = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByUuid_PrevAndNext(
			long budgetParticipatifId, String uuid,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		uuid = Objects.toString(uuid, "");

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, budgetParticipatif, uuid, orderByComparator, true);

			array[1] = budgetParticipatif;

			array[2] = getByUuid_PrevAndNext(
				session, budgetParticipatif, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BudgetParticipatif getByUuid_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, String uuid,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BudgetParticipatif budgetParticipatif :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(budgetParticipatif.uuid IS NULL OR budgetParticipatif.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the budget participatif where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBudgetParticipatifException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByUUID_G(String uuid, long groupId)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByUUID_G(uuid, groupId);

		if (budgetParticipatif == null) {
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

			throw new NoSuchBudgetParticipatifException(sb.toString());
		}

		return budgetParticipatif;
	}

	/**
	 * Returns the budget participatif where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the budget participatif where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUUID_G(
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

		if (result instanceof BudgetParticipatif) {
			BudgetParticipatif budgetParticipatif = (BudgetParticipatif)result;

			if (!Objects.equals(uuid, budgetParticipatif.getUuid()) ||
				(groupId != budgetParticipatif.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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

				List<BudgetParticipatif> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BudgetParticipatif budgetParticipatif = list.get(0);

					result = budgetParticipatif;

					cacheResult(budgetParticipatif);
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
			return (BudgetParticipatif)result;
		}
	}

	/**
	 * Removes the budget participatif where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the budget participatif that was removed
	 */
	@Override
	public BudgetParticipatif removeByUUID_G(String uuid, long groupId)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByUUID_G(uuid, groupId);

		return remove(budgetParticipatif);
	}

	/**
	 * Returns the number of budget participatifs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(budgetParticipatif.uuid IS NULL OR budgetParticipatif.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"budgetParticipatif.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the budget participatifs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (!uuid.equals(budgetParticipatif.getUuid()) ||
						(companyId != budgetParticipatif.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByUuid_C_PrevAndNext(
			long budgetParticipatifId, String uuid, long companyId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		uuid = Objects.toString(uuid, "");

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, budgetParticipatif, uuid, companyId, orderByComparator,
				true);

			array[1] = budgetParticipatif;

			array[2] = getByUuid_C_PrevAndNext(
				session, budgetParticipatif, uuid, companyId, orderByComparator,
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

	protected BudgetParticipatif getByUuid_C_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, String uuid,
		long companyId, OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BudgetParticipatif budgetParticipatif :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(budgetParticipatif.uuid IS NULL OR budgetParticipatif.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"budgetParticipatif.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the budget participatifs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (groupId != budgetParticipatif.getGroupId()) {
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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByGroupId_First(
			long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByGroupId_First(
			groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByGroupId_First(
		long groupId, OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByGroupId_Last(
			long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByGroupId_Last(
		long groupId, OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where groupId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByGroupId_PrevAndNext(
			long budgetParticipatifId, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, budgetParticipatif, groupId, orderByComparator, true);

			array[1] = budgetParticipatif;

			array[2] = getByGroupId_PrevAndNext(
				session, budgetParticipatif, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BudgetParticipatif getByGroupId_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (BudgetParticipatif budgetParticipatif :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathWithoutPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathCountByStatusAndGroupId;

	/**
	 * Returns all the budget participatifs where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByStatusAndGroupId(
		int status, long groupId) {

		return findByStatusAndGroupId(
			status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return findByStatusAndGroupId(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if ((status != budgetParticipatif.getStatus()) ||
						(groupId != budgetParticipatif.getGroupId())) {

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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(groupId);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByStatusAndGroupId(
			status, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByStatusAndGroupId(status, groupId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByStatusAndGroupId(
			status, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByStatusAndGroupId_PrevAndNext(
			long budgetParticipatifId, int status, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByStatusAndGroupId_PrevAndNext(
				session, budgetParticipatif, status, groupId, orderByComparator,
				true);

			array[1] = budgetParticipatif;

			array[2] = getByStatusAndGroupId_PrevAndNext(
				session, budgetParticipatif, status, groupId, orderByComparator,
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

	protected BudgetParticipatif getByStatusAndGroupId_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, int status,
		long groupId, OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	@Override
	public void removeByStatusAndGroupId(int status, long groupId) {
		for (BudgetParticipatif budgetParticipatif :
				findByStatusAndGroupId(
					status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByStatusAndGroupId(int status, long groupId) {
		FinderPath finderPath = _finderPathCountByStatusAndGroupId;

		Object[] finderArgs = new Object[] {status, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2 =
		"budgetParticipatif.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPublikId;
	private FinderPath _finderPathWithoutPaginationFindByPublikId;
	private FinderPath _finderPathCountByPublikId;

	/**
	 * Returns all the budget participatifs where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByPublikId(String publikId) {
		return findByPublikId(
			publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByPublikId(
		String publikId, int start, int end) {

		return findByPublikId(publikId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByPublikId(publikId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (!publikId.equals(budgetParticipatif.getPublikId())) {
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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByPublikId_First(
			String publikId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByPublikId_First(
			publikId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByPublikId_First(
		String publikId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByPublikId(
			publikId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByPublikId_Last(
			String publikId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByPublikId_Last(
			publikId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByPublikId_Last(
		String publikId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByPublikId(publikId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByPublikId(
			publikId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where publikId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByPublikId_PrevAndNext(
			long budgetParticipatifId, String publikId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		publikId = Objects.toString(publikId, "");

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByPublikId_PrevAndNext(
				session, budgetParticipatif, publikId, orderByComparator, true);

			array[1] = budgetParticipatif;

			array[2] = getByPublikId_PrevAndNext(
				session, budgetParticipatif, publikId, orderByComparator,
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

	protected BudgetParticipatif getByPublikId_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, String publikId,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	@Override
	public void removeByPublikId(String publikId) {
		for (BudgetParticipatif budgetParticipatif :
				findByPublikId(
					publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByPublikId(String publikId) {
		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountByPublikId;

		Object[] finderArgs = new Object[] {publikId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

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
		"budgetParticipatif.publikId = ?";

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_3 =
		"(budgetParticipatif.publikId IS NULL OR budgetParticipatif.publikId = '')";

	private FinderPath _finderPathWithPaginationFindByBudgetPhaseId;
	private FinderPath _finderPathWithoutPaginationFindByBudgetPhaseId;
	private FinderPath _finderPathCountByBudgetPhaseId;

	/**
	 * Returns all the budget participatifs where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByBudgetPhaseId(long budgetPhaseId) {
		return findByBudgetPhaseId(
			budgetPhaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where budgetPhaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByBudgetPhaseId(
		long budgetPhaseId, int start, int end) {

		return findByBudgetPhaseId(budgetPhaseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where budgetPhaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByBudgetPhaseId(
		long budgetPhaseId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByBudgetPhaseId(
			budgetPhaseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where budgetPhaseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByBudgetPhaseId(
		long budgetPhaseId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByBudgetPhaseId;
				finderArgs = new Object[] {budgetPhaseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBudgetPhaseId;
			finderArgs = new Object[] {
				budgetPhaseId, start, end, orderByComparator
			};
		}

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (budgetPhaseId !=
							budgetParticipatif.getBudgetPhaseId()) {

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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_BUDGETPHASEID_BUDGETPHASEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetPhaseId);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByBudgetPhaseId_First(
			long budgetPhaseId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByBudgetPhaseId_First(
			budgetPhaseId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetPhaseId=");
		sb.append(budgetPhaseId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByBudgetPhaseId_First(
		long budgetPhaseId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByBudgetPhaseId(
			budgetPhaseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByBudgetPhaseId_Last(
			long budgetPhaseId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByBudgetPhaseId_Last(
			budgetPhaseId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetPhaseId=");
		sb.append(budgetPhaseId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByBudgetPhaseId_Last(
		long budgetPhaseId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByBudgetPhaseId(budgetPhaseId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByBudgetPhaseId(
			budgetPhaseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where budgetPhaseId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param budgetPhaseId the budget phase ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByBudgetPhaseId_PrevAndNext(
			long budgetParticipatifId, long budgetPhaseId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByBudgetPhaseId_PrevAndNext(
				session, budgetParticipatif, budgetPhaseId, orderByComparator,
				true);

			array[1] = budgetParticipatif;

			array[2] = getByBudgetPhaseId_PrevAndNext(
				session, budgetParticipatif, budgetPhaseId, orderByComparator,
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

	protected BudgetParticipatif getByBudgetPhaseId_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif,
		long budgetPhaseId,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

		sb.append(_FINDER_COLUMN_BUDGETPHASEID_BUDGETPHASEID_2);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(budgetPhaseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where budgetPhaseId = &#63; from the database.
	 *
	 * @param budgetPhaseId the budget phase ID
	 */
	@Override
	public void removeByBudgetPhaseId(long budgetPhaseId) {
		for (BudgetParticipatif budgetParticipatif :
				findByBudgetPhaseId(
					budgetPhaseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where budgetPhaseId = &#63;.
	 *
	 * @param budgetPhaseId the budget phase ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByBudgetPhaseId(long budgetPhaseId) {
		FinderPath finderPath = _finderPathCountByBudgetPhaseId;

		Object[] finderArgs = new Object[] {budgetPhaseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_BUDGETPHASEID_BUDGETPHASEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetPhaseId);

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

	private static final String _FINDER_COLUMN_BUDGETPHASEID_BUDGETPHASEID_2 =
		"budgetParticipatif.budgetPhaseId = ?";

	private FinderPath _finderPathWithPaginationFindByParentId;
	private FinderPath _finderPathWithoutPaginationFindByParentId;
	private FinderPath _finderPathCountByParentId;

	/**
	 * Returns all the budget participatifs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByParentId(long parentId) {
		return findByParentId(
			parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByParentId(
		long parentId, int start, int end) {

		return findByParentId(parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByParentId(parentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByParentId(
		long parentId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParentId;
				finderArgs = new Object[] {parentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParentId;
			finderArgs = new Object[] {parentId, start, end, orderByComparator};
		}

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if (parentId != budgetParticipatif.getParentId()) {
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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByParentId_First(
			long parentId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByParentId_First(
			parentId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByParentId_First(
		long parentId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByParentId(
			parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByParentId_Last(
			long parentId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByParentId_Last(
			parentId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("parentId=");
		sb.append(parentId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByParentId_Last(
		long parentId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByParentId(parentId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByParentId(
			parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where parentId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByParentId_PrevAndNext(
			long budgetParticipatifId, long parentId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByParentId_PrevAndNext(
				session, budgetParticipatif, parentId, orderByComparator, true);

			array[1] = budgetParticipatif;

			array[2] = getByParentId_PrevAndNext(
				session, budgetParticipatif, parentId, orderByComparator,
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

	protected BudgetParticipatif getByParentId_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, long parentId,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

		sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where parentId = &#63; from the database.
	 *
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByParentId(long parentId) {
		for (BudgetParticipatif budgetParticipatif :
				findByParentId(
					parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where parentId = &#63;.
	 *
	 * @param parentId the parent ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByParentId(long parentId) {
		FinderPath finderPath = _finderPathCountByParentId;

		Object[] finderArgs = new Object[] {parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(parentId);

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

	private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 =
		"budgetParticipatif.parentId = ?";

	private FinderPath _finderPathWithPaginationFindByisCrushAndPublished;
	private FinderPath _finderPathWithoutPaginationFindByisCrushAndPublished;
	private FinderPath _finderPathCountByisCrushAndPublished;

	/**
	 * Returns all the budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByisCrushAndPublished(
		boolean isCrush, int status, long groupId) {

		return findByisCrushAndPublished(
			isCrush, status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByisCrushAndPublished(
		boolean isCrush, int status, long groupId, int start, int end) {

		return findByisCrushAndPublished(
			isCrush, status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByisCrushAndPublished(
		boolean isCrush, int status, long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findByisCrushAndPublished(
			isCrush, status, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findByisCrushAndPublished(
		boolean isCrush, int status, long groupId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByisCrushAndPublished;
				finderArgs = new Object[] {isCrush, status, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByisCrushAndPublished;
			finderArgs = new Object[] {
				isCrush, status, groupId, start, end, orderByComparator
			};
		}

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BudgetParticipatif budgetParticipatif : list) {
					if ((isCrush != budgetParticipatif.isIsCrush()) ||
						(status != budgetParticipatif.getStatus()) ||
						(groupId != budgetParticipatif.getGroupId())) {

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

			sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_ISCRUSH_2);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_STATUS_2);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isCrush);

				queryPos.add(status);

				queryPos.add(groupId);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Returns the first budget participatif in the ordered set where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByisCrushAndPublished_First(
			boolean isCrush, int status, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif =
			fetchByisCrushAndPublished_First(
				isCrush, status, groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCrush=");
		sb.append(isCrush);

		sb.append(", status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the first budget participatif in the ordered set where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByisCrushAndPublished_First(
		boolean isCrush, int status, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		List<BudgetParticipatif> list = findByisCrushAndPublished(
			isCrush, status, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last budget participatif in the ordered set where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif
	 * @throws NoSuchBudgetParticipatifException if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif findByisCrushAndPublished_Last(
			boolean isCrush, int status, long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByisCrushAndPublished_Last(
			isCrush, status, groupId, orderByComparator);

		if (budgetParticipatif != null) {
			return budgetParticipatif;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("isCrush=");
		sb.append(isCrush);

		sb.append(", status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchBudgetParticipatifException(sb.toString());
	}

	/**
	 * Returns the last budget participatif in the ordered set where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public BudgetParticipatif fetchByisCrushAndPublished_Last(
		boolean isCrush, int status, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		int count = countByisCrushAndPublished(isCrush, status, groupId);

		if (count == 0) {
			return null;
		}

		List<BudgetParticipatif> list = findByisCrushAndPublished(
			isCrush, status, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the budget participatifs before and after the current budget participatif in the ordered set where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param budgetParticipatifId the primary key of the current budget participatif
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif[] findByisCrushAndPublished_PrevAndNext(
			long budgetParticipatifId, boolean isCrush, int status,
			long groupId,
			OrderByComparator<BudgetParticipatif> orderByComparator)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = findByPrimaryKey(
			budgetParticipatifId);

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif[] array = new BudgetParticipatifImpl[3];

			array[0] = getByisCrushAndPublished_PrevAndNext(
				session, budgetParticipatif, isCrush, status, groupId,
				orderByComparator, true);

			array[1] = budgetParticipatif;

			array[2] = getByisCrushAndPublished_PrevAndNext(
				session, budgetParticipatif, isCrush, status, groupId,
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

	protected BudgetParticipatif getByisCrushAndPublished_PrevAndNext(
		Session session, BudgetParticipatif budgetParticipatif, boolean isCrush,
		int status, long groupId,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		sb.append(_SQL_SELECT_BUDGETPARTICIPATIF_WHERE);

		sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_ISCRUSH_2);

		sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_STATUS_2);

		sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_GROUPID_2);

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
			sb.append(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(isCrush);

		queryPos.add(status);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						budgetParticipatif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BudgetParticipatif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63; from the database.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 */
	@Override
	public void removeByisCrushAndPublished(
		boolean isCrush, int status, long groupId) {

		for (BudgetParticipatif budgetParticipatif :
				findByisCrushAndPublished(
					isCrush, status, groupId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs where isCrush = &#63; and status = &#63; and groupId = &#63;.
	 *
	 * @param isCrush the is crush
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching budget participatifs
	 */
	@Override
	public int countByisCrushAndPublished(
		boolean isCrush, int status, long groupId) {

		FinderPath finderPath = _finderPathCountByisCrushAndPublished;

		Object[] finderArgs = new Object[] {isCrush, status, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_BUDGETPARTICIPATIF_WHERE);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_ISCRUSH_2);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_STATUS_2);

			sb.append(_FINDER_COLUMN_ISCRUSHANDPUBLISHED_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(isCrush);

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

	private static final String _FINDER_COLUMN_ISCRUSHANDPUBLISHED_ISCRUSH_2 =
		"budgetParticipatif.isCrush = ? AND ";

	private static final String _FINDER_COLUMN_ISCRUSHANDPUBLISHED_STATUS_2 =
		"budgetParticipatif.status = ? AND ";

	private static final String _FINDER_COLUMN_ISCRUSHANDPUBLISHED_GROUPID_2 =
		"budgetParticipatif.groupId = ?";

	public BudgetParticipatifPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BudgetParticipatif.class);

		setModelImplClass(BudgetParticipatifImpl.class);
		setModelPKClass(long.class);

		setTable(BudgetParticipatifTable.INSTANCE);
	}

	/**
	 * Caches the budget participatif in the entity cache if it is enabled.
	 *
	 * @param budgetParticipatif the budget participatif
	 */
	@Override
	public void cacheResult(BudgetParticipatif budgetParticipatif) {
		entityCache.putResult(
			BudgetParticipatifImpl.class, budgetParticipatif.getPrimaryKey(),
			budgetParticipatif);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				budgetParticipatif.getUuid(), budgetParticipatif.getGroupId()
			},
			budgetParticipatif);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the budget participatifs in the entity cache if it is enabled.
	 *
	 * @param budgetParticipatifs the budget participatifs
	 */
	@Override
	public void cacheResult(List<BudgetParticipatif> budgetParticipatifs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (budgetParticipatifs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BudgetParticipatif budgetParticipatif : budgetParticipatifs) {
			if (entityCache.getResult(
					BudgetParticipatifImpl.class,
					budgetParticipatif.getPrimaryKey()) == null) {

				cacheResult(budgetParticipatif);
			}
		}
	}

	/**
	 * Clears the cache for all budget participatifs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BudgetParticipatifImpl.class);

		finderCache.clearCache(BudgetParticipatifImpl.class);
	}

	/**
	 * Clears the cache for the budget participatif.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BudgetParticipatif budgetParticipatif) {
		entityCache.removeResult(
			BudgetParticipatifImpl.class, budgetParticipatif);
	}

	@Override
	public void clearCache(List<BudgetParticipatif> budgetParticipatifs) {
		for (BudgetParticipatif budgetParticipatif : budgetParticipatifs) {
			entityCache.removeResult(
				BudgetParticipatifImpl.class, budgetParticipatif);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BudgetParticipatifImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BudgetParticipatifImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BudgetParticipatifModelImpl budgetParticipatifModelImpl) {

		Object[] args = new Object[] {
			budgetParticipatifModelImpl.getUuid(),
			budgetParticipatifModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, budgetParticipatifModelImpl);
	}

	/**
	 * Creates a new budget participatif with the primary key. Does not add the budget participatif to the database.
	 *
	 * @param budgetParticipatifId the primary key for the new budget participatif
	 * @return the new budget participatif
	 */
	@Override
	public BudgetParticipatif create(long budgetParticipatifId) {
		BudgetParticipatif budgetParticipatif = new BudgetParticipatifImpl();

		budgetParticipatif.setNew(true);
		budgetParticipatif.setPrimaryKey(budgetParticipatifId);

		String uuid = PortalUUIDUtil.generate();

		budgetParticipatif.setUuid(uuid);

		budgetParticipatif.setCompanyId(CompanyThreadLocal.getCompanyId());

		return budgetParticipatif;
	}

	/**
	 * Removes the budget participatif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif that was removed
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif remove(long budgetParticipatifId)
		throws NoSuchBudgetParticipatifException {

		return remove((Serializable)budgetParticipatifId);
	}

	/**
	 * Removes the budget participatif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the budget participatif
	 * @return the budget participatif that was removed
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif remove(Serializable primaryKey)
		throws NoSuchBudgetParticipatifException {

		Session session = null;

		try {
			session = openSession();

			BudgetParticipatif budgetParticipatif =
				(BudgetParticipatif)session.get(
					BudgetParticipatifImpl.class, primaryKey);

			if (budgetParticipatif == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBudgetParticipatifException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(budgetParticipatif);
		}
		catch (NoSuchBudgetParticipatifException noSuchEntityException) {
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
	protected BudgetParticipatif removeImpl(
		BudgetParticipatif budgetParticipatif) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(budgetParticipatif)) {
				budgetParticipatif = (BudgetParticipatif)session.get(
					BudgetParticipatifImpl.class,
					budgetParticipatif.getPrimaryKeyObj());
			}

			if (budgetParticipatif != null) {
				session.delete(budgetParticipatif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (budgetParticipatif != null) {
			clearCache(budgetParticipatif);
		}

		return budgetParticipatif;
	}

	@Override
	public BudgetParticipatif updateImpl(
		BudgetParticipatif budgetParticipatif) {

		boolean isNew = budgetParticipatif.isNew();

		if (!(budgetParticipatif instanceof BudgetParticipatifModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(budgetParticipatif.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					budgetParticipatif);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in budgetParticipatif proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BudgetParticipatif implementation " +
					budgetParticipatif.getClass());
		}

		BudgetParticipatifModelImpl budgetParticipatifModelImpl =
			(BudgetParticipatifModelImpl)budgetParticipatif;

		if (Validator.isNull(budgetParticipatif.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			budgetParticipatif.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (budgetParticipatif.getCreateDate() == null)) {
			if (serviceContext == null) {
				budgetParticipatif.setCreateDate(date);
			}
			else {
				budgetParticipatif.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!budgetParticipatifModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				budgetParticipatif.setModifiedDate(date);
			}
			else {
				budgetParticipatif.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(budgetParticipatif);
			}
			else {
				budgetParticipatif = (BudgetParticipatif)session.merge(
					budgetParticipatif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BudgetParticipatifImpl.class, budgetParticipatifModelImpl, false,
			true);

		cacheUniqueFindersCache(budgetParticipatifModelImpl);

		if (isNew) {
			budgetParticipatif.setNew(false);
		}

		budgetParticipatif.resetOriginalValues();

		return budgetParticipatif;
	}

	/**
	 * Returns the budget participatif with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the budget participatif
	 * @return the budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBudgetParticipatifException {

		BudgetParticipatif budgetParticipatif = fetchByPrimaryKey(primaryKey);

		if (budgetParticipatif == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBudgetParticipatifException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return budgetParticipatif;
	}

	/**
	 * Returns the budget participatif with the primary key or throws a <code>NoSuchBudgetParticipatifException</code> if it could not be found.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif
	 * @throws NoSuchBudgetParticipatifException if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif findByPrimaryKey(long budgetParticipatifId)
		throws NoSuchBudgetParticipatifException {

		return findByPrimaryKey((Serializable)budgetParticipatifId);
	}

	/**
	 * Returns the budget participatif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif, or <code>null</code> if a budget participatif with the primary key could not be found
	 */
	@Override
	public BudgetParticipatif fetchByPrimaryKey(long budgetParticipatifId) {
		return fetchByPrimaryKey((Serializable)budgetParticipatifId);
	}

	/**
	 * Returns all the budget participatifs.
	 *
	 * @return the budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the budget participatifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the budget participatifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findAll(
		int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the budget participatifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of budget participatifs
	 */
	@Override
	public List<BudgetParticipatif> findAll(
		int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator,
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

		List<BudgetParticipatif> list = null;

		if (useFinderCache) {
			list = (List<BudgetParticipatif>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BUDGETPARTICIPATIF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BUDGETPARTICIPATIF;

				sql = sql.concat(BudgetParticipatifModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BudgetParticipatif>)QueryUtil.list(
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
	 * Removes all the budget participatifs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BudgetParticipatif budgetParticipatif : findAll()) {
			remove(budgetParticipatif);
		}
	}

	/**
	 * Returns the number of budget participatifs.
	 *
	 * @return the number of budget participatifs
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
					_SQL_COUNT_BUDGETPARTICIPATIF);

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
		return "budgetParticipatifId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BUDGETPARTICIPATIF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BudgetParticipatifModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the budget participatif persistence.
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

		_finderPathWithPaginationFindByBudgetPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBudgetPhaseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"budgetPhaseId"}, true);

		_finderPathWithoutPaginationFindByBudgetPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBudgetPhaseId",
			new String[] {Long.class.getName()}, new String[] {"budgetPhaseId"},
			true);

		_finderPathCountByBudgetPhaseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBudgetPhaseId",
			new String[] {Long.class.getName()}, new String[] {"budgetPhaseId"},
			false);

		_finderPathWithPaginationFindByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"parentId"}, true);

		_finderPathWithoutPaginationFindByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			true);

		_finderPathCountByParentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
			new String[] {Long.class.getName()}, new String[] {"parentId"},
			false);

		_finderPathWithPaginationFindByisCrushAndPublished = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisCrushAndPublished",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"isCrush", "status", "groupId"}, true);

		_finderPathWithoutPaginationFindByisCrushAndPublished = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByisCrushAndPublished",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			new String[] {"isCrush", "status", "groupId"}, true);

		_finderPathCountByisCrushAndPublished = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByisCrushAndPublished",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			new String[] {"isCrush", "status", "groupId"}, false);

		BudgetParticipatifUtil.setPersistence(this);
	}

	public void destroy() {
		BudgetParticipatifUtil.setPersistence(null);

		entityCache.removeCache(BudgetParticipatifImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BUDGETPARTICIPATIF =
		"SELECT budgetParticipatif FROM BudgetParticipatif budgetParticipatif";

	private static final String _SQL_SELECT_BUDGETPARTICIPATIF_WHERE =
		"SELECT budgetParticipatif FROM BudgetParticipatif budgetParticipatif WHERE ";

	private static final String _SQL_COUNT_BUDGETPARTICIPATIF =
		"SELECT COUNT(budgetParticipatif) FROM BudgetParticipatif budgetParticipatif";

	private static final String _SQL_COUNT_BUDGETPARTICIPATIF_WHERE =
		"SELECT COUNT(budgetParticipatif) FROM BudgetParticipatif budgetParticipatif WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "budgetParticipatif.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BudgetParticipatif exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BudgetParticipatif exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BudgetParticipatifPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}