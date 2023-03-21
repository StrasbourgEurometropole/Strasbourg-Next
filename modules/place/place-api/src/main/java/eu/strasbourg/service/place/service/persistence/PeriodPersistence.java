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

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import eu.strasbourg.service.place.exception.NoSuchPeriodException;
import eu.strasbourg.service.place.model.Period;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the period service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PeriodUtil
 * @generated
 */
@ProviderType
public interface PeriodPersistence extends BasePersistence<Period> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PeriodUtil} to access the period persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching periods
	 */
	public java.util.List<Period> findByUuid(String uuid);

	/**
	 * Returns a range of all the periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @return the range of matching periods
	 */
	public java.util.List<Period> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching periods
	 */
	public java.util.List<Period> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns an ordered range of all the periods where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching periods
	 */
	public java.util.List<Period> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching period
	 * @throws NoSuchPeriodException if a matching period could not be found
	 */
	public Period findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Returns the first period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching period, or <code>null</code> if a matching period could not be found
	 */
	public Period fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns the last period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching period
	 * @throws NoSuchPeriodException if a matching period could not be found
	 */
	public Period findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Returns the last period in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching period, or <code>null</code> if a matching period could not be found
	 */
	public Period fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns the periods before and after the current period in the ordered set where uuid = &#63;.
	 *
	 * @param periodId the primary key of the current period
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next period
	 * @throws NoSuchPeriodException if a period with the primary key could not be found
	 */
	public Period[] findByUuid_PrevAndNext(
			long periodId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Removes all the periods where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of periods where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching periods
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the periods where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the matching periods
	 */
	public java.util.List<Period> findByPlaceId(long placeId);

	/**
	 * Returns a range of all the periods where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @return the range of matching periods
	 */
	public java.util.List<Period> findByPlaceId(
		long placeId, int start, int end);

	/**
	 * Returns an ordered range of all the periods where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching periods
	 */
	public java.util.List<Period> findByPlaceId(
		long placeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns an ordered range of all the periods where placeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param placeId the place ID
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching periods
	 */
	public java.util.List<Period> findByPlaceId(
		long placeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first period in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching period
	 * @throws NoSuchPeriodException if a matching period could not be found
	 */
	public Period findByPlaceId_First(
			long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Returns the first period in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching period, or <code>null</code> if a matching period could not be found
	 */
	public Period fetchByPlaceId_First(
		long placeId,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns the last period in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching period
	 * @throws NoSuchPeriodException if a matching period could not be found
	 */
	public Period findByPlaceId_Last(
			long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Returns the last period in the ordered set where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching period, or <code>null</code> if a matching period could not be found
	 */
	public Period fetchByPlaceId_Last(
		long placeId,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns the periods before and after the current period in the ordered set where placeId = &#63;.
	 *
	 * @param periodId the primary key of the current period
	 * @param placeId the place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next period
	 * @throws NoSuchPeriodException if a period with the primary key could not be found
	 */
	public Period[] findByPlaceId_PrevAndNext(
			long periodId, long placeId,
			com.liferay.portal.kernel.util.OrderByComparator<Period>
				orderByComparator)
		throws NoSuchPeriodException;

	/**
	 * Removes all the periods where placeId = &#63; from the database.
	 *
	 * @param placeId the place ID
	 */
	public void removeByPlaceId(long placeId);

	/**
	 * Returns the number of periods where placeId = &#63;.
	 *
	 * @param placeId the place ID
	 * @return the number of matching periods
	 */
	public int countByPlaceId(long placeId);

	/**
	 * Caches the period in the entity cache if it is enabled.
	 *
	 * @param period the period
	 */
	public void cacheResult(Period period);

	/**
	 * Caches the periods in the entity cache if it is enabled.
	 *
	 * @param periods the periods
	 */
	public void cacheResult(java.util.List<Period> periods);

	/**
	 * Creates a new period with the primary key. Does not add the period to the database.
	 *
	 * @param periodId the primary key for the new period
	 * @return the new period
	 */
	public Period create(long periodId);

	/**
	 * Removes the period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param periodId the primary key of the period
	 * @return the period that was removed
	 * @throws NoSuchPeriodException if a period with the primary key could not be found
	 */
	public Period remove(long periodId) throws NoSuchPeriodException;

	public Period updateImpl(Period period);

	/**
	 * Returns the period with the primary key or throws a <code>NoSuchPeriodException</code> if it could not be found.
	 *
	 * @param periodId the primary key of the period
	 * @return the period
	 * @throws NoSuchPeriodException if a period with the primary key could not be found
	 */
	public Period findByPrimaryKey(long periodId) throws NoSuchPeriodException;

	/**
	 * Returns the period with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param periodId the primary key of the period
	 * @return the period, or <code>null</code> if a period with the primary key could not be found
	 */
	public Period fetchByPrimaryKey(long periodId);

	/**
	 * Returns all the periods.
	 *
	 * @return the periods
	 */
	public java.util.List<Period> findAll();

	/**
	 * Returns a range of all the periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @return the range of periods
	 */
	public java.util.List<Period> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of periods
	 */
	public java.util.List<Period> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator);

	/**
	 * Returns an ordered range of all the periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of periods
	 * @param end the upper bound of the range of periods (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of periods
	 */
	public java.util.List<Period> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Period>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the periods from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of periods.
	 *
	 * @return the number of periods
	 */
	public int countAll();

}