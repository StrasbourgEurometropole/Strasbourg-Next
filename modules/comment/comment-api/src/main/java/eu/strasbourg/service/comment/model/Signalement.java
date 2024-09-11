/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Signalement service. Represents a row in the &quot;comment_Signalement&quot; database table, with each column mapped to a property of this class.
 *
 * @author Romain Vergnais
 * @see SignalementModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.comment.model.impl.SignalementImpl"
)
@ProviderType
public interface Signalement extends PersistedModel, SignalementModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.comment.model.impl.SignalementImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Signalement, Long> SIGNALEMENT_ID_ACCESSOR =
		new Accessor<Signalement, Long>() {

			@Override
			public Long get(Signalement signalement) {
				return signalement.getSignalementId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Signalement> getTypeClass() {
				return Signalement.class;
			}

		};

	/**
	 * méthode qui permet de récupérer le commmentaire lié au signalement.
	 *
	 * @return le commentaire.
	 */
	public eu.strasbourg.service.comment.model.Comment getComment();

	/**
	 * Recuperer le commmentaire lie au signalement.
	 *
	 * @return le commentaire.
	 */
	public String getCommentContent();

	/**
	 * Retourne l'utilisateur auteur du commentaire
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getCommentAuthor();

	/**
	 * Retourne le nom de l'auteur du commentaire
	 */
	public String getCommentAuthorLabel();

	/**
	 * Retourne l'utilisateur auteur du signalement
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getSignalementAuthor();

	/**
	 * Retourne le nom de l'auteur du signalement
	 */
	public String getSignalementAuthorLabel();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategoriesByAssetEntry();

	public String getCategorieName();

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

}