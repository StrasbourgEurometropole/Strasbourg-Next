/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Campaign service. Represents a row in the &quot;agenda_Campaign&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see CampaignModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.agenda.model.impl.CampaignImpl")
@ProviderType
public interface Campaign extends CampaignModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.CampaignImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Campaign, Long> CAMPAIGN_ID_ACCESSOR =
		new Accessor<Campaign, Long>() {

			@Override
			public Long get(Campaign campaign) {
				return campaign.getCampaignId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Campaign> getTypeClass() {
				return Campaign.class;
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
	 * Retourne les themes de la campagne
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes();

	/**
	 * Retourne les types de la campagne
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne true si l'utilisateur passé en paramètre est manager de la
	 * campagne
	 */
	public boolean isManagedByUser(long userId);

	public java.util.List<com.liferay.portal.kernel.model.User> getManagers();

	/**
	 * Retourne la liste des événements de la campagne
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.CampaignEvent>
		getEvents();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getDefaultImageURL();

	/**
	 * Génère l'export et place le fichier dans le dossier d'import des
	 * événements
	 */
	public void export();

	/**
	 * Génère l'export JSON
	 */
	public com.liferay.portal.kernel.json.JSONObject generateExport();

}