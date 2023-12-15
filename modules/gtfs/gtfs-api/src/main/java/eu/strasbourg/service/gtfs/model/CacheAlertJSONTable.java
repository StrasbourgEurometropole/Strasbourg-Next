/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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