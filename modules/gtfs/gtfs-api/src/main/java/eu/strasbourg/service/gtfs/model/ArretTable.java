/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_Arret&quot; database table.
 *
 * @author Cedric Henry
 * @see Arret
 * @generated
 */
public class ArretTable extends BaseTable<ArretTable> {

	public static final ArretTable INSTANCE = new ArretTable();

	public final Column<ArretTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Long> arretId = createColumn(
		"arretId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ArretTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> stopId = createColumn(
		"stopId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> code = createColumn(
		"code_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> latitude = createColumn(
		"latitude", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, String> longitude = createColumn(
		"longitude", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArretTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private ArretTable() {
		super("gtfs_Arret", ArretTable::new);
	}

}