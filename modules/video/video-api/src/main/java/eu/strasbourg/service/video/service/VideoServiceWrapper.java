/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VideoService}.
 *
 * @author BenjaminBini
 * @see VideoService
 * @generated
 */
public class VideoServiceWrapper
	implements ServiceWrapper<VideoService>, VideoService {

	public VideoServiceWrapper() {
		this(null);
	}

	public VideoServiceWrapper(VideoService videoService) {
		_videoService = videoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _videoService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getVideo(long id) {
		return _videoService.getVideo(id);
	}

	@Override
	public VideoService getWrappedService() {
		return _videoService;
	}

	@Override
	public void setWrappedService(VideoService videoService) {
		_videoService = videoService;
	}

	private VideoService _videoService;

}