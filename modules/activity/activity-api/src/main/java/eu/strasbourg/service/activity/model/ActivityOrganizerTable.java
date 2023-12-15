/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;activity_ActivityOrganizer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ActivityOrganizer
 * @generated
 */
public class ActivityOrganizerTable extends BaseTable<ActivityOrganizerTable> {

	public static final ActivityOrganizerTable INSTANCE =
		new ActivityOrganizerTable();

	public final Column<ActivityOrganizerTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Long> activityOrganizerId =
		createColumn(
			"activityOrganizerId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<ActivityOrganizerTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Clob> presentation =
		createColumn(
			"presentation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Clob> address = createColumn(
		"address", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> mail = createColumn(
		"mail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, String> siteURL = createColumn(
		"siteURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ActivityOrganizerTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ActivityOrganizerTable() {
		super("activity_ActivityOrganizer", ActivityOrganizerTable::new);
	}

}