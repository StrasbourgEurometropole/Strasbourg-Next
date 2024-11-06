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
 * The extended model interface for the PublicHoliday service. Represents a row in the &quot;place_PublicHoliday&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see PublicHolidayModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.place.model.impl.PublicHolidayImpl"
)
@ProviderType
public interface PublicHoliday extends PersistedModel, PublicHolidayModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.PublicHolidayImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PublicHoliday, Long>
		PUBLIC_HOLIDAY_ID_ACCESSOR = new Accessor<PublicHoliday, Long>() {

			@Override
			public Long get(PublicHoliday publicHoliday) {
				return publicHoliday.getPublicHolidayId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PublicHoliday> getTypeClass() {
				return PublicHoliday.class;
			}

		};

	/**
	 * Retourne la version JSON des jours fériés
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}