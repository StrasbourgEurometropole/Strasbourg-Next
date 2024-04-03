/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
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