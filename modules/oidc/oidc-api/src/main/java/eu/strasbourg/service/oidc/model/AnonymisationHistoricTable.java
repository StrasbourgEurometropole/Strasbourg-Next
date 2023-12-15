/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.oidc.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;publik_AnonymisationHistoric&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymisationHistoric
 * @generated
 */
public class AnonymisationHistoricTable
	extends BaseTable<AnonymisationHistoricTable> {

	public static final AnonymisationHistoricTable INSTANCE =
		new AnonymisationHistoricTable();

	public final Column<AnonymisationHistoricTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Long>
		anonymisationHistoricId = createColumn(
			"anonymisationHistoricId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AnonymisationHistoricTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Integer> result =
		createColumn(
			"result", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Clob> operations =
		createColumn("operations", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Clob> errorDescription =
		createColumn(
			"errorDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Clob> errorStackTrace =
		createColumn(
			"errorStackTrace", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AnonymisationHistoricTable, Date> finishDate =
		createColumn(
			"finishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AnonymisationHistoricTable() {
		super("publik_AnonymisationHistoric", AnonymisationHistoricTable::new);
	}

}