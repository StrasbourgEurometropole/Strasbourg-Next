/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.project.model.BudgetPhaseTable;
import eu.strasbourg.service.project.model.impl.BudgetPhaseImpl;
import eu.strasbourg.service.project.model.impl.BudgetPhaseModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from BudgetPhase.
 *
 * @author Cedric Henry
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.project.model.impl.BudgetPhaseImpl",
		"table.name=project_BudgetPhase"
	},
	service = ArgumentsResolver.class
)
public class BudgetPhaseModelArgumentsResolver implements ArgumentsResolver {

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

		BudgetPhaseModelImpl budgetPhaseModelImpl =
			(BudgetPhaseModelImpl)baseModel;

		long columnBitmask = budgetPhaseModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(budgetPhaseModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					budgetPhaseModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(BudgetPhasePersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(budgetPhaseModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return BudgetPhaseImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return BudgetPhaseTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		BudgetPhaseModelImpl budgetPhaseModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = budgetPhaseModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = budgetPhaseModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= BudgetPhaseModelImpl.getColumnBitmask(
			"beginDate");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}