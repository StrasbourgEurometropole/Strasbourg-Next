/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArtworkService}.
 *
 * @author BenjaminBini
 * @see ArtworkService
 * @generated
 */
public class ArtworkServiceWrapper
	implements ArtworkService, ServiceWrapper<ArtworkService> {

	public ArtworkServiceWrapper() {
		this(null);
	}

	public ArtworkServiceWrapper(ArtworkService artworkService) {
		_artworkService = artworkService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _artworkService.getOSGiServiceIdentifier();
	}

	@Override
	public ArtworkService getWrappedService() {
		return _artworkService;
	}

	@Override
	public void setWrappedService(ArtworkService artworkService) {
		_artworkService = artworkService;
	}

	private ArtworkService _artworkService;

}