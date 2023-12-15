/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_ProjectTimeline&quot; database table.
 *
 * @author Cedric Henry
 * @see ProjectTimeline
 * @generated
 */
public class ProjectTimelineTable extends BaseTable<ProjectTimelineTable> {

	public static final ProjectTimelineTable INSTANCE =
		new ProjectTimelineTable();

	public final Column<ProjectTimelineTable, Long> projectTimelineId =
		createColumn(
			"projectTimelineId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectTimelineTable, Integer> startDay = createColumn(
		"startDay", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, Integer> spacing = createColumn(
		"spacing", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, String> dateFormat = createColumn(
		"dateFormat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTimelineTable, Long> budgetParticipatifId =
		createColumn(
			"budgetParticipatifId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private ProjectTimelineTable() {
		super("project_ProjectTimeline", ProjectTimelineTable::new);
	}

}