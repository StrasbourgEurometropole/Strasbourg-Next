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