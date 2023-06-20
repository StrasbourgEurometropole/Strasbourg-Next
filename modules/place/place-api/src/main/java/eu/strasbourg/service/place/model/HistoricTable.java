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