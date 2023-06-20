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

package eu.strasbourg.service.help.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;help_HelpProposal&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see HelpProposal
 * @generated
 */
public class HelpProposalTable extends BaseTable<HelpProposalTable> {

	public static final HelpProposalTable INSTANCE = new HelpProposalTable();

	public final Column<HelpProposalTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> helpProposalId = createColumn(
		"helpProposalId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<HelpProposalTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> inTheNameOf = createColumn(
		"inTheNameOf", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> city = createColumn(
		"city", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> postalCode = createColumn(
		"postalCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Date> modifiedByUserDate =
		createColumn(
			"modifiedByUserDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> spokenLanguages =
		createColumn(
			"spokenLanguages", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Boolean> agreementSigned1 =
		createColumn(
			"agreementSigned1", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Boolean> agreementSigned2 =
		createColumn(
			"agreementSigned2", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Boolean> agreementSigned3 =
		createColumn(
			"agreementSigned3", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HelpProposalTable, Clob> comment = createColumn(
		"comment_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private HelpProposalTable() {
		super("help_HelpProposal", HelpProposalTable::new);
	}

}