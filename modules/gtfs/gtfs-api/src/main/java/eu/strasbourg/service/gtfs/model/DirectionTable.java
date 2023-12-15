/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;gtfs_Direction&quot; database table.
 *
 * @author Cedric Henry
 * @see Direction
 * @generated
 */
public class DirectionTable extends BaseTable<DirectionTable> {

	public static final DirectionTable INSTANCE = new DirectionTable();

	public final Column<DirectionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, Long> directionId = createColumn(
		"directionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DirectionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, String> tripId = createColumn(
		"tripId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, String> stopId = createColumn(
		"stopId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, String> routeId = createColumn(
		"routeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DirectionTable, String> destinationName = createColumn(
		"destinationName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DirectionTable() {
		super("gtfs_Direction", DirectionTable::new);
	}

}