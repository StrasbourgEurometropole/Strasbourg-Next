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

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;activity_ActivityCourse&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCourse
 * @generated
 */
public class ActivityCourseTable extends BaseTable<ActivityCourseTable> {

	public static final ActivityCourseTable INSTANCE =
		new ActivityCourseTable();

	public final Column<ActivityCourseTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> activityCourseId =
		createColumn(
			"activityCourseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ActivityCourseTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Clob> presentation = createColumn(
		"presentation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Clob> arrangements = createColumn(
		"arrangements", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Clob> price = createColumn(
		"price", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> activityId = createColumn(
		"activityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> organizerId = createColumn(
		"organizerId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Integer> duration = createColumn(
		"duration", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> imageIds = createColumn(
		"imageIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> videosIds = createColumn(
		"videosIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCourseTable, String> documentsIds =
		createColumn(
			"documentsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ActivityCourseTable() {
		super("activity_ActivityCourse", ActivityCourseTable::new);
	}

}