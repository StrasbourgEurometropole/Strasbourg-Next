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
 * The extended model interface for the OfficialTypeCouncil service. Represents a row in the &quot;council_OfficialTypeCouncil&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OfficialTypeCouncilModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.council.model.impl.OfficialTypeCouncilImpl"
)
@ProviderType
public interface OfficialTypeCouncil
	extends OfficialTypeCouncilModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.council.model.impl.OfficialTypeCouncilImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<OfficialTypeCouncil, Long>
		OFFICIAL_ID_ACCESSOR = new Accessor<OfficialTypeCouncil, Long>() {

			@Override
			public Long get(OfficialTypeCouncil officialTypeCouncil) {
				return officialTypeCouncil.getOfficialId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OfficialTypeCouncil> getTypeClass() {
				return OfficialTypeCouncil.class;
			}

		};
	public static final Accessor<OfficialTypeCouncil, Long> TYPE_ID_ACCESSOR =
		new Accessor<OfficialTypeCouncil, Long>() {

			@Override
			public Long get(OfficialTypeCouncil officialTypeCouncil) {
				return officialTypeCouncil.getTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<OfficialTypeCouncil> getTypeClass() {
				return OfficialTypeCouncil.class;
			}

		};

}