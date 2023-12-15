/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.activity.model.ActivityCourseSchedule;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ActivityCourseSchedule. This utility wraps
 * <code>eu.strasbourg.service.activity.service.impl.ActivityCourseScheduleLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleLocalService
 * @generated
 */
public class ActivityCourseScheduleLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityCourseScheduleLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the activity course schedule to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was added
	 */
	public static ActivityCourseSchedule addActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule) {

		return getService().addActivityCourseSchedule(activityCourseSchedule);
	}

	/**
	 * Creates a new activity course schedule with the primary key. Does not add the activity course schedule to the database.
	 *
	 * @param activityCourseScheduleId the primary key for the new activity course schedule
	 * @return the new activity course schedule
	 */
	public static ActivityCourseSchedule createActivityCourseSchedule(
		long activityCourseScheduleId) {

		return getService().createActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	public static ActivityCourseSchedule createActivityCourseSchedule(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createActivityCourseSchedule(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the activity course schedule from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was removed
	 */
	public static ActivityCourseSchedule deleteActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule) {

		return getService().deleteActivityCourseSchedule(
			activityCourseSchedule);
	}

	/**
	 * Deletes the activity course schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule that was removed
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule deleteActivityCourseSchedule(
			long activityCourseScheduleId)
		throws PortalException {

		return getService().deleteActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ActivityCourseSchedule fetchActivityCourseSchedule(
		long activityCourseScheduleId) {

		return getService().fetchActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule, or <code>null</code> if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule
		fetchActivityCourseScheduleByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchActivityCourseScheduleByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Retourne la liste des horaires pour une liste de jours donnés sur une
	 * plage horaire donnée
	 */
	public static List<ActivityCourseSchedule> findByDaysAndTimes(
		long groupId, boolean[] days, String startTime, String endTime) {

		return getService().findByDaysAndTimes(
			groupId, days, startTime, endTime);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<ActivityCourseSchedule> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the activity course schedule with the primary key.
	 *
	 * @param activityCourseScheduleId the primary key of the activity course schedule
	 * @return the activity course schedule
	 * @throws PortalException if a activity course schedule with the primary key could not be found
	 */
	public static ActivityCourseSchedule getActivityCourseSchedule(
			long activityCourseScheduleId)
		throws PortalException {

		return getService().getActivityCourseSchedule(activityCourseScheduleId);
	}

	/**
	 * Returns the activity course schedule matching the UUID and group.
	 *
	 * @param uuid the activity course schedule's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course schedule
	 * @throws PortalException if a matching activity course schedule could not be found
	 */
	public static ActivityCourseSchedule
			getActivityCourseScheduleByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getActivityCourseScheduleByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the activity course schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @return the range of activity course schedules
	 */
	public static List<ActivityCourseSchedule> getActivityCourseSchedules(
		int start, int end) {

		return getService().getActivityCourseSchedules(start, end);
	}

	/**
	 * Returns all the activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @return the matching activity course schedules, or an empty list if no matches were found
	 */
	public static List<ActivityCourseSchedule>
		getActivityCourseSchedulesByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().getActivityCourseSchedulesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of activity course schedules matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course schedules
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity course schedules
	 * @param end the upper bound of the range of activity course schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity course schedules, or an empty list if no matches were found
	 */
	public static List<ActivityCourseSchedule>
		getActivityCourseSchedulesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ActivityCourseSchedule> orderByComparator) {

		return getService().getActivityCourseSchedulesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activity course schedules.
	 *
	 * @return the number of activity course schedules
	 */
	public static int getActivityCourseSchedulesCount() {
		return getService().getActivityCourseSchedulesCount();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les horaires d'un cours dans un lieu
	 */
	public static List<ActivityCourseSchedule> getByActivityCoursePlace(
		long activityCoursePlaceId) {

		return getService().getByActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	public static List<ActivityCourseSchedule> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	public static ActivityCourseSchedule removeActivityCourseSchedule(
			long activityCourseScheduleId)
		throws PortalException {

		return getService().removeActivityCourseSchedule(
			activityCourseScheduleId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	/**
	 * Updates the activity course schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCourseScheduleLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCourseSchedule the activity course schedule
	 * @return the activity course schedule that was updated
	 */
	public static ActivityCourseSchedule updateActivityCourseSchedule(
		ActivityCourseSchedule activityCourseSchedule) {

		return getService().updateActivityCourseSchedule(
			activityCourseSchedule);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	public static ActivityCourseSchedule updateActivityCourseSchedule(
			ActivityCourseSchedule activityCourseSchedule,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateActivityCourseSchedule(
			activityCourseSchedule, sc);
	}

	public static ActivityCourseScheduleLocalService getService() {
		return _service;
	}

	public static void setService(ActivityCourseScheduleLocalService service) {
		_service = service;
	}

	private static volatile ActivityCourseScheduleLocalService _service;

}