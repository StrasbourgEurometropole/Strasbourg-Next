/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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

	public SaisineObservatoireServiceWrapper() {
		this(null);
	}

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