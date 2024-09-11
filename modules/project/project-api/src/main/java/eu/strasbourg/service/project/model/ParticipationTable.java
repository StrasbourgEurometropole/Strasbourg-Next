/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_Participation&quot; database table.
 *
 * @author Cedric Henry
 * @see Participation
 * @generated
 */
public class ParticipationTable extends BaseTable<ParticipationTable> {

	public static final ParticipationTable INSTANCE = new ParticipationTable();

	public final Column<ParticipationTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Long> participationId =
		createColumn(
			"participationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ParticipationTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> contactName = createColumn(
		"contactName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> contactLine1 = createColumn(
		"contactLine1", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> contactLine2 = createColumn(
		"contactLine2", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> contactPhoneNumber =
		createColumn(
			"contactPhoneNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> videoUrl = createColumn(
		"videoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> externalImageURL =
		createColumn(
			"externalImageURL", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> externalImageCopyright =
		createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Boolean> mediaChoice = createColumn(
		"mediaChoice", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> descriptionChapeau =
		createColumn(
			"descriptionChapeau", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Clob> descriptionBody =
		createColumn(
			"descriptionBody", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Clob> consultationPlacesBody =
		createColumn(
			"consultationPlacesBody", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> filesIds = createColumn(
		"filesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, String> eventsIds = createColumn(
		"eventsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Date> publicationDate =
		createColumn(
			"publicationDate", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<ParticipationTable, Date> expirationDate = createColumn(
		"expirationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ParticipationTable() {
		super("project_Participation", ParticipationTable::new);
	}

}