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
 * The table class for the &quot;project_SaisineObservatoire&quot; database table.
 *
 * @author Cedric Henry
 * @see SaisineObservatoire
 * @generated
 */
public class SaisineObservatoireTable
	extends BaseTable<SaisineObservatoireTable> {

	public static final SaisineObservatoireTable INSTANCE =
		new SaisineObservatoireTable();

	public final Column<SaisineObservatoireTable, Long> saisineObservatoireId =
		createColumn(
			"saisineObservatoireId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<SaisineObservatoireTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Clob> description =
		createColumn(
			"description", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> placeTextArea =
		createColumn(
			"placeTextArea", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> filesDownload =
		createColumn(
			"filesDownload", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Clob> cityResponse =
		createColumn(
			"cityResponse", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> projectTarget =
		createColumn(
			"projectTarget", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> otherMechanism =
		createColumn(
			"otherMechanism", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> collectiveName =
		createColumn(
			"collectiveName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String>
		petitionnaireLastname = createColumn(
			"petitionnaireLastname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String>
		petitionnaireFirstname = createColumn(
			"petitionnaireFirstname", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Date> petitionnaireBirthday =
		createColumn(
			"petitionnaireBirthday", Date.class, Types.TIMESTAMP,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> petitionnaireAdresse =
		createColumn(
			"petitionnaireAdresse", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Long>
		petitionnairePostalCode = createColumn(
			"petitionnairePostalCode", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> petitionnaireCity =
		createColumn(
			"petitionnaireCity", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> petitionnairePhone =
		createColumn(
			"petitionnairePhone", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> petitionnaireEmail =
		createColumn(
			"petitionnaireEmail", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> videoUrl =
		createColumn(
			"videoUrl", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> externalImageURL =
		createColumn(
			"externalImageURL", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String>
		externalImageCopyright = createColumn(
			"externalImageCopyright", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Boolean> mediaChoice =
		createColumn(
			"mediaChoice", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> publikId =
		createColumn(
			"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<SaisineObservatoireTable, String> filesIds =
		createColumn(
			"filesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private SaisineObservatoireTable() {
		super("project_SaisineObservatoire", SaisineObservatoireTable::new);
	}

}