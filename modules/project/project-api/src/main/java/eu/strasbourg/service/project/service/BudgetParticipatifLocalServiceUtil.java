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

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for BudgetParticipatif. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.BudgetParticipatifLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see BudgetParticipatifLocalService
 * @generated
 */
@ProviderType
public class BudgetParticipatifLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.BudgetParticipatifLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the budget participatif to the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was added
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
		addBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return getService().addBudgetParticipatif(budgetParticipatif);
	}

	/**
	 * Retourne le nombre de budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	public static int countBudgetSupportedByPublikUserInPhase(
		String publikUserId, long budgetPhaseId) {

		return getService().countBudgetSupportedByPublikUserInPhase(
			publikUserId, budgetPhaseId);
	}

	/**
	 * Creates a new budget participatif with the primary key. Does not add the budget participatif to the database.
	 *
	 * @param budgetParticipatifId the primary key for the new budget participatif
	 * @return the new budget participatif
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
		createBudgetParticipatif(long budgetParticipatifId) {

		return getService().createBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Crée une participation vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			createBudgetParticipatif(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createBudgetParticipatif(sc);
	}

	/**
	 * Deletes the budget participatif from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was removed
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
		deleteBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return getService().deleteBudgetParticipatif(budgetParticipatif);
	}

	/**
	 * Deletes the budget participatif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif that was removed
	 * @throws PortalException if a budget participatif with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			deleteBudgetParticipatif(long budgetParticipatifId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteBudgetParticipatif(budgetParticipatifId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static eu.strasbourg.service.project.model.BudgetParticipatif
		fetchBudgetParticipatif(long budgetParticipatifId) {

		return getService().fetchBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
		fetchBudgetParticipatifByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchBudgetParticipatifByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			findActiveBPByGroupId(long groupId) {

		return getService().findActiveBPByGroupId(groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> findByKeyword(
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
	 * Returns the budget participatif with the primary key.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif
	 * @throws PortalException if a budget participatif with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			getBudgetParticipatif(long budgetParticipatifId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetParticipatif(budgetParticipatifId);
	}

	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifByPublikUserID(String publikId) {

		return getService().getBudgetParticipatifByPublikUserID(publikId);
	}

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif
	 * @throws PortalException if a matching budget participatif could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			getBudgetParticipatifByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetParticipatifByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the budget participatifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of budget participatifs
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifs(int start, int end) {

		return getService().getBudgetParticipatifs(start, end);
	}

	/**
	 * Returns all the budget participatifs matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget participatifs
	 * @param companyId the primary key of the company
	 * @return the matching budget participatifs, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getBudgetParticipatifsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of budget participatifs matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget participatifs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching budget participatifs, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.project.model.BudgetParticipatif>
						orderByComparator) {

		return getService().getBudgetParticipatifsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of budget participatifs.
	 *
	 * @return the number of budget participatifs
	 */
	public static int getBudgetParticipatifsCount() {
		return getService().getBudgetParticipatifsCount();
	}

	/**
	 * Retourne tous les budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetSupportedByPublikUserInPhase(
				String publikUserId, long budgetPhaseId) {

		return getService().getBudgetSupportedByPublikUserInPhase(
			publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs d'une phase donnee
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getByBudgetPhase(long budgetPhaseId) {

		return getService().getByBudgetPhase(budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs d'un parent
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> getByParentId(
			long budgetPhaseId) {

		return getService().getByParentId(budgetPhaseId);
	}

	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getByPublikUserID(String publikId) {

		return getService().getByPublikUserID(publikId);
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
	 * Recuperer le nombre voulu des budgets participatifs les plus commentes
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus commentes triee.
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getMostCommented(
				long groupId, int delta,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return getService().getMostCommented(groupId, delta, phase);
	}

	/**
	 * Recuperer le nombre voulu des budgets participatifs les plus soutenus
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus soutenus triee.
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getMostSupported(
				long groupId, int delta,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return getService().getMostSupported(groupId, delta, phase);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne les budgets votes par en utilisateur pour la phase en cours en ne prenant pas en compte les doublons
	 * et les brouillons
	 *
	 * @param publikUserId
	 * @param budgetPhaseId
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getPublishedAndVotedByPublikUserInPhase(
				String publikUserId, long budgetPhaseId) {

		return getService().getPublishedAndVotedByPublikUserInPhase(
			publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getPublishedByGroupId(long groupId) {

		return getService().getPublishedByGroupId(groupId);
	}

	/**
	 * Recuperer les budgets participatifs "coup de coeur" les plus recents
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs coup de coeurs recent
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getRecentIsCrushed(
				long groupId, int delta,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return getService().getRecentIsCrushed(groupId, delta, phase);
	}

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de commentaires
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de commentaires
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getSortedByNbComments(
				long groupId,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return getService().getSortedByNbComments(groupId, phase);
	}

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de soutiens
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de soutiens
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getSortedByNbSupports(
				long groupId,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return getService().getSortedByNbSupports(groupId, phase);
	}

	public static void removeBudgetParticipatif(long budgetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeBudgetParticipatif(budgetId);
	}

	/**
	 * Updates the budget participatif in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was updated
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
		updateBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return getService().updateBudgetParticipatif(budgetParticipatif);
	}

	/**
	 * Méthode de mise à jour d'un budget
	 *
	 * @param budget le budget
	 * @param sc     le service context
	 * @return le budget
	 * @throws PortalException exception
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			updateBudgetParticipatif(
				eu.strasbourg.service.project.model.BudgetParticipatif budget,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateBudgetParticipatif(budget, sc);
	}

	/**
	 * Met à jour le statut du budgetParticipatif "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(budgetParticipatif, status);
	}

	/**
	 * mise a jour du status
	 *
	 * @param userId               l'identifiant de l'utilisateur
	 * @param budgetParticipatifId l'identifiant du budget
	 * @param status               le status
	 * @param serviceContext       le service context
	 * @param workflowContext      le context du workflow
	 * @return le budget
	 * @throws PortalException
	 */
	public static eu.strasbourg.service.project.model.BudgetParticipatif
			updateStatus(
				long userId, long budgetParticipatifId, int status,
				com.liferay.portal.kernel.service.ServiceContext serviceContext,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, budgetParticipatifId, status, serviceContext,
			workflowContext);
	}

	public static BudgetParticipatifLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BudgetParticipatifLocalService, BudgetParticipatifLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BudgetParticipatifLocalService.class);

		ServiceTracker
			<BudgetParticipatifLocalService, BudgetParticipatifLocalService>
				serviceTracker =
					new ServiceTracker
						<BudgetParticipatifLocalService,
						 BudgetParticipatifLocalService>(
							 bundle.getBundleContext(),
							 BudgetParticipatifLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}