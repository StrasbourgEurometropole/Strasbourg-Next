/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.agenda.model.AgendaExportPeriodTable;
import eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodImpl;
import eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from AgendaExportPeriod.
 *
 * @author BenjaminBini
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodImpl",
		"table.name=agenda_AgendaExportPeriod"
	},
	service = ArgumentsResolver.class
)
public class AgendaExportPeriodModelArgumentsResolver
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

		AgendaExportPeriodModelImpl agendaExportPeriodModelImpl =
			(AgendaExportPeriodModelImpl)baseModel;

		long columnBitmask = agendaExportPeriodModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				agendaExportPeriodModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					agendaExportPeriodModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				agendaExportPeriodModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AgendaExportPeriodImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AgendaExportPeriodTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AgendaExportPeriodModelImpl agendaExportPeriodModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					agendaExportPeriodModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = agendaExportPeriodModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}