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

package eu.strasbourg.service.oidc.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class AnonymisationHistoricSoap implements Serializable {
	public static AnonymisationHistoricSoap toSoapModel(
		AnonymisationHistoric model) {
		AnonymisationHistoricSoap soapModel = new AnonymisationHistoricSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setAnonymisationHistoricId(model.getAnonymisationHistoricId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setResult(model.getResult());
		soapModel.setOperations(model.getOperations());
		soapModel.setErrorDescription(model.getErrorDescription());
		soapModel.setErrorStackTrace(model.getErrorStackTrace());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setFinishDate(model.getFinishDate());

		return soapModel;
	}

	public static AnonymisationHistoricSoap[] toSoapModels(
		AnonymisationHistoric[] models) {
		AnonymisationHistoricSoap[] soapModels = new AnonymisationHistoricSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnonymisationHistoricSoap[][] toSoapModels(
		AnonymisationHistoric[][] models) {
		AnonymisationHistoricSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnonymisationHistoricSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnonymisationHistoricSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnonymisationHistoricSoap[] toSoapModels(
		List<AnonymisationHistoric> models) {
		List<AnonymisationHistoricSoap> soapModels = new ArrayList<AnonymisationHistoricSoap>(models.size());

		for (AnonymisationHistoric model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnonymisationHistoricSoap[soapModels.size()]);
	}

	public AnonymisationHistoricSoap() {
	}

	public long getPrimaryKey() {
		return _anonymisationHistoricId;
	}

	public void setPrimaryKey(long pk) {
		setAnonymisationHistoricId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getAnonymisationHistoricId() {
		return _anonymisationHistoricId;
	}

	public void setAnonymisationHistoricId(long anonymisationHistoricId) {
		_anonymisationHistoricId = anonymisationHistoricId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public int getResult() {
		return _result;
	}

	public void setResult(int result) {
		_result = result;
	}

	public String getOperations() {
		return _operations;
	}

	public void setOperations(String operations) {
		_operations = operations;
	}

	public String getErrorDescription() {
		return _errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		_errorDescription = errorDescription;
	}

	public String getErrorStackTrace() {
		return _errorStackTrace;
	}

	public void setErrorStackTrace(String errorStackTrace) {
		_errorStackTrace = errorStackTrace;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getFinishDate() {
		return _finishDate;
	}

	public void setFinishDate(Date finishDate) {
		_finishDate = finishDate;
	}

	private String _uuid;
	private long _anonymisationHistoricId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private int _result;
	private String _operations;
	private String _errorDescription;
	private String _errorStackTrace;
	private Date _startDate;
	private Date _finishDate;
}