/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.video.model.VideoGallery;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for VideoGallery. This utility wraps
 * <code>eu.strasbourg.service.video.service.impl.VideoGalleryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see VideoGalleryLocalService
 * @generated
 */
public class VideoGalleryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.video.service.impl.VideoGalleryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the video gallery to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was added
	 */
	public static VideoGallery addVideoGallery(VideoGallery videoGallery) {
		return getService().addVideoGallery(videoGallery);
	}

	public static boolean addVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries) {

		return getService().addVideoVideoGalleries(videoId, videoGalleries);
	}

	public static boolean addVideoVideoGalleries(
		long videoId, long[] galleryIds) {

		return getService().addVideoVideoGalleries(videoId, galleryIds);
	}

	public static boolean addVideoVideoGallery(long videoId, long galleryId) {
		return getService().addVideoVideoGallery(videoId, galleryId);
	}

	public static boolean addVideoVideoGallery(
		long videoId, VideoGallery videoGallery) {

		return getService().addVideoVideoGallery(videoId, videoGallery);
	}

	/**
	 * Modifie le statut de toutes les vidéos au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur
	 */
	public static void checkGalleries() throws PortalException {
		getService().checkGalleries();
	}

	public static void clearVideoVideoGalleries(long videoId) {
		getService().clearVideoVideoGalleries(videoId);
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
	 * Creates a new video gallery with the primary key. Does not add the video gallery to the database.
	 *
	 * @param galleryId the primary key for the new video gallery
	 * @return the new video gallery
	 */
	public static VideoGallery createVideoGallery(long galleryId) {
		return getService().createVideoGallery(galleryId);
	}

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public static VideoGallery createVideoGallery(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createVideoGallery(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the video gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param galleryId the primary key of the video gallery
	 * @return the video gallery that was removed
	 * @throws PortalException if a video gallery with the primary key could not be found
	 */
	public static VideoGallery deleteVideoGallery(long galleryId)
		throws PortalException {

		return getService().deleteVideoGallery(galleryId);
	}

	/**
	 * Deletes the video gallery from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was removed
	 */
	public static VideoGallery deleteVideoGallery(VideoGallery videoGallery) {
		return getService().deleteVideoGallery(videoGallery);
	}

	public static void deleteVideoVideoGalleries(
		long videoId, List<VideoGallery> videoGalleries) {

		getService().deleteVideoVideoGalleries(videoId, videoGalleries);
	}

	public static void deleteVideoVideoGalleries(
		long videoId, long[] galleryIds) {

		getService().deleteVideoVideoGalleries(videoId, galleryIds);
	}

	public static void deleteVideoVideoGallery(long videoId, long galleryId) {
		getService().deleteVideoVideoGallery(videoId, galleryId);
	}

	public static void deleteVideoVideoGallery(
		long videoId, VideoGallery videoGallery) {

		getService().deleteVideoVideoGallery(videoId, videoGallery);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
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

	public static VideoGallery fetchVideoGallery(long galleryId) {
		return getService().fetchVideoGallery(galleryId);
	}

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery, or <code>null</code> if a matching video gallery could not be found
	 */
	public static VideoGallery fetchVideoGalleryByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchVideoGalleryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mots clés
	 */
	public static List<VideoGallery> findByKeyword(
		String keyword, long groupId, int start, int end) {

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
	 * Retourne la liste des vocabulaires rattachés à l'entité
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les galeries éditions d'un groupe
	 */
	public static List<VideoGallery> getByGroupId(long groupId) {
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

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the video galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of video galleries
	 * @param end the upper bound of the range of video galleries (not inclusive)
	 * @return the range of video galleries
	 */
	public static List<VideoGallery> getVideoGalleries(int start, int end) {
		return getService().getVideoGalleries(start, end);
	}

	/**
	 * Returns all the video galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the video galleries
	 * @param companyId the primary key of the company
	 * @return the matching video galleries, or an empty list if no matches were found
	 */
	public static List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getVideoGalleriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of video galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the video galleries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of video galleries
	 * @param end the upper bound of the range of video galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching video galleries, or an empty list if no matches were found
	 */
	public static List<VideoGallery> getVideoGalleriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator) {

		return getService().getVideoGalleriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of video galleries.
	 *
	 * @return the number of video galleries
	 */
	public static int getVideoGalleriesCount() {
		return getService().getVideoGalleriesCount();
	}

	/**
	 * Returns the video gallery with the primary key.
	 *
	 * @param galleryId the primary key of the video gallery
	 * @return the video gallery
	 * @throws PortalException if a video gallery with the primary key could not be found
	 */
	public static VideoGallery getVideoGallery(long galleryId)
		throws PortalException {

		return getService().getVideoGallery(galleryId);
	}

	/**
	 * Returns the video gallery matching the UUID and group.
	 *
	 * @param uuid the video gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video gallery
	 * @throws PortalException if a matching video gallery could not be found
	 */
	public static VideoGallery getVideoGalleryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getVideoGalleryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the videoIds of the videos associated with the video gallery.
	 *
	 * @param galleryId the galleryId of the video gallery
	 * @return long[] the videoIds of videos associated with the video gallery
	 */
	public static long[] getVideoPrimaryKeys(long galleryId) {
		return getService().getVideoPrimaryKeys(galleryId);
	}

	public static List<VideoGallery> getVideoVideoGalleries(long videoId) {
		return getService().getVideoVideoGalleries(videoId);
	}

	public static List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end) {

		return getService().getVideoVideoGalleries(videoId, start, end);
	}

	public static List<VideoGallery> getVideoVideoGalleries(
		long videoId, int start, int end,
		OrderByComparator<VideoGallery> orderByComparator) {

		return getService().getVideoVideoGalleries(
			videoId, start, end, orderByComparator);
	}

	public static int getVideoVideoGalleriesCount(long videoId) {
		return getService().getVideoVideoGalleriesCount(videoId);
	}

	public static boolean hasVideoVideoGalleries(long videoId) {
		return getService().hasVideoVideoGalleries(videoId);
	}

	public static boolean hasVideoVideoGallery(long videoId, long galleryId) {
		return getService().hasVideoVideoGallery(videoId, galleryId);
	}

	/**
	 * Delete an Video Gallery
	 *
	 * @param galleryId
	 The ID of the video gallery to delete
	 * @return The deleted VideoGallery
	 * @throws PortalException
	 */
	public static VideoGallery removeGallery(long galleryId)
		throws PortalException {

		return getService().removeGallery(galleryId);
	}

	/**
	 * Recherche par le moteur de recherche
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setVideoVideoGalleries(long videoId, long[] galleryIds) {
		getService().setVideoVideoGalleries(videoId, galleryIds);
	}

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public static VideoGallery updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(VideoGallery gallery, int status)
		throws PortalException {

		getService().updateStatus(gallery, status);
	}

	/**
	 * Updates the video gallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoGallery the video gallery
	 * @return the video gallery that was updated
	 */
	public static VideoGallery updateVideoGallery(VideoGallery videoGallery) {
		return getService().updateVideoGallery(videoGallery);
	}

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public static VideoGallery updateVideoGallery(
			VideoGallery gallery,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateVideoGallery(gallery, sc);
	}

	public static VideoGalleryLocalService getService() {
		return _service;
	}

	public static void setService(VideoGalleryLocalService service) {
		_service = service;
	}

	private static volatile VideoGalleryLocalService _service;

}