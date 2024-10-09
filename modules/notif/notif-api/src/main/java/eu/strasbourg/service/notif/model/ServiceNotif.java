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
 * The extended model interface for the ServiceNotif service. Represents a row in the &quot;notif_ServiceNotif&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceNotifModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notif.model.impl.ServiceNotifImpl"
)
@ProviderType
public interface ServiceNotif extends PersistedModel, ServiceNotifModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notif.model.impl.ServiceNotifImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ServiceNotif, Long> SERVICE_ID_ACCESSOR =
		new Accessor<ServiceNotif, Long>() {

			@Override
			public Long get(ServiceNotif serviceNotif) {
				return serviceNotif.getServiceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ServiceNotif> getTypeClass() {
				return ServiceNotif.class;
			}

		};

	/**
	 * Retourne les Natures du service
	 */
	public java.util.List<NatureNotif> getNatures();

	/**
	 * Retourne les Messages du service
	 */
	public java.util.List<Message> getMessages();

}