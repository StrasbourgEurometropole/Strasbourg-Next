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
 * The table class for the &quot;gtfs_Agency&quot; database table.
 *
 * @author Cedric Henry
 * @see Agency
 * @generated
 */
public class AgencyTable extends BaseTable<AgencyTable> {

	public static final AgencyTable INSTANCE = new AgencyTable();

	public final Column<AgencyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AgencyTable, String> agency_name = createColumn(
		"agency_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_url = createColumn(
		"agency_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_timezone = createColumn(
		"agency_timezone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_phone = createColumn(
		"agency_phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_fare_url = createColumn(
		"agency_fare_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_lang = createColumn(
		"agency_lang", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AgencyTable() {
		super("gtfs_Agency", AgencyTable::new);
	}

}