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
 * The table class for the &quot;project_Petition&quot; database table.
 *
 * @author Cedric Henry
 * @see Petition
 * @generated
 */
public class PetitionTable extends BaseTable<PetitionTable> {

	public static final PetitionTable INSTANCE = new PetitionTable();

	public final Column<PetitionTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> petitionId = createColumn(
		"petitionId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PetitionTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> summary = createColumn(
		"summary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Clob> description = createColumn(
		"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> placeTextArea = createColumn(
		"placeTextArea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> filesDownload = createColumn(
		"filesDownload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> publicationDate = createColumn(
		"publicationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> expirationDate = createColumn(
		"expirationDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> extensionDate = createColumn(
		"extensionDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> quotaSignature = createColumn(
		"quotaSignature", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> inTheNameOf = createColumn(
		"inTheNameOf", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnaireLastname =
		createColumn(
			"petitionnaireLastname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnaireFirstname =
		createColumn(
			"petitionnaireFirstname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Date> petitionnaireBirthday =
		createColumn(
			"petitionnaireBirthday", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnaireAdresse =
		createColumn(
			"petitionnaireAdresse", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> petitionnairePostalCode =
		createColumn(
			"petitionnairePostalCode", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnaireCity = createColumn(
		"petitionnaireCity", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnairePhone =
		createColumn(
			"petitionnairePhone", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> petitionnaireEmail =
		createColumn(
			"petitionnaireEmail", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Boolean> isSupported = createColumn(
		"isSupported", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> supportedBy = createColumn(
		"supportedBy", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> videoUrl = createColumn(
		"videoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> externalImageURL = createColumn(
		"externalImageURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> externalImageCopyright =
		createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Boolean> mediaChoice = createColumn(
		"mediaChoice", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PetitionTable, String> filesIds = createColumn(
		"filesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PetitionTable() {
		super("project_Petition", PetitionTable::new);
	}

}