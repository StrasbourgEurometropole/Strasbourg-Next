/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.service.persistence.impl;

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

import eu.strasbourg.service.strasbourg.exception.NoSuchStrasbourgException;
import eu.strasbourg.service.strasbourg.model.Strasbourg;
import eu.strasbourg.service.strasbourg.model.StrasbourgTable;
import eu.strasbourg.service.strasbourg.model.impl.StrasbourgImpl;
import eu.strasbourg.service.strasbourg.model.impl.StrasbourgModelImpl;
import eu.strasbourg.service.strasbourg.service.persistence.StrasbourgPersistence;
import eu.strasbourg.service.strasbourg.service.persistence.StrasbourgUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the strasbourg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StrasbourgPersistenceImpl
	extends BasePersistenceImpl<Strasbourg> implements StrasbourgPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StrasbourgUtil</code> to access the strasbourg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StrasbourgImpl.class.getName();

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
	 * Returns all the strasbourgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching strasbourgs
	 */
	@Override
	public List<Strasbourg> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @return the range of matching strasbourgs
	 */
	@Override
	public List<Strasbourg> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching strasbourgs
	 */
	@Override
	public List<Strasbourg> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Strasbourg> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strasbourgs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching strasbourgs
	 */
	@Override
	public List<Strasbourg> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Strasbourg> orderByComparator,
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

		List<Strasbourg> list = null;

		if (useFinderCache) {
			list = (List<Strasbourg>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Strasbourg strasbourg : list) {
					if (!uuid.equals(strasbourg.getUuid())) {
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

			sb.append(_SQL_SELECT_STRASBOURG_WHERE);

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
				sb.append(StrasbourgModelImpl.ORDER_BY_JPQL);
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

				list = (List<Strasbourg>)QueryUtil.list(
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
	 * Returns the first strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strasbourg
	 * @throws NoSuchStrasbourgException if a matching strasbourg could not be found
	 */
	@Override
	public Strasbourg findByUuid_First(
			String uuid, OrderByComparator<Strasbourg> orderByComparator)
		throws NoSuchStrasbourgException {

		Strasbourg strasbourg = fetchByUuid_First(uuid, orderByComparator);

		if (strasbourg != null) {
			return strasbourg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStrasbourgException(sb.toString());
	}

	/**
	 * Returns the first strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strasbourg, or <code>null</code> if a matching strasbourg could not be found
	 */
	@Override
	public Strasbourg fetchByUuid_First(
		String uuid, OrderByComparator<Strasbourg> orderByComparator) {

		List<Strasbourg> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strasbourg
	 * @throws NoSuchStrasbourgException if a matching strasbourg could not be found
	 */
	@Override
	public Strasbourg findByUuid_Last(
			String uuid, OrderByComparator<Strasbourg> orderByComparator)
		throws NoSuchStrasbourgException {

		Strasbourg strasbourg = fetchByUuid_Last(uuid, orderByComparator);

		if (strasbourg != null) {
			return strasbourg;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStrasbourgException(sb.toString());
	}

	/**
	 * Returns the last strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strasbourg, or <code>null</code> if a matching strasbourg could not be found
	 */
	@Override
	public Strasbourg fetchByUuid_Last(
		String uuid, OrderByComparator<Strasbourg> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Strasbourg> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the strasbourgs before and after the current strasbourg in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current strasbourg
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next strasbourg
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<Strasbourg> orderByComparator)
		throws NoSuchStrasbourgException {

		uuid = Objects.toString(uuid, "");

		Strasbourg strasbourg = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Strasbourg[] array = new StrasbourgImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, strasbourg, uuid, orderByComparator, true);

			array[1] = strasbourg;

			array[2] = getByUuid_PrevAndNext(
				session, strasbourg, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Strasbourg getByUuid_PrevAndNext(
		Session session, Strasbourg strasbourg, String uuid,
		OrderByComparator<Strasbourg> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STRASBOURG_WHERE);

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
			sb.append(StrasbourgModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(strasbourg)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Strasbourg> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the strasbourgs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Strasbourg strasbourg :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(strasbourg);
		}
	}

	/**
	 * Returns the number of strasbourgs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching strasbourgs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STRASBOURG_WHERE);

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
		"strasbourg.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(strasbourg.uuid IS NULL OR strasbourg.uuid = '')";

	public StrasbourgPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Strasbourg.class);

		setModelImplClass(StrasbourgImpl.class);
		setModelPKClass(long.class);

		setTable(StrasbourgTable.INSTANCE);
	}

	/**
	 * Caches the strasbourg in the entity cache if it is enabled.
	 *
	 * @param strasbourg the strasbourg
	 */
	@Override
	public void cacheResult(Strasbourg strasbourg) {
		entityCache.putResult(
			StrasbourgImpl.class, strasbourg.getPrimaryKey(), strasbourg);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the strasbourgs in the entity cache if it is enabled.
	 *
	 * @param strasbourgs the strasbourgs
	 */
	@Override
	public void cacheResult(List<Strasbourg> strasbourgs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (strasbourgs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Strasbourg strasbourg : strasbourgs) {
			if (entityCache.getResult(
					StrasbourgImpl.class, strasbourg.getPrimaryKey()) == null) {

				cacheResult(strasbourg);
			}
		}
	}

	/**
	 * Clears the cache for all strasbourgs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StrasbourgImpl.class);

		finderCache.clearCache(StrasbourgImpl.class);
	}

	/**
	 * Clears the cache for the strasbourg.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Strasbourg strasbourg) {
		entityCache.removeResult(StrasbourgImpl.class, strasbourg);
	}

	@Override
	public void clearCache(List<Strasbourg> strasbourgs) {
		for (Strasbourg strasbourg : strasbourgs) {
			entityCache.removeResult(StrasbourgImpl.class, strasbourg);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StrasbourgImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StrasbourgImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new strasbourg with the primary key. Does not add the strasbourg to the database.
	 *
	 * @param id the primary key for the new strasbourg
	 * @return the new strasbourg
	 */
	@Override
	public Strasbourg create(long id) {
		Strasbourg strasbourg = new StrasbourgImpl();

		strasbourg.setNew(true);
		strasbourg.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		strasbourg.setUuid(uuid);

		return strasbourg;
	}

	/**
	 * Removes the strasbourg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg that was removed
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg remove(long id) throws NoSuchStrasbourgException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the strasbourg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the strasbourg
	 * @return the strasbourg that was removed
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg remove(Serializable primaryKey)
		throws NoSuchStrasbourgException {

		Session session = null;

		try {
			session = openSession();

			Strasbourg strasbourg = (Strasbourg)session.get(
				StrasbourgImpl.class, primaryKey);

			if (strasbourg == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStrasbourgException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(strasbourg);
		}
		catch (NoSuchStrasbourgException noSuchEntityException) {
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
	protected Strasbourg removeImpl(Strasbourg strasbourg) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(strasbourg)) {
				strasbourg = (Strasbourg)session.get(
					StrasbourgImpl.class, strasbourg.getPrimaryKeyObj());
			}

			if (strasbourg != null) {
				session.delete(strasbourg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (strasbourg != null) {
			clearCache(strasbourg);
		}

		return strasbourg;
	}

	@Override
	public Strasbourg updateImpl(Strasbourg strasbourg) {
		boolean isNew = strasbourg.isNew();

		if (!(strasbourg instanceof StrasbourgModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(strasbourg.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(strasbourg);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in strasbourg proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Strasbourg implementation " +
					strasbourg.getClass());
		}

		StrasbourgModelImpl strasbourgModelImpl =
			(StrasbourgModelImpl)strasbourg;

		if (Validator.isNull(strasbourg.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			strasbourg.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(strasbourg);
			}
			else {
				strasbourg = (Strasbourg)session.merge(strasbourg);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			StrasbourgImpl.class, strasbourgModelImpl, false, true);

		if (isNew) {
			strasbourg.setNew(false);
		}

		strasbourg.resetOriginalValues();

		return strasbourg;
	}

	/**
	 * Returns the strasbourg with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the strasbourg
	 * @return the strasbourg
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStrasbourgException {

		Strasbourg strasbourg = fetchByPrimaryKey(primaryKey);

		if (strasbourg == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStrasbourgException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return strasbourg;
	}

	/**
	 * Returns the strasbourg with the primary key or throws a <code>NoSuchStrasbourgException</code> if it could not be found.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg
	 * @throws NoSuchStrasbourgException if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg findByPrimaryKey(long id)
		throws NoSuchStrasbourgException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the strasbourg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the strasbourg
	 * @return the strasbourg, or <code>null</code> if a strasbourg with the primary key could not be found
	 */
	@Override
	public Strasbourg fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the strasbourgs.
	 *
	 * @return the strasbourgs
	 */
	@Override
	public List<Strasbourg> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @return the range of strasbourgs
	 */
	@Override
	public List<Strasbourg> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strasbourgs
	 */
	@Override
	public List<Strasbourg> findAll(
		int start, int end, OrderByComparator<Strasbourg> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strasbourgs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StrasbourgModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of strasbourgs
	 * @param end the upper bound of the range of strasbourgs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of strasbourgs
	 */
	@Override
	public List<Strasbourg> findAll(
		int start, int end, OrderByComparator<Strasbourg> orderByComparator,
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

		List<Strasbourg> list = null;

		if (useFinderCache) {
			list = (List<Strasbourg>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STRASBOURG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STRASBOURG;

				sql = sql.concat(StrasbourgModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Strasbourg>)QueryUtil.list(
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
	 * Removes all the strasbourgs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Strasbourg strasbourg : findAll()) {
			remove(strasbourg);
		}
	}

	/**
	 * Returns the number of strasbourgs.
	 *
	 * @return the number of strasbourgs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STRASBOURG);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STRASBOURG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StrasbourgModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the strasbourg persistence.
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

		StrasbourgUtil.setPersistence(this);
	}

	public void destroy() {
		StrasbourgUtil.setPersistence(null);

		entityCache.removeCache(StrasbourgImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STRASBOURG =
		"SELECT strasbourg FROM Strasbourg strasbourg";

	private static final String _SQL_SELECT_STRASBOURG_WHERE =
		"SELECT strasbourg FROM Strasbourg strasbourg WHERE ";

	private static final String _SQL_COUNT_STRASBOURG =
		"SELECT COUNT(strasbourg) FROM Strasbourg strasbourg";

	private static final String _SQL_COUNT_STRASBOURG_WHERE =
		"SELECT COUNT(strasbourg) FROM Strasbourg strasbourg WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "strasbourg.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Strasbourg exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Strasbourg exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StrasbourgPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}