/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Activity. This utility wraps
 * <code>eu.strasbourg.service.activity.service.impl.ActivityServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityService
 * @generated
 */
public class ActivityServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.activity.service.impl.ActivityServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.json.JSONArray getActivities(
			long groupId, String name, String language)
		throws PortalException {

		return getService().getActivities(groupId, name, language);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ActivityService getService() {
		return _service;
	}

	public static void setService(ActivityService service) {
		_service = service;
	}

	private static volatile ActivityService _service;

}