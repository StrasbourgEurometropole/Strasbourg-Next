/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.csmap.model.CsmapCache;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CsmapCache. This utility wraps
 * <code>eu.strasbourg.service.csmap.service.impl.CsmapCacheLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CsmapCacheLocalService
 * @generated
 */
public class CsmapCacheLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.csmap.service.impl.CsmapCacheLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the csmap cache to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCache the csmap cache
	 * @return the csmap cache that was added
	 */
	public static CsmapCache addCsmapCache(CsmapCache csmapCache) {
		return getService().addCsmapCache(csmapCache);
	}

	/**
	 * Creates a new csmap cache with the primary key. Does not add the csmap cache to the database.
	 *
	 * @param cacheId the primary key for the new csmap cache
	 * @return the new csmap cache
	 */
	public static CsmapCache createCsmapCache(long cacheId) {
		return getService().createCsmapCache(cacheId);
	}

	public static CsmapCache createCsmapCache(
		long codeCache, String json, java.util.Date date) {

		return getService().createCsmapCache(codeCache, json, date);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the csmap cache from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCache the csmap cache
	 * @return the csmap cache that was removed
	 */
	public static CsmapCache deleteCsmapCache(CsmapCache csmapCache) {
		return getService().deleteCsmapCache(csmapCache);
	}

	/**
	 * Deletes the csmap cache with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheId the primary key of the csmap cache
	 * @return the csmap cache that was removed
	 * @throws PortalException if a csmap cache with the primary key could not be found
	 */
	public static CsmapCache deleteCsmapCache(long cacheId)
		throws PortalException {

		return getService().deleteCsmapCache(cacheId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.CsmapCacheModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.CsmapCacheModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CsmapCache fetchByCodeCache(long codeCache) {
		return getService().fetchByCodeCache(codeCache);
	}

	public static CsmapCache fetchCsmapCache(long cacheId) {
		return getService().fetchCsmapCache(cacheId);
	}

	public static List<CsmapCache> findLastProcessNotSuccess() {
		return getService().findLastProcessNotSuccess();
	}

	public static void generateCsmapCache(long codeCache) {
		getService().generateCsmapCache(codeCache);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the csmap cache with the primary key.
	 *
	 * @param cacheId the primary key of the csmap cache
	 * @return the csmap cache
	 * @throws PortalException if a csmap cache with the primary key could not be found
	 */
	public static CsmapCache getCsmapCache(long cacheId)
		throws PortalException {

		return getService().getCsmapCache(cacheId);
	}

	/**
	 * Returns a range of all the csmap caches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.CsmapCacheModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of csmap caches
	 * @param end the upper bound of the range of csmap caches (not inclusive)
	 * @return the range of csmap caches
	 */
	public static List<CsmapCache> getCsmapCaches(int start, int end) {
		return getService().getCsmapCaches(start, end);
	}

	/**
	 * Returns the number of csmap caches.
	 *
	 * @return the number of csmap caches
	 */
	public static int getCsmapCachesCount() {
		return getService().getCsmapCachesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.json.JSONObject getJsonVide() {
		return getService().getJsonVide();
	}

	public static java.util.Date getLastModifiedEvent() {
		return getService().getLastModifiedEvent();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the csmap cache in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CsmapCacheLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param csmapCache the csmap cache
	 * @return the csmap cache that was updated
	 */
	public static CsmapCache updateCsmapCache(CsmapCache csmapCache) {
		return getService().updateCsmapCache(csmapCache);
	}

	public static CsmapCacheLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CsmapCacheLocalService> _serviceSnapshot =
		new Snapshot<>(
			CsmapCacheLocalServiceUtil.class, CsmapCacheLocalService.class);

}