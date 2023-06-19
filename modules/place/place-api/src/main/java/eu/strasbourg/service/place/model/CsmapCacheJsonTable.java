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

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_CsmapCacheJson&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see CsmapCacheJson
 * @generated
 */
public class CsmapCacheJsonTable extends BaseTable<CsmapCacheJsonTable> {

	public static final CsmapCacheJsonTable INSTANCE =
		new CsmapCacheJsonTable();

	public final Column<CsmapCacheJsonTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, String> sigId = createColumn(
		"sigId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<CsmapCacheJsonTable, Clob> jsonLieu = createColumn(
		"jsonLieu", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Clob> jsonHoraire = createColumn(
		"jsonHoraire", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> createPlace = createColumn(
		"createPlace", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> modifiedPlace = createColumn(
		"modifiedPlace", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private CsmapCacheJsonTable() {
		super("place_CsmapCacheJson", CsmapCacheJsonTable::new);
	}

}