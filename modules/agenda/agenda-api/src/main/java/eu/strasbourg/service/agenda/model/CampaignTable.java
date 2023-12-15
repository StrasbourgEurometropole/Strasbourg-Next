/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;agenda_Campaign&quot; database table.
 *
 * @author BenjaminBini
 * @see Campaign
 * @generated
 */
public class CampaignTable extends BaseTable<CampaignTable> {

	public static final CampaignTable INSTANCE = new CampaignTable();

	public final Column<CampaignTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Long> campaignId = createColumn(
		"campaignId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CampaignTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Long> defaultImageId = createColumn(
		"defaultImageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, String> defaultImageCopyright =
		createColumn(
			"defaultImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CampaignTable, String> managersIds = createColumn(
		"managersIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Boolean> exportEnabled = createColumn(
		"exportEnabled", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignTable, Date> endDate = createColumn(
		"endDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private CampaignTable() {
		super("agenda_Campaign", CampaignTable::new);
	}

}