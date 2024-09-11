/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EditionGalleryLocalService}.
 *
 * @author BenjaminBini
 * @see EditionGalleryLocalService
 * @generated
 */
public class EditionGalleryLocalServiceWrapper
	implements EditionGalleryLocalService,
			   ServiceWrapper<EditionGalleryLocalService> {

	public EditionGalleryLocalServiceWrapper() {
		this(null);
	}

	public EditionGalleryLocalServiceWrapper(
		EditionGalleryLocalService editionGalleryLocalService) {

		_editionGalleryLocalService = editionGalleryLocalService;
	}

	@Override
	public boolean addEditionEditionGalleries(
		long editionId,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries) {

		return _editionGalleryLocalService.addEditionEditionGalleries(
			editionId, editionGalleries);
	}

	@Override
	public boolean addEditionEditionGalleries(
		long editionId, long[] galleryIds) {

		return _editionGalleryLocalService.addEditionEditionGalleries(
			editionId, galleryIds);
	}

	@Override
	public boolean addEditionEditionGallery(
		long editionId,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return _editionGalleryLocalService.addEditionEditionGallery(
			editionId, editionGallery);
	}

	@Override
	public boolean addEditionEditionGallery(long editionId, long galleryId) {
		return _editionGalleryLocalService.addEditionEditionGallery(
			editionId, galleryId);
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
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery addEditionGallery(
		eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return _editionGalleryLocalService.addEditionGallery(editionGallery);
	}

	/**
	 * Modifie le statut de toutes les galeries au statut "SCHEDULED" qui ont
	 * une date de publication dans le futur
	 */
	@Override
	public void checkGalleries()
		throws com.liferay.portal.kernel.exception.PortalException {

		_editionGalleryLocalService.checkGalleries();
	}

	@Override
	public void clearEditionEditionGalleries(long editionId) {
		_editionGalleryLocalService.clearEditionEditionGalleries(editionId);
	}

	/**
	 * Creates a new edition gallery with the primary key. Does not add the edition gallery to the database.
	 *
	 * @param galleryId the primary key for the new edition gallery
	 * @return the new edition gallery
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
		createEditionGallery(long galleryId) {

		return _editionGalleryLocalService.createEditionGallery(galleryId);
	}

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
			createEditionGallery(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.createEditionGallery(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteEditionEditionGalleries(
		long editionId,
		java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
			editionGalleries) {

		_editionGalleryLocalService.deleteEditionEditionGalleries(
			editionId, editionGalleries);
	}

	@Override
	public void deleteEditionEditionGalleries(
		long editionId, long[] galleryIds) {

		_editionGalleryLocalService.deleteEditionEditionGalleries(
			editionId, galleryIds);
	}

	@Override
	public void deleteEditionEditionGallery(
		long editionId,
		eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		_editionGalleryLocalService.deleteEditionEditionGallery(
			editionId, editionGallery);
	}

	@Override
	public void deleteEditionEditionGallery(long editionId, long galleryId) {
		_editionGalleryLocalService.deleteEditionEditionGallery(
			editionId, galleryId);
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
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
		deleteEditionGallery(
			eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return _editionGalleryLocalService.deleteEditionGallery(editionGallery);
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
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
			deleteEditionGallery(long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.deleteEditionGallery(galleryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _editionGalleryLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _editionGalleryLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _editionGalleryLocalService.dynamicQuery();
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

		return _editionGalleryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _editionGalleryLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _editionGalleryLocalService.dynamicQuery(
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

		return _editionGalleryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _editionGalleryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
		fetchEditionGallery(long galleryId) {

		return _editionGalleryLocalService.fetchEditionGallery(galleryId);
	}

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
		fetchEditionGalleryByUuidAndGroupId(String uuid, long groupId) {

		return _editionGalleryLocalService.fetchEditionGalleryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _editionGalleryLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _editionGalleryLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _editionGalleryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _editionGalleryLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les galeries editions d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getByGroupId(long groupId) {

		return _editionGalleryLocalService.getByGroupId(groupId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionEditionGalleries(long editionId) {

		return _editionGalleryLocalService.getEditionEditionGalleries(
			editionId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionEditionGalleries(long editionId, int start, int end) {

		return _editionGalleryLocalService.getEditionEditionGalleries(
			editionId, start, end);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionEditionGalleries(
			long editionId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.EditionGallery>
					orderByComparator) {

		return _editionGalleryLocalService.getEditionEditionGalleries(
			editionId, start, end, orderByComparator);
	}

	@Override
	public int getEditionEditionGalleriesCount(long editionId) {
		return _editionGalleryLocalService.getEditionEditionGalleriesCount(
			editionId);
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
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleries(int start, int end) {

		return _editionGalleryLocalService.getEditionGalleries(start, end);
	}

	/**
	 * Returns all the edition galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the edition galleries
	 * @param companyId the primary key of the company
	 * @return the matching edition galleries, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleriesByUuidAndCompanyId(String uuid, long companyId) {

		return _editionGalleryLocalService.
			getEditionGalleriesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.EditionGallery>
		getEditionGalleriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.EditionGallery>
					orderByComparator) {

		return _editionGalleryLocalService.
			getEditionGalleriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of edition galleries.
	 *
	 * @return the number of edition galleries
	 */
	@Override
	public int getEditionGalleriesCount() {
		return _editionGalleryLocalService.getEditionGalleriesCount();
	}

	/**
	 * Returns the edition gallery with the primary key.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery
	 * @throws PortalException if a edition gallery with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery getEditionGallery(
			long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.getEditionGallery(galleryId);
	}

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery
	 * @throws PortalException if a matching edition gallery could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
			getEditionGalleryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.getEditionGalleryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns the editionIds of the editions associated with the edition gallery.
	 *
	 * @param galleryId the galleryId of the edition gallery
	 * @return long[] the editionIds of editions associated with the edition gallery
	 */
	@Override
	public long[] getEditionPrimaryKeys(long galleryId) {
		return _editionGalleryLocalService.getEditionPrimaryKeys(galleryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _editionGalleryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _editionGalleryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _editionGalleryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasEditionEditionGalleries(long editionId) {
		return _editionGalleryLocalService.hasEditionEditionGalleries(
			editionId);
	}

	@Override
	public boolean hasEditionEditionGallery(long editionId, long galleryId) {
		return _editionGalleryLocalService.hasEditionEditionGallery(
			editionId, galleryId);
	}

	/**
	 * Supprime une galerie
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery removeGallery(
			long galleryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.removeGallery(galleryId);
	}

	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _editionGalleryLocalService.search(searchContext);
	}

	@Override
	public void setEditionEditionGalleries(long editionId, long[] galleryIds) {
		_editionGalleryLocalService.setEditionEditionGalleries(
			editionId, galleryIds);
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
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
		updateEditionGallery(
			eu.strasbourg.service.edition.model.EditionGallery editionGallery) {

		return _editionGalleryLocalService.updateEditionGallery(editionGallery);
	}

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery
			updateEditionGallery(
				eu.strasbourg.service.edition.model.EditionGallery gallery,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.updateEditionGallery(gallery, sc);
	}

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.edition.model.EditionGallery gallery,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_editionGalleryLocalService.updateStatus(gallery, status);
	}

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.edition.model.EditionGallery updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionGalleryLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _editionGalleryLocalService.getBasePersistence();
	}

	@Override
	public EditionGalleryLocalService getWrappedService() {
		return _editionGalleryLocalService;
	}

	@Override
	public void setWrappedService(
		EditionGalleryLocalService editionGalleryLocalService) {

		_editionGalleryLocalService = editionGalleryLocalService;
	}

	private EditionGalleryLocalService _editionGalleryLocalService;

}