/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.place.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.place.model.PlaceTable;
import eu.strasbourg.service.place.model.impl.PlaceImpl;
import eu.strasbourg.service.place.model.impl.PlaceModelImpl;

import java.util.Objects;

/**
 * The arguments resolver class for retrieving value from Place.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PlaceModelArgumentsResolver implements ArgumentsResolver {

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

		PlaceModelImpl placeModelImpl = (PlaceModelImpl)baseModel;

		if (!checkColumn || _hasModifiedColumns(placeModelImpl, columnNames)) {
			return _getValue(placeModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return PlaceImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return PlaceTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		PlaceModelImpl placeModelImpl, String[] columnNames, boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = placeModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = placeModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static boolean _hasModifiedColumns(
		PlaceModelImpl placeModelImpl, String[] columnNames) {

		if (columnNames.length == 0) {
			return false;
		}

		for (String columnName : columnNames) {
			if (!Objects.equals(
					placeModelImpl.getColumnOriginalValue(columnName),
					placeModelImpl.getColumnValue(columnName))) {

				return true;
			}
		}

		return false;
	}

}