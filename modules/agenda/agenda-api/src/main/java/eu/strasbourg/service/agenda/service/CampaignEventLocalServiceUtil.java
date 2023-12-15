/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.agenda.model.CampaignEvent;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CampaignEvent. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.CampaignEventLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see CampaignEventLocalService
 * @generated
 */
public class CampaignEventLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.CampaignEventLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the campaign event to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignEvent the campaign event
	 * @return the campaign event that was added
	 */
	public static CampaignEvent addCampaignEvent(CampaignEvent campaignEvent) {
		return getService().addCampaignEvent(campaignEvent);
	}

	/**
	 * Creates a new campaign event with the primary key. Does not add the campaign event to the database.
	 *
	 * @param campaignEventId the primary key for the new campaign event
	 * @return the new campaign event
	 */
	public static CampaignEvent createCampaignEvent(long campaignEventId) {
		return getService().createCampaignEvent(campaignEventId);
	}

	/**
	 * Crée une campaignEvent vide avec une PK, non ajouté à la base de donnée
	 */
	public static CampaignEvent createCampaignEvent(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createCampaignEvent(sc);
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
	 * Deletes the campaign event from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignEvent the campaign event
	 * @return the campaign event that was removed
	 */
	public static CampaignEvent deleteCampaignEvent(
		CampaignEvent campaignEvent) {

		return getService().deleteCampaignEvent(campaignEvent);
	}

	/**
	 * Deletes the campaign event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event that was removed
	 * @throws PortalException if a campaign event with the primary key could not be found
	 */
	public static CampaignEvent deleteCampaignEvent(long campaignEventId)
		throws PortalException {

		return getService().deleteCampaignEvent(campaignEventId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl</code>.
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

	public static CampaignEvent fetchCampaignEvent(long campaignEventId) {
		return getService().fetchCampaignEvent(campaignEventId);
	}

	/**
	 * Returns the campaign event matching the UUID and group.
	 *
	 * @param uuid the campaign event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign event, or <code>null</code> if a matching campaign event could not be found
	 */
	public static CampaignEvent fetchCampaignEventByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCampaignEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Retourne les événements d'une campagne
	 */
	public static List<CampaignEvent> findByCampaignId(long campaignId) {
		return getService().findByCampaignId(campaignId);
	}

	/**
	 * Lance une recherche par mots-clés, thème et status
	 */
	public static List<CampaignEvent> findByKeywordThemeAndStatus(
		String keyword, long themeId, int status, long userId, long groupId,
		int start, int end) {

		return getService().findByKeywordThemeAndStatus(
			keyword, themeId, status, userId, groupId, start, end);
	}

	/**
	 * Compte de la recherche par mots-clés, thème et status
	 */
	public static long findByKeywordThemeAndStatusCount(
		String keyword, long themeId, int status, long userId, long groupId) {

		return getService().findByKeywordThemeAndStatusCount(
			keyword, themeId, status, userId, groupId);
	}

	/**
	 * Lance une recherche par mots-clés, thème, type, campagne et status
	 */
	public static List<CampaignEvent> findByKeywordThemeTypeCampaignAndStatus(
		String keyword, long themeId, long typeId, long campaignId, int status,
		long userId, long groupId, int start, int end) {

		return getService().findByKeywordThemeTypeCampaignAndStatus(
			keyword, themeId, typeId, campaignId, status, userId, groupId,
			start, end);
	}

	/**
	 * Compte de la recherche par mots-clés, thème, type, campagne et status
	 */
	public static long findByKeywordThemeTypeCampaignAndStatusCount(
		String keyword, long themeId, long typeId, long campaignId, int status,
		long userId, long groupId) {

		return getService().findByKeywordThemeTypeCampaignAndStatusCount(
			keyword, themeId, typeId, campaignId, status, userId, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the campaign event with the primary key.
	 *
	 * @param campaignEventId the primary key of the campaign event
	 * @return the campaign event
	 * @throws PortalException if a campaign event with the primary key could not be found
	 */
	public static CampaignEvent getCampaignEvent(long campaignEventId)
		throws PortalException {

		return getService().getCampaignEvent(campaignEventId);
	}

	/**
	 * Returns the campaign event matching the UUID and group.
	 *
	 * @param uuid the campaign event's UUID
	 * @param groupId the primary key of the group
	 * @return the matching campaign event
	 * @throws PortalException if a matching campaign event could not be found
	 */
	public static CampaignEvent getCampaignEventByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCampaignEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the campaign events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.CampaignEventModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @return the range of campaign events
	 */
	public static List<CampaignEvent> getCampaignEvents(int start, int end) {
		return getService().getCampaignEvents(start, end);
	}

	/**
	 * Returns all the campaign events matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaign events
	 * @param companyId the primary key of the company
	 * @return the matching campaign events, or an empty list if no matches were found
	 */
	public static List<CampaignEvent> getCampaignEventsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCampaignEventsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of campaign events matching the UUID and company.
	 *
	 * @param uuid the UUID of the campaign events
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of campaign events
	 * @param end the upper bound of the range of campaign events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching campaign events, or an empty list if no matches were found
	 */
	public static List<CampaignEvent> getCampaignEventsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CampaignEvent> orderByComparator) {

		return getService().getCampaignEventsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of campaign events.
	 *
	 * @return the number of campaign events
	 */
	public static int getCampaignEventsCount() {
		return getService().getCampaignEventsCount();
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
	 * Supprime une campaignEvent
	 */
	public static CampaignEvent removeCampaignEvent(long campaignEventId)
		throws PortalException {

		return getService().removeCampaignEvent(campaignEventId);
	}

	/**
	 * Updates the campaign event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CampaignEventLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param campaignEvent the campaign event
	 * @return the campaign event that was updated
	 */
	public static CampaignEvent updateCampaignEvent(
		CampaignEvent campaignEvent) {

		return getService().updateCampaignEvent(campaignEvent);
	}

	public static CampaignEventLocalService getService() {
		return _service;
	}

	public static void setService(CampaignEventLocalService service) {
		_service = service;
	}

	private static volatile CampaignEventLocalService _service;

}