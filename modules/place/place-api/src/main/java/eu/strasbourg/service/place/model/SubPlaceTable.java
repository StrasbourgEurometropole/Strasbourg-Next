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
 * The table class for the &quot;place_SubPlace&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see SubPlace
 * @generated
 */
public class SubPlaceTable extends BaseTable<SubPlaceTable> {

	public static final SubPlaceTable INSTANCE = new SubPlaceTable();

	public final Column<SubPlaceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, Long> subPlaceId = createColumn(
		"subPlaceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SubPlaceTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SubPlaceTable, Long> placeId = createColumn(
		"placeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private SubPlaceTable() {
		super("place_SubPlace", SubPlaceTable::new);
	}

}