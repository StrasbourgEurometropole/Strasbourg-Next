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

package eu.strasbourg.service.activity.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import eu.strasbourg.service.activity.model.ActivityCoursePlaceTable;
import eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceImpl;
import eu.strasbourg.service.activity.model.impl.ActivityCoursePlaceModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from ActivityCoursePlace.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ActivityCoursePlaceModelArgumentsResolver
	implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		ActivityCoursePlaceModelImpl activityCoursePlaceModelImpl =
			(ActivityCoursePlaceModelImpl)baseModel;

		long columnBitmask = activityCoursePlaceModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				activityCoursePlaceModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					activityCoursePlaceModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				activityCoursePlaceModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ActivityCoursePlaceImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ActivityCoursePlaceTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ActivityCoursePlaceModelImpl activityCoursePlaceModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					activityCoursePlaceModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = activityCoursePlaceModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}