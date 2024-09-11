/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;notification_UserNotificationType&quot; database table.
 *
 * @author BenjaminBini
 * @see UserNotificationType
 * @generated
 */
public class UserNotificationTypeTable
	extends BaseTable<UserNotificationTypeTable> {

	public static final UserNotificationTypeTable INSTANCE =
		new UserNotificationTypeTable();

	public final Column<UserNotificationTypeTable, String> publikUserId =
		createColumn(
			"publikUserId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);
	public final Column<UserNotificationTypeTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private UserNotificationTypeTable() {
		super(
			"notification_UserNotificationType",
			UserNotificationTypeTable::new);
	}

}