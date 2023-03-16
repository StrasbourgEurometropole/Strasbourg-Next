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

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AssociationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AssociationLocalService
 * @generated
 */
public class AssociationLocalServiceWrapper
	implements AssociationLocalService,
			   ServiceWrapper<AssociationLocalService> {

	public AssociationLocalServiceWrapper() {
		this(null);
	}

	public AssociationLocalServiceWrapper(
		AssociationLocalService associationLocalService) {

		_associationLocalService = associationLocalService;
	}

	/**
	 * Adds the association to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssociationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param association the association
	 * @return the association that was added
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association addAssociation(
		eu.strasbourg.service.activity.model.Association association) {

		return _associationLocalService.addAssociation(association);
	}

	/**
	 * Creates a new association with the primary key. Does not add the association to the database.
	 *
	 * @param associationId the primary key for the new association
	 * @return the new association
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association createAssociation(
		long associationId) {

		return _associationLocalService.createAssociation(associationId);
	}

	/**
	 * Crée une association vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association createAssociation(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.createAssociation(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the association from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssociationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param association the association
	 * @return the association that was removed
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association deleteAssociation(
		eu.strasbourg.service.activity.model.Association association) {

		return _associationLocalService.deleteAssociation(association);
	}

	/**
	 * Deletes the association with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssociationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param associationId the primary key of the association
	 * @return the association that was removed
	 * @throws PortalException if a association with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association deleteAssociation(
			long associationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.deleteAssociation(associationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _associationLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _associationLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _associationLocalService.dynamicQuery();
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

		return _associationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.AssociationModelImpl</code>.
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

		return _associationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.AssociationModelImpl</code>.
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

		return _associationLocalService.dynamicQuery(
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

		return _associationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _associationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.activity.model.Association fetchAssociation(
		long associationId) {

		return _associationLocalService.fetchAssociation(associationId);
	}

	/**
	 * Returns the association matching the UUID and group.
	 *
	 * @param uuid the association's UUID
	 * @param groupId the primary key of the group
	 * @return the matching association, or <code>null</code> if a matching association could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association
		fetchAssociationByUuidAndGroupId(String uuid, long groupId) {

		return _associationLocalService.fetchAssociationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Association>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _associationLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _associationLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _associationLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the association with the primary key.
	 *
	 * @param associationId the primary key of the association
	 * @return the association
	 * @throws PortalException if a association with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association getAssociation(
			long associationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.getAssociation(associationId);
	}

	/**
	 * Returns the association matching the UUID and group.
	 *
	 * @param uuid the association's UUID
	 * @param groupId the primary key of the group
	 * @return the matching association
	 * @throws PortalException if a matching association could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association
			getAssociationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.getAssociationByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the associations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.AssociationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of associations
	 * @param end the upper bound of the range of associations (not inclusive)
	 * @return the range of associations
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Association>
		getAssociations(int start, int end) {

		return _associationLocalService.getAssociations(start, end);
	}

	/**
	 * Returns all the associations matching the UUID and company.
	 *
	 * @param uuid the UUID of the associations
	 * @param companyId the primary key of the company
	 * @return the matching associations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Association>
		getAssociationsByUuidAndCompanyId(String uuid, long companyId) {

		return _associationLocalService.getAssociationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of associations matching the UUID and company.
	 *
	 * @param uuid the UUID of the associations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of associations
	 * @param end the upper bound of the range of associations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching associations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Association>
		getAssociationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.activity.model.Association>
					orderByComparator) {

		return _associationLocalService.getAssociationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of associations.
	 *
	 * @return the number of associations
	 */
	@Override
	public int getAssociationsCount() {
		return _associationLocalService.getAssociationsCount();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _associationLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Association>
		getByGroupId(long groupId) {

		return _associationLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _associationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _associationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _associationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association removeAssociation(
			long associationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.removeAssociation(associationId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public Hits search(SearchContext searchContext) throws SearchException {
		return _associationLocalService.search(searchContext);
	}

	/**
	 * Updates the association in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AssociationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param association the association
	 * @return the association that was updated
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association updateAssociation(
		eu.strasbourg.service.activity.model.Association association) {

		return _associationLocalService.updateAssociation(association);
	}

	/**
	 * Met à jour une association et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association updateAssociation(
			eu.strasbourg.service.activity.model.Association association,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.updateAssociation(association, sc);
	}

	/**
	 * Met à jour le statut de l'association par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.activity.model.Association updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _associationLocalService.updateStatus(userId, entryId, status);
	}

	@Override
	public AssociationLocalService getWrappedService() {
		return _associationLocalService;
	}

	@Override
	public void setWrappedService(
		AssociationLocalService associationLocalService) {

		_associationLocalService = associationLocalService;
	}

	private AssociationLocalService _associationLocalService;

}