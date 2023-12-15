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
 * The extended model interface for the Agency service. Represents a row in the &quot;gtfs_Agency&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see AgencyModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.AgencyImpl")
@ProviderType
public interface Agency extends AgencyModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.AgencyImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Agency, Long> ID_ACCESSOR =
		new Accessor<Agency, Long>() {

			@Override
			public Long get(Agency agency) {
				return agency.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Agency> getTypeClass() {
				return Agency.class;
			}

		};

}