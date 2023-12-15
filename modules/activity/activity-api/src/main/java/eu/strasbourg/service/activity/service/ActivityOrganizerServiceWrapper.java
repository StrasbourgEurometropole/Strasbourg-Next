/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityOrganizerService}.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityOrganizerService
 * @generated
 */
public class ActivityOrganizerServiceWrapper
	implements ActivityOrganizerService,
			   ServiceWrapper<ActivityOrganizerService> {

	public ActivityOrganizerServiceWrapper() {
		this(null);
	}

	public ActivityOrganizerServiceWrapper(
		ActivityOrganizerService activityOrganizerService) {

		_activityOrganizerService = activityOrganizerService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _activityOrganizerService.getOSGiServiceIdentifier();
	}

	@Override
	public ActivityOrganizerService getWrappedService() {
		return _activityOrganizerService;
	}

	@Override
	public void setWrappedService(
		ActivityOrganizerService activityOrganizerService) {

		_activityOrganizerService = activityOrganizerService;
	}

	private ActivityOrganizerService _activityOrganizerService;

}