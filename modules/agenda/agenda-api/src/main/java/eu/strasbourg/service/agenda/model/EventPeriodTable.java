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
 * The table class for the &quot;agenda_EventPeriod&quot; database table.
 *
 * @author BenjaminBini
 * @see EventPeriod
 * @generated
 */
public class EventPeriodTable extends BaseTable<EventPeriodTable> {

	public static final EventPeriodTable INSTANCE = new EventPeriodTable();

	public final Column<EventPeriodTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, Long> eventPeriodId = createColumn(
		"eventPeriodId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EventPeriodTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, String> times = createColumn(
		"times", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, String> startTime = createColumn(
		"startTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, String> endTime = createColumn(
		"endTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, Boolean> isRecurrent = createColumn(
		"isRecurrent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, String> timeDetail = createColumn(
		"timeDetail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventPeriodTable, Long> campaignEventId = createColumn(
		"campaignEventId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EventPeriodTable() {
		super("agenda_EventPeriod", EventPeriodTable::new);
	}

}