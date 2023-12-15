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
 * The table class for the &quot;place_Historic&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see Historic
 * @generated
 */
public class HistoricTable extends BaseTable<HistoricTable> {

	public static final HistoricTable INSTANCE = new HistoricTable();

	public final Column<HistoricTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HistoricTable, String> sigId = createColumn(
		"sigId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<HistoricTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<HistoricTable, Date> suppressionDate = createColumn(
		"suppressionDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private HistoricTable() {
		super("place_Historic", HistoricTable::new);
	}

}