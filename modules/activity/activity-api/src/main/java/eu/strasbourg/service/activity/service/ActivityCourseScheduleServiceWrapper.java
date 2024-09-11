/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityCourseScheduleService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseScheduleService
 * @generated
 */
public class ActivityCourseScheduleServiceWrapper
	implements ActivityCourseScheduleService,
			   ServiceWrapper<ActivityCourseScheduleService> {

	public ActivityCourseScheduleServiceWrapper() {
		this(null);
	}

	public ActivityCourseScheduleServiceWrapper(
		ActivityCourseScheduleService activityCourseScheduleService) {

		_activityCourseScheduleService = activityCourseScheduleService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityCourseScheduleService.getOSGiServiceIdentifier();
	}

	@Override
	public ActivityCourseScheduleService getWrappedService() {
		return _activityCourseScheduleService;
	}

	@Override
	public void setWrappedService(
		ActivityCourseScheduleService activityCourseScheduleService) {

		_activityCourseScheduleService = activityCourseScheduleService;
	}

	private ActivityCourseScheduleService _activityCourseScheduleService;

}