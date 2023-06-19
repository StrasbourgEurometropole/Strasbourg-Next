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
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.council.exception.NoSuchVoteException;
import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.model.VoteTable;
import eu.strasbourg.service.council.model.impl.VoteImpl;
import eu.strasbourg.service.council.model.impl.VoteModelImpl;
import eu.strasbourg.service.council.service.persistence.VotePK;
import eu.strasbourg.service.council.service.persistence.VotePersistence;
import eu.strasbourg.service.council.service.persistence.VoteUtil;

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
 * The persistence implementation for the vote service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VotePersistenceImpl
	extends BasePersistenceImpl<Vote> implements VotePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VoteUtil</code> to access the vote persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VoteImpl.class.getName();

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
	 * Returns all the votes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching votes
	 */
	@Override
	public List<Vote> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	@Override
	public List<Vote> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

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

		List<Vote> list = null;

		if (useFinderCache) {
			list = (List<Vote>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Vote vote : list) {
					if (!uuid.equals(vote.getUuid())) {
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

			sb.append(_SQL_SELECT_VOTE_WHERE);

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
				sb.append(VoteModelImpl.ORDER_BY_JPQL);
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

				list = (List<Vote>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByUuid_First(
			String uuid, OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByUuid_First(uuid, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUuid_First(
		String uuid, OrderByComparator<Vote> orderByComparator) {

		List<Vote> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByUuid_Last(
			String uuid, OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByUuid_Last(uuid, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUuid_Last(
		String uuid, OrderByComparator<Vote> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Vote> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where uuid = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote[] findByUuid_PrevAndNext(
			VotePK votePK, String uuid,
			OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		uuid = Objects.toString(uuid, "");

		Vote vote = findByPrimaryKey(votePK);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, vote, uuid, orderByComparator, true);

			array[1] = vote;

			array[2] = getByUuid_PrevAndNext(
				session, vote, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vote getByUuid_PrevAndNext(
		Session session, Vote vote, String uuid,
		OrderByComparator<Vote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VOTE_WHERE);

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
			sb.append(VoteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(vote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Vote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the votes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Vote vote :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(vote);
		}
	}

	/**
	 * Returns the number of votes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching votes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VOTE_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "vote.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(vote.uuid IS NULL OR vote.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByUUID_G(String uuid, long groupId)
		throws NoSuchVoteException {

		Vote vote = fetchByUUID_G(uuid, groupId);

		if (vote == null) {
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

			throw new NoSuchVoteException(sb.toString());
		}

		return vote;
	}

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the vote where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Vote) {
			Vote vote = (Vote)result;

			if (!Objects.equals(uuid, vote.getUuid()) ||
				(groupId != vote.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VOTE_WHERE);

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

				List<Vote> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Vote vote = list.get(0);

					result = vote;

					cacheResult(vote);
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
			return (Vote)result;
		}
	}

	/**
	 * Removes the vote where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the vote that was removed
	 */
	@Override
	public Vote removeByUUID_G(String uuid, long groupId)
		throws NoSuchVoteException {

		Vote vote = findByUUID_G(uuid, groupId);

		return remove(vote);
	}

	/**
	 * Returns the number of votes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching votes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VOTE_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		"vote.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(vote.uuid IS NULL OR vote.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"vote.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching votes
	 */
	@Override
	public List<Vote> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	@Override
	public List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the votes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

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

		List<Vote> list = null;

		if (useFinderCache) {
			list = (List<Vote>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Vote vote : list) {
					if (!uuid.equals(vote.getUuid()) ||
						(companyId != vote.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VOTE_WHERE);

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
				sb.append(VoteModelImpl.ORDER_BY_JPQL);
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

				list = (List<Vote>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the first vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Vote> orderByComparator) {

		List<Vote> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the last vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Vote> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Vote> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote[] findByUuid_C_PrevAndNext(
			VotePK votePK, String uuid, long companyId,
			OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		uuid = Objects.toString(uuid, "");

		Vote vote = findByPrimaryKey(votePK);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, vote, uuid, companyId, orderByComparator, true);

			array[1] = vote;

			array[2] = getByUuid_C_PrevAndNext(
				session, vote, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vote getByUuid_C_PrevAndNext(
		Session session, Vote vote, String uuid, long companyId,
		OrderByComparator<Vote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VOTE_WHERE);

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
			sb.append(VoteModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(vote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Vote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the votes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Vote vote :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(vote);
		}
	}

	/**
	 * Returns the number of votes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching votes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VOTE_WHERE);

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

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		"vote.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(vote.uuid IS NULL OR vote.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"vote.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDeliberationId;
	private FinderPath _finderPathWithoutPaginationFindByDeliberationId;
	private FinderPath _finderPathCountByDeliberationId;

	/**
	 * Returns all the votes where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @return the matching votes
	 */
	@Override
	public List<Vote> findByDeliberationId(long deliberationId) {
		return findByDeliberationId(
			deliberationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of matching votes
	 */
	@Override
	public List<Vote> findByDeliberationId(
		long deliberationId, int start, int end) {

		return findByDeliberationId(deliberationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByDeliberationId(
		long deliberationId, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return findByDeliberationId(
			deliberationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the votes where deliberationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param deliberationId the deliberation ID
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching votes
	 */
	@Override
	public List<Vote> findByDeliberationId(
		long deliberationId, int start, int end,
		OrderByComparator<Vote> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDeliberationId;
				finderArgs = new Object[] {deliberationId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDeliberationId;
			finderArgs = new Object[] {
				deliberationId, start, end, orderByComparator
			};
		}

		List<Vote> list = null;

		if (useFinderCache) {
			list = (List<Vote>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Vote vote : list) {
					if (deliberationId != vote.getDeliberationId()) {
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

			sb.append(_SQL_SELECT_VOTE_WHERE);

			sb.append(_FINDER_COLUMN_DELIBERATIONID_DELIBERATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(deliberationId);

				list = (List<Vote>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByDeliberationId_First(
			long deliberationId, OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByDeliberationId_First(
			deliberationId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("deliberationId=");
		sb.append(deliberationId);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the first vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByDeliberationId_First(
		long deliberationId, OrderByComparator<Vote> orderByComparator) {

		List<Vote> list = findByDeliberationId(
			deliberationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByDeliberationId_Last(
			long deliberationId, OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = fetchByDeliberationId_Last(
			deliberationId, orderByComparator);

		if (vote != null) {
			return vote;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("deliberationId=");
		sb.append(deliberationId);

		sb.append("}");

		throw new NoSuchVoteException(sb.toString());
	}

	/**
	 * Returns the last vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByDeliberationId_Last(
		long deliberationId, OrderByComparator<Vote> orderByComparator) {

		int count = countByDeliberationId(deliberationId);

		if (count == 0) {
			return null;
		}

		List<Vote> list = findByDeliberationId(
			deliberationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the votes before and after the current vote in the ordered set where deliberationId = &#63;.
	 *
	 * @param votePK the primary key of the current vote
	 * @param deliberationId the deliberation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote[] findByDeliberationId_PrevAndNext(
			VotePK votePK, long deliberationId,
			OrderByComparator<Vote> orderByComparator)
		throws NoSuchVoteException {

		Vote vote = findByPrimaryKey(votePK);

		Session session = null;

		try {
			session = openSession();

			Vote[] array = new VoteImpl[3];

			array[0] = getByDeliberationId_PrevAndNext(
				session, vote, deliberationId, orderByComparator, true);

			array[1] = vote;

			array[2] = getByDeliberationId_PrevAndNext(
				session, vote, deliberationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vote getByDeliberationId_PrevAndNext(
		Session session, Vote vote, long deliberationId,
		OrderByComparator<Vote> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VOTE_WHERE);

		sb.append(_FINDER_COLUMN_DELIBERATIONID_DELIBERATIONID_2);

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
			sb.append(VoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(deliberationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(vote)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Vote> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the votes where deliberationId = &#63; from the database.
	 *
	 * @param deliberationId the deliberation ID
	 */
	@Override
	public void removeByDeliberationId(long deliberationId) {
		for (Vote vote :
				findByDeliberationId(
					deliberationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(vote);
		}
	}

	/**
	 * Returns the number of votes where deliberationId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @return the number of matching votes
	 */
	@Override
	public int countByDeliberationId(long deliberationId) {
		FinderPath finderPath = _finderPathCountByDeliberationId;

		Object[] finderArgs = new Object[] {deliberationId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VOTE_WHERE);

			sb.append(_FINDER_COLUMN_DELIBERATIONID_DELIBERATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(deliberationId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_DELIBERATIONID_DELIBERATIONID_2 =
		"vote.id.deliberationId = ?";

	private FinderPath _finderPathFetchByDeliberationIdAndOfficialId;
	private FinderPath _finderPathCountByDeliberationIdAndOfficialId;

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the matching vote
	 * @throws NoSuchVoteException if a matching vote could not be found
	 */
	@Override
	public Vote findByDeliberationIdAndOfficialId(
			long deliberationId, long officialId)
		throws NoSuchVoteException {

		Vote vote = fetchByDeliberationIdAndOfficialId(
			deliberationId, officialId);

		if (vote == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("deliberationId=");
			sb.append(deliberationId);

			sb.append(", officialId=");
			sb.append(officialId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchVoteException(sb.toString());
		}

		return vote;
	}

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByDeliberationIdAndOfficialId(
		long deliberationId, long officialId) {

		return fetchByDeliberationIdAndOfficialId(
			deliberationId, officialId, true);
	}

	/**
	 * Returns the vote where deliberationId = &#63; and officialId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	@Override
	public Vote fetchByDeliberationIdAndOfficialId(
		long deliberationId, long officialId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {deliberationId, officialId};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByDeliberationIdAndOfficialId, finderArgs,
				this);
		}

		if (result instanceof Vote) {
			Vote vote = (Vote)result;

			if ((deliberationId != vote.getDeliberationId()) ||
				(officialId != vote.getOfficialId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VOTE_WHERE);

			sb.append(
				_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_DELIBERATIONID_2);

			sb.append(_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_OFFICIALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(deliberationId);

				queryPos.add(officialId);

				List<Vote> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByDeliberationIdAndOfficialId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									deliberationId, officialId
								};
							}

							_log.warn(
								"VotePersistenceImpl.fetchByDeliberationIdAndOfficialId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Vote vote = list.get(0);

					result = vote;

					cacheResult(vote);
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
			return (Vote)result;
		}
	}

	/**
	 * Removes the vote where deliberationId = &#63; and officialId = &#63; from the database.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the vote that was removed
	 */
	@Override
	public Vote removeByDeliberationIdAndOfficialId(
			long deliberationId, long officialId)
		throws NoSuchVoteException {

		Vote vote = findByDeliberationIdAndOfficialId(
			deliberationId, officialId);

		return remove(vote);
	}

	/**
	 * Returns the number of votes where deliberationId = &#63; and officialId = &#63;.
	 *
	 * @param deliberationId the deliberation ID
	 * @param officialId the official ID
	 * @return the number of matching votes
	 */
	@Override
	public int countByDeliberationIdAndOfficialId(
		long deliberationId, long officialId) {

		FinderPath finderPath = _finderPathCountByDeliberationIdAndOfficialId;

		Object[] finderArgs = new Object[] {deliberationId, officialId};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VOTE_WHERE);

			sb.append(
				_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_DELIBERATIONID_2);

			sb.append(_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_OFFICIALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(deliberationId);

				queryPos.add(officialId);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
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
		_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_DELIBERATIONID_2 =
			"vote.id.deliberationId = ? AND ";

	private static final String
		_FINDER_COLUMN_DELIBERATIONIDANDOFFICIALID_OFFICIALID_2 =
			"vote.id.officialId = ?";

	public VotePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Vote.class);

		setModelImplClass(VoteImpl.class);
		setModelPKClass(VotePK.class);

		setTable(VoteTable.INSTANCE);
	}

	/**
	 * Caches the vote in the entity cache if it is enabled.
	 *
	 * @param vote the vote
	 */
	@Override
	public void cacheResult(Vote vote) {
		dummyEntityCache.putResult(VoteImpl.class, vote.getPrimaryKey(), vote);

		dummyFinderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {vote.getUuid(), vote.getGroupId()}, vote);

		dummyFinderCache.putResult(
			_finderPathFetchByDeliberationIdAndOfficialId,
			new Object[] {vote.getDeliberationId(), vote.getOfficialId()},
			vote);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the votes in the entity cache if it is enabled.
	 *
	 * @param votes the votes
	 */
	@Override
	public void cacheResult(List<Vote> votes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (votes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Vote vote : votes) {
			if (dummyEntityCache.getResult(
					VoteImpl.class, vote.getPrimaryKey()) == null) {

				cacheResult(vote);
			}
		}
	}

	/**
	 * Clears the cache for all votes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(VoteImpl.class);

		dummyFinderCache.clearCache(VoteImpl.class);
	}

	/**
	 * Clears the cache for the vote.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vote vote) {
		dummyEntityCache.removeResult(VoteImpl.class, vote);
	}

	@Override
	public void clearCache(List<Vote> votes) {
		for (Vote vote : votes) {
			dummyEntityCache.removeResult(VoteImpl.class, vote);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(VoteImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(VoteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(VoteModelImpl voteModelImpl) {
		Object[] args = new Object[] {
			voteModelImpl.getUuid(), voteModelImpl.getGroupId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1));
		dummyFinderCache.putResult(
			_finderPathFetchByUUID_G, args, voteModelImpl);

		args = new Object[] {
			voteModelImpl.getDeliberationId(), voteModelImpl.getOfficialId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByDeliberationIdAndOfficialId, args,
			Long.valueOf(1));
		dummyFinderCache.putResult(
			_finderPathFetchByDeliberationIdAndOfficialId, args, voteModelImpl);
	}

	/**
	 * Creates a new vote with the primary key. Does not add the vote to the database.
	 *
	 * @param votePK the primary key for the new vote
	 * @return the new vote
	 */
	@Override
	public Vote create(VotePK votePK) {
		Vote vote = new VoteImpl();

		vote.setNew(true);
		vote.setPrimaryKey(votePK);

		String uuid = _portalUUID.generate();

		vote.setUuid(uuid);

		vote.setCompanyId(CompanyThreadLocal.getCompanyId());

		return vote;
	}

	/**
	 * Removes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote that was removed
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote remove(VotePK votePK) throws NoSuchVoteException {
		return remove((Serializable)votePK);
	}

	/**
	 * Removes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vote
	 * @return the vote that was removed
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote remove(Serializable primaryKey) throws NoSuchVoteException {
		Session session = null;

		try {
			session = openSession();

			Vote vote = (Vote)session.get(VoteImpl.class, primaryKey);

			if (vote == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVoteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vote);
		}
		catch (NoSuchVoteException noSuchEntityException) {
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
	protected Vote removeImpl(Vote vote) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vote)) {
				vote = (Vote)session.get(
					VoteImpl.class, vote.getPrimaryKeyObj());
			}

			if (vote != null) {
				session.delete(vote);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (vote != null) {
			clearCache(vote);
		}

		return vote;
	}

	@Override
	public Vote updateImpl(Vote vote) {
		boolean isNew = vote.isNew();

		if (!(vote instanceof VoteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(vote.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(vote);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in vote proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Vote implementation " +
					vote.getClass());
		}

		VoteModelImpl voteModelImpl = (VoteModelImpl)vote;

		if (Validator.isNull(vote.getUuid())) {
			String uuid = _portalUUID.generate();

			vote.setUuid(uuid);
		}

		if (isNew && (vote.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				vote.setCreateDate(date);
			}
			else {
				vote.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(vote);
			}
			else {
				vote = (Vote)session.merge(vote);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(VoteImpl.class, voteModelImpl, false, true);

		cacheUniqueFindersCache(voteModelImpl);

		if (isNew) {
			vote.setNew(false);
		}

		vote.resetOriginalValues();

		return vote;
	}

	/**
	 * Returns the vote with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vote
	 * @return the vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVoteException {

		Vote vote = fetchByPrimaryKey(primaryKey);

		if (vote == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVoteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vote;
	}

	/**
	 * Returns the vote with the primary key or throws a <code>NoSuchVoteException</code> if it could not be found.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote
	 * @throws NoSuchVoteException if a vote with the primary key could not be found
	 */
	@Override
	public Vote findByPrimaryKey(VotePK votePK) throws NoSuchVoteException {
		return findByPrimaryKey((Serializable)votePK);
	}

	/**
	 * Returns the vote with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote, or <code>null</code> if a vote with the primary key could not be found
	 */
	@Override
	public Vote fetchByPrimaryKey(VotePK votePK) {
		return fetchByPrimaryKey((Serializable)votePK);
	}

	/**
	 * Returns all the votes.
	 *
	 * @return the votes
	 */
	@Override
	public List<Vote> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of votes
	 */
	@Override
	public List<Vote> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of votes
	 */
	@Override
	public List<Vote> findAll(
		int start, int end, OrderByComparator<Vote> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of votes
	 */
	@Override
	public List<Vote> findAll(
		int start, int end, OrderByComparator<Vote> orderByComparator,
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

		List<Vote> list = null;

		if (useFinderCache) {
			list = (List<Vote>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VOTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VOTE;

				sql = sql.concat(VoteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Vote>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the votes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vote vote : findAll()) {
			remove(vote);
		}
	}

	/**
	 * Returns the number of votes.
	 *
	 * @return the number of votes
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VOTE);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "votePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VOTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vote persistence.
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

		_finderPathWithPaginationFindByDeliberationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDeliberationId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"deliberationId"}, true);

		_finderPathWithoutPaginationFindByDeliberationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDeliberationId",
			new String[] {Long.class.getName()},
			new String[] {"deliberationId"}, true);

		_finderPathCountByDeliberationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDeliberationId",
			new String[] {Long.class.getName()},
			new String[] {"deliberationId"}, false);

		_finderPathFetchByDeliberationIdAndOfficialId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByDeliberationIdAndOfficialId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"deliberationId", "officialId"}, true);

		_finderPathCountByDeliberationIdAndOfficialId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDeliberationIdAndOfficialId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"deliberationId", "officialId"}, false);

		_setVoteUtilPersistence(this);
	}

	public void destroy() {
		_setVoteUtilPersistence(null);

		dummyEntityCache.removeCache(VoteImpl.class.getName());
	}

	private void _setVoteUtilPersistence(VotePersistence votePersistence) {
		try {
			Field field = VoteUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, votePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	private static final String _SQL_SELECT_VOTE = "SELECT vote FROM Vote vote";

	private static final String _SQL_SELECT_VOTE_WHERE =
		"SELECT vote FROM Vote vote WHERE ";

	private static final String _SQL_COUNT_VOTE =
		"SELECT COUNT(vote) FROM Vote vote";

	private static final String _SQL_COUNT_VOTE_WHERE =
		"SELECT COUNT(vote) FROM Vote vote WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vote.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Vote exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Vote exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VotePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"officialId", "deliberationId"});

	@Override
	protected FinderCache getFinderCache() {
		return dummyFinderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}