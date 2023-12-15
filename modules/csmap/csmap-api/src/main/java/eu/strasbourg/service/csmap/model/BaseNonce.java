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
 * The extended model interface for the BaseNonce service. Represents a row in the &quot;csmap_BaseNonce&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonceModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.csmap.model.impl.BaseNonceImpl")
@ProviderType
public interface BaseNonce extends BaseNonceModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.csmap.model.impl.BaseNonceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BaseNonce, Long> BASE_NONCE_ID_ACCESSOR =
		new Accessor<BaseNonce, Long>() {

			@Override
			public Long get(BaseNonce baseNonce) {
				return baseNonce.getBaseNonceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BaseNonce> getTypeClass() {
				return BaseNonce.class;
			}

		};

}