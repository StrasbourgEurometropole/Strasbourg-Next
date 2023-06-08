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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.project.service.http.BudgetParticipatifServiceSoap}.
 *
 * @author Cedric Henry
 * @generated
 */
public class BudgetParticipatifSoap implements Serializable {

	public static BudgetParticipatifSoap toSoapModel(BudgetParticipatif model) {
		BudgetParticipatifSoap soapModel = new BudgetParticipatifSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBudgetParticipatifId(model.getBudgetParticipatifId());
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
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setSummary(model.getSummary());
		soapModel.setBudget(model.getBudget());
		soapModel.setMotif(model.getMotif());
		soapModel.setPlaceTextArea(model.getPlaceTextArea());
		soapModel.setInTheNameOf(model.getInTheNameOf());
		soapModel.setCitoyenLastname(model.getCitoyenLastname());
		soapModel.setCitoyenFirstname(model.getCitoyenFirstname());
		soapModel.setCitoyenAdresse(model.getCitoyenAdresse());
		soapModel.setCitoyenPostalCode(model.getCitoyenPostalCode());
		soapModel.setCitoyenCity(model.getCitoyenCity());
		soapModel.setCitoyenPhone(model.getCitoyenPhone());
		soapModel.setCitoyenMobile(model.getCitoyenMobile());
		soapModel.setCitoyenEmail(model.getCitoyenEmail());
		soapModel.setCitoyenBirthday(model.getCitoyenBirthday());
		soapModel.setHasCopyright(model.isHasCopyright());
		soapModel.setVideoUrl(model.getVideoUrl());
		soapModel.setImageTimeline(model.getImageTimeline());
		soapModel.setOpacityImage(model.getOpacityImage());
		soapModel.setIsCrush(model.isIsCrush());
		soapModel.setCrushComment(model.getCrushComment());
		soapModel.setPublikId(model.getPublikId());
		soapModel.setImageId(model.getImageId());
		soapModel.setFilesIds(model.getFilesIds());
		soapModel.setBudgetPhaseId(model.getBudgetPhaseId());
		soapModel.setParentId(model.getParentId());

		return soapModel;
	}

