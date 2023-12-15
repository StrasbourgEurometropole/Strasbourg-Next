/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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