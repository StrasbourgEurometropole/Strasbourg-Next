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

package eu.strasbourg.service.notification.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;notification_UserNotificationChannel&quot; database table.
 *
 * @author BenjaminBini
 * @see UserNotificationChannel
 * @generated
 */
public class UserNotificationChannelTable
	extends BaseTable<UserNotificationChannelTable> {

	public static final UserNotificationChannelTable INSTANCE =
		new UserNotificationChannelTable();

	public final Column<UserNotificationChannelTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserNotificationChannelTable, Long> channelId =
		createColumn(
			"channelId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private UserNotificationChannelTable() {
		super(
			"notification_UserNotificationChannel",
			UserNotificationChannelTable::new);
	}

}