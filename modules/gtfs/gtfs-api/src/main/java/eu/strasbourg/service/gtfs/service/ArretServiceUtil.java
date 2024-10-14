/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import java.util.List;

/**
 * Provides the remote service utility for Arret. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Cedric Henry
 * @see ArretService
 * @generated
 */
public class ArretServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Recuperer les lignes qui ont des alertes
	 */
	public static List<String> getAlerts() {
		return getService().getAlerts();
	}

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 */
	public static com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		String stopCode) {

		return getService().getArretRealTime(stopCode);
	}

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 * @param type type de l'arret (0 -> tram, 3 -> bus)
	 */
	public static com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		String stopCode, int type, int timeOut) {

		return getService().getArretRealTime(stopCode, type, timeOut);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ArretService getService() {
		return _service;
	}

	public static void setService(ArretService service) {
		_service = service;
	}

	private static volatile ArretService _service;

}