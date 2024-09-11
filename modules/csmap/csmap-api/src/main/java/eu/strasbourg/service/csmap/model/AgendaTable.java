/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;csmap_Agenda&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Agenda
 * @generated
 */
public class AgendaTable extends BaseTable<AgendaTable> {

	public static final AgendaTable INSTANCE = new AgendaTable();

	public final Column<AgendaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Long> agendaId = createColumn(
		"agendaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AgendaTable, String> title = createColumn(
		"title", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> editorialTitle = createColumn(
		"editorialTitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> subtitle = createColumn(
		"subtitle", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> labelLink = createColumn(
		"labelLink", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> link = createColumn(
		"link", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Date> publicationStartDate = createColumn(
		"publicationStartDate", Date.class, Types.TIMESTAMP,
		Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Date> publicationEndDate = createColumn(
		"publicationEndDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Boolean> isPrincipal = createColumn(
		"isPrincipal", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, Boolean> isActive = createColumn(
		"isActive", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> campaignsIds = createColumn(
		"campaignsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> themesIds = createColumn(
		"themesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> typesIds = createColumn(
		"typesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> territoriesIds = createColumn(
		"territoriesIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AgendaTable, String> tags = createColumn(
		"tags", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AgendaTable() {
		super("csmap_Agenda", AgendaTable::new);
	}

}