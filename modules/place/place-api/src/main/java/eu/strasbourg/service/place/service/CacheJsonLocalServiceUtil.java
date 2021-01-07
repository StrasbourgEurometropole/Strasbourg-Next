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

package eu.strasbourg.service.place.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CacheJson. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.CacheJsonLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angelique Zunino Champougny
 * @see CacheJsonLocalService
 * @generated
 */
@ProviderType
public class CacheJsonLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.CacheJsonLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cache json to the database. Also notifies the appropriate model listeners.
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was added
	 */
	public static eu.strasbourg.service.place.model.CacheJson addCacheJson(
		eu.strasbourg.service.place.model.CacheJson cacheJson) {

		return getService().addCacheJson(cacheJson);
	}

	/**
	 * Creates a new cache json with the primary key. Does not add the cache json to the database.
	 *
	 * @param sigId the primary key for the new cache json
	 * @return the new cache json
	 */
	public static eu.strasbourg.service.place.model.CacheJson createCacheJson(
		String sigId) {

		return getService().createCacheJson(sigId);
	}

	/**
	 * Deletes the cache json from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was removed
	 */
	public static eu.strasbourg.service.place.model.CacheJson deleteCacheJson(
		eu.strasbourg.service.place.model.CacheJson cacheJson) {

		return getService().deleteCacheJson(cacheJson);
	}

	/**
	 * Deletes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws PortalException if a cache json with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.CacheJson deleteCacheJson(
			String sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCacheJson(sigId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.place.model.CacheJson fetchCacheJson(
		String sigId) {

		return getService().fetchCacheJson(sigId);
	}

	/**
	 * Retourne les caches d'un lieu créé après une date et actif
	 */
	public static java.util.List<eu.strasbourg.service.place.model.CacheJson>
		getByCreatedDateAndIsActive(java.util.Date date) {

		return getService().getByCreatedDateAndIsActive(date);
	}

	/**
	 * Retourne les caches d'un lieu modifié après une date, créé avant cette date et actif
	 */
	public static java.util.List<eu.strasbourg.service.place.model.CacheJson>
		getByCreatedDateAndModifiedDateAndIsActive(java.util.Date date) {

		return getService().getByCreatedDateAndModifiedDateAndIsActive(date);
	}

	/**
	 * Retourne les caches d'un lieu modifié après une date et inactif
	 */
	public static java.util.List<eu.strasbourg.service.place.model.CacheJson>
		getByModifiedDateAndIsNotActive(java.util.Date date) {

		return getService().getByModifiedDateAndIsNotActive(date);
	}

	/**
	 * Returns the cache json with the primary key.
	 *
	 * @param sigId the primary key of the cache json
	 * @return the cache json
	 * @throws PortalException if a cache json with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.CacheJson getCacheJson(
			String sigId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCacheJson(sigId);
	}

	/**
	 * Returns a range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of cache jsons
	 */
	public static java.util.List<eu.strasbourg.service.place.model.CacheJson>
		getCacheJsons(int start, int end) {

		return getService().getCacheJsons(start, end);
	}

	/**
	 * Returns the number of cache jsons.
	 *
	 * @return the number of cache jsons
	 */
	public static int getCacheJsonsCount() {
		return getService().getCacheJsonsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cache json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param cacheJson the cache json
	 * @return the cache json that was updated
	 */
	public static eu.strasbourg.service.place.model.CacheJson updateCacheJson(
		eu.strasbourg.service.place.model.CacheJson cacheJson) {

		return getService().updateCacheJson(cacheJson);
	}

	public static CacheJsonLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CacheJsonLocalService, CacheJsonLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CacheJsonLocalService.class);

		ServiceTracker<CacheJsonLocalService, CacheJsonLocalService>
			serviceTracker =
				new ServiceTracker
					<CacheJsonLocalService, CacheJsonLocalService>(
						bundle.getBundleContext(), CacheJsonLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}