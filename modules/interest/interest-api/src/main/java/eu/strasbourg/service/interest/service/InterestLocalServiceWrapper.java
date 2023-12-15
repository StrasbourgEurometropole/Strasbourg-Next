/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link InterestLocalService}.
 *
 * @author BenjaminBini
 * @see InterestLocalService
 * @generated
 */
public class InterestLocalServiceWrapper
	implements InterestLocalService, ServiceWrapper<InterestLocalService> {

	public InterestLocalServiceWrapper() {
		this(null);
	}

	public InterestLocalServiceWrapper(
		InterestLocalService interestLocalService) {

		_interestLocalService = interestLocalService;
	}

	/**
	 * Adds the interest to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interest the interest
	 * @return the interest that was added
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest addInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return _interestLocalService.addInterest(interest);
	}

	/**
	 * Creates a new interest with the primary key. Does not add the interest to the database.
	 *
	 * @param interestId the primary key for the new interest
	 * @return the new interest
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest createInterest(
		long interestId) {

		return _interestLocalService.createInterest(interestId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest createInterest(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.createInterest(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the interest from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interest the interest
	 * @return the interest that was removed
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest deleteInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return _interestLocalService.deleteInterest(interest);
	}

	/**
	 * Deletes the interest with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest that was removed
	 * @throws PortalException if a interest with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest deleteInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.deleteInterest(interestId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _interestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _interestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interestLocalService.dynamicQuery();
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

		return _interestLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.InterestModelImpl</code>.
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

		return _interestLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.InterestModelImpl</code>.
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

		return _interestLocalService.dynamicQuery(
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

		return _interestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _interestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.interest.model.Interest fetchInterest(
		long interestId) {

		return _interestLocalService.fetchInterest(interestId);
	}

	/**
	 * Returns the interest matching the UUID and group.
	 *
	 * @param uuid the interest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching interest, or <code>null</code> if a matching interest could not be found
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest
		fetchInterestByUuidAndGroupId(String uuid, long groupId) {

		return _interestLocalService.fetchInterestByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return _interestLocalService.findByKeyword(
			keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	@Override
	public long findByKeywordCount(String keyword, long groupId) {
		return _interestLocalService.findByKeywordCount(keyword, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _interestLocalService.getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité Interest
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return _interestLocalService.getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les entité d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		getByGroupId(long groupId) {

		return _interestLocalService.getByGroupId(groupId);
	}

	/**
	 * Retourne tous les centres d'intérêts (publiées) d'un utilisateur
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		getByPublikUserId(String publikUserId) {

		return _interestLocalService.getByPublikUserId(publikUserId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _interestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _interestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the interest with the primary key.
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest
	 * @throws PortalException if a interest with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest getInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.getInterest(interestId);
	}

	/**
	 * Returns the interest matching the UUID and group.
	 *
	 * @param uuid the interest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching interest
	 * @throws PortalException if a matching interest could not be found
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest
			getInterestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.getInterestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the interests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.interest.model.impl.InterestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @return the range of interests
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterests(int start, int end) {

		return _interestLocalService.getInterests(start, end);
	}

	/**
	 * Returns all the interests matching the UUID and company.
	 *
	 * @param uuid the UUID of the interests
	 * @param companyId the primary key of the company
	 * @return the matching interests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterestsByUuidAndCompanyId(String uuid, long companyId) {

		return _interestLocalService.getInterestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of interests matching the UUID and company.
	 *
	 * @param uuid the UUID of the interests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of interests
	 * @param end the upper bound of the range of interests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching interests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.interest.model.Interest>
					orderByComparator) {

		return _interestLocalService.getInterestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of interests.
	 *
	 * @return the number of interests
	 */
	@Override
	public int getInterestsCount() {
		return _interestLocalService.getInterestsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _interestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest removeInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.removeInterest(interestId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	@Override
	public com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return _interestLocalService.search(searchContext);
	}

	/**
	 * Met à jour la relation entre un utilisateur et ses centres d'intérêts
	 */
	@Override
	public void setUserInterests(String publikUserId, long[] interestIds) {
		_interestLocalService.setUserInterests(publikUserId, interestIds);
	}

	/**
	 * Updates the interest in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InterestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param interest the interest
	 * @return the interest that was updated
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest updateInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return _interestLocalService.updateInterest(interest);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest updateInterest(
			eu.strasbourg.service.interest.model.Interest interest,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.updateInterest(interest, sc);
	}

	/**
	 * Met à jour le statut de l'entité
	 */
	@Override
	public eu.strasbourg.service.interest.model.Interest updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _interestLocalService.updateStatus(userId, entryId, status);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _interestLocalService.getBasePersistence();
	}

	@Override
	public InterestLocalService getWrappedService() {
		return _interestLocalService;
	}

	@Override
	public void setWrappedService(InterestLocalService interestLocalService) {
		_interestLocalService = interestLocalService;
	}

	private InterestLocalService _interestLocalService;

}