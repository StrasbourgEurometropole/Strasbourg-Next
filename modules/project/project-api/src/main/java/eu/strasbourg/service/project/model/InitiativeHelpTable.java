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
 * The table class for the &quot;project_InitiativeHelp&quot; database table.
 *
 * @author Cedric Henry
 * @see InitiativeHelp
 * @generated
 */
public class InitiativeHelpTable extends BaseTable<InitiativeHelpTable> {

	public static final InitiativeHelpTable INSTANCE =
		new InitiativeHelpTable();

	public final Column<InitiativeHelpTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, Long> initiativeHelpId =
		createColumn(
			"initiativeHelpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InitiativeHelpTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, Long> initiativeId = createColumn(
		"initiativeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, String> helpTypes = createColumn(
		"helpTypes", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, String> message = createColumn(
		"message", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InitiativeHelpTable, Boolean> helpDisplay =
		createColumn(
			"helpDisplay", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private InitiativeHelpTable() {
		super("project_InitiativeHelp", InitiativeHelpTable::new);
	}

}