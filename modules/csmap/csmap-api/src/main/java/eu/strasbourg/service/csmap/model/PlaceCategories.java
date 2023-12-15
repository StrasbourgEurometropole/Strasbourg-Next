/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PlaceCategories service. Represents a row in the &quot;csmap_PlaceCategories&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PlaceCategoriesModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.csmap.model.impl.PlaceCategoriesImpl"
)
@ProviderType
public interface PlaceCategories extends PersistedModel, PlaceCategoriesModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.csmap.model.impl.PlaceCategoriesImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PlaceCategories, Long>
		PLACE_CATEGORIES_ID_ACCESSOR = new Accessor<PlaceCategories, Long>() {

			@Override
			public Long get(PlaceCategories placeCategories) {
				return placeCategories.getPlaceCategoriesId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PlaceCategories> getTypeClass() {
				return PlaceCategories.class;
			}

		};

}