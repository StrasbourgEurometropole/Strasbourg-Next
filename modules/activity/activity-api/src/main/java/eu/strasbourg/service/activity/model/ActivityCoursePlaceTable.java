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
 * The table class for the &quot;activity_ActivityCoursePlace&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityCoursePlace
 * @generated
 */
public class ActivityCoursePlaceTable
	extends BaseTable<ActivityCoursePlaceTable> {

	public static final ActivityCoursePlaceTable INSTANCE =
		new ActivityCoursePlaceTable();

	public final Column<ActivityCoursePlaceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Long> activityCoursePlaceId =
		createColumn(
			"activityCoursePlaceId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ActivityCoursePlaceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Long> activityCourseId =
		createColumn(
			"activityCourseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> placeSIGId =
		createColumn(
			"placeSIGId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> placeName =
		createColumn(
			"placeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> placeStreetNumber =
		createColumn(
			"placeStreetNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> placeStreetName =
		createColumn(
			"placeStreetName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, String> placeZipCode =
		createColumn(
			"placeZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityCoursePlaceTable, Long> placeCityId =
		createColumn(
			"placeCityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ActivityCoursePlaceTable() {
		super("activity_ActivityCoursePlace", ActivityCoursePlaceTable::new);
	}

}