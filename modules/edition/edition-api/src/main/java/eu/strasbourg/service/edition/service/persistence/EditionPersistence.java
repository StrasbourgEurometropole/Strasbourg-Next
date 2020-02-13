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

package eu.strasbourg.service.edition.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.edition.exception.NoSuchEditionException;
import eu.strasbourg.service.edition.model.Edition;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the edition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see EditionUtil
 * @generated
 */
@ProviderType
public interface EditionPersistence extends BasePersistence<Edition> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EditionUtil} to access the edition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Edition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the editions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByUuid(String uuid);

	/**
	 * Returns a range of all the editions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the editions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where uuid = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByUuid_PrevAndNext(
			long editionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of editions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching editions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the edition where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchEditionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByUUID_G(String uuid, long groupId)
		throws NoSuchEditionException;

	/**
	 * Returns the edition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the edition where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUUID_G(
		String uuid, long groupId, boolean retrieveFromCache);

	/**
	 * Removes the edition where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the edition that was removed
	 */
	public Edition removeByUUID_G(String uuid, long groupId)
		throws NoSuchEditionException;

	/**
	 * Returns the number of editions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching editions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the editions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the editions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the editions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByUuid_C_PrevAndNext(
			long editionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of editions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching editions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the editions where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByTitle(String title);

	/**
	 * Returns a range of all the editions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByTitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the editions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where title = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByTitle_PrevAndNext(
			long editionId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of editions where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching editions
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the editions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByGroupId(long groupId);

	/**
	 * Returns a range of all the editions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the editions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where groupId = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByGroupId_PrevAndNext(
			long editionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of editions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching editions
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the editions where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByGroupIdAndTitle(
		long groupId, String title);

	/**
	 * Returns a range of all the editions where groupId = &#63; and title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByGroupIdAndTitle(
		long groupId, String title, int start, int end);

	/**
	 * Returns an ordered range of all the editions where groupId = &#63; and title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByGroupIdAndTitle(
		long groupId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where groupId = &#63; and title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByGroupIdAndTitle(
		long groupId, String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByGroupIdAndTitle_First(
			long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByGroupIdAndTitle_First(
		long groupId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByGroupIdAndTitle_Last(
			long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByGroupIdAndTitle_Last(
		long groupId, String title,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where groupId = &#63; and title = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param groupId the group ID
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByGroupIdAndTitle_PrevAndNext(
			long editionId, long groupId, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where groupId = &#63; and title = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 */
	public void removeByGroupIdAndTitle(long groupId, String title);

	/**
	 * Returns the number of editions where groupId = &#63; and title = &#63;.
	 *
	 * @param groupId the group ID
	 * @param title the title
	 * @return the number of matching editions
	 */
	public int countByGroupIdAndTitle(long groupId, String title);

	/**
	 * Returns all the editions where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the matching editions
	 */
	public java.util.List<Edition> findByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns a range of all the editions where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of matching editions
	 */
	public java.util.List<Edition> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end);

	/**
	 * Returns an ordered range of all the editions where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching editions
	 */
	public java.util.List<Edition> findByPublicationDateAndStatus(
		Date publicationDate, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first edition in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByPublicationDateAndStatus_First(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the first edition in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByPublicationDateAndStatus_First(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the last edition in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition
	 * @throws NoSuchEditionException if a matching edition could not be found
	 */
	public Edition findByPublicationDateAndStatus_Last(
			Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Returns the last edition in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public Edition fetchByPublicationDateAndStatus_Last(
		Date publicationDate, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns the editions before and after the current edition in the ordered set where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param editionId the primary key of the current edition
	 * @param publicationDate the publication date
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition[] findByPublicationDateAndStatus_PrevAndNext(
			long editionId, Date publicationDate, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Edition>
				orderByComparator)
		throws NoSuchEditionException;

	/**
	 * Removes all the editions where publicationDate &lt; &#63; and status = &#63; from the database.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 */
	public void removeByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Returns the number of editions where publicationDate &lt; &#63; and status = &#63;.
	 *
	 * @param publicationDate the publication date
	 * @param status the status
	 * @return the number of matching editions
	 */
	public int countByPublicationDateAndStatus(
		Date publicationDate, int status);

	/**
	 * Caches the edition in the entity cache if it is enabled.
	 *
	 * @param edition the edition
	 */
	public void cacheResult(Edition edition);

	/**
	 * Caches the editions in the entity cache if it is enabled.
	 *
	 * @param editions the editions
	 */
	public void cacheResult(java.util.List<Edition> editions);

	/**
	 * Creates a new edition with the primary key. Does not add the edition to the database.
	 *
	 * @param editionId the primary key for the new edition
	 * @return the new edition
	 */
	public Edition create(long editionId);

	/**
	 * Removes the edition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition that was removed
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition remove(long editionId) throws NoSuchEditionException;

	public Edition updateImpl(Edition edition);

	/**
	 * Returns the edition with the primary key or throws a <code>NoSuchEditionException</code> if it could not be found.
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition
	 * @throws NoSuchEditionException if a edition with the primary key could not be found
	 */
	public Edition findByPrimaryKey(long editionId)
		throws NoSuchEditionException;

	/**
	 * Returns the edition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition, or <code>null</code> if a edition with the primary key could not be found
	 */
	public Edition fetchByPrimaryKey(long editionId);

	/**
	 * Returns all the editions.
	 *
	 * @return the editions
	 */
	public java.util.List<Edition> findAll();

	/**
	 * Returns a range of all the editions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of editions
	 */
	public java.util.List<Edition> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the editions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of editions
	 */
	public java.util.List<Edition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator);

	/**
	 * Returns an ordered range of all the editions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of editions
	 */
	public java.util.List<Edition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Edition>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the editions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of editions.
	 *
	 * @return the number of editions
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of edition galleries associated with the edition.
	 *
	 * @param pk the primary key of the edition
	 * @return long[] of the primaryKeys of edition galleries associated with the edition
	 */
	public long[] getEditionGalleryPrimaryKeys(long pk);

	/**
	 * Returns all the edition galleries associated with the edition.
	 *
	 * @param pk the primary key of the edition
	 * @return the edition galleries associated with the edition
	 */
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleries(long pk);

	/**
	 * Returns a range of all the edition galleries associated with the edition.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the edition
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of edition galleries associated with the edition
	 */
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleries(long pk, int start, int end);

	/**
	 * Returns an ordered range of all the edition galleries associated with the edition.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EditionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the edition
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of edition galleries associated with the edition
	 */
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleries(
			long pk, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.EditionGallery>
					orderByComparator);

	/**
	 * Returns the number of edition galleries associated with the edition.
	 *
	 * @param pk the primary key of the edition
	 * @return the number of edition galleries associated with the edition
	 */
	public int getEditionGalleriesSize(long pk);

	/**
	 * Returns <code>true</code> if the edition gallery is associated with the edition.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPK the primary key of the edition gallery
	 * @return <code>true</code> if the edition gallery is associated with the edition; <code>false</code> otherwise
	 */
	public boolean containsEditionGallery(long pk, long editionGalleryPK);

	/**
	 * Returns <code>true</code> if the edition has any edition galleries associated with it.
	 *
	 * @param pk the primary key of the edition to check for associations with edition galleries
	 * @return <code>true</code> if the edition has any edition galleries associated with it; <code>false</code> otherwise
	 */
	public boolean containsEditionGalleries(long pk);

	/**
	 * Adds an association between the edition and the edition gallery. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPK the primary key of the edition gallery
	 */
	public void addEditionGallery(long pk, long editionGalleryPK);

	/**
	 * Adds an association between the edition and the edition gallery. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGallery the edition gallery
	 */
	public void addEditionGallery(
		long pk,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery);

	/**
	 * Adds an association between the edition and the edition galleries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPKs the primary keys of the edition galleries
	 */
	public void addEditionGalleries(long pk, long[] editionGalleryPKs);

	/**
	 * Adds an association between the edition and the edition galleries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleries the edition galleries
	 */
	public void addEditionGalleries(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries);

	/**
	 * Clears all associations between the edition and its edition galleries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition to clear the associated edition galleries from
	 */
	public void clearEditionGalleries(long pk);

	/**
	 * Removes the association between the edition and the edition gallery. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPK the primary key of the edition gallery
	 */
	public void removeEditionGallery(long pk, long editionGalleryPK);

	/**
	 * Removes the association between the edition and the edition gallery. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGallery the edition gallery
	 */
	public void removeEditionGallery(
		long pk,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery);

	/**
	 * Removes the association between the edition and the edition galleries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPKs the primary keys of the edition galleries
	 */
	public void removeEditionGalleries(long pk, long[] editionGalleryPKs);

	/**
	 * Removes the association between the edition and the edition galleries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleries the edition galleries
	 */
	public void removeEditionGalleries(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries);

	/**
	 * Sets the edition galleries associated with the edition, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleryPKs the primary keys of the edition galleries to be associated with the edition
	 */
	public void setEditionGalleries(long pk, long[] editionGalleryPKs);

	/**
	 * Sets the edition galleries associated with the edition, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the edition
	 * @param editionGalleries the edition galleries to be associated with the edition
	 */
	public void setEditionGalleries(
		long pk,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries);

	@Override
	public Set<String> getBadColumnNames();

}