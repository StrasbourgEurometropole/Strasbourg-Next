/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model.impl;

import eu.strasbourg.service.activity.model.ActivityCoursePlace;
import eu.strasbourg.service.activity.service.ActivityCoursePlaceLocalServiceUtil;

/**
 * The extended model base implementation for the ActivityCoursePlace service. Represents a row in the &quot;activity_ActivityCoursePlace&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ActivityCoursePlaceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlaceImpl
 * @see ActivityCoursePlace
 * @generated
 */
public abstract class ActivityCoursePlaceBaseImpl
	extends ActivityCoursePlaceModelImpl implements ActivityCoursePlace {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a activity course place model instance should use the <code>ActivityCoursePlace</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ActivityCoursePlaceLocalServiceUtil.addActivityCoursePlace(this);
		}
		else {
			ActivityCoursePlaceLocalServiceUtil.updateActivityCoursePlace(this);
		}
	}

}