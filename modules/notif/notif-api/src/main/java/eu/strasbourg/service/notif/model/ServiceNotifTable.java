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