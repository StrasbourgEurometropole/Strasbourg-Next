/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_Alert&quot; database table.
 *
 * @author Cedric Henry
 * @see Alert
 * @generated
 */
public class AlertTable extends BaseTable<AlertTable> {

	public static final AlertTable INSTANCE = new AlertTable();

	public final Column<AlertTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> alertId = createColumn(
		"alertId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AlertTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Long> arretId = createColumn(
		"arretId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AlertTable, String> ligneAndDirection = createColumn(
		"ligneAndDirection", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AlertTable, Clob> perturbation = createColumn(
		"perturbation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	private AlertTable() {
		super("gtfs_Alert", AlertTable::new);
	}

}