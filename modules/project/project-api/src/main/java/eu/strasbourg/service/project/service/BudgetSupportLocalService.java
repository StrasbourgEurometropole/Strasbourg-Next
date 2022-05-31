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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.BudgetSupport;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for BudgetSupport. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see BudgetSupportLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BudgetSupportLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BudgetSupportLocalServiceUtil} to access the budget support local service. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.BudgetSupportLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
	@Indexable(type = IndexableType.REINDEX)
	public BudgetSupport addBudgetSupport(BudgetSupport budgetSupport);

	/**
	 * Compter les soutiens d'un budget participatif donne
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @return Nombre de soutiens
	 */
	public int countBudgetSupportByBudgetParticipatifId(
		long budgetParticipatifId);

	/**
	 * Creates a new budget support with the primary key. Does not add the budget support to the database.
	 *
	 * @param budgetSupportId the primary key for the new budget support
	 * @return the new budget support
	 */
	@Transactional(enabled = false)
	public BudgetSupport createBudgetSupport(long budgetSupportId);

	/**
	 * Methode de creation d'un budget participatif.
	 *
	 * @param sc Le contexte de la requete.
	 * @return Le soutien cree.
	 */
	public BudgetSupport createBudgetSupport(ServiceContext sc);

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
	@Indexable(type = IndexableType.DELETE)
	public BudgetSupport deleteBudgetSupport(BudgetSupport budgetSupport);

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
	@Indexable(type = IndexableType.DELETE)
	public BudgetSupport deleteBudgetSupport(long budgetSupportId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetSupport fetchBudgetSupport(long budgetSupportId);

	/**
	 * Returns the budget support matching the UUID and group.
	 *
	 * @param uuid the budget support's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget support, or <code>null</code> if a matching budget support could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetSupport fetchBudgetSupportByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the budget support with the primary key.
	 *
	 * @param budgetSupportId the primary key of the budget support
	 * @return the budget support
	 * @throws PortalException if a budget support with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetSupport getBudgetSupport(long budgetSupportId)
		throws PortalException;

	/**
	 * Recuperer les soutiens d'un budgte et d'un utilisateur donne
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @param publikId ID publik de l'utilsiateur
	 * @return Liste des soutiens
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport>
		getBudgetSupportByBudgetParticipatifIdAndPublikUserId(
			long budgetParticipatifId, String publikUserId);

	/**
	 * Recuperer les soutiens d'un utilisateur donne
	 *
	 * @param publikId ID publik de l'utilsiateur
	 * @return Liste des soutiens
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport> getBudgetSupportByPublikId(String publikId);

	/**
	 * Returns the budget support matching the UUID and group.
	 *
	 * @param uuid the budget support's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget support
	 * @throws PortalException if a matching budget support could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetSupport getBudgetSupportByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport> getBudgetSupports(int start, int end);

	/**
	 * Recuperer les soutien par l'identifiant du budget participatif.
	 *
	 * @param budgetParticipatifId ID du budget participatif.
	 * @return Liste des budgets participatifs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport> getBudgetSupportsByBudgetParticipatifId(
		long budgetParticipatifId);

	/**
	 * Returns all the budget supports matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget supports
	 * @param companyId the primary key of the company
	 * @return the matching budget supports, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport> getBudgetSupportsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetSupport> getBudgetSupportsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetSupport> orderByComparator);

	/**
	 * Returns the number of budget supports.
	 *
	 * @return the number of budget supports
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBudgetSupportsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Supprimer un soutien donne
	 *
	 * @param budgetSupportId Id du soutien
	 */
	public void removeBudgetSupport(long budgetSupportId);

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
	@Indexable(type = IndexableType.REINDEX)
	public BudgetSupport updateBudgetSupport(BudgetSupport budgetSupport);

}