/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.comment.model.Comment;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Comment. This utility wraps
 * <code>eu.strasbourg.service.comment.service.impl.CommentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Romain Vergnais
 * @see CommentLocalService
 * @generated
 */
public class CommentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.comment.service.impl.CommentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Comment addComment(Comment comment) {
		return getService().addComment(comment);
	}

	/**
	 * Creates a new comment with the primary key. Does not add the comment to the database.
	 *
	 * @param commentId the primary key for the new comment
	 * @return the new comment
	 */
	public static Comment createComment(long commentId) {
		return getService().createComment(commentId);
	}

	/**
	 * Crée un commentaire vide avec une PK, non ajouté à la base de donnée
	 */
	public static Comment createComment(
			String userPublikId,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createComment(userPublikId, sc);
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
	 * Deletes the comment from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CommentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param comment the comment
	 * @return the comment that was removed
	 */
	public static Comment deleteComment(Comment comment) {
		return getService().deleteComment(comment);
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
	public static Comment deleteComment(long commentId) throws PortalException {
		return getService().deleteComment(commentId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.CommentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.comment.model.impl.CommentModelImpl</code>.
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

	public static Comment fetchComment(long commentId) {
		return getService().fetchComment(commentId);
	}

	/**
	 * Returns the comment matching the UUID and group.
	 *
	 * @param uuid the comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment, or <code>null</code> if a matching comment could not be found
	 */
	public static Comment fetchCommentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCommentByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Comment> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Recherche par mot clés (compte)
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à un commentaire
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les commentaires d'un asset entry
	 */
	public static List<Comment> getByAssetEntry(long assetEntryId, int status) {
		return getService().getByAssetEntry(assetEntryId, status);
	}

	/**
	 * Retourne tous les commentaires d'un asset entry
	 */
	public static List<Comment> getByAssetEntryAndLevel(
		long assetEntryId, int level, int status) {

		return getService().getByAssetEntryAndLevel(
			assetEntryId, level, status);
	}

	/**
	 * Retourne tous les commentaires d'un groupe
	 */
	public static List<Comment> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne tous les commentaires d'un commentaire parent
	 */
	public static List<Comment> getByParentCommentId(
		long parentCommentId, int status) {

		return getService().getByParentCommentId(parentCommentId, status);
	}

	/**
	 * Retourne tous les commentaires d'un utilisateur
	 */
	public static List<Comment> getByPublikId(String publikId) {
		return getService().getByPublikId(publikId);
	}

	/**
	 * Returns the comment with the primary key.
	 *
	 * @param commentId the primary key of the comment
	 * @return the comment
	 * @throws PortalException if a comment with the primary key could not be found
	 */
	public static Comment getComment(long commentId) throws PortalException {
		return getService().getComment(commentId);
	}

	/**
	 * Returns the comment matching the UUID and group.
	 *
	 * @param uuid the comment's UUID
	 * @param groupId the primary key of the group
	 * @return the matching comment
	 * @throws PortalException if a matching comment could not be found
	 */
	public static Comment getCommentByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getCommentByUuidAndGroupId(uuid, groupId);
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
	public static List<Comment> getComments(int start, int end) {
		return getService().getComments(start, end);
	}

	/**
	 * Returns all the comments matching the UUID and company.
	 *
	 * @param uuid the UUID of the comments
	 * @param companyId the primary key of the company
	 * @return the matching comments, or an empty list if no matches were found
	 */
	public static List<Comment> getCommentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCommentsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Comment> getCommentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Comment> orderByComparator) {

		return getService().getCommentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of comments.
	 *
	 * @return the number of comments
	 */
	public static int getCommentsCount() {
		return getService().getCommentsCount();
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
	 * méthode permettant d'obtenir une partie du commentaire.
	 *
	 * @param comment le commentaire en entier.
	 * @return le résultat du commentaire.
	 */
	public static String getSummary(String comment) {
		return getService().getSummary(comment);
	}

	/**
	 * Supprime un lien
	 */
	public static Comment removeComment(long commentId) throws PortalException {
		return getService().removeComment(commentId);
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
	public static Comment updateComment(Comment comment) {
		return getService().updateComment(comment);
	}

	/**
	 * Met à jour un commentaire et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Comment updateComment(
			Comment comment,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateComment(comment, sc);
	}

	/**
	 * Met à jour le statut du projet "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Comment comment, int status)
		throws PortalException {

		getService().updateStatus(comment, status);
	}

	/**
	 * Met à jour le statut du projet par le framework workflow
	 */
	public static Comment updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static CommentLocalService getService() {
		return _service;
	}

	public static void setService(CommentLocalService service) {
		_service = service;
	}

	private static volatile CommentLocalService _service;

}