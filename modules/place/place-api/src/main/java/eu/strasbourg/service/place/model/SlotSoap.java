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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class SlotSoap implements Serializable {

	public static SlotSoap toSoapModel(Slot model) {
		SlotSoap soapModel = new SlotSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSlotId(model.getSlotId());
		soapModel.setDayOfWeek(model.getDayOfWeek());
		soapModel.setStartHour(model.getStartHour());
		soapModel.setEndHour(model.getEndHour());
		soapModel.setComment(model.getComment());
		soapModel.setPeriodId(model.getPeriodId());
		soapModel.setSubPlaceId(model.getSubPlaceId());

		return soapModel;
	}

	public static SlotSoap[] toSoapModels(Slot[] models) {
		SlotSoap[] soapModels = new SlotSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SlotSoap[][] toSoapModels(Slot[][] models) {
		SlotSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SlotSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SlotSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SlotSoap[] toSoapModels(List<Slot> models) {
		List<SlotSoap> soapModels = new ArrayList<SlotSoap>(models.size());

		for (Slot model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SlotSoap[soapModels.size()]);
	}

	public SlotSoap() {
	}

	public long getPrimaryKey() {
		return _slotId;
	}

	public void setPrimaryKey(long pk) {
		setSlotId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSlotId() {
		return _slotId;
	}

	public void setSlotId(long slotId) {
		_slotId = slotId;
	}

	public long getDayOfWeek() {
		return _dayOfWeek;
	}

	public void setDayOfWeek(long dayOfWeek) {
		_dayOfWeek = dayOfWeek;
	}

	public String getStartHour() {
		return _startHour;
	}

	public void setStartHour(String startHour) {
		_startHour = startHour;
	}

	public String getEndHour() {
		return _endHour;
	}

	public void setEndHour(String endHour) {
		_endHour = endHour;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public long getPeriodId() {
		return _periodId;
	}

	public void setPeriodId(long periodId) {
		_periodId = periodId;
	}

	public long getSubPlaceId() {
		return _subPlaceId;
	}

	public void setSubPlaceId(long subPlaceId) {
		_subPlaceId = subPlaceId;
	}

	private String _uuid;
	private long _slotId;
	private long _dayOfWeek;
	private String _startHour;
	private String _endHour;
	private String _comment;
	private long _periodId;
	private long _subPlaceId;

}