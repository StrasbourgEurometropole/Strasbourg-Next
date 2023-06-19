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