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

package eu.strasbourg.service.oidc.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublikUserLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserLocalService
 * @generated
 */
@ProviderType
public class PublikUserLocalServiceWrapper
	implements PublikUserLocalService, ServiceWrapper<PublikUserLocalService> {

	public PublikUserLocalServiceWrapper(
		PublikUserLocalService publikUserLocalService) {

		_publikUserLocalService = publikUserLocalService;
	}

	/**
	 * Adds the publik user to the database. Also notifies the appropriate model listeners.
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was added
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser addPublikUser(
		eu.strasbourg.service.oidc.model.PublikUser publikUser) {

		return _publikUserLocalService.addPublikUser(publikUser);
	}

	/**
	 * Anonymise l'utilisateur pour placit
	 * suppression de la signature du pacte,
	 * anonymisation de ProjectFollowed, EventParticipation, Petition, Signataire, BudgetParticipatif,
	 *     BudgetSupport, Initiative, InitiativeHelp, Comment et Like
	 */
	@Override
	public void anonymisedUserPlacit(
		eu.strasbourg.service.oidc.model.PublikUser anonymUser,
		eu.strasbourg.service.oidc.model.PublikUser publikUser) {

		_publikUserLocalService.anonymisedUserPlacit(anonymUser, publikUser);
	}

	@Override
	public eu.strasbourg.service.oidc.model.PublikUser createPublikUser() {
		return _publikUserLocalService.createPublikUser();
	}

	/**
	 * Creates a new publik user with the primary key. Does not add the publik user to the database.
	 *
	 * @param publikUserLiferayId the primary key for the new publik user
	 * @return the new publik user
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser createPublikUser(
		long publikUserLiferayId) {

		return _publikUserLocalService.createPublikUser(publikUserLiferayId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publikUserLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the publik user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user that was removed
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser deletePublikUser(
			long publikUserLiferayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publikUserLocalService.deletePublikUser(publikUserLiferayId);
	}

	/**
	 * Deletes the publik user from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was removed
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser deletePublikUser(
		eu.strasbourg.service.oidc.model.PublikUser publikUser) {

		return _publikUserLocalService.deletePublikUser(publikUser);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publikUserLocalService.dynamicQuery();
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

		return _publikUserLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _publikUserLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _publikUserLocalService.dynamicQuery(
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

		return _publikUserLocalService.dynamicQueryCount(dynamicQuery);
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

		return _publikUserLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.oidc.model.PublikUser fetchPublikUser(
		long publikUserLiferayId) {

		return _publikUserLocalService.fetchPublikUser(publikUserLiferayId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _publikUserLocalService.getActionableDynamicQuery();
	}

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * sans critere
	 *
	 * @return Liste de tous les utilisateurs Publik
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getAllPublikUsers() {

		return _publikUserLocalService.getAllPublikUsers();
	}

	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getByPublikUserId(
		String publikUserId) {

		return _publikUserLocalService.getByPublikUserId(publikUserId);
	}

	/**
	 * méthode permettant de récupererer le nombre de signataire.
	 *
	 * @return le nombre de signataire.
	 */
	@Override
	public long getCountUserHasSignedPacte() {
		return _publikUserLocalService.getCountUserHasSignedPacte();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _publikUserLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _publikUserLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publikUserLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the publik user with the primary key.
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getPublikUser(
			long publikUserLiferayId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publikUserLocalService.getPublikUser(publikUserLiferayId);
	}

	/**
	 * Returns a range of all the publik users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publik users
	 * @param end the upper bound of the range of publik users (not inclusive)
	 * @return the range of publik users
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getPublikUsers(int start, int end) {

		return _publikUserLocalService.getPublikUsers(start, end);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getPublikUsers(
			int start, int end, String sortField, boolean isSortDesc) {

		return _publikUserLocalService.getPublikUsers(
			start, end, sortField, isSortDesc);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec recherche et pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getPublikUsers(
			int start, int end, String keywords, String sortField,
			boolean isSortDesc) {

		return _publikUserLocalService.getPublikUsers(
			start, end, keywords, sortField, isSortDesc);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * sans pagination
	 *
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getPublikUsers(String sortField, boolean isSortDesc) {

		return _publikUserLocalService.getPublikUsers(sortField, isSortDesc);
	}

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * avec recherche mais sans pagination
	 *
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getPublikUsers(String keywords, String sortField, boolean isSortDesc) {

		return _publikUserLocalService.getPublikUsers(
			keywords, sortField, isSortDesc);
	}

	/**
	 * Returns the number of publik users.
	 *
	 * @return the number of publik users
	 */
	@Override
	public int getPublikUsersCount() {
		return _publikUserLocalService.getPublikUsersCount();
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser removePublikUser(
		String publikUserId) {

		return _publikUserLocalService.removePublikUser(publikUserId);
	}

	/**
	 * Updates the publik user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was updated
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser updatePublikUser(
		eu.strasbourg.service.oidc.model.PublikUser publikUser) {

		return _publikUserLocalService.updatePublikUser(publikUser);
	}

	/**
	 * Met à jour un utilisateur Publik et l'enregistre en base
	 *
	 * @return L'utilisateur Publik modifié
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser updatePublikUser(
			eu.strasbourg.service.oidc.model.PublikUser publikUser,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _publikUserLocalService.updatePublikUser(publikUser, sc);
	}

	@Override
	public PublikUserLocalService getWrappedService() {
		return _publikUserLocalService;
	}

	@Override
	public void setWrappedService(
		PublikUserLocalService publikUserLocalService) {

		_publikUserLocalService = publikUserLocalService;
	}

	private PublikUserLocalService _publikUserLocalService;

}