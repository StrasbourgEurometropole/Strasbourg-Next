/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.council.model.OfficialTypeCouncilTable;
import eu.strasbourg.service.council.model.impl.OfficialTypeCouncilImpl;
import eu.strasbourg.service.council.model.impl.OfficialTypeCouncilModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from OfficialTypeCouncil.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.council.model.impl.OfficialTypeCouncilImpl",
		"table.name=council_OfficialTypeCouncil"
	},
	service = ArgumentsResolver.class
)
public class OfficialTypeCouncilModelArgumentsResolver
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

		OfficialTypeCouncilModelImpl officialTypeCouncilModelImpl =
			(OfficialTypeCouncilModelImpl)baseModel;

		long columnBitmask = officialTypeCouncilModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				officialTypeCouncilModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					officialTypeCouncilModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				officialTypeCouncilModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return OfficialTypeCouncilImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return OfficialTypeCouncilTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		OfficialTypeCouncilModelImpl officialTypeCouncilModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					officialTypeCouncilModelImpl.getColumnOriginalValue(
						columnName);
			}
			else {
				arguments[i] = officialTypeCouncilModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}