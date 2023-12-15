/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CalendarDate}.
 * </p>
 *
 * @author Cedric Henry
 * @see CalendarDate
 * @generated
 */
public class CalendarDateWrapper
	extends BaseModelWrapper<CalendarDate>
	implements CalendarDate, ModelWrapper<CalendarDate> {

	public CalendarDateWrapper(CalendarDate calendarDate) {
		super(calendarDate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("service_id", getService_id());
		attributes.put("date", getDate());
		attributes.put("exception_type", getException_type());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String service_id = (String)attributes.get("service_id");

		if (service_id != null) {
			setService_id(service_id);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer exception_type = (Integer)attributes.get("exception_type");

		if (exception_type != null) {
			setException_type(exception_type);
		}
	}

	@Override
	public CalendarDate cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the date of this calendar date.
	 *
	 * @return the date of this calendar date
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the exception_type of this calendar date.
	 *
	 * @return the exception_type of this calendar date
	 */
	@Override
	public int getException_type() {
		return model.getException_type();
	}

	/**
	 * Returns the ID of this calendar date.
	 *
	 * @return the ID of this calendar date
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this calendar date.
	 *
	 * @return the primary key of this calendar date
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service_id of this calendar date.
	 *
	 * @return the service_id of this calendar date
	 */
	@Override
	public String getService_id() {
		return model.getService_id();
	}

	/**
	 * Returns the uuid of this calendar date.
	 *
	 * @return the uuid of this calendar date
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
	 * Sets the date of this calendar date.
	 *
	 * @param date the date of this calendar date
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the exception_type of this calendar date.
	 *
	 * @param exception_type the exception_type of this calendar date
	 */
	@Override
	public void setException_type(int exception_type) {
		model.setException_type(exception_type);
	}

	/**
	 * Sets the ID of this calendar date.
	 *
	 * @param id the ID of this calendar date
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this calendar date.
	 *
	 * @param primaryKey the primary key of this calendar date
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service_id of this calendar date.
	 *
	 * @param service_id the service_id of this calendar date
	 */
	@Override
	public void setService_id(String service_id) {
		model.setService_id(service_id);
	}

	/**
	 * Sets the uuid of this calendar date.
	 *
	 * @param uuid the uuid of this calendar date
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
	protected CalendarDateWrapper wrap(CalendarDate calendarDate) {
		return new CalendarDateWrapper(calendarDate);
	}

}