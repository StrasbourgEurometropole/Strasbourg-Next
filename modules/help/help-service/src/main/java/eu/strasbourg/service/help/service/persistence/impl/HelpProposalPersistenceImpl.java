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

package eu.strasbourg.service.help.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
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
import com.liferay.portal.kernel.uuid.PortalUUID;

import eu.strasbourg.service.help.exception.NoSuchHelpProposalException;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpProposalTable;
import eu.strasbourg.service.help.model.impl.HelpProposalImpl;
import eu.strasbourg.service.help.model.impl.HelpProposalModelImpl;
import eu.strasbourg.service.help.service.persistence.HelpProposalPersistence;
import eu.strasbourg.service.help.service.persistence.HelpProposalUtil;
import eu.strasbourg.service.help.service.persistence.impl.constants.helpPersistenceConstants;

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

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the help proposal service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = HelpProposalPersistence.class)
public class HelpProposalPersistenceImpl
	extends BasePersistenceImpl<HelpProposal>
	implements HelpProposalPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HelpProposalUtil</code> to access the help proposal persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HelpProposalImpl.class.getName();

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
	 * Returns all the help proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the help proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the help proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the help proposals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator,
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

		List<HelpProposal> list = null;

		if (useFinderCache) {
			list = (List<HelpProposal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HelpProposal helpProposal : list) {
					if (!uuid.equals(helpProposal.getUuid())) {
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

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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
				sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
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

				list = (List<HelpProposal>)QueryUtil.list(
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
	 * Returns the first help proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByUuid_First(
			String uuid, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByUuid_First(uuid, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the first help proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUuid_First(
		String uuid, OrderByComparator<HelpProposal> orderByComparator) {

		List<HelpProposal> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last help proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByUuid_Last(
			String uuid, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByUuid_Last(uuid, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the last help proposal in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUuid_Last(
		String uuid, OrderByComparator<HelpProposal> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<HelpProposal> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the help proposals before and after the current help proposal in the ordered set where uuid = &#63;.
	 *
	 * @param helpProposalId the primary key of the current help proposal
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal[] findByUuid_PrevAndNext(
			long helpProposalId, String uuid,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		uuid = Objects.toString(uuid, "");

		HelpProposal helpProposal = findByPrimaryKey(helpProposalId);

		Session session = null;

		try {
			session = openSession();

			HelpProposal[] array = new HelpProposalImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, helpProposal, uuid, orderByComparator, true);

			array[1] = helpProposal;

			array[2] = getByUuid_PrevAndNext(
				session, helpProposal, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected HelpProposal getByUuid_PrevAndNext(
		Session session, HelpProposal helpProposal, String uuid,
		OrderByComparator<HelpProposal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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
			sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(helpProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HelpProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the help proposals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (HelpProposal helpProposal :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(helpProposal);
		}
	}

	/**
	 * Returns the number of help proposals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching help proposals
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

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
		"helpProposal.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(helpProposal.uuid IS NULL OR helpProposal.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the help proposal where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHelpProposalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByUUID_G(String uuid, long groupId)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByUUID_G(uuid, groupId);

		if (helpProposal == null) {
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

			throw new NoSuchHelpProposalException(sb.toString());
		}

		return helpProposal;
	}

	/**
	 * Returns the help proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the help proposal where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUUID_G(
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

		if (result instanceof HelpProposal) {
			HelpProposal helpProposal = (HelpProposal)result;

			if (!Objects.equals(uuid, helpProposal.getUuid()) ||
				(groupId != helpProposal.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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

				List<HelpProposal> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					HelpProposal helpProposal = list.get(0);

					result = helpProposal;

					cacheResult(helpProposal);
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
			return (HelpProposal)result;
		}
	}

	/**
	 * Removes the help proposal where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the help proposal that was removed
	 */
	@Override
	public HelpProposal removeByUUID_G(String uuid, long groupId)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = findByUUID_G(uuid, groupId);

		return remove(helpProposal);
	}

	/**
	 * Returns the number of help proposals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching help proposals
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

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
		"helpProposal.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(helpProposal.uuid IS NULL OR helpProposal.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"helpProposal.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the help proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the help proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the help proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the help proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator,
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

		List<HelpProposal> list = null;

		if (useFinderCache) {
			list = (List<HelpProposal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HelpProposal helpProposal : list) {
					if (!uuid.equals(helpProposal.getUuid()) ||
						(companyId != helpProposal.getCompanyId())) {

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

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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
				sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
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

				list = (List<HelpProposal>)QueryUtil.list(
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
	 * Returns the first help proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the first help proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<HelpProposal> orderByComparator) {

		List<HelpProposal> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last help proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the last help proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<HelpProposal> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<HelpProposal> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the help proposals before and after the current help proposal in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param helpProposalId the primary key of the current help proposal
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal[] findByUuid_C_PrevAndNext(
			long helpProposalId, String uuid, long companyId,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		uuid = Objects.toString(uuid, "");

		HelpProposal helpProposal = findByPrimaryKey(helpProposalId);

		Session session = null;

		try {
			session = openSession();

			HelpProposal[] array = new HelpProposalImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, helpProposal, uuid, companyId, orderByComparator,
				true);

			array[1] = helpProposal;

			array[2] = getByUuid_C_PrevAndNext(
				session, helpProposal, uuid, companyId, orderByComparator,
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

	protected HelpProposal getByUuid_C_PrevAndNext(
		Session session, HelpProposal helpProposal, String uuid, long companyId,
		OrderByComparator<HelpProposal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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
			sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(helpProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HelpProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the help proposals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (HelpProposal helpProposal :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(helpProposal);
		}
	}

	/**
	 * Returns the number of help proposals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching help proposals
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

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
		"helpProposal.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(helpProposal.uuid IS NULL OR helpProposal.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"helpProposal.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the help proposals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching help proposals
	 */
	@Override
	public List<HelpProposal> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the help proposals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the help proposals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the help proposals where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator,
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

		List<HelpProposal> list = null;

		if (useFinderCache) {
			list = (List<HelpProposal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HelpProposal helpProposal : list) {
					if (groupId != helpProposal.getGroupId()) {
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

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<HelpProposal>)QueryUtil.list(
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
	 * Returns the first help proposal in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByGroupId_First(
			long groupId, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByGroupId_First(
			groupId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the first help proposal in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByGroupId_First(
		long groupId, OrderByComparator<HelpProposal> orderByComparator) {

		List<HelpProposal> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last help proposal in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByGroupId_Last(
			long groupId, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the last help proposal in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByGroupId_Last(
		long groupId, OrderByComparator<HelpProposal> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<HelpProposal> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the help proposals before and after the current help proposal in the ordered set where groupId = &#63;.
	 *
	 * @param helpProposalId the primary key of the current help proposal
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal[] findByGroupId_PrevAndNext(
			long helpProposalId, long groupId,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = findByPrimaryKey(helpProposalId);

		Session session = null;

		try {
			session = openSession();

			HelpProposal[] array = new HelpProposalImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, helpProposal, groupId, orderByComparator, true);

			array[1] = helpProposal;

			array[2] = getByGroupId_PrevAndNext(
				session, helpProposal, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected HelpProposal getByGroupId_PrevAndNext(
		Session session, HelpProposal helpProposal, long groupId,
		OrderByComparator<HelpProposal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

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
			sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(helpProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HelpProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the help proposals where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (HelpProposal helpProposal :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(helpProposal);
		}
	}

	/**
	 * Returns the number of help proposals where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching help proposals
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

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
		"helpProposal.groupId = ?";

	private FinderPath _finderPathWithPaginationFindBypublikId;
	private FinderPath _finderPathWithoutPaginationFindBypublikId;
	private FinderPath _finderPathCountBypublikId;

	/**
	 * Returns all the help proposals where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching help proposals
	 */
	@Override
	public List<HelpProposal> findBypublikId(String publikId) {
		return findBypublikId(
			publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the help proposals where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findBypublikId(
		String publikId, int start, int end) {

		return findBypublikId(publikId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the help proposals where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator) {

		return findBypublikId(publikId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the help proposals where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching help proposals
	 */
	@Override
	public List<HelpProposal> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator,
		boolean useFinderCache) {

		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBypublikId;
				finderArgs = new Object[] {publikId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBypublikId;
			finderArgs = new Object[] {publikId, start, end, orderByComparator};
		}

		List<HelpProposal> list = null;

		if (useFinderCache) {
			list = (List<HelpProposal>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (HelpProposal helpProposal : list) {
					if (!publikId.equals(helpProposal.getPublikId())) {
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

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
				}

				list = (List<HelpProposal>)QueryUtil.list(
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
	 * Returns the first help proposal in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findBypublikId_First(
			String publikId, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchBypublikId_First(
			publikId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the first help proposal in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchBypublikId_First(
		String publikId, OrderByComparator<HelpProposal> orderByComparator) {

		List<HelpProposal> list = findBypublikId(
			publikId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last help proposal in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findBypublikId_Last(
			String publikId, OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchBypublikId_Last(
			publikId, orderByComparator);

		if (helpProposal != null) {
			return helpProposal;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchHelpProposalException(sb.toString());
	}

	/**
	 * Returns the last help proposal in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchBypublikId_Last(
		String publikId, OrderByComparator<HelpProposal> orderByComparator) {

		int count = countBypublikId(publikId);

		if (count == 0) {
			return null;
		}

		List<HelpProposal> list = findBypublikId(
			publikId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the help proposals before and after the current help proposal in the ordered set where publikId = &#63;.
	 *
	 * @param helpProposalId the primary key of the current help proposal
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal[] findBypublikId_PrevAndNext(
			long helpProposalId, String publikId,
			OrderByComparator<HelpProposal> orderByComparator)
		throws NoSuchHelpProposalException {

		publikId = Objects.toString(publikId, "");

		HelpProposal helpProposal = findByPrimaryKey(helpProposalId);

		Session session = null;

		try {
			session = openSession();

			HelpProposal[] array = new HelpProposalImpl[3];

			array[0] = getBypublikId_PrevAndNext(
				session, helpProposal, publikId, orderByComparator, true);

			array[1] = helpProposal;

			array[2] = getBypublikId_PrevAndNext(
				session, helpProposal, publikId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected HelpProposal getBypublikId_PrevAndNext(
		Session session, HelpProposal helpProposal, String publikId,
		OrderByComparator<HelpProposal> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

		boolean bindPublikId = false;

		if (publikId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
		}
		else {
			bindPublikId = true;

			sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
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
			sb.append(HelpProposalModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPublikId) {
			queryPos.add(publikId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(helpProposal)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<HelpProposal> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the help proposals where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	@Override
	public void removeBypublikId(String publikId) {
		for (HelpProposal helpProposal :
				findBypublikId(
					publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(helpProposal);
		}
	}

	/**
	 * Returns the number of help proposals where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching help proposals
	 */
	@Override
	public int countBypublikId(String publikId) {
		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountBypublikId;

		Object[] finderArgs = new Object[] {publikId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKID_PUBLIKID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
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

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_2 =
		"helpProposal.publikId = ?";

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_3 =
		"(helpProposal.publikId IS NULL OR helpProposal.publikId = '')";

	private FinderPath _finderPathFetchByPublikIdAndHelpProposalId;
	private FinderPath _finderPathCountByPublikIdAndHelpProposalId;

	/**
	 * Returns the help proposal where publikId = &#63; and helpProposalId = &#63; or throws a <code>NoSuchHelpProposalException</code> if it could not be found.
	 *
	 * @param publikId the publik ID
	 * @param helpProposalId the help proposal ID
	 * @return the matching help proposal
	 * @throws NoSuchHelpProposalException if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal findByPublikIdAndHelpProposalId(
			String publikId, long helpProposalId)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByPublikIdAndHelpProposalId(
			publikId, helpProposalId);

		if (helpProposal == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("publikId=");
			sb.append(publikId);

			sb.append(", helpProposalId=");
			sb.append(helpProposalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchHelpProposalException(sb.toString());
		}

		return helpProposal;
	}

	/**
	 * Returns the help proposal where publikId = &#63; and helpProposalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikId the publik ID
	 * @param helpProposalId the help proposal ID
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByPublikIdAndHelpProposalId(
		String publikId, long helpProposalId) {

		return fetchByPublikIdAndHelpProposalId(publikId, helpProposalId, true);
	}

	/**
	 * Returns the help proposal where publikId = &#63; and helpProposalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikId the publik ID
	 * @param helpProposalId the help proposal ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Override
	public HelpProposal fetchByPublikIdAndHelpProposalId(
		String publikId, long helpProposalId, boolean useFinderCache) {

		publikId = Objects.toString(publikId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {publikId, helpProposalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByPublikIdAndHelpProposalId, finderArgs, this);
		}

		if (result instanceof HelpProposal) {
			HelpProposal helpProposal = (HelpProposal)result;

			if (!Objects.equals(publikId, helpProposal.getPublikId()) ||
				(helpProposalId != helpProposal.getHelpProposalId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_HELPPROPOSAL_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_2);
			}

			sb.append(
				_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_HELPPROPOSALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
				}

				queryPos.add(helpProposalId);

				List<HelpProposal> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByPublikIdAndHelpProposalId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									publikId, helpProposalId
								};
							}

							_log.warn(
								"HelpProposalPersistenceImpl.fetchByPublikIdAndHelpProposalId(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					HelpProposal helpProposal = list.get(0);

					result = helpProposal;

					cacheResult(helpProposal);
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
			return (HelpProposal)result;
		}
	}

	/**
	 * Removes the help proposal where publikId = &#63; and helpProposalId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 * @param helpProposalId the help proposal ID
	 * @return the help proposal that was removed
	 */
	@Override
	public HelpProposal removeByPublikIdAndHelpProposalId(
			String publikId, long helpProposalId)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = findByPublikIdAndHelpProposalId(
			publikId, helpProposalId);

		return remove(helpProposal);
	}

	/**
	 * Returns the number of help proposals where publikId = &#63; and helpProposalId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param helpProposalId the help proposal ID
	 * @return the number of matching help proposals
	 */
	@Override
	public int countByPublikIdAndHelpProposalId(
		String publikId, long helpProposalId) {

		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountByPublikIdAndHelpProposalId;

		Object[] finderArgs = new Object[] {publikId, helpProposalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_HELPPROPOSAL_WHERE);

			boolean bindPublikId = false;

			if (publikId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_3);
			}
			else {
				bindPublikId = true;

				sb.append(_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_2);
			}

			sb.append(
				_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_HELPPROPOSALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublikId) {
					queryPos.add(publikId);
				}

				queryPos.add(helpProposalId);

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
		_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_2 =
			"helpProposal.publikId = ? AND ";

	private static final String
		_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_PUBLIKID_3 =
			"(helpProposal.publikId IS NULL OR helpProposal.publikId = '') AND ";

	private static final String
		_FINDER_COLUMN_PUBLIKIDANDHELPPROPOSALID_HELPPROPOSALID_2 =
			"helpProposal.helpProposalId = ?";

	public HelpProposalPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HelpProposal.class);

		setModelImplClass(HelpProposalImpl.class);
		setModelPKClass(long.class);

		setTable(HelpProposalTable.INSTANCE);
	}

	/**
	 * Caches the help proposal in the entity cache if it is enabled.
	 *
	 * @param helpProposal the help proposal
	 */
	@Override
	public void cacheResult(HelpProposal helpProposal) {
		entityCache.putResult(
			HelpProposalImpl.class, helpProposal.getPrimaryKey(), helpProposal);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {helpProposal.getUuid(), helpProposal.getGroupId()},
			helpProposal);

		finderCache.putResult(
			_finderPathFetchByPublikIdAndHelpProposalId,
			new Object[] {
				helpProposal.getPublikId(), helpProposal.getHelpProposalId()
			},
			helpProposal);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the help proposals in the entity cache if it is enabled.
	 *
	 * @param helpProposals the help proposals
	 */
	@Override
	public void cacheResult(List<HelpProposal> helpProposals) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (helpProposals.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HelpProposal helpProposal : helpProposals) {
			if (entityCache.getResult(
					HelpProposalImpl.class, helpProposal.getPrimaryKey()) ==
						null) {

				cacheResult(helpProposal);
			}
		}
	}

	/**
	 * Clears the cache for all help proposals.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HelpProposalImpl.class);

		finderCache.clearCache(HelpProposalImpl.class);
	}

	/**
	 * Clears the cache for the help proposal.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HelpProposal helpProposal) {
		entityCache.removeResult(HelpProposalImpl.class, helpProposal);
	}

	@Override
	public void clearCache(List<HelpProposal> helpProposals) {
		for (HelpProposal helpProposal : helpProposals) {
			entityCache.removeResult(HelpProposalImpl.class, helpProposal);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(HelpProposalImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HelpProposalImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		HelpProposalModelImpl helpProposalModelImpl) {

		Object[] args = new Object[] {
			helpProposalModelImpl.getUuid(), helpProposalModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, helpProposalModelImpl);

		args = new Object[] {
			helpProposalModelImpl.getPublikId(),
			helpProposalModelImpl.getHelpProposalId()
		};

		finderCache.putResult(
			_finderPathCountByPublikIdAndHelpProposalId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByPublikIdAndHelpProposalId, args,
			helpProposalModelImpl);
	}

	/**
	 * Creates a new help proposal with the primary key. Does not add the help proposal to the database.
	 *
	 * @param helpProposalId the primary key for the new help proposal
	 * @return the new help proposal
	 */
	@Override
	public HelpProposal create(long helpProposalId) {
		HelpProposal helpProposal = new HelpProposalImpl();

		helpProposal.setNew(true);
		helpProposal.setPrimaryKey(helpProposalId);

		String uuid = _portalUUID.generate();

		helpProposal.setUuid(uuid);

		helpProposal.setCompanyId(CompanyThreadLocal.getCompanyId());

		return helpProposal;
	}

	/**
	 * Removes the help proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal that was removed
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal remove(long helpProposalId)
		throws NoSuchHelpProposalException {

		return remove((Serializable)helpProposalId);
	}

	/**
	 * Removes the help proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the help proposal
	 * @return the help proposal that was removed
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal remove(Serializable primaryKey)
		throws NoSuchHelpProposalException {

		Session session = null;

		try {
			session = openSession();

			HelpProposal helpProposal = (HelpProposal)session.get(
				HelpProposalImpl.class, primaryKey);

			if (helpProposal == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHelpProposalException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(helpProposal);
		}
		catch (NoSuchHelpProposalException noSuchEntityException) {
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
	protected HelpProposal removeImpl(HelpProposal helpProposal) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(helpProposal)) {
				helpProposal = (HelpProposal)session.get(
					HelpProposalImpl.class, helpProposal.getPrimaryKeyObj());
			}

			if (helpProposal != null) {
				session.delete(helpProposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (helpProposal != null) {
			clearCache(helpProposal);
		}

		return helpProposal;
	}

	@Override
	public HelpProposal updateImpl(HelpProposal helpProposal) {
		boolean isNew = helpProposal.isNew();

		if (!(helpProposal instanceof HelpProposalModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(helpProposal.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					helpProposal);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in helpProposal proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom HelpProposal implementation " +
					helpProposal.getClass());
		}

		HelpProposalModelImpl helpProposalModelImpl =
			(HelpProposalModelImpl)helpProposal;

		if (Validator.isNull(helpProposal.getUuid())) {
			String uuid = _portalUUID.generate();

			helpProposal.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (helpProposal.getCreateDate() == null)) {
			if (serviceContext == null) {
				helpProposal.setCreateDate(date);
			}
			else {
				helpProposal.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!helpProposalModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				helpProposal.setModifiedDate(date);
			}
			else {
				helpProposal.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(helpProposal);
			}
			else {
				helpProposal = (HelpProposal)session.merge(helpProposal);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			HelpProposalImpl.class, helpProposalModelImpl, false, true);

		cacheUniqueFindersCache(helpProposalModelImpl);

		if (isNew) {
			helpProposal.setNew(false);
		}

		helpProposal.resetOriginalValues();

		return helpProposal;
	}

	/**
	 * Returns the help proposal with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the help proposal
	 * @return the help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHelpProposalException {

		HelpProposal helpProposal = fetchByPrimaryKey(primaryKey);

		if (helpProposal == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHelpProposalException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return helpProposal;
	}

	/**
	 * Returns the help proposal with the primary key or throws a <code>NoSuchHelpProposalException</code> if it could not be found.
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal
	 * @throws NoSuchHelpProposalException if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal findByPrimaryKey(long helpProposalId)
		throws NoSuchHelpProposalException {

		return findByPrimaryKey((Serializable)helpProposalId);
	}

	/**
	 * Returns the help proposal with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal, or <code>null</code> if a help proposal with the primary key could not be found
	 */
	@Override
	public HelpProposal fetchByPrimaryKey(long helpProposalId) {
		return fetchByPrimaryKey((Serializable)helpProposalId);
	}

	/**
	 * Returns all the help proposals.
	 *
	 * @return the help proposals
	 */
	@Override
	public List<HelpProposal> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the help proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of help proposals
	 */
	@Override
	public List<HelpProposal> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the help proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of help proposals
	 */
	@Override
	public List<HelpProposal> findAll(
		int start, int end, OrderByComparator<HelpProposal> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the help proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of help proposals
	 */
	@Override
	public List<HelpProposal> findAll(
		int start, int end, OrderByComparator<HelpProposal> orderByComparator,
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

		List<HelpProposal> list = null;

		if (useFinderCache) {
			list = (List<HelpProposal>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HELPPROPOSAL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HELPPROPOSAL;

				sql = sql.concat(HelpProposalModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HelpProposal>)QueryUtil.list(
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
	 * Removes all the help proposals from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HelpProposal helpProposal : findAll()) {
			remove(helpProposal);
		}
	}

	/**
	 * Returns the number of help proposals.
	 *
	 * @return the number of help proposals
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HELPPROPOSAL);

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
		return "helpProposalId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_HELPPROPOSAL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HelpProposalModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the help proposal persistence.
	 */
	@Activate
	public void activate() {
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

		_finderPathWithPaginationFindBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypublikId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"publikId"}, true);

		_finderPathWithoutPaginationFindBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			true);

		_finderPathCountBypublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			false);

		_finderPathFetchByPublikIdAndHelpProposalId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByPublikIdAndHelpProposalId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"publikId", "helpProposalId"}, true);

		_finderPathCountByPublikIdAndHelpProposalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublikIdAndHelpProposalId",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"publikId", "helpProposalId"}, false);

		_setHelpProposalUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setHelpProposalUtilPersistence(null);

		entityCache.removeCache(HelpProposalImpl.class.getName());
	}

	private void _setHelpProposalUtilPersistence(
		HelpProposalPersistence helpProposalPersistence) {

		try {
			Field field = HelpProposalUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, helpProposalPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = helpPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = helpPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = helpPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_HELPPROPOSAL =
		"SELECT helpProposal FROM HelpProposal helpProposal";

	private static final String _SQL_SELECT_HELPPROPOSAL_WHERE =
		"SELECT helpProposal FROM HelpProposal helpProposal WHERE ";

	private static final String _SQL_COUNT_HELPPROPOSAL =
		"SELECT COUNT(helpProposal) FROM HelpProposal helpProposal";

	private static final String _SQL_COUNT_HELPPROPOSAL_WHERE =
		"SELECT COUNT(helpProposal) FROM HelpProposal helpProposal WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "helpProposal.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HelpProposal exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No HelpProposal exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		HelpProposalPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}