/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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