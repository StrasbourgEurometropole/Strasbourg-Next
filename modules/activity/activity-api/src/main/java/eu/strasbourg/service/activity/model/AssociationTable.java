/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;activity_Association&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Association
 * @generated
 */
public class AssociationTable extends BaseTable<AssociationTable> {

	public static final AssociationTable INSTANCE = new AssociationTable();

	public final Column<AssociationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Long> associationId = createColumn(
		"associationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AssociationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Clob> presentation = createColumn(
		"presentation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> siteURL = createColumn(
		"siteURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> mail = createColumn(
		"mail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> facebookURL = createColumn(
		"facebookURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Clob> othersInformations =
		createColumn(
			"othersInformations", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AssociationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AssociationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AssociationTable() {
		super("activity_Association", AssociationTable::new);
	}

}