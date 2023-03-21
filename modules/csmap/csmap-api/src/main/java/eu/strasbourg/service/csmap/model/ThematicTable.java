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

package eu.strasbourg.service.csmap.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;csmap_Thematic&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Thematic
 * @generated
 */
public class ThematicTable extends BaseTable<ThematicTable> {

	public static final ThematicTable INSTANCE = new ThematicTable();

	public final Column<ThematicTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThematicTable, Long> thematicId = createColumn(
		"thematicId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ThematicTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThematicTable, String> favorite = createColumn(
		"favorite", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ThematicTable, String> topics = createColumn(
		"topics", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ThematicTable() {
		super("csmap_Thematic", ThematicTable::new);
	}

}