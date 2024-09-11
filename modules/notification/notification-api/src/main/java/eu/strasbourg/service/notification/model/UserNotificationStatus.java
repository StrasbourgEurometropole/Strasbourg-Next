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
 * The extended model interface for the UserNotificationStatus service. Represents a row in the &quot;notification_UserNotificationStatus&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see UserNotificationStatusModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.notification.model.impl.UserNotificationStatusImpl"
)
@ProviderType
public interface UserNotificationStatus
	extends PersistedModel, UserNotificationStatusModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.notification.model.impl.UserNotificationStatusImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserNotificationStatus, Long>
		NOTIFICATION_ID_ACCESSOR =
			new Accessor<UserNotificationStatus, Long>() {

				@Override
				public Long get(UserNotificationStatus userNotificationStatus) {
					return userNotificationStatus.getNotificationId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<UserNotificationStatus> getTypeClass() {
					return UserNotificationStatus.class;
				}

			};
	public static final Accessor<UserNotificationStatus, String>
		PUBLIK_USER_ID_ACCESSOR =
			new Accessor<UserNotificationStatus, String>() {

				@Override
				public String get(
					UserNotificationStatus userNotificationStatus) {

					return userNotificationStatus.getPublikUserId();
				}

				@Override
				public Class<String> getAttributeClass() {
					return String.class;
				}

				@Override
				public Class<UserNotificationStatus> getTypeClass() {
					return UserNotificationStatus.class;
				}

			};

	/**
	 * Retourne la version JSON de l'objet
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

	public eu.strasbourg.service.notification.model.Notification
		getNotification();

}