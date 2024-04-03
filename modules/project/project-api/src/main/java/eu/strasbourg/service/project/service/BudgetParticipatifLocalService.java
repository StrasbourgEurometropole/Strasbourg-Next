/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
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
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.BudgetParticipatif;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for BudgetParticipatif. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see BudgetParticipatifLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.project.model.BudgetParticipatif"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface BudgetParticipatifLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.BudgetParticipatifLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the budget participatif local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link BudgetParticipatifLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public BudgetParticipatif addBudgetParticipatif(
		BudgetParticipatif budgetParticipatif);

	/**
	 * Retourne le nombre de budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	public int countBudgetSupportedByPublikUserInPhase(
		String publikUserId, long budgetPhaseId);

	/**
	 * Creates a new budget participatif with the primary key. Does not add the budget participatif to the database.
	 *
	 * @param budgetParticipatifId the primary key for the new budget participatif
	 * @return the new budget participatif
	 */
	@Transactional(enabled = false)
	public BudgetParticipatif createBudgetParticipatif(
		long budgetParticipatifId);

	/**
	 * Crée une participation vide avec une PK, non ajouté à la base de donnée
	 */
	public BudgetParticipatif createBudgetParticipatif(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public BudgetParticipatif deleteBudgetParticipatif(
		BudgetParticipatif budgetParticipatif);

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
	@Indexable(type = IndexableType.DELETE)
	public BudgetParticipatif deleteBudgetParticipatif(
			long budgetParticipatifId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl</code>.
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
	public BudgetParticipatif fetchBudgetParticipatif(
		long budgetParticipatifId);

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif, or <code>null</code> if a matching budget participatif could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetParticipatif fetchBudgetParticipatifByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	public List<BudgetParticipatif> findActiveBPByGroupId(long groupId);

	/**
	 * Recherche par mot clés
	 */
	public List<BudgetParticipatif> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the budget participatif with the primary key.
	 *
	 * @param budgetParticipatifId the primary key of the budget participatif
	 * @return the budget participatif
	 * @throws PortalException if a budget participatif with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetParticipatif getBudgetParticipatif(long budgetParticipatifId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getBudgetParticipatifByPublikUserID(
		String publikId);

	/**
	 * Returns the budget participatif matching the UUID and group.
	 *
	 * @param uuid the budget participatif's UUID
	 * @param groupId the primary key of the group
	 * @return the matching budget participatif
	 * @throws PortalException if a matching budget participatif could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BudgetParticipatif getBudgetParticipatifByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getBudgetParticipatifs(int start, int end);

	/**
	 * Returns all the budget participatifs matching the UUID and company.
	 *
	 * @param uuid the UUID of the budget participatifs
	 * @param companyId the primary key of the company
	 * @return the matching budget participatifs, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getBudgetParticipatifsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getBudgetParticipatifsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BudgetParticipatif> orderByComparator);

	/**
	 * Returns the number of budget participatifs.
	 *
	 * @return the number of budget participatifs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBudgetParticipatifsCount();

	/**
	 * Retourne tous les budgets participatifs suivis par un utilisateur et une phase donnes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getBudgetSupportedByPublikUserInPhase(
		String publikUserId, long budgetPhaseId);

	/**
	 * Retourne tous les budgets participatifs d'une phase donnee
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getByBudgetPhase(long budgetPhaseId);

	/**
	 * Retourne tous les budgets participatifs d'un parent
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getByParentId(long budgetPhaseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getByPublikUserID(String publikId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Recuperer le nombre voulu des budgets participatifs les plus commentes
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus commentes triee.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getMostCommented(
		long groupId, int delta, AssetCategory phase);

	/**
	 * Recuperer le nombre voulu des budgets participatifs les plus soutenus
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs les plus soutenus triee.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getMostSupported(
		long groupId, int delta, AssetCategory phase);

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
	 * Retourne les budgets votes par en utilisateur pour la phase en cours en ne prenant pas en compte les doublons
	 * et les brouillons
	 *
	 * @param publikUserId
	 * @param budgetPhaseId
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getPublishedAndVotedByPublikUserInPhase(
		String publikUserId, long budgetPhaseId);

	/**
	 * Retourne tous les budgets participatifs publies d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getPublishedByGroupId(long groupId);

	/**
	 * Recuperer les budgets participatifs "coup de coeur" les plus recents
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste des budgets participatifs coup de coeurs recent
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getRecentIsCrushed(
		long groupId, int delta, AssetCategory phase);

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de commentaires
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de commentaires
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getSortedByNbComments(
		long groupId, AssetCategory phase);

	/**
	 * Methode permettant de recuperer une liste de budgets participatifs trie par nombre de soutiens
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de soutiens
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<BudgetParticipatif> getSortedByNbSupports(
		long groupId, AssetCategory phase);

	/**
	 * On randomise la date de modifications des budgets participatifs
	 * Cela permet de simuler un tri aléatoire
	 */
	public void randomizeModifiedDate() throws SearchException;

	public void removeBudgetParticipatif(long budgetId) throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public BudgetParticipatif updateBudgetParticipatif(
		BudgetParticipatif budgetParticipatif);

	/**
	 * Méthode de mise à jour d'un budget
	 *
	 * @param budget le budget
	 * @param sc     le service context
	 * @return le budget
	 * @throws PortalException exception
	 */
	public BudgetParticipatif updateBudgetParticipatif(
			BudgetParticipatif budget, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut du budgetParticipatif "manuellement" (pas via le workflow)
	 */
	public void updateStatus(BudgetParticipatif budgetParticipatif, int status)
		throws PortalException;

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
	public BudgetParticipatif updateStatus(
			long userId, long budgetParticipatifId, int status,
			ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}