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

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.Participation;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

/**
 * Provides the local service utility for Participation. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.ParticipationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see ParticipationLocalService
 * @generated
 */
public class ParticipationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ParticipationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the participation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was added
	 */
	public static Participation addParticipation(Participation participation) {
		return getService().addParticipation(participation);
	}

	/**
	 * Creates a new participation with the primary key. Does not add the participation to the database.
	 *
	 * @param participationId the primary key for the new participation
	 * @return the new participation
	 */
	public static Participation createParticipation(long participationId) {
		return getService().createParticipation(participationId);
	}

	/**
	 * Crée une participation vide avec une PK, non ajouté à la base de donnée
	 */
	public static Participation createParticipation(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createParticipation(sc);
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
	 * Deletes the participation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participationId the primary key of the participation
	 * @return the participation that was removed
	 * @throws PortalException if a participation with the primary key could not be found
	 */
	public static Participation deleteParticipation(long participationId)
		throws PortalException {

		return getService().deleteParticipation(participationId);
	}

	/**
	 * Deletes the participation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was removed
	 */
	public static Participation deleteParticipation(
		Participation participation) {

		return getService().deleteParticipation(participation);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
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

	public static Participation fetchParticipation(long participationId) {
		return getService().fetchParticipation(participationId);
	}

	/**
	 * Returns the participation matching the UUID and group.
	 *
	 * @param uuid the participation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation, or <code>null</code> if a matching participation could not be found
	 */
	public static Participation fetchParticipationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchParticipationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par mot clés
	 */
	public static List<Participation> findByKeyword(
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
	 * Renvoie la liste des vocabulaires rattachés à une participation
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne toutes les participations d'un groupe
	 */
	public static List<Participation> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
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
	 * méthode permettant de récupérer les 3 dernieres participations de la liste.
	 *
	 * @param groupId le grouptId
	 * @return la liste de participation.
	 */
	public static List<Participation> getLessCommented(long groupId) {
		return getService().getLessCommented(groupId);
	}

	/**
	 * méthode permettant de récupérer les 3 premières participations de la liste.
	 *
	 * @param groupId le grouptId
	 * @return la liste de participation.
	 */
	public static List<Participation> getMostCommented(long groupId) {
		return getService().getMostCommented(groupId);
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
	 * Returns the participation with the primary key.
	 *
	 * @param participationId the primary key of the participation
	 * @return the participation
	 * @throws PortalException if a participation with the primary key could not be found
	 */
	public static Participation getParticipation(long participationId)
		throws PortalException {

		return getService().getParticipation(participationId);
	}

	/**
	 * Returns the participation matching the UUID and group.
	 *
	 * @param uuid the participation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching participation
	 * @throws PortalException if a matching participation could not be found
	 */
	public static Participation getParticipationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getParticipationByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the participations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.ParticipationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of participations
	 * @param end the upper bound of the range of participations (not inclusive)
	 * @return the range of participations
	 */
	public static List<Participation> getParticipations(int start, int end) {
		return getService().getParticipations(start, end);
	}

	/**
	 * Returns all the participations matching the UUID and company.
	 *
	 * @param uuid the UUID of the participations
	 * @param companyId the primary key of the company
	 * @return the matching participations, or an empty list if no matches were found
	 */
	public static List<Participation> getParticipationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getParticipationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of participations matching the UUID and company.
	 *
	 * @param uuid the UUID of the participations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of participations
	 * @param end the upper bound of the range of participations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching participations, or an empty list if no matches were found
	 */
	public static List<Participation> getParticipationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Participation> orderByComparator) {

		return getService().getParticipationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of participations.
	 *
	 * @return the number of participations
	 */
	public static int getParticipationsCount() {
		return getService().getParticipationsCount();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Retourne toutes les participation publiees d'un groupe
	 */
	public static List<Participation> getPublishedByGroupId(long groupId) {
		return getService().getPublishedByGroupId(groupId);
	}

	/**
	 * Supprime une participation
	 */
	public static Participation removeParticipation(long participationId)
		throws PortalException {

		return getService().removeParticipation(participationId);
	}

	/**
	 * Met a jour le statut de toutes les participations
	 *
	 * @throws PortalException
	 */
	public static void updateAllParticipationsStatus() throws PortalException {
		getService().updateAllParticipationsStatus();
	}

	/**
	 * Updates the participation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ParticipationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participation the participation
	 * @return the participation that was updated
	 */
	public static Participation updateParticipation(
		Participation participation) {

		return getService().updateParticipation(participation);
	}

	/**
	 * Met à jour une participation et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	public static Participation updateParticipation(
			Participation participation,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateParticipation(participation, sc);
	}

	/**
	 * Met à jour le statut de la participation par le framework workflow
	 */
	public static Participation updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	/**
	 * Met à jour le statut de la participation "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(Participation participation, int status)
		throws PortalException {

		getService().updateStatus(participation, status);
	}

	public static ParticipationLocalService getService() {
		return _service;
	}

	private static volatile ParticipationLocalService _service;

}