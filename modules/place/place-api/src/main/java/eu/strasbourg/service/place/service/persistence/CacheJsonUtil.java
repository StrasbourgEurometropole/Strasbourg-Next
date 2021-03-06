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

package eu.strasbourg.service.place.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.CacheJson;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cache json service. This utility wraps <code>eu.strasbourg.service.place.service.persistence.impl.CacheJsonPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see CacheJsonPersistence
 * @generated
 */
@ProviderType
public class CacheJsonUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CacheJson cacheJson) {
		getPersistence().clearCache(cacheJson);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CacheJson> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CacheJson> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CacheJson> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CacheJson> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CacheJson update(CacheJson cacheJson) {
		return getPersistence().update(cacheJson);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CacheJson update(
		CacheJson cacheJson, ServiceContext serviceContext) {

		return getPersistence().update(cacheJson, serviceContext);
	}

	/**
	 * Returns all the cache jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cache jsons
	 */
	public static List<CacheJson> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public static List<CacheJson> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByUuid_First(
			String uuid, OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByUuid_First(
		String uuid, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByUuid_Last(
			String uuid, OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByUuid_Last(
		String uuid, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where uuid = &#63;.
	 *
	 * @param sigId the primary key of the current cache json
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson[] findByUuid_PrevAndNext(
			String sigId, String uuid,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByUuid_PrevAndNext(
			sigId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cache jsons where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cache jsons where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cache jsons
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cache jsons where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the matching cache jsons
	 */
	public static List<CacheJson> findBysigId(String sigId) {
		return getPersistence().findBysigId(sigId);
	}

	/**
	 * Returns a range of all the cache jsons where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public static List<CacheJson> findBysigId(
		String sigId, int start, int end) {

		return getPersistence().findBysigId(sigId, start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findBysigId(
		String sigId, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findBysigId(
			sigId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons where sigId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sigId the sig ID
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findBysigId(
		String sigId, int start, int end,
		OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findBysigId(
			sigId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first cache json in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findBysigId_First(
			String sigId, OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findBysigId_First(sigId, orderByComparator);
	}

	/**
	 * Returns the first cache json in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchBysigId_First(
		String sigId, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchBysigId_First(sigId, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findBysigId_Last(
			String sigId, OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findBysigId_Last(sigId, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchBysigId_Last(
		String sigId, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchBysigId_Last(sigId, orderByComparator);
	}

	/**
	 * Removes all the cache jsons where sigId = &#63; from the database.
	 *
	 * @param sigId the sig ID
	 */
	public static void removeBysigId(String sigId) {
		getPersistence().removeBysigId(sigId);
	}

	/**
	 * Returns the number of cache jsons where sigId = &#63;.
	 *
	 * @param sigId the sig ID
	 * @return the number of matching cache jsons
	 */
	public static int countBysigId(String sigId) {
		return getPersistence().countBysigId(sigId);
	}

	/**
	 * Returns all the cache jsons where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @return the matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndIsActive(
		Date createPlace, boolean isActive) {

		return getPersistence().findByCreatedDateAndIsActive(
			createPlace, isActive);
	}

	/**
	 * Returns a range of all the cache jsons where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndIsActive(
		Date createPlace, boolean isActive, int start, int end) {

		return getPersistence().findByCreatedDateAndIsActive(
			createPlace, isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndIsActive(
		Date createPlace, boolean isActive, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findByCreatedDateAndIsActive(
			createPlace, isActive, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndIsActive(
		Date createPlace, boolean isActive, int start, int end,
		OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCreatedDateAndIsActive(
			createPlace, isActive, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first cache json in the ordered set where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByCreatedDateAndIsActive_First(
			Date createPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByCreatedDateAndIsActive_First(
			createPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the first cache json in the ordered set where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByCreatedDateAndIsActive_First(
		Date createPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByCreatedDateAndIsActive_First(
			createPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByCreatedDateAndIsActive_Last(
			Date createPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByCreatedDateAndIsActive_Last(
			createPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByCreatedDateAndIsActive_Last(
		Date createPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByCreatedDateAndIsActive_Last(
			createPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param sigId the primary key of the current cache json
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson[] findByCreatedDateAndIsActive_PrevAndNext(
			String sigId, Date createPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByCreatedDateAndIsActive_PrevAndNext(
			sigId, createPlace, isActive, orderByComparator);
	}

	/**
	 * Removes all the cache jsons where createPlace &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 */
	public static void removeByCreatedDateAndIsActive(
		Date createPlace, boolean isActive) {

		getPersistence().removeByCreatedDateAndIsActive(createPlace, isActive);
	}

	/**
	 * Returns the number of cache jsons where createPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param isActive the is active
	 * @return the number of matching cache jsons
	 */
	public static int countByCreatedDateAndIsActive(
		Date createPlace, boolean isActive) {

		return getPersistence().countByCreatedDateAndIsActive(
			createPlace, isActive);
	}

	/**
	 * Returns all the cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @return the matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive) {

		return getPersistence().findByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive);
	}

	/**
	 * Returns a range of all the cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive, int start,
		int end) {

		return getPersistence().findByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive, int start,
		int end, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive, int start,
		int end, OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first cache json in the ordered set where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByCreatedDateAndModifiedDateAndIsActive_First(
			Date createPlace, Date modifiedPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().
			findByCreatedDateAndModifiedDateAndIsActive_First(
				createPlace, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the first cache json in the ordered set where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByCreatedDateAndModifiedDateAndIsActive_First(
		Date createPlace, Date modifiedPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().
			fetchByCreatedDateAndModifiedDateAndIsActive_First(
				createPlace, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByCreatedDateAndModifiedDateAndIsActive_Last(
			Date createPlace, Date modifiedPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().
			findByCreatedDateAndModifiedDateAndIsActive_Last(
				createPlace, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByCreatedDateAndModifiedDateAndIsActive_Last(
		Date createPlace, Date modifiedPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().
			fetchByCreatedDateAndModifiedDateAndIsActive_Last(
				createPlace, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param sigId the primary key of the current cache json
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson[]
			findByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
				String sigId, Date createPlace, Date modifiedPlace,
				boolean isActive,
				OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().
			findByCreatedDateAndModifiedDateAndIsActive_PrevAndNext(
				sigId, createPlace, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Removes all the cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 */
	public static void removeByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive) {

		getPersistence().removeByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive);
	}

	/**
	 * Returns the number of cache jsons where createPlace &lt; &#63; and modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param createPlace the create place
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @return the number of matching cache jsons
	 */
	public static int countByCreatedDateAndModifiedDateAndIsActive(
		Date createPlace, Date modifiedPlace, boolean isActive) {

		return getPersistence().countByCreatedDateAndModifiedDateAndIsActive(
			createPlace, modifiedPlace, isActive);
	}

	/**
	 * Returns all the cache jsons where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @return the matching cache jsons
	 */
	public static List<CacheJson> findByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive) {

		return getPersistence().findByModifiedDateAndIsActive(
			modifiedPlace, isActive);
	}

	/**
	 * Returns a range of all the cache jsons where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of matching cache jsons
	 */
	public static List<CacheJson> findByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive, int start, int end) {

		return getPersistence().findByModifiedDateAndIsActive(
			modifiedPlace, isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive, int start, int end,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findByModifiedDateAndIsActive(
			modifiedPlace, isActive, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching cache jsons
	 */
	public static List<CacheJson> findByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive, int start, int end,
		OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByModifiedDateAndIsActive(
			modifiedPlace, isActive, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	 * Returns the first cache json in the ordered set where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByModifiedDateAndIsActive_First(
			Date modifiedPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByModifiedDateAndIsActive_First(
			modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the first cache json in the ordered set where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByModifiedDateAndIsActive_First(
		Date modifiedPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByModifiedDateAndIsActive_First(
			modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json
	 * @throws NoSuchCacheJsonException if a matching cache json could not be found
	 */
	public static CacheJson findByModifiedDateAndIsActive_Last(
			Date modifiedPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByModifiedDateAndIsActive_Last(
			modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the last cache json in the ordered set where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cache json, or <code>null</code> if a matching cache json could not be found
	 */
	public static CacheJson fetchByModifiedDateAndIsActive_Last(
		Date modifiedPlace, boolean isActive,
		OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().fetchByModifiedDateAndIsActive_Last(
			modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Returns the cache jsons before and after the current cache json in the ordered set where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param sigId the primary key of the current cache json
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson[] findByModifiedDateAndIsActive_PrevAndNext(
			String sigId, Date modifiedPlace, boolean isActive,
			OrderByComparator<CacheJson> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByModifiedDateAndIsActive_PrevAndNext(
			sigId, modifiedPlace, isActive, orderByComparator);
	}

	/**
	 * Removes all the cache jsons where modifiedPlace &ge; &#63; and isActive = &#63; from the database.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 */
	public static void removeByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive) {

		getPersistence().removeByModifiedDateAndIsActive(
			modifiedPlace, isActive);
	}

	/**
	 * Returns the number of cache jsons where modifiedPlace &ge; &#63; and isActive = &#63;.
	 *
	 * @param modifiedPlace the modified place
	 * @param isActive the is active
	 * @return the number of matching cache jsons
	 */
	public static int countByModifiedDateAndIsActive(
		Date modifiedPlace, boolean isActive) {

		return getPersistence().countByModifiedDateAndIsActive(
			modifiedPlace, isActive);
	}

	/**
	 * Caches the cache json in the entity cache if it is enabled.
	 *
	 * @param cacheJson the cache json
	 */
	public static void cacheResult(CacheJson cacheJson) {
		getPersistence().cacheResult(cacheJson);
	}

	/**
	 * Caches the cache jsons in the entity cache if it is enabled.
	 *
	 * @param cacheJsons the cache jsons
	 */
	public static void cacheResult(List<CacheJson> cacheJsons) {
		getPersistence().cacheResult(cacheJsons);
	}

	/**
	 * Creates a new cache json with the primary key. Does not add the cache json to the database.
	 *
	 * @param sigId the primary key for the new cache json
	 * @return the new cache json
	 */
	public static CacheJson create(String sigId) {
		return getPersistence().create(sigId);
	}

	/**
	 * Removes the cache json with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the cache json
	 * @return the cache json that was removed
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson remove(String sigId)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().remove(sigId);
	}

	public static CacheJson updateImpl(CacheJson cacheJson) {
		return getPersistence().updateImpl(cacheJson);
	}

	/**
	 * Returns the cache json with the primary key or throws a <code>NoSuchCacheJsonException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the cache json
	 * @return the cache json
	 * @throws NoSuchCacheJsonException if a cache json with the primary key could not be found
	 */
	public static CacheJson findByPrimaryKey(String sigId)
		throws eu.strasbourg.service.place.exception.NoSuchCacheJsonException {

		return getPersistence().findByPrimaryKey(sigId);
	}

	/**
	 * Returns the cache json with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the cache json
	 * @return the cache json, or <code>null</code> if a cache json with the primary key could not be found
	 */
	public static CacheJson fetchByPrimaryKey(String sigId) {
		return getPersistence().fetchByPrimaryKey(sigId);
	}

	/**
	 * Returns all the cache jsons.
	 *
	 * @return the cache jsons
	 */
	public static List<CacheJson> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @return the range of cache jsons
	 */
	public static List<CacheJson> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cache jsons
	 */
	public static List<CacheJson> findAll(
		int start, int end, OrderByComparator<CacheJson> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cache jsons.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CacheJsonModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cache jsons
	 * @param end the upper bound of the range of cache jsons (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of cache jsons
	 */
	public static List<CacheJson> findAll(
		int start, int end, OrderByComparator<CacheJson> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the cache jsons from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cache jsons.
	 *
	 * @return the number of cache jsons
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CacheJsonPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CacheJsonPersistence, CacheJsonPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CacheJsonPersistence.class);

		ServiceTracker<CacheJsonPersistence, CacheJsonPersistence>
			serviceTracker =
				new ServiceTracker<CacheJsonPersistence, CacheJsonPersistence>(
					bundle.getBundleContext(), CacheJsonPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}