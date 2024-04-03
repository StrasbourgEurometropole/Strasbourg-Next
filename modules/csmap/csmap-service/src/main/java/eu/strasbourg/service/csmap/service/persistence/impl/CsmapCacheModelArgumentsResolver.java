/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.csmap.model.CsmapCacheTable;
import eu.strasbourg.service.csmap.model.impl.CsmapCacheImpl;
import eu.strasbourg.service.csmap.model.impl.CsmapCacheModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from CsmapCache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=eu.strasbourg.service.csmap.model.impl.CsmapCacheImpl",
		"table.name=csmap_CsmapCache"
	},
	service = ArgumentsResolver.class
)
public class CsmapCacheModelArgumentsResolver implements ArgumentsResolver {

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

		CsmapCacheModelImpl csmapCacheModelImpl =
			(CsmapCacheModelImpl)baseModel;

		long columnBitmask = csmapCacheModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(csmapCacheModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= csmapCacheModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(csmapCacheModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CsmapCacheImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CsmapCacheTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CsmapCacheModelImpl csmapCacheModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = csmapCacheModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = csmapCacheModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}