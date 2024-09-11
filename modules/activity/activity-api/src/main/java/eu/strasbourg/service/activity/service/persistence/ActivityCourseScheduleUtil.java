/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityCourseSchedule;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the activity course schedule service. This utility wraps <code>eu.strasbourg.service.activity.service.persistence.impl.ActivityCourseSchedulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseSchedulePersistence
 * @generated
 */
public class ActivityCourseScheduleUtil {

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
	public static void clearCache(
		ActivityCourseSchedule activityCourseSchedule) {

		getPersistence().clearCache(activityCourseSchedule);
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
	public static Map<Serializable, ActivityCourseSchedule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ActivityCourseSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActivityCourseSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActivityCourseSchedule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ActivityCourseSchedule update(
		ActivityCourseSchedule activityCourseSchedule) {

		return getPersistence().update(activityCourseSchedule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ActivityCourseSchedule update(
		ActivityCourseSchedule activityCourseSchedule,
		ServiceContext serviceContext) {

		return getPersistence().update(activityCourseSchedule, serviceContext);
	}

	/**
	 * Returns all the activity course schedules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the activity course schedules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByUuid_First(
			String uuid,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUuid_First(
		String uuid,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByUuid_Last(
			String uuid,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUuid_Last(
		String uuid,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the activity course schedules before and after the current activity course schedule in the ordered set where uuid = &#63;.
	 *
	 * @param activityCourseScheduleId the primary key of the current activity course schedule
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule[] findByUuid_PrevAndNext(
			long activityCourseScheduleId, String uuid,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_PrevAndNext(
			activityCourseScheduleId, uuid, orderByComparator);
	}

	/**
	 * Removes all the activity course schedules where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of activity course schedules where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching activity course schedules
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the activity course schedule where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchActivityCourseScheduleException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByUUID_G(String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course schedule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUUID_G(
		String uuid, long groupId) {

		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the activity course schedule where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the activity course schedule where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the activity course schedule that was removed
	 */
	public static ActivityCourseSchedule removeByUUID_G(
			String uuid, long groupId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of activity course schedules where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching activity course schedules
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the activity course schedules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the activity course schedules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the activity course schedules before and after the current activity course schedule in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param activityCourseScheduleId the primary key of the current activity course schedule
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule[] findByUuid_C_PrevAndNext(
			long activityCourseScheduleId, String uuid, long companyId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByUuid_C_PrevAndNext(
			activityCourseScheduleId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the activity course schedules where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of activity course schedules where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching activity course schedules
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the activity course schedules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the activity course schedules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByGroupId_First(
			long groupId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByGroupId_First(
		long groupId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByGroupId_Last(
			long groupId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByGroupId_Last(
		long groupId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the activity course schedules before and after the current activity course schedule in the ordered set where groupId = &#63;.
	 *
	 * @param activityCourseScheduleId the primary key of the current activity course schedule
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule[] findByGroupId_PrevAndNext(
			long activityCourseScheduleId, long groupId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByGroupId_PrevAndNext(
			activityCourseScheduleId, groupId, orderByComparator);
	}

	/**
	 * Removes all the activity course schedules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of activity course schedules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activity course schedules
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the activity course schedules where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @return the matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByActivityCoursePlace(
		long activityCoursePlaceId) {

		return getPersistence().findByActivityCoursePlace(
			activityCoursePlaceId);
	}

	/**
	 * Returns a range of all the activity course schedules where activityCoursePlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByActivityCoursePlace(
		long activityCoursePlaceId, int start, int end) {

		return getPersistence().findByActivityCoursePlace(
			activityCoursePlaceId, start, end);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where activityCoursePlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByActivityCoursePlace(
		long activityCoursePlaceId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findByActivityCoursePlace(
			activityCoursePlaceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course schedules where activityCoursePlaceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching activity course schedules
	 */
	public static List<ActivityCourseSchedule> findByActivityCoursePlace(
		long activityCoursePlaceId, int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByActivityCoursePlace(
			activityCoursePlaceId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByActivityCoursePlace_First(
			long activityCoursePlaceId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByActivityCoursePlace_First(
			activityCoursePlaceId, orderByComparator);
	}

	/**
	 * Returns the first activity course schedule in the ordered set where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByActivityCoursePlace_First(
		long activityCoursePlaceId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByActivityCoursePlace_First(
			activityCoursePlaceId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule findByActivityCoursePlace_Last(
			long activityCoursePlaceId,
			OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByActivityCoursePlace_Last(
			activityCoursePlaceId, orderByComparator);
	}

	/**
	 * Returns the last activity course schedule in the ordered set where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule fetchByActivityCoursePlace_Last(
		long activityCoursePlaceId,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().fetchByActivityCoursePlace_Last(
			activityCoursePlaceId, orderByComparator);
	}

	/**
	 * Returns the activity course schedules before and after the current activity course schedule in the ordered set where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCourseScheduleId the primary key of the current activity course schedule
	 * @param activityCoursePlaceId the activity course place ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule[]
			findByActivityCoursePlace_PrevAndNext(
				long activityCourseScheduleId, long activityCoursePlaceId,
				OrderByComparator<ActivityCourseSchedule> orderByComparator)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByActivityCoursePlace_PrevAndNext(
			activityCourseScheduleId, activityCoursePlaceId, orderByComparator);
	}

	/**
	 * Removes all the activity course schedules where activityCoursePlaceId = &#63; from the database.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 */
	public static void removeByActivityCoursePlace(long activityCoursePlaceId) {
		getPersistence().removeByActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Returns the number of activity course schedules where activityCoursePlaceId = &#63;.
	 *
	 * @param activityCoursePlaceId the activity course place ID
	 * @return the number of matching activity course schedules
	 */
	public static int countByActivityCoursePlace(long activityCoursePlaceId) {
		return getPersistence().countByActivityCoursePlace(
			activityCoursePlaceId);
	}

	/**
	 * Caches the activity course schedule in the entity cache if it is enabled.
	 *
	 * @param activityCourseSchedule the activity course schedule
	 */
	public static void cacheResult(
		ActivityCourseSchedule activityCourseSchedule) {

		getPersistence().cacheResult(activityCourseSchedule);
	}

	/**
	 * Caches the activity course schedules in the entity cache if it is enabled.
	 *
	 * @param activityCourseSchedules the activity course schedules
	 */
	public static void cacheResult(
		List<ActivityCourseSchedule> activityCourseSchedules) {

		getPersistence().cacheResult(activityCourseSchedules);
	}

	/**
	 * Creates a new activity course schedule with the primary key. Does not add the activity course schedule to the database.
	 *
	 * @param activityCourseScheduleId the primary key for the new activity course schedule
	 * @return the new activity course schedule
	 */
	public static ActivityCourseSchedule create(long activityCourseScheduleId) {
		return getPersistence().create(activityCourseScheduleId);
	}

	/**
	 * Removes the activity course schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule that was removed
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule remove(long activityCourseScheduleId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().remove(activityCourseScheduleId);
	}

	public static ActivityCourseSchedule updateImpl(
		ActivityCourseSchedule activityCourseSchedule) {

		return getPersistence().updateImpl(activityCourseSchedule);
	}

	/**
	 * Returns the activity course schedule with the primary key or throws a <code>NoSuchActivityCourseScheduleException</code> if it could not be found.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule
	 * @throws NoSuchActivityCourseScheduleException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule findByPrimaryKey(
			long activityCourseScheduleId)
		throws eu.strasbourg.service.activity.exception.
			NoSuchActivityCourseScheduleException {

		return getPersistence().findByPrimaryKey(activityCourseScheduleId);
	}

	/**
	 * Returns the activity course schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule, or <code>null</code> if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule fetchByPrimaryKey(
		long activityCourseScheduleId) {

		return getPersistence().fetchByPrimaryKey(activityCourseScheduleId);
	}

	/**
	 * Returns all the activity course schedules.
	 *
	 * @return the activity course schedules
	 */
	public static List<ActivityCourseSchedule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of activity course schedules
	 */
	public static List<ActivityCourseSchedule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activity course schedules
	 */
	public static List<ActivityCourseSchedule> findAll(
		int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of activity course schedules
	 */
	public static List<ActivityCourseSchedule> findAll(
		int start, int end,
		OrderByComparator<ActivityCourseSchedule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the activity course schedules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of activity course schedules.
	 *
	 * @return the number of activity course schedules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActivityCourseSchedulePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(
		ActivityCourseSchedulePersistence persistence) {

		_persistence = persistence;
	}

	private static volatile ActivityCourseSchedulePersistence _persistence;

}