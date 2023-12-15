/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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