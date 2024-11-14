/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Event. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author BenjaminBini
 * @see EventServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=agenda",
		"json.web.service.context.path=Event"
	},
	service = EventService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EventService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the event remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EventServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getCategories() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getCategory(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEvent(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEvents();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEventsByCategory(String categoryId)
		throws JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEventsByDate(String date) throws JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEventsByLanguage(String language) throws JSONException;

	/**
	 * Retourne les évènements approuvés d'une manifestations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEventsByManifestationWithLimit(
			long manifestationId, int start, int delta, String language)
		throws JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getEventsByPlace(String placeSIGId) throws JSONException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPublics() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getServices() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getSessions(long eventID);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getTerritories() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getThemes() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getTypes() throws PortalException;

}