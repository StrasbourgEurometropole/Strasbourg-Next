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
 * The table class for the &quot;agenda_CampaignEvent&quot; database table.
 *
 * @author BenjaminBini
 * @see CampaignEvent
 * @generated
 */
public class CampaignEventTable extends BaseTable<CampaignEventTable> {

	public static final CampaignEventTable INSTANCE = new CampaignEventTable();

	public final Column<CampaignEventTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> campaignEventId =
		createColumn(
			"campaignEventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CampaignEventTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> serviceId = createColumn(
		"serviceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> service = createColumn(
		"service", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> onSiteFirstName =
		createColumn(
			"onSiteFirstName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> onSiteLastName =
		createColumn(
			"onSiteLastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> onSitePhone = createColumn(
		"onSitePhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> subtitle = createColumn(
		"subtitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> webImageId = createColumn(
		"webImageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> imageOwner = createColumn(
		"imageOwner", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> manifestationsIds =
		createColumn(
			"manifestationsIds", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeSIGId = createColumn(
		"placeSIGId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeName = createColumn(
		"placeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeStreetNumber =
		createColumn(
			"placeStreetNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeStreetName =
		createColumn(
			"placeStreetName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeZipCode = createColumn(
		"placeZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> placeCityId = createColumn(
		"placeCityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> placeCountry = createColumn(
		"placeCountry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> promoter = createColumn(
		"promoter", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> publicPhone = createColumn(
		"publicPhone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> publicEmail = createColumn(
		"publicEmail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> websiteURL = createColumn(
		"websiteURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> websiteName = createColumn(
		"websiteName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Integer> free = createColumn(
		"free", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Clob> price = createColumn(
		"price", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> campaignId = createColumn(
		"campaignId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> themesIds = createColumn(
		"themesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> typesIds = createColumn(
		"typesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> publicsIds = createColumn(
		"publicsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Clob> bookingDescription =
		createColumn(
			"bookingDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, String> bookingURL = createColumn(
		"bookingURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Boolean> registration =
		createColumn(
			"registration", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Date> registrationStartDate =
		createColumn(
			"registrationStartDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Date> registrationEndDate =
		createColumn(
			"registrationEndDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<CampaignEventTable, Long> maxGauge = createColumn(
		"maxGauge", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CampaignEventTable() {
		super("agenda_CampaignEvent", CampaignEventTable::new);
	}

}