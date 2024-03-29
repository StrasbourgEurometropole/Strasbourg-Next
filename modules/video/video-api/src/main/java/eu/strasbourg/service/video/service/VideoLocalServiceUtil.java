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

package eu.strasbourg.service.video.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Video. This utility wraps
 * <code>eu.strasbourg.service.video.service.impl.VideoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see VideoLocalService
 * @generated
 */
public class VideoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.video.service.impl.VideoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the video to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was added
	 */
	public static eu.strasbourg.service.video.model.Video addVideo(
		eu.strasbourg.service.video.model.Video video) {

		return getService().addVideo(video);
	}

	public static void addVideoGalleryVideo(long galleryId, long videoId) {
		getService().addVideoGalleryVideo(galleryId, videoId);
	}

	public static void addVideoGalleryVideo(
		long galleryId, eu.strasbourg.service.video.model.Video video) {

		getService().addVideoGalleryVideo(galleryId, video);
	}

	public static void addVideoGalleryVideos(
		long galleryId,
		java.util.List<eu.strasbourg.service.video.model.Video> videos) {

		getService().addVideoGalleryVideos(galleryId, videos);
	}

	public static void addVideoGalleryVideos(long galleryId, long[] videoIds) {
		getService().addVideoGalleryVideos(galleryId, videoIds);
	}

	/**
	 * Modifie le statut de toutes les vidéos au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur
	 */
	public static void checkVideos()
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().checkVideos();
	}

	public static void clearVideoGalleryVideos(long galleryId) {
		getService().clearVideoGalleryVideos(galleryId);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	public static eu.strasbourg.service.video.model.Video createVideo(
		long videoId) {

		return getService().createVideo(videoId);
	}

	/**
	 * Crée une vidéo vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.video.model.Video createVideo(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createVideo(sc);
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

	/**
	 * Deletes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param videoId the primary key of the video
	 * @return the video that was removed
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static eu.strasbourg.service.video.model.Video deleteVideo(
			long videoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteVideo(videoId);
	}

	/**
	 * Deletes the video from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was removed
	 */
	public static eu.strasbourg.service.video.model.Video deleteVideo(
		eu.strasbourg.service.video.model.Video video) {

		return getService().deleteVideo(video);
	}

	public static void deleteVideoGalleryVideo(long galleryId, long videoId) {
		getService().deleteVideoGalleryVideo(galleryId, videoId);
	}

	public static void deleteVideoGalleryVideo(
		long galleryId, eu.strasbourg.service.video.model.Video video) {

		getService().deleteVideoGalleryVideo(galleryId, video);
	}

	public static void deleteVideoGalleryVideos(
		long galleryId,
		java.util.List<eu.strasbourg.service.video.model.Video> videos) {

		getService().deleteVideoGalleryVideos(galleryId, videos);
	}

	public static void deleteVideoGalleryVideos(
		long galleryId, long[] videoIds) {

		getService().deleteVideoGalleryVideos(galleryId, videoIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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

	public static eu.strasbourg.service.video.model.Video fetchVideo(
		long videoId) {

		return getService().fetchVideo(videoId);
	}

	/**
	 * Returns the video matching the UUID and group.
	 *
	 * @param uuid the video's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video, or <code>null</code> if a matching video could not be found
	 */
	public static eu.strasbourg.service.video.model.Video
		fetchVideoByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchVideoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static java.util.List<eu.strasbourg.service.video.model.Video>
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
	 * Retourne la liste des vocabulaires rattachés à l'entité
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les vidéos d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.video.model.Video>
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

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the video with the primary key.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static eu.strasbourg.service.video.model.Video getVideo(long videoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideo(videoId);
	}

	/**
	 * Returns the video matching the UUID and group.
	 *
	 * @param uuid the video's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video
	 * @throws PortalException if a matching video could not be found
	 */
	public static eu.strasbourg.service.video.model.Video
			getVideoByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getVideoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the galleryIds of the video galleries associated with the video.
	 *
	 * @param videoId the videoId of the video
	 * @return long[] the galleryIds of video galleries associated with the video
	 */
	public static long[] getVideoGalleryPrimaryKeys(long videoId) {
		return getService().getVideoGalleryPrimaryKeys(videoId);
	}

	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideoGalleryVideos(long galleryId) {

		return getService().getVideoGalleryVideos(galleryId);
	}

	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideoGalleryVideos(long galleryId, int start, int end) {

		return getService().getVideoGalleryVideos(galleryId, start, end);
	}

	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideoGalleryVideos(
			long galleryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.video.model.Video> orderByComparator) {

		return getService().getVideoGalleryVideos(
			galleryId, start, end, orderByComparator);
	}

	public static int getVideoGalleryVideosCount(long galleryId) {
		return getService().getVideoGalleryVideosCount(galleryId);
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideos(int start, int end) {

		return getService().getVideos(start, end);
	}

	/**
	 * Returns all the videos matching the UUID and company.
	 *
	 * @param uuid the UUID of the videos
	 * @param companyId the primary key of the company
	 * @return the matching videos, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideosByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getVideosByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of videos matching the UUID and company.
	 *
	 * @param uuid the UUID of the videos
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching videos, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.video.model.Video>
		getVideosByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.video.model.Video> orderByComparator) {

		return getService().getVideosByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public static int getVideosCount() {
		return getService().getVideosCount();
	}

	public static boolean hasVideoGalleryVideo(long galleryId, long videoId) {
		return getService().hasVideoGalleryVideo(galleryId, videoId);
	}

	public static boolean hasVideoGalleryVideos(long galleryId) {
		return getService().hasVideoGalleryVideos(galleryId);
	}

	/**
	 * Supprime une vidéo
	 */
	public static eu.strasbourg.service.video.model.Video removeVideo(
			long videoId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeVideo(videoId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setVideoGalleryVideos(long galleryId, long[] videoIds) {
		getService().setVideoGalleryVideos(galleryId, videoIds);
	}

	/**
	 * Met à jour le statut de la vidéo par le framework workflow
	 */
	public static eu.strasbourg.service.video.model.Video updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de la vidéo "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.video.model.Video video, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(video, status);
	}

	/**
	 * Updates the video in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VideoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param video the video
	 * @return the video that was updated
	 */
	public static eu.strasbourg.service.video.model.Video updateVideo(
		eu.strasbourg.service.video.model.Video video) {

		return getService().updateVideo(video);
	}

	/**
	 * Met à jour une vidéo et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.video.model.Video updateVideo(
			eu.strasbourg.service.video.model.Video video,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateVideo(video, sc);
	}

	public static VideoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<VideoLocalService, VideoLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(VideoLocalService.class);

		ServiceTracker<VideoLocalService, VideoLocalService> serviceTracker =
			new ServiceTracker<VideoLocalService, VideoLocalService>(
				bundle.getBundleContext(), VideoLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}