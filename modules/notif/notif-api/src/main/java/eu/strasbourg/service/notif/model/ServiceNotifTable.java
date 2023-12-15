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
 * The table class for the &quot;notif_ServiceNotif&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceNotif
 * @generated
 */
public class ServiceNotifTable extends BaseTable<ServiceNotifTable> {

	public static final ServiceNotifTable INSTANCE = new ServiceNotifTable();

	public final Column<ServiceNotifTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ServiceNotifTable, Long> organisationId = createColumn(
		"organisationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, Long> pictoId = createColumn(
		"pictoId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, String> csmapSubscriptionLabel =
		createColumn(
			"csmapSubscriptionLabel", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, Boolean> csmapSubscriptionMandatory =
		createColumn(
			"csmapSubscriptionMandatory", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, String> csmapTopic = createColumn(
		"csmapTopic", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ServiceNotifTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ServiceNotifTable() {
		super("notif_ServiceNotif", ServiceNotifTable::new);
	}

}