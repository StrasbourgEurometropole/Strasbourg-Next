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

import eu.strasbourg.service.project.model.BudgetPhase;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the budget phase service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.BudgetPhasePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetPhasePersistence
 * @generated
 */
public class BudgetPhaseUtil {

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
	public static void clearCache(BudgetPhase budgetPhase) {
		getPersistence().clearCache(budgetPhase);
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
	public static Map<Serializable, BudgetPhase> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<BudgetPhase> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<BudgetPhase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<BudgetPhase> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static BudgetPhase update(BudgetPhase budgetPhase) {
		return getPersistence().update(budgetPhase);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static BudgetPhase update(
		BudgetPhase budgetPhase, ServiceContext serviceContext) {

		return getPersistence().update(budgetPhase, serviceContext);
	}

	/**
	 * Returns all the budget phases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching budget phases
	 */
	public static List<BudgetPhase> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByUuid_First(
			String uuid, OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUuid_First(
		String uuid, OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByUuid_Last(
			String uuid, OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUuid_Last(
		String uuid, OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where uuid = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase[] findByUuid_PrevAndNext(
			long budgetPhaseId, String uuid,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_PrevAndNext(
			budgetPhaseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the budget phases where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of budget phases where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching budget phases
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBudgetPhaseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the budget phase where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the budget phase where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the budget phase that was removed
	 */
	public static BudgetPhase removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of budget phases where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching budget phases
	 */
	public static List<BudgetPhase> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase[] findByUuid_C_PrevAndNext(
			long budgetPhaseId, String uuid, long companyId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByUuid_C_PrevAndNext(
			budgetPhaseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the budget phases where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of budget phases where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching budget phases
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the budget phases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching budget phases
	 */
	public static List<BudgetPhase> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public static List<BudgetPhase> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the budget phases where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByGroupId_First(
			long groupId, OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByGroupId_First(
		long groupId, OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByGroupId_Last(
			long groupId, OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByGroupId_Last(
		long groupId, OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where groupId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase[] findByGroupId_PrevAndNext(
			long budgetPhaseId, long groupId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByGroupId_PrevAndNext(
			budgetPhaseId, groupId, orderByComparator);
	}

	/**
	 * Removes all the budget phases where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of budget phases where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the matching budget phases
	 */
	public static List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId) {

		return getPersistence().findByIsActiveAndGroupId(isActive, groupId);
	}

	/**
	 * Returns a range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of matching budget phases
	 */
	public static List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end) {

		return getPersistence().findByIsActiveAndGroupId(
			isActive, groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findByIsActiveAndGroupId(
			isActive, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching budget phases
	 */
	public static List<BudgetPhase> findByIsActiveAndGroupId(
		boolean isActive, long groupId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByIsActiveAndGroupId(
			isActive, groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByIsActiveAndGroupId_First(
			boolean isActive, long groupId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByIsActiveAndGroupId_First(
			isActive, groupId, orderByComparator);
	}

	/**
	 * Returns the first budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByIsActiveAndGroupId_First(
		boolean isActive, long groupId,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByIsActiveAndGroupId_First(
			isActive, groupId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase
	 * @throws NoSuchBudgetPhaseException if a matching budget phase could not be found
	 */
	public static BudgetPhase findByIsActiveAndGroupId_Last(
			boolean isActive, long groupId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByIsActiveAndGroupId_Last(
			isActive, groupId, orderByComparator);
	}

	/**
	 * Returns the last budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchByIsActiveAndGroupId_Last(
		boolean isActive, long groupId,
		OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().fetchByIsActiveAndGroupId_Last(
			isActive, groupId, orderByComparator);
	}

	/**
	 * Returns the budget phases before and after the current budget phase in the ordered set where isActive = &#63; and groupId = &#63;.
	 *
	 * @param budgetPhaseId the primary key of the current budget phase
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase[] findByIsActiveAndGroupId_PrevAndNext(
			long budgetPhaseId, boolean isActive, long groupId,
			OrderByComparator<BudgetPhase> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByIsActiveAndGroupId_PrevAndNext(
			budgetPhaseId, isActive, groupId, orderByComparator);
	}

	/**
	 * Removes all the budget phases where isActive = &#63; and groupId = &#63; from the database.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 */
	public static void removeByIsActiveAndGroupId(
		boolean isActive, long groupId) {

		getPersistence().removeByIsActiveAndGroupId(isActive, groupId);
	}

	/**
	 * Returns the number of budget phases where isActive = &#63; and groupId = &#63;.
	 *
	 * @param isActive the is active
	 * @param groupId the group ID
	 * @return the number of matching budget phases
	 */
	public static int countByIsActiveAndGroupId(
		boolean isActive, long groupId) {

		return getPersistence().countByIsActiveAndGroupId(isActive, groupId);
	}

	/**
	 * Caches the budget phase in the entity cache if it is enabled.
	 *
	 * @param budgetPhase the budget phase
	 */
	public static void cacheResult(BudgetPhase budgetPhase) {
		getPersistence().cacheResult(budgetPhase);
	}

	/**
	 * Caches the budget phases in the entity cache if it is enabled.
	 *
	 * @param budgetPhases the budget phases
	 */
	public static void cacheResult(List<BudgetPhase> budgetPhases) {
		getPersistence().cacheResult(budgetPhases);
	}

	/**
	 * Creates a new budget phase with the primary key. Does not add the budget phase to the database.
	 *
	 * @param budgetPhaseId the primary key for the new budget phase
	 * @return the new budget phase
	 */
	public static BudgetPhase create(long budgetPhaseId) {
		return getPersistence().create(budgetPhaseId);
	}

	/**
	 * Removes the budget phase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase that was removed
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase remove(long budgetPhaseId)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().remove(budgetPhaseId);
	}

	public static BudgetPhase updateImpl(BudgetPhase budgetPhase) {
		return getPersistence().updateImpl(budgetPhase);
	}

	/**
	 * Returns the budget phase with the primary key or throws a <code>NoSuchBudgetPhaseException</code> if it could not be found.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase
	 * @throws NoSuchBudgetPhaseException if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase findByPrimaryKey(long budgetPhaseId)
		throws eu.strasbourg.service.project.exception.
			NoSuchBudgetPhaseException {

		return getPersistence().findByPrimaryKey(budgetPhaseId);
	}

	/**
	 * Returns the budget phase with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase, or <code>null</code> if a budget phase with the primary key could not be found
	 */
	public static BudgetPhase fetchByPrimaryKey(long budgetPhaseId) {
		return getPersistence().fetchByPrimaryKey(budgetPhaseId);
	}

	/**
	 * Returns all the budget phases.
	 *
	 * @return the budget phases
	 */
	public static List<BudgetPhase> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of budget phases
	 */
	public static List<BudgetPhase> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of budget phases
	 */
	public static List<BudgetPhase> findAll(
		int start, int end, OrderByComparator<BudgetPhase> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of budget phases
	 */
	public static List<BudgetPhase> findAll(
		int start, int end, OrderByComparator<BudgetPhase> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the budget phases from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of budget phases.
	 *
	 * @return the number of budget phases
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static BudgetPhasePersistence getPersistence() {
		return _persistence;
	}

	private static volatile BudgetPhasePersistence _persistence;

}