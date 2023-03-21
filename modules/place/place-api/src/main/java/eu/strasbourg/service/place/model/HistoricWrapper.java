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

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Historic}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see Historic
 * @generated
 */
public class HistoricWrapper
	extends BaseModelWrapper<Historic>
	implements Historic, ModelWrapper<Historic> {

	public HistoricWrapper(Historic historic) {
		super(historic);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sigId", getSigId());
		attributes.put("name", getName());
		attributes.put("suppressionDate", getSuppressionDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String sigId = (String)attributes.get("sigId");

		if (sigId != null) {
			setSigId(sigId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date suppressionDate = (Date)attributes.get("suppressionDate");

		if (suppressionDate != null) {
			setSuppressionDate(suppressionDate);
		}
	}

	@Override
	public Historic cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the name of this historic.
	 *
	 * @return the name of this historic
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this historic.
	 *
	 * @return the primary key of this historic
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sig ID of this historic.
	 *
	 * @return the sig ID of this historic
	 */
	@Override
	public String getSigId() {
		return model.getSigId();
	}

	/**
	 * Returns the suppression date of this historic.
	 *
	 * @return the suppression date of this historic
	 */
	@Override
	public Date getSuppressionDate() {
		return model.getSuppressionDate();
	}

	/**
	 * Returns the uuid of this historic.
	 *
	 * @return the uuid of this historic
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this historic.
	 *
	 * @param name the name of this historic
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this historic.
	 *
	 * @param primaryKey the primary key of this historic
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sig ID of this historic.
	 *
	 * @param sigId the sig ID of this historic
	 */
	@Override
	public void setSigId(String sigId) {
		model.setSigId(sigId);
	}

	/**
	 * Sets the suppression date of this historic.
	 *
	 * @param suppressionDate the suppression date of this historic
	 */
	@Override
	public void setSuppressionDate(Date suppressionDate) {
		model.setSuppressionDate(suppressionDate);
	}

	/**
	 * Sets the uuid of this historic.
	 *
	 * @param uuid the uuid of this historic
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected HistoricWrapper wrap(Historic historic) {
		return new HistoricWrapper(historic);
	}

}