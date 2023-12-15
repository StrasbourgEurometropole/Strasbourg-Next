/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchSlotException;
import eu.strasbourg.service.place.model.Slot;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the slot service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see SlotUtil
 * @generated
 */
@ProviderType
public interface SlotPersistence extends BasePersistence<Slot> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SlotUtil} to access the slot persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the slots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching slots
	 */
	public java.util.List<Slot> findByUuid(String uuid);

	/**
	 * Returns a range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	public java.util.List<Slot> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns an ordered range of all the slots where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the first slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the last slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the last slot in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the slots before and after the current slot in the ordered set where uuid = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	public Slot[] findByUuid_PrevAndNext(
			long slotId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Removes all the slots where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of slots where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching slots
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the slots where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @return the matching slots
	 */
	public java.util.List<Slot> findByPeriodId(long periodId);

	/**
	 * Returns a range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	public java.util.List<Slot> findByPeriodId(
		long periodId, int start, int end);

	/**
	 * Returns an ordered range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findByPeriodId(
		long periodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns an ordered range of all the slots where periodId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param periodId the period ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findByPeriodId(
		long periodId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findByPeriodId_First(
			long periodId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the first slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchByPeriodId_First(
		long periodId,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the last slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findByPeriodId_Last(
			long periodId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the last slot in the ordered set where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchByPeriodId_Last(
		long periodId,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the slots before and after the current slot in the ordered set where periodId = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param periodId the period ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	public Slot[] findByPeriodId_PrevAndNext(
			long slotId, long periodId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Removes all the slots where periodId = &#63; from the database.
	 *
	 * @param periodId the period ID
	 */
	public void removeByPeriodId(long periodId);

	/**
	 * Returns the number of slots where periodId = &#63;.
	 *
	 * @param periodId the period ID
	 * @return the number of matching slots
	 */
	public int countByPeriodId(long periodId);

	/**
	 * Returns all the slots where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the matching slots
	 */
	public java.util.List<Slot> findBySubPlaceId(long subPlaceId);

	/**
	 * Returns a range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of matching slots
	 */
	public java.util.List<Slot> findBySubPlaceId(
		long subPlaceId, int start, int end);

	/**
	 * Returns an ordered range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findBySubPlaceId(
		long subPlaceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns an ordered range of all the slots where subPlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param subPlaceId the sub place ID
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching slots
	 */
	public java.util.List<Slot> findBySubPlaceId(
		long subPlaceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findBySubPlaceId_First(
			long subPlaceId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the first slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchBySubPlaceId_First(
		long subPlaceId,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the last slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot
	 * @throws NoSuchSlotException if a matching slot could not be found
	 */
	public Slot findBySubPlaceId_Last(
			long subPlaceId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Returns the last slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching slot, or <code>null</code> if a matching slot could not be found
	 */
	public Slot fetchBySubPlaceId_Last(
		long subPlaceId,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns the slots before and after the current slot in the ordered set where subPlaceId = &#63;.
	 *
	 * @param slotId the primary key of the current slot
	 * @param subPlaceId the sub place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	public Slot[] findBySubPlaceId_PrevAndNext(
			long slotId, long subPlaceId,
			com.liferay.portal.kernel.util.OrderByComparator<Slot>
				orderByComparator)
		throws NoSuchSlotException;

	/**
	 * Removes all the slots where subPlaceId = &#63; from the database.
	 *
	 * @param subPlaceId the sub place ID
	 */
	public void removeBySubPlaceId(long subPlaceId);

	/**
	 * Returns the number of slots where subPlaceId = &#63;.
	 *
	 * @param subPlaceId the sub place ID
	 * @return the number of matching slots
	 */
	public int countBySubPlaceId(long subPlaceId);

	/**
	 * Caches the slot in the entity cache if it is enabled.
	 *
	 * @param slot the slot
	 */
	public void cacheResult(Slot slot);

	/**
	 * Caches the slots in the entity cache if it is enabled.
	 *
	 * @param slots the slots
	 */
	public void cacheResult(java.util.List<Slot> slots);

	/**
	 * Creates a new slot with the primary key. Does not add the slot to the database.
	 *
	 * @param slotId the primary key for the new slot
	 * @return the new slot
	 */
	public Slot create(long slotId);

	/**
	 * Removes the slot with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot that was removed
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	public Slot remove(long slotId) throws NoSuchSlotException;

	public Slot updateImpl(Slot slot);

	/**
	 * Returns the slot with the primary key or throws a <code>NoSuchSlotException</code> if it could not be found.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot
	 * @throws NoSuchSlotException if a slot with the primary key could not be found
	 */
	public Slot findByPrimaryKey(long slotId) throws NoSuchSlotException;

	/**
	 * Returns the slot with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param slotId the primary key of the slot
	 * @return the slot, or <code>null</code> if a slot with the primary key could not be found
	 */
	public Slot fetchByPrimaryKey(long slotId);

	/**
	 * Returns all the slots.
	 *
	 * @return the slots
	 */
	public java.util.List<Slot> findAll();

	/**
	 * Returns a range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @return the range of slots
	 */
	public java.util.List<Slot> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of slots
	 */
	public java.util.List<Slot> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator);

	/**
	 * Returns an ordered range of all the slots.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SlotModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of slots
	 * @param end the upper bound of the range of slots (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of slots
	 */
	public java.util.List<Slot> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Slot>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the slots from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of slots.
	 *
	 * @return the number of slots
	 */
	public int countAll();

}