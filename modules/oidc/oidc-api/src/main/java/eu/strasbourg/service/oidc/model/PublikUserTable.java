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

package eu.strasbourg.service.oidc.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;publik_PublikUser&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see PublikUser
 * @generated
 */
public class PublikUserTable extends BaseTable<PublikUserTable> {

	public static final PublikUserTable INSTANCE = new PublikUserTable();

	public final Column<PublikUserTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Long> publikUserLiferayId =
		createColumn(
			"publikUserLiferayId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<PublikUserTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> accessToken = createColumn(
		"accessToken", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> firstName = createColumn(
		"firstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> lastName = createColumn(
		"lastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> mapConfig = createColumn(
		"mapConfig", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> displayConfig = createColumn(
		"displayConfig", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Date> pactSignature = createColumn(
		"pactSignature", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Date> banishDate = createColumn(
		"banishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Clob> banishDescription = createColumn(
		"banishDescription", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> imageURL = createColumn(
		"imageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Boolean> pactDisplay = createColumn(
		"pactDisplay", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> csmapJSON = createColumn(
		"csmapJSON", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Date> modifiedDateJSON = createColumn(
		"modifiedDateJSON", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, String> topicsFCM = createColumn(
		"topicsFCM", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PublikUserTable, Long> lastUpdateTimeTopics =
		createColumn(
			"lastUpdateTimeTopics", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);

	private PublikUserTable() {
		super("publik_PublikUser", PublikUserTable::new);
	}

}