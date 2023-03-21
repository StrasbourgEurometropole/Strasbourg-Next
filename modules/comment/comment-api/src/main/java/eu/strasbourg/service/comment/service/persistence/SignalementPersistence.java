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

package eu.strasbourg.service.comment.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import eu.strasbourg.service.comment.exception.NoSuchSignalementException;
import eu.strasbourg.service.comment.model.Signalement;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the signalement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Romain Vergnais
 * @see SignalementUtil
 * @generated
 */
@ProviderType
public interface SignalementPersistence extends BasePersistence<Signalement> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SignalementUtil} to access the signalement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the signalements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching signalements
	 */
	public java.util.List<Signalement> findByUuid(String uuid);

	/**
	 * Returns a range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where uuid = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement[] findByUuid_PrevAndNext(
			long signalementId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Removes all the signalements where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of signalements where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching signalements
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSignalementException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByUUID_G(String uuid, long groupId)
		throws NoSuchSignalementException;

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the signalement where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the signalement where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the signalement that was removed
	 */
	public Signalement removeByUUID_G(String uuid, long groupId)
		throws NoSuchSignalementException;

	/**
	 * Returns the number of signalements where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching signalements
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching signalements
	 */
	public java.util.List<Signalement> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the first signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the last signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement[] findByUuid_C_PrevAndNext(
			long signalementId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Removes all the signalements where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of signalements where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching signalements
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the signalements where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching signalements
	 */
	public java.util.List<Signalement> findByGroupId(long groupId);

	/**
	 * Returns a range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	public java.util.List<Signalement> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the first signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the last signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the last signalement in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where groupId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement[] findByGroupId_PrevAndNext(
			long signalementId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Removes all the signalements where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of signalements where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching signalements
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the signalements where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the matching signalements
	 */
	public java.util.List<Signalement> findByPublikId(String publikId);

	/**
	 * Returns a range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	public java.util.List<Signalement> findByPublikId(
		String publikId, int start, int end);

	/**
	 * Returns an ordered range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements where publikId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param publikId the publik ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByPublikId(
		String publikId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByPublikId_First(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the first signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByPublikId_First(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the last signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByPublikId_Last(
			String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the last signalement in the ordered set where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByPublikId_Last(
		String publikId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where publikId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param publikId the publik ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement[] findByPublikId_PrevAndNext(
			long signalementId, String publikId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Removes all the signalements where publikId = &#63; from the database.
	 *
	 * @param publikId the publik ID
	 */
	public void removeByPublikId(String publikId);

	/**
	 * Returns the number of signalements where publikId = &#63;.
	 *
	 * @param publikId the publik ID
	 * @return the number of matching signalements
	 */
	public int countByPublikId(String publikId);

	/**
	 * Returns all the signalements where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @return the matching signalements
	 */
	public java.util.List<Signalement> findByCommentId(long commentId);

	/**
	 * Returns a range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of matching signalements
	 */
	public java.util.List<Signalement> findByCommentId(
		long commentId, int start, int end);

	/**
	 * Returns an ordered range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByCommentId(
		long commentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements where commentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param commentId the comment ID
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching signalements
	 */
	public java.util.List<Signalement> findByCommentId(
		long commentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByCommentId_First(
			long commentId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the first signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByCommentId_First(
		long commentId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the last signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement
	 * @throws NoSuchSignalementException if a matching signalement could not be found
	 */
	public Signalement findByCommentId_Last(
			long commentId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Returns the last signalement in the ordered set where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching signalement, or <code>null</code> if a matching signalement could not be found
	 */
	public Signalement fetchByCommentId_Last(
		long commentId,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns the signalements before and after the current signalement in the ordered set where commentId = &#63;.
	 *
	 * @param signalementId the primary key of the current signalement
	 * @param commentId the comment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement[] findByCommentId_PrevAndNext(
			long signalementId, long commentId,
			com.liferay.portal.kernel.util.OrderByComparator<Signalement>
				orderByComparator)
		throws NoSuchSignalementException;

	/**
	 * Removes all the signalements where commentId = &#63; from the database.
	 *
	 * @param commentId the comment ID
	 */
	public void removeByCommentId(long commentId);

	/**
	 * Returns the number of signalements where commentId = &#63;.
	 *
	 * @param commentId the comment ID
	 * @return the number of matching signalements
	 */
	public int countByCommentId(long commentId);

	/**
	 * Caches the signalement in the entity cache if it is enabled.
	 *
	 * @param signalement the signalement
	 */
	public void cacheResult(Signalement signalement);

	/**
	 * Caches the signalements in the entity cache if it is enabled.
	 *
	 * @param signalements the signalements
	 */
	public void cacheResult(java.util.List<Signalement> signalements);

	/**
	 * Creates a new signalement with the primary key. Does not add the signalement to the database.
	 *
	 * @param signalementId the primary key for the new signalement
	 * @return the new signalement
	 */
	public Signalement create(long signalementId);

	/**
	 * Removes the signalement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement that was removed
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement remove(long signalementId)
		throws NoSuchSignalementException;

	public Signalement updateImpl(Signalement signalement);

	/**
	 * Returns the signalement with the primary key or throws a <code>NoSuchSignalementException</code> if it could not be found.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement
	 * @throws NoSuchSignalementException if a signalement with the primary key could not be found
	 */
	public Signalement findByPrimaryKey(long signalementId)
		throws NoSuchSignalementException;

	/**
	 * Returns the signalement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param signalementId the primary key of the signalement
	 * @return the signalement, or <code>null</code> if a signalement with the primary key could not be found
	 */
	public Signalement fetchByPrimaryKey(long signalementId);

	/**
	 * Returns all the signalements.
	 *
	 * @return the signalements
	 */
	public java.util.List<Signalement> findAll();

	/**
	 * Returns a range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @return the range of signalements
	 */
	public java.util.List<Signalement> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of signalements
	 */
	public java.util.List<Signalement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the signalements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SignalementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signalements
	 * @param end the upper bound of the range of signalements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of signalements
	 */
	public java.util.List<Signalement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Signalement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the signalements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of signalements.
	 *
	 * @return the number of signalements
	 */
	public int countAll();

}