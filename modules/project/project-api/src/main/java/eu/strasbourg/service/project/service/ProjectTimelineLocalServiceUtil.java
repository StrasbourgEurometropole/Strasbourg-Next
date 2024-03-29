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

package eu.strasbourg.service.project.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ProjectTimeline. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.ProjectTimelineLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see ProjectTimelineLocalService
 * @generated
 */
public class ProjectTimelineLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ProjectTimelineLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the project timeline to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTimeline the project timeline
	 * @return the project timeline that was added
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
		addProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return getService().addProjectTimeline(projectTimeline);
	}

	/**
	 * Crée une une entrée de timeline vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
			createProjectTimeline()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createProjectTimeline();
	}

	/**
	 * Creates a new project timeline with the primary key. Does not add the project timeline to the database.
	 *
	 * @param projectTimelineId the primary key for the new project timeline
	 * @return the new project timeline
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
		createProjectTimeline(long projectTimelineId) {

		return getService().createProjectTimeline(projectTimelineId);
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

	/**
	 * Deletes the project timeline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline that was removed
	 * @throws PortalException if a project timeline with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
			deleteProjectTimeline(long projectTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProjectTimeline(projectTimelineId);
	}

	/**
	 * Deletes the project timeline from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTimeline the project timeline
	 * @return the project timeline that was removed
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
		deleteProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return getService().deleteProjectTimeline(projectTimeline);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectTimelineModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectTimelineModelImpl</code>.
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

	public static eu.strasbourg.service.project.model.ProjectTimeline
		fetchProjectTimeline(long projectTimelineId) {

		return getService().fetchProjectTimeline(projectTimelineId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne les timeLine d'un budget participatif
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.ProjectTimeline>
			getByBudgetParticipatifId(long budgetParticipatifId) {

		return getService().getByBudgetParticipatifId(budgetParticipatifId);
	}

	/**
	 * Retourne les périodes d'un événement
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.ProjectTimeline> getByProjectId(
			long projectIdId) {

		return getService().getByProjectId(projectIdId);
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
	 * Returns the project timeline with the primary key.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline
	 * @throws PortalException if a project timeline with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
			getProjectTimeline(long projectTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjectTimeline(projectTimelineId);
	}

	/**
	 * Returns a range of all the project timelines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectTimelineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project timelines
	 * @param end the upper bound of the range of project timelines (not inclusive)
	 * @return the range of project timelines
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.ProjectTimeline>
			getProjectTimelines(int start, int end) {

		return getService().getProjectTimelines(start, end);
	}

	/**
	 * Returns the number of project timelines.
	 *
	 * @return the number of project timelines
	 */
	public static int getProjectTimelinesCount() {
		return getService().getProjectTimelinesCount();
	}

	/**
	 * Updates the project timeline in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectTimelineLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectTimeline the project timeline
	 * @return the project timeline that was updated
	 */
	public static eu.strasbourg.service.project.model.ProjectTimeline
		updateProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return getService().updateProjectTimeline(projectTimeline);
	}

	public static ProjectTimelineLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProjectTimelineLocalService, ProjectTimelineLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProjectTimelineLocalService.class);

		ServiceTracker<ProjectTimelineLocalService, ProjectTimelineLocalService>
			serviceTracker =
				new ServiceTracker
					<ProjectTimelineLocalService, ProjectTimelineLocalService>(
						bundle.getBundleContext(),
						ProjectTimelineLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}