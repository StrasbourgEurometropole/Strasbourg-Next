/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.Project;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Project. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.ProjectLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see ProjectLocalService
 * @generated
 */
public class ProjectLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ProjectLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the project to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was added
	 */
	public static Project addProject(Project project) {
		return getService().addProject(project);
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
	 * Creates a new project with the primary key. Does not add the project to the database.
	 *
	 * @param projectId the primary key for the new project
	 * @return the new project
	 */
	public static Project createProject(long projectId) {
		return getService().createProject(projectId);
	}

	/**
	 * Crée un projet vide avec une PK, non ajouté à la base de donnée
	 */
	public static Project createProject(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createProject(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the project with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectId the primary key of the project
	 * @return the project that was removed
	 * @throws PortalException if a project with the primary key could not be found
	 */
	public static Project deleteProject(long projectId) throws PortalException {
		return getService().deleteProject(projectId);
	}

	/**
	 * Deletes the project from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was removed
	 */
	public static Project deleteProject(Project project) {
		return getService().deleteProject(project);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
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

	public static Project fetchProject(long projectId) {
		return getService().fetchProject(projectId);
	}

	/**
	 * Returns the project matching the UUID and group.
	 *
	 * @param uuid the project's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project, or <code>null</code> if a matching project could not be found
	 */
	public static Project fetchProjectByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchProjectByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par ID de catégorie
	 */
	public static List<Project> findByCategoryIds(long[] categoryIds) {
		return getService().findByCategoryIds(categoryIds);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Project> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static List<Project> findProjectFollowedByProjectId(
		String publicId) {

		return getService().findProjectFollowedByProjectId(publicId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à un projet
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les projets d'un groupe
	 */
	public static List<Project> getByGroupId(long groupId) {
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
	 * Returns the project with the primary key.
	 *
	 * @param projectId the primary key of the project
	 * @return the project
	 * @throws PortalException if a project with the primary key could not be found
	 */
	public static Project getProject(long projectId) throws PortalException {
		return getService().getProject(projectId);
	}

	/**
	 * Returns the project matching the UUID and group.
	 *
	 * @param uuid the project's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project
	 * @throws PortalException if a matching project could not be found
	 */
	public static Project getProjectByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getProjectByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the projects.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ProjectModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @return the range of projects
	 */
	public static List<Project> getProjects(int start, int end) {
		return getService().getProjects(start, end);
	}

	/**
	 * Returns all the projects matching the UUID and company.
	 *
	 * @param uuid the UUID of the projects
	 * @param companyId the primary key of the company
	 * @return the matching projects, or an empty list if no matches were found
	 */
	public static List<Project> getProjectsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getProjectsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of projects matching the UUID and company.
	 *
	 * @param uuid the UUID of the projects
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of projects
	 * @param end the upper bound of the range of projects (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching projects, or an empty list if no matches were found
	 */
	public static List<Project> getProjectsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Project> orderByComparator) {

		return getService().getProjectsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of projects.
	 *
	 * @return the number of projects
	 */
	public static int getProjectsCount() {
		return getService().getProjectsCount();
	}

	/**
	 * Retourne tous les projets publiés d'un groupe
	 */
	public static List<Project> getPublishedByGroupId(long groupId) {
		return getService().getPublishedByGroupId(groupId);
	}

	/**
	 * Supprime un projet
	 */
	public static Project removeProject(long projectId) throws PortalException {
		return getService().removeProject(projectId);
	}

	/**
	 * Updates the project in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param project the project
	 * @return the project that was updated
	 */
	public static Project updateProject(Project project) {
		return getService().updateProject(project);
	}

	/**
	 * Met à jour un projet et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Project updateProject(
			Project project,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateProject(project, sc);
	}

	/**
	 * Met à jour le statut du projet par le framework workflow
	 */
	public static Project updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut du projet "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Project project, int status)
		throws PortalException {

		getService().updateStatus(project, status);
	}

	public static ProjectLocalService getService() {
		return _service;
	}

	public static void setService(ProjectLocalService service) {
		_service = service;
	}

	private static volatile ProjectLocalService _service;

}