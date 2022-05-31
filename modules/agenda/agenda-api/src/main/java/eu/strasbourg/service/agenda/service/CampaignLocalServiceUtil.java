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

package eu.strasbourg.service.agenda.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Campaign. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.CampaignLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see CampaignLocalService
 * @generated
 */
public class CampaignLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.CampaignLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the campaign to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was added
	 */
	public static eu.strasbourg.service.agenda.model.Campaign addCampaign(
		eu.strasbourg.service.agenda.model.Campaign campaign) {

		return getService().addCampaign(campaign);
	}

	/**
	 * Creates a new campaign with the primary key. Does not add the campaign to the database.
	 *
	 * @param campaignId the primary key for the new campaign
	 * @return the new campaign
	 */
	public static eu.strasbourg.service.agenda.model.Campaign createCampaign(
		long campaignId) {

		return getService().createCampaign(campaignId);
	}

	/**
	 * Crée une campaign vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.agenda.model.Campaign createCampaign(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createCampaign(sc);
	}

	/**
	 * Deletes the campaign from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was removed
	 */
	public static eu.strasbourg.service.agenda.model.Campaign deleteCampaign(
		eu.strasbourg.service.agenda.model.Campaign campaign) {

		return getService().deleteCampaign(campaign);
	}

	/**
	 * Deletes the campaign with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign that was removed
	 * @throws PortalException if a campaign with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.Campaign deleteCampaign(
			long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCampaign(campaignId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
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

	/**
	 * Exporte toutes les campagne exportables dans le dossier d'import des événements
	 */
	public static void exportCampaigns() {
		getService().exportCampaigns();
	}

	public static eu.strasbourg.service.agenda.model.Campaign fetchCampaign(
		long campaignId) {

		return getService().fetchCampaign(campaignId);
	}

	/**
	 * Returns the campaign matching the UUID and group.
	 *
	 * @param uuid the campaign's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign, or <code>null</code> if a matching campaign could not be found
	 */
	public static eu.strasbourg.service.agenda.model.Campaign
		fetchCampaignByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.Campaign>
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
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	public static java.util.List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les campaigns d'un groupe
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.Campaign>
		getByGroupId(long groupId) {

		return getService().getByGroupId(groupId);
	}

	/**
	 * Returns the campaign with the primary key.
	 *
	 * @param campaignId the primary key of the campaign
	 * @return the campaign
	 * @throws PortalException if a campaign with the primary key could not be found
	 */
	public static eu.strasbourg.service.agenda.model.Campaign getCampaign(
			long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCampaign(campaignId);
	}

	/**
	 * Returns the campaign matching the UUID and group.
	 *
	 * @param uuid the campaign's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign
	 * @throws PortalException if a matching campaign could not be found
	 */
	public static eu.strasbourg.service.agenda.model.Campaign
			getCampaignByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCampaignByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the campaigns.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @return the range of campaigns
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.Campaign>
		getCampaigns(int start, int end) {

		return getService().getCampaigns(start, end);
	}

	/**
	 * Returns all the campaigns matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaigns
	 * @param companyId the primary key of the company
	 * @return the matching campaigns, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.Campaign>
		getCampaignsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCampaignsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of campaigns matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaigns
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of campaigns
	 * @param end the upper bound of the range of campaigns (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching campaigns, or an empty list if no matches were found
	 */
	public static java.util.List<eu.strasbourg.service.agenda.model.Campaign>
		getCampaignsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.agenda.model.Campaign>
					orderByComparator) {

		return getService().getCampaignsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of campaigns.
	 *
	 * @return the number of campaigns
	 */
	public static int getCampaignsCount() {
		return getService().getCampaignsCount();
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime une campaign
	 */
	public static eu.strasbourg.service.agenda.model.Campaign removeCampaign(
			long campaignId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeCampaign(campaignId);
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
	 * Updates the campaign in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaign the campaign
	 * @return the campaign that was updated
	 */
	public static eu.strasbourg.service.agenda.model.Campaign updateCampaign(
		eu.strasbourg.service.agenda.model.Campaign campaign) {

		return getService().updateCampaign(campaign);
	}

	/**
	 * Met à jour une campaign et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.agenda.model.Campaign updateCampaign(
			eu.strasbourg.service.agenda.model.Campaign campaign,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCampaign(campaign, sc);
	}

	/**
	 * Met à jour le statut de l'campaign "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.agenda.model.Campaign campaign, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(campaign, status);
	}

	/**
	 * Met à jour le statut de l'campaign par le framework workflow
	 */
	public static eu.strasbourg.service.agenda.model.Campaign updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static CampaignLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampaignLocalService, CampaignLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CampaignLocalService.class);

		ServiceTracker<CampaignLocalService, CampaignLocalService>
			serviceTracker =
				new ServiceTracker<CampaignLocalService, CampaignLocalService>(
					bundle.getBundleContext(), CampaignLocalService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}