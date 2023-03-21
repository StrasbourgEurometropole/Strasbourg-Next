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
 * The table class for the &quot;agenda_Event&quot; database table.
 *
 * @author BenjaminBini
 * @see Event
 * @generated
 */
public class EventTable extends BaseTable<EventTable> {

	public static final EventTable INSTANCE = new EventTable();

	public final Column<EventTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> eventId = createColumn(
		"eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EventTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> subtitle = createColumn(
		"subtitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> externalImageURL = createColumn(
		"externalImageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> externalImageCopyright =
		createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EventTable, Integer> imageWidth = createColumn(
		"imageWidth", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EventTable, Integer> imageHeight = createColumn(
		"imageHeight", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeSIGId = createColumn(
		"placeSIGId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeName = createColumn(
		"placeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeStreetNumber = createColumn(
		"placeStreetNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeStreetName = createColumn(
		"placeStreetName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeZipCode = createColumn(
		"placeZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeCity = createColumn(
		"placeCity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> placeCountry = createColumn(
		"placeCountry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> mercatorX = createColumn(
		"mercatorX", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> mercatorY = createColumn(
		"mercatorY", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> access = createColumn(
		"access_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> accessForDisabled = createColumn(
		"accessForDisabled", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> accessForBlind = createColumn(
		"accessForBlind", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> accessForDeaf = createColumn(
		"accessForDeaf", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> accessForWheelchair = createColumn(
		"accessForWheelchair", Boolean.class, Types.BOOLEAN,
		Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> accessForElder = createColumn(
		"accessForElder", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> accessForDeficient = createColumn(
		"accessForDeficient", Boolean.class, Types.BOOLEAN,
		Column.FLAG_DEFAULT);
	public final Column<EventTable, String> promoter = createColumn(
		"promoter", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> websiteURL = createColumn(
		"websiteURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> websiteName = createColumn(
		"websiteName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Integer> free = createColumn(
		"free", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> price = createColumn(
		"price", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> bookingDescription = createColumn(
		"bookingDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> bookingURL = createColumn(
		"bookingURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> subscriptionURL = createColumn(
		"subscriptionURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> source = createColumn(
		"source", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> idSource = createColumn(
		"idSource", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> publicationDate = createColumn(
		"publicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> distribution = createColumn(
		"distribution", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> composer = createColumn(
		"composer", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, String> concertId = createColumn(
		"concertId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EventTable, Clob> program = createColumn(
		"program", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> firstStartDate = createColumn(
		"firstStartDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> lastEndDate = createColumn(
		"lastEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> createDateSource = createColumn(
		"createDateSource", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> modifiedDateSource = createColumn(
		"modifiedDateSource", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EventTable, Boolean> registration = createColumn(
		"registration", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> registrationStartDate = createColumn(
		"registrationStartDate", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<EventTable, Date> registrationEndDate = createColumn(
		"registrationEndDate", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<EventTable, Long> maxGauge = createColumn(
		"maxGauge", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EventTable() {
		super("agenda_Event", EventTable::new);
	}

}