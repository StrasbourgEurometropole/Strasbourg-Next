/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Manifestation. This utility wraps
 * <code>eu.strasbourg.service.agenda.service.impl.ManifestationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author BenjaminBini
 * @see ManifestationService
 * @generated
 */
public class ManifestationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.ManifestationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONObject getManifestation(
			long id)
		throws PortalException {

		return getService().getManifestation(id);
	}

	public static com.liferay.portal.kernel.json.JSONArray getManifestations()
		throws PortalException {

		return getService().getManifestations();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ManifestationService getService() {
		return _service;
	}

	public static void setService(ManifestationService service) {
		_service = service;
	}

	private static volatile ManifestationService _service;

}