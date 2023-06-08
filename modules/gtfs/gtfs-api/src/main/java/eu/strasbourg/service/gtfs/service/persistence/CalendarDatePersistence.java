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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.gtfs.exception.NoSuchCalendarDateException;
import eu.strasbourg.service.gtfs.model.CalendarDate;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the calendar date service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarDateUtil
 * @generated
 */
@ProviderType
public interface CalendarDatePersistence extends BasePersistence<CalendarDate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CalendarDateUtil} to access the calendar date persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, CalendarDate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	 * Returns all the calendar dates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching calendar dates
	 */
	public java.util.List<CalendarDate> findByUuid(String uuid);

	/**
	 * Returns a range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calendar dates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the first calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the last calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the last calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	public CalendarDate[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Removes all the calendar dates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of calendar dates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching calendar dates
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the calendar dates where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the matching calendar dates
	 */
	public java.util.List<CalendarDate> findByServiceId(String service_id);

	/**
	 * Returns a range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByServiceId(
		String service_id, int start, int end);

	/**
	 * Returns an ordered range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByServiceId(
		String service_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calendar dates where service_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param service_id the service_id
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByServiceId(
		String service_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByServiceId_First(
			String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the first calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByServiceId_First(
		String service_id,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the last calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByServiceId_Last(
			String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the last calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByServiceId_Last(
		String service_id,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where service_id = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param service_id the service_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	public CalendarDate[] findByServiceId_PrevAndNext(
			long id, String service_id,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Removes all the calendar dates where service_id = &#63; from the database.
	 *
	 * @param service_id the service_id
	 */
	public void removeByServiceId(String service_id);

	/**
	 * Returns the number of calendar dates where service_id = &#63;.
	 *
	 * @param service_id the service_id
	 * @return the number of matching calendar dates
	 */
	public int countByServiceId(String service_id);

	/**
	 * Returns all the calendar dates where date = &#63;.
	 *
	 * @param date the date
	 * @return the matching calendar dates
	 */
	public java.util.List<CalendarDate> findByDate(Date date);

	/**
	 * Returns a range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByDate(
		Date date, int start, int end);

	/**
	 * Returns an ordered range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByDate(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calendar dates where date = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param date the date
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching calendar dates
	 */
	public java.util.List<CalendarDate> findByDate(
		Date date, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByDate_First(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the first calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByDate_First(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the last calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date
	 * @throws NoSuchCalendarDateException if a matching calendar date could not be found
	 */
	public CalendarDate findByDate_Last(
			Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the last calendar date in the ordered set where date = &#63;.
	 *
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar date, or <code>null</code> if a matching calendar date could not be found
	 */
	public CalendarDate fetchByDate_Last(
		Date date,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns the calendar dates before and after the current calendar date in the ordered set where date = &#63;.
	 *
	 * @param id the primary key of the current calendar date
	 * @param date the date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	public CalendarDate[] findByDate_PrevAndNext(
			long id, Date date,
			com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
				orderByComparator)
		throws NoSuchCalendarDateException;

	/**
	 * Removes all the calendar dates where date = &#63; from the database.
	 *
	 * @param date the date
	 */
	public void removeByDate(Date date);

	/**
	 * Returns the number of calendar dates where date = &#63;.
	 *
	 * @param date the date
	 * @return the number of matching calendar dates
	 */
	public int countByDate(Date date);

	/**
	 * Caches the calendar date in the entity cache if it is enabled.
	 *
	 * @param calendarDate the calendar date
	 */
	public void cacheResult(CalendarDate calendarDate);

	/**
	 * Caches the calendar dates in the entity cache if it is enabled.
	 *
	 * @param calendarDates the calendar dates
	 */
	public void cacheResult(java.util.List<CalendarDate> calendarDates);

	/**
	 * Creates a new calendar date with the primary key. Does not add the calendar date to the database.
	 *
	 * @param id the primary key for the new calendar date
	 * @return the new calendar date
	 */
	public CalendarDate create(long id);

	/**
	 * Removes the calendar date with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date that was removed
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	public CalendarDate remove(long id) throws NoSuchCalendarDateException;

	public CalendarDate updateImpl(CalendarDate calendarDate);

	/**
	 * Returns the calendar date with the primary key or throws a <code>NoSuchCalendarDateException</code> if it could not be found.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date
	 * @throws NoSuchCalendarDateException if a calendar date with the primary key could not be found
	 */
	public CalendarDate findByPrimaryKey(long id)
		throws NoSuchCalendarDateException;

	/**
	 * Returns the calendar date with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the calendar date
	 * @return the calendar date, or <code>null</code> if a calendar date with the primary key could not be found
	 */
	public CalendarDate fetchByPrimaryKey(long id);

	/**
	 * Returns all the calendar dates.
	 *
	 * @return the calendar dates
	 */
	public java.util.List<CalendarDate> findAll();

	/**
	 * Returns a range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @return the range of calendar dates
	 */
	public java.util.List<CalendarDate> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of calendar dates
	 */
	public java.util.List<CalendarDate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the calendar dates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CalendarDateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendar dates
	 * @param end the upper bound of the range of calendar dates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of calendar dates
	 */
	public java.util.List<CalendarDate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CalendarDate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the calendar dates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of calendar dates.
	 *
	 * @return the number of calendar dates
	 */
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

}