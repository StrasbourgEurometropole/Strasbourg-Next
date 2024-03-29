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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class ScheduleExceptionSoap implements Serializable {

	public static ScheduleExceptionSoap toSoapModel(ScheduleException model) {
		ScheduleExceptionSoap soapModel = new ScheduleExceptionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExceptionId(model.getExceptionId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setOpeningTimes(model.getOpeningTimes());
		soapModel.setFirstComment(model.getFirstComment());
		soapModel.setSecondComment(model.getSecondComment());
		soapModel.setThirdComment(model.getThirdComment());
		soapModel.setFourthComment(model.getFourthComment());
		soapModel.setFifthComment(model.getFifthComment());
		soapModel.setComment(model.getComment());
		soapModel.setClosed(model.isClosed());
		soapModel.setPlaceId(model.getPlaceId());
		soapModel.setSubPlaceId(model.getSubPlaceId());

		return soapModel;
	}

	public static ScheduleExceptionSoap[] toSoapModels(
		ScheduleException[] models) {

		ScheduleExceptionSoap[] soapModels =
			new ScheduleExceptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScheduleExceptionSoap[][] toSoapModels(
		ScheduleException[][] models) {

		ScheduleExceptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ScheduleExceptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScheduleExceptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScheduleExceptionSoap[] toSoapModels(
		List<ScheduleException> models) {

		List<ScheduleExceptionSoap> soapModels =
			new ArrayList<ScheduleExceptionSoap>(models.size());

		for (ScheduleException model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScheduleExceptionSoap[soapModels.size()]);
	}

	public ScheduleExceptionSoap() {
	}

	public long getPrimaryKey() {
		return _exceptionId;
	}

	public void setPrimaryKey(long pk) {
		setExceptionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getExceptionId() {
		return _exceptionId;
	}

	public void setExceptionId(long exceptionId) {
		_exceptionId = exceptionId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public String getOpeningTimes() {
		return _openingTimes;
	}

	public void setOpeningTimes(String openingTimes) {
		_openingTimes = openingTimes;
	}

	public String getFirstComment() {
		return _firstComment;
	}

	public void setFirstComment(String firstComment) {
		_firstComment = firstComment;
	}

	public String getSecondComment() {
		return _secondComment;
	}

	public void setSecondComment(String secondComment) {
		_secondComment = secondComment;
	}

	public String getThirdComment() {
		return _thirdComment;
	}

	public void setThirdComment(String thirdComment) {
		_thirdComment = thirdComment;
	}

	public String getFourthComment() {
		return _fourthComment;
	}

	public void setFourthComment(String fourthComment) {
		_fourthComment = fourthComment;
	}

	public String getFifthComment() {
		return _fifthComment;
	}

	public void setFifthComment(String fifthComment) {
		_fifthComment = fifthComment;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public boolean getClosed() {
		return _closed;
	}

	public boolean isClosed() {
		return _closed;
	}

	public void setClosed(boolean closed) {
		_closed = closed;
	}

	public long getPlaceId() {
		return _placeId;
	}

	public void setPlaceId(long placeId) {
		_placeId = placeId;
	}

	public long getSubPlaceId() {
		return _subPlaceId;
	}

	public void setSubPlaceId(long subPlaceId) {
		_subPlaceId = subPlaceId;
	}

	private String _uuid;
	private long _exceptionId;
	private Date _startDate;
	private Date _endDate;
	private String _openingTimes;
	private String _firstComment;
	private String _secondComment;
	private String _thirdComment;
	private String _fourthComment;
	private String _fifthComment;
	private String _comment;
	private boolean _closed;
	private long _placeId;
	private long _subPlaceId;

}