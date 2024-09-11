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
 * The table class for the &quot;agenda_CacheJson&quot; database table.
 *
 * @author BenjaminBini
 * @see CacheJson
 * @generated
 */
public class CacheJsonTable extends BaseTable<CacheJsonTable> {

	public static final CacheJsonTable INSTANCE = new CacheJsonTable();

	public final Column<CacheJsonTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CacheJsonTable, Clob> jsonEvent = createColumn(
		"jsonEvent", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CacheJsonTable, Date> createEvent = createColumn(
		"createEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CacheJsonTable, Date> modifiedEvent = createColumn(
		"modifiedEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CacheJsonTable, Boolean> isApproved = createColumn(
		"isApproved", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private CacheJsonTable() {
		super("agenda_CacheJson", CacheJsonTable::new);
	}

}