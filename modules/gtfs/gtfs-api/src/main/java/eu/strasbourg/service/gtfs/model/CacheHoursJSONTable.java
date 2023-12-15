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