/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.activity.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Practice service. Represents a row in the &quot;activity_Practice&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PracticeModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.PracticeImpl"
)
@ProviderType
public interface Practice extends PersistedModel, PracticeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.PracticeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Practice, Long> PRACTICE_ID_ACCESSOR =
		new Accessor<Practice, Long>() {

			@Override
			public Long get(Practice practice) {
				return practice.getPracticeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Practice> getTypeClass() {
				return Practice.class;
			}

		};

	/**
	 * Retourne la version live de cette entité
	 */
	public Practice getLiveVersion();

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne les activités de l'association
	 */
	public Association getAssociation();

	/**
	 * Retourne la pratique de l'association
	 */
	public com.liferay.asset.kernel.model.AssetCategory getPractice();

	/**
	 * Retourne les publics de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne les quartiers de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistricts();

	/**
	 * Retourne l'accessibilité de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getAccessibilities();

}