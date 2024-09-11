/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityCoursePlace;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the activity course place service. This utility wraps <code>eu.strasbourg.service.activity.service.persistence.impl.ActivityCoursePlacePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlacePersistence
 * @generated
 */
public class ActivityCoursePlaceUtil {

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
	public static void clearCache(ActivityCoursePlace activityCoursePlace) {
		getPersistence().clearCache(activityCoursePlace);
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
	public static Map<Serializable, ActivityCoursePlace> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActivityCoursePlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActivityCoursePlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActivityCoursePlace> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ActivityCoursePlace update(
		ActivityCoursePlace activityCoursePlace) {

		return getPersistence().update(activityCoursePlace);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ActivityCoursePlace update(
		ActivityCoursePlace activityCoursePlace,
		ServiceContext serviceContext) {

		return getPersistence().update(activityCoursePlace, serviceContext);
	}

	/**
	 * Returns all the activity course places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByUuid_First(
			String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUuid_First(
		String uuid, OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByUuid_Last(
			String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUuid_Last(
		String uuid, OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where uuid = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace[] findByUuid_PrevAndNext(
			long activityCoursePlaceId, String uuid,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_PrevAndNext(
			activityCoursePlaceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the activity course places where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of activity course places where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity course places
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityCoursePlaceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course place where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the activity course place where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity course place that was removed
	 */
	public static ActivityCoursePlace removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of activity course places where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity course places
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace[] findByUuid_C_PrevAndNext(
			long activityCoursePlaceId, String uuid, long companyId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			activityCoursePlaceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the activity course places where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of activity course places where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity course places
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the activity course places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity course places
	 */
	public static List<ActivityCoursePlace> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByGroupId_First(
			long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByGroupId_First(
		long groupId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByGroupId_Last(
			long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByGroupId_Last(
		long groupId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where groupId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace[] findByGroupId_PrevAndNext(
			long activityCoursePlaceId, long groupId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByGroupId_PrevAndNext(
			activityCoursePlaceId, groupId, orderByComparator);
	}

	/**
	 * Removes all the activity course places where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of activity course places where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity course places
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the activity course places where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @return the matching activity course places
	 */
	public static List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId) {

		return getPersistence().findByActivityCourse(activityCourseId);
	}

	/**
	 * Returns a range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end) {

		return getPersistence().findByActivityCourse(
			activityCourseId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findByActivityCourse(
			activityCourseId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places where activityCourseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param activityCourseId the activity course ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findByActivityCourse(
		long activityCourseId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActivityCourse(
			activityCourseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByActivityCourse_First(
			long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByActivityCourse_First(
			activityCourseId, orderByComparator);
	}

	/**
	 * Returns the first activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByActivityCourse_First(
		long activityCourseId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByActivityCourse_First(
			activityCourseId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findByActivityCourse_Last(
			long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByActivityCourse_Last(
			activityCourseId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchByActivityCourse_Last(
		long activityCourseId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchByActivityCourse_Last(
			activityCourseId, orderByComparator);
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where activityCourseId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param activityCourseId the activity course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace[] findByActivityCourse_PrevAndNext(
			long activityCoursePlaceId, long activityCourseId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByActivityCourse_PrevAndNext(
			activityCoursePlaceId, activityCourseId, orderByComparator);
	}

	/**
	 * Removes all the activity course places where activityCourseId = &#63; from the database.
	 *
	 * @param activityCourseId the activity course ID
	 */
	public static void removeByActivityCourse(long activityCourseId) {
		getPersistence().removeByActivityCourse(activityCourseId);
	}

	/**
	 * Returns the number of activity course places where activityCourseId = &#63;.
	 *
	 * @param activityCourseId the activity course ID
	 * @return the number of matching activity course places
	 */
	public static int countByActivityCourse(long activityCourseId) {
		return getPersistence().countByActivityCourse(activityCourseId);
	}

	/**
	 * Returns all the activity course places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the matching activity course places
	 */
	public static List<ActivityCoursePlace> findBySigId(String placeSIGId) {
		return getPersistence().findBySigId(placeSIGId);
	}

	/**
	 * Returns a range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end) {

		return getPersistence().findBySigId(placeSIGId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findBySigId(
			placeSIGId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places where placeSIGId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param placeSIGId the place sig ID
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course places
	 */
	public static List<ActivityCoursePlace> findBySigId(
		String placeSIGId, int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySigId(
			placeSIGId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findBySigId_First(
			String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findBySigId_First(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the first activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchBySigId_First(
		String placeSIGId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchBySigId_First(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place
	 * @throws NoSuchActivityCoursePlaceException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace findBySigId_Last(
			String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findBySigId_Last(placeSIGId, orderByComparator);
	}

	/**
	 * Returns the last activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchBySigId_Last(
		String placeSIGId,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().fetchBySigId_Last(
			placeSIGId, orderByComparator);
	}

	/**
	 * Returns the activity course places before and after the current activity course place in the ordered set where placeSIGId = &#63;.
	 *
	 * @param activityCoursePlaceId the primary key of the current activity course place
	 * @param placeSIGId the place sig ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace[] findBySigId_PrevAndNext(
			long activityCoursePlaceId, String placeSIGId,
			OrderByComparator<ActivityCoursePlace> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findBySigId_PrevAndNext(
			activityCoursePlaceId, placeSIGId, orderByComparator);
	}

	/**
	 * Removes all the activity course places where placeSIGId = &#63; from the database.
	 *
	 * @param placeSIGId the place sig ID
	 */
	public static void removeBySigId(String placeSIGId) {
		getPersistence().removeBySigId(placeSIGId);
	}

	/**
	 * Returns the number of activity course places where placeSIGId = &#63;.
	 *
	 * @param placeSIGId the place sig ID
	 * @return the number of matching activity course places
	 */
	public static int countBySigId(String placeSIGId) {
		return getPersistence().countBySigId(placeSIGId);
	}

	/**
	 * Caches the activity course place in the entity cache if it is enabled.
	 *
	 * @param activityCoursePlace the activity course place
	 */
	public static void cacheResult(ActivityCoursePlace activityCoursePlace) {
		getPersistence().cacheResult(activityCoursePlace);
	}

	/**
	 * Caches the activity course places in the entity cache if it is enabled.
	 *
	 * @param activityCoursePlaces the activity course places
	 */
	public static void cacheResult(
		List<ActivityCoursePlace> activityCoursePlaces) {

		getPersistence().cacheResult(activityCoursePlaces);
	}

	/**
	 * Creates a new activity course place with the primary key. Does not add the activity course place to the database.
	 *
	 * @param activityCoursePlaceId the primary key for the new activity course place
	 * @return the new activity course place
	 */
	public static ActivityCoursePlace create(long activityCoursePlaceId) {
		return getPersistence().create(activityCoursePlaceId);
	}

	/**
	 * Removes the activity course place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place that was removed
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace remove(long activityCoursePlaceId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().remove(activityCoursePlaceId);
	}

	public static ActivityCoursePlace updateImpl(
		ActivityCoursePlace activityCoursePlace) {

		return getPersistence().updateImpl(activityCoursePlace);
	}

	/**
	 * Returns the activity course place with the primary key or throws a <code>NoSuchActivityCoursePlaceException</code> if it could not be found.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place
	 * @throws NoSuchActivityCoursePlaceException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace findByPrimaryKey(
			long activityCoursePlaceId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCoursePlaceException {

		return getPersistence().findByPrimaryKey(activityCoursePlaceId);
	}

	/**
	 * Returns the activity course place with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place, or <code>null</code> if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace fetchByPrimaryKey(
		long activityCoursePlaceId) {

		return getPersistence().fetchByPrimaryKey(activityCoursePlaceId);
	}

	/**
	 * Returns all the activity course places.
	 *
	 * @return the activity course places
	 */
	public static List<ActivityCoursePlace> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of activity course places
	 */
	public static List<ActivityCoursePlace> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity course places
	 */
	public static List<ActivityCoursePlace> findAll(
		int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity course places
	 */
	public static List<ActivityCoursePlace> findAll(
		int start, int end,
		OrderByComparator<ActivityCoursePlace> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the activity course places from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of activity course places.
	 *
	 * @return the number of activity course places
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityCoursePlacePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ActivityCoursePlacePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ActivityCoursePlacePersistence _persistence;

}