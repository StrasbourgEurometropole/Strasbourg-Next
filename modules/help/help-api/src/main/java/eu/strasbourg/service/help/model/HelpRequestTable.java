/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.help.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;help_HelpRequest&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequest
 * @generated
 */
public class HelpRequestTable extends BaseTable<HelpRequestTable> {

	public static final HelpRequestTable INSTANCE = new HelpRequestTable();

	public final Column<HelpRequestTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> helpRequestId = createColumn(
		"helpRequestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<HelpRequestTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> helpProposalId = createColumn(
		"helpProposalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Clob> message = createColumn(
		"message", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Long> studentCardImageId =
		createColumn(
			"studentCardImageId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Boolean> agreementSigned1 =
		createColumn(
			"agreementSigned1", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Boolean> agreementSigned2 =
		createColumn(
			"agreementSigned2", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Boolean> agreementSigned3 =
		createColumn(
			"agreementSigned3", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpRequestTable, Clob> comment = createColumn(
		"comment_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private HelpRequestTable() {
		super("help_HelpRequest", HelpRequestTable::new);
	}

}