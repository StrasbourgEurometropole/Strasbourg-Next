/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.objtp.exception.NoSuchObjectCategoryException;
import eu.strasbourg.service.objtp.model.ObjectCategory;
import eu.strasbourg.service.objtp.model.ObjectCategoryTable;
import eu.strasbourg.service.objtp.model.impl.ObjectCategoryImpl;
import eu.strasbourg.service.objtp.model.impl.ObjectCategoryModelImpl;
import eu.strasbourg.service.objtp.service.persistence.ObjectCategoryPersistence;
import eu.strasbourg.service.objtp.service.persistence.ObjectCategoryUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the object category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author JeremyZwickert
 * @generated
 */
public class ObjectCategoryPersistenceImpl
	extends BasePersistenceImpl<ObjectCategory>
	implements ObjectCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ObjectCategoryUtil</code> to access the object category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ObjectCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ObjectCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ObjectCategory.class);

		setModelImplClass(ObjectCategoryImpl.class);
		setModelPKClass(String.class);

		setTable(ObjectCategoryTable.INSTANCE);
	}

	/**
	 * Caches the object category in the entity cache if it is enabled.
	 *
	 * @param objectCategory the object category
	 */
	@Override
	public void cacheResult(ObjectCategory objectCategory) {
		entityCache.putResult(
			ObjectCategoryImpl.class, objectCategory.getPrimaryKey(),
			objectCategory);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the object categories in the entity cache if it is enabled.
	 *
	 * @param objectCategories the object categories
	 */
	@Override
	public void cacheResult(List<ObjectCategory> objectCategories) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (objectCategories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ObjectCategory objectCategory : objectCategories) {
			if (entityCache.getResult(
					ObjectCategoryImpl.class, objectCategory.getPrimaryKey()) ==
						null) {

				cacheResult(objectCategory);
			}
		}
	}

	/**
	 * Clears the cache for all object categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ObjectCategoryImpl.class);

		finderCache.clearCache(ObjectCategoryImpl.class);
	}

	/**
	 * Clears the cache for the object category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ObjectCategory objectCategory) {
		entityCache.removeResult(ObjectCategoryImpl.class, objectCategory);
	}

	@Override
	public void clearCache(List<ObjectCategory> objectCategories) {
		for (ObjectCategory objectCategory : objectCategories) {
			entityCache.removeResult(ObjectCategoryImpl.class, objectCategory);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ObjectCategoryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ObjectCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new object category with the primary key. Does not add the object category to the database.
	 *
	 * @param code the primary key for the new object category
	 * @return the new object category
	 */
	@Override
	public ObjectCategory create(String code) {
		ObjectCategory objectCategory = new ObjectCategoryImpl();

		objectCategory.setNew(true);
		objectCategory.setPrimaryKey(code);

		return objectCategory;
	}

	/**
	 * Removes the object category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param code the primary key of the object category
	 * @return the object category that was removed
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	@Override
	public ObjectCategory remove(String code)
		throws NoSuchObjectCategoryException {

		return remove((Serializable)code);
	}

	/**
	 * Removes the object category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the object category
	 * @return the object category that was removed
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	@Override
	public ObjectCategory remove(Serializable primaryKey)
		throws NoSuchObjectCategoryException {

		Session session = null;

		try {
			session = openSession();

			ObjectCategory objectCategory = (ObjectCategory)session.get(
				ObjectCategoryImpl.class, primaryKey);

			if (objectCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchObjectCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(objectCategory);
		}
		catch (NoSuchObjectCategoryException noSuchEntityException) {
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
	protected ObjectCategory removeImpl(ObjectCategory objectCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(objectCategory)) {
				objectCategory = (ObjectCategory)session.get(
					ObjectCategoryImpl.class,
					objectCategory.getPrimaryKeyObj());
			}

			if (objectCategory != null) {
				session.delete(objectCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (objectCategory != null) {
			clearCache(objectCategory);
		}

		return objectCategory;
	}

	@Override
	public ObjectCategory updateImpl(ObjectCategory objectCategory) {
		boolean isNew = objectCategory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(objectCategory);
			}
			else {
				objectCategory = (ObjectCategory)session.merge(objectCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ObjectCategoryImpl.class, objectCategory, false, true);

		if (isNew) {
			objectCategory.setNew(false);
		}

		objectCategory.resetOriginalValues();

		return objectCategory;
	}

	/**
	 * Returns the object category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the object category
	 * @return the object category
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	@Override
	public ObjectCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchObjectCategoryException {

		ObjectCategory objectCategory = fetchByPrimaryKey(primaryKey);

		if (objectCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchObjectCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return objectCategory;
	}

	/**
	 * Returns the object category with the primary key or throws a <code>NoSuchObjectCategoryException</code> if it could not be found.
	 *
	 * @param code the primary key of the object category
	 * @return the object category
	 * @throws NoSuchObjectCategoryException if a object category with the primary key could not be found
	 */
	@Override
	public ObjectCategory findByPrimaryKey(String code)
		throws NoSuchObjectCategoryException {

		return findByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns the object category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param code the primary key of the object category
	 * @return the object category, or <code>null</code> if a object category with the primary key could not be found
	 */
	@Override
	public ObjectCategory fetchByPrimaryKey(String code) {
		return fetchByPrimaryKey((Serializable)code);
	}

	/**
	 * Returns all the object categories.
	 *
	 * @return the object categories
	 */
	@Override
	public List<ObjectCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @return the range of object categories
	 */
	@Override
	public List<ObjectCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of object categories
	 */
	@Override
	public List<ObjectCategory> findAll(
		int start, int end,
		OrderByComparator<ObjectCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the object categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ObjectCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of object categories
	 * @param end the upper bound of the range of object categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of object categories
	 */
	@Override
	public List<ObjectCategory> findAll(
		int start, int end, OrderByComparator<ObjectCategory> orderByComparator,
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

		List<ObjectCategory> list = null;

		if (useFinderCache) {
			list = (List<ObjectCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OBJECTCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OBJECTCATEGORY;

				sql = sql.concat(ObjectCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ObjectCategory>)QueryUtil.list(
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
	 * Removes all the object categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ObjectCategory objectCategory : findAll()) {
			remove(objectCategory);
		}
	}

	/**
	 * Returns the number of object categories.
	 *
	 * @return the number of object categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OBJECTCATEGORY);

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
		return "code_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OBJECTCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ObjectCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the object category persistence.
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

		ObjectCategoryUtil.setPersistence(this);
	}

	public void destroy() {
		ObjectCategoryUtil.setPersistence(null);

		entityCache.removeCache(ObjectCategoryImpl.class.getName());
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OBJECTCATEGORY =
		"SELECT objectCategory FROM ObjectCategory objectCategory";

	private static final String _SQL_COUNT_OBJECTCATEGORY =
		"SELECT COUNT(objectCategory) FROM ObjectCategory objectCategory";

	private static final String _ORDER_BY_ENTITY_ALIAS = "objectCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ObjectCategory exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ObjectCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"code"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}