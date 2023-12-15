/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArtworkCollectionService}.
 *
 * @author BenjaminBini
 * @see ArtworkCollectionService
 * @generated
 */
public class ArtworkCollectionServiceWrapper
	implements ArtworkCollectionService,
			   ServiceWrapper<ArtworkCollectionService> {

	public ArtworkCollectionServiceWrapper() {
		this(null);
	}

	public ArtworkCollectionServiceWrapper(
		ArtworkCollectionService artworkCollectionService) {

		_artworkCollectionService = artworkCollectionService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _artworkCollectionService.getOSGiServiceIdentifier();
	}

	@Override
	public ArtworkCollectionService getWrappedService() {
		return _artworkCollectionService;
	}

	@Override
	public void setWrappedService(
		ArtworkCollectionService artworkCollectionService) {

		_artworkCollectionService = artworkCollectionService;
	}

	private ArtworkCollectionService _artworkCollectionService;

}