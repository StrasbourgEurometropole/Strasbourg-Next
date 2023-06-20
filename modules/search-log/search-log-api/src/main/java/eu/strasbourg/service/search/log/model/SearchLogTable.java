/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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