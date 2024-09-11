/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.oidc.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.oidc.model.PublikUser;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PublikUser. This utility wraps
 * <code>eu.strasbourg.service.oidc.service.impl.PublikUserLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserLocalService
 * @generated
 */
public class PublikUserLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.oidc.service.impl.PublikUserLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the publik user to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was added
	 */
	public static PublikUser addPublikUser(PublikUser publikUser) {
		return getService().addPublikUser(publikUser);
	}

	/**
	 * Anonymise l'utilisateur pour placit
	 * suppression de la signature du pacte,
	 * anonymisation de ProjectFollowed, EventParticipation, Petition, Signataire, BudgetParticipatif,
	 *     BudgetSupport, Initiative, InitiativeHelp, Comment et Like
	 */
	public static void anonymisedUserPlacit(
		PublikUser anonymUser, PublikUser publikUser) {

		getService().anonymisedUserPlacit(anonymUser, publikUser);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static PublikUser createPublikUser() {
		return getService().createPublikUser();
	}

	/**
	 * Creates a new publik user with the primary key. Does not add the publik user to the database.
	 *
	 * @param publikUserLiferayId the primary key for the new publik user
	 * @return the new publik user
	 */
	public static PublikUser createPublikUser(long publikUserLiferayId) {
		return getService().createPublikUser(publikUserLiferayId);
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
	 * Deletes the publik user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user that was removed
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	public static PublikUser deletePublikUser(long publikUserLiferayId)
		throws PortalException {

		return getService().deletePublikUser(publikUserLiferayId);
	}

	/**
	 * Deletes the publik user from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was removed
	 */
	public static PublikUser deletePublikUser(PublikUser publikUser) {
		return getService().deletePublikUser(publikUser);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
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

	public static PublikUser fetchPublikUser(long publikUserLiferayId) {
		return getService().fetchPublikUser(publikUserLiferayId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * sans critere
	 *
	 * @return Liste de tous les utilisateurs Publik
	 */
	public static List<PublikUser> getAllPublikUsers() {
		return getService().getAllPublikUsers();
	}

	public static List<PublikUser> getByPactSignatureAndPactDisplay() {
		return getService().getByPactSignatureAndPactDisplay();
	}

	public static PublikUser getByPublikUserId(String publikUserId) {
		return getService().getByPublikUserId(publikUserId);
	}

	/**
	 * méthode permettant de récupererer le nombre de signataire.
	 *
	 * @return le nombre de signataire.
	 */
	public static long getCountUserHasSignedPacte() {
		return getService().getCountUserHasSignedPacte();
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
	 * Returns the publik user with the primary key.
	 *
	 * @param publikUserLiferayId the primary key of the publik user
	 * @return the publik user
	 * @throws PortalException if a publik user with the primary key could not be found
	 */
	public static PublikUser getPublikUser(long publikUserLiferayId)
		throws PortalException {

		return getService().getPublikUser(publikUserLiferayId);
	}

	/**
	 * Returns a range of all the publik users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.oidc.model.impl.PublikUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publik users
	 * @param end the upper bound of the range of publik users (not inclusive)
	 * @return the range of publik users
	 */
	public static List<PublikUser> getPublikUsers(int start, int end) {
		return getService().getPublikUsers(start, end);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	public static List<PublikUser> getPublikUsers(
		int start, int end, String sortField, boolean isSortDesc) {

		return getService().getPublikUsers(start, end, sortField, isSortDesc);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * avec recherche et pagination
	 *
	 * @param start Debut de l'index de recherche pour la pagination
	 * @param end Fin de l'index de recherche pour la pagination
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	public static List<PublikUser> getPublikUsers(
		int start, int end, String keywords, String sortField,
		boolean isSortDesc) {

		return getService().getPublikUsers(
			start, end, keywords, sortField, isSortDesc);
	}

	/**
	 * Rechercher des utilisateurs Publik directement via l'outil de persistance
	 * sans pagination
	 *
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	public static List<PublikUser> getPublikUsers(
		String sortField, boolean isSortDesc) {

		return getService().getPublikUsers(sortField, isSortDesc);
	}

	/**
	 * Rechercher tous les utilisateurs Publik directement via l'outil de persistance
	 * avec recherche mais sans pagination
	 *
	 * @param keywords Mots-clefs pour la recherche sur le nom, prenom, email
	 * @param sortField Champ de tri utilisé
	 * @param isSortDesc La liste est-elle triée par ordre decroissant ?
	 * @return Liste des utilisateurs trouvés
	 */
	public static List<PublikUser> getPublikUsers(
		String keywords, String sortField, boolean isSortDesc) {

		return getService().getPublikUsers(keywords, sortField, isSortDesc);
	}

	/**
	 * Returns the number of publik users.
	 *
	 * @return the number of publik users
	 */
	public static int getPublikUsersCount() {
		return getService().getPublikUsersCount();
	}

	/**
	 * Supprime une entité
	 */
	public static PublikUser removePublikUser(String publikUserId) {
		return getService().removePublikUser(publikUserId);
	}

	/**
	 * Updates the publik user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PublikUserLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param publikUser the publik user
	 * @return the publik user that was updated
	 */
	public static PublikUser updatePublikUser(PublikUser publikUser) {
		return getService().updatePublikUser(publikUser);
	}

	/**
	 * Met à jour un utilisateur Publik et l'enregistre en base
	 *
	 * @return L'utilisateur Publik modifié
	 */
	public static PublikUser updatePublikUser(
			PublikUser publikUser,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updatePublikUser(publikUser, sc);
	}

	/**
	 * Enregistre ou update l'utilisateur en base
	 */
	public static void updateUserInfoInDatabase(
		String internalId, String accessToken, String givenName,
		String familyName, String email, String photo, String accordPlacit,
		String listingPlacit) {

		getService().updateUserInfoInDatabase(
			internalId, accessToken, givenName, familyName, email, photo,
			accordPlacit, listingPlacit);
	}

	public static PublikUserLocalService getService() {
		return _service;
	}

	public static void setService(PublikUserLocalService service) {
		_service = service;
	}

	private static volatile PublikUserLocalService _service;

}