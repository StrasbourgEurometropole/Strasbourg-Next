/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PlacitPlaceService}.
 *
 * @author Cedric Henry
 * @see PlacitPlaceService
 * @generated
 */
public class PlacitPlaceServiceWrapper
	implements PlacitPlaceService, ServiceWrapper<PlacitPlaceService> {

	public PlacitPlaceServiceWrapper() {
		this(null);
	}

	public PlacitPlaceServiceWrapper(PlacitPlaceService placitPlaceService) {
		_placitPlaceService = placitPlaceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _placitPlaceService.getOSGiServiceIdentifier();
	}

	@Override
	public PlacitPlaceService getWrappedService() {
		return _placitPlaceService;
	}

	@Override
	public void setWrappedService(PlacitPlaceService placitPlaceService) {
		_placitPlaceService = placitPlaceService;
	}

	private PlacitPlaceService _placitPlaceService;

}