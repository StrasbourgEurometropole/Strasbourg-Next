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
 * The table class for the &quot;gtfs_Route&quot; database table.
 *
 * @author Cedric Henry
 * @see Route
 * @generated
 */
public class RouteTable extends BaseTable<RouteTable> {

	public static final RouteTable INSTANCE = new RouteTable();

	public final Column<RouteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RouteTable, String> route_id = createColumn(
		"route_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, String> route_short_name = createColumn(
		"route_short_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, String> route_long_name = createColumn(
		"route_long_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, String> route_desc = createColumn(
		"route_desc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, Integer> route_type = createColumn(
		"route_type", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<RouteTable, String> route_color = createColumn(
		"route_color", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RouteTable, String> route_text_color = createColumn(
		"route_text_color", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RouteTable() {
		super("gtfs_Route", RouteTable::new);
	}

}