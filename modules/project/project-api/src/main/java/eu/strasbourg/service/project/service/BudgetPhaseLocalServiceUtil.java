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
 * Provides the local service utility for BudgetPhase. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.BudgetPhaseLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see BudgetPhaseLocalService
 * @generated
 */
public class BudgetPhaseLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.BudgetPhaseLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the budget phase to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetPhaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetPhase the budget phase
	 * @return the budget phase that was added
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		addBudgetPhase(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return getService().addBudgetPhase(budgetPhase);
	}

	/**
	 * Creates a new budget phase with the primary key. Does not add the budget phase to the database.
	 *
	 * @param budgetPhaseId the primary key for the new budget phase
	 * @return the new budget phase
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		createBudgetPhase(long budgetPhaseId) {

		return getService().createBudgetPhase(budgetPhaseId);
	}

	/**
	 * Crée une phase vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			createBudgetPhase(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createBudgetPhase(sc);
	}

	/**
	 * Deletes the budget phase from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetPhaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetPhase the budget phase
	 * @return the budget phase that was removed
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		deleteBudgetPhase(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return getService().deleteBudgetPhase(budgetPhase);
	}

	/**
	 * Deletes the budget phase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetPhaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase that was removed
	 * @throws PortalException if a budget phase with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			deleteBudgetPhase(long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteBudgetPhase(budgetPhaseId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl</code>.
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

	public static eu.strasbourg.service.project.model.BudgetPhase
		fetchBudgetPhase(long budgetPhaseId) {

		return getService().fetchBudgetPhase(budgetPhaseId);
	}

	/**
	 * Returns the budget phase matching the UUID and group.
	 *
	 * @param uuid the budget phase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		fetchBudgetPhaseByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchBudgetPhaseByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase> findByKeyword(
			String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la phase active si elle existe
	 *
	 * @param groupId ID du site
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		getActivePhase(long groupId) {

		return getService().getActivePhase(groupId);
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à uen phase
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Returns the budget phase with the primary key.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase
	 * @throws PortalException if a budget phase with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			getBudgetPhase(long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetPhase(budgetPhaseId);
	}

	/**
	 * Returns the budget phase matching the UUID and group.
	 *
	 * @param uuid the budget phase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget phase
	 * @throws PortalException if a matching budget phase could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			getBudgetPhaseByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetPhaseByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the budget phases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @return the range of budget phases
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase> getBudgetPhases(
			int start, int end) {

		return getService().getBudgetPhases(start, end);
	}

	/**
	 * Returns all the budget phases matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget phases
	 * @param companyId the primary key of the company
	 * @return the matching budget phases, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase>
			getBudgetPhasesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getBudgetPhasesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of budget phases matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget phases
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of budget phases
	 * @param end the upper bound of the range of budget phases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching budget phases, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase>
			getBudgetPhasesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.project.model.BudgetPhase>
						orderByComparator) {

		return getService().getBudgetPhasesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of budget phases.
	 *
	 * @return the number of budget phases
	 */
	public static int getBudgetPhasesCount() {
		return getService().getBudgetPhasesCount();
	}

	/**
	 * Retourne toutes les phases d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase> getByGroupId(
			long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne les phases d'un groupe ayant un statut actif (champ isActive et non le
	 * statut du workFlow Liferay)
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetPhase>
			getByIsActiveAndGroupId(boolean isActive, long groupId) {

		return getService().getByIsActiveAndGroupId(isActive, groupId);
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
	 * Supprime une phase
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			removeBudgetPhase(long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeBudgetPhase(budgetPhaseId);
	}

	/**
	 * Updates the budget phase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetPhaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetPhase the budget phase
	 * @return the budget phase that was updated
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
		updateBudgetPhase(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return getService().updateBudgetPhase(budgetPhase);
	}

	/**
	 * Met à jour une phase et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase
			updateBudgetPhase(
				eu.strasbourg.service.project.model.BudgetPhase budgetPhase,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateBudgetPhase(budgetPhase, sc);
	}

	/**
	 * Met à jour le statut de la phase "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(budgetPhase, status);
	}

	/**
	 * Met à jour le statut de la phase par le framework workflow
	 */
	public static eu.strasbourg.service.project.model.BudgetPhase updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static BudgetPhaseLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BudgetPhaseLocalService, BudgetPhaseLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(BudgetPhaseLocalService.class);

		ServiceTracker<BudgetPhaseLocalService, BudgetPhaseLocalService>
			serviceTracker =
				new ServiceTracker
					<BudgetPhaseLocalService, BudgetPhaseLocalService>(
						bundle.getBundleContext(),
						BudgetPhaseLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}