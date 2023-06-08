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

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AgencyLocalService}.
 *
 * @author Cedric Henry
 * @see AgencyLocalService
 * @generated
 */
public class AgencyLocalServiceWrapper
	implements AgencyLocalService, ServiceWrapper<AgencyLocalService> {

	public AgencyLocalServiceWrapper(AgencyLocalService agencyLocalService) {
		_agencyLocalService = agencyLocalService;
	}

	/**
	 * Adds the agency to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency addAgency(
		eu.strasbourg.service.gtfs.model.Agency agency) {

		return _agencyLocalService.addAgency(agency);
	}

	/**
	 * Creates a new agency with the primary key. Does not add the agency to the database.
	 *
	 * @param id the primary key for the new agency
	 * @return the new agency
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency createAgency(long id) {
		return _agencyLocalService.createAgency(id);
	}

	/**
	 * Crée une agence vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency createAgency(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.createAgency(sc);
	}

	/**
	 * Crée une agence à partir d'une entrée GTFS
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency createAgencyFromGTFS(
			eu.strasbourg.utils.models.AgencyGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.createAgencyFromGTFS(entry);
	}

	/**
	 * Deletes the agency from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency deleteAgency(
		eu.strasbourg.service.gtfs.model.Agency agency) {

		return _agencyLocalService.deleteAgency(agency);
	}

	/**
	 * Deletes the agency with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the agency
	 * @return the agency that was removed
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency deleteAgency(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.deleteAgency(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agencyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _agencyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _agencyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _agencyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _agencyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _agencyLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Agency fetchAgency(long id) {
		return _agencyLocalService.fetchAgency(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agencyLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the agencies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AgencyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agencies
	 * @param end the upper bound of the range of agencies (not inclusive)
	 * @return the range of agencies
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Agency> getAgencies(
		int start, int end) {

		return _agencyLocalService.getAgencies(start, end);
	}

	/**
	 * Returns the number of agencies.
	 *
	 * @return the number of agencies
	 */
	@Override
	public int getAgenciesCount() {
		return _agencyLocalService.getAgenciesCount();
	}

	/**
	 * Returns the agency with the primary key.
	 *
	 * @param id the primary key of the agency
	 * @return the agency
	 * @throws PortalException if a agency with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency getAgency(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.getAgency(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agencyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agencyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Import des agences sous le format de données GTFS
	 */
	@Override
	public void importFromGTFS(
			java.util.Map<String, eu.strasbourg.utils.models.AgencyGTFS> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		_agencyLocalService.importFromGTFS(data);
	}

	/**
	 * Supprime une agence
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency removeAgency(long agencyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.removeAgency(agencyId);
	}

	/**
	 * Supprime toutes les agences
	 */
	@Override
	public void removeAllAgencies()
		throws com.liferay.portal.kernel.exception.PortalException {

		_agencyLocalService.removeAllAgencies();
	}

	/**
	 * Updates the agency in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgencyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agency the agency
	 * @return the agency that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency updateAgency(
		eu.strasbourg.service.gtfs.model.Agency agency) {

		return _agencyLocalService.updateAgency(agency);
	}

	/**
	 * Met à jour une agence et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Agency updateAgency(
			eu.strasbourg.service.gtfs.model.Agency agency,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agencyLocalService.updateAgency(agency, sc);
	}

	@Override
	public AgencyLocalService getWrappedService() {
		return _agencyLocalService;
	}

	@Override
	public void setWrappedService(AgencyLocalService agencyLocalService) {
		_agencyLocalService = agencyLocalService;
	}

	private AgencyLocalService _agencyLocalService;

}