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