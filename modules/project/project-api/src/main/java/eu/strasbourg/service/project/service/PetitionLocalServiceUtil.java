/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.Petition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Petition. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.PetitionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see PetitionLocalService
 * @generated
 */
public class PetitionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.PetitionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the petition to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petition the petition
	 * @return the petition that was added
	 */
	public static Petition addPetition(Petition petition) {
		return getService().addPetition(petition);
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
	 * Creates a new petition with the primary key. Does not add the petition to the database.
	 *
	 * @param petitionId the primary key for the new petition
	 * @return the new petition
	 */
	public static Petition createPetition(long petitionId) {
		return getService().createPetition(petitionId);
	}

	/**
	 * Crée une participation vide avec une PK, non ajouté à la base de donnée
	 */
	public static Petition createPetition(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createPetition(sc);
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
	 * Deletes the petition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petitionId the primary key of the petition
	 * @return the petition that was removed
	 * @throws PortalException if a petition with the primary key could not be found
	 */
	public static Petition deletePetition(long petitionId)
		throws PortalException {

		return getService().deletePetition(petitionId);
	}

	/**
	 * Deletes the petition from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petition the petition
	 * @return the petition that was removed
	 */
	public static Petition deletePetition(Petition petition) {
		return getService().deletePetition(petition);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PetitionModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PetitionModelImpl</code>.
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

	public static Petition fetchPetition(long petitionId) {
		return getService().fetchPetition(petitionId);
	}

	/**
	 * Returns the petition matching the UUID and group.
	 *
	 * @param uuid the petition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching petition, or <code>null</code> if a matching petition could not be found
	 */
	public static Petition fetchPetitionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPetitionByUuidAndGroupId(uuid, groupId);
	}

	public static List<Petition> findByKeyword(
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
	 * Renvoie la liste des vocabulaires rattachés à une petition
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne tous les petitions d'un groupe
	 */
	public static List<Petition> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	public static List<Petition> getByPublikUserID(String publikId) {
		return getService().getByPublikUserID(publikId);
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
	 * Returns the petition with the primary key.
	 *
	 * @param petitionId the primary key of the petition
	 * @return the petition
	 * @throws PortalException if a petition with the primary key could not be found
	 */
	public static Petition getPetition(long petitionId) throws PortalException {
		return getService().getPetition(petitionId);
	}

	public static List<Petition> getPetitionByPublikUserID(String publikId) {
		return getService().getPetitionByPublikUserID(publikId);
	}

	public static List<Petition> getPetitionBySignatairePublikId(
		String publikId) {

		return getService().getPetitionBySignatairePublikId(publikId);
	}

	/**
	 * Returns the petition matching the UUID and group.
	 *
	 * @param uuid the petition's UUID
	 * @param groupId the primary key of the group
	 * @return the matching petition
	 * @throws PortalException if a matching petition could not be found
	 */
	public static Petition getPetitionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPetitionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the petitions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PetitionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @return the range of petitions
	 */
	public static List<Petition> getPetitions(int start, int end) {
		return getService().getPetitions(start, end);
	}

	/**
	 * Returns all the petitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the petitions
	 * @param companyId the primary key of the company
	 * @return the matching petitions, or an empty list if no matches were found
	 */
	public static List<Petition> getPetitionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPetitionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of petitions matching the UUID and company.
	 *
	 * @param uuid the UUID of the petitions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of petitions
	 * @param end the upper bound of the range of petitions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching petitions, or an empty list if no matches were found
	 */
	public static List<Petition> getPetitionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Petition> orderByComparator) {

		return getService().getPetitionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of petitions.
	 *
	 * @return the number of petitions
	 */
	public static int getPetitionsCount() {
		return getService().getPetitionsCount();
	}

	/**
	 * Retourne tous les petitions publiées d'un groupe
	 */
	public static List<Petition> getPublishedByGroupId(long groupId) {
		return getService().getPublishedByGroupId(groupId);
	}

	public static List<Petition> getTheMostCommented(long groupId) {
		return getService().getTheMostCommented(groupId);
	}

	/**
	 * Méthode permettant de trier les petitions
	 *
	 * @return
	 */
	public static List<Petition> getTheMostSigned(long groupId) {
		return getService().getTheMostSigned(groupId);
	}

	public static List<Petition> getTheThreeLessSigned(long groupId) {
		return getService().getTheThreeLessSigned(groupId);
	}

	/**
	 * @return
	 */
	public static List<Petition> getTheThreeMostSigned(long groupId) {
		return getService().getTheThreeMostSigned(groupId);
	}

	/**
	 * Supprime une petition
	 */
	public static Petition removePetition(long petitionId)
		throws PortalException {

		return getService().removePetition(petitionId);
	}

	public static void updateAllPetitionsStatus() throws PortalException {
		getService().updateAllPetitionsStatus();
	}

	/**
	 * Updates the petition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PetitionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param petition the petition
	 * @return the petition that was updated
	 */
	public static Petition updatePetition(Petition petition) {
		return getService().updatePetition(petition);
	}

	public static Petition updatePetition(
			Petition petition,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updatePetition(petition, sc);
	}

	public static Petition updateStatus(
			long userId, long petitionId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, petitionId, status, serviceContext, workflowContext);
	}

	/**
	 * Met à jour le statut du petition "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Petition petition, int status)
		throws PortalException {

		getService().updateStatus(petition, status);
	}

	public static PetitionLocalService getService() {
		return _service;
	}

	public static void setService(PetitionLocalService service) {
		_service = service;
	}

	private static volatile PetitionLocalService _service;

}