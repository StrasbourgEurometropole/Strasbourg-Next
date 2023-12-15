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
 * The extended model interface for the UserNotificationType service. Represents a row in the &quot;notification_UserNotificationType&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see UserNotificationTypeModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notification.model.impl.UserNotificationTypeImpl"
)
@ProviderType
public interface UserNotificationType
	extends PersistedModel, UserNotificationTypeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserNotificationType, String>
		PUBLIK_USER_ID_ACCESSOR = new Accessor<UserNotificationType, String>() {

			@Override
			public String get(UserNotificationType userNotificationType) {
				return userNotificationType.getPublikUserId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<UserNotificationType> getTypeClass() {
				return UserNotificationType.class;
			}

		};
	public static final Accessor<UserNotificationType, Long> TYPE_ID_ACCESSOR =
		new Accessor<UserNotificationType, Long>() {

			@Override
			public Long get(UserNotificationType userNotificationType) {
				return userNotificationType.getTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserNotificationType> getTypeClass() {
				return UserNotificationType.class;
			}

		};

}