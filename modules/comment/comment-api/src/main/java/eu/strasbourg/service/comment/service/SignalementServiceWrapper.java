/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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