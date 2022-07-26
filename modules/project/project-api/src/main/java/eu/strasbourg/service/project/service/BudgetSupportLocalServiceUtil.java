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
 * Provides the local service utility for BudgetSupport. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.BudgetSupportLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see BudgetSupportLocalService
 * @generated
 */
public class BudgetSupportLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.BudgetSupportLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the budget support to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetSupportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetSupport the budget support
	 * @return the budget support that was added
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		addBudgetSupport(
			eu.strasbourg.service.project.model.BudgetSupport budgetSupport) {

		return getService().addBudgetSupport(budgetSupport);
	}

	/**
	 * Compter les soutiens d'un budget participatif donne
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @return Nombre de soutiens
	 */
	public static int countBudgetSupportByBudgetParticipatifId(
		long budgetParticipatifId) {

		return getService().countBudgetSupportByBudgetParticipatifId(
			budgetParticipatifId);
	}

	/**
	 * Creates a new budget support with the primary key. Does not add the budget support to the database.
	 *
	 * @param budgetSupportId the primary key for the new budget support
	 * @return the new budget support
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		createBudgetSupport(long budgetSupportId) {

		return getService().createBudgetSupport(budgetSupportId);
	}

	/**
	 * Methode de creation d'un budget participatif.
	 *
	 * @param sc Le contexte de la requete.
	 * @return Le soutien cree.
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		createBudgetSupport(
			com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createBudgetSupport(sc);
	}

	/**
	 * Deletes the budget support from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetSupportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetSupport the budget support
	 * @return the budget support that was removed
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		deleteBudgetSupport(
			eu.strasbourg.service.project.model.BudgetSupport budgetSupport) {

		return getService().deleteBudgetSupport(budgetSupport);
	}

	/**
	 * Deletes the budget support with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetSupportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetSupportId the primary key of the budget support
	 * @return the budget support that was removed
	 * @throws PortalException if a budget support with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
			deleteBudgetSupport(long budgetSupportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteBudgetSupport(budgetSupportId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl</code>.
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

	public static eu.strasbourg.service.project.model.BudgetSupport
		fetchBudgetSupport(long budgetSupportId) {

		return getService().fetchBudgetSupport(budgetSupportId);
	}

	/**
	 * Returns the budget support matching the UUID and group.
	 *
	 * @param uuid the budget support's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget support, or <code>null</code> if a matching budget support could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		fetchBudgetSupportByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchBudgetSupportByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the budget support with the primary key.
	 *
	 * @param budgetSupportId the primary key of the budget support
	 * @return the budget support
	 * @throws PortalException if a budget support with the primary key could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
			getBudgetSupport(long budgetSupportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetSupport(budgetSupportId);
	}

	/**
	 * Recuperer les soutiens d'un budgte et d'un utilisateur donne
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @param publikId ID publik de l'utilsiateur
	 * @return Liste des soutiens
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport>
			getBudgetSupportByBudgetParticipatifIdAndPublikUserId(
				long budgetParticipatifId, String publikUserId) {

		return getService().
			getBudgetSupportByBudgetParticipatifIdAndPublikUserId(
				budgetParticipatifId, publikUserId);
	}

	/**
	 * Recuperer les soutiens d'un utilisateur donne
	 *
	 * @param publikId ID publik de l'utilsiateur
	 * @return Liste des soutiens
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport>
			getBudgetSupportByPublikId(String publikId) {

		return getService().getBudgetSupportByPublikId(publikId);
	}

	/**
	 * Returns the budget support matching the UUID and group.
	 *
	 * @param uuid the budget support's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget support
	 * @throws PortalException if a matching budget support could not be found
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
			getBudgetSupportByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBudgetSupportByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the budget supports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of budget supports
	 * @param end the upper bound of the range of budget supports (not inclusive)
	 * @return the range of budget supports
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport> getBudgetSupports(
			int start, int end) {

		return getService().getBudgetSupports(start, end);
	}

	/**
	 * Recuperer les soutien par l'identifiant du budget participatif.
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @return Liste des budgets participatifs
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport>
			getBudgetSupportsByBudgetParticipatifId(long budgetParticipatifId) {

		return getService().getBudgetSupportsByBudgetParticipatifId(
			budgetParticipatifId);
	}

	/**
	 * Returns all the budget supports matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget supports
	 * @param companyId the primary key of the company
	 * @return the matching budget supports, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport>
			getBudgetSupportsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getBudgetSupportsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of budget supports matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget supports
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of budget supports
	 * @param end the upper bound of the range of budget supports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching budget supports, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.project.model.BudgetSupport>
			getBudgetSupportsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.project.model.BudgetSupport>
						orderByComparator) {

		return getService().getBudgetSupportsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of budget supports.
	 *
	 * @return the number of budget supports
	 */
	public static int getBudgetSupportsCount() {
		return getService().getBudgetSupportsCount();
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
	 * Supprimer un soutien donne
	 *
	 * @param budgetSupportId Id du soutien
	 */
	public static void removeBudgetSupport(long budgetSupportId) {
		getService().removeBudgetSupport(budgetSupportId);
	}

	/**
	 * Updates the budget support in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BudgetSupportLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param budgetSupport the budget support
	 * @return the budget support that was updated
	 */
	public static eu.strasbourg.service.project.model.BudgetSupport
		updateBudgetSupport(
			eu.strasbourg.service.project.model.BudgetSupport budgetSupport) {

		return getService().updateBudgetSupport(budgetSupport);
	}

	public static BudgetSupportLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<BudgetSupportLocalService, BudgetSupportLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			BudgetSupportLocalService.class);

		ServiceTracker<BudgetSupportLocalService, BudgetSupportLocalService>
			serviceTracker =
				new ServiceTracker
					<BudgetSupportLocalService, BudgetSupportLocalService>(
						bundle.getBundleContext(),
						BudgetSupportLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}