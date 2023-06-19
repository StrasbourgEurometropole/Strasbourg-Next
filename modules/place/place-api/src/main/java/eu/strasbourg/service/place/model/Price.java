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

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Price service. Represents a row in the &quot;place_Price&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see PriceModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.place.model.impl.PriceImpl")
@ProviderType
public interface Price extends PersistedModel, PriceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.PriceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Price, Long> PRICE_ID_ACCESSOR =
		new Accessor<Price, Long>() {

			@Override
			public Long get(Price price) {
				return price.getPriceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Price> getTypeClass() {
				return Price.class;
			}

		};

	/**
	 * Retourne les lieux du tarif
	 */
	public java.util.List<eu.strasbourg.service.place.model.Place> getPlaces();

	/**
	 * Renvoie la liste des IDs des lieux auxquelles ce tarif
	 * appartient sous forme de String
	 */
	public String getPlacesIds();

}