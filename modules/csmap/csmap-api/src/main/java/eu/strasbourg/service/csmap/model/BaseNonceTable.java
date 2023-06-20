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

import java.util.Date;

/**
 * The table class for the &quot;csmap_BaseNonce&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonce
 * @generated
 */
public class BaseNonceTable extends BaseTable<BaseNonceTable> {

	public static final BaseNonceTable INSTANCE = new BaseNonceTable();

	public final Column<BaseNonceTable, Long> baseNonceId = createColumn(
		"baseNonceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BaseNonceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BaseNonceTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private BaseNonceTable() {
		super("csmap_BaseNonce", BaseNonceTable::new);
	}

}