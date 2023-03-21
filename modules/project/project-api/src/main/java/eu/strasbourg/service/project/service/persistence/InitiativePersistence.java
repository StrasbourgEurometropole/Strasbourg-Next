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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import eu.strasbourg.service.project.exception.NoSuchInitiativeException;
import eu.strasbourg.service.project.model.Initiative;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the initiative service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeUtil
 * @generated
 */
@ProviderType
public interface InitiativePersistence extends BasePersistence<Initiative> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InitiativeUtil} to access the initiative persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching initiatives
	 */
	public java.util.List<Initiative> findByUuid(String uuid);

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
	public java.util.List<Initiative> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Initiative> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where uuid = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public Initiative[] findByUuid_PrevAndNext(
			long initiativeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Removes all the initiatives where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of initiatives where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching initiatives
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeException;

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the initiative where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the initiative where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the initiative that was removed
	 */
	public Initiative removeByUUID_G(String uuid, long groupId)
		throws NoSuchInitiativeException;

	/**
	 * Returns the number of initiatives where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching initiatives
	 */
	public java.util.List<Initiative> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the first initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the last initiative in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public Initiative[] findByUuid_C_PrevAndNext(
			long initiativeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Removes all the initiatives where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of initiatives where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching initiatives
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	public java.util.List<Initiative> findByGroupId(long groupId);

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
	public java.util.List<Initiative> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Initiative> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the first initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the last initiative in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where groupId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public Initiative[] findByGroupId_PrevAndNext(
			long initiativeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Removes all the initiatives where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of initiatives where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching initiatives
	 */
	public java.util.List<Initiative> findBypublikId(String publikId);

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
	public java.util.List<Initiative> findBypublikId(
		String publikId, int start, int end);

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
	public java.util.List<Initiative> findBypublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findBypublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findBypublikId_First(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the first initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchBypublikId_First(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findBypublikId_Last(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the last initiative in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchBypublikId_Last(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the initiatives before and after the current initiative in the ordered set where publikId = &#63;.
	 *
	 * @param initiativeId the primary key of the current initiative
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public Initiative[] findBypublikId_PrevAndNext(
			long initiativeId, String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Removes all the initiatives where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public void removeBypublikId(String publikId);

	/**
	 * Returns the number of initiatives where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching initiatives
	 */
	public int countBypublikId(String publikId);

	/**
	 * Returns all the initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the matching initiatives
	 */
	public java.util.List<Initiative> findByStatusAndGroupId(
		int status, long groupId);

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
	public java.util.List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end);

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
	public java.util.List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findByStatusAndGroupId(
		int status, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByStatusAndGroupId_First(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the first initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByStatusAndGroupId_First(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative
	 * @throws NoSuchInitiativeException if a matching initiative could not be found
	 */
	public Initiative findByStatusAndGroupId_Last(
			int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Returns the last initiative in the ordered set where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public Initiative fetchByStatusAndGroupId_Last(
		int status, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public Initiative[] findByStatusAndGroupId_PrevAndNext(
			long initiativeId, int status, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Initiative>
				orderByComparator)
		throws NoSuchInitiativeException;

	/**
	 * Removes all the initiatives where status = &#63; and groupId = &#63; from the database.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 */
	public void removeByStatusAndGroupId(int status, long groupId);

	/**
	 * Returns the number of initiatives where status = &#63; and groupId = &#63;.
	 *
	 * @param status the status
	 * @param groupId the group ID
	 * @return the number of matching initiatives
	 */
	public int countByStatusAndGroupId(int status, long groupId);

	/**
	 * Caches the initiative in the entity cache if it is enabled.
	 *
	 * @param initiative the initiative
	 */
	public void cacheResult(Initiative initiative);

	/**
	 * Caches the initiatives in the entity cache if it is enabled.
	 *
	 * @param initiatives the initiatives
	 */
	public void cacheResult(java.util.List<Initiative> initiatives);

	/**
	 * Creates a new initiative with the primary key. Does not add the initiative to the database.
	 *
	 * @param initiativeId the primary key for the new initiative
	 * @return the new initiative
	 */
	public Initiative create(long initiativeId);

	/**
	 * Removes the initiative with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative that was removed
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public Initiative remove(long initiativeId)
		throws NoSuchInitiativeException;

	public Initiative updateImpl(Initiative initiative);

	/**
	 * Returns the initiative with the primary key or throws a <code>NoSuchInitiativeException</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative
	 * @throws NoSuchInitiativeException if a initiative with the primary key could not be found
	 */
	public Initiative findByPrimaryKey(long initiativeId)
		throws NoSuchInitiativeException;

	/**
	 * Returns the initiative with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative, or <code>null</code> if a initiative with the primary key could not be found
	 */
	public Initiative fetchByPrimaryKey(long initiativeId);

	/**
	 * Returns all the initiatives.
	 *
	 * @return the initiatives
	 */
	public java.util.List<Initiative> findAll();

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
	public java.util.List<Initiative> findAll(int start, int end);

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
	public java.util.List<Initiative> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator);

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
	public java.util.List<Initiative> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Initiative>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the initiatives from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of initiatives.
	 *
	 * @return the number of initiatives
	 */
	public int countAll();

}