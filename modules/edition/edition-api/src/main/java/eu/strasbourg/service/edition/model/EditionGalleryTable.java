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

package eu.strasbourg.service.edition.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;edition_EditionGallery&quot; database table.
 *
 * @author BenjaminBini
 * @see EditionGallery
 * @generated
 */
public class EditionGalleryTable extends BaseTable<EditionGalleryTable> {

	public static final EditionGalleryTable INSTANCE =
		new EditionGalleryTable();

	public final Column<EditionGalleryTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Long> galleryId = createColumn(
		"galleryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EditionGalleryTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<EditionGalleryTable, Date> publicationDate =
		createColumn(
			"publicationDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);

	private EditionGalleryTable() {
		super("edition_EditionGallery", EditionGalleryTable::new);
	}

}