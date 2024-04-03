/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;notif_Notification&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Notification
 * @generated
 */
public class NotificationTable extends BaseTable<NotificationTable> {

	public static final NotificationTable INSTANCE = new NotificationTable();

	public final Column<NotificationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> notificationId = createColumn(
		"notificationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<NotificationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Integer> isAlert = createColumn(
		"isAlert", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> natureId = createColumn(
		"natureId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> subtitle = createColumn(
		"subtitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Date> broadcastDate = createColumn(
		"broadcastDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> messageId = createColumn(
		"messageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> content = createColumn(
		"content", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> labelUrl = createColumn(
		"labelUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> url = createColumn(
		"url", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> typeBroadcast = createColumn(
		"typeBroadcast", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> district = createColumn(
		"district", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, String> broadcastChannels =
		createColumn(
			"broadcastChannels", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> sendStatusCsmap = createColumn(
		"sendStatusCsmap", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> sendStatusTwitter =
		createColumn(
			"sendStatusTwitter", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> sendStatusMonst = createColumn(
		"sendStatusMonst", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> sendStatusMail = createColumn(
		"sendStatusMail", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Long> sendStatusSegur = createColumn(
		"sendStatusSegur", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<NotificationTable, Boolean> isSend = createColumn(
		"isSend", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private NotificationTable() {
		super("notif_Notification", NotificationTable::new);
	}

}