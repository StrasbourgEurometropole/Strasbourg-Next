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
 * The extended model interface for the CsmapCacheJson service. Represents a row in the &quot;place_CsmapCacheJson&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see CsmapCacheJsonModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.place.model.impl.CsmapCacheJsonImpl"
)
@ProviderType
public interface CsmapCacheJson extends CsmapCacheJsonModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.CsmapCacheJsonImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CsmapCacheJson, String> SIG_ID_ACCESSOR =
		new Accessor<CsmapCacheJson, String>() {

			@Override
			public String get(CsmapCacheJson csmapCacheJson) {
				return csmapCacheJson.getSigId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<CsmapCacheJson> getTypeClass() {
				return CsmapCacheJson.class;
			}

		};

}