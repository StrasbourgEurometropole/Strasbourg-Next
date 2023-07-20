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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link SaisineObservatoire}.
 * </p>
 *
 * @author Cedric Henry
 * @see SaisineObservatoire
 * @generated
 */
public class SaisineObservatoireWrapper
	implements ModelWrapper<SaisineObservatoire>, SaisineObservatoire {

	public SaisineObservatoireWrapper(SaisineObservatoire saisineObservatoire) {
		_saisineObservatoire = saisineObservatoire;
	}

	@Override
	public Class<?> getModelClass() {
		return SaisineObservatoire.class;
	}

	@Override
	public String getModelClassName() {
		return SaisineObservatoire.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("saisineObservatoireId", getSaisineObservatoireId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("title", getTitle());
		attributes.put("summary", getSummary());
		attributes.put("description", getDescription());
		attributes.put("placeTextArea", getPlaceTextArea());
		attributes.put("filesDownload", getFilesDownload());
		attributes.put("inTheNameOf", getInTheNameOf());
		attributes.put("isOfficial", isIsOfficial());
		attributes.put("cityResponse", getCityResponse());
		attributes.put("projectTarget", getProjectTarget());
		attributes.put("petitionnaireLastname", getPetitionnaireLastname());
		attributes.put("petitionnaireFirstname", getPetitionnaireFirstname());
		attributes.put("petitionnaireBirthday", getPetitionnaireBirthday());
		attributes.put("petitionnaireAdresse", getPetitionnaireAdresse());
		attributes.put("petitionnairePostalCode", getPetitionnairePostalCode());
		attributes.put("petitionnaireCity", getPetitionnaireCity());
		attributes.put("petitionnairePhone", getPetitionnairePhone());
		attributes.put("petitionnaireEmail", getPetitionnaireEmail());
		attributes.put("isSupported", isIsSupported());
		attributes.put("supportedBy", getSupportedBy());
		attributes.put("videoUrl", getVideoUrl());
		attributes.put("externalImageURL", getExternalImageURL());
		attributes.put("externalImageCopyright", getExternalImageCopyright());
		attributes.put("mediaChoice", isMediaChoice());
		attributes.put("publikId", getPublikId());
		attributes.put("imageId", getImageId());
		attributes.put("filesIds", getFilesIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long saisineObservatoireId = (Long)attributes.get(
			"saisineObservatoireId");

		if (saisineObservatoireId != null) {
			setSaisineObservatoireId(saisineObservatoireId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String summary = (String)attributes.get("summary");

		if (summary != null) {
			setSummary(summary);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String placeTextArea = (String)attributes.get("placeTextArea");

		if (placeTextArea != null) {
			setPlaceTextArea(placeTextArea);
		}

		String filesDownload = (String)attributes.get("filesDownload");

		if (filesDownload != null) {
			setFilesDownload(filesDownload);
		}

		String inTheNameOf = (String)attributes.get("inTheNameOf");

		if (inTheNameOf != null) {
			setInTheNameOf(inTheNameOf);
		}

		Boolean isOfficial = (Boolean)attributes.get("isOfficial");

		if (isOfficial != null) {
			setIsOfficial(isOfficial);
		}

		String cityResponse = (String)attributes.get("cityResponse");

		if (cityResponse != null) {
			setCityResponse(cityResponse);
		}

		String projectTarget = (String)attributes.get("projectTarget");

		if (projectTarget != null) {
			setProjectTarget(projectTarget);
		}

		String petitionnaireLastname = (String)attributes.get(
			"petitionnaireLastname");

		if (petitionnaireLastname != null) {
			setPetitionnaireLastname(petitionnaireLastname);
		}

		String petitionnaireFirstname = (String)attributes.get(
			"petitionnaireFirstname");

		if (petitionnaireFirstname != null) {
			setPetitionnaireFirstname(petitionnaireFirstname);
		}

		Date petitionnaireBirthday = (Date)attributes.get(
			"petitionnaireBirthday");

		if (petitionnaireBirthday != null) {
			setPetitionnaireBirthday(petitionnaireBirthday);
		}

		String petitionnaireAdresse = (String)attributes.get(
			"petitionnaireAdresse");

		if (petitionnaireAdresse != null) {
			setPetitionnaireAdresse(petitionnaireAdresse);
		}

		Long petitionnairePostalCode = (Long)attributes.get(
			"petitionnairePostalCode");

		if (petitionnairePostalCode != null) {
			setPetitionnairePostalCode(petitionnairePostalCode);
		}

		String petitionnaireCity = (String)attributes.get("petitionnaireCity");

		if (petitionnaireCity != null) {
			setPetitionnaireCity(petitionnaireCity);
		}

		String petitionnairePhone = (String)attributes.get(
			"petitionnairePhone");

		if (petitionnairePhone != null) {
			setPetitionnairePhone(petitionnairePhone);
		}

		String petitionnaireEmail = (String)attributes.get(
			"petitionnaireEmail");

		if (petitionnaireEmail != null) {
			setPetitionnaireEmail(petitionnaireEmail);
		}

		Boolean isSupported = (Boolean)attributes.get("isSupported");

		if (isSupported != null) {
			setIsSupported(isSupported);
		}

		String supportedBy = (String)attributes.get("supportedBy");

		if (supportedBy != null) {
			setSupportedBy(supportedBy);
		}

		String videoUrl = (String)attributes.get("videoUrl");

		if (videoUrl != null) {
			setVideoUrl(videoUrl);
		}

		String externalImageURL = (String)attributes.get("externalImageURL");

		if (externalImageURL != null) {
			setExternalImageURL(externalImageURL);
		}

		String externalImageCopyright = (String)attributes.get(
			"externalImageCopyright");

		if (externalImageCopyright != null) {
			setExternalImageCopyright(externalImageCopyright);
		}

		Boolean mediaChoice = (Boolean)attributes.get("mediaChoice");

		if (mediaChoice != null) {
			setMediaChoice(mediaChoice);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		String filesIds = (String)attributes.get("filesIds");

		if (filesIds != null) {
			setFilesIds(filesIds);
		}
	}

	@Override
	public Object clone() {
		return new SaisineObservatoireWrapper(
			(SaisineObservatoire)_saisineObservatoire.clone());
	}

	@Override
	public int compareTo(
		eu.strasbourg.service.project.model.SaisineObservatoire
			saisineObservatoire) {

		return _saisineObservatoire.compareTo(saisineObservatoire);
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return _saisineObservatoire.getAssetEntry();
	}

	@Override
	public String getAuthorLabel() {
		return _saisineObservatoire.getAuthorLabel();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return _saisineObservatoire.getCategories();
	}

	/**
	 * Returns the city response of this saisine observatoire.
	 *
	 * @return the city response of this saisine observatoire
	 */
	@Override
	public String getCityResponse() {
		return _saisineObservatoire.getCityResponse();
	}

	/**
	 * Returns the company ID of this saisine observatoire.
	 *
	 * @return the company ID of this saisine observatoire
	 */
	@Override
	public long getCompanyId() {
		return _saisineObservatoire.getCompanyId();
	}

	/**
	 * Returns the create date of this saisine observatoire.
	 *
	 * @return the create date of this saisine observatoire
	 */
	@Override
	public Date getCreateDate() {
		return _saisineObservatoire.getCreateDate();
	}

	/**
	 * Returns the description of this saisine observatoire.
	 *
	 * @return the description of this saisine observatoire
	 */
	@Override
	public String getDescription() {
		return _saisineObservatoire.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _saisineObservatoire.getExpandoBridge();
	}

	/**
	 * Returns the external image copyright of this saisine observatoire.
	 *
	 * @return the external image copyright of this saisine observatoire
	 */
	@Override
	public String getExternalImageCopyright() {
		return _saisineObservatoire.getExternalImageCopyright();
	}

	/**
	 * Returns the external image url of this saisine observatoire.
	 *
	 * @return the external image url of this saisine observatoire
	 */
	@Override
	public String getExternalImageURL() {
		return _saisineObservatoire.getExternalImageURL();
	}

	/**
	 * Returns the files download of this saisine observatoire.
	 *
	 * @return the files download of this saisine observatoire
	 */
	@Override
	public String getFilesDownload() {
		return _saisineObservatoire.getFilesDownload();
	}

	/**
	 * Returns the files IDs of this saisine observatoire.
	 *
	 * @return the files IDs of this saisine observatoire
	 */
	@Override
	public String getFilesIds() {
		return _saisineObservatoire.getFilesIds();
	}

	/**
	 * Returns the group ID of this saisine observatoire.
	 *
	 * @return the group ID of this saisine observatoire
	 */
	@Override
	public long getGroupId() {
		return _saisineObservatoire.getGroupId();
	}

	/**
	 * Returns the image ID of this saisine observatoire.
	 *
	 * @return the image ID of this saisine observatoire
	 */
	@Override
	public long getImageId() {
		return _saisineObservatoire.getImageId();
	}

	/**
	 * Returns the in the name of of this saisine observatoire.
	 *
	 * @return the in the name of of this saisine observatoire
	 */
	@Override
	public String getInTheNameOf() {
		return _saisineObservatoire.getInTheNameOf();
	}

	/**
	 * Returns the is official of this saisine observatoire.
	 *
	 * @return the is official of this saisine observatoire
	 */
	@Override
	public boolean getIsOfficial() {
		return _saisineObservatoire.getIsOfficial();
	}

	/**
	 * Returns the is supported of this saisine observatoire.
	 *
	 * @return the is supported of this saisine observatoire
	 */
	@Override
	public boolean getIsSupported() {
		return _saisineObservatoire.getIsSupported();
	}

	/**
	 * Returns the media choice of this saisine observatoire.
	 *
	 * @return the media choice of this saisine observatoire
	 */
	@Override
	public boolean getMediaChoice() {
		return _saisineObservatoire.getMediaChoice();
	}

	/**
	 * Returns the modified date of this saisine observatoire.
	 *
	 * @return the modified date of this saisine observatoire
	 */
	@Override
	public Date getModifiedDate() {
		return _saisineObservatoire.getModifiedDate();
	}

	/**
	 * Returns the petitionnaire adresse of this saisine observatoire.
	 *
	 * @return the petitionnaire adresse of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireAdresse() {
		return _saisineObservatoire.getPetitionnaireAdresse();
	}

	/**
	 * Returns the petitionnaire birthday of this saisine observatoire.
	 *
	 * @return the petitionnaire birthday of this saisine observatoire
	 */
	@Override
	public Date getPetitionnaireBirthday() {
		return _saisineObservatoire.getPetitionnaireBirthday();
	}

	/**
	 * Returns the petitionnaire city of this saisine observatoire.
	 *
	 * @return the petitionnaire city of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireCity() {
		return _saisineObservatoire.getPetitionnaireCity();
	}

	/**
	 * Returns the petitionnaire email of this saisine observatoire.
	 *
	 * @return the petitionnaire email of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireEmail() {
		return _saisineObservatoire.getPetitionnaireEmail();
	}

	/**
	 * Returns the petitionnaire firstname of this saisine observatoire.
	 *
	 * @return the petitionnaire firstname of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireFirstname() {
		return _saisineObservatoire.getPetitionnaireFirstname();
	}

	/**
	 * Returns the petitionnaire lastname of this saisine observatoire.
	 *
	 * @return the petitionnaire lastname of this saisine observatoire
	 */
	@Override
	public String getPetitionnaireLastname() {
		return _saisineObservatoire.getPetitionnaireLastname();
	}

	/**
	 * Returns the petitionnaire phone of this saisine observatoire.
	 *
	 * @return the petitionnaire phone of this saisine observatoire
	 */
	@Override
	public String getPetitionnairePhone() {
		return _saisineObservatoire.getPetitionnairePhone();
	}

	/**
	 * Returns the petitionnaire postal code of this saisine observatoire.
	 *
	 * @return the petitionnaire postal code of this saisine observatoire
	 */
	@Override
	public long getPetitionnairePostalCode() {
		return _saisineObservatoire.getPetitionnairePostalCode();
	}

	/**
	 * Returns the place text area of this saisine observatoire.
	 *
	 * @return the place text area of this saisine observatoire
	 */
	@Override
	public String getPlaceTextArea() {
		return _saisineObservatoire.getPlaceTextArea();
	}

	/**
	 * Retourne la liste des lieux placit liés à la petition
	 */
	@Override
	public java.util.List<eu.strasbourg.service.project.model.PlacitPlace>
		getPlacitPlaces() {

		return _saisineObservatoire.getPlacitPlaces();
	}

	/**
	 * Returns the primary key of this saisine observatoire.
	 *
	 * @return the primary key of this saisine observatoire
	 */
	@Override
	public long getPrimaryKey() {
		return _saisineObservatoire.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _saisineObservatoire.getPrimaryKeyObj();
	}

	/**
	 * Returns the project target of this saisine observatoire.
	 *
	 * @return the project target of this saisine observatoire
	 */
	@Override
	public String getProjectTarget() {
		return _saisineObservatoire.getProjectTarget();
	}

	/**
	 * Returns the publik ID of this saisine observatoire.
	 *
	 * @return the publik ID of this saisine observatoire
	 */
	@Override
	public String getPublikId() {
		return _saisineObservatoire.getPublikId();
	}

	/**
	 * Returns the saisine observatoire ID of this saisine observatoire.
	 *
	 * @return the saisine observatoire ID of this saisine observatoire
	 */
	@Override
	public long getSaisineObservatoireId() {
		return _saisineObservatoire.getSaisineObservatoireId();
	}

	/**
	 * méthode de récupération du status
	 *
	 * @return le status.
	 */
	@Override
	public String getSaisineObservatoireStatus() {
		return _saisineObservatoire.getSaisineObservatoireStatus();
	}

	/**
	 * Returns the status of this saisine observatoire.
	 *
	 * @return the status of this saisine observatoire
	 */
	@Override
	public int getStatus() {
		return _saisineObservatoire.getStatus();
	}

	/**
	 * Returns the status by user ID of this saisine observatoire.
	 *
	 * @return the status by user ID of this saisine observatoire
	 */
	@Override
	public long getStatusByUserId() {
		return _saisineObservatoire.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this saisine observatoire.
	 *
	 * @return the status by user name of this saisine observatoire
	 */
	@Override
	public String getStatusByUserName() {
		return _saisineObservatoire.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this saisine observatoire.
	 *
	 * @return the status by user uuid of this saisine observatoire
	 */
	@Override
	public String getStatusByUserUuid() {
		return _saisineObservatoire.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this saisine observatoire.
	 *
	 * @return the status date of this saisine observatoire
	 */
	@Override
	public Date getStatusDate() {
		return _saisineObservatoire.getStatusDate();
	}

	/**
	 * Returns the summary of this saisine observatoire.
	 *
	 * @return the summary of this saisine observatoire
	 */
	@Override
	public String getSummary() {
		return _saisineObservatoire.getSummary();
	}

	/**
	 * Returns the supported by of this saisine observatoire.
	 *
	 * @return the supported by of this saisine observatoire
	 */
	@Override
	public String getSupportedBy() {
		return _saisineObservatoire.getSupportedBy();
	}

	/**
	 * Returns the title of this saisine observatoire.
	 *
	 * @return the title of this saisine observatoire
	 */
	@Override
	public String getTitle() {
		return _saisineObservatoire.getTitle();
	}

	/**
	 * Returns the user ID of this saisine observatoire.
	 *
	 * @return the user ID of this saisine observatoire
	 */
	@Override
	public long getUserId() {
		return _saisineObservatoire.getUserId();
	}

	/**
	 * Returns the user name of this saisine observatoire.
	 *
	 * @return the user name of this saisine observatoire
	 */
	@Override
	public String getUserName() {
		return _saisineObservatoire.getUserName();
	}

	/**
	 * Returns the user uuid of this saisine observatoire.
	 *
	 * @return the user uuid of this saisine observatoire
	 */
	@Override
	public String getUserUuid() {
		return _saisineObservatoire.getUserUuid();
	}

	/**
	 * Returns the video url of this saisine observatoire.
	 *
	 * @return the video url of this saisine observatoire
	 */
	@Override
	public String getVideoUrl() {
		return _saisineObservatoire.getVideoUrl();
	}

	@Override
	public int hashCode() {
		return _saisineObservatoire.hashCode();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is approved.
	 *
	 * @return <code>true</code> if this saisine observatoire is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return _saisineObservatoire.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _saisineObservatoire.isCachedModel();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is denied.
	 *
	 * @return <code>true</code> if this saisine observatoire is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return _saisineObservatoire.isDenied();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is a draft.
	 *
	 * @return <code>true</code> if this saisine observatoire is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return _saisineObservatoire.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _saisineObservatoire.isEscapedModel();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is expired.
	 *
	 * @return <code>true</code> if this saisine observatoire is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return _saisineObservatoire.isExpired();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is inactive.
	 *
	 * @return <code>true</code> if this saisine observatoire is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return _saisineObservatoire.isInactive();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is incomplete.
	 *
	 * @return <code>true</code> if this saisine observatoire is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return _saisineObservatoire.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is is official.
	 *
	 * @return <code>true</code> if this saisine observatoire is is official; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsOfficial() {
		return _saisineObservatoire.isIsOfficial();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is is supported.
	 *
	 * @return <code>true</code> if this saisine observatoire is is supported; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsSupported() {
		return _saisineObservatoire.isIsSupported();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is media choice.
	 *
	 * @return <code>true</code> if this saisine observatoire is media choice; <code>false</code> otherwise
	 */
	@Override
	public boolean isMediaChoice() {
		return _saisineObservatoire.isMediaChoice();
	}

	@Override
	public boolean isNew() {
		return _saisineObservatoire.isNew();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is pending.
	 *
	 * @return <code>true</code> if this saisine observatoire is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return _saisineObservatoire.isPending();
	}

	/**
	 * Returns <code>true</code> if this saisine observatoire is scheduled.
	 *
	 * @return <code>true</code> if this saisine observatoire is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return _saisineObservatoire.isScheduled();
	}

	@Override
	public void persist() {
		_saisineObservatoire.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_saisineObservatoire.setCachedModel(cachedModel);
	}

	/**
	 * Sets the city response of this saisine observatoire.
	 *
	 * @param cityResponse the city response of this saisine observatoire
	 */
	@Override
	public void setCityResponse(String cityResponse) {
		_saisineObservatoire.setCityResponse(cityResponse);
	}

	/**
	 * Sets the company ID of this saisine observatoire.
	 *
	 * @param companyId the company ID of this saisine observatoire
	 */
	@Override
	public void setCompanyId(long companyId) {
		_saisineObservatoire.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this saisine observatoire.
	 *
	 * @param createDate the create date of this saisine observatoire
	 */
	@Override
	public void setCreateDate(Date createDate) {
		_saisineObservatoire.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this saisine observatoire.
	 *
	 * @param description the description of this saisine observatoire
	 */
	@Override
	public void setDescription(String description) {
		_saisineObservatoire.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {

		_saisineObservatoire.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_saisineObservatoire.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_saisineObservatoire.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	 * Sets the external image copyright of this saisine observatoire.
	 *
	 * @param externalImageCopyright the external image copyright of this saisine observatoire
	 */
	@Override
	public void setExternalImageCopyright(String externalImageCopyright) {
		_saisineObservatoire.setExternalImageCopyright(externalImageCopyright);
	}

	/**
	 * Sets the external image url of this saisine observatoire.
	 *
	 * @param externalImageURL the external image url of this saisine observatoire
	 */
	@Override
	public void setExternalImageURL(String externalImageURL) {
		_saisineObservatoire.setExternalImageURL(externalImageURL);
	}

	/**
	 * Sets the files download of this saisine observatoire.
	 *
	 * @param filesDownload the files download of this saisine observatoire
	 */
	@Override
	public void setFilesDownload(String filesDownload) {
		_saisineObservatoire.setFilesDownload(filesDownload);
	}

	/**
	 * Sets the files IDs of this saisine observatoire.
	 *
	 * @param filesIds the files IDs of this saisine observatoire
	 */
	@Override
	public void setFilesIds(String filesIds) {
		_saisineObservatoire.setFilesIds(filesIds);
	}

	/**
	 * Sets the group ID of this saisine observatoire.
	 *
	 * @param groupId the group ID of this saisine observatoire
	 */
	@Override
	public void setGroupId(long groupId) {
		_saisineObservatoire.setGroupId(groupId);
	}

	/**
	 * Sets the image ID of this saisine observatoire.
	 *
	 * @param imageId the image ID of this saisine observatoire
	 */
	@Override
	public void setImageId(long imageId) {
		_saisineObservatoire.setImageId(imageId);
	}

	/**
	 * Sets the in the name of of this saisine observatoire.
	 *
	 * @param inTheNameOf the in the name of of this saisine observatoire
	 */
	@Override
	public void setInTheNameOf(String inTheNameOf) {
		_saisineObservatoire.setInTheNameOf(inTheNameOf);
	}

	/**
	 * Sets whether this saisine observatoire is is official.
	 *
	 * @param isOfficial the is official of this saisine observatoire
	 */
	@Override
	public void setIsOfficial(boolean isOfficial) {
		_saisineObservatoire.setIsOfficial(isOfficial);
	}

	/**
	 * Sets whether this saisine observatoire is is supported.
	 *
	 * @param isSupported the is supported of this saisine observatoire
	 */
	@Override
	public void setIsSupported(boolean isSupported) {
		_saisineObservatoire.setIsSupported(isSupported);
	}

	/**
	 * Sets whether this saisine observatoire is media choice.
	 *
	 * @param mediaChoice the media choice of this saisine observatoire
	 */
	@Override
	public void setMediaChoice(boolean mediaChoice) {
		_saisineObservatoire.setMediaChoice(mediaChoice);
	}

	/**
	 * Sets the modified date of this saisine observatoire.
	 *
	 * @param modifiedDate the modified date of this saisine observatoire
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_saisineObservatoire.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_saisineObservatoire.setNew(n);
	}

	/**
	 * Sets the petitionnaire adresse of this saisine observatoire.
	 *
	 * @param petitionnaireAdresse the petitionnaire adresse of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireAdresse(String petitionnaireAdresse) {
		_saisineObservatoire.setPetitionnaireAdresse(petitionnaireAdresse);
	}

	/**
	 * Sets the petitionnaire birthday of this saisine observatoire.
	 *
	 * @param petitionnaireBirthday the petitionnaire birthday of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireBirthday(Date petitionnaireBirthday) {
		_saisineObservatoire.setPetitionnaireBirthday(petitionnaireBirthday);
	}

	/**
	 * Sets the petitionnaire city of this saisine observatoire.
	 *
	 * @param petitionnaireCity the petitionnaire city of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireCity(String petitionnaireCity) {
		_saisineObservatoire.setPetitionnaireCity(petitionnaireCity);
	}

	/**
	 * Sets the petitionnaire email of this saisine observatoire.
	 *
	 * @param petitionnaireEmail the petitionnaire email of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireEmail(String petitionnaireEmail) {
		_saisineObservatoire.setPetitionnaireEmail(petitionnaireEmail);
	}

	/**
	 * Sets the petitionnaire firstname of this saisine observatoire.
	 *
	 * @param petitionnaireFirstname the petitionnaire firstname of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireFirstname(String petitionnaireFirstname) {
		_saisineObservatoire.setPetitionnaireFirstname(petitionnaireFirstname);
	}

	/**
	 * Sets the petitionnaire lastname of this saisine observatoire.
	 *
	 * @param petitionnaireLastname the petitionnaire lastname of this saisine observatoire
	 */
	@Override
	public void setPetitionnaireLastname(String petitionnaireLastname) {
		_saisineObservatoire.setPetitionnaireLastname(petitionnaireLastname);
	}

	/**
	 * Sets the petitionnaire phone of this saisine observatoire.
	 *
	 * @param petitionnairePhone the petitionnaire phone of this saisine observatoire
	 */
	@Override
	public void setPetitionnairePhone(String petitionnairePhone) {
		_saisineObservatoire.setPetitionnairePhone(petitionnairePhone);
	}

	/**
	 * Sets the petitionnaire postal code of this saisine observatoire.
	 *
	 * @param petitionnairePostalCode the petitionnaire postal code of this saisine observatoire
	 */
	@Override
	public void setPetitionnairePostalCode(long petitionnairePostalCode) {
		_saisineObservatoire.setPetitionnairePostalCode(
			petitionnairePostalCode);
	}

	/**
	 * Sets the place text area of this saisine observatoire.
	 *
	 * @param placeTextArea the place text area of this saisine observatoire
	 */
	@Override
	public void setPlaceTextArea(String placeTextArea) {
		_saisineObservatoire.setPlaceTextArea(placeTextArea);
	}

	/**
	 * Sets the primary key of this saisine observatoire.
	 *
	 * @param primaryKey the primary key of this saisine observatoire
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		_saisineObservatoire.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_saisineObservatoire.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	 * Sets the project target of this saisine observatoire.
	 *
	 * @param projectTarget the project target of this saisine observatoire
	 */
	@Override
	public void setProjectTarget(String projectTarget) {
		_saisineObservatoire.setProjectTarget(projectTarget);
	}

	/**
	 * Sets the publik ID of this saisine observatoire.
	 *
	 * @param publikId the publik ID of this saisine observatoire
	 */
	@Override
	public void setPublikId(String publikId) {
		_saisineObservatoire.setPublikId(publikId);
	}

	/**
	 * Sets the saisine observatoire ID of this saisine observatoire.
	 *
	 * @param saisineObservatoireId the saisine observatoire ID of this saisine observatoire
	 */
	@Override
	public void setSaisineObservatoireId(long saisineObservatoireId) {
		_saisineObservatoire.setSaisineObservatoireId(saisineObservatoireId);
	}

	/**
	 * Sets the status of this saisine observatoire.
	 *
	 * @param status the status of this saisine observatoire
	 */
	@Override
	public void setStatus(int status) {
		_saisineObservatoire.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this saisine observatoire.
	 *
	 * @param statusByUserId the status by user ID of this saisine observatoire
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_saisineObservatoire.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this saisine observatoire.
	 *
	 * @param statusByUserName the status by user name of this saisine observatoire
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		_saisineObservatoire.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this saisine observatoire.
	 *
	 * @param statusByUserUuid the status by user uuid of this saisine observatoire
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_saisineObservatoire.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this saisine observatoire.
	 *
	 * @param statusDate the status date of this saisine observatoire
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		_saisineObservatoire.setStatusDate(statusDate);
	}

	/**
	 * Sets the summary of this saisine observatoire.
	 *
	 * @param summary the summary of this saisine observatoire
	 */
	@Override
	public void setSummary(String summary) {
		_saisineObservatoire.setSummary(summary);
	}

	/**
	 * Sets the supported by of this saisine observatoire.
	 *
	 * @param supportedBy the supported by of this saisine observatoire
	 */
	@Override
	public void setSupportedBy(String supportedBy) {
		_saisineObservatoire.setSupportedBy(supportedBy);
	}

	/**
	 * Sets the title of this saisine observatoire.
	 *
	 * @param title the title of this saisine observatoire
	 */
	@Override
	public void setTitle(String title) {
		_saisineObservatoire.setTitle(title);
	}

	/**
	 * Sets the user ID of this saisine observatoire.
	 *
	 * @param userId the user ID of this saisine observatoire
	 */
	@Override
	public void setUserId(long userId) {
		_saisineObservatoire.setUserId(userId);
	}

	/**
	 * Sets the user name of this saisine observatoire.
	 *
	 * @param userName the user name of this saisine observatoire
	 */
	@Override
	public void setUserName(String userName) {
		_saisineObservatoire.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this saisine observatoire.
	 *
	 * @param userUuid the user uuid of this saisine observatoire
	 */
	@Override
	public void setUserUuid(String userUuid) {
		_saisineObservatoire.setUserUuid(userUuid);
	}

	/**
	 * Sets the video url of this saisine observatoire.
	 *
	 * @param videoUrl the video url of this saisine observatoire
	 */
	@Override
	public void setVideoUrl(String videoUrl) {
		_saisineObservatoire.setVideoUrl(videoUrl);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel
		<eu.strasbourg.service.project.model.SaisineObservatoire>
			toCacheModel() {

		return _saisineObservatoire.toCacheModel();
	}

	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		toEscapedModel() {

		return new SaisineObservatoireWrapper(
			_saisineObservatoire.toEscapedModel());
	}

	@Override
	public String toString() {
		return _saisineObservatoire.toString();
	}

	@Override
	public eu.strasbourg.service.project.model.SaisineObservatoire
		toUnescapedModel() {

		return new SaisineObservatoireWrapper(
			_saisineObservatoire.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _saisineObservatoire.toXmlString();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaisineObservatoireWrapper)) {
			return false;
		}

		SaisineObservatoireWrapper saisineObservatoireWrapper =
			(SaisineObservatoireWrapper)object;

		if (Objects.equals(
				_saisineObservatoire,
				saisineObservatoireWrapper._saisineObservatoire)) {

			return true;
		}

		return false;
	}

	@Override
	public SaisineObservatoire getWrappedModel() {
		return _saisineObservatoire;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _saisineObservatoire.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _saisineObservatoire.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_saisineObservatoire.resetOriginalValues();
	}

	private final SaisineObservatoire _saisineObservatoire;

}