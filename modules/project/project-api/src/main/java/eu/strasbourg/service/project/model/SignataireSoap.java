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

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.project.service.http.SignataireServiceSoap}.
 *
 * @author Cedric Henry
 * @see eu.strasbourg.service.project.service.http.SignataireServiceSoap
 * @generated
 */
@ProviderType
public class SignataireSoap implements Serializable {
	public static SignataireSoap toSoapModel(Signataire model) {
		SignataireSoap soapModel = new SignataireSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSignataireId(model.getSignataireId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setSignataireName(model.getSignataireName());
		soapModel.setSignataireFirstname(model.getSignataireFirstname());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setAddress(model.getAddress());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setCity(model.getCity());
		soapModel.setSignatureDate(model.getSignatureDate());
		soapModel.setPublikId(model.getPublikId());
		soapModel.setPetitionId(model.getPetitionId());

		return soapModel;
	}

	public static SignataireSoap[] toSoapModels(Signataire[] models) {
		SignataireSoap[] soapModels = new SignataireSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SignataireSoap[][] toSoapModels(Signataire[][] models) {
		SignataireSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SignataireSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SignataireSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SignataireSoap[] toSoapModels(List<Signataire> models) {
		List<SignataireSoap> soapModels = new ArrayList<SignataireSoap>(models.size());

		for (Signataire model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SignataireSoap[soapModels.size()]);
	}

	public SignataireSoap() {
	}

	public long getPrimaryKey() {
		return _signataireId;
	}

	public void setPrimaryKey(long pk) {
		setSignataireId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSignataireId() {
		return _signataireId;
	}

	public void setSignataireId(long signataireId) {
		_signataireId = signataireId;
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

	public String getSignataireName() {
		return _signataireName;
	}

	public void setSignataireName(String signataireName) {
		_signataireName = signataireName;
	}

	public String getSignataireFirstname() {
		return _signataireFirstname;
	}

	public void setSignataireFirstname(String signataireFirstname) {
		_signataireFirstname = signataireFirstname;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public long getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(long postalCode) {
		_postalCode = postalCode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public Date getSignatureDate() {
		return _signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		_signatureDate = signatureDate;
	}

	public long getPublikId() {
		return _publikId;
	}

	public void setPublikId(long publikId) {
		_publikId = publikId;
	}

	public long getPetitionId() {
		return _petitionId;
	}

	public void setPetitionId(long petitionId) {
		_petitionId = petitionId;
	}

	private String _uuid;
	private long _signataireId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _signataireName;
	private String _signataireFirstname;
	private Date _birthday;
	private String _address;
	private long _postalCode;
	private String _city;
	private Date _signatureDate;
	private long _publikId;
	private long _petitionId;
}