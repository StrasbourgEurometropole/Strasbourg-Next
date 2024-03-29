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

package eu.strasbourg.service.edition.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Edition. This utility wraps
 * <code>eu.strasbourg.service.edition.service.impl.EditionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see EditionLocalService
 * @generated
 */
public class EditionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.edition.service.impl.EditionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the edition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was added
	 */
	public static eu.strasbourg.service.edition.model.Edition addEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return getService().addEdition(edition);
	}

	public static void addEditionGalleryEdition(
		long galleryId, eu.strasbourg.service.edition.model.Edition edition) {

		getService().addEditionGalleryEdition(galleryId, edition);
	}

	public static void addEditionGalleryEdition(
		long galleryId, long editionId) {

		getService().addEditionGalleryEdition(galleryId, editionId);
	}

	public static void addEditionGalleryEditions(
		long galleryId,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions) {

		getService().addEditionGalleryEditions(galleryId, editions);
	}

	public static void addEditionGalleryEditions(
		long galleryId, long[] editionIds) {

		getService().addEditionGalleryEditions(galleryId, editionIds);
	}

	/**
	 * Modifie le statut de toutes les editions au statut "SCHEDULED" qui ont
	 * une date de publication dans le futur
	 */
	public static void checkEditions()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkEditions();
	}

	public static void clearEditionGalleryEditions(long galleryId) {
		getService().clearEditionGalleryEditions(galleryId);
	}

	/**
	 * Creates a new edition with the primary key. Does not add the edition to the database.
	 *
	 * @param editionId the primary key for the new edition
	 * @return the new edition
	 */
	public static eu.strasbourg.service.edition.model.Edition createEdition(
		long editionId) {

		return getService().createEdition(editionId);
	}

	/**
	 * Crée une edition vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.edition.model.Edition createEdition(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createEdition(sc);
	}

	/**
	 * Deletes the edition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was removed
	 */
	public static eu.strasbourg.service.edition.model.Edition deleteEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return getService().deleteEdition(edition);
	}

	/**
	 * Deletes the edition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition that was removed
	 * @throws PortalException if a edition with the primary key could not be found
	 */
	public static eu.strasbourg.service.edition.model.Edition deleteEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEdition(editionId);
	}

	public static void deleteEditionGalleryEdition(
		long galleryId, eu.strasbourg.service.edition.model.Edition edition) {

		getService().deleteEditionGalleryEdition(galleryId, edition);
	}

	public static void deleteEditionGalleryEdition(
		long galleryId, long editionId) {

		getService().deleteEditionGalleryEdition(galleryId, editionId);
	}

	public static void deleteEditionGalleryEditions(
		long galleryId,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions) {

		getService().deleteEditionGalleryEditions(galleryId, editions);
	}

	public static void deleteEditionGalleryEditions(
		long galleryId, long[] editionIds) {

		getService().deleteEditionGalleryEditions(galleryId, editionIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
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

	public static eu.strasbourg.service.edition.model.Edition fetchEdition(
		long editionId) {

		return getService().fetchEdition(editionId);
	}

	/**
	 * Returns the edition matching the UUID and group.
	 *
	 * @param uuid the edition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition, or <code>null</code> if a matching edition could not be found
	 */
	public static eu.strasbourg.service.edition.model.Edition
		fetchEditionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEditionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les editions d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Returns the edition with the primary key.
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition
	 * @throws PortalException if a edition with the primary key could not be found
	 */
	public static eu.strasbourg.service.edition.model.Edition getEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEdition(editionId);
	}

	/**
	 * Returns the edition matching the UUID and group.
	 *
	 * @param uuid the edition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition
	 * @throws PortalException if a matching edition could not be found
	 */
	public static eu.strasbourg.service.edition.model.Edition
			getEditionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEditionByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(long galleryId) {

		return getService().getEditionGalleryEditions(galleryId);
	}

	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(long galleryId, int start, int end) {

		return getService().getEditionGalleryEditions(galleryId, start, end);
	}

	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(
			long galleryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.Edition>
					orderByComparator) {

		return getService().getEditionGalleryEditions(
			galleryId, start, end, orderByComparator);
	}

	public static int getEditionGalleryEditionsCount(long galleryId) {
		return getService().getEditionGalleryEditionsCount(galleryId);
	}

	/**
	 * Returns the galleryIds of the edition galleries associated with the edition.
	 *
	 * @param editionId the editionId of the edition
	 * @return long[] the galleryIds of edition galleries associated with the edition
	 */
	public static long[] getEditionGalleryPrimaryKeys(long editionId) {
		return getService().getEditionGalleryPrimaryKeys(editionId);
	}

	/**
	 * Returns a range of all the editions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of editions
	 */
	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditions(int start, int end) {

		return getService().getEditions(start, end);
	}

	/**
	 * Returns all the editions matching the UUID and company.
	 *
	 * @param uuid the UUID of the editions
	 * @param companyId the primary key of the company
	 * @return the matching editions, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEditionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of editions matching the UUID and company.
	 *
	 * @param uuid the UUID of the editions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching editions, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.Edition>
					orderByComparator) {

		return getService().getEditionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of editions.
	 *
	 * @return the number of editions
	 */
	public static int getEditionsCount() {
		return getService().getEditionsCount();
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

	public static boolean hasEditionGalleryEdition(
		long galleryId, long editionId) {

		return getService().hasEditionGalleryEdition(galleryId, editionId);
	}

	public static boolean hasEditionGalleryEditions(long galleryId) {
		return getService().hasEditionGalleryEditions(galleryId);
	}

	/**
	 * Supprime une edition
	 */
	public static eu.strasbourg.service.edition.model.Edition removeEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeEdition(editionId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setEditionGalleryEditions(
		long galleryId, long[] editionIds) {

		getService().setEditionGalleryEditions(galleryId, editionIds);
	}

	/**
	 * Updates the edition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was updated
	 */
	public static eu.strasbourg.service.edition.model.Edition updateEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return getService().updateEdition(edition);
	}

	/**
	 * Met à jour une edition et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.edition.model.Edition updateEdition(
			eu.strasbourg.service.edition.model.Edition edition,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEdition(edition, sc);
	}

	/**
	 * Met à jour le statut de l'edition "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.edition.model.Edition edition, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(edition, status);
	}

	/**
	 * Met à jour le statut de l'edition par le framework workflow
	 */
	public static eu.strasbourg.service.edition.model.Edition updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static EditionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EditionLocalService, EditionLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EditionLocalService.class);

		ServiceTracker<EditionLocalService, EditionLocalService>
			serviceTracker =
				new ServiceTracker<EditionLocalService, EditionLocalService>(
					bundle.getBundleContext(), EditionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}