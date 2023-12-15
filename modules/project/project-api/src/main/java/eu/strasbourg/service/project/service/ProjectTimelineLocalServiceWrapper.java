/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ProjectTimelineLocalService}.
 *
 * @author Cedric Henry
 * @see ProjectTimelineLocalService
 * @generated
 */
public class ProjectTimelineLocalServiceWrapper
	implements ProjectTimelineLocalService,
			   ServiceWrapper<ProjectTimelineLocalService> {

	public ProjectTimelineLocalServiceWrapper() {
		this(null);
	}

	public ProjectTimelineLocalServiceWrapper(
		ProjectTimelineLocalService projectTimelineLocalService) {

		_projectTimelineLocalService = projectTimelineLocalService;
	}

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
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
		addProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return _projectTimelineLocalService.addProjectTimeline(projectTimeline);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Crée une une entrée de timeline vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
			createProjectTimeline()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.createProjectTimeline();
	}

	/**
	 * Creates a new project timeline with the primary key. Does not add the project timeline to the database.
	 *
	 * @param projectTimelineId the primary key for the new project timeline
	 * @return the new project timeline
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
		createProjectTimeline(long projectTimelineId) {

		return _projectTimelineLocalService.createProjectTimeline(
			projectTimelineId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
			deleteProjectTimeline(long projectTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.deleteProjectTimeline(
			projectTimelineId);
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
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
		deleteProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return _projectTimelineLocalService.deleteProjectTimeline(
			projectTimeline);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _projectTimelineLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _projectTimelineLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _projectTimelineLocalService.dynamicQuery();
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

		return _projectTimelineLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _projectTimelineLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _projectTimelineLocalService.dynamicQuery(
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

		return _projectTimelineLocalService.dynamicQueryCount(dynamicQuery);
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

		return _projectTimelineLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
		fetchProjectTimeline(long projectTimelineId) {

		return _projectTimelineLocalService.fetchProjectTimeline(
			projectTimelineId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _projectTimelineLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les timeLine d'un budget participatif
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectTimeline>
		getByBudgetParticipatifId(long budgetParticipatifId) {

		return _projectTimelineLocalService.getByBudgetParticipatifId(
			budgetParticipatifId);
	}

	/**
	 * Retourne les périodes d'un événement
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectTimeline>
		getByProjectId(long projectIdId) {

		return _projectTimelineLocalService.getByProjectId(projectIdId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _projectTimelineLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectTimelineLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the project timeline with the primary key.
	 *
	 * @param projectTimelineId the primary key of the project timeline
	 * @return the project timeline
	 * @throws PortalException if a project timeline with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
			getProjectTimeline(long projectTimelineId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _projectTimelineLocalService.getProjectTimeline(
			projectTimelineId);
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
	@Override
	public java.util.List<eu.strasbourg.service.project.model.ProjectTimeline>
		getProjectTimelines(int start, int end) {

		return _projectTimelineLocalService.getProjectTimelines(start, end);
	}

	/**
	 * Returns the number of project timelines.
	 *
	 * @return the number of project timelines
	 */
	@Override
	public int getProjectTimelinesCount() {
		return _projectTimelineLocalService.getProjectTimelinesCount();
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
	@Override
	public eu.strasbourg.service.project.model.ProjectTimeline
		updateProjectTimeline(
			eu.strasbourg.service.project.model.ProjectTimeline
				projectTimeline) {

		return _projectTimelineLocalService.updateProjectTimeline(
			projectTimeline);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _projectTimelineLocalService.getBasePersistence();
	}

	@Override
	public ProjectTimelineLocalService getWrappedService() {
		return _projectTimelineLocalService;
	}

	@Override
	public void setWrappedService(
		ProjectTimelineLocalService projectTimelineLocalService) {

		_projectTimelineLocalService = projectTimelineLocalService;
	}

	private ProjectTimelineLocalService _projectTimelineLocalService;

}