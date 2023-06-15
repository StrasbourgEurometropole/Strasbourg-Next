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

package eu.strasbourg.service.help.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.help.model.HelpProposal;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for HelpProposal. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see HelpProposalLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface HelpProposalLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.help.service.impl.HelpProposalLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the help proposal local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link HelpProposalLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the help proposal to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpProposal the help proposal
	 * @return the help proposal that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public HelpProposal addHelpProposal(HelpProposal helpProposal);

	/**
	 * Creates a new help proposal with the primary key. Does not add the help proposal to the database.
	 *
	 * @param helpProposalId the primary key for the new help proposal
	 * @return the new help proposal
	 */
	@Transactional(enabled = false)
	public HelpProposal createHelpProposal(long helpProposalId);

	/**
	 * Crée une helpProposal vide avec une PK, non ajouté à la base de donnée
	 */
	public HelpProposal createHelpProposal(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the help proposal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpProposal the help proposal
	 * @return the help proposal that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public HelpProposal deleteHelpProposal(HelpProposal helpProposal);

	/**
	 * Deletes the help proposal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal that was removed
	 * @throws PortalException if a help proposal with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public HelpProposal deleteHelpProposal(long helpProposalId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code>.
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
	public HelpProposal fetchHelpProposal(long helpProposalId);

	/**
	 * Returns the help proposal matching the UUID and group.
	 *
	 * @param uuid the help proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HelpProposal fetchHelpProposalByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Recherche par mot clés
	 */
	public List<HelpProposal> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	public List<HelpProposal> findHelpedByPublikId(String publikUserId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne toutes les helpProposal d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HelpProposal> getByGroupId(long groupId);

	/**
	 * Retourne toutes les helpProposal d'un utilisateur (MonStrasbourg)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HelpProposal> getByPublikID(String publikId);

	/**
	 * Retourne la demande d'aide pour un utilisateur et une proposition donnee
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HelpProposal getByPublikIdAndHelpProposalId(
		String publikId, long helpProposalId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the help proposal with the primary key.
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal
	 * @throws PortalException if a help proposal with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HelpProposal getHelpProposal(long helpProposalId)
		throws PortalException;

	/**
	 * Returns the help proposal matching the UUID and group.
	 *
	 * @param uuid the help proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help proposal
	 * @throws PortalException if a matching help proposal could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HelpProposal getHelpProposalByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the help proposals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @return the range of help proposals
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HelpProposal> getHelpProposals(int start, int end);

	/**
	 * Returns all the help proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the help proposals
	 * @param companyId the primary key of the company
	 * @return the matching help proposals, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HelpProposal> getHelpProposalsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of help proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the help proposals
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of help proposals
	 * @param end the upper bound of the range of help proposals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching help proposals, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<HelpProposal> getHelpProposalsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator);

	/**
	 * Returns the number of help proposals.
	 *
	 * @return the number of help proposals
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getHelpProposalsCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void reindexById(long helpProposalId) throws SearchException;

	/**
	 * Supprime une helpProposal
	 */
	public HelpProposal removeHelpProposal(long helpProposalId)
		throws PortalException;

	/**
	 * Updates the help proposal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpProposal the help proposal
	 * @return the help proposal that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public HelpProposal updateHelpProposal(HelpProposal helpProposal);

	/**
	 * Met à jour une helpProposal et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public HelpProposal updateHelpProposal(
			HelpProposal helpProposal, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de la helpProposal "manuellement" (pas via le workflow)
	 */
	public void updateStatus(HelpProposal helpProposal, int status)
		throws PortalException;

	/**
	 * Met à jour le statut de la helpProposal par le framework workflow
	 */
	public HelpProposal updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}