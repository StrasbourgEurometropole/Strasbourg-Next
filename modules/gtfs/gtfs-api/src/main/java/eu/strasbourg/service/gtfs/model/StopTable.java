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

/**
 * The table class for the &quot;gtfs_Stop&quot; database table.
 *
 * @author Cedric Henry
 * @see Stop
 * @generated
 */
public class StopTable extends BaseTable<StopTable> {

	public static final StopTable INSTANCE = new StopTable();

	public final Column<StopTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StopTable, String> stop_id = createColumn(
		"stop_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_code = createColumn(
		"stop_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_lat = createColumn(
		"stop_lat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_lon = createColumn(
		"stop_lon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_name = createColumn(
		"stop_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_url = createColumn(
		"stop_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_desc = createColumn(
		"stop_desc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StopTable() {
		super("gtfs_Stop", StopTable::new);
	}

}