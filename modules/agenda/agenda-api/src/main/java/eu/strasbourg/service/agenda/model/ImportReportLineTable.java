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

/**
 * The table class for the &quot;agenda_ImportReportLine&quot; database table.
 *
 * @author BenjaminBini
 * @see ImportReportLine
 * @generated
 */
public class ImportReportLineTable extends BaseTable<ImportReportLineTable> {

	public static final ImportReportLineTable INSTANCE =
		new ImportReportLineTable();

	public final Column<ImportReportLineTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, Long> lineId = createColumn(
		"lineId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ImportReportLineTable, String> type = createColumn(
		"type_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, Clob> log = createColumn(
		"log_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, String> entityName =
		createColumn(
			"entityName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, String> entityExternalId =
		createColumn(
			"entityExternalId", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportReportLineTable, Long> reportId = createColumn(
		"reportId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ImportReportLineTable() {
		super("agenda_ImportReportLine", ImportReportLineTable::new);
	}

}