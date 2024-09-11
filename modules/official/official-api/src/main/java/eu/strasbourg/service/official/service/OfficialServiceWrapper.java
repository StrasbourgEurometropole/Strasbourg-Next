/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.official.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OfficialService}.
 *
 * @author AngeliqueZUNINO
 * @see OfficialService
 * @generated
 */
public class OfficialServiceWrapper
	implements OfficialService, ServiceWrapper<OfficialService> {

	public OfficialServiceWrapper() {
		this(null);
	}

	public OfficialServiceWrapper(OfficialService officialService) {
		_officialService = officialService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _officialService.getOSGiServiceIdentifier();
	}

	@Override
	public OfficialService getWrappedService() {
		return _officialService;
	}

	@Override
	public void setWrappedService(OfficialService officialService) {
		_officialService = officialService;
	}

	private OfficialService _officialService;

}