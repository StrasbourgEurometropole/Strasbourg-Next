/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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