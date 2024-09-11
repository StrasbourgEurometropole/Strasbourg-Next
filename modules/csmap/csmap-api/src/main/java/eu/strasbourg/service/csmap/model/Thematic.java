/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Thematic service. Represents a row in the &quot;csmap_Thematic&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ThematicModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.csmap.model.impl.ThematicImpl")
@ProviderType
public interface Thematic extends PersistedModel, ThematicModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.csmap.model.impl.ThematicImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Thematic, Long> THEMATIC_ID_ACCESSOR =
		new Accessor<Thematic, Long>() {

			@Override
			public Long get(Thematic thematic) {
				return thematic.getThematicId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Thematic> getTypeClass() {
				return Thematic.class;
			}

		};

}