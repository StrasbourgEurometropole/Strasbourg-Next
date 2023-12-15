/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;notif_Message&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Message
 * @generated
 */
public class MessageTable extends BaseTable<MessageTable> {

	public static final MessageTable INSTANCE = new MessageTable();

	public final Column<MessageTable, Long> messageId = createColumn(
		"messageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MessageTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MessageTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MessageTable() {
		super("notif_Message", MessageTable::new);
	}

}