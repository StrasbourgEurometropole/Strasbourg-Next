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
 * The extended model interface for the GoogleMyBusinessHistoric service. Represents a row in the &quot;place_GoogleMyBusinessHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoricModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricImpl"
)
@ProviderType
public interface GoogleMyBusinessHistoric
	extends GoogleMyBusinessHistoricModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GoogleMyBusinessHistoric, Long>
		GOOGLE_MY_BUSINESS_HISTORIC_ID_ACCESSOR =
			new Accessor<GoogleMyBusinessHistoric, Long>() {

				@Override
				public Long get(
					GoogleMyBusinessHistoric googleMyBusinessHistoric) {

					return googleMyBusinessHistoric.
						getGoogleMyBusinessHistoricId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<GoogleMyBusinessHistoric> getTypeClass() {
					return GoogleMyBusinessHistoric.class;
				}

			};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Renvoie le label affichable du resultat de google mybusiness
	 *
	 * @return
	 */
	public String getResultLabel();

	/**
	 * Ajout d'une ligne dans le resultat de google mybusiness
	 *
	 * @return
	 */
	public void addNewOperation(String operation);

	/**
	 * Envoi du mail d'envoi
	 */
	public void sendMail();

}