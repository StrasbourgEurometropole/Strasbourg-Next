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

package eu.strasbourg.service.csmap.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.csmap.exception.NoSuchCacheAgendaJsonException;
import eu.strasbourg.service.csmap.model.CacheAgendaJson;
import eu.strasbourg.service.csmap.model.impl.CacheAgendaJsonImpl;
import eu.strasbourg.service.csmap.model.impl.CacheAgendaJsonModelImpl;
import eu.strasbourg.service.csmap.service.persistence.CacheAgendaJsonPersistence;
import eu.strasbourg.service.csmap.service.persistence.impl.constants.csmapPersistenceConstants;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cache agenda json service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CacheAgendaJsonPersistence.class)
@ProviderType
public class CacheAgendaJsonPersistenceImpl
	extends BasePersistenceImpl<CacheAgendaJson>
	implements CacheAgendaJsonPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CacheAgendaJsonUtil</code> to access the cache agenda json persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CacheAgendaJsonImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CacheAgendaJsonPersistenceImpl() {
		setModelClass(CacheAgendaJson.class);

		setModelImplClass(CacheAgendaJsonImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cache agenda json in the entity cache if it is enabled.
	 *
	 * @param cacheAgendaJson the cache agenda json
	 */
	@Override
	public void cacheResult(CacheAgendaJson cacheAgendaJson) {
		entityCache.putResult(
			entityCacheEnabled, CacheAgendaJsonImpl.class,
			cacheAgendaJson.getPrimaryKey(), cacheAgendaJson);

		cacheAgendaJson.resetOriginalValues();
	}

	/**
	 * Caches the cache agenda jsons in the entity cache if it is enabled.
	 *
	 * @param cacheAgendaJsons the cache agenda jsons
	 */
	@Override
	public void cacheResult(List<CacheAgendaJson> cacheAgendaJsons) {
		for (CacheAgendaJson cacheAgendaJson : cacheAgendaJsons) {
			if (entityCache.getResult(
					entityCacheEnabled, CacheAgendaJsonImpl.class,
					cacheAgendaJson.getPrimaryKey()) == null) {

				cacheResult(cacheAgendaJson);
			}
			else {
				cacheAgendaJson.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cache agenda jsons.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CacheAgendaJsonImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cache agenda json.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CacheAgendaJson cacheAgendaJson) {
		entityCache.removeResult(
			entityCacheEnabled, CacheAgendaJsonImpl.class,
			cacheAgendaJson.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CacheAgendaJson> cacheAgendaJsons) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CacheAgendaJson cacheAgendaJson : cacheAgendaJsons) {
			entityCache.removeResult(
				entityCacheEnabled, CacheAgendaJsonImpl.class,
				cacheAgendaJson.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cache agenda json with the primary key. Does not add the cache agenda json to the database.
	 *
	 * @param cacheId the primary key for the new cache agenda json
	 * @return the new cache agenda json
	 */
	@Override
	public CacheAgendaJson create(long cacheId) {
		CacheAgendaJson cacheAgendaJson = new CacheAgendaJsonImpl();

		cacheAgendaJson.setNew(true);
		cacheAgendaJson.setPrimaryKey(cacheId);

		return cacheAgendaJson;
	}

	/**
	 * Removes the cache agenda json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cacheId the primary key of the cache agenda json
	 * @return the cache agenda json that was removed
	 * @throws NoSuchCacheAgendaJsonException if a cache agenda json with the primary key could not be found
	 */
	@Override
	public CacheAgendaJson remove(long cacheId)
		throws NoSuchCacheAgendaJsonException {

		return remove((Serializable)cacheId);
	}

	/**
	 * Removes the cache agenda json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cache agenda json
	 * @return the cache agenda json that was removed
	 * @throws NoSuchCacheAgendaJsonException if a cache agenda json with the primary key could not be found
	 */
	@Override
	public CacheAgendaJson remove(Serializable primaryKey)
		throws NoSuchCacheAgendaJsonException {

		Session session = null;

		try {
			session = openSession();

			CacheAgendaJson cacheAgendaJson = (CacheAgendaJson)session.get(
				CacheAgendaJsonImpl.class, primaryKey);

			if (cacheAgendaJson == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCacheAgendaJsonException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(cacheAgendaJson);
		}
		catch (NoSuchCacheAgendaJsonException nsee) {
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
	protected CacheAgendaJson removeImpl(CacheAgendaJson cacheAgendaJson) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cacheAgendaJson)) {
				cacheAgendaJson = (CacheAgendaJson)session.get(
					CacheAgendaJsonImpl.class,
					cacheAgendaJson.getPrimaryKeyObj());
			}

			if (cacheAgendaJson != null) {
				session.delete(cacheAgendaJson);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cacheAgendaJson != null) {
			clearCache(cacheAgendaJson);
		}

		return cacheAgendaJson;
	}

	@Override
	public CacheAgendaJson updateImpl(CacheAgendaJson cacheAgendaJson) {
		boolean isNew = cacheAgendaJson.isNew();

		Session session = null;

		try {
			session = openSession();

			if (cacheAgendaJson.isNew()) {
				session.save(cacheAgendaJson);

				cacheAgendaJson.setNew(false);
			}
			else {
				cacheAgendaJson = (CacheAgendaJson)session.merge(
					cacheAgendaJson);
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
			entityCacheEnabled, CacheAgendaJsonImpl.class,
			cacheAgendaJson.getPrimaryKey(), cacheAgendaJson, false);

		cacheAgendaJson.resetOriginalValues();

		return cacheAgendaJson;
	}

	/**
	 * Returns the cache agenda json with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cache agenda json
	 * @return the cache agenda json
	 * @throws NoSuchCacheAgendaJsonException if a cache agenda json with the primary key could not be found
	 */
	@Override
	public CacheAgendaJson findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCacheAgendaJsonException {

		CacheAgendaJson cacheAgendaJson = fetchByPrimaryKey(primaryKey);

		if (cacheAgendaJson == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCacheAgendaJsonException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return cacheAgendaJson;
	}

	/**
	 * Returns the cache agenda json with the primary key or throws a <code>NoSuchCacheAgendaJsonException</code> if it could not be found.
	 *
	 * @param cacheId the primary key of the cache agenda json
	 * @return the cache agenda json
	 * @throws NoSuchCacheAgendaJsonException if a cache agenda json with the primary key could not be found
	 */
	@Override
	public CacheAgendaJson findByPrimaryKey(long cacheId)
		throws NoSuchCacheAgendaJsonException {

		return findByPrimaryKey((Serializable)cacheId);
	}

	/**
	 * Returns the cache agenda json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cacheId the primary key of the cache agenda json
	 * @return the cache agenda json, or <code>null</code> if a cache agenda json with the primary key could not be found
	 */
	@Override
	public CacheAgendaJson fetchByPrimaryKey(long cacheId) {
		return fetchByPrimaryKey((Serializable)cacheId);
	}

	/**
	 * Returns all the cache agenda jsons.
	 *
	 * @return the cache agenda jsons
	 */
	@Override
	public List<CacheAgendaJson> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cache agenda jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheAgendaJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache agenda jsons
	 * @param end the upper bound of the range of cache agenda jsons (not inclusive)
	 * @return the range of cache agenda jsons
	 */
	@Override
	public List<CacheAgendaJson> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cache agenda jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheAgendaJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache agenda jsons
	 * @param end the upper bound of the range of cache agenda jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cache agenda jsons
	 */
	@Override
	public List<CacheAgendaJson> findAll(
		int start, int end,
		OrderByComparator<CacheAgendaJson> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the cache agenda jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheAgendaJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache agenda jsons
	 * @param end the upper bound of the range of cache agenda jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cache agenda jsons
	 */
	@Override
	public List<CacheAgendaJson> findAll(
		int start, int end,
		OrderByComparator<CacheAgendaJson> orderByComparator,
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

		List<CacheAgendaJson> list = null;

		if (retrieveFromCache) {
			list = (List<CacheAgendaJson>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CACHEAGENDAJSON);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CACHEAGENDAJSON;

				if (pagination) {
					sql = sql.concat(CacheAgendaJsonModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CacheAgendaJson>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CacheAgendaJson>)QueryUtil.list(
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
	 * Removes all the cache agenda jsons from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CacheAgendaJson cacheAgendaJson : findAll()) {
			remove(cacheAgendaJson);
		}
	}

	/**
	 * Returns the number of cache agenda jsons.
	 *
	 * @return the number of cache agenda jsons
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CACHEAGENDAJSON);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "cacheId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CACHEAGENDAJSON;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CacheAgendaJsonModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cache agenda json persistence.
	 */
	@Activate
	public void activate() {
		CacheAgendaJsonModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CacheAgendaJsonModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CacheAgendaJsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CacheAgendaJsonImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CacheAgendaJsonImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.csmap.model.CacheAgendaJson"),
			true);
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = csmapPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CACHEAGENDAJSON =
		"SELECT cacheAgendaJson FROM CacheAgendaJson cacheAgendaJson";

	private static final String _SQL_COUNT_CACHEAGENDAJSON =
		"SELECT COUNT(cacheAgendaJson) FROM CacheAgendaJson cacheAgendaJson";

	private static final String _ORDER_BY_ENTITY_ALIAS = "cacheAgendaJson.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CacheAgendaJson exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CacheAgendaJsonPersistenceImpl.class);

}