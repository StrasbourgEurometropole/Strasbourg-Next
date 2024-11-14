/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventService}.
 *
 * @author BenjaminBini
 * @see EventService
 * @generated
 */
public class EventServiceWrapper
	implements EventService, ServiceWrapper<EventService> {

	public EventServiceWrapper() {
		this(null);
	}

	public EventServiceWrapper(EventService eventService) {
		_eventService = eventService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCategories()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getCategories();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCategory(long id) {
		return _eventService.getCategory(id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEvent(long id) {
		return _eventService.getEvent(id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEvents() {
		return _eventService.getEvents();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventsByCategory(
			String categoryId)
		throws com.liferay.portal.kernel.json.JSONException {

		return _eventService.getEventsByCategory(categoryId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventsByDate(
			String date)
		throws com.liferay.portal.kernel.json.JSONException {

		return _eventService.getEventsByDate(date);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventsByLanguage(
			String language)
		throws com.liferay.portal.kernel.json.JSONException {

		return _eventService.getEventsByLanguage(language);
	}

	/**
	 * Retourne les évènements approuvés d'une manifestations
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject
			getEventsByManifestationWithLimit(
				long manifestationId, int start, int delta, String language)
		throws com.liferay.portal.kernel.json.JSONException {

		return _eventService.getEventsByManifestationWithLimit(
			manifestationId, start, delta, language);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getEventsByPlace(
			String placeSIGId)
		throws com.liferay.portal.kernel.json.JSONException {

		return _eventService.getEventsByPlace(placeSIGId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPublics()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getPublics();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getServices()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getServices();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getSessions(long eventID) {
		return _eventService.getSessions(eventID);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getTerritories()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getTerritories();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getThemes()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getThemes();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getTypes()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _eventService.getTypes();
	}

	@Override
	public EventService getWrappedService() {
		return _eventService;
	}

	@Override
	public void setWrappedService(EventService eventService) {
		_eventService = eventService;
	}

	private EventService _eventService;

}