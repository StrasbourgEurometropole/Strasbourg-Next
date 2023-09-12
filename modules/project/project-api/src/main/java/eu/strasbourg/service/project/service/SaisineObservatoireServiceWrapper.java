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

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SaisineObservatoireService}.
 *
 * @author Cedric Henry
 * @see SaisineObservatoireService
 * @generated
 */
public class SaisineObservatoireServiceWrapper
	implements SaisineObservatoireService,
			   ServiceWrapper<SaisineObservatoireService> {

	public SaisineObservatoireServiceWrapper(
		SaisineObservatoireService saisineObservatoireService) {

		_saisineObservatoireService = saisineObservatoireService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _saisineObservatoireService.getOSGiServiceIdentifier();
	}

	@Override
	public SaisineObservatoireService getWrappedService() {
		return _saisineObservatoireService;
	}

	@Override
	public void setWrappedService(
		SaisineObservatoireService saisineObservatoireService) {

		_saisineObservatoireService = saisineObservatoireService;
	}

	private SaisineObservatoireService _saisineObservatoireService;

}