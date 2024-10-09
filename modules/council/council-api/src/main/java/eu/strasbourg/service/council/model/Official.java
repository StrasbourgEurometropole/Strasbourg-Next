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
 * The extended model interface for the Official service. Represents a row in the &quot;council_Official&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OfficialModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.council.model.impl.OfficialImpl"
)
@ProviderType
public interface Official extends OfficialModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.council.model.impl.OfficialImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Official, Long> OFFICIAL_ID_ACCESSOR =
		new Accessor<Official, Long>() {

			@Override
			public Long get(Official official) {
				return official.getOfficialId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Official> getTypeClass() {
				return Official.class;
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

	/**
	 * Renvoie le nom de complet au format "Prénom NOM"
	 */
	public String getFullName();

	/**
	 * Renvoie si l'electeur est noté absent pour la session données
	 */
	public boolean isNotedAbsent(long councilSessionId);

	/**
	 * Renvoie le statut de connection de l'utilisateur
	 *
	 * @return True si la dernière connection date de moins de 15sec
	 */
	public boolean isConnected();

	/**
	 * Renvoie les types de conseil rattachés à cet élu
	 */
	public java.util.List<Type> getCouncilTypes();

	/**
	 * Renvoie un strind 'id types de conseil rattachés à cet élu
	 */
	public String getCouncilTypesIds();

	/**
	 * Renvoie l'élu au format JSON
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}