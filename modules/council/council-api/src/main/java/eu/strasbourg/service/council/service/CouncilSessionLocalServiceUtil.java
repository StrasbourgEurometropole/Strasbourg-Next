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

package eu.strasbourg.service.council.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CouncilSession. This utility wraps
 * <code>eu.strasbourg.service.council.service.impl.CouncilSessionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSessionLocalService
 * @generated
 */
public class CouncilSessionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.CouncilSessionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the council session to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was added
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
		addCouncilSession(
			eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return getService().addCouncilSession(councilSession);
	}

	/**
	 * Calcul de la date pour trouver le conseil
	 * Si la date du jour moins 6h est sur le jour d'avant, alors on fait la recherche sur le jour d'avant
	 */
	public static java.util.GregorianCalendar calculDateForFindCouncil() {
		return getService().calculDateForFindCouncil();
	}

	/**
	 * Creates a new council session with the primary key. Does not add the council session to the database.
	 *
	 * @param councilSessionId the primary key for the new council session
	 * @return the new council session
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
		createCouncilSession(long councilSessionId) {

		return getService().createCouncilSession(councilSessionId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			createCouncilSession(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createCouncilSession(sc);
	}

	/**
	 * Deletes the council session from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was removed
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
		deleteCouncilSession(
			eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return getService().deleteCouncilSession(councilSession);
	}

	/**
	 * Deletes the council session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session that was removed
	 * @throws PortalException if a council session with the primary key could not be found
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			deleteCouncilSession(long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCouncilSession(councilSessionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static eu.strasbourg.service.council.model.CouncilSession
		fetchCouncilSession(long councilSessionId) {

		return getService().fetchCouncilSession(councilSessionId);
	}

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session, or <code>null</code> if a matching council session could not be found
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
		fetchCouncilSessionByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchCouncilSessionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Recherche par Date de CouncilSession
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession> findByDate(
			java.util.Date date) {

		return getService().findByDate(date);
	}

	/**
	 * Recherche par titre de CouncilSession
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession> findByTitre(
			String title) {

		return getService().findByTitre(title);
	}

	/**
	 * Recherche par type de CouncilSession
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession> findByTypeId(
			long typeId) {

		return getService().findByTypeId(typeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the council session with the primary key.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session
	 * @throws PortalException if a council session with the primary key could not be found
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			getCouncilSession(long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCouncilSession(councilSessionId);
	}

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session
	 * @throws PortalException if a matching council session could not be found
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			getCouncilSessionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCouncilSessionByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the council sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.council.model.impl.CouncilSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @return the range of council sessions
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession> getCouncilSessions(
			int start, int end) {

		return getService().getCouncilSessions(start, end);
	}

	/**
	 * Returns all the council sessions matching the UUID and company.
	 *
	 * @param uuid the UUID of the council sessions
	 * @param companyId the primary key of the company
	 * @return the matching council sessions, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession>
			getCouncilSessionsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getCouncilSessionsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of council sessions matching the UUID and company.
	 *
	 * @param uuid the UUID of the council sessions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of council sessions
	 * @param end the upper bound of the range of council sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching council sessions, or an empty list if no matches were found
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession>
			getCouncilSessionsByUuidAndCompanyId(
				String uuid, long companyId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<eu.strasbourg.service.council.model.CouncilSession>
						orderByComparator) {

		return getService().getCouncilSessionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of council sessions.
	 *
	 * @return the number of council sessions
	 */
	public static int getCouncilSessionsCount() {
		return getService().getCouncilSessionsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Retourne les conseils dont la date est égale ou supérieure à celle passée en paramètre
	 */
	public static java.util.List
		<eu.strasbourg.service.council.model.CouncilSession>
			getFutureCouncilSessions(java.util.Date date) {

		return getService().getFutureCouncilSessions(date);
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
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Si le conseil a des délib
	 */
	public static boolean hasDelib(long councilSessionId) {
		return getService().hasDelib(councilSessionId);
	}

	/**
	 * Si le titre avec l'ID donné est déjà utilisé par une autre session du même type de conseil
	 */
	public static boolean isTitleAlreadyUsedInCouncilTypeId(
		String title, long councilSessionId, long typeId) {

		return getService().isTitleAlreadyUsedInCouncilTypeId(
			title, councilSessionId, typeId);
	}

	/**
	 * Supprime une entité
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			removeCouncilSession(long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().removeCouncilSession(councilSessionId);
	}

	/**
	 * Updates the council session in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CouncilSessionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param councilSession the council session
	 * @return the council session that was updated
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
		updateCouncilSession(
			eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return getService().updateCouncilSession(councilSession);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			updateCouncilSession(
				eu.strasbourg.service.council.model.CouncilSession
					councilSession,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateCouncilSession(councilSession, sc);
	}

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	public static void updateStatus(
			eu.strasbourg.service.council.model.CouncilSession councilSession,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(councilSession, status);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	public static eu.strasbourg.service.council.model.CouncilSession
			updateStatus(
				long userId, long entryId, int status,
				com.liferay.portal.kernel.service.ServiceContext sc,
				java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	public static CouncilSessionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CouncilSessionLocalService, CouncilSessionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CouncilSessionLocalService.class);

		ServiceTracker<CouncilSessionLocalService, CouncilSessionLocalService>
			serviceTracker =
				new ServiceTracker
					<CouncilSessionLocalService, CouncilSessionLocalService>(
						bundle.getBundleContext(),
						CouncilSessionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}