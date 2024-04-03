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

import eu.strasbourg.service.project.model.Signataire;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Signataire. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.SignataireLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see SignataireLocalService
 * @generated
 */
public class SignataireLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.SignataireLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the signataire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was added
	 */
	public static Signataire addSignataire(Signataire signataire) {
		return getService().addSignataire(signataire);
	}

	/**
	 * méthode permettant de compter le nombre de faux signataire
	 *
	 * @param petitionId la pétition concernée
	 * @return le nombre de signataires
	 */
	public static int countFakeSignataireByPetition(long petitionId) {
		return getService().countFakeSignataireByPetition(petitionId);
	}

	/**
	 * méthode permettant de récuperer les signataires par l'identifiant de la pétition.
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	public static int countSignataireByPetitionId(long petitionId) {
		return getService().countSignataireByPetitionId(petitionId);
	}

	/**
	 * méthode de création de faux signataires
	 *
	 * @param petitionId la pétition concernée
	 * @param nombreCreation le nombre de creation souhaité.
	 */
	public static void createFakeSignataire(
		long petitionId, int nombreCreation) {

		getService().createFakeSignataire(petitionId, nombreCreation);
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
	 * Creates a new signataire with the primary key. Does not add the signataire to the database.
	 *
	 * @param signataireId the primary key for the new signataire
	 * @return the new signataire
	 */
	public static Signataire createSignataire(long signataireId) {
		return getService().createSignataire(signataireId);
	}

	/**
	 * méthode de creation de signataire.
	 *
	 * @param sc le context.
	 * @return le signataire crée.
	 */
	public static Signataire createSignataire(
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createSignataire(sc);
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
	 * Deletes the signataire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire that was removed
	 * @throws PortalException if a signataire with the primary key could not be found
	 */
	public static Signataire deleteSignataire(long signataireId)
		throws PortalException {

		return getService().deleteSignataire(signataireId);
	}

	/**
	 * Deletes the signataire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was removed
	 */
	public static Signataire deleteSignataire(Signataire signataire) {
		return getService().deleteSignataire(signataire);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
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

	public static Signataire fetchSignataire(long signataireId) {
		return getService().fetchSignataire(signataireId);
	}

	/**
	 * Returns the signataire matching the UUID and group.
	 *
	 * @param uuid the signataire's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	public static Signataire fetchSignataireByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSignataireByUuidAndGroupId(uuid, groupId);
	}

	public static List<Signataire> findSignatairesByPetitionIdAndPublikUserId(
			long petitionId, String publikUserId)
		throws javax.portlet.PortletException {

		return getService().findSignatairesByPetitionIdAndPublikUserId(
			petitionId, publikUserId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * méthode permettant de récuperer tous les signataires par l'identifiant de la pétition y compris les entree anonymes (Signatures papiers)
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	public static List<Signataire> getAllSignatairesByPetitionId(
		long petitionId) {

		return getService().getAllSignatairesByPetitionId(petitionId);
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
	 * Returns the signataire with the primary key.
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire
	 * @throws PortalException if a signataire with the primary key could not be found
	 */
	public static Signataire getSignataire(long signataireId)
		throws PortalException {

		return getService().getSignataire(signataireId);
	}

	public static List<Signataire> getSignataireByPublikId(String publikId) {
		return getService().getSignataireByPublikId(publikId);
	}

	/**
	 * Returns the signataire matching the UUID and group.
	 *
	 * @param uuid the signataire's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signataire
	 * @throws PortalException if a matching signataire could not be found
	 */
	public static Signataire getSignataireByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSignataireByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the signataires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of signataires
	 */
	public static List<Signataire> getSignataires(int start, int end) {
		return getService().getSignataires(start, end);
	}

	/**
	 * méthode permettant de récuperer les signataires par l'identifiant de la pétition. Ne prend pas les entree anonymes (Signatures papiers)
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	public static List<Signataire> getSignatairesByPetitionId(long petitionId) {
		return getService().getSignatairesByPetitionId(petitionId);
	}

	/**
	 * Returns all the signataires matching the UUID and company.
	 *
	 * @param uuid the UUID of the signataires
	 * @param companyId the primary key of the company
	 * @return the matching signataires, or an empty list if no matches were found
	 */
	public static List<Signataire> getSignatairesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSignatairesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of signataires matching the UUID and company.
	 *
	 * @param uuid the UUID of the signataires
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching signataires, or an empty list if no matches were found
	 */
	public static List<Signataire> getSignatairesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signataire> orderByComparator) {

		return getService().getSignatairesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of signataires.
	 *
	 * @return the number of signataires
	 */
	public static int getSignatairesCount() {
		return getService().getSignatairesCount();
	}

	public static void removeSignataire(long signataireId) {
		getService().removeSignataire(signataireId);
	}

	/**
	 * Updates the signataire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was updated
	 */
	public static Signataire updateSignataire(Signataire signataire) {
		return getService().updateSignataire(signataire);
	}

	public static SignataireLocalService getService() {
		return _service;
	}

	public static void setService(SignataireLocalService service) {
		_service = service;
	}

	private static volatile SignataireLocalService _service;

}