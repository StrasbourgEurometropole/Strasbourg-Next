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