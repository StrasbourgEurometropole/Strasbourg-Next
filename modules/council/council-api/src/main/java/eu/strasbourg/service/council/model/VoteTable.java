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