/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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