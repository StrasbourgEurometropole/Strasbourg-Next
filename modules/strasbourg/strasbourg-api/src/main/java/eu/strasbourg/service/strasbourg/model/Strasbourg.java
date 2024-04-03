/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Strasbourg service. Represents a row in the &quot;strasbourg_Strasbourg&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.strasbourg.model.impl.StrasbourgImpl"
)
@ProviderType
public interface Strasbourg extends PersistedModel, StrasbourgModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.strasbourg.model.impl.StrasbourgImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Strasbourg, Long> ID_ACCESSOR =
		new Accessor<Strasbourg, Long>() {

			@Override
			public Long get(Strasbourg strasbourg) {
				return strasbourg.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Strasbourg> getTypeClass() {
				return Strasbourg.class;
			}

		};

}