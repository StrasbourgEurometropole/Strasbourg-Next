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

package eu.strasbourg.service.interest.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserInterest}.
 * </p>
 *
 * @author BenjaminBini
 * @see UserInterest
 * @generated
 */
public class UserInterestWrapper
	extends BaseModelWrapper<UserInterest>
	implements ModelWrapper<UserInterest>, UserInterest {

	public UserInterestWrapper(UserInterest userInterest) {
		super(userInterest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("interestId", getInterestId());
		attributes.put("publikUserId", getPublikUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long interestId = (Long)attributes.get("interestId");

		if (interestId != null) {
			setInterestId(interestId);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}
	}

	@Override
	public UserInterest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public eu.strasbourg.service.interest.model.Interest getInterest() {
		return model.getInterest();
	}

	/**
	 * Returns the interest ID of this user interest.
	 *
	 * @return the interest ID of this user interest
	 */
	@Override
	public long getInterestId() {
		return model.getInterestId();
	}

	/**
	 * Returns the primary key of this user interest.
	 *
	 * @return the primary key of this user interest
	 */
	@Override
	public eu.strasbourg.service.interest.service.persistence.UserInterestPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this user interest.
	 *
	 * @return the publik user ID of this user interest
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
	 * Sets the interest ID of this user interest.
	 *
	 * @param interestId the interest ID of this user interest
	 */
	@Override
	public void setInterestId(long interestId) {
		model.setInterestId(interestId);
	}

	/**
	 * Sets the primary key of this user interest.
	 *
	 * @param primaryKey the primary key of this user interest
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.interest.service.persistence.UserInterestPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this user interest.
	 *
	 * @param publikUserId the publik user ID of this user interest
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
	protected UserInterestWrapper wrap(UserInterest userInterest) {
		return new UserInterestWrapper(userInterest);
	}

}