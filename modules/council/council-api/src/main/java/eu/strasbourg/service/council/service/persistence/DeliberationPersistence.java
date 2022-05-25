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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.council.exception.NoSuchDeliberationException;
import eu.strasbourg.service.council.model.Deliberation;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the deliberation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationUtil
 * @generated
 */
@ProviderType
public interface DeliberationPersistence extends BasePersistence<Deliberation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DeliberationUtil} to access the deliberation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Deliberation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the deliberations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid(String uuid);

	/**
	 * Returns a range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where uuid = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public Deliberation[] findByUuid_PrevAndNext(
			long deliberationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Removes all the deliberations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of deliberations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching deliberations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchDeliberationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByUUID_G(String uuid, long groupId)
		throws NoSuchDeliberationException;

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the deliberation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the deliberation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the deliberation that was removed
	 */
	public Deliberation removeByUUID_G(String uuid, long groupId)
		throws NoSuchDeliberationException;

	/**
	 * Returns the number of deliberations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching deliberations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the first deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the last deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public Deliberation[] findByUuid_C_PrevAndNext(
			long deliberationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Removes all the deliberations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of deliberations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching deliberations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the deliberations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the matching deliberations
	 */
	public java.util.List<Deliberation> findByCouncilSessionId(
		long councilSessionId);

	/**
	 * Returns a range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of matching deliberations
	 */
	public java.util.List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end);

	/**
	 * Returns an ordered range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the deliberations where councilSessionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param councilSessionId the council session ID
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching deliberations
	 */
	public java.util.List<Deliberation> findByCouncilSessionId(
		long councilSessionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByCouncilSessionId_First(
			long councilSessionId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the first deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByCouncilSessionId_First(
		long councilSessionId,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the last deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation
	 * @throws NoSuchDeliberationException if a matching deliberation could not be found
	 */
	public Deliberation findByCouncilSessionId_Last(
			long councilSessionId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Returns the last deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching deliberation, or <code>null</code> if a matching deliberation could not be found
	 */
	public Deliberation fetchByCouncilSessionId_Last(
		long councilSessionId,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns the deliberations before and after the current deliberation in the ordered set where councilSessionId = &#63;.
	 *
	 * @param deliberationId the primary key of the current deliberation
	 * @param councilSessionId the council session ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public Deliberation[] findByCouncilSessionId_PrevAndNext(
			long deliberationId, long councilSessionId,
			com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
				orderByComparator)
		throws NoSuchDeliberationException;

	/**
	 * Removes all the deliberations where councilSessionId = &#63; from the database.
	 *
	 * @param councilSessionId the council session ID
	 */
	public void removeByCouncilSessionId(long councilSessionId);

	/**
	 * Returns the number of deliberations where councilSessionId = &#63;.
	 *
	 * @param councilSessionId the council session ID
	 * @return the number of matching deliberations
	 */
	public int countByCouncilSessionId(long councilSessionId);

	/**
	 * Caches the deliberation in the entity cache if it is enabled.
	 *
	 * @param deliberation the deliberation
	 */
	public void cacheResult(Deliberation deliberation);

	/**
	 * Caches the deliberations in the entity cache if it is enabled.
	 *
	 * @param deliberations the deliberations
	 */
	public void cacheResult(java.util.List<Deliberation> deliberations);

	/**
	 * Creates a new deliberation with the primary key. Does not add the deliberation to the database.
	 *
	 * @param deliberationId the primary key for the new deliberation
	 * @return the new deliberation
	 */
	public Deliberation create(long deliberationId);

	/**
	 * Removes the deliberation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation that was removed
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public Deliberation remove(long deliberationId)
		throws NoSuchDeliberationException;

	public Deliberation updateImpl(Deliberation deliberation);

	/**
	 * Returns the deliberation with the primary key or throws a <code>NoSuchDeliberationException</code> if it could not be found.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation
	 * @throws NoSuchDeliberationException if a deliberation with the primary key could not be found
	 */
	public Deliberation findByPrimaryKey(long deliberationId)
		throws NoSuchDeliberationException;

	/**
	 * Returns the deliberation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param deliberationId the primary key of the deliberation
	 * @return the deliberation, or <code>null</code> if a deliberation with the primary key could not be found
	 */
	public Deliberation fetchByPrimaryKey(long deliberationId);

	/**
	 * Returns all the deliberations.
	 *
	 * @return the deliberations
	 */
	public java.util.List<Deliberation> findAll();

	/**
	 * Returns a range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @return the range of deliberations
	 */
	public java.util.List<Deliberation> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of deliberations
	 */
	public java.util.List<Deliberation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator);

	/**
	 * Returns an ordered range of all the deliberations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DeliberationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of deliberations
	 * @param end the upper bound of the range of deliberations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of deliberations
	 */
	public java.util.List<Deliberation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Deliberation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the deliberations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of deliberations.
	 *
	 * @return the number of deliberations
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}