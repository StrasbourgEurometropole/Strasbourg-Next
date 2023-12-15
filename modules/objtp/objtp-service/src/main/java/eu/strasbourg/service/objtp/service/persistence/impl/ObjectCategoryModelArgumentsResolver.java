/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.objtp.model.ObjectCategoryTable;
import eu.strasbourg.service.objtp.model.impl.ObjectCategoryImpl;
import eu.strasbourg.service.objtp.model.impl.ObjectCategoryModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from ObjectCategory.
 *
 * @author JeremyZwickert
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.objtp.model.impl.ObjectCategoryImpl",
		"table.name=objtp_ObjectCategory"
	},
	service = ArgumentsResolver.class
)
public class ObjectCategoryModelArgumentsResolver implements ArgumentsResolver {

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

		ObjectCategoryModelImpl objectCategoryModelImpl =
			(ObjectCategoryModelImpl)baseModel;

		long columnBitmask = objectCategoryModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(objectCategoryModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					objectCategoryModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(ObjectCategoryPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(objectCategoryModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ObjectCategoryImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ObjectCategoryTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ObjectCategoryModelImpl objectCategoryModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = objectCategoryModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = objectCategoryModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= ObjectCategoryModelImpl.getColumnBitmask(
			"name");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}