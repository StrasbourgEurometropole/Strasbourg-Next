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