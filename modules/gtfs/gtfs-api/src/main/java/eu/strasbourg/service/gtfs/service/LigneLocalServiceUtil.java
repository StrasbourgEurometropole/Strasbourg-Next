/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.Ligne;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Ligne. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.LigneLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see LigneLocalService
 * @generated
 */
public class LigneLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.LigneLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ligne to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LigneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ligne the ligne
	 * @return the ligne that was added
	 */
	public static Ligne addLigne(Ligne ligne) {
		return getService().addLigne(ligne);
	}

	/**
	 * Creates a new ligne with the primary key. Does not add the ligne to the database.
	 *
	 * @param ligneId the primary key for the new ligne
	 * @return the new ligne
	 */
	public static Ligne createLigne(long ligneId) {
		return getService().createLigne(ligneId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public static Ligne createLigne(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createLigne(sc);
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
	 * Deletes the ligne from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LigneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ligne the ligne
	 * @return the ligne that was removed
	 */
	public static Ligne deleteLigne(Ligne ligne) {
		return getService().deleteLigne(ligne);
	}

	/**
	 * Deletes the ligne with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LigneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne that was removed
	 * @throws PortalException if a ligne with the primary key could not be found
	 */
	public static Ligne deleteLigne(long ligneId) throws PortalException {
		return getService().deleteLigne(ligneId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>.
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

	public static Ligne fetchLigne(long ligneId) {
		return getService().fetchLigne(ligneId);
	}

	/**
	 * Returns the ligne matching the UUID and group.
	 *
	 * @param uuid the ligne's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public static Ligne fetchLigneByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchLigneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Ligne> findByKeyword(
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
	 * Retourne la liste de toutes les lignes
	 */
	public static Map<String, Ligne> getAll() {
		return getService().getAll();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entree
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	public static List<Ligne> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne une ligne via son routeId CTS
	 */
	public static Ligne getByRouteId(String routeId) {
		return getService().getByRouteId(routeId);
	}

	/**
	 * Retourne les lignes qui possedent les memes donnees
	 */
	public static List<Ligne> getByShortNameAndStatus(
		String shortName, int status) {

		return getService().getByShortNameAndStatus(shortName, status);
	}

	/**
	 * Retourne toutes les lignes avec un status choisi
	 */
	public static List<Ligne> getByStatus(int status) {
		return getService().getByStatus(status);
	}

	/**
	 * Retourne toutes les lignes avec un status choisi par modifiedDate
	 */
	public static List<Ligne> getByStatusOrderedByModifiedDate(int status) {
		return getService().getByStatusOrderedByModifiedDate(status);
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
	 * Returns the ligne with the primary key.
	 *
	 * @param ligneId the primary key of the ligne
	 * @return the ligne
	 * @throws PortalException if a ligne with the primary key could not be found
	 */
	public static Ligne getLigne(long ligneId) throws PortalException {
		return getService().getLigne(ligneId);
	}

	/**
	 * Returns the ligne matching the UUID and group.
	 *
	 * @param uuid the ligne's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ligne
	 * @throws PortalException if a matching ligne could not be found
	 */
	public static Ligne getLigneByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getLigneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recuperer toutes les couleurs de ligne au format JSON
	 */
	public static com.liferay.portal.kernel.json.JSONArray getLigneColors() {
		return getService().getLigneColors();
	}

	/**
	 * Recuperer toutes les couleurs de ligne au format HashMap
	 */
	public static Map<String, String[]> getLigneColorsFreemarker() {
		return getService().getLigneColorsFreemarker();
	}

	/**
	 * Returns a range of all the lignes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @return the range of lignes
	 */
	public static List<Ligne> getLignes(int start, int end) {
		return getService().getLignes(start, end);
	}

	/**
	 * Returns all the lignes matching the UUID and company.
	 *
	 * @param uuid the UUID of the lignes
	 * @param companyId the primary key of the company
	 * @return the matching lignes, or an empty list if no matches were found
	 */
	public static List<Ligne> getLignesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getLignesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of lignes matching the UUID and company.
	 *
	 * @param uuid the UUID of the lignes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of lignes
	 * @param end the upper bound of the range of lignes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching lignes, or an empty list if no matches were found
	 */
	public static List<Ligne> getLignesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Ligne> orderByComparator) {

		return getService().getLignesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of lignes.
	 *
	 * @return the number of lignes
	 */
	public static int getLignesCount() {
		return getService().getLignesCount();
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
	 * Supprime l'entree
	 */
	public static Ligne removeLigne(long ligneId) throws PortalException {
		return getService().removeLigne(ligneId);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow) des entrees
	 */
	public static void unpublishLignes(
			List<Ligne> lignes,
			eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().unpublishLignes(lignes, importHistoric, sc);
	}

	/**
	 * Updates the ligne in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LigneLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ligne the ligne
	 * @return the ligne that was updated
	 */
	public static Ligne updateLigne(Ligne ligne) {
		return getService().updateLigne(ligne);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Ligne updateLigne(
			Ligne ligne, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateLigne(ligne, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public static void updateLignes(
			List<Ligne> lignes,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().updateLignes(lignes, sc);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Ligne ligne, int status)
		throws PortalException {

		getService().updateStatus(ligne, status);
	}

	/**
	 * Met à jour le statut de l'entree par le framework workflow
	 */
	public static Ligne updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static LigneLocalService getService() {
		return _service;
	}

	public static void setService(LigneLocalService service) {
		_service = service;
	}

	private static volatile LigneLocalService _service;

}