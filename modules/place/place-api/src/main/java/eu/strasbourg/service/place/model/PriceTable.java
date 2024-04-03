/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_Price&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see Price
 * @generated
 */
public class PriceTable extends BaseTable<PriceTable> {

	public static final PriceTable INSTANCE = new PriceTable();

	public final Column<PriceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PriceTable, Long> priceId = createColumn(
		"priceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PriceTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PriceTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PriceTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PriceTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PriceTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PriceTable, Clob> priceDescription = createColumn(
		"priceDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private PriceTable() {
		super("place_Price", PriceTable::new);
	}

}