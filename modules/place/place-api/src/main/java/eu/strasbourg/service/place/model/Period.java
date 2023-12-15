/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Period service. Represents a row in the &quot;place_Period&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see PeriodModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.place.model.impl.PeriodImpl")
@ProviderType
public interface Period extends PeriodModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.PeriodImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Period, Long> PERIOD_ID_ACCESSOR =
		new Accessor<Period, Long>() {

			@Override
			public Long get(Period period) {
				return period.getPeriodId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Period> getTypeClass() {
				return Period.class;
			}

		};

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	public java.util.List<eu.strasbourg.service.place.model.Slot> getAllSlots();

	/**
	 * Retourne les Slots de la période pour un lieu
	 */
	public java.util.List<eu.strasbourg.service.place.model.Slot> getSlots();

	/**
	 * Retourne les Slots de la période pour un sous-lieu
	 */
	public java.util.List<eu.strasbourg.service.place.model.Slot> getSlots(
		long subPlaceId);

	/**
	 * Retourne la liste des horaires par jour (0 = lundi, 1 = mardi, etc.)
	 */
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getWeekSchedule();

	/**
	 * Retourne la liste des horaires par jour pour le sous lieu (0 = lundi, 1 = mardi, etc.)
	 */
	public java.util.List<eu.strasbourg.service.place.model.PlaceSchedule>
		getWeekSchedule(long subPlaceId);

	public String getDisplay(java.util.Locale locale);

	/**
	 * Retourne la version JSON de la période
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}