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

package eu.strasbourg.service.like.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Like. This utility wraps
 * <code>eu.strasbourg.service.like.service.impl.LikeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see LikeLocalService
 * @generated
 */
@ProviderType
public class LikeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.like.service.impl.LikeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the like to the database. Also notifies the appropriate model listeners.
	 *
	 * @param like the like
	 * @return the like that was added
	 */
	public static eu.strasbourg.service.like.model.Like addLike(
		eu.strasbourg.service.like.model.Like like) {

		return getService().addLike(like);
	}

	/**
	 * Crée un nouveau like/dislike
	 */
	public static eu.strasbourg.service.like.model.Like createLike() {
		return getService().createLike();
	}

	/**
	 * Creates a new like with the primary key. Does not add the like to the database.
	 *
	 * @param likeId the primary key for the new like
	 * @return the new like
	 */
	public static eu.strasbourg.service.like.model.Like createLike(
		long likeId) {

		return getService().createLike(likeId);
	}

	/**
	 * Deletes the like from the database. Also notifies the appropriate model listeners.
	 *
	 * @param like the like
	 * @return the like that was removed
	 */
	public static eu.strasbourg.service.like.model.Like deleteLike(
		eu.strasbourg.service.like.model.Like like) {

		return getService().deleteLike(like);
	}

	/**
	 * Deletes the like with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param likeId the primary key of the like
	 * @return the like that was removed
	 * @throws PortalException if a like with the primary key could not be found
	 */
	public static eu.strasbourg.service.like.model.Like deleteLike(long likeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLike(likeId);
	}

	/**
	 * Supprime les likes/dislike d'une entité
	 */
	public static void deleteLikeByEntityIdAndType(long entityId, long typeId) {
		getService().deleteLikeByEntityIdAndType(entityId, typeId);
	}

	/**
	 * Supprime les likes/dislike d'une entité selon son type (Like ou Dislike)
	 */
	public static void deleteLikeByEntityIdAndTypeAndIsDislike(
		long entityId, long typeId, boolean isDislike) {

		getService().deleteLikeByEntityIdAndTypeAndIsDislike(
			entityId, typeId, isDislike);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static eu.strasbourg.service.like.model.Like fetchLike(long likeId) {
		return getService().fetchLike(likeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des like/dislike d'une entité
	 */
	public static java.util.List<eu.strasbourg.service.like.model.Like>
		getByEntityIdAndTypeId(long entityId, long typeId) {

		return getService().getByEntityIdAndTypeId(entityId, typeId);
	}

	/**
	 * Retourne la liste des like/dislike d'une entité selon le type de like (like/dislike)
	 */
	public static java.util.List<eu.strasbourg.service.like.model.Like>
		getByEntityIdAndTypeIdAndIsDislike(
			long entityId, long typeId, boolean isDislike) {

		return getService().getByEntityIdAndTypeIdAndIsDislike(
			entityId, typeId, isDislike);
	}

	/**
	 * Retourne la liste des likes/dislikes d'un utilisateur
	 */
	public static java.util.List<eu.strasbourg.service.like.model.Like>
		getByPublikUser(String publikUserId) {

		return getService().getByPublikUser(publikUserId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the like with the primary key.
	 *
	 * @param likeId the primary key of the like
	 * @return the like
	 * @throws PortalException if a like with the primary key could not be found
	 */
	public static eu.strasbourg.service.like.model.Like getLike(long likeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLike(likeId);
	}

	/**
	 * Returns a range of all the likes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of likes
	 * @param end the upper bound of the range of likes (not inclusive)
	 * @return the range of likes
	 */
	public static java.util.List<eu.strasbourg.service.like.model.Like>
		getLikes(int start, int end) {

		return getService().getLikes(start, end);
	}

	/**
	 * Returns the number of likes.
	 *
	 * @return the number of likes
	 */
	public static int getLikesCount() {
		return getService().getLikesCount();
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

	/**
	 * Updates the like in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param like the like
	 * @return the like that was updated
	 */
	public static eu.strasbourg.service.like.model.Like updateLike(
		eu.strasbourg.service.like.model.Like like) {

		return getService().updateLike(like);
	}

	public static LikeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LikeLocalService, LikeLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LikeLocalService.class);

		ServiceTracker<LikeLocalService, LikeLocalService> serviceTracker =
			new ServiceTracker<LikeLocalService, LikeLocalService>(
				bundle.getBundleContext(), LikeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}