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

package eu.strasbourg.service.favorite.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;favorite_Favorite&quot; database table.
 *
 * @author BenjaminBini
 * @see Favorite
 * @generated
 */
public class FavoriteTable extends BaseTable<FavoriteTable> {

	public static final FavoriteTable INSTANCE = new FavoriteTable();

	public final Column<FavoriteTable, Long> favoriteId = createColumn(
		"favoriteId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FavoriteTable, String> publikUserId = createColumn(
		"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Long> entityGroupId = createColumn(
		"entityGroupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Date> onDashboardDate = createColumn(
		"onDashboardDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Integer> order = createColumn(
		"order_", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FavoriteTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private FavoriteTable() {
		super("favorite_Favorite", FavoriteTable::new);
	}

}