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

package eu.strasbourg.service.gtfs.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
	public static eu.strasbourg.service.gtfs.model.Ligne addLigne(
		eu.strasbourg.service.gtfs.model.Ligne ligne) {

		return getService().addLigne(ligne);
	}

	/**
	 * Creates a new ligne with the primary key. Does not add the ligne to the database.
	 *
	 * @param ligneId the primary key for the new ligne
	 * @return the new ligne
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne createLigne(
		long ligneId) {

		return getService().createLigne(ligneId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne createLigne(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createLigne(sc);
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
	public static eu.strasbourg.service.gtfs.model.Ligne deleteLigne(
		eu.strasbourg.service.gtfs.model.Ligne ligne) {

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
	public static eu.strasbourg.service.gtfs.model.Ligne deleteLigne(
			long ligneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLigne(ligneId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.LigneModelImpl</code>.
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

	public static eu.strasbourg.service.gtfs.model.Ligne fetchLigne(
		long ligneId) {

		return getService().fetchLigne(ligneId);
	}

	/**
	 * Returns the ligne matching the UUID and group.
	 *
	 * @param uuid the ligne's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ligne, or <code>null</code> if a matching ligne could not be found
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne
		fetchLigneByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchLigneByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		findByKeyword(String keyword, long groupId, int start, int end) {

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
	public static java.util.Map<String, eu.strasbourg.service.gtfs.model.Ligne>
		getAll() {

		return getService().getAll();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entree
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne une ligne via son routeId CTS
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne getByRouteId(
		String routeId) {

		return getService().getByRouteId(routeId);
	}

	/**
	 * Retourne les lignes qui possedent les memes donnees
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getByShortNameAndStatus(String shortName, int status) {

		return getService().getByShortNameAndStatus(shortName, status);
	}

	/**
	 * Retourne toutes les lignes avec un status choisi
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getByStatus(int status) {

		return getService().getByStatus(status);
	}

	/**
	 * Retourne toutes les lignes avec un status choisi par modifiedDate
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getByStatusOrderedByModifiedDate(int status) {

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
	public static eu.strasbourg.service.gtfs.model.Ligne getLigne(long ligneId)
		throws com.liferay.portal.kernel.exception.PortalException {

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
	public static eu.strasbourg.service.gtfs.model.Ligne
			getLigneByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

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
	public static java.util.Map<String, String[]> getLigneColorsFreemarker() {
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
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getLignes(int start, int end) {

		return getService().getLignes(start, end);
	}

	/**
	 * Returns all the lignes matching the UUID and company.
	 *
	 * @param uuid the UUID of the lignes
	 * @param companyId the primary key of the company
	 * @return the matching lignes, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getLignesByUuidAndCompanyId(String uuid, long companyId) {

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
	public static java.util.List<eu.strasbourg.service.gtfs.model.Ligne>
		getLignesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.gtfs.model.Ligne> orderByComparator) {

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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime l'entree
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne removeLigne(
			long ligneId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeLigne(ligneId);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow) des entrees
	 */
	public static void unpublishLignes(
			java.util.List<eu.strasbourg.service.gtfs.model.Ligne> lignes,
			eu.strasbourg.service.gtfs.model.ImportHistoric importHistoric,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

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
	public static eu.strasbourg.service.gtfs.model.Ligne updateLigne(
		eu.strasbourg.service.gtfs.model.Ligne ligne) {

		return getService().updateLigne(ligne);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne updateLigne(
			eu.strasbourg.service.gtfs.model.Ligne ligne,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateLigne(ligne, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public static void updateLignes(
			java.util.List<eu.strasbourg.service.gtfs.model.Ligne> lignes,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateLignes(lignes, sc);
	}

	/**
	 * Met à jour le statut "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.gtfs.model.Ligne ligne, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(ligne, status);
	}

	/**
	 * Met à jour le statut de l'entree par le framework workflow
	 */
	public static eu.strasbourg.service.gtfs.model.Ligne updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static LigneLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LigneLocalService, LigneLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LigneLocalService.class);

		ServiceTracker<LigneLocalService, LigneLocalService> serviceTracker =
			new ServiceTracker<LigneLocalService, LigneLocalService>(
				bundle.getBundleContext(), LigneLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}