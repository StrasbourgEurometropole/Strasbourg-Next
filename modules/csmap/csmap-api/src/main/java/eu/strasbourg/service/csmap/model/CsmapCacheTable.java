/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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