/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence.impl;

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

import eu.strasbourg.service.agenda.exception.NoSuchAgendaExportPeriodException;
import eu.strasbourg.service.agenda.model.AgendaExportPeriod;
import eu.strasbourg.service.agenda.model.AgendaExportPeriodTable;
import eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodImpl;
import eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodModelImpl;
import eu.strasbourg.service.agenda.service.persistence.AgendaExportPeriodPersistence;
import eu.strasbourg.service.agenda.service.persistence.AgendaExportPeriodUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the agenda export period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @generated
 */
public class AgendaExportPeriodPersistenceImpl
	extends BasePersistenceImpl<AgendaExportPeriod>
	implements AgendaExportPeriodPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AgendaExportPeriodUtil</code> to access the agenda export period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AgendaExportPeriodImpl.class.getName();

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
	 * Returns all the agenda export periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda export periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @return the range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda export periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda export periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator,
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

		List<AgendaExportPeriod> list = null;

		if (useFinderCache) {
			list = (List<AgendaExportPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExportPeriod agendaExportPeriod : list) {
					if (!uuid.equals(agendaExportPeriod.getUuid())) {
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

			sb.append(_SQL_SELECT_AGENDAEXPORTPERIOD_WHERE);

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
				sb.append(AgendaExportPeriodModelImpl.ORDER_BY_JPQL);
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

				list = (List<AgendaExportPeriod>)QueryUtil.list(
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
	 * Returns the first agenda export period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod findByUuid_First(
			String uuid,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = fetchByUuid_First(
			uuid, orderByComparator);

		if (agendaExportPeriod != null) {
			return agendaExportPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaExportPeriodException(sb.toString());
	}

	/**
	 * Returns the first agenda export period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export period, or <code>null</code> if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod fetchByUuid_First(
		String uuid, OrderByComparator<AgendaExportPeriod> orderByComparator) {

		List<AgendaExportPeriod> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod findByUuid_Last(
			String uuid,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = fetchByUuid_Last(
			uuid, orderByComparator);

		if (agendaExportPeriod != null) {
			return agendaExportPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAgendaExportPeriodException(sb.toString());
	}

	/**
	 * Returns the last agenda export period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export period, or <code>null</code> if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod fetchByUuid_Last(
		String uuid, OrderByComparator<AgendaExportPeriod> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AgendaExportPeriod> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda export periods before and after the current agenda export period in the ordered set where uuid = &#63;.
	 *
	 * @param agendaExportPeriodId the primary key of the current agenda export period
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod[] findByUuid_PrevAndNext(
			long agendaExportPeriodId, String uuid,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		uuid = Objects.toString(uuid, "");

		AgendaExportPeriod agendaExportPeriod = findByPrimaryKey(
			agendaExportPeriodId);

		Session session = null;

		try {
			session = openSession();

			AgendaExportPeriod[] array = new AgendaExportPeriodImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, agendaExportPeriod, uuid, orderByComparator, true);

			array[1] = agendaExportPeriod;

			array[2] = getByUuid_PrevAndNext(
				session, agendaExportPeriod, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AgendaExportPeriod getByUuid_PrevAndNext(
		Session session, AgendaExportPeriod agendaExportPeriod, String uuid,
		OrderByComparator<AgendaExportPeriod> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENDAEXPORTPERIOD_WHERE);

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
			sb.append(AgendaExportPeriodModelImpl.ORDER_BY_JPQL);
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
						agendaExportPeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExportPeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda export periods where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AgendaExportPeriod agendaExportPeriod :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(agendaExportPeriod);
		}
	}

	/**
	 * Returns the number of agenda export periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching agenda export periods
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDAEXPORTPERIOD_WHERE);

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
		"agendaExportPeriod.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(agendaExportPeriod.uuid IS NULL OR agendaExportPeriod.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByAgendaExportId;
	private FinderPath _finderPathWithoutPaginationFindByAgendaExportId;
	private FinderPath _finderPathCountByAgendaExportId;

	/**
	 * Returns all the agenda export periods where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @return the matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByAgendaExportId(long agendaExportId) {
		return findByAgendaExportId(
			agendaExportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda export periods where agendaExportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param agendaExportId the agenda export ID
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @return the range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByAgendaExportId(
		long agendaExportId, int start, int end) {

		return findByAgendaExportId(agendaExportId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda export periods where agendaExportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param agendaExportId the agenda export ID
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByAgendaExportId(
		long agendaExportId, int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator) {

		return findByAgendaExportId(
			agendaExportId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda export periods where agendaExportId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param agendaExportId the agenda export ID
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findByAgendaExportId(
		long agendaExportId, int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAgendaExportId;
				finderArgs = new Object[] {agendaExportId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAgendaExportId;
			finderArgs = new Object[] {
				agendaExportId, start, end, orderByComparator
			};
		}

		List<AgendaExportPeriod> list = null;

		if (useFinderCache) {
			list = (List<AgendaExportPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AgendaExportPeriod agendaExportPeriod : list) {
					if (agendaExportId !=
							agendaExportPeriod.getAgendaExportId()) {

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

			sb.append(_SQL_SELECT_AGENDAEXPORTPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_AGENDAEXPORTID_AGENDAEXPORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AgendaExportPeriodModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(agendaExportId);

				list = (List<AgendaExportPeriod>)QueryUtil.list(
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
	 * Returns the first agenda export period in the ordered set where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod findByAgendaExportId_First(
			long agendaExportId,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = fetchByAgendaExportId_First(
			agendaExportId, orderByComparator);

		if (agendaExportPeriod != null) {
			return agendaExportPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("agendaExportId=");
		sb.append(agendaExportId);

		sb.append("}");

		throw new NoSuchAgendaExportPeriodException(sb.toString());
	}

	/**
	 * Returns the first agenda export period in the ordered set where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching agenda export period, or <code>null</code> if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod fetchByAgendaExportId_First(
		long agendaExportId,
		OrderByComparator<AgendaExportPeriod> orderByComparator) {

		List<AgendaExportPeriod> list = findByAgendaExportId(
			agendaExportId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last agenda export period in the ordered set where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod findByAgendaExportId_Last(
			long agendaExportId,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = fetchByAgendaExportId_Last(
			agendaExportId, orderByComparator);

		if (agendaExportPeriod != null) {
			return agendaExportPeriod;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("agendaExportId=");
		sb.append(agendaExportId);

		sb.append("}");

		throw new NoSuchAgendaExportPeriodException(sb.toString());
	}

	/**
	 * Returns the last agenda export period in the ordered set where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching agenda export period, or <code>null</code> if a matching agenda export period could not be found
	 */
	@Override
	public AgendaExportPeriod fetchByAgendaExportId_Last(
		long agendaExportId,
		OrderByComparator<AgendaExportPeriod> orderByComparator) {

		int count = countByAgendaExportId(agendaExportId);

		if (count == 0) {
			return null;
		}

		List<AgendaExportPeriod> list = findByAgendaExportId(
			agendaExportId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the agenda export periods before and after the current agenda export period in the ordered set where agendaExportId = &#63;.
	 *
	 * @param agendaExportPeriodId the primary key of the current agenda export period
	 * @param agendaExportId the agenda export ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod[] findByAgendaExportId_PrevAndNext(
			long agendaExportPeriodId, long agendaExportId,
			OrderByComparator<AgendaExportPeriod> orderByComparator)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = findByPrimaryKey(
			agendaExportPeriodId);

		Session session = null;

		try {
			session = openSession();

			AgendaExportPeriod[] array = new AgendaExportPeriodImpl[3];

			array[0] = getByAgendaExportId_PrevAndNext(
				session, agendaExportPeriod, agendaExportId, orderByComparator,
				true);

			array[1] = agendaExportPeriod;

			array[2] = getByAgendaExportId_PrevAndNext(
				session, agendaExportPeriod, agendaExportId, orderByComparator,
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

	protected AgendaExportPeriod getByAgendaExportId_PrevAndNext(
		Session session, AgendaExportPeriod agendaExportPeriod,
		long agendaExportId,
		OrderByComparator<AgendaExportPeriod> orderByComparator,
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

		sb.append(_SQL_SELECT_AGENDAEXPORTPERIOD_WHERE);

		sb.append(_FINDER_COLUMN_AGENDAEXPORTID_AGENDAEXPORTID_2);

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
			sb.append(AgendaExportPeriodModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(agendaExportId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						agendaExportPeriod)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AgendaExportPeriod> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the agenda export periods where agendaExportId = &#63; from the database.
	 *
	 * @param agendaExportId the agenda export ID
	 */
	@Override
	public void removeByAgendaExportId(long agendaExportId) {
		for (AgendaExportPeriod agendaExportPeriod :
				findByAgendaExportId(
					agendaExportId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(agendaExportPeriod);
		}
	}

	/**
	 * Returns the number of agenda export periods where agendaExportId = &#63;.
	 *
	 * @param agendaExportId the agenda export ID
	 * @return the number of matching agenda export periods
	 */
	@Override
	public int countByAgendaExportId(long agendaExportId) {
		FinderPath finderPath = _finderPathCountByAgendaExportId;

		Object[] finderArgs = new Object[] {agendaExportId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AGENDAEXPORTPERIOD_WHERE);

			sb.append(_FINDER_COLUMN_AGENDAEXPORTID_AGENDAEXPORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(agendaExportId);

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

	private static final String _FINDER_COLUMN_AGENDAEXPORTID_AGENDAEXPORTID_2 =
		"agendaExportPeriod.agendaExportId = ?";

	public AgendaExportPeriodPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AgendaExportPeriod.class);

		setModelImplClass(AgendaExportPeriodImpl.class);
		setModelPKClass(long.class);

		setTable(AgendaExportPeriodTable.INSTANCE);
	}

	/**
	 * Caches the agenda export period in the entity cache if it is enabled.
	 *
	 * @param agendaExportPeriod the agenda export period
	 */
	@Override
	public void cacheResult(AgendaExportPeriod agendaExportPeriod) {
		entityCache.putResult(
			AgendaExportPeriodImpl.class, agendaExportPeriod.getPrimaryKey(),
			agendaExportPeriod);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the agenda export periods in the entity cache if it is enabled.
	 *
	 * @param agendaExportPeriods the agenda export periods
	 */
	@Override
	public void cacheResult(List<AgendaExportPeriod> agendaExportPeriods) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (agendaExportPeriods.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AgendaExportPeriod agendaExportPeriod : agendaExportPeriods) {
			if (entityCache.getResult(
					AgendaExportPeriodImpl.class,
					agendaExportPeriod.getPrimaryKey()) == null) {

				cacheResult(agendaExportPeriod);
			}
		}
	}

	/**
	 * Clears the cache for all agenda export periods.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AgendaExportPeriodImpl.class);

		finderCache.clearCache(AgendaExportPeriodImpl.class);
	}

	/**
	 * Clears the cache for the agenda export period.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AgendaExportPeriod agendaExportPeriod) {
		entityCache.removeResult(
			AgendaExportPeriodImpl.class, agendaExportPeriod);
	}

	@Override
	public void clearCache(List<AgendaExportPeriod> agendaExportPeriods) {
		for (AgendaExportPeriod agendaExportPeriod : agendaExportPeriods) {
			entityCache.removeResult(
				AgendaExportPeriodImpl.class, agendaExportPeriod);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AgendaExportPeriodImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AgendaExportPeriodImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new agenda export period with the primary key. Does not add the agenda export period to the database.
	 *
	 * @param agendaExportPeriodId the primary key for the new agenda export period
	 * @return the new agenda export period
	 */
	@Override
	public AgendaExportPeriod create(long agendaExportPeriodId) {
		AgendaExportPeriod agendaExportPeriod = new AgendaExportPeriodImpl();

		agendaExportPeriod.setNew(true);
		agendaExportPeriod.setPrimaryKey(agendaExportPeriodId);

		String uuid = PortalUUIDUtil.generate();

		agendaExportPeriod.setUuid(uuid);

		return agendaExportPeriod;
	}

	/**
	 * Removes the agenda export period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param agendaExportPeriodId the primary key of the agenda export period
	 * @return the agenda export period that was removed
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod remove(long agendaExportPeriodId)
		throws NoSuchAgendaExportPeriodException {

		return remove((Serializable)agendaExportPeriodId);
	}

	/**
	 * Removes the agenda export period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the agenda export period
	 * @return the agenda export period that was removed
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod remove(Serializable primaryKey)
		throws NoSuchAgendaExportPeriodException {

		Session session = null;

		try {
			session = openSession();

			AgendaExportPeriod agendaExportPeriod =
				(AgendaExportPeriod)session.get(
					AgendaExportPeriodImpl.class, primaryKey);

			if (agendaExportPeriod == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAgendaExportPeriodException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(agendaExportPeriod);
		}
		catch (NoSuchAgendaExportPeriodException noSuchEntityException) {
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
	protected AgendaExportPeriod removeImpl(
		AgendaExportPeriod agendaExportPeriod) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(agendaExportPeriod)) {
				agendaExportPeriod = (AgendaExportPeriod)session.get(
					AgendaExportPeriodImpl.class,
					agendaExportPeriod.getPrimaryKeyObj());
			}

			if (agendaExportPeriod != null) {
				session.delete(agendaExportPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (agendaExportPeriod != null) {
			clearCache(agendaExportPeriod);
		}

		return agendaExportPeriod;
	}

	@Override
	public AgendaExportPeriod updateImpl(
		AgendaExportPeriod agendaExportPeriod) {

		boolean isNew = agendaExportPeriod.isNew();

		if (!(agendaExportPeriod instanceof AgendaExportPeriodModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(agendaExportPeriod.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					agendaExportPeriod);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in agendaExportPeriod proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AgendaExportPeriod implementation " +
					agendaExportPeriod.getClass());
		}

		AgendaExportPeriodModelImpl agendaExportPeriodModelImpl =
			(AgendaExportPeriodModelImpl)agendaExportPeriod;

		if (Validator.isNull(agendaExportPeriod.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			agendaExportPeriod.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(agendaExportPeriod);
			}
			else {
				agendaExportPeriod = (AgendaExportPeriod)session.merge(
					agendaExportPeriod);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AgendaExportPeriodImpl.class, agendaExportPeriodModelImpl, false,
			true);

		if (isNew) {
			agendaExportPeriod.setNew(false);
		}

		agendaExportPeriod.resetOriginalValues();

		return agendaExportPeriod;
	}

	/**
	 * Returns the agenda export period with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the agenda export period
	 * @return the agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAgendaExportPeriodException {

		AgendaExportPeriod agendaExportPeriod = fetchByPrimaryKey(primaryKey);

		if (agendaExportPeriod == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAgendaExportPeriodException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return agendaExportPeriod;
	}

	/**
	 * Returns the agenda export period with the primary key or throws a <code>NoSuchAgendaExportPeriodException</code> if it could not be found.
	 *
	 * @param agendaExportPeriodId the primary key of the agenda export period
	 * @return the agenda export period
	 * @throws NoSuchAgendaExportPeriodException if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod findByPrimaryKey(long agendaExportPeriodId)
		throws NoSuchAgendaExportPeriodException {

		return findByPrimaryKey((Serializable)agendaExportPeriodId);
	}

	/**
	 * Returns the agenda export period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param agendaExportPeriodId the primary key of the agenda export period
	 * @return the agenda export period, or <code>null</code> if a agenda export period with the primary key could not be found
	 */
	@Override
	public AgendaExportPeriod fetchByPrimaryKey(long agendaExportPeriodId) {
		return fetchByPrimaryKey((Serializable)agendaExportPeriodId);
	}

	/**
	 * Returns all the agenda export periods.
	 *
	 * @return the agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the agenda export periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @return the range of agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the agenda export periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findAll(
		int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the agenda export periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AgendaExportPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agenda export periods
	 * @param end the upper bound of the range of agenda export periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of agenda export periods
	 */
	@Override
	public List<AgendaExportPeriod> findAll(
		int start, int end,
		OrderByComparator<AgendaExportPeriod> orderByComparator,
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

		List<AgendaExportPeriod> list = null;

		if (useFinderCache) {
			list = (List<AgendaExportPeriod>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AGENDAEXPORTPERIOD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AGENDAEXPORTPERIOD;

				sql = sql.concat(AgendaExportPeriodModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AgendaExportPeriod>)QueryUtil.list(
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
	 * Removes all the agenda export periods from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AgendaExportPeriod agendaExportPeriod : findAll()) {
			remove(agendaExportPeriod);
		}
	}

	/**
	 * Returns the number of agenda export periods.
	 *
	 * @return the number of agenda export periods
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
					_SQL_COUNT_AGENDAEXPORTPERIOD);

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
		return "agendaExportPeriodId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AGENDAEXPORTPERIOD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AgendaExportPeriodModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the agenda export period persistence.
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

		_finderPathWithPaginationFindByAgendaExportId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAgendaExportId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"agendaExportId"}, true);

		_finderPathWithoutPaginationFindByAgendaExportId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAgendaExportId",
			new String[] {Long.class.getName()},
			new String[] {"agendaExportId"}, true);

		_finderPathCountByAgendaExportId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAgendaExportId",
			new String[] {Long.class.getName()},
			new String[] {"agendaExportId"}, false);

		AgendaExportPeriodUtil.setPersistence(this);
	}

	public void destroy() {
		AgendaExportPeriodUtil.setPersistence(null);

		entityCache.removeCache(AgendaExportPeriodImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AGENDAEXPORTPERIOD =
		"SELECT agendaExportPeriod FROM AgendaExportPeriod agendaExportPeriod";

	private static final String _SQL_SELECT_AGENDAEXPORTPERIOD_WHERE =
		"SELECT agendaExportPeriod FROM AgendaExportPeriod agendaExportPeriod WHERE ";

	private static final String _SQL_COUNT_AGENDAEXPORTPERIOD =
		"SELECT COUNT(agendaExportPeriod) FROM AgendaExportPeriod agendaExportPeriod";

	private static final String _SQL_COUNT_AGENDAEXPORTPERIOD_WHERE =
		"SELECT COUNT(agendaExportPeriod) FROM AgendaExportPeriod agendaExportPeriod WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "agendaExportPeriod.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AgendaExportPeriod exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AgendaExportPeriod exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AgendaExportPeriodPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}