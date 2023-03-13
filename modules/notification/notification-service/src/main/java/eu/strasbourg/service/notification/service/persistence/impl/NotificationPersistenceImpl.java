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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notification.exception.NoSuchNotificationException;
import eu.strasbourg.service.notification.model.Notification;
import eu.strasbourg.service.notification.model.NotificationTable;
import eu.strasbourg.service.notification.model.impl.NotificationImpl;
import eu.strasbourg.service.notification.model.impl.NotificationModelImpl;
import eu.strasbourg.service.notification.service.persistence.NotificationPersistence;
import eu.strasbourg.service.notification.service.persistence.NotificationUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the notification service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class NotificationPersistenceImpl
	extends BasePersistenceImpl<Notification>
	implements NotificationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NotificationUtil</code> to access the notification persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NotificationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPublicationDateAndStatus;
	private FinderPath _finderPathWithPaginationCountByPublicationDateAndStatus;

	/**
	 * Returns all the notifications where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching notifications
	 */
	@Override
	public List<Notification> findByPublicationDateAndStatus(
		Date publicationDate, int status) {

		return findByPublicationDateAndStatus(
			publicationDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notifications where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	@Override
	public List<Notification> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end) {

		return findByPublicationDateAndStatus(
			publicationDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifications where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	@Override
	public List<Notification> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return findByPublicationDateAndStatus(
			publicationDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notifications where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	@Override
	public List<Notification> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByPublicationDateAndStatus;
		finderArgs = new Object[] {
			_getTime(publicationDate), status, start, end, orderByComparator
		};

		List<Notification> list = null;

		if (useFinderCache) {
			list = (List<Notification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Notification notification : list) {
					if ((publicationDate.getTime() <=
							notification.getPublicationDate(
							).getTime()) ||
						(status != notification.getStatus())) {

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

			sb.append(_SQL_SELECT_NOTIFICATION_WHERE);

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
				sb.append(NotificationModelImpl.ORDER_BY_JPQL);
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

				list = (List<Notification>)QueryUtil.list(
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
	 * Returns the first notification in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = fetchByPublicationDateAndStatus_First(
			publicationDate, status, orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publicationDate<");
		sb.append(publicationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationException(sb.toString());
	}

	/**
	 * Returns the first notification in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		OrderByComparator<Notification> orderByComparator) {

		List<Notification> list = findByPublicationDateAndStatus(
			publicationDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = fetchByPublicationDateAndStatus_Last(
			publicationDate, status, orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publicationDate<");
		sb.append(publicationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationException(sb.toString());
	}

	/**
	 * Returns the last notification in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		OrderByComparator<Notification> orderByComparator) {

		int count = countByPublicationDateAndStatus(publicationDate, status);

		if (count == 0) {
			return null;
		}

		List<Notification> list = findByPublicationDateAndStatus(
			publicationDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification[] findByPublicationDateAndStatus_PrevAndNext(
			long notificationId, Date publicationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			Notification[] array = new NotificationImpl[3];

			array[0] = getByPublicationDateAndStatus_PrevAndNext(
				session, notification, publicationDate, status,
				orderByComparator, true);

			array[1] = notification;

			array[2] = getByPublicationDateAndStatus_PrevAndNext(
				session, notification, publicationDate, status,
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

	protected Notification getByPublicationDateAndStatus_PrevAndNext(
		Session session, Notification notification, Date publicationDate,
		int status, OrderByComparator<Notification> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATION_WHERE);

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
			sb.append(NotificationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(notification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Notification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifications where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	@Override
	public void removeByPublicationDateAndStatus(
		Date publicationDate, int status) {

		for (Notification notification :
				findByPublicationDateAndStatus(
					publicationDate, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(notification);
		}
	}

	/**
	 * Returns the number of notifications where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching notifications
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

			sb.append(_SQL_COUNT_NOTIFICATION_WHERE);

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
			"notification.publicationDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_PUBLICATIONDATE_2 =
			"notification.publicationDate < ? AND ";

	private static final String
		_FINDER_COLUMN_PUBLICATIONDATEANDSTATUS_STATUS_2 =
			"notification.status = ?";

	private FinderPath _finderPathWithPaginationFindByExpirationDateAndStatus;
	private FinderPath _finderPathWithPaginationCountByExpirationDateAndStatus;

	/**
	 * Returns all the notifications where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the matching notifications
	 */
	@Override
	public List<Notification> findByExpirationDateAndStatus(
		Date expirationDate, int status) {

		return findByExpirationDateAndStatus(
			expirationDate, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifications where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of matching notifications
	 */
	@Override
	public List<Notification> findByExpirationDateAndStatus(
		Date expirationDate, int status, int start, int end) {

		return findByExpirationDateAndStatus(
			expirationDate, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifications where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notifications
	 */
	@Override
	public List<Notification> findByExpirationDateAndStatus(
		Date expirationDate, int status, int start, int end,
		OrderByComparator<Notification> orderByComparator) {

		return findByExpirationDateAndStatus(
			expirationDate, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notifications where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notifications
	 */
	@Override
	public List<Notification> findByExpirationDateAndStatus(
		Date expirationDate, int status, int start, int end,
		OrderByComparator<Notification> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByExpirationDateAndStatus;
		finderArgs = new Object[] {
			_getTime(expirationDate), status, start, end, orderByComparator
		};

		List<Notification> list = null;

		if (useFinderCache) {
			list = (List<Notification>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Notification notification : list) {
					if ((expirationDate.getTime() <=
							notification.getExpirationDate(
							).getTime()) ||
						(status != notification.getStatus())) {

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

			sb.append(_SQL_SELECT_NOTIFICATION_WHERE);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				sb.append(
					_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				sb.append(
					_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NotificationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExpirationDate) {
					queryPos.add(new Timestamp(expirationDate.getTime()));
				}

				queryPos.add(status);

				list = (List<Notification>)QueryUtil.list(
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
	 * Returns the first notification in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByExpirationDateAndStatus_First(
			Date expirationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = fetchByExpirationDateAndStatus_First(
			expirationDate, status, orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expirationDate<");
		sb.append(expirationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationException(sb.toString());
	}

	/**
	 * Returns the first notification in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByExpirationDateAndStatus_First(
		Date expirationDate, int status,
		OrderByComparator<Notification> orderByComparator) {

		List<Notification> list = findByExpirationDateAndStatus(
			expirationDate, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last notification in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification
	 * @throws NoSuchNotificationException if a matching notification could not be found
	 */
	@Override
	public Notification findByExpirationDateAndStatus_Last(
			Date expirationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = fetchByExpirationDateAndStatus_Last(
			expirationDate, status, orderByComparator);

		if (notification != null) {
			return notification;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expirationDate<");
		sb.append(expirationDate);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchNotificationException(sb.toString());
	}

	/**
	 * Returns the last notification in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching notification, or <code>null</code> if a matching notification could not be found
	 */
	@Override
	public Notification fetchByExpirationDateAndStatus_Last(
		Date expirationDate, int status,
		OrderByComparator<Notification> orderByComparator) {

		int count = countByExpirationDateAndStatus(expirationDate, status);

		if (count == 0) {
			return null;
		}

		List<Notification> list = findByExpirationDateAndStatus(
			expirationDate, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notifications before and after the current notification in the ordered set where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param notificationId the primary key of the current notification
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification[] findByExpirationDateAndStatus_PrevAndNext(
			long notificationId, Date expirationDate, int status,
			OrderByComparator<Notification> orderByComparator)
		throws NoSuchNotificationException {

		Notification notification = findByPrimaryKey(notificationId);

		Session session = null;

		try {
			session = openSession();

			Notification[] array = new NotificationImpl[3];

			array[0] = getByExpirationDateAndStatus_PrevAndNext(
				session, notification, expirationDate, status,
				orderByComparator, true);

			array[1] = notification;

			array[2] = getByExpirationDateAndStatus_PrevAndNext(
				session, notification, expirationDate, status,
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

	protected Notification getByExpirationDateAndStatus_PrevAndNext(
		Session session, Notification notification, Date expirationDate,
		int status, OrderByComparator<Notification> orderByComparator,
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

		sb.append(_SQL_SELECT_NOTIFICATION_WHERE);

		boolean bindExpirationDate = false;

		if (expirationDate == null) {
			sb.append(_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_1);
		}
		else {
			bindExpirationDate = true;

			sb.append(_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_2);
		}

		sb.append(_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_STATUS_2);

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
			sb.append(NotificationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindExpirationDate) {
			queryPos.add(new Timestamp(expirationDate.getTime()));
		}

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(notification)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Notification> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notifications where expirationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 */
	@Override
	public void removeByExpirationDateAndStatus(
		Date expirationDate, int status) {

		for (Notification notification :
				findByExpirationDateAndStatus(
					expirationDate, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(notification);
		}
	}

	/**
	 * Returns the number of notifications where expirationDate &lt; &#63; and status = &#63;.
	 *
	 * @param expirationDate the expiration date
	 * @param status the status
	 * @return the number of matching notifications
	 */
	@Override
	public int countByExpirationDateAndStatus(Date expirationDate, int status) {
		FinderPath finderPath =
			_finderPathWithPaginationCountByExpirationDateAndStatus;

		Object[] finderArgs = new Object[] {_getTime(expirationDate), status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTIFICATION_WHERE);

			boolean bindExpirationDate = false;

			if (expirationDate == null) {
				sb.append(
					_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_1);
			}
			else {
				bindExpirationDate = true;

				sb.append(
					_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_2);
			}

			sb.append(_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindExpirationDate) {
					queryPos.add(new Timestamp(expirationDate.getTime()));
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
		_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_1 =
			"notification.expirationDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_EXPIRATIONDATE_2 =
			"notification.expirationDate < ? AND ";

	private static final String
		_FINDER_COLUMN_EXPIRATIONDATEANDSTATUS_STATUS_2 =
			"notification.status = ?";

	public NotificationPersistenceImpl() {
		setModelClass(Notification.class);

		setModelImplClass(NotificationImpl.class);
		setModelPKClass(long.class);

		setTable(NotificationTable.INSTANCE);
	}

	/**
	 * Caches the notification in the entity cache if it is enabled.
	 *
	 * @param notification the notification
	 */
	@Override
	public void cacheResult(Notification notification) {
		entityCache.putResult(
			NotificationImpl.class, notification.getPrimaryKey(), notification);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the notifications in the entity cache if it is enabled.
	 *
	 * @param notifications the notifications
	 */
	@Override
	public void cacheResult(List<Notification> notifications) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (notifications.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Notification notification : notifications) {
			if (entityCache.getResult(
					NotificationImpl.class, notification.getPrimaryKey()) ==
						null) {

				cacheResult(notification);
			}
		}
	}

	/**
	 * Clears the cache for all notifications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NotificationImpl.class);

		finderCache.clearCache(NotificationImpl.class);
	}

	/**
	 * Clears the cache for the notification.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Notification notification) {
		entityCache.removeResult(NotificationImpl.class, notification);
	}

	@Override
	public void clearCache(List<Notification> notifications) {
		for (Notification notification : notifications) {
			entityCache.removeResult(NotificationImpl.class, notification);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NotificationImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NotificationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new notification with the primary key. Does not add the notification to the database.
	 *
	 * @param notificationId the primary key for the new notification
	 * @return the new notification
	 */
	@Override
	public Notification create(long notificationId) {
		Notification notification = new NotificationImpl();

		notification.setNew(true);
		notification.setPrimaryKey(notificationId);

		return notification;
	}

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification remove(long notificationId)
		throws NoSuchNotificationException {

		return remove((Serializable)notificationId);
	}

	/**
	 * Removes the notification with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the notification
	 * @return the notification that was removed
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification remove(Serializable primaryKey)
		throws NoSuchNotificationException {

		Session session = null;

		try {
			session = openSession();

			Notification notification = (Notification)session.get(
				NotificationImpl.class, primaryKey);

			if (notification == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNotificationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(notification);
		}
		catch (NoSuchNotificationException noSuchEntityException) {
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
	protected Notification removeImpl(Notification notification) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(notification)) {
				notification = (Notification)session.get(
					NotificationImpl.class, notification.getPrimaryKeyObj());
			}

			if (notification != null) {
				session.delete(notification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (notification != null) {
			clearCache(notification);
		}

		return notification;
	}

	@Override
	public Notification updateImpl(Notification notification) {
		boolean isNew = notification.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(notification);
			}
			else {
				notification = (Notification)session.merge(notification);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NotificationImpl.class, notification, false, true);

		if (isNew) {
			notification.setNew(false);
		}

		notification.resetOriginalValues();

		return notification;
	}

	/**
	 * Returns the notification with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNotificationException {

		Notification notification = fetchByPrimaryKey(primaryKey);

		if (notification == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNotificationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return notification;
	}

	/**
	 * Returns the notification with the primary key or throws a <code>NoSuchNotificationException</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification
	 * @throws NoSuchNotificationException if a notification with the primary key could not be found
	 */
	@Override
	public Notification findByPrimaryKey(long notificationId)
		throws NoSuchNotificationException {

		return findByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns the notification with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param notificationId the primary key of the notification
	 * @return the notification, or <code>null</code> if a notification with the primary key could not be found
	 */
	@Override
	public Notification fetchByPrimaryKey(long notificationId) {
		return fetchByPrimaryKey((Serializable)notificationId);
	}

	/**
	 * Returns all the notifications.
	 *
	 * @return the notifications
	 */
	@Override
	public List<Notification> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @return the range of notifications
	 */
	@Override
	public List<Notification> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notifications
	 */
	@Override
	public List<Notification> findAll(
		int start, int end, OrderByComparator<Notification> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notifications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NotificationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notifications
	 * @param end the upper bound of the range of notifications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notifications
	 */
	@Override
	public List<Notification> findAll(
		int start, int end, OrderByComparator<Notification> orderByComparator,
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

		List<Notification> list = null;

		if (useFinderCache) {
			list = (List<Notification>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NOTIFICATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NOTIFICATION;

				sql = sql.concat(NotificationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Notification>)QueryUtil.list(
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
	 * Removes all the notifications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Notification notification : findAll()) {
			remove(notification);
		}
	}

	/**
	 * Returns the number of notifications.
	 *
	 * @return the number of notifications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NOTIFICATION);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "notificationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTIFICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NotificationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the notification persistence.
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

		_finderPathWithPaginationFindByExpirationDateAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByExpirationDateAndStatus",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"expirationDate", "status"}, true);

		_finderPathWithPaginationCountByExpirationDateAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByExpirationDateAndStatus",
				new String[] {Date.class.getName(), Integer.class.getName()},
				new String[] {"expirationDate", "status"}, false);

		_setNotificationUtilPersistence(this);
	}

	public void destroy() {
		_setNotificationUtilPersistence(null);

		entityCache.removeCache(NotificationImpl.class.getName());
	}

	private void _setNotificationUtilPersistence(
		NotificationPersistence notificationPersistence) {

		try {
			Field field = NotificationUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, notificationPersistence);
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

	private static final String _SQL_SELECT_NOTIFICATION =
		"SELECT notification FROM Notification notification";

	private static final String _SQL_SELECT_NOTIFICATION_WHERE =
		"SELECT notification FROM Notification notification WHERE ";

	private static final String _SQL_COUNT_NOTIFICATION =
		"SELECT COUNT(notification) FROM Notification notification";

	private static final String _SQL_COUNT_NOTIFICATION_WHERE =
		"SELECT COUNT(notification) FROM Notification notification WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "notification.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Notification exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Notification exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NotificationPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}