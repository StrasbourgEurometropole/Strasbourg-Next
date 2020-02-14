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

import eu.strasbourg.service.agenda.exception.NoSuchEventPeriodException;
import eu.strasbourg.service.agenda.model.EventPeriod;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the event period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BenjaminBini
 * @see EventPeriodUtil
 * @generated
 */
@ProviderType
public interface EventPeriodPersistence extends BasePersistence<EventPeriod> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventPeriodUtil} to access the event period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, EventPeriod> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching event periods
	 */
	public java.util.List<EventPeriod> findByUuid(String uuid);

	/**
	 * Returns a range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public java.util.List<EventPeriod> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the first event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the last event period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the event periods before and after the current event period in the ordered set where uuid = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public EventPeriod[] findByUuid_PrevAndNext(
			long eventPeriodId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Removes all the event periods where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of event periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching event periods
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching event periods
	 */
	public java.util.List<EventPeriod> findByEventId(long eventId);

	/**
	 * Returns a range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public java.util.List<EventPeriod> findByEventId(
		long eventId, int start, int end);

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event periods where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByEventId(
		long eventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByEventId_First(
			long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the first event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByEventId_First(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByEventId_Last(
			long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the last event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByEventId_Last(
		long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the event periods before and after the current event period in the ordered set where eventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public EventPeriod[] findByEventId_PrevAndNext(
			long eventPeriodId, long eventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Removes all the event periods where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	public void removeByEventId(long eventId);

	/**
	 * Returns the number of event periods where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching event periods
	 */
	public int countByEventId(long eventId);

	/**
	 * Returns all the event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the matching event periods
	 */
	public java.util.List<EventPeriod> findByCampaignEventId(
		long campaignEventId);

	/**
	 * Returns a range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of matching event periods
	 */
	public java.util.List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end);

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event periods where campaignEventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param campaignEventId the campaign event ID
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching event periods
	 */
	public java.util.List<EventPeriod> findByCampaignEventId(
		long campaignEventId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByCampaignEventId_First(
			long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the first event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByCampaignEventId_First(
		long campaignEventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period
	 * @throws NoSuchEventPeriodException if a matching event period could not be found
	 */
	public EventPeriod findByCampaignEventId_Last(
			long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the last event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching event period, or <code>null</code> if a matching event period could not be found
	 */
	public EventPeriod fetchByCampaignEventId_Last(
		long campaignEventId,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns the event periods before and after the current event period in the ordered set where campaignEventId = &#63;.
	 *
	 * @param eventPeriodId the primary key of the current event period
	 * @param campaignEventId the campaign event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public EventPeriod[] findByCampaignEventId_PrevAndNext(
			long eventPeriodId, long campaignEventId,
			com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
				orderByComparator)
		throws NoSuchEventPeriodException;

	/**
	 * Removes all the event periods where campaignEventId = &#63; from the database.
	 *
	 * @param campaignEventId the campaign event ID
	 */
	public void removeByCampaignEventId(long campaignEventId);

	/**
	 * Returns the number of event periods where campaignEventId = &#63;.
	 *
	 * @param campaignEventId the campaign event ID
	 * @return the number of matching event periods
	 */
	public int countByCampaignEventId(long campaignEventId);

	/**
	 * Caches the event period in the entity cache if it is enabled.
	 *
	 * @param eventPeriod the event period
	 */
	public void cacheResult(EventPeriod eventPeriod);

	/**
	 * Caches the event periods in the entity cache if it is enabled.
	 *
	 * @param eventPeriods the event periods
	 */
	public void cacheResult(java.util.List<EventPeriod> eventPeriods);

	/**
	 * Creates a new event period with the primary key. Does not add the event period to the database.
	 *
	 * @param eventPeriodId the primary key for the new event period
	 * @return the new event period
	 */
	public EventPeriod create(long eventPeriodId);

	/**
	 * Removes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period that was removed
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public EventPeriod remove(long eventPeriodId)
		throws NoSuchEventPeriodException;

	public EventPeriod updateImpl(EventPeriod eventPeriod);

	/**
	 * Returns the event period with the primary key or throws a <code>NoSuchEventPeriodException</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period
	 * @throws NoSuchEventPeriodException if a event period with the primary key could not be found
	 */
	public EventPeriod findByPrimaryKey(long eventPeriodId)
		throws NoSuchEventPeriodException;

	/**
	 * Returns the event period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period, or <code>null</code> if a event period with the primary key could not be found
	 */
	public EventPeriod fetchByPrimaryKey(long eventPeriodId);

	/**
	 * Returns all the event periods.
	 *
	 * @return the event periods
	 */
	public java.util.List<EventPeriod> findAll();

	/**
	 * Returns a range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of event periods
	 */
	public java.util.List<EventPeriod> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of event periods
	 */
	public java.util.List<EventPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator);

	/**
	 * Returns an ordered range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>EventPeriodModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of event periods
	 */
	public java.util.List<EventPeriod> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventPeriod>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the event periods from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of event periods.
	 *
	 * @return the number of event periods
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}