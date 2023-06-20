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

package eu.strasbourg.service.activity.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;activity_ActivityCourseSchedule&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourseSchedule
 * @generated
 */
public class ActivityCourseScheduleTable
	extends BaseTable<ActivityCourseScheduleTable> {

	public static final ActivityCourseScheduleTable INSTANCE =
		new ActivityCourseScheduleTable();

	public final Column<ActivityCourseScheduleTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Long>
		activityCourseScheduleId = createColumn(
			"activityCourseScheduleId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ActivityCourseScheduleTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Long>
		activityCoursePlaceId = createColumn(
			"activityCoursePlaceId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, String> startTime =
		createColumn(
			"startTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, String> endTime =
		createColumn(
			"endTime", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> monday =
		createColumn(
			"monday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> tuesday =
		createColumn(
			"tuesday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> wednesday =
		createColumn(
			"wednesday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> thursday =
		createColumn(
			"thursday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> friday =
		createColumn(
			"friday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> saturday =
		createColumn(
			"saturday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, Boolean> sunday =
		createColumn(
			"sunday", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, String> comments =
		createColumn(
			"comments", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseScheduleTable, String> periodsIds =
		createColumn(
			"periodsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ActivityCourseScheduleTable() {
		super(
			"activity_ActivityCourseSchedule",
			ActivityCourseScheduleTable::new);
	}

}