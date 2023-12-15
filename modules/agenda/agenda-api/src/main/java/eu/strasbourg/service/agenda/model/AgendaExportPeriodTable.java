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
 * The table class for the &quot;agenda_AgendaExportPeriod&quot; database table.
 *
 * @author BenjaminBini
 * @see AgendaExportPeriod
 * @generated
 */
public class AgendaExportPeriodTable
	extends BaseTable<AgendaExportPeriodTable> {

	public static final AgendaExportPeriodTable INSTANCE =
		new AgendaExportPeriodTable();

	public final Column<AgendaExportPeriodTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaExportPeriodTable, Long> agendaExportPeriodId =
		createColumn(
			"agendaExportPeriodId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AgendaExportPeriodTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportPeriodTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaExportPeriodTable, Long> agendaExportId =
		createColumn(
			"agendaExportId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private AgendaExportPeriodTable() {
		super("agenda_AgendaExportPeriod", AgendaExportPeriodTable::new);
	}

}