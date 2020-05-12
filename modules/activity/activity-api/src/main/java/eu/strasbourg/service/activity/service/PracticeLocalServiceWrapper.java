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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PracticeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PracticeLocalService
 * @generated
 */
@ProviderType
public class PracticeLocalServiceWrapper
	implements PracticeLocalService, ServiceWrapper<PracticeLocalService> {

	public PracticeLocalServiceWrapper(
		PracticeLocalService practiceLocalService) {

		_practiceLocalService = practiceLocalService;
	}

	/**
	 * Adds the practice to the database. Also notifies the appropriate model listeners.
	 *
	 * @param practice the practice
	 * @return the practice that was added
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice addPractice(
		eu.strasbourg.service.activity.model.Practice practice) {

		return _practiceLocalService.addPractice(practice);
	}

	/**
	 * Creates a new practice with the primary key. Does not add the practice to the database.
	 *
	 * @param practiceId the primary key for the new practice
	 * @return the new practice
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice createPractice(
		long practiceId) {

		return _practiceLocalService.createPractice(practiceId);
	}

	/**
	 * Crée une pratique vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice createPractice(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.createPractice(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the practice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param practiceId the primary key of the practice
	 * @return the practice that was removed
	 * @throws PortalException if a practice with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice deletePractice(
			long practiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.deletePractice(practiceId);
	}

	/**
	 * Deletes the practice from the database. Also notifies the appropriate model listeners.
	 *
	 * @param practice the practice
	 * @return the practice that was removed
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice deletePractice(
		eu.strasbourg.service.activity.model.Practice practice) {

		return _practiceLocalService.deletePractice(practice);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _practiceLocalService.dynamicQuery();
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

		return _practiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.PracticeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _practiceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.PracticeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _practiceLocalService.dynamicQuery(
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

		return _practiceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _practiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.activity.model.Practice fetchPractice(
		long practiceId) {

		return _practiceLocalService.fetchPractice(practiceId);
	}

	/**
	 * Returns the practice matching the UUID and group.
	 *
	 * @param uuid the practice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching practice, or <code>null</code> if a matching practice could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice
		fetchPracticeByUuidAndGroupId(String uuid, long groupId) {

		return _practiceLocalService.fetchPracticeByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _practiceLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _practiceLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _practiceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _practiceLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les pratiques d'une association
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getByAssociation(long associationId) {

		return _practiceLocalService.getByAssociation(associationId);
	}

	/**
	 * Retourne toutes les éditions d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getByGroupId(long groupId) {

		return _practiceLocalService.getByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _practiceLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _practiceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _practiceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the practice with the primary key.
	 *
	 * @param practiceId the primary key of the practice
	 * @return the practice
	 * @throws PortalException if a practice with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice getPractice(
			long practiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.getPractice(practiceId);
	}

	/**
	 * Returns the practice matching the UUID and group.
	 *
	 * @param uuid the practice's UUID
	 * @param groupId the primary key of the group
	 * @return the matching practice
	 * @throws PortalException if a matching practice could not be found
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice
			getPracticeByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.getPracticeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the practices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.activity.model.impl.PracticeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of practices
	 * @param end the upper bound of the range of practices (not inclusive)
	 * @return the range of practices
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getPractices(int start, int end) {

		return _practiceLocalService.getPractices(start, end);
	}

	/**
	 * Returns all the practices matching the UUID and company.
	 *
	 * @param uuid the UUID of the practices
	 * @param companyId the primary key of the company
	 * @return the matching practices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getPracticesByUuidAndCompanyId(String uuid, long companyId) {

		return _practiceLocalService.getPracticesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of practices matching the UUID and company.
	 *
	 * @param uuid the UUID of the practices
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of practices
	 * @param end the upper bound of the range of practices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching practices, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.activity.model.Practice>
		getPracticesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.activity.model.Practice>
					orderByComparator) {

		return _practiceLocalService.getPracticesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of practices.
	 *
	 * @return the number of practices
	 */
	@Override
	public int getPracticesCount() {
		return _practiceLocalService.getPracticesCount();
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice removePractice(
			long practiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.removePractice(practiceId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _practiceLocalService.search(searchContext);
	}

	/**
	 * Updates the practice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param practice the practice
	 * @return the practice that was updated
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice updatePractice(
		eu.strasbourg.service.activity.model.Practice practice) {

		return _practiceLocalService.updatePractice(practice);
	}

	/**
	 * Met à jour une pratique et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice updatePractice(
			eu.strasbourg.service.activity.model.Practice practice,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.updatePractice(practice, sc);
	}

	/**
	 * Met à jour le statut de la pratique par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.activity.model.Practice updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _practiceLocalService.updateStatus(userId, entryId, status);
	}

	@Override
	public PracticeLocalService getWrappedService() {
		return _practiceLocalService;
	}

	@Override
	public void setWrappedService(PracticeLocalService practiceLocalService) {
		_practiceLocalService = practiceLocalService;
	}

	private PracticeLocalService _practiceLocalService;

}