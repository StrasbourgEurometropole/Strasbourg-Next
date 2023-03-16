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

package eu.strasbourg.service.agenda.model;

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
 * @author BenjaminBini
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
		attributes.put("eventId", getEventId());
		attributes.put("title", getTitle());
		attributes.put("suppressionDate", getSuppressionDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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
	 * Returns the event ID of this historic.
	 *
	 * @return the event ID of this historic
	 */
	@Override
	public long getEventId() {
		return model.getEventId();
	}

	/**
	 * Returns the primary key of this historic.
	 *
	 * @return the primary key of this historic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
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
	 * Returns the title of this historic.
	 *
	 * @return the title of this historic
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
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
	 * Sets the event ID of this historic.
	 *
	 * @param eventId the event ID of this historic
	 */
	@Override
	public void setEventId(long eventId) {
		model.setEventId(eventId);
	}

	/**
	 * Sets the primary key of this historic.
	 *
	 * @param primaryKey the primary key of this historic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
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
	 * Sets the title of this historic.
	 *
	 * @param title the title of this historic
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
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