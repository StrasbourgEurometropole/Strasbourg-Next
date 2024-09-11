/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;interest_UserInterest&quot; database table.
 *
 * @author BenjaminBini
 * @see UserInterest
 * @generated
 */
public class UserInterestTable extends BaseTable<UserInterestTable> {

	public static final UserInterestTable INSTANCE = new UserInterestTable();

	public final Column<UserInterestTable, Long> interestId = createColumn(
		"interestId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserInterestTable, String> publikUserId = createColumn(
		"publikUserId", String.class, Types.VARCHAR, Column.FLAG_PRIMARY);

	private UserInterestTable() {
		super("interest_UserInterest", UserInterestTable::new);
	}

}