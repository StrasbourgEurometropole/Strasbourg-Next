/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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