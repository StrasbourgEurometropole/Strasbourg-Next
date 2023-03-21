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

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_CacheHoursJSON&quot; database table.
 *
 * @author Cedric Henry
 * @see CacheHoursJSON
 * @generated
 */
public class CacheHoursJSONTable extends BaseTable<CacheHoursJSONTable> {

	public static final CacheHoursJSONTable INSTANCE =
		new CacheHoursJSONTable();

	public final Column<CacheHoursJSONTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CacheHoursJSONTable, String> stopCode = createColumn(
		"stopCode", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<CacheHoursJSONTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_PRIMARY);
	public final Column<CacheHoursJSONTable, Clob> jsonHour = createColumn(
		"jsonHour", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CacheHoursJSONTable, Date> creationDate = createColumn(
		"creationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CacheHoursJSONTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CacheHoursJSONTable() {
		super("gtfs_CacheHoursJSON", CacheHoursJSONTable::new);
	}

}