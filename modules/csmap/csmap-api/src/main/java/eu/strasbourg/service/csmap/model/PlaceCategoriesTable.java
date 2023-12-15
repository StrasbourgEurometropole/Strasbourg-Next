/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;csmap_PlaceCategories&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PlaceCategories
 * @generated
 */
public class PlaceCategoriesTable extends BaseTable<PlaceCategoriesTable> {

	public static final PlaceCategoriesTable INSTANCE =
		new PlaceCategoriesTable();

	public final Column<PlaceCategoriesTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceCategoriesTable, Long> placeCategoriesId =
		createColumn(
			"placeCategoriesId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PlaceCategoriesTable, String> categoriesIds =
		createColumn(
			"categoriesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PlaceCategoriesTable() {
		super("csmap_PlaceCategories", PlaceCategoriesTable::new);
	}

}