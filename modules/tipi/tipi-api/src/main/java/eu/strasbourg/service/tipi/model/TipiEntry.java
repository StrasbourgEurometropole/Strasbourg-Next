/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TipiEntry service. Represents a row in the &quot;tipi_TipiEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntryModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.tipi.model.impl.TipiEntryImpl")
@ProviderType
public interface TipiEntry extends PersistedModel, TipiEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.tipi.model.impl.TipiEntryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TipiEntry, Long> ID_ACCESSOR =
		new Accessor<TipiEntry, Long>() {

			@Override
			public Long get(TipiEntry tipiEntry) {
				return tipiEntry.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TipiEntry> getTypeClass() {
				return TipiEntry.class;
			}

		};

}