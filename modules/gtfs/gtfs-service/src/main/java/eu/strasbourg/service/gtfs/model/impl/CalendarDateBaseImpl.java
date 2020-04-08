/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.gtfs.model.impl;

import aQute.bnd.annotation.ProviderType;

import eu.strasbourg.service.gtfs.model.CalendarDate;
import eu.strasbourg.service.gtfs.service.CalendarDateLocalServiceUtil;

/**
 * The extended model base implementation for the CalendarDate service. Represents a row in the &quot;gtfs_CalendarDate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarDateImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarDateImpl
 * @see CalendarDate
 * @generated
 */
@ProviderType
public abstract class CalendarDateBaseImpl extends CalendarDateModelImpl
	implements CalendarDate {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar date model instance should use the {@link CalendarDate} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			CalendarDateLocalServiceUtil.addCalendarDate(this);
		}
		else {
			CalendarDateLocalServiceUtil.updateCalendarDate(this);
		}
	}
}