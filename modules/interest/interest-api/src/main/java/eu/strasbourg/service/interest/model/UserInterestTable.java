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