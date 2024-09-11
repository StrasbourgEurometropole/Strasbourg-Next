/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.gtfs.model.Alert;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Alert. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.AlertLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Cedric Henry
 * @see AlertLocalService
 * @generated
 */
public class AlertLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.AlertLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Alert addAlert(Alert alert) {
		return getService().addAlert(alert);
	}

	/**
	 * Creates a new alert with the primary key. Does not add the alert to the database.
	 *
	 * @param alertId the primary key for the new alert
	 * @return the new alert
	 */
	public static Alert createAlert(long alertId) {
		return getService().createAlert(alertId);
	}

	/**
	 * Crée une entree avec une PK, non ajouté à la base de donnée
	 */
	public static Alert createAlert(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().createAlert(sc);
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
	 * Deletes the alert from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AlertLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param alert the alert
	 * @return the alert that was removed
	 */
	public static Alert deleteAlert(Alert alert) {
		return getService().deleteAlert(alert);
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
	public static Alert deleteAlert(long alertId) throws PortalException {
		return getService().deleteAlert(alertId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.AlertModelImpl</code>.
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

	public static Alert fetchAlert(long alertId) {
		return getService().fetchAlert(alertId);
	}

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert, or <code>null</code> if a matching alert could not be found
	 */
	public static Alert fetchAlertByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchAlertByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the alert with the primary key.
	 *
	 * @param alertId the primary key of the alert
	 * @return the alert
	 * @throws PortalException if a alert with the primary key could not be found
	 */
	public static Alert getAlert(long alertId) throws PortalException {
		return getService().getAlert(alertId);
	}

	/**
	 * Returns the alert matching the UUID and group.
	 *
	 * @param uuid the alert's UUID
	 * @param groupId the primary key of the group
	 * @return the matching alert
	 * @throws PortalException if a matching alert could not be found
	 */
	public static Alert getAlertByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getAlertByUuidAndGroupId(uuid, groupId);
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
	public static List<Alert> getAlerts(int start, int end) {
		return getService().getAlerts(start, end);
	}

	/**
	 * Returns all the alerts matching the UUID and company.
	 *
	 * @param uuid the UUID of the alerts
	 * @param companyId the primary key of the company
	 * @return the matching alerts, or an empty list if no matches were found
	 */
	public static List<Alert> getAlertsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAlertsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Alert> getAlertsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Alert> orderByComparator) {

		return getService().getAlertsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of alerts.
	 *
	 * @return the number of alerts
	 */
	public static int getAlertsCount() {
		return getService().getAlertsCount();
	}

	/**
	 * Retourne la liste de toutes les alertes
	 */
	public static List<Alert> getAll() {
		return getService().getAll();
	}

	/**
	 * Retourne toutes les alertes d'un arret
	 */
	public static List<Alert> getByArretId(long arretId) {
		return getService().getByArretId(arretId);
	}

	/**
	 * Retourne toutes les entrees d'un groupe
	 */
	public static List<Alert> getByGroupId(long groupId) {
		return getService().getByGroupId(groupId);
	}

	/**
	 * Renvoie le nombre des alertes en cours ou à venir de cet arret
	 *
	 * @param arretId : identifiant arret
	 * @return
	 */
	public static long getCountAlertsActives(long arretId) {
		return getService().getCountAlertsActives(arretId);
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
	 * Supprime l'entree
	 */
	public static Alert removeAlert(long alertId) throws PortalException {
		return getService().removeAlert(alertId);
	}

	/**
	 * Supprime les entrees
	 */
	public static void removeAlerts(List<Alert> alerts) throws PortalException {
		getService().removeAlerts(alerts);
	}

	/**
	 * Supprime les entree correspondants au arretId donnee
	 */
	public static List<Alert> removeByArretId(long arretId)
		throws PortalException {

		return getService().removeByArretId(arretId);
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
	public static Alert updateAlert(Alert alert) {
		return getService().updateAlert(alert);
	}

	/**
	 * Met à jour une entree et l'enregistre en base de données
	 *
	 * @throws PortalException
	 * @throws IOException
	 */
	public static Alert updateAlert(
			Alert alert, com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		return getService().updateAlert(alert, sc);
	}

	/**
	 * Met à jour les entree donnees
	 *
	 * @throws IOException
	 */
	public static void updateAlerts(
			List<Alert> alerts,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws PortalException {

		getService().updateAlerts(alerts, sc);
	}

	public static AlertLocalService getService() {
		return _service;
	}

	public static void setService(AlertLocalService service) {
		_service = service;
	}

	private static volatile AlertLocalService _service;

}