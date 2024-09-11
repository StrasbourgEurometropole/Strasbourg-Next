/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.comment.model.SignalementTable;
import eu.strasbourg.service.comment.model.impl.SignalementImpl;
import eu.strasbourg.service.comment.model.impl.SignalementModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from Signalement.
 *
 * @author Romain Vergnais
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.comment.model.impl.SignalementImpl",
		"table.name=comment_Signalement"
	},
	service = ArgumentsResolver.class
)
public class SignalementModelArgumentsResolver implements ArgumentsResolver {

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

		SignalementModelImpl signalementModelImpl =
			(SignalementModelImpl)baseModel;

		long columnBitmask = signalementModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(signalementModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					signalementModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(SignalementPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(signalementModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return SignalementImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return SignalementTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		SignalementModelImpl signalementModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = signalementModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = signalementModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= SignalementModelImpl.getColumnBitmask(
			"createDate");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}