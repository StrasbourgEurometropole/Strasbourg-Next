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
 * The extended model interface for the StopTime service. Represents a row in the &quot;gtfs_StopTime&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see StopTimeModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.StopTimeImpl")
@ProviderType
public interface StopTime extends PersistedModel, StopTimeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.StopTimeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<StopTime, Long> ID_ACCESSOR =
		new Accessor<StopTime, Long>() {

			@Override
			public Long get(StopTime stopTime) {
				return stopTime.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<StopTime> getTypeClass() {
				return StopTime.class;
			}

		};

}