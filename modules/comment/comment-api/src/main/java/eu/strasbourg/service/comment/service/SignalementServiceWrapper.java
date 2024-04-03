/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SignalementService}.
 *
 * @author Romain Vergnais
 * @see SignalementService
 * @generated
 */
public class SignalementServiceWrapper
	implements ServiceWrapper<SignalementService>, SignalementService {

	public SignalementServiceWrapper() {
		this(null);
	}

	public SignalementServiceWrapper(SignalementService signalementService) {
		_signalementService = signalementService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _signalementService.getOSGiServiceIdentifier();
	}

	@Override
	public SignalementService getWrappedService() {
		return _signalementService;
	}

	@Override
	public void setWrappedService(SignalementService signalementService) {
		_signalementService = signalementService;
	}

	private SignalementService _signalementService;

}