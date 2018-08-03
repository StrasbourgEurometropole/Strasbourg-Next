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
 * The extended model interface for the Petition service. Represents a row in the &quot;project_Petition&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see PetitionModel
 * @see eu.strasbourg.service.project.model.impl.PetitionImpl
 * @see eu.strasbourg.service.project.model.impl.PetitionModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.project.model.impl.PetitionImpl")
@ProviderType
public interface Petition extends PetitionModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.project.model.impl.PetitionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Petition, Long> PETITION_ID_ACCESSOR = new Accessor<Petition, Long>() {
			@Override
			public Long get(Petition petition) {
				return petition.getPetitionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Petition> getTypeClass() {
				return Petition.class;
			}
		};

	/**
	* Retourne l'AssetEntry rattaché cet item
	*/
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	* Retourne le label de 5 digits du nombre de commentaires de l'entité
	*/
	public java.lang.String getNbApprovedCommentsLabel();

	/**
	* Retourne le nombre de commentaires de l'entité
	*/
	public int getNbApprovedComments();

	/**
	* Retourne les commentaires de l'entité
	*/
	public java.util.List<eu.strasbourg.service.comment.model.Comment> getApprovedComments();

	/**
	* Renvoie la liste des AssetCategory rattachées à cet item (via
	* l'assetEntry)
	*/
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory> getCategories();

	/**
	* Retourne le status de la petition
	*/
	public com.liferay.asset.kernel.model.AssetCategory getPetitionStatusCategory();
}