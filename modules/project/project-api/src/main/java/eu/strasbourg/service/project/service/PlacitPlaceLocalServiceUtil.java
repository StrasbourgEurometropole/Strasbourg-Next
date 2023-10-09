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

import eu.strasbourg.service.project.model.PlacitPlace;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for PlacitPlace. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.PlacitPlaceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see PlacitPlaceLocalService
 * @generated
 */
public class PlacitPlaceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.PlacitPlaceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the placit place to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was added
	 */
	public static PlacitPlace addPlacitPlace(PlacitPlace placitPlace) {
		return getService().addPlacitPlace(placitPlace);
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
	 * Creates a new placit place with the primary key. Does not add the placit place to the database.
	 *
	 * @param placitPlaceId the primary key for the new placit place
	 * @return the new placit place
	 */
	public static PlacitPlace createPlacitPlace(long placitPlaceId) {
		return getService().createPlacitPlace(placitPlaceId);
	}

	/**
	 * Crée un lieu Placit vide avec une PK, non ajouté à la base de donnée
	 */
	public static PlacitPlace createPlacitPlace(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createPlacitPlace(sc);
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
	 * Deletes the placit place with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place that was removed
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace deletePlacitPlace(long placitPlaceId)
		throws PortalException {

		return getService().deletePlacitPlace(placitPlaceId);
	}

	/**
	 * Deletes the placit place from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was removed
	 */
	public static PlacitPlace deletePlacitPlace(PlacitPlace placitPlace) {
		return getService().deletePlacitPlace(placitPlace);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
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

	public static PlacitPlace fetchPlacitPlace(long placitPlaceId) {
		return getService().fetchPlacitPlace(placitPlaceId);
	}

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place, or <code>null</code> if a matching placit place could not be found
	 */
	public static PlacitPlace fetchPlacitPlaceByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchPlacitPlaceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Lance une recherche par liste d'ids
	 */
	public static List<PlacitPlace> findByIds(List<Long> placitPlaceIds) {
		return getService().findByIds(placitPlaceIds);
	}

	/**
	 * Lance une recherche par mots-clés
	 */
	public static List<PlacitPlace> findByKeyword(
		String keyword, long groupId, int start, int end) {

		return getService().findByKeyword(keyword, groupId, start, end);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à l'entité
	 */
	public static List<com.liferay.asset.kernel.model.AssetVocabulary>
		getAttachedVocabularies(long groupId) {

		return getService().getAttachedVocabularies(groupId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	public static List<PlacitPlace> getByBudgetParticipatif(
		long budgetParticipatifId) {

		return getService().getByBudgetParticipatif(budgetParticipatifId);
	}

	/**
	 * Retourne tous les lieux Placit d'un groupe
	 */
	public static List<PlacitPlace> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Retourne les lieux d'une initiative
	 */
	public static List<PlacitPlace> getByInitiative(long initiativeId) {
		return getService().getByInitiative(initiativeId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	public static List<PlacitPlace> getByParticipation(long participationId) {
		return getService().getByParticipation(participationId);
	}

	/**
	 * Retourne les lieux d'une participation
	 */
	public static List<PlacitPlace> getByPetition(long petitionId) {
		return getService().getByPetition(petitionId);
	}

	/**
	 * Retourne les lieux d'un projet
	 */
	public static List<PlacitPlace> getByProject(long projectId) {
		return getService().getByProject(projectId);
	}

	public static List<PlacitPlace> getBySaisineObservatoire(
		long saisineObservatoireId) {

		return getService().getBySaisineObservatoire(saisineObservatoireId);
	}

	/**
	 * Retourne toutes les lieux de cours d'un lieu
	 */
	public static List<PlacitPlace> getBySigId(String sigId) {
		return getService().getBySigId(sigId);
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
	 * Returns the placit place with the primary key.
	 *
	 * @param placitPlaceId the primary key of the placit place
	 * @return the placit place
	 * @throws PortalException if a placit place with the primary key could not be found
	 */
	public static PlacitPlace getPlacitPlace(long placitPlaceId)
		throws PortalException {

		return getService().getPlacitPlace(placitPlaceId);
	}

	/**
	 * Returns the placit place matching the UUID and group.
	 *
	 * @param uuid the placit place's UUID
	 * @param groupId the primary key of the group
	 * @return the matching placit place
	 * @throws PortalException if a matching placit place could not be found
	 */
	public static PlacitPlace getPlacitPlaceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getPlacitPlaceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the placit places.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.PlacitPlaceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @return the range of placit places
	 */
	public static List<PlacitPlace> getPlacitPlaces(int start, int end) {
		return getService().getPlacitPlaces(start, end);
	}

	/**
	 * Returns all the placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @return the matching placit places, or an empty list if no matches were found
	 */
	public static List<PlacitPlace> getPlacitPlacesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getPlacitPlacesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of placit places matching the UUID and company.
	 *
	 * @param uuid the UUID of the placit places
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of placit places
	 * @param end the upper bound of the range of placit places (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching placit places, or an empty list if no matches were found
	 */
	public static List<PlacitPlace> getPlacitPlacesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PlacitPlace> orderByComparator) {

		return getService().getPlacitPlacesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of placit places.
	 *
	 * @return the number of placit places
	 */
	public static int getPlacitPlacesCount() {
		return getService().getPlacitPlacesCount();
	}

	/**
	 * Supprime une entité
	 */
	public static PlacitPlace removePlacitPlace(long placitPlaceId)
		throws PortalException {

		return getService().removePlacitPlace(placitPlaceId);
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
	 * Updates the placit place in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PlacitPlaceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param placitPlace the placit place
	 * @return the placit place that was updated
	 */
	public static PlacitPlace updatePlacitPlace(PlacitPlace placitPlace) {
		return getService().updatePlacitPlace(placitPlace);
	}

	/**
	 * Met à jour un lieu Placit et l'enregistre en base de données
	 */
	public static PlacitPlace updatePlacitPlace(
			PlacitPlace placitPlace,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updatePlacitPlace(placitPlace, sc);
	}

	public static PlacitPlaceLocalService getService() {
		return _service;
	}

	private static volatile PlacitPlaceLocalService _service;

}