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

package eu.strasbourg.service.project.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.exception.NoSuchSaisineObservatoireException;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.model.SaisineObservatoireTable;
import eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl;
import eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl;
import eu.strasbourg.service.project.service.persistence.SaisineObservatoirePersistence;
import eu.strasbourg.service.project.service.persistence.SaisineObservatoireUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the saisine observatoire service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @generated
 */
public class SaisineObservatoirePersistenceImpl
	extends BasePersistenceImpl<SaisineObservatoire>
	implements SaisineObservatoirePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SaisineObservatoireUtil</code> to access the saisine observatoire persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SaisineObservatoireImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
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

		List<SaisineObservatoire> list = null;

		if (useFinderCache) {
			list = (List<SaisineObservatoire>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SaisineObservatoire saisineObservatoire : list) {
					if (groupId != saisineObservatoire.getGroupId()) {
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

			sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<SaisineObservatoire>)QueryUtil.list(
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
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByGroupId_First(
			long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByGroupId_First(
			groupId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByGroupId_First(
		long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		List<SaisineObservatoire> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByGroupId_Last(
			long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByGroupId_Last(
		long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<SaisineObservatoire> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where groupId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire[] findByGroupId_PrevAndNext(
			long saisineObservatoireId, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = findByPrimaryKey(
			saisineObservatoireId);

		Session session = null;

		try {
			session = openSession();

			SaisineObservatoire[] array = new SaisineObservatoireImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, saisineObservatoire, groupId, orderByComparator, true);

			array[1] = saisineObservatoire;

			array[2] = getByGroupId_PrevAndNext(
				session, saisineObservatoire, groupId, orderByComparator,
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

	protected SaisineObservatoire getByGroupId_PrevAndNext(
		Session session, SaisineObservatoire saisineObservatoire, long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator,
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

		sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

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
			sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						saisineObservatoire)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SaisineObservatoire> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the saisine observatoires where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (SaisineObservatoire saisineObservatoire :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(saisineObservatoire);
		}
	}

	/**
	 * Returns the number of saisine observatoires where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAISINEOBSERVATOIRE_WHERE);

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
		"saisineObservatoire.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathWithoutPaginationFindByStatusAndGroupId;
	private FinderPath _finderPathCountByStatusAndGroupId;

	/**
	 * Returns all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId) {

		return findByStatusAndGroupId(
			status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return findByStatusAndGroupId(status, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatusAndGroupId;
				finderArgs = new Object[] {status, groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatusAndGroupId;
			finderArgs = new Object[] {
				status, groupId, start, end, orderByComparator
			};
		}

		List<SaisineObservatoire> list = null;

		if (useFinderCache) {
			list = (List<SaisineObservatoire>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SaisineObservatoire saisineObservatoire : list) {
					if ((status != saisineObservatoire.getStatus()) ||
						(groupId != saisineObservatoire.getGroupId())) {

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

			sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				queryPos.add(groupId);

				list = (List<SaisineObservatoire>)QueryUtil.list(
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
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		List<SaisineObservatoire> list = findByStatusAndGroupId(
			status, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append(", groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		int count = countByStatusAndGroupId(status, groupId);

		if (count == 0) {
			return null;
		}

		List<SaisineObservatoire> list = findByStatusAndGroupId(
			status, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire[] findByStatusAndGroupId_PrevAndNext(
			long saisineObservatoireId, int status, long groupId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = findByPrimaryKey(
			saisineObservatoireId);

		Session session = null;

		try {
			session = openSession();

			SaisineObservatoire[] array = new SaisineObservatoireImpl[3];

			array[0] = getByStatusAndGroupId_PrevAndNext(
				session, saisineObservatoire, status, groupId,
				orderByComparator, true);

			array[1] = saisineObservatoire;

			array[2] = getByStatusAndGroupId_PrevAndNext(
				session, saisineObservatoire, status, groupId,
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

	protected SaisineObservatoire getByStatusAndGroupId_PrevAndNext(
		Session session, SaisineObservatoire saisineObservatoire, int status,
		long groupId, OrderByComparator<SaisineObservatoire> orderByComparator,
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

		sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

		sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

		sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

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
			sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						saisineObservatoire)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SaisineObservatoire> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the saisine observatoires where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	@Override
	public void removeByStatusAndGroupId(int status, long groupId) {
		for (SaisineObservatoire saisineObservatoire :
				findByStatusAndGroupId(
					status, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(saisineObservatoire);
		}
	}

	/**
	 * Returns the number of saisine observatoires where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching saisine observatoires
	 */
	@Override
	public int countByStatusAndGroupId(int status, long groupId) {
		FinderPath finderPath = _finderPathCountByStatusAndGroupId;

		Object[] finderArgs = new Object[] {status, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SAISINEOBSERVATOIRE_WHERE);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_STATUS_2);

			sb.append(_FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUSANDGROUPID_STATUS_2 =
		"saisineObservatoire.status = ? AND ";

	private static final String _FINDER_COLUMN_STATUSANDGROUPID_GROUPID_2 =
		"saisineObservatoire.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPublikId;
	private FinderPath _finderPathWithoutPaginationFindByPublikId;
	private FinderPath _finderPathCountByPublikId;

	/**
	 * Returns all the saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByPublikId(String publikId) {
		return findByPublikId(
			publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end) {

		return findByPublikId(publikId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return findByPublikId(publikId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findByPublikId(
		String publikId, int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
		boolean useFinderCache) {

		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPublikId;
				finderArgs = new Object[] {publikId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPublikId;
			finderArgs = new Object[] {publikId, start, end, orderByComparator};
		}

		List<SaisineObservatoire> list = null;

		if (useFinderCache) {
			list = (List<SaisineObservatoire>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SaisineObservatoire saisineObservatoire : list) {
					if (!publikId.equals(saisineObservatoire.getPublikId())) {
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

			sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

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
				sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
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

				list = (List<SaisineObservatoire>)QueryUtil.list(
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
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByPublikId_First(
			String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByPublikId_First(
			publikId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the first saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByPublikId_First(
		String publikId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		List<SaisineObservatoire> list = findByPublikId(
			publikId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire findByPublikId_Last(
			String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByPublikId_Last(
			publikId, orderByComparator);

		if (saisineObservatoire != null) {
			return saisineObservatoire;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publikId=");
		sb.append(publikId);

		sb.append("}");

		throw new NoSuchSaisineObservatoireException(sb.toString());
	}

	/**
	 * Returns the last saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching saisine observatoire, or <code>null</code> if a matching saisine observatoire could not be found
	 */
	@Override
	public SaisineObservatoire fetchByPublikId_Last(
		String publikId,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		int count = countByPublikId(publikId);

		if (count == 0) {
			return null;
		}

		List<SaisineObservatoire> list = findByPublikId(
			publikId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the saisine observatoires before and after the current saisine observatoire in the ordered set where publikId = &#63;.
	 *
	 * @param saisineObservatoireId the primary key of the current saisine observatoire
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire[] findByPublikId_PrevAndNext(
			long saisineObservatoireId, String publikId,
			OrderByComparator<SaisineObservatoire> orderByComparator)
		throws NoSuchSaisineObservatoireException {

		publikId = Objects.toString(publikId, "");

		SaisineObservatoire saisineObservatoire = findByPrimaryKey(
			saisineObservatoireId);

		Session session = null;

		try {
			session = openSession();

			SaisineObservatoire[] array = new SaisineObservatoireImpl[3];

			array[0] = getByPublikId_PrevAndNext(
				session, saisineObservatoire, publikId, orderByComparator,
				true);

			array[1] = saisineObservatoire;

			array[2] = getByPublikId_PrevAndNext(
				session, saisineObservatoire, publikId, orderByComparator,
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

	protected SaisineObservatoire getByPublikId_PrevAndNext(
		Session session, SaisineObservatoire saisineObservatoire,
		String publikId,
		OrderByComparator<SaisineObservatoire> orderByComparator,
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

		sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE_WHERE);

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
			sb.append(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						saisineObservatoire)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SaisineObservatoire> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the saisine observatoires where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	@Override
	public void removeByPublikId(String publikId) {
		for (SaisineObservatoire saisineObservatoire :
				findByPublikId(
					publikId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(saisineObservatoire);
		}
	}

	/**
	 * Returns the number of saisine observatoires where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching saisine observatoires
	 */
	@Override
	public int countByPublikId(String publikId) {
		publikId = Objects.toString(publikId, "");

		FinderPath finderPath = _finderPathCountByPublikId;

		Object[] finderArgs = new Object[] {publikId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SAISINEOBSERVATOIRE_WHERE);

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
		"saisineObservatoire.publikId = ?";

	private static final String _FINDER_COLUMN_PUBLIKID_PUBLIKID_3 =
		"(saisineObservatoire.publikId IS NULL OR saisineObservatoire.publikId = '')";

	public SaisineObservatoirePersistenceImpl() {
		setModelClass(SaisineObservatoire.class);

		setModelImplClass(SaisineObservatoireImpl.class);
		setModelPKClass(long.class);

		setTable(SaisineObservatoireTable.INSTANCE);
	}

	/**
	 * Caches the saisine observatoire in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoire the saisine observatoire
	 */
	@Override
	public void cacheResult(SaisineObservatoire saisineObservatoire) {
		entityCache.putResult(
			SaisineObservatoireImpl.class, saisineObservatoire.getPrimaryKey(),
			saisineObservatoire);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the saisine observatoires in the entity cache if it is enabled.
	 *
	 * @param saisineObservatoires the saisine observatoires
	 */
	@Override
	public void cacheResult(List<SaisineObservatoire> saisineObservatoires) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (saisineObservatoires.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SaisineObservatoire saisineObservatoire : saisineObservatoires) {
			if (entityCache.getResult(
					SaisineObservatoireImpl.class,
					saisineObservatoire.getPrimaryKey()) == null) {

				cacheResult(saisineObservatoire);
			}
		}
	}

	/**
	 * Clears the cache for all saisine observatoires.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SaisineObservatoireImpl.class);

		finderCache.clearCache(SaisineObservatoireImpl.class);
	}

	/**
	 * Clears the cache for the saisine observatoire.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SaisineObservatoire saisineObservatoire) {
		entityCache.removeResult(
			SaisineObservatoireImpl.class, saisineObservatoire);
	}

	@Override
	public void clearCache(List<SaisineObservatoire> saisineObservatoires) {
		for (SaisineObservatoire saisineObservatoire : saisineObservatoires) {
			entityCache.removeResult(
				SaisineObservatoireImpl.class, saisineObservatoire);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SaisineObservatoireImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(SaisineObservatoireImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	@Override
	public SaisineObservatoire create(long saisineObservatoireId) {
		SaisineObservatoire saisineObservatoire = new SaisineObservatoireImpl();

		saisineObservatoire.setNew(true);
		saisineObservatoire.setPrimaryKey(saisineObservatoireId);

		saisineObservatoire.setCompanyId(CompanyThreadLocal.getCompanyId());

		return saisineObservatoire;
	}

	/**
	 * Removes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire remove(long saisineObservatoireId)
		throws NoSuchSaisineObservatoireException {

		return remove((Serializable)saisineObservatoireId);
	}

	/**
	 * Removes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire remove(Serializable primaryKey)
		throws NoSuchSaisineObservatoireException {

		Session session = null;

		try {
			session = openSession();

			SaisineObservatoire saisineObservatoire =
				(SaisineObservatoire)session.get(
					SaisineObservatoireImpl.class, primaryKey);

			if (saisineObservatoire == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSaisineObservatoireException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(saisineObservatoire);
		}
		catch (NoSuchSaisineObservatoireException noSuchEntityException) {
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
	protected SaisineObservatoire removeImpl(
		SaisineObservatoire saisineObservatoire) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(saisineObservatoire)) {
				saisineObservatoire = (SaisineObservatoire)session.get(
					SaisineObservatoireImpl.class,
					saisineObservatoire.getPrimaryKeyObj());
			}

			if (saisineObservatoire != null) {
				session.delete(saisineObservatoire);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (saisineObservatoire != null) {
			clearCache(saisineObservatoire);
		}

		return saisineObservatoire;
	}

	@Override
	public SaisineObservatoire updateImpl(
		SaisineObservatoire saisineObservatoire) {

		boolean isNew = saisineObservatoire.isNew();

		if (!(saisineObservatoire instanceof SaisineObservatoireModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(saisineObservatoire.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					saisineObservatoire);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in saisineObservatoire proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SaisineObservatoire implementation " +
					saisineObservatoire.getClass());
		}

		SaisineObservatoireModelImpl saisineObservatoireModelImpl =
			(SaisineObservatoireModelImpl)saisineObservatoire;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (saisineObservatoire.getCreateDate() == null)) {
			if (serviceContext == null) {
				saisineObservatoire.setCreateDate(date);
			}
			else {
				saisineObservatoire.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!saisineObservatoireModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				saisineObservatoire.setModifiedDate(date);
			}
			else {
				saisineObservatoire.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(saisineObservatoire);
			}
			else {
				saisineObservatoire = (SaisineObservatoire)session.merge(
					saisineObservatoire);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SaisineObservatoireImpl.class, saisineObservatoireModelImpl, false,
			true);

		if (isNew) {
			saisineObservatoire.setNew(false);
		}

		saisineObservatoire.resetOriginalValues();

		return saisineObservatoire;
	}

	/**
	 * Returns the saisine observatoire with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSaisineObservatoireException {

		SaisineObservatoire saisineObservatoire = fetchByPrimaryKey(primaryKey);

		if (saisineObservatoire == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSaisineObservatoireException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return saisineObservatoire;
	}

	/**
	 * Returns the saisine observatoire with the primary key or throws a <code>NoSuchSaisineObservatoireException</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws NoSuchSaisineObservatoireException if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire findByPrimaryKey(long saisineObservatoireId)
		throws NoSuchSaisineObservatoireException {

		return findByPrimaryKey((Serializable)saisineObservatoireId);
	}

	/**
	 * Returns the saisine observatoire with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire, or <code>null</code> if a saisine observatoire with the primary key could not be found
	 */
	@Override
	public SaisineObservatoire fetchByPrimaryKey(long saisineObservatoireId) {
		return fetchByPrimaryKey((Serializable)saisineObservatoireId);
	}

	/**
	 * Returns all the saisine observatoires.
	 *
	 * @return the saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findAll(
		int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of saisine observatoires
	 */
	@Override
	public List<SaisineObservatoire> findAll(
		int start, int end,
		OrderByComparator<SaisineObservatoire> orderByComparator,
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

		List<SaisineObservatoire> list = null;

		if (useFinderCache) {
			list = (List<SaisineObservatoire>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SAISINEOBSERVATOIRE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SAISINEOBSERVATOIRE;

				sql = sql.concat(SaisineObservatoireModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SaisineObservatoire>)QueryUtil.list(
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
	 * Removes all the saisine observatoires from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SaisineObservatoire saisineObservatoire : findAll()) {
			remove(saisineObservatoire);
		}
	}

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
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
					_SQL_COUNT_SAISINEOBSERVATOIRE);

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
		return "saisineObservatoireId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SAISINEOBSERVATOIRE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SaisineObservatoireModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the saisine observatoire persistence.
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

		_finderPathWithPaginationFindByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatusAndGroupId",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"status", "groupId"}, true);

		_finderPathWithoutPaginationFindByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatusAndGroupId",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, true);

		_finderPathCountByStatusAndGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByStatusAndGroupId",
			new String[] {Integer.class.getName(), Long.class.getName()},
			new String[] {"status", "groupId"}, false);

		_finderPathWithPaginationFindByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPublikId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"publikId"}, true);

		_finderPathWithoutPaginationFindByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			true);

		_finderPathCountByPublikId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPublikId",
			new String[] {String.class.getName()}, new String[] {"publikId"},
			false);

		_setSaisineObservatoireUtilPersistence(this);
	}

	public void destroy() {
		_setSaisineObservatoireUtilPersistence(null);

		entityCache.removeCache(SaisineObservatoireImpl.class.getName());
	}

	private void _setSaisineObservatoireUtilPersistence(
		SaisineObservatoirePersistence saisineObservatoirePersistence) {

		try {
			Field field = SaisineObservatoireUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, saisineObservatoirePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SAISINEOBSERVATOIRE =
		"SELECT saisineObservatoire FROM SaisineObservatoire saisineObservatoire";

	private static final String _SQL_SELECT_SAISINEOBSERVATOIRE_WHERE =
		"SELECT saisineObservatoire FROM SaisineObservatoire saisineObservatoire WHERE ";

	private static final String _SQL_COUNT_SAISINEOBSERVATOIRE =
		"SELECT COUNT(saisineObservatoire) FROM SaisineObservatoire saisineObservatoire";

	private static final String _SQL_COUNT_SAISINEOBSERVATOIRE_WHERE =
		"SELECT COUNT(saisineObservatoire) FROM SaisineObservatoire saisineObservatoire WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "saisineObservatoire.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SaisineObservatoire exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SaisineObservatoire exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SaisineObservatoirePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}