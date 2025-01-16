/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link EventPeriodLocalService}.
 *
 * @author BenjaminBini
 * @see EventPeriodLocalService
 * @generated
 */
public class EventPeriodLocalServiceWrapper
	implements EventPeriodLocalService,
			   ServiceWrapper<EventPeriodLocalService> {

	public EventPeriodLocalServiceWrapper() {
		this(null);
	}

	public EventPeriodLocalServiceWrapper(
		EventPeriodLocalService eventPeriodLocalService) {

		_eventPeriodLocalService = eventPeriodLocalService;
	}

	/**
	 * Adds the event period to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was added
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod addEventPeriod(
		eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return _eventPeriodLocalService.addEventPeriod(eventPeriod);
	}

	/**
	 * Crée une édition vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod createEventPeriod()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.createEventPeriod();
	}

	/**
	 * Creates a new event period with the primary key. Does not add the event period to the database.
	 *
	 * @param eventPeriodId the primary key for the new event period
	 * @return the new event period
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod createEventPeriod(
		long eventPeriodId) {

		return _eventPeriodLocalService.createEventPeriod(eventPeriodId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the event period from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was removed
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod deleteEventPeriod(
		eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return _eventPeriodLocalService.deleteEventPeriod(eventPeriod);
	}

	/**
	 * Deletes the event period with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period that was removed
	 * @throws PortalException if a event period with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod deleteEventPeriod(
			long eventPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.deleteEventPeriod(eventPeriodId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _eventPeriodLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _eventPeriodLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventPeriodLocalService.dynamicQuery();
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

		return _eventPeriodLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
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

		return _eventPeriodLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
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

		return _eventPeriodLocalService.dynamicQuery(
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

		return _eventPeriodLocalService.dynamicQueryCount(dynamicQuery);
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

		return _eventPeriodLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod fetchEventPeriod(
		long eventPeriodId) {

		return _eventPeriodLocalService.fetchEventPeriod(eventPeriodId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _eventPeriodLocalService.getActionableDynamicQuery();
	}

	/**
	 * Retourne les périodes d'un événement de campagne
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getByCampaignEventId(long campaignEventId) {

		return _eventPeriodLocalService.getByCampaignEventId(campaignEventId);
	}

	/**
	 * Retourne les périodes d'un événement
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getByEventId(long eventId) {

		return _eventPeriodLocalService.getByEventId(eventId);
	}

	/**
	 * Returns the event period with the primary key.
	 *
	 * @param eventPeriodId the primary key of the event period
	 * @return the event period
	 * @throws PortalException if a event period with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod getEventPeriod(
			long eventPeriodId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.getEventPeriod(eventPeriodId);
	}

	/**
	 * Returns a range of all the event periods.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.agenda.model.impl.EventPeriodModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of event periods
	 * @param end the upper bound of the range of event periods (not inclusive)
	 * @return the range of event periods
	 */
	@Override
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getEventPeriods(int start, int end) {

		return _eventPeriodLocalService.getEventPeriods(start, end);
	}

	/**
	 * Returns the number of event periods.
	 *
	 * @return the number of event periods
	 */
	@Override
	public int getEventPeriodsCount() {
		return _eventPeriodLocalService.getEventPeriodsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _eventPeriodLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventPeriodLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventPeriodLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the event period in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EventPeriodLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param eventPeriod the event period
	 * @return the event period that was updated
	 */
	@Override
	public eu.strasbourg.service.agenda.model.EventPeriod updateEventPeriod(
		eu.strasbourg.service.agenda.model.EventPeriod eventPeriod) {

		return _eventPeriodLocalService.updateEventPeriod(eventPeriod);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _eventPeriodLocalService.getBasePersistence();
	}

	@Override
	public EventPeriodLocalService getWrappedService() {
		return _eventPeriodLocalService;
	}

	@Override
	public void setWrappedService(
		EventPeriodLocalService eventPeriodLocalService) {

		_eventPeriodLocalService = eventPeriodLocalService;
	}

	private EventPeriodLocalService _eventPeriodLocalService;

}