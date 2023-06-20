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

package eu.strasbourg.service.csmap.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;csmap_CsmapCache&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CsmapCache
 * @generated
 */
public class CsmapCacheTable extends BaseTable<CsmapCacheTable> {

	public static final CsmapCacheTable INSTANCE = new CsmapCacheTable();

	public final Column<CsmapCacheTable, Long> cacheId = createColumn(
		"cacheId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CsmapCacheTable, Long> codeCache = createColumn(
		"codeCache", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheTable, String> cacheJson = createColumn(
		"cacheJson", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheTable, Boolean> isLastProcessSuccess =
		createColumn(
			"isLastProcessSuccess", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<CsmapCacheTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheTable, Date> processedDate = createColumn(
		"processedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CsmapCacheTable() {
		super("csmap_CsmapCache", CsmapCacheTable::new);
	}

}