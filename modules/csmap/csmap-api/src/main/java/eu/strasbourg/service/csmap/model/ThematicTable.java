/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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