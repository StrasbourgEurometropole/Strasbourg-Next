/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.council.model.Vote;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Vote. This utility wraps
 * <code>eu.strasbourg.service.council.service.impl.VoteLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see VoteLocalService
 * @generated
 */
public class VoteLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.VoteLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the vote to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was added
	 */
	public static Vote addVote(Vote vote) {
		return getService().addVote(vote);
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
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static Vote createVote(
		long officialId, long deliberationId,
		com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().createVote(officialId, deliberationId, sc);
	}

	/**
	 * Creates a new vote with the primary key. Does not add the vote to the database.
	 *
	 * @param votePK the primary key for the new vote
	 * @return the new vote
	 */
	public static Vote createVote(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return getService().createVote(votePK);
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
	 * Deletes the vote from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was removed
	 */
	public static Vote deleteVote(Vote vote) {
		return getService().deleteVote(vote);
	}

	/**
	 * Deletes the vote with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote that was removed
	 * @throws PortalException if a vote with the primary key could not be found
	 */
	public static Vote deleteVote(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws PortalException {

		return getService().deleteVote(votePK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
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

	public static Vote fetchVote(
		eu.strasbourg.service.council.service.persistence.VotePK votePK) {

		return getService().fetchVote(votePK);
	}

	/**
	 * Returns the vote matching the UUID and group.
	 *
	 * @param uuid the vote's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vote, or <code>null</code> if a matching vote could not be found
	 */
	public static Vote fetchVoteByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchVoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Retourne la liste des votes d'une délibération
	 */
	public static List<Vote> findByDeliberationId(long deliberationId) {
		return getService().findByDeliberationId(deliberationId);
	}

	/**
	 * Retourne le vote d'un élu pour une délibération
	 */
	public static Vote findByDeliberationIdandOfficialId(
		long deliberationId, long officialId) {

		return getService().findByDeliberationIdandOfficialId(
			deliberationId, officialId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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
	 * Returns the vote with the primary key.
	 *
	 * @param votePK the primary key of the vote
	 * @return the vote
	 * @throws PortalException if a vote with the primary key could not be found
	 */
	public static Vote getVote(
			eu.strasbourg.service.council.service.persistence.VotePK votePK)
		throws PortalException {

		return getService().getVote(votePK);
	}

	/**
	 * Returns the vote matching the UUID and group.
	 *
	 * @param uuid the vote's UUID
	 * @param groupId the primary key of the group
	 * @return the matching vote
	 * @throws PortalException if a matching vote could not be found
	 */
	public static Vote getVoteByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getVoteByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the votes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.VoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @return the range of votes
	 */
	public static List<Vote> getVotes(int start, int end) {
		return getService().getVotes(start, end);
	}

	/**
	 * Returns all the votes matching the UUID and company.
	 *
	 * @param uuid the UUID of the votes
	 * @param companyId the primary key of the company
	 * @return the matching votes, or an empty list if no matches were found
	 */
	public static List<Vote> getVotesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getVotesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of votes matching the UUID and company.
	 *
	 * @param uuid the UUID of the votes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of votes
	 * @param end the upper bound of the range of votes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching votes, or an empty list if no matches were found
	 */
	public static List<Vote> getVotesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Vote> orderByComparator) {

		return getService().getVotesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of votes.
	 *
	 * @return the number of votes
	 */
	public static int getVotesCount() {
		return getService().getVotesCount();
	}

	/**
	 * Supprime une entité
	 */
	public static Vote removeVote(long officialId, long deliberationId)
		throws PortalException {

		return getService().removeVote(officialId, deliberationId);
	}

	/**
	 * Supprime les votes d'une délibération
	 */
	public static void removeVotesFromDeliberation(long deliberationId)
		throws PortalException {

		getService().removeVotesFromDeliberation(deliberationId);
	}

	/**
	 * Updates the vote in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect VoteLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param vote the vote
	 * @return the vote that was updated
	 */
	public static Vote updateVote(Vote vote) {
		return getService().updateVote(vote);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static Vote updateVote(
		Vote vote, com.liferay.portal.kernel.service.ServiceContext sc) {

		return getService().updateVote(vote, sc);
	}

	public static VoteLocalService getService() {
		return _service;
	}

	public static void setService(VoteLocalService service) {
		_service = service;
	}

	private static volatile VoteLocalService _service;

}