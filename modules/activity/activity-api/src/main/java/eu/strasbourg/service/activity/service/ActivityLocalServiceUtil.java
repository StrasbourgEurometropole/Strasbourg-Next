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

package eu.strasbourg.service.activity.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Activity. This utility wraps
 * <code>eu.strasbourg.service.activity.service.impl.ActivityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityLocalService
 * @generated
 */
public class ActivityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the activity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was added
	 */
	public static eu.strasbourg.service.activity.model.Activity addActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return getService().addActivity(activity);
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	public static eu.strasbourg.service.activity.model.Activity createActivity(
		long activityId) {

		return getService().createActivity(activityId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.activity.model.Activity createActivity(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createActivity(sc);
	}

	/**
	 * Deletes the activity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was removed
	 */
	public static eu.strasbourg.service.activity.model.Activity deleteActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return getService().deleteActivity(activity);
	}

	/**
	 * Deletes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws PortalException if a activity with the primary key could not be found
	 */
	public static eu.strasbourg.service.activity.model.Activity deleteActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteActivity(activityId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.activity.model.Activity fetchActivity(
		long activityId) {

		return getService().fetchActivity(activityId);
	}

	/**
	 * Returns the activity matching the UUID and group.
	 *
	 * @param uuid the activity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity, or <code>null</code> if a matching activity could not be found
	 */
	public static eu.strasbourg.service.activity.model.Activity
		fetchActivityByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchActivityByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par liste d'ids
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		findByIds(java.util.List<Long> activityIds) {

		return getService().findByIds(activityIds);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of activities
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivities(int start, int end) {

		return getService().getActivities(start, end);
	}

	/**
	 * Returns all the activities matching the UUID and company.
	 *
	 * @param uuid the UUID of the activities
	 * @param companyId the primary key of the company
	 * @return the matching activities, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivitiesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getActivitiesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of activities matching the UUID and company.
	 *
	 * @param uuid the UUID of the activities
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching activities, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivitiesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.activity.model.Activity>
					orderByComparator) {

		return getService().getActivitiesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	public static int getActivitiesCount() {
		return getService().getActivitiesCount();
	}

	/**
	 * Returns the activity with the primary key.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws PortalException if a activity with the primary key could not be found
	 */
	public static eu.strasbourg.service.activity.model.Activity getActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActivity(activityId);
	}

	/**
	 * Returns the activity matching the UUID and group.
	 *
	 * @param uuid the activity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity
	 * @throws PortalException if a matching activity could not be found
	 */
	public static eu.strasbourg.service.activity.model.Activity
			getActivityByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getActivityByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		getByGroupId(long groupId) {

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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne l'affichage de l'agenda des cours pour un lieu
	 * Transformation de :
	 * ActivityCourse - ActivityCoursePlace - ActivityCourseSchedule
	 * 					   ^                        ^
	 * 			               |                        |
	 * 			  			 Place                   Period
	 *
	 * En :
	 * Period -> Course -> Schedule
	 */
	public static eu.strasbourg.service.activity.model.PlaceAgenda
		getPlaceAgenda(String sigId, java.util.Locale locale) {

		return getService().getPlaceAgenda(sigId, locale);
	}

	/**
	 * Supprime une entité
	 */
	public static eu.strasbourg.service.activity.model.Activity removeActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeActivity(activityId);
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
	 * Retourne les Hits correspondant aux paramètres pour le webservice des
	 * activités
	 */
	public static java.util.List<eu.strasbourg.service.activity.model.Activity>
		searchActivities(
			long groupId, String keywords, java.util.Locale locale) {

		return getService().searchActivities(groupId, keywords, locale);
	}

	/**
	 * Updates the activity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ActivityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param activity the activity
	 * @return the activity that was updated
	 */
	public static eu.strasbourg.service.activity.model.Activity updateActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return getService().updateActivity(activity);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.activity.model.Activity updateActivity(
			eu.strasbourg.service.activity.model.Activity activity,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateActivity(activity, sc);
	}

	/**
	 * Met à jour le statut de l'entité
	 */
	public static eu.strasbourg.service.activity.model.Activity updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(userId, entryId, status);
	}

	public static ActivityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActivityLocalService, ActivityLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActivityLocalService.class);

		ServiceTracker<ActivityLocalService, ActivityLocalService>
			serviceTracker =
				new ServiceTracker<ActivityLocalService, ActivityLocalService>(
					bundle.getBundleContext(), ActivityLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}