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

import java.sql.Types;

/**
 * The table class for the &quot;edition_EditionToEditionGallery&quot; database table.
 *
 * @author BenjaminBini
 * @see Edition
 * @see EditionGallery
 * @generated
 */
public class edition_EditionToEditionGalleryTable
	extends BaseTable<edition_EditionToEditionGalleryTable> {

	public static final edition_EditionToEditionGalleryTable INSTANCE =
		new edition_EditionToEditionGalleryTable();

	public final Column<edition_EditionToEditionGalleryTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<edition_EditionToEditionGalleryTable, Long> editionId =
		createColumn(
			"editionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<edition_EditionToEditionGalleryTable, Long> galleryId =
		createColumn(
			"galleryId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private edition_EditionToEditionGalleryTable() {
		super(
			"edition_EditionToEditionGallery",
			edition_EditionToEditionGalleryTable::new);
	}

}