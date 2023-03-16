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
 * The table class for the &quot;gtfs_Calendar&quot; database table.
 *
 * @author Cedric Henry
 * @see Calendar
 * @generated
 */
public class CalendarTable extends BaseTable<CalendarTable> {

	public static final CalendarTable INSTANCE = new CalendarTable();

	public final Column<CalendarTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CalendarTable, String> service_id = createColumn(
		"service_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> monday = createColumn(
		"monday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> tuesday = createColumn(
		"tuesday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> wednesday = createColumn(
		"wednesday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> thursday = createColumn(
		"thursday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> friday = createColumn(
		"friday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> saturday = createColumn(
		"saturday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Boolean> sunday = createColumn(
		"sunday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Date> start_date = createColumn(
		"start_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CalendarTable, Date> end_date = createColumn(
		"end_date", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CalendarTable() {
		super("gtfs_Calendar", CalendarTable::new);
	}

}