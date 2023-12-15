/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CommentLocalService}.
 *
 * @author Romain Vergnais
 * @see CommentLocalService
 * @generated
 */
public class CommentLocalServiceWrapper
	implements CommentLocalService, ServiceWrapper<CommentLocalService> {

	public CommentLocalServiceWrapper() {
		this(null);
	}

	public CommentLocalServiceWrapper(CommentLocalService commentLocalService) {
		_commentLocalService = commentLocalService;
	}

	/**
	 * Adds the comment to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comment the comment
	 * @return the comment that was added
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment addComment(
		eu.strasbourg.service.comment.model.Comment comment) {

		return _commentLocalService.addComment(comment);
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment createComment(
		long commentId) {

		return _commentLocalService.createComment(commentId);
	}

	/**
	 * Crée un commentaire vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment createComment(
			String userPublikId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.createComment(userPublikId, sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the comment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comment the comment
	 * @return the comment that was removed
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment deleteComment(
		eu.strasbourg.service.comment.model.Comment comment) {

		return _commentLocalService.deleteComment(comment);
	}

	/**
	 * Deletes the comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment that was removed
	 * @throws PortalException if a comment with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment deleteComment(
			long commentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.deleteComment(commentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _commentLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _commentLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _commentLocalService.dynamicQuery();
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

		return _commentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.CommentModelImpl</code>.
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

		return _commentLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.CommentModelImpl</code>.
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

		return _commentLocalService.dynamicQuery(
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

		return _commentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _commentLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.comment.model.Comment fetchComment(
		long commentId) {

		return _commentLocalService.fetchComment(commentId);
	}

	/**
	 * Returns the comment matching the UUID and group.
	 *
	 * @param uuid the comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment
		fetchCommentByUuidAndGroupId(String uuid, long groupId) {

		return _commentLocalService.fetchCommentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _commentLocalService.findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _commentLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _commentLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à un commentaire
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _commentLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les commentaires d'un asset entry
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getByAssetEntry(long assetEntryId, int status) {

		return _commentLocalService.getByAssetEntry(assetEntryId, status);
	}

	/**
	 * Retourne tous les commentaires d'un asset entry
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getByAssetEntryAndLevel(long assetEntryId, int level, int status) {

		return _commentLocalService.getByAssetEntryAndLevel(
			assetEntryId, level, status);
	}

	/**
	 * Retourne tous les commentaires d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getByGroupId(long groupId) {

		return _commentLocalService.getByGroupId(groupId);
	}

	/**
	 * Retourne tous les commentaires d'un commentaire parent
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getByParentCommentId(long parentCommentId, int status) {

		return _commentLocalService.getByParentCommentId(
			parentCommentId, status);
	}

	/**
	 * Retourne tous les commentaires d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getByPublikId(String publikId) {

		return _commentLocalService.getByPublikId(publikId);
	}

	/**
	 * Returns the comment with the primary key.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws PortalException if a comment with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment getComment(
			long commentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.getComment(commentId);
	}

	/**
	 * Returns the comment matching the UUID and group.
	 *
	 * @param uuid the comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment
	 * @throws PortalException if a matching comment could not be found
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment
			getCommentByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.getCommentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.CommentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @return the range of comments
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getComments(int start, int end) {

		return _commentLocalService.getComments(start, end);
	}

	/**
	 * Returns all the comments matching the UUID and company.
	 *
	 * @param uuid the UUID of the comments
	 * @param companyId the primary key of the company
	 * @return the matching comments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getCommentsByUuidAndCompanyId(String uuid, long companyId) {

		return _commentLocalService.getCommentsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of comments matching the UUID and company.
	 *
	 * @param uuid the UUID of the comments
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of comments
	 * @param end the upper bound of the range of comments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching comments, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getCommentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.comment.model.Comment>
					orderByComparator) {

		return _commentLocalService.getCommentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	@Override
	public int getCommentsCount() {
		return _commentLocalService.getCommentsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _commentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _commentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * méthode permettant d'obtenir une partie du commentaire.
	 *
	 * @param comment le commentaire en entier.
	 * @return le résultat du commentaire.
	 */
	@Override
	public String getSummary(String comment) {
		return _commentLocalService.getSummary(comment);
	}

	/**
	 * Supprime un lien
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment removeComment(
			long commentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.removeComment(commentId);
	}

	/**
	 * Updates the comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comment the comment
	 * @return the comment that was updated
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment updateComment(
		eu.strasbourg.service.comment.model.Comment comment) {

		return _commentLocalService.updateComment(comment);
	}

	/**
	 * Met à jour un commentaire et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment updateComment(
			eu.strasbourg.service.comment.model.Comment comment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.updateComment(comment, sc);
	}

	/**
	 * Met à jour le statut du projet "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.comment.model.Comment comment, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_commentLocalService.updateStatus(comment, status);
	}

	/**
	 * Met à jour le statut du projet par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commentLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _commentLocalService.getBasePersistence();
	}

	@Override
	public CommentLocalService getWrappedService() {
		return _commentLocalService;
	}

	@Override
	public void setWrappedService(CommentLocalService commentLocalService) {
		_commentLocalService = commentLocalService;
	}

	private CommentLocalService _commentLocalService;

}