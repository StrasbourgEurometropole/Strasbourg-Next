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

package eu.strasbourg.service.formSendRecordField.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;formSendRecordField_FormSendRecordFieldSignalement&quot; database table.
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldSignalement
 * @generated
 */
public class FormSendRecordFieldSignalementTable
	extends BaseTable<FormSendRecordFieldSignalementTable> {

	public static final FormSendRecordFieldSignalementTable INSTANCE =
		new FormSendRecordFieldSignalementTable();

	public final Column<FormSendRecordFieldSignalementTable, String> uuid =
		createColumn("uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Long>
		signalementId = createColumn(
			"signalementId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FormSendRecordFieldSignalementTable, Long> groupId =
		createColumn("groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Date>
		modifiedDate = createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Long>
		statusByUserId = createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, String>
		statusByUserName = createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, Long>
		formSendRecordFieldId = createColumn(
			"formSendRecordFieldId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldSignalementTable, String> publikId =
		createColumn(
			"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FormSendRecordFieldSignalementTable() {
		super(
			"formSendRecordField_FormSendRecordFieldSignalement",
			FormSendRecordFieldSignalementTable::new);
	}

}