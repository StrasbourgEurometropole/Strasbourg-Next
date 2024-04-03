/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Notification service. Represents a row in the &quot;notification_Notification&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see NotificationModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notification.model.impl.NotificationImpl"
)
@ProviderType
public interface Notification extends NotificationModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notification.model.impl.NotificationImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Notification, Long> NOTIFICATION_ID_ACCESSOR =
		new Accessor<Notification, Long>() {

			@Override
			public Long get(Notification notification) {
				return notification.getNotificationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Notification> getTypeClass() {
				return Notification.class;
			}

		};

	/**
	 * Retourne le type de la notification
	 */
	public com.liferay.asset.kernel.model.AssetCategory getType();

	/**
	 * Retourne la liste des utilisateurs concernés par la notification
	 */
	public java.util.List<eu.strasbourg.service.oidc.model.PublikUser>
		getUsersToNotify();

}