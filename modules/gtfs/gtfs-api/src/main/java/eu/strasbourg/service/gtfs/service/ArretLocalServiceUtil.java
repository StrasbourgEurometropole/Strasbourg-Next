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

import eu.strasbourg.service.gtfs.model.Arret;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Arret. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.ArretLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see ArretLocalService
 * @generated
 */
public class ArretLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.ArretLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the arret to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was added
	 */
	public static Arret addArret(Arret arret) {
		return getService().addArret(arret);
	}

	/**
	 * Creates a new arret with the primary key. Does not add the arret to the database.
	 *
	 * @param arretId the primary key for the new arret
	 * @return the new arret
	 */
	public static Arret createArret(long arretId) {
		return getService().createArret(arretId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public static Arret createArret(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createArret(sc);
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
	 * Deletes the arret from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was removed
	 */
	public static Arret deleteArret(Arret arret) {
		return getService().deleteArret(arret);
	}

	/**
	 * Deletes the arret with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret that was removed
	 * @throws PortalException if a arret with the primary key could not be found
	 */
	public static Arret deleteArret(long arretId) throws PortalException {
		return getService().deleteArret(arretId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
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

	public static Arret fetchArret(long arretId) {
		return getService().fetchArret(arretId);
	}

	/**
	 * Returns the arret matching the UUID and group.
	 *
	 * @param uuid the arret's UUID
	 * @param groupId the primary key of the group
	 * @return the matching arret, or <code>null</code> if a matching arret could not be found
	 */
	public static Arret fetchArretByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchArretByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche des Arrets par identifiants
	 *
	 * @param idsArrets: list des identifiants
	 * @return
	 */
	public static List<Arret> findByIds(List<Long> idsArrets) {
		return getService().findByIds(idsArrets);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Arret> findByKeyword(
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
	 * Retourne la liste de tous les arrets
	 */
	public static Map<String, Arret> getAll() {
		return getService().getAll();
	}

	/**
	 * Returns the arret with the primary key.
	 *
	 * @param arretId the primary key of the arret
	 * @return the arret
	 * @throws PortalException if a arret with the primary key could not be found
	 */
	public static Arret getArret(long arretId) throws PortalException {
		return getService().getArret(arretId);
	}

	/**
	 * Returns the arret matching the UUID and group.
	 *
	 * @param uuid the arret's UUID
	 * @param groupId the primary key of the group
	 * @return the matching arret
	 * @throws PortalException if a matching arret could not be found
	 */
	public static Arret getArretByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getArretByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the arrets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.ArretModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @return the range of arrets
	 */
	public static List<Arret> getArrets(int start, int end) {
		return getService().getArrets(start, end);
	}

	/**
	 * Returns all the arrets matching the UUID and company.
	 *
	 * @param uuid the UUID of the arrets
	 * @param companyId the primary key of the company
	 * @return the matching arrets, or an empty list if no matches were found
	 */
	public static List<Arret> getArretsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getArretsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of arrets matching the UUID and company.
	 *
	 * @param uuid the UUID of the arrets
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of arrets
	 * @param end the upper bound of the range of arrets (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching arrets, or an empty list if no matches were found
	 */
	public static List<Arret> getArretsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Arret> orderByComparator) {

		return getService().getArretsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of arrets.
	 *
	 * @return the number of arrets
	 */
	public static int getArretsCount() {
		return getService().getArretsCount();
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
	public static List<Arret> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne tous les arret avec un status choisi
	 */
	public static List<Arret> getByStatus(int status) {
		return getService().getByStatus(status);
	}

	/**
	 * Retourne les arrets via le stopCode
	 */
	public static List<Arret> getByStopCode(String stopCode) {
		return getService().getByStopCode(stopCode);
	}

	/**
	 * Retourne un arret via son stopId CTS
	 */
	public static Arret getByStopId(String stopId) {
		return getService().getByStopId(stopId);
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
	 * Supprime l'entree
	 */
	public static Arret removeArret(long arretId) throws PortalException {
		return getService().removeArret(arretId);
	}

	/**
	 * Supprime les entrees
	 */
	public static void removeArrets(
			List<Arret> arrets,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().removeArrets(arrets, sc);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow) des entrees
	 */
	public static void unpublishArrets(
			List<Arret> arrets,
			eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().unpublishArrets(arrets, importHistoric, sc);
	}

	/**
	 * Updates the arret in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ArretLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param arret the arret
	 * @return the arret that was updated
	 */
	public static Arret updateArret(Arret arret) {
		return getService().updateArret(arret);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Arret updateArret(
			Arret arret, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateArret(arret, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public static void updateArrets(
			List<Arret> arrets,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().updateArrets(arrets, sc);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Arret arret, int status)
		throws PortalException {

		getService().updateStatus(arret, status);
	}

	/**
	 * Met à jour le statut de l'entree par le framework workflow
	 */
	public static Arret updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static ArretLocalService getService() {
		return _service;
	}

	public static void setService(ArretLocalService service) {
		_service = service;
	}

	private static volatile ArretLocalService _service;

}