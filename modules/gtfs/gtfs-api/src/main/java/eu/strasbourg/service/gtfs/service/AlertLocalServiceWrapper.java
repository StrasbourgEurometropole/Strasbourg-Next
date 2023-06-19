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
 * Provides a wrapper for {@link AlertLocalService}.
 *
 * @author Cedric Henry
 * @see AlertLocalService
 * @generated
 */
public class AlertLocalServiceWrapper
	implements AlertLocalService, ServiceWrapper<AlertLocalService> {

	public AlertLocalServiceWrapper() {
		this(null);
	}

	public AlertLocalServiceWrapper(AlertLocalService alertLocalService) {
		_alertLocalService = alertLocalService;
	}

	/**
	 * Adds the alert to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert addAlert(
		eu.strasbourg.service.gtfs.model.Alert alert) {

		return _alertLocalService.addAlert(alert);
	}

	/**
	 * Creates a new alert with the primary key. Does not add the alert to the database.
	 *
	 * @param alertId the primary key for the new alert
	 * @return the new alert
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert createAlert(long alertId) {
		return _alertLocalService.createAlert(alertId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert createAlert(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.createAlert(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the alert from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert deleteAlert(
		eu.strasbourg.service.gtfs.model.Alert alert) {

		return _alertLocalService.deleteAlert(alert);
	}

	/**
	 * Deletes the alert with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alertId the primary key of the alert
	 * @return the alert that was removed
	 * @throws PortalException if a alert with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert deleteAlert(long alertId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.deleteAlert(alertId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _alertLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _alertLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alertLocalService.dynamicQuery();
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

		return _alertLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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

		return _alertLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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

		return _alertLocalService.dynamicQuery(
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

		return _alertLocalService.dynamicQueryCount(dynamicQuery);
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

		return _alertLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Alert fetchAlert(long alertId) {
		return _alertLocalService.fetchAlert(alertId);
	}

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert, or <code>null</code> if a matching alert could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert fetchAlertByUuidAndGroupId(
		String uuid, long groupId) {

		return _alertLocalService.fetchAlertByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _alertLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the alert with the primary key.
	 *
	 * @param alertId the primary key of the alert
	 * @return the alert
	 * @throws PortalException if a alert with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert getAlert(long alertId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.getAlert(alertId);
	}

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert
	 * @throws PortalException if a matching alert could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert getAlertByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.getAlertByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the alerts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of alerts
	 * @param end the upper bound of the range of alerts (not inclusive)
	 * @return the range of alerts
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert> getAlerts(
		int start, int end) {

		return _alertLocalService.getAlerts(start, end);
	}

	/**
	 * Returns all the alerts matching the UUID and company.
	 *
	 * @param uuid the UUID of the alerts
	 * @param companyId the primary key of the company
	 * @return the matching alerts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert>
		getAlertsByUuidAndCompanyId(String uuid, long companyId) {

		return _alertLocalService.getAlertsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of alerts matching the UUID and company.
	 *
	 * @param uuid the UUID of the alerts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of alerts
	 * @param end the upper bound of the range of alerts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching alerts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert>
		getAlertsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.gtfs.model.Alert> orderByComparator) {

		return _alertLocalService.getAlertsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of alerts.
	 *
	 * @return the number of alerts
	 */
	@Override
	public int getAlertsCount() {
		return _alertLocalService.getAlertsCount();
	}

	/**
	 * Retourne la liste de toutes les alertes
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert> getAll() {
		return _alertLocalService.getAll();
	}

	/**
	 * Retourne toutes les alertes d'un arret
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert> getByArretId(
		long arretId) {

		return _alertLocalService.getByArretId(arretId);
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert> getByGroupId(
		long groupId) {

		return _alertLocalService.getByGroupId(groupId);
	}

	/**
	 * Renvoie le nombre des alertes en cours ou à venir de cet arret
	 *
	 * @param arretId : identifiant arret
	 * @return
	 */
	@Override
	public long getCountAlertsActives(long arretId) {
		return _alertLocalService.getCountAlertsActives(arretId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _alertLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _alertLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Supprime l'entree
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert removeAlert(long alertId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.removeAlert(alertId);
	}

	/**
	 * Supprime les entrees
	 */
	@Override
	public void removeAlerts(
			java.util.List<eu.strasbourg.service.gtfs.model.Alert> alerts)
		throws com.liferay.portal.kernel.exception.PortalException {

		_alertLocalService.removeAlerts(alerts);
	}

	/**
	 * Supprime les entree correspondants au arretId donnee
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Alert>
			removeByArretId(long arretId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.removeByArretId(arretId);
	}

	/**
	 * Updates the alert in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert updateAlert(
		eu.strasbourg.service.gtfs.model.Alert alert) {

		return _alertLocalService.updateAlert(alert);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws PortalException
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Alert updateAlert(
			eu.strasbourg.service.gtfs.model.Alert alert,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _alertLocalService.updateAlert(alert, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	@Override
	public void updateAlerts(
			java.util.List<eu.strasbourg.service.gtfs.model.Alert> alerts,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		_alertLocalService.updateAlerts(alerts, sc);
	}

	@Override
	public AlertLocalService getWrappedService() {
		return _alertLocalService;
	}

	@Override
	public void setWrappedService(AlertLocalService alertLocalService) {
		_alertLocalService = alertLocalService;
	}

	private AlertLocalService _alertLocalService;

}