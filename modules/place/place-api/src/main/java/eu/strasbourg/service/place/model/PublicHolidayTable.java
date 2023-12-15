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
 * The table class for the &quot;place_PublicHoliday&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see PublicHoliday
 * @generated
 */
public class PublicHolidayTable extends BaseTable<PublicHolidayTable> {

	public static final PublicHolidayTable INSTANCE = new PublicHolidayTable();

	public final Column<PublicHolidayTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Long> publicHolidayId =
		createColumn(
			"publicHolidayId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PublicHolidayTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublicHolidayTable, Boolean> recurrent = createColumn(
		"recurrent", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private PublicHolidayTable() {
		super("place_PublicHoliday", PublicHolidayTable::new);
	}

}