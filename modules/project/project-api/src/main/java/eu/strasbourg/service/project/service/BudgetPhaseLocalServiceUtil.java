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

import eu.strasbourg.service.project.model.BudgetPhase;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

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
	public static BudgetPhase addBudgetPhase(BudgetPhase budgetPhase) {
		return getService().addBudgetPhase(budgetPhase);
	}

	/**
	 * Creates a new budget phase with the primary key. Does not add the budget phase to the database.
	 *
	 * @param budgetPhaseId the primary key for the new budget phase
	 * @return the new budget phase
	 */
	public static BudgetPhase createBudgetPhase(long budgetPhaseId) {
		return getService().createBudgetPhase(budgetPhaseId);
	}

	/**
	 * Crée une phase vide avec une PK, non ajouté à la base de donnée
	 */
	public static BudgetPhase createBudgetPhase(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createBudgetPhase(sc);
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
	 * Deletes the budget phase from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetPhaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetPhase the budget phase
	 * @return the budget phase that was removed
	 */
	public static BudgetPhase deleteBudgetPhase(BudgetPhase budgetPhase) {
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
	public static BudgetPhase deleteBudgetPhase(long budgetPhaseId)
		throws PortalException {

		return getService().deleteBudgetPhase(budgetPhaseId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl</code>.
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

	public static BudgetPhase fetchBudgetPhase(long budgetPhaseId) {
		return getService().fetchBudgetPhase(budgetPhaseId);
	}

	/**
	 * Returns the budget phase matching the UUID and group.
	 *
	 * @param uuid the budget phase's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget phase, or <code>null</code> if a matching budget phase could not be found
	 */
	public static BudgetPhase fetchBudgetPhaseByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBudgetPhaseByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<BudgetPhase> findByKeyword(
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
	public static BudgetPhase getActivePhase(long groupId) {
		return getService().getActivePhase(groupId);
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à uen phase
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
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
	public static BudgetPhase getBudgetPhase(long budgetPhaseId)
		throws PortalException {

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
	public static BudgetPhase getBudgetPhaseByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

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
	public static List<BudgetPhase> getBudgetPhases(int start, int end) {
		return getService().getBudgetPhases(start, end);
	}

	/**
	 * Returns all the budget phases matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget phases
	 * @param companyId the primary key of the company
	 * @return the matching budget phases, or an empty list if no matches were found
	 */
	public static List<BudgetPhase> getBudgetPhasesByUuidAndCompanyId(
		String uuid, long companyId) {

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
	public static List<BudgetPhase> getBudgetPhasesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetPhase> orderByComparator) {

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
	public static List<BudgetPhase> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne les phases d'un groupe ayant un statut actif (champ isActive et non le
	 * statut du workFlow Liferay)
	 */
	public static List<BudgetPhase> getByIsActiveAndGroupId(
		boolean isActive, long groupId) {

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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une phase
	 */
	public static BudgetPhase removeBudgetPhase(long budgetPhaseId)
		throws PortalException {

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
	public static BudgetPhase updateBudgetPhase(BudgetPhase budgetPhase) {
		return getService().updateBudgetPhase(budgetPhase);
	}

	/**
	 * Met à jour une phase et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static BudgetPhase updateBudgetPhase(
			BudgetPhase budgetPhase,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateBudgetPhase(budgetPhase, sc);
	}

	/**
	 * Met à jour le statut de la phase "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(BudgetPhase budgetPhase, int status)
		throws PortalException {

		getService().updateStatus(budgetPhase, status);
	}

	/**
	 * Met à jour le statut de la phase par le framework workflow
	 */
	public static BudgetPhase updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static BudgetPhaseLocalService getService() {
		return _service;
	}

	public static void setService(BudgetPhaseLocalService service) {
		_service = service;
	}

	private static volatile BudgetPhaseLocalService _service;

}