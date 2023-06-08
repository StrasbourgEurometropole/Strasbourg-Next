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
 * Provides the local service utility for EditionGallery. This utility wraps
 * <code>eu.strasbourg.service.edition.service.impl.EditionGalleryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see EditionGalleryLocalService
 * @generated
 */
public class EditionGalleryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.edition.service.impl.EditionGalleryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addEditionEditionGalleries(
		long editionId,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries) {

		getService().addEditionEditionGalleries(editionId, editionGalleries);
	}

	public static void addEditionEditionGalleries(
		long editionId, long[] galleryIds) {

		getService().addEditionEditionGalleries(editionId, galleryIds);
	}

	public static void addEditionEditionGallery(
		long editionId,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		getService().addEditionEditionGallery(editionId, editionGallery);
	}

	public static void addEditionEditionGallery(
		long editionId, long galleryId) {

		getService().addEditionEditionGallery(editionId, galleryId);
	}

	/**
	 * Adds the edition gallery to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was added
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
		addEditionGallery(
			eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return getService().addEditionGallery(editionGallery);
	}

	/**
	 * Modifie le statut de toutes les galeries au statut "SCHEDULED" qui ont
	 * une date de publication dans le futur
	 */
	public static void checkGalleries()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkGalleries();
	}

	public static void clearEditionEditionGalleries(long editionId) {
		getService().clearEditionEditionGalleries(editionId);
	}

	/**
	 * Creates a new edition gallery with the primary key. Does not add the edition gallery to the database.
	 *
	 * @param galleryId the primary key for the new edition gallery
	 * @return the new edition gallery
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
		createEditionGallery(long galleryId) {

		return getService().createEditionGallery(galleryId);
	}

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			createEditionGallery(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createEditionGallery(sc);
	}

	public static void deleteEditionEditionGalleries(
		long editionId,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries) {

		getService().deleteEditionEditionGalleries(editionId, editionGalleries);
	}

	public static void deleteEditionEditionGalleries(
		long editionId, long[] galleryIds) {

		getService().deleteEditionEditionGalleries(editionId, galleryIds);
	}

	public static void deleteEditionEditionGallery(
		long editionId,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		getService().deleteEditionEditionGallery(editionId, editionGallery);
	}

	public static void deleteEditionEditionGallery(
		long editionId, long galleryId) {

		getService().deleteEditionEditionGallery(editionId, galleryId);
	}

	/**
	 * Deletes the edition gallery from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was removed
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
		deleteEditionGallery(
			eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return getService().deleteEditionGallery(editionGallery);
	}

	/**
	 * Deletes the edition gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery that was removed
	 * @throws PortalException if a edition gallery with the primary key could not be found
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			deleteEditionGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteEditionGallery(galleryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
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

	public static eu.strasbourg.service.edition.model.EditionGallery
		fetchEditionGallery(long galleryId) {

		return getService().fetchEditionGallery(galleryId);
	}

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
		fetchEditionGalleryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchEditionGalleryByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery> findByKeyword(
			String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

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
	 * Retourne toutes les galeries editions d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery> getByGroupId(
			long groupId) {

		return getService().getByGroupId(groupId);
	}

	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionEditionGalleries(long editionId) {

		return getService().getEditionEditionGalleries(editionId);
	}

	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionEditionGalleries(long editionId, int start, int end) {

		return getService().getEditionEditionGalleries(editionId, start, end);
	}

	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionEditionGalleries(
				long editionId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.edition.model.EditionGallery>
						orderByComparator) {

		return getService().getEditionEditionGalleries(
			editionId, start, end, orderByComparator);
	}

	public static int getEditionEditionGalleriesCount(long editionId) {
		return getService().getEditionEditionGalleriesCount(editionId);
	}

	/**
	 * Returns a range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of edition galleries
	 */
	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionGalleries(int start, int end) {

		return getService().getEditionGalleries(start, end);
	}

	/**
	 * Returns all the edition galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the edition galleries
	 * @param companyId the primary key of the company
	 * @return the matching edition galleries, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionGalleriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getEditionGalleriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of edition galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the edition galleries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching edition galleries, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.edition.model.EditionGallery>
			getEditionGalleriesByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.edition.model.EditionGallery>
						orderByComparator) {

		return getService().getEditionGalleriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of edition galleries.
	 *
	 * @return the number of edition galleries
	 */
	public static int getEditionGalleriesCount() {
		return getService().getEditionGalleriesCount();
	}

	/**
	 * Returns the edition gallery with the primary key.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery
	 * @throws PortalException if a edition gallery with the primary key could not be found
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			getEditionGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEditionGallery(galleryId);
	}

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery
	 * @throws PortalException if a matching edition gallery could not be found
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			getEditionGalleryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getEditionGalleryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the editionIds of the editions associated with the edition gallery.
	 *
	 * @param galleryId the galleryId of the edition gallery
	 * @return long[] the editionIds of editions associated with the edition gallery
	 */
	public static long[] getEditionPrimaryKeys(long galleryId) {
		return getService().getEditionPrimaryKeys(galleryId);
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

	public static boolean hasEditionEditionGalleries(long editionId) {
		return getService().hasEditionEditionGalleries(editionId);
	}

	public static boolean hasEditionEditionGallery(
		long editionId, long galleryId) {

		return getService().hasEditionEditionGallery(editionId, galleryId);
	}

	/**
	 * Supprime une galerie
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			removeGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeGallery(galleryId);
	}

	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setEditionEditionGalleries(
		long editionId, long[] galleryIds) {

		getService().setEditionEditionGalleries(editionId, galleryIds);
	}

	/**
	 * Updates the edition gallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was updated
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
		updateEditionGallery(
			eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return getService().updateEditionGallery(editionGallery);
	}

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			updateEditionGallery(
				eu.strasbourg.service.edition.model.EditionGallery gallery,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEditionGallery(gallery, sc);
	}

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.edition.model.EditionGallery gallery,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(gallery, status);
	}

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public static eu.strasbourg.service.edition.model.EditionGallery
			updateStatus(
				long userId, long entryId, int status,
				com.liferay.portal.kernel.service.ServiceContext sc,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static EditionGalleryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<EditionGalleryLocalService, EditionGalleryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			EditionGalleryLocalService.class);

		ServiceTracker<EditionGalleryLocalService, EditionGalleryLocalService>
			serviceTracker =
				new ServiceTracker
					<EditionGalleryLocalService, EditionGalleryLocalService>(
						bundle.getBundleContext(),
						EditionGalleryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}