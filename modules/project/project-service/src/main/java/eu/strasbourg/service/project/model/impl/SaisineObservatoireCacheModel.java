/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.SaisineObservatoire;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SaisineObservatoire in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class SaisineObservatoireCacheModel
	implements CacheModel<SaisineObservatoire>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SaisineObservatoireCacheModel)) {
			return false;
		}

		SaisineObservatoireCacheModel saisineObservatoireCacheModel =
			(SaisineObservatoireCacheModel)object;

		if (saisineObservatoireId ==
				saisineObservatoireCacheModel.saisineObservatoireId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, saisineObservatoireId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(69);

		sb.append("{saisineObservatoireId=");
		sb.append(saisineObservatoireId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", placeTextArea=");
		sb.append(placeTextArea);
		sb.append(", filesDownload=");
		sb.append(filesDownload);
		sb.append(", cityResponse=");
		sb.append(cityResponse);
		sb.append(", projectTarget=");
		sb.append(projectTarget);
		sb.append(", otherMechanism=");
		sb.append(otherMechanism);
		sb.append(", collectiveName=");
		sb.append(collectiveName);
		sb.append(", petitionnaireLastname=");
		sb.append(petitionnaireLastname);
		sb.append(", petitionnaireFirstname=");
		sb.append(petitionnaireFirstname);
		sb.append(", petitionnaireBirthday=");
		sb.append(petitionnaireBirthday);
		sb.append(", petitionnaireAdresse=");
		sb.append(petitionnaireAdresse);
		sb.append(", petitionnairePostalCode=");
		sb.append(petitionnairePostalCode);
		sb.append(", petitionnaireCity=");
		sb.append(petitionnaireCity);
		sb.append(", petitionnairePhone=");
		sb.append(petitionnairePhone);
		sb.append(", petitionnaireEmail=");
		sb.append(petitionnaireEmail);
		sb.append(", videoUrl=");
		sb.append(videoUrl);
		sb.append(", externalImageURL=");
		sb.append(externalImageURL);
		sb.append(", externalImageCopyright=");
		sb.append(externalImageCopyright);
		sb.append(", mediaChoice=");
		sb.append(mediaChoice);
		sb.append(", publikId=");
		sb.append(publikId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", filesIds=");
		sb.append(filesIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SaisineObservatoire toEntityModel() {
		SaisineObservatoireImpl saisineObservatoireImpl =
			new SaisineObservatoireImpl();

		saisineObservatoireImpl.setSaisineObservatoireId(saisineObservatoireId);
		saisineObservatoireImpl.setGroupId(groupId);
		saisineObservatoireImpl.setCompanyId(companyId);
		saisineObservatoireImpl.setUserId(userId);

		if (userName == null) {
			saisineObservatoireImpl.setUserName("");
		}
		else {
			saisineObservatoireImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			saisineObservatoireImpl.setCreateDate(null);
		}
		else {
			saisineObservatoireImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			saisineObservatoireImpl.setModifiedDate(null);
		}
		else {
			saisineObservatoireImpl.setModifiedDate(new Date(modifiedDate));
		}

		saisineObservatoireImpl.setStatus(status);
		saisineObservatoireImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			saisineObservatoireImpl.setStatusByUserName("");
		}
		else {
			saisineObservatoireImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			saisineObservatoireImpl.setStatusDate(null);
		}
		else {
			saisineObservatoireImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			saisineObservatoireImpl.setTitle("");
		}
		else {
			saisineObservatoireImpl.setTitle(title);
		}

		if (description == null) {
			saisineObservatoireImpl.setDescription("");
		}
		else {
			saisineObservatoireImpl.setDescription(description);
		}

		if (placeTextArea == null) {
			saisineObservatoireImpl.setPlaceTextArea("");
		}
		else {
			saisineObservatoireImpl.setPlaceTextArea(placeTextArea);
		}

		if (filesDownload == null) {
			saisineObservatoireImpl.setFilesDownload("");
		}
		else {
			saisineObservatoireImpl.setFilesDownload(filesDownload);
		}

		if (cityResponse == null) {
			saisineObservatoireImpl.setCityResponse("");
		}
		else {
			saisineObservatoireImpl.setCityResponse(cityResponse);
		}

		if (projectTarget == null) {
			saisineObservatoireImpl.setProjectTarget("");
		}
		else {
			saisineObservatoireImpl.setProjectTarget(projectTarget);
		}

		if (otherMechanism == null) {
			saisineObservatoireImpl.setOtherMechanism("");
		}
		else {
			saisineObservatoireImpl.setOtherMechanism(otherMechanism);
		}

		if (collectiveName == null) {
			saisineObservatoireImpl.setCollectiveName("");
		}
		else {
			saisineObservatoireImpl.setCollectiveName(collectiveName);
		}

		if (petitionnaireLastname == null) {
			saisineObservatoireImpl.setPetitionnaireLastname("");
		}
		else {
			saisineObservatoireImpl.setPetitionnaireLastname(
				petitionnaireLastname);
		}

		if (petitionnaireFirstname == null) {
			saisineObservatoireImpl.setPetitionnaireFirstname("");
		}
		else {
			saisineObservatoireImpl.setPetitionnaireFirstname(
				petitionnaireFirstname);
		}

		if (petitionnaireBirthday == Long.MIN_VALUE) {
			saisineObservatoireImpl.setPetitionnaireBirthday(null);
		}
		else {
			saisineObservatoireImpl.setPetitionnaireBirthday(
				new Date(petitionnaireBirthday));
		}

		if (petitionnaireAdresse == null) {
			saisineObservatoireImpl.setPetitionnaireAdresse("");
		}
		else {
			saisineObservatoireImpl.setPetitionnaireAdresse(
				petitionnaireAdresse);
		}

		saisineObservatoireImpl.setPetitionnairePostalCode(
			petitionnairePostalCode);

		if (petitionnaireCity == null) {
			saisineObservatoireImpl.setPetitionnaireCity("");
		}
		else {
			saisineObservatoireImpl.setPetitionnaireCity(petitionnaireCity);
		}

		if (petitionnairePhone == null) {
			saisineObservatoireImpl.setPetitionnairePhone("");
		}
		else {
			saisineObservatoireImpl.setPetitionnairePhone(petitionnairePhone);
		}

		if (petitionnaireEmail == null) {
			saisineObservatoireImpl.setPetitionnaireEmail("");
		}
		else {
			saisineObservatoireImpl.setPetitionnaireEmail(petitionnaireEmail);
		}

		if (videoUrl == null) {
			saisineObservatoireImpl.setVideoUrl("");
		}
		else {
			saisineObservatoireImpl.setVideoUrl(videoUrl);
		}

		if (externalImageURL == null) {
			saisineObservatoireImpl.setExternalImageURL("");
		}
		else {
			saisineObservatoireImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageCopyright == null) {
			saisineObservatoireImpl.setExternalImageCopyright("");
		}
		else {
			saisineObservatoireImpl.setExternalImageCopyright(
				externalImageCopyright);
		}

		saisineObservatoireImpl.setMediaChoice(mediaChoice);

		if (publikId == null) {
			saisineObservatoireImpl.setPublikId("");
		}
		else {
			saisineObservatoireImpl.setPublikId(publikId);
		}

		saisineObservatoireImpl.setImageId(imageId);

		if (filesIds == null) {
			saisineObservatoireImpl.setFilesIds("");
		}
		else {
			saisineObservatoireImpl.setFilesIds(filesIds);
		}

		saisineObservatoireImpl.resetOriginalValues();

		return saisineObservatoireImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		saisineObservatoireId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = (String)objectInput.readObject();
		placeTextArea = objectInput.readUTF();
		filesDownload = objectInput.readUTF();
		cityResponse = (String)objectInput.readObject();
		projectTarget = objectInput.readUTF();
		otherMechanism = objectInput.readUTF();
		collectiveName = objectInput.readUTF();
		petitionnaireLastname = objectInput.readUTF();
		petitionnaireFirstname = objectInput.readUTF();
		petitionnaireBirthday = objectInput.readLong();
		petitionnaireAdresse = objectInput.readUTF();

		petitionnairePostalCode = objectInput.readLong();
		petitionnaireCity = objectInput.readUTF();
		petitionnairePhone = objectInput.readUTF();
		petitionnaireEmail = objectInput.readUTF();
		videoUrl = objectInput.readUTF();
		externalImageURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();

		mediaChoice = objectInput.readBoolean();
		publikId = objectInput.readUTF();

		imageId = objectInput.readLong();
		filesIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(saisineObservatoireId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (placeTextArea == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeTextArea);
		}

		if (filesDownload == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filesDownload);
		}

		if (cityResponse == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(cityResponse);
		}

		if (projectTarget == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(projectTarget);
		}

		if (otherMechanism == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(otherMechanism);
		}

		if (collectiveName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(collectiveName);
		}

		if (petitionnaireLastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnaireLastname);
		}

		if (petitionnaireFirstname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnaireFirstname);
		}

		objectOutput.writeLong(petitionnaireBirthday);

		if (petitionnaireAdresse == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnaireAdresse);
		}

		objectOutput.writeLong(petitionnairePostalCode);

		if (petitionnaireCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnaireCity);
		}

		if (petitionnairePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnairePhone);
		}

		if (petitionnaireEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(petitionnaireEmail);
		}

		if (videoUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videoUrl);
		}

		if (externalImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageURL);
		}

		if (externalImageCopyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageCopyright);
		}

		objectOutput.writeBoolean(mediaChoice);

		if (publikId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikId);
		}

		objectOutput.writeLong(imageId);

		if (filesIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(filesIds);
		}
	}

	public long saisineObservatoireId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String description;
	public String placeTextArea;
	public String filesDownload;
	public String cityResponse;
	public String projectTarget;
	public String otherMechanism;
	public String collectiveName;
	public String petitionnaireLastname;
	public String petitionnaireFirstname;
	public long petitionnaireBirthday;
	public String petitionnaireAdresse;
	public long petitionnairePostalCode;
	public String petitionnaireCity;
	public String petitionnairePhone;
	public String petitionnaireEmail;
	public String videoUrl;
	public String externalImageURL;
	public String externalImageCopyright;
	public boolean mediaChoice;
	public String publikId;
	public long imageId;
	public String filesIds;

}