/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BudgetParticipatifLocalService}.
 *
 * @author Cedric Henry
 * @see BudgetParticipatifLocalService
 * @generated
 */
public class BudgetParticipatifLocalServiceWrapper
	implements BudgetParticipatifLocalService,
			   ServiceWrapper<BudgetParticipatifLocalService> {

	public BudgetParticipatifLocalServiceWrapper() {
		this(null);
	}

	public BudgetParticipatifLocalServiceWrapper(
		BudgetParticipatifLocalService budgetParticipatifLocalService) {

		_budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	/**
	 * Adds the budget participatif to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetParticipatifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was added
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		addBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return _budgetParticipatifLocalService.addBudgetParticipatif(
			budgetParticipatif);
	}

	/**
	 * Retourne le nombre de budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	@Override
	public int countBudgetSupportedByPublikUserInPhase(
		String publikUserId, long budgetPhaseId) {

		return _budgetParticipatifLocalService.
			countBudgetSupportedByPublikUserInPhase(
				publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne le nombre de budgets participatifs suivis négativement par un utilisateur et une phase donnes
	 */
	@Override
	public int countBudgetSupportedNegativelyByPublikUserInPhase(
		String publikUserId, long budgetPhaseId) {

		return _budgetParticipatifLocalService.
			countBudgetSupportedNegativelyByPublikUserInPhase(
				publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne le nombre de budgets participatifs suivis positivement par un utilisateur et une phase donnes
	 */
	@Override
	public int countBudgetSupportedPositivelyByPublikUserInPhase(
		String publikUserId, long budgetPhaseId) {

		return _budgetParticipatifLocalService.
			countBudgetSupportedPositivelyByPublikUserInPhase(
				publikUserId, budgetPhaseId);
	}

	/**
	 * Creates a new budget participatif with the primary key. Does not add the budget participatif to the database.
	 *
	 * @param budgetParticipatifId the primary key for the new budget participatif
	 * @return the new budget participatif
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		createBudgetParticipatif(long budgetParticipatifId) {

		return _budgetParticipatifLocalService.createBudgetParticipatif(
			budgetParticipatifId);
	}

	/**
	 * Crée une participation vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
			createBudgetParticipatif(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.createBudgetParticipatif(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the budget participatif from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetParticipatifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was removed
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		deleteBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return _budgetParticipatifLocalService.deleteBudgetParticipatif(
			budgetParticipatif);
	}

	/**
	 * Deletes the budget participatif with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetParticipatifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif that was removed
	 * @throws PortalException if a budget participatif with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
			deleteBudgetParticipatif(long budgetParticipatifId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.deleteBudgetParticipatif(
			budgetParticipatifId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _budgetParticipatifLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _budgetParticipatifLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _budgetParticipatifLocalService.dynamicQuery();
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

		return _budgetParticipatifLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>.
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

		return _budgetParticipatifLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>.
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

		return _budgetParticipatifLocalService.dynamicQuery(
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

		return _budgetParticipatifLocalService.dynamicQueryCount(dynamicQuery);
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

		return _budgetParticipatifLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		fetchBudgetParticipatif(long budgetParticipatifId) {

		return _budgetParticipatifLocalService.fetchBudgetParticipatif(
			budgetParticipatifId);
	}

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		fetchBudgetParticipatifByUuidAndGroupId(String uuid, long groupId) {

		return _budgetParticipatifLocalService.
			fetchBudgetParticipatifByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			findActiveBPByGroupId(long groupId) {

		return _budgetParticipatifLocalService.findActiveBPByGroupId(groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> findByKeyword(
			String keyword, long groupId, int start, int end) {

		return _budgetParticipatifLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _budgetParticipatifLocalService.findByKeywordCount(
			keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _budgetParticipatifLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the budget participatif with the primary key.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif
	 * @throws PortalException if a budget participatif with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
			getBudgetParticipatif(long budgetParticipatifId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.getBudgetParticipatif(
			budgetParticipatifId);
	}

	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifByPublikUserID(String publikId) {

		return _budgetParticipatifLocalService.
			getBudgetParticipatifByPublikUserID(publikId);
	}

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif
	 * @throws PortalException if a matching budget participatif could not be found
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
			getBudgetParticipatifByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.
			getBudgetParticipatifByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the budget participatifs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget participatifs
	 * @param end the upper bound of the range of budget participatifs (not inclusive)
	 * @return the range of budget participatifs
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifs(int start, int end) {

		return _budgetParticipatifLocalService.getBudgetParticipatifs(
			start, end);
	}

	/**
	 * Returns all the budget participatifs matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget participatifs
	 * @param companyId the primary key of the company
	 * @return the matching budget participatifs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifsByUuidAndCompanyId(
				String uuid, long companyId) {

		return _budgetParticipatifLocalService.
			getBudgetParticipatifsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetParticipatifsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.project.model.BudgetParticipatif>
						orderByComparator) {

		return _budgetParticipatifLocalService.
			getBudgetParticipatifsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of budget participatifs.
	 *
	 * @return the number of budget participatifs
	 */
	@Override
	public int getBudgetParticipatifsCount() {
		return _budgetParticipatifLocalService.getBudgetParticipatifsCount();
	}

	/**
	 * Retourne tous les budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetSupportedByPublikUserInPhase(
				String publikUserId, long budgetPhaseId) {

		return _budgetParticipatifLocalService.
			getBudgetSupportedByPublikUserInPhase(publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getBudgetSupportedByPublikUserInPhase(
				String publikUserId, long budgetPhaseId, boolean isNegative) {

		return _budgetParticipatifLocalService.
			getBudgetSupportedByPublikUserInPhase(
				publikUserId, budgetPhaseId, isNegative);
	}

	/**
	 * Retourne tous les budgets participatifs d'une phase donnee
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getByBudgetPhase(long budgetPhaseId) {

		return _budgetParticipatifLocalService.getByBudgetPhase(budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs d'un parent
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif> getByParentId(
			long budgetPhaseId) {

		return _budgetParticipatifLocalService.getByParentId(budgetPhaseId);
	}

	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getByPublikUserID(String publikId) {

		return _budgetParticipatifLocalService.getByPublikUserID(publikId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _budgetParticipatifLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _budgetParticipatifLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Recuperer le nombre voulu des budgets participatifs les plus commentes
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus commentes triee.
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getMostCommented(
				long groupId, int delta,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return _budgetParticipatifLocalService.getMostCommented(
			groupId, delta, phase);
	}

	/**
	 * Recuperer le nombre voulu des budgets participatifs les plus soutenus
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus soutenus triee.
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getMostSupported(
				long groupId, int delta,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return _budgetParticipatifLocalService.getMostSupported(
			groupId, delta, phase);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _budgetParticipatifLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne les budgets votes par en utilisateur pour la phase en cours en ne prenant pas en compte les doublons
	 * et les brouillons
	 *
	 * @param publikUserId
	 * @param budgetPhaseId
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getPublishedAndVotedByPublikUserInPhase(
				String publikUserId, long budgetPhaseId) {

		return _budgetParticipatifLocalService.
			getPublishedAndVotedByPublikUserInPhase(
				publikUserId, budgetPhaseId);
	}

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getPublishedByGroupId(long groupId) {

		return _budgetParticipatifLocalService.getPublishedByGroupId(groupId);
	}

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de commentaires
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de commentaires
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getSortedByNbComments(
				long groupId,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return _budgetParticipatifLocalService.getSortedByNbComments(
			groupId, phase);
	}

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de soutiens
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de soutiens
	 */
	@Override
	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			getSortedByNbSupports(
				long groupId,
				com.liferay.asset.kernel.model.AssetCategory phase) {

		return _budgetParticipatifLocalService.getSortedByNbSupports(
			groupId, phase);
	}

	@Override
	public void removeBudgetParticipatif(long budgetId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_budgetParticipatifLocalService.removeBudgetParticipatif(budgetId);
	}

	/**
	 * Updates the budget participatif in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetParticipatifLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetParticipatif the budget participatif
	 * @return the budget participatif that was updated
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
		updateBudgetParticipatif(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif) {

		return _budgetParticipatifLocalService.updateBudgetParticipatif(
			budgetParticipatif);
	}

	/**
	 * Méthode de mise à jour d'un budget
	 *
	 * @param budget le budget
	 * @param sc     le service context
	 * @return le budget
	 * @throws PortalException exception
	 */
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif
			updateBudgetParticipatif(
				eu.strasbourg.service.project.model.BudgetParticipatif budget,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.updateBudgetParticipatif(
			budget, sc);
	}

	/**
	 * Met à jour le statut du budgetParticipatif "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.project.model.BudgetParticipatif
				budgetParticipatif,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_budgetParticipatifLocalService.updateStatus(
			budgetParticipatif, status);
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
	@Override
	public eu.strasbourg.service.project.model.BudgetParticipatif updateStatus(
			long userId, long budgetParticipatifId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _budgetParticipatifLocalService.updateStatus(
			userId, budgetParticipatifId, status, serviceContext,
			workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _budgetParticipatifLocalService.getBasePersistence();
	}

	@Override
	public BudgetParticipatifLocalService getWrappedService() {
		return _budgetParticipatifLocalService;
	}

	@Override
	public void setWrappedService(
		BudgetParticipatifLocalService budgetParticipatifLocalService) {

		_budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	private BudgetParticipatifLocalService _budgetParticipatifLocalService;

}