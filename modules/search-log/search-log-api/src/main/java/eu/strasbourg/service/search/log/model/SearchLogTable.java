/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;search_SearchLog&quot; database table.
 *
 * @author BenjaminBini
 * @see SearchLog
 * @generated
 */
public class SearchLogTable extends BaseTable<SearchLogTable> {

	public static final SearchLogTable INSTANCE = new SearchLogTable();

	public final Column<SearchLogTable, Long> searchLogId = createColumn(
		"searchLogId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<SearchLogTable, String> keywords = createColumn(
		"keywords", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> searchTime = createColumn(
		"searchTime", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> resultCount = createColumn(
		"resultCount", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result1ClassId = createColumn(
		"result1ClassId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result1ClassPK = createColumn(
		"result1ClassPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> result1Title = createColumn(
		"result1Title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result2ClassId = createColumn(
		"result2ClassId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result2ClassPK = createColumn(
		"result2ClassPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> result2Title = createColumn(
		"result2Title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result3ClassId = createColumn(
		"result3ClassId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> result3ClassPK = createColumn(
		"result3ClassPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> result3Title = createColumn(
		"result3Title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> userTargetClassId = createColumn(
		"userTargetClassId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> userTargetClassPK = createColumn(
		"userTargetClassPK", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> userTargetTitle = createColumn(
		"userTargetTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Long> layoutId = createColumn(
		"layoutId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> layoutFriendlyURL =
		createColumn(
			"layoutFriendlyURL", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, String> language = createColumn(
		"language", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SearchLogTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private SearchLogTable() {
		super("search_SearchLog", SearchLogTable::new);
	}

}