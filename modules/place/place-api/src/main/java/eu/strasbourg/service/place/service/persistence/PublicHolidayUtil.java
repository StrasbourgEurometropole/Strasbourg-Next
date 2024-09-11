/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.PublicHoliday;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the public holiday service. This utility wraps <code>eu.strasbourg.service.place.service.persistence.impl.PublicHolidayPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see PublicHolidayPersistence
 * @generated
 */
public class PublicHolidayUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PublicHoliday publicHoliday) {
		getPersistence().clearCache(publicHoliday);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PublicHoliday> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PublicHoliday> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PublicHoliday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PublicHoliday> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PublicHoliday update(PublicHoliday publicHoliday) {
		return getPersistence().update(publicHoliday);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PublicHoliday update(
		PublicHoliday publicHoliday, ServiceContext serviceContext) {

		return getPersistence().update(publicHoliday, serviceContext);
	}

	/**
	 * Returns all the public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching public holidays
	 */
	public static List<PublicHoliday> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<PublicHoliday> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<PublicHoliday> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public static PublicHoliday findByUuid_First(
			String uuid, OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public static PublicHoliday fetchByUuid_First(
		String uuid, OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public static PublicHoliday findByUuid_Last(
			String uuid, OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public static PublicHoliday fetchByUuid_Last(
		String uuid, OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where uuid = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public static PublicHoliday[] findByUuid_PrevAndNext(
			long publicHolidayId, String uuid,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByUuid_PrevAndNext(
			publicHolidayId, uuid, orderByComparator);
	}

	/**
	 * Removes all the public holidays where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of public holidays where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching public holidays
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the matching public holidays
	 */
	public static List<PublicHoliday> findByRecurrent(boolean recurrent) {
		return getPersistence().findByRecurrent(recurrent);
	}

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
	public static List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end) {

		return getPersistence().findByRecurrent(recurrent, start, end);
	}

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
	public static List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().findByRecurrent(
			recurrent, start, end, orderByComparator);
	}

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
	public static List<PublicHoliday> findByRecurrent(
		boolean recurrent, int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRecurrent(
			recurrent, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public static PublicHoliday findByRecurrent_First(
			boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByRecurrent_First(
			recurrent, orderByComparator);
	}

	/**
	 * Returns the first public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public static PublicHoliday fetchByRecurrent_First(
		boolean recurrent, OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().fetchByRecurrent_First(
			recurrent, orderByComparator);
	}

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday
	 * @throws NoSuchPublicHolidayException if a matching public holiday could not be found
	 */
	public static PublicHoliday findByRecurrent_Last(
			boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByRecurrent_Last(
			recurrent, orderByComparator);
	}

	/**
	 * Returns the last public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching public holiday, or <code>null</code> if a matching public holiday could not be found
	 */
	public static PublicHoliday fetchByRecurrent_Last(
		boolean recurrent, OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().fetchByRecurrent_Last(
			recurrent, orderByComparator);
	}

	/**
	 * Returns the public holidays before and after the current public holiday in the ordered set where recurrent = &#63;.
	 *
	 * @param publicHolidayId the primary key of the current public holiday
	 * @param recurrent the recurrent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public static PublicHoliday[] findByRecurrent_PrevAndNext(
			long publicHolidayId, boolean recurrent,
			OrderByComparator<PublicHoliday> orderByComparator)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByRecurrent_PrevAndNext(
			publicHolidayId, recurrent, orderByComparator);
	}

	/**
	 * Removes all the public holidays where recurrent = &#63; from the database.
	 *
	 * @param recurrent the recurrent
	 */
	public static void removeByRecurrent(boolean recurrent) {
		getPersistence().removeByRecurrent(recurrent);
	}

	/**
	 * Returns the number of public holidays where recurrent = &#63;.
	 *
	 * @param recurrent the recurrent
	 * @return the number of matching public holidays
	 */
	public static int countByRecurrent(boolean recurrent) {
		return getPersistence().countByRecurrent(recurrent);
	}

	/**
	 * Caches the public holiday in the entity cache if it is enabled.
	 *
	 * @param publicHoliday the public holiday
	 */
	public static void cacheResult(PublicHoliday publicHoliday) {
		getPersistence().cacheResult(publicHoliday);
	}

	/**
	 * Caches the public holidays in the entity cache if it is enabled.
	 *
	 * @param publicHolidays the public holidays
	 */
	public static void cacheResult(List<PublicHoliday> publicHolidays) {
		getPersistence().cacheResult(publicHolidays);
	}

	/**
	 * Creates a new public holiday with the primary key. Does not add the public holiday to the database.
	 *
	 * @param publicHolidayId the primary key for the new public holiday
	 * @return the new public holiday
	 */
	public static PublicHoliday create(long publicHolidayId) {
		return getPersistence().create(publicHolidayId);
	}

	/**
	 * Removes the public holiday with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday that was removed
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public static PublicHoliday remove(long publicHolidayId)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().remove(publicHolidayId);
	}

	public static PublicHoliday updateImpl(PublicHoliday publicHoliday) {
		return getPersistence().updateImpl(publicHoliday);
	}

	/**
	 * Returns the public holiday with the primary key or throws a <code>NoSuchPublicHolidayException</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday
	 * @throws NoSuchPublicHolidayException if a public holiday with the primary key could not be found
	 */
	public static PublicHoliday findByPrimaryKey(long publicHolidayId)
		throws eu.strasbourg.service.place.exception.
			NoSuchPublicHolidayException {

		return getPersistence().findByPrimaryKey(publicHolidayId);
	}

	/**
	 * Returns the public holiday with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publicHolidayId the primary key of the public holiday
	 * @return the public holiday, or <code>null</code> if a public holiday with the primary key could not be found
	 */
	public static PublicHoliday fetchByPrimaryKey(long publicHolidayId) {
		return getPersistence().fetchByPrimaryKey(publicHolidayId);
	}

	/**
	 * Returns all the public holidays.
	 *
	 * @return the public holidays
	 */
	public static List<PublicHoliday> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PublicHoliday> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PublicHoliday> findAll(
		int start, int end,
		OrderByComparator<PublicHoliday> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PublicHoliday> findAll(
		int start, int end, OrderByComparator<PublicHoliday> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the public holidays from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of public holidays.
	 *
	 * @return the number of public holidays
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PublicHolidayPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PublicHolidayPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PublicHolidayPersistence _persistence;

}