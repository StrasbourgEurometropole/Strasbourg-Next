/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_Project&quot; database table.
 *
 * @author Cedric Henry
 * @see Project
 * @generated
 */
public class ProjectTable extends BaseTable<ProjectTable> {

	public static final ProjectTable INSTANCE = new ProjectTable();

	public final Column<ProjectTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProjectTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> externalImageURL = createColumn(
		"externalImageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> externalImageCopyright =
		createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Double> opacityImage = createColumn(
		"opacityImage", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> detailURL = createColumn(
		"detailURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> budget = createColumn(
		"budget", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> label = createColumn(
		"label", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> duration = createColumn(
		"duration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Clob> partners = createColumn(
		"partners", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> contactName = createColumn(
		"contactName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> contactLine1 = createColumn(
		"contactLine1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> contactLine2 = createColumn(
		"contactLine2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, String> contactPhoneNumber = createColumn(
		"contactPhoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProjectTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProjectTable() {
		super("project_Project", ProjectTable::new);
	}

}