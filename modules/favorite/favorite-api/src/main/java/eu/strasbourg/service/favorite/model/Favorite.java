/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Favorite service. Represents a row in the &quot;favorite_Favorite&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see FavoriteModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.favorite.model.impl.FavoriteImpl"
)
@ProviderType
public interface Favorite extends FavoriteModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.favorite.model.impl.FavoriteImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Favorite, Long> FAVORITE_ID_ACCESSOR =
		new Accessor<Favorite, Long>() {

			@Override
			public Long get(Favorite favorite) {
				return favorite.getFavoriteId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Favorite> getTypeClass() {
				return Favorite.class;
			}

		};

	public boolean hasAssetEntry();

	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	public eu.strasbourg.service.favorite.model.FavoriteType getFavoriteType();

	public boolean isOnDashboard();

	/**
	 * Retourne la version JSON d'un favoris
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}