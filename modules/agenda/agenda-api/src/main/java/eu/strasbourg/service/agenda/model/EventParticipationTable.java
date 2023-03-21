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