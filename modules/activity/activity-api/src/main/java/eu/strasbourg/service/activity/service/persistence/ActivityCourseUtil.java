/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityCourse;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the activity course service. This utility wraps <code>eu.strasbourg.service.activity.service.persistence.impl.ActivityCoursePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePersistence
 * @generated
 */
public class ActivityCourseUtil {

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
	public static void clearCache(ActivityCourse activityCourse) {
		getPersistence().clearCache(activityCourse);
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
	public static Map<Serializable, ActivityCourse> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActivityCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActivityCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActivityCourse> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ActivityCourse update(ActivityCourse activityCourse) {
		return getPersistence().update(activityCourse);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ActivityCourse update(
		ActivityCourse activityCourse, ServiceContext serviceContext) {

		return getPersistence().update(activityCourse, serviceContext);
	}

	/**
	 * Returns all the activity courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity courses
	 */
	public static List<ActivityCourse> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByUuid_First(
			String uuid, OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUuid_First(
		String uuid, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByUuid_Last(
			String uuid, OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUuid_Last(
		String uuid, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where uuid = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse[] findByUuid_PrevAndNext(
			long activityCourseId, String uuid,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_PrevAndNext(
			activityCourseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the activity courses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of activity courses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity courses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityCourseException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the activity course where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity course that was removed
	 */
	public static ActivityCourse removeByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of activity courses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity courses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity courses
	 */
	public static List<ActivityCourse> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse[] findByUuid_C_PrevAndNext(
			long activityCourseId, String uuid, long companyId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByUuid_C_PrevAndNext(
			activityCourseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the activity courses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of activity courses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity courses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the activity courses where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the matching activity courses
	 */
	public static List<ActivityCourse> findByActivity(long activityId) {
		return getPersistence().findByActivity(activityId);
	}

	/**
	 * Returns a range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	public static List<ActivityCourse> findByActivity(
		long activityId, int start, int end) {

		return getPersistence().findByActivity(activityId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findByActivity(
			activityId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity courses where activityId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param activityId the activity ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByActivity(
		long activityId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActivity(
			activityId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByActivity_First(
			long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByActivity_First(
			activityId, orderByComparator);
	}

	/**
	 * Returns the first activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByActivity_First(
		long activityId, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByActivity_First(
			activityId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByActivity_Last(
			long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByActivity_Last(
			activityId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByActivity_Last(
		long activityId, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByActivity_Last(
			activityId, orderByComparator);
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where activityId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param activityId the activity ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse[] findByActivity_PrevAndNext(
			long activityCourseId, long activityId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByActivity_PrevAndNext(
			activityCourseId, activityId, orderByComparator);
	}

	/**
	 * Removes all the activity courses where activityId = &#63; from the database.
	 *
	 * @param activityId the activity ID
	 */
	public static void removeByActivity(long activityId) {
		getPersistence().removeByActivity(activityId);
	}

	/**
	 * Returns the number of activity courses where activityId = &#63;.
	 *
	 * @param activityId the activity ID
	 * @return the number of matching activity courses
	 */
	public static int countByActivity(long activityId) {
		return getPersistence().countByActivity(activityId);
	}

	/**
	 * Returns all the activity courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity courses
	 */
	public static List<ActivityCourse> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of matching activity courses
	 */
	public static List<ActivityCourse> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity courses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity courses
	 */
	public static List<ActivityCourse> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByGroupId_First(
			long groupId, OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByGroupId_First(
		long groupId, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course
	 * @throws NoSuchActivityCourseException if a matching activity course could not be found
	 */
	public static ActivityCourse findByGroupId_Last(
			long groupId, OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course, or <code>null</code> if a matching activity course could not be found
	 */
	public static ActivityCourse fetchByGroupId_Last(
		long groupId, OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the activity courses before and after the current activity course in the ordered set where groupId = &#63;.
	 *
	 * @param activityCourseId the primary key of the current activity course
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse[] findByGroupId_PrevAndNext(
			long activityCourseId, long groupId,
			OrderByComparator<ActivityCourse> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByGroupId_PrevAndNext(
			activityCourseId, groupId, orderByComparator);
	}

	/**
	 * Removes all the activity courses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of activity courses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity courses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the activity course in the entity cache if it is enabled.
	 *
	 * @param activityCourse the activity course
	 */
	public static void cacheResult(ActivityCourse activityCourse) {
		getPersistence().cacheResult(activityCourse);
	}

	/**
	 * Caches the activity courses in the entity cache if it is enabled.
	 *
	 * @param activityCourses the activity courses
	 */
	public static void cacheResult(List<ActivityCourse> activityCourses) {
		getPersistence().cacheResult(activityCourses);
	}

	/**
	 * Creates a new activity course with the primary key. Does not add the activity course to the database.
	 *
	 * @param activityCourseId the primary key for the new activity course
	 * @return the new activity course
	 */
	public static ActivityCourse create(long activityCourseId) {
		return getPersistence().create(activityCourseId);
	}

	/**
	 * Removes the activity course with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course that was removed
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse remove(long activityCourseId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().remove(activityCourseId);
	}

	public static ActivityCourse updateImpl(ActivityCourse activityCourse) {
		return getPersistence().updateImpl(activityCourse);
	}

	/**
	 * Returns the activity course with the primary key or throws a <code>NoSuchActivityCourseException</code> if it could not be found.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course
	 * @throws NoSuchActivityCourseException if a activity course with the primary key could not be found
	 */
	public static ActivityCourse findByPrimaryKey(long activityCourseId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseException {

		return getPersistence().findByPrimaryKey(activityCourseId);
	}

	/**
	 * Returns the activity course with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityCourseId the primary key of the activity course
	 * @return the activity course, or <code>null</code> if a activity course with the primary key could not be found
	 */
	public static ActivityCourse fetchByPrimaryKey(long activityCourseId) {
		return getPersistence().fetchByPrimaryKey(activityCourseId);
	}

	/**
	 * Returns all the activity courses.
	 *
	 * @return the activity courses
	 */
	public static List<ActivityCourse> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @return the range of activity courses
	 */
	public static List<ActivityCourse> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity courses
	 */
	public static List<ActivityCourse> findAll(
		int start, int end,
		OrderByComparator<ActivityCourse> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity courses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity courses
	 * @param end the upper bound of the range of activity courses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity courses
	 */
	public static List<ActivityCourse> findAll(
		int start, int end, OrderByComparator<ActivityCourse> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the activity courses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of activity courses.
	 *
	 * @return the number of activity courses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityCoursePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ActivityCoursePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ActivityCoursePersistence _persistence;

}