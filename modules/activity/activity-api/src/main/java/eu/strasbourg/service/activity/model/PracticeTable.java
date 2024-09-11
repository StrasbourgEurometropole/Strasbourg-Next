/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;activity_Practice&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Practice
 * @generated
 */
public class PracticeTable extends BaseTable<PracticeTable> {

	public static final PracticeTable INSTANCE = new PracticeTable();

	public final Column<PracticeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Long> practiceId = createColumn(
		"practiceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PracticeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PracticeTable, Long> associationId = createColumn(
		"associationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private PracticeTable() {
		super("activity_Practice", PracticeTable::new);
	}

}