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

package eu.strasbourg.service.notification.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notification.exception.NoSuchUserNotificationChannelException;
import eu.strasbourg.service.notification.model.UserNotificationChannel;
import eu.strasbourg.service.notification.model.UserNotificationChannelTable;
import eu.strasbourg.service.notification.model.impl.UserNotificationChannelImpl;
import eu.strasbourg.service.notification.model.impl.UserNotificationChannelModelImpl;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPK;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPersistence;
import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the user notification channel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class UserNotificationChannelPersistenceImpl
	extends BasePersistenceImpl<UserNotificationChannel>
	implements UserNotificationChannelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserNotificationChannelUtil</code> to access the user notification channel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserNotificationChannelImpl.class.getName();

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
	 * Returns all the user notification channels where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByPublikUserId(
		String publikUserId) {

		return findByPublikUserId(
			publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end) {

		return findByPublikUserId(publikUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		return findByPublikUserId(
			publikUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user notification channels where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator,
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

		List<UserNotificationChannel> list = null;

		if (useFinderCache) {
			list = (List<UserNotificationChannel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserNotificationChannel userNotificationChannel : list) {
					if (!publikUserId.equals(
							userNotificationChannel.getPublikUserId())) {

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

			sb.append(_SQL_SELECT_USERNOTIFICATIONCHANNEL_WHERE);

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
				sb.append(UserNotificationChannelModelImpl.ORDER_BY_JPQL);
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

				list = (List<UserNotificationChannel>)QueryUtil.list(
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
	 * Returns the first user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel findByPublikUserId_First(
			String publikUserId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel =
			fetchByPublikUserId_First(publikUserId, orderByComparator);

		if (userNotificationChannel != null) {
			return userNotificationChannel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchUserNotificationChannelException(sb.toString());
	}

	/**
	 * Returns the first user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel fetchByPublikUserId_First(
		String publikUserId,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		List<UserNotificationChannel> list = findByPublikUserId(
			publikUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel findByPublikUserId_Last(
			String publikUserId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel =
			fetchByPublikUserId_Last(publikUserId, orderByComparator);

		if (userNotificationChannel != null) {
			return userNotificationChannel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikUserId=");
		sb.append(publikUserId);

		sb.append("}");

		throw new NoSuchUserNotificationChannelException(sb.toString());
	}

	/**
	 * Returns the last user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel fetchByPublikUserId_Last(
		String publikUserId,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		int count = countByPublikUserId(publikUserId);

		if (count == 0) {
			return null;
		}

		List<UserNotificationChannel> list = findByPublikUserId(
			publikUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user notification channels before and after the current user notification channel in the ordered set where publikUserId = &#63;.
	 *
	 * @param userNotificationChannelPK the primary key of the current user notification channel
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel[] findByPublikUserId_PrevAndNext(
			UserNotificationChannelPK userNotificationChannelPK,
			String publikUserId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		publikUserId = Objects.toString(publikUserId, "");

		UserNotificationChannel userNotificationChannel = findByPrimaryKey(
			userNotificationChannelPK);

		Session session = null;

		try {
			session = openSession();

			UserNotificationChannel[] array =
				new UserNotificationChannelImpl[3];

			array[0] = getByPublikUserId_PrevAndNext(
				session, userNotificationChannel, publikUserId,
				orderByComparator, true);

			array[1] = userNotificationChannel;

			array[2] = getByPublikUserId_PrevAndNext(
				session, userNotificationChannel, publikUserId,
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

	protected UserNotificationChannel getByPublikUserId_PrevAndNext(
		Session session, UserNotificationChannel userNotificationChannel,
		String publikUserId,
		OrderByComparator<UserNotificationChannel> orderByComparator,
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

		sb.append(_SQL_SELECT_USERNOTIFICATIONCHANNEL_WHERE);

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
			sb.append(UserNotificationChannelModelImpl.ORDER_BY_JPQL);
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
						userNotificationChannel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserNotificationChannel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user notification channels where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	@Override
	public void removeByPublikUserId(String publikUserId) {
		for (UserNotificationChannel userNotificationChannel :
				findByPublikUserId(
					publikUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userNotificationChannel);
		}
	}

	/**
	 * Returns the number of user notification channels where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching user notification channels
	 */
	@Override
	public int countByPublikUserId(String publikUserId) {
		publikUserId = Objects.toString(publikUserId, "");

		FinderPath finderPath = _finderPathCountByPublikUserId;

		Object[] finderArgs = new Object[] {publikUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERNOTIFICATIONCHANNEL_WHERE);

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
		"userNotificationChannel.id.publikUserId = ?";

	private static final String _FINDER_COLUMN_PUBLIKUSERID_PUBLIKUSERID_3 =
		"(userNotificationChannel.id.publikUserId IS NULL OR userNotificationChannel.id.publikUserId = '')";

	private FinderPath _finderPathWithPaginationFindByChannelId;
	private FinderPath _finderPathWithoutPaginationFindByChannelId;
	private FinderPath _finderPathCountByChannelId;

	/**
	 * Returns all the user notification channels where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByChannelId(long channelId) {
		return findByChannelId(
			channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end) {

		return findByChannelId(channelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		return findByChannelId(channelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user notification channels where channelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param channelId the channel ID
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findByChannelId(
		long channelId, int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByChannelId;
				finderArgs = new Object[] {channelId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByChannelId;
			finderArgs = new Object[] {
				channelId, start, end, orderByComparator
			};
		}

		List<UserNotificationChannel> list = null;

		if (useFinderCache) {
			list = (List<UserNotificationChannel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserNotificationChannel userNotificationChannel : list) {
					if (channelId != userNotificationChannel.getChannelId()) {
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

			sb.append(_SQL_SELECT_USERNOTIFICATIONCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserNotificationChannelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

				list = (List<UserNotificationChannel>)QueryUtil.list(
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
	 * Returns the first user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel findByChannelId_First(
			long channelId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel =
			fetchByChannelId_First(channelId, orderByComparator);

		if (userNotificationChannel != null) {
			return userNotificationChannel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchUserNotificationChannelException(sb.toString());
	}

	/**
	 * Returns the first user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel fetchByChannelId_First(
		long channelId,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		List<UserNotificationChannel> list = findByChannelId(
			channelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel
	 * @throws NoSuchUserNotificationChannelException if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel findByChannelId_Last(
			long channelId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel = fetchByChannelId_Last(
			channelId, orderByComparator);

		if (userNotificationChannel != null) {
			return userNotificationChannel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("channelId=");
		sb.append(channelId);

		sb.append("}");

		throw new NoSuchUserNotificationChannelException(sb.toString());
	}

	/**
	 * Returns the last user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user notification channel, or <code>null</code> if a matching user notification channel could not be found
	 */
	@Override
	public UserNotificationChannel fetchByChannelId_Last(
		long channelId,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		int count = countByChannelId(channelId);

		if (count == 0) {
			return null;
		}

		List<UserNotificationChannel> list = findByChannelId(
			channelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user notification channels before and after the current user notification channel in the ordered set where channelId = &#63;.
	 *
	 * @param userNotificationChannelPK the primary key of the current user notification channel
	 * @param channelId the channel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel[] findByChannelId_PrevAndNext(
			UserNotificationChannelPK userNotificationChannelPK, long channelId,
			OrderByComparator<UserNotificationChannel> orderByComparator)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel = findByPrimaryKey(
			userNotificationChannelPK);

		Session session = null;

		try {
			session = openSession();

			UserNotificationChannel[] array =
				new UserNotificationChannelImpl[3];

			array[0] = getByChannelId_PrevAndNext(
				session, userNotificationChannel, channelId, orderByComparator,
				true);

			array[1] = userNotificationChannel;

			array[2] = getByChannelId_PrevAndNext(
				session, userNotificationChannel, channelId, orderByComparator,
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

	protected UserNotificationChannel getByChannelId_PrevAndNext(
		Session session, UserNotificationChannel userNotificationChannel,
		long channelId,
		OrderByComparator<UserNotificationChannel> orderByComparator,
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

		sb.append(_SQL_SELECT_USERNOTIFICATIONCHANNEL_WHERE);

		sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

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
			sb.append(UserNotificationChannelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(channelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						userNotificationChannel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserNotificationChannel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user notification channels where channelId = &#63; from the database.
	 *
	 * @param channelId the channel ID
	 */
	@Override
	public void removeByChannelId(long channelId) {
		for (UserNotificationChannel userNotificationChannel :
				findByChannelId(
					channelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userNotificationChannel);
		}
	}

	/**
	 * Returns the number of user notification channels where channelId = &#63;.
	 *
	 * @param channelId the channel ID
	 * @return the number of matching user notification channels
	 */
	@Override
	public int countByChannelId(long channelId) {
		FinderPath finderPath = _finderPathCountByChannelId;

		Object[] finderArgs = new Object[] {channelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERNOTIFICATIONCHANNEL_WHERE);

			sb.append(_FINDER_COLUMN_CHANNELID_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(channelId);

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

	private static final String _FINDER_COLUMN_CHANNELID_CHANNELID_2 =
		"userNotificationChannel.id.channelId = ?";

	public UserNotificationChannelPersistenceImpl() {
		setModelClass(UserNotificationChannel.class);

		setModelImplClass(UserNotificationChannelImpl.class);
		setModelPKClass(UserNotificationChannelPK.class);

		setTable(UserNotificationChannelTable.INSTANCE);
	}

	/**
	 * Caches the user notification channel in the entity cache if it is enabled.
	 *
	 * @param userNotificationChannel the user notification channel
	 */
	@Override
	public void cacheResult(UserNotificationChannel userNotificationChannel) {
		entityCache.putResult(
			UserNotificationChannelImpl.class,
			userNotificationChannel.getPrimaryKey(), userNotificationChannel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user notification channels in the entity cache if it is enabled.
	 *
	 * @param userNotificationChannels the user notification channels
	 */
	@Override
	public void cacheResult(
		List<UserNotificationChannel> userNotificationChannels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userNotificationChannels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserNotificationChannel userNotificationChannel :
				userNotificationChannels) {

			if (entityCache.getResult(
					UserNotificationChannelImpl.class,
					userNotificationChannel.getPrimaryKey()) == null) {

				cacheResult(userNotificationChannel);
			}
		}
	}

	/**
	 * Clears the cache for all user notification channels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserNotificationChannelImpl.class);

		finderCache.clearCache(UserNotificationChannelImpl.class);
	}

	/**
	 * Clears the cache for the user notification channel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserNotificationChannel userNotificationChannel) {
		entityCache.removeResult(
			UserNotificationChannelImpl.class, userNotificationChannel);
	}

	@Override
	public void clearCache(
		List<UserNotificationChannel> userNotificationChannels) {

		for (UserNotificationChannel userNotificationChannel :
				userNotificationChannels) {

			entityCache.removeResult(
				UserNotificationChannelImpl.class, userNotificationChannel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserNotificationChannelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				UserNotificationChannelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user notification channel with the primary key. Does not add the user notification channel to the database.
	 *
	 * @param userNotificationChannelPK the primary key for the new user notification channel
	 * @return the new user notification channel
	 */
	@Override
	public UserNotificationChannel create(
		UserNotificationChannelPK userNotificationChannelPK) {

		UserNotificationChannel userNotificationChannel =
			new UserNotificationChannelImpl();

		userNotificationChannel.setNew(true);
		userNotificationChannel.setPrimaryKey(userNotificationChannelPK);

		return userNotificationChannel;
	}

	/**
	 * Removes the user notification channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel that was removed
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel remove(
			UserNotificationChannelPK userNotificationChannelPK)
		throws NoSuchUserNotificationChannelException {

		return remove((Serializable)userNotificationChannelPK);
	}

	/**
	 * Removes the user notification channel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user notification channel
	 * @return the user notification channel that was removed
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel remove(Serializable primaryKey)
		throws NoSuchUserNotificationChannelException {

		Session session = null;

		try {
			session = openSession();

			UserNotificationChannel userNotificationChannel =
				(UserNotificationChannel)session.get(
					UserNotificationChannelImpl.class, primaryKey);

			if (userNotificationChannel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserNotificationChannelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userNotificationChannel);
		}
		catch (NoSuchUserNotificationChannelException noSuchEntityException) {
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
	protected UserNotificationChannel removeImpl(
		UserNotificationChannel userNotificationChannel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userNotificationChannel)) {
				userNotificationChannel = (UserNotificationChannel)session.get(
					UserNotificationChannelImpl.class,
					userNotificationChannel.getPrimaryKeyObj());
			}

			if (userNotificationChannel != null) {
				session.delete(userNotificationChannel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userNotificationChannel != null) {
			clearCache(userNotificationChannel);
		}

		return userNotificationChannel;
	}

	@Override
	public UserNotificationChannel updateImpl(
		UserNotificationChannel userNotificationChannel) {

		boolean isNew = userNotificationChannel.isNew();

		if (!(userNotificationChannel instanceof
				UserNotificationChannelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userNotificationChannel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userNotificationChannel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userNotificationChannel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserNotificationChannel implementation " +
					userNotificationChannel.getClass());
		}

		UserNotificationChannelModelImpl userNotificationChannelModelImpl =
			(UserNotificationChannelModelImpl)userNotificationChannel;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userNotificationChannel);
			}
			else {
				userNotificationChannel =
					(UserNotificationChannel)session.merge(
						userNotificationChannel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserNotificationChannelImpl.class, userNotificationChannelModelImpl,
			false, true);

		if (isNew) {
			userNotificationChannel.setNew(false);
		}

		userNotificationChannel.resetOriginalValues();

		return userNotificationChannel;
	}

	/**
	 * Returns the user notification channel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user notification channel
	 * @return the user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserNotificationChannelException {

		UserNotificationChannel userNotificationChannel = fetchByPrimaryKey(
			primaryKey);

		if (userNotificationChannel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserNotificationChannelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userNotificationChannel;
	}

	/**
	 * Returns the user notification channel with the primary key or throws a <code>NoSuchUserNotificationChannelException</code> if it could not be found.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel
	 * @throws NoSuchUserNotificationChannelException if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel findByPrimaryKey(
			UserNotificationChannelPK userNotificationChannelPK)
		throws NoSuchUserNotificationChannelException {

		return findByPrimaryKey((Serializable)userNotificationChannelPK);
	}

	/**
	 * Returns the user notification channel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userNotificationChannelPK the primary key of the user notification channel
	 * @return the user notification channel, or <code>null</code> if a user notification channel with the primary key could not be found
	 */
	@Override
	public UserNotificationChannel fetchByPrimaryKey(
		UserNotificationChannelPK userNotificationChannelPK) {

		return fetchByPrimaryKey((Serializable)userNotificationChannelPK);
	}

	/**
	 * Returns all the user notification channels.
	 *
	 * @return the user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @return the range of user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findAll(
		int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user notification channels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserNotificationChannelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification channels
	 * @param end the upper bound of the range of user notification channels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user notification channels
	 */
	@Override
	public List<UserNotificationChannel> findAll(
		int start, int end,
		OrderByComparator<UserNotificationChannel> orderByComparator,
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

		List<UserNotificationChannel> list = null;

		if (useFinderCache) {
			list = (List<UserNotificationChannel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERNOTIFICATIONCHANNEL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERNOTIFICATIONCHANNEL;

				sql = sql.concat(
					UserNotificationChannelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserNotificationChannel>)QueryUtil.list(
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
	 * Removes all the user notification channels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserNotificationChannel userNotificationChannel : findAll()) {
			remove(userNotificationChannel);
		}
	}

	/**
	 * Returns the number of user notification channels.
	 *
	 * @return the number of user notification channels
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
					_SQL_COUNT_USERNOTIFICATIONCHANNEL);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userNotificationChannelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERNOTIFICATIONCHANNEL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserNotificationChannelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user notification channel persistence.
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

		_finderPathWithPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByChannelId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"channelId"}, true);

		_finderPathWithoutPaginationFindByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			true);

		_finderPathCountByChannelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByChannelId",
			new String[] {Long.class.getName()}, new String[] {"channelId"},
			false);

		_setUserNotificationChannelUtilPersistence(this);
	}

	public void destroy() {
		_setUserNotificationChannelUtilPersistence(null);

		entityCache.removeCache(UserNotificationChannelImpl.class.getName());
	}

	private void _setUserNotificationChannelUtilPersistence(
		UserNotificationChannelPersistence userNotificationChannelPersistence) {

		try {
			Field field = UserNotificationChannelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, userNotificationChannelPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERNOTIFICATIONCHANNEL =
		"SELECT userNotificationChannel FROM UserNotificationChannel userNotificationChannel";

	private static final String _SQL_SELECT_USERNOTIFICATIONCHANNEL_WHERE =
		"SELECT userNotificationChannel FROM UserNotificationChannel userNotificationChannel WHERE ";

	private static final String _SQL_COUNT_USERNOTIFICATIONCHANNEL =
		"SELECT COUNT(userNotificationChannel) FROM UserNotificationChannel userNotificationChannel";

	private static final String _SQL_COUNT_USERNOTIFICATIONCHANNEL_WHERE =
		"SELECT COUNT(userNotificationChannel) FROM UserNotificationChannel userNotificationChannel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"userNotificationChannel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserNotificationChannel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserNotificationChannel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserNotificationChannelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"publikUserId", "channelId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}