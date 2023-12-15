/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;gtfs_Trip&quot; database table.
 *
 * @author Cedric Henry
 * @see Trip
 * @generated
 */
public class TripTable extends BaseTable<TripTable> {

	public static final TripTable INSTANCE = new TripTable();

	public final Column<TripTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TripTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TripTable, String> route_id = createColumn(
		"route_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TripTable, String> service_id = createColumn(
		"service_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TripTable, String> trip_id = createColumn(
		"trip_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TripTable, String> trip_headsign = createColumn(
		"trip_headsign", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TripTable, Boolean> direction_id = createColumn(
		"direction_id", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<TripTable, String> block_id = createColumn(
		"block_id", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TripTable() {
		super("gtfs_Trip", TripTable::new);
	}

}