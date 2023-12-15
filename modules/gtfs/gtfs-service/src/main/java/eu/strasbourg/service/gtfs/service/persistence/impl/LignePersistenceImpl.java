/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.gtfs.exception.NoSuchLigneException;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.model.LigneTable;
import eu.strasbourg.service.gtfs.model.impl.LigneImpl;
import eu.strasbourg.service.gtfs.model.impl.LigneModelImpl;
import eu.strasbourg.service.gtfs.service.persistence.LignePersistence;
import eu.strasbourg.service.gtfs.service.persistence.LigneUtil;

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
 * The persistence implementation for the ligne service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class LignePersistenceImpl
	extends BasePersistenceImpl<Ligne> implements LignePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LigneUtil</code> to access the ligne persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LigneImpl.class.getName();

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
	 * Returns all the lignes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lignes
	 */
	@Override
	public List<Ligne> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ligne> orderByComparator, boolean useFinderCache) {

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

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ligne ligne : list) {
					if (!uuid.equals(ligne.getUuid())) {
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

			sb.append(_SQL_SELECT_LIGNE_WHERE);

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
				sb.append(LigneModelImpl.ORDER_BY_JPQL);
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

				list = (List<Ligne>)QueryUtil.list(
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
	 * Returns the first ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByUuid_First(
			String uuid, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByUuid_First(uuid, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUuid_First(
		String uuid, OrderByComparator<Ligne> orderByComparator) {

		List<Ligne> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByUuid_Last(
			String uuid, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByUuid_Last(uuid, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUuid_Last(
		String uuid, OrderByComparator<Ligne> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Ligne> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where uuid = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne[] findByUuid_PrevAndNext(
			long ligneId, String uuid,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		uuid = Objects.toString(uuid, "");

		Ligne ligne = findByPrimaryKey(ligneId);

		Session session = null;

		try {
			session = openSession();

			Ligne[] array = new LigneImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ligne, uuid, orderByComparator, true);

			array[1] = ligne;

			array[2] = getByUuid_PrevAndNext(
				session, ligne, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ligne getByUuid_PrevAndNext(
		Session session, Ligne ligne, String uuid,
		OrderByComparator<Ligne> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIGNE_WHERE);

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
			sb.append(LigneModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ligne)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ligne> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lignes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Ligne ligne :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lignes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "ligne.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ligne.uuid IS NULL OR ligne.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByUUID_G(String uuid, long groupId)
		throws NoSuchLigneException {

		Ligne ligne = fetchByUUID_G(uuid, groupId);

		if (ligne == null) {
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

			throw new NoSuchLigneException(sb.toString());
		}

		return ligne;
	}

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUUID_G(
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

		if (result instanceof Ligne) {
			Ligne ligne = (Ligne)result;

			if (!Objects.equals(uuid, ligne.getUuid()) ||
				(groupId != ligne.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_LIGNE_WHERE);

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

				List<Ligne> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Ligne ligne = list.get(0);

					result = ligne;

					cacheResult(ligne);
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
			return (Ligne)result;
		}
	}

	/**
	 * Removes the ligne where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ligne that was removed
	 */
	@Override
	public Ligne removeByUUID_G(String uuid, long groupId)
		throws NoSuchLigneException {

		Ligne ligne = findByUUID_G(uuid, groupId);

		return remove(ligne);
	}

	/**
	 * Returns the number of lignes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lignes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

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
		"ligne.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ligne.uuid IS NULL OR ligne.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ligne.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lignes
	 */
	@Override
	public List<Ligne> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ligne> orderByComparator, boolean useFinderCache) {

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

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ligne ligne : list) {
					if (!uuid.equals(ligne.getUuid()) ||
						(companyId != ligne.getCompanyId())) {

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

			sb.append(_SQL_SELECT_LIGNE_WHERE);

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
				sb.append(LigneModelImpl.ORDER_BY_JPQL);
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

				list = (List<Ligne>)QueryUtil.list(
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
	 * Returns the first ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Ligne> orderByComparator) {

		List<Ligne> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Ligne> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Ligne> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne[] findByUuid_C_PrevAndNext(
			long ligneId, String uuid, long companyId,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		uuid = Objects.toString(uuid, "");

		Ligne ligne = findByPrimaryKey(ligneId);

		Session session = null;

		try {
			session = openSession();

			Ligne[] array = new LigneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ligne, uuid, companyId, orderByComparator, true);

			array[1] = ligne;

			array[2] = getByUuid_C_PrevAndNext(
				session, ligne, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ligne getByUuid_C_PrevAndNext(
		Session session, Ligne ligne, String uuid, long companyId,
		OrderByComparator<Ligne> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LIGNE_WHERE);

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
			sb.append(LigneModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ligne)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ligne> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lignes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Ligne ligne :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lignes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

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
		"ligne.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ligne.uuid IS NULL OR ligne.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ligne.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the lignes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lignes
	 */
	@Override
	public List<Ligne> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	@Override
	public List<Ligne> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Ligne> orderByComparator, boolean useFinderCache) {

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

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ligne ligne : list) {
					if (groupId != ligne.getGroupId()) {
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

			sb.append(_SQL_SELECT_LIGNE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LigneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Ligne>)QueryUtil.list(
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
	 * Returns the first ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByGroupId_First(
			long groupId, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByGroupId_First(groupId, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the first ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByGroupId_First(
		long groupId, OrderByComparator<Ligne> orderByComparator) {

		List<Ligne> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByGroupId_Last(
			long groupId, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByGroupId_Last(groupId, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the last ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByGroupId_Last(
		long groupId, OrderByComparator<Ligne> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Ligne> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where groupId = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne[] findByGroupId_PrevAndNext(
			long ligneId, long groupId,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = findByPrimaryKey(ligneId);

		Session session = null;

		try {
			session = openSession();

			Ligne[] array = new LigneImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, ligne, groupId, orderByComparator, true);

			array[1] = ligne;

			array[2] = getByGroupId_PrevAndNext(
				session, ligne, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ligne getByGroupId_PrevAndNext(
		Session session, Ligne ligne, long groupId,
		OrderByComparator<Ligne> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIGNE_WHERE);

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
			sb.append(LigneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ligne)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ligne> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lignes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Ligne ligne :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lignes
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

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
		"ligne.groupId = ?";

	private FinderPath _finderPathFetchByRouteId;
	private FinderPath _finderPathCountByRouteId;

	/**
	 * Returns the ligne where routeId = &#63; or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param routeId the route ID
	 * @return the matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByRouteId(String routeId) throws NoSuchLigneException {
		Ligne ligne = fetchByRouteId(routeId);

		if (ligne == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("routeId=");
			sb.append(routeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLigneException(sb.toString());
		}

		return ligne;
	}

	/**
	 * Returns the ligne where routeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param routeId the route ID
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByRouteId(String routeId) {
		return fetchByRouteId(routeId, true);
	}

	/**
	 * Returns the ligne where routeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param routeId the route ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByRouteId(String routeId, boolean useFinderCache) {
		routeId = Objects.toString(routeId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {routeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByRouteId, finderArgs, this);
		}

		if (result instanceof Ligne) {
			Ligne ligne = (Ligne)result;

			if (!Objects.equals(routeId, ligne.getRouteId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LIGNE_WHERE);

			boolean bindRouteId = false;

			if (routeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROUTEID_ROUTEID_3);
			}
			else {
				bindRouteId = true;

				sb.append(_FINDER_COLUMN_ROUTEID_ROUTEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRouteId) {
					queryPos.add(routeId);
				}

				List<Ligne> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByRouteId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {routeId};
							}

							_log.warn(
								"LignePersistenceImpl.fetchByRouteId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Ligne ligne = list.get(0);

					result = ligne;

					cacheResult(ligne);
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
			return (Ligne)result;
		}
	}

	/**
	 * Removes the ligne where routeId = &#63; from the database.
	 *
	 * @param routeId the route ID
	 * @return the ligne that was removed
	 */
	@Override
	public Ligne removeByRouteId(String routeId) throws NoSuchLigneException {
		Ligne ligne = findByRouteId(routeId);

		return remove(ligne);
	}

	/**
	 * Returns the number of lignes where routeId = &#63;.
	 *
	 * @param routeId the route ID
	 * @return the number of matching lignes
	 */
	@Override
	public int countByRouteId(String routeId) {
		routeId = Objects.toString(routeId, "");

		FinderPath finderPath = _finderPathCountByRouteId;

		Object[] finderArgs = new Object[] {routeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

			boolean bindRouteId = false;

			if (routeId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ROUTEID_ROUTEID_3);
			}
			else {
				bindRouteId = true;

				sb.append(_FINDER_COLUMN_ROUTEID_ROUTEID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRouteId) {
					queryPos.add(routeId);
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

	private static final String _FINDER_COLUMN_ROUTEID_ROUTEID_2 =
		"ligne.routeId = ?";

	private static final String _FINDER_COLUMN_ROUTEID_ROUTEID_3 =
		"(ligne.routeId IS NULL OR ligne.routeId = '')";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the lignes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching lignes
	 */
	@Override
	public List<Ligne> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	@Override
	public List<Ligne> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByStatus(
		int status, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByStatus(
		int status, int start, int end,
		OrderByComparator<Ligne> orderByComparator, boolean useFinderCache) {

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

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ligne ligne : list) {
					if (status != ligne.getStatus()) {
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

			sb.append(_SQL_SELECT_LIGNE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LigneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Ligne>)QueryUtil.list(
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
	 * Returns the first ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByStatus_First(
			int status, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByStatus_First(status, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the first ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByStatus_First(
		int status, OrderByComparator<Ligne> orderByComparator) {

		List<Ligne> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByStatus_Last(
			int status, OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByStatus_Last(status, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the last ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByStatus_Last(
		int status, OrderByComparator<Ligne> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Ligne> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where status = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne[] findByStatus_PrevAndNext(
			long ligneId, int status,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = findByPrimaryKey(ligneId);

		Session session = null;

		try {
			session = openSession();

			Ligne[] array = new LigneImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ligne, status, orderByComparator, true);

			array[1] = ligne;

			array[2] = getByStatus_PrevAndNext(
				session, ligne, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ligne getByStatus_PrevAndNext(
		Session session, Ligne ligne, int status,
		OrderByComparator<Ligne> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIGNE_WHERE);

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
			sb.append(LigneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ligne)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ligne> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lignes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Ligne ligne :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching lignes
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

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
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"ligne.status = ?";

	private FinderPath _finderPathWithPaginationFindByShortNameAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByShortNameAndStatus;
	private FinderPath _finderPathCountByShortNameAndStatus;

	/**
	 * Returns all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @return the matching lignes
	 */
	@Override
	public List<Ligne> findByShortNameAndStatus(String shortName, int status) {
		return findByShortNameAndStatus(
			shortName, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	@Override
	public List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end) {

		return findByShortNameAndStatus(shortName, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return findByShortNameAndStatus(
			shortName, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	@Override
	public List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end,
		OrderByComparator<Ligne> orderByComparator, boolean useFinderCache) {

		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByShortNameAndStatus;
				finderArgs = new Object[] {shortName, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByShortNameAndStatus;
			finderArgs = new Object[] {
				shortName, status, start, end, orderByComparator
			};
		}

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ligne ligne : list) {
					if (!shortName.equals(ligne.getShortName()) ||
						(status != ligne.getStatus())) {

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

			sb.append(_SQL_SELECT_LIGNE_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_2);
			}

			sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LigneModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
				}

				queryPos.add(status);

				list = (List<Ligne>)QueryUtil.list(
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
	 * Returns the first ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByShortNameAndStatus_First(
			String shortName, int status,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByShortNameAndStatus_First(
			shortName, status, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the first ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByShortNameAndStatus_First(
		String shortName, int status,
		OrderByComparator<Ligne> orderByComparator) {

		List<Ligne> list = findByShortNameAndStatus(
			shortName, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	@Override
	public Ligne findByShortNameAndStatus_Last(
			String shortName, int status,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		Ligne ligne = fetchByShortNameAndStatus_Last(
			shortName, status, orderByComparator);

		if (ligne != null) {
			return ligne;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shortName=");
		sb.append(shortName);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchLigneException(sb.toString());
	}

	/**
	 * Returns the last ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	@Override
	public Ligne fetchByShortNameAndStatus_Last(
		String shortName, int status,
		OrderByComparator<Ligne> orderByComparator) {

		int count = countByShortNameAndStatus(shortName, status);

		if (count == 0) {
			return null;
		}

		List<Ligne> list = findByShortNameAndStatus(
			shortName, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne[] findByShortNameAndStatus_PrevAndNext(
			long ligneId, String shortName, int status,
			OrderByComparator<Ligne> orderByComparator)
		throws NoSuchLigneException {

		shortName = Objects.toString(shortName, "");

		Ligne ligne = findByPrimaryKey(ligneId);

		Session session = null;

		try {
			session = openSession();

			Ligne[] array = new LigneImpl[3];

			array[0] = getByShortNameAndStatus_PrevAndNext(
				session, ligne, shortName, status, orderByComparator, true);

			array[1] = ligne;

			array[2] = getByShortNameAndStatus_PrevAndNext(
				session, ligne, shortName, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ligne getByShortNameAndStatus_PrevAndNext(
		Session session, Ligne ligne, String shortName, int status,
		OrderByComparator<Ligne> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_LIGNE_WHERE);

		boolean bindShortName = false;

		if (shortName.isEmpty()) {
			sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_3);
		}
		else {
			bindShortName = true;

			sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_2);
		}

		sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_STATUS_2);

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
			sb.append(LigneModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindShortName) {
			queryPos.add(shortName);
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ligne)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ligne> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lignes where shortName = &#63; and status = &#63; from the database.
	 *
	 * @param shortName the short name
	 * @param status the status
	 */
	@Override
	public void removeByShortNameAndStatus(String shortName, int status) {
		for (Ligne ligne :
				findByShortNameAndStatus(
					shortName, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @return the number of matching lignes
	 */
	@Override
	public int countByShortNameAndStatus(String shortName, int status) {
		shortName = Objects.toString(shortName, "");

		FinderPath finderPath = _finderPathCountByShortNameAndStatus;

		Object[] finderArgs = new Object[] {shortName, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_LIGNE_WHERE);

			boolean bindShortName = false;

			if (shortName.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_3);
			}
			else {
				bindShortName = true;

				sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_2);
			}

			sb.append(_FINDER_COLUMN_SHORTNAMEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShortName) {
					queryPos.add(shortName);
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

	private static final String _FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_2 =
		"ligne.shortName = ? AND ";

	private static final String _FINDER_COLUMN_SHORTNAMEANDSTATUS_SHORTNAME_3 =
		"(ligne.shortName IS NULL OR ligne.shortName = '') AND ";

	private static final String _FINDER_COLUMN_SHORTNAMEANDSTATUS_STATUS_2 =
		"ligne.status = ?";

	public LignePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ligne.class);

		setModelImplClass(LigneImpl.class);
		setModelPKClass(long.class);

		setTable(LigneTable.INSTANCE);
	}

	/**
	 * Caches the ligne in the entity cache if it is enabled.
	 *
	 * @param ligne the ligne
	 */
	@Override
	public void cacheResult(Ligne ligne) {
		entityCache.putResult(LigneImpl.class, ligne.getPrimaryKey(), ligne);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ligne.getUuid(), ligne.getGroupId()}, ligne);

		finderCache.putResult(
			_finderPathFetchByRouteId, new Object[] {ligne.getRouteId()},
			ligne);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lignes in the entity cache if it is enabled.
	 *
	 * @param lignes the lignes
	 */
	@Override
	public void cacheResult(List<Ligne> lignes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lignes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ligne ligne : lignes) {
			if (entityCache.getResult(LigneImpl.class, ligne.getPrimaryKey()) ==
					null) {

				cacheResult(ligne);
			}
		}
	}

	/**
	 * Clears the cache for all lignes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LigneImpl.class);

		finderCache.clearCache(LigneImpl.class);
	}

	/**
	 * Clears the cache for the ligne.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ligne ligne) {
		entityCache.removeResult(LigneImpl.class, ligne);
	}

	@Override
	public void clearCache(List<Ligne> lignes) {
		for (Ligne ligne : lignes) {
			entityCache.removeResult(LigneImpl.class, ligne);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(LigneImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LigneImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(LigneModelImpl ligneModelImpl) {
		Object[] args = new Object[] {
			ligneModelImpl.getUuid(), ligneModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByUUID_G, args, ligneModelImpl);

		args = new Object[] {ligneModelImpl.getRouteId()};

		finderCache.putResult(_finderPathCountByRouteId, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByRouteId, args, ligneModelImpl);
	}

	/**
	 * Creates a new ligne with the primary key. Does not add the ligne to the database.
	 *
	 * @param ligneId the primary key for the new ligne
	 * @return the new ligne
	 */
	@Override
	public Ligne create(long ligneId) {
		Ligne ligne = new LigneImpl();

		ligne.setNew(true);
		ligne.setPrimaryKey(ligneId);

		String uuid = PortalUUIDUtil.generate();

		ligne.setUuid(uuid);

		ligne.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ligne;
	}

	/**
	 * Removes the ligne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne that was removed
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne remove(long ligneId) throws NoSuchLigneException {
		return remove((Serializable)ligneId);
	}

	/**
	 * Removes the ligne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ligne
	 * @return the ligne that was removed
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne remove(Serializable primaryKey) throws NoSuchLigneException {
		Session session = null;

		try {
			session = openSession();

			Ligne ligne = (Ligne)session.get(LigneImpl.class, primaryKey);

			if (ligne == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLigneException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ligne);
		}
		catch (NoSuchLigneException noSuchEntityException) {
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
	protected Ligne removeImpl(Ligne ligne) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ligne)) {
				ligne = (Ligne)session.get(
					LigneImpl.class, ligne.getPrimaryKeyObj());
			}

			if (ligne != null) {
				session.delete(ligne);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ligne != null) {
			clearCache(ligne);
		}

		return ligne;
	}

	@Override
	public Ligne updateImpl(Ligne ligne) {
		boolean isNew = ligne.isNew();

		if (!(ligne instanceof LigneModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ligne.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ligne);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ligne proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ligne implementation " +
					ligne.getClass());
		}

		LigneModelImpl ligneModelImpl = (LigneModelImpl)ligne;

		if (Validator.isNull(ligne.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ligne.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ligne.getCreateDate() == null)) {
			if (serviceContext == null) {
				ligne.setCreateDate(date);
			}
			else {
				ligne.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ligneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ligne.setModifiedDate(date);
			}
			else {
				ligne.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ligne);
			}
			else {
				ligne = (Ligne)session.merge(ligne);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LigneImpl.class, ligneModelImpl, false, true);

		cacheUniqueFindersCache(ligneModelImpl);

		if (isNew) {
			ligne.setNew(false);
		}

		ligne.resetOriginalValues();

		return ligne;
	}

	/**
	 * Returns the ligne with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ligne
	 * @return the ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLigneException {

		Ligne ligne = fetchByPrimaryKey(primaryKey);

		if (ligne == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLigneException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ligne;
	}

	/**
	 * Returns the ligne with the primary key or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne findByPrimaryKey(long ligneId) throws NoSuchLigneException {
		return findByPrimaryKey((Serializable)ligneId);
	}

	/**
	 * Returns the ligne with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne, or <code>null</code> if a ligne with the primary key could not be found
	 */
	@Override
	public Ligne fetchByPrimaryKey(long ligneId) {
		return fetchByPrimaryKey((Serializable)ligneId);
	}

	/**
	 * Returns all the lignes.
	 *
	 * @return the lignes
	 */
	@Override
	public List<Ligne> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of lignes
	 */
	@Override
	public List<Ligne> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lignes
	 */
	@Override
	public List<Ligne> findAll(
		int start, int end, OrderByComparator<Ligne> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lignes
	 */
	@Override
	public List<Ligne> findAll(
		int start, int end, OrderByComparator<Ligne> orderByComparator,
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

		List<Ligne> list = null;

		if (useFinderCache) {
			list = (List<Ligne>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LIGNE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LIGNE;

				sql = sql.concat(LigneModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ligne>)QueryUtil.list(
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
	 * Removes all the lignes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ligne ligne : findAll()) {
			remove(ligne);
		}
	}

	/**
	 * Returns the number of lignes.
	 *
	 * @return the number of lignes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LIGNE);

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
		return "ligneId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LIGNE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LigneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ligne persistence.
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

		_finderPathFetchByRouteId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByRouteId",
			new String[] {String.class.getName()}, new String[] {"routeId"},
			true);

		_finderPathCountByRouteId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRouteId",
			new String[] {String.class.getName()}, new String[] {"routeId"},
			false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByShortNameAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShortNameAndStatus",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"shortName", "status"}, true);

		_finderPathWithoutPaginationFindByShortNameAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByShortNameAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"shortName", "status"}, true);

		_finderPathCountByShortNameAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByShortNameAndStatus",
			new String[] {String.class.getName(), Integer.class.getName()},
			new String[] {"shortName", "status"}, false);

		LigneUtil.setPersistence(this);
	}

	public void destroy() {
		LigneUtil.setPersistence(null);

		entityCache.removeCache(LigneImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_LIGNE =
		"SELECT ligne FROM Ligne ligne";

	private static final String _SQL_SELECT_LIGNE_WHERE =
		"SELECT ligne FROM Ligne ligne WHERE ";

	private static final String _SQL_COUNT_LIGNE =
		"SELECT COUNT(ligne) FROM Ligne ligne";

	private static final String _SQL_COUNT_LIGNE_WHERE =
		"SELECT COUNT(ligne) FROM Ligne ligne WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ligne.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ligne exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ligne exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LignePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}