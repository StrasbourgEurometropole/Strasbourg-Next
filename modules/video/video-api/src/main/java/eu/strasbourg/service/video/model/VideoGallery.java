/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.video.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the VideoGallery service. Represents a row in the &quot;video_VideoGallery&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see VideoGalleryModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.video.model.impl.VideoGalleryImpl"
)
@ProviderType
public interface VideoGallery extends PersistedModel, VideoGalleryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.video.model.impl.VideoGalleryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<VideoGallery, Long> GALLERY_ID_ACCESSOR =
		new Accessor<VideoGallery, Long>() {

			@Override
			public Long get(VideoGallery videoGallery) {
				return videoGallery.getGalleryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<VideoGallery> getTypeClass() {
				return VideoGallery.class;
			}

		};

	/**
	 * Retourne l'AssetEntry correspondant à cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des AssetCategory correspondant à cet item (via l'AssetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Renvoie l'URL de l'image à partir de l'id du DLFileEntry
	 *
	 * @throws PortalException
	 * @throws NumberFormatException
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne la liste des vidéos de la galerie
	 */
	public java.util.List<eu.strasbourg.service.video.model.Video> getVideos();

	/**
	 * Retourne la liste des ids des vidéos de la galerie
	 */
	public String getVideosIds();

	/**
	 * Renvoie la liste des éditions publiées de la galerie
	 */
	public java.util.List<eu.strasbourg.service.video.model.Video>
		getPublishedVideos();

	/**
	 * Renvoie la version live de la galerie, si elle existe
	 */
	public eu.strasbourg.service.video.model.VideoGallery getLiveVersion();

}