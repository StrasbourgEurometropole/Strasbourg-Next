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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BudgetPhaseLocalService}.
 *
 * @author Cedric Henry
 * @see BudgetPhaseLocalService
 * @generated
 */
public class BudgetPhaseLocalServiceWrapper
	implements BudgetPhaseLocalService,
			   ServiceWrapper<BudgetPhaseLocalService> {

	public BudgetPhaseLocalServiceWrapper() {
		this(null);
	}

	public BudgetPhaseLocalServiceWrapper(
		BudgetPhaseLocalService budgetPhaseLocalService) {

		_budgetPhaseLocalService = budgetPhaseLocalService;
	}

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
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase addBudgetPhase(
		eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return _budgetPhaseLocalService.addBudgetPhase(budgetPhase);
	}

	/**
	 * Creates a new budget phase with the primary key. Does not add the budget phase to the database.
	 *
	 * @param budgetPhaseId the primary key for the new budget phase
	 * @return the new budget phase
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase createBudgetPhase(
		long budgetPhaseId) {

		return _budgetPhaseLocalService.createBudgetPhase(budgetPhaseId);
	}

	/**
	 * Crée une phase vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase createBudgetPhase(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.createBudgetPhase(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase deleteBudgetPhase(
		eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return _budgetPhaseLocalService.deleteBudgetPhase(budgetPhase);
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
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase deleteBudgetPhase(
			long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.deleteBudgetPhase(budgetPhaseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _budgetPhaseLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _budgetPhaseLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _budgetPhaseLocalService.dynamicQuery();
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

		return _budgetPhaseLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _budgetPhaseLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _budgetPhaseLocalService.dynamicQuery(
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

		return _budgetPhaseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _budgetPhaseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.BudgetPhase fetchBudgetPhase(
		long budgetPhaseId) {

		return _budgetPhaseLocalService.fetchBudgetPhase(budgetPhaseId);
	}

	/**
	 * Returns the budget phase matching the UUID and group.
	 *
	 * @param uuid the budget phase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase
		fetchBudgetPhaseByUuidAndGroupId(String uuid, long groupId) {

		return _budgetPhaseLocalService.fetchBudgetPhaseByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _budgetPhaseLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _budgetPhaseLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _budgetPhaseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la phase active si elle existe
	 *
	 * @param groupId ID du site
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase getActivePhase(
		long groupId) {

		return _budgetPhaseLocalService.getActivePhase(groupId);
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à uen phase
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _budgetPhaseLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Returns the budget phase with the primary key.
	 *
	 * @param budgetPhaseId the primary key of the budget phase
	 * @return the budget phase
	 * @throws PortalException if a budget phase with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase getBudgetPhase(
			long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.getBudgetPhase(budgetPhaseId);
	}

	/**
	 * Returns the budget phase matching the UUID and group.
	 *
	 * @param uuid the budget phase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget phase
	 * @throws PortalException if a matching budget phase could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase
			getBudgetPhaseByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.getBudgetPhaseByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		getBudgetPhases(int start, int end) {

		return _budgetPhaseLocalService.getBudgetPhases(start, end);
	}

	/**
	 * Returns all the budget phases matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget phases
	 * @param companyId the primary key of the company
	 * @return the matching budget phases, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		getBudgetPhasesByUuidAndCompanyId(String uuid, long companyId) {

		return _budgetPhaseLocalService.getBudgetPhasesByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		getBudgetPhasesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.project.model.BudgetPhase>
					orderByComparator) {

		return _budgetPhaseLocalService.getBudgetPhasesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of budget phases.
	 *
	 * @return the number of budget phases
	 */
	@Override
	public int getBudgetPhasesCount() {
		return _budgetPhaseLocalService.getBudgetPhasesCount();
	}

	/**
	 * Retourne toutes les phases d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		getByGroupId(long groupId) {

		return _budgetPhaseLocalService.getByGroupId(groupId);
	}

	/**
	 * Retourne les phases d'un groupe ayant un statut actif (champ isActive et non le
	 * statut du workFlow Liferay)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.BudgetPhase>
		getByIsActiveAndGroupId(boolean isActive, long groupId) {

		return _budgetPhaseLocalService.getByIsActiveAndGroupId(
			isActive, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _budgetPhaseLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _budgetPhaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _budgetPhaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une phase
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase removeBudgetPhase(
			long budgetPhaseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.removeBudgetPhase(budgetPhaseId);
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
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase updateBudgetPhase(
		eu.strasbourg.service.project.model.BudgetPhase budgetPhase) {

		return _budgetPhaseLocalService.updateBudgetPhase(budgetPhase);
	}

	/**
	 * Met à jour une phase et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase updateBudgetPhase(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.updateBudgetPhase(budgetPhase, sc);
	}

	/**
	 * Met à jour le statut de la phase "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.project.model.BudgetPhase budgetPhase,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_budgetPhaseLocalService.updateStatus(budgetPhase, status);
	}

	/**
	 * Met à jour le statut de la phase par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetPhase updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetPhaseLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BudgetPhaseLocalService getWrappedService() {
		return _budgetPhaseLocalService;
	}

	@Override
	public void setWrappedService(
		BudgetPhaseLocalService budgetPhaseLocalService) {

		_budgetPhaseLocalService = budgetPhaseLocalService;
	}

	private BudgetPhaseLocalService _budgetPhaseLocalService;

}