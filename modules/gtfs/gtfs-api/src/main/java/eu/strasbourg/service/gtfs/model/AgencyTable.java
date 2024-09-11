/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;gtfs_Agency&quot; database table.
 *
 * @author Cedric Henry
 * @see Agency
 * @generated
 */
public class AgencyTable extends BaseTable<AgencyTable> {

	public static final AgencyTable INSTANCE = new AgencyTable();

	public final Column<AgencyTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AgencyTable, String> agency_name = createColumn(
		"agency_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_url = createColumn(
		"agency_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_timezone = createColumn(
		"agency_timezone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_phone = createColumn(
		"agency_phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_fare_url = createColumn(
		"agency_fare_url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgencyTable, String> agency_lang = createColumn(
		"agency_lang", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AgencyTable() {
		super("gtfs_Agency", AgencyTable::new);
	}

}