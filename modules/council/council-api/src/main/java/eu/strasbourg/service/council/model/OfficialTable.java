/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;council_Official&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Official
 * @generated
 */
public class OfficialTable extends BaseTable<OfficialTable> {

	public static final OfficialTable INSTANCE = new OfficialTable();

	public final Column<OfficialTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> officialId = createColumn(
		"officialId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfficialTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> firstname = createColumn(
		"firstname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> lastname = createColumn(
		"lastname", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, Date> lastActivity = createColumn(
		"lastActivity", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTable, String> lastSignInDeviceInfo =
		createColumn(
			"lastSignInDeviceInfo", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private OfficialTable() {
		super("council_Official", OfficialTable::new);
	}

}