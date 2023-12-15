/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;notif_NatureNotif&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see NatureNotif
 * @generated
 */
public class NatureNotifTable extends BaseTable<NatureNotifTable> {

	public static final NatureNotifTable INSTANCE = new NatureNotifTable();

	public final Column<NatureNotifTable, Long> natureId = createColumn(
		"natureId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NatureNotifTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NatureNotifTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private NatureNotifTable() {
		super("notif_NatureNotif", NatureNotifTable::new);
	}

}