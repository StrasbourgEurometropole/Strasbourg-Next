/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.like.model.Like;

import java.io.Serializable;

import java.util.List;

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
public class LikeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.like.service.impl.LikeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the like to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LikeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param like the like
	 * @return the like that was added
	 */
	public static Like addLike(Like like) {
		return getService().addLike(like);
	}

	/**
	 * Crée un nouveau like/dislike
	 */
	public static Like createLike() {
		return getService().createLike();
	}

	/**
	 * Creates a new like with the primary key. Does not add the like to the database.
	 *
	 * @param likeId the primary key for the new like
	 * @return the new like
	 */
	public static Like createLike(long likeId) {
		return getService().createLike(likeId);
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
	 * Deletes the like from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LikeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param like the like
	 * @return the like that was removed
	 */
	public static Like deleteLike(Like like) {
		return getService().deleteLike(like);
	}

	/**
	 * Deletes the like with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LikeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param likeId the primary key of the like
	 * @return the like that was removed
	 * @throws PortalException if a like with the primary key could not be found
	 */
	public static Like deleteLike(long likeId) throws PortalException {
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>.
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

	public static Like fetchLike(long likeId) {
		return getService().fetchLike(likeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des like/dislike d'une entité
	 */
	public static List<Like> getByEntityIdAndTypeId(
		long entityId, long typeId) {

		return getService().getByEntityIdAndTypeId(entityId, typeId);
	}

	/**
	 * Retourne la liste des like/dislike d'une entité selon le type de like (like/dislike)
	 */
	public static List<Like> getByEntityIdAndTypeIdAndIsDislike(
		long entityId, long typeId, boolean isDislike) {

		return getService().getByEntityIdAndTypeIdAndIsDislike(
			entityId, typeId, isDislike);
	}

	/**
	 * Retourne la liste des likes/dislikes d'un utilisateur
	 */
	public static List<Like> getByPublikUser(String publikUserId) {
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
	public static Like getLike(long likeId) throws PortalException {
		return getService().getLike(likeId);
	}

	/**
	 * Returns a range of all the likes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.like.model.impl.LikeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of likes
	 * @param end the upper bound of the range of likes (not inclusive)
	 * @return the range of likes
	 */
	public static List<Like> getLikes(int start, int end) {
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

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the like in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LikeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param like the like
	 * @return the like that was updated
	 */
	public static Like updateLike(Like like) {
		return getService().updateLike(like);
	}

	public static LikeLocalService getService() {
		return _service;
	}

	public static void setService(LikeLocalService service) {
		_service = service;
	}

	private static volatile LikeLocalService _service;

}