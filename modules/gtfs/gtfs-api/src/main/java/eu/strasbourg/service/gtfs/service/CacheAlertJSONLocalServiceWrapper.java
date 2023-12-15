/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CacheAlertJSONLocalService}.
 *
 * @author Cedric Henry
 * @see CacheAlertJSONLocalService
 * @generated
 */
public class CacheAlertJSONLocalServiceWrapper
	implements CacheAlertJSONLocalService,
			   ServiceWrapper<CacheAlertJSONLocalService> {

	public CacheAlertJSONLocalServiceWrapper() {
		this(null);
	}

	public CacheAlertJSONLocalServiceWrapper(
		CacheAlertJSONLocalService cacheAlertJSONLocalService) {

		_cacheAlertJSONLocalService = cacheAlertJSONLocalService;
	}

	/**
	 * Adds the cache alert json to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheAlertJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheAlertJSON the cache alert json
	 * @return the cache alert json that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON addCacheAlertJSON(
		eu.strasbourg.service.gtfs.model.CacheAlertJSON cacheAlertJSON) {

		return _cacheAlertJSONLocalService.addCacheAlertJSON(cacheAlertJSON);
	}

	/**
	 * Creates a new cache alert json with the primary key. Does not add the cache alert json to the database.
	 *
	 * @param cacheId the primary key for the new cache alert json
	 * @return the new cache alert json
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON createCacheAlertJSON(
		long cacheId) {

		return _cacheAlertJSONLocalService.createCacheAlertJSON(cacheId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheAlertJSONLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the cache alert json from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheAlertJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheAlertJSON the cache alert json
	 * @return the cache alert json that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON deleteCacheAlertJSON(
		eu.strasbourg.service.gtfs.model.CacheAlertJSON cacheAlertJSON) {

		return _cacheAlertJSONLocalService.deleteCacheAlertJSON(cacheAlertJSON);
	}

	/**
	 * Deletes the cache alert json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheAlertJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheId the primary key of the cache alert json
	 * @return the cache alert json that was removed
	 * @throws PortalException if a cache alert json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON deleteCacheAlertJSON(
			long cacheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheAlertJSONLocalService.deleteCacheAlertJSON(cacheId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheAlertJSONLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _cacheAlertJSONLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _cacheAlertJSONLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cacheAlertJSONLocalService.dynamicQuery();
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

		return _cacheAlertJSONLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONModelImpl</code>.
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

		return _cacheAlertJSONLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONModelImpl</code>.
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

		return _cacheAlertJSONLocalService.dynamicQuery(
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

		return _cacheAlertJSONLocalService.dynamicQueryCount(dynamicQuery);
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

		return _cacheAlertJSONLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON fetchCacheAlertJSON(
		long cacheId) {

		return _cacheAlertJSONLocalService.fetchCacheAlertJSON(cacheId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _cacheAlertJSONLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cache alert json with the primary key.
	 *
	 * @param cacheId the primary key of the cache alert json
	 * @return the cache alert json
	 * @throws PortalException if a cache alert json with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON getCacheAlertJSON(
			long cacheId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheAlertJSONLocalService.getCacheAlertJSON(cacheId);
	}

	/**
	 * Returns a range of all the cache alert jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheAlertJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache alert jsons
	 * @param end the upper bound of the range of cache alert jsons (not inclusive)
	 * @return the range of cache alert jsons
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.CacheAlertJSON>
		getCacheAlertJSONs(int start, int end) {

		return _cacheAlertJSONLocalService.getCacheAlertJSONs(start, end);
	}

	/**
	 * Returns the number of cache alert jsons.
	 *
	 * @return the number of cache alert jsons
	 */
	@Override
	public int getCacheAlertJSONsCount() {
		return _cacheAlertJSONLocalService.getCacheAlertJSONsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _cacheAlertJSONLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cacheAlertJSONLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _cacheAlertJSONLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cache alert json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheAlertJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheAlertJSON the cache alert json
	 * @return the cache alert json that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.CacheAlertJSON updateCacheAlertJSON(
		eu.strasbourg.service.gtfs.model.CacheAlertJSON cacheAlertJSON) {

		return _cacheAlertJSONLocalService.updateCacheAlertJSON(cacheAlertJSON);
	}

	/**
	 * Met à jour le jsonAlert
	 */
	@Override
	public void updateJsonAlert() {
		_cacheAlertJSONLocalService.updateJsonAlert();
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _cacheAlertJSONLocalService.getBasePersistence();
	}

	@Override
	public CacheAlertJSONLocalService getWrappedService() {
		return _cacheAlertJSONLocalService;
	}

	@Override
	public void setWrappedService(
		CacheAlertJSONLocalService cacheAlertJSONLocalService) {

		_cacheAlertJSONLocalService = cacheAlertJSONLocalService;
	}

	private CacheAlertJSONLocalService _cacheAlertJSONLocalService;

}