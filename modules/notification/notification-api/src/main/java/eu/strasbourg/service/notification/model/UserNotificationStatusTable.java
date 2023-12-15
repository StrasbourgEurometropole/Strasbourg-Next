/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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