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

}