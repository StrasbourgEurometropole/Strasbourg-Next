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

package eu.strasbourg.service.gtfs.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Arret. This utility wraps
 * {@link eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Cedric Henry
 * @see ArretService
 * @see eu.strasbourg.service.gtfs.service.base.ArretServiceBaseImpl
 * @see eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl
 * @generated
 */
@ProviderType
public class ArretServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link eu.strasbourg.service.gtfs.service.impl.ArretServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Recuperer les donnees temps real de la CTS pour un arret
	*
	* @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	*/
	public static com.liferay.portal.kernel.json.JSONArray getArretRealTime(
		java.lang.String stopCode) {
		return getService().getArretRealTime(stopCode);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ArretService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArretService, ArretService> _serviceTracker = ServiceTrackerFactory.open(ArretService.class);
}