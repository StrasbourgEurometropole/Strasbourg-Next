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
 * The extended model interface for the Trip service. Represents a row in the &quot;gtfs_Trip&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see TripModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.TripImpl")
@ProviderType
public interface Trip extends PersistedModel, TripModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.TripImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Trip, Long> ID_ACCESSOR =
		new Accessor<Trip, Long>() {

			@Override
			public Long get(Trip trip) {
				return trip.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Trip> getTypeClass() {
				return Trip.class;
			}

		};

}