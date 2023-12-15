/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;objtp_FoundObject&quot; database table.
 *
 * @author JeremyZwickert
 * @see FoundObject
 * @generated
 */
public class FoundObjectTable extends BaseTable<FoundObjectTable> {

	public static final FoundObjectTable INSTANCE = new FoundObjectTable();

	public final Column<FoundObjectTable, String> number = createColumn(
		"number_", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<FoundObjectTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FoundObjectTable, String> imageUrl = createColumn(
		"imageUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FoundObjectTable, String> categoryCode = createColumn(
		"categoryCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FoundObjectTable() {
		super("objtp_FoundObject", FoundObjectTable::new);
	}

}