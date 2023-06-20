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

package eu.strasbourg.service.tipi.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;tipi_TipiEntry&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntry
 * @generated
 */
public class TipiEntryTable extends BaseTable<TipiEntryTable> {

	public static final TipiEntryTable INSTANCE = new TipiEntryTable();

	public final Column<TipiEntryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TipiEntryTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, Integer> total = createColumn(
		"total", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, Integer> paidCount = createColumn(
		"paidCount", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, Integer> refusedCount = createColumn(
		"refusedCount", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, Integer> canceledCount = createColumn(
		"canceledCount", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<TipiEntryTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TipiEntryTable() {
		super("tipi_TipiEntry", TipiEntryTable::new);
	}

}