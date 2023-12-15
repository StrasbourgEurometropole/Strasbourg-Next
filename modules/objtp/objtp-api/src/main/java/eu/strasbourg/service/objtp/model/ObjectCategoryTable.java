/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;objtp_ObjectCategory&quot; database table.
 *
 * @author JeremyZwickert
 * @see ObjectCategory
 * @generated
 */
public class ObjectCategoryTable extends BaseTable<ObjectCategoryTable> {

	public static final ObjectCategoryTable INSTANCE =
		new ObjectCategoryTable();

	public final Column<ObjectCategoryTable, String> code = createColumn(
		"code_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<ObjectCategoryTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ObjectCategoryTable() {
		super("objtp_ObjectCategory", ObjectCategoryTable::new);
	}

}