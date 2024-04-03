/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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