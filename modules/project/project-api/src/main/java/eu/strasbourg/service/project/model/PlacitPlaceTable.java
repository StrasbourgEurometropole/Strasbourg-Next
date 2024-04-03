/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;project_PlacitPlace&quot; database table.
 *
 * @author Cedric Henry
 * @see PlacitPlace
 * @generated
 */
public class PlacitPlaceTable extends BaseTable<PlacitPlaceTable> {

	public static final PlacitPlaceTable INSTANCE = new PlacitPlaceTable();

	public final Column<PlacitPlaceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> placitPlaceId = createColumn(
		"placitPlaceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PlacitPlaceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> placeName = createColumn(
		"placeName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> placeStreetNumber =
		createColumn(
			"placeStreetNumber", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> placeStreetName =
		createColumn(
			"placeStreetName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> placeZipCode = createColumn(
		"placeZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> placeCityId = createColumn(
		"placeCityId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> projectId = createColumn(
		"projectId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> participationId = createColumn(
		"participationId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> petitionId = createColumn(
		"petitionId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> saisineObservatoireId =
		createColumn(
			"saisineObservatoireId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> budgetParticipatifId =
		createColumn(
			"budgetParticipatifId", Long.class, Types.BIGINT,
			Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, Long> initiativeId = createColumn(
		"initiativeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlacitPlaceTable, String> placeSIGId = createColumn(
		"placeSIGId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PlacitPlaceTable() {
		super("project_PlacitPlace", PlacitPlaceTable::new);
	}

}