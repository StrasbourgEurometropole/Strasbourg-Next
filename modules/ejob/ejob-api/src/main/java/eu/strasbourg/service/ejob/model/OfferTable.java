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

package eu.strasbourg.service.ejob.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;
import java.util.Date;

/**
 * The table class for the &quot;ejob_Offer&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Offer
 * @generated
 */
public class OfferTable extends BaseTable<OfferTable> {

	public static final OfferTable INSTANCE = new OfferTable();

	public final Column<OfferTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> offerId = createColumn(
		"offerId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfferTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> publicationId = createColumn(
		"publicationId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> postNumber = createColumn(
		"postNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> jobCreationDescription =
		createColumn(
			"jobCreationDescription", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> startDate = createColumn(
		"startDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> permanentDescription = createColumn(
		"permanentDescription", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> duration = createColumn(
		"duration", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> post = createColumn(
		"post", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Boolean> isFullTime = createColumn(
		"isFullTime", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> fullTimeDescription = createColumn(
		"fullTimeDescription", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<OfferTable, Clob> introduction = createColumn(
		"introduction", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Clob> activities = createColumn(
		"activities", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Clob> profil = createColumn(
		"profil", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Clob> conditions = createColumn(
		"conditions", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Clob> avantages = createColumn(
		"avantages", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> limitDate = createColumn(
		"limitDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> contact = createColumn(
		"contact", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, String> emails = createColumn(
		"emails", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Boolean> shareLinkedin = createColumn(
		"shareLinkedin", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> publicationStartDate = createColumn(
		"publicationStartDate", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<OfferTable, Date> publicationEndDate = createColumn(
		"publicationEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Integer> isExported = createColumn(
		"isExported", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Integer> emailSend = createColumn(
		"emailSend", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<OfferTable, Integer> emailPartnerSent = createColumn(
		"emailPartnerSent", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);

	private OfferTable() {
		super("ejob_Offer", OfferTable::new);
	}

}