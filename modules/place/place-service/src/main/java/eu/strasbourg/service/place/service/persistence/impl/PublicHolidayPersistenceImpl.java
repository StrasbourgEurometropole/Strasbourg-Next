/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.place.exception.NoSuchPublicHolidayException;
import eu.strasbourg.service.place.model.PublicHoliday;
import eu.strasbourg.service.place.model.PublicHolidayTable;
import eu.strasbourg.service.place.model.impl.PublicHolidayImpl;
import eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl;
import eu.strasbourg.service.place.service.persistence.PublicHolidayPersistence;
import eu.strasbourg.service.place.service.persistence.PublicHolidayUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the public holiday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PublicHolidayPersistenceImpl
	extends BasePersistenceImpl<PublicHoliday>
	implements PublicHolidayPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PublicHolidayUtil</code> to access the public holiday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PublicHolidayImpl.class.getName();

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
	 * Returns all the public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator,
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

		List<PublicHoliday> list = null;

		if (useFinderCache) {
			list = (List<PublicHoliday>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PublicHoliday publicHoliday : list) {
					if (!uuid.equals(publicHoliday.getUuid())) {
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

			sb.append(_SQL_SELECT_PUBLICHOLIDAY_WHERE);

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
				sb.append(PublicHolidayModelImpl.ORDER_BY_JPQL);
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

				list = (List<PublicHoliday>)QueryUtil.list(
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
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday findByUuid_First(
			String uuid, OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = fetchByUuid_First(
			uuid, orderByComparator);

		if (publicHoliday != null) {
			return publicHoliday;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPublicHolidayException(sb.toString());
	}

	/**
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday fetchByUuid_First(
		String uuid, OrderByComparator<PublicHoliday> orderByComparator) {

		List<PublicHoliday> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday findByUuid_Last(
			String uuid, OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = fetchByUuid_Last(uuid, orderByComparator);

		if (publicHoliday != null) {
			return publicHoliday;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPublicHolidayException(sb.toString());
	}

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday fetchByUuid_Last(
		String uuid, OrderByComparator<PublicHoliday> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PublicHoliday> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday[] findByUuid_PrevAndNext(
			long publicHolidayId, String uuid,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		uuid = Objects.toString(uuid, "");

		PublicHoliday publicHoliday = findByPrimaryKey(publicHolidayId);

		Session session = null;

		try {
			session = openSession();

			PublicHoliday[] array = new PublicHolidayImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, publicHoliday, uuid, orderByComparator, true);

			array[1] = publicHoliday;

			array[2] = getByUuid_PrevAndNext(
				session, publicHoliday, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublicHoliday getByUuid_PrevAndNext(
		Session session, PublicHoliday publicHoliday, String uuid,
		OrderByComparator<PublicHoliday> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PUBLICHOLIDAY_WHERE);

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
			sb.append(PublicHolidayModelImpl.ORDER_BY_JPQL);
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
						publicHoliday)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PublicHoliday> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the public holidays where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PublicHoliday publicHoliday :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(publicHoliday);
		}
	}

	/**
	 * Returns the number of public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching public holidays
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PUBLICHOLIDAY_WHERE);

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
		"publicHoliday.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(publicHoliday.uuid IS NULL OR publicHoliday.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByRecurrent;
	private FinderPath _finderPathWithoutPaginationFindByRecurrent;
	private FinderPath _finderPathCountByRecurrent;

	/**
	 * Returns all the public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByRecurrent(boolean recurrent) {
		return findByRecurrent(
			recurrent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end) {

		return findByRecurrent(recurrent, start, end, null);
	}

	/**
	 * Returns an ordered range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return findByRecurrent(recurrent, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching public holidays
	 */
	@Override
	public List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRecurrent;
				finderArgs = new Object[] {recurrent};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRecurrent;
			finderArgs = new Object[] {
				recurrent, start, end, orderByComparator
			};
		}

		List<PublicHoliday> list = null;

		if (useFinderCache) {
			list = (List<PublicHoliday>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PublicHoliday publicHoliday : list) {
					if (recurrent != publicHoliday.isRecurrent()) {
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

			sb.append(_SQL_SELECT_PUBLICHOLIDAY_WHERE);

			sb.append(_FINDER_COLUMN_RECURRENT_RECURRENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PublicHolidayModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recurrent);

				list = (List<PublicHoliday>)QueryUtil.list(
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
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday findByRecurrent_First(
			boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = fetchByRecurrent_First(
			recurrent, orderByComparator);

		if (publicHoliday != null) {
			return publicHoliday;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recurrent=");
		sb.append(recurrent);

		sb.append("}");

		throw new NoSuchPublicHolidayException(sb.toString());
	}

	/**
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday fetchByRecurrent_First(
		boolean recurrent, OrderByComparator<PublicHoliday> orderByComparator) {

		List<PublicHoliday> list = findByRecurrent(
			recurrent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday findByRecurrent_Last(
			boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = fetchByRecurrent_Last(
			recurrent, orderByComparator);

		if (publicHoliday != null) {
			return publicHoliday;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("recurrent=");
		sb.append(recurrent);

		sb.append("}");

		throw new NoSuchPublicHolidayException(sb.toString());
	}

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	@Override
	public PublicHoliday fetchByRecurrent_Last(
		boolean recurrent, OrderByComparator<PublicHoliday> orderByComparator) {

		int count = countByRecurrent(recurrent);

		if (count == 0) {
			return null;
		}

		List<PublicHoliday> list = findByRecurrent(
			recurrent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday[] findByRecurrent_PrevAndNext(
			long publicHolidayId, boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = findByPrimaryKey(publicHolidayId);

		Session session = null;

		try {
			session = openSession();

			PublicHoliday[] array = new PublicHolidayImpl[3];

			array[0] = getByRecurrent_PrevAndNext(
				session, publicHoliday, recurrent, orderByComparator, true);

			array[1] = publicHoliday;

			array[2] = getByRecurrent_PrevAndNext(
				session, publicHoliday, recurrent, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PublicHoliday getByRecurrent_PrevAndNext(
		Session session, PublicHoliday publicHoliday, boolean recurrent,
		OrderByComparator<PublicHoliday> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PUBLICHOLIDAY_WHERE);

		sb.append(_FINDER_COLUMN_RECURRENT_RECURRENT_2);

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
			sb.append(PublicHolidayModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(recurrent);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						publicHoliday)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PublicHoliday> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the public holidays where recurrent = &#63; from the database.
	 *
	 * @param recurrent the recurrent
	 */
	@Override
	public void removeByRecurrent(boolean recurrent) {
		for (PublicHoliday publicHoliday :
				findByRecurrent(
					recurrent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(publicHoliday);
		}
	}

	/**
	 * Returns the number of public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the number of matching public holidays
	 */
	@Override
	public int countByRecurrent(boolean recurrent) {
		FinderPath finderPath = _finderPathCountByRecurrent;

		Object[] finderArgs = new Object[] {recurrent};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PUBLICHOLIDAY_WHERE);

			sb.append(_FINDER_COLUMN_RECURRENT_RECURRENT_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(recurrent);

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

	private static final String _FINDER_COLUMN_RECURRENT_RECURRENT_2 =
		"publicHoliday.recurrent = ?";

	public PublicHolidayPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("date", "date_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PublicHoliday.class);

		setModelImplClass(PublicHolidayImpl.class);
		setModelPKClass(long.class);

		setTable(PublicHolidayTable.INSTANCE);
	}

	/**
	 * Caches the public holiday in the entity cache if it is enabled.
	 *
	 * @param publicHoliday the public holiday
	 */
	@Override
	public void cacheResult(PublicHoliday publicHoliday) {
		entityCache.putResult(
			PublicHolidayImpl.class, publicHoliday.getPrimaryKey(),
			publicHoliday);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the public holidays in the entity cache if it is enabled.
	 *
	 * @param publicHolidays the public holidays
	 */
	@Override
	public void cacheResult(List<PublicHoliday> publicHolidays) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (publicHolidays.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PublicHoliday publicHoliday : publicHolidays) {
			if (entityCache.getResult(
					PublicHolidayImpl.class, publicHoliday.getPrimaryKey()) ==
						null) {

				cacheResult(publicHoliday);
			}
		}
	}

	/**
	 * Clears the cache for all public holidays.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PublicHolidayImpl.class);

		finderCache.clearCache(PublicHolidayImpl.class);
	}

	/**
	 * Clears the cache for the public holiday.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PublicHoliday publicHoliday) {
		entityCache.removeResult(PublicHolidayImpl.class, publicHoliday);
	}

	@Override
	public void clearCache(List<PublicHoliday> publicHolidays) {
		for (PublicHoliday publicHoliday : publicHolidays) {
			entityCache.removeResult(PublicHolidayImpl.class, publicHoliday);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PublicHolidayImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PublicHolidayImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new public holiday with the primary key. Does not add the public holiday to the database.
	 *
	 * @param publicHolidayId the primary key for the new public holiday
	 * @return the new public holiday
	 */
	@Override
	public PublicHoliday create(long publicHolidayId) {
		PublicHoliday publicHoliday = new PublicHolidayImpl();

		publicHoliday.setNew(true);
		publicHoliday.setPrimaryKey(publicHolidayId);

		String uuid = PortalUUIDUtil.generate();

		publicHoliday.setUuid(uuid);

		return publicHoliday;
	}

	/**
	 * Removes the public holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday that was removed
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday remove(long publicHolidayId)
		throws NoSuchPublicHolidayException {

		return remove((Serializable)publicHolidayId);
	}

	/**
	 * Removes the public holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the public holiday
	 * @return the public holiday that was removed
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday remove(Serializable primaryKey)
		throws NoSuchPublicHolidayException {

		Session session = null;

		try {
			session = openSession();

			PublicHoliday publicHoliday = (PublicHoliday)session.get(
				PublicHolidayImpl.class, primaryKey);

			if (publicHoliday == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublicHolidayException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(publicHoliday);
		}
		catch (NoSuchPublicHolidayException noSuchEntityException) {
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
	protected PublicHoliday removeImpl(PublicHoliday publicHoliday) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publicHoliday)) {
				publicHoliday = (PublicHoliday)session.get(
					PublicHolidayImpl.class, publicHoliday.getPrimaryKeyObj());
			}

			if (publicHoliday != null) {
				session.delete(publicHoliday);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (publicHoliday != null) {
			clearCache(publicHoliday);
		}

		return publicHoliday;
	}

	@Override
	public PublicHoliday updateImpl(PublicHoliday publicHoliday) {
		boolean isNew = publicHoliday.isNew();

		if (!(publicHoliday instanceof PublicHolidayModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(publicHoliday.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					publicHoliday);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in publicHoliday proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PublicHoliday implementation " +
					publicHoliday.getClass());
		}

		PublicHolidayModelImpl publicHolidayModelImpl =
			(PublicHolidayModelImpl)publicHoliday;

		if (Validator.isNull(publicHoliday.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			publicHoliday.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(publicHoliday);
			}
			else {
				publicHoliday = (PublicHoliday)session.merge(publicHoliday);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PublicHolidayImpl.class, publicHolidayModelImpl, false, true);

		if (isNew) {
			publicHoliday.setNew(false);
		}

		publicHoliday.resetOriginalValues();

		return publicHoliday;
	}

	/**
	 * Returns the public holiday with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the public holiday
	 * @return the public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublicHolidayException {

		PublicHoliday publicHoliday = fetchByPrimaryKey(primaryKey);

		if (publicHoliday == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublicHolidayException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return publicHoliday;
	}

	/**
	 * Returns the public holiday with the primary key or throws a <code>NoSuchPublicHolidayException</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday findByPrimaryKey(long publicHolidayId)
		throws NoSuchPublicHolidayException {

		return findByPrimaryKey((Serializable)publicHolidayId);
	}

	/**
	 * Returns the public holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday, or <code>null</code> if a public holiday with the primary key could not be found
	 */
	@Override
	public PublicHoliday fetchByPrimaryKey(long publicHolidayId) {
		return fetchByPrimaryKey((Serializable)publicHolidayId);
	}

	/**
	 * Returns all the public holidays.
	 *
	 * @return the public holidays
	 */
	@Override
	public List<PublicHoliday> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of public holidays
	 */
	@Override
	public List<PublicHoliday> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of public holidays
	 */
	@Override
	public List<PublicHoliday> findAll(
		int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of public holidays
	 */
	@Override
	public List<PublicHoliday> findAll(
		int start, int end, OrderByComparator<PublicHoliday> orderByComparator,
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

		List<PublicHoliday> list = null;

		if (useFinderCache) {
			list = (List<PublicHoliday>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PUBLICHOLIDAY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLICHOLIDAY;

				sql = sql.concat(PublicHolidayModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PublicHoliday>)QueryUtil.list(
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
	 * Removes all the public holidays from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PublicHoliday publicHoliday : findAll()) {
			remove(publicHoliday);
		}
	}

	/**
	 * Returns the number of public holidays.
	 *
	 * @return the number of public holidays
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PUBLICHOLIDAY);

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
		return "publicHolidayId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PUBLICHOLIDAY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PublicHolidayModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the public holiday persistence.
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

		_finderPathWithPaginationFindByRecurrent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRecurrent",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"recurrent"}, true);

		_finderPathWithoutPaginationFindByRecurrent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRecurrent",
			new String[] {Boolean.class.getName()}, new String[] {"recurrent"},
			true);

		_finderPathCountByRecurrent = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRecurrent",
			new String[] {Boolean.class.getName()}, new String[] {"recurrent"},
			false);

		PublicHolidayUtil.setPersistence(this);
	}

	public void destroy() {
		PublicHolidayUtil.setPersistence(null);

		entityCache.removeCache(PublicHolidayImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PUBLICHOLIDAY =
		"SELECT publicHoliday FROM PublicHoliday publicHoliday";

	private static final String _SQL_SELECT_PUBLICHOLIDAY_WHERE =
		"SELECT publicHoliday FROM PublicHoliday publicHoliday WHERE ";

	private static final String _SQL_COUNT_PUBLICHOLIDAY =
		"SELECT COUNT(publicHoliday) FROM PublicHoliday publicHoliday";

	private static final String _SQL_COUNT_PUBLICHOLIDAY_WHERE =
		"SELECT COUNT(publicHoliday) FROM PublicHoliday publicHoliday WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "publicHoliday.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PublicHoliday exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PublicHoliday exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PublicHolidayPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "date"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}