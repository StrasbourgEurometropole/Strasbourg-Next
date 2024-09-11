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
 * The extended model interface for the Comment service. Represents a row in the &quot;comment_Comment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Romain Vergnais
 * @see CommentModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.comment.model.impl.CommentImpl")
@ProviderType
public interface Comment extends CommentModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.comment.model.impl.CommentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Comment, Long> COMMENT_ID_ACCESSOR =
		new Accessor<Comment, Long>() {

			@Override
			public Long get(Comment comment) {
				return comment.getCommentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Comment> getTypeClass() {
				return Comment.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	public String getTypeAssetEntry();

	public String getAssetEntryTitle();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	public eu.strasbourg.service.oidc.model.PublikUser getPublikUser();

	public String getPublikUserName();

	/**
	 * méthode permettant de retourner le nom de l'utilisateur en entier.
	 *
	 * @return le nom de l'utilisateur.
	 */
	public String getFullPublikUserName();

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes();

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes();

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes();

	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public int getNbLikesDislikes();

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public int getNbLikes();

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public int getNbDislikes();

	/**
	 * Retourne la liste des commentaires enfants de l'item
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedChildComments();

	/**
	 * méthode qui renvoie la liste des signalements d'un commentaire.
	 *
	 * @return la liste des signalements
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Signalement>
		findSignalements();

	/**
	 * méthode qui renvoie le nombre de signalement pour un commentaire.
	 *
	 * @return le nombre de signalement en int.
	 */
	public int getCountSignalements();

}