/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Interest service. Represents a row in the &quot;interest_Interest&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see InterestModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.interest.model.impl.InterestImpl"
)
@ProviderType
public interface Interest extends InterestModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.interest.model.impl.InterestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Interest, Long> INTEREST_ID_ACCESSOR =
		new Accessor<Interest, Long>() {

			@Override
			public Long get(Interest interest) {
				return interest.getInterestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Interest> getTypeClass() {
				return Interest.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne le type du centre d'intérêt
	 */
	public com.liferay.asset.kernel.model.AssetCategory getType();

	/**
	 * Retourne la version JSON du centre d'intérêt
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}