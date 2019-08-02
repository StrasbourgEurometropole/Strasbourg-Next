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

package eu.strasbourg.service.place.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Place. This utility wraps
 * {@link eu.strasbourg.service.place.service.impl.PlaceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceService
 * @see eu.strasbourg.service.place.service.base.PlaceServiceBaseImpl
 * @see eu.strasbourg.service.place.service.impl.PlaceServiceImpl
 * @generated
 */
@ProviderType
public class PlaceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link eu.strasbourg.service.place.service.impl.PlaceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray getPlaces()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlaces();
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByNameAndLanguage(
		java.lang.String name, java.lang.String language)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesByNameAndLanguage(name, language);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByTerritory(
		java.lang.String territoryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesByTerritory(territoryId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByTerritoryAndType(
		java.lang.String territoryId, java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesByTerritoryAndType(territoryId, typeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByType(
		java.lang.String typeId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesByType(typeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPlacesByTypes(
		java.util.List<java.lang.String> typesId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesByTypes(typesId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getTypes()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTypes();
	}

	/**
	* Retourne l'ancien web service LR6 concernant les Types de lieu
	*/
	public static com.liferay.portal.kernel.json.JSONObject getLegacyCategoriesJSON()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLegacyCategoriesJSON();
	}

	/**
	* Retourne l'horrible ancien web service LR6
	*/
	public static com.liferay.portal.kernel.json.JSONObject getLegacyJSON() {
		return getService().getLegacyJSON();
	}

	/**
	* Retourne l'ancien web service LR6 concernant les Territoires
	*/
	public static com.liferay.portal.kernel.json.JSONObject getLegacyTerritoriesJSON()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLegacyTerritoriesJSON();
	}

	public static com.liferay.portal.kernel.json.JSONObject getPlaceById(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlaceById(id);
	}

	public static com.liferay.portal.kernel.json.JSONObject getPlaceByIdSIG(
		java.lang.String sigId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlaceByIdSIG(sigId);
	}

	/**
	* Retourne le géoJSON des lieux
	*/
	public static com.liferay.portal.kernel.json.JSONObject getPlacesGeoJSON()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPlacesGeoJSON();
	}

	public static com.liferay.portal.kernel.json.JSONObject getRealtime()
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRealtime();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static PlaceService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PlaceService, PlaceService> _serviceTracker = ServiceTrackerFactory.open(PlaceService.class);
}