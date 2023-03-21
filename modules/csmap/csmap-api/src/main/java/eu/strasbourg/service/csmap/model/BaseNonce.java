/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
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