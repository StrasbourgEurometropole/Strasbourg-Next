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

package eu.strasbourg.service.like.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;like_Like&quot; database table.
 *
 * @author Cedric Henry
 * @see Like
 * @generated
 */
public class LikeTable extends BaseTable<LikeTable> {

	public static final LikeTable INSTANCE = new LikeTable();

	public final Column<LikeTable, Long> likeId = createColumn(
		"likeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<LikeTable, String> publikUserId = createColumn(
		"publikUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LikeTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<LikeTable, Boolean> isDislike = createColumn(
		"isDislike", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<LikeTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LikeTable, Long> entityId = createColumn(
		"entityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<LikeTable, Long> entityGroupId = createColumn(
		"entityGroupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private LikeTable() {
		super("like_Like", LikeTable::new);
	}

}