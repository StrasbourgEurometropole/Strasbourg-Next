/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Calendar service. Represents a row in the &quot;gtfs_Calendar&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see CalendarModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.CalendarImpl")
@ProviderType
public interface Calendar extends CalendarModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.CalendarImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Calendar, Long> ID_ACCESSOR =
		new Accessor<Calendar, Long>() {

			@Override
			public Long get(Calendar calendar) {
				return calendar.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Calendar> getTypeClass() {
				return Calendar.class;
			}

		};

}