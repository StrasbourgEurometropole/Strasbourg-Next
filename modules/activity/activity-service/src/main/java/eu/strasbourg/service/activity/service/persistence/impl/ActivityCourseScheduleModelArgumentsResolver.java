/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.activity.model.ActivityCourseScheduleTable;
import eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleImpl;
import eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from ActivityCourseSchedule.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.activity.model.impl.ActivityCourseScheduleImpl",
		"table.name=activity_ActivityCourseSchedule"
	},
	service = ArgumentsResolver.class
)
public class ActivityCourseScheduleModelArgumentsResolver
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

		ActivityCourseScheduleModelImpl activityCourseScheduleModelImpl =
			(ActivityCourseScheduleModelImpl)baseModel;

		long columnBitmask = activityCourseScheduleModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				activityCourseScheduleModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					activityCourseScheduleModelImpl.getColumnBitmask(
						columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				activityCourseScheduleModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ActivityCourseScheduleImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ActivityCourseScheduleTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ActivityCourseScheduleModelImpl activityCourseScheduleModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					activityCourseScheduleModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = activityCourseScheduleModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}