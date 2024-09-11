/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityCoursePlaceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlaceService
 * @generated
 */
public class ActivityCoursePlaceServiceWrapper
	implements ActivityCoursePlaceService,
			   ServiceWrapper<ActivityCoursePlaceService> {

	public ActivityCoursePlaceServiceWrapper() {
		this(null);
	}

	public ActivityCoursePlaceServiceWrapper(
		ActivityCoursePlaceService activityCoursePlaceService) {

		_activityCoursePlaceService = activityCoursePlaceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityCoursePlaceService.getOSGiServiceIdentifier();
	}

	@Override
	public ActivityCoursePlaceService getWrappedService() {
		return _activityCoursePlaceService;
	}

	@Override
	public void setWrappedService(
		ActivityCoursePlaceService activityCoursePlaceService) {

		_activityCoursePlaceService = activityCoursePlaceService;
	}

	private ActivityCoursePlaceService _activityCoursePlaceService;

}