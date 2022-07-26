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

package eu.strasbourg.service.agenda.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.agenda.exception.NoSuchManifestationException;
import eu.strasbourg.service.agenda.model.Manifestation;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the manifestation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see ManifestationUtil
 * @generated
 */
@ProviderType
public interface ManifestationPersistence
	extends BasePersistence<Manifestation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ManifestationUtil} to access the manifestation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Manifestation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid(String uuid);

	/**
	 * Returns a range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByUuid_PrevAndNext(
			long manifestationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of manifestations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching manifestations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByUUID_G(String uuid, long groupId)
		throws NoSuchManifestationException;

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the manifestation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the manifestation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the manifestation that was removed
	 */
	public Manifestation removeByUUID_G(String uuid, long groupId)
		throws NoSuchManifestationException;

	/**
	 * Returns the number of manifestations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByUuid_C_PrevAndNext(
			long manifestationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of manifestations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching manifestations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findBytitle(String title);

	/**
	 * Returns a range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findBytitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findBytitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findBytitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchBytitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findBytitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchBytitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where title = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findBytitle_PrevAndNext(
			long manifestationId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeBytitle(String title);

	/**
	 * Returns the number of manifestations where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching manifestations
	 */
	public int countBytitle(String title);

	/**
	 * Returns all the manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByGroupId(long groupId);

	/**
	 * Returns a range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where groupId = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByGroupId_PrevAndNext(
			long manifestationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of manifestations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching manifestations
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns a range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByPublicationDateAndStatus_PrevAndNext(
			long manifestationId, Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	public void removeByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns the number of manifestations where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	public int countByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns all the manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByEndDate(Date endDate);

	/**
	 * Returns a range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByEndDate(
		Date endDate, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where endDate &lt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param endDate the end date
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByEndDate(
		Date endDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByEndDate_First(
			Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByEndDate_First(
		Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByEndDate_Last(
			Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByEndDate_Last(
		Date endDate,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where endDate &lt; &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param endDate the end date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByEndDate_PrevAndNext(
			long manifestationId, Date endDate,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where endDate &lt; &#63; from the database.
	 *
	 * @param endDate the end date
	 */
	public void removeByEndDate(Date endDate);

	/**
	 * Returns the number of manifestations where endDate &lt; &#63;.
	 *
	 * @param endDate the end date
	 * @return the number of matching manifestations
	 */
	public int countByEndDate(Date endDate);

	/**
	 * Returns all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the matching manifestations
	 */
	public java.util.List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status);

	/**
	 * Returns a range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of matching manifestations
	 */
	public java.util.List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching manifestations
	 */
	public java.util.List<Manifestation> findByStatusDateAndStatus(
		Date statusDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByStatusDateAndStatus_First(
			Date statusDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the first manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByStatusDateAndStatus_First(
		Date statusDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByStatusDateAndStatus_Last(
			Date statusDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Returns the last manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByStatusDateAndStatus_Last(
		Date statusDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns the manifestations before and after the current manifestation in the ordered set where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param manifestationId the primary key of the current manifestation
	 * @param statusDate the status date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation[] findByStatusDateAndStatus_PrevAndNext(
			long manifestationId, Date statusDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
				orderByComparator)
		throws NoSuchManifestationException;

	/**
	 * Removes all the manifestations where statusDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 */
	public void removeByStatusDateAndStatus(Date statusDate, int status);

	/**
	 * Returns the number of manifestations where statusDate &lt; &#63; and status = &#63;.
	 *
	 * @param statusDate the status date
	 * @param status the status
	 * @return the number of matching manifestations
	 */
	public int countByStatusDateAndStatus(Date statusDate, int status);

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findBySourceAndIdSource(String source, String idSource)
		throws NoSuchManifestationException;

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchBySourceAndIdSource(
		String source, String idSource);

	/**
	 * Returns the manifestation where source = &#63; and idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchBySourceAndIdSource(
		String source, String idSource, boolean useFinderCache);

	/**
	 * Removes the manifestation where source = &#63; and idSource = &#63; from the database.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	public Manifestation removeBySourceAndIdSource(
			String source, String idSource)
		throws NoSuchManifestationException;

	/**
	 * Returns the number of manifestations where source = &#63; and idSource = &#63;.
	 *
	 * @param source the source
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	public int countBySourceAndIdSource(String source, String idSource);

	/**
	 * Returns the manifestation where idSource = &#63; or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation
	 * @throws NoSuchManifestationException if a matching manifestation could not be found
	 */
	public Manifestation findByIdSource(String idSource)
		throws NoSuchManifestationException;

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param idSource the id source
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByIdSource(String idSource);

	/**
	 * Returns the manifestation where idSource = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param idSource the id source
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public Manifestation fetchByIdSource(
		String idSource, boolean useFinderCache);

	/**
	 * Removes the manifestation where idSource = &#63; from the database.
	 *
	 * @param idSource the id source
	 * @return the manifestation that was removed
	 */
	public Manifestation removeByIdSource(String idSource)
		throws NoSuchManifestationException;

	/**
	 * Returns the number of manifestations where idSource = &#63;.
	 *
	 * @param idSource the id source
	 * @return the number of matching manifestations
	 */
	public int countByIdSource(String idSource);

	/**
	 * Caches the manifestation in the entity cache if it is enabled.
	 *
	 * @param manifestation the manifestation
	 */
	public void cacheResult(Manifestation manifestation);

	/**
	 * Caches the manifestations in the entity cache if it is enabled.
	 *
	 * @param manifestations the manifestations
	 */
	public void cacheResult(java.util.List<Manifestation> manifestations);

	/**
	 * Creates a new manifestation with the primary key. Does not add the manifestation to the database.
	 *
	 * @param manifestationId the primary key for the new manifestation
	 * @return the new manifestation
	 */
	public Manifestation create(long manifestationId);

	/**
	 * Removes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation remove(long manifestationId)
		throws NoSuchManifestationException;

	public Manifestation updateImpl(Manifestation manifestation);

	/**
	 * Returns the manifestation with the primary key or throws a <code>NoSuchManifestationException</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation
	 * @throws NoSuchManifestationException if a manifestation with the primary key could not be found
	 */
	public Manifestation findByPrimaryKey(long manifestationId)
		throws NoSuchManifestationException;

	/**
	 * Returns the manifestation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation, or <code>null</code> if a manifestation with the primary key could not be found
	 */
	public Manifestation fetchByPrimaryKey(long manifestationId);

	/**
	 * Returns all the manifestations.
	 *
	 * @return the manifestations
	 */
	public java.util.List<Manifestation> findAll();

	/**
	 * Returns a range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of manifestations
	 */
	public java.util.List<Manifestation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of manifestations
	 */
	public java.util.List<Manifestation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of manifestations
	 */
	public java.util.List<Manifestation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Manifestation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the manifestations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of manifestations.
	 *
	 * @return the number of manifestations
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return long[] of the primaryKeys of events associated with the manifestation
	 */
	public long[] getEventPrimaryKeys(long pk);

	/**
	 * Returns all the events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the events associated with the manifestation
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk);

	/**
	 * Returns a range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of events associated with the manifestation
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end);

	/**
	 * Returns an ordered range of all the events associated with the manifestation.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the manifestation
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of events associated with the manifestation
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Event> getEvents(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<eu.strasbourg.service.agenda.model.Event> orderByComparator);

	/**
	 * Returns the number of events associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @return the number of events associated with the manifestation
	 */
	public int getEventsSize(long pk);

	/**
	 * Returns <code>true</code> if the event is associated with the manifestation.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 * @return <code>true</code> if the event is associated with the manifestation; <code>false</code> otherwise
	 */
	public boolean containsEvent(long pk, long eventPK);

	/**
	 * Returns <code>true</code> if the manifestation has any events associated with it.
	 *
	 * @param pk the primary key of the manifestation to check for associations with events
	 * @return <code>true</code> if the manifestation has any events associated with it; <code>false</code> otherwise
	 */
	public boolean containsEvents(long pk);

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 */
	public void addEvent(long pk, long eventPK);

	/**
	 * Adds an association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 */
	public void addEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event);

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 */
	public void addEvents(long pk, long[] eventPKs);

	/**
	 * Adds an association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 */
	public void addEvents(
		long pk,
		java.util.List<eu.strasbourg.service.agenda.model.Event> events);

	/**
	 * Clears all associations between the manifestation and its events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation to clear the associated events from
	 */
	public void clearEvents(long pk);

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPK the primary key of the event
	 */
	public void removeEvent(long pk, long eventPK);

	/**
	 * Removes the association between the manifestation and the event. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param event the event
	 */
	public void removeEvent(
		long pk, eu.strasbourg.service.agenda.model.Event event);

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events
	 */
	public void removeEvents(long pk, long[] eventPKs);

	/**
	 * Removes the association between the manifestation and the events. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events
	 */
	public void removeEvents(
		long pk,
		java.util.List<eu.strasbourg.service.agenda.model.Event> events);

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param eventPKs the primary keys of the events to be associated with the manifestation
	 */
	public void setEvents(long pk, long[] eventPKs);

	/**
	 * Sets the events associated with the manifestation, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the manifestation
	 * @param events the events to be associated with the manifestation
	 */
	public void setEvents(
		long pk,
		java.util.List<eu.strasbourg.service.agenda.model.Event> events);

	@Override
	public Set<String> getBadColumnNames();

}