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
import com.liferay.portal.kernel.bean.BeanReference;
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
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.agenda.exception.NoSuchManifestationException;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.model.ManifestationTable;
import eu.strasbourg.service.agenda.model.impl.ManifestationImpl;
import eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl;
import eu.strasbourg.service.agenda.service.persistence.EventPersistence;
import eu.strasbourg.service.agenda.service.persistence.ManifestationPersistence;
import eu.strasbourg.service.agenda.service.persistence.ManifestationUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the manifestation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class ManifestationPersistenceImpl
	extends BasePersistenceImpl<Manifestation>
	implements ManifestationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ManifestationUtil</code> to access the manifestation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ManifestationImpl.class.getName();

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
	 * Returns all the manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
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

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if (!uuid.equals(manifestation.getUuid())) {
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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByUuid_First(
			String uuid, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByUuid_First(
			uuid, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUuid_First(
		String uuid, OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByUuid_Last(
			String uuid, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByUuid_Last(uuid, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUuid_Last(
		String uuid, OrderByComparator<Manifestation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByUuid_PrevAndNext(
			long manifestationId, String uuid,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		uuid = Objects.toString(uuid, "");

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, manifestation, uuid, orderByComparator, true);

			array[1] = manifestation;

			array[2] = getByUuid_PrevAndNext(
				session, manifestation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manifestation getByUuid_PrevAndNext(
		Session session, Manifestation manifestation, String uuid,
		OrderByComparator<Manifestation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
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
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Manifestation manifestation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

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
		"manifestation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(manifestation.uuid IS NULL OR manifestation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByUUID_G(String uuid, long groupId)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByUUID_G(uuid, groupId);

		if (manifestation == null) {
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

			throw new NoSuchManifestationException(sb.toString());
		}

		return manifestation;
	}

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUUID_G(
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

		if (result instanceof Manifestation) {
			Manifestation manifestation = (Manifestation)result;

			if (!Objects.equals(uuid, manifestation.getUuid()) ||
				(groupId != manifestation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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

				List<Manifestation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Manifestation manifestation = list.get(0);

					result = manifestation;

					cacheResult(manifestation);
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
			return (Manifestation)result;
		}
	}

	/**
	 * Removes the manifestation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the manifestation that was removed
	 */
	@Override
	public Manifestation removeByUUID_G(String uuid, long groupId)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByUUID_G(uuid, groupId);

		return remove(manifestation);
	}

	/**
	 * Returns the number of manifestations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

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
		"manifestation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(manifestation.uuid IS NULL OR manifestation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"manifestation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
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

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if (!uuid.equals(manifestation.getUuid()) ||
						(companyId != manifestation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Manifestation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByUuid_C_PrevAndNext(
			long manifestationId, String uuid, long companyId,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		uuid = Objects.toString(uuid, "");

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, manifestation, uuid, companyId, orderByComparator,
				true);

			array[1] = manifestation;

			array[2] = getByUuid_C_PrevAndNext(
				session, manifestation, uuid, companyId, orderByComparator,
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

	protected Manifestation getByUuid_C_PrevAndNext(
		Session session, Manifestation manifestation, String uuid,
		long companyId, OrderByComparator<Manifestation> orderByComparator,
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

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
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
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Manifestation manifestation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

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
		"manifestation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(manifestation.uuid IS NULL OR manifestation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"manifestation.companyId = ?";

	private FinderPath _finderPathWithPaginationFindBytitle;
	private FinderPath _finderPathWithoutPaginationFindBytitle;
	private FinderPath _finderPathCountBytitle;

	/**
	 * Returns all the manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findBytitle(String title) {
		return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findBytitle(String title, int start, int end) {
		return findBytitle(title, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findBytitle(
		String title, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findBytitle(title, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findBytitle(
		String title, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		title = Objects.toString(title, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBytitle;
				finderArgs = new Object[] {title};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBytitle;
			finderArgs = new Object[] {title, start, end, orderByComparator};
		}

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if (!title.equals(manifestation.getTitle())) {
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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findBytitle_First(
			String title, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchBytitle_First(
			title, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchBytitle_First(
		String title, OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findBytitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findBytitle_Last(
			String title, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchBytitle_Last(
			title, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("title=");
		sb.append(title);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchBytitle_Last(
		String title, OrderByComparator<Manifestation> orderByComparator) {

		int count = countBytitle(title);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findBytitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where title = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findBytitle_PrevAndNext(
			long manifestationId, String title,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		title = Objects.toString(title, "");

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getBytitle_PrevAndNext(
				session, manifestation, title, orderByComparator, true);

			array[1] = manifestation;

			array[2] = getBytitle_PrevAndNext(
				session, manifestation, title, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manifestation getBytitle_PrevAndNext(
		Session session, Manifestation manifestation, String title,
		OrderByComparator<Manifestation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTitle) {
			queryPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeBytitle(String title) {
		for (Manifestation manifestation :
				findBytitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching manifestations
	 */
	@Override
	public int countBytitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountBytitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
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

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 =
		"manifestation.title = ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(manifestation.title IS NULL OR manifestation.title = '')";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
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

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if (groupId != manifestation.getGroupId()) {
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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByGroupId_First(
			long groupId, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByGroupId_First(
			groupId, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByGroupId_First(
		long groupId, OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByGroupId_Last(
			long groupId, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByGroupId_Last(
		long groupId, OrderByComparator<Manifestation> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByGroupId_PrevAndNext(
			long manifestationId, long groupId,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, manifestation, groupId, orderByComparator, true);

			array[1] = manifestation;

			array[2] = getByGroupId_PrevAndNext(
				session, manifestation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manifestation getByGroupId_PrevAndNext(
		Session session, Manifestation manifestation, long groupId,
		OrderByComparator<Manifestation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
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
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Manifestation manifestation :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

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
		"manifestation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPublicationDateAndStatus;
	private FinderPath _finderPathWithPaginationCountByPublicationDateAndStatus;

	/**
	 * Returns all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return findByPublicationDateAndStatus(
			publicationDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end) {

		return findByPublicationDateAndStatus(
			publicationDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByPublicationDateAndStatus;
		finderArgs = new Object[] {
			_getTime(publicationDate), status, start, end, orderByComparator
		};

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if ((publicationDate.getTime() <=
							manifestation.getPublicationDate(
							).getTime()) ||
						(status != manifestation.getStatus())) {

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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindPublicationDate = false;

			if (publicationDate == null) {
				sb.append(
					_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_1);
			}
			else {
				bindPublicationDate = true;

				sb.append(
					_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublicationDate) {
					queryPos.add(new Timestamp(publicationDate.getTime()));
				}

				queryPos.add(status);

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publicationDate<");
		sb.append(publicationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByPublicationDateAndStatus(
			publicationDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publicationDate<");
		sb.append(publicationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		int count = countByPublicationDateAndStatus(publicationDate, status);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByPublicationDateAndStatus(
			publicationDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByPublicationDateAndStatus_PrevAndNext(
			long manifestationId, Date publicationDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByPublicationDateAndStatus_PrevAndNext(
				session, manifestation, publicationDate, status,
				orderByComparator, true);

			array[1] = manifestation;

			array[2] = getByPublicationDateAndStatus_PrevAndNext(
				session, manifestation, publicationDate, status,
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

	protected Manifestation getByPublicationDateAndStatus_PrevAndNext(
		Session session, Manifestation manifestation, Date publicationDate,
		int status, OrderByComparator<Manifestation> orderByComparator,
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

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

		boolean bindPublicationDate = false;

		if (publicationDate == null) {
			sb.append(
				_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_1);
		}
		else {
			bindPublicationDate = true;

			sb.append(
				_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_2);
		}

		sb.append(_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_STATUS_2);

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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPublicationDate) {
			queryPos.add(new Timestamp(publicationDate.getTime()));
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	@Override
	public void removeByPublicationDateAndStatus(
		Date publicationDate, int status) {

		for (Manifestation manifestation :
				findByPublicationDateAndStatus(
					publicationDate, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByPublicationDateAndStatus(
		Date publicationDate, int status) {

		FinderPath finderPath =
			_finderPathWithPaginationCountByPublicationDateAndStatus;

		Object[] finderArgs = new Object[] {_getTime(publicationDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindPublicationDate = false;

			if (publicationDate == null) {
				sb.append(
					_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_1);
			}
			else {
				bindPublicationDate = true;

				sb.append(
					_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublicationDate) {
					queryPos.add(new Timestamp(publicationDate.getTime()));
				}

				queryPos.add(status);

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
		_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_1 =
			"manifestation.publicationDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_2 =
			"manifestation.publicationDate < ? AND ";

	private static final String
		_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_STATUS_2 =
			"manifestation.status = ?";

	private FinderPath _finderPathWithPaginationFindByEndDate;
	private FinderPath _finderPathWithPaginationCountByEndDate;

	/**
	 * Returns all the manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByEndDate(Date endDate) {
		return findByEndDate(
			endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByEndDate(Date endDate, int start, int end) {
		return findByEndDate(endDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByEndDate(endDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByEndDate;
		finderArgs = new Object[] {
			_getTime(endDate), start, end, orderByComparator
		};

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if (endDate.getTime() <= manifestation.getEndDate(
						).getTime()) {

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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
				}

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByEndDate_First(
			Date endDate, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByEndDate_First(
			endDate, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("endDate<");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByEndDate_First(
		Date endDate, OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByEndDate(
			endDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByEndDate_Last(
			Date endDate, OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByEndDate_Last(
			endDate, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("endDate<");
		sb.append(endDate);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByEndDate_Last(
		Date endDate, OrderByComparator<Manifestation> orderByComparator) {

		int count = countByEndDate(endDate);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByEndDate(
			endDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByEndDate_PrevAndNext(
			long manifestationId, Date endDate,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByEndDate_PrevAndNext(
				session, manifestation, endDate, orderByComparator, true);

			array[1] = manifestation;

			array[2] = getByEndDate_PrevAndNext(
				session, manifestation, endDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Manifestation getByEndDate_PrevAndNext(
		Session session, Manifestation manifestation, Date endDate,
		OrderByComparator<Manifestation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

		boolean bindEndDate = false;

		if (endDate == null) {
			sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
		}
		else {
			bindEndDate = true;

			sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEndDate) {
			queryPos.add(new Timestamp(endDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where endDate &lt; &#63; from the database.
	 *
	 * @param endDate the end date
	 */
	@Override
	public void removeByEndDate(Date endDate) {
		for (Manifestation manifestation :
				findByEndDate(
					endDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByEndDate(Date endDate) {
		FinderPath finderPath = _finderPathWithPaginationCountByEndDate;

		Object[] finderArgs = new Object[] {_getTime(endDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindEndDate = false;

			if (endDate == null) {
				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_1);
			}
			else {
				bindEndDate = true;

				sb.append(_FINDER_COLUMN_ENDDATE_ENDDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEndDate) {
					queryPos.add(new Timestamp(endDate.getTime()));
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

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_1 =
		"manifestation.endDate IS NULL";

	private static final String _FINDER_COLUMN_ENDDATE_ENDDATE_2 =
		"manifestation.endDate < ?";

	private FinderPath _finderPathWithPaginationFindByStatusDateAndStatus;
	private FinderPath _finderPathWithPaginationCountByStatusDateAndStatus;

	/**
	 * Returns all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the matching manifestations
	 */
	@Override
	public List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status) {

		return findByStatusDateAndStatus(
			statusDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end) {

		return findByStatusDateAndStatus(statusDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findByStatusDateAndStatus(
			statusDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	@Override
	public List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		OrderByComparator<Manifestation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByStatusDateAndStatus;
		finderArgs = new Object[] {
			_getTime(statusDate), status, start, end, orderByComparator
		};

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Manifestation manifestation : list) {
					if ((statusDate.getTime() <= manifestation.getStatusDate(
						).getTime()) || (status != manifestation.getStatus())) {

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

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindStatusDate = false;

			if (statusDate == null) {
				sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_1);
			}
			else {
				bindStatusDate = true;

				sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_2);
			}

			sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatusDate) {
					queryPos.add(new Timestamp(statusDate.getTime()));
				}

				queryPos.add(status);

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByStatusDateAndStatus_First(
			Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByStatusDateAndStatus_First(
			statusDate, status, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statusDate<");
		sb.append(statusDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByStatusDateAndStatus_First(
		Date statusDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		List<Manifestation> list = findByStatusDateAndStatus(
			statusDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByStatusDateAndStatus_Last(
			Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByStatusDateAndStatus_Last(
			statusDate, status, orderByComparator);

		if (manifestation != null) {
			return manifestation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("statusDate<");
		sb.append(statusDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchManifestationException(sb.toString());
	}

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByStatusDateAndStatus_Last(
		Date statusDate, int status,
		OrderByComparator<Manifestation> orderByComparator) {

		int count = countByStatusDateAndStatus(statusDate, status);

		if (count == 0) {
			return null;
		}

		List<Manifestation> list = findByStatusDateAndStatus(
			statusDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation[] findByStatusDateAndStatus_PrevAndNext(
			long manifestationId, Date statusDate, int status,
			OrderByComparator<Manifestation> orderByComparator)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByPrimaryKey(manifestationId);

		Session session = null;

		try {
			session = openSession();

			Manifestation[] array = new ManifestationImpl[3];

			array[0] = getByStatusDateAndStatus_PrevAndNext(
				session, manifestation, statusDate, status, orderByComparator,
				true);

			array[1] = manifestation;

			array[2] = getByStatusDateAndStatus_PrevAndNext(
				session, manifestation, statusDate, status, orderByComparator,
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

	protected Manifestation getByStatusDateAndStatus_PrevAndNext(
		Session session, Manifestation manifestation, Date statusDate,
		int status, OrderByComparator<Manifestation> orderByComparator,
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

		sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

		boolean bindStatusDate = false;

		if (statusDate == null) {
			sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_1);
		}
		else {
			bindStatusDate = true;

			sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_2);
		}

		sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUS_2);

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
			sb.append(ManifestationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindStatusDate) {
			queryPos.add(new Timestamp(statusDate.getTime()));
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						manifestation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Manifestation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the manifestations where statusDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 */
	@Override
	public void removeByStatusDateAndStatus(Date statusDate, int status) {
		for (Manifestation manifestation :
				findByStatusDateAndStatus(
					statusDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByStatusDateAndStatus(Date statusDate, int status) {
		FinderPath finderPath =
			_finderPathWithPaginationCountByStatusDateAndStatus;

		Object[] finderArgs = new Object[] {_getTime(statusDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindStatusDate = false;

			if (statusDate == null) {
				sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_1);
			}
			else {
				bindStatusDate = true;

				sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_2);
			}

			sb.append(_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindStatusDate) {
					queryPos.add(new Timestamp(statusDate.getTime()));
				}

				queryPos.add(status);

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
		_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_1 =
			"manifestation.statusDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_STATUSDATEANDSTATUS_STATUSDATE_2 =
			"manifestation.statusDate < ? AND ";

	private static final String _FINDER_COLUMN_STATUSDATEANDSTATUS_STATUS_2 =
		"manifestation.status = ?";

	private FinderPath _finderPathFetchBySourceAndIdSource;
	private FinderPath _finderPathCountBySourceAndIdSource;

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findBySourceAndIdSource(String source, String idSource)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchBySourceAndIdSource(
			source, idSource);

		if (manifestation == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("source=");
			sb.append(source);

			sb.append(", idSource=");
			sb.append(idSource);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchManifestationException(sb.toString());
		}

		return manifestation;
	}

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchBySourceAndIdSource(
		String source, String idSource) {

		return fetchBySourceAndIdSource(source, idSource, true);
	}

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchBySourceAndIdSource(
		String source, String idSource, boolean useFinderCache) {

		source = Objects.toString(source, "");
		idSource = Objects.toString(idSource, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {source, idSource};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySourceAndIdSource, finderArgs, this);
		}

		if (result instanceof Manifestation) {
			Manifestation manifestation = (Manifestation)result;

			if (!Objects.equals(source, manifestation.getSource()) ||
				!Objects.equals(idSource, manifestation.getIdSource())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindSource = false;

			if (source.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_3);
			}
			else {
				bindSource = true;

				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_2);
			}

			boolean bindIdSource = false;

			if (idSource.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_3);
			}
			else {
				bindIdSource = true;

				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSource) {
					queryPos.add(source);
				}

				if (bindIdSource) {
					queryPos.add(idSource);
				}

				List<Manifestation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySourceAndIdSource, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {source, idSource};
							}

							_log.warn(
								"ManifestationPersistenceImpl.fetchBySourceAndIdSource(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Manifestation manifestation = list.get(0);

					result = manifestation;

					cacheResult(manifestation);
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
			return (Manifestation)result;
		}
	}

	/**
	 * Removes the manifestation where source = &#63; and idSource = &#63; from the database.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	@Override
	public Manifestation removeBySourceAndIdSource(
			String source, String idSource)
		throws NoSuchManifestationException {

		Manifestation manifestation = findBySourceAndIdSource(source, idSource);

		return remove(manifestation);
	}

	/**
	 * Returns the number of manifestations where source = &#63; and idSource = &#63;.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	@Override
	public int countBySourceAndIdSource(String source, String idSource) {
		source = Objects.toString(source, "");
		idSource = Objects.toString(idSource, "");

		FinderPath finderPath = _finderPathCountBySourceAndIdSource;

		Object[] finderArgs = new Object[] {source, idSource};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindSource = false;

			if (source.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_3);
			}
			else {
				bindSource = true;

				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_2);
			}

			boolean bindIdSource = false;

			if (idSource.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_3);
			}
			else {
				bindIdSource = true;

				sb.append(_FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSource) {
					queryPos.add(source);
				}

				if (bindIdSource) {
					queryPos.add(idSource);
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

	private static final String _FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_2 =
		"manifestation.source = ? AND ";

	private static final String _FINDER_COLUMN_SOURCEANDIDSOURCE_SOURCE_3 =
		"(manifestation.source IS NULL OR manifestation.source = '') AND ";

	private static final String _FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_2 =
		"manifestation.idSource = ?";

	private static final String _FINDER_COLUMN_SOURCEANDIDSOURCE_IDSOURCE_3 =
		"(manifestation.idSource IS NULL OR manifestation.idSource = '')";

	private FinderPath _finderPathFetchByIdSource;
	private FinderPath _finderPathCountByIdSource;

	/**
	 * Returns the manifestation where idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	@Override
	public Manifestation findByIdSource(String idSource)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByIdSource(idSource);

		if (manifestation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("idSource=");
			sb.append(idSource);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchManifestationException(sb.toString());
		}

		return manifestation;
	}

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByIdSource(String idSource) {
		return fetchByIdSource(idSource, true);
	}

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	@Override
	public Manifestation fetchByIdSource(
		String idSource, boolean useFinderCache) {

		idSource = Objects.toString(idSource, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {idSource};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByIdSource, finderArgs, this);
		}

		if (result instanceof Manifestation) {
			Manifestation manifestation = (Manifestation)result;

			if (!Objects.equals(idSource, manifestation.getIdSource())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MANIFESTATION_WHERE);

			boolean bindIdSource = false;

			if (idSource.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDSOURCE_IDSOURCE_3);
			}
			else {
				bindIdSource = true;

				sb.append(_FINDER_COLUMN_IDSOURCE_IDSOURCE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdSource) {
					queryPos.add(idSource);
				}

				List<Manifestation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByIdSource, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {idSource};
							}

							_log.warn(
								"ManifestationPersistenceImpl.fetchByIdSource(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Manifestation manifestation = list.get(0);

					result = manifestation;

					cacheResult(manifestation);
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
			return (Manifestation)result;
		}
	}

	/**
	 * Removes the manifestation where idSource = &#63; from the database.
	 *
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	@Override
	public Manifestation removeByIdSource(String idSource)
		throws NoSuchManifestationException {

		Manifestation manifestation = findByIdSource(idSource);

		return remove(manifestation);
	}

	/**
	 * Returns the number of manifestations where idSource = &#63;.
	 *
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	@Override
	public int countByIdSource(String idSource) {
		idSource = Objects.toString(idSource, "");

		FinderPath finderPath = _finderPathCountByIdSource;

		Object[] finderArgs = new Object[] {idSource};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MANIFESTATION_WHERE);

			boolean bindIdSource = false;

			if (idSource.isEmpty()) {
				sb.append(_FINDER_COLUMN_IDSOURCE_IDSOURCE_3);
			}
			else {
				bindIdSource = true;

				sb.append(_FINDER_COLUMN_IDSOURCE_IDSOURCE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindIdSource) {
					queryPos.add(idSource);
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

	private static final String _FINDER_COLUMN_IDSOURCE_IDSOURCE_2 =
		"manifestation.idSource = ?";

	private static final String _FINDER_COLUMN_IDSOURCE_IDSOURCE_3 =
		"(manifestation.idSource IS NULL OR manifestation.idSource = '')";

	public ManifestationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Manifestation.class);

		setModelImplClass(ManifestationImpl.class);
		setModelPKClass(long.class);

		setTable(ManifestationTable.INSTANCE);
	}

	/**
	 * Caches the manifestation in the entity cache if it is enabled.
	 *
	 * @param manifestation the manifestation
	 */
	@Override
	public void cacheResult(Manifestation manifestation) {
		entityCache.putResult(
			ManifestationImpl.class, manifestation.getPrimaryKey(),
			manifestation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {manifestation.getUuid(), manifestation.getGroupId()},
			manifestation);

		finderCache.putResult(
			_finderPathFetchBySourceAndIdSource,
			new Object[] {
				manifestation.getSource(), manifestation.getIdSource()
			},
			manifestation);

		finderCache.putResult(
			_finderPathFetchByIdSource,
			new Object[] {manifestation.getIdSource()}, manifestation);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the manifestations in the entity cache if it is enabled.
	 *
	 * @param manifestations the manifestations
	 */
	@Override
	public void cacheResult(List<Manifestation> manifestations) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (manifestations.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Manifestation manifestation : manifestations) {
			if (entityCache.getResult(
					ManifestationImpl.class, manifestation.getPrimaryKey()) ==
						null) {

				cacheResult(manifestation);
			}
		}
	}

	/**
	 * Clears the cache for all manifestations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ManifestationImpl.class);

		finderCache.clearCache(ManifestationImpl.class);
	}

	/**
	 * Clears the cache for the manifestation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Manifestation manifestation) {
		entityCache.removeResult(ManifestationImpl.class, manifestation);
	}

	@Override
	public void clearCache(List<Manifestation> manifestations) {
		for (Manifestation manifestation : manifestations) {
			entityCache.removeResult(ManifestationImpl.class, manifestation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ManifestationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ManifestationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ManifestationModelImpl manifestationModelImpl) {

		Object[] args = new Object[] {
			manifestationModelImpl.getUuid(),
			manifestationModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, manifestationModelImpl);

		args = new Object[] {
			manifestationModelImpl.getSource(),
			manifestationModelImpl.getIdSource()
		};

		finderCache.putResult(
			_finderPathCountBySourceAndIdSource, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySourceAndIdSource, args, manifestationModelImpl);

		args = new Object[] {manifestationModelImpl.getIdSource()};

		finderCache.putResult(
			_finderPathCountByIdSource, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByIdSource, args, manifestationModelImpl);
	}

	/**
	 * Creates a new manifestation with the primary key. Does not add the manifestation to the database.
	 *
	 * @param manifestationId the primary key for the new manifestation
	 * @return the new manifestation
	 */
	@Override
	public Manifestation create(long manifestationId) {
		Manifestation manifestation = new ManifestationImpl();

		manifestation.setNew(true);
		manifestation.setPrimaryKey(manifestationId);

		String uuid = _portalUUID.generate();

		manifestation.setUuid(uuid);

		manifestation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return manifestation;
	}

	/**
	 * Removes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation remove(long manifestationId)
		throws NoSuchManifestationException {

		return remove((Serializable)manifestationId);
	}

	/**
	 * Removes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation remove(Serializable primaryKey)
		throws NoSuchManifestationException {

		Session session = null;

		try {
			session = openSession();

			Manifestation manifestation = (Manifestation)session.get(
				ManifestationImpl.class, primaryKey);

			if (manifestation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchManifestationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(manifestation);
		}
		catch (NoSuchManifestationException noSuchEntityException) {
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
	protected Manifestation removeImpl(Manifestation manifestation) {
		manifestationToEventTableMapper.deleteLeftPrimaryKeyTableMappings(
			manifestation.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(manifestation)) {
				manifestation = (Manifestation)session.get(
					ManifestationImpl.class, manifestation.getPrimaryKeyObj());
			}

			if (manifestation != null) {
				session.delete(manifestation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (manifestation != null) {
			clearCache(manifestation);
		}

		return manifestation;
	}

	@Override
	public Manifestation updateImpl(Manifestation manifestation) {
		boolean isNew = manifestation.isNew();

		if (!(manifestation instanceof ManifestationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(manifestation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					manifestation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in manifestation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Manifestation implementation " +
					manifestation.getClass());
		}

		ManifestationModelImpl manifestationModelImpl =
			(ManifestationModelImpl)manifestation;

		if (Validator.isNull(manifestation.getUuid())) {
			String uuid = _portalUUID.generate();

			manifestation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (manifestation.getCreateDate() == null)) {
			if (serviceContext == null) {
				manifestation.setCreateDate(date);
			}
			else {
				manifestation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!manifestationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				manifestation.setModifiedDate(date);
			}
			else {
				manifestation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(manifestation);
			}
			else {
				manifestation = (Manifestation)session.merge(manifestation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ManifestationImpl.class, manifestationModelImpl, false, true);

		cacheUniqueFindersCache(manifestationModelImpl);

		if (isNew) {
			manifestation.setNew(false);
		}

		manifestation.resetOriginalValues();

		return manifestation;
	}

	/**
	 * Returns the manifestation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the manifestation
	 * @return the manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchManifestationException {

		Manifestation manifestation = fetchByPrimaryKey(primaryKey);

		if (manifestation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchManifestationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return manifestation;
	}

	/**
	 * Returns the manifestation with the primary key or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation findByPrimaryKey(long manifestationId)
		throws NoSuchManifestationException {

		return findByPrimaryKey((Serializable)manifestationId);
	}

	/**
	 * Returns the manifestation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation, or <code>null</code> if a manifestation with the primary key could not be found
	 */
	@Override
	public Manifestation fetchByPrimaryKey(long manifestationId) {
		return fetchByPrimaryKey((Serializable)manifestationId);
	}

	/**
	 * Returns all the manifestations.
	 *
	 * @return the manifestations
	 */
	@Override
	public List<Manifestation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of manifestations
	 */
	@Override
	public List<Manifestation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manifestations
	 */
	@Override
	public List<Manifestation> findAll(
		int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of manifestations
	 */
	@Override
	public List<Manifestation> findAll(
		int start, int end, OrderByComparator<Manifestation> orderByComparator,
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

		List<Manifestation> list = null;

		if (useFinderCache) {
			list = (List<Manifestation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MANIFESTATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MANIFESTATION;

				sql = sql.concat(ManifestationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Manifestation>)QueryUtil.list(
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
	 * Removes all the manifestations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Manifestation manifestation : findAll()) {
			remove(manifestation);
		}
	}

	/**
	 * Returns the number of manifestations.
	 *
	 * @return the number of manifestations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MANIFESTATION);

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

	/**
	 * Returns the primaryKeys of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return long[] of the primaryKeys of events associated with the manifestation
	 */
	@Override
	public long[] getEventPrimaryKeys(long pk) {
		long[] pks = manifestationToEventTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the events associated with the manifestation
	 */
	@Override
	public List<eu.strasbourg.service.agenda.model.Event> getEvents(long pk) {
		return getEvents(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns a range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of events associated with the manifestation
	 */
	@Override
	public List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end) {

		return getEvents(pk, start, end, null);
	}

	/**
	 * Returns an ordered range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of events associated with the manifestation
	 */
	@Override
	public List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end,
		OrderByComparator<eu.strasbourg.service.agenda.model.Event>
			orderByComparator) {

		return manifestationToEventTableMapper.getRightBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the number of events associated with the manifestation
	 */
	@Override
	public int getEventsSize(long pk) {
		long[] pks = manifestationToEventTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the event is associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 * @return <code>true</code> if the event is associated with the manifestation; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEvent(long pk, long eventPK) {
		return manifestationToEventTableMapper.containsTableMapping(
			pk, eventPK);
	}

	/**
	 * Returns <code>true</code> if the manifestation has any events associated with it.
	 *
	 * @param pk the primary key of the manifestation to check for associations with events
	 * @return <code>true</code> if the manifestation has any events associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsEvents(long pk) {
		if (getEventsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 */
	@Override
	public void addEvent(long pk, long eventPK) {
		Manifestation manifestation = fetchByPrimaryKey(pk);

		if (manifestation == null) {
			manifestationToEventTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, eventPK);
		}
		else {
			manifestationToEventTableMapper.addTableMapping(
				manifestation.getCompanyId(), pk, eventPK);
		}
	}

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 */
	@Override
	public void addEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event) {

		Manifestation manifestation = fetchByPrimaryKey(pk);

		if (manifestation == null) {
			manifestationToEventTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, event.getPrimaryKey());
		}
		else {
			manifestationToEventTableMapper.addTableMapping(
				manifestation.getCompanyId(), pk, event.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 */
	@Override
	public void addEvents(long pk, long[] eventPKs) {
		long companyId = 0;

		Manifestation manifestation = fetchByPrimaryKey(pk);

		if (manifestation == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = manifestation.getCompanyId();
		}

		manifestationToEventTableMapper.addTableMappings(
			companyId, pk, eventPKs);
	}

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 */
	@Override
	public void addEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		addEvents(
			pk,
			ListUtil.toLongArray(
				events,
				eu.strasbourg.service.agenda.model.Event.EVENT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the manifestation and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation to clear the associated events from
	 */
	@Override
	public void clearEvents(long pk) {
		manifestationToEventTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 */
	@Override
	public void removeEvent(long pk, long eventPK) {
		manifestationToEventTableMapper.deleteTableMapping(pk, eventPK);
	}

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 */
	@Override
	public void removeEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event) {

		manifestationToEventTableMapper.deleteTableMapping(
			pk, event.getPrimaryKey());
	}

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 */
	@Override
	public void removeEvents(long pk, long[] eventPKs) {
		manifestationToEventTableMapper.deleteTableMappings(pk, eventPKs);
	}

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 */
	@Override
	public void removeEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		removeEvents(
			pk,
			ListUtil.toLongArray(
				events,
				eu.strasbourg.service.agenda.model.Event.EVENT_ID_ACCESSOR));
	}

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events to be associated with the manifestation
	 */
	@Override
	public void setEvents(long pk, long[] eventPKs) {
		Set<Long> newEventPKsSet = SetUtil.fromArray(eventPKs);
		Set<Long> oldEventPKsSet = SetUtil.fromArray(
			manifestationToEventTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removeEventPKsSet = new HashSet<Long>(oldEventPKsSet);

		removeEventPKsSet.removeAll(newEventPKsSet);

		manifestationToEventTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removeEventPKsSet));

		newEventPKsSet.removeAll(oldEventPKsSet);

		long companyId = 0;

		Manifestation manifestation = fetchByPrimaryKey(pk);

		if (manifestation == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = manifestation.getCompanyId();
		}

		manifestationToEventTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newEventPKsSet));
	}

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events to be associated with the manifestation
	 */
	@Override
	public void setEvents(
		long pk, List<eu.strasbourg.service.agenda.model.Event> events) {

		try {
			long[] eventPKs = new long[events.size()];

			for (int i = 0; i < events.size(); i++) {
				eu.strasbourg.service.agenda.model.Event event = events.get(i);

				eventPKs[i] = event.getPrimaryKey();
			}

			setEvents(pk, eventPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
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
		return "manifestationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MANIFESTATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ManifestationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the manifestation persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		manifestationToEventTableMapper = TableMapperFactory.getTableMapper(
			"agenda_EventToManifestation", "companyId", "manifestationId",
			"eventId", this, eventPersistence);

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

		_finderPathWithPaginationFindBytitle = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"title"}, true);

		_finderPathWithoutPaginationFindBytitle = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytitle",
			new String[] {String.class.getName()}, new String[] {"title"},
			true);

		_finderPathCountBytitle = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytitle",
			new String[] {String.class.getName()}, new String[] {"title"},
			false);

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

		_finderPathWithPaginationFindByPublicationDateAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPublicationDateAndStatus",
				new String[] {
					Date.class.getName(), Integer.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"publicationDate", "status"}, true);

		_finderPathWithPaginationCountByPublicationDateAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByPublicationDateAndStatus",
				new String[] {Date.class.getName(), Integer.class.getName()},
				new String[] {"publicationDate", "status"}, false);

		_finderPathWithPaginationFindByEndDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEndDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"endDate"}, true);

		_finderPathWithPaginationCountByEndDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByEndDate",
			new String[] {Date.class.getName()}, new String[] {"endDate"},
			false);

		_finderPathWithPaginationFindByStatusDateAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusDateAndStatus",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"statusDate", "status"}, true);

		_finderPathWithPaginationCountByStatusDateAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"countByStatusDateAndStatus",
			new String[] {Date.class.getName(), Integer.class.getName()},
			new String[] {"statusDate", "status"}, false);

		_finderPathFetchBySourceAndIdSource = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySourceAndIdSource",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"source", "idSource"}, true);

		_finderPathCountBySourceAndIdSource = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySourceAndIdSource",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"source", "idSource"}, false);

		_finderPathFetchByIdSource = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByIdSource",
			new String[] {String.class.getName()}, new String[] {"idSource"},
			true);

		_finderPathCountByIdSource = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdSource",
			new String[] {String.class.getName()}, new String[] {"idSource"},
			false);

		_setManifestationUtilPersistence(this);
	}

	public void destroy() {
		_setManifestationUtilPersistence(null);

		entityCache.removeCache(ManifestationImpl.class.getName());

		TableMapperFactory.removeTableMapper("agenda_EventToManifestation");
	}

	private void _setManifestationUtilPersistence(
		ManifestationPersistence manifestationPersistence) {

		try {
			Field field = ManifestationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, manifestationPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;

	protected TableMapper
		<Manifestation, eu.strasbourg.service.agenda.model.Event>
			manifestationToEventTableMapper;

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_MANIFESTATION =
		"SELECT manifestation FROM Manifestation manifestation";

	private static final String _SQL_SELECT_MANIFESTATION_WHERE =
		"SELECT manifestation FROM Manifestation manifestation WHERE ";

	private static final String _SQL_COUNT_MANIFESTATION =
		"SELECT COUNT(manifestation) FROM Manifestation manifestation";

	private static final String _SQL_COUNT_MANIFESTATION_WHERE =
		"SELECT COUNT(manifestation) FROM Manifestation manifestation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "manifestation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Manifestation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Manifestation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ManifestationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}