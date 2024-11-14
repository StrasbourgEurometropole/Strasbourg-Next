/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Event. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.EventServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see EventService
 * @generated
 */
public class EventServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray getCategories()
		throws PortalException {

		return getService().getCategories();
	}

	public static com.liferay.portal.kernel.json.JSONObject getCategory(
		long id) {

		return getService().getCategory(id);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEvent(long id) {
		return getService().getEvent(id);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEvents() {
		return getService().getEvents();
	}

	public static com.liferay.portal.kernel.json.JSONObject getEventsByCategory(
			String categoryId)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getEventsByCategory(categoryId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEventsByDate(
			String date)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getEventsByDate(date);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEventsByLanguage(
			String language)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getEventsByLanguage(language);
	}

	/**
	 * Retourne les évènements approuvés d'une manifestations
	 */
	public static com.liferay.portal.kernel.json.JSONObject
			getEventsByManifestationWithLimit(
				long manifestationId, int start, int delta, String language)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getEventsByManifestationWithLimit(
			manifestationId, start, delta, language);
	}

	public static com.liferay.portal.kernel.json.JSONObject getEventsByPlace(
			String placeSIGId)
		throws com.liferay.portal.kernel.json.JSONException {

		return getService().getEventsByPlace(placeSIGId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONArray getPublics()
		throws PortalException {

		return getService().getPublics();
	}

	public static com.liferay.portal.kernel.json.JSONArray getServices()
		throws PortalException {

		return getService().getServices();
	}

	public static com.liferay.portal.kernel.json.JSONArray getSessions(
		long eventID) {

		return getService().getSessions(eventID);
	}

	public static com.liferay.portal.kernel.json.JSONArray getTerritories()
		throws PortalException {

		return getService().getTerritories();
	}

	public static com.liferay.portal.kernel.json.JSONArray getThemes()
		throws PortalException {

		return getService().getThemes();
	}

	public static com.liferay.portal.kernel.json.JSONArray getTypes()
		throws PortalException {

		return getService().getTypes();
	}

	public static EventService getService() {
		return _service;
	}

	public static void setService(EventService service) {
		_service = service;
	}

	private static volatile EventService _service;

}