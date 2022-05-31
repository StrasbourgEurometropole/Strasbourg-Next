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

package eu.strasbourg.service.interest.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Interest. This utility wraps
 * <code>eu.strasbourg.service.interest.service.impl.InterestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see InterestLocalService
 * @generated
 */
public class InterestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.interest.service.impl.InterestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static eu.strasbourg.service.interest.model.Interest addInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return getService().addInterest(interest);
	}

	/**
	 * Creates a new interest with the primary key. Does not add the interest to the database.
	 *
	 * @param interestId the primary key for the new interest
	 * @return the new interest
	 */
	public static eu.strasbourg.service.interest.model.Interest createInterest(
		long interestId) {

		return getService().createInterest(interestId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.interest.model.Interest createInterest(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createInterest(sc);
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
	public static eu.strasbourg.service.interest.model.Interest deleteInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return getService().deleteInterest(interest);
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
	public static eu.strasbourg.service.interest.model.Interest deleteInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteInterest(interestId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.interest.model.Interest fetchInterest(
		long interestId) {

		return getService().fetchInterest(interestId);
	}

	/**
	 * Returns the interest matching the UUID and group.
	 *
	 * @param uuid the interest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching interest, or <code>null</code> if a matching interest could not be found
	 */
	public static eu.strasbourg.service.interest.model.Interest
		fetchInterestByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchInterestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		findByKeyword(String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés
	 */
	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité Interest
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les entité d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne tous les centres d'intérêts (publiées) d'un utilisateur
	 */
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		getByPublikUserId(String publikUserId) {

		return getService().getByPublikUserId(publikUserId);
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
	 * Returns the interest with the primary key.
	 *
	 * @param interestId the primary key of the interest
	 * @return the interest
	 * @throws PortalException if a interest with the primary key could not be found
	 */
	public static eu.strasbourg.service.interest.model.Interest getInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInterest(interestId);
	}

	/**
	 * Returns the interest matching the UUID and group.
	 *
	 * @param uuid the interest's UUID
	 * @param groupId the primary key of the group
	 * @return the matching interest
	 * @throws PortalException if a matching interest could not be found
	 */
	public static eu.strasbourg.service.interest.model.Interest
			getInterestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInterestByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterests(int start, int end) {

		return getService().getInterests(start, end);
	}

	/**
	 * Returns all the interests matching the UUID and company.
	 *
	 * @param uuid the UUID of the interests
	 * @param companyId the primary key of the company
	 * @return the matching interests, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterestsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getInterestsByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<eu.strasbourg.service.interest.model.Interest>
		getInterestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.interest.model.Interest>
					orderByComparator) {

		return getService().getInterestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of interests.
	 *
	 * @return the number of interests
	 */
	public static int getInterestsCount() {
		return getService().getInterestsCount();
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une entité
	 */
	public static eu.strasbourg.service.interest.model.Interest removeInterest(
			long interestId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeInterest(interestId);
	}

	/**
	 * Lance une recherche selon le searchContext
	 */
	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	/**
	 * Met à jour la relation entre un utilisateur et ses centres d'intérêts
	 */
	public static void setUserInterests(
		String publikUserId, long[] interestIds) {

		getService().setUserInterests(publikUserId, interestIds);
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
	public static eu.strasbourg.service.interest.model.Interest updateInterest(
		eu.strasbourg.service.interest.model.Interest interest) {

		return getService().updateInterest(interest);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.interest.model.Interest updateInterest(
			eu.strasbourg.service.interest.model.Interest interest,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateInterest(interest, sc);
	}

	/**
	 * Met à jour le statut de l'entité
	 */
	public static eu.strasbourg.service.interest.model.Interest updateStatus(
			long userId, long entryId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(userId, entryId, status);
	}

	public static InterestLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<InterestLocalService, InterestLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(InterestLocalService.class);

		ServiceTracker<InterestLocalService, InterestLocalService>
			serviceTracker =
				new ServiceTracker<InterestLocalService, InterestLocalService>(
					bundle.getBundleContext(), InterestLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}