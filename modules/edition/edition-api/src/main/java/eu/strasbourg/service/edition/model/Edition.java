/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Edition service. Represents a row in the &quot;edition_Edition&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see EditionModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.edition.model.impl.EditionImpl")
@ProviderType
public interface Edition extends EditionModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.edition.model.impl.EditionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Edition, Long> EDITION_ID_ACCESSOR =
		new Accessor<Edition, Long>() {

			@Override
			public Long get(Edition edition) {
				return edition.getEditionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Edition> getTypeClass() {
				return Edition.class;
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
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Renvoie la liste des galleries auxquelles cette édition appartient
	 */
	public java.util.List<EditionGallery> getEditionGalleries();

	/**
	 * Renvoie la liste des IDs des galleries auxquelles cette édition
	 * appartient sous forme de String
	 */
	public String getEditionGalleriesIds();

	/**
	 * Renvoie la liste des galeries publiées
	 */
	public java.util.List<EditionGallery> getPublishedEditionGalleries();

	/**
	 * Renvoie l'URL de téléchargement du fichier (que ce soit un FileEntry ou
	 * une URL externe)
	 */
	public String getFileDownloadURL(java.util.Locale locale);

	/**
	 * Retourne le nom du fichier si un fichier uploadé est lié à l'édition, le titre de l'édition sinon
	 */
	public String getFileTitle(java.util.Locale locale);

	/**
	 * Renvoie la taille du fichier sous forme de String
	 */
	public String getFileSize(java.util.Locale locale);

	/**
	 * Renovie le type du fichier sous forme de String (si c'est une FileEntry -
	 * renvoie une chaîne vide si c'est une URL externe)
	 */
	public String getFileType(java.util.Locale locale);

	/**
	 * Renvoie la version live de l'édition, si elle existe
	 */
	public Edition getLiveVersion();

	/**
	 * Retourne les sources de l'édition
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getSources();

	/**
	 * Retourne les types de l'édition
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le texte à afficher pour les types de l'édition
	 */
	public String getTypesLabels(java.util.Locale locale);

	/**
	 * Retourne les musées de l'édition
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getMuseums();

	/**
	 * Retourne le(s) label(s) du/des musées de l'édition
	 */
	public String getMuseumsLabel(java.util.Locale locale);

	/**
	 * Retourne la version JSON de l'édition
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}