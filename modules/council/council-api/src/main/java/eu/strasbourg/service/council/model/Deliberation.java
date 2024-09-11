/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Deliberation service. Represents a row in the &quot;council_Deliberation&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DeliberationModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.council.model.impl.DeliberationImpl"
)
@ProviderType
public interface Deliberation extends DeliberationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.council.model.impl.DeliberationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Deliberation, Long> DELIBERATION_ID_ACCESSOR =
		new Accessor<Deliberation, Long>() {

			@Override
			public Long get(Deliberation deliberation) {
				return deliberation.getDeliberationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Deliberation> getTypeClass() {
				return Deliberation.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	public eu.strasbourg.service.council.model.CouncilSession
		getCouncilSession();

	public String getOrderAmendement();

	public boolean isCree();

	public boolean isAffichageEnCours();

	public boolean isVoteOuvert();

	public boolean isAdopte();

	public boolean isRejete();

	public boolean isCommunique();

	public boolean isRetire();

}