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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.agenda.service.http.ManifestationServiceSoap}.
 *
 * @author BenjaminBini
 * @generated
 */
public class ManifestationSoap implements Serializable {

	public static ManifestationSoap toSoapModel(Manifestation model) {
		ManifestationSoap soapModel = new ManifestationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setManifestationId(model.getManifestationId());
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
		soapModel.setImageId(model.getImageId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setExternalImageURL(model.getExternalImageURL());
		soapModel.setExternalImageCopyright(model.getExternalImageCopyright());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setSource(model.getSource());
		soapModel.setIdSource(model.getIdSource());
		soapModel.setPublicationDate(model.getPublicationDate());
		soapModel.setCreateDateSource(model.getCreateDateSource());
		soapModel.setModifiedDateSource(model.getModifiedDateSource());

		return soapModel;
	}

	public static ManifestationSoap[] toSoapModels(Manifestation[] models) {
		ManifestationSoap[] soapModels = new ManifestationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ManifestationSoap[][] toSoapModels(Manifestation[][] models) {
		ManifestationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ManifestationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ManifestationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ManifestationSoap[] toSoapModels(List<Manifestation> models) {
		List<ManifestationSoap> soapModels = new ArrayList<ManifestationSoap>(
			models.size());

		for (Manifestation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ManifestationSoap[soapModels.size()]);
	}

	public ManifestationSoap() {
	}

	public long getPrimaryKey() {
		return _manifestationId;
	}

	public void setPrimaryKey(long pk) {
		setManifestationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getManifestationId() {
		return _manifestationId;
	}

	public void setManifestationId(long manifestationId) {
		_manifestationId = manifestationId;
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

	public Long getImageId() {
		return _imageId;
	}

	public void setImageId(Long imageId) {
		_imageId = imageId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getExternalImageURL() {
		return _externalImageURL;
	}

	public void setExternalImageURL(String externalImageURL) {
		_externalImageURL = externalImageURL;
	}

	public String getExternalImageCopyright() {
		return _externalImageCopyright;
	}

	public void setExternalImageCopyright(String externalImageCopyright) {
		_externalImageCopyright = externalImageCopyright;
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

	public String getSource() {
		return _source;
	}

	public void setSource(String source) {
		_source = source;
	}

	public String getIdSource() {
		return _idSource;
	}

	public void setIdSource(String idSource) {
		_idSource = idSource;
	}

	public Date getPublicationDate() {
		return _publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	public Date getCreateDateSource() {
		return _createDateSource;
	}

	public void setCreateDateSource(Date createDateSource) {
		_createDateSource = createDateSource;
	}

	public Date getModifiedDateSource() {
		return _modifiedDateSource;
	}

	public void setModifiedDateSource(Date modifiedDateSource) {
		_modifiedDateSource = modifiedDateSource;
	}

	private String _uuid;
	private long _manifestationId;
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
	private Long _imageId;
	private String _title;
	private String _description;
	private String _externalImageURL;
	private String _externalImageCopyright;
	private Date _startDate;
	private Date _endDate;
	private String _source;
	private String _idSource;
	private Date _publicationDate;
	private Date _createDateSource;
	private Date _modifiedDateSource;

}