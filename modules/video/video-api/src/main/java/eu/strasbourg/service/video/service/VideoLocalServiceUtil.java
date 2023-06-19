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

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.video.model.Video;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

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
	public static Video addVideo(Video video) {
		return getService().addVideo(video);
	}

	public static void addVideoGalleryVideo(long galleryId, long videoId) {
		getService().addVideoGalleryVideo(galleryId, videoId);
	}

	public static void addVideoGalleryVideo(long galleryId, Video video) {
		getService().addVideoGalleryVideo(galleryId, video);
	}

	public static void addVideoGalleryVideos(
		long galleryId, List<Video> videos) {

		getService().addVideoGalleryVideos(galleryId, videos);
	}

	public static void addVideoGalleryVideos(long galleryId, long[] videoIds) {
		getService().addVideoGalleryVideos(galleryId, videoIds);
	}

	/**
	 * Modifie le statut de toutes les vidéos au statut "SCHEDULED" qui ont une
	 * date de publication dans le futur
	 */
	public static void checkVideos() throws PortalException {
		getService().checkVideos();
	}

	public static void clearVideoGalleryVideos(long galleryId) {
		getService().clearVideoGalleryVideos(galleryId);
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
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param videoId the primary key for the new video
	 * @return the new video
	 */
	public static Video createVideo(long videoId) {
		return getService().createVideo(videoId);
	}

	/**
	 * Crée une vidéo vide avec une PK, non ajouté à la base de donnée
	 */
	public static Video createVideo(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createVideo(sc);
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
	public static Video deleteVideo(long videoId) throws PortalException {
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
	public static Video deleteVideo(Video video) {
		return getService().deleteVideo(video);
	}

	public static void deleteVideoGalleryVideo(long galleryId, long videoId) {
		getService().deleteVideoGalleryVideo(galleryId, videoId);
	}

	public static void deleteVideoGalleryVideo(long galleryId, Video video) {
		getService().deleteVideoGalleryVideo(galleryId, video);
	}

	public static void deleteVideoGalleryVideos(
		long galleryId, List<Video> videos) {

		getService().deleteVideoGalleryVideos(galleryId, videos);
	}

	public static void deleteVideoGalleryVideos(
		long galleryId, long[] videoIds) {

		getService().deleteVideoGalleryVideos(galleryId, videoIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.video.model.impl.VideoModelImpl</code>.
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

	public static Video fetchVideo(long videoId) {
		return getService().fetchVideo(videoId);
	}

	/**
	 * Returns the video matching the UUID and group.
	 *
	 * @param uuid the video's UUID
	 * @param groupId the primary key of the group
	 * @return the matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchVideoByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchVideoByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<Video> findByKeyword(
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
	 * Retourne toutes les vidéos d'un groupe
	 */
	public static List<Video> getByGroupId(long groupId) {
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
	 * Returns the video with the primary key.
	 *
	 * @param videoId the primary key of the video
	 * @return the video
	 * @throws PortalException if a video with the primary key could not be found
	 */
	public static Video getVideo(long videoId) throws PortalException {
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
	public static Video getVideoByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

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

	public static List<Video> getVideoGalleryVideos(long galleryId) {
		return getService().getVideoGalleryVideos(galleryId);
	}

	public static List<Video> getVideoGalleryVideos(
		long galleryId, int start, int end) {

		return getService().getVideoGalleryVideos(galleryId, start, end);
	}

	public static List<Video> getVideoGalleryVideos(
		long galleryId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

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
	public static List<Video> getVideos(int start, int end) {
		return getService().getVideos(start, end);
	}

	/**
	 * Returns all the videos matching the UUID and company.
	 *
	 * @param uuid the UUID of the videos
	 * @param companyId the primary key of the company
	 * @return the matching videos, or an empty list if no matches were found
	 */
	public static List<Video> getVideosByUuidAndCompanyId(
		String uuid, long companyId) {

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
	public static List<Video> getVideosByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Video> orderByComparator) {

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
	public static Video removeVideo(long videoId) throws PortalException {
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
	public static Video updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de la vidéo "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Video video, int status)
		throws PortalException {

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
	public static Video updateVideo(Video video) {
		return getService().updateVideo(video);
	}

	/**
	 * Met à jour une vidéo et l'enregistre en base de données
	 */
	public static Video updateVideo(
			Video video, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateVideo(video, sc);
	}

	public static VideoLocalService getService() {
		return _service;
	}

	private static volatile VideoLocalService _service;

}