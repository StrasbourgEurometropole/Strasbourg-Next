/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.Historic;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the historic service. This utility wraps <code>eu.strasbourg.service.place.service.persistence.impl.HistoricPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see HistoricPersistence
 * @generated
 */
public class HistoricUtil {

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
	public static void clearCache(Historic historic) {
		getPersistence().clearCache(historic);
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
	public static Map<Serializable, Historic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Historic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Historic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Historic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Historic> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Historic update(Historic historic) {
		return getPersistence().update(historic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Historic update(
		Historic historic, ServiceContext serviceContext) {

		return getPersistence().update(historic, serviceContext);
	}

	/**
	 * Returns all the historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching historics
	 */
	public static List<Historic> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	public static List<Historic> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	public static List<Historic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Historic> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the historics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	public static List<Historic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Historic> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public static Historic findByUuid_First(
			String uuid, OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public static Historic fetchByUuid_First(
		String uuid, OrderByComparator<Historic> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public static Historic findByUuid_Last(
			String uuid, OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last historic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public static Historic fetchByUuid_Last(
		String uuid, OrderByComparator<Historic> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the historics before and after the current historic in the ordered set where uuid = &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public static Historic[] findByUuid_PrevAndNext(
			String sigId, String uuid,
			OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findByUuid_PrevAndNext(
			sigId, uuid, orderByComparator);
	}

	/**
	 * Removes all the historics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of historics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching historics
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the matching historics
	 */
	public static List<Historic> findBySuppressionDate(Date suppressionDate) {
		return getPersistence().findBySuppressionDate(suppressionDate);
	}

	/**
	 * Returns a range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of matching historics
	 */
	public static List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end) {

		return getPersistence().findBySuppressionDate(
			suppressionDate, start, end);
	}

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching historics
	 */
	public static List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		OrderByComparator<Historic> orderByComparator) {

		return getPersistence().findBySuppressionDate(
			suppressionDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the historics where suppressionDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param suppressionDate the suppression date
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching historics
	 */
	public static List<Historic> findBySuppressionDate(
		Date suppressionDate, int start, int end,
		OrderByComparator<Historic> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBySuppressionDate(
			suppressionDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public static Historic findBySuppressionDate_First(
			Date suppressionDate, OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findBySuppressionDate_First(
			suppressionDate, orderByComparator);
	}

	/**
	 * Returns the first historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public static Historic fetchBySuppressionDate_First(
		Date suppressionDate, OrderByComparator<Historic> orderByComparator) {

		return getPersistence().fetchBySuppressionDate_First(
			suppressionDate, orderByComparator);
	}

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic
	 * @throws NoSuchHistoricException if a matching historic could not be found
	 */
	public static Historic findBySuppressionDate_Last(
			Date suppressionDate, OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findBySuppressionDate_Last(
			suppressionDate, orderByComparator);
	}

	/**
	 * Returns the last historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching historic, or <code>null</code> if a matching historic could not be found
	 */
	public static Historic fetchBySuppressionDate_Last(
		Date suppressionDate, OrderByComparator<Historic> orderByComparator) {

		return getPersistence().fetchBySuppressionDate_Last(
			suppressionDate, orderByComparator);
	}

	/**
	 * Returns the historics before and after the current historic in the ordered set where suppressionDate &ge; &#63;.
	 *
	 * @param sigId the primary key of the current historic
	 * @param suppressionDate the suppression date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public static Historic[] findBySuppressionDate_PrevAndNext(
			String sigId, Date suppressionDate,
			OrderByComparator<Historic> orderByComparator)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findBySuppressionDate_PrevAndNext(
			sigId, suppressionDate, orderByComparator);
	}

	/**
	 * Removes all the historics where suppressionDate &ge; &#63; from the database.
	 *
	 * @param suppressionDate the suppression date
	 */
	public static void removeBySuppressionDate(Date suppressionDate) {
		getPersistence().removeBySuppressionDate(suppressionDate);
	}

	/**
	 * Returns the number of historics where suppressionDate &ge; &#63;.
	 *
	 * @param suppressionDate the suppression date
	 * @return the number of matching historics
	 */
	public static int countBySuppressionDate(Date suppressionDate) {
		return getPersistence().countBySuppressionDate(suppressionDate);
	}

	/**
	 * Caches the historic in the entity cache if it is enabled.
	 *
	 * @param historic the historic
	 */
	public static void cacheResult(Historic historic) {
		getPersistence().cacheResult(historic);
	}

	/**
	 * Caches the historics in the entity cache if it is enabled.
	 *
	 * @param historics the historics
	 */
	public static void cacheResult(List<Historic> historics) {
		getPersistence().cacheResult(historics);
	}

	/**
	 * Creates a new historic with the primary key. Does not add the historic to the database.
	 *
	 * @param sigId the primary key for the new historic
	 * @return the new historic
	 */
	public static Historic create(String sigId) {
		return getPersistence().create(sigId);
	}

	/**
	 * Removes the historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic that was removed
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public static Historic remove(String sigId)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().remove(sigId);
	}

	public static Historic updateImpl(Historic historic) {
		return getPersistence().updateImpl(historic);
	}

	/**
	 * Returns the historic with the primary key or throws a <code>NoSuchHistoricException</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic
	 * @throws NoSuchHistoricException if a historic with the primary key could not be found
	 */
	public static Historic findByPrimaryKey(String sigId)
		throws eu.strasbourg.service.place.exception.NoSuchHistoricException {

		return getPersistence().findByPrimaryKey(sigId);
	}

	/**
	 * Returns the historic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sigId the primary key of the historic
	 * @return the historic, or <code>null</code> if a historic with the primary key could not be found
	 */
	public static Historic fetchByPrimaryKey(String sigId) {
		return getPersistence().fetchByPrimaryKey(sigId);
	}

	/**
	 * Returns all the historics.
	 *
	 * @return the historics
	 */
	public static List<Historic> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @return the range of historics
	 */
	public static List<Historic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of historics
	 */
	public static List<Historic> findAll(
		int start, int end, OrderByComparator<Historic> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of historics
	 * @param end the upper bound of the range of historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of historics
	 */
	public static List<Historic> findAll(
		int start, int end, OrderByComparator<Historic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the historics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of historics.
	 *
	 * @return the number of historics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HistoricPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HistoricPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HistoricPersistence _persistence;

}