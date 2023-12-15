/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link LikeLocalService}.
 *
 * @author Cedric Henry
 * @see LikeLocalService
 * @generated
 */
public class LikeLocalServiceWrapper
	implements LikeLocalService, ServiceWrapper<LikeLocalService> {

	public LikeLocalServiceWrapper() {
		this(null);
	}

	public LikeLocalServiceWrapper(LikeLocalService likeLocalService) {
		_likeLocalService = likeLocalService;
	}

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
	@Override
	public eu.strasbourg.service.like.model.Like addLike(
		eu.strasbourg.service.like.model.Like like) {

		return _likeLocalService.addLike(like);
	}

	/**
	 * Crée un nouveau like/dislike
	 */
	@Override
	public eu.strasbourg.service.like.model.Like createLike() {
		return _likeLocalService.createLike();
	}

	/**
	 * Creates a new like with the primary key. Does not add the like to the database.
	 *
	 * @param likeId the primary key for the new like
	 * @return the new like
	 */
	@Override
	public eu.strasbourg.service.like.model.Like createLike(long likeId) {
		return _likeLocalService.createLike(likeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _likeLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.like.model.Like deleteLike(
		eu.strasbourg.service.like.model.Like like) {

		return _likeLocalService.deleteLike(like);
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
	@Override
	public eu.strasbourg.service.like.model.Like deleteLike(long likeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _likeLocalService.deleteLike(likeId);
	}

	/**
	 * Supprime les likes/dislike d'une entité
	 */
	@Override
	public void deleteLikeByEntityIdAndType(long entityId, long typeId) {
		_likeLocalService.deleteLikeByEntityIdAndType(entityId, typeId);
	}

	/**
	 * Supprime les likes/dislike d'une entité selon son type (Like ou Dislike)
	 */
	@Override
	public void deleteLikeByEntityIdAndTypeAndIsDislike(
		long entityId, long typeId, boolean isDislike) {

		_likeLocalService.deleteLikeByEntityIdAndTypeAndIsDislike(
			entityId, typeId, isDislike);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _likeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _likeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _likeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _likeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _likeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _likeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _likeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _likeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _likeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.like.model.Like fetchLike(long likeId) {
		return _likeLocalService.fetchLike(likeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _likeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne la liste des like/dislike d'une entité
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getByEntityIdAndTypeId(long entityId, long typeId) {

		return _likeLocalService.getByEntityIdAndTypeId(entityId, typeId);
	}

	/**
	 * Retourne la liste des like/dislike d'une entité selon le type de like (like/dislike)
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getByEntityIdAndTypeIdAndIsDislike(
			long entityId, long typeId, boolean isDislike) {

		return _likeLocalService.getByEntityIdAndTypeIdAndIsDislike(
			entityId, typeId, isDislike);
	}

	/**
	 * Retourne la liste des likes/dislikes d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getByPublikUser(String publikUserId) {

		return _likeLocalService.getByPublikUser(publikUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _likeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the like with the primary key.
	 *
	 * @param likeId the primary key of the like
	 * @return the like
	 * @throws PortalException if a like with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.like.model.Like getLike(long likeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _likeLocalService.getLike(likeId);
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
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes(
		int start, int end) {

		return _likeLocalService.getLikes(start, end);
	}

	/**
	 * Returns the number of likes.
	 *
	 * @return the number of likes
	 */
	@Override
	public int getLikesCount() {
		return _likeLocalService.getLikesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _likeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _likeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.like.model.Like updateLike(
		eu.strasbourg.service.like.model.Like like) {

		return _likeLocalService.updateLike(like);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _likeLocalService.getBasePersistence();
	}

	@Override
	public LikeLocalService getWrappedService() {
		return _likeLocalService;
	}

	@Override
	public void setWrappedService(LikeLocalService likeLocalService) {
		_likeLocalService = likeLocalService;
	}

	private LikeLocalService _likeLocalService;

}