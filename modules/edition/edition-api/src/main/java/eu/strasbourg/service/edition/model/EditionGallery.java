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
 * The extended model interface for the EditionGallery service. Represents a row in the &quot;edition_EditionGallery&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see EditionGalleryModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.edition.model.impl.EditionGalleryImpl"
)
@ProviderType
public interface EditionGallery extends EditionGalleryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.edition.model.impl.EditionGalleryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EditionGallery, Long> GALLERY_ID_ACCESSOR =
		new Accessor<EditionGallery, Long>() {

			@Override
			public Long get(EditionGallery editionGallery) {
				return editionGallery.getGalleryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EditionGallery> getTypeClass() {
				return EditionGallery.class;
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
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Renvoie la liste des éditions de la galerie
	 */
	public java.util.List<Edition> getEditions();

	/**
	 * Renvoie la liste des ids des éditions de la galerie sous forme de String
	 */
	public String getEditionsIds();

	/**
	 * Retourne les types de la galerie d'éditions
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne le texte à afficher pour les types de la galerie d'éditions
	 */
	public String getTypesLabels(java.util.Locale locale);

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	public java.util.List<Edition> getPublishedEditions();

	/**
	 * Renvoie la version live de la galerie d'édition, si elle existe
	 */
	public EditionGallery getLiveVersion();

	/**
	 * Retourne la version JSON de la galerie
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}