/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.CacheHoursJSON;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CacheHoursJSON. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.CacheHoursJSONLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see CacheHoursJSONLocalService
 * @generated
 */
public class CacheHoursJSONLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.CacheHoursJSONLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cache hours json to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was added
	 */
	public static CacheHoursJSON addCacheHoursJSON(
		CacheHoursJSON cacheHoursJSON) {

		return getService().addCacheHoursJSON(cacheHoursJSON);
	}

	/**
	 * Creates a new cache hours json with the primary key. Does not add the cache hours json to the database.
	 *
	 * @param cacheHoursJSONPK the primary key for the new cache hours json
	 * @return the new cache hours json
	 */
	public static CacheHoursJSON createCacheHoursJSON(
		eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
			cacheHoursJSONPK) {

		return getService().createCacheHoursJSON(cacheHoursJSONPK);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static CacheHoursJSON createCacheHoursJSON(
		String stopCode, int type) {

		return getService().createCacheHoursJSON(stopCode, type);
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
	 * Deletes the cache hours json from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was removed
	 */
	public static CacheHoursJSON deleteCacheHoursJSON(
		CacheHoursJSON cacheHoursJSON) {

		return getService().deleteCacheHoursJSON(cacheHoursJSON);
	}

	/**
	 * Deletes the cache hours json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json that was removed
	 * @throws PortalException if a cache hours json with the primary key could not be found
	 */
	public static CacheHoursJSON deleteCacheHoursJSON(
			eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
				cacheHoursJSONPK)
		throws PortalException {

		return getService().deleteCacheHoursJSON(cacheHoursJSONPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
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

	/**
	 * Retourne le cache d'un arret et type
	 */
	public static CacheHoursJSON fetchByStopCodeAndType(
		String stopCode, int type) {

		return getService().fetchByStopCodeAndType(stopCode, type);
	}

	public static CacheHoursJSON fetchCacheHoursJSON(
		eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
			cacheHoursJSONPK) {

		return getService().fetchCacheHoursJSON(cacheHoursJSONPK);
	}

	/**
	 * Returns the cache hours json with the primary key.
	 *
	 * @param cacheHoursJSONPK the primary key of the cache hours json
	 * @return the cache hours json
	 * @throws PortalException if a cache hours json with the primary key could not be found
	 */
	public static CacheHoursJSON getCacheHoursJSON(
			eu.strasbourg.service.gtfs.service.persistence.CacheHoursJSONPK
				cacheHoursJSONPK)
		throws PortalException {

		return getService().getCacheHoursJSON(cacheHoursJSONPK);
	}

	/**
	 * Returns a range of all the cache hours jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache hours jsons
	 * @param end the upper bound of the range of cache hours jsons (not inclusive)
	 * @return the range of cache hours jsons
	 */
	public static List<CacheHoursJSON> getCacheHoursJSONs(int start, int end) {
		return getService().getCacheHoursJSONs(start, end);
	}

	/**
	 * Returns the number of cache hours jsons.
	 *
	 * @return the number of cache hours jsons
	 */
	public static int getCacheHoursJSONsCount() {
		return getService().getCacheHoursJSONsCount();
	}

	/**
	 * Met à jour le jsonHour du stop
	 */
	public static String getJsonHour(String stopCode, int type, int timeOut) {
		return getService().getJsonHour(stopCode, type, timeOut);
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
	 * Updates the cache hours json in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CacheHoursJSONLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cacheHoursJSON the cache hours json
	 * @return the cache hours json that was updated
	 */
	public static CacheHoursJSON updateCacheHoursJSON(
		CacheHoursJSON cacheHoursJSON) {

		return getService().updateCacheHoursJSON(cacheHoursJSON);
	}

	public static CacheHoursJSONLocalService getService() {
		return _service;
	}

	public static void setService(CacheHoursJSONLocalService service) {
		_service = service;
	}

	private static volatile CacheHoursJSONLocalService _service;

}