/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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