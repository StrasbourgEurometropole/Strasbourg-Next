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

import eu.strasbourg.service.project.model.Initiative;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Initiative. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.InitiativeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see InitiativeLocalService
 * @generated
 */
public class InitiativeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.InitiativeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the initiative to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiative the initiative
	 * @return the initiative that was added
	 */
	public static Initiative addInitiative(Initiative initiative) {
		return getService().addInitiative(initiative);
	}

	/**
	 * Creates a new initiative with the primary key. Does not add the initiative to the database.
	 *
	 * @param initiativeId the primary key for the new initiative
	 * @return the new initiative
	 */
	public static Initiative createInitiative(long initiativeId) {
		return getService().createInitiative(initiativeId);
	}

	/**
	 * Crée une initiative vide avec une PK, non ajouté à la base de donnée
	 */
	public static Initiative createInitiative(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createInitiative(sc);
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
	 * Deletes the initiative from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiative the initiative
	 * @return the initiative that was removed
	 */
	public static Initiative deleteInitiative(Initiative initiative) {
		return getService().deleteInitiative(initiative);
	}

	/**
	 * Deletes the initiative with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative that was removed
	 * @throws PortalException if a initiative with the primary key could not be found
	 */
	public static Initiative deleteInitiative(long initiativeId)
		throws PortalException {

		return getService().deleteInitiative(initiativeId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeModelImpl</code>.
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

	public static Initiative fetchInitiative(long initiativeId) {
		return getService().fetchInitiative(initiativeId);
	}

	/**
	 * Returns the initiative matching the UUID and group.
	 *
	 * @param uuid the initiative's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative, or <code>null</code> if a matching initiative could not be found
	 */
	public static Initiative fetchInitiativeByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchInitiativeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Initiative> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static List<Initiative> findByPublikUserId(String publikUserId) {
		return getService().findByPublikUserId(publikUserId);
	}

	public static List<Initiative> findHelpedByPublikUserId(
		String publikUserId) {

		return getService().findHelpedByPublikUserId(publikUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne toutes les initiatives d'un groupe
	 */
	public static List<Initiative> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static List<Initiative> getByPublikUserID(String publikId) {
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
	 * Returns the initiative with the primary key.
	 *
	 * @param initiativeId the primary key of the initiative
	 * @return the initiative
	 * @throws PortalException if a initiative with the primary key could not be found
	 */
	public static Initiative getInitiative(long initiativeId)
		throws PortalException {

		return getService().getInitiative(initiativeId);
	}

	/**
	 * Returns the initiative matching the UUID and group.
	 *
	 * @param uuid the initiative's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative
	 * @throws PortalException if a matching initiative could not be found
	 */
	public static Initiative getInitiativeByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getInitiativeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the initiatives.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @return the range of initiatives
	 */
	public static List<Initiative> getInitiatives(int start, int end) {
		return getService().getInitiatives(start, end);
	}

	/**
	 * Returns all the initiatives matching the UUID and company.
	 *
	 * @param uuid the UUID of the initiatives
	 * @param companyId the primary key of the company
	 * @return the matching initiatives, or an empty list if no matches were found
	 */
	public static List<Initiative> getInitiativesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getInitiativesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of initiatives matching the UUID and company.
	 *
	 * @param uuid the UUID of the initiatives
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of initiatives
	 * @param end the upper bound of the range of initiatives (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching initiatives, or an empty list if no matches were found
	 */
	public static List<Initiative> getInitiativesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Initiative> orderByComparator) {

		return getService().getInitiativesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of initiatives.
	 *
	 * @return the number of initiatives
	 */
	public static int getInitiativesCount() {
		return getService().getInitiativesCount();
	}

	/**
	 * Recuperer le nombre voulu d'initiatives les plus commentes
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste d'initiatives les plus commentes triee.
	 */
	public static List<Initiative> getMostCommented(long groupId, int delta) {
		return getService().getMostCommented(groupId, delta);
	}

	/**
	 * Recuperer le nombre voulu d'initiatives les plus soutenus
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste d'initiatives les plus aidé triee.
	 */
	public static List<Initiative> getMostHelped(long groupId, int delta) {
		return getService().getMostHelped(groupId, delta);
	}

	/**
	 * Recuperer le nombre voulu d'initiatives les plus soutenus
	 *
	 * @param groupId ID du site
	 * @param delta Nombre de resultats max voulu
	 * @return Liste d'initiatives les plus aidé triee.
	 */
	public static List<Initiative> getMostLiked(long groupId, int delta) {
		return getService().getMostLiked(groupId, delta);
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
	 * Retourne toutes les initiatives publiées d'un groupe
	 */
	public static List<Initiative> getPublishedByGroupId(long groupId) {
		return getService().getPublishedByGroupId(groupId);
	}

	/**
	 * Methode permettant de recuperer une liste d'initiatives triee par nombre de commentaires
	 *
	 * @param groupId ID du site
	 * @return Liste des initiatives triee par nombre de commentaires
	 */
	public static List<Initiative> getSortedByNbComments(long groupId) {
		return getService().getSortedByNbComments(groupId);
	}

	/**
	 * Methode permettant de recuperer une liste d'initiatives triee par nombre de soutiens
	 *
	 * @param groupId ID du site
	 * @return Liste des budgets participatifs triee par nombre de soutiens
	 */
	public static List<Initiative> getSortedByNbHelps(long groupId) {
		return getService().getSortedByNbHelps(groupId);
	}

	/**
	 * Methode permettant de recuperer une liste d'initiatives triee par nombre de soutiens
	 *
	 * @param groupId ID du site
	 * @return Liste d'initiatives triee par nombre de soutiens
	 */
	public static List<Initiative> getSortedByNbLikes(long groupId) {
		return getService().getSortedByNbLikes(groupId);
	}

	/**
	 * Supprime une initiative
	 */
	public static Initiative removeInitiative(long initiativeId)
		throws PortalException {

		return getService().removeInitiative(initiativeId);
	}

	/**
	 * Updates the initiative in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiative the initiative
	 * @return the initiative that was updated
	 */
	public static Initiative updateInitiative(Initiative initiative) {
		return getService().updateInitiative(initiative);
	}

	/**
	 * Met à jour une initiative et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Initiative updateInitiative(
			Initiative initiative,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateInitiative(initiative, sc);
	}

	/**
	 * Met à jour le statut de l'initiative "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Initiative initiative, int status)
		throws PortalException {

		getService().updateStatus(initiative, status);
	}

	/**
	 * Met à jour le statut de l'initiative par le framework workflow
	 */
	public static Initiative updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static InitiativeLocalService getService() {
		return _service;
	}

	public static void setService(InitiativeLocalService service) {
		_service = service;
	}

	private static volatile InitiativeLocalService _service;

}