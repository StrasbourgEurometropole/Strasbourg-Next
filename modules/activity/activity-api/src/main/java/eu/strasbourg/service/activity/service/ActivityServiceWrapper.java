/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityService
 * @generated
 */
public class ActivityServiceWrapper
	implements ActivityService, ServiceWrapper<ActivityService> {

	public ActivityServiceWrapper() {
		this(null);
	}

	public ActivityServiceWrapper(ActivityService activityService) {
		_activityService = activityService;
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getActivities(
			long groupId, String name, String language)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _activityService.getActivities(groupId, name, language);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityService.getOSGiServiceIdentifier();
	}

	@Override
	public ActivityService getWrappedService() {
		return _activityService;
	}

	@Override
	public void setWrappedService(ActivityService activityService) {
		_activityService = activityService;
	}

	private ActivityService _activityService;

}