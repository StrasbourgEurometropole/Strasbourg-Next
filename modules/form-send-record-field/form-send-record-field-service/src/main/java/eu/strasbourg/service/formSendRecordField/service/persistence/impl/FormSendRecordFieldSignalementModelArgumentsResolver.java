/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.formSendRecordField.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;

import eu.strasbourg.service.formSendRecordField.model.FormSendRecordFieldSignalementTable;
import eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementImpl;
import eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The arguments resolver class for retrieving value from FormSendRecordFieldSignalement.
 *
 * @author Angélique Zunino
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"class.name=eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementImpl",
		"table.name=formSendRecordField_FormSendRecordFieldSignalement"
	},
	service = ArgumentsResolver.class
)
public class FormSendRecordFieldSignalementModelArgumentsResolver
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

		FormSendRecordFieldSignalementModelImpl
			formSendRecordFieldSignalementModelImpl =
				(FormSendRecordFieldSignalementModelImpl)baseModel;

		long columnBitmask =
			formSendRecordFieldSignalementModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(
				formSendRecordFieldSignalementModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					formSendRecordFieldSignalementModelImpl.getColumnBitmask(
						columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(FormSendRecordFieldSignalementPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(
				formSendRecordFieldSignalementModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return FormSendRecordFieldSignalementImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return FormSendRecordFieldSignalementTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		FormSendRecordFieldSignalementModelImpl
			formSendRecordFieldSignalementModelImpl,
		String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] =
					formSendRecordFieldSignalementModelImpl.
						getColumnOriginalValue(columnName);
			}
			else {
				arguments[i] =
					formSendRecordFieldSignalementModelImpl.getColumnValue(
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

		orderByColumnsBitmask |=
			FormSendRecordFieldSignalementModelImpl.getColumnBitmask(
				"createDate");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}