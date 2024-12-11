/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Place. This utility wraps
 * <code>eu.strasbourg.service.place.service.impl.PlaceServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceService
 * @generated
 */
public class PlaceServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.PlaceServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Retourne les horaires du jour
	 */
	public static com.liferay.portal.kernel.json.JSONObject getCacheJsonHoraire(
		String sigId, String localeId) {

		return getService().getCacheJsonHoraire(sigId, localeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEquipments()
		throws PortalException {

		return getService().getEquipments();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject getPlaceById(
		long id) {

		return getService().getPlaceById(id);
	}

	public static com.liferay.portal.kernel.json.JSONObject getPlaceByIdSIG(
		String sigId) {

		return getService().getPlaceByIdSIG(sigId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlaces()
		throws PortalException {

		return getService().getPlaces();
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getPlacesByNameAndLanguage(String name, String language)
		throws PortalException {

		return getService().getPlacesByNameAndLanguage(name, language);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByTerritory(
			String territoryId)
		throws PortalException {

		return getService().getPlacesByTerritory(territoryId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
			getPlacesByTerritoryAndType(String territoryId, String typeId)
		throws PortalException {

		return getService().getPlacesByTerritoryAndType(territoryId, typeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByType(
			String typeId)
		throws PortalException {

		return getService().getPlacesByType(typeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByTypes(
			List<String> typesId)
		throws PortalException {

		return getService().getPlacesByTypes(typesId);
	}

	/**
	 * Retourne le géoJSON des lieux
	 */
	public static com.liferay.portal.kernel.json.JSONObject getPlacesGeoJSON() {
		return getService().getPlacesGeoJSON();
	}

	public static com.liferay.portal.kernel.json.JSONObject getRealtime() {
		return getService().getRealtime();
	}

	public static com.liferay.portal.kernel.json.JSONArray getTypes()
		throws PortalException {

		return getService().getTypes();
	}

	public static PlaceService getService() {
		return _service;
	}

	public static void setService(PlaceService service) {
		_service = service;
	}

	private static volatile PlaceService _service;

}