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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityLocalService
 * @generated
 */
public class ActivityLocalServiceWrapper
	implements ActivityLocalService, ServiceWrapper<ActivityLocalService> {

	public ActivityLocalServiceWrapper() {
		this(null);
	}

	public ActivityLocalServiceWrapper(
		ActivityLocalService activityLocalService) {

		_activityLocalService = activityLocalService;
	}

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
	@Override
	public eu.strasbourg.service.activity.model.Activity addActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return _activityLocalService.addActivity(activity);
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity createActivity(
		long activityId) {

		return _activityLocalService.createActivity(activityId);
	}

	/**
	 * Crée une activité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity createActivity(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.createActivity(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.activity.model.Activity deleteActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return _activityLocalService.deleteActivity(activity);
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
	@Override
	public eu.strasbourg.service.activity.model.Activity deleteActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.deleteActivity(activityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _activityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _activityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _activityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _activityLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _activityLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _activityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _activityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _activityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.activity.model.Activity fetchActivity(
		long activityId) {

		return _activityLocalService.fetchActivity(activityId);
	}

	/**
	 * Returns the activity matching the UUID and group.
	 *
	 * @param uuid the activity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity, or <code>null</code> if a matching activity could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity
		fetchActivityByUuidAndGroupId(String uuid, long groupId) {

		return _activityLocalService.fetchActivityByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par liste d'ids
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		findByIds(java.util.List<Long> activityIds) {

		return _activityLocalService.findByIds(activityIds);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _activityLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _activityLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _activityLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivities(int start, int end) {

		return _activityLocalService.getActivities(start, end);
	}

	/**
	 * Returns all the activities matching the UUID and company.
	 *
	 * @param uuid the UUID of the activities
	 * @param companyId the primary key of the company
	 * @return the matching activities, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivitiesByUuidAndCompanyId(String uuid, long companyId) {

		return _activityLocalService.getActivitiesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		getActivitiesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.activity.model.Activity>
					orderByComparator) {

		return _activityLocalService.getActivitiesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
	 */
	@Override
	public int getActivitiesCount() {
		return _activityLocalService.getActivitiesCount();
	}

	/**
	 * Returns the activity with the primary key.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws PortalException if a activity with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity getActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.getActivity(activityId);
	}

	/**
	 * Returns the activity matching the UUID and group.
	 *
	 * @param uuid the activity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching activity
	 * @throws PortalException if a matching activity could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity
			getActivityByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.getActivityByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _activityLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		getByGroupId(long groupId) {

		return _activityLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _activityLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _activityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.activity.model.PlaceAgenda getPlaceAgenda(
		String sigId, java.util.Locale locale) {

		return _activityLocalService.getPlaceAgenda(sigId, locale);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity removeActivity(
			long activityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.removeActivity(activityId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _activityLocalService.search(searchContext);
	}

	/**
	 * Retourne les Hits correspondant aux paramètres pour le webservice des
	 * activités
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Activity>
		searchActivities(
			long groupId, String keywords, java.util.Locale locale) {

		return _activityLocalService.searchActivities(
			groupId, keywords, locale);
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
	@Override
	public eu.strasbourg.service.activity.model.Activity updateActivity(
		eu.strasbourg.service.activity.model.Activity activity) {

		return _activityLocalService.updateActivity(activity);
	}

	/**
	 * Met à jour une activité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity updateActivity(
			eu.strasbourg.service.activity.model.Activity activity,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.updateActivity(activity, sc);
	}

	/**
	 * Met à jour le statut de l'entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Activity updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityLocalService.updateStatus(userId, entryId, status);
	}

	@Override
	public ActivityLocalService getWrappedService() {
		return _activityLocalService;
	}

	@Override
	public void setWrappedService(ActivityLocalService activityLocalService) {
		_activityLocalService = activityLocalService;
	}

	private ActivityLocalService _activityLocalService;

}