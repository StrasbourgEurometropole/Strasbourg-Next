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