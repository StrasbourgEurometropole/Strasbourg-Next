/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.csmap.model.Thematic;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the thematic service. This utility wraps <code>eu.strasbourg.service.csmap.service.persistence.impl.ThematicPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ThematicPersistence
 * @generated
 */
public class ThematicUtil {

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
	public static void clearCache(Thematic thematic) {
		getPersistence().clearCache(thematic);
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
	public static Map<Serializable, Thematic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Thematic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Thematic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Thematic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Thematic> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Thematic update(Thematic thematic) {
		return getPersistence().update(thematic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Thematic update(
		Thematic thematic, ServiceContext serviceContext) {

		return getPersistence().update(thematic, serviceContext);
	}

	/**
	 * Returns all the thematics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching thematics
	 */
	public static List<Thematic> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the thematics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @return the range of matching thematics
	 */
	public static List<Thematic> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the thematics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching thematics
	 */
	public static List<Thematic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Thematic> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the thematics where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching thematics
	 */
	public static List<Thematic> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Thematic> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first thematic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thematic
	 * @throws NoSuchThematicException if a matching thematic could not be found
	 */
	public static Thematic findByUuid_First(
			String uuid, OrderByComparator<Thematic> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.NoSuchThematicException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first thematic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching thematic, or <code>null</code> if a matching thematic could not be found
	 */
	public static Thematic fetchByUuid_First(
		String uuid, OrderByComparator<Thematic> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last thematic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thematic
	 * @throws NoSuchThematicException if a matching thematic could not be found
	 */
	public static Thematic findByUuid_Last(
			String uuid, OrderByComparator<Thematic> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.NoSuchThematicException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last thematic in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching thematic, or <code>null</code> if a matching thematic could not be found
	 */
	public static Thematic fetchByUuid_Last(
		String uuid, OrderByComparator<Thematic> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the thematics before and after the current thematic in the ordered set where uuid = &#63;.
	 *
	 * @param thematicId the primary key of the current thematic
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next thematic
	 * @throws NoSuchThematicException if a thematic with the primary key could not be found
	 */
	public static Thematic[] findByUuid_PrevAndNext(
			long thematicId, String uuid,
			OrderByComparator<Thematic> orderByComparator)
		throws eu.strasbourg.service.csmap.exception.NoSuchThematicException {

		return getPersistence().findByUuid_PrevAndNext(
			thematicId, uuid, orderByComparator);
	}

	/**
	 * Removes all the thematics where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of thematics where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching thematics
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the thematic in the entity cache if it is enabled.
	 *
	 * @param thematic the thematic
	 */
	public static void cacheResult(Thematic thematic) {
		getPersistence().cacheResult(thematic);
	}

	/**
	 * Caches the thematics in the entity cache if it is enabled.
	 *
	 * @param thematics the thematics
	 */
	public static void cacheResult(List<Thematic> thematics) {
		getPersistence().cacheResult(thematics);
	}

	/**
	 * Creates a new thematic with the primary key. Does not add the thematic to the database.
	 *
	 * @param thematicId the primary key for the new thematic
	 * @return the new thematic
	 */
	public static Thematic create(long thematicId) {
		return getPersistence().create(thematicId);
	}

	/**
	 * Removes the thematic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param thematicId the primary key of the thematic
	 * @return the thematic that was removed
	 * @throws NoSuchThematicException if a thematic with the primary key could not be found
	 */
	public static Thematic remove(long thematicId)
		throws eu.strasbourg.service.csmap.exception.NoSuchThematicException {

		return getPersistence().remove(thematicId);
	}

	public static Thematic updateImpl(Thematic thematic) {
		return getPersistence().updateImpl(thematic);
	}

	/**
	 * Returns the thematic with the primary key or throws a <code>NoSuchThematicException</code> if it could not be found.
	 *
	 * @param thematicId the primary key of the thematic
	 * @return the thematic
	 * @throws NoSuchThematicException if a thematic with the primary key could not be found
	 */
	public static Thematic findByPrimaryKey(long thematicId)
		throws eu.strasbourg.service.csmap.exception.NoSuchThematicException {

		return getPersistence().findByPrimaryKey(thematicId);
	}

	/**
	 * Returns the thematic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param thematicId the primary key of the thematic
	 * @return the thematic, or <code>null</code> if a thematic with the primary key could not be found
	 */
	public static Thematic fetchByPrimaryKey(long thematicId) {
		return getPersistence().fetchByPrimaryKey(thematicId);
	}

	/**
	 * Returns all the thematics.
	 *
	 * @return the thematics
	 */
	public static List<Thematic> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the thematics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @return the range of thematics
	 */
	public static List<Thematic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the thematics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thematics
	 */
	public static List<Thematic> findAll(
		int start, int end, OrderByComparator<Thematic> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the thematics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThematicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thematics
	 * @param end the upper bound of the range of thematics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of thematics
	 */
	public static List<Thematic> findAll(
		int start, int end, OrderByComparator<Thematic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the thematics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of thematics.
	 *
	 * @return the number of thematics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ThematicPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ThematicPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ThematicPersistence _persistence;

}