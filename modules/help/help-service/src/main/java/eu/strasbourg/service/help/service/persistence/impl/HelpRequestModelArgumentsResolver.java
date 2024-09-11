/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.help.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.help.model.HelpRequestTable;
import eu.strasbourg.service.help.model.impl.HelpRequestImpl;
import eu.strasbourg.service.help.model.impl.HelpRequestModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from HelpRequest.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=eu.strasbourg.service.help.model.impl.HelpRequestImpl",
		"table.name=help_HelpRequest"
	},
	service = ArgumentsResolver.class
)
public class HelpRequestModelArgumentsResolver implements ArgumentsResolver {

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

		HelpRequestModelImpl helpRequestModelImpl =
			(HelpRequestModelImpl)baseModel;

		long columnBitmask = helpRequestModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(helpRequestModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					helpRequestModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(helpRequestModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return HelpRequestImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return HelpRequestTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		HelpRequestModelImpl helpRequestModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = helpRequestModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = helpRequestModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}