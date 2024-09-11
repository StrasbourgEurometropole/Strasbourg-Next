/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.place.model.GoogleMyBusinessHistoricTable;
import eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricImpl;
import eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from GoogleMyBusinessHistoric.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricImpl",
		"table.name=place_GoogleMyBusinessHistoric"
	},
	service = ArgumentsResolver.class
)
public class GoogleMyBusinessHistoricModelArgumentsResolver
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

		GoogleMyBusinessHistoricModelImpl googleMyBusinessHistoricModelImpl =
			(GoogleMyBusinessHistoricModelImpl)baseModel;

		long columnBitmask =
			googleMyBusinessHistoricModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				googleMyBusinessHistoricModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					googleMyBusinessHistoricModelImpl.getColumnBitmask(
						columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(GoogleMyBusinessHistoricPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				googleMyBusinessHistoricModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return GoogleMyBusinessHistoricImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return GoogleMyBusinessHistoricTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		GoogleMyBusinessHistoricModelImpl googleMyBusinessHistoricModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					googleMyBusinessHistoricModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = googleMyBusinessHistoricModelImpl.getColumnValue(
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

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}