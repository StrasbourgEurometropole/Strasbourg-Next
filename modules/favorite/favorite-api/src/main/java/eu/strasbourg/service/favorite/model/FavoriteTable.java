/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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