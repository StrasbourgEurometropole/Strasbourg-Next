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

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;formSendRecordField_FormSendRecordField&quot; database table.
 *
 * @author Angélique Zunino
 * @see FormSendRecordField
 * @generated
 */
public class FormSendRecordFieldTable
	extends BaseTable<FormSendRecordFieldTable> {

	public static final FormSendRecordFieldTable INSTANCE =
		new FormSendRecordFieldTable();

	public final Column<FormSendRecordFieldTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> formSendRecordFieldId =
		createColumn(
			"formSendRecordFieldId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<FormSendRecordFieldTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Integer> status =
		createColumn(
			"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> statusByUserId =
		createColumn(
			"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, String> statusByUserName =
		createColumn(
			"statusByUserName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Date> statusDate =
		createColumn(
			"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Clob> response = createColumn(
		"response", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> assetEntryId =
		createColumn(
			"assetEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> contentId =
		createColumn(
			"contentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, String> instanceId =
		createColumn(
			"instanceId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FormSendRecordFieldTable, Long> responseUserId =
		createColumn(
			"responseUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FormSendRecordFieldTable() {
		super(
			"formSendRecordField_FormSendRecordField",
			FormSendRecordFieldTable::new);
	}

}