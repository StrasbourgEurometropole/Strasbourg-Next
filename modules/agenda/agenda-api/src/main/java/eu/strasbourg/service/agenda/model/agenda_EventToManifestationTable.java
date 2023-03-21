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

package eu.strasbourg.service.agenda.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;agenda_EventToManifestation&quot; database table.
 *
 * @author BenjaminBini
 * @see Event
 * @see Manifestation
 * @generated
 */
public class agenda_EventToManifestationTable
	extends BaseTable<agenda_EventToManifestationTable> {

	public static final agenda_EventToManifestationTable INSTANCE =
		new agenda_EventToManifestationTable();

	public final Column<agenda_EventToManifestationTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<agenda_EventToManifestationTable, Long> eventId =
		createColumn("eventId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<agenda_EventToManifestationTable, Long>
		manifestationId = createColumn(
			"manifestationId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);

	private agenda_EventToManifestationTable() {
		super(
			"agenda_EventToManifestation",
			agenda_EventToManifestationTable::new);
	}

}