	public static BudgetParticipatifSoap[] toSoapModels(
		BudgetParticipatif[] models) {

		BudgetParticipatifSoap[] soapModels =
			new BudgetParticipatifSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BudgetParticipatifSoap[][] toSoapModels(
		BudgetParticipatif[][] models) {

		BudgetParticipatifSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new BudgetParticipatifSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BudgetParticipatifSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BudgetParticipatifSoap[] toSoapModels(
		List<BudgetParticipatif> models) {

		List<BudgetParticipatifSoap> soapModels =
			new ArrayList<BudgetParticipatifSoap>(models.size());

		for (BudgetParticipatif model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new BudgetParticipatifSoap[soapModels.size()]);
	}

	public BudgetParticipatifSoap() {
	}

	public long getPrimaryKey() {
		return _budgetParticipatifId;
	}

	public void setPrimaryKey(long pk) {
		setBudgetParticipatifId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBudgetParticipatifId() {
		return _budgetParticipatifId;
	}

	public void setBudgetParticipatifId(long budgetParticipatifId) {
		_budgetParticipatifId = budgetParticipatifId;
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

	public String getSummary() {
		return _summary;
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	public String getBudget() {
		return _budget;
	}

	public void setBudget(String budget) {
		_budget = budget;
	}

	public String getMotif() {
		return _motif;
	}

	public void setMotif(String motif) {
		_motif = motif;
	}

	public String getPlaceTextArea() {
		return _placeTextArea;
	}

	public void setPlaceTextArea(String placeTextArea) {
		_placeTextArea = placeTextArea;
	}

	public String getInTheNameOf() {
		return _inTheNameOf;
	}

	public void setInTheNameOf(String inTheNameOf) {
		_inTheNameOf = inTheNameOf;
	}

	public String getCitoyenLastname() {
		return _citoyenLastname;
	}

	public void setCitoyenLastname(String citoyenLastname) {
		_citoyenLastname = citoyenLastname;
	}

	public String getCitoyenFirstname() {
		return _citoyenFirstname;
	}

	public void setCitoyenFirstname(String citoyenFirstname) {
		_citoyenFirstname = citoyenFirstname;
	}

	public String getCitoyenAdresse() {
		return _citoyenAdresse;
	}

	public void setCitoyenAdresse(String citoyenAdresse) {
		_citoyenAdresse = citoyenAdresse;
	}

	public long getCitoyenPostalCode() {
		return _citoyenPostalCode;
	}

	public void setCitoyenPostalCode(long citoyenPostalCode) {
		_citoyenPostalCode = citoyenPostalCode;
	}

	public String getCitoyenCity() {
		return _citoyenCity;
	}

	public void setCitoyenCity(String citoyenCity) {
		_citoyenCity = citoyenCity;
	}

	public String getCitoyenPhone() {
		return _citoyenPhone;
	}

	public void setCitoyenPhone(String citoyenPhone) {
		_citoyenPhone = citoyenPhone;
	}

	public String getCitoyenMobile() {
		return _citoyenMobile;
	}

	public void setCitoyenMobile(String citoyenMobile) {
		_citoyenMobile = citoyenMobile;
	}

	public String getCitoyenEmail() {
		return _citoyenEmail;
	}

	public void setCitoyenEmail(String citoyenEmail) {
		_citoyenEmail = citoyenEmail;
	}

	public Date getCitoyenBirthday() {
		return _citoyenBirthday;
	}

	public void setCitoyenBirthday(Date citoyenBirthday) {
		_citoyenBirthday = citoyenBirthday;
	}

	public boolean getHasCopyright() {
		return _hasCopyright;
	}

	public boolean isHasCopyright() {
		return _hasCopyright;
	}

	public void setHasCopyright(boolean hasCopyright) {
		_hasCopyright = hasCopyright;
	}

	public String getVideoUrl() {
		return _videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		_videoUrl = videoUrl;
	}

	public long getImageTimeline() {
		return _imageTimeline;
	}

	public void setImageTimeline(long imageTimeline) {
		_imageTimeline = imageTimeline;
	}

	public double getOpacityImage() {
		return _opacityImage;
	}

	public void setOpacityImage(double opacityImage) {
		_opacityImage = opacityImage;
	}

	public boolean getIsCrush() {
		return _isCrush;
	}

	public boolean isIsCrush() {
		return _isCrush;
	}

	public void setIsCrush(boolean isCrush) {
		_isCrush = isCrush;
	}

	public String getCrushComment() {
		return _crushComment;
	}

	public void setCrushComment(String crushComment) {
		_crushComment = crushComment;
	}

	public String getPublikId() {
		return _publikId;
	}

	public void setPublikId(String publikId) {
		_publikId = publikId;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public String getFilesIds() {
		return _filesIds;
	}

	public void setFilesIds(String filesIds) {
		_filesIds = filesIds;
	}

	public long getBudgetPhaseId() {
		return _budgetPhaseId;
	}

	public void setBudgetPhaseId(long budgetPhaseId) {
		_budgetPhaseId = budgetPhaseId;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	private String _uuid;
	private long _budgetParticipatifId;
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
	private String _title;
	private String _description;
	private String _summary;
	private String _budget;
	private String _motif;
	private String _placeTextArea;
	private String _inTheNameOf;
	private String _citoyenLastname;
	private String _citoyenFirstname;
	private String _citoyenAdresse;
	private long _citoyenPostalCode;
	private String _citoyenCity;
	private String _citoyenPhone;
	private String _citoyenMobile;
	private String _citoyenEmail;
	private Date _citoyenBirthday;
	private boolean _hasCopyright;
	private String _videoUrl;
	private long _imageTimeline;
	private double _opacityImage;
	private boolean _isCrush;
	private String _crushComment;
	private String _publikId;
	private long _imageId;
	private String _filesIds;
	private long _budgetPhaseId;
	private long _parentId;

}