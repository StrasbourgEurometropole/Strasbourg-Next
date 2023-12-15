/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.ImportHistoric;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the import historic service. This utility wraps <code>eu.strasbourg.service.gtfs.service.persistence.impl.ImportHistoricPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see ImportHistoricPersistence
 * @generated
 */
public class ImportHistoricUtil {

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
	public static void clearCache(ImportHistoric importHistoric) {
		getPersistence().clearCache(importHistoric);
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
	public static Map<Serializable, ImportHistoric> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ImportHistoric> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ImportHistoric> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ImportHistoric> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ImportHistoric update(ImportHistoric importHistoric) {
		return getPersistence().update(importHistoric);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ImportHistoric update(
		ImportHistoric importHistoric, ServiceContext serviceContext) {

		return getPersistence().update(importHistoric, serviceContext);
	}

	/**
	 * Returns all the import historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching import historics
	 */
	public static List<ImportHistoric> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the import historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the import historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first import historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByUuid_First(
			String uuid, OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first import historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUuid_First(
		String uuid, OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByUuid_Last(
			String uuid, OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUuid_Last(
		String uuid, OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the import historics before and after the current import historic in the ordered set where uuid = &#63;.
	 *
	 * @param importHistoricId the primary key of the current import historic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import historic
	 * @throws NoSuchImportHistoricException if a import historic with the primary key could not be found
	 */
	public static ImportHistoric[] findByUuid_PrevAndNext(
			long importHistoricId, String uuid,
			OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_PrevAndNext(
			importHistoricId, uuid, orderByComparator);
	}

	/**
	 * Removes all the import historics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of import historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching import historics
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the import historic where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchImportHistoricException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the import historic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the import historic where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the import historic where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the import historic that was removed
	 */
	public static ImportHistoric removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of import historics where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching import historics
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the import historics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching import historics
	 */
	public static List<ImportHistoric> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the import historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the import historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import historics where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first import historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first import historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the import historics before and after the current import historic in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param importHistoricId the primary key of the current import historic
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import historic
	 * @throws NoSuchImportHistoricException if a import historic with the primary key could not be found
	 */
	public static ImportHistoric[] findByUuid_C_PrevAndNext(
			long importHistoricId, String uuid, long companyId,
			OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByUuid_C_PrevAndNext(
			importHistoricId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the import historics where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of import historics where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching import historics
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the import historics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching import historics
	 */
	public static List<ImportHistoric> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the import historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of matching import historics
	 */
	public static List<ImportHistoric> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the import historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import historics where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching import historics
	 */
	public static List<ImportHistoric> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first import historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByGroupId_First(
			long groupId, OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first import historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByGroupId_First(
		long groupId, OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic
	 * @throws NoSuchImportHistoricException if a matching import historic could not be found
	 */
	public static ImportHistoric findByGroupId_Last(
			long groupId, OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last import historic in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching import historic, or <code>null</code> if a matching import historic could not be found
	 */
	public static ImportHistoric fetchByGroupId_Last(
		long groupId, OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the import historics before and after the current import historic in the ordered set where groupId = &#63;.
	 *
	 * @param importHistoricId the primary key of the current import historic
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next import historic
	 * @throws NoSuchImportHistoricException if a import historic with the primary key could not be found
	 */
	public static ImportHistoric[] findByGroupId_PrevAndNext(
			long importHistoricId, long groupId,
			OrderByComparator<ImportHistoric> orderByComparator)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByGroupId_PrevAndNext(
			importHistoricId, groupId, orderByComparator);
	}

	/**
	 * Removes all the import historics where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of import historics where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching import historics
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the import historic in the entity cache if it is enabled.
	 *
	 * @param importHistoric the import historic
	 */
	public static void cacheResult(ImportHistoric importHistoric) {
		getPersistence().cacheResult(importHistoric);
	}

	/**
	 * Caches the import historics in the entity cache if it is enabled.
	 *
	 * @param importHistorics the import historics
	 */
	public static void cacheResult(List<ImportHistoric> importHistorics) {
		getPersistence().cacheResult(importHistorics);
	}

	/**
	 * Creates a new import historic with the primary key. Does not add the import historic to the database.
	 *
	 * @param importHistoricId the primary key for the new import historic
	 * @return the new import historic
	 */
	public static ImportHistoric create(long importHistoricId) {
		return getPersistence().create(importHistoricId);
	}

	/**
	 * Removes the import historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic that was removed
	 * @throws NoSuchImportHistoricException if a import historic with the primary key could not be found
	 */
	public static ImportHistoric remove(long importHistoricId)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().remove(importHistoricId);
	}

	public static ImportHistoric updateImpl(ImportHistoric importHistoric) {
		return getPersistence().updateImpl(importHistoric);
	}

	/**
	 * Returns the import historic with the primary key or throws a <code>NoSuchImportHistoricException</code> if it could not be found.
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic
	 * @throws NoSuchImportHistoricException if a import historic with the primary key could not be found
	 */
	public static ImportHistoric findByPrimaryKey(long importHistoricId)
		throws eu.strasbourg.service.gtfs.exception.
			NoSuchImportHistoricException {

		return getPersistence().findByPrimaryKey(importHistoricId);
	}

	/**
	 * Returns the import historic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importHistoricId the primary key of the import historic
	 * @return the import historic, or <code>null</code> if a import historic with the primary key could not be found
	 */
	public static ImportHistoric fetchByPrimaryKey(long importHistoricId) {
		return getPersistence().fetchByPrimaryKey(importHistoricId);
	}

	/**
	 * Returns all the import historics.
	 *
	 * @return the import historics
	 */
	public static List<ImportHistoric> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the import historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @return the range of import historics
	 */
	public static List<ImportHistoric> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the import historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of import historics
	 */
	public static List<ImportHistoric> findAll(
		int start, int end,
		OrderByComparator<ImportHistoric> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the import historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ImportHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of import historics
	 * @param end the upper bound of the range of import historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of import historics
	 */
	public static List<ImportHistoric> findAll(
		int start, int end, OrderByComparator<ImportHistoric> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the import historics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of import historics.
	 *
	 * @return the number of import historics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ImportHistoricPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ImportHistoricPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ImportHistoricPersistence _persistence;

}