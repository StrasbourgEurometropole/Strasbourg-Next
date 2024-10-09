/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Arret service. Represents a row in the &quot;gtfs_Arret&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see ArretModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.gtfs.model.impl.ArretImpl")
@ProviderType
public interface Arret extends ArretModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.ArretImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Arret, Long> ARRET_ID_ACCESSOR =
		new Accessor<Arret, Long>() {

			@Override
			public Long get(Arret arret) {
				return arret.getArretId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Arret> getTypeClass() {
				return Arret.class;
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
	 * Renvoie la liste des Directions de cet arret
	 */
	public java.util.List<Direction> getDirections();

	/**
	 * Renvoie la liste des Alertes de cet arret
	 */
	public java.util.List<Alert> getAlerts();

	/**
	 * Renvoie la liste des Alertes en cours ou à venir de cet arret
	 */
	public java.util.List<Alert> getAlertsActives();

	/**
	 * Renvoie le count des Alertes en cours ou à venir de cet arret
	 */
	public long getCountAlertsActives();

	/**
	 * Renvoie la correspondance du type d'arret en format texte
	 */
	public String getTypeText();

	/**
	 * Renvoie les directions sans doublon de lignes shortName, [bgColor, textColor, destinationName]
	 */
	public java.util.Map<String, String[]> getDirectionsUniques();

	/**
	 * Renvoie les prochains passages
	 */
	public java.util.List<com.liferay.portal.kernel.json.JSONObject>
		getArretRealTime();

	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	public com.liferay.portal.kernel.json.JSONObject getGeoJSON(
		long groupId, java.util.Locale locale);

}