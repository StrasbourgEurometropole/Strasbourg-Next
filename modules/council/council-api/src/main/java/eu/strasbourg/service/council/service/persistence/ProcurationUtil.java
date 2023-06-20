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

package eu.strasbourg.service.council.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.council.model.Procuration;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the procuration service. This utility wraps <code>eu.strasbourg.service.council.service.persistence.impl.ProcurationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProcurationPersistence
 * @generated
 */
public class ProcurationUtil {

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
	public static void clearCache(Procuration procuration) {
		getPersistence().clearCache(procuration);
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
	public static Map<Serializable, Procuration> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Procuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Procuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Procuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Procuration update(Procuration procuration) {
		return getPersistence().update(procuration);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Procuration update(
		Procuration procuration, ServiceContext serviceContext) {

		return getPersistence().update(procuration, serviceContext);
	}

	/**
	 * Returns all the procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching procurations
	 */
	public static List<Procuration> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	public static List<Procuration> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByUuid_First(
			String uuid, OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUuid_First(
		String uuid, OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByUuid_Last(
			String uuid, OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUuid_Last(
		String uuid, OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration[] findByUuid_PrevAndNext(
			long procurationId, String uuid,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_PrevAndNext(
			procurationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the procurations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of procurations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching procurations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the procuration where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the procuration where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the procuration that was removed
	 */
	public static Procuration removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching procurations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching procurations
	 */
	public static List<Procuration> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	public static List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration[] findByUuid_C_PrevAndNext(
			long procurationId, String uuid, long companyId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			procurationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the procurations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of procurations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching procurations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the matching procurations
	 */
	public static List<Procuration> findByCouncilSessionId(
		long councilSessionId) {

		return getPersistence().findByCouncilSessionId(councilSessionId);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCouncilSessionId(
			councilSessionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByCouncilSessionId_First(
			long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByCouncilSessionId_First(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByCouncilSessionId_First(
		long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByCouncilSessionId_First(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByCouncilSessionId_Last(
			long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByCouncilSessionId_Last(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByCouncilSessionId_Last(
		long councilSessionId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByCouncilSessionId_Last(
			councilSessionId, orderByComparator);
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration[] findByCouncilSessionId_PrevAndNext(
			long procurationId, long councilSessionId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByCouncilSessionId_PrevAndNext(
			procurationId, councilSessionId, orderByComparator);
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 */
	public static void removeByCouncilSessionId(long councilSessionId) {
		getPersistence().removeByCouncilSessionId(councilSessionId);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the number of matching procurations
	 */
	public static int countByCouncilSessionId(long councilSessionId) {
		return getPersistence().countByCouncilSessionId(councilSessionId);
	}

	/**
	 * Returns all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the matching procurations
	 */
	public static List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end) {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, start, end);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration> findByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId, int start, int end,
		OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByCouncilSessionIdAndOfficialVotersId_First(
			long councilSessionId, long officialVotersId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId_First(
			councilSessionId, officialVotersId, orderByComparator);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByCouncilSessionIdAndOfficialVotersId_First(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().
			fetchByCouncilSessionIdAndOfficialVotersId_First(
				councilSessionId, officialVotersId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByCouncilSessionIdAndOfficialVotersId_Last(
			long councilSessionId, long officialVotersId,
			OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByCouncilSessionIdAndOfficialVotersId_Last(
			councilSessionId, officialVotersId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByCouncilSessionIdAndOfficialVotersId_Last(
		long councilSessionId, long officialVotersId,
		OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().fetchByCouncilSessionIdAndOfficialVotersId_Last(
			councilSessionId, officialVotersId, orderByComparator);
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration[]
			findByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
				long procurationId, long councilSessionId,
				long officialVotersId,
				OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			findByCouncilSessionIdAndOfficialVotersId_PrevAndNext(
				procurationId, councilSessionId, officialVotersId,
				orderByComparator);
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; and officialVotersId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 */
	public static void removeByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		getPersistence().removeByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialVotersId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @return the number of matching procurations
	 */
	public static int countByCouncilSessionIdAndOfficialVotersId(
		long councilSessionId, long officialVotersId) {

		return getPersistence().countByCouncilSessionIdAndOfficialVotersId(
			councilSessionId, officialVotersId);
	}

	/**
	 * Returns all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procurations
	 */
	public static List<Procuration>
		findByCouncilSessionIdAndOfficialUnavailableId(
			long councilSessionId, long officialUnavailableId) {

		return getPersistence().findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId);
	}

	/**
	 * Returns a range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of matching procurations
	 */
	public static List<Procuration>
		findByCouncilSessionIdAndOfficialUnavailableId(
			long councilSessionId, long officialUnavailableId, int start,
			int end) {

		return getPersistence().findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, start, end);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration>
		findByCouncilSessionIdAndOfficialUnavailableId(
			long councilSessionId, long officialUnavailableId, int start,
			int end, OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching procurations
	 */
	public static List<Procuration>
		findByCouncilSessionIdAndOfficialUnavailableId(
			long councilSessionId, long officialUnavailableId, int start,
			int end, OrderByComparator<Procuration> orderByComparator,
			boolean useFinderCache) {

		return getPersistence().findByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration
			findByCouncilSessionIdAndOfficialUnavailableId_First(
				long councilSessionId, long officialUnavailableId,
				OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			findByCouncilSessionIdAndOfficialUnavailableId_First(
				councilSessionId, officialUnavailableId, orderByComparator);
	}

	/**
	 * Returns the first procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration
		fetchByCouncilSessionIdAndOfficialUnavailableId_First(
			long councilSessionId, long officialUnavailableId,
			OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().
			fetchByCouncilSessionIdAndOfficialUnavailableId_First(
				councilSessionId, officialUnavailableId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration
			findByCouncilSessionIdAndOfficialUnavailableId_Last(
				long councilSessionId, long officialUnavailableId,
				OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			findByCouncilSessionIdAndOfficialUnavailableId_Last(
				councilSessionId, officialUnavailableId, orderByComparator);
	}

	/**
	 * Returns the last procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration
		fetchByCouncilSessionIdAndOfficialUnavailableId_Last(
			long councilSessionId, long officialUnavailableId,
			OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().
			fetchByCouncilSessionIdAndOfficialUnavailableId_Last(
				councilSessionId, officialUnavailableId, orderByComparator);
	}

	/**
	 * Returns the procurations before and after the current procuration in the ordered set where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param procurationId the primary key of the current procuration
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration[]
			findByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
				long procurationId, long councilSessionId,
				long officialUnavailableId,
				OrderByComparator<Procuration> orderByComparator)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			findByCouncilSessionIdAndOfficialUnavailableId_PrevAndNext(
				procurationId, councilSessionId, officialUnavailableId,
				orderByComparator);
	}

	/**
	 * Removes all the procurations where councilSessionId = &#63; and officialUnavailableId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 */
	public static void removeByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId) {

		getPersistence().removeByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the number of matching procurations
	 */
	public static int countByCouncilSessionIdAndOfficialUnavailableId(
		long councilSessionId, long officialUnavailableId) {

		return getPersistence().countByCouncilSessionIdAndOfficialUnavailableId(
			councilSessionId, officialUnavailableId);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration
			findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				long councilSessionId, long officialVotersId,
				long officialUnavailableId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			findByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration
		fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVotersId,
			long officialUnavailableId) {

		return getPersistence().
			fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration
		fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
			long councilSessionId, long officialVotersId,
			long officialUnavailableId, boolean useFinderCache) {

		return getPersistence().
			fetchByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId,
				useFinderCache);
	}

	/**
	 * Removes the procuration where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the procuration that was removed
	 */
	public static Procuration
			removeByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				long councilSessionId, long officialVotersId,
				long officialUnavailableId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().
			removeByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialVotersId = &#63; and officialUnavailableId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialVotersId the official voters ID
	 * @param officialUnavailableId the official unavailable ID
	 * @return the number of matching procurations
	 */
	public static int countByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
		long councilSessionId, long officialVotersId,
		long officialUnavailableId) {

		return getPersistence().
			countByCouncilSessionIdAndOfficialVotersAndUnavailableIds(
				councilSessionId, officialVotersId, officialUnavailableId);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the matching procuration
	 * @throws NoSuchProcurationException if a matching procuration could not be found
	 */
	public static Procuration findByAbsenceForCouncilSession(
			long councilSessionId, long officialUnavailableId, boolean isAbsent)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent) {

		return getPersistence().fetchByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);
	}

	/**
	 * Returns the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching procuration, or <code>null</code> if a matching procuration could not be found
	 */
	public static Procuration fetchByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent,
		boolean useFinderCache) {

		return getPersistence().fetchByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent, useFinderCache);
	}

	/**
	 * Removes the procuration where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the procuration that was removed
	 */
	public static Procuration removeByAbsenceForCouncilSession(
			long councilSessionId, long officialUnavailableId, boolean isAbsent)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().removeByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);
	}

	/**
	 * Returns the number of procurations where councilSessionId = &#63; and officialUnavailableId = &#63; and isAbsent = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param officialUnavailableId the official unavailable ID
	 * @param isAbsent the is absent
	 * @return the number of matching procurations
	 */
	public static int countByAbsenceForCouncilSession(
		long councilSessionId, long officialUnavailableId, boolean isAbsent) {

		return getPersistence().countByAbsenceForCouncilSession(
			councilSessionId, officialUnavailableId, isAbsent);
	}

	/**
	 * Caches the procuration in the entity cache if it is enabled.
	 *
	 * @param procuration the procuration
	 */
	public static void cacheResult(Procuration procuration) {
		getPersistence().cacheResult(procuration);
	}

	/**
	 * Caches the procurations in the entity cache if it is enabled.
	 *
	 * @param procurations the procurations
	 */
	public static void cacheResult(List<Procuration> procurations) {
		getPersistence().cacheResult(procurations);
	}

	/**
	 * Creates a new procuration with the primary key. Does not add the procuration to the database.
	 *
	 * @param procurationId the primary key for the new procuration
	 * @return the new procuration
	 */
	public static Procuration create(long procurationId) {
		return getPersistence().create(procurationId);
	}

	/**
	 * Removes the procuration with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration that was removed
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration remove(long procurationId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().remove(procurationId);
	}

	public static Procuration updateImpl(Procuration procuration) {
		return getPersistence().updateImpl(procuration);
	}

	/**
	 * Returns the procuration with the primary key or throws a <code>NoSuchProcurationException</code> if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration
	 * @throws NoSuchProcurationException if a procuration with the primary key could not be found
	 */
	public static Procuration findByPrimaryKey(long procurationId)
		throws eu.strasbourg.service.council.exception.
			NoSuchProcurationException {

		return getPersistence().findByPrimaryKey(procurationId);
	}

	/**
	 * Returns the procuration with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param procurationId the primary key of the procuration
	 * @return the procuration, or <code>null</code> if a procuration with the primary key could not be found
	 */
	public static Procuration fetchByPrimaryKey(long procurationId) {
		return getPersistence().fetchByPrimaryKey(procurationId);
	}

	/**
	 * Returns all the procurations.
	 *
	 * @return the procurations
	 */
	public static List<Procuration> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @return the range of procurations
	 */
	public static List<Procuration> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of procurations
	 */
	public static List<Procuration> findAll(
		int start, int end, OrderByComparator<Procuration> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the procurations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProcurationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of procurations
	 * @param end the upper bound of the range of procurations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of procurations
	 */
	public static List<Procuration> findAll(
		int start, int end, OrderByComparator<Procuration> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the procurations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of procurations.
	 *
	 * @return the number of procurations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProcurationPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ProcurationPersistence _persistence;

}