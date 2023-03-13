/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.notification.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserNotificationChannel}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserNotificationChannel
 * @generated
 */
public class UserNotificationChannelWrapper
	extends BaseModelWrapper<UserNotificationChannel>
	implements ModelWrapper<UserNotificationChannel>, UserNotificationChannel {

	public UserNotificationChannelWrapper(
		UserNotificationChannel userNotificationChannel) {

		super(userNotificationChannel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publikUserId", getPublikUserId());
		attributes.put("channelId", getChannelId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}
	}

	@Override
	public UserNotificationChannel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the channel ID of this user notification channel.
	 *
	 * @return the channel ID of this user notification channel
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the primary key of this user notification channel.
	 *
	 * @return the primary key of this user notification channel
	 */
	@Override
	public eu.strasbourg.service.notification.service.persistence.
		UserNotificationChannelPK getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this user notification channel.
	 *
	 * @return the publik user ID of this user notification channel
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the channel ID of this user notification channel.
	 *
	 * @param channelId the channel ID of this user notification channel
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the primary key of this user notification channel.
	 *
	 * @param primaryKey the primary key of this user notification channel
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.notification.service.persistence.
			UserNotificationChannelPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this user notification channel.
	 *
	 * @param publikUserId the publik user ID of this user notification channel
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected UserNotificationChannelWrapper wrap(
		UserNotificationChannel userNotificationChannel) {

		return new UserNotificationChannelWrapper(userNotificationChannel);
	}

}