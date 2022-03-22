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
public class PublikUserSoap implements Serializable {

	public static PublikUserSoap toSoapModel(PublikUser model) {
		PublikUserSoap soapModel = new PublikUserSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPublikUserLiferayId(model.getPublikUserLiferayId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setPublikId(model.getPublikId());
		soapModel.setAccessToken(model.getAccessToken());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMapConfig(model.getMapConfig());
		soapModel.setDisplayConfig(model.getDisplayConfig());
		soapModel.setPactSignature(model.getPactSignature());
		soapModel.setBanishDate(model.getBanishDate());
		soapModel.setBanishDescription(model.getBanishDescription());
		soapModel.setImageURL(model.getImageURL());
		soapModel.setPactDisplay(model.isPactDisplay());
		soapModel.setCsmapJSON(model.getCsmapJSON());
		soapModel.setModifiedDateJSON(model.getModifiedDateJSON());
		soapModel.setTopicsFCM(model.getTopicsFCM());
		soapModel.setLastUpdateTimeTopics(model.getLastUpdateTimeTopics());

		return soapModel;
	}

	public static PublikUserSoap[] toSoapModels(PublikUser[] models) {
		PublikUserSoap[] soapModels = new PublikUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublikUserSoap[][] toSoapModels(PublikUser[][] models) {
		PublikUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublikUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublikUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublikUserSoap[] toSoapModels(List<PublikUser> models) {
		List<PublikUserSoap> soapModels = new ArrayList<PublikUserSoap>(
			models.size());

		for (PublikUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublikUserSoap[soapModels.size()]);
	}

	public PublikUserSoap() {
	}

	public long getPrimaryKey() {
		return _publikUserLiferayId;
	}

	public void setPrimaryKey(long pk) {
		setPublikUserLiferayId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPublikUserLiferayId() {
		return _publikUserLiferayId;
	}

	public void setPublikUserLiferayId(long publikUserLiferayId) {
		_publikUserLiferayId = publikUserLiferayId;
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

	public String getPublikId() {
		return _publikId;
	}

	public void setPublikId(String publikId) {
		_publikId = publikId;
	}

	public String getAccessToken() {
		return _accessToken;
	}

	public void setAccessToken(String accessToken) {
		_accessToken = accessToken;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMapConfig() {
		return _mapConfig;
	}

	public void setMapConfig(String mapConfig) {
		_mapConfig = mapConfig;
	}

	public String getDisplayConfig() {
		return _displayConfig;
	}

	public void setDisplayConfig(String displayConfig) {
		_displayConfig = displayConfig;
	}

	public Date getPactSignature() {
		return _pactSignature;
	}

	public void setPactSignature(Date pactSignature) {
		_pactSignature = pactSignature;
	}

	public Date getBanishDate() {
		return _banishDate;
	}

	public void setBanishDate(Date banishDate) {
		_banishDate = banishDate;
	}

	public String getBanishDescription() {
		return _banishDescription;
	}

	public void setBanishDescription(String banishDescription) {
		_banishDescription = banishDescription;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
	}

	public boolean getPactDisplay() {
		return _pactDisplay;
	}

	public boolean isPactDisplay() {
		return _pactDisplay;
	}

	public void setPactDisplay(boolean pactDisplay) {
		_pactDisplay = pactDisplay;
	}

	public String getCsmapJSON() {
		return _csmapJSON;
	}

	public void setCsmapJSON(String csmapJSON) {
		_csmapJSON = csmapJSON;
	}

	public Date getModifiedDateJSON() {
		return _modifiedDateJSON;
	}

	public void setModifiedDateJSON(Date modifiedDateJSON) {
		_modifiedDateJSON = modifiedDateJSON;
	}

	public String getTopicsFCM() {
		return _topicsFCM;
	}

	public void setTopicsFCM(String topicsFCM) {
		_topicsFCM = topicsFCM;
	}

	public long getLastUpdateTimeTopics() {
		return _lastUpdateTimeTopics;
	}

	public void setLastUpdateTimeTopics(long lastUpdateTimeTopics) {
		_lastUpdateTimeTopics = lastUpdateTimeTopics;
	}

	private String _uuid;
	private long _publikUserLiferayId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userName;
	private String _publikId;
	private String _accessToken;
	private String _firstName;
	private String _lastName;
	private String _email;
	private String _mapConfig;
	private String _displayConfig;
	private Date _pactSignature;
	private Date _banishDate;
	private String _banishDescription;
	private String _imageURL;
	private boolean _pactDisplay;
	private String _csmapJSON;
	private Date _modifiedDateJSON;
	private String _topicsFCM;
	private long _lastUpdateTimeTopics;

}