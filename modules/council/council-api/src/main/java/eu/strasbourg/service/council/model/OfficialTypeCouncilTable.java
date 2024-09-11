/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;council_OfficialTypeCouncil&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see OfficialTypeCouncil
 * @generated
 */
public class OfficialTypeCouncilTable
	extends BaseTable<OfficialTypeCouncilTable> {

	public static final OfficialTypeCouncilTable INSTANCE =
		new OfficialTypeCouncilTable();

	public final Column<OfficialTypeCouncilTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OfficialTypeCouncilTable, Long> officialId =
		createColumn(
			"officialId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfficialTypeCouncilTable, Long> typeId = createColumn(
		"typeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OfficialTypeCouncilTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTypeCouncilTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<OfficialTypeCouncilTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<OfficialTypeCouncilTable, String> result = createColumn(
		"result", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private OfficialTypeCouncilTable() {
		super("council_OfficialTypeCouncil", OfficialTypeCouncilTable::new);
	}

}