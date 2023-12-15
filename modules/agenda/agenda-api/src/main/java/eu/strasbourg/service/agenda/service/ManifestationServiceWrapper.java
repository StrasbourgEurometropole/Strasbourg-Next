/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ManifestationService}.
 *
 * @author BenjaminBini
 * @see ManifestationService
 * @generated
 */
public class ManifestationServiceWrapper
	implements ManifestationService, ServiceWrapper<ManifestationService> {

	public ManifestationServiceWrapper() {
		this(null);
	}

	public ManifestationServiceWrapper(
		ManifestationService manifestationService) {

		_manifestationService = manifestationService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getManifestation(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _manifestationService.getManifestation(id);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getManifestations()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _manifestationService.getManifestations();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _manifestationService.getOSGiServiceIdentifier();
	}

	@Override
	public ManifestationService getWrappedService() {
		return _manifestationService;
	}

	@Override
	public void setWrappedService(ManifestationService manifestationService) {
		_manifestationService = manifestationService;
	}

	private ManifestationService _manifestationService;

}