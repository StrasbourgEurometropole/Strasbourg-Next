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

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_CalendarDate&quot; database table.
 *
 * @author Cedric Henry
 * @see CalendarDate
 * @generated
 */
public class CalendarDateTable extends BaseTable<CalendarDateTable> {

	public static final CalendarDateTable INSTANCE = new CalendarDateTable();

	public final Column<CalendarDateTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalendarDateTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CalendarDateTable, String> service_id = createColumn(
		"service_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalendarDateTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CalendarDateTable, Integer> exception_type =
		createColumn(
			"exception_type", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);

	private CalendarDateTable() {
		super("gtfs_CalendarDate", CalendarDateTable::new);
	}

}