/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.tipi.model.TipiEntryTable;
import eu.strasbourg.service.tipi.model.impl.TipiEntryImpl;
import eu.strasbourg.service.tipi.model.impl.TipiEntryModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from TipiEntry.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.tipi.model.impl.TipiEntryImpl",
		"table.name=tipi_TipiEntry"
	},
	service = ArgumentsResolver.class
)
public class TipiEntryModelArgumentsResolver implements ArgumentsResolver {

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

		TipiEntryModelImpl tipiEntryModelImpl = (TipiEntryModelImpl)baseModel;

		long columnBitmask = tipiEntryModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(tipiEntryModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= tipiEntryModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(tipiEntryModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return TipiEntryImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return TipiEntryTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		TipiEntryModelImpl tipiEntryModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = tipiEntryModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = tipiEntryModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}