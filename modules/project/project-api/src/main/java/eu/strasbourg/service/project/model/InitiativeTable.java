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
 * The table class for the &quot;project_Initiative&quot; database table.
 *
 * @author Cedric Henry
 * @see Initiative
 * @generated
 */
public class InitiativeTable extends BaseTable<InitiativeTable> {

	public static final InitiativeTable INSTANCE = new InitiativeTable();

	public final Column<InitiativeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> initiativeId = createColumn(
		"initiativeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InitiativeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> placeTextArea = createColumn(
		"placeTextArea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> inTheNameOf = createColumn(
		"inTheNameOf", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> videoUrl = createColumn(
		"videoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> externalImageURL =
		createColumn(
			"externalImageURL", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> externalImageCopyright =
		createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Boolean> mediaChoice = createColumn(
		"mediaChoice", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> assetEntryId = createColumn(
		"assetEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, String> filesIds = createColumn(
		"filesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeTable, Date> publicationDate = createColumn(
		"publicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private InitiativeTable() {
		super("project_Initiative", InitiativeTable::new);
	}

}