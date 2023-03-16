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
 * The table class for the &quot;gtfs_CacheAlertJSON&quot; database table.
 *
 * @author Cedric Henry
 * @see CacheAlertJSON
 * @generated
 */
public class CacheAlertJSONTable extends BaseTable<CacheAlertJSONTable> {

	public static final CacheAlertJSONTable INSTANCE =
		new CacheAlertJSONTable();

	public final Column<CacheAlertJSONTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CacheAlertJSONTable, Long> cacheId = createColumn(
		"cacheId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CacheAlertJSONTable, Clob> jsonAlert = createColumn(
		"jsonAlert", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CacheAlertJSONTable, Date> creationDate = createColumn(
		"creationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CacheAlertJSONTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CacheAlertJSONTable() {
		super("gtfs_CacheAlertJSON", CacheAlertJSONTable::new);
	}

}