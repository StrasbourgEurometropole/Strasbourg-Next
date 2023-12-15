/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.project.model.SaisineObservatoireTable;
import eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl;
import eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from SaisineObservatoire.
 *
 * @author Cedric Henry
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl",
		"table.name=project_SaisineObservatoire"
	},
	service = ArgumentsResolver.class
)
public class SaisineObservatoireModelArgumentsResolver
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

		SaisineObservatoireModelImpl saisineObservatoireModelImpl =
			(SaisineObservatoireModelImpl)baseModel;

		long columnBitmask = saisineObservatoireModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				saisineObservatoireModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					saisineObservatoireModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(SaisineObservatoirePersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				saisineObservatoireModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SaisineObservatoireImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SaisineObservatoireTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SaisineObservatoireModelImpl saisineObservatoireModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					saisineObservatoireModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = saisineObservatoireModelImpl.getColumnValue(
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

		orderByColumnsBitmask |= SaisineObservatoireModelImpl.getColumnBitmask(
			"title");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}