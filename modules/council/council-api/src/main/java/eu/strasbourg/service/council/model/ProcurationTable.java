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
 * The table class for the &quot;council_Procuration&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Procuration
 * @generated
 */
public class ProcurationTable extends BaseTable<ProcurationTable> {

	public static final ProcurationTable INSTANCE = new ProcurationTable();

	public final Column<ProcurationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> procurationId = createColumn(
		"procurationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProcurationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> officialVotersId = createColumn(
		"officialVotersId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> officialUnavailableId =
		createColumn(
			"officialUnavailableId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> councilSessionId = createColumn(
		"councilSessionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Boolean> isAbsent = createColumn(
		"isAbsent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Integer> procurationMode =
		createColumn(
			"procurationMode", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Integer> presential = createColumn(
		"presential", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Boolean> isAfterVote = createColumn(
		"isAfterVote", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Date> startHour = createColumn(
		"startHour", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Date> endHour = createColumn(
		"endHour", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> startDelib = createColumn(
		"startDelib", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, Long> endDelib = createColumn(
		"endDelib", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProcurationTable, String> otherProcurationMode =
		createColumn(
			"otherProcurationMode", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private ProcurationTable() {
		super("council_Procuration", ProcurationTable::new);
	}

}