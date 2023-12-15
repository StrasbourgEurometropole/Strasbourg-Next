/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.artwork.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Artwork service. Represents a row in the &quot;artwork_Artwork&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see ArtworkModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.artwork.model.impl.ArtworkImpl")
@ProviderType
public interface Artwork extends ArtworkModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.artwork.model.impl.ArtworkImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Artwork, Long> ARTWORK_ID_ACCESSOR =
		new Accessor<Artwork, Long>() {

			@Override
			public Long get(Artwork artwork) {
				return artwork.getArtworkId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Artwork> getTypeClass() {
				return Artwork.class;
			}

		};

	/**
	 * Retourne l'AssetEntry correspondant à cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des AssetCategory correspondant à cet item (via
	 * l'AssetEntry)
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
	 * Retourne la légende de l'image principale
	 */
	public String getImageLegend(java.util.Locale locale);

	/**
	 * Retourne la légende de l'image principale suivie de son copyright
	 */
	public String getImageLegendAndCopyright(java.util.Locale locale);

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	public java.util.List<String> getImagesURLs();

	/**
	 * Retourne la liste des URL publiques des images additionnelles
	 */
	public java.util.List<String> getImagesLegendsAndCopyrights(
		java.util.Locale locale);

	/**
	 * Retourne la liste des collections d'oeuvres
	 */
	public java.util.List<eu.strasbourg.service.artwork.model.ArtworkCollection>
		getArtworkCollections();

	/**
	 * Retourne la liste des ids de collections d'oeuvres sous forme de String
	 */
	public String getArtworkCollectionsIds();

	/**
	 * Retourne la liste des collections d'oeuvres publiées
	 */
	public java.util.List<eu.strasbourg.service.artwork.model.ArtworkCollection>
		getPublishedArtworkCollections();

	/**
	 * Retourne la version live de l'oeuvre, si elle existe
	 */
	public eu.strasbourg.service.artwork.model.Artwork getLiveVersion();

	/**
	 * Retourne les sources de l'oeuvre
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getSources();

	/**
	 * Retourne la classe css correspondante à la source
	 */
	public String getSourceCSSClass();

}