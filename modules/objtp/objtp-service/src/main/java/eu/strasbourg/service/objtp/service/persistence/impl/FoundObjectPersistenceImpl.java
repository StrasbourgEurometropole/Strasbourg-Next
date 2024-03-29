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

package eu.strasbourg.service.objtp.service.persistence.impl;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.objtp.exception.NoSuchFoundObjectException;
import eu.strasbourg.service.objtp.model.FoundObject;
import eu.strasbourg.service.objtp.model.impl.FoundObjectImpl;
import eu.strasbourg.service.objtp.model.impl.FoundObjectModelImpl;
import eu.strasbourg.service.objtp.service.persistence.FoundObjectPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the found object service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author JeremyZwickert
 * @generated
 */
public class FoundObjectPersistenceImpl
	extends BasePersistenceImpl<FoundObject> implements FoundObjectPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FoundObjectUtil</code> to access the found object persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FoundObjectImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCategoryCode;
	private FinderPath _finderPathWithoutPaginationFindByCategoryCode;
	private FinderPath _finderPathCountByCategoryCode;

	/**
	 * Returns all the found objects where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @return the matching found objects
	 */
	@Override
	public List<FoundObject> findByCategoryCode(String categoryCode) {
		return findByCategoryCode(
			categoryCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the found objects where categoryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param categoryCode the category code
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @return the range of matching found objects
	 */
	@Override
	public List<FoundObject> findByCategoryCode(
		String categoryCode, int start, int end) {

		return findByCategoryCode(categoryCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the found objects where categoryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param categoryCode the category code
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching found objects
	 */
	@Override
	public List<FoundObject> findByCategoryCode(
		String categoryCode, int start, int end,
		OrderByComparator<FoundObject> orderByComparator) {

		return findByCategoryCode(
			categoryCode, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the found objects where categoryCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param categoryCode the category code
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching found objects
	 */
	@Override
	public List<FoundObject> findByCategoryCode(
		String categoryCode, int start, int end,
		OrderByComparator<FoundObject> orderByComparator,
		boolean useFinderCache) {

		categoryCode = Objects.toString(categoryCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategoryCode;
				finderArgs = new Object[] {categoryCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategoryCode;
			finderArgs = new Object[] {
				categoryCode, start, end, orderByComparator
			};
		}

		List<FoundObject> list = null;

		if (useFinderCache) {
			list = (List<FoundObject>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FoundObject foundObject : list) {
					if (!categoryCode.equals(foundObject.getCategoryCode())) {
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

			sb.append(_SQL_SELECT_FOUNDOBJECT_WHERE);

			boolean bindCategoryCode = false;

			if (categoryCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_3);
			}
			else {
				bindCategoryCode = true;

				sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FoundObjectModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryCode) {
					queryPos.add(categoryCode);
				}

				list = (List<FoundObject>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first found object in the ordered set where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching found object
	 * @throws NoSuchFoundObjectException if a matching found object could not be found
	 */
	@Override
	public FoundObject findByCategoryCode_First(
			String categoryCode,
			OrderByComparator<FoundObject> orderByComparator)
		throws NoSuchFoundObjectException {

		FoundObject foundObject = fetchByCategoryCode_First(
			categoryCode, orderByComparator);

		if (foundObject != null) {
			return foundObject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryCode=");
		sb.append(categoryCode);

		sb.append("}");

		throw new NoSuchFoundObjectException(sb.toString());
	}

	/**
	 * Returns the first found object in the ordered set where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching found object, or <code>null</code> if a matching found object could not be found
	 */
	@Override
	public FoundObject fetchByCategoryCode_First(
		String categoryCode, OrderByComparator<FoundObject> orderByComparator) {

		List<FoundObject> list = findByCategoryCode(
			categoryCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last found object in the ordered set where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching found object
	 * @throws NoSuchFoundObjectException if a matching found object could not be found
	 */
	@Override
	public FoundObject findByCategoryCode_Last(
			String categoryCode,
			OrderByComparator<FoundObject> orderByComparator)
		throws NoSuchFoundObjectException {

		FoundObject foundObject = fetchByCategoryCode_Last(
			categoryCode, orderByComparator);

		if (foundObject != null) {
			return foundObject;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryCode=");
		sb.append(categoryCode);

		sb.append("}");

		throw new NoSuchFoundObjectException(sb.toString());
	}

	/**
	 * Returns the last found object in the ordered set where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching found object, or <code>null</code> if a matching found object could not be found
	 */
	@Override
	public FoundObject fetchByCategoryCode_Last(
		String categoryCode, OrderByComparator<FoundObject> orderByComparator) {

		int count = countByCategoryCode(categoryCode);

		if (count == 0) {
			return null;
		}

		List<FoundObject> list = findByCategoryCode(
			categoryCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the found objects before and after the current found object in the ordered set where categoryCode = &#63;.
	 *
	 * @param number the primary key of the current found object
	 * @param categoryCode the category code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next found object
	 * @throws NoSuchFoundObjectException if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject[] findByCategoryCode_PrevAndNext(
			String number, String categoryCode,
			OrderByComparator<FoundObject> orderByComparator)
		throws NoSuchFoundObjectException {

		categoryCode = Objects.toString(categoryCode, "");

		FoundObject foundObject = findByPrimaryKey(number);

		Session session = null;

		try {
			session = openSession();

			FoundObject[] array = new FoundObjectImpl[3];

			array[0] = getByCategoryCode_PrevAndNext(
				session, foundObject, categoryCode, orderByComparator, true);

			array[1] = foundObject;

			array[2] = getByCategoryCode_PrevAndNext(
				session, foundObject, categoryCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FoundObject getByCategoryCode_PrevAndNext(
		Session session, FoundObject foundObject, String categoryCode,
		OrderByComparator<FoundObject> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_FOUNDOBJECT_WHERE);

		boolean bindCategoryCode = false;

		if (categoryCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_3);
		}
		else {
			bindCategoryCode = true;

			sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_2);
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
			sb.append(FoundObjectModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCategoryCode) {
			queryPos.add(categoryCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(foundObject)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FoundObject> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the found objects where categoryCode = &#63; from the database.
	 *
	 * @param categoryCode the category code
	 */
	@Override
	public void removeByCategoryCode(String categoryCode) {
		for (FoundObject foundObject :
				findByCategoryCode(
					categoryCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(foundObject);
		}
	}

	/**
	 * Returns the number of found objects where categoryCode = &#63;.
	 *
	 * @param categoryCode the category code
	 * @return the number of matching found objects
	 */
	@Override
	public int countByCategoryCode(String categoryCode) {
		categoryCode = Objects.toString(categoryCode, "");

		FinderPath finderPath = _finderPathCountByCategoryCode;

		Object[] finderArgs = new Object[] {categoryCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FOUNDOBJECT_WHERE);

			boolean bindCategoryCode = false;

			if (categoryCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_3);
			}
			else {
				bindCategoryCode = true;

				sb.append(_FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCategoryCode) {
					queryPos.add(categoryCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_2 =
		"foundObject.categoryCode = ?";

	private static final String _FINDER_COLUMN_CATEGORYCODE_CATEGORYCODE_3 =
		"(foundObject.categoryCode IS NULL OR foundObject.categoryCode = '')";

	public FoundObjectPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("number", "number_");
		dbColumnNames.put("date", "date_");

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
				"_dbColumnNames");

			field.setAccessible(true);

			field.set(this, dbColumnNames);
		}
		catch (Exception exception) {
			if (_log.isDebugEnabled()) {
				_log.debug(exception, exception);
			}
		}

		setModelClass(FoundObject.class);
	}

	/**
	 * Caches the found object in the entity cache if it is enabled.
	 *
	 * @param foundObject the found object
	 */
	@Override
	public void cacheResult(FoundObject foundObject) {
		entityCache.putResult(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED, FoundObjectImpl.class,
			foundObject.getPrimaryKey(), foundObject);

		foundObject.resetOriginalValues();
	}

	/**
	 * Caches the found objects in the entity cache if it is enabled.
	 *
	 * @param foundObjects the found objects
	 */
	@Override
	public void cacheResult(List<FoundObject> foundObjects) {
		for (FoundObject foundObject : foundObjects) {
			if (entityCache.getResult(
					FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
					FoundObjectImpl.class, foundObject.getPrimaryKey()) ==
						null) {

				cacheResult(foundObject);
			}
			else {
				foundObject.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all found objects.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FoundObjectImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the found object.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FoundObject foundObject) {
		entityCache.removeResult(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED, FoundObjectImpl.class,
			foundObject.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FoundObject> foundObjects) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FoundObject foundObject : foundObjects) {
			entityCache.removeResult(
				FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
				FoundObjectImpl.class, foundObject.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
				FoundObjectImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new found object with the primary key. Does not add the found object to the database.
	 *
	 * @param number the primary key for the new found object
	 * @return the new found object
	 */
	@Override
	public FoundObject create(String number) {
		FoundObject foundObject = new FoundObjectImpl();

		foundObject.setNew(true);
		foundObject.setPrimaryKey(number);

		return foundObject;
	}

	/**
	 * Removes the found object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param number the primary key of the found object
	 * @return the found object that was removed
	 * @throws NoSuchFoundObjectException if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject remove(String number) throws NoSuchFoundObjectException {
		return remove((Serializable)number);
	}

	/**
	 * Removes the found object with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the found object
	 * @return the found object that was removed
	 * @throws NoSuchFoundObjectException if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject remove(Serializable primaryKey)
		throws NoSuchFoundObjectException {

		Session session = null;

		try {
			session = openSession();

			FoundObject foundObject = (FoundObject)session.get(
				FoundObjectImpl.class, primaryKey);

			if (foundObject == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFoundObjectException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(foundObject);
		}
		catch (NoSuchFoundObjectException noSuchEntityException) {
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
	protected FoundObject removeImpl(FoundObject foundObject) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(foundObject)) {
				foundObject = (FoundObject)session.get(
					FoundObjectImpl.class, foundObject.getPrimaryKeyObj());
			}

			if (foundObject != null) {
				session.delete(foundObject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (foundObject != null) {
			clearCache(foundObject);
		}

		return foundObject;
	}

	@Override
	public FoundObject updateImpl(FoundObject foundObject) {
		boolean isNew = foundObject.isNew();

		if (!(foundObject instanceof FoundObjectModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(foundObject.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(foundObject);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in foundObject proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FoundObject implementation " +
					foundObject.getClass());
		}

		FoundObjectModelImpl foundObjectModelImpl =
			(FoundObjectModelImpl)foundObject;

		Session session = null;

		try {
			session = openSession();

			if (foundObject.isNew()) {
				session.save(foundObject);

				foundObject.setNew(false);
			}
			else {
				foundObject = (FoundObject)session.merge(foundObject);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!FoundObjectModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {
				foundObjectModelImpl.getCategoryCode()
			};

			finderCache.removeResult(_finderPathCountByCategoryCode, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategoryCode, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((foundObjectModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategoryCode.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					foundObjectModelImpl.getOriginalCategoryCode()
				};

				finderCache.removeResult(_finderPathCountByCategoryCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategoryCode, args);

				args = new Object[] {foundObjectModelImpl.getCategoryCode()};

				finderCache.removeResult(_finderPathCountByCategoryCode, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategoryCode, args);
			}
		}

		entityCache.putResult(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED, FoundObjectImpl.class,
			foundObject.getPrimaryKey(), foundObject, false);

		foundObject.resetOriginalValues();

		return foundObject;
	}

	/**
	 * Returns the found object with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the found object
	 * @return the found object
	 * @throws NoSuchFoundObjectException if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFoundObjectException {

		FoundObject foundObject = fetchByPrimaryKey(primaryKey);

		if (foundObject == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFoundObjectException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return foundObject;
	}

	/**
	 * Returns the found object with the primary key or throws a <code>NoSuchFoundObjectException</code> if it could not be found.
	 *
	 * @param number the primary key of the found object
	 * @return the found object
	 * @throws NoSuchFoundObjectException if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject findByPrimaryKey(String number)
		throws NoSuchFoundObjectException {

		return findByPrimaryKey((Serializable)number);
	}

	/**
	 * Returns the found object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the found object
	 * @return the found object, or <code>null</code> if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED, FoundObjectImpl.class,
			primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		FoundObject foundObject = (FoundObject)serializable;

		if (foundObject == null) {
			Session session = null;

			try {
				session = openSession();

				foundObject = (FoundObject)session.get(
					FoundObjectImpl.class, primaryKey);

				if (foundObject != null) {
					cacheResult(foundObject);
				}
				else {
					entityCache.putResult(
						FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
						FoundObjectImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception exception) {
				entityCache.removeResult(
					FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
					FoundObjectImpl.class, primaryKey);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return foundObject;
	}

	/**
	 * Returns the found object with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param number the primary key of the found object
	 * @return the found object, or <code>null</code> if a found object with the primary key could not be found
	 */
	@Override
	public FoundObject fetchByPrimaryKey(String number) {
		return fetchByPrimaryKey((Serializable)number);
	}

	@Override
	public Map<Serializable, FoundObject> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, FoundObject> map =
			new HashMap<Serializable, FoundObject>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			FoundObject foundObject = fetchByPrimaryKey(primaryKey);

			if (foundObject != null) {
				map.put(primaryKey, foundObject);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
				FoundObjectImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (FoundObject)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler sb = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		sb.append(_SQL_SELECT_FOUNDOBJECT_WHERE_PKS_IN);

		for (int i = 0; i < uncachedPrimaryKeys.size(); i++) {
			sb.append("?");

			sb.append(",");
		}

		sb.setIndex(sb.index() - 1);

		sb.append(")");

		String sql = sb.toString();

		Session session = null;

		try {
			session = openSession();

			Query query = session.createQuery(sql);

			QueryPos queryPos = QueryPos.getInstance(query);

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				queryPos.add((String)primaryKey);
			}

			for (FoundObject foundObject : (List<FoundObject>)query.list()) {
				map.put(foundObject.getPrimaryKeyObj(), foundObject);

				cacheResult(foundObject);

				uncachedPrimaryKeys.remove(foundObject.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
					FoundObjectImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the found objects.
	 *
	 * @return the found objects
	 */
	@Override
	public List<FoundObject> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the found objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @return the range of found objects
	 */
	@Override
	public List<FoundObject> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the found objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of found objects
	 */
	@Override
	public List<FoundObject> findAll(
		int start, int end, OrderByComparator<FoundObject> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the found objects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FoundObjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of found objects
	 * @param end the upper bound of the range of found objects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of found objects
	 */
	@Override
	public List<FoundObject> findAll(
		int start, int end, OrderByComparator<FoundObject> orderByComparator,
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

		List<FoundObject> list = null;

		if (useFinderCache) {
			list = (List<FoundObject>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FOUNDOBJECT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FOUNDOBJECT;

				sql = sql.concat(FoundObjectModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FoundObject>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the found objects from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FoundObject foundObject : findAll()) {
			remove(foundObject);
		}
	}

	/**
	 * Returns the number of found objects.
	 *
	 * @return the number of found objects
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FOUNDOBJECT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return FoundObjectModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the found object persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, FoundObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, FoundObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCategoryCode = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, FoundObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategoryCode = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, FoundObjectImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryCode",
			new String[] {String.class.getName()},
			FoundObjectModelImpl.CATEGORYCODE_COLUMN_BITMASK |
			FoundObjectModelImpl.DATE_COLUMN_BITMASK);

		_finderPathCountByCategoryCode = new FinderPath(
			FoundObjectModelImpl.ENTITY_CACHE_ENABLED,
			FoundObjectModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryCode",
			new String[] {String.class.getName()});
	}

	public void destroy() {
		entityCache.removeCache(FoundObjectImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FOUNDOBJECT =
		"SELECT foundObject FROM FoundObject foundObject";

	private static final String _SQL_SELECT_FOUNDOBJECT_WHERE_PKS_IN =
		"SELECT foundObject FROM FoundObject foundObject WHERE number_ IN (";

	private static final String _SQL_SELECT_FOUNDOBJECT_WHERE =
		"SELECT foundObject FROM FoundObject foundObject WHERE ";

	private static final String _SQL_COUNT_FOUNDOBJECT =
		"SELECT COUNT(foundObject) FROM FoundObject foundObject";

	private static final String _SQL_COUNT_FOUNDOBJECT_WHERE =
		"SELECT COUNT(foundObject) FROM FoundObject foundObject WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "foundObject.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FoundObject exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FoundObject exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FoundObjectPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"number", "date"});

}