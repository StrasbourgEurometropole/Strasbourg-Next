/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArretService}.
 *
 * @author Cedric Henry
 * @see ArretService
 * @generated
 */
public class ArretServiceWrapper
	implements ArretService, ServiceWrapper<ArretService> {

	public ArretServiceWrapper() {
		this(null);
	}

	public ArretServiceWrapper(ArretService arretService) {
		_arretService = arretService;
	}

	/**
	 * Recuperer les lignes qui ont des alertes
	 */
	@Override
	public java.util.List<String> getAlerts() {
		return _arretService.getAlerts();
	}

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		String stopCode) {

		return _arretService.getArretRealTime(stopCode);
	}

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 *
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 * @param type type de l'arret (0 -> tram, 3 -> bus)
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		String stopCode, int type, int timeOut) {

		return _arretService.getArretRealTime(stopCode, type, timeOut);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _arretService.getOSGiServiceIdentifier();
	}

	@Override
	public ArretService getWrappedService() {
		return _arretService;
	}

	@Override
	public void setWrappedService(ArretService arretService) {
		_arretService = arretService;
	}

	private ArretService _arretService;

}