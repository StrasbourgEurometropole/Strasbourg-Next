/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;edition_Edition&quot; database table.
 *
 * @author BenjaminBini
 * @see Edition
 * @generated
 */
public class EditionTable extends BaseTable<EditionTable> {

	public static final EditionTable INSTANCE = new EditionTable();

	public final Column<EditionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Long> editionId = createColumn(
		"editionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EditionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> subtitle = createColumn(
		"subtitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);

	public final Column<EditionTable, String> URL = createColumn(
		"URL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<EditionTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> editor = createColumn(
		"editor", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> distribution = createColumn(
		"distribution", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<EditionTable, String> ISBN = createColumn(
		"ISBN", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<EditionTable, String> price = createColumn(
		"price", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Boolean> availableForExchange =
		createColumn(
			"availableForExchange", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<EditionTable, Boolean> inStock = createColumn(
		"inStock", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> diffusionDateYear = createColumn(
		"diffusionDateYear", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> diffusionDateMonth = createColumn(
		"diffusionDateMonth", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> pageNumber = createColumn(
		"pageNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> pictureNumber = createColumn(
		"pictureNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Date> publicationDate = createColumn(
		"publicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<EditionTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EditionTable, String> fileId = createColumn(
		"fileId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private EditionTable() {
		super("edition_Edition", EditionTable::new);
	}

}