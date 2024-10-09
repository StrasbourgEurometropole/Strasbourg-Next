/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.help.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.help.model.HelpRequest;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for HelpRequest. This utility wraps
 * <code>eu.strasbourg.service.help.service.impl.HelpRequestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequestLocalService
 * @generated
 */
public class HelpRequestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.help.service.impl.HelpRequestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the help request to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpRequest the help request
	 * @return the help request that was added
	 */
	public static HelpRequest addHelpRequest(HelpRequest helpRequest) {
		return getService().addHelpRequest(helpRequest);
	}

	/**
	 * Creates a new help request with the primary key. Does not add the help request to the database.
	 *
	 * @param helpRequestId the primary key for the new help request
	 * @return the new help request
	 */
	public static HelpRequest createHelpRequest(long helpRequestId) {
		return getService().createHelpRequest(helpRequestId);
	}

	/**
	 * Methode de creation d'une demande d'aide
	 *
	 * @param sc Le contexte de la requete.
	 * @return L'aide cree.
	 */
	public static HelpRequest createHelpRequest(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createHelpRequest(sc);
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
	 * Deletes the help request from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpRequest the help request
	 * @return the help request that was removed
	 */
	public static HelpRequest deleteHelpRequest(HelpRequest helpRequest) {
		return getService().deleteHelpRequest(helpRequest);
	}

	/**
	 * Deletes the help request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpRequestId the primary key of the help request
	 * @return the help request that was removed
	 * @throws PortalException if a help request with the primary key could not be found
	 */
	public static HelpRequest deleteHelpRequest(long helpRequestId)
		throws PortalException {

		return getService().deleteHelpRequest(helpRequestId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpRequestModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpRequestModelImpl</code>.
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

	public static HelpRequest fetchHelpRequest(long helpRequestId) {
		return getService().fetchHelpRequest(helpRequestId);
	}

	/**
	 * Returns the help request matching the UUID and group.
	 *
	 * @param uuid the help request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help request, or <code>null</code> if a matching help request could not be found
	 */
	public static HelpRequest fetchHelpRequestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchHelpRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<HelpRequest> findByKeyword(
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
	 * Retourne la liste des demands d'aides pour une proposition
	 */
	public static List<HelpRequest> getByHelpProposalId(long helpRequestId) {
		return getService().getByHelpProposalId(helpRequestId);
	}

	/**
	 * Retourne les demandes d'aides pour un utilisateur
	 */
	public static List<HelpRequest> getByPublikId(String publikId) {
		return getService().getByPublikId(publikId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the help request with the primary key.
	 *
	 * @param helpRequestId the primary key of the help request
	 * @return the help request
	 * @throws PortalException if a help request with the primary key could not be found
	 */
	public static HelpRequest getHelpRequest(long helpRequestId)
		throws PortalException {

		return getService().getHelpRequest(helpRequestId);
	}

	/**
	 * Returns the help request matching the UUID and group.
	 *
	 * @param uuid the help request's UUID
	 * @param groupId the primary key of the group
	 * @return the matching help request
	 * @throws PortalException if a matching help request could not be found
	 */
	public static HelpRequest getHelpRequestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getHelpRequestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the help requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.help.model.impl.HelpRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of help requests
	 * @param end the upper bound of the range of help requests (not inclusive)
	 * @return the range of help requests
	 */
	public static List<HelpRequest> getHelpRequests(int start, int end) {
		return getService().getHelpRequests(start, end);
	}

	/**
	 * Returns all the help requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the help requests
	 * @param companyId the primary key of the company
	 * @return the matching help requests, or an empty list if no matches were found
	 */
	public static List<HelpRequest> getHelpRequestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getHelpRequestsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of help requests matching the UUID and company.
	 *
	 * @param uuid the UUID of the help requests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of help requests
	 * @param end the upper bound of the range of help requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching help requests, or an empty list if no matches were found
	 */
	public static List<HelpRequest> getHelpRequestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<HelpRequest> orderByComparator) {

		return getService().getHelpRequestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of help requests.
	 *
	 * @return the number of help requests
	 */
	public static int getHelpRequestsCount() {
		return getService().getHelpRequestsCount();
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

	public static void reindexById(long helpRequestId)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindexById(helpRequestId);
	}

	/**
	 * Supprimer une demande d'aide
	 *
	 * @param helpRequestId Id de la demande d'aide
	 */
	public static HelpRequest removeHelpRequest(long helpRequestId)
		throws PortalException {

		return getService().removeHelpRequest(helpRequestId);
	}

	/**
	 * Updates the help request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HelpRequestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param helpRequest the help request
	 * @return the help request that was updated
	 */
	public static HelpRequest updateHelpRequest(HelpRequest helpRequest) {
		return getService().updateHelpRequest(helpRequest);
	}

	/**
	 * Met à jour une helpProposal et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static HelpRequest updateHelpRequest(
			HelpRequest helpRequest,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateHelpRequest(helpRequest, sc);
	}

	/**
	 * Met à jour le statut de la helpProposal "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(HelpRequest helpRequest, int status)
		throws PortalException {

		getService().updateStatus(helpRequest, status);
	}

	/**
	 * Met à jour le statut de la helpProposal par le framework workflow
	 */
	public static HelpRequest updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static HelpRequestLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<HelpRequestLocalService> _serviceSnapshot =
		new Snapshot<>(
			HelpRequestLocalServiceUtil.class, HelpRequestLocalService.class);

}