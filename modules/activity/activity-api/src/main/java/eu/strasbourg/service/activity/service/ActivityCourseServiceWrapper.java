/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityCourseService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseService
 * @generated
 */
public class ActivityCourseServiceWrapper
	implements ActivityCourseService, ServiceWrapper<ActivityCourseService> {

	public ActivityCourseServiceWrapper() {
		this(null);
	}

	public ActivityCourseServiceWrapper(
		ActivityCourseService activityCourseService) {

		_activityCourseService = activityCourseService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityCourseService.getOSGiServiceIdentifier();
	}

	@Override
	public ActivityCourseService getWrappedService() {
		return _activityCourseService;
	}

	@Override
	public void setWrappedService(ActivityCourseService activityCourseService) {
		_activityCourseService = activityCourseService;
	}

	private ActivityCourseService _activityCourseService;

}