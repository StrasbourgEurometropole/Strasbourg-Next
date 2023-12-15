/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CalendarLocalService}.
 *
 * @author Cedric Henry
 * @see CalendarLocalService
 * @generated
 */
public class CalendarLocalServiceWrapper
	implements CalendarLocalService, ServiceWrapper<CalendarLocalService> {

	public CalendarLocalServiceWrapper() {
		this(null);
	}

	public CalendarLocalServiceWrapper(
		CalendarLocalService calendarLocalService) {

		_calendarLocalService = calendarLocalService;
	}

	/**
	 * Adds the calendar to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendar the calendar
	 * @return the calendar that was added
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar addCalendar(
		eu.strasbourg.service.gtfs.model.Calendar calendar) {

		return _calendarLocalService.addCalendar(calendar);
	}

	/**
	 * Creates a new calendar with the primary key. Does not add the calendar to the database.
	 *
	 * @param id the primary key for the new calendar
	 * @return the new calendar
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar createCalendar(long id) {
		return _calendarLocalService.createCalendar(id);
	}

	/**
	 * Crée un Calendar vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar createCalendar(
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.createCalendar(sc);
	}

	/**
	 * Crée un Calendar à partir d'une entrée GTFS
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar createCalendarFromGTFS(
			eu.strasbourg.utils.models.CalendarGTFS entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.createCalendarFromGTFS(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the calendar from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendar the calendar
	 * @return the calendar that was removed
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar deleteCalendar(
		eu.strasbourg.service.gtfs.model.Calendar calendar) {

		return _calendarLocalService.deleteCalendar(calendar);
	}

	/**
	 * Deletes the calendar with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the calendar
	 * @return the calendar that was removed
	 * @throws PortalException if a calendar with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar deleteCalendar(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.deleteCalendar(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _calendarLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _calendarLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _calendarLocalService.dynamicQuery();
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

		return _calendarLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarModelImpl</code>.
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

		return _calendarLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarModelImpl</code>.
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

		return _calendarLocalService.dynamicQuery(
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

		return _calendarLocalService.dynamicQueryCount(dynamicQuery);
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

		return _calendarLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public eu.strasbourg.service.gtfs.model.Calendar fetchCalendar(long id) {
		return _calendarLocalService.fetchCalendar(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _calendarLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the calendar with the primary key.
	 *
	 * @param id the primary key of the calendar
	 * @return the calendar
	 * @throws PortalException if a calendar with the primary key could not be found
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar getCalendar(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.getCalendar(id);
	}

	/**
	 * Returns a range of all the calendars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.gtfs.model.impl.CalendarModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of calendars
	 * @param end the upper bound of the range of calendars (not inclusive)
	 * @return the range of calendars
	 */
	@Override
	public java.util.List<eu.strasbourg.service.gtfs.model.Calendar>
		getCalendars(int start, int end) {

		return _calendarLocalService.getCalendars(start, end);
	}

	/**
	 * Returns the number of calendars.
	 *
	 * @return the number of calendars
	 */
	@Override
	public int getCalendarsCount() {
		return _calendarLocalService.getCalendarsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _calendarLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _calendarLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Import des calendrier sous le format de données GTFS
	 */
	@Override
	public void importFromGTFS(
			java.util.Map<String, eu.strasbourg.utils.models.CalendarGTFS> data)
		throws com.liferay.portal.kernel.exception.PortalException {

		_calendarLocalService.importFromGTFS(data);
	}

	/**
	 * Supprime toutes les Calendar
	 */
	@Override
	public void removeAllCalendars()
		throws com.liferay.portal.kernel.exception.PortalException {

		_calendarLocalService.removeAllCalendars();
	}

	/**
	 * Supprime un Calendar
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar removeCalendar(
			long calendarId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.removeCalendar(calendarId);
	}

	/**
	 * Updates the calendar in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CalendarLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param calendar the calendar
	 * @return the calendar that was updated
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar updateCalendar(
		eu.strasbourg.service.gtfs.model.Calendar calendar) {

		return _calendarLocalService.updateCalendar(calendar);
	}

	/**
	 * Met à jour un Calendar et l'enregistre en base de données
	 *
	 * @throws IOException
	 */
	@Override
	public eu.strasbourg.service.gtfs.model.Calendar updateCalendar(
			eu.strasbourg.service.gtfs.model.Calendar calendar,
			com.liferay.portal.kernel.service.ServiceContext sc)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _calendarLocalService.updateCalendar(calendar, sc);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _calendarLocalService.getBasePersistence();
	}

	@Override
	public CalendarLocalService getWrappedService() {
		return _calendarLocalService;
	}

	@Override
	public void setWrappedService(CalendarLocalService calendarLocalService) {
		_calendarLocalService = calendarLocalService;
	}

	private CalendarLocalService _calendarLocalService;

}