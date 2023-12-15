/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;notification_Notification&quot; database table.
 *
 * @author BenjaminBini
 * @see Notification
 * @generated
 */
public class NotificationTable extends BaseTable<NotificationTable> {

	public static final NotificationTable INSTANCE = new NotificationTable();

	public final Column<NotificationTable, Long> notificationId = createColumn(
		"notificationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NotificationTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Boolean> automatic = createColumn(
		"automatic", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Boolean> singleUser = createColumn(
		"singleUser", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> singleUserId = createColumn(
		"singleUserId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> publicationDate = createColumn(
		"publicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> expirationDate = createColumn(
		"expirationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private NotificationTable() {
		super("notification_Notification", NotificationTable::new);
	}

}