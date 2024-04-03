/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_BudgetParticipatif&quot; database table.
 *
 * @author Cedric Henry
 * @see BudgetParticipatif
 * @generated
 */
public class BudgetParticipatifTable
	extends BaseTable<BudgetParticipatifTable> {

	public static final BudgetParticipatifTable INSTANCE =
		new BudgetParticipatifTable();

	public final Column<BudgetParticipatifTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> budgetParticipatifId =
		createColumn(
			"budgetParticipatifId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<BudgetParticipatifTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> summary = createColumn(
		"summary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> budget = createColumn(
		"budget", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Clob> motif = createColumn(
		"motif", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> placeTextArea =
		createColumn(
			"placeTextArea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> inTheNameOf =
		createColumn(
			"inTheNameOf", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenLastname =
		createColumn(
			"citoyenLastname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenFirstname =
		createColumn(
			"citoyenFirstname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenAdresse =
		createColumn(
			"citoyenAdresse", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> citoyenPostalCode =
		createColumn(
			"citoyenPostalCode", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenCity =
		createColumn(
			"citoyenCity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenPhone =
		createColumn(
			"citoyenPhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenMobile =
		createColumn(
			"citoyenMobile", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> citoyenEmail =
		createColumn(
			"citoyenEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Date> citoyenBirthday =
		createColumn(
			"citoyenBirthday", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Boolean> hasCopyright =
		createColumn(
			"hasCopyright", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> videoUrl =
		createColumn(
			"videoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> imageTimeline =
		createColumn(
			"imageTimeline", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Double> opacityImage =
		createColumn(
			"opacityImage", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Boolean> isCrush =
		createColumn(
			"isCrush", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Clob> crushComment =
		createColumn(
			"crushComment", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> publikId =
		createColumn(
			"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, String> filesIds =
		createColumn(
			"filesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> budgetPhaseId =
		createColumn(
			"budgetPhaseId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BudgetParticipatifTable, Long> parentId = createColumn(
		"parentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private BudgetParticipatifTable() {
		super("project_BudgetParticipatif", BudgetParticipatifTable::new);
	}

}