/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CacheJsonLocalService}.
 *
 * @author BenjaminBini
 * @see CacheJsonLocalService
 * @generated
 */
public class CacheJsonLocalServiceWrapper
	implements CacheJsonLocalService, ServiceWrapper<CacheJsonLocalService> {

	public CacheJsonLocalServiceWrapper() {
		this(null);
	}

	public CacheJsonLocalServiceWrapper(
		CacheJsonLocalService cacheJsonLocalService) {

		_cacheJsonLocalService = cacheJsonLocalService;
	}

	/**
	 * Adds the cache json to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was added
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson addCacheJson(
		eu.strasbourg.service.agenda.model.CacheJson cacheJson) {

		return _cacheJsonLocalService.addCacheJson(cacheJson);
	}

	/**
	 * Creates a new cache json with the primary key. Does not add the cache json to the database.
	 *
	 * @param eventId the primary key for the new cache json
	 * @return the new cache json
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson createCacheJson(
		long eventId) {

		return _cacheJsonLocalService.createCacheJson(eventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheJsonLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cache json from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was removed
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson deleteCacheJson(
		eu.strasbourg.service.agenda.model.CacheJson cacheJson) {

		return _cacheJsonLocalService.deleteCacheJson(cacheJson);
	}

	/**
	 * Deletes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws PortalException if a cache json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson deleteCacheJson(
			long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheJsonLocalService.deleteCacheJson(eventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheJsonLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cacheJsonLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cacheJsonLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cacheJsonLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cacheJsonLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _cacheJsonLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _cacheJsonLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _cacheJsonLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _cacheJsonLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.agenda.model.CacheJson fetchCacheJson(
		long eventId) {

		return _cacheJsonLocalService.fetchCacheJson(eventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cacheJsonLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la list  cache d'un event s'il est approuvé sinon envoi une erreur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.CacheJson>
		getAllIsApproved() {

		return _cacheJsonLocalService.getAllIsApproved();
	}

	/**
	 * Retourne le cache d'un event s'il est approuvé sinon null
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson
		getByEventIdAndIsApproved(long eventId) {

		return _cacheJsonLocalService.getByEventIdAndIsApproved(eventId);
	}

	/**
	 * Returns the cache json with the primary key.
	 *
	 * @param eventId the primary key of the cache json
	 * @return the cache json
	 * @throws PortalException if a cache json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson getCacheJson(
			long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheJsonLocalService.getCacheJson(eventId);
	}

	/**
	 * Returns a range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CacheJsonModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of cache jsons
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.CacheJson>
		getCacheJsons(int start, int end) {

		return _cacheJsonLocalService.getCacheJsons(start, end);
	}

	/**
	 * Returns the number of cache jsons.
	 *
	 * @return the number of cache jsons
	 */
	@Override
	public int getCacheJsonsCount() {
		return _cacheJsonLocalService.getCacheJsonsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cacheJsonLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cacheJsonLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheJsonLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cache json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheJsonLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was updated
	 */
	@Override
	public eu.strasbourg.service.agenda.model.CacheJson updateCacheJson(
		eu.strasbourg.service.agenda.model.CacheJson cacheJson) {

		return _cacheJsonLocalService.updateCacheJson(cacheJson);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _cacheJsonLocalService.getBasePersistence();
	}

	@Override
	public CacheJsonLocalService getWrappedService() {
		return _cacheJsonLocalService;
	}

	@Override
	public void setWrappedService(CacheJsonLocalService cacheJsonLocalService) {
		_cacheJsonLocalService = cacheJsonLocalService;
	}

	private CacheJsonLocalService _cacheJsonLocalService;

}