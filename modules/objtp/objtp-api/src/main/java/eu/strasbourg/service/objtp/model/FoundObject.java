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
 * The extended model interface for the FoundObject service. Represents a row in the &quot;objtp_FoundObject&quot; database table, with each column mapped to a property of this class.
 *
 * @author JeremyZwickert
 * @see FoundObjectModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.objtp.model.impl.FoundObjectImpl"
)
@ProviderType
public interface FoundObject extends FoundObjectModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.objtp.model.impl.FoundObjectImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FoundObject, String> NUMBER_ACCESSOR =
		new Accessor<FoundObject, String>() {

			@Override
			public String get(FoundObject foundObject) {
				return foundObject.getNumber();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<FoundObject> getTypeClass() {
				return FoundObject.class;
			}

		};

}