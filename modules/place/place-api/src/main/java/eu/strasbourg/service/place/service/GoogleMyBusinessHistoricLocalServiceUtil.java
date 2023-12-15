/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

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
	public static GoogleMyBusinessHistoric addGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric) {

		return getService().addGoogleMyBusinessHistoric(
			googleMyBusinessHistoric);
	}

	/**
	 * Creates a new google my business historic with the primary key. Does not add the google my business historic to the database.
	 *
	 * @param googleMyBusinessHistoricId the primary key for the new google my business historic
	 * @return the new google my business historic
	 */
	public static GoogleMyBusinessHistoric createGoogleMyBusinessHistoric(
		long googleMyBusinessHistoricId) {

		return getService().createGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * Crée une entrée googleMyBusiness vide avec une PK, non ajouté à la base de donnée
	 */
	public static GoogleMyBusinessHistoric createGoogleMyBusinessHistoric(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createGoogleMyBusinessHistoric(sc);
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
	 * Deletes the google my business historic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was removed
	 */
	public static GoogleMyBusinessHistoric deleteGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric) {

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
	public static GoogleMyBusinessHistoric deleteGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException {

		return getService().deleteGoogleMyBusinessHistoric(
			googleMyBusinessHistoricId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Effectue la synchronisation
	 */
	public static void doSynchronisation(
		com.liferay.portal.kernel.service.ServiceContext sc,
		GoogleMyBusinessHistoric googleMyBusinessHistoric) {

		getService().doSynchronisation(sc, googleMyBusinessHistoric);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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

	public static GoogleMyBusinessHistoric fetchGoogleMyBusinessHistoric(
		long googleMyBusinessHistoricId) {

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
	public static GoogleMyBusinessHistoric
		fetchGoogleMyBusinessHistoricByUuidAndGroupId(
			String uuid, long groupId) {

		return getService().fetchGoogleMyBusinessHistoricByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<GoogleMyBusinessHistoric> findByKeyword(
		String keyword, long groupId, int start, int end) {

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
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les google mybusiness d'un groupe
	 */
	public static List<GoogleMyBusinessHistoric> getByGroupId(long groupId) {
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
	public static GoogleMyBusinessHistoric getGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException {

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
	public static GoogleMyBusinessHistoric
			getGoogleMyBusinessHistoricByUuidAndGroupId(
				String uuid, long groupId)
		throws PortalException {

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
	public static List<GoogleMyBusinessHistoric> getGoogleMyBusinessHistorics(
		int start, int end) {

		return getService().getGoogleMyBusinessHistorics(start, end);
	}

	/**
	 * Returns all the google my business historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the google my business historics
	 * @param companyId the primary key of the company
	 * @return the matching google my business historics, or an empty list if no matches were found
	 */
	public static List<GoogleMyBusinessHistoric>
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
	public static List<GoogleMyBusinessHistoric>
		getGoogleMyBusinessHistoricsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<GoogleMyBusinessHistoric> orderByComparator) {

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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime l'entree google mybusiness
	 */
	public static GoogleMyBusinessHistoric removeGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException {

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
	public static GoogleMyBusinessHistoric updateGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric) {

		return getService().updateGoogleMyBusinessHistoric(
			googleMyBusinessHistoric);
	}

	/**
	 * Met à jour une entree google mybusiness et l'enregistre en base de données
	 *
	 * @throws PortalException
	 */
	public static GoogleMyBusinessHistoric updateGoogleMyBusinessHistoric(
			GoogleMyBusinessHistoric googleMyBusinessHistoric,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateGoogleMyBusinessHistoric(
			googleMyBusinessHistoric, sc);
	}

	/**
	 * Met à jour le statut de l'entree google mybusiness "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			GoogleMyBusinessHistoric googleMyBusinessHistoric, int status)
		throws PortalException {

		getService().updateStatus(googleMyBusinessHistoric, status);
	}

	/**
	 * Met à jour le statut de l'entree google mybusiness par le framework workflow
	 */
	public static GoogleMyBusinessHistoric updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static GoogleMyBusinessHistoricLocalService getService() {
		return _service;
	}

	public static void setService(
		GoogleMyBusinessHistoricLocalService service) {

		_service = service;
	}

	private static volatile GoogleMyBusinessHistoricLocalService _service;

}