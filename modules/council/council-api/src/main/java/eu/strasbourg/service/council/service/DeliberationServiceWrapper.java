/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DeliberationService}.
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationService
 * @generated
 */
public class DeliberationServiceWrapper
	implements DeliberationService, ServiceWrapper<DeliberationService> {

	public DeliberationServiceWrapper() {
		this(null);
	}

	public DeliberationServiceWrapper(DeliberationService deliberationService) {
		_deliberationService = deliberationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _deliberationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getUserFront(
		long officialId, String officialDeviceInfo, long councilSessionId) {

		return _deliberationService.getUserFront(
			officialId, officialDeviceInfo, councilSessionId);
	}

	@Override
	public DeliberationService getWrappedService() {
		return _deliberationService;
	}

	@Override
	public void setWrappedService(DeliberationService deliberationService) {
		_deliberationService = deliberationService;
	}

	private DeliberationService _deliberationService;

}