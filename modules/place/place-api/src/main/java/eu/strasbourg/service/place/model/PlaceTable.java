/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Clob;
import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;place_Place&quot; database table.
 *
 * @author Angelique Zunino Champougny
 * @see Place
 * @generated
 */
public class PlaceTable extends BaseTable<PlaceTable> {

	public static final PlaceTable INSTANCE = new PlaceTable();

	public final Column<PlaceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> placeId = createColumn(
		"placeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<PlaceTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Date> lastPublishDate = createColumn(
		"lastPublishDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Integer> status = createColumn(
		"status", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> statusByUserId = createColumn(
		"statusByUserId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> statusByUserName = createColumn(
		"statusByUserName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Date> statusDate = createColumn(
		"statusDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> SIGid = createColumn(
		"SIGid", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> addressComplement = createColumn(
		"addressComplement", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> addressStreet = createColumn(
		"addressStreet", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> addressDistribution = createColumn(
		"addressDistribution", String.class, Types.VARCHAR,
		Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> addressZipCode = createColumn(
		"addressZipCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> addressCountry = createColumn(
		"addressCountry", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> mercatorX = createColumn(
		"mercatorX", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> mercatorY = createColumn(
		"mercatorY", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<PlaceTable, String> RGF93X = createColumn(
		"RGF93X", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<PlaceTable, String> RGF93Y = createColumn(
		"RGF93Y", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<PlaceTable, String> locationId = createColumn(
		"locationId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> alias = createColumn(
		"alias_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> presentation = createColumn(
		"presentation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> serviceAndActivities = createColumn(
		"serviceAndActivities", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> characteristics = createColumn(
		"characteristics", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> subjectToPublicHoliday =
		createColumn(
			"subjectToPublicHoliday", Boolean.class, Types.BOOLEAN,
			Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> exceptionalSchedule = createColumn(
		"exceptionalSchedule", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> displayEvents = createColumn(
		"displayEvents", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> additionalInformation = createColumn(
		"additionalInformation", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> contenuTooltipCarto = createColumn(
		"contenuTooltipCarto", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> hasURLSchedule = createColumn(
		"hasURLSchedule", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> scheduleLinkName = createColumn(
		"scheduleLinkName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> scheduleLinkURL = createColumn(
		"scheduleLinkURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> phone = createColumn(
		"phone", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> mail = createColumn(
		"mail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> siteURL = createColumn(
		"siteURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> siteLabel = createColumn(
		"siteLabel", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> bookingURL = createColumn(
		"bookingURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> facebookURL = createColumn(
		"facebookURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> facebookLabel = createColumn(
		"facebookLabel", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> instagramURL = createColumn(
		"instagramURL", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> instagramLabel = createColumn(
		"instagramLabel", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> accesMap = createColumn(
		"accesMap", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> access = createColumn(
		"access_", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Clob> accessForDisabled = createColumn(
		"accessForDisabled", Clob.class, Types.CLOB, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> accessForBlind = createColumn(
		"accessForBlind", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> accessForDeaf = createColumn(
		"accessForDeaf", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> accessForWheelchair = createColumn(
		"accessForWheelchair", Boolean.class, Types.BOOLEAN,
		Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> accessForElder = createColumn(
		"accessForElder", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> accessForDeficient = createColumn(
		"accessForDeficient", Boolean.class, Types.BOOLEAN,
		Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Boolean> RTEnabled = createColumn(
		"RTEnabled", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> RTType = createColumn(
		"RTType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> RTExternalId = createColumn(
		"RTExternalId", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> RTAvailable = createColumn(
		"RTAvailable", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> RTOccupation = createColumn(
		"RTOccupation", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> RTCapacity = createColumn(
		"RTCapacity", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> RTStatus = createColumn(
		"RTStatus", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Date> RTLastUpdate = createColumn(
		"RTLastUpdate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Integer> imageWidth = createColumn(
		"imageWidth", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Integer> imageHeight = createColumn(
		"imageHeight", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> imageIds = createColumn(
		"imageIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> videosIds = createColumn(
		"videosIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, Long> priceId = createColumn(
		"priceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<PlaceTable, String> documentsIds = createColumn(
		"documentsIds", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private PlaceTable() {
		super("place_Place", PlaceTable::new);
	}

}