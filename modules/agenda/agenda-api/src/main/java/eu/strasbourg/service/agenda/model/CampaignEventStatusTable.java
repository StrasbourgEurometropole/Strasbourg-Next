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

package eu.strasbourg.service.agenda.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;agenda_CampaignEventStatus&quot; database table.
 *
 * @author BenjaminBini
 * @see CampaignEventStatus
 * @generated
 */
public class CampaignEventStatusTable
	extends BaseTable<CampaignEventStatusTable> {

	public static final CampaignEventStatusTable INSTANCE =
		new CampaignEventStatusTable();

	public final Column<CampaignEventStatusTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Long> statusId = createColumn(
		"statusId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CampaignEventStatusTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Clob> comment = createColumn(
		"comment_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Boolean> deletionDenied =
		createColumn(
			"deletionDenied", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Long> campaignEventId =
		createColumn(
			"campaignEventId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Long> previousStatusId =
		createColumn(
			"previousStatusId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventStatusTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CampaignEventStatusTable() {
		super("agenda_CampaignEventStatus", CampaignEventStatusTable::new);
	}

}