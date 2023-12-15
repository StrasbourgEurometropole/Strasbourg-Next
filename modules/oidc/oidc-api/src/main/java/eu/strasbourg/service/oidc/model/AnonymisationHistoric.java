/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.oidc.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AnonymisationHistoric service. Represents a row in the &quot;publik_AnonymisationHistoric&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AnonymisationHistoricModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.oidc.model.impl.AnonymisationHistoricImpl"
)
@ProviderType
public interface AnonymisationHistoric
	extends AnonymisationHistoricModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.oidc.model.impl.AnonymisationHistoricImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnonymisationHistoric, Long>
		ANONYMISATION_HISTORIC_ID_ACCESSOR =
			new Accessor<AnonymisationHistoric, Long>() {

				@Override
				public Long get(AnonymisationHistoric anonymisationHistoric) {
					return anonymisationHistoric.getAnonymisationHistoricId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AnonymisationHistoric> getTypeClass() {
					return AnonymisationHistoric.class;
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
	 * Renvoie le label affichable du resultat de l'anonymisation
	 *
	 * @return
	 */
	public String getResultLabel();

	/**
	 * Ajout d'une ligne dans le resultat de l'anonymisation
	 *
	 * @return
	 */
	public void addNewOperation(String operation);

	/**
	 * Envoi du mail d'import
	 */
	public void sendMail();

}