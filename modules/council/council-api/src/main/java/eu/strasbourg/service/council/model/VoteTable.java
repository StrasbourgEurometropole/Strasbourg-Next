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
 * The table class for the &quot;council_Vote&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Vote
 * @generated
 */
public class VoteTable extends BaseTable<VoteTable> {

	public static final VoteTable INSTANCE = new VoteTable();

	public final Column<VoteTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VoteTable, Long> officialId = createColumn(
		"officialId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VoteTable, Long> deliberationId = createColumn(
		"deliberationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<VoteTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VoteTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<VoteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<VoteTable, String> result = createColumn(
		"result", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<VoteTable, Long> officialProcurationId = createColumn(
		"officialProcurationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private VoteTable() {
		super("council_Vote", VoteTable::new);
	}

}