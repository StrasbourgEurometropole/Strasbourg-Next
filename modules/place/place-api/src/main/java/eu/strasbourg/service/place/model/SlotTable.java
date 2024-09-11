/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;place_Slot&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see Slot
 * @generated
 */
public class SlotTable extends BaseTable<SlotTable> {

	public static final SlotTable INSTANCE = new SlotTable();

	public final Column<SlotTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SlotTable, Long> slotId = createColumn(
		"slotId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SlotTable, Long> dayOfWeek = createColumn(
		"dayOfWeek", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SlotTable, String> startHour = createColumn(
		"startHour", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SlotTable, String> endHour = createColumn(
		"endHour", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SlotTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SlotTable, Long> periodId = createColumn(
		"periodId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SlotTable, Long> subPlaceId = createColumn(
		"subPlaceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SlotTable() {
		super("place_Slot", SlotTable::new);
	}

}