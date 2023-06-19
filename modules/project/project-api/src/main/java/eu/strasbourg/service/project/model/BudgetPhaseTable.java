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

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_BudgetPhase&quot; database table.
 *
 * @author Cedric Henry
 * @see BudgetPhase
 * @generated
 */
public class BudgetPhaseTable extends BaseTable<BudgetPhaseTable> {

	public static final BudgetPhaseTable INSTANCE = new BudgetPhaseTable();

	public final Column<BudgetPhaseTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Long> budgetPhaseId = createColumn(
		"budgetPhaseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BudgetPhaseTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Long> numberOfVote = createColumn(
		"numberOfVote", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> beginDate = createColumn(
		"beginDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> beginVoteDate = createColumn(
		"beginVoteDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetPhaseTable, Date> endVoteDate = createColumn(
		"endVoteDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private BudgetPhaseTable() {
		super("project_BudgetPhase", BudgetPhaseTable::new);
	}

}