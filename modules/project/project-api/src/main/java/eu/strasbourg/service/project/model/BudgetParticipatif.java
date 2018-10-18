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
 * The extended model interface for the BudgetParticipatif service. Represents a row in the &quot;project_BudgetParticipatif&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see BudgetParticipatifModel
 * @see eu.strasbourg.service.project.model.impl.BudgetParticipatifImpl
 * @see eu.strasbourg.service.project.model.impl.BudgetParticipatifModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.project.model.impl.BudgetParticipatifImpl")
@ProviderType
public interface BudgetParticipatif extends BudgetParticipatifModel,
	PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.project.model.impl.BudgetParticipatifImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BudgetParticipatif, Long> BUDGET_PARTICIPATIF_ID_ACCESSOR =
		new Accessor<BudgetParticipatif, Long>() {
			@Override
			public Long get(BudgetParticipatif budgetParticipatif) {
				return budgetParticipatif.getBudgetParticipatifId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BudgetParticipatif> getTypeClass() {
				return BudgetParticipatif.class;
			}
		};

	/**
	* Retourne le projet de la participation (
	*/
	public com.liferay.asset.kernel.model.AssetCategory getProjectCategory();

	public java.lang.String getProjectTitle(java.util.Locale locale);

	/**
	* Retourne l'AssetEntry rattaché cet item
	*/
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	* Retourne les thematiques de la participation (
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getThematicCategories();

	public java.lang.String getThematicTitle(java.util.Locale locale);

	/**
	* Retourne les catégories 'Territoire' correspondant aux pays de la petition
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getTerritoryCategories();

	/**
	* Retourne la liste des lieux placit liés à la participation
	*/
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace> getPlacitPlaces();

	/**
	* retourne les catégories
	*
	* @return
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getCategories();

	/**
	* Retourne l'URL de l'image à partir de l'id du DLFileEntry
	*/
	public java.lang.String getImageURL();

	/**
	* Retourne une chaine des 'Territoires' correspondant aux quartiers de la petition
	*
	* @return : Chaine des quartiers ou description "Aucun" ou "Tous"
	*/
	public java.lang.String getDistrictLabel(java.util.Locale locale);

	/**
	* Retourne les sous-sous-catégories 'Territoire' correspondant aux quartiers de la petition
	*
	* @return : null si vide, sinon la liste des catégories
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getDistrictCategories();

	/**
	* Retourne la version JSON de l'entité
	*/
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		java.lang.String publikUserId);
}