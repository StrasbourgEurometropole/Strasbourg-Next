/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service;

import java.util.Map;

/**
 * Provides the remote service utility for Ligne. This utility wraps
 * <code>eu.strasbourg.service.gtfs.service.impl.LigneServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Cedric Henry
 * @see LigneService
 * @generated
 */
public class LigneServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.gtfs.service.impl.LigneServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Recuperer les couleurs des lignes
	 */
	public static com.liferay.portal.kernel.json.JSONArray getLigneColors() {
		return getService().getLigneColors();
	}

	/**
	 * Recuperer les couleurs des lignes pour freemarker
	 */
	public static Map<String, String[]> getLigneColorsFreemarker() {
		return getService().getLigneColorsFreemarker();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static LigneService getService() {
		return _service;
	}

	public static void setService(LigneService service) {
		_service = service;
	}

	private static volatile LigneService _service;

}