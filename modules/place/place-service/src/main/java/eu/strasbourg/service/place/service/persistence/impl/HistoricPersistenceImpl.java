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

package eu.strasbourg.service.place.service.persistence.impl;

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
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.place.exception.NoSuchHistoricException;
import eu.strasbourg.service.place.model.Historic;
import eu.strasbourg.service.place.model.HistoricTable;
import eu.strasbourg.service.place.model.impl.HistoricImpl;
import eu.strasbourg.service.place.model.impl.HistoricModelImpl;
import eu.strasbourg.service.place.service.persistence.HistoricPersistence;
import eu.strasbourg.service.place.service.persistence.HistoricUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the historic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class HistoricPersistenceImpl
	extends BasePersistenceImpl<Historic> implements HistoricPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HistoricUtil</code> to access the historic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HistoricImpl.class.getName();

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
	 * Returns all the historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching historics
	 */
	@Override
	public List<Historic> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	@Override
	public List<Historic> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	@Override
	public List<Historic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Historic> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	@Override
	public List<Historic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Historic> orderByComparator, boolean useFinderCache) {

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

		List<Historic> list = null;

		if (useFinderCache) {
			list = (List<Historic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Historic historic : list) {
					if (!uuid.equals(historic.getUuid())) {
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

			sb.append(_SQL_SELECT_HISTORIC_WHERE);

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
				sb.append(HistoricModelImpl.ORDER_BY_JPQL);
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

				list = (List<Historic>)QueryUtil.list(
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
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	@Override
	public Historic findByUuid_First(
			String uuid, OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		Historic historic = fetchByUuid_First(uuid, orderByComparator);

		if (historic != null) {
			return historic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHistoricException(sb.toString());
	}

	/**
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	@Override
	public Historic fetchByUuid_First(
		String uuid, OrderByComparator<Historic> orderByComparator) {

		List<Historic> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	@Override
	public Historic findByUuid_Last(
			String uuid, OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		Historic historic = fetchByUuid_Last(uuid, orderByComparator);

		if (historic != null) {
			return historic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHistoricException(sb.toString());
	}

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	@Override
	public Historic fetchByUuid_Last(
		String uuid, OrderByComparator<Historic> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Historic> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the historics before and after the current historic in the ordered set where uuid = &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic[] findByUuid_PrevAndNext(
			String sigId, String uuid,
			OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		uuid = Objects.toString(uuid, "");

		Historic historic = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			Historic[] array = new HistoricImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, historic, uuid, orderByComparator, true);

			array[1] = historic;

			array[2] = getByUuid_PrevAndNext(
				session, historic, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Historic getByUuid_PrevAndNext(
		Session session, Historic historic, String uuid,
		OrderByComparator<Historic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HISTORIC_WHERE);

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
			sb.append(HistoricModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(historic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Historic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the historics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Historic historic :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(historic);
		}
	}

	/**
	 * Returns the number of historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching historics
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HISTORIC_WHERE);

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
		"historic.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(historic.uuid IS NULL OR historic.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBySuppressionDate;
	private FinderPath _finderPathWithPaginationCountBySuppressionDate;

	/**
	 * Returns all the historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the matching historics
	 */
	@Override
	public List<Historic> findBySuppressionDate(Date suppressionDate) {
		return findBySuppressionDate(
			suppressionDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	@Override
	public List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end) {

		return findBySuppressionDate(suppressionDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	@Override
	public List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		OrderByComparator<Historic> orderByComparator) {

		return findBySuppressionDate(
			suppressionDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	@Override
	public List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		OrderByComparator<Historic> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindBySuppressionDate;
		finderArgs = new Object[] {
			_getTime(suppressionDate), start, end, orderByComparator
		};

		List<Historic> list = null;

		if (useFinderCache) {
			list = (List<Historic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Historic historic : list) {
					if (suppressionDate.getTime() > historic.getSuppressionDate(
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

			sb.append(_SQL_SELECT_HISTORIC_WHERE);

			boolean bindSuppressionDate = false;

			if (suppressionDate == null) {
				sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_1);
			}
			else {
				bindSuppressionDate = true;

				sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HistoricModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSuppressionDate) {
					queryPos.add(new Timestamp(suppressionDate.getTime()));
				}

				list = (List<Historic>)QueryUtil.list(
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
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	@Override
	public Historic findBySuppressionDate_First(
			Date suppressionDate, OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		Historic historic = fetchBySuppressionDate_First(
			suppressionDate, orderByComparator);

		if (historic != null) {
			return historic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("suppressionDate>=");
		sb.append(suppressionDate);

		sb.append("}");

		throw new NoSuchHistoricException(sb.toString());
	}

	/**
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	@Override
	public Historic fetchBySuppressionDate_First(
		Date suppressionDate, OrderByComparator<Historic> orderByComparator) {

		List<Historic> list = findBySuppressionDate(
			suppressionDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	@Override
	public Historic findBySuppressionDate_Last(
			Date suppressionDate, OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		Historic historic = fetchBySuppressionDate_Last(
			suppressionDate, orderByComparator);

		if (historic != null) {
			return historic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("suppressionDate>=");
		sb.append(suppressionDate);

		sb.append("}");

		throw new NoSuchHistoricException(sb.toString());
	}

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	@Override
	public Historic fetchBySuppressionDate_Last(
		Date suppressionDate, OrderByComparator<Historic> orderByComparator) {

		int count = countBySuppressionDate(suppressionDate);

		if (count == 0) {
			return null;
		}

		List<Historic> list = findBySuppressionDate(
			suppressionDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the historics before and after the current historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic[] findBySuppressionDate_PrevAndNext(
			String sigId, Date suppressionDate,
			OrderByComparator<Historic> orderByComparator)
		throws NoSuchHistoricException {

		Historic historic = findByPrimaryKey(sigId);

		Session session = null;

		try {
			session = openSession();

			Historic[] array = new HistoricImpl[3];

			array[0] = getBySuppressionDate_PrevAndNext(
				session, historic, suppressionDate, orderByComparator, true);

			array[1] = historic;

			array[2] = getBySuppressionDate_PrevAndNext(
				session, historic, suppressionDate, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Historic getBySuppressionDate_PrevAndNext(
		Session session, Historic historic, Date suppressionDate,
		OrderByComparator<Historic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HISTORIC_WHERE);

		boolean bindSuppressionDate = false;

		if (suppressionDate == null) {
			sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_1);
		}
		else {
			bindSuppressionDate = true;

			sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_2);
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
			sb.append(HistoricModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindSuppressionDate) {
			queryPos.add(new Timestamp(suppressionDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(historic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Historic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the historics where suppressionDate &ge; &#63; from the database.
	 *
	 * @param suppressionDate the suppression date
	 */
	@Override
	public void removeBySuppressionDate(Date suppressionDate) {
		for (Historic historic :
				findBySuppressionDate(
					suppressionDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(historic);
		}
	}

	/**
	 * Returns the number of historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the number of matching historics
	 */
	@Override
	public int countBySuppressionDate(Date suppressionDate) {
		FinderPath finderPath = _finderPathWithPaginationCountBySuppressionDate;

		Object[] finderArgs = new Object[] {_getTime(suppressionDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HISTORIC_WHERE);

			boolean bindSuppressionDate = false;

			if (suppressionDate == null) {
				sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_1);
			}
			else {
				bindSuppressionDate = true;

				sb.append(_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSuppressionDate) {
					queryPos.add(new Timestamp(suppressionDate.getTime()));
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

	private static final String
		_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_1 =
			"historic.suppressionDate IS NULL";

	private static final String
		_FINDER_COLUMN_SUPPRESSIONDATE_SUPPRESSIONDATE_2 =
			"historic.suppressionDate >= ?";

	public HistoricPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Historic.class);

		setModelImplClass(HistoricImpl.class);
		setModelPKClass(String.class);

		setTable(HistoricTable.INSTANCE);
	}

	/**
	 * Caches the historic in the entity cache if it is enabled.
	 *
	 * @param historic the historic
	 */
	@Override
	public void cacheResult(Historic historic) {
		entityCache.putResult(
			HistoricImpl.class, historic.getPrimaryKey(), historic);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the historics in the entity cache if it is enabled.
	 *
	 * @param historics the historics
	 */
	@Override
	public void cacheResult(List<Historic> historics) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (historics.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Historic historic : historics) {
			if (entityCache.getResult(
					HistoricImpl.class, historic.getPrimaryKey()) == null) {

				cacheResult(historic);
			}
		}
	}

	/**
	 * Clears the cache for all historics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HistoricImpl.class);

		finderCache.clearCache(HistoricImpl.class);
	}

	/**
	 * Clears the cache for the historic.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Historic historic) {
		entityCache.removeResult(HistoricImpl.class, historic);
	}

	@Override
	public void clearCache(List<Historic> historics) {
		for (Historic historic : historics) {
			entityCache.removeResult(HistoricImpl.class, historic);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(HistoricImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HistoricImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new historic with the primary key. Does not add the historic to the database.
	 *
	 * @param sigId the primary key for the new historic
	 * @return the new historic
	 */
	@Override
	public Historic create(String sigId) {
		Historic historic = new HistoricImpl();

		historic.setNew(true);
		historic.setPrimaryKey(sigId);

		String uuid = _portalUUID.generate();

		historic.setUuid(uuid);

		return historic;
	}

	/**
	 * Removes the historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic that was removed
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic remove(String sigId) throws NoSuchHistoricException {
		return remove((Serializable)sigId);
	}

	/**
	 * Removes the historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the historic
	 * @return the historic that was removed
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic remove(Serializable primaryKey)
		throws NoSuchHistoricException {

		Session session = null;

		try {
			session = openSession();

			Historic historic = (Historic)session.get(
				HistoricImpl.class, primaryKey);

			if (historic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHistoricException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(historic);
		}
		catch (NoSuchHistoricException noSuchEntityException) {
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
	protected Historic removeImpl(Historic historic) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(historic)) {
				historic = (Historic)session.get(
					HistoricImpl.class, historic.getPrimaryKeyObj());
			}

			if (historic != null) {
				session.delete(historic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (historic != null) {
			clearCache(historic);
		}

		return historic;
	}

	@Override
	public Historic updateImpl(Historic historic) {
		boolean isNew = historic.isNew();

		if (!(historic instanceof HistoricModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(historic.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(historic);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in historic proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Historic implementation " +
					historic.getClass());
		}

		HistoricModelImpl historicModelImpl = (HistoricModelImpl)historic;

		if (Validator.isNull(historic.getUuid())) {
			String uuid = _portalUUID.generate();

			historic.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(historic);
			}
			else {
				historic = (Historic)session.merge(historic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HistoricImpl.class, historicModelImpl, false, true);

		if (isNew) {
			historic.setNew(false);
		}

		historic.resetOriginalValues();

		return historic;
	}

	/**
	 * Returns the historic with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the historic
	 * @return the historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHistoricException {

		Historic historic = fetchByPrimaryKey(primaryKey);

		if (historic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHistoricException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return historic;
	}

	/**
	 * Returns the historic with the primary key or throws a <code>NoSuchHistoricException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	@Override
	public Historic findByPrimaryKey(String sigId)
		throws NoSuchHistoricException {

		return findByPrimaryKey((Serializable)sigId);
	}

	/**
	 * Returns the historic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic, or <code>null</code> if a historic with the primary key could not be found
	 */
	@Override
	public Historic fetchByPrimaryKey(String sigId) {
		return fetchByPrimaryKey((Serializable)sigId);
	}

	/**
	 * Returns all the historics.
	 *
	 * @return the historics
	 */
	@Override
	public List<Historic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of historics
	 */
	@Override
	public List<Historic> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of historics
	 */
	@Override
	public List<Historic> findAll(
		int start, int end, OrderByComparator<Historic> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of historics
	 */
	@Override
	public List<Historic> findAll(
		int start, int end, OrderByComparator<Historic> orderByComparator,
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

		List<Historic> list = null;

		if (useFinderCache) {
			list = (List<Historic>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HISTORIC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HISTORIC;

				sql = sql.concat(HistoricModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Historic>)QueryUtil.list(
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
	 * Removes all the historics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Historic historic : findAll()) {
			remove(historic);
		}
	}

	/**
	 * Returns the number of historics.
	 *
	 * @return the number of historics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HISTORIC);

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
		return "sigId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HISTORIC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HistoricModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the historic persistence.
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

		_finderPathWithPaginationFindBySuppressionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySuppressionDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"suppressionDate"}, true);

		_finderPathWithPaginationCountBySuppressionDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countBySuppressionDate",
			new String[] {Date.class.getName()},
			new String[] {"suppressionDate"}, false);

		_setHistoricUtilPersistence(this);
	}

	public void destroy() {
		_setHistoricUtilPersistence(null);

		entityCache.removeCache(HistoricImpl.class.getName());
	}

	private void _setHistoricUtilPersistence(
		HistoricPersistence historicPersistence) {

		try {
			Field field = HistoricUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, historicPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
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

	private static final String _SQL_SELECT_HISTORIC =
		"SELECT historic FROM Historic historic";

	private static final String _SQL_SELECT_HISTORIC_WHERE =
		"SELECT historic FROM Historic historic WHERE ";

	private static final String _SQL_COUNT_HISTORIC =
		"SELECT COUNT(historic) FROM Historic historic";

	private static final String _SQL_COUNT_HISTORIC_WHERE =
		"SELECT COUNT(historic) FROM Historic historic WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "historic.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Historic exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Historic exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HistoricPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}