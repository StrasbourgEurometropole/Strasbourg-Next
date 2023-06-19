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

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_Period&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see Period
 * @generated
 */
public class PeriodTable extends BaseTable<PeriodTable> {

	public static final PeriodTable INSTANCE = new PeriodTable();

	public final Column<PeriodTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> periodId = createColumn(
		"periodId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PeriodTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Boolean> defaultPeriod = createColumn(
		"defaultPeriod", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Boolean> alwaysOpen = createColumn(
		"alwaysOpen", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> RTGreenThreshold = createColumn(
		"RTGreenThreshold", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> RTOrangeThreshold = createColumn(
		"RTOrangeThreshold", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> RTRedThreshold = createColumn(
		"RTRedThreshold", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> RTMaxThreshold = createColumn(
		"RTMaxThreshold", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PeriodTable, Long> placeId = createColumn(
		"placeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PeriodTable() {
		super("place_Period", PeriodTable::new);
	}

}