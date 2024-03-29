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

package eu.strasbourg.service.place.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for GoogleMyBusinessHistoric. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.GoogleMyBusinessHistoricLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoricLocalService
 * @generated
 */
public class GoogleMyBusinessHistoricLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.GoogleMyBusinessHistoricLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the google my business historic to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was added
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		addGoogleMyBusinessHistoric(
			eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
				googleMyBusinessHistoric) {

		return getService().addGoogleMyBusinessHistoric(
			googleMyBusinessHistoric);
	}

	/**
	 * Creates a new google my business historic with the primary key. Does not add the google my business historic to the database.
	 *
	 * @param googleMyBusinessHistoricId the primary key for the new google my business historic
	 * @return the new google my business historic
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		createGoogleMyBusinessHistoric(long googleMyBusinessHistoricId) {

		return getService().createGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * Crée une entrée googleMyBusiness vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			createGoogleMyBusinessHistoric(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createGoogleMyBusinessHistoric(sc);
	}

	/**
	 * Deletes the google my business historic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was removed
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		deleteGoogleMyBusinessHistoric(
			eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
				googleMyBusinessHistoric) {

		return getService().deleteGoogleMyBusinessHistoric(
			googleMyBusinessHistoric);
	}

	/**
	 * Deletes the google my business historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic that was removed
	 * @throws PortalException if a google my business historic with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			deleteGoogleMyBusinessHistoric(long googleMyBusinessHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
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

	/**
	 * Effectue la synchronisation
	 */
	public static void doSynchronisation(
		com.liferay.portal.kernel.service.ServiceContext sc,
		eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			googleMyBusinessHistoric) {

		getService().doSynchronisation(sc, googleMyBusinessHistoric);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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

	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		fetchGoogleMyBusinessHistoric(long googleMyBusinessHistoricId) {

		return getService().fetchGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * Returns the google my business historic matching the UUID and group.
	 *
	 * @param uuid the google my business historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		fetchGoogleMyBusinessHistoricByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchGoogleMyBusinessHistoricByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static java.util.List
		<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
			findByKeyword(String keyword, long groupId, int start, int end) {

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
	 * Renvoie la liste des vocabulaires rattachés à google mybusiness
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les google mybusiness d'un groupe
	 */
	public static java.util.List
		<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
			getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the google my business historic with the primary key.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic
	 * @throws PortalException if a google my business historic with the primary key could not be found
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			getGoogleMyBusinessHistoric(long googleMyBusinessHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * Returns the google my business historic matching the UUID and group.
	 *
	 * @param uuid the google my business historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching google my business historic
	 * @throws PortalException if a matching google my business historic could not be found
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			getGoogleMyBusinessHistoricByUuidAndGroupId(
				String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getGoogleMyBusinessHistoricByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the google my business historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of google my business historics
	 */
	public static java.util.List
		<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
			getGoogleMyBusinessHistorics(int start, int end) {

		return getService().getGoogleMyBusinessHistorics(start, end);
	}

	/**
	 * Returns all the google my business historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the google my business historics
	 * @param companyId the primary key of the company
	 * @return the matching google my business historics, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
			getGoogleMyBusinessHistoricsByUuidAndCompanyId(
				String uuid, long companyId) {

		return getService().getGoogleMyBusinessHistoricsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of google my business historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the google my business historics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching google my business historics, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
			getGoogleMyBusinessHistoricsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.place.model.GoogleMyBusinessHistoric>
						orderByComparator) {

		return getService().getGoogleMyBusinessHistoricsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of google my business historics.
	 *
	 * @return the number of google my business historics
	 */
	public static int getGoogleMyBusinessHistoricsCount() {
		return getService().getGoogleMyBusinessHistoricsCount();
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime l'entree google mybusiness
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			removeGoogleMyBusinessHistoric(long googleMyBusinessHistoricId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * Updates the google my business historic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was updated
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
		updateGoogleMyBusinessHistoric(
			eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
				googleMyBusinessHistoric) {

		return getService().updateGoogleMyBusinessHistoric(
			googleMyBusinessHistoric);
	}

	/**
	 * Met à jour une entree google mybusiness et l'enregistre en base de données
	 *
	 * @throws PortalException
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			updateGoogleMyBusinessHistoric(
				eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
					googleMyBusinessHistoric,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateGoogleMyBusinessHistoric(
			googleMyBusinessHistoric, sc);
	}

	/**
	 * Met à jour le statut de l'entree google mybusiness "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
				googleMyBusinessHistoric,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(googleMyBusinessHistoric, status);
	}

	/**
	 * Met à jour le statut de l'entree google mybusiness par le framework workflow
	 */
	public static eu.strasbourg.service.place.model.GoogleMyBusinessHistoric
			updateStatus(
				long userId, long entryId, int status,
				com.liferay.portal.kernel.service.ServiceContext sc,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static GoogleMyBusinessHistoricLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<GoogleMyBusinessHistoricLocalService,
		 GoogleMyBusinessHistoricLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			GoogleMyBusinessHistoricLocalService.class);

		ServiceTracker
			<GoogleMyBusinessHistoricLocalService,
			 GoogleMyBusinessHistoricLocalService> serviceTracker =
				new ServiceTracker
					<GoogleMyBusinessHistoricLocalService,
					 GoogleMyBusinessHistoricLocalService>(
						 bundle.getBundleContext(),
						 GoogleMyBusinessHistoricLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}