/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EditionService}.
 *
 * @author BenjaminBini
 * @see EditionService
 * @generated
 */
public class EditionServiceWrapper
	implements EditionService, ServiceWrapper<EditionService> {

	public EditionServiceWrapper() {
		this(null);
	}

	public EditionServiceWrapper(EditionService editionService) {
		_editionService = editionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _editionService.getOSGiServiceIdentifier();
	}

	@Override
	public EditionService getWrappedService() {
		return _editionService;
	}

	@Override
	public void setWrappedService(EditionService editionService) {
		_editionService = editionService;
	}

	private EditionService _editionService;

}