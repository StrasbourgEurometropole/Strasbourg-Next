/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.agenda.model.EventTable;
import eu.strasbourg.service.agenda.model.impl.EventImpl;
import eu.strasbourg.service.agenda.model.impl.EventModelImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The arguments resolver class for retrieving value from Event.
 *
 * @author BenjaminBini
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.agenda.model.impl.EventImpl",
		"table.name=agenda_Event"
	},
	service = ArgumentsResolver.class
)
public class EventModelArgumentsResolver implements ArgumentsResolver {

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

		EventModelImpl eventModelImpl = (EventModelImpl)baseModel;

		if (!checkColumn || _hasModifiedColumns(eventModelImpl, columnNames) ||
			_hasModifiedColumns(eventModelImpl, _ORDER_BY_COLUMNS)) {

			return _getValue(eventModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return EventImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return EventTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		EventModelImpl eventModelImpl, String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = eventModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = eventModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static boolean _hasModifiedColumns(
		EventModelImpl eventModelImpl, String[] columnNames) {

		if (columnNames.length == 0) {
			return false;
		}

		for (String columnName : columnNames) {
			if (!Objects.equals(
					eventModelImpl.getColumnOriginalValue(columnName),
					eventModelImpl.getColumnValue(columnName))) {

				return true;
			}
		}

		return false;
	}

	private static final String[] _ORDER_BY_COLUMNS;

	static {
		List<String> orderByColumns = new ArrayList<String>();

		orderByColumns.add("modifiedDate");

		_ORDER_BY_COLUMNS = orderByColumns.toArray(new String[0]);
	}

}