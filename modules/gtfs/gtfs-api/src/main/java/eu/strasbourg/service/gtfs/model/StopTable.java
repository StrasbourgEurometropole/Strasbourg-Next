/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;gtfs_Stop&quot; database table.
 *
 * @author Cedric Henry
 * @see Stop
 * @generated
 */
public class StopTable extends BaseTable<StopTable> {

	public static final StopTable INSTANCE = new StopTable();

	public final Column<StopTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<StopTable, String> stop_id = createColumn(
		"stop_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_code = createColumn(
		"stop_code", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_lat = createColumn(
		"stop_lat", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_lon = createColumn(
		"stop_lon", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_name = createColumn(
		"stop_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_url = createColumn(
		"stop_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StopTable, String> stop_desc = createColumn(
		"stop_desc", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private StopTable() {
		super("gtfs_Stop", StopTable::new);
	}

}