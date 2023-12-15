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
 * The extended model interface for the Stop service. Represents a row in the &quot;gtfs_Stop&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see StopModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.StopImpl")
@ProviderType
public interface Stop extends PersistedModel, StopModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.StopImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Stop, Long> ID_ACCESSOR =
		new Accessor<Stop, Long>() {

			@Override
			public Long get(Stop stop) {
				return stop.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Stop> getTypeClass() {
				return Stop.class;
			}

		};

}