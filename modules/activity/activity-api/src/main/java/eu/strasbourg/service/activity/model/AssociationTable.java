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