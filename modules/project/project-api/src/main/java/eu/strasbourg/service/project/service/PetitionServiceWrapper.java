/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PetitionService}.
 *
 * @author Cedric Henry
 * @see PetitionService
 * @generated
 */
public class PetitionServiceWrapper
	implements PetitionService, ServiceWrapper<PetitionService> {

	public PetitionServiceWrapper() {
		this(null);
	}

	public PetitionServiceWrapper(PetitionService petitionService) {
		_petitionService = petitionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _petitionService.getOSGiServiceIdentifier();
	}

	@Override
	public PetitionService getWrappedService() {
		return _petitionService;
	}

	@Override
	public void setWrappedService(PetitionService petitionService) {
		_petitionService = petitionService;
	}

	private PetitionService _petitionService;

}