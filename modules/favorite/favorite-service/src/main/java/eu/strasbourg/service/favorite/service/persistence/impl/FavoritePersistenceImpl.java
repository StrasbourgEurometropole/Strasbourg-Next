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

package eu.strasbourg.service.favorite.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;
import eu.strasbourg.service.favorite.exception.NoSuchFavoriteException;
import eu.strasbourg.service.favorite.model.Favorite;
import eu.strasbourg.service.favorite.model.FavoriteTable;
import eu.strasbourg.service.favorite.model.impl.FavoriteImpl;
import eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl;
import eu.strasbourg.service.favorite.service.persistence.FavoritePersistence;
import eu.strasbourg.service.favorite.service.persistence.FavoriteUtil;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the favorite service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class FavoritePersistenceImpl
	extends BasePersistenceImpl<Favorite> implements FavoritePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FavoriteUtil</code> to access the favorite persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FavoriteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPublikUserId;
	private FinderPath _finderPathWithoutPaginationFindByPublikUserId;
	private FinderPath _finderPathCountByPublikUserId;

	/**
	 * Returns all the favorites where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching favorites
	 */
	@Override
	public List<Favorite> findByPublikUserId(String publikUserId) {
		return findByPublikUserId(
			publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	@Override
	public List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end) {

		return findByPublikUserId(publikUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<Favorite> orderByComparator) {

		return findByPublikUserId(
			publikUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favorites where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<Favorite> orderByComparator, boolean useFinderCache) {

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

		List<Favorite> list = null;

		if (useFinderCache) {
			list = (List<Favorite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favorite favorite : list) {
					if (!publikUserId.equals(favorite.getPublikUserId())) {
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

			sb.append(_SQL_SELECT_FAVORITE_WHERE);

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
				sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
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

				list = (List<Favorite>)QueryUtil.list(
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
	 * Returns the first favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByPublikUserId_First(
			String publikUserId, OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByPublikUserId_First(
			publikUserId, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the first favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByPublikUserId_First(
		String publikUserId, OrderByComparator<Favorite> orderByComparator) {

		List<Favorite> list = findByPublikUserId(
			publikUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByPublikUserId_Last(
			String publikUserId, OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByPublikUserId_Last(
			publikUserId, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the last favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByPublikUserId_Last(
		String publikUserId, OrderByComparator<Favorite> orderByComparator) {

		int count = countByPublikUserId(publikUserId);

		if (count == 0) {
			return null;
		}

		List<Favorite> list = findByPublikUserId(
			publikUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where publikUserId = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite[] findByPublikUserId_PrevAndNext(
			long favoriteId, String publikUserId,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		publikUserId = Objects.toString(publikUserId, "");

		Favorite favorite = findByPrimaryKey(favoriteId);

		Session session = null;

		try {
			session = openSession();

			Favorite[] array = new FavoriteImpl[3];

			array[0] = getByPublikUserId_PrevAndNext(
				session, favorite, publikUserId, orderByComparator, true);

			array[1] = favorite;

			array[2] = getByPublikUserId_PrevAndNext(
				session, favorite, publikUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Favorite getByPublikUserId_PrevAndNext(
		Session session, Favorite favorite, String publikUserId,
		OrderByComparator<Favorite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FAVORITE_WHERE);

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
			sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(favorite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Favorite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favorites where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	@Override
	public void removeByPublikUserId(String publikUserId) {
		for (Favorite favorite :
				findByPublikUserId(
					publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByPublikUserId(String publikUserId) {
		publikUserId = Objects.toString(publikUserId, "");

		FinderPath finderPath = _finderPathCountByPublikUserId;

		Object[] finderArgs = new Object[] {publikUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FAVORITE_WHERE);

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
		"favorite.publikUserId = ?";

	private static final String _FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3 =
		"(favorite.publikUserId IS NULL OR favorite.publikUserId = '')";

	private FinderPath _finderPathFetchByAllAttributes;
	private FinderPath _finderPathCountByAllAttributes;

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or throws a <code>NoSuchFavoriteException</code> if it could not be found.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByAllAttributes(
			String publikUserId, String title, long typeId, long entityId)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByAllAttributes(
			publikUserId, title, typeId, entityId);

		if (favorite == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("publikUserId=");
			sb.append(publikUserId);

			sb.append(", title=");
			sb.append(title);

			sb.append(", typeId=");
			sb.append(typeId);

			sb.append(", entityId=");
			sb.append(entityId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFavoriteException(sb.toString());
		}

		return favorite;
	}

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByAllAttributes(
		String publikUserId, String title, long typeId, long entityId) {

		return fetchByAllAttributes(
			publikUserId, title, typeId, entityId, true);
	}

	/**
	 * Returns the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByAllAttributes(
		String publikUserId, String title, long typeId, long entityId,
		boolean useFinderCache) {

		publikUserId = Objects.toString(publikUserId, "");
		title = Objects.toString(title, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {publikUserId, title, typeId, entityId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAllAttributes, finderArgs, this);
		}

		if (result instanceof Favorite) {
			Favorite favorite = (Favorite)result;

			if (!Objects.equals(publikUserId, favorite.getPublikUserId()) ||
				!Objects.equals(title, favorite.getTitle()) ||
				(typeId != favorite.getTypeId()) ||
				(entityId != favorite.getEntityId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_FAVORITE_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_2);
			}

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TITLE_2);
			}

			sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TYPEID_2);

			sb.append(_FINDER_COLUMN_ALLATTRIBUTES_ENTITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				if (bindTitle) {
					queryPos.add(title);
				}

				queryPos.add(typeId);

				queryPos.add(entityId);

				List<Favorite> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAllAttributes, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									publikUserId, title, typeId, entityId
								};
							}

							_log.warn(
								"FavoritePersistenceImpl.fetchByAllAttributes(String, String, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Favorite favorite = list.get(0);

					result = favorite;

					cacheResult(favorite);
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
			return (Favorite)result;
		}
	}

	/**
	 * Removes the favorite where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the favorite that was removed
	 */
	@Override
	public Favorite removeByAllAttributes(
			String publikUserId, String title, long typeId, long entityId)
		throws NoSuchFavoriteException {

		Favorite favorite = findByAllAttributes(
			publikUserId, title, typeId, entityId);

		return remove(favorite);
	}

	/**
	 * Returns the number of favorites where publikUserId = &#63; and title = &#63; and typeId = &#63; and entityId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param title the title
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByAllAttributes(
		String publikUserId, String title, long typeId, long entityId) {

		publikUserId = Objects.toString(publikUserId, "");
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathCountByAllAttributes;

		Object[] finderArgs = new Object[] {
			publikUserId, title, typeId, entityId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_FAVORITE_WHERE);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_2);
			}

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TITLE_2);
			}

			sb.append(_FINDER_COLUMN_ALLATTRIBUTES_TYPEID_2);

			sb.append(_FINDER_COLUMN_ALLATTRIBUTES_ENTITYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				if (bindTitle) {
					queryPos.add(title);
				}

				queryPos.add(typeId);

				queryPos.add(entityId);

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

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_2 =
		"favorite.publikUserId = ? AND ";

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_PUBLIKUSERID_3 =
		"(favorite.publikUserId IS NULL OR favorite.publikUserId = '') AND ";

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_TITLE_2 =
		"favorite.title = ? AND ";

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_TITLE_3 =
		"(favorite.title IS NULL OR favorite.title = '') AND ";

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_TYPEID_2 =
		"favorite.typeId = ? AND ";

	private static final String _FINDER_COLUMN_ALLATTRIBUTES_ENTITYID_2 =
		"favorite.entityId = ?";

	private FinderPath _finderPathWithPaginationFindByEntityIdAndTypeId;
	private FinderPath _finderPathWithoutPaginationFindByEntityIdAndTypeId;
	private FinderPath _finderPathCountByEntityIdAndTypeId;

	/**
	 * Returns all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the matching favorites
	 */
	@Override
	public List<Favorite> findByEntityIdAndTypeId(long entityId, long typeId) {
		return findByEntityIdAndTypeId(
			entityId, typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	@Override
	public List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end) {

		return findByEntityIdAndTypeId(entityId, typeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end,
		OrderByComparator<Favorite> orderByComparator) {

		return findByEntityIdAndTypeId(
			entityId, typeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByEntityIdAndTypeId(
		long entityId, long typeId, int start, int end,
		OrderByComparator<Favorite> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByEntityIdAndTypeId;
				finderArgs = new Object[] {entityId, typeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEntityIdAndTypeId;
			finderArgs = new Object[] {
				entityId, typeId, start, end, orderByComparator
			};
		}

		List<Favorite> list = null;

		if (useFinderCache) {
			list = (List<Favorite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favorite favorite : list) {
					if ((entityId != favorite.getEntityId()) ||
						(typeId != favorite.getTypeId())) {

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

			sb.append(_SQL_SELECT_FAVORITE_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_ENTITYID_2);

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityId);

				queryPos.add(typeId);

				list = (List<Favorite>)QueryUtil.list(
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
	 * Returns the first favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByEntityIdAndTypeId_First(
			long entityId, long typeId,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByEntityIdAndTypeId_First(
			entityId, typeId, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append(", typeId=");
		sb.append(typeId);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the first favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByEntityIdAndTypeId_First(
		long entityId, long typeId,
		OrderByComparator<Favorite> orderByComparator) {

		List<Favorite> list = findByEntityIdAndTypeId(
			entityId, typeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByEntityIdAndTypeId_Last(
			long entityId, long typeId,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByEntityIdAndTypeId_Last(
			entityId, typeId, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("entityId=");
		sb.append(entityId);

		sb.append(", typeId=");
		sb.append(typeId);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the last favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByEntityIdAndTypeId_Last(
		long entityId, long typeId,
		OrderByComparator<Favorite> orderByComparator) {

		int count = countByEntityIdAndTypeId(entityId, typeId);

		if (count == 0) {
			return null;
		}

		List<Favorite> list = findByEntityIdAndTypeId(
			entityId, typeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where entityId = &#63; and typeId = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite[] findByEntityIdAndTypeId_PrevAndNext(
			long favoriteId, long entityId, long typeId,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite = findByPrimaryKey(favoriteId);

		Session session = null;

		try {
			session = openSession();

			Favorite[] array = new FavoriteImpl[3];

			array[0] = getByEntityIdAndTypeId_PrevAndNext(
				session, favorite, entityId, typeId, orderByComparator, true);

			array[1] = favorite;

			array[2] = getByEntityIdAndTypeId_PrevAndNext(
				session, favorite, entityId, typeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Favorite getByEntityIdAndTypeId_PrevAndNext(
		Session session, Favorite favorite, long entityId, long typeId,
		OrderByComparator<Favorite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_FAVORITE_WHERE);

		sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_ENTITYID_2);

		sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_TYPEID_2);

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
			sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(entityId);

		queryPos.add(typeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(favorite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Favorite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favorites where entityId = &#63; and typeId = &#63; from the database.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 */
	@Override
	public void removeByEntityIdAndTypeId(long entityId, long typeId) {
		for (Favorite favorite :
				findByEntityIdAndTypeId(
					entityId, typeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites where entityId = &#63; and typeId = &#63;.
	 *
	 * @param entityId the entity ID
	 * @param typeId the type ID
	 * @return the number of matching favorites
	 */
	@Override
	public int countByEntityIdAndTypeId(long entityId, long typeId) {
		FinderPath finderPath = _finderPathCountByEntityIdAndTypeId;

		Object[] finderArgs = new Object[] {entityId, typeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FAVORITE_WHERE);

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_ENTITYID_2);

			sb.append(_FINDER_COLUMN_ENTITYIDANDTYPEID_TYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(entityId);

				queryPos.add(typeId);

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

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPEID_ENTITYID_2 =
		"favorite.entityId = ? AND ";

	private static final String _FINDER_COLUMN_ENTITYIDANDTYPEID_TYPEID_2 =
		"favorite.typeId = ?";

	private FinderPath
		_finderPathWithPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent;
	private FinderPath
		_finderPathWithoutPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent;
	private FinderPath
		_finderPathCountByTypeIdAndEntityIdAndPublikUserIdAndContent;

	/**
	 * Returns all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @return the matching favorites
	 */
	@Override
	public List<Favorite> findByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content) {

		return findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of matching favorites
	 */
	@Override
	public List<Favorite> findByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content,
		int start, int end) {

		return findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content, start, end, null);
	}

	/**
	 * Returns an ordered range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content,
		int start, int end, OrderByComparator<Favorite> orderByComparator) {

		return findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching favorites
	 */
	@Override
	public List<Favorite> findByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content,
		int start, int end, OrderByComparator<Favorite> orderByComparator,
		boolean useFinderCache) {

		publikUserId = Objects.toString(publikUserId, "");
		content = Objects.toString(content, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent;
				finderArgs = new Object[] {
					typeId, entityId, publikUserId, content
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent;
			finderArgs = new Object[] {
				typeId, entityId, publikUserId, content, start, end,
				orderByComparator
			};
		}

		List<Favorite> list = null;

		if (useFinderCache) {
			list = (List<Favorite>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Favorite favorite : list) {
					if ((typeId != favorite.getTypeId()) ||
						(entityId != favorite.getEntityId()) ||
						!publikUserId.equals(favorite.getPublikUserId()) ||
						!content.equals(favorite.getContent())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_FAVORITE_WHERE);

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_TYPEID_2);

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_ENTITYID_2);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_2);
			}

			boolean bindContent = false;

			if (content.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(typeId);

				queryPos.add(entityId);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				if (bindContent) {
					queryPos.add(content);
				}

				list = (List<Favorite>)QueryUtil.list(
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
	 * Returns the first favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByTypeIdAndEntityIdAndPublikUserIdAndContent_First(
			long typeId, long entityId, String publikUserId, String content,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite =
			fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_First(
				typeId, entityId, publikUserId, content, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("typeId=");
		sb.append(typeId);

		sb.append(", entityId=");
		sb.append(entityId);

		sb.append(", publikUserId=");
		sb.append(publikUserId);

		sb.append(", content=");
		sb.append(content);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the first favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_First(
		long typeId, long entityId, String publikUserId, String content,
		OrderByComparator<Favorite> orderByComparator) {

		List<Favorite> list = findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite
	 * @throws NoSuchFavoriteException if a matching favorite could not be found
	 */
	@Override
	public Favorite findByTypeIdAndEntityIdAndPublikUserIdAndContent_Last(
			long typeId, long entityId, String publikUserId, String content,
			OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		Favorite favorite =
			fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_Last(
				typeId, entityId, publikUserId, content, orderByComparator);

		if (favorite != null) {
			return favorite;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("typeId=");
		sb.append(typeId);

		sb.append(", entityId=");
		sb.append(entityId);

		sb.append(", publikUserId=");
		sb.append(publikUserId);

		sb.append(", content=");
		sb.append(content);

		sb.append("}");

		throw new NoSuchFavoriteException(sb.toString());
	}

	/**
	 * Returns the last favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching favorite, or <code>null</code> if a matching favorite could not be found
	 */
	@Override
	public Favorite fetchByTypeIdAndEntityIdAndPublikUserIdAndContent_Last(
		long typeId, long entityId, String publikUserId, String content,
		OrderByComparator<Favorite> orderByComparator) {

		int count = countByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content);

		if (count == 0) {
			return null;
		}

		List<Favorite> list = findByTypeIdAndEntityIdAndPublikUserIdAndContent(
			typeId, entityId, publikUserId, content, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the favorites before and after the current favorite in the ordered set where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param favoriteId the primary key of the current favorite
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite[]
			findByTypeIdAndEntityIdAndPublikUserIdAndContent_PrevAndNext(
				long favoriteId, long typeId, long entityId,
				String publikUserId, String content,
				OrderByComparator<Favorite> orderByComparator)
		throws NoSuchFavoriteException {

		publikUserId = Objects.toString(publikUserId, "");
		content = Objects.toString(content, "");

		Favorite favorite = findByPrimaryKey(favoriteId);

		Session session = null;

		try {
			session = openSession();

			Favorite[] array = new FavoriteImpl[3];

			array[0] =
				getByTypeIdAndEntityIdAndPublikUserIdAndContent_PrevAndNext(
					session, favorite, typeId, entityId, publikUserId, content,
					orderByComparator, true);

			array[1] = favorite;

			array[2] =
				getByTypeIdAndEntityIdAndPublikUserIdAndContent_PrevAndNext(
					session, favorite, typeId, entityId, publikUserId, content,
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

	protected Favorite
		getByTypeIdAndEntityIdAndPublikUserIdAndContent_PrevAndNext(
			Session session, Favorite favorite, long typeId, long entityId,
			String publikUserId, String content,
			OrderByComparator<Favorite> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_FAVORITE_WHERE);

		sb.append(
			_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_TYPEID_2);

		sb.append(
			_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_ENTITYID_2);

		boolean bindPublikUserId = false;

		if (publikUserId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_3);
		}
		else {
			bindPublikUserId = true;

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_2);
		}

		boolean bindContent = false;

		if (content.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_3);
		}
		else {
			bindContent = true;

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_2);
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
			sb.append(FavoriteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(typeId);

		queryPos.add(entityId);

		if (bindPublikUserId) {
			queryPos.add(publikUserId);
		}

		if (bindContent) {
			queryPos.add(content);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(favorite)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Favorite> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63; from the database.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 */
	@Override
	public void removeByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content) {

		for (Favorite favorite :
				findByTypeIdAndEntityIdAndPublikUserIdAndContent(
					typeId, entityId, publikUserId, content, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites where typeId = &#63; and entityId = &#63; and publikUserId = &#63; and content = &#63;.
	 *
	 * @param typeId the type ID
	 * @param entityId the entity ID
	 * @param publikUserId the publik user ID
	 * @param content the content
	 * @return the number of matching favorites
	 */
	@Override
	public int countByTypeIdAndEntityIdAndPublikUserIdAndContent(
		long typeId, long entityId, String publikUserId, String content) {

		publikUserId = Objects.toString(publikUserId, "");
		content = Objects.toString(content, "");

		FinderPath finderPath =
			_finderPathCountByTypeIdAndEntityIdAndPublikUserIdAndContent;

		Object[] finderArgs = new Object[] {
			typeId, entityId, publikUserId, content
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_FAVORITE_WHERE);

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_TYPEID_2);

			sb.append(
				_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_ENTITYID_2);

			boolean bindPublikUserId = false;

			if (publikUserId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_3);
			}
			else {
				bindPublikUserId = true;

				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_2);
			}

			boolean bindContent = false;

			if (content.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_3);
			}
			else {
				bindContent = true;

				sb.append(
					_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(typeId);

				queryPos.add(entityId);

				if (bindPublikUserId) {
					queryPos.add(publikUserId);
				}

				if (bindContent) {
					queryPos.add(content);
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
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_TYPEID_2 =
			"favorite.typeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_ENTITYID_2 =
			"favorite.entityId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_2 =
			"favorite.publikUserId = ? AND ";

	private static final String
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_PUBLIKUSERID_3 =
			"(favorite.publikUserId IS NULL OR favorite.publikUserId = '') AND ";

	private static final String
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_2 =
			"favorite.content = ?";

	private static final String
		_FINDER_COLUMN_TYPEIDANDENTITYIDANDPUBLIKUSERIDANDCONTENT_CONTENT_3 =
			"(favorite.content IS NULL OR favorite.content = '')";

	public FavoritePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Favorite.class);

		setModelImplClass(FavoriteImpl.class);
		setModelPKClass(long.class);

		setTable(FavoriteTable.INSTANCE);
	}

	/**
	 * Caches the favorite in the entity cache if it is enabled.
	 *
	 * @param favorite the favorite
	 */
	@Override
	public void cacheResult(Favorite favorite) {
		entityCache.putResult(
			FavoriteImpl.class, favorite.getPrimaryKey(), favorite);

		finderCache.putResult(
			_finderPathFetchByAllAttributes,
			new Object[] {
				favorite.getPublikUserId(), favorite.getTitle(),
				favorite.getTypeId(), favorite.getEntityId()
			},
			favorite);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the favorites in the entity cache if it is enabled.
	 *
	 * @param favorites the favorites
	 */
	@Override
	public void cacheResult(List<Favorite> favorites) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (favorites.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Favorite favorite : favorites) {
			if (entityCache.getResult(
					FavoriteImpl.class, favorite.getPrimaryKey()) == null) {

				cacheResult(favorite);
			}
		}
	}

	/**
	 * Clears the cache for all favorites.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FavoriteImpl.class);

		finderCache.clearCache(FavoriteImpl.class);
	}

	/**
	 * Clears the cache for the favorite.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Favorite favorite) {
		entityCache.removeResult(FavoriteImpl.class, favorite);
	}

	@Override
	public void clearCache(List<Favorite> favorites) {
		for (Favorite favorite : favorites) {
			entityCache.removeResult(FavoriteImpl.class, favorite);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FavoriteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FavoriteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FavoriteModelImpl favoriteModelImpl) {

		Object[] args = new Object[] {
			favoriteModelImpl.getPublikUserId(), favoriteModelImpl.getTitle(),
			favoriteModelImpl.getTypeId(), favoriteModelImpl.getEntityId()
		};

		finderCache.putResult(
			_finderPathCountByAllAttributes, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAllAttributes, args, favoriteModelImpl);
	}

	/**
	 * Creates a new favorite with the primary key. Does not add the favorite to the database.
	 *
	 * @param favoriteId the primary key for the new favorite
	 * @return the new favorite
	 */
	@Override
	public Favorite create(long favoriteId) {
		Favorite favorite = new FavoriteImpl();

		favorite.setNew(true);
		favorite.setPrimaryKey(favoriteId);

		return favorite;
	}

	/**
	 * Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite remove(long favoriteId) throws NoSuchFavoriteException {
		return remove((Serializable)favoriteId);
	}

	/**
	 * Removes the favorite with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the favorite
	 * @return the favorite that was removed
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite remove(Serializable primaryKey)
		throws NoSuchFavoriteException {

		Session session = null;

		try {
			session = openSession();

			Favorite favorite = (Favorite)session.get(
				FavoriteImpl.class, primaryKey);

			if (favorite == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFavoriteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(favorite);
		}
		catch (NoSuchFavoriteException noSuchEntityException) {
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
	protected Favorite removeImpl(Favorite favorite) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(favorite)) {
				favorite = (Favorite)session.get(
					FavoriteImpl.class, favorite.getPrimaryKeyObj());
			}

			if (favorite != null) {
				session.delete(favorite);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (favorite != null) {
			clearCache(favorite);
		}

		return favorite;
	}

	@Override
	public Favorite updateImpl(Favorite favorite) {
		boolean isNew = favorite.isNew();

		if (!(favorite instanceof FavoriteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(favorite.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(favorite);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in favorite proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Favorite implementation " +
					favorite.getClass());
		}

		FavoriteModelImpl favoriteModelImpl = (FavoriteModelImpl)favorite;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (favorite.getCreateDate() == null)) {
			if (serviceContext == null) {
				favorite.setCreateDate(date);
			}
			else {
				favorite.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!favoriteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				favorite.setModifiedDate(date);
			}
			else {
				favorite.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(favorite);
			}
			else {
				favorite = (Favorite)session.merge(favorite);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FavoriteImpl.class, favoriteModelImpl, false, true);

		cacheUniqueFindersCache(favoriteModelImpl);

		if (isNew) {
			favorite.setNew(false);
		}

		favorite.resetOriginalValues();

		return favorite;
	}

	/**
	 * Returns the favorite with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the favorite
	 * @return the favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFavoriteException {

		Favorite favorite = fetchByPrimaryKey(primaryKey);

		if (favorite == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFavoriteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return favorite;
	}

	/**
	 * Returns the favorite with the primary key or throws a <code>NoSuchFavoriteException</code> if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite
	 * @throws NoSuchFavoriteException if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite findByPrimaryKey(long favoriteId)
		throws NoSuchFavoriteException {

		return findByPrimaryKey((Serializable)favoriteId);
	}

	/**
	 * Returns the favorite with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param favoriteId the primary key of the favorite
	 * @return the favorite, or <code>null</code> if a favorite with the primary key could not be found
	 */
	@Override
	public Favorite fetchByPrimaryKey(long favoriteId) {
		return fetchByPrimaryKey((Serializable)favoriteId);
	}

	/**
	 * Returns all the favorites.
	 *
	 * @return the favorites
	 */
	@Override
	public List<Favorite> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @return the range of favorites
	 */
	@Override
	public List<Favorite> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of favorites
	 */
	@Override
	public List<Favorite> findAll(
		int start, int end, OrderByComparator<Favorite> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the favorites.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FavoriteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of favorites
	 * @param end the upper bound of the range of favorites (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of favorites
	 */
	@Override
	public List<Favorite> findAll(
		int start, int end, OrderByComparator<Favorite> orderByComparator,
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

		List<Favorite> list = null;

		if (useFinderCache) {
			list = (List<Favorite>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FAVORITE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FAVORITE;

				sql = sql.concat(FavoriteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Favorite>)QueryUtil.list(
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
	 * Removes all the favorites from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Favorite favorite : findAll()) {
			remove(favorite);
		}
	}

	/**
	 * Returns the number of favorites.
	 *
	 * @return the number of favorites
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FAVORITE);

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
		return "favoriteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FAVORITE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FavoriteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the favorite persistence.
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

		_finderPathFetchByAllAttributes = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAllAttributes",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			new String[] {"publikUserId", "title", "typeId", "entityId"}, true);

		_finderPathCountByAllAttributes = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAllAttributes",
			new String[] {
				String.class.getName(), String.class.getName(),
				Long.class.getName(), Long.class.getName()
			},
			new String[] {"publikUserId", "title", "typeId", "entityId"},
			false);

		_finderPathWithPaginationFindByEntityIdAndTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEntityIdAndTypeId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"entityId", "typeId"}, true);

		_finderPathWithoutPaginationFindByEntityIdAndTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEntityIdAndTypeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"entityId", "typeId"}, true);

		_finderPathCountByEntityIdAndTypeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEntityIdAndTypeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"entityId", "typeId"}, false);

		_finderPathWithPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTypeIdAndEntityIdAndPublikUserIdAndContent",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"typeId", "entityId", "publikUserId", "content"},
				true);

		_finderPathWithoutPaginationFindByTypeIdAndEntityIdAndPublikUserIdAndContent =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTypeIdAndEntityIdAndPublikUserIdAndContent",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), String.class.getName()
				},
				new String[] {"typeId", "entityId", "publikUserId", "content"},
				true);

		_finderPathCountByTypeIdAndEntityIdAndPublikUserIdAndContent =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTypeIdAndEntityIdAndPublikUserIdAndContent",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					String.class.getName(), String.class.getName()
				},
				new String[] {"typeId", "entityId", "publikUserId", "content"},
				false);

		_setFavoriteUtilPersistence(this);
	}

	public void destroy() {
		_setFavoriteUtilPersistence(null);

		entityCache.removeCache(FavoriteImpl.class.getName());
	}

	private void _setFavoriteUtilPersistence(
		FavoritePersistence favoritePersistence) {

		try {
			Field field = FavoriteUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, favoritePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FAVORITE =
		"SELECT favorite FROM Favorite favorite";

	private static final String _SQL_SELECT_FAVORITE_WHERE =
		"SELECT favorite FROM Favorite favorite WHERE ";

	private static final String _SQL_COUNT_FAVORITE =
		"SELECT COUNT(favorite) FROM Favorite favorite";

	private static final String _SQL_COUNT_FAVORITE_WHERE =
		"SELECT COUNT(favorite) FROM Favorite favorite WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "favorite.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Favorite exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Favorite exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FavoritePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}