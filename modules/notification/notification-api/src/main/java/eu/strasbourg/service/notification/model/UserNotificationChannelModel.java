/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import eu.strasbourg.service.notification.service.persistence.UserNotificationChannelPK;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the UserNotificationChannel service. Represents a row in the &quot;notification_UserNotificationChannel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.notification.model.impl.UserNotificationChannelImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationChannel
 * @generated
 */
@ProviderType
public interface UserNotificationChannelModel
	extends BaseModel<UserNotificationChannel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a user notification channel model instance should use the {@link UserNotificationChannel} interface instead.
	 */

	/**
	 * Returns the primary key of this user notification channel.
	 *
	 * @return the primary key of this user notification channel
	 */
	public UserNotificationChannelPK getPrimaryKey();

	/**
	 * Sets the primary key of this user notification channel.
	 *
	 * @param primaryKey the primary key of this user notification channel
	 */
	public void setPrimaryKey(UserNotificationChannelPK primaryKey);

	/**
	 * Returns the publik user ID of this user notification channel.
	 *
	 * @return the publik user ID of this user notification channel
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this user notification channel.
	 *
	 * @param publikUserId the publik user ID of this user notification channel
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the channel ID of this user notification channel.
	 *
	 * @return the channel ID of this user notification channel
	 */
	public long getChannelId();

	/**
	 * Sets the channel ID of this user notification channel.
	 *
	 * @param channelId the channel ID of this user notification channel
	 */
	public void setChannelId(long channelId);

	@Override
	public UserNotificationChannel cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}