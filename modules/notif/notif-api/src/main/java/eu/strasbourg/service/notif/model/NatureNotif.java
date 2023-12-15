/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the NatureNotif service. Represents a row in the &quot;notif_NatureNotif&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see NatureNotifModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notif.model.impl.NatureNotifImpl"
)
@ProviderType
public interface NatureNotif extends NatureNotifModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notif.model.impl.NatureNotifImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<NatureNotif, Long> NATURE_ID_ACCESSOR =
		new Accessor<NatureNotif, Long>() {

			@Override
			public Long get(NatureNotif natureNotif) {
				return natureNotif.getNatureId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<NatureNotif> getTypeClass() {
				return NatureNotif.class;
			}

		};

}