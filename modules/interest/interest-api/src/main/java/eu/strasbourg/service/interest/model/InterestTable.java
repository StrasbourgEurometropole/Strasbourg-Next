/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;interest_Interest&quot; database table.
 *
 * @author BenjaminBini
 * @see Interest
 * @generated
 */
public class InterestTable extends BaseTable<InterestTable> {

	public static final InterestTable INSTANCE = new InterestTable();

	public final Column<InterestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Long> interestId = createColumn(
		"interestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<InterestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<InterestTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<InterestTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<InterestTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private InterestTable() {
		super("interest_Interest", InterestTable::new);
	}

}