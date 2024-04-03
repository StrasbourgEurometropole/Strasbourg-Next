/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.like.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Like service. Represents a row in the &quot;like_Like&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see LikeModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.like.model.impl.LikeImpl")
@ProviderType
public interface Like extends LikeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.like.model.impl.LikeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Like, Long> LIKE_ID_ACCESSOR =
		new Accessor<Like, Long>() {

			@Override
			public Long get(Like like) {
				return like.getLikeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Like> getTypeClass() {
				return Like.class;
			}

		};

	public eu.strasbourg.service.like.model.LikeType getLikeType();

	/**
	 * Retourne la version JSON d'un like/dislike
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}