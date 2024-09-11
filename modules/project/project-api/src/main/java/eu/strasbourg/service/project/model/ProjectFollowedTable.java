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