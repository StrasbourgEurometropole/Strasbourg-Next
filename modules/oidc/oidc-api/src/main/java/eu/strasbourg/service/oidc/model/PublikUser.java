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

package eu.strasbourg.service.oidc.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PublikUser service. Represents a row in the &quot;publik_PublikUser&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PublikUserModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.oidc.model.impl.PublikUserImpl")
@ProviderType
public interface PublikUser extends PersistedModel, PublikUserModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.oidc.model.impl.PublikUserImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PublikUser, Long>
		PUBLIK_USER_LIFERAY_ID_ACCESSOR = new Accessor<PublikUser, Long>() {

			@Override
			public Long get(PublikUser publikUser) {
				return publikUser.getPublikUserLiferayId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PublikUser> getTypeClass() {
				return PublikUser.class;
			}

		};

	/**
	 * L'utilisateur est-il en perdiode de bannissement ?
	 */
	public boolean isBanned();

	/**
	 * Retourne l'image de profil ou le substitut
	 */
	public String getImageURLOrSurrogate();

}