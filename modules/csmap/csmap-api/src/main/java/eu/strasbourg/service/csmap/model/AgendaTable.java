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