/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SignataireService}.
 *
 * @author Cedric Henry
 * @see SignataireService
 * @generated
 */
public class SignataireServiceWrapper
	implements ServiceWrapper<SignataireService>, SignataireService {

	public SignataireServiceWrapper() {
		this(null);
	}

	public SignataireServiceWrapper(SignataireService signataireService) {
		_signataireService = signataireService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signataireService.getOSGiServiceIdentifier();
	}

	@Override
	public SignataireService getWrappedService() {
		return _signataireService;
	}

	@Override
	public void setWrappedService(SignataireService signataireService) {
		_signataireService = signataireService;
	}

	private SignataireService _signataireService;

}