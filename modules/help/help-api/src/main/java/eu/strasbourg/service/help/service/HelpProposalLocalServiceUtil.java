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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.help.model.HelpProposal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for HelpProposal. This utility wraps
 * <code>eu.strasbourg.service.help.service.impl.HelpProposalLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HelpProposalLocalService
 * @generated
 */
public class HelpProposalLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.help.service.impl.HelpProposalLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static HelpProposal addHelpProposal(HelpProposal helpProposal) {
		return getService().addHelpProposal(helpProposal);
	}

	/**
	 * Creates a new help proposal with the primary key. Does not add the help proposal to the database.
	 *
	 * @param helpProposalId the primary key for the new help proposal
	 * @return the new help proposal
	 */
	public static HelpProposal createHelpProposal(long helpProposalId) {
		return getService().createHelpProposal(helpProposalId);
	}

	/**
	 * Crée une helpProposal vide avec une PK, non ajouté à la base de donnée
	 */
	public static HelpProposal createHelpProposal(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createHelpProposal(sc);
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
	 * Deletes the help proposal from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpProposalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpProposal the help proposal
	 * @return the help proposal that was removed
	 */
	public static HelpProposal deleteHelpProposal(HelpProposal helpProposal) {
		return getService().deleteHelpProposal(helpProposal);
	}

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
	public static HelpProposal deleteHelpProposal(long helpProposalId)
		throws PortalException {

		return getService().deleteHelpProposal(helpProposalId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpProposalModelImpl</code>.
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

	public static HelpProposal fetchHelpProposal(long helpProposalId) {
		return getService().fetchHelpProposal(helpProposalId);
	}

	/**
	 * Returns the help proposal matching the UUID and group.
	 *
	 * @param uuid the help proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help proposal, or <code>null</code> if a matching help proposal could not be found
	 */
	public static HelpProposal fetchHelpProposalByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchHelpProposalByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<HelpProposal> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static List<HelpProposal> findHelpedByPublikId(String publikUserId) {
		return getService().findHelpedByPublikId(publikUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne toutes les helpProposal d'un groupe
	 */
	public static List<HelpProposal> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne toutes les helpProposal d'un utilisateur (MonStrasbourg)
	 */
	public static List<HelpProposal> getByPublikID(String publikId) {
		return getService().getByPublikID(publikId);
	}

	/**
	 * Retourne la demande d'aide pour un utilisateur et une proposition donnee
	 */
	public static HelpProposal getByPublikIdAndHelpProposalId(
		String publikId, long helpProposalId) {

		return getService().getByPublikIdAndHelpProposalId(
			publikId, helpProposalId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the help proposal with the primary key.
	 *
	 * @param helpProposalId the primary key of the help proposal
	 * @return the help proposal
	 * @throws PortalException if a help proposal with the primary key could not be found
	 */
	public static HelpProposal getHelpProposal(long helpProposalId)
		throws PortalException {

		return getService().getHelpProposal(helpProposalId);
	}

	/**
	 * Returns the help proposal matching the UUID and group.
	 *
	 * @param uuid the help proposal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help proposal
	 * @throws PortalException if a matching help proposal could not be found
	 */
	public static HelpProposal getHelpProposalByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getHelpProposalByUuidAndGroupId(uuid, groupId);
	}

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
	public static List<HelpProposal> getHelpProposals(int start, int end) {
		return getService().getHelpProposals(start, end);
	}

	/**
	 * Returns all the help proposals matching the UUID and company.
	 *
	 * @param uuid the UUID of the help proposals
	 * @param companyId the primary key of the company
	 * @return the matching help proposals, or an empty list if no matches were found
	 */
	public static List<HelpProposal> getHelpProposalsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getHelpProposalsByUuidAndCompanyId(uuid, companyId);
	}

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
	public static List<HelpProposal> getHelpProposalsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<HelpProposal> orderByComparator) {

		return getService().getHelpProposalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of help proposals.
	 *
	 * @return the number of help proposals
	 */
	public static int getHelpProposalsCount() {
		return getService().getHelpProposalsCount();
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

	public static void reindexById(long helpProposalId)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindexById(helpProposalId);
	}

	/**
	 * Supprime une helpProposal
	 */
	public static HelpProposal removeHelpProposal(long helpProposalId)
		throws PortalException {

		return getService().removeHelpProposal(helpProposalId);
	}

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
	public static HelpProposal updateHelpProposal(HelpProposal helpProposal) {
		return getService().updateHelpProposal(helpProposal);
	}

	/**
	 * Met à jour une helpProposal et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static HelpProposal updateHelpProposal(
			HelpProposal helpProposal,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateHelpProposal(helpProposal, sc);
	}

	/**
	 * Met à jour le statut de la helpProposal "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(HelpProposal helpProposal, int status)
		throws PortalException {

		getService().updateStatus(helpProposal, status);
	}

	/**
	 * Met à jour le statut de la helpProposal par le framework workflow
	 */
	public static HelpProposal updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static HelpProposalLocalService getService() {
		return _service;
	}

	private static volatile HelpProposalLocalService _service;

}