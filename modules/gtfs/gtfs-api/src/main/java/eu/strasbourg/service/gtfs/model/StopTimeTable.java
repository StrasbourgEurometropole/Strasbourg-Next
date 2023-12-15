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
 * The table class for the &quot;gtfs_StopTime&quot; database table.
 *
 * @author Cedric Henry
 * @see StopTime
 * @generated
 */
public class StopTimeTable extends BaseTable<StopTimeTable> {

	public static final StopTimeTable INSTANCE = new StopTimeTable();

	public final Column<StopTimeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StopTimeTable, String> trip_id = createColumn(
		"trip_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, Date> arrival_time = createColumn(
		"arrival_time", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, Date> departure_time = createColumn(
		"departure_time", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, String> stop_id = createColumn(
		"stop_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, Integer> stop_sequence = createColumn(
		"stop_sequence", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, String> pickup_type = createColumn(
		"pickup_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTimeTable, String> drop_off_type = createColumn(
		"drop_off_type", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StopTimeTable() {
		super("gtfs_StopTime", StopTimeTable::new);
	}

}