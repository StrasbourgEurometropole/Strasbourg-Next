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