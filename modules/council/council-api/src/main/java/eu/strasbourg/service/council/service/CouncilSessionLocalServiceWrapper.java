/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CouncilSessionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSessionLocalService
 * @generated
 */
public class CouncilSessionLocalServiceWrapper
	implements CouncilSessionLocalService,
			   ServiceWrapper<CouncilSessionLocalService> {

	public CouncilSessionLocalServiceWrapper() {
		this(null);
	}

	public CouncilSessionLocalServiceWrapper(
		CouncilSessionLocalService councilSessionLocalService) {

		_councilSessionLocalService = councilSessionLocalService;
	}

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
	@Override
	public eu.strasbourg.service.council.model.CouncilSession addCouncilSession(
		eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return _councilSessionLocalService.addCouncilSession(councilSession);
	}

	/**
	 * Calcul de la date pour trouver le conseil
	 * Si la date du jour moins 6h est sur le jour d'avant, alors on fait la recherche sur le jour d'avant
	 */
	@Override
	public java.util.GregorianCalendar calculDateForFindCouncil() {
		return _councilSessionLocalService.calculDateForFindCouncil();
	}

	/**
	 * Creates a new council session with the primary key. Does not add the council session to the database.
	 *
	 * @param councilSessionId the primary key for the new council session
	 * @return the new council session
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		createCouncilSession(long councilSessionId) {

		return _councilSessionLocalService.createCouncilSession(
			councilSessionId);
	}

	/**
	 * Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
			createCouncilSession(
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.createCouncilSession(sc);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		deleteCouncilSession(
			eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return _councilSessionLocalService.deleteCouncilSession(councilSession);
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
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
			deleteCouncilSession(long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.deleteCouncilSession(
			councilSessionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _councilSessionLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _councilSessionLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _councilSessionLocalService.dynamicQuery();
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

		return _councilSessionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _councilSessionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _councilSessionLocalService.dynamicQuery(
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

		return _councilSessionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _councilSessionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		fetchCouncilSession(long councilSessionId) {

		return _councilSessionLocalService.fetchCouncilSession(
			councilSessionId);
	}

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session, or <code>null</code> if a matching council session could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		fetchCouncilSessionByUuidAndGroupId(String uuid, long groupId) {

		return _councilSessionLocalService.fetchCouncilSessionByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Recherche par Date de CouncilSession
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		findByDate(java.util.Date date) {

		return _councilSessionLocalService.findByDate(date);
	}

	/**
	 * Recherche par titre de CouncilSession
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		findByTitre(String title) {

		return _councilSessionLocalService.findByTitre(title);
	}

	/**
	 * Recherche par type de CouncilSession
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		findByTypeId(long typeId) {

		return _councilSessionLocalService.findByTypeId(typeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _councilSessionLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the council session with the primary key.
	 *
	 * @param councilSessionId the primary key of the council session
	 * @return the council session
	 * @throws PortalException if a council session with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession getCouncilSession(
			long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.getCouncilSession(councilSessionId);
	}

	/**
	 * Returns the council session matching the UUID and group.
	 *
	 * @param uuid the council session's UUID
	 * @param groupId the primary key of the group
	 * @return the matching council session
	 * @throws PortalException if a matching council session could not be found
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
			getCouncilSessionByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.getCouncilSessionByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		getCouncilSessions(int start, int end) {

		return _councilSessionLocalService.getCouncilSessions(start, end);
	}

	/**
	 * Returns all the council sessions matching the UUID and company.
	 *
	 * @param uuid the UUID of the council sessions
	 * @param companyId the primary key of the company
	 * @return the matching council sessions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		getCouncilSessionsByUuidAndCompanyId(String uuid, long companyId) {

		return _councilSessionLocalService.getCouncilSessionsByUuidAndCompanyId(
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
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		getCouncilSessionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<eu.strasbourg.service.council.model.CouncilSession>
					orderByComparator) {

		return _councilSessionLocalService.getCouncilSessionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of council sessions.
	 *
	 * @return the number of council sessions
	 */
	@Override
	public int getCouncilSessionsCount() {
		return _councilSessionLocalService.getCouncilSessionsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _councilSessionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Retourne les conseils dont la date est égale ou supérieure à celle passée en paramètre
	 */
	@Override
	public java.util.List<eu.strasbourg.service.council.model.CouncilSession>
		getFutureCouncilSessions(java.util.Date date) {

		return _councilSessionLocalService.getFutureCouncilSessions(date);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _councilSessionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _councilSessionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Si le conseil a des délib
	 */
	@Override
	public boolean hasDelib(long councilSessionId) {
		return _councilSessionLocalService.hasDelib(councilSessionId);
	}

	/**
	 * Si le titre avec l'ID donné est déjà utilisé par une autre session du même type de conseil
	 */
	@Override
	public boolean isTitleAlreadyUsedInCouncilTypeId(
		String title, long councilSessionId, long typeId) {

		return _councilSessionLocalService.isTitleAlreadyUsedInCouncilTypeId(
			title, councilSessionId, typeId);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
			removeCouncilSession(long councilSessionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.removeCouncilSession(
			councilSessionId);
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
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		updateCouncilSession(
			eu.strasbourg.service.council.model.CouncilSession councilSession) {

		return _councilSessionLocalService.updateCouncilSession(councilSession);
	}

	/**
	 * Met à jour une entité et l'enregistre en base de données
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession
			updateCouncilSession(
				eu.strasbourg.service.council.model.CouncilSession
					councilSession,
				com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.updateCouncilSession(
			councilSession, sc);
	}

	/**
	 * Met à jour le statut de l'entité "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(
			eu.strasbourg.service.council.model.CouncilSession councilSession,
			int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_councilSessionLocalService.updateStatus(councilSession, status);
	}

	/**
	 * Met à jour le statut de l'entité par le framework workflow
	 */
	@Override
	public eu.strasbourg.service.council.model.CouncilSession updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext sc,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _councilSessionLocalService.updateStatus(
			userId, entryId, status, sc, workflowContext);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _councilSessionLocalService.getBasePersistence();
	}

	@Override
	public CouncilSessionLocalService getWrappedService() {
		return _councilSessionLocalService;
	}

	@Override
	public void setWrappedService(
		CouncilSessionLocalService councilSessionLocalService) {

		_councilSessionLocalService = councilSessionLocalService;
	}

	private CouncilSessionLocalService _councilSessionLocalService;

}