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

package eu.strasbourg.service.council.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.council.exception.NoSuchOfficialException;
import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.model.impl.OfficialImpl;
import eu.strasbourg.service.council.model.impl.OfficialModelImpl;
import eu.strasbourg.service.council.service.persistence.OfficialPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the official service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialPersistence
 * @see eu.strasbourg.service.council.service.persistence.OfficialUtil
 * @generated
 */
@ProviderType
public class OfficialPersistenceImpl extends BasePersistenceImpl<Official>
	implements OfficialPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OfficialUtil} to access the official persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OfficialImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			OfficialModelImpl.UUID_COLUMN_BITMASK |
			OfficialModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the officials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching officials
	 */
	@Override
	public List<Official> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of matching officials
	 */
	@Override
	public List<Official> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByUuid(String uuid, int start, int end,
		OrderByComparator<Official> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByUuid(String uuid, int start, int end,
		OrderByComparator<Official> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Official official : list) {
					if (!Objects.equals(uuid, official.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first official in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByUuid_First(String uuid,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByUuid_First(uuid, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the first official in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUuid_First(String uuid,
		OrderByComparator<Official> orderByComparator) {
		List<Official> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last official in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByUuid_Last(String uuid,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByUuid_Last(uuid, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the last official in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUuid_Last(String uuid,
		OrderByComparator<Official> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Official> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the officials before and after the current official in the ordered set where uuid = &#63;.
	 *
	 * @param officialId the primary key of the current official
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official[] findByUuid_PrevAndNext(long officialId, String uuid,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = findByPrimaryKey(officialId);

		Session session = null;

		try {
			session = openSession();

			Official[] array = new OfficialImpl[3];

			array[0] = getByUuid_PrevAndNext(session, official, uuid,
					orderByComparator, true);

			array[1] = official;

			array[2] = getByUuid_PrevAndNext(session, official, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Official getByUuid_PrevAndNext(Session session,
		Official official, String uuid,
		OrderByComparator<Official> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OFFICIAL_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OfficialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(official);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Official> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the officials where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Official official : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching officials
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "official.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "official.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(official.uuid IS NULL OR official.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			OfficialModelImpl.UUID_COLUMN_BITMASK |
			OfficialModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the official where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchOfficialException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByUUID_G(String uuid, long groupId)
		throws NoSuchOfficialException {
		Official official = fetchByUUID_G(uuid, groupId);

		if (official == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchOfficialException(msg.toString());
		}

		return official;
	}

	/**
	 * Returns the official where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the official where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Official) {
			Official official = (Official)result;

			if (!Objects.equals(uuid, official.getUuid()) ||
					(groupId != official.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Official> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Official official = list.get(0);

					result = official;

					cacheResult(official);

					if ((official.getUuid() == null) ||
							!official.getUuid().equals(uuid) ||
							(official.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, official);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Official)result;
		}
	}

	/**
	 * Removes the official where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the official that was removed
	 */
	@Override
	public Official removeByUUID_G(String uuid, long groupId)
		throws NoSuchOfficialException {
		Official official = findByUUID_G(uuid, groupId);

		return remove(official);
	}

	/**
	 * Returns the number of officials where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching officials
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "official.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "official.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(official.uuid IS NULL OR official.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "official.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			OfficialModelImpl.UUID_COLUMN_BITMASK |
			OfficialModelImpl.COMPANYID_COLUMN_BITMASK |
			OfficialModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the officials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching officials
	 */
	@Override
	public List<Official> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of matching officials
	 */
	@Override
	public List<Official> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Official> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Official> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Official official : list) {
					if (!Objects.equals(uuid, official.getUuid()) ||
							(companyId != official.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first official in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the first official in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Official> orderByComparator) {
		List<Official> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last official in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the last official in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Official> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Official> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the officials before and after the current official in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param officialId the primary key of the current official
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official[] findByUuid_C_PrevAndNext(long officialId, String uuid,
		long companyId, OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = findByPrimaryKey(officialId);

		Session session = null;

		try {
			session = openSession();

			Official[] array = new OfficialImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, official, uuid,
					companyId, orderByComparator, true);

			array[1] = official;

			array[2] = getByUuid_C_PrevAndNext(session, official, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Official getByUuid_C_PrevAndNext(Session session,
		Official official, String uuid, long companyId,
		OrderByComparator<Official> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_OFFICIAL_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OfficialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(official);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Official> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the officials where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Official official : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching officials
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "official.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "official.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(official.uuid IS NULL OR official.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "official.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAIL = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmail",
			new String[] { String.class.getName() },
			OfficialModelImpl.EMAIL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
			new String[] { String.class.getName() });

	/**
	 * Returns the official where email = &#63; or throws a {@link NoSuchOfficialException} if it could not be found.
	 *
	 * @param email the email
	 * @return the matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByEmail(String email) throws NoSuchOfficialException {
		Official official = fetchByEmail(email);

		if (official == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("email=");
			msg.append(email);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchOfficialException(msg.toString());
		}

		return official;
	}

	/**
	 * Returns the official where email = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param email the email
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByEmail(String email) {
		return fetchByEmail(email, true);
	}

	/**
	 * Returns the official where email = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param email the email
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByEmail(String email, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { email };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_EMAIL,
					finderArgs, this);
		}

		if (result instanceof Official) {
			Official official = (Official)result;

			if (!Objects.equals(email, official.getEmail())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				List<Official> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"OfficialPersistenceImpl.fetchByEmail(String, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Official official = list.get(0);

					result = official;

					cacheResult(official);

					if ((official.getEmail() == null) ||
							!official.getEmail().equals(email)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
							finderArgs, official);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Official)result;
		}
	}

	/**
	 * Removes the official where email = &#63; from the database.
	 *
	 * @param email the email
	 * @return the official that was removed
	 */
	@Override
	public Official removeByEmail(String email) throws NoSuchOfficialException {
		Official official = findByEmail(email);

		return remove(official);
	}

	/**
	 * Returns the number of officials where email = &#63;.
	 *
	 * @param email the email
	 * @return the number of matching officials
	 */
	@Override
	public int countByEmail(String email) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAIL;

		Object[] finderArgs = new Object[] { email };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			boolean bindEmail = false;

			if (email == null) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
			}
			else if (email.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
			}
			else {
				bindEmail = true;

				query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmail) {
					qPos.add(email);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "official.email IS NULL";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "official.email = ?";
	private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(official.email IS NULL OR official.email = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVE =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndIsActive",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndIsActive",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			OfficialModelImpl.GROUPID_COLUMN_BITMASK |
			OfficialModelImpl.ISACTIVE_COLUMN_BITMASK |
			OfficialModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVE = new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndIsActive",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the officials where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @return the matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActive(long groupId,
		boolean isActive) {
		return findByGroupIdAndIsActive(groupId, isActive, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials where groupId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActive(long groupId,
		boolean isActive, int start, int end) {
		return findByGroupIdAndIsActive(groupId, isActive, start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActive(long groupId,
		boolean isActive, int start, int end,
		OrderByComparator<Official> orderByComparator) {
		return findByGroupIdAndIsActive(groupId, isActive, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActive(long groupId,
		boolean isActive, int start, int end,
		OrderByComparator<Official> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE;
			finderArgs = new Object[] { groupId, isActive };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVE;
			finderArgs = new Object[] {
					groupId, isActive,
					
					start, end, orderByComparator
				};
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Official official : list) {
					if ((groupId != official.getGroupId()) ||
							(isActive != official.getIsActive())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActive_First(long groupId,
		boolean isActive, OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActive_First(groupId, isActive,
				orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActive_First(long groupId,
		boolean isActive, OrderByComparator<Official> orderByComparator) {
		List<Official> list = findByGroupIdAndIsActive(groupId, isActive, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActive_Last(long groupId,
		boolean isActive, OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActive_Last(groupId, isActive,
				orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActive_Last(long groupId,
		boolean isActive, OrderByComparator<Official> orderByComparator) {
		int count = countByGroupIdAndIsActive(groupId, isActive);

		if (count == 0) {
			return null;
		}

		List<Official> list = findByGroupIdAndIsActive(groupId, isActive,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the officials before and after the current official in the ordered set where groupId = &#63; and isActive = &#63;.
	 *
	 * @param officialId the primary key of the current official
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official[] findByGroupIdAndIsActive_PrevAndNext(long officialId,
		long groupId, boolean isActive,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = findByPrimaryKey(officialId);

		Session session = null;

		try {
			session = openSession();

			Official[] array = new OfficialImpl[3];

			array[0] = getByGroupIdAndIsActive_PrevAndNext(session, official,
					groupId, isActive, orderByComparator, true);

			array[1] = official;

			array[2] = getByGroupIdAndIsActive_PrevAndNext(session, official,
					groupId, isActive, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Official getByGroupIdAndIsActive_PrevAndNext(Session session,
		Official official, long groupId, boolean isActive,
		OrderByComparator<Official> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_OFFICIAL_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_ISACTIVE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OfficialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isActive);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(official);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Official> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the officials where groupId = &#63; and isActive = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 */
	@Override
	public void removeByGroupIdAndIsActive(long groupId, boolean isActive) {
		for (Official official : findByGroupIdAndIsActive(groupId, isActive,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials where groupId = &#63; and isActive = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @return the number of matching officials
	 */
	@Override
	public int countByGroupIdAndIsActive(long groupId, boolean isActive) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVE;

		Object[] finderArgs = new Object[] { groupId, isActive };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVE_GROUPID_2 = "official.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVE_ISACTIVE_2 = "official.isActive = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndIsActiveAndIsMunicipal",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndIsActiveAndIsMunicipal",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			OfficialModelImpl.GROUPID_COLUMN_BITMASK |
			OfficialModelImpl.ISACTIVE_COLUMN_BITMASK |
			OfficialModelImpl.ISMUNICIPAL_COLUMN_BITMASK |
			OfficialModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISMUNICIPAL =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndIsActiveAndIsMunicipal",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @return the matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal) {
		return findByGroupIdAndIsActiveAndIsMunicipal(groupId, isActive,
			isMunicipal, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal, int start, int end) {
		return findByGroupIdAndIsActiveAndIsMunicipal(groupId, isActive,
			isMunicipal, start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal, int start, int end,
		OrderByComparator<Official> orderByComparator) {
		return findByGroupIdAndIsActiveAndIsMunicipal(groupId, isActive,
			isMunicipal, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal, int start, int end,
		OrderByComparator<Official> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL;
			finderArgs = new Object[] { groupId, isActive, isMunicipal };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL;
			finderArgs = new Object[] {
					groupId, isActive, isMunicipal,
					
					start, end, orderByComparator
				};
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Official official : list) {
					if ((groupId != official.getGroupId()) ||
							(isActive != official.getIsActive()) ||
							(isMunicipal != official.getIsMunicipal())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISACTIVE_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISMUNICIPAL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				qPos.add(isMunicipal);

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActiveAndIsMunicipal_First(long groupId,
		boolean isActive, boolean isMunicipal,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActiveAndIsMunicipal_First(groupId,
				isActive, isMunicipal, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", isMunicipal=");
		msg.append(isMunicipal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActiveAndIsMunicipal_First(
		long groupId, boolean isActive, boolean isMunicipal,
		OrderByComparator<Official> orderByComparator) {
		List<Official> list = findByGroupIdAndIsActiveAndIsMunicipal(groupId,
				isActive, isMunicipal, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActiveAndIsMunicipal_Last(long groupId,
		boolean isActive, boolean isMunicipal,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActiveAndIsMunicipal_Last(groupId,
				isActive, isMunicipal, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", isMunicipal=");
		msg.append(isMunicipal);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActiveAndIsMunicipal_Last(long groupId,
		boolean isActive, boolean isMunicipal,
		OrderByComparator<Official> orderByComparator) {
		int count = countByGroupIdAndIsActiveAndIsMunicipal(groupId, isActive,
				isMunicipal);

		if (count == 0) {
			return null;
		}

		List<Official> list = findByGroupIdAndIsActiveAndIsMunicipal(groupId,
				isActive, isMunicipal, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the officials before and after the current official in the ordered set where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param officialId the primary key of the current official
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official[] findByGroupIdAndIsActiveAndIsMunicipal_PrevAndNext(
		long officialId, long groupId, boolean isActive, boolean isMunicipal,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = findByPrimaryKey(officialId);

		Session session = null;

		try {
			session = openSession();

			Official[] array = new OfficialImpl[3];

			array[0] = getByGroupIdAndIsActiveAndIsMunicipal_PrevAndNext(session,
					official, groupId, isActive, isMunicipal,
					orderByComparator, true);

			array[1] = official;

			array[2] = getByGroupIdAndIsActiveAndIsMunicipal_PrevAndNext(session,
					official, groupId, isActive, isMunicipal,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Official getByGroupIdAndIsActiveAndIsMunicipal_PrevAndNext(
		Session session, Official official, long groupId, boolean isActive,
		boolean isMunicipal, OrderByComparator<Official> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_OFFICIAL_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISACTIVE_2);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISMUNICIPAL_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OfficialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isActive);

		qPos.add(isMunicipal);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(official);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Official> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 */
	@Override
	public void removeByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal) {
		for (Official official : findByGroupIdAndIsActiveAndIsMunicipal(
				groupId, isActive, isMunicipal, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials where groupId = &#63; and isActive = &#63; and isMunicipal = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isMunicipal the is municipal
	 * @return the number of matching officials
	 */
	@Override
	public int countByGroupIdAndIsActiveAndIsMunicipal(long groupId,
		boolean isActive, boolean isMunicipal) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISMUNICIPAL;

		Object[] finderArgs = new Object[] { groupId, isActive, isMunicipal };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISACTIVE_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISMUNICIPAL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				qPos.add(isMunicipal);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_GROUPID_2 =
		"official.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISACTIVE_2 =
		"official.isActive = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISMUNICIPAL_ISMUNICIPAL_2 =
		"official.isMunicipal = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupIdAndIsActiveAndIsEurometropolitan",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, OfficialImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndIsActiveAndIsEurometropolitan",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			OfficialModelImpl.GROUPID_COLUMN_BITMASK |
			OfficialModelImpl.ISACTIVE_COLUMN_BITMASK |
			OfficialModelImpl.ISEUROMETROPOLITAN_COLUMN_BITMASK |
			OfficialModelImpl.LASTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN =
		new FinderPath(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndIsActiveAndIsEurometropolitan",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @return the matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsEurometropolitan(
		long groupId, boolean isActive, boolean isEurometropolitan) {
		return findByGroupIdAndIsActiveAndIsEurometropolitan(groupId, isActive,
			isEurometropolitan, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsEurometropolitan(
		long groupId, boolean isActive, boolean isEurometropolitan, int start,
		int end) {
		return findByGroupIdAndIsActiveAndIsEurometropolitan(groupId, isActive,
			isEurometropolitan, start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsEurometropolitan(
		long groupId, boolean isActive, boolean isEurometropolitan, int start,
		int end, OrderByComparator<Official> orderByComparator) {
		return findByGroupIdAndIsActiveAndIsEurometropolitan(groupId, isActive,
			isEurometropolitan, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching officials
	 */
	@Override
	public List<Official> findByGroupIdAndIsActiveAndIsEurometropolitan(
		long groupId, boolean isActive, boolean isEurometropolitan, int start,
		int end, OrderByComparator<Official> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN;
			finderArgs = new Object[] { groupId, isActive, isEurometropolitan };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN;
			finderArgs = new Object[] {
					groupId, isActive, isEurometropolitan,
					
					start, end, orderByComparator
				};
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Official official : list) {
					if ((groupId != official.getGroupId()) ||
							(isActive != official.getIsActive()) ||
							(isEurometropolitan != official.getIsEurometropolitan())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISACTIVE_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISEUROMETROPOLITAN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OfficialModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				qPos.add(isEurometropolitan);

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActiveAndIsEurometropolitan_First(
		long groupId, boolean isActive, boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActiveAndIsEurometropolitan_First(groupId,
				isActive, isEurometropolitan, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", isEurometropolitan=");
		msg.append(isEurometropolitan);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the first official in the ordered set where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActiveAndIsEurometropolitan_First(
		long groupId, boolean isActive, boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator) {
		List<Official> list = findByGroupIdAndIsActiveAndIsEurometropolitan(groupId,
				isActive, isEurometropolitan, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official
	 * @throws NoSuchOfficialException if a matching official could not be found
	 */
	@Override
	public Official findByGroupIdAndIsActiveAndIsEurometropolitan_Last(
		long groupId, boolean isActive, boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = fetchByGroupIdAndIsActiveAndIsEurometropolitan_Last(groupId,
				isActive, isEurometropolitan, orderByComparator);

		if (official != null) {
			return official;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", isActive=");
		msg.append(isActive);

		msg.append(", isEurometropolitan=");
		msg.append(isEurometropolitan);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOfficialException(msg.toString());
	}

	/**
	 * Returns the last official in the ordered set where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching official, or <code>null</code> if a matching official could not be found
	 */
	@Override
	public Official fetchByGroupIdAndIsActiveAndIsEurometropolitan_Last(
		long groupId, boolean isActive, boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator) {
		int count = countByGroupIdAndIsActiveAndIsEurometropolitan(groupId,
				isActive, isEurometropolitan);

		if (count == 0) {
			return null;
		}

		List<Official> list = findByGroupIdAndIsActiveAndIsEurometropolitan(groupId,
				isActive, isEurometropolitan, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the officials before and after the current official in the ordered set where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param officialId the primary key of the current official
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official[] findByGroupIdAndIsActiveAndIsEurometropolitan_PrevAndNext(
		long officialId, long groupId, boolean isActive,
		boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator)
		throws NoSuchOfficialException {
		Official official = findByPrimaryKey(officialId);

		Session session = null;

		try {
			session = openSession();

			Official[] array = new OfficialImpl[3];

			array[0] = getByGroupIdAndIsActiveAndIsEurometropolitan_PrevAndNext(session,
					official, groupId, isActive, isEurometropolitan,
					orderByComparator, true);

			array[1] = official;

			array[2] = getByGroupIdAndIsActiveAndIsEurometropolitan_PrevAndNext(session,
					official, groupId, isActive, isEurometropolitan,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Official getByGroupIdAndIsActiveAndIsEurometropolitan_PrevAndNext(
		Session session, Official official, long groupId, boolean isActive,
		boolean isEurometropolitan,
		OrderByComparator<Official> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_OFFICIAL_WHERE);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISACTIVE_2);

		query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISEUROMETROPOLITAN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OfficialModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(isActive);

		qPos.add(isEurometropolitan);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(official);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Official> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 */
	@Override
	public void removeByGroupIdAndIsActiveAndIsEurometropolitan(long groupId,
		boolean isActive, boolean isEurometropolitan) {
		for (Official official : findByGroupIdAndIsActiveAndIsEurometropolitan(
				groupId, isActive, isEurometropolitan, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials where groupId = &#63; and isActive = &#63; and isEurometropolitan = &#63;.
	 *
	 * @param groupId the group ID
	 * @param isActive the is active
	 * @param isEurometropolitan the is eurometropolitan
	 * @return the number of matching officials
	 */
	@Override
	public int countByGroupIdAndIsActiveAndIsEurometropolitan(long groupId,
		boolean isActive, boolean isEurometropolitan) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN;

		Object[] finderArgs = new Object[] { groupId, isActive, isEurometropolitan };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_OFFICIAL_WHERE);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISACTIVE_2);

			query.append(_FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISEUROMETROPOLITAN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(isActive);

				qPos.add(isEurometropolitan);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_GROUPID_2 =
		"official.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISACTIVE_2 =
		"official.isActive = ? AND ";
	private static final String _FINDER_COLUMN_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN_ISEUROMETROPOLITAN_2 =
		"official.isEurometropolitan = ?";

	public OfficialPersistenceImpl() {
		setModelClass(Official.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the official in the entity cache if it is enabled.
	 *
	 * @param official the official
	 */
	@Override
	public void cacheResult(Official official) {
		entityCache.putResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialImpl.class, official.getPrimaryKey(), official);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { official.getUuid(), official.getGroupId() }, official);

		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL,
			new Object[] { official.getEmail() }, official);

		official.resetOriginalValues();
	}

	/**
	 * Caches the officials in the entity cache if it is enabled.
	 *
	 * @param officials the officials
	 */
	@Override
	public void cacheResult(List<Official> officials) {
		for (Official official : officials) {
			if (entityCache.getResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
						OfficialImpl.class, official.getPrimaryKey()) == null) {
				cacheResult(official);
			}
			else {
				official.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all officials.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OfficialImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the official.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Official official) {
		entityCache.removeResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialImpl.class, official.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((OfficialModelImpl)official, true);
	}

	@Override
	public void clearCache(List<Official> officials) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Official official : officials) {
			entityCache.removeResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
				OfficialImpl.class, official.getPrimaryKey());

			clearUniqueFindersCache((OfficialModelImpl)official, true);
		}
	}

	protected void cacheUniqueFindersCache(OfficialModelImpl officialModelImpl) {
		Object[] args = new Object[] {
				officialModelImpl.getUuid(), officialModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			officialModelImpl, false);

		args = new Object[] { officialModelImpl.getEmail() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_EMAIL, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_EMAIL, args,
			officialModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		OfficialModelImpl officialModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					officialModelImpl.getUuid(), officialModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((officialModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					officialModelImpl.getOriginalUuid(),
					officialModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { officialModelImpl.getEmail() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}

		if ((officialModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAIL.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { officialModelImpl.getOriginalEmail() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_EMAIL, args);
		}
	}

	/**
	 * Creates a new official with the primary key. Does not add the official to the database.
	 *
	 * @param officialId the primary key for the new official
	 * @return the new official
	 */
	@Override
	public Official create(long officialId) {
		Official official = new OfficialImpl();

		official.setNew(true);
		official.setPrimaryKey(officialId);

		String uuid = PortalUUIDUtil.generate();

		official.setUuid(uuid);

		official.setCompanyId(companyProvider.getCompanyId());

		return official;
	}

	/**
	 * Removes the official with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officialId the primary key of the official
	 * @return the official that was removed
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official remove(long officialId) throws NoSuchOfficialException {
		return remove((Serializable)officialId);
	}

	/**
	 * Removes the official with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the official
	 * @return the official that was removed
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official remove(Serializable primaryKey)
		throws NoSuchOfficialException {
		Session session = null;

		try {
			session = openSession();

			Official official = (Official)session.get(OfficialImpl.class,
					primaryKey);

			if (official == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOfficialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(official);
		}
		catch (NoSuchOfficialException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Official removeImpl(Official official) {
		official = toUnwrappedModel(official);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(official)) {
				official = (Official)session.get(OfficialImpl.class,
						official.getPrimaryKeyObj());
			}

			if (official != null) {
				session.delete(official);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (official != null) {
			clearCache(official);
		}

		return official;
	}

	@Override
	public Official updateImpl(Official official) {
		official = toUnwrappedModel(official);

		boolean isNew = official.isNew();

		OfficialModelImpl officialModelImpl = (OfficialModelImpl)official;

		if (Validator.isNull(official.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			official.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (official.getCreateDate() == null)) {
			if (serviceContext == null) {
				official.setCreateDate(now);
			}
			else {
				official.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!officialModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				official.setModifiedDate(now);
			}
			else {
				official.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (official.isNew()) {
				session.save(official);

				official.setNew(false);
			}
			else {
				official = (Official)session.merge(official);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!OfficialModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { officialModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					officialModelImpl.getUuid(),
					officialModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] {
					officialModelImpl.getGroupId(),
					officialModelImpl.getIsActive()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVE,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE,
				args);

			args = new Object[] {
					officialModelImpl.getGroupId(),
					officialModelImpl.getIsActive(),
					officialModelImpl.getIsMunicipal()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
				args);

			args = new Object[] {
					officialModelImpl.getGroupId(),
					officialModelImpl.getIsActive(),
					officialModelImpl.getIsEurometropolitan()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((officialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { officialModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { officialModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((officialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officialModelImpl.getOriginalUuid(),
						officialModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						officialModelImpl.getUuid(),
						officialModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((officialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officialModelImpl.getOriginalGroupId(),
						officialModelImpl.getOriginalIsActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE,
					args);

				args = new Object[] {
						officialModelImpl.getGroupId(),
						officialModelImpl.getIsActive()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVE,
					args);
			}

			if ((officialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officialModelImpl.getOriginalGroupId(),
						officialModelImpl.getOriginalIsActive(),
						officialModelImpl.getOriginalIsMunicipal()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
					args);

				args = new Object[] {
						officialModelImpl.getGroupId(),
						officialModelImpl.getIsActive(),
						officialModelImpl.getIsMunicipal()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISMUNICIPAL,
					args);
			}

			if ((officialModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						officialModelImpl.getOriginalGroupId(),
						officialModelImpl.getOriginalIsActive(),
						officialModelImpl.getOriginalIsEurometropolitan()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
					args);

				args = new Object[] {
						officialModelImpl.getGroupId(),
						officialModelImpl.getIsActive(),
						officialModelImpl.getIsEurometropolitan()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPIDANDISACTIVEANDISEUROMETROPOLITAN,
					args);
			}
		}

		entityCache.putResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
			OfficialImpl.class, official.getPrimaryKey(), official, false);

		clearUniqueFindersCache(officialModelImpl, false);
		cacheUniqueFindersCache(officialModelImpl);

		official.resetOriginalValues();

		return official;
	}

	protected Official toUnwrappedModel(Official official) {
		if (official instanceof OfficialImpl) {
			return official;
		}

		OfficialImpl officialImpl = new OfficialImpl();

		officialImpl.setNew(official.isNew());
		officialImpl.setPrimaryKey(official.getPrimaryKey());

		officialImpl.setUuid(official.getUuid());
		officialImpl.setOfficialId(official.getOfficialId());
		officialImpl.setGroupId(official.getGroupId());
		officialImpl.setCompanyId(official.getCompanyId());
		officialImpl.setUserId(official.getUserId());
		officialImpl.setUserName(official.getUserName());
		officialImpl.setCreateDate(official.getCreateDate());
		officialImpl.setModifiedDate(official.getModifiedDate());
		officialImpl.setStatus(official.getStatus());
		officialImpl.setStatusByUserId(official.getStatusByUserId());
		officialImpl.setStatusByUserName(official.getStatusByUserName());
		officialImpl.setStatusDate(official.getStatusDate());
		officialImpl.setEmail(official.getEmail());
		officialImpl.setFirstname(official.getFirstname());
		officialImpl.setLastname(official.getLastname());
		officialImpl.setIsMunicipal(official.isIsMunicipal());
		officialImpl.setIsEurometropolitan(official.isIsEurometropolitan());
		officialImpl.setIsActive(official.isIsActive());

		return officialImpl;
	}

	/**
	 * Returns the official with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the official
	 * @return the official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOfficialException {
		Official official = fetchByPrimaryKey(primaryKey);

		if (official == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOfficialException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return official;
	}

	/**
	 * Returns the official with the primary key or throws a {@link NoSuchOfficialException} if it could not be found.
	 *
	 * @param officialId the primary key of the official
	 * @return the official
	 * @throws NoSuchOfficialException if a official with the primary key could not be found
	 */
	@Override
	public Official findByPrimaryKey(long officialId)
		throws NoSuchOfficialException {
		return findByPrimaryKey((Serializable)officialId);
	}

	/**
	 * Returns the official with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the official
	 * @return the official, or <code>null</code> if a official with the primary key could not be found
	 */
	@Override
	public Official fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
				OfficialImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Official official = (Official)serializable;

		if (official == null) {
			Session session = null;

			try {
				session = openSession();

				official = (Official)session.get(OfficialImpl.class, primaryKey);

				if (official != null) {
					cacheResult(official);
				}
				else {
					entityCache.putResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
						OfficialImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
					OfficialImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return official;
	}

	/**
	 * Returns the official with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officialId the primary key of the official
	 * @return the official, or <code>null</code> if a official with the primary key could not be found
	 */
	@Override
	public Official fetchByPrimaryKey(long officialId) {
		return fetchByPrimaryKey((Serializable)officialId);
	}

	@Override
	public Map<Serializable, Official> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Official> map = new HashMap<Serializable, Official>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Official official = fetchByPrimaryKey(primaryKey);

			if (official != null) {
				map.put(primaryKey, official);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
					OfficialImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Official)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OFFICIAL_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Official official : (List<Official>)q.list()) {
				map.put(official.getPrimaryKeyObj(), official);

				cacheResult(official);

				uncachedPrimaryKeys.remove(official.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(OfficialModelImpl.ENTITY_CACHE_ENABLED,
					OfficialImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the officials.
	 *
	 * @return the officials
	 */
	@Override
	public List<Official> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the officials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @return the range of officials
	 */
	@Override
	public List<Official> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the officials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of officials
	 */
	@Override
	public List<Official> findAll(int start, int end,
		OrderByComparator<Official> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the officials.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link OfficialModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of officials
	 * @param end the upper bound of the range of officials (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of officials
	 */
	@Override
	public List<Official> findAll(int start, int end,
		OrderByComparator<Official> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Official> list = null;

		if (retrieveFromCache) {
			list = (List<Official>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_OFFICIAL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OFFICIAL;

				if (pagination) {
					sql = sql.concat(OfficialModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Official>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the officials from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Official official : findAll()) {
			remove(official);
		}
	}

	/**
	 * Returns the number of officials.
	 *
	 * @return the number of officials
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OFFICIAL);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
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
	protected Map<String, Integer> getTableColumnsMap() {
		return OfficialModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the official persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(OfficialImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_OFFICIAL = "SELECT official FROM Official official";
	private static final String _SQL_SELECT_OFFICIAL_WHERE_PKS_IN = "SELECT official FROM Official official WHERE officialId IN (";
	private static final String _SQL_SELECT_OFFICIAL_WHERE = "SELECT official FROM Official official WHERE ";
	private static final String _SQL_COUNT_OFFICIAL = "SELECT COUNT(official) FROM Official official";
	private static final String _SQL_COUNT_OFFICIAL_WHERE = "SELECT COUNT(official) FROM Official official WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "official.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Official exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Official exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(OfficialPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}