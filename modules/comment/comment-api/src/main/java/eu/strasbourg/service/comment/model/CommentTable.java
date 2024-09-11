/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;comment_Comment&quot; database table.
 *
 * @author Romain Vergnais
 * @see Comment
 * @generated
 */
public class CommentTable extends BaseTable<CommentTable> {

	public static final CommentTable INSTANCE = new CommentTable();

	public final Column<CommentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> commentId = createColumn(
		"commentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CommentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Clob> text = createColumn(
		"text_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Integer> level = createColumn(
		"level", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> userQuality = createColumn(
		"userQuality", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Date> modifiedByUserDate = createColumn(
		"modifiedByUserDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> assetEntryId = createColumn(
		"assetEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, String> publikId = createColumn(
		"publikId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Long> parentCommentId = createColumn(
		"parentCommentId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CommentTable, Clob> urlProjectCommentaire =
		createColumn(
			"urlProjectCommentaire", Clob.class, Types.CLOB,
			Column.FLAG_DEFAULT);

	private CommentTable() {
		super("comment_Comment", CommentTable::new);
	}

}