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