/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;agenda_AgendaExport&quot; database table.
 *
 * @author BenjaminBini
 * @see AgendaExport
 * @generated
 */
public class AgendaExportTable extends BaseTable<AgendaExportTable> {

	public static final AgendaExportTable INSTANCE = new AgendaExportTable();

	public final Column<AgendaExportTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Long> agendaExportId = createColumn(
		"agendaExportId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AgendaExportTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, String> language = createColumn(
		"language", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, String> exportFormat = createColumn(
		"exportFormat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Long> templateId = createColumn(
		"templateId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Clob> eventCategories = createColumn(
		"eventCategories", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AgendaExportTable, Clob> aggregations = createColumn(
		"aggregations", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private AgendaExportTable() {
		super("agenda_AgendaExport", AgendaExportTable::new);
	}

}