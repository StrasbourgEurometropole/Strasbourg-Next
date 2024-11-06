/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PlaceService}.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceService
 * @generated
 */
public class PlaceServiceWrapper
	implements PlaceService, ServiceWrapper<PlaceService> {

	public PlaceServiceWrapper() {
		this(null);
	}

	public PlaceServiceWrapper(PlaceService placeService) {
		_placeService = placeService;
	}

	/**
	 * Retourne les horaires du jour
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getCacheJsonHoraire(
		String sigId, String localeId) {

		return _placeService.getCacheJsonHoraire(sigId, localeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEquipments()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getEquipments();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _placeService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getPlaceById(long id) {
		return _placeService.getPlaceById(id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getPlaceByIdSIG(
		String sigId) {

		return _placeService.getPlaceByIdSIG(sigId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlaces() {
		return _placeService.getPlaces();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlacesByNameAndLanguage(
		String name, String language) {

		return _placeService.getPlacesByNameAndLanguage(name, language);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlacesByTerritory(
			String territoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getPlacesByTerritory(territoryId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlacesByTerritoryAndType(
			String territoryId, String typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getPlacesByTerritoryAndType(territoryId, typeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlacesByType(
			String typeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getPlacesByType(typeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPlacesByTypes(
			java.util.List<String> typesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getPlacesByTypes(typesId);
	}

	/**
	 * Retourne le géoJSON des lieux
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getPlacesGeoJSON() {
		return _placeService.getPlacesGeoJSON();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getRealtime() {
		return _placeService.getRealtime();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getTypes()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _placeService.getTypes();
	}

	@Override
	public PlaceService getWrappedService() {
		return _placeService;
	}

	@Override
	public void setWrappedService(PlaceService placeService) {
		_placeService = placeService;
	}

	private PlaceService _placeService;

}