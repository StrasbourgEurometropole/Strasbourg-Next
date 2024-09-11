/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.link.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;link_Link&quot; database table.
 *
 * @author BenjaminBini
 * @see Link
 * @generated
 */
public class LinkTable extends BaseTable<LinkTable> {

	public static final LinkTable INSTANCE = new LinkTable();

	public final Column<LinkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Long> linkId = createColumn(
		"linkId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LinkTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LinkTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LinkTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LinkTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<LinkTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<LinkTable, String> URL = createColumn(
		"URL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<LinkTable, String> hoverText = createColumn(
		"hoverText", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private LinkTable() {
		super("link_Link", LinkTable::new);
	}

}