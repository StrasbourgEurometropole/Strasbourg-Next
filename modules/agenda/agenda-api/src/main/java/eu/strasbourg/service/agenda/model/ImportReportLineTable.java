/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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