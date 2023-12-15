/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.service.persistence.impl;

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
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notif.exception.NoSuchNatureNotifException;
import eu.strasbourg.service.notif.model.NatureNotif;
import eu.strasbourg.service.notif.model.NatureNotifTable;
import eu.strasbourg.service.notif.model.impl.NatureNotifImpl;
import eu.strasbourg.service.notif.model.impl.NatureNotifModelImpl;
import eu.strasbourg.service.notif.service.persistence.NatureNotifPersistence;
import eu.strasbourg.service.notif.service.persistence.NatureNotifUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the nature notif service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class NatureNotifPersistenceImpl
	extends BasePersistenceImpl<NatureNotif> implements NatureNotifPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NatureNotifUtil</code> to access the nature notif persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NatureNotifImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByServiceId;
	private FinderPath _finderPathWithoutPaginationFindByServiceId;
	private FinderPath _finderPathCountByServiceId;

	/**
	 * Returns all the nature notifs where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the matching nature notifs
	 */
	@Override
	public List<NatureNotif> findByServiceId(long serviceId) {
		return findByServiceId(
			serviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nature notifs where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @return the range of matching nature notifs
	 */
	@Override
	public List<NatureNotif> findByServiceId(
		long serviceId, int start, int end) {

		return findByServiceId(serviceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the nature notifs where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching nature notifs
	 */
	@Override
	public List<NatureNotif> findByServiceId(
		long serviceId, int start, int end,
		OrderByComparator<NatureNotif> orderByComparator) {

		return findByServiceId(serviceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the nature notifs where serviceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param serviceId the service ID
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching nature notifs
	 */
	@Override
	public List<NatureNotif> findByServiceId(
		long serviceId, int start, int end,
		OrderByComparator<NatureNotif> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByServiceId;
				finderArgs = new Object[] {serviceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByServiceId;
			finderArgs = new Object[] {
				serviceId, start, end, orderByComparator
			};
		}

		List<NatureNotif> list = null;

		if (useFinderCache) {
			list = (List<NatureNotif>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (NatureNotif natureNotif : list) {
					if (serviceId != natureNotif.getServiceId()) {
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

			sb.append(_SQL_SELECT_NATURENOTIF_WHERE);

			sb.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NatureNotifModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceId);

				list = (List<NatureNotif>)QueryUtil.list(
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
	 * Returns the first nature notif in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nature notif
	 * @throws NoSuchNatureNotifException if a matching nature notif could not be found
	 */
	@Override
	public NatureNotif findByServiceId_First(
			long serviceId, OrderByComparator<NatureNotif> orderByComparator)
		throws NoSuchNatureNotifException {

		NatureNotif natureNotif = fetchByServiceId_First(
			serviceId, orderByComparator);

		if (natureNotif != null) {
			return natureNotif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceId=");
		sb.append(serviceId);

		sb.append("}");

		throw new NoSuchNatureNotifException(sb.toString());
	}

	/**
	 * Returns the first nature notif in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching nature notif, or <code>null</code> if a matching nature notif could not be found
	 */
	@Override
	public NatureNotif fetchByServiceId_First(
		long serviceId, OrderByComparator<NatureNotif> orderByComparator) {

		List<NatureNotif> list = findByServiceId(
			serviceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last nature notif in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nature notif
	 * @throws NoSuchNatureNotifException if a matching nature notif could not be found
	 */
	@Override
	public NatureNotif findByServiceId_Last(
			long serviceId, OrderByComparator<NatureNotif> orderByComparator)
		throws NoSuchNatureNotifException {

		NatureNotif natureNotif = fetchByServiceId_Last(
			serviceId, orderByComparator);

		if (natureNotif != null) {
			return natureNotif;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("serviceId=");
		sb.append(serviceId);

		sb.append("}");

		throw new NoSuchNatureNotifException(sb.toString());
	}

	/**
	 * Returns the last nature notif in the ordered set where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching nature notif, or <code>null</code> if a matching nature notif could not be found
	 */
	@Override
	public NatureNotif fetchByServiceId_Last(
		long serviceId, OrderByComparator<NatureNotif> orderByComparator) {

		int count = countByServiceId(serviceId);

		if (count == 0) {
			return null;
		}

		List<NatureNotif> list = findByServiceId(
			serviceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the nature notifs before and after the current nature notif in the ordered set where serviceId = &#63;.
	 *
	 * @param natureId the primary key of the current nature notif
	 * @param serviceId the service ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next nature notif
	 * @throws NoSuchNatureNotifException if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif[] findByServiceId_PrevAndNext(
			long natureId, long serviceId,
			OrderByComparator<NatureNotif> orderByComparator)
		throws NoSuchNatureNotifException {

		NatureNotif natureNotif = findByPrimaryKey(natureId);

		Session session = null;

		try {
			session = openSession();

			NatureNotif[] array = new NatureNotifImpl[3];

			array[0] = getByServiceId_PrevAndNext(
				session, natureNotif, serviceId, orderByComparator, true);

			array[1] = natureNotif;

			array[2] = getByServiceId_PrevAndNext(
				session, natureNotif, serviceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected NatureNotif getByServiceId_PrevAndNext(
		Session session, NatureNotif natureNotif, long serviceId,
		OrderByComparator<NatureNotif> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NATURENOTIF_WHERE);

		sb.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

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
			sb.append(NatureNotifModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(serviceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(natureNotif)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<NatureNotif> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the nature notifs where serviceId = &#63; from the database.
	 *
	 * @param serviceId the service ID
	 */
	@Override
	public void removeByServiceId(long serviceId) {
		for (NatureNotif natureNotif :
				findByServiceId(
					serviceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(natureNotif);
		}
	}

	/**
	 * Returns the number of nature notifs where serviceId = &#63;.
	 *
	 * @param serviceId the service ID
	 * @return the number of matching nature notifs
	 */
	@Override
	public int countByServiceId(long serviceId) {
		FinderPath finderPath = _finderPathCountByServiceId;

		Object[] finderArgs = new Object[] {serviceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NATURENOTIF_WHERE);

			sb.append(_FINDER_COLUMN_SERVICEID_SERVICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(serviceId);

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

	private static final String _FINDER_COLUMN_SERVICEID_SERVICEID_2 =
		"natureNotif.serviceId = ?";

	public NatureNotifPersistenceImpl() {
		setModelClass(NatureNotif.class);

		setModelImplClass(NatureNotifImpl.class);
		setModelPKClass(long.class);

		setTable(NatureNotifTable.INSTANCE);
	}

	/**
	 * Caches the nature notif in the entity cache if it is enabled.
	 *
	 * @param natureNotif the nature notif
	 */
	@Override
	public void cacheResult(NatureNotif natureNotif) {
		entityCache.putResult(
			NatureNotifImpl.class, natureNotif.getPrimaryKey(), natureNotif);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the nature notifs in the entity cache if it is enabled.
	 *
	 * @param natureNotifs the nature notifs
	 */
	@Override
	public void cacheResult(List<NatureNotif> natureNotifs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (natureNotifs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NatureNotif natureNotif : natureNotifs) {
			if (entityCache.getResult(
					NatureNotifImpl.class, natureNotif.getPrimaryKey()) ==
						null) {

				cacheResult(natureNotif);
			}
		}
	}

	/**
	 * Clears the cache for all nature notifs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NatureNotifImpl.class);

		finderCache.clearCache(NatureNotifImpl.class);
	}

	/**
	 * Clears the cache for the nature notif.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NatureNotif natureNotif) {
		entityCache.removeResult(NatureNotifImpl.class, natureNotif);
	}

	@Override
	public void clearCache(List<NatureNotif> natureNotifs) {
		for (NatureNotif natureNotif : natureNotifs) {
			entityCache.removeResult(NatureNotifImpl.class, natureNotif);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(NatureNotifImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NatureNotifImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new nature notif with the primary key. Does not add the nature notif to the database.
	 *
	 * @param natureId the primary key for the new nature notif
	 * @return the new nature notif
	 */
	@Override
	public NatureNotif create(long natureId) {
		NatureNotif natureNotif = new NatureNotifImpl();

		natureNotif.setNew(true);
		natureNotif.setPrimaryKey(natureId);

		return natureNotif;
	}

	/**
	 * Removes the nature notif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param natureId the primary key of the nature notif
	 * @return the nature notif that was removed
	 * @throws NoSuchNatureNotifException if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif remove(long natureId) throws NoSuchNatureNotifException {
		return remove((Serializable)natureId);
	}

	/**
	 * Removes the nature notif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nature notif
	 * @return the nature notif that was removed
	 * @throws NoSuchNatureNotifException if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif remove(Serializable primaryKey)
		throws NoSuchNatureNotifException {

		Session session = null;

		try {
			session = openSession();

			NatureNotif natureNotif = (NatureNotif)session.get(
				NatureNotifImpl.class, primaryKey);

			if (natureNotif == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNatureNotifException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(natureNotif);
		}
		catch (NoSuchNatureNotifException noSuchEntityException) {
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
	protected NatureNotif removeImpl(NatureNotif natureNotif) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(natureNotif)) {
				natureNotif = (NatureNotif)session.get(
					NatureNotifImpl.class, natureNotif.getPrimaryKeyObj());
			}

			if (natureNotif != null) {
				session.delete(natureNotif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (natureNotif != null) {
			clearCache(natureNotif);
		}

		return natureNotif;
	}

	@Override
	public NatureNotif updateImpl(NatureNotif natureNotif) {
		boolean isNew = natureNotif.isNew();

		if (!(natureNotif instanceof NatureNotifModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(natureNotif.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(natureNotif);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in natureNotif proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom NatureNotif implementation " +
					natureNotif.getClass());
		}

		NatureNotifModelImpl natureNotifModelImpl =
			(NatureNotifModelImpl)natureNotif;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(natureNotif);
			}
			else {
				natureNotif = (NatureNotif)session.merge(natureNotif);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			NatureNotifImpl.class, natureNotifModelImpl, false, true);

		if (isNew) {
			natureNotif.setNew(false);
		}

		natureNotif.resetOriginalValues();

		return natureNotif;
	}

	/**
	 * Returns the nature notif with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nature notif
	 * @return the nature notif
	 * @throws NoSuchNatureNotifException if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNatureNotifException {

		NatureNotif natureNotif = fetchByPrimaryKey(primaryKey);

		if (natureNotif == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNatureNotifException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return natureNotif;
	}

	/**
	 * Returns the nature notif with the primary key or throws a <code>NoSuchNatureNotifException</code> if it could not be found.
	 *
	 * @param natureId the primary key of the nature notif
	 * @return the nature notif
	 * @throws NoSuchNatureNotifException if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif findByPrimaryKey(long natureId)
		throws NoSuchNatureNotifException {

		return findByPrimaryKey((Serializable)natureId);
	}

	/**
	 * Returns the nature notif with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param natureId the primary key of the nature notif
	 * @return the nature notif, or <code>null</code> if a nature notif with the primary key could not be found
	 */
	@Override
	public NatureNotif fetchByPrimaryKey(long natureId) {
		return fetchByPrimaryKey((Serializable)natureId);
	}

	/**
	 * Returns all the nature notifs.
	 *
	 * @return the nature notifs
	 */
	@Override
	public List<NatureNotif> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nature notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @return the range of nature notifs
	 */
	@Override
	public List<NatureNotif> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nature notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nature notifs
	 */
	@Override
	public List<NatureNotif> findAll(
		int start, int end, OrderByComparator<NatureNotif> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the nature notifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NatureNotifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nature notifs
	 * @param end the upper bound of the range of nature notifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nature notifs
	 */
	@Override
	public List<NatureNotif> findAll(
		int start, int end, OrderByComparator<NatureNotif> orderByComparator,
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

		List<NatureNotif> list = null;

		if (useFinderCache) {
			list = (List<NatureNotif>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NATURENOTIF);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NATURENOTIF;

				sql = sql.concat(NatureNotifModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NatureNotif>)QueryUtil.list(
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
	 * Removes all the nature notifs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NatureNotif natureNotif : findAll()) {
			remove(natureNotif);
		}
	}

	/**
	 * Returns the number of nature notifs.
	 *
	 * @return the number of nature notifs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NATURENOTIF);

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
		return "natureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NATURENOTIF;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NatureNotifModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nature notif persistence.
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

		_finderPathWithPaginationFindByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByServiceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"serviceId"}, true);

		_finderPathWithoutPaginationFindByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByServiceId",
			new String[] {Long.class.getName()}, new String[] {"serviceId"},
			true);

		_finderPathCountByServiceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByServiceId",
			new String[] {Long.class.getName()}, new String[] {"serviceId"},
			false);

		NatureNotifUtil.setPersistence(this);
	}

	public void destroy() {
		NatureNotifUtil.setPersistence(null);

		entityCache.removeCache(NatureNotifImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NATURENOTIF =
		"SELECT natureNotif FROM NatureNotif natureNotif";

	private static final String _SQL_SELECT_NATURENOTIF_WHERE =
		"SELECT natureNotif FROM NatureNotif natureNotif WHERE ";

	private static final String _SQL_COUNT_NATURENOTIF =
		"SELECT COUNT(natureNotif) FROM NatureNotif natureNotif";

	private static final String _SQL_COUNT_NATURENOTIF_WHERE =
		"SELECT COUNT(natureNotif) FROM NatureNotif natureNotif WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "natureNotif.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NatureNotif exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No NatureNotif exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NatureNotifPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}