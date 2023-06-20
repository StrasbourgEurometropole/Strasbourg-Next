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

package eu.strasbourg.service.council.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.council.model.OfficialTypeCouncilTable;
import eu.strasbourg.service.council.model.impl.OfficialTypeCouncilImpl;
import eu.strasbourg.service.council.model.impl.OfficialTypeCouncilModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from OfficialTypeCouncil.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OfficialTypeCouncilModelArgumentsResolver
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

		OfficialTypeCouncilModelImpl officialTypeCouncilModelImpl =
			(OfficialTypeCouncilModelImpl)baseModel;

		long columnBitmask = officialTypeCouncilModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				officialTypeCouncilModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					officialTypeCouncilModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				officialTypeCouncilModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return OfficialTypeCouncilImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return OfficialTypeCouncilTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		OfficialTypeCouncilModelImpl officialTypeCouncilModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					officialTypeCouncilModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = officialTypeCouncilModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}