/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EditionGalleryService}.
 *
 * @author BenjaminBini
 * @see EditionGalleryService
 * @generated
 */
public class EditionGalleryServiceWrapper
	implements EditionGalleryService, ServiceWrapper<EditionGalleryService> {

	public EditionGalleryServiceWrapper() {
		this(null);
	}

	public EditionGalleryServiceWrapper(
		EditionGalleryService editionGalleryService) {

		_editionGalleryService = editionGalleryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _editionGalleryService.getOSGiServiceIdentifier();
	}

	@Override
	public EditionGalleryService getWrappedService() {
		return _editionGalleryService;
	}

	@Override
	public void setWrappedService(EditionGalleryService editionGalleryService) {
		_editionGalleryService = editionGalleryService;
	}

	private EditionGalleryService _editionGalleryService;

}