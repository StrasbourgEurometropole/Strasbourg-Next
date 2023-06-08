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

package eu.strasbourg.service.edition.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EditionLocalService}.
 *
 * @author BenjaminBini
 * @see EditionLocalService
 * @generated
 */
public class EditionLocalServiceWrapper
	implements EditionLocalService, ServiceWrapper<EditionLocalService> {

	public EditionLocalServiceWrapper(EditionLocalService editionLocalService) {
		_editionLocalService = editionLocalService;
	}

	/**
	 * Adds the edition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was added
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition addEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return _editionLocalService.addEdition(edition);
	}

	@Override
	public void addEditionGalleryEdition(
		long galleryId, eu.strasbourg.service.edition.model.Edition edition) {

		_editionLocalService.addEditionGalleryEdition(galleryId, edition);
	}

	@Override
	public void addEditionGalleryEdition(long galleryId, long editionId) {
		_editionLocalService.addEditionGalleryEdition(galleryId, editionId);
	}

	@Override
	public void addEditionGalleryEditions(
		long galleryId,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions) {

		_editionLocalService.addEditionGalleryEditions(galleryId, editions);
	}

	@Override
	public void addEditionGalleryEditions(long galleryId, long[] editionIds) {
		_editionLocalService.addEditionGalleryEditions(galleryId, editionIds);
	}

	/**
	 * Modifie le statut de toutes les editions au statut "SCHEDULED" qui ont
	 * une date de publication dans le futur
	 */
	@Override
	public void checkEditions()
		throws com.liferay.portal.kernel.exception.PortalException {

		_editionLocalService.checkEditions();
	}

	@Override
	public void clearEditionGalleryEditions(long galleryId) {
		_editionLocalService.clearEditionGalleryEditions(galleryId);
	}

	/**
	 * Creates a new edition with the primary key. Does not add the edition to the database.
	 *
	 * @param editionId the primary key for the new edition
	 * @return the new edition
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition createEdition(
		long editionId) {

		return _editionLocalService.createEdition(editionId);
	}

	/**
	 * Crée une edition vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition createEdition(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.createEdition(sc);
	}

	/**
	 * Deletes the edition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was removed
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition deleteEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return _editionLocalService.deleteEdition(edition);
	}

	/**
	 * Deletes the edition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition that was removed
	 * @throws PortalException if a edition with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition deleteEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.deleteEdition(editionId);
	}

	@Override
	public void deleteEditionGalleryEdition(
		long galleryId, eu.strasbourg.service.edition.model.Edition edition) {

		_editionLocalService.deleteEditionGalleryEdition(galleryId, edition);
	}

	@Override
	public void deleteEditionGalleryEdition(long galleryId, long editionId) {
		_editionLocalService.deleteEditionGalleryEdition(galleryId, editionId);
	}

	@Override
	public void deleteEditionGalleryEditions(
		long galleryId,
		java.util.List<eu.strasbourg.service.edition.model.Edition> editions) {

		_editionLocalService.deleteEditionGalleryEditions(galleryId, editions);
	}

	@Override
	public void deleteEditionGalleryEditions(
		long galleryId, long[] editionIds) {

		_editionLocalService.deleteEditionGalleryEditions(
			galleryId, editionIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _editionLocalService.dynamicQuery();
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

		return _editionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
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

		return _editionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
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

		return _editionLocalService.dynamicQuery(
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

		return _editionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _editionLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.edition.model.Edition fetchEdition(
		long editionId) {

		return _editionLocalService.fetchEdition(editionId);
	}

	/**
	 * Returns the edition matching the UUID and group.
	 *
	 * @param uuid the edition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition, or <code>null</code> if a matching edition could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition
		fetchEditionByUuidAndGroupId(String uuid, long groupId) {

		return _editionLocalService.fetchEditionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _editionLocalService.findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _editionLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _editionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _editionLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les editions d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getByGroupId(long groupId) {

		return _editionLocalService.getByGroupId(groupId);
	}

	/**
	 * Returns the edition with the primary key.
	 *
	 * @param editionId the primary key of the edition
	 * @return the edition
	 * @throws PortalException if a edition with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition getEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.getEdition(editionId);
	}

	/**
	 * Returns the edition matching the UUID and group.
	 *
	 * @param uuid the edition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition
	 * @throws PortalException if a matching edition could not be found
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition
			getEditionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.getEditionByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(long galleryId) {

		return _editionLocalService.getEditionGalleryEditions(galleryId);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(long galleryId, int start, int end) {

		return _editionLocalService.getEditionGalleryEditions(
			galleryId, start, end);
	}

	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionGalleryEditions(
			long galleryId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.Edition>
					orderByComparator) {

		return _editionLocalService.getEditionGalleryEditions(
			galleryId, start, end, orderByComparator);
	}

	@Override
	public int getEditionGalleryEditionsCount(long galleryId) {
		return _editionLocalService.getEditionGalleryEditionsCount(galleryId);
	}

	/**
	 * Returns the galleryIds of the edition galleries associated with the edition.
	 *
	 * @param editionId the editionId of the edition
	 * @return long[] the galleryIds of edition galleries associated with the edition
	 */
	@Override
	public long[] getEditionGalleryPrimaryKeys(long editionId) {
		return _editionLocalService.getEditionGalleryPrimaryKeys(editionId);
	}

	/**
	 * Returns a range of all the editions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @return the range of editions
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditions(int start, int end) {

		return _editionLocalService.getEditions(start, end);
	}

	/**
	 * Returns all the editions matching the UUID and company.
	 *
	 * @param uuid the UUID of the editions
	 * @param companyId the primary key of the company
	 * @return the matching editions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionsByUuidAndCompanyId(String uuid, long companyId) {

		return _editionLocalService.getEditionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of editions matching the UUID and company.
	 *
	 * @param uuid the UUID of the editions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of editions
	 * @param end the upper bound of the range of editions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching editions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.edition.model.Edition>
		getEditionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.edition.model.Edition>
					orderByComparator) {

		return _editionLocalService.getEditionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of editions.
	 *
	 * @return the number of editions
	 */
	@Override
	public int getEditionsCount() {
		return _editionLocalService.getEditionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _editionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _editionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _editionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasEditionGalleryEdition(long galleryId, long editionId) {
		return _editionLocalService.hasEditionGalleryEdition(
			galleryId, editionId);
	}

	@Override
	public boolean hasEditionGalleryEditions(long galleryId) {
		return _editionLocalService.hasEditionGalleryEditions(galleryId);
	}

	/**
	 * Supprime une edition
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition removeEdition(
			long editionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.removeEdition(editionId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _editionLocalService.search(searchContext);
	}

	@Override
	public void setEditionGalleryEditions(long galleryId, long[] editionIds) {
		_editionLocalService.setEditionGalleryEditions(galleryId, editionIds);
	}

	/**
	 * Updates the edition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param edition the edition
	 * @return the edition that was updated
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition updateEdition(
		eu.strasbourg.service.edition.model.Edition edition) {

		return _editionLocalService.updateEdition(edition);
	}

	/**
	 * Met à jour une edition et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition updateEdition(
			eu.strasbourg.service.edition.model.Edition edition,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.updateEdition(edition, sc);
	}

	/**
	 * Met à jour le statut de l'edition "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.edition.model.Edition edition, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_editionLocalService.updateStatus(edition, status);
	}

	/**
	 * Met à jour le statut de l'edition par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.edition.model.Edition updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _editionLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public EditionLocalService getWrappedService() {
		return _editionLocalService;
	}

	@Override
	public void setWrappedService(EditionLocalService editionLocalService) {
		_editionLocalService = editionLocalService;
	}

	private EditionLocalService _editionLocalService;

}