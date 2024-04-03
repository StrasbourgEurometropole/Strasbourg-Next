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
 * The table class for the &quot;agenda_EventParticipation&quot; database table.
 *
 * @author BenjaminBini
 * @see EventParticipation
 * @generated
 */
public class EventParticipationTable
	extends BaseTable<EventParticipationTable> {

	public static final EventParticipationTable INSTANCE =
		new EventParticipationTable();

	public final Column<EventParticipationTable, Long> eventParticipationId =
		createColumn(
			"eventParticipationId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<EventParticipationTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventParticipationTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventParticipationTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventParticipationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EventParticipationTable() {
		super("agenda_EventParticipation", EventParticipationTable::new);
	}

}