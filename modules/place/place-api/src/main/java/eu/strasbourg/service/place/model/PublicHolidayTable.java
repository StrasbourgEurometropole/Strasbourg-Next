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

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_PublicHoliday&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see PublicHoliday
 * @generated
 */
public class PublicHolidayTable extends BaseTable<PublicHolidayTable> {

	public static final PublicHolidayTable INSTANCE = new PublicHolidayTable();

	public final Column<PublicHolidayTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Long> publicHolidayId =
		createColumn(
			"publicHolidayId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PublicHolidayTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Boolean> recurrent = createColumn(
		"recurrent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private PublicHolidayTable() {
		super("place_PublicHoliday", PublicHolidayTable::new);
	}

}