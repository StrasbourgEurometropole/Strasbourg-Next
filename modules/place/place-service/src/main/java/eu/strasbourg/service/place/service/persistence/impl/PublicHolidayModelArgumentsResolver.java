/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.place.model.PublicHolidayTable;
import eu.strasbourg.service.place.model.impl.PublicHolidayImpl;
import eu.strasbourg.service.place.model.impl.PublicHolidayModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from PublicHoliday.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.place.model.impl.PublicHolidayImpl",
		"table.name=place_PublicHoliday"
	},
	service = ArgumentsResolver.class
)
public class PublicHolidayModelArgumentsResolver implements ArgumentsResolver {

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

		PublicHolidayModelImpl publicHolidayModelImpl =
			(PublicHolidayModelImpl)baseModel;

		long columnBitmask = publicHolidayModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(publicHolidayModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					publicHolidayModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(publicHolidayModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PublicHolidayImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PublicHolidayTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PublicHolidayModelImpl publicHolidayModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = publicHolidayModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = publicHolidayModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}