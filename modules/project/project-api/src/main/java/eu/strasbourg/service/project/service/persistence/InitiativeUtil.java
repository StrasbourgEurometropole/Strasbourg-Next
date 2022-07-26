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

import eu.strasbourg.service.project.model.Initiative;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the initiative service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.InitiativePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativePersistence
 * @generated
 */
public class InitiativeUtil {

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
	public static void clearCache(Initiative initiative) {
		getPersistence().clearCache(initiative);
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
	public static Map<Serializable, Initiative> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Initiative> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Initiative> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Initiative> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Initiative update(Initiative initiative) {
		return getPersistence().update(initiative);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Initiative update(
		Initiative initiative, ServiceContext serviceContext) {

		return getPersistence().update(initiative, serviceContext);
	}

	/**
	 * Returns all the initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching initiatives
	 */
	public static List<Initiative> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	public static List<Initiative> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByUuid_First(
			String uuid, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUuid_First(
		String uuid, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByUuid_Last(
			String uuid, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUuid_Last(
		String uuid, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where uuid = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative[] findByUuid_PrevAndNext(
			long initiativeId, String uuid,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_PrevAndNext(
			initiativeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the initiatives where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching initiatives
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the initiative where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the initiative that was removed
	 */
	public static Initiative removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of initiatives where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching initiatives
	 */
	public static List<Initiative> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	public static List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative[] findByUuid_C_PrevAndNext(
			long initiativeId, String uuid, long companyId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			initiativeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the initiatives where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching initiatives
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	public static List<Initiative> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	public static List<Initiative> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByGroupId_First(
			long groupId, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByGroupId_First(
		long groupId, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByGroupId_Last(
			long groupId, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByGroupId_Last(
		long groupId, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where groupId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative[] findByGroupId_PrevAndNext(
			long initiativeId, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByGroupId_PrevAndNext(
			initiativeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the initiatives where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching initiatives
	 */
	public static List<Initiative> findBypublikId(String publikId) {
		return getPersistence().findBypublikId(publikId);
	}

	/**
	 * Returns a range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	public static List<Initiative> findBypublikId(
		String publikId, int start, int end) {

		return getPersistence().findBypublikId(publikId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findBypublikId(
			publikId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findBypublikId(
		String publikId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypublikId(
			publikId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findBypublikId_First(
			String publikId, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findBypublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchBypublikId_First(
		String publikId, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchBypublikId_First(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findBypublikId_Last(
			String publikId, OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findBypublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchBypublikId_Last(
		String publikId, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchBypublikId_Last(
			publikId, orderByComparator);
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where publikId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative[] findBypublikId_PrevAndNext(
			long initiativeId, String publikId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findBypublikId_PrevAndNext(
			initiativeId, publikId, orderByComparator);
	}

	/**
	 * Removes all the initiatives where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public static void removeBypublikId(String publikId) {
		getPersistence().removeBypublikId(publikId);
	}

	/**
	 * Returns the number of initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching initiatives
	 */
	public static int countBypublikId(String publikId) {
		return getPersistence().countBypublikId(publikId);
	}

	/**
	 * Returns all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	public static List<Initiative> findByStatusAndGroupId(
		int status, long groupId) {

		return getPersistence().findByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns a range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of matching initiatives
	 */
	public static List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiatives
	 */
	public static List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatusAndGroupId(
			status, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByStatusAndGroupId_First(
			int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByStatusAndGroupId_First(
		int status, long groupId,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_First(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public static Initiative findByStatusAndGroupId_Last(
			int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchByStatusAndGroupId_Last(
		int status, long groupId,
		OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().fetchByStatusAndGroupId_Last(
			status, groupId, orderByComparator);
	}

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative[] findByStatusAndGroupId_PrevAndNext(
			long initiativeId, int status, long groupId,
			OrderByComparator<Initiative> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByStatusAndGroupId_PrevAndNext(
			initiativeId, status, groupId, orderByComparator);
	}

	/**
	 * Removes all the initiatives where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public static void removeByStatusAndGroupId(int status, long groupId) {
		getPersistence().removeByStatusAndGroupId(status, groupId);
	}

	/**
	 * Returns the number of initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public static int countByStatusAndGroupId(int status, long groupId) {
		return getPersistence().countByStatusAndGroupId(status, groupId);
	}

	/**
	 * Caches the initiative in the entity cache if it is enabled.
	 *
	 * @param initiative the initiative
	 */
	public static void cacheResult(Initiative initiative) {
		getPersistence().cacheResult(initiative);
	}

	/**
	 * Caches the initiatives in the entity cache if it is enabled.
	 *
	 * @param initiatives the initiatives
	 */
	public static void cacheResult(List<Initiative> initiatives) {
		getPersistence().cacheResult(initiatives);
	}

	/**
	 * Creates a new initiative with the primary key. Does not add the initiative to the database.
	 *
	 * @param initiativeId the primary key for the new initiative
	 * @return the new initiative
	 */
	public static Initiative create(long initiativeId) {
		return getPersistence().create(initiativeId);
	}

	/**
	 * Removes the initiative with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative that was removed
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative remove(long initiativeId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().remove(initiativeId);
	}

	public static Initiative updateImpl(Initiative initiative) {
		return getPersistence().updateImpl(initiative);
	}

	/**
	 * Returns the initiative with the primary key or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public static Initiative findByPrimaryKey(long initiativeId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeException {

		return getPersistence().findByPrimaryKey(initiativeId);
	}

	/**
	 * Returns the initiative with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative, or <code>null</code> if a initiative with the primary key could not be found
	 */
	public static Initiative fetchByPrimaryKey(long initiativeId) {
		return getPersistence().fetchByPrimaryKey(initiativeId);
	}

	/**
	 * Returns all the initiatives.
	 *
	 * @return the initiatives
	 */
	public static List<Initiative> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of initiatives
	 */
	public static List<Initiative> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of initiatives
	 */
	public static List<Initiative> findAll(
		int start, int end, OrderByComparator<Initiative> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of initiatives
	 */
	public static List<Initiative> findAll(
		int start, int end, OrderByComparator<Initiative> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the initiatives from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of initiatives.
	 *
	 * @return the number of initiatives
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static InitiativePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InitiativePersistence, InitiativePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InitiativePersistence.class);

		ServiceTracker<InitiativePersistence, InitiativePersistence>
			serviceTracker =
				new ServiceTracker
					<InitiativePersistence, InitiativePersistence>(
						bundle.getBundleContext(), InitiativePersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}