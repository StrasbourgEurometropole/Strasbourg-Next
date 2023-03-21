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

package eu.strasbourg.service.activity.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Practice service. Represents a row in the &quot;activity_Practice&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PracticeModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.activity.model.impl.PracticeImpl"
)
@ProviderType
public interface Practice extends PersistedModel, PracticeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.activity.model.impl.PracticeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Practice, Long> PRACTICE_ID_ACCESSOR =
		new Accessor<Practice, Long>() {

			@Override
			public Long get(Practice practice) {
				return practice.getPracticeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Practice> getTypeClass() {
				return Practice.class;
			}

		};

	/**
	 * Retourne la version live de cette entité
	 */
	public eu.strasbourg.service.activity.model.Practice getLiveVersion();

	/**
	 * Retourne l'AssetEntry rattaché à cette entité
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cette entité (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne les activités de l'association
	 */
	public eu.strasbourg.service.activity.model.Association getAssociation();

	/**
	 * Retourne la pratique de l'association
	 */
	public com.liferay.asset.kernel.model.AssetCategory getPractice();

	/**
	 * Retourne les publics de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne les quartiers de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getDistricts();

	/**
	 * Retourne l'accessibilité de l'association
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getAccessibilities();

}