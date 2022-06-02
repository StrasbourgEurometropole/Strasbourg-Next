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

package eu.strasbourg.service.gtfs.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.Arret;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the arret service. This utility wraps <code>eu.strasbourg.service.gtfs.service.persistence.impl.ArretPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see ArretPersistence
 * @generated
 */
public class ArretUtil {

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
	public static void clearCache(Arret arret) {
		getPersistence().clearCache(arret);
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
	public static Map<Serializable, Arret> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Arret> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Arret> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Arret> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Arret update(Arret arret) {
		return getPersistence().update(arret);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Arret update(Arret arret, ServiceContext serviceContext) {
		return getPersistence().update(arret, serviceContext);
	}

	/**
	 * Returns all the arrets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching arrets
	 */
	public static List<Arret> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the arrets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of matching arrets
	 */
	public static List<Arret> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the arrets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Arret> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first arret in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByUuid_First(
			String uuid, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first arret in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUuid_First(
		String uuid, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByUuid_Last(
			String uuid, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUuid_Last(
		String uuid, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the arrets before and after the current arret in the ordered set where uuid = &#63;.
	 *
	 * @param arretId the primary key of the current arret
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret[] findByUuid_PrevAndNext(
			long arretId, String uuid,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_PrevAndNext(
			arretId, uuid, orderByComparator);
	}

	/**
	 * Removes all the arrets where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of arrets where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching arrets
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the arret where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchArretException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the arret where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the arret where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the arret where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the arret that was removed
	 */
	public static Arret removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of arrets where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching arrets
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the arrets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching arrets
	 */
	public static List<Arret> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the arrets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of matching arrets
	 */
	public static List<Arret> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the arrets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Arret> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first arret in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first arret in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the arrets before and after the current arret in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param arretId the primary key of the current arret
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret[] findByUuid_C_PrevAndNext(
			long arretId, String uuid, long companyId,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByUuid_C_PrevAndNext(
			arretId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the arrets where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of arrets where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching arrets
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the arrets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching arrets
	 */
	public static List<Arret> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the arrets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of matching arrets
	 */
	public static List<Arret> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the arrets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Arret> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first arret in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByGroupId_First(
			long groupId, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first arret in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByGroupId_First(
		long groupId, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByGroupId_Last(
			long groupId, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByGroupId_Last(
		long groupId, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the arrets before and after the current arret in the ordered set where groupId = &#63;.
	 *
	 * @param arretId the primary key of the current arret
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret[] findByGroupId_PrevAndNext(
			long arretId, long groupId,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByGroupId_PrevAndNext(
			arretId, groupId, orderByComparator);
	}

	/**
	 * Removes all the arrets where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of arrets where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching arrets
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the arrets where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching arrets
	 */
	public static List<Arret> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the arrets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of matching arrets
	 */
	public static List<Arret> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the arrets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByStatus(
		int status, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByStatus(
		int status, int start, int end,
		OrderByComparator<Arret> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first arret in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByStatus_First(
			int status, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first arret in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByStatus_First(
		int status, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByStatus_Last(
			int status, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByStatus_Last(
		int status, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the arrets before and after the current arret in the ordered set where status = &#63;.
	 *
	 * @param arretId the primary key of the current arret
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret[] findByStatus_PrevAndNext(
			long arretId, int status,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByStatus_PrevAndNext(
			arretId, status, orderByComparator);
	}

	/**
	 * Removes all the arrets where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of arrets where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching arrets
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns the arret where stopId = &#63; or throws a <code>NoSuchArretException</code> if it could not be found.
	 *
	 * @param stopId the stop ID
	 * @return the matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByStopId(String stopId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByStopId(stopId);
	}

	/**
	 * Returns the arret where stopId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param stopId the stop ID
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByStopId(String stopId) {
		return getPersistence().fetchByStopId(stopId);
	}

	/**
	 * Returns the arret where stopId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param stopId the stop ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByStopId(String stopId, boolean useFinderCache) {
		return getPersistence().fetchByStopId(stopId, useFinderCache);
	}

	/**
	 * Removes the arret where stopId = &#63; from the database.
	 *
	 * @param stopId the stop ID
	 * @return the arret that was removed
	 */
	public static Arret removeByStopId(String stopId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().removeByStopId(stopId);
	}

	/**
	 * Returns the number of arrets where stopId = &#63;.
	 *
	 * @param stopId the stop ID
	 * @return the number of matching arrets
	 */
	public static int countByStopId(String stopId) {
		return getPersistence().countByStopId(stopId);
	}

	/**
	 * Returns all the arrets where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching arrets
	 */
	public static List<Arret> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the arrets where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of matching arrets
	 */
	public static List<Arret> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the arrets where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByCode(
		String code, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching arrets
	 */
	public static List<Arret> findByCode(
		String code, int start, int end,
		OrderByComparator<Arret> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first arret in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByCode_First(
			String code, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first arret in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByCode_First(
		String code, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret
	 * @throws NoSuchArretException if a matching arret could not be found
	 */
	public static Arret findByCode_Last(
			String code, OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last arret in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchByCode_Last(
		String code, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the arrets before and after the current arret in the ordered set where code = &#63;.
	 *
	 * @param arretId the primary key of the current arret
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret[] findByCode_PrevAndNext(
			long arretId, String code,
			OrderByComparator<Arret> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByCode_PrevAndNext(
			arretId, code, orderByComparator);
	}

	/**
	 * Removes all the arrets where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of arrets where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching arrets
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Caches the arret in the entity cache if it is enabled.
	 *
	 * @param arret the arret
	 */
	public static void cacheResult(Arret arret) {
		getPersistence().cacheResult(arret);
	}

	/**
	 * Caches the arrets in the entity cache if it is enabled.
	 *
	 * @param arrets the arrets
	 */
	public static void cacheResult(List<Arret> arrets) {
		getPersistence().cacheResult(arrets);
	}

	/**
	 * Creates a new arret with the primary key. Does not add the arret to the database.
	 *
	 * @param arretId the primary key for the new arret
	 * @return the new arret
	 */
	public static Arret create(long arretId) {
		return getPersistence().create(arretId);
	}

	/**
	 * Removes the arret with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret that was removed
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret remove(long arretId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().remove(arretId);
	}

	public static Arret updateImpl(Arret arret) {
		return getPersistence().updateImpl(arret);
	}

	/**
	 * Returns the arret with the primary key or throws a <code>NoSuchArretException</code> if it could not be found.
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret
	 * @throws NoSuchArretException if a arret with the primary key could not be found
	 */
	public static Arret findByPrimaryKey(long arretId)
		throws eu.strasbourg.service.gtfs.exception.NoSuchArretException {

		return getPersistence().findByPrimaryKey(arretId);
	}

	/**
	 * Returns the arret with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret, or <code>null</code> if a arret with the primary key could not be found
	 */
	public static Arret fetchByPrimaryKey(long arretId) {
		return getPersistence().fetchByPrimaryKey(arretId);
	}

	/**
	 * Returns all the arrets.
	 *
	 * @return the arrets
	 */
	public static List<Arret> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the arrets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of arrets
	 */
	public static List<Arret> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the arrets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of arrets
	 */
	public static List<Arret> findAll(
		int start, int end, OrderByComparator<Arret> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the arrets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ArretModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of arrets
	 */
	public static List<Arret> findAll(
		int start, int end, OrderByComparator<Arret> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the arrets from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of arrets.
	 *
	 * @return the number of arrets
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ArretPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArretPersistence, ArretPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArretPersistence.class);

		ServiceTracker<ArretPersistence, ArretPersistence> serviceTracker =
			new ServiceTracker<ArretPersistence, ArretPersistence>(
				bundle.getBundleContext(), ArretPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}