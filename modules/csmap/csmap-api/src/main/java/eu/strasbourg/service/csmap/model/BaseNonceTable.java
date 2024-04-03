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