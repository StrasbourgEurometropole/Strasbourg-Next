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
 * The table class for the &quot;council_Deliberation&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Deliberation
 * @generated
 */
public class DeliberationTable extends BaseTable<DeliberationTable> {

	public static final DeliberationTable INSTANCE = new DeliberationTable();

	public final Column<DeliberationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Long> deliberationId = createColumn(
		"deliberationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DeliberationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, String> amendement = createColumn(
		"amendement", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, String> stage = createColumn(
		"stage", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Integer> countOfficialsVoting =
		createColumn(
			"countOfficialsVoting", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Integer> countOfficialsActive =
		createColumn(
			"countOfficialsActive", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Integer> quorum = createColumn(
		"quorum", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Date> beginningVoteDate =
		createColumn(
			"beginningVoteDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Date> endVoteDate = createColumn(
		"endVoteDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DeliberationTable, Long> councilSessionId =
		createColumn(
			"councilSessionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private DeliberationTable() {
		super("council_Deliberation", DeliberationTable::new);
	}

}