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