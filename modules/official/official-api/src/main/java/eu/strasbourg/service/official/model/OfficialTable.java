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

package eu.strasbourg.service.official.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;official_Official&quot; database table.
 *
 * @author AngeliqueZUNINO
 * @see Official
 * @generated
 */
public class OfficialTable extends BaseTable<OfficialTable> {

	public static final OfficialTable INSTANCE = new OfficialTable();

	public final Column<OfficialTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> officialId = createColumn(
		"officialId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfficialTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Integer> gender = createColumn(
		"gender", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Clob> thematicDelegation = createColumn(
		"thematicDelegation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Clob> missions = createColumn(
		"missions", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Boolean> wasMinister = createColumn(
		"wasMinister", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Clob> contact = createColumn(
		"contact", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Integer> orderDeputyMayor = createColumn(
		"orderDeputyMayor", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Integer> orderVicePresident =
		createColumn(
			"orderVicePresident", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> listeContact = createColumn(
		"listeContact", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> resumeFonction = createColumn(
		"resumeFonction", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private OfficialTable() {
		super("official_Official", OfficialTable::new);
	}

}