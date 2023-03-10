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
 * The table class for the &quot;gtfs_ImportHistoric&quot; database table.
 *
 * @author Cedric Henry
 * @see ImportHistoric
 * @generated
 */
public class ImportHistoricTable extends BaseTable<ImportHistoricTable> {

	public static final ImportHistoricTable INSTANCE =
		new ImportHistoricTable();

	public final Column<ImportHistoricTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Long> importHistoricId =
		createColumn(
			"importHistoricId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ImportHistoricTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Integer> result = createColumn(
		"result", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Clob> operations = createColumn(
		"operations", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Clob> errorDescription =
		createColumn(
			"errorDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Clob> errorStackTrace =
		createColumn(
			"errorStackTrace", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, Date> finishDate = createColumn(
		"finishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportHistoricTable, String> gtfsFileHash =
		createColumn(
			"gtfsFileHash", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ImportHistoricTable() {
		super("gtfs_ImportHistoric", ImportHistoricTable::new);
	}

}