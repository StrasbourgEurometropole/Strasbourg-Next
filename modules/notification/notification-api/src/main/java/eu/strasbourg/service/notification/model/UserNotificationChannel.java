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
 * The extended model interface for the UserNotificationChannel service. Represents a row in the &quot;notification_UserNotificationChannel&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see UserNotificationChannelModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notification.model.impl.UserNotificationChannelImpl"
)
@ProviderType
public interface UserNotificationChannel
	extends PersistedModel, UserNotificationChannelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserNotificationChannel, String>
		PUBLIK_USER_ID_ACCESSOR =
			new Accessor<UserNotificationChannel, String>() {

				@Override
				public String get(
					UserNotificationChannel userNotificationChannel) {

					return userNotificationChannel.getPublikUserId();
				}

				@Override
				public Class<String> getAttributeClass() {
					return String.class;
				}

				@Override
				public Class<UserNotificationChannel> getTypeClass() {
					return UserNotificationChannel.class;
				}

			};
	public static final Accessor<UserNotificationChannel, Long>
		CHANNEL_ID_ACCESSOR = new Accessor<UserNotificationChannel, Long>() {

			@Override
			public Long get(UserNotificationChannel userNotificationChannel) {
				return userNotificationChannel.getChannelId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserNotificationChannel> getTypeClass() {
				return UserNotificationChannel.class;
			}

		};

}