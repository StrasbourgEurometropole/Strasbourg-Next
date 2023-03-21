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

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.project.model.PlacitPlace;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the placit place service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.PlacitPlacePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see PlacitPlacePersistence
 * @generated
 */
public class PlacitPlaceUtil {

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
	public static void clearCache(PlacitPlace placitPlace) {
		getPersistence().clearCache(placitPlace);
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
	public static Map<Serializable, PlacitPlace> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PlacitPlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PlacitPlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PlacitPlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PlacitPlace update(PlacitPlace placitPlace) {
		return getPersistence().update(placitPlace);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PlacitPlace update(
		PlacitPlace placitPlace, ServiceContext serviceContext) {

		return getPersistence().update(placitPlace, serviceContext);
	}

	/**
	 * Returns all the placit places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByUuid_First(
			String uuid, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUuid_First(
		String uuid, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByUuid_Last(
			String uuid, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUuid_Last(
		String uuid, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where uuid = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByUuid_PrevAndNext(
			long placitPlaceId, String uuid,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_PrevAndNext(
			placitPlaceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the placit places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of placit places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching placit places
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchPlacitPlaceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the placit place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the placit place where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the placit place that was removed
	 */
	public static PlacitPlace removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of placit places where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching placit places
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByUuid_C_PrevAndNext(
			long placitPlaceId, String uuid, long companyId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			placitPlaceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the placit places where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of placit places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching placit places
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the placit places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByGroupId_First(
			long groupId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByGroupId_First(
		long groupId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByGroupId_Last(
			long groupId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByGroupId_Last(
		long groupId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where groupId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByGroupId_PrevAndNext(
			long placitPlaceId, long groupId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByGroupId_PrevAndNext(
			placitPlaceId, groupId, orderByComparator);
	}

	/**
	 * Removes all the placit places where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of placit places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching placit places
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the placit places where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByProject(long projectId) {
		return getPersistence().findByProject(projectId);
	}

	/**
	 * Returns a range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByProject(
		long projectId, int start, int end) {

		return getPersistence().findByProject(projectId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByProject(
		long projectId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByProject(
			projectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where projectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param projectId the project ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByProject(
		long projectId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProject(
			projectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByProject_First(
			long projectId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByProject_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByProject_First(
		long projectId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByProject_First(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByProject_Last(
			long projectId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByProject_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByProject_Last(
		long projectId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByProject_Last(
			projectId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where projectId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param projectId the project ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByProject_PrevAndNext(
			long placitPlaceId, long projectId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByProject_PrevAndNext(
			placitPlaceId, projectId, orderByComparator);
	}

	/**
	 * Removes all the placit places where projectId = &#63; from the database.
	 *
	 * @param projectId the project ID
	 */
	public static void removeByProject(long projectId) {
		getPersistence().removeByProject(projectId);
	}

	/**
	 * Returns the number of placit places where projectId = &#63;.
	 *
	 * @param projectId the project ID
	 * @return the number of matching placit places
	 */
	public static int countByProject(long projectId) {
		return getPersistence().countByProject(projectId);
	}

	/**
	 * Returns all the placit places where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByParticipation(long participationId) {
		return getPersistence().findByParticipation(participationId);
	}

	/**
	 * Returns a range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByParticipation(
		long participationId, int start, int end) {

		return getPersistence().findByParticipation(
			participationId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByParticipation(
		long participationId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByParticipation(
			participationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where participationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param participationId the participation ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByParticipation(
		long participationId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParticipation(
			participationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByParticipation_First(
			long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByParticipation_First(
			participationId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByParticipation_First(
		long participationId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByParticipation_First(
			participationId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByParticipation_Last(
			long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByParticipation_Last(
			participationId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByParticipation_Last(
		long participationId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByParticipation_Last(
			participationId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where participationId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param participationId the participation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByParticipation_PrevAndNext(
			long placitPlaceId, long participationId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByParticipation_PrevAndNext(
			placitPlaceId, participationId, orderByComparator);
	}

	/**
	 * Removes all the placit places where participationId = &#63; from the database.
	 *
	 * @param participationId the participation ID
	 */
	public static void removeByParticipation(long participationId) {
		getPersistence().removeByParticipation(participationId);
	}

	/**
	 * Returns the number of placit places where participationId = &#63;.
	 *
	 * @param participationId the participation ID
	 * @return the number of matching placit places
	 */
	public static int countByParticipation(long participationId) {
		return getPersistence().countByParticipation(participationId);
	}

	/**
	 * Returns all the placit places where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByPetition(long petitionId) {
		return getPersistence().findByPetition(petitionId);
	}

	/**
	 * Returns a range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByPetition(
		long petitionId, int start, int end) {

		return getPersistence().findByPetition(petitionId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByPetition(
			petitionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where petitionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param petitionId the petition ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByPetition(
		long petitionId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPetition(
			petitionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByPetition_First(
			long petitionId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByPetition_First(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByPetition_First(
		long petitionId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByPetition_First(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByPetition_Last(
			long petitionId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByPetition_Last(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByPetition_Last(
		long petitionId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByPetition_Last(
			petitionId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where petitionId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param petitionId the petition ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByPetition_PrevAndNext(
			long placitPlaceId, long petitionId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByPetition_PrevAndNext(
			placitPlaceId, petitionId, orderByComparator);
	}

	/**
	 * Removes all the placit places where petitionId = &#63; from the database.
	 *
	 * @param petitionId the petition ID
	 */
	public static void removeByPetition(long petitionId) {
		getPersistence().removeByPetition(petitionId);
	}

	/**
	 * Returns the number of placit places where petitionId = &#63;.
	 *
	 * @param petitionId the petition ID
	 * @return the number of matching placit places
	 */
	public static int countByPetition(long petitionId) {
		return getPersistence().countByPetition(petitionId);
	}

	/**
	 * Returns all the placit places where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId) {

		return getPersistence().findByBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Returns a range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end) {

		return getPersistence().findByBudgetParticipatif(
			budgetParticipatifId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByBudgetParticipatif(
			budgetParticipatifId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where budgetParticipatifId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByBudgetParticipatif(
		long budgetParticipatifId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByBudgetParticipatif(
			budgetParticipatifId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByBudgetParticipatif_First(
			long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByBudgetParticipatif_First(
			budgetParticipatifId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByBudgetParticipatif_First(
		long budgetParticipatifId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByBudgetParticipatif_First(
			budgetParticipatifId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByBudgetParticipatif_Last(
			long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByBudgetParticipatif_Last(
			budgetParticipatifId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByBudgetParticipatif_Last(
		long budgetParticipatifId,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByBudgetParticipatif_Last(
			budgetParticipatifId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where budgetParticipatifId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param budgetParticipatifId the budget participatif ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByBudgetParticipatif_PrevAndNext(
			long placitPlaceId, long budgetParticipatifId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByBudgetParticipatif_PrevAndNext(
			placitPlaceId, budgetParticipatifId, orderByComparator);
	}

	/**
	 * Removes all the placit places where budgetParticipatifId = &#63; from the database.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 */
	public static void removeByBudgetParticipatif(long budgetParticipatifId) {
		getPersistence().removeByBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Returns the number of placit places where budgetParticipatifId = &#63;.
	 *
	 * @param budgetParticipatifId the budget participatif ID
	 * @return the number of matching placit places
	 */
	public static int countByBudgetParticipatif(long budgetParticipatifId) {
		return getPersistence().countByBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Returns all the placit places where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findByInitiative(long initiativeId) {
		return getPersistence().findByInitiative(initiativeId);
	}

	/**
	 * Returns a range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end) {

		return getPersistence().findByInitiative(initiativeId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findByInitiative(
			initiativeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findByInitiative(
		long initiativeId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByInitiative(
			initiativeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByInitiative_First(
			long initiativeId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByInitiative_First(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByInitiative_First(
		long initiativeId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByInitiative_First(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findByInitiative_Last(
			long initiativeId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByInitiative_Last(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchByInitiative_Last(
		long initiativeId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchByInitiative_Last(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where initiativeId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findByInitiative_PrevAndNext(
			long placitPlaceId, long initiativeId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByInitiative_PrevAndNext(
			placitPlaceId, initiativeId, orderByComparator);
	}

	/**
	 * Removes all the placit places where initiativeId = &#63; from the database.
	 *
	 * @param initiativeId the initiative ID
	 */
	public static void removeByInitiative(long initiativeId) {
		getPersistence().removeByInitiative(initiativeId);
	}

	/**
	 * Returns the number of placit places where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the number of matching placit places
	 */
	public static int countByInitiative(long initiativeId) {
		return getPersistence().countByInitiative(initiativeId);
	}

	/**
	 * Returns all the placit places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the matching placit places
	 */
	public static List<PlacitPlace> findBySigId(String placeSIGId) {
		return getPersistence().findBySigId(placeSIGId);
	}

	/**
	 * Returns a range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of matching placit places
	 */
	public static List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end) {

		return getPersistence().findBySigId(placeSIGId, start, end);
	}

	/**
	 * Returns an ordered range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findBySigId(
			placeSIGId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching placit places
	 */
	public static List<PlacitPlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySigId(
			placeSIGId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findBySigId_First(
			String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findBySigId_First(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the first placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchBySigId_First(
		String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchBySigId_First(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place
	 * @throws NoSuchPlacitPlaceException if a matching placit place could not be found
	 */
	public static PlacitPlace findBySigId_Last(
			String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findBySigId_Last(placeSIGId, orderByComparator);
	}

	/**
	 * Returns the last placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchBySigId_Last(
		String placeSIGId, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().fetchBySigId_Last(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the placit places before and after the current placit place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placitPlaceId the primary key of the current placit place
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace[] findBySigId_PrevAndNext(
			long placitPlaceId, String placeSIGId,
			OrderByComparator<PlacitPlace> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findBySigId_PrevAndNext(
			placitPlaceId, placeSIGId, orderByComparator);
	}

	/**
	 * Removes all the placit places where placeSIGId = &#63; from the database.
	 *
	 * @param placeSIGId the place sig ID
	 */
	public static void removeBySigId(String placeSIGId) {
		getPersistence().removeBySigId(placeSIGId);
	}

	/**
	 * Returns the number of placit places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the number of matching placit places
	 */
	public static int countBySigId(String placeSIGId) {
		return getPersistence().countBySigId(placeSIGId);
	}

	/**
	 * Caches the placit place in the entity cache if it is enabled.
	 *
	 * @param placitPlace the placit place
	 */
	public static void cacheResult(PlacitPlace placitPlace) {
		getPersistence().cacheResult(placitPlace);
	}

	/**
	 * Caches the placit places in the entity cache if it is enabled.
	 *
	 * @param placitPlaces the placit places
	 */
	public static void cacheResult(List<PlacitPlace> placitPlaces) {
		getPersistence().cacheResult(placitPlaces);
	}

	/**
	 * Creates a new placit place with the primary key. Does not add the placit place to the database.
	 *
	 * @param placitPlaceId the primary key for the new placit place
	 * @return the new placit place
	 */
	public static PlacitPlace create(long placitPlaceId) {
		return getPersistence().create(placitPlaceId);
	}

	/**
	 * Removes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace remove(long placitPlaceId)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().remove(placitPlaceId);
	}

	public static PlacitPlace updateImpl(PlacitPlace placitPlace) {
		return getPersistence().updateImpl(placitPlace);
	}

	/**
	 * Returns the placit place with the primary key or throws a <code>NoSuchPlacitPlaceException</code> if it could not be found.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place
	 * @throws NoSuchPlacitPlaceException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace findByPrimaryKey(long placitPlaceId)
		throws eu.strasbourg.service.project.exception.
			NoSuchPlacitPlaceException {

		return getPersistence().findByPrimaryKey(placitPlaceId);
	}

	/**
	 * Returns the placit place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place, or <code>null</code> if a placit place with the primary key could not be found
	 */
	public static PlacitPlace fetchByPrimaryKey(long placitPlaceId) {
		return getPersistence().fetchByPrimaryKey(placitPlaceId);
	}

	/**
	 * Returns all the placit places.
	 *
	 * @return the placit places
	 */
	public static List<PlacitPlace> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of placit places
	 */
	public static List<PlacitPlace> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of placit places
	 */
	public static List<PlacitPlace> findAll(
		int start, int end, OrderByComparator<PlacitPlace> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of placit places
	 */
	public static List<PlacitPlace> findAll(
		int start, int end, OrderByComparator<PlacitPlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the placit places from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of placit places.
	 *
	 * @return the number of placit places
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PlacitPlacePersistence getPersistence() {
		return _persistence;
	}

	private static volatile PlacitPlacePersistence _persistence;

}