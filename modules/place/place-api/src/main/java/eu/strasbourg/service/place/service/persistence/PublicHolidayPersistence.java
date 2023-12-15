/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import eu.strasbourg.service.place.exception.NoSuchPublicHolidayException;
import eu.strasbourg.service.place.model.PublicHoliday;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the public holiday service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PublicHolidayUtil
 * @generated
 */
@ProviderType
public interface PublicHolidayPersistence
	extends BasePersistence<PublicHoliday> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublicHolidayUtil} to access the public holiday persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching public holidays
	 */
	public java.util.List<PublicHoliday> findByUuid(String uuid);

	/**
	 * Returns a range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the public holidays where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public PublicHoliday findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public PublicHoliday fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public PublicHoliday findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public PublicHoliday fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public PublicHoliday[] findByUuid_PrevAndNext(
			long publicHolidayId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Removes all the public holidays where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching public holidays
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the matching public holidays
	 */
	public java.util.List<PublicHoliday> findByRecurrent(boolean recurrent);

	/**
	 * Returns a range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end);

	/**
	 * Returns an ordered range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the public holidays where recurrent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param recurrent the recurrent
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching public holidays
	 */
	public java.util.List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public PublicHoliday findByRecurrent_First(
			boolean recurrent,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public PublicHoliday fetchByRecurrent_First(
		boolean recurrent,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public PublicHoliday findByRecurrent_Last(
			boolean recurrent,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public PublicHoliday fetchByRecurrent_Last(
		boolean recurrent,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public PublicHoliday[] findByRecurrent_PrevAndNext(
			long publicHolidayId, boolean recurrent,
			com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
				orderByComparator)
		throws NoSuchPublicHolidayException;

	/**
	 * Removes all the public holidays where recurrent = &#63; from the database.
	 *
	 * @param recurrent the recurrent
	 */
	public void removeByRecurrent(boolean recurrent);

	/**
	 * Returns the number of public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the number of matching public holidays
	 */
	public int countByRecurrent(boolean recurrent);

	/**
	 * Caches the public holiday in the entity cache if it is enabled.
	 *
	 * @param publicHoliday the public holiday
	 */
	public void cacheResult(PublicHoliday publicHoliday);

	/**
	 * Caches the public holidays in the entity cache if it is enabled.
	 *
	 * @param publicHolidays the public holidays
	 */
	public void cacheResult(java.util.List<PublicHoliday> publicHolidays);

	/**
	 * Creates a new public holiday with the primary key. Does not add the public holiday to the database.
	 *
	 * @param publicHolidayId the primary key for the new public holiday
	 * @return the new public holiday
	 */
	public PublicHoliday create(long publicHolidayId);

	/**
	 * Removes the public holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday that was removed
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public PublicHoliday remove(long publicHolidayId)
		throws NoSuchPublicHolidayException;

	public PublicHoliday updateImpl(PublicHoliday publicHoliday);

	/**
	 * Returns the public holiday with the primary key or throws a <code>NoSuchPublicHolidayException</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public PublicHoliday findByPrimaryKey(long publicHolidayId)
		throws NoSuchPublicHolidayException;

	/**
	 * Returns the public holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday, or <code>null</code> if a public holiday with the primary key could not be found
	 */
	public PublicHoliday fetchByPrimaryKey(long publicHolidayId);

	/**
	 * Returns all the public holidays.
	 *
	 * @return the public holidays
	 */
	public java.util.List<PublicHoliday> findAll();

	/**
	 * Returns a range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @return the range of public holidays
	 */
	public java.util.List<PublicHoliday> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of public holidays
	 */
	public java.util.List<PublicHoliday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator);

	/**
	 * Returns an ordered range of all the public holidays.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublicHolidayModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of public holidays
	 * @param end the upper bound of the range of public holidays (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of public holidays
	 */
	public java.util.List<PublicHoliday> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PublicHoliday>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the public holidays from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of public holidays.
	 *
	 * @return the number of public holidays
	 */
	public int countAll();

}