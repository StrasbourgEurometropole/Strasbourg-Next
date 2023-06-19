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

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_BudgetSupport&quot; database table.
 *
 * @author Cedric Henry
 * @see BudgetSupport
 * @generated
 */
public class BudgetSupportTable extends BaseTable<BudgetSupportTable> {

	public static final BudgetSupportTable INSTANCE = new BudgetSupportTable();

	public final Column<BudgetSupportTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Long> budgetSupportId =
		createColumn(
			"budgetSupportId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BudgetSupportTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenLastName =
		createColumn(
			"citoyenLastName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenFirstname =
		createColumn(
			"citoyenFirstname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Date> citoyenBirthday =
		createColumn(
			"citoyenBirthday", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenAddress =
		createColumn(
			"citoyenAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenMail = createColumn(
		"citoyenMail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Long> citoyenPostalCode =
		createColumn(
			"citoyenPostalCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenMobilePhone =
		createColumn(
			"citoyenMobilePhone", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenPhone = createColumn(
		"citoyenPhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> citoyenCity = createColumn(
		"citoyenCity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, String> publikUserId = createColumn(
		"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetSupportTable, Long> budgetParticipatifId =
		createColumn(
			"budgetParticipatifId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private BudgetSupportTable() {
		super("project_BudgetSupport", BudgetSupportTable::new);
	}

}