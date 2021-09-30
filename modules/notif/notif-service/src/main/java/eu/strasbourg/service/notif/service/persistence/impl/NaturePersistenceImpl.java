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

package eu.strasbourg.service.notif.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.notif.exception.NoSuchNatureException;
import eu.strasbourg.service.notif.model.Nature;
import eu.strasbourg.service.notif.model.impl.NatureImpl;
import eu.strasbourg.service.notif.model.impl.NatureModelImpl;
import eu.strasbourg.service.notif.service.persistence.NaturePersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the nature service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class NaturePersistenceImpl
	extends BasePersistenceImpl<Nature> implements NaturePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NatureUtil</code> to access the nature persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NatureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public NaturePersistenceImpl() {
		setModelClass(Nature.class);
	}

	/**
	 * Caches the nature in the entity cache if it is enabled.
	 *
	 * @param nature the nature
	 */
	@Override
	public void cacheResult(Nature nature) {
		entityCache.putResult(
			NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
			nature.getPrimaryKey(), nature);

		nature.resetOriginalValues();
	}

	/**
	 * Caches the natures in the entity cache if it is enabled.
	 *
	 * @param natures the natures
	 */
	@Override
	public void cacheResult(List<Nature> natures) {
		for (Nature nature : natures) {
			if (entityCache.getResult(
					NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
					nature.getPrimaryKey()) == null) {

				cacheResult(nature);
			}
			else {
				nature.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all natures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NatureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nature.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Nature nature) {
		entityCache.removeResult(
			NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
			nature.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Nature> natures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Nature nature : natures) {
			entityCache.removeResult(
				NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
				nature.getPrimaryKey());
		}
	}

	/**
	 * Creates a new nature with the primary key. Does not add the nature to the database.
	 *
	 * @param natureId the primary key for the new nature
	 * @return the new nature
	 */
	@Override
	public Nature create(long natureId) {
		Nature nature = new NatureImpl();

		nature.setNew(true);
		nature.setPrimaryKey(natureId);

		return nature;
	}

	/**
	 * Removes the nature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param natureId the primary key of the nature
	 * @return the nature that was removed
	 * @throws NoSuchNatureException if a nature with the primary key could not be found
	 */
	@Override
	public Nature remove(long natureId) throws NoSuchNatureException {
		return remove((Serializable)natureId);
	}

	/**
	 * Removes the nature with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nature
	 * @return the nature that was removed
	 * @throws NoSuchNatureException if a nature with the primary key could not be found
	 */
	@Override
	public Nature remove(Serializable primaryKey) throws NoSuchNatureException {
		Session session = null;

		try {
			session = openSession();

			Nature nature = (Nature)session.get(NatureImpl.class, primaryKey);

			if (nature == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNatureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(nature);
		}
		catch (NoSuchNatureException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Nature removeImpl(Nature nature) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nature)) {
				nature = (Nature)session.get(
					NatureImpl.class, nature.getPrimaryKeyObj());
			}

			if (nature != null) {
				session.delete(nature);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (nature != null) {
			clearCache(nature);
		}

		return nature;
	}

	@Override
	public Nature updateImpl(Nature nature) {
		boolean isNew = nature.isNew();

		Session session = null;

		try {
			session = openSession();

			if (nature.isNew()) {
				session.save(nature);

				nature.setNew(false);
			}
			else {
				nature = (Nature)session.merge(nature);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
			nature.getPrimaryKey(), nature, false);

		nature.resetOriginalValues();

		return nature;
	}

	/**
	 * Returns the nature with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nature
	 * @return the nature
	 * @throws NoSuchNatureException if a nature with the primary key could not be found
	 */
	@Override
	public Nature findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNatureException {

		Nature nature = fetchByPrimaryKey(primaryKey);

		if (nature == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNatureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return nature;
	}

	/**
	 * Returns the nature with the primary key or throws a <code>NoSuchNatureException</code> if it could not be found.
	 *
	 * @param natureId the primary key of the nature
	 * @return the nature
	 * @throws NoSuchNatureException if a nature with the primary key could not be found
	 */
	@Override
	public Nature findByPrimaryKey(long natureId) throws NoSuchNatureException {
		return findByPrimaryKey((Serializable)natureId);
	}

	/**
	 * Returns the nature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nature
	 * @return the nature, or <code>null</code> if a nature with the primary key could not be found
	 */
	@Override
	public Nature fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(
			NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Nature nature = (Nature)serializable;

		if (nature == null) {
			Session session = null;

			try {
				session = openSession();

				nature = (Nature)session.get(NatureImpl.class, primaryKey);

				if (nature != null) {
					cacheResult(nature);
				}
				else {
					entityCache.putResult(
						NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
						primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(
					NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
					primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return nature;
	}

	/**
	 * Returns the nature with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param natureId the primary key of the nature
	 * @return the nature, or <code>null</code> if a nature with the primary key could not be found
	 */
	@Override
	public Nature fetchByPrimaryKey(long natureId) {
		return fetchByPrimaryKey((Serializable)natureId);
	}

	@Override
	public Map<Serializable, Nature> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Nature> map = new HashMap<Serializable, Nature>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Nature nature = fetchByPrimaryKey(primaryKey);

			if (nature != null) {
				map.put(primaryKey, nature);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(
				NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
				primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Nature)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler(
			uncachedPrimaryKeys.size() * 2 + 1);

		query.append(_SQL_SELECT_NATURE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Nature nature : (List<Nature>)q.list()) {
				map.put(nature.getPrimaryKeyObj(), nature);

				cacheResult(nature);

				uncachedPrimaryKeys.remove(nature.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(
					NatureModelImpl.ENTITY_CACHE_ENABLED, NatureImpl.class,
					primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the natures.
	 *
	 * @return the natures
	 */
	@Override
	public List<Nature> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the natures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NatureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of natures
	 * @param end the upper bound of the range of natures (not inclusive)
	 * @return the range of natures
	 */
	@Override
	public List<Nature> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the natures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NatureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of natures
	 * @param end the upper bound of the range of natures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of natures
	 */
	@Override
	public List<Nature> findAll(
		int start, int end, OrderByComparator<Nature> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the natures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>NatureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of natures
	 * @param end the upper bound of the range of natures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of natures
	 */
	@Override
	public List<Nature> findAll(
		int start, int end, OrderByComparator<Nature> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Nature> list = null;

		if (retrieveFromCache) {
			list = (List<Nature>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NATURE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NATURE;

				if (pagination) {
					sql = sql.concat(NatureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Nature>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Nature>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the natures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Nature nature : findAll()) {
			remove(nature);
		}
	}

	/**
	 * Returns the number of natures.
	 *
	 * @return the number of natures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NATURE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NatureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nature persistence.
	 */
	public void afterPropertiesSet() {
		_finderPathWithPaginationFindAll = new FinderPath(
			NatureModelImpl.ENTITY_CACHE_ENABLED,
			NatureModelImpl.FINDER_CACHE_ENABLED, NatureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			NatureModelImpl.ENTITY_CACHE_ENABLED,
			NatureModelImpl.FINDER_CACHE_ENABLED, NatureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			NatureModelImpl.ENTITY_CACHE_ENABLED,
			NatureModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	public void destroy() {
		entityCache.removeCache(NatureImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NATURE =
		"SELECT nature FROM Nature nature";

	private static final String _SQL_SELECT_NATURE_WHERE_PKS_IN =
		"SELECT nature FROM Nature nature WHERE natureId IN (";

	private static final String _SQL_COUNT_NATURE =
		"SELECT COUNT(nature) FROM Nature nature";

	private static final String _ORDER_BY_ENTITY_ALIAS = "nature.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Nature exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		NaturePersistenceImpl.class);

}