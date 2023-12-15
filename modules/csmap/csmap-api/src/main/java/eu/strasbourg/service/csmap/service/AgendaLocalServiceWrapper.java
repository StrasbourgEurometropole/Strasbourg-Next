/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AgendaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AgendaLocalService
 * @generated
 */
public class AgendaLocalServiceWrapper
	implements AgendaLocalService, ServiceWrapper<AgendaLocalService> {

	public AgendaLocalServiceWrapper() {
		this(null);
	}

	public AgendaLocalServiceWrapper(AgendaLocalService agendaLocalService) {
		_agendaLocalService = agendaLocalService;
	}

	/**
	 * Adds the agenda to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agenda the agenda
	 * @return the agenda that was added
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda addAgenda(
		eu.strasbourg.service.csmap.model.Agenda agenda) {

		return _agendaLocalService.addAgenda(agenda);
	}

	@Override
	public eu.strasbourg.service.csmap.model.Agenda createAgenda() {
		return _agendaLocalService.createAgenda();
	}

	/**
	 * Creates a new agenda with the primary key. Does not add the agenda to the database.
	 *
	 * @param agendaId the primary key for the new agenda
	 * @return the new agenda
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda createAgenda(
		long agendaId) {

		return _agendaLocalService.createAgenda(agendaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the agenda from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agenda the agenda
	 * @return the agenda that was removed
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda deleteAgenda(
		eu.strasbourg.service.csmap.model.Agenda agenda) {

		return _agendaLocalService.deleteAgenda(agenda);
	}

	/**
	 * Deletes the agenda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agendaId the primary key of the agenda
	 * @return the agenda that was removed
	 * @throws PortalException if a agenda with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda deleteAgenda(long agendaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaLocalService.deleteAgenda(agendaId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _agendaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _agendaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _agendaLocalService.dynamicQuery();
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

		return _agendaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.AgendaModelImpl</code>.
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

		return _agendaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.AgendaModelImpl</code>.
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

		return _agendaLocalService.dynamicQuery(
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

		return _agendaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _agendaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.csmap.model.Agenda fetchAgenda(long agendaId) {
		return _agendaLocalService.fetchAgenda(agendaId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _agendaLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the agenda with the primary key.
	 *
	 * @param agendaId the primary key of the agenda
	 * @return the agenda
	 * @throws PortalException if a agenda with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda getAgenda(long agendaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaLocalService.getAgenda(agendaId);
	}

	@Override
	public eu.strasbourg.service.csmap.model.Agenda getAgendaPrincipal() {
		return _agendaLocalService.getAgendaPrincipal();
	}

	/**
	 * Returns a range of all the agendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.csmap.model.impl.AgendaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of agendas
	 * @param end the upper bound of the range of agendas (not inclusive)
	 * @return the range of agendas
	 */
	@Override
	public java.util.List<eu.strasbourg.service.csmap.model.Agenda> getAgendas(
		int start, int end) {

		return _agendaLocalService.getAgendas(start, end);
	}

	/**
	 * Returns the number of agendas.
	 *
	 * @return the number of agendas
	 */
	@Override
	public int getAgendasCount() {
		return _agendaLocalService.getAgendasCount();
	}

	@Override
	public java.util.List<eu.strasbourg.service.csmap.model.Agenda>
		getAgendasThematique() {

		return _agendaLocalService.getAgendasThematique();
	}

	@Override
	public java.util.List<eu.strasbourg.service.csmap.model.Agenda>
		getAgendasThematiqueInactif() {

		return _agendaLocalService.getAgendasThematiqueInactif();
	}

	@Override
	public eu.strasbourg.service.csmap.model.Agenda getAgendaThematiqueActif() {
		return _agendaLocalService.getAgendaThematiqueActif();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _agendaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _agendaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _agendaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the agenda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AgendaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param agenda the agenda
	 * @return the agenda that was updated
	 */
	@Override
	public eu.strasbourg.service.csmap.model.Agenda updateAgenda(
		eu.strasbourg.service.csmap.model.Agenda agenda) {

		return _agendaLocalService.updateAgenda(agenda);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _agendaLocalService.getBasePersistence();
	}

	@Override
	public AgendaLocalService getWrappedService() {
		return _agendaLocalService;
	}

	@Override
	public void setWrappedService(AgendaLocalService agendaLocalService) {
		_agendaLocalService = agendaLocalService;
	}

	private AgendaLocalService _agendaLocalService;

}