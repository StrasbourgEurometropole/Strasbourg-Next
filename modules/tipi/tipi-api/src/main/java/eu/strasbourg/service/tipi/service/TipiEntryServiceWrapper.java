/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TipiEntryService}.
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntryService
 * @generated
 */
public class TipiEntryServiceWrapper
	implements ServiceWrapper<TipiEntryService>, TipiEntryService {

	public TipiEntryServiceWrapper() {
		this(null);
	}

	public TipiEntryServiceWrapper(TipiEntryService tipiEntryService) {
		_tipiEntryService = tipiEntryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tipiEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public TipiEntryService getWrappedService() {
		return _tipiEntryService;
	}

	@Override
	public void setWrappedService(TipiEntryService tipiEntryService) {
		_tipiEntryService = tipiEntryService;
	}

	private TipiEntryService _tipiEntryService;

}