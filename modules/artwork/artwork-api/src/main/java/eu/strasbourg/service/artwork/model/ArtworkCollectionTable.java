/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;artwork_ArtworkCollection&quot; database table.
 *
 * @author BenjaminBini
 * @see ArtworkCollection
 * @generated
 */
public class ArtworkCollectionTable extends BaseTable<ArtworkCollectionTable> {

	public static final ArtworkCollectionTable INSTANCE =
		new ArtworkCollectionTable();

	public final Column<ArtworkCollectionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Long> collectionId =
		createColumn(
			"collectionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ArtworkCollectionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Date> lastPublishDate =
		createColumn(
			"lastPublishDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, String> contributors =
		createColumn(
			"contributors", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArtworkCollectionTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ArtworkCollectionTable() {
		super("artwork_ArtworkCollection", ArtworkCollectionTable::new);
	}

}