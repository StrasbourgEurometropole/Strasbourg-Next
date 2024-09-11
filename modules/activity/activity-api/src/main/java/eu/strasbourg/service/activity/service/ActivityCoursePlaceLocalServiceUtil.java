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

import eu.strasbourg.service.activity.model.ActivityCoursePlace;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ActivityCoursePlace. This utility wraps
 * <code>eu.strasbourg.service.activity.service.impl.ActivityCoursePlaceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlaceLocalService
 * @generated
 */
public class ActivityCoursePlaceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityCoursePlaceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the activity course place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCoursePlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCoursePlace the activity course place
	 * @return the activity course place that was added
	 */
	public static ActivityCoursePlace addActivityCoursePlace(
		ActivityCoursePlace activityCoursePlace) {

		return getService().addActivityCoursePlace(activityCoursePlace);
	}

	/**
	 * Creates a new activity course place with the primary key. Does not add the activity course place to the database.
	 *
	 * @param activityCoursePlaceId the primary key for the new activity course place
	 * @return the new activity course place
	 */
	public static ActivityCoursePlace createActivityCoursePlace(
		long activityCoursePlaceId) {

		return getService().createActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	public static ActivityCoursePlace createActivityCoursePlace(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createActivityCoursePlace(sc);
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
	 * Deletes the activity course place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCoursePlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCoursePlace the activity course place
	 * @return the activity course place that was removed
	 */
	public static ActivityCoursePlace deleteActivityCoursePlace(
		ActivityCoursePlace activityCoursePlace) {

		return getService().deleteActivityCoursePlace(activityCoursePlace);
	}

	/**
	 * Deletes the activity course place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCoursePlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place that was removed
	 * @throws PortalException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace deleteActivityCoursePlace(
			long activityCoursePlaceId)
		throws PortalException {

		return getService().deleteActivityCoursePlace(activityCoursePlaceId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl</code>.
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

	public static ActivityCoursePlace fetchActivityCoursePlace(
		long activityCoursePlaceId) {

		return getService().fetchActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Returns the activity course place matching the UUID and group.
	 *
	 * @param uuid the activity course place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course place, or <code>null</code> if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace fetchActivityCoursePlaceByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchActivityCoursePlaceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par liste d'ids
	 */
	public static List<ActivityCoursePlace> findByIds(
		List<Long> activityCoursePlaceIds) {

		return getService().findByIds(activityCoursePlaceIds);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<ActivityCoursePlace> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Récupère la liste des lieux sans horaires
	 */
	public static List<ActivityCoursePlace> findWithNoSchedule(long groupId) {
		return getService().findWithNoSchedule(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the activity course place with the primary key.
	 *
	 * @param activityCoursePlaceId the primary key of the activity course place
	 * @return the activity course place
	 * @throws PortalException if a activity course place with the primary key could not be found
	 */
	public static ActivityCoursePlace getActivityCoursePlace(
			long activityCoursePlaceId)
		throws PortalException {

		return getService().getActivityCoursePlace(activityCoursePlaceId);
	}

	/**
	 * Returns the activity course place matching the UUID and group.
	 *
	 * @param uuid the activity course place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity course place
	 * @throws PortalException if a matching activity course place could not be found
	 */
	public static ActivityCoursePlace getActivityCoursePlaceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getActivityCoursePlaceByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the activity course places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @return the range of activity course places
	 */
	public static List<ActivityCoursePlace> getActivityCoursePlaces(
		int start, int end) {

		return getService().getActivityCoursePlaces(start, end);
	}

	/**
	 * Returns all the activity course places matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course places
	 * @param companyId the primary key of the company
	 * @return the matching activity course places, or an empty list if no matches were found
	 */
	public static List<ActivityCoursePlace>
		getActivityCoursePlacesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getActivityCoursePlacesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of activity course places matching the UUID and company.
	 *
	 * @param uuid the UUID of the activity course places
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activity course places
	 * @param end the upper bound of the range of activity course places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activity course places, or an empty list if no matches were found
	 */
	public static List<ActivityCoursePlace>
		getActivityCoursePlacesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ActivityCoursePlace> orderByComparator) {

		return getService().getActivityCoursePlacesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activity course places.
	 *
	 * @return the number of activity course places
	 */
	public static int getActivityCoursePlacesCount() {
		return getService().getActivityCoursePlacesCount();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les lieux d'un cours
	 */
	public static List<ActivityCoursePlace> getByActivityCourse(
		long activityCourseId) {

		return getService().getByActivityCourse(activityCourseId);
	}

	/**
	 * Retourne tous les lieux de cours d'un groupe
	 */
	public static List<ActivityCoursePlace> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne toutes les lieux de cours d'un lieu
	 */
	public static List<ActivityCoursePlace> getBySigId(String sigId) {
		return getService().getBySigId(sigId);
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
	public static ActivityCoursePlace removeActivityCoursePlace(
			long activityCoursePlaceId)
		throws PortalException {

		return getService().removeActivityCoursePlace(activityCoursePlaceId);
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
	 * Updates the activity course place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityCoursePlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityCoursePlace the activity course place
	 * @return the activity course place that was updated
	 */
	public static ActivityCoursePlace updateActivityCoursePlace(
		ActivityCoursePlace activityCoursePlace) {

		return getService().updateActivityCoursePlace(activityCoursePlace);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	public static ActivityCoursePlace updateActivityCoursePlace(
			ActivityCoursePlace activityCoursePlace,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateActivityCoursePlace(activityCoursePlace, sc);
	}

	public static ActivityCoursePlaceLocalService getService() {
		return _service;
	}

	public static void setService(ActivityCoursePlaceLocalService service) {
		_service = service;
	}

	private static volatile ActivityCoursePlaceLocalService _service;

}