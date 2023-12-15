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

import eu.strasbourg.service.agenda.model.Manifestation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Manifestation. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.ManifestationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author BenjaminBini
 * @see ManifestationLocalService
 * @generated
 */
public class ManifestationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.ManifestationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean addEventManifestation(
		long eventId, long manifestationId) {

		return getService().addEventManifestation(eventId, manifestationId);
	}

	public static boolean addEventManifestation(
		long eventId, Manifestation manifestation) {

		return getService().addEventManifestation(eventId, manifestation);
	}

	public static boolean addEventManifestations(
		long eventId, List<Manifestation> manifestations) {

		return getService().addEventManifestations(eventId, manifestations);
	}

	public static boolean addEventManifestations(
		long eventId, long[] manifestationIds) {

		return getService().addEventManifestations(eventId, manifestationIds);
	}

	/**
	 * Adds the manifestation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was added
	 */
	public static Manifestation addManifestation(Manifestation manifestation) {
		return getService().addManifestation(manifestation);
	}

	/**
	 * Modifie le statut de tous les manifestations au statut "SCHEDULED" qui
	 * ont une date de publication dans le futur
	 */
	public static void checkManifestations() throws PortalException {
		getService().checkManifestations();
	}

	public static void clearEventManifestations(long eventId) {
		getService().clearEventManifestations(eventId);
	}

	/**
	 * Creates a new manifestation with the primary key. Does not add the manifestation to the database.
	 *
	 * @param manifestationId the primary key for the new manifestation
	 * @return the new manifestation
	 */
	public static Manifestation createManifestation(long manifestationId) {
		return getService().createManifestation(manifestationId);
	}

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public static Manifestation createManifestation(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createManifestation(sc);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static void deleteEventManifestation(
		long eventId, long manifestationId) {

		getService().deleteEventManifestation(eventId, manifestationId);
	}

	public static void deleteEventManifestation(
		long eventId, Manifestation manifestation) {

		getService().deleteEventManifestation(eventId, manifestation);
	}

	public static void deleteEventManifestations(
		long eventId, List<Manifestation> manifestations) {

		getService().deleteEventManifestations(eventId, manifestations);
	}

	public static void deleteEventManifestations(
		long eventId, long[] manifestationIds) {

		getService().deleteEventManifestations(eventId, manifestationIds);
	}

	/**
	 * Deletes the manifestation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation that was removed
	 * @throws PortalException if a manifestation with the primary key could not be found
	 */
	public static Manifestation deleteManifestation(long manifestationId)
		throws PortalException {

		return getService().deleteManifestation(manifestationId);
	}

	/**
	 * Deletes the manifestation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was removed
	 */
	public static Manifestation deleteManifestation(
		Manifestation manifestation) {

		return getService().deleteManifestation(manifestation);
	}

	/**
	 * Supprime les manifestations dépubliés depuis au moins un mois
	 */
	public static void deleteOldUnpublishedManifestations()
		throws PortalException {

		getService().deleteOldUnpublishedManifestations();
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
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

	public static Manifestation fetchManifestation(long manifestationId) {
		return getService().fetchManifestation(manifestationId);
	}

	/**
	 * Returns the manifestation matching the UUID and group.
	 *
	 * @param uuid the manifestation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching manifestation, or <code>null</code> if a matching manifestation could not be found
	 */
	public static Manifestation fetchManifestationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchManifestationByUuidAndGroupId(uuid, groupId);
	}

	public static Manifestation findByIdSource(String idSource) {
		return getService().findByIdSource(idSource);
	}

	public static List<Manifestation> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	public static long findByKeywordCount(String keyword, long groupId) {
		return getService().findByKeywordCount(keyword, groupId);
	}

	public static Manifestation findBySourceAndIdSource(
		String source, String idSource) {

		return getService().findBySourceAndIdSource(source, idSource);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les galeries éditions d'un groupe
	 */
	public static List<Manifestation> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static List<Manifestation> getEventManifestations(long eventId) {
		return getService().getEventManifestations(eventId);
	}

	public static List<Manifestation> getEventManifestations(
		long eventId, int start, int end) {

		return getService().getEventManifestations(eventId, start, end);
	}

	public static List<Manifestation> getEventManifestations(
		long eventId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getService().getEventManifestations(
			eventId, start, end, orderByComparator);
	}

	public static int getEventManifestationsCount(long eventId) {
		return getService().getEventManifestationsCount(eventId);
	}

	/**
	 * Returns the eventIds of the events associated with the manifestation.
	 *
	 * @param manifestationId the manifestationId of the manifestation
	 * @return long[] the eventIds of events associated with the manifestation
	 */
	public static long[] getEventPrimaryKeys(long manifestationId) {
		return getService().getEventPrimaryKeys(manifestationId);
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
	 * Returns the manifestation with the primary key.
	 *
	 * @param manifestationId the primary key of the manifestation
	 * @return the manifestation
	 * @throws PortalException if a manifestation with the primary key could not be found
	 */
	public static Manifestation getManifestation(long manifestationId)
		throws PortalException {

		return getService().getManifestation(manifestationId);
	}

	/**
	 * Returns the manifestation matching the UUID and group.
	 *
	 * @param uuid the manifestation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching manifestation
	 * @throws PortalException if a matching manifestation could not be found
	 */
	public static Manifestation getManifestationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getManifestationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the manifestations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.ManifestationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @return the range of manifestations
	 */
	public static List<Manifestation> getManifestations(int start, int end) {
		return getService().getManifestations(start, end);
	}

	/**
	 * Returns all the manifestations matching the UUID and company.
	 *
	 * @param uuid the UUID of the manifestations
	 * @param companyId the primary key of the company
	 * @return the matching manifestations, or an empty list if no matches were found
	 */
	public static List<Manifestation> getManifestationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getManifestationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of manifestations matching the UUID and company.
	 *
	 * @param uuid the UUID of the manifestations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of manifestations
	 * @param end the upper bound of the range of manifestations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching manifestations, or an empty list if no matches were found
	 */
	public static List<Manifestation> getManifestationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Manifestation> orderByComparator) {

		return getService().getManifestationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of manifestations.
	 *
	 * @return the number of manifestations
	 */
	public static int getManifestationsCount() {
		return getService().getManifestationsCount();
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

	public static boolean hasEventManifestation(
		long eventId, long manifestationId) {

		return getService().hasEventManifestation(eventId, manifestationId);
	}

	public static boolean hasEventManifestations(long eventId) {
		return getService().hasEventManifestations(eventId);
	}

	/**
	 * Delete an Event Manifestation
	 *
	 * @param manifestationId
	 The ID of the event manifestation to delete
	 * @return The deleted Manifestation
	 * @throws PortalException
	 */
	public static Manifestation removeManifestation(long manifestationId)
		throws PortalException {

		return getService().removeManifestation(manifestationId);
	}

	public static com.liferay.portal.kernel.search.Hits search(
			com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.SearchException {

		return getService().search(searchContext);
	}

	public static void setEventManifestations(
		long eventId, long[] manifestationIds) {

		getService().setEventManifestations(eventId, manifestationIds);
	}

	/**
	 * Dépublie les manifestations dont la date de fin est dépassée
	 */
	public static void unpublishPastManifestations() throws PortalException {
		getService().unpublishPastManifestations();
	}

	/**
	 * Updates the manifestation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ManifestationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param manifestation the manifestation
	 * @return the manifestation that was updated
	 */
	public static Manifestation updateManifestation(
		Manifestation manifestation) {

		return getService().updateManifestation(manifestation);
	}

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public static Manifestation updateManifestation(
			Manifestation manifestation,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateManifestation(manifestation, sc);
	}

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public static Manifestation updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Manifestation manifestation, int status)
		throws PortalException {

		getService().updateStatus(manifestation, status);
	}

	public static ManifestationLocalService getService() {
		return _service;
	}

	public static void setService(ManifestationLocalService service) {
		_service = service;
	}

	private static volatile ManifestationLocalService _service;

}