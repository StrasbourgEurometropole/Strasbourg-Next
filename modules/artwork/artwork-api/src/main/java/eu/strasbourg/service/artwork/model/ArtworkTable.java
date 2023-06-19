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

package eu.strasbourg.service.artwork.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;artwork_Artwork&quot; database table.
 *
 * @author BenjaminBini
 * @see Artwork
 * @generated
 */
public class ArtworkTable extends BaseTable<ArtworkTable> {

	public static final ArtworkTable INSTANCE = new ArtworkTable();

	public final Column<ArtworkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Long> artworkId = createColumn(
		"artworkId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ArtworkTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Clob> technicalInformation = createColumn(
		"technicalInformation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> noticeLink = createColumn(
		"noticeLink", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> artistName = createColumn(
		"artistName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> creationYear = createColumn(
		"creationYear", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> origin = createColumn(
		"origin", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> exhibitionName = createColumn(
		"exhibitionName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> exhibitionPlace = createColumn(
		"exhibitionPlace", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> loanPeriod = createColumn(
		"loanPeriod", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> linkName = createColumn(
		"linkName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkTable, String> imagesIds = createColumn(
		"imagesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ArtworkTable() {
		super("artwork_Artwork", ArtworkTable::new);
	}

}