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
 * The table class for the &quot;notification_UserNotificationStatus&quot; database table.
 *
 * @author BenjaminBini
 * @see UserNotificationStatus
 * @generated
 */
public class UserNotificationStatusTable
	extends BaseTable<UserNotificationStatusTable> {

	public static final UserNotificationStatusTable INSTANCE =
		new UserNotificationStatusTable();

	public final Column<UserNotificationStatusTable, Long> notificationId =
		createColumn(
			"notificationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserNotificationStatusTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserNotificationStatusTable, Boolean> read =
		createColumn(
			"read_", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private UserNotificationStatusTable() {
		super(
			"notification_UserNotificationStatus",
			UserNotificationStatusTable::new);
	}

}