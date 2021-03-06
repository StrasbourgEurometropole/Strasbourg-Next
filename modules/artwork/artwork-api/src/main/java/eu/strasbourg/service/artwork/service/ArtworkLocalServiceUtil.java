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

package eu.strasbourg.service.artwork.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Artwork. This utility wraps
 * <code>eu.strasbourg.service.artwork.service.impl.ArtworkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see ArtworkLocalService
 * @generated
 */
@ProviderType
public class ArtworkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.artwork.service.impl.ArtworkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the artwork to the database. Also notifies the appropriate model listeners.
	 *
	 * @param artwork the artwork
	 * @return the artwork that was added
	 */
	public static eu.strasbourg.service.artwork.model.Artwork addArtwork(
		eu.strasbourg.service.artwork.model.Artwork artwork) {

		return getService().addArtwork(artwork);
	}

	public static void addArtworkCollectionArtwork(
		long collectionId,
		eu.strasbourg.service.artwork.model.Artwork artwork) {

		getService().addArtworkCollectionArtwork(collectionId, artwork);
	}

	public static void addArtworkCollectionArtwork(
		long collectionId, long artworkId) {

		getService().addArtworkCollectionArtwork(collectionId, artworkId);
	}

	public static void addArtworkCollectionArtworks(
		long collectionId,
		java.util.List<eu.strasbourg.service.artwork.model.Artwork> artworks) {

		getService().addArtworkCollectionArtworks(collectionId, artworks);
	}

	public static void addArtworkCollectionArtworks(
		long collectionId, long[] artworkIds) {

		getService().addArtworkCollectionArtworks(collectionId, artworkIds);
	}

	public static void clearArtworkCollectionArtworks(long collectionId) {
		getService().clearArtworkCollectionArtworks(collectionId);
	}

	/**
	 * Creates a new artwork with the primary key. Does not add the artwork to the database.
	 *
	 * @param artworkId the primary key for the new artwork
	 * @return the new artwork
	 */
	public static eu.strasbourg.service.artwork.model.Artwork createArtwork(
		long artworkId) {

		return getService().createArtwork(artworkId);
	}

	/**
	 * Crée une édition vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.artwork.model.Artwork createArtwork(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createArtwork(sc);
	}

	/**
	 * Deletes the artwork from the database. Also notifies the appropriate model listeners.
	 *
	 * @param artwork the artwork
	 * @return the artwork that was removed
	 */
	public static eu.strasbourg.service.artwork.model.Artwork deleteArtwork(
		eu.strasbourg.service.artwork.model.Artwork artwork) {

		return getService().deleteArtwork(artwork);
	}

	/**
	 * Deletes the artwork with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param artworkId the primary key of the artwork
	 * @return the artwork that was removed
	 * @throws PortalException if a artwork with the primary key could not be found
	 */
	public static eu.strasbourg.service.artwork.model.Artwork deleteArtwork(
			long artworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteArtwork(artworkId);
	}

	public static void deleteArtworkCollectionArtwork(
		long collectionId,
		eu.strasbourg.service.artwork.model.Artwork artwork) {

		getService().deleteArtworkCollectionArtwork(collectionId, artwork);
	}

	public static void deleteArtworkCollectionArtwork(
		long collectionId, long artworkId) {

		getService().deleteArtworkCollectionArtwork(collectionId, artworkId);
	}

	public static void deleteArtworkCollectionArtworks(
		long collectionId,
		java.util.List<eu.strasbourg.service.artwork.model.Artwork> artworks) {

		getService().deleteArtworkCollectionArtworks(collectionId, artworks);
	}

	public static void deleteArtworkCollectionArtworks(
		long collectionId, long[] artworkIds) {

		getService().deleteArtworkCollectionArtworks(collectionId, artworkIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static eu.strasbourg.service.artwork.model.Artwork fetchArtwork(
		long artworkId) {

		return getService().fetchArtwork(artworkId);
	}

	/**
	 * Returns the artwork matching the UUID and group.
	 *
	 * @param uuid the artwork's UUID
	 * @param groupId the primary key of the group
	 * @return the matching artwork, or <code>null</code> if a matching artwork could not be found
	 */
	public static eu.strasbourg.service.artwork.model.Artwork
		fetchArtworkByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchArtworkByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		findByKeyword(String keyword, long groupId, int start, int end) {

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
	 * Returns the artwork with the primary key.
	 *
	 * @param artworkId the primary key of the artwork
	 * @return the artwork
	 * @throws PortalException if a artwork with the primary key could not be found
	 */
	public static eu.strasbourg.service.artwork.model.Artwork getArtwork(
			long artworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArtwork(artworkId);
	}

	/**
	 * Returns the artwork matching the UUID and group.
	 *
	 * @param uuid the artwork's UUID
	 * @param groupId the primary key of the group
	 * @return the matching artwork
	 * @throws PortalException if a matching artwork could not be found
	 */
	public static eu.strasbourg.service.artwork.model.Artwork
			getArtworkByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getArtworkByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworkCollectionArtworks(long collectionId) {

		return getService().getArtworkCollectionArtworks(collectionId);
	}

	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworkCollectionArtworks(long collectionId, int start, int end) {

		return getService().getArtworkCollectionArtworks(
			collectionId, start, end);
	}

	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworkCollectionArtworks(
			long collectionId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.artwork.model.Artwork>
					orderByComparator) {

		return getService().getArtworkCollectionArtworks(
			collectionId, start, end, orderByComparator);
	}

	public static int getArtworkCollectionArtworksCount(long collectionId) {
		return getService().getArtworkCollectionArtworksCount(collectionId);
	}

	/**
	 * Returns the collectionIds of the artwork collections associated with the artwork.
	 *
	 * @param artworkId the artworkId of the artwork
	 * @return long[] the collectionIds of artwork collections associated with the artwork
	 */
	public static long[] getArtworkCollectionPrimaryKeys(long artworkId) {
		return getService().getArtworkCollectionPrimaryKeys(artworkId);
	}

	/**
	 * Returns a range of all the artworks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.artwork.model.impl.ArtworkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of artworks
	 * @param end the upper bound of the range of artworks (not inclusive)
	 * @return the range of artworks
	 */
	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworks(int start, int end) {

		return getService().getArtworks(start, end);
	}

	/**
	 * Returns all the artworks matching the UUID and company.
	 *
	 * @param uuid the UUID of the artworks
	 * @param companyId the primary key of the company
	 * @return the matching artworks, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworksByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getArtworksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of artworks matching the UUID and company.
	 *
	 * @param uuid the UUID of the artworks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of artworks
	 * @param end the upper bound of the range of artworks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching artworks, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getArtworksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.artwork.model.Artwork>
					orderByComparator) {

		return getService().getArtworksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of artworks.
	 *
	 * @return the number of artworks
	 */
	public static int getArtworksCount() {
		return getService().getArtworksCount();
	}

	/**
	 * Return the vocabularies attached to the Artwork entity
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les oeuvres d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.artwork.model.Artwork>
		getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasArtworkCollectionArtwork(
		long collectionId, long artworkId) {

		return getService().hasArtworkCollectionArtwork(
			collectionId, artworkId);
	}

	public static boolean hasArtworkCollectionArtworks(long collectionId) {
		return getService().hasArtworkCollectionArtworks(collectionId);
	}

	/**
	 * Delete an artwork
	 */
	public static eu.strasbourg.service.artwork.model.Artwork removeArtwork(
			long artworkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeArtwork(artworkId);
	}

	/**
	 * Search
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setArtworkCollectionArtworks(
		long collectionId, long[] artworkIds) {

		getService().setArtworkCollectionArtworks(collectionId, artworkIds);
	}

	/**
	 * Updates the artwork in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param artwork the artwork
	 * @return the artwork that was updated
	 */
	public static eu.strasbourg.service.artwork.model.Artwork updateArtwork(
		eu.strasbourg.service.artwork.model.Artwork artwork) {

		return getService().updateArtwork(artwork);
	}

	/**
	 * Met à jour une édition et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.artwork.model.Artwork updateArtwork(
			eu.strasbourg.service.artwork.model.Artwork artwork,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateArtwork(artwork, sc);
	}

	/**
	 * Met à jour le statut de l'oeuvre "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.artwork.model.Artwork artwork, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(artwork, status);
	}

	/**
	 * Met à jour le statut de l'oeuvre par le framework workflow
	 */
	public static eu.strasbourg.service.artwork.model.Artwork updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static ArtworkLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArtworkLocalService, ArtworkLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArtworkLocalService.class);

		ServiceTracker<ArtworkLocalService, ArtworkLocalService>
			serviceTracker =
				new ServiceTracker<ArtworkLocalService, ArtworkLocalService>(
					bundle.getBundleContext(), ArtworkLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}