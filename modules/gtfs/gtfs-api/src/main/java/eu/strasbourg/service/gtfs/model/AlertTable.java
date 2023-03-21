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

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_Alert&quot; database table.
 *
 * @author Cedric Henry
 * @see Alert
 * @generated
 */
public class AlertTable extends BaseTable<AlertTable> {

	public static final AlertTable INSTANCE = new AlertTable();

	public final Column<AlertTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> alertId = createColumn(
		"alertId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AlertTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> arretId = createColumn(
		"arretId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertTable, String> ligneAndDirection = createColumn(
		"ligneAndDirection", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Clob> perturbation = createColumn(
		"perturbation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private AlertTable() {
		super("gtfs_Alert", AlertTable::new);
	}

}