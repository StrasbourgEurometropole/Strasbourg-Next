/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the SaisineObservatoire service. Represents a row in the &quot;project_SaisineObservatoire&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see SaisineObservatoireModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl"
)
@ProviderType
public interface SaisineObservatoire
	extends PersistedModel, SaisineObservatoireModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SaisineObservatoire, Long>
		SAISINE_OBSERVATOIRE_ID_ACCESSOR =
			new Accessor<SaisineObservatoire, Long>() {

				@Override
				public Long get(SaisineObservatoire saisineObservatoire) {
					return saisineObservatoire.getSaisineObservatoireId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<SaisineObservatoire> getTypeClass() {
					return SaisineObservatoire.class;
				}

			};

	public String getThematicLabel(java.util.Locale locale);

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	public String getSaisineObservatoireStatus();

	public String getAuthorLabel();

	/**
	 * Retourne la liste des lieux placit liés à la petition
	 */
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces();

	/**
	 * Retourne X suggestions max pour une pétition
	 *
	 * @param request
	 la requete
	 * @param nbSuggestions
	 le nombre de suggestions.
	 * @return la liste de pétition.
	 */
	public java.util.List
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions);

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne le label de 5 digits du nombre de commentaires de l'entité
	 */
	public String getNbApprovedCommentsLabel();

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	public int getNbApprovedComments();

	/**
	 * Retourne les commentaires de l'entité
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments();

	/**
	 * Retourne les thematiques de la saisine (
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThematicCategories();

	/**
	 * Retourne le projet de la saisine (
	 */
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory();

	/**
	 * Retourne la version JSON de l'entité
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserId);

	public String getProjectTitle(java.util.Locale locale);

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	public String getFrontStatusFR();

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	public String getAuthorImageURL();

	/**
	 * Retourne l'auteur en publik user
	 *
	 * @return
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getAuthorPublikUser();

	/**
	 * Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
	 *
	 * @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	 */
	public String getDistrictLabel(java.util.Locale locale);

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistrictCategories();

	/**
	 * Retourne les sous-sous-catégories 'Territoire' correspondant aux communes de la pétition
	 *
	 * @return : null si vide, sinon la liste des catégories
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCityCategories();

	/**
	 * Retourne les catégories 'Territoire' correspondant aux pays de la petition
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritoryCategories();

	public com.liferay.asset.kernel.model.AssetCategory getStatusCategorie();

}