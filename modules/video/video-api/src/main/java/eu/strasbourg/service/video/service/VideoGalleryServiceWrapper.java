/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VideoGalleryService}.
 *
 * @author BenjaminBini
 * @see VideoGalleryService
 * @generated
 */
public class VideoGalleryServiceWrapper
	implements ServiceWrapper<VideoGalleryService>, VideoGalleryService {

	public VideoGalleryServiceWrapper() {
		this(null);
	}

	public VideoGalleryServiceWrapper(VideoGalleryService videoGalleryService) {
		_videoGalleryService = videoGalleryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _videoGalleryService.getOSGiServiceIdentifier();
	}

	@Override
	public VideoGalleryService getWrappedService() {
		return _videoGalleryService;
	}

	@Override
	public void setWrappedService(VideoGalleryService videoGalleryService) {
		_videoGalleryService = videoGalleryService;
	}

	private VideoGalleryService _videoGalleryService;

}