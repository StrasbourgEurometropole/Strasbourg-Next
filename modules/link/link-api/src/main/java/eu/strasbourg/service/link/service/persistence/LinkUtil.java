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

package eu.strasbourg.service.link.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.link.model.Link;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the link service. This utility wraps <code>eu.strasbourg.service.link.service.persistence.impl.LinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see LinkPersistence
 * @generated
 */
public class LinkUtil {

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
	public static void clearCache(Link link) {
		getPersistence().clearCache(link);
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
	public static Map<Serializable, Link> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Link> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Link> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Link update(Link link) {
		return getPersistence().update(link);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Link update(Link link, ServiceContext serviceContext) {
		return getPersistence().update(link, serviceContext);
	}

	/**
	 * Returns all the links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching links
	 */
	public static List<Link> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public static List<Link> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the links where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Link> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByUuid_First(
			String uuid, OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUuid_First(
		String uuid, OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByUuid_Last(
			String uuid, OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUuid_Last(
		String uuid, OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the links before and after the current link in the ordered set where uuid = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public static Link[] findByUuid_PrevAndNext(
			long linkId, String uuid, OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_PrevAndNext(
			linkId, uuid, orderByComparator);
	}

	/**
	 * Removes all the links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching links
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the link where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the link that was removed
	 */
	public static Link removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of links where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching links
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching links
	 */
	public static List<Link> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public static List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the links where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Link> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the links before and after the current link in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public static Link[] findByUuid_C_PrevAndNext(
			long linkId, String uuid, long companyId,
			OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByUuid_C_PrevAndNext(
			linkId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the links where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of links where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching links
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching links
	 */
	public static List<Link> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 */
	public static List<Link> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Link> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the links where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching links
	 */
	public static List<Link> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Link> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByGroupId_First(
			long groupId, OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByGroupId_First(
		long groupId, OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws NoSuchLinkException if a matching link could not be found
	 */
	public static Link findByGroupId_Last(
			long groupId, OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last link in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 */
	public static Link fetchByGroupId_Last(
		long groupId, OrderByComparator<Link> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the links before and after the current link in the ordered set where groupId = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public static Link[] findByGroupId_PrevAndNext(
			long linkId, long groupId,
			OrderByComparator<Link> orderByComparator)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByGroupId_PrevAndNext(
			linkId, groupId, orderByComparator);
	}

	/**
	 * Removes all the links where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of links where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching links
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the link in the entity cache if it is enabled.
	 *
	 * @param link the link
	 */
	public static void cacheResult(Link link) {
		getPersistence().cacheResult(link);
	}

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public static void cacheResult(List<Link> links) {
		getPersistence().cacheResult(links);
	}

	/**
	 * Creates a new link with the primary key. Does not add the link to the database.
	 *
	 * @param linkId the primary key for the new link
	 * @return the new link
	 */
	public static Link create(long linkId) {
		return getPersistence().create(linkId);
	}

	/**
	 * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link
	 * @return the link that was removed
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public static Link remove(long linkId)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().remove(linkId);
	}

	public static Link updateImpl(Link link) {
		return getPersistence().updateImpl(link);
	}

	/**
	 * Returns the link with the primary key or throws a <code>NoSuchLinkException</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link
	 * @throws NoSuchLinkException if a link with the primary key could not be found
	 */
	public static Link findByPrimaryKey(long linkId)
		throws eu.strasbourg.service.link.exception.NoSuchLinkException {

		return getPersistence().findByPrimaryKey(linkId);
	}

	/**
	 * Returns the link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link, or <code>null</code> if a link with the primary key could not be found
	 */
	public static Link fetchByPrimaryKey(long linkId) {
		return getPersistence().fetchByPrimaryKey(linkId);
	}

	/**
	 * Returns all the links.
	 *
	 * @return the links
	 */
	public static List<Link> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of links
	 */
	public static List<Link> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of links
	 */
	public static List<Link> findAll(
		int start, int end, OrderByComparator<Link> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of links
	 */
	public static List<Link> findAll(
		int start, int end, OrderByComparator<Link> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of links.
	 *
	 * @return the number of links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LinkPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LinkPersistence _persistence;

}