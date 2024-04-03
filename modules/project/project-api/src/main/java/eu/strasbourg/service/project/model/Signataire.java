/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Signataire service. Represents a row in the &quot;project_Signataire&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see SignataireModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.SignataireImpl"
)
@ProviderType
public interface Signataire extends PersistedModel, SignataireModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.SignataireImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Signataire, Long> SIGNATAIRE_ID_ACCESSOR =
		new Accessor<Signataire, Long>() {

			@Override
			public Long get(Signataire signataire) {
				return signataire.getSignataireId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Signataire> getTypeClass() {
				return Signataire.class;
			}

		};

}