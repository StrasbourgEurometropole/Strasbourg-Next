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

import eu.strasbourg.service.project.exception.NoSuchPlacitPlaceException;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.PlacitPlaceTable;
import eu.strasbourg.service.project.model.impl.PlacitPlaceImpl;
import eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl;
import eu.strasbourg.service.project.service.persistence.PlacitPlacePersistence;
import eu.strasbourg.service.project.service.persistence.PlacitPlaceUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the placit place service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class PlacitPlacePersistenceImpl
	extends BasePersistenceImpl<PlacitPlace> implements PlacitPlacePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PlacitPlaceUtil</code> to access the placit place persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PlacitPlaceImpl.class.getName();

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
	 * Returns all the placit places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
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

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (!uuid.equals(placitPlace.getUuid())) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
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

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByUuid_First(
			String uuid, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByUuid_First(uuid, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUuid_First(
		String uuid, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByUuid_Last(
			String uuid, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByUuid_Last(uuid, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUuid_Last(
		String uuid, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where uuid = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByUuid_PrevAndNext(
			long placitPlaceId, String uuid,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		uuid = Objects.toString(uuid, "");

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, placitPlace, uuid, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByUuid_PrevAndNext(
				session, placitPlace, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getByUuid_PrevAndNext(
		Session session, PlacitPlace placitPlace, String uuid,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PlacitPlace placitPlace :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching placit places
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

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
		"placitPlace.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(placitPlace.uuid IS NULL OR placitPlace.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPlacitPlaceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByUUID_G(String uuid, long groupId)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByUUID_G(uuid, groupId);

		if (placitPlace == null) {
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

			throw new NoSuchPlacitPlaceException(sb.toString());
		}

		return placitPlace;
	}

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUUID_G(
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

		if (result instanceof PlacitPlace) {
			PlacitPlace placitPlace = (PlacitPlace)result;

			if (!Objects.equals(uuid, placitPlace.getUuid()) ||
				(groupId != placitPlace.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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

				List<PlacitPlace> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					PlacitPlace placitPlace = list.get(0);

					result = placitPlace;

					cacheResult(placitPlace);
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
			return (PlacitPlace)result;
		}
	}

	/**
	 * Removes the placit place where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the placit place that was removed
	 */
	@Override
	public PlacitPlace removeByUUID_G(String uuid, long groupId)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByUUID_G(uuid, groupId);

		return remove(placitPlace);
	}

	/**
	 * Returns the number of placit places where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

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
		"placitPlace.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(placitPlace.uuid IS NULL OR placitPlace.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"placitPlace.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
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

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (!uuid.equals(placitPlace.getUuid()) ||
						(companyId != placitPlace.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
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

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByUuid_C_PrevAndNext(
			long placitPlaceId, String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		uuid = Objects.toString(uuid, "");

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, placitPlace, uuid, companyId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByUuid_C_PrevAndNext(
				session, placitPlace, uuid, companyId, orderByComparator,
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

	protected PlacitPlace getByUuid_C_PrevAndNext(
		Session session, PlacitPlace placitPlace, String uuid, long companyId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PlacitPlace placitPlace :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

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
		"placitPlace.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(placitPlace.uuid IS NULL OR placitPlace.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"placitPlace.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the placit places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
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

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (groupId != placitPlace.getGroupId()) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByGroupId_First(
			long groupId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByGroupId_First(
			groupId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByGroupId_First(
		long groupId, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByGroupId_Last(
			long groupId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByGroupId_Last(
		long groupId, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where groupId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByGroupId_PrevAndNext(
			long placitPlaceId, long groupId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, placitPlace, groupId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByGroupId_PrevAndNext(
				session, placitPlace, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getByGroupId_PrevAndNext(
		Session session, PlacitPlace placitPlace, long groupId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (PlacitPlace placitPlace :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

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
		"placitPlace.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByProject;
	private FinderPath _finderPathWithoutPaginationFindByProject;
	private FinderPath _finderPathCountByProject;

	/**
	 * Returns all the placit places where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByProject(long projectId) {
		return findByProject(
			projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByProject(long projectId, int start, int end) {
		return findByProject(projectId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByProject(
		long projectId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByProject(projectId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByProject(
		long projectId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProject;
				finderArgs = new Object[] {projectId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProject;
			finderArgs = new Object[] {
				projectId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (projectId != placitPlace.getProjectId()) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByProject_First(
			long projectId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByProject_First(
			projectId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByProject_First(
		long projectId, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByProject(
			projectId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByProject_Last(
			long projectId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByProject_Last(
			projectId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectId=");
		sb.append(projectId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByProject_Last(
		long projectId, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByProject(projectId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByProject(
			projectId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where projectId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByProject_PrevAndNext(
			long placitPlaceId, long projectId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByProject_PrevAndNext(
				session, placitPlace, projectId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByProject_PrevAndNext(
				session, placitPlace, projectId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getByProject_PrevAndNext(
		Session session, PlacitPlace placitPlace, long projectId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(projectId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	@Override
	public void removeByProject(long projectId) {
		for (PlacitPlace placitPlace :
				findByProject(
					projectId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByProject(long projectId) {
		FinderPath finderPath = _finderPathCountByProject;

		Object[] finderArgs = new Object[] {projectId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECT_PROJECTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectId);

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

	private static final String _FINDER_COLUMN_PROJECT_PROJECTID_2 =
		"placitPlace.projectId = ?";

	private FinderPath _finderPathWithPaginationFindByParticipation;
	private FinderPath _finderPathWithoutPaginationFindByParticipation;
	private FinderPath _finderPathCountByParticipation;

	/**
	 * Returns all the placit places where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByParticipation(long participationId) {
		return findByParticipation(
			participationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByParticipation(
		long participationId, int start, int end) {

		return findByParticipation(participationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByParticipation(
		long participationId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByParticipation(
			participationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByParticipation(
		long participationId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByParticipation;
				finderArgs = new Object[] {participationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByParticipation;
			finderArgs = new Object[] {
				participationId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (participationId != placitPlace.getParticipationId()) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PARTICIPATION_PARTICIPATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(participationId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByParticipation_First(
			long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByParticipation_First(
			participationId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("participationId=");
		sb.append(participationId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByParticipation_First(
		long participationId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByParticipation(
			participationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByParticipation_Last(
			long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByParticipation_Last(
			participationId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("participationId=");
		sb.append(participationId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByParticipation_Last(
		long participationId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByParticipation(participationId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByParticipation(
			participationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where participationId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByParticipation_PrevAndNext(
			long placitPlaceId, long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByParticipation_PrevAndNext(
				session, placitPlace, participationId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByParticipation_PrevAndNext(
				session, placitPlace, participationId, orderByComparator,
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

	protected PlacitPlace getByParticipation_PrevAndNext(
		Session session, PlacitPlace placitPlace, long participationId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_PARTICIPATION_PARTICIPATIONID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(participationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where participationId = &#63; from the database.
	 *
	 * @param participationId the participation ID
	 */
	@Override
	public void removeByParticipation(long participationId) {
		for (PlacitPlace placitPlace :
				findByParticipation(
					participationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByParticipation(long participationId) {
		FinderPath finderPath = _finderPathCountByParticipation;

		Object[] finderArgs = new Object[] {participationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PARTICIPATION_PARTICIPATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(participationId);

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

	private static final String _FINDER_COLUMN_PARTICIPATION_PARTICIPATIONID_2 =
		"placitPlace.participationId = ?";

	private FinderPath _finderPathWithPaginationFindByPetition;
	private FinderPath _finderPathWithoutPaginationFindByPetition;
	private FinderPath _finderPathCountByPetition;

	/**
	 * Returns all the placit places where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByPetition(long petitionId) {
		return findByPetition(
			petitionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByPetition(
		long petitionId, int start, int end) {

		return findByPetition(petitionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByPetition(petitionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPetition;
				finderArgs = new Object[] {petitionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPetition;
			finderArgs = new Object[] {
				petitionId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (petitionId != placitPlace.getPetitionId()) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PETITION_PETITIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petitionId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByPetition_First(
			long petitionId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByPetition_First(
			petitionId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petitionId=");
		sb.append(petitionId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByPetition_First(
		long petitionId, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByPetition(
			petitionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByPetition_Last(
			long petitionId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByPetition_Last(
			petitionId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("petitionId=");
		sb.append(petitionId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByPetition_Last(
		long petitionId, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByPetition(petitionId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByPetition(
			petitionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByPetition_PrevAndNext(
			long placitPlaceId, long petitionId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByPetition_PrevAndNext(
				session, placitPlace, petitionId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByPetition_PrevAndNext(
				session, placitPlace, petitionId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getByPetition_PrevAndNext(
		Session session, PlacitPlace placitPlace, long petitionId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_PETITION_PETITIONID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(petitionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where petitionId = &#63; from the database.
	 *
	 * @param petitionId the petition ID
	 */
	@Override
	public void removeByPetition(long petitionId) {
		for (PlacitPlace placitPlace :
				findByPetition(
					petitionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByPetition(long petitionId) {
		FinderPath finderPath = _finderPathCountByPetition;

		Object[] finderArgs = new Object[] {petitionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_PETITION_PETITIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(petitionId);

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

	private static final String _FINDER_COLUMN_PETITION_PETITIONID_2 =
		"placitPlace.petitionId = ?";

	private FinderPath _finderPathWithPaginationFindBySaisineObservatoire;
	private FinderPath _finderPathWithoutPaginationFindBySaisineObservatoire;
	private FinderPath _finderPathCountBySaisineObservatoire;

	/**
	 * Returns all the placit places where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySaisineObservatoire(
		long saisineObservatoireId) {

		return findBySaisineObservatoire(
			saisineObservatoireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where saisineObservatoireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySaisineObservatoire(
		long saisineObservatoireId, int start, int end) {

		return findBySaisineObservatoire(
			saisineObservatoireId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where saisineObservatoireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySaisineObservatoire(
		long saisineObservatoireId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findBySaisineObservatoire(
			saisineObservatoireId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where saisineObservatoireId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySaisineObservatoire(
		long saisineObservatoireId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindBySaisineObservatoire;
				finderArgs = new Object[] {saisineObservatoireId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySaisineObservatoire;
			finderArgs = new Object[] {
				saisineObservatoireId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (saisineObservatoireId !=
							placitPlace.getSaisineObservatoireId()) {

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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(
				_FINDER_COLUMN_SAISINEOBSERVATOIRE_SAISINEOBSERVATOIREID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(saisineObservatoireId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findBySaisineObservatoire_First(
			long saisineObservatoireId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchBySaisineObservatoire_First(
			saisineObservatoireId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("saisineObservatoireId=");
		sb.append(saisineObservatoireId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchBySaisineObservatoire_First(
		long saisineObservatoireId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findBySaisineObservatoire(
			saisineObservatoireId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findBySaisineObservatoire_Last(
			long saisineObservatoireId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchBySaisineObservatoire_Last(
			saisineObservatoireId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("saisineObservatoireId=");
		sb.append(saisineObservatoireId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchBySaisineObservatoire_Last(
		long saisineObservatoireId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countBySaisineObservatoire(saisineObservatoireId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findBySaisineObservatoire(
			saisineObservatoireId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where saisineObservatoireId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findBySaisineObservatoire_PrevAndNext(
			long placitPlaceId, long saisineObservatoireId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getBySaisineObservatoire_PrevAndNext(
				session, placitPlace, saisineObservatoireId, orderByComparator,
				true);

			array[1] = placitPlace;

			array[2] = getBySaisineObservatoire_PrevAndNext(
				session, placitPlace, saisineObservatoireId, orderByComparator,
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

	protected PlacitPlace getBySaisineObservatoire_PrevAndNext(
		Session session, PlacitPlace placitPlace, long saisineObservatoireId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_SAISINEOBSERVATOIRE_SAISINEOBSERVATOIREID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(saisineObservatoireId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where saisineObservatoireId = &#63; from the database.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 */
	@Override
	public void removeBySaisineObservatoire(long saisineObservatoireId) {
		for (PlacitPlace placitPlace :
				findBySaisineObservatoire(
					saisineObservatoireId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where saisineObservatoireId = &#63;.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countBySaisineObservatoire(long saisineObservatoireId) {
		FinderPath finderPath = _finderPathCountBySaisineObservatoire;

		Object[] finderArgs = new Object[] {saisineObservatoireId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(
				_FINDER_COLUMN_SAISINEOBSERVATOIRE_SAISINEOBSERVATOIREID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(saisineObservatoireId);

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
		_FINDER_COLUMN_SAISINEOBSERVATOIRE_SAISINEOBSERVATOIREID_2 =
			"placitPlace.saisineObservatoireId = ?";

	private FinderPath _finderPathWithPaginationFindByBudgetParticipatif;
	private FinderPath _finderPathWithoutPaginationFindByBudgetParticipatif;
	private FinderPath _finderPathCountByBudgetParticipatif;

	/**
	 * Returns all the placit places where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId) {

		return findByBudgetParticipatif(
			budgetParticipatifId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end) {

		return findByBudgetParticipatif(budgetParticipatifId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByBudgetParticipatif(
			budgetParticipatifId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBudgetParticipatif;
				finderArgs = new Object[] {budgetParticipatifId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByBudgetParticipatif;
			finderArgs = new Object[] {
				budgetParticipatifId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (budgetParticipatifId !=
							placitPlace.getBudgetParticipatifId()) {

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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_BUDGETPARTICIPATIF_BUDGETPARTICIPATIFID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetParticipatifId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByBudgetParticipatif_First(
			long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByBudgetParticipatif_First(
			budgetParticipatifId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetParticipatifId=");
		sb.append(budgetParticipatifId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByBudgetParticipatif_First(
		long budgetParticipatifId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByBudgetParticipatif(
			budgetParticipatifId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByBudgetParticipatif_Last(
			long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByBudgetParticipatif_Last(
			budgetParticipatifId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("budgetParticipatifId=");
		sb.append(budgetParticipatifId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByBudgetParticipatif_Last(
		long budgetParticipatifId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByBudgetParticipatif(budgetParticipatifId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByBudgetParticipatif(
			budgetParticipatifId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByBudgetParticipatif_PrevAndNext(
			long placitPlaceId, long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByBudgetParticipatif_PrevAndNext(
				session, placitPlace, budgetParticipatifId, orderByComparator,
				true);

			array[1] = placitPlace;

			array[2] = getByBudgetParticipatif_PrevAndNext(
				session, placitPlace, budgetParticipatifId, orderByComparator,
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

	protected PlacitPlace getByBudgetParticipatif_PrevAndNext(
		Session session, PlacitPlace placitPlace, long budgetParticipatifId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_BUDGETPARTICIPATIF_BUDGETPARTICIPATIFID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(budgetParticipatifId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where budgetParticipatifId = &#63; from the database.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 */
	@Override
	public void removeByBudgetParticipatif(long budgetParticipatifId) {
		for (PlacitPlace placitPlace :
				findByBudgetParticipatif(
					budgetParticipatifId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByBudgetParticipatif(long budgetParticipatifId) {
		FinderPath finderPath = _finderPathCountByBudgetParticipatif;

		Object[] finderArgs = new Object[] {budgetParticipatifId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_BUDGETPARTICIPATIF_BUDGETPARTICIPATIFID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(budgetParticipatifId);

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
		_FINDER_COLUMN_BUDGETPARTICIPATIF_BUDGETPARTICIPATIFID_2 =
			"placitPlace.budgetParticipatifId = ?";

	private FinderPath _finderPathWithPaginationFindByInitiative;
	private FinderPath _finderPathWithoutPaginationFindByInitiative;
	private FinderPath _finderPathCountByInitiative;

	/**
	 * Returns all the placit places where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findByInitiative(long initiativeId) {
		return findByInitiative(
			initiativeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end) {

		return findByInitiative(initiativeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findByInitiative(
			initiativeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInitiative;
				finderArgs = new Object[] {initiativeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInitiative;
			finderArgs = new Object[] {
				initiativeId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (initiativeId != placitPlace.getInitiativeId()) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_INITIATIVE_INITIATIVEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(initiativeId);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByInitiative_First(
			long initiativeId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByInitiative_First(
			initiativeId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("initiativeId=");
		sb.append(initiativeId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByInitiative_First(
		long initiativeId, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findByInitiative(
			initiativeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findByInitiative_Last(
			long initiativeId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByInitiative_Last(
			initiativeId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("initiativeId=");
		sb.append(initiativeId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchByInitiative_Last(
		long initiativeId, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countByInitiative(initiativeId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findByInitiative(
			initiativeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findByInitiative_PrevAndNext(
			long placitPlaceId, long initiativeId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getByInitiative_PrevAndNext(
				session, placitPlace, initiativeId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getByInitiative_PrevAndNext(
				session, placitPlace, initiativeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getByInitiative_PrevAndNext(
		Session session, PlacitPlace placitPlace, long initiativeId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		sb.append(_FINDER_COLUMN_INITIATIVE_INITIATIVEID_2);

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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(initiativeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where initiativeId = &#63; from the database.
	 *
	 * @param initiativeId the initiative ID
	 */
	@Override
	public void removeByInitiative(long initiativeId) {
		for (PlacitPlace placitPlace :
				findByInitiative(
					initiativeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countByInitiative(long initiativeId) {
		FinderPath finderPath = _finderPathCountByInitiative;

		Object[] finderArgs = new Object[] {initiativeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			sb.append(_FINDER_COLUMN_INITIATIVE_INITIATIVEID_2);

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

	private static final String _FINDER_COLUMN_INITIATIVE_INITIATIVEID_2 =
		"placitPlace.initiativeId = ?";

	private FinderPath _finderPathWithPaginationFindBySigId;
	private FinderPath _finderPathWithoutPaginationFindBySigId;
	private FinderPath _finderPathCountBySigId;

	/**
	 * Returns all the placit places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySigId(String placeSIGId) {
		return findBySigId(
			placeSIGId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end) {

		return findBySigId(placeSIGId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return findBySigId(placeSIGId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	@Override
	public List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		placeSIGId = Objects.toString(placeSIGId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySigId;
				finderArgs = new Object[] {placeSIGId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySigId;
			finderArgs = new Object[] {
				placeSIGId, start, end, orderByComparator
			};
		}

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PlacitPlace placitPlace : list) {
					if (!placeSIGId.equals(placitPlace.getPlaceSIGId())) {
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

			sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

			boolean bindPlaceSIGId = false;

			if (placeSIGId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
			}
			else {
				bindPlaceSIGId = true;

				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlaceSIGId) {
					queryPos.add(placeSIGId);
				}

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Returns the first placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findBySigId_First(
			String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchBySigId_First(
			placeSIGId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeSIGId=");
		sb.append(placeSIGId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the first placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchBySigId_First(
		String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator) {

		List<PlacitPlace> list = findBySigId(
			placeSIGId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace findBySigId_Last(
			String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchBySigId_Last(
			placeSIGId, orderByComparator);

		if (placitPlace != null) {
			return placitPlace;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("placeSIGId=");
		sb.append(placeSIGId);

		sb.append("}");

		throw new NoSuchPlacitPlaceException(sb.toString());
	}

	/**
	 * Returns the last placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	@Override
	public PlacitPlace fetchBySigId_Last(
		String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator) {

		int count = countBySigId(placeSIGId);

		if (count == 0) {
			return null;
		}

		List<PlacitPlace> list = findBySigId(
			placeSIGId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace[] findBySigId_PrevAndNext(
			long placitPlaceId, String placeSIGId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws NoSuchPlacitPlaceException {

		placeSIGId = Objects.toString(placeSIGId, "");

		PlacitPlace placitPlace = findByPrimaryKey(placitPlaceId);

		Session session = null;

		try {
			session = openSession();

			PlacitPlace[] array = new PlacitPlaceImpl[3];

			array[0] = getBySigId_PrevAndNext(
				session, placitPlace, placeSIGId, orderByComparator, true);

			array[1] = placitPlace;

			array[2] = getBySigId_PrevAndNext(
				session, placitPlace, placeSIGId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PlacitPlace getBySigId_PrevAndNext(
		Session session, PlacitPlace placitPlace, String placeSIGId,
		OrderByComparator<PlacitPlace> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PLACITPLACE_WHERE);

		boolean bindPlaceSIGId = false;

		if (placeSIGId.isEmpty()) {
			sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
		}
		else {
			bindPlaceSIGId = true;

			sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
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
			sb.append(PlacitPlaceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPlaceSIGId) {
			queryPos.add(placeSIGId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(placitPlace)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PlacitPlace> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the placit places where placeSIGId = &#63; from the database.
	 *
	 * @param placeSIGId the place sig ID
	 */
	@Override
	public void removeBySigId(String placeSIGId) {
		for (PlacitPlace placitPlace :
				findBySigId(
					placeSIGId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the number of matching placit places
	 */
	@Override
	public int countBySigId(String placeSIGId) {
		placeSIGId = Objects.toString(placeSIGId, "");

		FinderPath finderPath = _finderPathCountBySigId;

		Object[] finderArgs = new Object[] {placeSIGId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PLACITPLACE_WHERE);

			boolean bindPlaceSIGId = false;

			if (placeSIGId.isEmpty()) {
				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_3);
			}
			else {
				bindPlaceSIGId = true;

				sb.append(_FINDER_COLUMN_SIGID_PLACESIGID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPlaceSIGId) {
					queryPos.add(placeSIGId);
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

	private static final String _FINDER_COLUMN_SIGID_PLACESIGID_2 =
		"placitPlace.placeSIGId = ?";

	private static final String _FINDER_COLUMN_SIGID_PLACESIGID_3 =
		"(placitPlace.placeSIGId IS NULL OR placitPlace.placeSIGId = '')";

	public PlacitPlacePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PlacitPlace.class);

		setModelImplClass(PlacitPlaceImpl.class);
		setModelPKClass(long.class);

		setTable(PlacitPlaceTable.INSTANCE);
	}

	/**
	 * Caches the placit place in the entity cache if it is enabled.
	 *
	 * @param placitPlace the placit place
	 */
	@Override
	public void cacheResult(PlacitPlace placitPlace) {
		entityCache.putResult(
			PlacitPlaceImpl.class, placitPlace.getPrimaryKey(), placitPlace);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {placitPlace.getUuid(), placitPlace.getGroupId()},
			placitPlace);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the placit places in the entity cache if it is enabled.
	 *
	 * @param placitPlaces the placit places
	 */
	@Override
	public void cacheResult(List<PlacitPlace> placitPlaces) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (placitPlaces.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PlacitPlace placitPlace : placitPlaces) {
			if (entityCache.getResult(
					PlacitPlaceImpl.class, placitPlace.getPrimaryKey()) ==
						null) {

				cacheResult(placitPlace);
			}
		}
	}

	/**
	 * Clears the cache for all placit places.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PlacitPlaceImpl.class);

		finderCache.clearCache(PlacitPlaceImpl.class);
	}

	/**
	 * Clears the cache for the placit place.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PlacitPlace placitPlace) {
		entityCache.removeResult(PlacitPlaceImpl.class, placitPlace);
	}

	@Override
	public void clearCache(List<PlacitPlace> placitPlaces) {
		for (PlacitPlace placitPlace : placitPlaces) {
			entityCache.removeResult(PlacitPlaceImpl.class, placitPlace);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PlacitPlaceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PlacitPlaceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PlacitPlaceModelImpl placitPlaceModelImpl) {

		Object[] args = new Object[] {
			placitPlaceModelImpl.getUuid(), placitPlaceModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, placitPlaceModelImpl);
	}

	/**
	 * Creates a new placit place with the primary key. Does not add the placit place to the database.
	 *
	 * @param placitPlaceId the primary key for the new placit place
	 * @return the new placit place
	 */
	@Override
	public PlacitPlace create(long placitPlaceId) {
		PlacitPlace placitPlace = new PlacitPlaceImpl();

		placitPlace.setNew(true);
		placitPlace.setPrimaryKey(placitPlaceId);

		String uuid = PortalUUIDUtil.generate();

		placitPlace.setUuid(uuid);

		placitPlace.setCompanyId(CompanyThreadLocal.getCompanyId());

		return placitPlace;
	}

	/**
	 * Removes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace remove(long placitPlaceId)
		throws NoSuchPlacitPlaceException {

		return remove((Serializable)placitPlaceId);
	}

	/**
	 * Removes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace remove(Serializable primaryKey)
		throws NoSuchPlacitPlaceException {

		Session session = null;

		try {
			session = openSession();

			PlacitPlace placitPlace = (PlacitPlace)session.get(
				PlacitPlaceImpl.class, primaryKey);

			if (placitPlace == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPlacitPlaceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(placitPlace);
		}
		catch (NoSuchPlacitPlaceException noSuchEntityException) {
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
	protected PlacitPlace removeImpl(PlacitPlace placitPlace) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(placitPlace)) {
				placitPlace = (PlacitPlace)session.get(
					PlacitPlaceImpl.class, placitPlace.getPrimaryKeyObj());
			}

			if (placitPlace != null) {
				session.delete(placitPlace);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (placitPlace != null) {
			clearCache(placitPlace);
		}

		return placitPlace;
	}

	@Override
	public PlacitPlace updateImpl(PlacitPlace placitPlace) {
		boolean isNew = placitPlace.isNew();

		if (!(placitPlace instanceof PlacitPlaceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(placitPlace.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(placitPlace);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in placitPlace proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PlacitPlace implementation " +
					placitPlace.getClass());
		}

		PlacitPlaceModelImpl placitPlaceModelImpl =
			(PlacitPlaceModelImpl)placitPlace;

		if (Validator.isNull(placitPlace.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			placitPlace.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (placitPlace.getCreateDate() == null)) {
			if (serviceContext == null) {
				placitPlace.setCreateDate(date);
			}
			else {
				placitPlace.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!placitPlaceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				placitPlace.setModifiedDate(date);
			}
			else {
				placitPlace.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(placitPlace);
			}
			else {
				placitPlace = (PlacitPlace)session.merge(placitPlace);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PlacitPlaceImpl.class, placitPlaceModelImpl, false, true);

		cacheUniqueFindersCache(placitPlaceModelImpl);

		if (isNew) {
			placitPlace.setNew(false);
		}

		placitPlace.resetOriginalValues();

		return placitPlace;
	}

	/**
	 * Returns the placit place with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the placit place
	 * @return the placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPlacitPlaceException {

		PlacitPlace placitPlace = fetchByPrimaryKey(primaryKey);

		if (placitPlace == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPlacitPlaceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return placitPlace;
	}

	/**
	 * Returns the placit place with the primary key or throws a <code>NoSuchPlacitPlaceException</code> if it could not be found.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace findByPrimaryKey(long placitPlaceId)
		throws NoSuchPlacitPlaceException {

		return findByPrimaryKey((Serializable)placitPlaceId);
	}

	/**
	 * Returns the placit place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place, or <code>null</code> if a placit place with the primary key could not be found
	 */
	@Override
	public PlacitPlace fetchByPrimaryKey(long placitPlaceId) {
		return fetchByPrimaryKey((Serializable)placitPlaceId);
	}

	/**
	 * Returns all the placit places.
	 *
	 * @return the placit places
	 */
	@Override
	public List<PlacitPlace> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of placit places
	 */
	@Override
	public List<PlacitPlace> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of placit places
	 */
	@Override
	public List<PlacitPlace> findAll(
		int start, int end, OrderByComparator<PlacitPlace> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of placit places
	 */
	@Override
	public List<PlacitPlace> findAll(
		int start, int end, OrderByComparator<PlacitPlace> orderByComparator,
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

		List<PlacitPlace> list = null;

		if (useFinderCache) {
			list = (List<PlacitPlace>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PLACITPLACE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PLACITPLACE;

				sql = sql.concat(PlacitPlaceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PlacitPlace>)QueryUtil.list(
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
	 * Removes all the placit places from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PlacitPlace placitPlace : findAll()) {
			remove(placitPlace);
		}
	}

	/**
	 * Returns the number of placit places.
	 *
	 * @return the number of placit places
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PLACITPLACE);

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
		return "placitPlaceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PLACITPLACE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PlacitPlaceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the placit place persistence.
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

		_finderPathWithPaginationFindByProject = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProject",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"projectId"}, true);

		_finderPathWithoutPaginationFindByProject = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProject",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			true);

		_finderPathCountByProject = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProject",
			new String[] {Long.class.getName()}, new String[] {"projectId"},
			false);

		_finderPathWithPaginationFindByParticipation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParticipation",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"participationId"}, true);

		_finderPathWithoutPaginationFindByParticipation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParticipation",
			new String[] {Long.class.getName()},
			new String[] {"participationId"}, true);

		_finderPathCountByParticipation = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParticipation",
			new String[] {Long.class.getName()},
			new String[] {"participationId"}, false);

		_finderPathWithPaginationFindByPetition = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPetition",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"petitionId"}, true);

		_finderPathWithoutPaginationFindByPetition = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPetition",
			new String[] {Long.class.getName()}, new String[] {"petitionId"},
			true);

		_finderPathCountByPetition = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPetition",
			new String[] {Long.class.getName()}, new String[] {"petitionId"},
			false);

		_finderPathWithPaginationFindBySaisineObservatoire = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySaisineObservatoire",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"saisineObservatoireId"}, true);

		_finderPathWithoutPaginationFindBySaisineObservatoire = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBySaisineObservatoire", new String[] {Long.class.getName()},
			new String[] {"saisineObservatoireId"}, true);

		_finderPathCountBySaisineObservatoire = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySaisineObservatoire", new String[] {Long.class.getName()},
			new String[] {"saisineObservatoireId"}, false);

		_finderPathWithPaginationFindByBudgetParticipatif = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBudgetParticipatif",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"budgetParticipatifId"}, true);

		_finderPathWithoutPaginationFindByBudgetParticipatif = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBudgetParticipatif", new String[] {Long.class.getName()},
			new String[] {"budgetParticipatifId"}, true);

		_finderPathCountByBudgetParticipatif = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBudgetParticipatif", new String[] {Long.class.getName()},
			new String[] {"budgetParticipatifId"}, false);

		_finderPathWithPaginationFindByInitiative = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInitiative",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"initiativeId"}, true);

		_finderPathWithoutPaginationFindByInitiative = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInitiative",
			new String[] {Long.class.getName()}, new String[] {"initiativeId"},
			true);

		_finderPathCountByInitiative = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInitiative",
			new String[] {Long.class.getName()}, new String[] {"initiativeId"},
			false);

		_finderPathWithPaginationFindBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySigId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"placeSIGId"}, true);

		_finderPathWithoutPaginationFindBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySigId",
			new String[] {String.class.getName()}, new String[] {"placeSIGId"},
			true);

		_finderPathCountBySigId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySigId",
			new String[] {String.class.getName()}, new String[] {"placeSIGId"},
			false);

		PlacitPlaceUtil.setPersistence(this);
	}

	public void destroy() {
		PlacitPlaceUtil.setPersistence(null);

		entityCache.removeCache(PlacitPlaceImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PLACITPLACE =
		"SELECT placitPlace FROM PlacitPlace placitPlace";

	private static final String _SQL_SELECT_PLACITPLACE_WHERE =
		"SELECT placitPlace FROM PlacitPlace placitPlace WHERE ";

	private static final String _SQL_COUNT_PLACITPLACE =
		"SELECT COUNT(placitPlace) FROM PlacitPlace placitPlace";

	private static final String _SQL_COUNT_PLACITPLACE_WHERE =
		"SELECT COUNT(placitPlace) FROM PlacitPlace placitPlace WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "placitPlace.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PlacitPlace exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PlacitPlace exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PlacitPlacePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}