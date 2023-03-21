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