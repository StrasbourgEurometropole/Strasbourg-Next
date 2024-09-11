/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.favorite.model.FavoriteTable;
import eu.strasbourg.service.favorite.model.impl.FavoriteImpl;
import eu.strasbourg.service.favorite.model.impl.FavoriteModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from Favorite.
 *
 * @author BenjaminBini
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.favorite.model.impl.FavoriteImpl",
		"table.name=favorite_Favorite"
	},
	service = ArgumentsResolver.class
)
public class FavoriteModelArgumentsResolver implements ArgumentsResolver {

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

		FavoriteModelImpl favoriteModelImpl = (FavoriteModelImpl)baseModel;

		long columnBitmask = favoriteModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(favoriteModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= favoriteModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(favoriteModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return FavoriteImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return FavoriteTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		FavoriteModelImpl favoriteModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = favoriteModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = favoriteModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}