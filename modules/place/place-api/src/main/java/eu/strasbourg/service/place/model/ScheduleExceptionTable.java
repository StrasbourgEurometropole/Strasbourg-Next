/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_ScheduleException&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleException
 * @generated
 */
public class ScheduleExceptionTable extends BaseTable<ScheduleExceptionTable> {

	public static final ScheduleExceptionTable INSTANCE =
		new ScheduleExceptionTable();

	public final Column<ScheduleExceptionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, Long> exceptionId =
		createColumn(
			"exceptionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ScheduleExceptionTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> openingTimes =
		createColumn(
			"openingTimes", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> firstComment =
		createColumn(
			"firstComment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> secondComment =
		createColumn(
			"secondComment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> thirdComment =
		createColumn(
			"thirdComment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> fourthComment =
		createColumn(
			"fourthComment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> fifthComment =
		createColumn(
			"fifthComment", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, Boolean> closed = createColumn(
		"closed", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, Long> placeId = createColumn(
		"placeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ScheduleExceptionTable, Long> subPlaceId = createColumn(
		"subPlaceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ScheduleExceptionTable() {
		super("place_ScheduleException", ScheduleExceptionTable::new);
	}

}