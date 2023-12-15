/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;gtfs_Ligne&quot; database table.
 *
 * @author Cedric Henry
 * @see Ligne
 * @generated
 */
public class LigneTable extends BaseTable<LigneTable> {

	public static final LigneTable INSTANCE = new LigneTable();

	public final Column<LigneTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Long> ligneId = createColumn(
		"ligneId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LigneTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> routeId = createColumn(
		"routeId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> shortName = createColumn(
		"shortName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, Integer> type = createColumn(
		"type_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> backgroundColor = createColumn(
		"backgroundColor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LigneTable, String> textColor = createColumn(
		"textColor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LigneTable() {
		super("gtfs_Ligne", LigneTable::new);
	}

}