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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.gtfs.exception.NoSuchLigneException;
import eu.strasbourg.service.gtfs.model.Ligne;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ligne service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see LigneUtil
 * @generated
 */
@ProviderType
public interface LignePersistence extends BasePersistence<Ligne> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LigneUtil} to access the ligne persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the lignes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lignes
	 */
	public java.util.List<Ligne> findByUuid(String uuid);

	/**
	 * Returns a range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where uuid = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne[] findByUuid_PrevAndNext(
			long ligneId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Removes all the lignes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of lignes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lignes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByUUID_G(String uuid, long groupId)
		throws NoSuchLigneException;

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the ligne where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the ligne where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the ligne that was removed
	 */
	public Ligne removeByUUID_G(String uuid, long groupId)
		throws NoSuchLigneException;

	/**
	 * Returns the number of lignes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lignes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lignes
	 */
	public java.util.List<Ligne> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the first ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the last ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne[] findByUuid_C_PrevAndNext(
			long ligneId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Removes all the lignes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of lignes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lignes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the lignes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching lignes
	 */
	public java.util.List<Ligne> findByGroupId(long groupId);

	/**
	 * Returns a range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	public java.util.List<Ligne> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the first ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the last ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the last ligne in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where groupId = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne[] findByGroupId_PrevAndNext(
			long ligneId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Removes all the lignes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of lignes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching lignes
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the ligne where routeId = &#63; or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param routeId the route ID
	 * @return the matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByRouteId(String routeId) throws NoSuchLigneException;

	/**
	 * Returns the ligne where routeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param routeId the route ID
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByRouteId(String routeId);

	/**
	 * Returns the ligne where routeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param routeId the route ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByRouteId(String routeId, boolean useFinderCache);

	/**
	 * Removes the ligne where routeId = &#63; from the database.
	 *
	 * @param routeId the route ID
	 * @return the ligne that was removed
	 */
	public Ligne removeByRouteId(String routeId) throws NoSuchLigneException;

	/**
	 * Returns the number of lignes where routeId = &#63;.
	 *
	 * @param routeId the route ID
	 * @return the number of matching lignes
	 */
	public int countByRouteId(String routeId);

	/**
	 * Returns all the lignes where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching lignes
	 */
	public java.util.List<Ligne> findByStatus(int status);

	/**
	 * Returns a range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	public java.util.List<Ligne> findByStatus(int status, int start, int end);

	/**
	 * Returns an ordered range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the first ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the last ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the last ligne in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where status = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne[] findByStatus_PrevAndNext(
			long ligneId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Removes all the lignes where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of lignes where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching lignes
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @return the matching lignes
	 */
	public java.util.List<Ligne> findByShortNameAndStatus(
		String shortName, int status);

	/**
	 * Returns a range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of matching lignes
	 */
	public java.util.List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end);

	/**
	 * Returns an ordered range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes where shortName = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching lignes
	 */
	public java.util.List<Ligne> findByShortNameAndStatus(
		String shortName, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByShortNameAndStatus_First(
			String shortName, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the first ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByShortNameAndStatus_First(
		String shortName, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the last ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne
	 * @throws NoSuchLigneException if a matching ligne could not be found
	 */
	public Ligne findByShortNameAndStatus_Last(
			String shortName, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Returns the last ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public Ligne fetchByShortNameAndStatus_Last(
		String shortName, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns the lignes before and after the current ligne in the ordered set where shortName = &#63; and status = &#63;.
	 *
	 * @param ligneId the primary key of the current ligne
	 * @param shortName the short name
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne[] findByShortNameAndStatus_PrevAndNext(
			long ligneId, String shortName, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Ligne>
				orderByComparator)
		throws NoSuchLigneException;

	/**
	 * Removes all the lignes where shortName = &#63; and status = &#63; from the database.
	 *
	 * @param shortName the short name
	 * @param status the status
	 */
	public void removeByShortNameAndStatus(String shortName, int status);

	/**
	 * Returns the number of lignes where shortName = &#63; and status = &#63;.
	 *
	 * @param shortName the short name
	 * @param status the status
	 * @return the number of matching lignes
	 */
	public int countByShortNameAndStatus(String shortName, int status);

	/**
	 * Caches the ligne in the entity cache if it is enabled.
	 *
	 * @param ligne the ligne
	 */
	public void cacheResult(Ligne ligne);

	/**
	 * Caches the lignes in the entity cache if it is enabled.
	 *
	 * @param lignes the lignes
	 */
	public void cacheResult(java.util.List<Ligne> lignes);

	/**
	 * Creates a new ligne with the primary key. Does not add the ligne to the database.
	 *
	 * @param ligneId the primary key for the new ligne
	 * @return the new ligne
	 */
	public Ligne create(long ligneId);

	/**
	 * Removes the ligne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne that was removed
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne remove(long ligneId) throws NoSuchLigneException;

	public Ligne updateImpl(Ligne ligne);

	/**
	 * Returns the ligne with the primary key or throws a <code>NoSuchLigneException</code> if it could not be found.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne
	 * @throws NoSuchLigneException if a ligne with the primary key could not be found
	 */
	public Ligne findByPrimaryKey(long ligneId) throws NoSuchLigneException;

	/**
	 * Returns the ligne with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne, or <code>null</code> if a ligne with the primary key could not be found
	 */
	public Ligne fetchByPrimaryKey(long ligneId);

	/**
	 * Returns all the lignes.
	 *
	 * @return the lignes
	 */
	public java.util.List<Ligne> findAll();

	/**
	 * Returns a range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of lignes
	 */
	public java.util.List<Ligne> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lignes
	 */
	public java.util.List<Ligne> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator);

	/**
	 * Returns an ordered range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lignes
	 */
	public java.util.List<Ligne> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ligne>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the lignes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of lignes.
	 *
	 * @return the number of lignes
	 */
	public int countAll();

}