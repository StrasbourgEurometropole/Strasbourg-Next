/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.InitiativeHelp;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the initiative help service. This utility wraps <code>eu.strasbourg.service.project.service.persistence.impl.InitiativeHelpPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeHelpPersistence
 * @generated
 */
public class InitiativeHelpUtil {

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
	public static void clearCache(InitiativeHelp initiativeHelp) {
		getPersistence().clearCache(initiativeHelp);
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
	public static Map<Serializable, InitiativeHelp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<InitiativeHelp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<InitiativeHelp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<InitiativeHelp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static InitiativeHelp update(InitiativeHelp initiativeHelp) {
		return getPersistence().update(initiativeHelp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static InitiativeHelp update(
		InitiativeHelp initiativeHelp, ServiceContext serviceContext) {

		return getPersistence().update(initiativeHelp, serviceContext);
	}

	/**
	 * Returns all the initiative helps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching initiative helps
	 */
	public static List<InitiativeHelp> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiative helps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByUuid_First(
			String uuid, OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByUuid_First(
		String uuid, OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByUuid_Last(
			String uuid, OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByUuid_Last(
		String uuid, OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where uuid = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp[] findByUuid_PrevAndNext(
			long initiativeHelpId, String uuid,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByUuid_PrevAndNext(
			initiativeHelpId, uuid, orderByComparator);
	}

	/**
	 * Removes all the initiative helps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of initiative helps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching initiative helps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the initiative help where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the initiative help where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the initiative help that was removed
	 */
	public static InitiativeHelp removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of initiative helps where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching initiative helps
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the initiative helps where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the matching initiative helps
	 */
	public static List<InitiativeHelp> findByPublikUserId(String publikUserId) {
		return getPersistence().findByPublikUserId(publikUserId);
	}

	/**
	 * Returns a range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end) {

		return getPersistence().findByPublikUserId(publikUserId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().findByPublikUserId(
			publikUserId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiative helps where publikUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param publikUserId the publik user ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByPublikUserId(
		String publikUserId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPublikUserId(
			publikUserId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByPublikUserId_First(
			String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByPublikUserId_First(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the first initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByPublikUserId_First(
		String publikUserId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByPublikUserId_First(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByPublikUserId_Last(
			String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByPublikUserId_Last(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByPublikUserId_Last(
		String publikUserId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByPublikUserId_Last(
			publikUserId, orderByComparator);
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where publikUserId = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param publikUserId the publik user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp[] findByPublikUserId_PrevAndNext(
			long initiativeHelpId, String publikUserId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByPublikUserId_PrevAndNext(
			initiativeHelpId, publikUserId, orderByComparator);
	}

	/**
	 * Removes all the initiative helps where publikUserId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 */
	public static void removeByPublikUserId(String publikUserId) {
		getPersistence().removeByPublikUserId(publikUserId);
	}

	/**
	 * Returns the number of initiative helps where publikUserId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @return the number of matching initiative helps
	 */
	public static int countByPublikUserId(String publikUserId) {
		return getPersistence().countByPublikUserId(publikUserId);
	}

	/**
	 * Returns all the initiative helps where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the matching initiative helps
	 */
	public static List<InitiativeHelp> findByinitiativeId(long initiativeId) {
		return getPersistence().findByinitiativeId(initiativeId);
	}

	/**
	 * Returns a range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end) {

		return getPersistence().findByinitiativeId(initiativeId, start, end);
	}

	/**
	 * Returns an ordered range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().findByinitiativeId(
			initiativeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiative helps where initiativeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param initiativeId the initiative ID
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching initiative helps
	 */
	public static List<InitiativeHelp> findByinitiativeId(
		long initiativeId, int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByinitiativeId(
			initiativeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByinitiativeId_First(
			long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByinitiativeId_First(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the first initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByinitiativeId_First(
		long initiativeId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByinitiativeId_First(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByinitiativeId_Last(
			long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByinitiativeId_Last(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the last initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByinitiativeId_Last(
		long initiativeId,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().fetchByinitiativeId_Last(
			initiativeId, orderByComparator);
	}

	/**
	 * Returns the initiative helps before and after the current initiative help in the ordered set where initiativeId = &#63;.
	 *
	 * @param initiativeHelpId the primary key of the current initiative help
	 * @param initiativeId the initiative ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp[] findByinitiativeId_PrevAndNext(
			long initiativeHelpId, long initiativeId,
			OrderByComparator<InitiativeHelp> orderByComparator)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByinitiativeId_PrevAndNext(
			initiativeHelpId, initiativeId, orderByComparator);
	}

	/**
	 * Removes all the initiative helps where initiativeId = &#63; from the database.
	 *
	 * @param initiativeId the initiative ID
	 */
	public static void removeByinitiativeId(long initiativeId) {
		getPersistence().removeByinitiativeId(initiativeId);
	}

	/**
	 * Returns the number of initiative helps where initiativeId = &#63;.
	 *
	 * @param initiativeId the initiative ID
	 * @return the number of matching initiative helps
	 */
	public static int countByinitiativeId(long initiativeId) {
		return getPersistence().countByinitiativeId(initiativeId);
	}

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the matching initiative help
	 * @throws NoSuchInitiativeHelpException if a matching initiative help could not be found
	 */
	public static InitiativeHelp findByPublikUserIdAndInitiativeId(
			String publikUserId, long initiativeId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);
	}

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId) {

		return getPersistence().fetchByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);
	}

	/**
	 * Returns the initiative help where publikUserId = &#63; and initiativeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	public static InitiativeHelp fetchByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId, boolean useFinderCache) {

		return getPersistence().fetchByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId, useFinderCache);
	}

	/**
	 * Removes the initiative help where publikUserId = &#63; and initiativeId = &#63; from the database.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the initiative help that was removed
	 */
	public static InitiativeHelp removeByPublikUserIdAndInitiativeId(
			String publikUserId, long initiativeId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().removeByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);
	}

	/**
	 * Returns the number of initiative helps where publikUserId = &#63; and initiativeId = &#63;.
	 *
	 * @param publikUserId the publik user ID
	 * @param initiativeId the initiative ID
	 * @return the number of matching initiative helps
	 */
	public static int countByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId) {

		return getPersistence().countByPublikUserIdAndInitiativeId(
			publikUserId, initiativeId);
	}

	/**
	 * Caches the initiative help in the entity cache if it is enabled.
	 *
	 * @param initiativeHelp the initiative help
	 */
	public static void cacheResult(InitiativeHelp initiativeHelp) {
		getPersistence().cacheResult(initiativeHelp);
	}

	/**
	 * Caches the initiative helps in the entity cache if it is enabled.
	 *
	 * @param initiativeHelps the initiative helps
	 */
	public static void cacheResult(List<InitiativeHelp> initiativeHelps) {
		getPersistence().cacheResult(initiativeHelps);
	}

	/**
	 * Creates a new initiative help with the primary key. Does not add the initiative help to the database.
	 *
	 * @param initiativeHelpId the primary key for the new initiative help
	 * @return the new initiative help
	 */
	public static InitiativeHelp create(long initiativeHelpId) {
		return getPersistence().create(initiativeHelpId);
	}

	/**
	 * Removes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp remove(long initiativeHelpId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().remove(initiativeHelpId);
	}

	public static InitiativeHelp updateImpl(InitiativeHelp initiativeHelp) {
		return getPersistence().updateImpl(initiativeHelp);
	}

	/**
	 * Returns the initiative help with the primary key or throws a <code>NoSuchInitiativeHelpException</code> if it could not be found.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help
	 * @throws NoSuchInitiativeHelpException if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp findByPrimaryKey(long initiativeHelpId)
		throws eu.strasbourg.service.project.exception.
			NoSuchInitiativeHelpException {

		return getPersistence().findByPrimaryKey(initiativeHelpId);
	}

	/**
	 * Returns the initiative help with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help, or <code>null</code> if a initiative help with the primary key could not be found
	 */
	public static InitiativeHelp fetchByPrimaryKey(long initiativeHelpId) {
		return getPersistence().fetchByPrimaryKey(initiativeHelpId);
	}

	/**
	 * Returns all the initiative helps.
	 *
	 * @return the initiative helps
	 */
	public static List<InitiativeHelp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of initiative helps
	 */
	public static List<InitiativeHelp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of initiative helps
	 */
	public static List<InitiativeHelp> findAll(
		int start, int end,
		OrderByComparator<InitiativeHelp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of initiative helps
	 */
	public static List<InitiativeHelp> findAll(
		int start, int end, OrderByComparator<InitiativeHelp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the initiative helps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of initiative helps.
	 *
	 * @return the number of initiative helps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InitiativeHelpPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(InitiativeHelpPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile InitiativeHelpPersistence _persistence;

}