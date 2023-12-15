/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.help.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.help.model.HelpProposalTable;
import eu.strasbourg.service.help.model.impl.HelpProposalImpl;
import eu.strasbourg.service.help.model.impl.HelpProposalModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from HelpProposal.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=eu.strasbourg.service.help.model.impl.HelpProposalImpl",
		"table.name=help_HelpProposal"
	},
	service = ArgumentsResolver.class
)
public class HelpProposalModelArgumentsResolver implements ArgumentsResolver {

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

		HelpProposalModelImpl helpProposalModelImpl =
			(HelpProposalModelImpl)baseModel;

		long columnBitmask = helpProposalModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(helpProposalModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					helpProposalModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(HelpProposalPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(helpProposalModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return HelpProposalImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return HelpProposalTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		HelpProposalModelImpl helpProposalModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = helpProposalModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = helpProposalModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= HelpProposalModelImpl.getColumnBitmask(
			"modifiedByUserDate");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}