/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Place. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Angelique Zunino Champougny
 * @see PlaceServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=place",
		"json.web.service.context.path=Place"
	},
	service = PlaceService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PlaceService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.PlaceServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the place remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PlaceServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Retourne les horaires du jour
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getCacheJsonHoraire(String sigId, String localeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getEquipments() throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getPlaceById(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getPlaceByIdSIG(String sigId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlaces();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlacesByNameAndLanguage(String name, String language);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlacesByTerritory(String territoryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlacesByTerritoryAndType(
			String territoryId, String typeId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlacesByType(String typeId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPlacesByTypes(List<String> typesId)
		throws PortalException;

	/**
	 * Retourne le géoJSON des lieux
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getPlacesGeoJSON();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getRealtime();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getTypes() throws PortalException;

}