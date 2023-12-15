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
 * This class is a wrapper for {@link Calendar}.
 * </p>
 *
 * @author Cedric Henry
 * @see Calendar
 * @generated
 */
public class CalendarWrapper
	extends BaseModelWrapper<Calendar>
	implements Calendar, ModelWrapper<Calendar> {

	public CalendarWrapper(Calendar calendar) {
		super(calendar);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("service_id", getService_id());
		attributes.put("monday", isMonday());
		attributes.put("tuesday", isTuesday());
		attributes.put("wednesday", isWednesday());
		attributes.put("thursday", isThursday());
		attributes.put("friday", isFriday());
		attributes.put("saturday", isSaturday());
		attributes.put("sunday", isSunday());
		attributes.put("start_date", getStart_date());
		attributes.put("end_date", getEnd_date());

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

		Boolean monday = (Boolean)attributes.get("monday");

		if (monday != null) {
			setMonday(monday);
		}

		Boolean tuesday = (Boolean)attributes.get("tuesday");

		if (tuesday != null) {
			setTuesday(tuesday);
		}

		Boolean wednesday = (Boolean)attributes.get("wednesday");

		if (wednesday != null) {
			setWednesday(wednesday);
		}

		Boolean thursday = (Boolean)attributes.get("thursday");

		if (thursday != null) {
			setThursday(thursday);
		}

		Boolean friday = (Boolean)attributes.get("friday");

		if (friday != null) {
			setFriday(friday);
		}

		Boolean saturday = (Boolean)attributes.get("saturday");

		if (saturday != null) {
			setSaturday(saturday);
		}

		Boolean sunday = (Boolean)attributes.get("sunday");

		if (sunday != null) {
			setSunday(sunday);
		}

		Date start_date = (Date)attributes.get("start_date");

		if (start_date != null) {
			setStart_date(start_date);
		}

		Date end_date = (Date)attributes.get("end_date");

		if (end_date != null) {
			setEnd_date(end_date);
		}
	}

	@Override
	public Calendar cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the end_date of this calendar.
	 *
	 * @return the end_date of this calendar
	 */
	@Override
	public Date getEnd_date() {
		return model.getEnd_date();
	}

	/**
	 * Returns the friday of this calendar.
	 *
	 * @return the friday of this calendar
	 */
	@Override
	public boolean getFriday() {
		return model.getFriday();
	}

	/**
	 * Returns the ID of this calendar.
	 *
	 * @return the ID of this calendar
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the monday of this calendar.
	 *
	 * @return the monday of this calendar
	 */
	@Override
	public boolean getMonday() {
		return model.getMonday();
	}

	/**
	 * Returns the primary key of this calendar.
	 *
	 * @return the primary key of this calendar
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the saturday of this calendar.
	 *
	 * @return the saturday of this calendar
	 */
	@Override
	public boolean getSaturday() {
		return model.getSaturday();
	}

	/**
	 * Returns the service_id of this calendar.
	 *
	 * @return the service_id of this calendar
	 */
	@Override
	public String getService_id() {
		return model.getService_id();
	}

	/**
	 * Returns the start_date of this calendar.
	 *
	 * @return the start_date of this calendar
	 */
	@Override
	public Date getStart_date() {
		return model.getStart_date();
	}

	/**
	 * Returns the sunday of this calendar.
	 *
	 * @return the sunday of this calendar
	 */
	@Override
	public boolean getSunday() {
		return model.getSunday();
	}

	/**
	 * Returns the thursday of this calendar.
	 *
	 * @return the thursday of this calendar
	 */
	@Override
	public boolean getThursday() {
		return model.getThursday();
	}

	/**
	 * Returns the tuesday of this calendar.
	 *
	 * @return the tuesday of this calendar
	 */
	@Override
	public boolean getTuesday() {
		return model.getTuesday();
	}

	/**
	 * Returns the uuid of this calendar.
	 *
	 * @return the uuid of this calendar
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the wednesday of this calendar.
	 *
	 * @return the wednesday of this calendar
	 */
	@Override
	public boolean getWednesday() {
		return model.getWednesday();
	}

	/**
	 * Returns <code>true</code> if this calendar is friday.
	 *
	 * @return <code>true</code> if this calendar is friday; <code>false</code> otherwise
	 */
	@Override
	public boolean isFriday() {
		return model.isFriday();
	}

	/**
	 * Returns <code>true</code> if this calendar is monday.
	 *
	 * @return <code>true</code> if this calendar is monday; <code>false</code> otherwise
	 */
	@Override
	public boolean isMonday() {
		return model.isMonday();
	}

	/**
	 * Returns <code>true</code> if this calendar is saturday.
	 *
	 * @return <code>true</code> if this calendar is saturday; <code>false</code> otherwise
	 */
	@Override
	public boolean isSaturday() {
		return model.isSaturday();
	}

	/**
	 * Returns <code>true</code> if this calendar is sunday.
	 *
	 * @return <code>true</code> if this calendar is sunday; <code>false</code> otherwise
	 */
	@Override
	public boolean isSunday() {
		return model.isSunday();
	}

	/**
	 * Returns <code>true</code> if this calendar is thursday.
	 *
	 * @return <code>true</code> if this calendar is thursday; <code>false</code> otherwise
	 */
	@Override
	public boolean isThursday() {
		return model.isThursday();
	}

	/**
	 * Returns <code>true</code> if this calendar is tuesday.
	 *
	 * @return <code>true</code> if this calendar is tuesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isTuesday() {
		return model.isTuesday();
	}

	/**
	 * Returns <code>true</code> if this calendar is wednesday.
	 *
	 * @return <code>true</code> if this calendar is wednesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isWednesday() {
		return model.isWednesday();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the end_date of this calendar.
	 *
	 * @param end_date the end_date of this calendar
	 */
	@Override
	public void setEnd_date(Date end_date) {
		model.setEnd_date(end_date);
	}

	/**
	 * Sets whether this calendar is friday.
	 *
	 * @param friday the friday of this calendar
	 */
	@Override
	public void setFriday(boolean friday) {
		model.setFriday(friday);
	}

	/**
	 * Sets the ID of this calendar.
	 *
	 * @param id the ID of this calendar
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets whether this calendar is monday.
	 *
	 * @param monday the monday of this calendar
	 */
	@Override
	public void setMonday(boolean monday) {
		model.setMonday(monday);
	}

	/**
	 * Sets the primary key of this calendar.
	 *
	 * @param primaryKey the primary key of this calendar
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this calendar is saturday.
	 *
	 * @param saturday the saturday of this calendar
	 */
	@Override
	public void setSaturday(boolean saturday) {
		model.setSaturday(saturday);
	}

	/**
	 * Sets the service_id of this calendar.
	 *
	 * @param service_id the service_id of this calendar
	 */
	@Override
	public void setService_id(String service_id) {
		model.setService_id(service_id);
	}

	/**
	 * Sets the start_date of this calendar.
	 *
	 * @param start_date the start_date of this calendar
	 */
	@Override
	public void setStart_date(Date start_date) {
		model.setStart_date(start_date);
	}

	/**
	 * Sets whether this calendar is sunday.
	 *
	 * @param sunday the sunday of this calendar
	 */
	@Override
	public void setSunday(boolean sunday) {
		model.setSunday(sunday);
	}

	/**
	 * Sets whether this calendar is thursday.
	 *
	 * @param thursday the thursday of this calendar
	 */
	@Override
	public void setThursday(boolean thursday) {
		model.setThursday(thursday);
	}

	/**
	 * Sets whether this calendar is tuesday.
	 *
	 * @param tuesday the tuesday of this calendar
	 */
	@Override
	public void setTuesday(boolean tuesday) {
		model.setTuesday(tuesday);
	}

	/**
	 * Sets the uuid of this calendar.
	 *
	 * @param uuid the uuid of this calendar
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets whether this calendar is wednesday.
	 *
	 * @param wednesday the wednesday of this calendar
	 */
	@Override
	public void setWednesday(boolean wednesday) {
		model.setWednesday(wednesday);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected CalendarWrapper wrap(Calendar calendar) {
		return new CalendarWrapper(calendar);
	}

}