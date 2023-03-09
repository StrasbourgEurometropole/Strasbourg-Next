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

package eu.strasbourg.service.agenda.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;agenda_CsmapCacheJson&quot; database table.
 *
 * @author BenjaminBini
 * @see CsmapCacheJson
 * @generated
 */
public class CsmapCacheJsonTable extends BaseTable<CsmapCacheJsonTable> {

	public static final CsmapCacheJsonTable INSTANCE =
		new CsmapCacheJsonTable();

	public final Column<CsmapCacheJsonTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CsmapCacheJsonTable, Clob> jsonEvent = createColumn(
		"jsonEvent", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> createEvent = createColumn(
		"createEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> modifiedEvent = createColumn(
		"modifiedEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> regeneratedDate =
		createColumn(
			"regeneratedDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Boolean> hasSchedules =
		createColumn(
			"hasSchedules", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private CsmapCacheJsonTable() {
		super("agenda_CsmapCacheJson", CsmapCacheJsonTable::new);
	}

}