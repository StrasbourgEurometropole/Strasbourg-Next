/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;strasbourg_Strasbourg&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Strasbourg
 * @generated
 */
public class StrasbourgTable extends BaseTable<StrasbourgTable> {

	public static final StrasbourgTable INSTANCE = new StrasbourgTable();

	public final Column<StrasbourgTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<StrasbourgTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private StrasbourgTable() {
		super("strasbourg_Strasbourg", StrasbourgTable::new);
	}

}