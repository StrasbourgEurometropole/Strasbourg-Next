/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ObjectCategory service. Represents a row in the &quot;objtp_ObjectCategory&quot; database table, with each column mapped to a property of this class.
 *
 * @author JeremyZwickert
 * @see ObjectCategoryModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.objtp.model.impl.ObjectCategoryImpl"
)
@ProviderType
public interface ObjectCategory extends ObjectCategoryModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.objtp.model.impl.ObjectCategoryImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ObjectCategory, String> CODE_ACCESSOR =
		new Accessor<ObjectCategory, String>() {

			@Override
			public String get(ObjectCategory objectCategory) {
				return objectCategory.getCode();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<ObjectCategory> getTypeClass() {
				return ObjectCategory.class;
			}

		};

}