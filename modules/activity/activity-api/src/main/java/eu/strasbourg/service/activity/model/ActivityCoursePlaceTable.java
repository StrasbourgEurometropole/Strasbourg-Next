/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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