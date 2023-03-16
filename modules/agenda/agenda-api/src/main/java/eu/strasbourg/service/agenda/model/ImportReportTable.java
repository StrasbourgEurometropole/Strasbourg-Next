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

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;agenda_ImportReport&quot; database table.
 *
 * @author BenjaminBini
 * @see ImportReport
 * @generated
 */
public class ImportReportTable extends BaseTable<ImportReportTable> {

	public static final ImportReportTable INSTANCE = new ImportReportTable();

	public final Column<ImportReportTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> reportId = createColumn(
		"reportId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ImportReportTable, String> provider = createColumn(
		"provider", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, String> filename = createColumn(
		"filename", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> status = createColumn(
		"status", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, String> globalErrorCause =
		createColumn(
			"globalErrorCause", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> newEventsCount = createColumn(
		"newEventsCount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> modifiedEventsCount =
		createColumn(
			"modifiedEventsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> errorEventsCount =
		createColumn(
			"errorEventsCount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> unmodifiedEventsCount =
		createColumn(
			"unmodifiedEventsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> deletedEventsCount =
		createColumn(
			"deletedEventsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> newManifestationsCount =
		createColumn(
			"newManifestationsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> modifiedManifestationsCount =
		createColumn(
			"modifiedManifestationsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> errorManifestationsCount =
		createColumn(
			"errorManifestationsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> unmodifiedManifestationsCount =
		createColumn(
			"unmodifiedManifestationsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Long> deletedManifestationsCount =
		createColumn(
			"deletedManifestationsCount", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ImportReportTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ImportReportTable() {
		super("agenda_ImportReport", ImportReportTable::new);
	}

}