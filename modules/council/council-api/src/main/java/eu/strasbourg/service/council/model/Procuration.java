/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Procuration service. Represents a row in the &quot;council_Procuration&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProcurationModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.council.model.impl.ProcurationImpl"
)
@ProviderType
public interface Procuration extends PersistedModel, ProcurationModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.council.model.impl.ProcurationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Procuration, Long> PROCURATION_ID_ACCESSOR =
		new Accessor<Procuration, Long>() {

			@Override
			public Long get(Procuration procuration) {
				return procuration.getProcurationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Procuration> getTypeClass() {
				return Procuration.class;
			}

		};

	/**
	 * Retourne le nom complet de l'élu reçevant la procuration
	 */
	public String getOfficialVotersFullName();

}