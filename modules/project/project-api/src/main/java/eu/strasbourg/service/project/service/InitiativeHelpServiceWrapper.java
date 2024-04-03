/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InitiativeHelpService}.
 *
 * @author Cedric Henry
 * @see InitiativeHelpService
 * @generated
 */
public class InitiativeHelpServiceWrapper
	implements InitiativeHelpService, ServiceWrapper<InitiativeHelpService> {

	public InitiativeHelpServiceWrapper() {
		this(null);
	}

	public InitiativeHelpServiceWrapper(
		InitiativeHelpService initiativeHelpService) {

		_initiativeHelpService = initiativeHelpService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _initiativeHelpService.getOSGiServiceIdentifier();
	}

	@Override
	public InitiativeHelpService getWrappedService() {
		return _initiativeHelpService;
	}

	@Override
	public void setWrappedService(InitiativeHelpService initiativeHelpService) {
		_initiativeHelpService = initiativeHelpService;
	}

	private InitiativeHelpService _initiativeHelpService;

}