/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;artwork_ArtworkToArtworkCollection&quot; database table.
 *
 * @author BenjaminBini
 * @see Artwork
 * @see ArtworkCollection
 * @generated
 */
public class artwork_ArtworkToArtworkCollectionTable
	extends BaseTable<artwork_ArtworkToArtworkCollectionTable> {

	public static final artwork_ArtworkToArtworkCollectionTable INSTANCE =
		new artwork_ArtworkToArtworkCollectionTable();

	public final Column<artwork_ArtworkToArtworkCollectionTable, Long>
		companyId = createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<artwork_ArtworkToArtworkCollectionTable, Long>
		artworkId = createColumn(
			"artworkId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<artwork_ArtworkToArtworkCollectionTable, Long>
		collectionId = createColumn(
			"collectionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private artwork_ArtworkToArtworkCollectionTable() {
		super(
			"artwork_ArtworkToArtworkCollection",
			artwork_ArtworkToArtworkCollectionTable::new);
	}

}