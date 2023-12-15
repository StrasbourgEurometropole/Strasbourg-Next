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
 * The table class for the &quot;agenda_CsmapCacheJson&quot; database table.
 *
 * @author BenjaminBini
 * @see CsmapCacheJson
 * @generated
 */
public class CsmapCacheJsonTable extends BaseTable<CsmapCacheJsonTable> {

	public static final CsmapCacheJsonTable INSTANCE =
		new CsmapCacheJsonTable();

	public final Column<CsmapCacheJsonTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CsmapCacheJsonTable, Clob> jsonEvent = createColumn(
		"jsonEvent", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> createEvent = createColumn(
		"createEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> modifiedEvent = createColumn(
		"modifiedEvent", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Date> regeneratedDate =
		createColumn(
			"regeneratedDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CsmapCacheJsonTable, Boolean> hasSchedules =
		createColumn(
			"hasSchedules", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private CsmapCacheJsonTable() {
		super("agenda_CsmapCacheJson", CsmapCacheJsonTable::new);
	}

}