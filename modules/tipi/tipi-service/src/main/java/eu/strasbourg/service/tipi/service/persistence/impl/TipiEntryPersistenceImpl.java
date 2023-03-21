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

package eu.strasbourg.service.tipi.service.persistence.impl;

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
import eu.strasbourg.service.tipi.exception.NoSuchTipiEntryException;
import eu.strasbourg.service.tipi.model.TipiEntry;
import eu.strasbourg.service.tipi.model.TipiEntryTable;
import eu.strasbourg.service.tipi.model.impl.TipiEntryImpl;
import eu.strasbourg.service.tipi.model.impl.TipiEntryModelImpl;
import eu.strasbourg.service.tipi.service.persistence.TipiEntryPersistence;
import eu.strasbourg.service.tipi.service.persistence.TipiEntryUtil;

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
 * The persistence implementation for the tipi entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class TipiEntryPersistenceImpl
	extends BasePersistenceImpl<TipiEntry> implements TipiEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TipiEntryUtil</code> to access the tipi entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TipiEntryImpl.class.getName();

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
	 * Returns all the tipi entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipi entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @return the range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipi entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipiEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipi entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TipiEntry> orderByComparator,
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

		List<TipiEntry> list = null;

		if (useFinderCache) {
			list = (List<TipiEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipiEntry tipiEntry : list) {
					if (!uuid.equals(tipiEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_TIPIENTRY_WHERE);

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
				sb.append(TipiEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TipiEntry>)QueryUtil.list(
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
	 * Returns the first tipi entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipi entry
	 * @throws NoSuchTipiEntryException if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry findByUuid_First(
			String uuid, OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = fetchByUuid_First(uuid, orderByComparator);

		if (tipiEntry != null) {
			return tipiEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipiEntryException(sb.toString());
	}

	/**
	 * Returns the first tipi entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipi entry, or <code>null</code> if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry fetchByUuid_First(
		String uuid, OrderByComparator<TipiEntry> orderByComparator) {

		List<TipiEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipi entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipi entry
	 * @throws NoSuchTipiEntryException if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry findByUuid_Last(
			String uuid, OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = fetchByUuid_Last(uuid, orderByComparator);

		if (tipiEntry != null) {
			return tipiEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTipiEntryException(sb.toString());
	}

	/**
	 * Returns the last tipi entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipi entry, or <code>null</code> if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry fetchByUuid_Last(
		String uuid, OrderByComparator<TipiEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TipiEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipi entries before and after the current tipi entry in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current tipi entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipi entry
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		uuid = Objects.toString(uuid, "");

		TipiEntry tipiEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TipiEntry[] array = new TipiEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, tipiEntry, uuid, orderByComparator, true);

			array[1] = tipiEntry;

			array[2] = getByUuid_PrevAndNext(
				session, tipiEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipiEntry getByUuid_PrevAndNext(
		Session session, TipiEntry tipiEntry, String uuid,
		OrderByComparator<TipiEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPIENTRY_WHERE);

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
			sb.append(TipiEntryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(tipiEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipiEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipi entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TipiEntry tipiEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipiEntry);
		}
	}

	/**
	 * Returns the number of tipi entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching tipi entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPIENTRY_WHERE);

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
		"tipiEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(tipiEntry.uuid IS NULL OR tipiEntry.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByDate;
	private FinderPath _finderPathWithoutPaginationFindByDate;
	private FinderPath _finderPathCountByDate;

	/**
	 * Returns all the tipi entries where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByDate(Date date) {
		return findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipi entries where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @return the range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByDate(Date date, int start, int end) {
		return findByDate(date, start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipi entries where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByDate(
		Date date, int start, int end,
		OrderByComparator<TipiEntry> orderByComparator) {

		return findByDate(date, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipi entries where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching tipi entries
	 */
	@Override
	public List<TipiEntry> findByDate(
		Date date, int start, int end,
		OrderByComparator<TipiEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDate;
				finderArgs = new Object[] {_getTime(date)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDate;
			finderArgs = new Object[] {
				_getTime(date), start, end, orderByComparator
			};
		}

		List<TipiEntry> list = null;

		if (useFinderCache) {
			list = (List<TipiEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TipiEntry tipiEntry : list) {
					if (!Objects.equals(date, tipiEntry.getDate())) {
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

			sb.append(_SQL_SELECT_TIPIENTRY_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TipiEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
				}

				list = (List<TipiEntry>)QueryUtil.list(
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
	 * Returns the first tipi entry in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipi entry
	 * @throws NoSuchTipiEntryException if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry findByDate_First(
			Date date, OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = fetchByDate_First(date, orderByComparator);

		if (tipiEntry != null) {
			return tipiEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchTipiEntryException(sb.toString());
	}

	/**
	 * Returns the first tipi entry in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching tipi entry, or <code>null</code> if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry fetchByDate_First(
		Date date, OrderByComparator<TipiEntry> orderByComparator) {

		List<TipiEntry> list = findByDate(date, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last tipi entry in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipi entry
	 * @throws NoSuchTipiEntryException if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry findByDate_Last(
			Date date, OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = fetchByDate_Last(date, orderByComparator);

		if (tipiEntry != null) {
			return tipiEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("date=");
		sb.append(date);

		sb.append("}");

		throw new NoSuchTipiEntryException(sb.toString());
	}

	/**
	 * Returns the last tipi entry in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching tipi entry, or <code>null</code> if a matching tipi entry could not be found
	 */
	@Override
	public TipiEntry fetchByDate_Last(
		Date date, OrderByComparator<TipiEntry> orderByComparator) {

		int count = countByDate(date);

		if (count == 0) {
			return null;
		}

		List<TipiEntry> list = findByDate(
			date, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the tipi entries before and after the current tipi entry in the ordered set where date = &#63;.
	 *
	 * @param id the primary key of the current tipi entry
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next tipi entry
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry[] findByDate_PrevAndNext(
			long id, Date date, OrderByComparator<TipiEntry> orderByComparator)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			TipiEntry[] array = new TipiEntryImpl[3];

			array[0] = getByDate_PrevAndNext(
				session, tipiEntry, date, orderByComparator, true);

			array[1] = tipiEntry;

			array[2] = getByDate_PrevAndNext(
				session, tipiEntry, date, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TipiEntry getByDate_PrevAndNext(
		Session session, TipiEntry tipiEntry, Date date,
		OrderByComparator<TipiEntry> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TIPIENTRY_WHERE);

		boolean bindDate = false;

		if (date == null) {
			sb.append(_FINDER_COLUMN_DATE_DATE_1);
		}
		else {
			bindDate = true;

			sb.append(_FINDER_COLUMN_DATE_DATE_2);
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
			sb.append(TipiEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDate) {
			queryPos.add(new Timestamp(date.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(tipiEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TipiEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the tipi entries where date = &#63; from the database.
	 *
	 * @param date the date
	 */
	@Override
	public void removeByDate(Date date) {
		for (TipiEntry tipiEntry :
				findByDate(date, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(tipiEntry);
		}
	}

	/**
	 * Returns the number of tipi entries where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching tipi entries
	 */
	@Override
	public int countByDate(Date date) {
		FinderPath finderPath = _finderPathCountByDate;

		Object[] finderArgs = new Object[] {_getTime(date)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TIPIENTRY_WHERE);

			boolean bindDate = false;

			if (date == null) {
				sb.append(_FINDER_COLUMN_DATE_DATE_1);
			}
			else {
				bindDate = true;

				sb.append(_FINDER_COLUMN_DATE_DATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDate) {
					queryPos.add(new Timestamp(date.getTime()));
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

	private static final String _FINDER_COLUMN_DATE_DATE_1 =
		"tipiEntry.date IS NULL";

	private static final String _FINDER_COLUMN_DATE_DATE_2 =
		"tipiEntry.date = ?";

	public TipiEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");
		dbColumnNames.put("date", "date_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TipiEntry.class);

		setModelImplClass(TipiEntryImpl.class);
		setModelPKClass(long.class);

		setTable(TipiEntryTable.INSTANCE);
	}

	/**
	 * Caches the tipi entry in the entity cache if it is enabled.
	 *
	 * @param tipiEntry the tipi entry
	 */
	@Override
	public void cacheResult(TipiEntry tipiEntry) {
		entityCache.putResult(
			TipiEntryImpl.class, tipiEntry.getPrimaryKey(), tipiEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the tipi entries in the entity cache if it is enabled.
	 *
	 * @param tipiEntries the tipi entries
	 */
	@Override
	public void cacheResult(List<TipiEntry> tipiEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (tipiEntries.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TipiEntry tipiEntry : tipiEntries) {
			if (entityCache.getResult(
					TipiEntryImpl.class, tipiEntry.getPrimaryKey()) == null) {

				cacheResult(tipiEntry);
			}
		}
	}

	/**
	 * Clears the cache for all tipi entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TipiEntryImpl.class);

		finderCache.clearCache(TipiEntryImpl.class);
	}

	/**
	 * Clears the cache for the tipi entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TipiEntry tipiEntry) {
		entityCache.removeResult(TipiEntryImpl.class, tipiEntry);
	}

	@Override
	public void clearCache(List<TipiEntry> tipiEntries) {
		for (TipiEntry tipiEntry : tipiEntries) {
			entityCache.removeResult(TipiEntryImpl.class, tipiEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TipiEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TipiEntryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new tipi entry with the primary key. Does not add the tipi entry to the database.
	 *
	 * @param id the primary key for the new tipi entry
	 * @return the new tipi entry
	 */
	@Override
	public TipiEntry create(long id) {
		TipiEntry tipiEntry = new TipiEntryImpl();

		tipiEntry.setNew(true);
		tipiEntry.setPrimaryKey(id);

		String uuid = _portalUUID.generate();

		tipiEntry.setUuid(uuid);

		return tipiEntry;
	}

	/**
	 * Removes the tipi entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the tipi entry
	 * @return the tipi entry that was removed
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry remove(long id) throws NoSuchTipiEntryException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the tipi entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the tipi entry
	 * @return the tipi entry that was removed
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry remove(Serializable primaryKey)
		throws NoSuchTipiEntryException {

		Session session = null;

		try {
			session = openSession();

			TipiEntry tipiEntry = (TipiEntry)session.get(
				TipiEntryImpl.class, primaryKey);

			if (tipiEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTipiEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(tipiEntry);
		}
		catch (NoSuchTipiEntryException noSuchEntityException) {
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
	protected TipiEntry removeImpl(TipiEntry tipiEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(tipiEntry)) {
				tipiEntry = (TipiEntry)session.get(
					TipiEntryImpl.class, tipiEntry.getPrimaryKeyObj());
			}

			if (tipiEntry != null) {
				session.delete(tipiEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (tipiEntry != null) {
			clearCache(tipiEntry);
		}

		return tipiEntry;
	}

	@Override
	public TipiEntry updateImpl(TipiEntry tipiEntry) {
		boolean isNew = tipiEntry.isNew();

		if (!(tipiEntry instanceof TipiEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(tipiEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(tipiEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in tipiEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TipiEntry implementation " +
					tipiEntry.getClass());
		}

		TipiEntryModelImpl tipiEntryModelImpl = (TipiEntryModelImpl)tipiEntry;

		if (Validator.isNull(tipiEntry.getUuid())) {
			String uuid = _portalUUID.generate();

			tipiEntry.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(tipiEntry);
			}
			else {
				tipiEntry = (TipiEntry)session.merge(tipiEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TipiEntryImpl.class, tipiEntryModelImpl, false, true);

		if (isNew) {
			tipiEntry.setNew(false);
		}

		tipiEntry.resetOriginalValues();

		return tipiEntry;
	}

	/**
	 * Returns the tipi entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the tipi entry
	 * @return the tipi entry
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTipiEntryException {

		TipiEntry tipiEntry = fetchByPrimaryKey(primaryKey);

		if (tipiEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTipiEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return tipiEntry;
	}

	/**
	 * Returns the tipi entry with the primary key or throws a <code>NoSuchTipiEntryException</code> if it could not be found.
	 *
	 * @param id the primary key of the tipi entry
	 * @return the tipi entry
	 * @throws NoSuchTipiEntryException if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry findByPrimaryKey(long id) throws NoSuchTipiEntryException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the tipi entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the tipi entry
	 * @return the tipi entry, or <code>null</code> if a tipi entry with the primary key could not be found
	 */
	@Override
	public TipiEntry fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the tipi entries.
	 *
	 * @return the tipi entries
	 */
	@Override
	public List<TipiEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the tipi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @return the range of tipi entries
	 */
	@Override
	public List<TipiEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the tipi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of tipi entries
	 */
	@Override
	public List<TipiEntry> findAll(
		int start, int end, OrderByComparator<TipiEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the tipi entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TipiEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of tipi entries
	 * @param end the upper bound of the range of tipi entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of tipi entries
	 */
	@Override
	public List<TipiEntry> findAll(
		int start, int end, OrderByComparator<TipiEntry> orderByComparator,
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

		List<TipiEntry> list = null;

		if (useFinderCache) {
			list = (List<TipiEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TIPIENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TIPIENTRY;

				sql = sql.concat(TipiEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TipiEntry>)QueryUtil.list(
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
	 * Removes all the tipi entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TipiEntry tipiEntry : findAll()) {
			remove(tipiEntry);
		}
	}

	/**
	 * Returns the number of tipi entries.
	 *
	 * @return the number of tipi entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TIPIENTRY);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TIPIENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TipiEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the tipi entry persistence.
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

		_finderPathWithPaginationFindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"date_"}, true);

		_finderPathWithoutPaginationFindByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDate",
			new String[] {Date.class.getName()}, new String[] {"date_"}, true);

		_finderPathCountByDate = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDate",
			new String[] {Date.class.getName()}, new String[] {"date_"}, false);

		_setTipiEntryUtilPersistence(this);
	}

	public void destroy() {
		_setTipiEntryUtilPersistence(null);

		entityCache.removeCache(TipiEntryImpl.class.getName());
	}

	private void _setTipiEntryUtilPersistence(
		TipiEntryPersistence tipiEntryPersistence) {

		try {
			Field field = TipiEntryUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, tipiEntryPersistence);
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

	private static final String _SQL_SELECT_TIPIENTRY =
		"SELECT tipiEntry FROM TipiEntry tipiEntry";

	private static final String _SQL_SELECT_TIPIENTRY_WHERE =
		"SELECT tipiEntry FROM TipiEntry tipiEntry WHERE ";

	private static final String _SQL_COUNT_TIPIENTRY =
		"SELECT COUNT(tipiEntry) FROM TipiEntry tipiEntry";

	private static final String _SQL_COUNT_TIPIENTRY_WHERE =
		"SELECT COUNT(tipiEntry) FROM TipiEntry tipiEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "tipiEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TipiEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TipiEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TipiEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id", "date", "type"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}