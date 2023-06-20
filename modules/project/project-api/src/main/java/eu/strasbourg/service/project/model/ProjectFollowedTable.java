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
 * The table class for the &quot;project_ProjectFollowed&quot; database table.
 *
 * @author Cedric Henry
 * @see ProjectFollowed
 * @generated
 */
public class ProjectFollowedTable extends BaseTable<ProjectFollowedTable> {

	public static final ProjectFollowedTable INSTANCE =
		new ProjectFollowedTable();

	public final Column<ProjectFollowedTable, Long> projectFollowedId =
		createColumn(
			"projectFollowedId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectFollowedTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectFollowedTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectFollowedTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectFollowedTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProjectFollowedTable() {
		super("project_ProjectFollowed", ProjectFollowedTable::new);
	}

}