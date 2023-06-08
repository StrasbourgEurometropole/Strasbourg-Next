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

package eu.strasbourg.service.comment.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.comment.service.http.CommentServiceSoap}.
 *
 * @author Romain Vergnais
 * @generated
 */
public class CommentSoap implements Serializable {

	public static CommentSoap toSoapModel(Comment model) {
		CommentSoap soapModel = new CommentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCommentId(model.getCommentId());
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
		soapModel.setText(model.getText());
		soapModel.setLevel(model.getLevel());
		soapModel.setUserQuality(model.getUserQuality());
		soapModel.setModifiedByUserDate(model.getModifiedByUserDate());
		soapModel.setAssetEntryId(model.getAssetEntryId());
		soapModel.setPublikId(model.getPublikId());
		soapModel.setParentCommentId(model.getParentCommentId());
		soapModel.setUrlProjectCommentaire(model.getUrlProjectCommentaire());

		return soapModel;
	}

	public static CommentSoap[] toSoapModels(Comment[] models) {
		CommentSoap[] soapModels = new CommentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[][] toSoapModels(Comment[][] models) {
		CommentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CommentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CommentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CommentSoap[] toSoapModels(List<Comment> models) {
		List<CommentSoap> soapModels = new ArrayList<CommentSoap>(
			models.size());

		for (Comment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CommentSoap[soapModels.size()]);
	}

	public CommentSoap() {
	}

	public long getPrimaryKey() {
		return _commentId;
	}

	public void setPrimaryKey(long pk) {
		setCommentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCommentId() {
		return _commentId;
	}

	public void setCommentId(long commentId) {
		_commentId = commentId;
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

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public String getUserQuality() {
		return _userQuality;
	}

	public void setUserQuality(String userQuality) {
		_userQuality = userQuality;
	}

	public Date getModifiedByUserDate() {
		return _modifiedByUserDate;
	}

	public void setModifiedByUserDate(Date modifiedByUserDate) {
		_modifiedByUserDate = modifiedByUserDate;
	}

	public long getAssetEntryId() {
		return _assetEntryId;
	}

	public void setAssetEntryId(long assetEntryId) {
		_assetEntryId = assetEntryId;
	}

	public String getPublikId() {
		return _publikId;
	}

	public void setPublikId(String publikId) {
		_publikId = publikId;
	}

	public long getParentCommentId() {
		return _parentCommentId;
	}

	public void setParentCommentId(long parentCommentId) {
		_parentCommentId = parentCommentId;
	}

	public String getUrlProjectCommentaire() {
		return _urlProjectCommentaire;
	}

	public void setUrlProjectCommentaire(String urlProjectCommentaire) {
		_urlProjectCommentaire = urlProjectCommentaire;
	}

	private String _uuid;
	private long _commentId;
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
	private String _text;
	private int _level;
	private String _userQuality;
	private Date _modifiedByUserDate;
	private long _assetEntryId;
	private String _publikId;
	private long _parentCommentId;
	private String _urlProjectCommentaire;

}