/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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