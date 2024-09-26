/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
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
 * Provides the remote service interface for Arret. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Cedric Henry
 * @see ArretServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=gtfs",
		"json.web.service.context.path=Arret"
	},
	service = ArretService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ArretService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the arret remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ArretServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Recuperer les lignes qui ont des alertes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<String> getAlerts();

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getArretRealTime(String stopCode);

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 * @param type type de l'arret (0 -> tram, 3 -> bus)
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getArretRealTime(String stopCode, int type, int timeOut);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}