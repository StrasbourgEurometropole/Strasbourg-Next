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
 * The extended model interface for the Manifestation service. Represents a row in the &quot;agenda_Manifestation&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see ManifestationModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.ManifestationImpl"
)
@ProviderType
public interface Manifestation extends ManifestationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.ManifestationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Manifestation, Long>
		MANIFESTATION_ID_ACCESSOR = new Accessor<Manifestation, Long>() {

			@Override
			public Long get(Manifestation manifestation) {
				return manifestation.getManifestationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Manifestation> getTypeClass() {
				return Manifestation.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattachée cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Renvoie la liste des éditions de la galerie
	 */
	public java.util.List<Event> getEvents();

	/**
	 * Renvoie la liste des ids des éditions de la galerie sous forme de String
	 */
	public String getEventsIds();

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	public java.util.List<Event> getPublishedEvents();

	/**
	 * Retourne la période principale de la manifestation sous forme de String
	 * dans la locale passée en paramètre
	 */
	public String getManifestationScheduleDisplay(java.util.Locale locale);

	/**
	 * Renvoie la version live de la manifestation, si elle existe
	 */
	public Manifestation getLiveVersion();

	/**
	 * Retourne les types de la manifestation
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le label des types de l'événement
	 */
	public String getTypeLabel(java.util.Locale locale);

	/**
	 * Retourne les themes de la manifestation
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes();

	/**
	 * Retourne le label des themes de l'événement
	 */
	public String getThemeLabel(java.util.Locale locale);

	/**
	 * Retourne les publics de la manifestation
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne le label des publics de l'événement
	 */
	public String getPublicLabel(java.util.Locale locale);

	/**
	 * Retourne les territoires de la manifestation
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getServices();

	/**
	 * Renvoie la version JSON de la manifestation
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}