/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InitiativeService}.
 *
 * @author Cedric Henry
 * @see InitiativeService
 * @generated
 */
public class InitiativeServiceWrapper
	implements InitiativeService, ServiceWrapper<InitiativeService> {

	public InitiativeServiceWrapper() {
		this(null);
	}

	public InitiativeServiceWrapper(InitiativeService initiativeService) {
		_initiativeService = initiativeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _initiativeService.getOSGiServiceIdentifier();
	}

	@Override
	public InitiativeService getWrappedService() {
		return _initiativeService;
	}

	@Override
	public void setWrappedService(InitiativeService initiativeService) {
		_initiativeService = initiativeService;
	}

	private InitiativeService _initiativeService;

}