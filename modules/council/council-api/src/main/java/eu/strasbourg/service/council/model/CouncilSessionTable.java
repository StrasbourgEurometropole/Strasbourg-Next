/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;council_CouncilSession&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CouncilSession
 * @generated
 */
public class CouncilSessionTable extends BaseTable<CouncilSessionTable> {

	public static final CouncilSessionTable INSTANCE =
		new CouncilSessionTable();

	public final Column<CouncilSessionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> councilSessionId =
		createColumn(
			"councilSessionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CouncilSessionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> lastDelibProcessed =
		createColumn(
			"lastDelibProcessed", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> officialLeaderId =
		createColumn(
			"officialLeaderId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CouncilSessionTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CouncilSessionTable() {
		super("council_CouncilSession", CouncilSessionTable::new);
	}

}