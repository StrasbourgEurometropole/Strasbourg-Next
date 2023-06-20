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

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_GoogleMyBusinessHistoric&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoric
 * @generated
 */
public class GoogleMyBusinessHistoricTable
	extends BaseTable<GoogleMyBusinessHistoricTable> {

	public static final GoogleMyBusinessHistoricTable INSTANCE =
		new GoogleMyBusinessHistoricTable();

	public final Column<GoogleMyBusinessHistoricTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Long>
		googleMyBusinessHistoricId = createColumn(
			"googleMyBusinessHistoricId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<GoogleMyBusinessHistoricTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, String>
		statusByUserName = createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Integer> result =
		createColumn(
			"result", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Clob> operations =
		createColumn("operations", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Clob> errorDescription =
		createColumn(
			"errorDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Clob> errorStackTrace =
		createColumn(
			"errorStackTrace", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> startDate =
		createColumn(
			"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<GoogleMyBusinessHistoricTable, Date> finishDate =
		createColumn(
			"finishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private GoogleMyBusinessHistoricTable() {
		super(
			"place_GoogleMyBusinessHistoric",
			GoogleMyBusinessHistoricTable::new);
	}

}