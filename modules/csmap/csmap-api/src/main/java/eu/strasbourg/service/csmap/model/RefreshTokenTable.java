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
 * The table class for the &quot;csmap_RefreshToken&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see RefreshToken
 * @generated
 */
public class RefreshTokenTable extends BaseTable<RefreshTokenTable> {

	public static final RefreshTokenTable INSTANCE = new RefreshTokenTable();

	public final Column<RefreshTokenTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenTable, Long> refreshTokenId = createColumn(
		"refreshTokenId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RefreshTokenTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenTable, String> value = createColumn(
		"value", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RefreshTokenTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private RefreshTokenTable() {
		super("csmap_RefreshToken", RefreshTokenTable::new);
	}

}